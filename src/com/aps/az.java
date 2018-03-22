package com.aps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: DiskLruCache */
public final class az {
    final /* synthetic */ ay f13000a;
    private final bb f13001b;
    private final boolean[] f13002c;
    private boolean f13003d;
    private boolean f13004e;

    private az(ay ayVar, bb bbVar) {
        this.f13000a = ayVar;
        this.f13001b = bbVar;
        this.f13002c = bbVar.f13009d ? null : new boolean[ayVar.f12993i];
    }

    public OutputStream m17385a(int i) throws IOException {
        if (i < 0 || i >= this.f13000a.f12993i) {
            throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + this.f13000a.f12993i);
        }
        OutputStream b;
        synchronized (this.f13000a) {
            File b2;
            OutputStream fileOutputStream;
            if (this.f13001b.f13010e != this) {
                throw new IllegalStateException();
            }
            if (!this.f13001b.f13009d) {
                this.f13002c[i] = true;
            }
            b2 = this.f13001b.m17402b(i);
            try {
                fileOutputStream = new FileOutputStream(b2);
            } catch (FileNotFoundException e) {
                this.f13000a.f12987c.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(b2);
                } catch (FileNotFoundException e2) {
                    b = ay.f12985p;
                }
            }
            b = new ba(this, fileOutputStream);
        }
        return b;
    }

    public void m17386a() throws IOException {
        if (this.f13003d) {
            this.f13000a.m17361a(this, false);
            this.f13000a.m17381c(this.f13001b.f13007b);
        } else {
            this.f13000a.m17361a(this, true);
        }
        this.f13004e = true;
    }

    public void m17387b() throws IOException {
        this.f13000a.m17361a(this, false);
    }
}
