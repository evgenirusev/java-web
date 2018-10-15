package server;

import server.http.HttpRequest;
import server.http.HttpRequestImpl;
import server.http.HttpResponse;
import server.http.HttpStatus;
import server.io.Reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class RequestHandler {
    private static final String PAGES_PATH = "C:\\Users\\Evgeni\\IdeaProjects\\java-web-fundamentals\\http-server-request-response-handler\\src\\resources\\pages\\";
    private static final String HOME_PAGE_NAME = "index.html";
    private static final String ROOT_REQUEST = "/";
    private static final String PAGE_EXTENTION = ".html";
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    public RequestHandler(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
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
            // TODO return this.processResourceRequest(url);
        }

        return this.processPageRequest(url);
    }

    private byte[] processPageRequest(String url) {
        if (ROOT_REQUEST.equals(url)) {
            this.httpRequest.setRequestUrl(HOME_PAGE_NAME);
        }

        String pagePath = PAGES_PATH + this.httpRequest.getRequestUrl() + PAGE_EXTENTION;

        File page = new File(pagePath);

        if (!page.exists() || page.isDirectory()) {
            return this.pageNotFound();
        }

        try {
            this.httpResponse.setContent(Files.readAllBytes(Paths.get(pagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.httpResponse.addHeader("Content-Type" , "text/html");
        return this.ok();
    }

    private byte[] ok() {
        this.httpResponse.setStatusCode(HttpStatus.OK);
        return this.httpResponse.getBytes();
    }

    private byte[] pageNotFound() {
        this.httpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        return this.httpResponse.getBytes();
    }
}
