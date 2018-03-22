package com.huawei.nfc.carrera.logic.ta;

import android.util.Log;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.util.GodClassUtil;
import org.json.JSONObject;

public class TACardInfo implements Cloneable {
    private static final String TA_JSON_KEY_AID = "aid";
    private static final String TA_JSON_KEY_BACKGROUND_FILE_NAME = "background_file_name";
    private static final String TA_JSON_KEY_BACKGROUND_FILE_TIME = "background_file_time";
    private static final String TA_JSON_KEY_CARDCLASSFYTYPE = "card_type";
    private static final String TA_JSON_KEY_CARDGROUPTYPE = "card_group_type";
    private static final String TA_JSON_KEY_CARDSTATUS = "card_status";
    private static final String TA_JSON_KEY_DPANDIGEST = "dpan_digest";
    private static final String TA_JSON_KEY_DPANFOUR = "dpan_four";
    private static final String TA_JSON_KEY_FPANDIGEST = "fpan_digest";
    private static final String TA_JSON_KEY_FPANFOUR = "fpan_four";
    private static final String TA_JSON_KEY_ISDEFAULTCARD = "is_default_card";
    private static final String TA_JSON_KEY_ISSUERID = "issuerId";
    private static final String TA_JSON_KEY_NAME = "name";
    private static final String TA_JSON_KEY_PRODUCTID = "productId";
    private static final String TA_JSON_KEY_RF_FILE_NAME = "Rf_file_name";
    private static final String TA_JSON_KEY_RF_FILE_TIME = "Rf_File_time";
    private static final String TA_JSON_KEY_STATUSUPDATETIME = "status_update_time";
    public long Rf_File_time;
    public String Rf_file_name;
    public String aid;
    public String background_file_name;
    public long background_file_time;
    public int cardGroupType;
    public int cardStatus;
    public int cardType;
    public String dpanDigest;
    public String dpanFour;
    public String fpanDigest;
    public String fpanFour;
    public boolean isDefaultCard;
    public String issuerId;
    public String name;
    public String productId;
    public long statusUpdateTime;

    public TACardInfo(String str, String str2, String str3, int i, boolean z, String str4, String str5, String str6, String str7, int i2, long j, int i3, String str8, String str9, long j2, String str10, long j3) {
        this.aid = str;
        this.productId = str2;
        this.issuerId = str3;
        this.cardGroupType = i;
        this.isDefaultCard = z;
        this.fpanDigest = str4;
        this.fpanFour = str5;
        this.dpanDigest = str6;
        this.dpanFour = str7;
        this.cardStatus = i2;
        this.statusUpdateTime = j;
        this.cardType = i3;
        this.name = str8;
        this.Rf_file_name = str9;
        this.Rf_File_time = j2;
        this.background_file_name = str10;
        this.background_file_time = j3;
    }

