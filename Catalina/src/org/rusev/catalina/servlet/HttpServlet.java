package org.rusev.catalina.servlet;

import java.io.IOException;

public interface HttpServlet {

    void init(ServletConfig servletConfig);

    void service(HttpServletRequest request, HttpServletResponse response) throws IOException;

    ServletConfig getServletConfig();
}