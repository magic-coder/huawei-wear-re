package com.huawei.nfc.carrera.logic.wxpay;

import android.util.Log;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.json.JsonUtil;
import org.json.JSONObject;

public class WXPayInfo {
    private String appId;
    private String nonceStr;
    private String packageValue;
    private String partnerId;
    private String prepayId;
    private String sign;
    private String timeStamp;

    class Commonkey {
        static final String KEY_APP_ID = "appid";
        static final String KEY_NONCE_STR = "noncestr";
        static final String KEY_PACKAGE_VALUE = "packageValue";
        static final String KEY_PARTNER_ID = "partnerid";
        static final String KEY_PREPAY_ID = "prepayid";
        static final String KEY_SIGN = "sign";
        static final String KEY_TIME_STAMP = "timestamp";

        private Commonkey() {
        }
    }

    public static WXPayInfo build(String str) {
        if (StringUtil.isEmpty(str, true)) {
            return null;
        }
        WXPayInfo wXPayInfo = new WXPayInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            wXPayInfo.appId = JsonUtil.getStringValue(jSONObject, "appid");
            if (wXPayInfo.appId == null) {
                return null;
            }
            wXPayInfo.nonceStr = JsonUtil.getStringValue(jSONObject, "noncestr");
            if (wXPayInfo.nonceStr == null) {
                return null;
            }
            wXPayInfo.packageValue = JsonUtil.getStringValue(jSONObject, "packageValue");
            if (wXPayInfo.packageValue == null) {
                return null;
            }
            wXPayInfo.prepayId = JsonUtil.getStringValue(jSONObject, "prepayid");
            if (wXPayInfo.prepayId == null) {
                return null;
            }
            wXPayInfo.sign = JsonUtil.getStringValue(jSONObject, "sign");
            if (wXPayInfo.sign == null) {
                return null;
            }
            wXPayInfo.timeStamp = JsonUtil.getStringValue(jSONObject, "timestamp");
            if (wXPayInfo.timeStamp == null) {
                return null;
            }
            wXPayInfo.partnerId = JsonUtil.getStringValue(jSONObject, "partnerid");
            if (wXPayInfo.partnerId != null) {
                return wXPayInfo;
            }
            return null;
        } catch (Throwable e) {
            LogX.e("PayInfo, JSONException" + Log.getStackTraceString(e), true);
            return null;
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getNonceStr() {
        return this.nonceStr;
    }

    public void setNonceStr(String str) {
        this.nonceStr = str;
    }

    public String getPackageValue() {
        return this.packageValue;
    }

    public void setPackageValue(String str) {
        this.packageValue = str;
    }

    public String getPrepayId() {
        return this.prepayId;
    }

    public void setPrepayId(String str) {
        this.prepayId = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public String getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(String str) {
        this.partnerId = str;
    }
}
