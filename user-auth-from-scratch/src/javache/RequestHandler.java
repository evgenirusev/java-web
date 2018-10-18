package javache;

import javache.constants.RequestConstants;
import javache.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static javache.constants.RequestConstants.LOGIN_PAGE_STATIC;

public class RequestHandler {
    private static final String HTML_EXTENSION = "html";
    private static final String INDEX_PAGE = "index";
    private static final String INDEX_PAGE_WITH_EXPENTION = "index.html";
    private static final String REGISTER_PAGE = "register";
    private static final String LOGIN_PAGE = "login";
    private static final String DEFAULT_PROFILE_REDIRECT = "users/profile";
    private static final String EMPTY_STRING = "";
    private static final String DOT = ".";

    private HttpRequest httpRequest;

    private HttpResponse httpResponse;

    private HttpSessionStorage sessionStorage;

    public RequestHandler(HttpSessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    public byte[] handleRequest(String requestContent) {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();

        byte[] result = null;

        if(this.httpRequest.getMethod().equals("GET")) {
            result = this.processGetRequest();
        } else if (this.httpRequest.getMethod().equals("POST")) {
            result = this.handlePostRequest();
        }

        this.sessionStorage.refreshSessions();

        return result;
    }

    private byte[] handlePostRequest() {

        return null;
    }

    private byte[] ok(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.Ok);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] badRequest(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.BadRequest);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] notFound(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.NotFound);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] redirect(String location) {
        this.httpResponse.setStatusCode(HttpStatus.SeeOther);
        this.httpResponse.addHeader("Location", location);
        return this.httpResponse.getBytes();
    }

    private byte[] internalServerError(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.InternalServerError);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private String getMimeType(File file) {
        String fileName = file.getName();

        if(fileName.endsWith("css")) {
            return "text/css";
        } else if (fileName.endsWith("html")) {
            return "text/html";
        } else if (fileName.endsWith("jpg") || fileName.endsWith("jpeg")) {
            return "image/jpeg";
        } else if (fileName.endsWith("png")) {
            return "image/png";
        }

        return "text/plain";
    }

    private byte[] processResourceRequest(String url) {

        if (HTML_EXTENSION.equalsIgnoreCase(getFileExtension(url))) {
            if (isUserLogged()) {
                if (INDEX_PAGE.equalsIgnoreCase(url) || REGISTER_PAGE.equalsIgnoreCase(url)
                        || LOGIN_PAGE.equalsIgnoreCase(url)) {
                    return redirect(DEFAULT_PROFILE_REDIRECT);
                }
            } else {
                if (url.toLowerCase().endsWith(RequestConstants.LOGOUT_PAGE) ||
                        url.toLowerCase().endsWith(RequestConstants.USER_HOME_PAGE) ||
                        url.toLowerCase().endsWith(RequestConstants.USER_PROFILE_PAGE) ||
                        url.toLowerCase().endsWith(RequestConstants.LOGOUT_PAGE + DOT + HTML_EXTENSION) ||
                        url.toLowerCase().endsWith(RequestConstants.USER_HOME_PAGE + DOT + HTML_EXTENSION) ||
                        url.toLowerCase().endsWith(RequestConstants.USER_PROFILE_PAGE + DOT + HTML_EXTENSION)) {
                    return this.redirect(LOGIN_PAGE_STATIC);
                }
            }
        }

        String assetPath = WebConstants.ASSETS_FOLDER_PATH + getFileExtension(url) + url;

        File file = new File(assetPath);

        if(!file.exists() || file.isDirectory()) {
            return this.notFound(("Asset not found!").getBytes());
        }

        byte[] result = null;

        try {
            result = Files.readAllBytes(Paths.get(assetPath));
        } catch (IOException e) {
            return this.internalServerError(("Something went wrong!").getBytes());
        }

        this.httpResponse.addHeader("Content-Type", this.getMimeType(file));
        this.httpResponse.addHeader("Content-Length", result.length + "");
        this.httpResponse.addHeader("Content-Disposition", "inline");

        return this.ok(result);
    }

    private byte[] processPageRequest(String url) {

        switch (url) {
            case "/": case "/index":
                return processResourceRequest(INDEX_PAGE_WITH_EXPENTION);
            case "/home":
                if (!isUserLogged()) {
                    return redirect(INDEX_PAGE_WITH_EXPENTION);
                }
                break;
            case "/users/profile":
                if (!isUserLogged()) {
                    return redirect(INDEX_PAGE_WITH_EXPENTION);
                }
                break;
            case "/logout":
                if (!isUserLogged()) {
                    return redirect(LOGIN_PAGE + DOT + HTML_EXTENSION);
                }
                this.
                break;
        }



        if ("/".equals(url) || "/index".equals(url)) {
            return processResourceRequest("/index.html");
        }

        String pagePath = WebConstants.PAGES_FOLDER_PATH + url + DOT + HTML_EXTENSION;

        File file = new File(pagePath);

        if(!file.exists() || file.isDirectory()) {
            return this.notFound(("Page not found!").getBytes());
        }

        byte[] result = null;

        try {
            result = Files.readAllBytes(Paths.get(pagePath));
        } catch (IOException e) {
            return this.internalServerError(("Something went wrong!").getBytes());
        }

        this.httpResponse.addHeader("Content-Type", this.getMimeType(file));

        return this.ok(result);
    }

    private byte[] processGetRequest() {
        String url = this.httpRequest.getRequestUrl();

        if (httpRequest.isResource()) {
            return processResourceRequest(url);
        }

        return processPageRequest(url);
    }

    public boolean isUserLogged() {
        return this.httpRequest.getCookies().containsKey("Javache") && this.sessionStorage.containsId(this.httpRequest.getCookies().get("Javache").getValue());
    }

    private static String getFileExtension(String fileName) {
        final int index = fileName.lastIndexOf(DOT);

        if (index != -1 && index != 0) {
            return fileName.substring(index + 1);
        } else {
            return EMPTY_STRING;
        }
    }

    private byte[] logout() {
        if(!isUserLogged()) {
            return this.redirect("/login");
        }

        String sessionId = this.httpRequest.getCookies().get("Javache").getValue();
        this.sessionStorage.getById(sessionId).invalidate();
        this.httpResponse.addCookie("Javache", "deleted; expires=Thu, 01 Jan 1970 00:00:00 GMT;");

        return this.redirect("index.html");
    }
}
