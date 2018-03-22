package com.huawei.nfc.carrera.logic.appletcardinfo.impl;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.appletcardinfo.AppletCardInfoReadApi;
import com.huawei.nfc.carrera.logic.appletcardinfo.configdata.ConfigData;
import com.huawei.nfc.carrera.logic.appletcardinfo.configdata.ConfigDataManager;
import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.TransactionRecord;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.appletcardinfo.traffic.TrafficCardInfoReader;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.nfc.carrera.logic.oma.OmaApduManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.List;

public class AppletCardInfoReader implements AppletCardInfoReadApi {
    private static final String TAG = "AppletCardInfo";
    private ConfigData configData = ConfigDataManager.getInstance(this.mContext);
    private Context mContext;
    private IOmaService omaService = OmaApduManager.getInstance(this.mContext);
    private TrafficCardInfoReader tCardInfoReader = new TrafficCardInfoReader(this.omaService, this.configData);

    public AppletCardInfoReader(Context context) {
        this.mContext = context;
    }

    public AppletCardResult<CardInfo> readTrafficCardInfo(String str, String str2, int i) {
        C2538c.c(TAG, new Object[]{" readTrafficCardInfo begin"});
        AppletCardResult<CardInfo> appletCardResult = new AppletCardResult();
        try {
            appletCardResult.setData(this.tCardInfoReader.readCardInfo(str, str2, i));
        } catch (AppletCardException e) {
            this.tCardInfoReader.closeChannel();
            appletCardResult.setResultCode(e.getErrCode());
            appletCardResult.setMsg(e.getMessage());
            reportErrorInfo(str, str2, "readTrafficCardInfo", AutoReportErrorCode.ERROR_EVENT_ID_NFC_ESE_GET_TRAFFIC_CARD_INFO_FAIL, appletCardResult);
        }
        C2538c.c(TAG, new Object[]{" readTrafficCardInfo end. result : " + appletCardResult.getResultCode()});
        return appletCardResult;
    }

    public AppletCardResult<List<TransactionRecord>> readTrafficCardTransactionRecord(String str, String str2) {
        C2538c.c(TAG, new Object[]{" readTrafficCardTransactionRecord begin"});
        AppletCardResult<List<TransactionRecord>> appletCardResult = new AppletCardResult();
        try {
            appletCardResult.setData(this.tCardInfoReader.readTransactionRecords(str, str2));
        } catch (AppletCardException e) {
            this.tCardInfoReader.closeChannel();
            appletCardResult.setResultCode(e.getErrCode());
            appletCardResult.setMsg(e.getMessage());
            reportErrorInfo(str, str2, "readTrafficCardTransactionRecord", AutoReportErrorCode.ERROR_EVENT_ID_NFC_ESE_GET_TRAFFIC_CARD_TRADE_RECORD_FAIL, appletCardResult);
        }
        C2538c.c(TAG, new Object[]{" readTrafficCardTransactionRecord end. result : " + appletCardResult.getResultCode()});
        return appletCardResult;
    }

    private void reportErrorInfo(String str, String str2, String str3, int i, AppletCardResult appletCardResult) {
        HashMap hashMap = new HashMap();
        String str4 = str3 + HwAccountConstants.BLANK + appletCardResult.getPrintMsg();
        hashMap.put("aid", str);
        hashMap.put("productId", str2);
        hashMap.put("data_type", str3);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(appletCardResult.getResultCode()));
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str4);
        C2538c.e(TAG, new Object[]{"" + i + hashMap + str4});
    }
}
