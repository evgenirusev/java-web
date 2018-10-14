package server;

import server.http.HttpRequest;
import server.http.HttpRequestImpl;
import server.http.HttpResponse;
import server.http.HttpStatus;

import java.io.File;

public final class RequestHandler {
    private static final String PAGES_PATH = "C:\\Users\\Evgeni\\IdeaProjects\\java-web-fundamentals\\http-server-request-response-handler\\src\\resources\\pages\\";
    private static final String HOME_PAGE_NAME = "index.html";
    private static final String ROOT_REQUEST = "/";
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
        String url = this.httpRequest.getRequestUrl();

        if (this.httpRequest.isResource()) {
            return this.processResourceRequest(url);
        }

        return this.processPageRequest(url);
    }

    private byte[] processPageRequest(String url) {
        if (ROOT_REQUEST.equals(url)) {
            this.httpRequest.setRequestUrl(HOME_PAGE_NAME);
        }

        String pagePath = PAGES_PATH + this.httpRequest.getRequestUrl();

        File page = new File(pagePath);

        if (!page.exists() || page.isDirectory()) {
            return this.pageNotFound();
        }

        this.httpResponse.setStatusCode(HttpStatus.OK);
        // TODO implement the rest of the response headers
    }

    private byte[] pageNotFound() {

    }

    private byte[] processResourceRequest(String url) {
        // TODO
    }
}
