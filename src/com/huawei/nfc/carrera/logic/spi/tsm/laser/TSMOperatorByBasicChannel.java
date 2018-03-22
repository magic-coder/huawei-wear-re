package com.huawei.nfc.carrera.logic.spi.tsm.laser;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu.MyApduManager;
import com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu.MyTSMOperatorResponse;
import com.leisen.wallet.sdk.AppConfig;
import com.leisen.wallet.sdk.bean.CommonRequestParams;

public class TSMOperatorByBasicChannel implements MyTSMOperatorResponse {
    private static final int RETURN_COMMOMREQUESTPARAMS_IS_NULL = 100001;
    private static final int RETURN_CPLC_IS_NULL = 100008;
    private static final int RETURN_FUNCALLID_IS_NULL = 100004;
    public static final int RETURN_NETWORK_ERROR = 100010;
    public static final int RETURN_RESPONSE_PARSE_ERROR = 100012;
    public static final int RETURN_SERVER_ERROR = 100013;
    private static final int RETURN_SERVICEID_IS_NULL = 100003;
    public static final int RETURN_SMARTCARD_OPER_FAILURE = 100009;
    private static final int RETURN_SUCCESS = 100000;
    public static final int RETURN_UNKNOW_ERROR = 100011;
    private static final byte[] SYNC_LOCK = new byte[0];
    private MyApduManager mApduManager;
    private int mOperatorResult = 100000;

    private TSMOperatorByBasicChannel(Context context) {
        AppConfig.init(context);
        this.mApduManager = new MyApduManager(context);
        this.mApduManager.setTsmOperatorResponse(this);
    }

    public static TSMOperatorByBasicChannel getInstance(Context context, String str) {
        TSMOperatorByBasicChannel tSMOperatorByBasicChannel;
        synchronized (SYNC_LOCK) {
            if (str != null) {
                AppConfig.setStreamUrl(str);
            }
            tSMOperatorByBasicChannel = new TSMOperatorByBasicChannel(context);
        }
        return tSMOperatorByBasicChannel;
    }

    private int checkCommonRequestParams(CommonRequestParams commonRequestParams) {
        if (commonRequestParams == null) {
            return 100001;
        }
        if (commonRequestParams.getCplc() == null) {
            return 100008;
        }
        if (commonRequestParams.getServiceId() == null) {
            return 100003;
        }
        if (commonRequestParams.getFunCallId() == null) {
            return 100004;
        }
        return -1;
    }

    public void onOperSuccess(String str) {
        this.mOperatorResult = 100000;
    }

    public void onOperFailure(int i, String str) {
        this.mOperatorResult = i;
    }

    public int commonExecuteByBasicChannel(CommonRequestParams commonRequestParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestCommonMethod(commonRequestParams);
        return this.mOperatorResult;
    }
}
