package com.codecool.surmann.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Handler implements HttpHandler {
   Method method;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response;

        try {
            response = (String) method.invoke(null, (HttpExchange) exchange);
            exchange.sendResponseHeaders(200, response.length());
        } catch (IllegalAccessException | InvocationTargetException | IOException | IllegalArgumentException e) {
            response = "500 Internal Server error:\n\n" + e.getMessage();
            exchange.sendResponseHeaders(500, response.length());
        }
        try (OutputStream stream = exchange.getResponseBody()) {
            stream.write(response.getBytes());
        }

    }

    Handler(Method method) {
        this.method = method;
    }
}

