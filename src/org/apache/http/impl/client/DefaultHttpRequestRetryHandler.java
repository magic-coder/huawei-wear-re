package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

@Immutable
public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
    private final boolean requestSentRetryEnabled;
    private final int retryCount;

    public DefaultHttpRequestRetryHandler(int i, boolean z) {
        this.retryCount = i;
        this.requestSentRetryEnabled = z;
    }

    public DefaultHttpRequestRetryHandler() {
        this(3, false);
    }

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        if (iOException == null) {
            throw new IllegalArgumentException("Exception parameter may not be null");
        } else if (httpContext == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        } else if (i > this.retryCount) {
            return false;
        } else {
            if (iOException instanceof InterruptedIOException) {
                return false;
            }
            if (iOException instanceof UnknownHostException) {
                return false;
            }
            if (iOException instanceof ConnectException) {
                return false;
            }
            if (iOException instanceof SSLException) {
                return false;
            }
            HttpRequest httpRequest = (HttpRequest) httpContext.getAttribute("http.request");
            if (requestIsAborted(httpRequest)) {
                return false;
            }
            if (handleAsIdempotent(httpRequest)) {
                return true;
            }
            Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
            Object obj = (bool == null || !bool.booleanValue()) ? null : 1;
            if (obj == null || this.requestSentRetryEnabled) {
                return true;
            }
            return false;
        }
    }

    public boolean isRequestSentRetryEnabled() {
        return this.requestSentRetryEnabled;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    protected boolean handleAsIdempotent(HttpRequest httpRequest) {
        return !(httpRequest instanceof HttpEntityEnclosingRequest);
    }

    protected boolean requestIsAborted(HttpRequest httpRequest) {
        HttpRequest original;
        if (httpRequest instanceof RequestWrapper) {
            original = ((RequestWrapper) httpRequest).getOriginal();
        } else {
            original = httpRequest;
        }
        return (original instanceof HttpUriRequest) && ((HttpUriRequest) original).isAborted();
    }
}
