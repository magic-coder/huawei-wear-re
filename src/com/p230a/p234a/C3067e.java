package com.p230a.p234a;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.p230a.p231b.p232b.C3125b;
import com.p230a.p231b.p232b.C3127d;
import com.p230a.p231b.p232b.p233a.C3102w;
import com.p230a.p231b.p232b.p233a.C3107e;
import com.p230a.p231b.p232b.p233a.C3115m;
import com.p230a.p231b.p235a.C3084d;
import java.util.HashMap;
import java.util.Map;

public abstract class C3067e {
    protected Context f10325a = null;
    protected HashMap f10326b = new HashMap(5);
    protected Map f10327c = null;
    protected int f10328d = 20000;
    protected int f10329e = 0;
    protected float f10330f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private Object f10331g = null;

    protected static String m13746b(String str) {
        return new StringBuffer("https://creditcard.ecitic.com/citiccard/TsmNet/").append(str).toString();
    }

    protected abstract String mo3638a(String str);

    protected abstract HashMap mo3639a(HashMap hashMap);

    protected void m13749a() {
        if (this.f10331g != null) {
            synchronized (this.f10331g) {
                try {
                    this.f10331g.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void mo3641a(Context context) {
        if (C3084d.m13793a() == null) {
            C3084d.m13794a(context);
        }
        C3127d.m13929a(context);
    }

    protected void m13751a(Context context, HashMap hashMap) {
        this.f10325a = context;
        this.f10326b = hashMap;
        this.f10326b = mo3639a(hashMap);
        this.f10327c = null;
        C3115m c3125b = new C3125b(C3067e.m13746b(mo3638a((String) hashMap.get("Function"))), this.f10326b, new C3066a(this, context), new C3071d(this));
        c3125b.m13871a(new C3107e(this.f10328d, this.f10329e, this.f10330f));
        C3127d.m13929a(context).m13930a(c3125b);
    }

    protected void mo3642a(Context context, Map map) {
        this.f10327c = map;
        mo3643b();
    }

    protected void m13753a(C3102w c3102w) {
        try {
            this.f10327c = new HashMap();
            Object obj = "";
            if (c3102w != null) {
                if (c3102w.f10396a != null) {
                    obj = "responseCode=" + c3102w.f10396a.f10432a + "|";
                }
                obj = new StringBuilder(String.valueOf(obj)).append(c3102w.toString()).toString();
            }
            this.f10327c.put("Result", "-1");
            this.f10327c.put("ResultMsg", obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mo3643b();
    }

    public Map m13754b(Context context, HashMap hashMap) {
        mo3641a(context);
        this.f10331g = new Object();
        new Thread(new C3072f(this, context, hashMap)).start();
        m13749a();
        return this.f10327c;
    }

    protected void mo3643b() {
        if (this.f10331g != null) {
            synchronized (this.f10331g) {
                this.f10331g.notifyAll();
            }
        }
    }
}
