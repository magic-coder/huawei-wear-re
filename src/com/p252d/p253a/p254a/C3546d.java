package com.p252d.p253a.p254a;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.HttpContext;

/* compiled from: AsyncHttpClient */
class C3546d implements HttpRequestInterceptor {
    final /* synthetic */ C3543a f13538a;

    C3546d(C3543a c3543a) {
        this.f13538a = c3543a;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        AuthState authState = (AuthState) httpContext.getAttribute(ClientContext.TARGET_AUTH_STATE);
        CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute(ClientContext.CREDS_PROVIDER);
        HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
        if (authState.getAuthScheme() == null) {
            Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()));
            if (credentials != null) {
                authState.setAuthScheme(new BasicScheme());
                authState.setCredentials(credentials);
            }
        }
    }
}
