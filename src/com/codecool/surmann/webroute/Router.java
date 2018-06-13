package com.codecool.surmann.webroute;

import com.sun.net.httpserver.HttpExchange;

public class Router {

    @WebRoute(path = "/")
    public static String Homepage(HttpExchange exchange) {

        return "<!doctype html>" +
                "<html lang=\"en\">" +
                "<head><title>Main page</title></head>" +
                "<body><h1>Welcome!</h1></body>" +
                "</html>";
    }
}
