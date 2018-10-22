package org.rusev.catalina.servlet;

import java.util.Map;

public interface ServletConfig {
    Map<String, Object> allGetAttributes();

    Object getAttribute(String name);

    void setAttribute(String name, Object attribute);

    void deleteAttribute(String name);
}