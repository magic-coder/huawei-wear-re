package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.tsm.request.CommandRequest;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.wallet.utils.log.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class UnLockEseTsmOperator {
    public static final String SIGN_TYPE_SHA256 = "RSA256";
    public static final int TSM_OPERATE_RESULT_FAILED_CONN_UNAVAILABLE = -2;
    public static final int TSM_OPERATE_RESULT_FAILED_CPLC_ERRO = -3;
    public static final int TSM_OPERATE_RESULT_FAILED_NO_NETWORK = -1;
    public static final int TSM_OPERATE_RESULT_FAILED_UNKNOWN_ERROR = -99;
    public static final int TSM_OPERATE_RESULT_SUCCESS = 0;
    private static final String mAction = "UnLockEseTsmOperator";
    protected Context mContext;

    public UnLockEseTsmOperator(Context context) {
        this.mContext = context;
    }

    public int excute() {
        LogX.i("tsm operate.");
        String queryCplc = ESEInfoManager.getInstance(this.mContext).queryCplc();
        if (StringUtil.isEmpty(queryCplc, true)) {
            return -3;
        }
        TsmParamQueryResponse queryOperateParams = queryOperateParams(createTsmParamQueryRequest(queryCplc, ((TelephonyManager) this.mContext.getSystemService("phone")).getDeviceId()));
        if (queryOperateParams == null) {
            LogX.e("excute, query params failed.");
            return -99;
        }
        LogX.d("excute tsm operate, query params result code:" + queryOperateParams.returnCode);
        if (queryOperateParams.returnCode != 0) {
            return translateReturnCode(queryOperateParams.returnCode);
        }
        if (StringUtil.isEmpty(queryOperateParams.funcID, true) || StringUtil.isEmpty(queryOperateParams.servicID, true)) {
            LogX.e("funcID or serviceID illegal.");
            return -99;
        }
        boolean z;
        CommandRequest commandRequest = new CommandRequest();
        commandRequest.funcallID = queryOperateParams.funcID;
        commandRequest.serverID = queryOperateParams.servicID;
        commandRequest.cplc = queryCplc;
        if (LogUtil.m28542a()) {
            LogX.d("excute, funcallID: " + commandRequest.funcallID + ",serverID: " + commandRequest.serverID + ",cplc: " + commandRequest.cplc);
        }
        int excuteTsmCommandByBasicChannel = SPIServiceFactory.createLaserTSMService(this.mContext).excuteTsmCommandByBasicChannel(commandRequest);
        LogX.i("excute action result: " + excuteTsmCommandByBasicChannel);
        if (100000 == excuteTsmCommandByBasicChannel) {
            z = false;
        } else {
            Map hashMap = new HashMap();
            hashMap.put("fail_action", mAction);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excuteTsmCommandByBasicChannel));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_EXCUTE_ERR, hashMap, "Tsm excute err!", true, false);
            z = true;
        }
        return z;
    }

    private TsmParamQueryRequest createTsmParamQueryRequest(String str, String str2) {
        return new TsmParamQueryRequest(str, ServiceConfig.WALLET_MERCHANT_ID, -1, ServiceConfig.WALLET_MERCHANT_ID, Build.MODEL, str2);
    }

    private int translateReturnCode(int i) {
        if (-1 == i) {
            return -1;
        }
        if (-2 == i) {
            return -2;
        }
        Map hashMap = new HashMap();
        hashMap.put("fail_action", mAction);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_QUIRE_TSM_PARAM_ERR, hashMap, "Tsm quire param err!", true, false);
        return -99;
    }

    public TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest) {
        return ServerServiceFactory.createCardServerApi(this.mContext).queryUnLockEseTsmParam(tsmParamQueryRequest);
    }
}
