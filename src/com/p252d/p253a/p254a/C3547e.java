package com.p252d.p253a.p254a;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* compiled from: AsyncHttpClient */
class C3547e extends HttpEntityWrapper {
    InputStream f13539a;
    PushbackInputStream f13540b;
    GZIPInputStream f13541c;

    public C3547e(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public InputStream getContent() throws IOException {
        this.f13539a = this.wrappedEntity.getContent();
        this.f13540b = new PushbackInputStream(this.f13539a, 2);
        if (!C3543a.m17804a(this.f13540b)) {
            return this.f13540b;
        }
        this.f13541c = new GZIPInputStream(this.f13540b);
        return this.f13541c;
    }

    public long getContentLength() {
        return this.wrappedEntity == null ? 0 : this.wrappedEntity.getContentLength();
    }

    public void consumeContent() throws IOException {
        C3543a.m17802a(this.f13539a);
        C3543a.m17802a(this.f13540b);
        C3543a.m17802a(this.f13541c);
        super.consumeContent();
    }
}
