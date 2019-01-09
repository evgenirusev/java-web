package org.rusev.catalina.servlet;

import org.softuni.javache.http.HttpResponse;
import org.softuni.javache.http.HttpResponseImpl;

import java.io.OutputStream;

public class HttpServletResponseImpl extends HttpResponseImpl implements HttpServletResponse {

    private OutputStream outputStream;

    public HttpServletResponseImpl(OutputStream outputStream) {
        super();
        this.setOutputStream(outputStream);
    }

    @Override
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    private void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
