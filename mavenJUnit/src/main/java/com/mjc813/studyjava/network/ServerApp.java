package com.mjc813.studyjava.network;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;


@Getter
@Setter
public class ServerApp {
    private final ServerSocket serverSocket;
    private final Map<String, Set<ClientHandler>> rooms = new ConcurrentHashMap<>();
    private final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();
    private volatile boolean running = true;

    public ServerApp(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("서버 시작");
        try {
            while (running) {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket, this);
                clients.add(handler);
                new Thread(handler).start();
            }
        } finally {
            shutdown();
        }
    }

    public void shutdown() throws IOException {
        running = false;
        for (ClientHandler c : clients) {
            c.shutdown();
        }
        serverSocket.close();
        System.out.println("서버 종료");
    }

    // 방 목록
    public Set<String> getRoomNames() {
        return rooms.keySet();
    }

    // 방 입장
    public synchronized boolean joinRoom(String room, ClientHandler client) {
        Set<ClientHandler> members = rooms.get(room);
        if (members == null) return false;
        members.add(client);
        return true;
    }

    // 방 생성
    public synchronized boolean createRoom(String room, ClientHandler client) {
        if (rooms.containsKey(room)) return false;
        rooms.put(room, ConcurrentHashMap.newKeySet());
        rooms.get(room).add(client);
        return true;
    }

    // 방 퇴장
    public synchronized void leaveRoom(String room, ClientHandler client) {
        Set<ClientHandler> members = rooms.get(room);
        if (members != null) members.remove(client);
    }

    // 방 전체 메시지
    public void broadcastToRoom(String room, String message) {
        Set<ClientHandler> members = rooms.get(room);
        if (members != null) {
            for (ClientHandler c : members) {
                c.send(message);
            }
        }
    }

    // 전체 클라이언트에 메시지
    public void broadcastToAll(String message) {
        for (ClientHandler c : clients) {
            c.send(message);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerApp server = new ServerApp(19999);
        server.start();
    }
}
