package org.simalliance.openmobileapi;

import android.os.RemoteException;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import org.simalliance.openmobileapi.service.C6662h;
import org.simalliance.openmobileapi.service.C6668n;
import org.simalliance.openmobileapi.service.SmartcardError;

/* compiled from: Session */
public class C6656g {
    private final Object f22899a = new Object();
    private final C6651c f22900b;
    private final C6650b f22901c;
    private final C6668n f22902d;

    C6656g(C6651c c6651c, C6668n c6668n, C6650b c6650b) {
        this.f22900b = c6651c;
        this.f22901c = c6650b;
        this.f22902d = c6668n;
    }

    public C6650b m29962a() {
        return this.f22901c;
    }

    public void m29964b() {
        if (this.f22900b == null || !this.f22900b.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22902d != null) {
            synchronized (this.f22899a) {
                SmartcardError smartcardError = new SmartcardError();
                try {
                    this.f22902d.mo5551a(smartcardError);
                    C6651c.m29949a(smartcardError);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
        }
    }

    public boolean m29965c() {
        try {
            if (this.f22902d == null) {
                return true;
            }
            return this.f22902d.mo5555c();
        } catch (RemoteException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void m29966d() {
        if (this.f22900b == null || !this.f22900b.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22902d != null) {
            synchronized (this.f22899a) {
                SmartcardError smartcardError = new SmartcardError();
                try {
                    this.f22902d.mo5553b(smartcardError);
                    C6651c.m29949a(smartcardError);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
        }
    }

    public C6649a m29961a(byte[] bArr) throws IOException {
        C6649a c6649a = null;
        if (this.f22900b == null || !this.f22900b.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22902d == null) {
            throw new IllegalStateException("service session is null");
        } else if (m29962a() == null) {
            throw new IllegalStateException("reader must not be null");
        } else {
            synchronized (this.f22899a) {
                SmartcardError smartcardError = new SmartcardError();
                try {
                    C6662h a = this.f22902d.mo5549a(bArr, this.f22900b.m29955d(), smartcardError);
                    if (m29958b(smartcardError)) {
                    } else if ((bArr == null || bArr.length == 0) && !m29957a(smartcardError)) {
                    } else {
                        C6651c.m29949a(smartcardError);
                        smartcardError.clear();
                        boolean c = m29959c(smartcardError);
                        C6651c.m29949a(smartcardError);
                        if (c) {
                        } else {
                            smartcardError.clear();
                            m29960d(smartcardError);
                            C6651c.m29949a(smartcardError);
                            if (a == null) {
                            } else {
                                c6649a = new C6649a(this.f22900b, this, a);
                            }
                        }
                    }
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                } catch (Exception e2) {
                    throw new IOException(e2.getMessage());
                }
            }
            return c6649a;
        }
    }

    public C6649a m29963b(byte[] bArr) throws IOException {
        C6649a c6649a = null;
        if (this.f22900b == null || !this.f22900b.m29952a()) {
            throw new IllegalStateException("service not connected to system");
        } else if (this.f22902d == null) {
            throw new IllegalStateException("service session is null");
        } else if (m29962a() == null) {
            throw new IllegalStateException("reader must not be null");
        } else {
            synchronized (this.f22899a) {
                SmartcardError smartcardError = new SmartcardError();
                try {
                    C6662h b = this.f22902d.mo5552b(bArr, this.f22900b.m29955d(), smartcardError);
                    C6651c.m29949a(smartcardError);
                    smartcardError.clear();
                    boolean c = m29959c(smartcardError);
                    C6651c.m29949a(smartcardError);
                    if (c) {
                    } else {
                        smartcardError.clear();
                        m29960d(smartcardError);
                        C6651c.m29949a(smartcardError);
                        if (b == null) {
                        } else {
                            c6649a = new C6649a(this.f22900b, this, b);
                        }
                    }
                } catch (RemoteException e) {
                    throw new IllegalStateException(e.getMessage());
                } catch (Exception e2) {
                    throw new IOException(e2.getMessage());
                }
            }
            return c6649a;
        }
    }

    private boolean m29957a(SmartcardError smartcardError) {
        Exception createException = smartcardError.createException();
        if (createException != null) {
            String message = createException.getMessage();
            if (message != null && message.contains("default application is not selected")) {
                return false;
            }
        }
        return true;
    }

    private boolean m29958b(SmartcardError smartcardError) {
        Exception createException = smartcardError.createException();
        if (createException != null) {
            String message = createException.getMessage();
            if (message != null && message.contains("basic channel in use")) {
                return true;
            }
        }
        return false;
    }

    private boolean m29959c(SmartcardError smartcardError) {
        Exception createException = smartcardError.createException();
        if (createException != null) {
            if (createException instanceof MissingResourceException) {
                return true;
            }
            String message = createException.getMessage();
            if (message != null && (message.contains("channel in use") || message.contains("open channel failed") || message.contains("out of channels") || message.contains("MANAGE CHANNEL"))) {
                return true;
            }
        }
        return false;
    }

    private void m29960d(SmartcardError smartcardError) throws NoSuchElementException {
        Exception createException = smartcardError.createException();
        if (createException != null && (createException instanceof NoSuchElementException)) {
            throw new NoSuchElementException("Applet with the defined aid does not exist in the SE");
        }
    }
}
