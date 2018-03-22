package org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;

@Immutable
public class LaxRedirectStrategy extends DefaultRedirectStrategy {
    private static final String[] REDIRECT_METHODS = new String[]{HttpGet.METHOD_NAME, HttpPost.METHOD_NAME, HttpHead.METHOD_NAME};

    protected boolean isRedirectable(String str) {
        for (String equalsIgnoreCase : REDIRECT_METHODS) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
