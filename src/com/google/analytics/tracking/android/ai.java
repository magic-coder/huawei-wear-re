package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: GAThread */
class ai extends Thread implements C3647h {
    private static ai f14057g;
    private final LinkedBlockingQueue<Runnable> f14058a = new LinkedBlockingQueue();
    private volatile boolean f14059b = false;
    private volatile boolean f14060c = false;
    private volatile List<Command> f14061d;
    private volatile String f14062e;
    private volatile String f14063f;
    private volatile be f14064h;
    private final Context f14065i;

    static ai m18218a(Context context) {
        if (f14057g == null) {
            f14057g = new ai(context);
        }
        return f14057g;
    }

    private ai(Context context) {
        super("GAThread");
        if (context != null) {
            this.f14065i = context.getApplicationContext();
        } else {
            this.f14065i = context;
        }
        start();
    }

    protected void m18239e() {
        this.f14064h.mo4267f();
        this.f14061d = new ArrayList();
        this.f14061d.add(new Command(Command.APPEND_VERSION, "&_v".substring(1), "ma3.0.2"));
        this.f14061d.add(new Command(Command.APPEND_QUEUE_TIME, "&qt".substring(1), null));
        this.f14061d.add(new Command(Command.APPEND_CACHE_BUSTER, "&z".substring(1), null));
    }

    public void mo4234a(Map<String, String> map) {
        Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m18234a(new aj(this, hashMap));
    }

    private String m18225b(Map<String, String> map) {
        if (map.containsKey("useSecure")) {
            return bj.m18343a((String) map.get("useSecure"), true) ? "https:" : "http:";
        } else {
            return "https:";
        }
    }

    private boolean m18229c(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = bj.m18339a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (m18217a((String) map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get("&t") == null ? "unknown" : (String) map.get("&t");
        ar.m18268c(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    static int m18217a(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private void m18231d(Map<String, String> map) {
        C3649n a = C3657i.m18353a();
        bj.m18342a(map, "&an", a.mo4248a("&an"));
        bj.m18342a(map, "&av", a.mo4248a("&av"));
        bj.m18342a(map, "&aid", a.mo4248a("&aid"));
        bj.m18342a(map, "&aiid", a.mo4248a("&aiid"));
        map.put("&v", "1");
    }

    public void mo4233a() {
        m18234a(new ak(this));
    }

    public void mo4235b() {
        m18234a(new al(this));
    }

    void m18234a(Runnable runnable) {
        this.f14058a.add(runnable);
    }

    static String m18224b(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                ar.m18264a("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                ar.m18269d("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            ar.m18267b("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            ar.m18267b("No campaign data found.");
            return null;
        } catch (IOException e2) {
            ar.m18264a("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private String m18221a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            ar.m18269d("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.f14064h == null) {
                this.f14064h = new C3668z(this.f14065i, this);
            }
            m18239e();
            this.f14063f = C3658j.m18356a().mo4248a("&cid");
            this.f14062e = m18224b(this.f14065i);
        } catch (Throwable th) {
            ar.m18264a("Error initializing the GAThread: " + m18221a(th));
            ar.m18264a("Google Analytics will not start up.");
            this.f14059b = true;
        }
        while (!this.f14060c) {
            try {
                Runnable runnable = (Runnable) this.f14058a.take();
                if (!this.f14059b) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                ar.m18267b(e2.toString());
            } catch (Throwable th2) {
                ar.m18264a("Error on GAThread: " + m18221a(th2));
                ar.m18264a("Google Analytics is shutting down.");
                this.f14059b = true;
            }
        }
    }

    public LinkedBlockingQueue<Runnable> mo4236c() {
        return this.f14058a;
    }

    public Thread mo4237d() {
        return this;
    }
}
