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
    private volatile String myRoom = null;
    private volatile String lastRequestedRoom = null;

    public void start(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        new Thread(() -> {
            String msg;
            try {
                while ((msg = in.readLine()) != null) {
                    if ("true".equals(msg)) {
                        myRoom = lastRequestedRoom;
                        System.out.println("방 [" + myRoom + "]에 입장하였습니다. (quit 입력시 퇴장)");
                    } else if ("false".equals(msg)) {
                        System.out.println("방 입장에 실패했습니다.");
                    } else {
                        System.out.println(msg);
                    }
                }
            } catch (IOException ignored) {}
        }).start();

        Scanner sc = new Scanner(System.in);

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
                    lastRequestedRoom = room;
                    out.println(gson.toJson(cmd));
                } else if (input.equals("4")) {
                    System.out.print("생성할 방 이름: ");
                    String room = sc.nextLine().trim();
                    Command cmd = new Command("4");
                    cmd.id = myId;
                    cmd.room = room;
                    lastRequestedRoom = room;
                    out.println(gson.toJson(cmd));
                } else if (input.equals("5")) {
                    Command cmd = new Command("5");
                    cmd.id = myId;
                    out.println(gson.toJson(cmd));
                    socket.close();
                    break;
                }
            } else {
                String msg = sc.nextLine();
                if ("quit".equals(msg)) {
                    Command cmd = new Command("8");
                    cmd.id = myId;
                    cmd.room = myRoom;
                    out.println(gson.toJson(cmd));
                    myRoom = null;
                    lastRequestedRoom = null;
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
        if (args.length <= 0) {
            System.out.println("java.옵션에 가서 ip 주소를 입력해주세요.");
        }else {
            new ClientApp().start(args[0], 19999);
        }
    }
}
