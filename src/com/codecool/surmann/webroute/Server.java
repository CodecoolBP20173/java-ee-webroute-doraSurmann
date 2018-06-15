package com.codecool.surmann.webroute;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;


public class Server {
    private static HttpServer server1;

    public static void main(String[] args)  throws IOException {

        server1 = HttpServer.create(new InetSocketAddress(8000), 0);
        createRoutes();
        server1.setExecutor(null);
        server1.start();
        System.out.println("Server started");

    }

    private static void createRoutes() {
        System.out.println("Creating routes");
        for (Method method : Router.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(WebRoute.class)) {
                String path = method.getAnnotation(WebRoute.class).path();
                Server.server1.createContext(path, new Handler(method));
                System.out.println("    route \"" + path + "\" has set up");
            }
        }
        System.out.println("Routes set up finished");
    }
}


