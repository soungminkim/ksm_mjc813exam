package com.mjc813.socket.firstteaching;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientAPP {
    private Socket socket = null;

    private BufferedWriter bw = null;
    public ClientAPP() { this.socket = new Socket(); }

    public void init(String ipAddr, int port)throws IOException {
        SocketAddress addr = new InetSocketAddress(ipAddr, port);
        this.socket.connect(addr);
        this.bw = new BufferedWriter(
                new OutputStreamWriter(this.socket.getOutputStream())
        );
        BufferedReader br = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream())
        );
        Thread readSockeThread = new Thread(new ClientReadSocketThread(br));
        readSockeThread.start();
    }

    public void send(String str) throws IOException {
        this.bw.write(str);
        this.bw.newLine();
        this.bw.flush();
    }

    public void close() throws IOException {
        this.bw.close();
        this.socket.close();
    }

    public static void main (String[] args) {
        System.out.println("클라이언트 실행");
        Scanner sc = new Scanner(System.in);
        ClientAPP ca = new ClientAPP();

        try {
            ca.init("127.0.0.1", 19999);
            ca.send("한글되나요?");
            while (true) {
                String str = sc.nextLine();
                if ("quit".equals(str)) {
                    ca.send("exit!@#$app");
                    break;
                }
                ca.send(str);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                ca.close();
            } catch (IOException e) {}
        }
    }
}
