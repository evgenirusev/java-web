package server;

import java.io.IOException;

public class StartUp {
    public static void main(String[] args) throws IOException {
        Server server = new Server(WebConstants.PORT);
        server.run();
    }
}