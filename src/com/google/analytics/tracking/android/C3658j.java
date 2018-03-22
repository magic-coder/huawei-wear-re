package com.google.analytics.tracking.android;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* compiled from: ClientIdDefaultProvider */
class C3658j implements C3649n {
    private static C3658j f14185a;
    private static final Object f14186b = new Object();
    private final Context f14187c;
    private String f14188d;
    private boolean f14189e = false;
    private final Object f14190f = new Object();

    public static void m18359a(Context context) {
        synchronized (f14186b) {
            if (f14185a == null) {
                f14185a = new C3658j(context);
            }
        }
    }

    public static C3658j m18356a() {
        C3658j c3658j;
        synchronized (f14186b) {
            c3658j = f14185a;
        }
        return c3658j;
    }

    protected C3658j(Context context) {
        this.f14187c = context;
        m18363e();
    }

    public String mo4248a(String str) {
        if ("&cid".equals(str)) {
            return m18362d();
        }
        return null;
    }

    private String m18362d() {
        if (!this.f14189e) {
            synchronized (this.f14190f) {
                if (!this.f14189e) {
                    ar.m18268c("Waiting for clientId to load");
                    do {
                        try {
                            this.f14190f.wait();
                        } catch (InterruptedException e) {
                            ar.m18264a("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.f14189e);
                }
            }
        }
        ar.m18268c("Loaded clientId");
        return this.f14188d;
    }

    private boolean m18361b(String str) {
        try {
            ar.m18268c("Storing clientId.");
            FileOutputStream openFileOutput = this.f14187c.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            ar.m18264a("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            ar.m18264a("Error writing to clientId file.");
            return false;
        }
    }

    protected String m18365b() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        if (m18361b(toLowerCase)) {
            return toLowerCase;
        }
        return "0";
    }

    private void m18363e() {
        new C3659k(this, "client_id_fetcher").start();
    }

    String m18366c() {
        String str = null;
        try {
            FileInputStream openFileInput = this.f14187c.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                ar.m18264a("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.f14187c.deleteFile("gaClientId");
            } else if (read <= 0) {
                ar.m18264a("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.f14187c.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    ar.m18264a("Error reading clientId file, deleting it.");
                    this.f14187c.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            ar.m18264a("Error reading clientId file, deleting it.");
            this.f14187c.deleteFile("gaClientId");
        }
        if (str == null) {
            return m18365b();
        }
        return str;
    }
}
