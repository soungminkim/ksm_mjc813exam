package com.mjc813.studyjava.network;

import com.google.gson.Gson;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private final Gson gson = new Gson();
    private String myId = null;

    public void start(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        // 서버 메시지 수신 스레드 ONLY! (readLine을 한 번만 사용!)
        new Thread(() -> {
            String msg;
            try {
                while ((msg = in.readLine()) != null) {
                    System.out.println(msg); // 서버에서 온 모든 메시지(입장 성공/실패, 채팅, 시스템메시지 등)
                }
            } catch (IOException ignored) {}
        }).start();

        Scanner sc = new Scanner(System.in);
        String myRoom = null;

        // 아이디 설정 (한 번만)
        System.out.print("아이디를 입력하세요: ");
        myId = sc.nextLine().trim();

        while (true) {
            if (myRoom == null) {
                System.out.println("======================================================");
                System.out.println("1.대화명변경, 2.방목록보기, 3.방입장, 4.방만들기, 5.종료");
                System.out.println("======================================================");
                String input = sc.nextLine().trim();

                if (input.equals("1")) {
                    System.out.print("변경할 대화명: ");
                    String name = sc.nextLine().trim();
                    Command cmd = new Command("1");
                    cmd.id = myId;
                    cmd.name = name;
                    out.println(gson.toJson(cmd));
                } else if (input.equals("2")) {
                    Command cmd = new Command("2");
                    cmd.id = myId;
                    out.println(gson.toJson(cmd));
                } else if (input.equals("3")) {
                    System.out.print("입장할 방 이름: ");
                    String room = sc.nextLine().trim();
                    Command cmd = new Command("3");
                    cmd.id = myId;
                    cmd.room = room;
                    out.println(gson.toJson(cmd));
                } else if (input.equals("4")) {
                    System.out.print("생성할 방 이름: ");
                    String room = sc.nextLine().trim();
                    Command cmd = new Command("4");
                    cmd.id = myId;
                    cmd.room = room;
                    out.println(gson.toJson(cmd));
                    myRoom = room;
                } else if (input.equals("5")) {
                    Command cmd = new Command("5");
                    cmd.id = myId;
                    out.println(gson.toJson(cmd));
                    socket.close();
                    break;
                }
            } else {
                // 방에 들어간 경우
                String msg = sc.nextLine();
                if ("quit".equals(msg)) {
                    Command cmd = new Command("8");
                    cmd.id = myId;
                    cmd.room = myRoom;
                    out.println(gson.toJson(cmd));
                    myRoom = null;
                } else {
                    Command cmd = new Command("7");
                    cmd.id = myId;
                    cmd.room = myRoom;
                    cmd.msg = msg;
                    out.println(gson.toJson(cmd));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ClientApp().start("127.0.0.1", 19999);
    }
}
