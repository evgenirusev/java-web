package org.rusev.catalina.servlet;

import org.softuni.javache.http.HttpResponse;

import java.io.OutputStream;

public interface HttpServletResponse extends HttpResponse {
    OutputStream getOutputStream();
}
