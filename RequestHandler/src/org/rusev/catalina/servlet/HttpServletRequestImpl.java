package org.rusev.catalina.servlet;

import org.softuni.javache.http.HttpRequestImpl;

import java.io.InputStream;

public class HttpServletRequestImpl extends HttpRequestImpl implements HttpServletRequest {
    private InputStream inputStream;

    public HttpServletRequestImpl(String requestContent, InputStream requestStream) {
        super(requestContent);
        this.setInputStream(inputStream);
    }

    @Override
    public InputStream getInputStream() {
        return this.inputStream;
    }

    private void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