    TACardInfo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("aid")) {
                this.aid = jSONObject.getString("aid");
            }
            if (jSONObject.has(TA_JSON_KEY_PRODUCTID)) {
                this.productId = jSONObject.getString(TA_JSON_KEY_PRODUCTID);
            }
            if (jSONObject.has("issuerId")) {
                this.issuerId = jSONObject.getString("issuerId");
            }
            if (jSONObject.has(TA_JSON_KEY_CARDGROUPTYPE)) {
                this.cardGroupType = jSONObject.getInt(TA_JSON_KEY_CARDGROUPTYPE);
            }
            if (jSONObject.has(TA_JSON_KEY_ISDEFAULTCARD)) {
                this.isDefaultCard = jSONObject.getBoolean(TA_JSON_KEY_ISDEFAULTCARD);
            }
            if (jSONObject.has(TA_JSON_KEY_FPANDIGEST)) {
                this.fpanDigest = jSONObject.getString(TA_JSON_KEY_FPANDIGEST);
            }
            if (jSONObject.has(TA_JSON_KEY_FPANFOUR)) {
                this.fpanFour = jSONObject.getString(TA_JSON_KEY_FPANFOUR);
            }
            if (jSONObject.has(TA_JSON_KEY_DPANDIGEST)) {
                this.dpanDigest = jSONObject.getString(TA_JSON_KEY_DPANDIGEST);
            }
            if (jSONObject.has(TA_JSON_KEY_DPANFOUR)) {
                this.dpanFour = jSONObject.getString(TA_JSON_KEY_DPANFOUR);
            }
            if (jSONObject.has(TA_JSON_KEY_CARDSTATUS)) {
                this.cardStatus = jSONObject.getInt(TA_JSON_KEY_CARDSTATUS);
            }
            if (jSONObject.has(TA_JSON_KEY_STATUSUPDATETIME)) {
                this.statusUpdateTime = jSONObject.getLong(TA_JSON_KEY_STATUSUPDATETIME);
            }
            if (jSONObject.has("card_type")) {
                this.cardType = jSONObject.getInt("card_type");
            }
            if (jSONObject.has("name")) {
                this.name = jSONObject.getString("name");
            }
            if (jSONObject.has(TA_JSON_KEY_RF_FILE_NAME)) {
                this.Rf_file_name = jSONObject.getString(TA_JSON_KEY_RF_FILE_NAME);
            }
            if (jSONObject.has(TA_JSON_KEY_RF_FILE_TIME)) {
                this.Rf_File_time = jSONObject.getLong(TA_JSON_KEY_RF_FILE_TIME);
            }
            if (jSONObject.has(TA_JSON_KEY_BACKGROUND_FILE_NAME)) {
                this.background_file_name = jSONObject.getString(TA_JSON_KEY_BACKGROUND_FILE_NAME);
            }
            if (jSONObject.has(TA_JSON_KEY_BACKGROUND_FILE_TIME)) {
                this.background_file_time = jSONObject.getLong(TA_JSON_KEY_BACKGROUND_FILE_TIME);
            }
        } catch (Throwable e) {
            LogX.m5469e("create ta card info failed: " + Log.getStackTraceString(e));
        }
    }

    String getTaCardInfoJsonStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", this.aid);
            jSONObject.put(TA_JSON_KEY_PRODUCTID, this.productId);
            jSONObject.put("issuerId", this.issuerId);
            jSONObject.put(TA_JSON_KEY_CARDGROUPTYPE, this.cardGroupType);
            jSONObject.put(TA_JSON_KEY_ISDEFAULTCARD, this.isDefaultCard);
            jSONObject.put(TA_JSON_KEY_FPANDIGEST, this.fpanDigest);
            jSONObject.put(TA_JSON_KEY_FPANFOUR, this.fpanFour);
            jSONObject.put(TA_JSON_KEY_DPANDIGEST, this.dpanDigest);
            jSONObject.put(TA_JSON_KEY_DPANFOUR, this.dpanFour);
            jSONObject.put(TA_JSON_KEY_CARDSTATUS, this.cardStatus);
            jSONObject.put(TA_JSON_KEY_STATUSUPDATETIME, this.statusUpdateTime);
            jSONObject.put("card_type", this.cardType);
            jSONObject.put("name", this.name);
            jSONObject.put(TA_JSON_KEY_RF_FILE_NAME, this.Rf_file_name);
            jSONObject.put(TA_JSON_KEY_RF_FILE_TIME, this.Rf_File_time);
            jSONObject.put(TA_JSON_KEY_BACKGROUND_FILE_NAME, this.background_file_name);
            jSONObject.put(TA_JSON_KEY_BACKGROUND_FILE_TIME, this.background_file_time);
        } catch (Throwable e) {
            LogX.m5469e("getTaCardInfoJsonStr, json exception: " + Log.getStackTraceString(e));
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    protected TACardInfo clone() {
        try {
            return (TACardInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("cardType=").append(this.cardGroupType).append("\n");
        stringBuffer.append("isDefaultCard=").append(this.isDefaultCard).append("\n");
        stringBuffer.append("imeiDigest=").append(this.fpanDigest).append("\n");
        stringBuffer.append("imeiFour=").append(this.fpanFour).append("\n");
        stringBuffer.append("numberDigest=").append(this.dpanDigest).append("\n");
        stringBuffer.append("numberFour=").append(this.dpanFour).append("\n");
        stringBuffer.append("aid=").append(this.aid).append("\n");
        stringBuffer.append("productId=").append(this.productId).append("\n");
        stringBuffer.append("issuerId=").append(this.issuerId).append("\n");
        stringBuffer.append("cardStatus=").append(this.cardStatus).append("\n");
        stringBuffer.append("statusUpdateTime=").append(this.statusUpdateTime).append("\n");
        stringBuffer.append("cardClassfyType=").append(this.cardType).append("\n");
        stringBuffer.append("name=").append(this.name).append("\n");
        stringBuffer.append("Rf_file_name=").append(this.Rf_file_name).append("\n");
        stringBuffer.append("Rf_File_time=").append(this.Rf_File_time).append("\n");
        stringBuffer.append("background_file_name=").append(this.background_file_name).append("\n");
        stringBuffer.append("background_file_time=").append(this.background_file_time).append("\n");
        return stringBuffer.toString();
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public int getCardGroupType() {
        return ((Integer) GodClassUtil.commonFunc(Integer.valueOf(this.cardGroupType))).intValue();
    }

    public void setCardGroupType(int i) {
        this.cardGroupType = i;
    }

    public boolean isDefaultCard() {
        return this.isDefaultCard;
    }

    public void setDefaultCard(boolean z) {
        this.isDefaultCard = z;
    }

    public String getFpanDigest() {
        return this.fpanDigest;
    }

    public void setFpanDigest(String str) {
        this.fpanDigest = str;
    }

    public String getFpanFour() {
        return this.fpanFour;
    }

    public void setFpanFour(String str) {
        this.fpanFour = str;
    }

    public String getDpanDigest() {
        return this.dpanDigest;
    }

    public void setDpanDigest(String str) {
        this.dpanDigest = str;
    }

    public String getDpanFour() {
        return this.dpanFour;
    }

    public void setDpanFour(String str) {
        this.dpanFour = str;
    }

    public int getCardStatus() {
        return this.cardStatus;
    }

    public void setCardStatus(int i) {
        this.cardStatus = i;
    }

    public long getStatusUpdateTime() {
        return this.statusUpdateTime;
    }

    public void setStatusUpdateTime(long j) {
        this.statusUpdateTime = j;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getRf_file_name() {
        return this.Rf_file_name;
    }

    public void setRf_file_name(String str) {
        this.Rf_file_name = str;
    }

    public long getRf_File_time() {
        return this.Rf_File_time;
    }

    public void setRf_File_time(long j) {
        this.Rf_File_time = j;
    }

    public String getBackground_file_name() {
        return this.background_file_name;
    }

    public void setBackground_file_name(String str) {
        this.background_file_name = str;
    }

    public long getBackground_file_time() {
        return this.background_file_time;
    }

    public void setBackground_file_time(long j) {
        this.background_file_time = j;
    }

    public boolean isCardStatusPayedNotOpened() {
        if (this.cardStatus == 11 || this.cardStatus == 12) {
            return true;
        }
        return false;
    }
}
