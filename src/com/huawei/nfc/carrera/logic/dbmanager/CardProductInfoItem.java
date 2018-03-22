package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentValues;
import android.util.Log;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.response.CardProductInfoServerItem;
import com.huawei.nfc.carrera.storage.db.DataModel.CardProductInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.util.GodClassUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class CardProductInfoItem {
    private String[] commonRechargeAmounts;
    private String description;
    private String fontColor;
    private String issueCardActCd;
    private int issueCardDiscountCost = -1;
    private String[] issueCardRechargeAmounts;
    private int issueCardStdCost;
    private String issuerId;
    private String mktInfo;
    private String pictureUrl;
    private String productId;
    private String productName;
    private String rechargeActCd;
    private String[] rechargeDiscountAmounts;
    private String reserved1;
    private String reserved2;
    private String reserved3;
    private String reserved4;
    private String reserved5;
    private String reserved6;
    private String reservedInfo;
    private String snbCardId;
    private String snbCityBusCode;
    private long timeStamp;
    private int type;
    private String version;

    public CardProductInfoItem(CardProductInfoServerItem cardProductInfoServerItem) {
        this.productId = cardProductInfoServerItem.getProductId();
        this.productName = cardProductInfoServerItem.getProductName();
        this.pictureUrl = cardProductInfoServerItem.getPictureUrl();
        this.description = cardProductInfoServerItem.getDescription();
        this.type = cardProductInfoServerItem.getType();
        this.timeStamp = cardProductInfoServerItem.getTimeStamp();
        this.version = cardProductInfoServerItem.getVersion();
        this.issuerId = cardProductInfoServerItem.getIssuerId();
        this.mktInfo = cardProductInfoServerItem.getMktInfo();
        this.reservedInfo = cardProductInfoServerItem.getReservedInfo();
        this.fontColor = cardProductInfoServerItem.getFontColor();
        this.reserved1 = cardProductInfoServerItem.getReserved1();
        this.reserved2 = cardProductInfoServerItem.getReserved2();
        this.reserved3 = cardProductInfoServerItem.getReserved3();
        this.reserved4 = cardProductInfoServerItem.getReserved4();
        this.reserved5 = cardProductInfoServerItem.getReserved5();
        this.reserved6 = cardProductInfoServerItem.getReserved6();
        parseMktInfoJson();
        parseReservedJson();
    }

    public final void parseMktInfoJson() {
        try {
            if (!StringUtil.isEmpty(this.mktInfo, true)) {
                JSONObject jSONObject = new JSONObject(this.mktInfo);
                if (jSONObject.has("issuecard_act_cd")) {
                    this.issueCardActCd = jSONObject.getString("issuecard_act_cd");
                }
                if (jSONObject.has("issuecard_discount_cost")) {
                    this.issueCardDiscountCost = jSONObject.getInt("issuecard_discount_cost");
                }
                if (jSONObject.has("recharge_act_cd")) {
                    this.rechargeActCd = jSONObject.getString("recharge_act_cd");
                }
                if (jSONObject.has("recharge_discount_amounts")) {
                    String string = jSONObject.getString("recharge_discount_amounts");
                    if (!StringUtil.isEmpty(string, true)) {
                        this.rechargeDiscountAmounts = string.split(",");
                    }
                }
            }
        } catch (Throwable e) {
            LogX.e("parseMktInfoJson : " + Log.getStackTraceString(e));
        }
    }

    public final void parseReservedJson() {
        try {
            if (!StringUtil.isEmpty(this.reservedInfo, true)) {
                String string;
                JSONObject jSONObject = new JSONObject(this.reservedInfo);
                if (jSONObject.has("issuecard_recharge")) {
                    string = jSONObject.getString("issuecard_recharge");
                    if (!StringUtil.isEmpty(string, true)) {
                        this.issueCardRechargeAmounts = string.split(",");
                    }
                }
                if (jSONObject.has("common_recharge")) {
                    string = jSONObject.getString("common_recharge");
                    if (!StringUtil.isEmpty(string, true)) {
                        this.commonRechargeAmounts = string.split(",");
                    }
                }
                if (jSONObject.has("issuecard_std_cost")) {
                    this.issueCardStdCost = jSONObject.getInt("issuecard_std_cost");
                }
                if (jSONObject.has(SNBConstant.FIELD_CARD_ID)) {
                    string = jSONObject.getString(SNBConstant.FIELD_CARD_ID);
                    if (!StringUtil.isEmpty(string, true)) {
                        this.snbCardId = string;
                    }
                }
                if (jSONObject.has(SNBConstant.FIELD_CITY_BUS_CODE)) {
                    String string2 = jSONObject.getString(SNBConstant.FIELD_CITY_BUS_CODE);
                    if (!StringUtil.isEmpty(string2, true)) {
                        this.snbCityBusCode = string2;
                    }
                }
            }
        } catch (Throwable e) {
            LogX.e("parseReservedJson : " + Log.getStackTraceString(e));
        }
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_PRODUCT_ID, this.productId);
        contentValues.put("name", this.productName);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_PIC_URL, this.pictureUrl);
        contentValues.put("description", this.description);
        contentValues.put("card_type", Integer.valueOf(this.type));
        contentValues.put("timestamp", Long.valueOf(this.timeStamp));
        contentValues.put("version", this.version);
        contentValues.put("issuer_id", this.issuerId);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_MKT_INFO, this.mktInfo);
        contentValues.put("reserved_info", this.reservedInfo);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_FONT_COLOR, this.fontColor);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_RESERVD_1, this.reserved1);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_RESERVD_2, this.reserved2);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_RESERVD_3, this.reserved3);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_RESERVD_4, this.reserved4);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_RESERVD_5, this.reserved5);
        contentValues.put(CardProductInfoColumns.COLUMN_NAME_RESERVD_6, this.reserved6);
        return contentValues;
    }

    public String getFontColor() {
        return (String) C0978h.a(this.fontColor);
    }

    public void setFontColor(String str) {
        this.fontColor = (String) C0978h.a(str);
    }

    public String getReserved1() {
        return (String) C0978h.a(this.reserved1);
    }

    public void setReserved1(String str) {
        this.reserved1 = (String) C0978h.a(str);
    }

    public String getReserved2() {
        return (String) C0978h.a(this.reserved2);
    }

    public void setReserved2(String str) {
        this.reserved2 = (String) C0978h.a(str);
    }

    public String getReserved3() {
        return (String) C0978h.a(this.reserved3);
    }

    public void setReserved3(String str) {
        this.reserved3 = (String) C0978h.a(str);
    }

    public String getReserved4() {
        return (String) C0978h.a(this.reserved4);
    }

    public void setReserved4(String str) {
        this.reserved4 = (String) C0978h.a(str);
    }

    public String getReserved5() {
        return (String) C0978h.a(this.reserved5);
    }

    public void setReserved5(String str) {
        this.reserved5 = (String) C0978h.a(str);
    }

    public String getReserved6() {
        return (String) C0978h.a(this.reserved6);
    }

    public void setReserved6(String str) {
        this.reserved6 = (String) C0978h.a(str);
    }

    public String[] getRechargeDiscountAmounts() {
        Object obj;
        if (this.rechargeDiscountAmounts == null) {
            obj = null;
        } else {
            String[] strArr = (String[]) this.rechargeDiscountAmounts.clone();
        }
        return (String[]) GodClassUtil.commonFunc(obj);
    }

    public String[] getCommonRechargeAmounts() {
        Object obj;
        if (this.commonRechargeAmounts == null) {
            obj = null;
        } else {
            String[] strArr = (String[]) this.commonRechargeAmounts.clone();
        }
        return (String[]) GodClassUtil.commonFunc(obj);
    }

    public String getProductId() {
        return (String) C0978h.a(this.productId);
    }

    public void setProductId(String str) {
        this.productId = (String) C0978h.a(str);
    }

    public String getProductName() {
        return (String) C0978h.a(this.productName);
    }

    public void setProductName(String str) {
        this.productName = (String) C0978h.a(str);
    }

    public String getPictureUrl() {
        return (String) C0978h.a(this.pictureUrl);
    }

    public void setPictureUrl(String str) {
        this.pictureUrl = (String) C0978h.a(str);
    }

    public String getDescription() {
        return (String) C0978h.a(this.description);
    }

    public void setDescription(String str) {
        this.description = (String) C0978h.a(str);
    }

    public int getType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.type))).intValue();
    }

    public void setType(int i) {
        this.type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getTimeStamp() {
        return ((Long) C0978h.a(Long.valueOf(this.timeStamp))).longValue();
    }

    public void setTimeStamp(long j) {
        this.timeStamp = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public String getVersion() {
        return (String) C0978h.a(this.version);
    }

    public void setVersion(String str) {
        this.version = (String) C0978h.a(str);
    }

    public String getIssuerId() {
        return (String) C0978h.a(this.issuerId);
    }

    public void setIssuerId(String str) {
        this.issuerId = (String) C0978h.a(str);
    }

    public String getMktInfo() {
        return (String) C0978h.a(this.mktInfo);
    }

    public void setMktInfo(String str) {
        this.mktInfo = (String) C0978h.a(str);
    }

    public String getReservedInfo() {
        return (String) C0978h.a(this.reservedInfo);
    }

    public void setReservedInfo(String str) {
        this.reservedInfo = (String) C0978h.a(str);
    }

    public String[] getIssueCardRechargeAmounts() {
        return (String[]) C0978h.a(this.issueCardRechargeAmounts);
    }

    public void setIssueCardRechargeAmounts(String[] strArr) {
        this.issueCardRechargeAmounts = (String[]) C0978h.a(strArr);
    }

    public void setCommonRechargeAmounts(String[] strArr) {
        this.commonRechargeAmounts = (String[]) C0978h.a(strArr);
    }

    public String getIssueCardActCd() {
        return (String) C0978h.a(this.issueCardActCd);
    }

    public void setIssueCardActCd(String str) {
        this.issueCardActCd = (String) C0978h.a(str);
    }

    public int getIssueCardDiscountCost() {
        return ((Integer) C0978h.a(Integer.valueOf(this.issueCardDiscountCost))).intValue();
    }

    public void setIssueCardDiscountCost(int i) {
        this.issueCardDiscountCost = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getIssueCardStdCost() {
        return ((Integer) C0978h.a(Integer.valueOf(this.issueCardStdCost))).intValue();
    }

    public void setIssueCardStdCost(int i) {
        this.issueCardStdCost = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String getRechargeActCd() {
        return (String) C0978h.a(this.rechargeActCd);
    }

    public void setRechargeActCd(String str) {
        this.rechargeActCd = (String) C0978h.a(str);
    }

    public void setRechargeDiscountAmounts(String[] strArr) {
        this.rechargeDiscountAmounts = (String[]) C0978h.a(strArr);
    }

    public String getSnbCardId() {
        return (String) C0978h.a(this.snbCardId);
    }

    public void setSnbCardId(String str) {
        this.snbCardId = (String) C0978h.a(str);
    }

    public String getSnbCityBusCode() {
        return (String) C0978h.a(this.snbCityBusCode);
    }

    public void setSnbCityBusCode(String str) {
        this.snbCityBusCode = (String) C0978h.a(str);
    }

    public List<String> getReservedNField() {
        List arrayList = new ArrayList();
        addString(this.reserved1, arrayList);
        addString(this.reserved2, arrayList);
        addString(this.reserved3, arrayList);
        addString(this.reserved4, arrayList);
        addString(this.reserved5, arrayList);
        addString(this.reserved6, arrayList);
        return arrayList;
    }

    private void addString(String str, ArrayList<String> arrayList) {
        if (!StringUtil.isEmpty(str, true)) {
            arrayList.add(str);
        }
    }
}
