package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {
    private ServerSocket server;
    private Integer port;

    public Server(Integer port) {
        this.port = port;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        this.server.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);

        while(true) {
            try (Socket clientSocket = this.server.accept()) {
                clientSocket.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILLISECONDS);

                StringBuilder sb = new StringBuilder();

                byte[] headers = ("HTTP/1.1 200 OK\r\n" +
                        "Date: Mon, 27 Jul 2009 12:28:53 GMT\r\n" +
                        "Server: Apache/2.2.14 (Win32)\r\n" +
                        "Content-Type: image/gif\r\n" +
                        "\r\n").getBytes();
                sb.append(headers);
                sb.append(Files.readAllBytes(Paths.get("C:\\Users\\Evgeni\\IdeaProjects\\java-web-fundamentals\\http-server-request-response-handler\\src\\server\\hedgehog.jpeg")));

                clientSocket.getOutputStream().write(sb.toString().getBytes());
//                ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket, new RequestHandler());
//
//                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
//                task.run();
                System.out.println();
            } catch (SocketTimeoutException e) {
                System.out.println("Socket Timeout Exception");
            }
        }
    }
}