package com.mjc813.studyjava.network;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ServerApp {
    private ServerSocket ss; // 서버 소켓
    private final Map<String, Set<ClientHandler>> chatRooms = new ConcurrentHashMap<>(); // 방 이름 → 참여자 목록
    private final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet(); // 전체 클라이언트 목록

    public ServerApp(int port) throws IOException {
        this.ss = new ServerSocket();
        this.ss.bind(new InetSocketAddress(port));
    }

    public void init() throws IOException {
        System.out.println("서버 시작됨");
        while (true) {
            Socket sck = ss.accept();
            ClientHandler handler = new ClientHandler(sck);
            clients.add(handler);
            new Thread(handler).start();
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;
        private String nickname = "무명자";
        private String currentRoom = null;
        private BufferedReader reader;
        private BufferedWriter writer;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":", 3);
                    String cmd = parts[0];
                    switch (cmd) {
                        case "1": nickname = parts[1]; break; // 닉네임 변경
                        case "2": writer.write(String.join("\n", chatRooms.keySet()) + "\n"); writer.flush(); break; // 방 목록 요청
                        case "3": joinRoom(parts[1]); break; // 방 입장
                        case "4": createRoom(parts[1]); break; // 방 생성
                        case "5": shutdown(); return; // 종료
                        case "7": sendMessageToRoom(parts[1], "(" + nickname + ") : " + parts[2]); break; // 채팅 메시지 전송
                        case "8": leaveRoom(parts[1]); break; // 방 퇴장
                    }
                }
            } catch (IOException e) {
                System.err.println("클라이언트 처리 오류: " + e.getMessage());
            } finally {
                shutdown();
            }
        }

        private void joinRoom(String roomName) throws IOException {
            if (!chatRooms.containsKey(roomName)) {
                writer.write("없는 방입니다.\n"); writer.flush();
                return;
            }
            leaveRoom(currentRoom);
            currentRoom = roomName;
            chatRooms.get(roomName).add(this);
            writer.write("[" + roomName + "] 입장 완료. quit 입력시 퇴장합니다.\n");
            writer.flush();
            sendMessageToRoom(roomName, "(" + nickname + ") : 입장 했습니다.");
        }

        private void createRoom(String roomName) throws IOException {
            if (chatRooms.containsKey(roomName)) {
                writer.write("이미 존재하는 방입니다.\n"); writer.flush();
                return;
            }
            chatRooms.put(roomName, ConcurrentHashMap.newKeySet());
            joinRoom(roomName);
            writer.write("[" + roomName + "] 대화방을 생성했습니다.\n"); writer.flush();
            sendMessageToRoom(roomName, "(" + nickname + ") : 대화방을 생성했습니다.");
        }

        private void leaveRoom(String roomName) {
            if (roomName == null) return;
            Set<ClientHandler> members = chatRooms.get(roomName);
            if (members != null) {
                members.remove(this);
                sendMessageToRoom(roomName, "(" + nickname + ") : 퇴장 했습니다.");
            }
        }

        private void sendMessageToRoom(String roomName, String msg) {
            Set<ClientHandler> members = chatRooms.get(roomName);
            if (members != null) {
                for (ClientHandler ch : members) {
                    try {
                        ch.writer.write(msg + "\n");
                        ch.writer.flush();
                    } catch (IOException ignored) {}
                }
            }
        }

        private void shutdown() {
            leaveRoom(currentRoom);
            clients.remove(this);
            try { socket.close(); } catch (IOException ignored) {}
        }
    }

    public static void main(String[] args) throws IOException {
        ServerApp server = new ServerApp(19999);
        server.init();
    }
}