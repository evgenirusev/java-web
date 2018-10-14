package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import server.io.Reader;
import server.io.Writer;

import java.net.Socket;

public class ConnectionHandler extends Thread {
    private Socket clientSocket;
    private InputStream clientSocketInputStream;
    private OutputStream clientSocketOutputStream;
    private RequestHandler requestHandler;

    public ConnectionHandler(Socket clientSocket, RequestHandler requestHandler) {
        this.initializeConnection(clientSocket);
        this.requestHandler = requestHandler;
    }

    private void initializeConnection(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            this.clientSocketInputStream = this.clientSocket.getInputStream();
            this.clientSocketOutputStream = this.clientSocket.getOutputStream();
        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    @Override
    public void run() {
        try {
            String requestContent = Reader.readAllLines(this.clientSocketInputStream);
            byte[] responseContent = this.requestHandler.handleRequest(requestContent);
            Writer.writeBytes(responseContent, this.clientSocketOutputStream);

            this.clientSocketInputStream.close();
            this.clientSocketOutputStream.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public InputStream getClientSocketInputStream() {
        return clientSocketInputStream;
    }

    public void setClientSocketInputStream(InputStream clientSocketInputStream) {
        this.clientSocketInputStream = clientSocketInputStream;
    }

    public OutputStream getClientSocketOutputStream() {
        return clientSocketOutputStream;
    }

    public void setClientSocketOutputStream(OutputStream clientSocketOutputStream) {
        this.clientSocketOutputStream = clientSocketOutputStream;
    }

    public RequestHandler getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
}
