package server.http;

import java.util.HashMap;

public class HttpResponseImpl implements HttpResponse {
    @Override
    public HashMap<String, String> getHeaders() {
        return null;
    }

    @Override
    public int getStatusCode() {
        return 0;
    }

    @Override
    public byte[] getContent() {
        return new byte[0];
    }

    @Override
    public byte[] getBytes() {
        return new byte[0];
    }

    @Override
    public void setStatudCode(int statusCode) {

    }

    @Override
    public void setContent(byte[] content) {

    }

    @Override
    public void addHeader(String header, String value) {

    }
}
