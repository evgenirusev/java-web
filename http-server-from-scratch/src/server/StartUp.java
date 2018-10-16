package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StartUp {
    public static void main(String[] args) throws IOException {
        Server server = new Server(WebConstants.PORT);
        server.run();
    }
}