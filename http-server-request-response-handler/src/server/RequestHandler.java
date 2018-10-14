package server;

import server.http.HttpRequest;
import server.http.HttpRequestImpl;
import server.http.HttpResponse;

public final class RequestHandler {
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    public RequestHandler(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public byte[] handleRequest(String requestContent) {
        this.httpRequest = new HttpRequestImpl(requestContent);

        byte[] result = null;

        if (this.httpRequest.getMethod().equals("GET")) {
            result = this.processGetRequest();
        }

        return result;
    }

    private byte[] processGetRequest() {
        if (this.httpRequest.isResource()) {
            return this.processResourceRequest();
        }
        return this.processPageRequest();
    }

    private byte[] processPageRequest() {
        // TODO
    }

    private byte[] processResourceRequest() {
        // TODO
    }
}
