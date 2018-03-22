package com.aps;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: DiskLruCache */
final class bb {
    final /* synthetic */ ay f13006a;
    private final String f13007b;
    private final long[] f13008c;
    private boolean f13009d;
    private az f13010e;
    private long f13011f;

    private bb(ay ayVar, String str) {
        this.f13006a = ayVar;
        this.f13007b = str;
        this.f13008c = new long[ayVar.f12993i];
    }

    public String m17401a() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.f13008c) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    private void m17393a(String[] strArr) throws IOException {
        if (strArr.length != this.f13006a.f12993i) {
            throw m17395b(strArr);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                this.f13008c[i] = Long.parseLong(strArr[i]);
                i++;
            } catch (NumberFormatException e) {
                throw m17395b(strArr);
            }
        }
    }

    private IOException m17395b(String[] strArr) throws IOException {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File m17400a(int i) {
        return new File(this.f13006a.f12987c, this.f13007b + "." + i);
    }

    public File m17402b(int i) {
        return new File(this.f13006a.f12987c, this.f13007b + "." + i + ".tmp");
    }
}
