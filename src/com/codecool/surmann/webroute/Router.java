package com.codecool.surmann.webroute;

import com.sun.net.httpserver.HttpExchange;

public class Router {
    private static int counter = 0;

    @WebRoute(path = "/", method = WebRoute.HTTPMethod.GET)
    public static String Homepage(HttpExchange exchange) {

        return "<!doctype html>" +
                "<html lang=\"en\">" +
                "<head><title>Main page</title></head>" +
                "<body><h1>Welcome! " + ++counter +
                "</h1></body>" +
                "</html>";
    }
    @WebRoute(path = "/other", method = WebRoute.HTTPMethod.POST)
    public static String Otherpage(HttpExchange exchange) {

        return "<!doctype html>" +
                "<html lang=\"en\">" +
                "<head><title>Other page</title></head>" +
                "<body><h2>some other page</h2></body>" +
                "</html>";
    }
}
