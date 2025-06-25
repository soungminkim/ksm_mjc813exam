package com.mjc813.studyjava.network;

import com.google.gson.Gson;
import java.io.*;
import java.net.Socket;
import java.util.Set;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final ServerApp server;
    private final BufferedReader in;
    private final PrintWriter out;
    private String name = "무명자";
    private String currentRoom = null;
    private final Gson gson = new Gson();
    private volatile boolean running = true;

    public ClientHandler(Socket socket, ServerApp server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
    }

    @Override
    public void run() {
        try {
            String line;
            while (running && (line = in.readLine()) != null) {
                Command cmd = gson.fromJson(line, Command.class);
                switch (cmd.command) {
                    case "1": // 대화명변경
                        if (cmd.name != null && !cmd.name.trim().isEmpty()) {
                            name = cmd.name.trim();
                            out.println("대화명이 변경되었습니다: " + name);
                        }
                        break;
                    case "2": // 방목록보기
                        StringBuilder sb = new StringBuilder();
                        for (String r : server.getRoomNames()) {
                            Set<ClientHandler> members = server.getRooms().get(r);
                            int count = (members != null) ? members.size() : 0;
                            sb.append(r).append(" (").append(count).append("명)\n ");
                        }
                        out.println(sb.toString().trim());
                        break;
                    case "3": // 방입장
                        if (cmd.room != null && server.joinRoom(cmd.room, this)) {
                            currentRoom = cmd.room;
                            out.println("true");
                            server.broadcastToRoom(currentRoom, "(" + name + ") : 입장 했습니다.", this);
                        } else {
                            out.println("false");
                        }
                        break;
                    case "4":
                        if (cmd.room != null && server.createRoom(cmd.room, this)) {
                            currentRoom = cmd.room;
                            server.broadcastToRoom(currentRoom, "(" + name + ") : 대화방을 생성했습니다.", this);
                            out.println("true");
                        } else {
                            out.println("방 이름이 중복되었거나 잘못되었습니다.");
                        }
                        break;
                    case "7": // 대화
                        if (currentRoom != null && cmd.msg != null) {
                            server.broadcastToRoom(currentRoom, "(" + name + ") : " + cmd.msg, this);
                        }
                        break;
                    case "8": // 방퇴장
                        if (currentRoom != null) {
                            server.leaveRoom(currentRoom, this);
                            server.broadcastToRoom(currentRoom, "(" + name + ") : 퇴장 했습니다.", this);
                            currentRoom = null;
                        }
                        break;
                }
            }
        } catch (IOException ignored) {} finally {
            try { socket.close(); } catch (IOException ignore) {}
            server.getClients().remove(this);
        }
    }

    public void send(String msg) {
        out.println(msg);
    }

    public void shutdown() {
        running = false;
        try { socket.close(); } catch (IOException ignore) {}
    }
}
