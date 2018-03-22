package com.p230a.p231b.p232b.p233a.p236a;

import com.p230a.p231b.p232b.p233a.C3104c;
import com.p230a.p231b.p232b.p233a.C3121x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

final class C3099m {
    public long f10388a;
    public String f10389b;
    public String f10390c;
    public long f10391d;
    public long f10392e;
    public long f10393f;
    public Map f10394g;

    private C3099m() {
    }

    public C3099m(String str, C3104c c3104c) {
        this.f10389b = str;
        this.f10388a = (long) c3104c.f10410a.length;
        this.f10390c = c3104c.f10411b;
        this.f10391d = c3104c.f10412c;
        this.f10392e = c3104c.f10413d;
        this.f10393f = c3104c.f10414e;
        this.f10394g = c3104c.f10415f;
    }

    public static C3099m m13839a(InputStream inputStream) {
        C3099m c3099m = new C3099m();
        if (C3089c.m13806a(inputStream) != 538051844) {
            throw new IOException();
        }
        c3099m.f10389b = C3089c.m13814c(inputStream);
        c3099m.f10390c = C3089c.m13814c(inputStream);
        if (c3099m.f10390c.equals("")) {
            c3099m.f10390c = null;
        }
        c3099m.f10391d = C3089c.m13813b(inputStream);
        c3099m.f10392e = C3089c.m13813b(inputStream);
        c3099m.f10393f = C3089c.m13813b(inputStream);
        c3099m.f10394g = C3089c.m13816d(inputStream);
        return c3099m;
    }

    public final boolean m13840a(OutputStream outputStream) {
        try {
            C3089c.m13807a(outputStream, 538051844);
            C3089c.m13809a(outputStream, this.f10389b);
            C3089c.m13809a(outputStream, this.f10390c == null ? "" : this.f10390c);
            C3089c.m13808a(outputStream, this.f10391d);
            C3089c.m13808a(outputStream, this.f10392e);
            C3089c.m13808a(outputStream, this.f10393f);
            C3089c.m13811a(this.f10394g, outputStream);
            outputStream.flush();
            return true;
        } catch (IOException e) {
            C3121x.m13907b("%s", e.toString());
            return false;
        }
    }
}
