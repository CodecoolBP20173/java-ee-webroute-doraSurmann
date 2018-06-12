package com.codecool.surmann.webroute;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestServer {
    @WebRoute(bool = true)
    private static void doTrue() {
        System.out.println("inside the method");
    }

    public static void main(String[] args) throws IOException {
        try {
            Method method = TestServer.class.getDeclaredMethod("doTrue");
            method.invoke(null);
            WebRoute myAnnotation = method.getAnnotation(WebRoute.class);
            System.out.println("annotation string: " + myAnnotation.string());
            System.out.println("annotation bool: " + myAnnotation.bool());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) throws IOException {
        Server server = new Server(8000, TestRouter.class);
        server.start();
    }*/
}


/* public class Test {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}*/