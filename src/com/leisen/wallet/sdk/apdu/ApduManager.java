package com.leisen.wallet.sdk.apdu;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.p190v.C2538c;
import com.leisen.wallet.sdk.AppConfig;
import com.leisen.wallet.sdk.bean.CommonRequestParams;
import com.leisen.wallet.sdk.bean.OperAppletReqParams;
import com.leisen.wallet.sdk.business.ApduResBean;
import com.leisen.wallet.sdk.business.BaseBusinessForResp;
import com.leisen.wallet.sdk.business.BaseResponse;
import com.leisen.wallet.sdk.http.AsyncHttpClient;
import com.leisen.wallet.sdk.http.SimpleResponseHandler;
import com.leisen.wallet.sdk.oma.SmartCard;
import com.leisen.wallet.sdk.tsm.TSMOperatorResponse;
import com.leisen.wallet.sdk.util.AppJsonUtil;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import org.apache.http.entity.StringEntity;

public class ApduManager extends SimpleResponseHandler {
    private static final int BUSINESS_TYPE_ACTIVATE = 35;
    private static final int BUSINESS_TYPE_APPLETOPER = 30;
    private static final int BUSINESS_TYPE_COMMON_METHOD = 40;
    private static final int BUSINESS_TYPE_GPACOPER = 32;
    private static final int BUSINESS_TYPE_INFOINIT = 34;
    private static final int BUSINESS_TYPE_INFOSYNC = 33;
    private static final int BUSINESS_TYPE_SSDOPER = 31;
    private static final int FLAG_ACTIVATE_APPLET = 9;
    private static final int FLAG_ESEINFOSYNC = 2;
    private static final int FLAG_GETCIN = 7;
    private static final int FLAG_GETCPLC = 6;
    private static final int FLAG_GETIIN = 8;
    private static final int FLAG_INFOINIT = 1;
    private static final int FLAG_OPERAPPLET = 4;
    private static final int FLAG_OPERGPAC = 5;
    private static final int FLAG_OPERSSD = 3;
    public static final int SEND_TYPE_FIRST = 1;
    public static final int SEND_TYPE_NEXT = 2;
    private static final String TAG = "ApduManager";
    private ApduResponseHandler mApduResponseHandler = new C61871();
    private ApduSmartCardRequest mApduSmartCardRequest;
    private AsyncHttpClient mAsyncHttpClient;
    private int mBusinessType = -1;
    private CommonRequestParams mCommonRequestParams;
    private Context mContext;
    private int mCurrentTaskIndex = 1;
    private String mErrorMessage;
    private TSMOperatorResponse mTsmOperatorResponse;

    class C61871 extends ApduResponseHandler {
        C61871() {
        }

        public void onSuccess(String str) {
            if (ApduManager.this.mTsmOperatorResponse != null) {
                ApduManager.this.mTsmOperatorResponse.onOperSuccess(str);
            }
            ApduManager.this.clearData();
        }

        public void onSendNext(int i, int i2, String str, String str2) {
            ApduManager.this.mCurrentTaskIndex = ApduManager.this.mCurrentTaskIndex + 1;
            C2538c.c(ApduManager.TAG, new Object[]{"onSendNext"});
            ApduManager.this.sendNextApdu(i, i2, str, str2);
        }

        public void OnSendNextError(int i, int i2, String str, String str2, Error error) {
            ApduManager.this.mErrorMessage = error.getMessage();
            ApduManager.this.mCurrentTaskIndex = ApduManager.this.mCurrentTaskIndex + 1;
            C2538c.c(ApduManager.TAG, new Object[]{"OnSendNextError"});
            ApduManager.this.sendNextApdu(i, i2, str, str2);
        }

        public void onFailure(int i, Error error) {
            if (ApduManager.this.mTsmOperatorResponse != null) {
                ApduManager.this.mTsmOperatorResponse.onOperFailure(i, error);
            }
            ApduManager.this.clearData();
        }
    }

    class C61882 extends TypeToken<BaseResponse<BaseBusinessForResp>> {
        C61882() {
        }
    }

    public ApduManager(Context context) {
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mAsyncHttpClient = new AsyncHttpClient(true);
        this.mApduSmartCardRequest = new ApduSmartCardRequest(this.mContext, this.mApduResponseHandler);
    }

