package com.squareup.okhttp;

import com.sina.weibo.sdk.component.GameManager;
import com.squareup.okhttp.internal.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.client.utils.URLEncodedUtils;

public final class FormEncodingBuilder {
    private static final MediaType CONTENT_TYPE = MediaType.parse(URLEncodedUtils.CONTENT_TYPE);
    private final StringBuilder content = new StringBuilder();

    public FormEncodingBuilder add(String str, String str2) {
        if (this.content.length() > 0) {
            this.content.append('&');
        }
        try {
            this.content.append(URLEncoder.encode(str, GameManager.DEFAULT_CHARSET)).append('=').append(URLEncoder.encode(str2, GameManager.DEFAULT_CHARSET));
            return this;
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public RequestBody build() {
        if (this.content.length() == 0) {
            throw new IllegalStateException("Form encoded body must have at least one part.");
        }
        return RequestBody.create(CONTENT_TYPE, this.content.toString().getBytes(Util.UTF_8));
    }
}
