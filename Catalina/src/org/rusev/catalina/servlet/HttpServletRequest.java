package org.rusev.catalina.servlet;

import org.softuni.javache.http.HttpRequest;

import java.io.InputStream;

public interface HttpServletRequest extends HttpRequest {
    InputStream getInputStream();
}
