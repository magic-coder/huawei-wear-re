package com.huawei.p390z.p525a;

import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TACardInfo */
public class C6182a implements Cloneable {
    public String f21673a;
    public String f21674b;
    public String f21675c;
    public int f21676d;
    public boolean f21677e;
    public String f21678f;
    public String f21679g;
    public String f21680h;
    public String f21681i;
    public int f21682j;
    public long f21683k;
    public int f21684l;
    public String f21685m;
    public String f21686n;
    public long f21687o;
    public String f21688p;
    public long f21689q;

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m28621b();
    }

    public C6182a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            m28619b(jSONObject);
            m28618a(jSONObject);
        } catch (JSONException e) {
            C2538c.e("TACardInfo", new Object[]{"TACardInfo() error = " + e.getMessage()});
        }
    }

    private final void m28618a(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("card_type")) {
            this.f21684l = jSONObject.getInt("card_type");
        }
        if (jSONObject.has("status_update_time")) {
            this.f21683k = jSONObject.getLong("status_update_time");
        }
        if (jSONObject.has("name")) {
            this.f21685m = jSONObject.getString("name");
        }
        if (jSONObject.has("Rf_File_time")) {
            this.f21687o = jSONObject.getLong("Rf_File_time");
        }
        if (jSONObject.has("Rf_file_name")) {
            this.f21686n = jSONObject.getString("Rf_file_name");
        }
        if (jSONObject.has("background_file_time")) {
            this.f21689q = jSONObject.getLong("background_file_time");
        }
        if (jSONObject.has("background_file_name")) {
            this.f21688p = jSONObject.getString("background_file_name");
        }
    }

    private final void m28619b(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("aid")) {
            this.f21673a = jSONObject.getString("aid");
        }
        if (jSONObject.has("issuerId")) {
            this.f21675c = jSONObject.getString("issuerId");
        }
        if (jSONObject.has("productId")) {
            this.f21674b = jSONObject.getString("productId");
        }
        if (jSONObject.has("card_group_type")) {
            this.f21676d = jSONObject.getInt("card_group_type");
        }
        if (jSONObject.has("fpan_digest")) {
            this.f21678f = jSONObject.getString("fpan_digest");
        }
        if (jSONObject.has("is_default_card")) {
            this.f21677e = jSONObject.getBoolean("is_default_card");
        }
        if (jSONObject.has("fpan_four")) {
            this.f21679g = jSONObject.getString("fpan_four");
        }
        if (jSONObject.has("dpan_four")) {
            this.f21681i = jSONObject.getString("dpan_four");
        }
        if (jSONObject.has("dpan_digest")) {
            this.f21680h = jSONObject.getString("dpan_digest");
        }
        if (jSONObject.has("card_status")) {
            this.f21682j = jSONObject.getInt("card_status");
        }
    }

    public String m28620a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", this.f21673a);
            jSONObject.put("productId", this.f21674b);
            jSONObject.put("issuerId", this.f21675c);
            jSONObject.put("card_group_type", this.f21676d);
            jSONObject.put("is_default_card", this.f21677e);
            jSONObject.put("fpan_digest", this.f21678f);
            jSONObject.put("fpan_four", this.f21679g);
            jSONObject.put("dpan_digest", this.f21680h);
            jSONObject.put("dpan_four", this.f21681i);
            jSONObject.put("card_status", this.f21682j);
            jSONObject.put("status_update_time", this.f21683k);
            jSONObject.put("card_type", this.f21684l);
            jSONObject.put("name", this.f21685m);
            jSONObject.put("Rf_file_name", this.f21686n);
            jSONObject.put("Rf_File_time", this.f21687o);
            jSONObject.put("background_file_name", this.f21688p);
            jSONObject.put("background_file_time", this.f21689q);
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    protected C6182a m28621b() {
        try {
            return (C6182a) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("cardType=").append(this.f21676d).append("\n");
        stringBuffer.append("isDefaultCard=").append(this.f21677e).append("\n");
        stringBuffer.append("imeiDigest=").append(this.f21678f).append("\n");
        stringBuffer.append("imeiFour=").append(this.f21679g).append("\n");
        stringBuffer.append("numberDigest=").append(this.f21680h).append("\n");
        stringBuffer.append("numberFour=").append(this.f21681i).append("\n");
        stringBuffer.append("aid=").append(this.f21673a).append("\n");
        stringBuffer.append("productId=").append(this.f21674b).append("\n");
        stringBuffer.append("issuerId=").append(this.f21675c).append("\n");
        stringBuffer.append("cardStatus=").append(this.f21682j).append("\n");
        stringBuffer.append("statusUpdateTime=").append(this.f21683k).append("\n");
        stringBuffer.append("cardClassfyType=").append(this.f21684l).append("\n");
        stringBuffer.append("name=").append(this.f21685m).append("\n");
        stringBuffer.append("Rf_file_name=").append(this.f21686n).append("\n");
        stringBuffer.append("Rf_File_time=").append(this.f21687o).append("\n");
        stringBuffer.append("background_file_name=").append(this.f21688p).append("\n");
        stringBuffer.append("background_file_time=").append(this.f21689q).append("\n");
        return stringBuffer.toString();
    }
}
