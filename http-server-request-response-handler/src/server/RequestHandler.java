package server;

import server.http.HttpRequest;
import server.http.HttpRequestImpl;

public class RequestHandler {
    public byte[] handleRequest(String requestContent) {
        HttpRequest httpRequest = new HttpRequestImpl(requestContent);

        return null;
    }
}
