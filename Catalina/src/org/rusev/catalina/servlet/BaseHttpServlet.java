package org.rusev.catalina.servlet;

import org.softuni.javache.http.HttpStatus;
import org.softuni.javache.io.Writer;

import java.io.IOException;

public abstract class BaseHttpServlet implements HttpServlet {
    private ServletConfig servletConfig;
    private boolean isInitialized;

    protected BaseHttpServlet() {
        this.isInitialized = false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.configureNotFound(request, response);

        response.setContent(("[ERROR] GET " + request.getRequestUrl()
                + "[MESSAGE] The page you are looking for is not found").getBytes());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        this.configureNotFound(request, response);

        response.setContent(("[ERROR] POST " + request.getRequestUrl()
                + "[MESSAGE] The page you are looking for is not found").getBytes());
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        this.configureNotFound(request, response);

        response.setContent(("[ERROR] PUT " + request.getRequestUrl()
                + "[MESSAGE] The page you are looking for is not found").getBytes());
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        this.configureNotFound(request, response);

        response.setContent(("[ERROR] DELETE " + request.getRequestUrl()
                + "[MESSAGE] The page you are looking for is not found").getBytes());
    }


    private void configureNotFound(HttpServletRequest request, HttpServletResponse response) {
        response.setStatusCode(HttpStatus.NOT_FOUND);

        response.addHeader("Content-Type", "text/html");
    }

    @Override
    public void init(ServletConfig servletConfig) {
        this.isInitialized = true;
        this.servletConfig = servletConfig;
    }

    @Override
    public boolean isInitialized() {
        return this.isInitialized;
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getMethod().equals("GET")) {
            this.doGet(request, response);
        } else if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equals("PUT")) {
            this.doPut(request, response);
        } else if (request.getMethod().equals("DELETE")) {
            this.doDelete(request, response);
        }

        Writer.writeBytes(response.getBytes(), response.getOutputStream());
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
}
