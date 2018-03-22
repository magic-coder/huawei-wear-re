package com.tencent.map.p535b;

import android.telephony.TelephonyManager;
import java.util.regex.Pattern;

final class C6321m extends Thread {
    private C6320l f22025a = null;
    private C6318j f22026b = null;
    private C6323o f22027c = null;
    private /* synthetic */ C6313f f22028d;

    C6321m(C6313f c6313f, C6320l c6320l, C6318j c6318j, C6323o c6323o) {
        this.f22028d = c6313f;
        if (c6320l != null) {
            this.f22025a = (C6320l) c6320l.clone();
        }
        if (c6318j != null) {
            this.f22026b = (C6318j) c6318j.clone();
        }
        if (c6323o != null) {
            this.f22027c = (C6323o) c6323o.clone();
        }
    }

    public final void run() {
        if (!C6313f.f21961r) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.f22028d.f21974b.getSystemService("phone");
                this.f22028d.f21965C = telephonyManager.getDeviceId();
                this.f22028d.f21966D = telephonyManager.getSubscriberId();
                this.f22028d.f21967E = telephonyManager.getLine1Number();
                Pattern compile = Pattern.compile("[0-9a-zA-Z+-]*");
                this.f22028d.f21965C = this.f22028d.f21965C == null ? "" : this.f22028d.f21965C;
                if (compile.matcher(this.f22028d.f21965C).matches()) {
                    this.f22028d.f21965C = this.f22028d.f21965C == null ? "" : this.f22028d.f21965C;
                } else {
                    this.f22028d.f21965C = "";
                }
                this.f22028d.f21966D = this.f22028d.f21966D == null ? "" : this.f22028d.f21966D;
                if (compile.matcher(this.f22028d.f21966D).matches()) {
                    this.f22028d.f21966D = this.f22028d.f21966D == null ? "" : this.f22028d.f21966D;
                } else {
                    this.f22028d.f21966D = "";
                }
                this.f22028d.f21967E = this.f22028d.f21967E == null ? "" : this.f22028d.f21967E;
                if (compile.matcher(this.f22028d.f21967E).matches()) {
                    this.f22028d.f21967E = this.f22028d.f21967E == null ? "" : this.f22028d.f21967E;
                } else {
                    this.f22028d.f21967E = "";
                }
            } catch (Exception e) {
            }
            C6313f.f21961r = true;
            this.f22028d.f21965C = this.f22028d.f21965C == null ? "" : this.f22028d.f21965C;
            this.f22028d.f21966D = this.f22028d.f21966D == null ? "" : this.f22028d.f21966D;
            this.f22028d.f21967E = this.f22028d.f21967E == null ? "" : this.f22028d.f21967E;
            this.f22028d.f21969G = C6326s.m29001a(this.f22028d.f21965C == null ? "0123456789ABCDEF" : this.f22028d.f21965C);
        }
        String a = this.f22028d.f21978f == 4 ? C6325r.m28997a(this.f22027c) : "[]";
        String a2 = C6325r.m28995a(this.f22026b, this.f22028d.f21975c.m28987a());
        String a3 = C6325r.m28998a(this.f22028d.f21965C, this.f22028d.f21966D, this.f22028d.f21967E, this.f22028d.f21968F, this.f22028d.f21971I);
        String a4 = (this.f22025a == null || !this.f22025a.m28988a()) ? "{}" : C6325r.m28996a(this.f22025a);
        this.f22028d.f21987o.sendMessage(this.f22028d.f21987o.obtainMessage(16, (("{\"version\":\"1.1.8\",\"address\":" + this.f22028d.f21983k) + ",\"source\":203,\"access_token\":\"" + this.f22028d.f21969G + "\",\"app_name\":" + "\"" + this.f22028d.f21970H + "\",\"bearing\":1") + ",\"attribute\":" + a3 + ",\"location\":" + a4 + ",\"cells\":" + a2 + ",\"wifis\":" + a + "}"));
    }
}
