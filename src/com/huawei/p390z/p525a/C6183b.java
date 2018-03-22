package com.huawei.p390z.p525a;

import com.huawei.nfc.carrera.logic.cardinfo.model.WalletSupportInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WalletSupportInfo */
public class C6183b {
    private String f21690a = "";
    private String f21691b = "";
    private int f21692c = 0;

    public void m28624a(String str) {
        this.f21690a = str;
    }

    public void m28625b(String str) {
        this.f21691b = str;
    }

    public void m28623a(int i) {
        this.f21692c = i;
    }

    public String m28622a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WalletSupportInfo.JSON_KEY_SUPPORTBUSINESS, this.f21690a);
            jSONObject.put(WalletSupportInfo.JSON_KEY_SUPPORTISSUERS, this.f21691b);
            jSONObject.put(WalletSupportInfo.JSON_KEY_SUPPORTDEFAUTCARD, this.f21692c);
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
