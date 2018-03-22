package com.huawei.nfc.carrera.logic.dbmanager;

import android.content.ContentValues;
import android.util.Log;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.model.AppInfo;
import com.huawei.nfc.carrera.server.card.response.IssuerInfoServerItem;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IssuerInfoItem {
    private static final String TAG = IssuerInfoItem.class.getSimpleName();
    private String aid;
    private String appInfo;
    private List<AppInfo> appInfos;
    private String bankAgreementTitle;
    private String bankAgreementUrl;
    private String busAgreementUrl;
    private String contactNumber;
    private String creditCallCenterNumber;
    private String creditTcUrl;
    private String creditTermsTitle;
    private String creditTermsUrl;
    private String creditWebsite;
    private String debitCallCenterNumber;
    private String debitTcUrl;
    private String debitTermsTitle;
    private String debitTermsUrl;
    private String debitWebsite;
    private String description;
    private int isSupportDelete = 0;
    private String issuerId;
    private int issuerType;
    private String logoUrl;
    private double minRechargeAmount;
    private int mode;
    private String name;
    private String productId;
    private String reservedInfo;
    private int sn;
    private String supportBusFlag;
    private int supportType;
    private long timeStamp;
    private int walletVersion;
    private boolean wxLedgerSupport = false;
    private boolean wxPaySupport = false;

    public IssuerInfoItem(IssuerInfoServerItem issuerInfoServerItem) {
        this.issuerId = issuerInfoServerItem.getIssuerId();
        this.name = issuerInfoServerItem.getName();
        this.description = issuerInfoServerItem.getDescription();
        this.logoUrl = issuerInfoServerItem.getLogoUrl();
        this.issuerType = issuerInfoServerItem.getIssuerType();
        this.supportType = issuerInfoServerItem.getSupportType();
        this.mode = issuerInfoServerItem.getMode();
        try {
            this.walletVersion = Integer.parseInt(issuerInfoServerItem.getWalletVersion());
        } catch (NumberFormatException e) {
            this.walletVersion = 0;
        }
        this.contactNumber = issuerInfoServerItem.getContactNumber();
        this.debitCallCenterNumber = issuerInfoServerItem.getDebitCallCenterNumber();
        this.creditCallCenterNumber = issuerInfoServerItem.getCreditCallCenterNumber();
        this.debitTcUrl = issuerInfoServerItem.getDebitTcUrl();
        this.creditTcUrl = issuerInfoServerItem.getCreditTcUrl();
        this.debitWebsite = issuerInfoServerItem.getDebitWebsite();
        this.creditWebsite = issuerInfoServerItem.getCreditWebsite();
        this.timeStamp = issuerInfoServerItem.getTimeStamp();
        this.appInfo = issuerInfoServerItem.getAppInfo();
        this.reservedInfo = issuerInfoServerItem.getReservedInfo();
        this.sn = issuerInfoServerItem.getSn();
        parseReservedJson();
        parseAppInfoJson();
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("issuer_id", this.issuerId);
        contentValues.put("name", this.name);
        contentValues.put("description", this.description);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_LOGO_URL, this.logoUrl);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_ISSUER_TYPE, Integer.valueOf(this.issuerType));
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_SUPPORT_CARD_TYPE, Integer.valueOf(this.supportType));
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_MODE, Integer.valueOf(this.mode));
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_APK_VERSION, Integer.valueOf(this.walletVersion));
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_CONTACT_NUM, this.contactNumber);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_DEBIT_CALL_NUM, this.debitCallCenterNumber);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_CREDIT_CALL_NUM, this.creditCallCenterNumber);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_DEBITTC_URL, this.debitTcUrl);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_CREDITTC_URL, this.creditTcUrl);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_CREDIT_WEBSITE_URL, this.creditWebsite);
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_DEBIT_WEBSITE_URL, this.debitWebsite);
        contentValues.put("timestamp", Long.valueOf(this.timeStamp));
        contentValues.put(IssuerInfoColumns.COLUMN_NAME_APPINFO, this.appInfo);
        contentValues.put("reserved_info", this.reservedInfo);
        contentValues.put("sn", Integer.valueOf(this.sn));
        return contentValues;
    }

    public final void parseReservedJson() {
        try {
            if (!StringUtil.isEmpty(this.reservedInfo, true)) {
                JSONObject jSONObject = new JSONObject(this.reservedInfo);
                if (jSONObject.has("credit_terms_title")) {
                    this.creditTermsTitle = jSONObject.getString("credit_terms_title");
                }
                if (jSONObject.has("credit_terms_url")) {
                    this.creditTermsUrl = jSONObject.getString("credit_terms_url");
                }
                if (jSONObject.has("debit_terms_title")) {
                    this.debitTermsTitle = jSONObject.getString("debit_terms_title");
                }
                if (jSONObject.has("debit_terms_url")) {
                    this.debitTermsUrl = jSONObject.getString("debit_terms_url");
                }
                if (jSONObject.has("bank_agreement_title")) {
                    this.bankAgreementTitle = jSONObject.getString("bank_agreement_title");
                }
                if (jSONObject.has("bank_agreement_url")) {
                    this.bankAgreementUrl = jSONObject.getString("bank_agreement_url");
                }
                if (jSONObject.has("aid")) {
                    this.aid = jSONObject.getString("aid");
                }
                if (jSONObject.has("productId")) {
                    this.productId = jSONObject.getString("productId");
                }
                if (jSONObject.has(CardAndIssuerInfoCache.BUS_DIC_NAME)) {
                    this.supportBusFlag = jSONObject.getString(CardAndIssuerInfoCache.BUS_DIC_NAME);
                }
                if (jSONObject.has("bus_agreement_url")) {
                    this.busAgreementUrl = jSONObject.getString("bus_agreement_url");
                }
                if (jSONObject.has("min_recharge_amount")) {
                    this.minRechargeAmount = jSONObject.getDouble("min_recharge_amount");
                }
                if (jSONObject.has("is_support_delete")) {
                    this.isSupportDelete = jSONObject.getInt("is_support_delete");
                }
                if (jSONObject.has("wxledger_support")) {
                    this.wxLedgerSupport = jSONObject.getBoolean("wxledger_support");
                }
                if (jSONObject.has("wxpay_support")) {
                    this.wxPaySupport = jSONObject.getBoolean("wxpay_support");
                }
            }
        } catch (Throwable e) {
            LogX.e("parseReservedJson : " + Log.getStackTraceString(e));
        }
    }

    public final void parseAppInfoJson() {
        try {
            C2538c.b(TAG, new Object[]{this.appInfo});
            if (!StringUtil.isEmpty(this.appInfo, true)) {
                LogX.d("parseAppInfoJson." + this.appInfo);
                JSONArray jSONArray = new JSONObject(this.appInfo).getJSONArray("appInfoList");
                if (jSONArray != null && jSONArray.length() > 0) {
                    this.appInfos = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            AppInfo appInfo = new AppInfo();
                            if (jSONObject.has("issuer_app_pkg")) {
                                appInfo.setIssuerAppPkg(jSONObject.getString("issuer_app_pkg"));
                            }
                            if (jSONObject.has("issuer_app_appId")) {
                                appInfo.setIssuerAppMarketId(jSONObject.getString("issuer_app_appId"));
                            }
                            if (jSONObject.has("supportType")) {
                                appInfo.setSupportType(jSONObject.getInt("supportType"));
                            }
                            if (jSONObject.has("apk_icon_url")) {
                                appInfo.setApkIconUrl(jSONObject.getString("apk_icon_url"));
                            }
                            if (jSONObject.has("apk_name")) {
                                appInfo.setApkName(jSONObject.getString("apk_name"));
                            }
                            this.appInfos.add(appInfo);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            LogX.e("parseReservedJson JSONException ");
        }
    }

    public String getIssuerId() {
        return (String) C0978h.a(this.issuerId);
    }

    public void setIssuerId(String str) {
        this.issuerId = (String) C0978h.a(str);
    }

    public String getName() {
        return (String) C0978h.a(this.name);
    }

    public void setName(String str) {
        this.name = (String) C0978h.a(str);
    }

    public String getDescription() {
        return (String) C0978h.a(this.description);
    }

    public void setDescription(String str) {
        this.description = (String) C0978h.a(str);
    }

    public String getLogoUrl() {
        return (String) C0978h.a(this.logoUrl);
    }

    public void setLogoUrl(String str) {
        this.logoUrl = (String) C0978h.a(str);
    }

    public int getIssuerType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.issuerType))).intValue();
    }

    public void setIssuerType(int i) {
        this.issuerType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSupportType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.supportType))).intValue();
    }

    public void setSupportType(int i) {
        this.supportType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getMode() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mode))).intValue();
    }

    public void setMode(int i) {
        this.mode = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWalletVersion() {
        return ((Integer) C0978h.a(Integer.valueOf(this.walletVersion))).intValue();
    }

    public void setWalletVersion(int i) {
        this.walletVersion = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String getContactNumber() {
        return (String) C0978h.a(this.contactNumber);
    }

    public void setContactNumber(String str) {
        this.contactNumber = (String) C0978h.a(str);
    }

    public String getDebitCallCenterNumber() {
        return (String) C0978h.a(this.debitCallCenterNumber);
    }

    public void setDebitCallCenterNumber(String str) {
        this.debitCallCenterNumber = (String) C0978h.a(str);
    }

    public String getCreditCallCenterNumber() {
        return (String) C0978h.a(this.creditCallCenterNumber);
    }

    public void setCreditCallCenterNumber(String str) {
        this.creditCallCenterNumber = (String) C0978h.a(str);
    }

    public String getDebitTcUrl() {
        return (String) C0978h.a(this.debitTcUrl);
    }

    public void setDebitTcUrl(String str) {
        this.debitTcUrl = (String) C0978h.a(str);
    }

    public String getCreditTcUrl() {
        return (String) C0978h.a(this.creditTcUrl);
    }

    public void setCreditTcUrl(String str) {
        this.creditTcUrl = (String) C0978h.a(str);
    }

    public long getTimeStamp() {
        return ((Long) C0978h.a(Long.valueOf(this.timeStamp))).longValue();
    }

    public void setTimeStamp(long j) {
        this.timeStamp = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public String getAppInfo() {
        return (String) C0978h.a(this.appInfo);
    }

    public void setAppInfo(String str) {
        this.appInfo = (String) C0978h.a(str);
    }

    public String getReservedInfo() {
        return (String) C0978h.a(this.reservedInfo);
    }

    public void setReservedInfo(String str) {
        this.reservedInfo = (String) C0978h.a(str);
    }

    public String getCreditTermsTitle() {
        return (String) C0978h.a(this.creditTermsTitle);
    }

    public void setCreditTermsTitle(String str) {
        this.creditTermsTitle = (String) C0978h.a(str);
    }

    public String getCreditTermsUrl() {
        return (String) C0978h.a(this.creditTermsUrl);
    }

    public void setCreditTermsUrl(String str) {
        this.creditTermsUrl = (String) C0978h.a(str);
    }

    public String getDebitTermsTitle() {
        return (String) C0978h.a(this.debitTermsTitle);
    }

    public void setDebitTermsTitle(String str) {
        this.debitTermsTitle = (String) C0978h.a(str);
    }

    public String getDebitTermsUrl() {
        return (String) C0978h.a(this.debitTermsUrl);
    }

    public void setDebitTermsUrl(String str) {
        this.debitTermsUrl = (String) C0978h.a(str);
    }

    public String getDebitWebsite() {
        return (String) C0978h.a(this.debitWebsite);
    }

    public void setDebitWebsite(String str) {
        this.debitWebsite = (String) C0978h.a(str);
    }

    public String getCreditWebsite() {
        return (String) C0978h.a(this.creditWebsite);
    }

    public void setCreditWebsite(String str) {
        this.creditWebsite = (String) C0978h.a(str);
    }

    public String getBankAgreementTitle() {
        return (String) C0978h.a(this.bankAgreementTitle);
    }

    public void setBankAgreementTitle(String str) {
        this.bankAgreementTitle = (String) C0978h.a(str);
    }

    public String getBankAgreementUrl() {
        return (String) C0978h.a(this.bankAgreementUrl);
    }

    public void setBankAgreementUrl(String str) {
        this.bankAgreementUrl = (String) C0978h.a(str);
    }

    public String getAid() {
        return (String) C0978h.a(this.aid);
    }

    public void setAid(String str) {
        this.aid = (String) C0978h.a(str);
    }

    public String getProductId() {
        return (String) C0978h.a(this.productId);
    }

    public void setProductId(String str) {
        this.productId = (String) C0978h.a(str);
    }

    public List<AppInfo> getAppInfos() {
        return (List) C0978h.a(this.appInfos);
    }

    public void setAppInfos(List<AppInfo> list) {
        this.appInfos = (List) C0978h.a(list);
    }

    public String getSupportBusFlag() {
        return (String) C0978h.a(this.supportBusFlag);
    }

    public void setSupportBusFlag(String str) {
        this.supportBusFlag = (String) C0978h.a(str);
    }

    public String getBusAgreementUrl() {
        return (String) C0978h.a(this.busAgreementUrl);
    }

    public void setBusAgreementUrl(String str) {
        this.busAgreementUrl = (String) C0978h.a(str);
    }

    public int getSn() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sn))).intValue();
    }

    public void setSn(int i) {
        this.sn = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public double getMinRechargeAmount() {
        return ((Double) C0978h.a(Double.valueOf(this.minRechargeAmount))).doubleValue();
    }

    public void setMinRechargeAmount(double d) {
        this.minRechargeAmount = ((Double) C0978h.a(Double.valueOf(d))).doubleValue();
    }

    public int getIsSupportDelete() {
        return ((Integer) C0978h.a(Integer.valueOf(this.isSupportDelete))).intValue();
    }

    public void setIsSupportDelete(int i) {
        this.isSupportDelete = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public boolean isWxLedgerSupport() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.wxLedgerSupport))).booleanValue();
    }

    public void setWxLedgerSupport(boolean z) {
        this.wxLedgerSupport = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean isWxPaySupport() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.wxPaySupport))).booleanValue();
    }

    public void setWxPaySupport(boolean z) {
        this.wxPaySupport = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }
}
