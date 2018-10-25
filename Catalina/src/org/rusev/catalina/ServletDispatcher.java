package org.rusev.catalina;

import org.rusev.catalina.servlet.*;
import org.rusev.catalina.util.ApplicationLoadingService;
import org.softuni.javache.api.RequestHandler;
import org.softuni.javache.http.HttpStatus;
import org.softuni.javache.io.Reader;
import org.softuni.javache.io.Writer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ServletDispatcher implements RequestHandler {
    private final String serverRootFolderPath;

    private boolean hasIntercepted;

    private Map<String, HttpServlet> servletMap;

    private ApplicationLoadingService applicationLoadingService;

    public ServletDispatcher(String serverRootFolderPath) {
        this.serverRootFolderPath = serverRootFolderPath;
        this.hasIntercepted = false;
        this.servletMap = new HashMap<>();
        this.applicationLoadingService = new ApplicationLoadingService();
    }

    private void initializeServletMap() {
        try {
            this.servletMap = new HashMap<>();
            this.applicationLoadingService.loadApplications(serverRootFolderPath
                    + "webapps" + File.separator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {
        try {
            this.initializeServletMap();
            HttpServletRequest request = new HttpServletRequestImpl(Reader.readAllLines(inputStream), inputStream);
            HttpServletResponse response = new HttpServletResponseImpl(outputStream);

            String requestUrl = request.getRequestUrl();

            HttpServlet servletObject = null;

            if (this.servletMap.containsKey(requestUrl)) {
                servletObject = this.servletMap.get(requestUrl);
            }

            if (servletObject == null) {
                response.setStatusCode(HttpStatus.NOT_FOUND);
                response.setContent(("Servlet Not Found.").getBytes());
                Writer.writeBytes(response.getBytes(), response.getOutputStream());
            }

            servletObject.service(request, response);


            this.hasIntercepted = true;
        }catch (IOException e) {
            e.printStackTrace();
            this.hasIntercepted = false;
        }
    }

    @Override
    public boolean hasIntercepted() {
        return this.hasIntercepted;
    }
}
