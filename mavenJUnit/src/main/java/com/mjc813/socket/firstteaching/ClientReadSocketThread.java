package com.mjc813.socket.firstteaching;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientReadSocketThread implements Runnable {
    private BufferedReader br = null;
    public ClientReadSocketThread(BufferedReader br) {
        this.br = br;
    }
    @Override
    public void run() {
        try {
            while (true) {
                String str = this.br.readLine();
                if (str.equals("exit!@#$app")) {
                    this.br.close();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Client Read Socket Error");
        }
        System.exit(0);
    }
}
