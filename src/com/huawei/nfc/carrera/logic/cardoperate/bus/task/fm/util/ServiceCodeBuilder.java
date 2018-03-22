package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.util;

import android.content.Context;
import cn.com.fmsh.util.FM_Bytes;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.CardServerBaseRequest;
import com.huawei.nfc.carrera.server.card.response.SignDataResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public abstract class ServiceCodeBuilder {
    private static final String SEPERATOR = "|";
    private static final int SERVICE_DATA_LEN = 14;
    public static final int SERVICE_TYPE_ACT_ISSUE = 1;
    public static final int SERVICE_TYPE_ACT_RECHARGE = 2;
    public static final int SERVICE_TYPE_MANAGE_DELETE = 4;
    public static final int SERVICE_TYPE_MANAGE_MOVE = 3;
    private static final String SIGN_TYPE_RSA256 = "RSA256";
    protected Context mContext;

    protected abstract byte[] getServiceData(String str);

    protected abstract String getServiceNo(int i);

    public ServiceCodeBuilder(Context context) {
        this.mContext = context;
    }

    public byte[] buildServiceCode(int i, String str) {
        byte[] bArr = new byte[0];
        Object buildServiceNoAndServiceDataLenAndData = buildServiceNoAndServiceDataLenAndData(i, str);
        LogX.i("serviceNoAndServiceDataLen = " + buildServiceNoAndServiceDataLenAndData);
        if (buildServiceNoAndServiceDataLenAndData == null || buildServiceNoAndServiceDataLenAndData.length == 0) {
            LogX.e("buildServiceCode, illegal serviceNoAndServiceDataLen");
            return bArr;
        }
        byte[] buildServiceDataAndCheckCode = buildServiceDataAndCheckCode(buildServiceNoAndServiceDataLenAndData);
        if (buildServiceDataAndCheckCode != null && buildServiceDataAndCheckCode.length != 0) {
            return FM_Bytes.join(buildServiceNoAndServiceDataLenAndData, buildServiceDataAndCheckCode);
        }
        LogX.e("buildServiceCode, illegal serviceDataAndCheckCode");
        return bArr;
    }

    private byte[] buildServiceNoAndServiceDataLenAndData(int i, String str) {
        LogX.i("enter buildServiceNoAndServiceDataLenAndData ");
        byte[] bArr = new byte[0];
        String serviceNo = getServiceNo(i);
        LogX.i("serviceNoStr = " + serviceNo);
        if (StringUtil.isEmpty(serviceNo, true)) {
            LogX.e("buildServiceNoAndServiceDataLenAndData, illegal serviceNoStr");
        } else {
            Object serviceData = getServiceData(str);
            LogX.i("enter serviceData : " + serviceData);
            try {
                byte[] intToBytes;
                byte[] bytes = serviceNo.getBytes("utf-8");
                if (serviceData == null || serviceData.length == 0) {
                    LogX.e("buildServiceNoAndServiceDataLenAndData, illegal serviceData");
                    intToBytes = FM_Bytes.intToBytes(14, 2);
                    bArr = FM_Bytes.join(bytes, intToBytes);
                } else {
                    intToBytes = FM_Bytes.intToBytes(serviceData.length + 14, 2);
                    bArr = FM_Bytes.join(FM_Bytes.join(bytes, intToBytes), serviceData);
                }
                LogX.i("buildServiceNoAndServiceDataLenAndData, serviceNo =" + FM_Bytes.bytesToHexString(bytes) + " , serviceDataLen =" + FM_Bytes.bytesToHexString(intToBytes) + " , serviceData =" + FM_Bytes.bytesToHexString(serviceData) + " , serviceNoAndServiceDataLenAndData =" + FM_Bytes.bytesToHexString(bArr));
            } catch (UnsupportedEncodingException e) {
                LogX.e("buildServiceNoAndServiceDataLenAndData, UnsupportedEncodingException serviceNo");
            }
        }
        return bArr;
    }

    private byte[] buildServiceDataAndCheckCode(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        SignDataResponse querySignData = ServerServiceFactory.createCardServerApi(this.mContext).querySignData(new CardServerBaseRequest(), FM_Bytes.bytesToHexString(bArr), "RSA256");
        if (querySignData == null || querySignData.returnCode != 0) {
            Map hashMap = new HashMap();
            String str = "buildActDataAndCheckCode, " + (querySignData == null ? "response is null" : "return code error : " + querySignData.returnCode);
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_SIGNATURE_ERR, hashMap, str, false, false);
            return null;
        }
        String str2 = querySignData.time;
        String str3 = querySignData.sign;
        if (StringUtil.isEmpty(str2, true) || StringUtil.isEmpty(str3, true)) {
            Map hashMap2 = new HashMap();
            str3 = "buildServiceDataAndCheckCode, illegal response";
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str3);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_SIGNATURE_ERR, hashMap2, str3, false, false);
            return bArr2;
        }
        try {
            return FM_Bytes.join((SEPERATOR + str2).getBytes("utf-8"), str3.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            hashMap2 = new HashMap();
            str3 = "buildActDataAndCheckCode, UnsupportedEncodingException serviceData or checkCode";
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str3);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_SIGNATURE_ERR, hashMap2, str3, false, false);
            return bArr2;
        }
    }
}
