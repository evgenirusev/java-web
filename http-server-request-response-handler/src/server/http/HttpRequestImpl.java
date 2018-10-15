package server.http;

import server.WebConstants;

import java.util.Arrays;
import java.util.HashMap;

public class HttpRequestImpl implements HttpRequest {
    private String method;
    private String requestUrl;
    private HashMap<String, String> headers;
    private HashMap<String, String> bodyParameters;

    public HttpRequestImpl(String requestContent) {
        this.headers = new HashMap<>();
        this.bodyParameters = new HashMap<>();
        this.parseRequestContent(requestContent);
    }

    private void parseRequestContent(String requestContent) {
        String[] lines = requestContent.split("\r\n");
        this.parseRequestFirstLine(lines[0]);
        String[] remainingLines = Arrays.stream(lines).skip(1).toArray(String[]::new);
        this.parseRequestHeaders(remainingLines);
        if ((WebConstants.EMPTY_STRING).equals(remainingLines[remainingLines.length - 2])) {
            this.parseBodyParameters(remainingLines[remainingLines.length - 1]);
        }
    }

    private void parseBodyParameters(String remainingLine) {
        String[] keyValuePairs = remainingLine.split("&");
        for (int i = 0; i < keyValuePairs.length; i++) {
            String key = keyValuePairs[i].split("=")[0];
            String value = keyValuePairs[i].split("=")[1];
            this.bodyParameters.put(key, value);
        }
    }

    private void parseRequestHeaders(String[] remainingLines) {
        for (int i = 0; i < remainingLines.length; i++) {
            if (WebConstants.EMPTY_STRING.equals(remainingLines[i])) {
                break;
            }
            String[] headerLine = remainingLines[i].split(": ");
            String header = headerLine[0];
            String headerValue = headerLine[1];
            this.headers.put(header, headerValue);
        }
    }

    private void parseRequestFirstLine(String requestLine) {
        String[] requestLineTokens = requestLine.split("\\s+");
        String method = requestLineTokens[0];
        String url = requestLineTokens[1];
        this.setMethod(method);
        this.setRequestUrl(url);
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return this.bodyParameters;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.put(parameter, value);
    }

    @Override
    public boolean isResource() {
        return requestUrl.contains(".");
    }
}
