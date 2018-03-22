package com.huawei.nfc.carrera.logic.cardinfo.model;

import android.graphics.Bitmap;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.model.AppInfo;
import java.util.List;

public class BankIssuerInfo {
    private List<AppInfo> appInfos;
    private String bankAgreementTitle;
    private String bankAgreementUrl;
    private String contactNumber;
    private String crebitContactNumber;
    private String creditTcUrl;
    private String creditTermsTitle;
    private String creditTermsUrl;
    private String creditWebsite;
    private String debitContactNumber;
    private String debitTcUrl;
    private String debitTermsTitle;
    private String debitTermsUrl;
    private String debitWebsite;
    private String issuerName;
    private Bitmap logoIcon;
    private int mode;

    public BankIssuerInfo(IssuerInfoItem issuerInfoItem) {
        this.issuerName = issuerInfoItem.getName();
        this.mode = issuerInfoItem.getMode();
        this.creditTcUrl = issuerInfoItem.getCreditTcUrl();
        this.debitTcUrl = issuerInfoItem.getDebitTcUrl();
        this.debitTermsTitle = issuerInfoItem.getDebitTermsTitle();
        this.debitTermsUrl = issuerInfoItem.getDebitTermsUrl();
        this.creditTermsTitle = issuerInfoItem.getCreditTermsTitle();
        this.creditTermsUrl = issuerInfoItem.getCreditTermsUrl();
        this.bankAgreementTitle = issuerInfoItem.getBankAgreementTitle();
        this.bankAgreementUrl = issuerInfoItem.getBankAgreementUrl();
        this.contactNumber = issuerInfoItem.getContactNumber();
        this.debitContactNumber = issuerInfoItem.getDebitCallCenterNumber();
        this.crebitContactNumber = issuerInfoItem.getCreditCallCenterNumber();
        this.appInfos = issuerInfoItem.getAppInfos();
        this.creditWebsite = issuerInfoItem.getCreditWebsite();
        this.debitWebsite = issuerInfoItem.getDebitWebsite();
    }

    public String getIssuerName() {
        return this.issuerName;
    }

    public void setIssuerName(String str) {
        this.issuerName = str;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public String getDebitTermsUrl() {
        return this.debitTermsUrl;
    }

    public void setDebitTermsUrl(String str) {
        this.debitTermsUrl = str;
    }

    public String getCreditTermsTitle() {
        return this.creditTermsTitle;
    }

    public void setCreditTermsTitle(String str) {
        this.creditTermsTitle = str;
    }

    public String getCreditTermsUrl() {
        return this.creditTermsUrl;
    }

    public void setCreditTermsUrl(String str) {
        this.creditTermsUrl = str;
    }

    public String getBankAgreementTitle() {
        return this.bankAgreementTitle;
    }

    public void setBankAgreementTitle(String str) {
        this.bankAgreementTitle = str;
    }

    public String getBankAgreementUrl() {
        return this.bankAgreementUrl;
    }

    public void setBankAgreementUrl(String str) {
        this.bankAgreementUrl = str;
    }

    public Bitmap getLogoIcon() {
        return this.logoIcon;
    }

    public void setLogoIcon(Bitmap bitmap) {
        this.logoIcon = bitmap;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String str) {
        this.contactNumber = str;
    }

    public String getDebitContactNumber() {
        return this.debitContactNumber;
    }

    public void setDebitContactNumber(String str) {
        this.debitContactNumber = str;
    }

    public String getCrebitContactNumber() {
        return this.crebitContactNumber;
    }

    public void setCrebitContactNumber(String str) {
        this.crebitContactNumber = str;
    }

    public List<AppInfo> getAppInfos() {
        return this.appInfos;
    }

    public void setAppInfos(List<AppInfo> list) {
        this.appInfos = list;
    }

    public String getDebitWebsite() {
        return this.debitWebsite;
    }

    public void setDebitWebsite(String str) {
        this.debitWebsite = str;
    }

    public String getCreditWebsite() {
        return this.creditWebsite;
    }

    public void setCreditWebsite(String str) {
        this.creditWebsite = str;
    }

    public String getCreditTcUrl() {
        return this.creditTcUrl;
    }

    public void setCreditTcUrl(String str) {
        this.creditTcUrl = str;
    }

    public String getDebitTcUrl() {
        return this.debitTcUrl;
    }

    public void setDebitTcUrl(String str) {
        this.debitTcUrl = str;
    }

    public String getDebitTermsTitle() {
        return this.debitTermsTitle;
    }

    public void setDebitTermsTitle(String str) {
        this.debitTermsTitle = str;
    }
}
