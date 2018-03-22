package com.huawei.nfc.carrera.logic.lostmanager.report;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.report.dbmanager.ReportStatusDBManager;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.CardStatusReportRequest;
import com.huawei.nfc.carrera.server.card.request.DeviceStatusReportRequest;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.utils.PackageUtil;
import java.util.HashMap;
import java.util.Map;

class ReportStatusBaseTask {
    public static final String KEY_DEVICE_STATUS = "device_status";
    protected Context mContext;
    protected ReportStatusDBManager reportStatusDBManager = new ReportStatusDBManager(this.mContext);

    public ReportStatusBaseTask(Context context) {
        this.mContext = context;
    }

    protected boolean reportStatusToServer(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z) {
        CardStatusReportRequest cardStatusReportRequest = new CardStatusReportRequest();
        cardStatusReportRequest.setAid(str);
        cardStatusReportRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
        cardStatusReportRequest.setTerminal(ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceModel());
        cardStatusReportRequest.setUserID(str3);
        cardStatusReportRequest.setStatus(str2);
        cardStatusReportRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardStatusReportRequest.setRsaKeyIndex(-1);
        cardStatusReportRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        cardStatusReportRequest.setImei(ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceSN());
        cardStatusReportRequest.setDpanid(str4);
        cardStatusReportRequest.setCardName(str5);
        cardStatusReportRequest.setCardNumber(str6);
        cardStatusReportRequest.setIfNotify(z);
        if ("0".equals(str2)) {
            cardStatusReportRequest.setWalletVersion("" + PackageUtil.m28462b(this.mContext));
            cardStatusReportRequest.setIssuerId(str7);
            cardStatusReportRequest.setCardType(i);
        }
        CardServerBaseResponse reportCardStatus = ServerServiceFactory.createCardServerApi(this.mContext).reportCardStatus(cardStatusReportRequest);
        if (reportCardStatus == null) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "reportStatusToServer, get illegal response.");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_REPORT_STATUS_ERR, hashMap, null, false, false);
            return false;
        }
        LogX.d("reportStatusToServer, response code: " + reportCardStatus.returnCode);
        if (reportCardStatus.returnCode == 0) {
            return true;
        }
        Map hashMap2 = new HashMap();
        hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "reportStatusToServer, get error response code : " + reportCardStatus.returnCode);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_REPORT_STATUS_ERR, hashMap2, null, false, false);
        return false;
    }

    protected void removeDBStatusItem(String str) {
        this.reportStatusDBManager.removeOneReportStatusInfo(str);
    }

    protected boolean reportStatusToServer(String str) {
        LogX.i("sendRequestToServer : type : " + str);
        DeviceStatusReportRequest deviceStatusReportRequest = new DeviceStatusReportRequest();
        deviceStatusReportRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        deviceStatusReportRequest.setRsaKeyIndex(-1);
        deviceStatusReportRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        deviceStatusReportRequest.reportDeviceInfo = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        deviceStatusReportRequest.status = str;
        CardServerBaseResponse reportDeviceStatus = ServerServiceFactory.createCardServerApi(this.mContext).reportDeviceStatus(deviceStatusReportRequest);
        if (reportDeviceStatus == null) {
            return false;
        }
        LogX.i("send repair result to server result: " + reportDeviceStatus.returnCode);
        if (reportDeviceStatus.returnCode == 0) {
            return true;
        }
        return false;
    }

    protected void updateDeviceStatus(String str) {
        NFCPreferences.getInstance(this.mContext).putString("device_status", str);
    }

    protected void removeDeviceStatus() {
        NFCPreferences.getInstance(this.mContext).remove("device_status");
    }
}
