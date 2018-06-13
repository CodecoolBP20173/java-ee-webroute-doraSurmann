package com.codecool.surmann.webroute;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                List<String> params = paramsFromPath(path);
                Server.server1.createContext(path, new Handler(method));
                System.out.println("    route to path \"" + path + "\" set up");
            }
            System.out.println("Server routes successfully set up");
        }
    }
    private static List<String> paramsFromPath(String path) {
        Pattern pattern1 = Pattern.compile("<.*?>");
        Matcher matcher1 = pattern1.matcher(path);
        List<String> params = new ArrayList<>();

        while (matcher1.find()) {
            String param = matcher1.group(0);
            params.add(param.substring(1, param.length() - 1));
        }
        return params;

    }
}


