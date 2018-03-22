package com.leisen.wallet.sdk.tsm;

import android.content.Context;
import com.leisen.wallet.sdk.AppConfig;
import com.leisen.wallet.sdk.apdu.ApduManager;
import com.leisen.wallet.sdk.bean.CommonRequestParams;
import com.leisen.wallet.sdk.bean.OperAppletReqParams;

public class TSMOperator implements ITSMOperator, TSMOperatorResponse {
    private static final int RETURN_APPLETAID_IS_NULL = 100006;
    private static final int RETURN_APPLETVERSION_IS_NULL = 100007;
    private static final int RETURN_COMMOMREQUESTPARAMS_IS_NULL = 100001;
    private static final int RETURN_CPLC_IS_NULL = 100008;
    private static final int RETURN_FUNCALLID_IS_NULL = 100004;
    public static final int RETURN_NETWORK_ERROR = 100010;
    private static final int RETURN_OPERAPPLETREQPARAMS_IS_NULL = 100002;
    public static final int RETURN_RESPONSE_PARSE_ERROR = 100012;
    public static final int RETURN_SERVER_ERROR = 100013;
    private static final int RETURN_SERVICEID_IS_NULL = 100003;
    public static final int RETURN_SMARTCARD_OPER_FAILURE = 100009;
    private static final int RETURN_SSDAID_IS_NULL = 100005;
    private static final int RETURN_SUCCESS = 100000;
    public static final int RETURN_UNKNOW_ERROR = 100011;
    private static final Object lock = new Object();
    private ApduManager mApduManager;
    private int mOperatorResult = 100000;
    private TSMOperatorResponse mTsmOperatorResponse;

    private TSMOperator() {
    }

    private TSMOperator(Context context) {
        AppConfig.init(context);
        this.mApduManager = new ApduManager(context);
        this.mApduManager.setTsmOperatorResponse(this);
    }

    public static TSMOperator getInstance(Context context, String str) {
        TSMOperator tSMOperator;
        synchronized (lock) {
            if (str != null) {
                AppConfig.setStreamUrl(str);
            }
            tSMOperator = new TSMOperator(context);
        }
        return tSMOperator;
    }

    public int notifyEseInfoSync(CommonRequestParams commonRequestParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestEseInfoSync(commonRequestParams);
        return this.mOperatorResult;
    }

    public int notifyInfoInit(CommonRequestParams commonRequestParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestInfoInit(commonRequestParams);
        return this.mOperatorResult;
    }

    public int addGPAC(CommonRequestParams commonRequestParams, String str) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        if (str == null) {
            return 100006;
        }
        this.mApduManager.requestOperGPAC(1, commonRequestParams, str);
        return this.mOperatorResult;
    }

    public int deleteGPAC(CommonRequestParams commonRequestParams, String str) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        if (str == null) {
            return 100006;
        }
        this.mApduManager.requestOperGPAC(2, commonRequestParams, str);
        return this.mOperatorResult;
    }

    public int createSSD(CommonRequestParams commonRequestParams, String str) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        if (str == null) {
            return 100005;
        }
        this.mApduManager.requestOperSSD(1, commonRequestParams, str);
        return this.mOperatorResult;
    }

    public int deleteSSD(CommonRequestParams commonRequestParams, String str) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        if (str == null) {
            return 100005;
        }
        this.mApduManager.requestOperSSD(2, commonRequestParams, str);
        return this.mOperatorResult;
    }

    public int lockSSD(CommonRequestParams commonRequestParams, String str) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        if (str == null) {
            return 100005;
        }
        this.mApduManager.requestOperSSD(3, commonRequestParams, str);
        return this.mOperatorResult;
    }

    public int unlockSSD(CommonRequestParams commonRequestParams, String str) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        if (str == null) {
            return 100005;
        }
        this.mApduManager.requestOperSSD(4, commonRequestParams, str);
        return this.mOperatorResult;
    }

    public int installApplet(CommonRequestParams commonRequestParams, OperAppletReqParams operAppletReqParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        checkCommonRequestParams = checkOperAppetReqParams(operAppletReqParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestOperApplet(1, commonRequestParams, operAppletReqParams);
        return this.mOperatorResult;
    }

    public int deleteApplet(CommonRequestParams commonRequestParams, OperAppletReqParams operAppletReqParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        checkCommonRequestParams = checkOperAppetReqParams(operAppletReqParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestOperApplet(2, commonRequestParams, operAppletReqParams);
        return this.mOperatorResult;
    }

    public int lockApplet(CommonRequestParams commonRequestParams, OperAppletReqParams operAppletReqParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        checkCommonRequestParams = checkOperAppetReqParams(operAppletReqParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestOperApplet(3, commonRequestParams, operAppletReqParams);
        return this.mOperatorResult;
    }

    public int unlockApplet(CommonRequestParams commonRequestParams, OperAppletReqParams operAppletReqParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        checkCommonRequestParams = checkOperAppetReqParams(operAppletReqParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestOperApplet(4, commonRequestParams, operAppletReqParams);
        return this.mOperatorResult;
    }

    public int activateApplet(CommonRequestParams commonRequestParams, String str) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        if (str == null) {
            return 100006;
        }
        this.mApduManager.requestactivateApplet(commonRequestParams, str);
        return this.mOperatorResult;
    }

    public TSMOperator setTsmOperatorResponse(TSMOperatorResponse tSMOperatorResponse) {
        this.mTsmOperatorResponse = tSMOperatorResponse;
        return this;
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

    private int checkOperAppetReqParams(OperAppletReqParams operAppletReqParams) {
        if (operAppletReqParams == null) {
            return 100002;
        }
        if (operAppletReqParams.getAppletAid() == null) {
            return 100006;
        }
        return -1;
    }

    public void getCPLC(String str) {
        this.mApduManager.requestGetCPLC(str);
    }

    public void getCIN(String str) {
        this.mApduManager.requestGetCIN(str);
    }

    public void getIIN(String str) {
        this.mApduManager.requestGetIIN(str);
    }

    public void onOperSuccess(String str) {
        this.mOperatorResult = 100000;
        if (this.mTsmOperatorResponse != null) {
            this.mTsmOperatorResponse.onOperSuccess(str);
        }
    }

    public void onOperFailure(int i, Error error) {
        this.mOperatorResult = i;
        if (this.mTsmOperatorResponse != null) {
            this.mTsmOperatorResponse.onOperFailure(i, error);
        }
    }

    public int commonExecute(CommonRequestParams commonRequestParams) {
        int checkCommonRequestParams = checkCommonRequestParams(commonRequestParams);
        if (checkCommonRequestParams != -1) {
            return checkCommonRequestParams;
        }
        this.mApduManager.requestCommonMethod(commonRequestParams);
        return this.mOperatorResult;
    }
}
