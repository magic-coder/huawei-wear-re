package com.squareup.okhttp.internal.http;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        return str.equals(HttpPost.METHOD_NAME) || str.equals("PATCH") || str.equals(HttpPut.METHOD_NAME) || str.equals("DELETE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals(HttpPost.METHOD_NAME) || str.equals(HttpPut.METHOD_NAME) || str.equals("PATCH");
    }

    public static boolean permitsRequestBody(String str) {
        return requiresRequestBody(str) || str.equals("DELETE");
    }

    private HttpMethod() {
    }
}
