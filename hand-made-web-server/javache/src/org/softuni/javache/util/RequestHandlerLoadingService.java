package org.softuni.javache.util;

import org.softuni.javache.api.RequestHandler;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class RequestHandlerLoadingService {
    private Set<RequestHandler> requestHandlers;

    public RequestHandlerLoadingService() { }

    public Set<RequestHandler> getRequestHandlers() {
        return Collections.unmodifiableSet(requestHandlers);
    }

    public void loadRequestHandlers(Set<String> requestHandlerPriority) {
        this.requestHandlers = new LinkedHashSet<>();


    }
}