package org.rusev.catalina.servlet;

import java.io.IOException;

public interface HttpServlet {

    void init(ServletConfig servletConfig);

    boolean isInitialized();

    ServletConfig getServletConfig();

    void service(HttpServletRequest request, HttpServletResponse response) throws IOException;
}