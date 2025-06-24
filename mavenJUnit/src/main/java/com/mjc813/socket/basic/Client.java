package com.mjc813.socket.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    private Socket sock = new Socket();

    public void connect(String ip, int port) throws IOException {
        sock.connect(new InetSocketAddress(ip, port));
    }

    public void send(String str) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(this.sock.getOutputStream()));
        bw.write(str);
        bw.flush();
        bw.close();
    }

    public void close() throws IOException {
        this.sock.close();
    }

    public static void main(String[] args){
        System.out.println("클라어인트 실행");
        Client client = new Client();
        try {
            client.connect("127.0.0.1", 59999);
            client.send(String.format("Client[%s] %s"
            , InetAddress.getLocalHost()
            , "잘접속했다."));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
