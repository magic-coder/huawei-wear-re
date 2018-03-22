package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.tsm.request.CommandRequest;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

abstract class TsmBaseOperator {
    public static final String SIGN_TYPE_SHA256 = "RSA256";
    public static final int TSM_OPERATE_RESULT_FAILED = -4;
    public static final int TSM_OPERATE_RESULT_FAILED_CONN_UNAVAILABLE = -2;
    public static final int TSM_OPERATE_RESULT_FAILED_CPLC_ERRO = -3;
    public static final int TSM_OPERATE_RESULT_FAILED_NO_NETWORK = -1;
    public static final int TSM_OPERATE_RESULT_FAILED_UNKNOWN_ERROR = -99;
    public static final int TSM_OPERATE_RESULT_SUCCESS = 0;
    private String issuerId;
    private final String mAction;
    protected Context mContext;

    abstract TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest);

    TsmBaseOperator(Context context, String str) {
        this.mContext = context;
        this.mAction = str;
    }

    public int excute() {
        boolean z = false;
        LogX.i("tsm excute start.");
        String queryCplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        LogX.e("excute, query params cplc : " + queryCplc);
        if (StringUtil.isEmpty(queryCplc, true)) {
            return -3;
        }
        String deviceSN = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceSN();
        String deviceModel = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceModel();
        LogX.e("excute, query params imei : " + deviceSN + " ; model : " + deviceModel);
        if (StringUtil.isEmpty(deviceSN, true) || StringUtil.isEmpty(deviceModel, true)) {
            return -4;
        }
        TsmParamQueryRequest createTsmParamQueryRequest = createTsmParamQueryRequest(queryCplc, deviceSN, deviceModel);
        LogX.i("tsm 3.create TsmParamQueryRequest: " + createTsmParamQueryRequest.toString());
        TsmParamQueryResponse queryOperateParams = queryOperateParams(createTsmParamQueryRequest);
        if (queryOperateParams == null) {
            LogX.e("tsm excute, query params failed.");
            return -99;
        }
        LogX.i("tsm 4.return TsmParamQueryResponse: " + queryOperateParams.toString());
        if (queryOperateParams.returnCode != 0) {
            return translateReturnCode(queryOperateParams.returnCode);
        }
        if (StringUtil.isEmpty(queryOperateParams.funcID, true) || StringUtil.isEmpty(queryOperateParams.servicID, true)) {
            LogX.e("TsmBaseOperator", "tsm funcID or serviceID illegal.");
            return -99;
        }
        CommandRequest createCommandRequest = createCommandRequest(queryCplc, queryOperateParams);
        LogX.d("tsm 5.create CommandRequest: " + createCommandRequest.toString());
        int excuteTsmCommand = SPIServiceFactory.createLaserTSMService(this.mContext).excuteTsmCommand(createCommandRequest);
        LogX.i("tsm 6.return TsmParamQueryResponse: " + String.valueOf(excuteTsmCommand));
        if (100000 != excuteTsmCommand) {
            Map hashMap = new HashMap();
            hashMap.put("fail_action", this.mAction);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excuteTsmCommand));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_EXCUTE_ERR, hashMap, "tsm excute err!", true, false);
            z = true;
        }
        return z;
    }

    private TsmParamQueryRequest createTsmParamQueryRequest(String str, String str2, String str3) {
        return new TsmParamQueryRequest(str, ServiceConfig.WALLET_MERCHANT_ID, -1, ServiceConfig.WALLET_MERCHANT_ID, str3, str2);
    }

    private CommandRequest createCommandRequest(String str, TsmParamQueryResponse tsmParamQueryResponse) {
        return CommandRequest.build(str, tsmParamQueryResponse.funcID, tsmParamQueryResponse.servicID);
    }

    private int translateReturnCode(int i) {
        if (-1 == i) {
            return -1;
        }
        if (-2 == i) {
            return -2;
        }
        Map hashMap = new HashMap();
        hashMap.put("fail_action", this.mAction);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_QUIRE_TSM_PARAM_ERR, hashMap, "Tsm quire param err!", true, false);
        return -99;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }
}
