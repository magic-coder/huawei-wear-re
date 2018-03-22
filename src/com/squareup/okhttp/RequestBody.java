package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.Okio;

public abstract class RequestBody {

    final class C26221 extends RequestBody {
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ MediaType val$contentType;

        C26221(MediaType mediaType, byte[] bArr) {
            this.val$contentType = mediaType;
            this.val$content = bArr;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return (long) this.val$content.length;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.write(this.val$content);
        }
    }

    final class C26232 extends RequestBody {
        final /* synthetic */ MediaType val$contentType;
        final /* synthetic */ File val$file;

        C26232(MediaType mediaType, File file) {
            this.val$contentType = mediaType;
            this.val$file = file;
        }

        public MediaType contentType() {
            return this.val$contentType;
        }

        public long contentLength() {
            return this.val$file.length();
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Closeable closeable = null;
            try {
                closeable = Okio.source(this.val$file);
                bufferedSink.writeAll(closeable);
            } finally {
                Util.closeQuietly(closeable);
            }
        }
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public long contentLength() throws IOException {
        return -1;
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            charset = mediaType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        if (bArr != null) {
            return new C26221(mediaType, bArr);
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(MediaType mediaType, File file) {
        if (file != null) {
            return new C26232(mediaType, file);
        }
        throw new NullPointerException("content == null");
    }
}
