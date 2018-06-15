package com.codecool.surmann.webroute;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WebRoute {
    public static enum HTTPMethod {
        GET,
        POST
    }
    String path() default "/";
    HTTPMethod method() default HTTPMethod.GET;

}
