package org.rusev.catalina.servlet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServletConfigImpl implements ServletConfig {
    private Map<String, Object> attributes;

    public ServletConfigImpl() {
        this.attributes = new HashMap<>();
    }

    @Override
    public Map<String, Object> allGetAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    @Override
    public Object getAttribute(String name) {
        if (this.attributes.containsKey(name)) {
            return this.attributes.get(name);
        }

        return null;
    }

    @Override
    public void setAttribute(String name, Object attribute) {
        this.attributes.put(name, attribute);
    }

    @Override
    public void deleteAttribute(String name) {
        this.attributes.remove(name);
    }
}
