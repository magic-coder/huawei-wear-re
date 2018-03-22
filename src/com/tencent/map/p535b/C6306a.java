package com.tencent.map.p535b;

import android.location.Location;
import com.amap.api.location.LocationManagerProxy;
import org.json.JSONException;
import org.json.JSONObject;

public class C6306a {
    public String f21939a;
    private double f21940b;
    private double f21941c;
    private double f21942d;
    private double f21943e;
    private double f21944f;
    private double f21945g;
    private C6307b f21946h;
    private C6308c f21947i;
    private boolean f21948j;

    static /* synthetic */ void m28916a(C6306a c6306a, byte[] bArr, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(new String(bArr, str));
        } catch (Exception e) {
            if (c6306a.f21946h != null) {
                c6306a.f21946h.mo5302a(360.0d, 360.0d);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(stringBuffer.toString()).getJSONObject(LocationManagerProxy.KEY_LOCATION_CHANGED);
            double d = jSONObject.getDouble("latitude");
            double d2 = jSONObject.getDouble("longitude");
            c6306a.f21944f = d - c6306a.f21942d;
            c6306a.f21945g = d2 - c6306a.f21943e;
            c6306a.f21940b = c6306a.f21942d;
            c6306a.f21941c = c6306a.f21943e;
            if (c6306a.f21946h != null) {
                c6306a.f21946h.mo5302a(d, d2);
            }
        } catch (JSONException e2) {
            if (c6306a.f21946h != null) {
                c6306a.f21946h.mo5302a(360.0d, 360.0d);
            }
        }
    }

    public final void m28919a(double d, double d2, C6307b c6307b) {
        this.f21946h = c6307b;
        if (!(this.f21944f == 0.0d || this.f21945g == 0.0d)) {
            float[] fArr = new float[10];
            Location.distanceBetween(d, d2, this.f21940b, this.f21941c, fArr);
            if (fArr[0] < 1500.0f) {
                this.f21946h.mo5302a(this.f21944f + d, this.f21945g + d2);
                return;
            }
        }
        if (!this.f21948j) {
            this.f21939a = "{\"source\":101,\"access_token\":\"160e7bd42dec9428721034e0146fc6dd\",\"location\":{\"latitude\":" + d + ",\"longitude\":" + d2 + "}\t}";
            this.f21942d = d;
            this.f21943e = d2;
            this.f21947i = new C6308c(this);
            this.f21947i.start();
        }
    }

    public static boolean m28918a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static C6331x m28915a(String str, String str2, byte[] bArr) throws C6332y, ab, Exception {
        Object obj = 1;
        if (C6329v.m29015b() == null) {
            obj = null;
        }
        if (obj == null) {
            throw new C6332y();
        }
        try {
            return aa.m28921a(false, str, str2, null, bArr, false, true);
        } catch (Exception e) {
            throw e;
        }
    }
}
