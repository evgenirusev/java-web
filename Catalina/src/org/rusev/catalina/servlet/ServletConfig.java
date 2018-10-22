package org.rusev.catalina.servlet;

import java.util.HashMap;

public interface ServletConfig {
    HashMap<String, Object> allGetAttributes();

    Object getAttribute(String name);

    void setAttribute(String name, Object attribute);

    void deleteAttribute(String name);
}