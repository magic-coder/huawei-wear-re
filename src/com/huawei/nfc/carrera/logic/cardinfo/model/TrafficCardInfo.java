package com.huawei.nfc.carrera.logic.cardinfo.model;

import android.graphics.Bitmap;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.util.GodClassUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrafficCardInfo {
    public static final int BUSCARD_NOT_SUPPORT_DELETE = 0;
    public static final int BUSCARD_SUPPORT_DELETE = 1;
    private String agreementUrl;
    private String aid;
    private Bitmap cardIcon;
    private Bitmap cardLogo;
    private String contactHuaweiNum;
    private int isSupportDelete;
    public List<IssueMoney> issueAmounts = new ArrayList();
    private String licUrl;
    private int mode;
    private String name;
    private String proUrl;
    private String productCode;
    private String productDesc;
    public List<RechargeMoney> rechargeAmounts = new ArrayList();
    private boolean wxLedger = false;
    private boolean wxPaySupport = false;

    public void clearRechargeAmounts() {
        this.rechargeAmounts.clear();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAid() {
        return (String) GodClassUtil.commonFunc(this.aid);
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getLicUrl() {
        return this.licUrl;
    }

    public void setLicUrl(String str) {
        this.licUrl = str;
    }

    public String getProUrl() {
        return this.proUrl;
    }

    public void setProUrl(String str) {
        this.proUrl = str;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductDesc(String str) {
        this.productDesc = str;
    }

    public Bitmap getCardIcon() {
        return this.cardIcon;
    }

    public void setCardIcon(Bitmap bitmap) {
        this.cardIcon = bitmap;
    }

    public Bitmap getCardLogo() {
        return this.cardLogo;
    }

    public void setCardLogo(Bitmap bitmap) {
        this.cardLogo = bitmap;
    }

    public String getAgreementUrl() {
        return this.agreementUrl;
    }

    public void setAgreementUrl(String str) {
        this.agreementUrl = str;
    }

    public int getIsSupportDelete() {
        return this.isSupportDelete;
    }

    public void setIsSupportDelete(int i) {
        this.isSupportDelete = i;
    }

    public static int getBuscardNotSupportDelete() {
        return 0;
    }

    public static int getBuscardSupportDelete() {
        return 1;
    }

    public String getContactHuaweiNum() {
        return this.contactHuaweiNum;
    }

    public void setContactHuaweiNum(String str) {
        this.contactHuaweiNum = str;
    }

    public List<IssueMoney> getIssueAmounts() {
        return this.issueAmounts;
    }

    public void setIssueAmounts(List<IssueMoney> list) {
        this.issueAmounts = list;
    }

    public List<RechargeMoney> getRechargeAmounts() {
        return (List) GodClassUtil.commonFunc(this.rechargeAmounts);
    }

    public void setRechargeAmounts(List<RechargeMoney> list) {
        this.rechargeAmounts = list;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public boolean isWxPaySupport() {
        return this.wxPaySupport;
    }

    public void setWxPaySupport(boolean z) {
        this.wxPaySupport = z;
    }

    public TrafficCardInfo(IssuerInfoItem issuerInfoItem, CardProductInfoItem cardProductInfoItem) {
        this.name = issuerInfoItem.getName();
        this.aid = issuerInfoItem.getAid();
        this.licUrl = issuerInfoItem.getDebitTcUrl();
        this.proUrl = issuerInfoItem.getCreditTcUrl();
        this.agreementUrl = issuerInfoItem.getBusAgreementUrl();
        this.productDesc = cardProductInfoItem.getDescription();
        this.contactHuaweiNum = issuerInfoItem.getContactNumber();
        this.isSupportDelete = issuerInfoItem.getIsSupportDelete();
        this.mode = issuerInfoItem.getMode();
        this.wxLedger = issuerInfoItem.isWxLedgerSupport();
        this.wxPaySupport = issuerInfoItem.isWxPaySupport();
        parseIssueMoney(cardProductInfoItem.getIssueCardRechargeAmounts(), (double) cardProductInfoItem.getIssueCardStdCost(), (double) cardProductInfoItem.getIssueCardDiscountCost());
        parseRechargeMoney(cardProductInfoItem.getCommonRechargeAmounts(), cardProductInfoItem.getRechargeDiscountAmounts());
    }

    private void parseIssueMoney(String[] strArr, double d, double d2) {
        if (strArr == null || strArr.length <= 0) {
            LogX.d("parseRechargeMoney input param is not illegal.issueAmounts");
            return;
        }
        this.issueAmounts.clear();
        for (String str : strArr) {
            IssueMoney issueMoney = new IssueMoney();
            issueMoney.setIssueStdMoney(d);
            issueMoney.setIssueMoney(d2);
            try {
                issueMoney.setPayMoney(Double.parseDouble(str));
                issueMoney.setRechargeMoney(issueMoney.getPayMoney() - issueMoney.getIssueMoney());
                this.issueAmounts.add(issueMoney);
            } catch (NumberFormatException e) {
                LogX.w("parseRechargeMoney amount is not number. amount = " + str + " issueCardCost = " + d);
            }
        }
    }

    private void parseRechargeMoney(String[] strArr, String[] strArr2) {
        int i = 1;
        int i2 = 0;
        if (strArr == null || strArr.length <= 0) {
            LogX.d("parseRechargeMoney input param is not illegal.rechargeStdMoney");
            return;
        }
        int i3 = (strArr2 == null || strArr2.length <= 0) ? 1 : 0;
        if (strArr2 == null || strArr2.length == strArr.length) {
            i = 0;
        }
        if (i != 0) {
            LogX.w("parseRechargeMoney : discount amounts info is not illegal.StdMoney = " + Arrays.toString(strArr) + " DiscountMoney = " + Arrays.toString(strArr2));
        }
        this.rechargeAmounts.clear();
        while (i2 < strArr.length) {
            RechargeMoney rechargeMoney = new RechargeMoney();
            double parseDouble = Double.parseDouble(strArr[i2]);
            double parseDouble2 = (i3 == 0 && i == 0) ? Double.parseDouble(strArr2[i2]) : 0.0d;
            if (parseDouble < 0.0d || parseDouble2 < 0.0d) {
                LogX.w("parseIssueMoney amount is not a number.rechargeStdMoney = " + Arrays.toString(strArr) + " rechargeDiscountMoney = " + Arrays.toString(strArr2));
            } else {
                rechargeMoney.setRechargeMoney(parseDouble);
                rechargeMoney.setPayMoney(parseDouble2);
                this.rechargeAmounts.add(rechargeMoney);
                LogX.w("parseIssueMoney amount rechargeMoney" + parseDouble + " ---payMoney--- " + parseDouble2);
            }
            i2++;
        }
    }

    public String toString() {
        return "TrafficCardInfo{name='" + this.name + '\'' + ", aid='" + this.aid + '\'' + ", licUrl='" + this.licUrl + '\'' + ", proUrl='" + this.proUrl + '\'' + ", productDesc='" + this.productDesc + '\'' + ", cardIcon=" + this.cardIcon + ", cardLogo=" + this.cardLogo + ", agreementUrl='" + this.agreementUrl + '\'' + ", isSupportDelete=" + this.isSupportDelete + ", contactHuaweiNum='" + this.contactHuaweiNum + '\'' + ", issueAmounts=" + this.issueAmounts + ", rechargeAmounts=" + this.rechargeAmounts + '}';
    }

    public boolean isWxLedger() {
        return this.wxLedger;
    }

    public void setWxLedger(boolean z) {
        this.wxLedger = z;
    }

    public void trafficCardInfoSai1() {
    }

    public void trafficCardInfoSai2() {
    }

    public void trafficCardInfoSai3() {
    }

    public void trafficCardInfoSai4() {
    }

    public void trafficCardInfoSai5() {
    }

    public void trafficCardInfoSai6() {
    }

    public void trafficCardInfoSai7() {
    }

    public void trafficCardInfoSai8() {
    }

    public void trafficCardInfoSai9() {
    }
}
