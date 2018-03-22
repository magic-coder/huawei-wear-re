package com.huawei.nfc.carrera.logic.lostmanager.report;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.lostmanager.report.dbmanager.ReportStatusItem;
import com.huawei.nfc.carrera.util.LogX;

public class ReportCardStatusTask extends ReportStatusBaseTask implements Runnable {
    public static final String CARD_STATUS_DELETED = "6";
    public static final String CARD_STATUS_LOCKED = "3";
    public static final String CARD_STATUS_NOT_ACTIVED = "7";
    public static final String CARD_STATUS_OPENED = "0";
    private final String curAid;
    private boolean ifNotify = false;
    private final String mCardName;
    private final String mCardNumber;
    private final String mCardStatus;
    private int mCardType;
    private final String mDpanid;
    private String mIssuerID;

    public ReportCardStatusTask(Context context, String str, String str2, String str3, String str4, String str5) {
        super(context);
        this.curAid = str;
        this.mCardStatus = str2;
        this.mDpanid = str3;
        this.mCardName = str4;
        this.mCardNumber = str5;
    }

    public ReportCardStatusTask(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
        super(context);
        this.curAid = str;
        this.mCardStatus = str2;
        this.mDpanid = str3;
        this.mCardName = str4;
        this.mCardNumber = str5;
        this.ifNotify = z;
    }

    public ReportCardStatusTask(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        super(context);
        this.curAid = str;
        this.mCardStatus = str2;
        this.mDpanid = str3;
        this.mCardName = str4;
        this.mCardNumber = str5;
        this.mIssuerID = str6;
        this.mCardType = i;
    }

    public void run() {
        String queryAccountUserId = queryAccountUserId();
        updateDBStatus(this.curAid, this.mCardStatus, queryAccountUserId, this.mDpanid, this.mCardName, this.mCardNumber, this.mIssuerID, this.mCardType, this.ifNotify);
        if (reportStatusToServer(this.curAid, this.mCardStatus, queryAccountUserId, this.mDpanid, this.mCardName, this.mCardNumber, this.mIssuerID, this.mCardType, this.ifNotify)) {
            removeDBStatusItem(this.curAid);
        }
    }

    private String queryAccountUserId() {
        String userID = ((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID();
        LogX.i("reportCardOpenedAvailableStatus, userid: " + userID);
        return userID;
    }

    private void updateDBStatus(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z) {
        ReportStatusItem reportStatusItem = new ReportStatusItem();
        reportStatusItem.setAid(str);
        reportStatusItem.setCardStatus(str2);
        reportStatusItem.setUserId(str3);
        reportStatusItem.setDpanId(str4);
        reportStatusItem.setCardName(str5);
        reportStatusItem.setCardNumber(str6);
        reportStatusItem.setIssuerID(str7);
        reportStatusItem.setCardType(i);
        reportStatusItem.setIfNotify(z);
        this.reportStatusDBManager.insertOrUpdateOneCardReportInfo(reportStatusItem);
    }
}
