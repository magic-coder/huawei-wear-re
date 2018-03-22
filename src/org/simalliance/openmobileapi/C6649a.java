package org.simalliance.openmobileapi;

import android.os.RemoteException;
import java.io.IOException;
import org.simalliance.openmobileapi.service.C6662h;
import org.simalliance.openmobileapi.service.SmartcardError;

/* compiled from: Channel */
public class C6649a {
    private C6656g f22882a;
    private final C6662h f22883b;
    private final C6651c f22884c;
    private final Object f22885d = new Object();

    C6649a(C6651c c6651c, C6656g c6656g, C6662h c6662h) {
        this.f22884c = c6651c;
        this.f22882a = c6656g;
        this.f22883b = c6662h;
    }

    public void m29939a() {
        if (this.f22884c == null || !this.f22884c.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22883b == null) {
            throw new IllegalStateException("channel must not be null");
        } else if (!m29941b()) {
            synchronized (this.f22885d) {
                SmartcardError smartcardError = new SmartcardError();
                try {
                    this.f22883b.mo5537a(smartcardError);
                    C6651c.m29949a(smartcardError);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
        }
    }

    public boolean m29941b() {
        if (this.f22884c == null || !this.f22884c.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22883b == null) {
            throw new IllegalStateException("channel must not be null");
        } else {
            try {
                return this.f22883b.mo5538a();
            } catch (RemoteException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }

    public byte[] m29940a(byte[] bArr) throws IOException {
        if (this.f22884c == null || !this.f22884c.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22883b == null) {
            throw new IllegalStateException("channel must not be null");
        } else {
            byte[] a;
            synchronized (this.f22885d) {
                SmartcardError smartcardError = new SmartcardError();
                try {
                    a = this.f22883b.mo5539a(bArr, smartcardError);
                    C6651c.m29949a(smartcardError);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                } catch (Exception e2) {
                    throw new IOException(e2.getMessage());
                }
            }
            return a;
        }
    }

    public byte[] m29942c() {
        if (this.f22884c == null || !this.f22884c.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22883b == null) {
            throw new IllegalStateException("channel must not be null");
        } else {
            try {
                if (this.f22883b.mo5538a()) {
                    throw new IllegalStateException("channel is closed");
                }
                try {
                    byte[] c = this.f22883b.mo5542c();
                    if (c == null || c.length != 0) {
                        return c;
                    }
                    return null;
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            } catch (RemoteException e2) {
                throw new IllegalStateException(e2.getMessage());
            }
        }
    }
}
