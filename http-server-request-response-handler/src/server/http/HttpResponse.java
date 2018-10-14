package server.http;

import java.util.HashMap;

public interface HttpResponse {
    HashMap<String, String> getHeaders();

    int getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setStatudCode(int statusCode);

    void setContent(byte[] content);

    void addHeader(String header, String value);
}
