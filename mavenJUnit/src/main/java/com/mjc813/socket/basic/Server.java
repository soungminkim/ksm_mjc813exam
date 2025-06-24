package com.mjc813.socket.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Socket accept(int port) throws IOException {
        this.serverSocket = new ServerSocket();
        this.serverSocket.bind(new InetSocketAddress(port));
        Socket socket = this.serverSocket.accept();
        return socket;
    }

    public void read(Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str = br.readLine();
        System.out.printf("Form Clinet: %s\n", str);
        br.close();
        socket.close();
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }

    public static void main(String[] args) {
        System.out.println("서버 시작");
        Server server = new Server();

        try {
            Socket sck = server.accept(59999);
            server.read(sck);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
