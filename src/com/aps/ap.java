package com.aps;

import com.amap.api.location.core.AMapLocException;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import org.json.JSONObject;

/* compiled from: AmapLoc */
public class ap {
    private String f12914a = "";
    private double f12915b = 0.0d;
    private double f12916c = 0.0d;
    private float f12917d = 0.0f;
    private float f12918e = 0.0f;
    private float f12919f = 0.0f;
    private long f12920g = 0;
    private AMapLocException f12921h = new AMapLocException();
    private String f12922i = "new";
    private String f12923j = "";
    private String f12924k = "";
    private String f12925l = "";
    private String f12926m = "";
    private String f12927n = "";
    private String f12928o = "";
    private String f12929p = "";
    private String f12930q = "";
    private String f12931r = "";
    private String f12932s = "";
    private String f12933t = "";
    private String f12934u = "";
    private String f12935v = "";
    private String f12936w = "";
    private String f12937x = "";
    private JSONObject f12938y = null;

    public AMapLocException m17284a() {
        return this.f12921h;
    }

    public void m17288a(AMapLocException aMapLocException) {
        this.f12921h = aMapLocException;
    }

    public String m17291b() {
        return this.f12933t;
    }

    public void m17289a(String str) {
        this.f12933t = str;
    }

    public String m17295c() {
        return this.f12934u;
    }

    public void m17294b(String str) {
        this.f12934u = str;
    }

    public String m17297d() {
        return this.f12937x;
    }

    public void m17296c(String str) {
        this.f12937x = str;
    }

    public void m17298d(String str) {
        this.f12935v = str;
    }

    public void m17300e(String str) {
        this.f12936w = str;
    }

    public ap(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f12914a = jSONObject.getString("provider");
                this.f12915b = jSONObject.getDouble("lon");
                this.f12916c = jSONObject.getDouble("lat");
                this.f12917d = (float) jSONObject.getLong("accuracy");
                this.f12918e = (float) jSONObject.getLong("speed");
                this.f12919f = (float) jSONObject.getLong("bearing");
                this.f12920g = jSONObject.getLong(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME);
                this.f12922i = jSONObject.getString("type");
                this.f12923j = jSONObject.getString("retype");
                this.f12924k = jSONObject.getString("citycode");
                this.f12925l = jSONObject.getString("desc");
                this.f12926m = jSONObject.getString("adcode");
                this.f12927n = jSONObject.getString("country");
                this.f12928o = jSONObject.getString("province");
                this.f12929p = jSONObject.getString("city");
                this.f12930q = jSONObject.getString("road");
                this.f12931r = jSONObject.getString("street");
                this.f12932s = jSONObject.getString(ParamKey.POINAME);
                this.f12934u = jSONObject.getString("floor");
                this.f12933t = jSONObject.getString(ParamKey.POIID);
                this.f12935v = jSONObject.getString("coord");
                this.f12936w = jSONObject.getString("mcell");
                this.f12937x = jSONObject.getString(DistrictSearchQuery.KEYWORDS_DISTRICT);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void m17302f(String str) {
        this.f12914a = str;
    }

    public double m17299e() {
        return this.f12915b;
    }

    public void m17285a(double d) {
        this.f12915b = d;
    }

    public double m17301f() {
        return this.f12916c;
    }

    public void m17292b(double d) {
        this.f12916c = d;
    }

    public float m17303g() {
        return this.f12917d;
    }

    public void m17286a(float f) {
        this.f12917d = f;
    }

    public void m17293b(float f) {
        this.f12919f = f;
    }

    public long m17305h() {
        return this.f12920g;
    }

    public void m17287a(long j) {
        this.f12920g = j;
    }

    public String m17307i() {
        return this.f12922i;
    }

    public void m17304g(String str) {
        this.f12922i = str;
    }

    public String m17309j() {
        return this.f12923j;
    }

    public void m17306h(String str) {
        this.f12923j = str;
    }

    public String m17311k() {
        return this.f12924k;
    }

    public void m17308i(String str) {
        this.f12924k = str;
    }

    public String m17313l() {
        return this.f12925l;
    }

    public void m17310j(String str) {
        this.f12925l = str;
    }

    public String m17315m() {
        return this.f12926m;
    }

    public void m17312k(String str) {
        this.f12926m = str;
    }

    public String m17317n() {
        return this.f12927n;
    }

    public void m17314l(String str) {
        this.f12927n = str;
    }

    public String m17319o() {
        return this.f12928o;
    }

    public void m17316m(String str) {
        this.f12928o = str;
    }

    public String m17321p() {
        return this.f12929p;
    }

    public void m17318n(String str) {
        this.f12929p = str;
    }

    public String m17323q() {
        return this.f12930q;
    }

    public void m17320o(String str) {
        this.f12930q = str;
    }

    public String m17325r() {
        return this.f12931r;
    }

    public void m17322p(String str) {
        this.f12931r = str;
    }

    public String m17326s() {
        return this.f12932s;
    }

    public void m17324q(String str) {
        this.f12932s = str;
    }

    public JSONObject m17327t() {
        return this.f12938y;
    }

    public void m17290a(JSONObject jSONObject) {
        this.f12938y = jSONObject;
    }

    public String m17328u() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("provider", this.f12914a);
            jSONObject.put("lon", this.f12915b);
            jSONObject.put("lat", this.f12916c);
            jSONObject.put("accuracy", (double) this.f12917d);
            jSONObject.put("speed", (double) this.f12918e);
            jSONObject.put("bearing", (double) this.f12919f);
            jSONObject.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, this.f12920g);
            jSONObject.put("type", this.f12922i);
            jSONObject.put("retype", this.f12923j);
            jSONObject.put("citycode", this.f12924k);
            jSONObject.put("desc", this.f12925l);
            jSONObject.put("adcode", this.f12926m);
            jSONObject.put("country", this.f12927n);
            jSONObject.put("province", this.f12928o);
            jSONObject.put("city", this.f12929p);
            jSONObject.put("road", this.f12930q);
            jSONObject.put("street", this.f12931r);
            jSONObject.put(ParamKey.POINAME, this.f12932s);
            jSONObject.put(ParamKey.POIID, this.f12933t);
            jSONObject.put("floor", this.f12934u);
            jSONObject.put("coord", this.f12935v);
            jSONObject.put("mcell", this.f12936w);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f12937x);
        } catch (Throwable e) {
            bu.m17452a(e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
