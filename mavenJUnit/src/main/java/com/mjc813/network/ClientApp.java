package com.mjc813.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientApp {
    private Socket sck = null;
    public ClientApp() {
        this.sck = new Socket();    // 클라이언트소켓 생성
    }
    public void init(String ipAddr, int port) throws IOException {
        SocketAddress sa = new InetSocketAddress(ipAddr, port);
        this.sck.connect(sa);
        // Ip 주소와 포트로 접속한다.
    }
    public static void main(String[] args) {
        System.out.println("Client start");
        try {
            ClientApp ca = new ClientApp();
            ca.init("127.0.0.1", 19999);
            // 입력받은 문자를 서버에 넘겨 주는 코드

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ca.sck.getOutputStream()));

            Scanner sc = new Scanner(System.in);

            while (true) {
                String line = sc.nextLine();
                if (line.equals("quit")){
                    writer.write("exit!@#$app");
                    writer.flush();
                    System.out.println("Client 종료");
                    break;
                }
                writer.write(line + "\n");
                writer.flush();
            }
            writer.close();
            sc.close();
            ca.sck.close();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
