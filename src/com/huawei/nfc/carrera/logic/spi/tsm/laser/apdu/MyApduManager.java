package com.huawei.nfc.carrera.logic.spi.tsm.laser.apdu;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.p190v.C2538c;
import com.leisen.wallet.sdk.AppConfig;
import com.leisen.wallet.sdk.bean.CommonRequestParams;
import com.leisen.wallet.sdk.business.ApduResBean;
import com.leisen.wallet.sdk.business.BaseBusinessForResp;
import com.leisen.wallet.sdk.business.BaseResponse;
import com.leisen.wallet.sdk.http.AsyncHttpClient;
import com.leisen.wallet.sdk.http.AsyncHttpResponseHandler;
import com.leisen.wallet.sdk.util.AppJsonUtil;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.entity.StringEntity;

public class MyApduManager extends AsyncHttpResponseHandler {
    private static final String BOUNDARY = "==>";
    private static final int BUSINESS_TYPE_COMMON_METHOD = 40;
    public static final int SEND_TYPE_FIRST = 1;
    public static final int SEND_TYPE_NEXT = 2;
    private static final String TAG = "MyApduManager";
    private static TypeToken<BaseResponse<BaseBusinessForResp>> myTypeToken = new C55512();
    private MyApduResponseHandler mApduResponseHandler = new C55501();
    private MyApduSmartCardRequest mApduSmartCardRequest;
    private AsyncHttpClient mAsyncHttpClient;
    private int mBusinessType = -1;
    private CommonRequestParams mCommonRequestParams;
    private Context mContext;
    private int mCurrentTaskIndex = 1;
    private String mErrorMessage;
    private MyTSMOperatorResponse mTsmOperatorResponse;

    class C55501 extends MyApduResponseHandler {
        C55501() {
        }

        public void onSuccess(String str) {
            if (MyApduManager.this.mTsmOperatorResponse != null) {
                MyApduManager.this.mTsmOperatorResponse.onOperSuccess(str);
            }
            MyApduManager.this.clearData();
        }

        public void onSendNext(int i, int i2, String str, String str2) {
            MyApduManager.this.mCurrentTaskIndex = MyApduManager.this.mCurrentTaskIndex + 1;
            MyApduManager.this.sendNextApdu(i, i2, str, str2);
        }

        public void onSendNextError(int i, int i2, String str, String str2, String str3) {
            MyApduManager.this.mErrorMessage = str3;
            MyApduManager.this.mCurrentTaskIndex = MyApduManager.this.mCurrentTaskIndex + 1;
            MyApduManager.this.sendNextApdu(i, i2, str, str2);
        }

        public void onFailure(int i, String str) {
            if (MyApduManager.this.mTsmOperatorResponse != null) {
                MyApduManager.this.mTsmOperatorResponse.onOperFailure(i, str);
            }
            MyApduManager.this.clearData();
        }
    }

    final class C55512 extends TypeToken<BaseResponse<BaseBusinessForResp>> {
        C55512() {
        }
    }

    public MyApduManager(Context context) {
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mAsyncHttpClient = new AsyncHttpClient(true);
        this.mApduSmartCardRequest = new MyApduSmartCardRequest(this.mContext, this.mApduResponseHandler);
    }

    public void requestCommonMethod(CommonRequestParams commonRequestParams) {
        this.mBusinessType = 40;
        this.mApduSmartCardRequest.setFlag(-1);
        this.mCommonRequestParams = commonRequestParams;
        sendFirstApdu(AppJsonUtil.getBaseReqJsonResult(commonRequestParams, this.mBusinessType, this.mCurrentTaskIndex));
    }

    private void sendFirstApdu(String str) {
        sendApduToServer(str);
    }

    private void sendNextApdu(int i, int i2, String str, String str2) {
        ApduResBean apduResBean = new ApduResBean();
        apduResBean.setIndex(i2);
        apduResBean.setApdu(str);
        apduResBean.setSw(str2);
        sendApduToServer(AppJsonUtil.getReqNextJsonResult(this.mCommonRequestParams, this.mBusinessType, apduResBean, i, this.mCurrentTaskIndex));
    }

    private void sendApduToServer(String str) {
        C2538c.c(TAG, new Object[]{"==>request url:" + AppConfig.getStreamUrl()});
        C2538c.c(TAG, new Object[]{"==>request:" + str});
        if (str != null) {
            try {
                this.mAsyncHttpClient.post(this.mContext, AppConfig.getStreamUrl(), new StringEntity(str, GameManager.DEFAULT_CHARSET), "text/json", this);
            } catch (Exception e) {
                this.mApduResponseHandler.sendFailureMessage(100011, e.getMessage());
            }
        }
    }

    public void setTsmOperatorResponse(MyTSMOperatorResponse myTSMOperatorResponse) {
        this.mTsmOperatorResponse = myTSMOperatorResponse;
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
        MySmartCard.getInstance().closeService();
    }

    public void onSuccess(String str) {
        BaseResponse baseResponse;
        C2538c.c(TAG, new Object[]{"==>response:" + str});
        try {
            baseResponse = (BaseResponse) new Gson().fromJson(str, myTypeToken.getType());
        } catch (JsonSyntaxException e) {
            this.mApduResponseHandler.sendFailureMessage(100012, "response data parse failure");
            baseResponse = null;
        }
        if (baseResponse == null) {
            this.mApduResponseHandler.sendFailureMessage(100012, "response data is empty");
        } else if (((BaseBusinessForResp) baseResponse.getBusiness()).getOperationResult() != 100000) {
            String operationDes = ((BaseBusinessForResp) baseResponse.getBusiness()).getOperationDes();
            if (!(this.mErrorMessage == null || "".equals(this.mErrorMessage))) {
                operationDes = operationDes + ":" + this.mErrorMessage;
                this.mErrorMessage = null;
            }
            this.mApduResponseHandler.sendFailureMessage(100013, operationDes);
        } else if (((BaseBusinessForResp) baseResponse.getBusiness()).getFinishFlag() == 0) {
            this.mApduResponseHandler.sendSuccessMessage(null);
        } else {
            this.mApduSmartCardRequest.setCapduList(((BaseBusinessForResp) baseResponse.getBusiness()).getCapduList());
            sendRequestToSmartCard();
        }
    }

    public void onFailure(String str, Throwable th) {
        C2538c.e(TAG, new Object[]{"==>response:" + str});
        this.mApduResponseHandler.sendFailureMessage(100010, th.getMessage());
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(getResponseString(bArr, getCharset()), th);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        onSuccess(getResponseString(bArr, getCharset()));
    }

    private String getResponseString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            C2538c.e("", new Object[]{BOUNDARY + e.getMessage()});
            return null;
        }
    }
}
