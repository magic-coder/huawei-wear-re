package com.p230a.p234a;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.p230a.p231b.p235a.C3082b;
import com.p230a.p231b.p237c.C3130c;
import com.p230a.p231b.p237c.C3132e;
import com.p230a.p231b.p237c.C3133f;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.simalliance.openmobileapi.C3076f;
import org.simalliance.openmobileapi.C6649a;
import org.simalliance.openmobileapi.C6650b;
import org.simalliance.openmobileapi.C6651c;
import org.simalliance.openmobileapi.C6656g;

public final class C3077j extends C3067e implements C3076f {
    private C6651c f10339g;
    private C6656g f10340h;
    private C6649a f10341i;
    private String f10342j;
    private String f10343k;

    public C3077j() {
        this.f10340h = null;
        this.f10341i = null;
        this.f10342j = "";
        this.f10343k = "";
        this.d = 60000;
        this.e = 0;
        this.f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    }

    static /* synthetic */ void m13766a(C3077j c3077j, Map map) {
        String str = (String) map.get("APDU");
        boolean c = !C3132e.m13953a(str) ? c3077j.m13768c(str) : false;
        c3077j.b.put("Function", "apduResult");
        c3077j.b.put("ApduIndex", c3077j.f10342j);
        if (c3077j.f10343k == null || "".equals(c3077j.f10343k)) {
            c3077j.b.put("RAPDU", "");
        } else {
            c3077j.b.put("RAPDU", C3133f.m13956b(c3077j.f10343k));
        }
        c3077j.b.put("Result", c ? "0" : "1");
        if (map.get("SessionId") != null) {
            c3077j.b.put("SessionId", (String) map.get("SessionId"));
        }
        c3077j.b.put("Signature", (String) map.get("Signature"));
        c3077j.b.put("Timespan", (String) map.get("Timespan"));
        c3077j.b.put("Token", (String) map.get("Token"));
        c3077j.m13751a(c3077j.a, c3077j.b);
    }

    private boolean m13767c() {
        try {
            C3082b.m13790c("citic", "Retrieve available readers...");
            C6650b[] b = this.f10339g.m29953b();
            if (b.length <= 0) {
                C3082b.m13788a("citic", "available readers not exist.");
                return false;
            }
            int i = 0;
            while (i < b.length) {
                String a = b[i].m29943a();
                if (a == null || !a.toLowerCase().startsWith("ese")) {
                    i++;
                } else {
                    this.f10340h = b[i].m29944b();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean m13768c(String str) {
        int i = 6;
        if (this.f10339g == null) {
            return false;
        }
        try {
            if ((this.f10340h == null && !m13767c()) || str.length() < 6) {
                return false;
            }
            C3130c.m13938b(str.substring(0, 4));
            int b = C3130c.m13938b(str.substring(4, 6));
            while (b > 0) {
                int b2 = C3130c.m13938b(str.substring(i, i + 2));
                C3082b.m13788a("citic", "第" + b2 + "条指令");
                this.f10342j = new StringBuilder(String.valueOf(b2)).toString();
                i += 2;
                b2 = i + 4;
                int b3 = C3130c.m13938b(str.substring(i, b2));
                String substring = str.substring(b2, (b3 << 1) + b2);
                C3082b.m13788a("citic", substring);
                String str2 = "";
                if (substring.startsWith("00A4")) {
                    if (!(this.f10341i == null || this.f10341i.m29941b())) {
                        this.f10341i.m29939a();
                    }
                    this.f10341i = this.f10340h.m29963b(C3130c.m13937a(substring.substring(10)));
                    str2 = C3130c.m13936a(this.f10341i.m29942c());
                } else if (this.f10341i != null) {
                    str2 = C3130c.m13936a(this.f10341i.m29940a(C3130c.m13937a(substring)));
                }
                C3082b.m13788a("citic", "getCplc response apdu : " + str2);
                this.f10343k = str2;
                if (str2 == null || "".equals(str2) || !str2.endsWith("9000")) {
                    return false;
                }
                b--;
                if (b == 0) {
                    return true;
                }
                i = ((b3 << 1) + b2) + 4;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected final String mo3638a(String str) {
        return "apduResult".equals(str) ? "cardApduResult.action" : "personDataRequest.action";
    }

    protected final HashMap mo3639a(HashMap hashMap) {
        return hashMap;
    }

    protected final void mo3641a(Context context) {
        super.mo3641a(context);
        try {
            C3082b.m13790c("citic", "creating SEService object");
            C6651c c6651c = new C6651c(context, this);
        } catch (SecurityException e) {
            C3082b.m13789b("citic", "Binding not allowed, uses-permission org.simalliance.openmobileapi.SMARTCARD?");
        } catch (Exception e2) {
            C3082b.m13789b("citic", "Exception: " + e2.getMessage());
        }
    }

    protected final void mo3642a(Context context, Map map) {
        if (map == null) {
            mo3643b();
        }
        String str = (String) map.get("ApduCode");
        String str2 = (String) map.get("APDU");
        if ("1".equals(str) || C3132e.m13953a(str2)) {
            this.c = new HashMap();
            this.c.put("Result", (String) map.get("Result"));
            this.c.put("Signature", (String) map.get("Signature"));
            this.c.put("Timespan", (String) map.get("Timespan"));
            this.c.put("Token", (String) map.get("Token"));
            mo3643b();
        } else if (C3132e.m13953a(str) || "0".equals(str)) {
            new Thread(new C3073g(this, context, map)).start();
        }
    }

    protected final void mo3643b() {
        try {
            if (!(this.f10341i == null || this.f10341i.m29941b())) {
                C3082b.m13788a("citic", "getCplc, channel close begin.");
                this.f10341i.m29939a();
                C3082b.m13788a("citic", "getCplc, channel close end.");
            }
            if (!(this.f10340h == null || this.f10340h.m29965c())) {
                C3082b.m13788a("citic", "close channels in the session begin.");
                this.f10340h.m29966d();
                C3082b.m13788a("citic", "close channels in the session end.");
                C3082b.m13788a("citic", "close the session begin.");
                this.f10340h.m29964b();
                C3082b.m13788a("citic", "close the session end.");
            }
            if (((this.f10339g != null ? 1 : 0) & this.f10339g.m29952a()) != 0) {
                this.f10339g.m29954c();
            }
            this.f10339g = null;
            if (this.c == null) {
                C3082b.m13788a("citic", "mResponseMap == null");
            }
            if (this.c != null) {
                C3082b.m13788a("citic", "mResponseMap != null");
                for (Entry entry : this.c.entrySet()) {
                    C3082b.m13788a("citic", new StringBuilder(String.valueOf((String) entry.getKey())).append("=").append(entry.getValue()).toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.mo3643b();
    }

    public final void serviceConnected(C6651c c6651c) {
        this.f10339g = c6651c;
    }
}
