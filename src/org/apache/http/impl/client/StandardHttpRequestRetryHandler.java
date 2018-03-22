package org.apache.http.impl.client;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;

@Immutable
public class StandardHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {
    private final Map<String, Boolean> idempotentMethods;

    public StandardHttpRequestRetryHandler(int i, boolean z) {
        super(i, z);
        this.idempotentMethods = new ConcurrentHashMap();
        this.idempotentMethods.put(HttpGet.METHOD_NAME, Boolean.TRUE);
        this.idempotentMethods.put(HttpHead.METHOD_NAME, Boolean.TRUE);
        this.idempotentMethods.put(HttpPut.METHOD_NAME, Boolean.TRUE);
        this.idempotentMethods.put("DELETE", Boolean.TRUE);
        this.idempotentMethods.put(HttpOptions.METHOD_NAME, Boolean.TRUE);
        this.idempotentMethods.put(HttpTrace.METHOD_NAME, Boolean.TRUE);
    }

    public StandardHttpRequestRetryHandler() {
        this(3, false);
    }

    protected boolean handleAsIdempotent(HttpRequest httpRequest) {
        Boolean bool = (Boolean) this.idempotentMethods.get(httpRequest.getRequestLine().getMethod().toUpperCase(Locale.US));
        return bool != null && bool.booleanValue();
    }
}
