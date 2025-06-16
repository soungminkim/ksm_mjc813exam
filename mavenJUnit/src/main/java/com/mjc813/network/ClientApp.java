package com.mjc813.network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
    public void send(String str) throws IOException {
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(this.sck.getOutputStream())
//        );
//        // 통신소켓의 OutputStream (출력용도스트림)을 쓰기버퍼에 연결한다.
//        writer.write(str);  // 문자열을 통신소켓으로 전송한다.
//        writer.flush();     // 전송 flush 한다.
//        writer.close();     // 쓰기버퍼를 닫는다.

        OutputStream os = this.sck.getOutputStream();
        os.write(str.getBytes());   // 통신소켓에 데이터를 전송한다.
        os.flush();
        os.close();
    }
    public static void main(String[] args) {
        System.out.println("Client start");
        try {
            ClientApp ca = new ClientApp();
            ca.init("127.0.0.1", 19999);
            // 입력받은 문자를 서버에 넘겨 주는 코드
            Scanner sc = new Scanner(System.in);
            while (true) {
                String line = sc.nextLine();
                if (line.equals("quit")){
                    ca.send("exit!@#$app");
                    System.out.println("Client 종료");
                    sc.close();
                    break;
                }
                ca.send(line);
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
