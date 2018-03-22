package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpMethod;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

public final class Request {
    private final RequestBody body;
    private volatile CacheControl cacheControl;
    private final Headers headers;
    private final String method;
    private final Object tag;
    private volatile URI uri;
    private volatile URL url;
    private final String urlString;

    public class Builder {
        private RequestBody body;
        private com.squareup.okhttp.Headers.Builder headers;
        private String method;
        private Object tag;
        private URL url;
        private String urlString;

        public Builder() {
            this.method = HttpGet.METHOD_NAME;
            this.headers = new com.squareup.okhttp.Headers.Builder();
        }

        private Builder(Request request) {
            this.urlString = request.urlString;
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tag = request.tag;
            this.headers = request.headers.newBuilder();
        }

        public Builder url(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.urlString = str;
            return this;
        }

        public Builder url(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.url = url;
            this.urlString = url.toString();
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.isEmpty()) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", cacheControl2);
        }

        public Builder get() {
            return method(HttpGet.METHOD_NAME, null);
        }

        public Builder head() {
            return method(HttpHead.METHOD_NAME, null);
        }

        public Builder post(RequestBody requestBody) {
            return method(HttpPost.METHOD_NAME, requestBody);
        }

        public Builder delete() {
            return method("DELETE", null);
        }

        public Builder put(RequestBody requestBody) {
            return method(HttpPut.METHOD_NAME, requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (requestBody == null || HttpMethod.permitsRequestBody(str)) {
                if (requestBody == null && HttpMethod.permitsRequestBody(str)) {
                    requestBody = RequestBody.create(null, Util.EMPTY_BYTE_ARRAY);
                }
                this.method = str;
                this.body = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Request build() {
            if (this.urlString != null) {
                return new Request();
            }
            throw new IllegalStateException("url == null");
        }
    }

    private Request(Builder builder) {
        Object access$400;
        this.urlString = builder.urlString;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        if (builder.tag != null) {
            access$400 = builder.tag;
        } else {
            Request request = this;
        }
        this.tag = access$400;
        this.url = builder.url;
    }

    public URL url() {
        try {
            URL url = this.url;
            if (url == null) {
                url = new URL(this.urlString);
                this.url = url;
            }
            return url;
        } catch (Throwable e) {
            throw new RuntimeException("Malformed URL: " + this.urlString, e);
        }
    }

    public URI uri() throws IOException {
        try {
            URI uri = this.uri;
            if (uri == null) {
                uri = Platform.get().toUriLenient(url());
                this.uri = uri;
            }
            return uri;
        } catch (URISyntaxException e) {
            throw new IOException(e.getMessage());
        }
    }

    public String urlString() {
        return this.urlString;
    }

    public String method() {
        return this.method;
    }

    public Headers headers() {
        return this.headers;
    }

    public String header(String str) {
        return this.headers.get(str);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public RequestBody body() {
        return this.body;
    }

    public Object tag() {
        return this.tag;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        cacheControl = CacheControl.parse(this.headers);
        this.cacheControl = cacheControl;
        return cacheControl;
    }

    public boolean isHttps() {
        return url().getProtocol().equals("https");
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.urlString + ", tag=" + (this.tag != this ? this.tag : null) + '}';
    }
}
