package org.rusev.catalina.servlet;


public @interface WebServlet {
    String route() default "";

    boolean loadOnStartUp() default true;
}
