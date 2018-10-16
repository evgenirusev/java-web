package server;

import server.http.HttpRequest;
import server.http.HttpRequestImpl;
import server.http.HttpResponse;
import server.http.HttpStatus;
import server.io.Reader;
import utility.Helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class RequestHandler {
    private static final String PAGES_PATH = "C:\\Users\\Evgeni\\IdeaProjects\\java-web-fundamentals\\http-server-request-response-handler\\src\\resources\\pages\\";
    private static final String HOME_PAGE_NAME = "index.html";
    private static final String ROOT_REQUEST = "/";
    private static final String PAGE_EXTENTION = ".html";
    private static final String RESOURCES_PATH = "C:\\Users\\Evgeni\\IdeaProjects\\java-web-fundamentals\\http-server-request-response-handler\\src\\resources\\assets";
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;
    private static final Map<String, String> CONTENT_TYPES = new HashMap<String, String>() {{
        put("html", "text/html; charset=utf-8");
        put("txt", "text/plain; charset=utf-8");
        put("png", "image/png");
        put("jpg", "image/jpeg");
        put("jpeg", "image/jpeg");
        put("css", "text/css; charset=utf-8");
    }};

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
            return this.processResource(url);
        }

        return this.processPageRequest(url);
    }

    private byte[] processResource(String url) {
        String resourcePath = RESOURCES_PATH + url;
        File resourceFile = new File(resourcePath);

        try {
            this.httpResponse.setContent(Files.readAllBytes(Paths.get(resourceFile.toURI())));
        } catch (IOException e) {
            return this.pageNotFound();
        }

        this.httpResponse.addHeader("Content-Type", CONTENT_TYPES.get(Helpers.getExtension(resourceFile)));
        this.httpResponse.addHeader("Content-Length", this.httpResponse.getContent().length + "");
        this.httpResponse.addHeader("Content-Disposition", "inline");

        this.httpResponse.addHeader("Cache-Control", "public,max-age=604800");
        this.httpResponse.addHeader("Accept-Ranges", "bytes");
        this.httpResponse.addHeader("X-Frame-Options", "deny");

        return this.ok();
    }

    private byte[] processPageRequest(String url) {
        if (ROOT_REQUEST.equals(url)) {
            this.httpRequest.setRequestUrl(HOME_PAGE_NAME);
        }

        String pagePath = PAGES_PATH + url + PAGE_EXTENTION;

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