    public void requestInfoInit(CommonRequestParams commonRequestParams) {
        this.mBusinessType = 34;
        this.mApduSmartCardRequest.setFlag(1);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getBaseReqJsonResult(commonRequestParams, this.mBusinessType, this.mCurrentTaskIndex));
    }

    public void requestEseInfoSync(CommonRequestParams commonRequestParams) {
        this.mBusinessType = 33;
        this.mApduSmartCardRequest.setFlag(2);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getBaseReqJsonResult(commonRequestParams, this.mBusinessType, this.mCurrentTaskIndex));
    }

    public void requestOperSSD(int i, CommonRequestParams commonRequestParams, String str) {
        this.mBusinessType = 31;
        this.mApduSmartCardRequest.setFlag(3);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getOperSSDJsonResult(commonRequestParams, this.mBusinessType, i, str, this.mCurrentTaskIndex));
    }

    public void requestOperApplet(int i, CommonRequestParams commonRequestParams, OperAppletReqParams operAppletReqParams) {
        this.mBusinessType = 30;
        this.mApduSmartCardRequest.setFlag(4);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getOperAppletJsonResult(commonRequestParams, this.mBusinessType, i, operAppletReqParams, this.mCurrentTaskIndex));
    }

    public void requestactivateApplet(CommonRequestParams commonRequestParams, String str) {
        this.mBusinessType = 35;
        this.mApduSmartCardRequest.setFlag(9);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getActivateAppletJsonResult(commonRequestParams, this.mBusinessType, str, this.mCurrentTaskIndex));
    }

    public void requestCommonMethod(CommonRequestParams commonRequestParams) {
        this.mBusinessType = 40;
        this.mApduSmartCardRequest.setFlag(-1);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getBaseReqJsonResult(commonRequestParams, this.mBusinessType, this.mCurrentTaskIndex));
    }

    public void requestOperGPAC(int i, CommonRequestParams commonRequestParams, String str) {
        this.mBusinessType = 32;
        this.mApduSmartCardRequest.setFlag(5);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getOperGPACJsonResult(commonRequestParams, this.mBusinessType, i, str, this.mCurrentTaskIndex));
    }

    public void requestGetCPLC(String str) {
        this.mApduSmartCardRequest.setFlag(6);
        this.mApduSmartCardRequest.isGetLocalData(true);
        this.mApduSmartCardRequest.setGetLocalDataApdu(AppConfig.APDU_GETCPLC, str);
        sendRequestToSmartCard();
    }

    public void requestGetCIN(String str) {
        this.mApduSmartCardRequest.setFlag(7);
        this.mApduSmartCardRequest.isGetLocalData(true);
        this.mApduSmartCardRequest.setGetLocalDataApdu(AppConfig.APDU_GETCIN, str);
        sendRequestToSmartCard();
    }

    public void requestGetIIN(String str) {
        this.mApduSmartCardRequest.setFlag(8);
        this.mApduSmartCardRequest.isGetLocalData(true);
        this.mApduSmartCardRequest.setGetLocalDataApdu(AppConfig.APDU_GETIIN, str);
        sendRequestToSmartCard();
    }

    private void sendFirstApdu(String str) {
        sendApduToServer(str);
    }

    private void sendNextApdu(int i, int i2, String str, String str2) {
        C2538c.c(TAG, new Object[]{"sendNextApdu index : " + i2 + "  ; result : " + i + " ; rapdu : " + str + " ; sw : " + str2});
        ApduResBean apduResBean = new ApduResBean();
        apduResBean.setIndex(i2);
        apduResBean.setApdu(str);
        apduResBean.setSw(str2);
        sendApduToServer(AppJsonUtil.getReqNextJsonResult(this.mCommonRequestParams, this.mBusinessType, apduResBean, i, this.mCurrentTaskIndex));
    }

    private void sendApduToServer(String str) {
        C2538c.c(TAG, new Object[]{"sendApduToServer request url:" + AppConfig.getStreamUrl()});
        C2538c.c(TAG, new Object[]{"sendApduToServer request:" + str});
        if (str != null) {
            try {
                this.mAsyncHttpClient.post(this.mContext, AppConfig.getStreamUrl(), new StringEntity(str, GameManager.DEFAULT_CHARSET), "text/json", this);
            } catch (UnsupportedEncodingException e) {
                this.mApduResponseHandler.sendFailureMessage(100011, new Error(e.getMessage()));
            }
        }
    }

    public void setTsmOperatorResponse(TSMOperatorResponse tSMOperatorResponse) {
        this.mTsmOperatorResponse = tSMOperatorResponse;
    }

    private void sendRequestToSmartCard() {
        if (this.mApduSmartCardRequest != null) {
            this.mApduSmartCardRequest.run();
        }
    }

    private void clearData() {
        this.mCurrentTaskIndex = 1;
        this.mBusinessType = -1;
        this.mCommonRequestParams = null;
        SmartCard.getInstance().closeChannel();
    }

    public void onSuccess(String str) {
        BaseResponse baseResponse;
        C2538c.c(TAG, new Object[]{"onSuccess response:" + str});
        try {
            baseResponse = (BaseResponse) new Gson().fromJson(str, new C61882().getType());
        } catch (JsonSyntaxException e) {
            this.mApduResponseHandler.sendFailureMessage(100012, new Error("response data parse failure"));
            baseResponse = null;
        }
        if (baseResponse == null) {
            this.mApduResponseHandler.sendFailureMessage(100012, new Error("response data is empty"));
        } else if (((BaseBusinessForResp) baseResponse.getBusiness()).getOperationResult() != 100000) {
            String operationDes = ((BaseBusinessForResp) baseResponse.getBusiness()).getOperationDes();
            if (!(this.mErrorMessage == null || "".equals(this.mErrorMessage))) {
                operationDes = operationDes + ":" + this.mErrorMessage;
                this.mErrorMessage = null;
            }
            this.mApduResponseHandler.sendFailureMessage(100013, new Error(operationDes));
        } else if (((BaseBusinessForResp) baseResponse.getBusiness()).getFinishFlag() == 0) {
            this.mApduResponseHandler.sendSuccessMessage(null);
        } else {
            this.mApduSmartCardRequest.setCapduList(((BaseBusinessForResp) baseResponse.getBusiness()).getCapduList());
            sendRequestToSmartCard();
        }
    }

    public void OnFailure(String str, Throwable th) {
        C2538c.e(TAG, new Object[]{"OnFailure response:" + str});
        this.mApduResponseHandler.sendFailureMessage(100010, new Error(th.getMessage()));
    }
}
