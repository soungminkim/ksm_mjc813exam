    package com.mjc813.network;

    import java.io.*;
    import java.net.InetSocketAddress;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.net.SocketAddress;

    public class ServerApp {
        private ServerSocket ss = null;

        public ServerApp(int port) throws IOException {
            // this.ss = new ServerSocket(port);   // 포트번호로 서버소켓 생성
            this.ss = new ServerSocket();
            this.ss.bind(new InetSocketAddress(19999)); // 바인드 명령으로 접속받아들일 IP주소대역과 포트번호로 클라이언트 접속을 대기할 수 있다.
        }

        public void init() throws IOException {
            try {
                Socket sck = this.ss.accept();  // 클라이언트접속 기다림, 블로킹상태
                System.out.println(sck.toString()); // 접속되면 이 문장 실행

    //            BufferedReader reader = new BufferedReader(
    //                    new InputStreamReader(sck.getInputStream())
    //            );  // 소켓의 입력을 InputStream 에서 받아서 읽기버퍼로 전달한다.
    //            String str = reader.readLine(); // 읽기버퍼에서 읽는다. 블로킹 상태
    //            System.out.println(str);
    //            reader.close(); // 읽기버퍼닫기

                new Thread(new SocketReader(sck)).start();

            } catch (IOException e) {
                System.err.println(e.getMessage());
                throw e;
            }
        }

        private class SocketReader implements Runnable {
            private final Socket sck;

            public SocketReader(Socket sck) {
                this.sck = sck;
            }
            @Override
            public void run() {
                try (InputStream is = sck.getInputStream()) {
                    byte[] barr = is.readAllBytes();
                    String str = new String(barr);
                    System.out.println(str);
                } catch (IOException e) {
                    System.err.println("입력 처리 중 오류: " + e.getMessage());
                }
            }
        }

        public static void main(String[] args) throws IOException {
            System.out.println("Server start");
            ServerApp sa = new ServerApp(19999);
            sa.init();
        }
    }
