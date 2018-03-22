package org.simalliance.openmobileapi;

import android.os.RemoteException;
import java.io.IOException;
import org.simalliance.openmobileapi.service.C6665k;
import org.simalliance.openmobileapi.service.C6668n;
import org.simalliance.openmobileapi.service.SmartcardError;

/* compiled from: Reader */
public class C6650b {
    private final String f22886a;
    private final C6651c f22887b;
    private C6665k f22888c;
    private final Object f22889d = new Object();

    C6650b(C6651c c6651c, String str) {
        this.f22886a = str;
        this.f22887b = c6651c;
        this.f22888c = null;
    }

    public String m29943a() {
        return this.f22886a;
    }

    public C6656g m29944b() throws IOException {
        if (this.f22887b == null || !this.f22887b.m29952a()) {
            throw new IllegalStateException("service is not connected");
        }
        C6656g c6656g;
        if (this.f22888c == null) {
            try {
                this.f22888c = this.f22887b.m29951a(this.f22886a);
            } catch (Exception e) {
                throw new IOException("service reader cannot be accessed.");
            }
        }
        synchronized (this.f22889d) {
            SmartcardError smartcardError = new SmartcardError();
            try {
                C6668n c = this.f22888c.mo5546c(smartcardError);
                C6651c.m29949a(smartcardError);
                if (c == null) {
                    throw new IOException("service session is null.");
                }
                c6656g = new C6656g(this.f22887b, c, this);
            } catch (RemoteException e2) {
                throw new IOException(e2.getMessage());
            }
        }
        return c6656g;
    }

    public boolean m29945c() {
        if (this.f22887b == null || !this.f22887b.m29952a()) {
            throw new IllegalStateException("service is not connected");
        }
        if (this.f22888c == null) {
            try {
                this.f22888c = this.f22887b.m29951a(this.f22886a);
            } catch (Exception e) {
                throw new IllegalStateException("service reader cannot be accessed. " + e.getLocalizedMessage());
            }
        }
        SmartcardError smartcardError = new SmartcardError();
        try {
            boolean b = this.f22888c.mo5545b(smartcardError);
            C6651c.m29949a(smartcardError);
            return b;
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }

    public void m29946d() {
        if (this.f22887b == null || !this.f22887b.m29952a()) {
            throw new IllegalStateException("service is not connected");
        } else if (this.f22888c != null) {
            synchronized (this.f22889d) {
                SmartcardError smartcardError = new SmartcardError();
                try {
                    this.f22888c.mo5547d(smartcardError);
                    C6651c.m29949a(smartcardError);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
        }
    }
}
