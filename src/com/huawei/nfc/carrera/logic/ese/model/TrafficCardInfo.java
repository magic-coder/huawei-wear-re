package com.huawei.nfc.carrera.logic.ese.model;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.util.JSONHelperNotEncrypted;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

public class TrafficCardInfo {
    public static final String CARD_INSTALL_STATUS = "1";
    public static final String CARD_UNINSTALL_STATUS = "0";
    public static final int CARD_VALIDITY_DATE_STATUS_AFTER = 2;
    public static final int CARD_VALIDITY_DATE_STATUS_BEFORE = 1;
    public static final int CARD_VALIDITY_DATE_STATUS_NORMAL = 0;
    public static final int CARD_VALIDITY_DATE_STATUS_UNKNOWN = -1;
    private static final String TAG = "TrafficCardInfo";
    private String activationStatus;
    private String balance;
    private String cardNo;
    private String expireDate;
    private String installStatus;
    private String startdate;
    private int validityTermStatus;

    public static TrafficCardInfo build(String str) throws JSONException {
        TrafficCardInfo trafficCardInfo = new TrafficCardInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            trafficCardInfo.cardNo = JSONHelperNotEncrypted.getStringValue(jSONObject, "card_number");
            trafficCardInfo.balance = JSONHelperNotEncrypted.getStringValue(jSONObject, "balance");
            trafficCardInfo.expireDate = JSONHelperNotEncrypted.getStringValue(jSONObject, SNBConstant.FIELD_VALIDITY);
            trafficCardInfo.activationStatus = JSONHelperNotEncrypted.getStringValue(jSONObject, "activation_status");
            trafficCardInfo.installStatus = JSONHelperNotEncrypted.getStringValue(jSONObject, "install_status");
            trafficCardInfo.startdate = JSONHelperNotEncrypted.getStringValue(jSONObject, SNBConstant.FIELD_STARTDATE);
        } catch (JSONException e) {
            C2538c.e(TAG, new Object[]{"TrafficCardInfo build JSONException e : " + e.getMessage()});
        }
        return trafficCardInfo;
    }

    public String getCardNo() {
        return (String) C0978h.a(this.cardNo);
    }

    public String getBalance() {
        return (String) C0978h.a(this.balance);
    }

    public String getExpireDate() {
        return (String) C0978h.a(this.expireDate);
    }

    public int getValidityTermStatus() {
        return ((Integer) C0978h.a(Integer.valueOf(this.validityTermStatus))).intValue();
    }

    public String getActivationStatus() {
        return (String) C0978h.a(this.activationStatus);
    }

    public String getInstallStatus() {
        return (String) C0978h.a(this.installStatus);
    }

    public String getStartdate() {
        return (String) C0978h.a(this.startdate);
    }

    public void setCardNo(String str) {
        this.cardNo = (String) C0978h.a(str);
    }

    public void setBalance(String str) {
        this.balance = (String) C0978h.a(str);
    }

    public void setExpireDate(String str) {
        this.expireDate = (String) C0978h.a(str);
    }

    public void setValidityTermStatus(int i) {
        this.validityTermStatus = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setActivationStatus(String str) {
        this.activationStatus = (String) C0978h.a(str);
    }

    public void setInstallStatus(String str) {
        this.installStatus = (String) C0978h.a(str);
    }

    public void setStartdate(String str) {
        this.startdate = (String) C0978h.a(str);
    }
}
