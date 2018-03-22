package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.wearable.C0530i;
import java.io.IOException;
import java.io.OutputStream;

public final class dw extends OutputStream {
    private final OutputStream f1053a;
    private volatile di f1054b;

    public dw(OutputStream outputStream) {
        this.f1053a = (OutputStream) C0424f.m649a((Object) outputStream);
    }

    private IOException m2160a(IOException iOException) {
        di diVar = this.f1054b;
        if (diVar == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new C0530i("Channel closed unexpectedly before stream was finished", diVar.f1030a, diVar.f1031b);
    }

    C0540d m2161a() {
        return new dx(this);
    }

    void m2162a(di diVar) {
        this.f1054b = diVar;
    }

    public void close() throws IOException {
        try {
            this.f1053a.close();
        } catch (IOException e) {
            throw m2160a(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.f1053a.flush();
        } catch (IOException e) {
            throw m2160a(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.f1053a.write(i);
        } catch (IOException e) {
            throw m2160a(e);
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.f1053a.write(bArr);
        } catch (IOException e) {
            throw m2160a(e);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.f1053a.write(bArr, i, i2);
        } catch (IOException e) {
            throw m2160a(e);
        }
    }
}
