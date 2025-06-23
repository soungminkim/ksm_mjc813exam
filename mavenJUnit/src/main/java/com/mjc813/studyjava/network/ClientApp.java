package com.mjc813.studyjava.network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientApp {
    private Socket sck = null;

    public ClientApp() {
        this.sck = new Socket();
    }

    public void init(String ipAddr, int port) throws IOException {
        sck.connect(new InetSocketAddress(ipAddr, port));
    }

    public static void main(String[] args) {
        System.out.println("Client Start");
        try {
            ClientApp ca = new ClientApp();
            ca.init("127.0.0.1", 19999);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ca.sck.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(ca.sck.getInputStream()));
            Scanner sc = new Scanner(System.in);

            // 서버로부터 수신된 메시지를 출력하는 스레드
            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException ignored) {}
            }).start();

            // 사용자 입력을 처리하고 서버에 전송
            while (true) {
                System.out.println("============================");
                System.out.println("1.대화명변경, 2.방목록보기");
                System.out.println("3.방입장, 4.방만들기, 5.종료");
                System.out.println("============================");
                String cmd = sc.nextLine();

                switch (cmd) {
                    case "1" -> {
                        System.out.print("대화명: ");
                        String name = sc.nextLine();
                        writer.write("1:" + name + "\n");
                        writer.flush();
                    }
                    case "2" -> {
                        writer.write("2\n");
                        writer.flush();
                    }
                    case "3" -> {
                        System.out.print("입장할 방 이름: ");
                        String room = sc.nextLine();
                        writer.write("3:" + room + "\n");
                        writer.flush();
                        // 대화 모드 시작
                        while (true) {
                            System.out.print(">> ");
                            String msg = sc.nextLine();
                            if (msg.equals("quit")) {
                                writer.write("8:" + room + "\n");
                                writer.flush();
                                break;
                            }
                            writer.write("7:" + room + ":" + msg + "\n");
                            writer.flush();
                        }
                    }
                    case "4" -> {
                        System.out.print("만들 방 이름: ");
                        String room = sc.nextLine();
                        writer.write("4:" + room + "\n");
                        writer.flush();
                        // 대화 모드 시작
                        while (true) {
                            System.out.print(">> ");
                            String msg = sc.nextLine();
                            if (msg.equals("quit")) {
                                writer.write("8:" + room + "\n");
                                writer.flush();
                                break;
                            }
                            writer.write("7:" + room + ":" + msg + "\n");
                            writer.flush();
                        }
                    }
                    case "5" -> {
                        writer.write("5\n");
                        writer.flush();
                        ca.sck.close();
                        return;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
