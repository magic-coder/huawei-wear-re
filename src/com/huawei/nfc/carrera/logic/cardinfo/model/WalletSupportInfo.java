package com.huawei.nfc.carrera.logic.cardinfo.model;

import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletSupportInfo {
    public static final String JSON_KEY_SUPPORTBUSINESS = "supportBusiness";
    public static final String JSON_KEY_SUPPORTDEFAUTCARD = "supportDefautcard";
    public static final String JSON_KEY_SUPPORTISSUERS = "supportIssuers";
    private static final String TAG = "WalletSupportInfo";
    private String supportBusiness = "";
    private int supportDefautcard = 0;
    private String supportIssuers = "";
    private ArrayList<String> supportList = new ArrayList();

    public interface WalletSupportInfoSai1 {
    }

    public interface WalletSupportInfoSai2 {
    }

    public interface WalletSupportInfoSai3 {
    }

    public interface WalletSupportInfoSai4 {
    }

    public interface WalletSupportInfoSai5 {
    }

    public interface WalletSupportInfoSai6 {
    }

    public WalletSupportInfo(String str) {
        try {
            C2538c.e(TAG, new Object[]{"WalletSupportInfo jsonStr: " + str});
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(JSON_KEY_SUPPORTBUSINESS)) {
                    this.supportBusiness = jSONObject.getString(JSON_KEY_SUPPORTBUSINESS);
                }
                if (jSONObject.has(JSON_KEY_SUPPORTISSUERS)) {
                    this.supportIssuers = jSONObject.getString(JSON_KEY_SUPPORTISSUERS);
                    if (this.supportIssuers != null && this.supportIssuers.contains("|")) {
                        String[] split = this.supportIssuers.split("\\|");
                        for (Object add : split) {
                            this.supportList.add(add);
                        }
                    }
                }
                if (jSONObject.has(JSON_KEY_SUPPORTDEFAUTCARD)) {
                    this.supportDefautcard = jSONObject.getInt(JSON_KEY_SUPPORTDEFAUTCARD);
                }
            }
        } catch (JSONException e) {
            C2538c.e(TAG, new Object[]{"create WalletSupportInfo failed: " + e.getMessage()});
        }
    }

    public String toString() {
        return "WalletSupportInfo{supportBusiness='" + this.supportBusiness + '\'' + ", supportIssuers='" + this.supportIssuers + '\'' + ", supportDefautcard=" + this.supportDefautcard + '}';
    }

    public String getSupportBusiness() {
        return this.supportBusiness;
    }

    public void setSupportBusiness(String str) {
        this.supportBusiness = str;
    }

    public String getSupportIssuers() {
        return this.supportIssuers;
    }

    public void setSupportIssuers(String str) {
        this.supportIssuers = str;
    }

    public int getSupportDefautcard() {
        return this.supportDefautcard;
    }

    public void setSupportDefautcard(int i) {
        this.supportDefautcard = i;
    }

    public ArrayList<String> getSupportList() {
        return this.supportList;
    }

    public void setSupportList(ArrayList<String> arrayList) {
        this.supportList = arrayList;
    }

    public void walletSupportInfoSAI1() {
    }

    public void walletSupportInfoSAI2() {
    }

    public void walletSupportInfoSAI3() {
    }

    public void walletSupportInfoSAI4() {
    }

    public void walletSupportInfoSAI5() {
    }
}
