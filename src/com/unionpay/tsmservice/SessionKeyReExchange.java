package com.unionpay.tsmservice;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.unionpay.tsmservice.ITsmCallback.Stub;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import com.unionpay.tsmservice.request.BleKeyExchangeRequestParams;
import com.unionpay.tsmservice.request.CheckBinRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExchangeKeyRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetActiveCodeRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetUniteAppListRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenUniteCardApplyActivityRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.UniteAppDeleteRequestParams;
import com.unionpay.tsmservice.request.UniteAppDownloadRequestParams;
import com.unionpay.tsmservice.request.UniteCardActiveRequestParams;
import com.unionpay.tsmservice.result.ExchangeKeyResult;
import com.unionpay.tsmservice.result.GetPubKeyResult;
import com.unionpay.tsmservice.utils.IUPJniInterface;

public class SessionKeyReExchange {
    private static final String TAG = "SessionKeyReExchange";
    private ITsmCallback mCallback;
    private int mKeyType;
    private int mMethodId;
    private Object mObj;
    private OnSafetyKeyboardCallback mOnSafetyKeyboardCallback;
    private RequestParams mParams;
    private ITsmProgressCallback mProgressCallback;
    private Context mThirdPartyContext;
    private int mType;
    private UPTsmAddon mUPTsmAddon;

    class SessionKeyValidCallBack extends Stub {
        public static final int CALLBACK_EXCHANGE_KEY = 1;
        public static final int CALLBACK_GET_PUBKEY = 0;
        private int mId = -1;

        public SessionKeyValidCallBack(int i) {
            this.mId = i;
        }

        public void onResult(Bundle bundle) throws RemoteException {
            switch (this.mId) {
                case 0:
                    bundle.setClassLoader(GetPubKeyResult.class.getClassLoader());
                    SessionKeyReExchange.this.onGetPubKey(((GetPubKeyResult) bundle.get("result")).getKey());
                    return;
                case 1:
                    bundle.setClassLoader(ExchangeKeyResult.class.getClassLoader());
                    SessionKeyReExchange.this.onExchangeKey(((ExchangeKeyResult) bundle.get("result")).getKey());
                    return;
                default:
                    return;
            }
        }

        public void onError(String str, String str2) throws RemoteException {
            Log.e(SessionKeyReExchange.TAG, "execute reExchangeKey onError : errorCode=" + str + " errorDesc=" + str2);
            if (SessionKeyReExchange.this.mCallback != null) {
                switch (SessionKeyReExchange.this.mMethodId) {
                    case 1:
                        str = ResultCode.ERROR_INTERFACE_GET_ASSOCIATED_APP;
                        break;
                    case 2:
                        str = ResultCode.ERROR_INTERFACE_APP_DOWNLOAD_APPLY;
                        break;
                    case 3:
                        str = ResultCode.ERROR_INTERFACE_APP_DELETE;
                        break;
                    case 4:
                        str = ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE;
                        break;
                    case 5:
                        str = ResultCode.ERROR_INTERFACE_GET_APP_DETAIL;
                        break;
                    case 6:
                        str = ResultCode.ERROR_INTERFACE_GET_TRANS_ELEMENTS;
                        break;
                    case 7:
                        str = ResultCode.ERROR_INTERFACE_APP_DOWNLOAD;
                        break;
                    case 8:
                        str = ResultCode.ERROR_INTERFACE_APP_DATA_UPDATE;
                        break;
                    case 9:
                        str = ResultCode.ERROR_INTERFACE_APP_DATA_UPDATE;
                        break;
                    case 10:
                        str = ResultCode.ERROR_INTERFACE_GET_TRANS_RECORD;
                        break;
                    case 11:
                        str = ResultCode.ERROR_INTERFACE_GET_ACCOUNT_INFO;
                        break;
                    case 12:
                        str = ResultCode.ERROR_INTERFACE_GET_ACCOUNT_BALANCE;
                        break;
                    case 13:
                        str = ResultCode.ERROR_INTERFACE_GET_CARD_INFO;
                        break;
                    case 14:
                        str = ResultCode.ERROR_INTERFACE_SET_DEFAULT_CARD;
                        break;
                    case 15:
                        str = ResultCode.ERROR_INTERFACE_OPEN_CHANNEL;
                        break;
                    case 16:
                        str = ResultCode.ERROR_INTERFACE_SEND_APDU;
                        break;
                    case 17:
                        str = ResultCode.ERROR_INTERFACE_CLOSE_CHANNEL;
                        break;
                    case 18:
                        str = ResultCode.ERROR_INTERFACE_HIDE_APP_APPLY;
                        break;
                    case 19:
                        str = ResultCode.ERROR_INTERFACE_GET_SE_ID;
                        break;
                    case 20:
                        str = ResultCode.ERROR_INTERFACE_GET_DEFAULT_CARD;
                        break;
                    case 21:
                        str = ResultCode.ERROR_INTERFACE_GET_SE_APP_LIST;
                        break;
                    case 22:
                        str = ResultCode.ERROR_INTERFACE_GET_APP_LIST;
                        break;
                    case 23:
                        str = ResultCode.ERROR_INTERFACE_GET_APP_STATUS;
                        break;
                    case 24:
                        str = ResultCode.ERROR_INTERFACE_APP_LOCK;
                        break;
                    case 25:
                        str = ResultCode.ERROR_INTERFACE_APP_UNLOCK;
                        break;
                    case 26:
                        str = "10004";
                        break;
                    case 27:
                        break;
                    case 28:
                        str = ResultCode.ERROR_INTERFACE_EXECUTE_CMD;
                        break;
                    case 29:
                        String str3 = ResultCode.ERROR_INTERFACE_BLE_KEY_EXCHANGE;
                        break;
                    case 32:
                        str = ResultCode.ERROR_INTERFACE_CHECK_BIN_CODE;
                        break;
                    case 33:
                        str = ResultCode.ERROR_INTERFACE_OPEN_UNITE_CARD_APPLY_ACTIVITY;
                        break;
                    case 34:
                        str = ResultCode.ERROR_INTERFACE_UNITE_APP_DOWNLOAD;
                        break;
                    case 35:
                        str = ResultCode.ERROR_INTERFACE_UNITE_APP_LIST;
                        break;
                    case 36:
                        str = ResultCode.ERROR_INTERFACE_UNITE_APP_DELETE;
                        break;
                    case 37:
                        str = ResultCode.ERROR_INTERFACE_GET_ACTIVE_CODE;
                        break;
                    case 38:
                        str = ResultCode.ERROR_INTERFACE_UNITE_CARD_ACTIVE;
                        break;
                    case 39:
                        str = ResultCode.ERROR_INTERFACE_GET_SUPPORTED_CARD_TYPE_LIST;
                        break;
                    case 40:
                        str = ResultCode.ERROR_INTERFACE_SET_SAFETYKEYBOARD_BITMAP;
                        break;
                    case 41:
                        str = ResultCode.ERROR_INTERFACE_SHOW_SAFETYKEYBOARD;
                        break;
                    case 42:
                        str = ResultCode.ERROR_INTERFACE_GET_SAFETYKEYBOARD_ENCRYPTEDDATA;
                        break;
                }
                str = "10001";
                SessionKeyReExchange.this.mCallback.onError(str + HwAccountConstants.DEFAULT_DEVICEPLMN, str2);
            }
        }
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, null, iTsmCallback);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, null);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        this(uPTsmAddon, i, requestParams, iTsmCallback, null, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback, int i2) {
        this.mMethodId = 0;
        this.mKeyType = 1000;
        this.mUPTsmAddon = uPTsmAddon;
        this.mMethodId = i;
        this.mParams = requestParams;
        this.mCallback = iTsmCallback;
        this.mProgressCallback = iTsmProgressCallback;
        this.mKeyType = i2;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        this.mMethodId = 0;
        this.mKeyType = 1000;
        this.mUPTsmAddon = uPTsmAddon;
        this.mMethodId = i;
        this.mType = i2;
        this.mParams = safetyKeyboardRequestParams;
        this.mOnSafetyKeyboardCallback = onSafetyKeyboardCallback;
        this.mThirdPartyContext = context;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i, Object obj, ITsmCallback iTsmCallback) {
        this.mMethodId = 0;
        this.mKeyType = 1000;
        this.mUPTsmAddon = uPTsmAddon;
        this.mMethodId = i;
        this.mObj = obj;
        this.mCallback = iTsmCallback;
        this.mKeyType = 1000;
    }

    public void reGetPubKey() throws RemoteException {
        this.mUPTsmAddon.getPubKey(new SessionKeyValidCallBack(0));
    }

    private void onGetPubKey(String str) throws RemoteException {
        String rsaEncrypt = rsaEncrypt(str, makeSessionKey());
        ExchangeKeyRequestParams exchangeKeyRequestParams = new ExchangeKeyRequestParams();
        exchangeKeyRequestParams.setTempKey(rsaEncrypt);
        exchangeKeyRequestParams.setType(this.mKeyType);
        this.mUPTsmAddon.exchangeKey(exchangeKeyRequestParams, new SessionKeyValidCallBack(1));
    }

    private void onExchangeKey(String str) throws RemoteException {
        String decryptMsg = decryptMsg(str);
        if (1001 == this.mKeyType) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.KEY_SESSION_KEY, decryptMsg);
            if (this.mCallback != null) {
                updateSessionKeyTimestamp(1001, decryptMsg);
                this.mCallback.onResult(bundle);
                return;
            }
            return;
        }
        setSessionKey(decryptMsg);
        updateSessionKeyTimestamp(1000, decryptMsg);
        Log.i(Constant.ADDON_LOG_TAG, "=======updateSessionKeyTimestamp");
        reExecRemoteMethod();
    }

    private void reExecRemoteMethod() throws RemoteException {
        switch (this.mMethodId) {
            case 13:
                this.mUPTsmAddon.getCardInfo((String[]) this.mObj, this.mCallback);
                return;
            case 14:
                this.mUPTsmAddon.setDefaultCard((String) this.mObj, this.mCallback);
                return;
            case 20:
                this.mUPTsmAddon.getDefaultCard(this.mCallback);
                return;
            case 26:
                this.mUPTsmAddon.encryptData((EncryptDataRequestParams) this.mParams, this.mCallback);
                return;
            case 27:
                InitRequestParams initRequestParams = (InitRequestParams) this.mParams;
                Log.i(Constant.ADDON_LOG_TAG, "=======mUPTsmAddon.init");
                this.mUPTsmAddon.init(initRequestParams, this.mCallback);
                return;
            case 28:
                this.mUPTsmAddon.executeCmd((ExecuteCmdRequestParams) this.mParams, this.mCallback, this.mProgressCallback);
                return;
            case 29:
                this.mUPTsmAddon.bleKeyExchange((BleKeyExchangeRequestParams) this.mParams, this.mCallback);
                return;
            case 32:
                this.mUPTsmAddon.checkBinCode((CheckBinRequestParams) this.mParams, this.mCallback);
                return;
            case 33:
                this.mUPTsmAddon.openUniteCardApplyActivity((OpenUniteCardApplyActivityRequestParams) this.mParams, this.mUPTsmAddon.getContext(), this.mCallback);
                return;
            case 34:
                this.mUPTsmAddon.UniteAppDownload((UniteAppDownloadRequestParams) this.mParams, this.mCallback, this.mProgressCallback);
                return;
            case 35:
                this.mUPTsmAddon.getUniteAppList((GetUniteAppListRequestParams) this.mParams, this.mCallback);
                return;
            case 36:
                this.mUPTsmAddon.uniteAppDelete((UniteAppDeleteRequestParams) this.mParams, this.mCallback, this.mProgressCallback);
                return;
            case 37:
                this.mUPTsmAddon.getActiveCode((GetActiveCodeRequestParams) this.mParams, this.mCallback);
                return;
            case 38:
                this.mUPTsmAddon.uniteCardActive((UniteCardActiveRequestParams) this.mParams, this.mCallback);
                return;
            case 39:
                this.mUPTsmAddon.getSupportedCardTypeList(this.mCallback);
                return;
            case 40:
                this.mUPTsmAddon.setSafetyKeyboardBitmap((SafetyKeyboardRequestParams) this.mParams);
                return;
            case 41:
                this.mUPTsmAddon.showSafetyKeyboard((SafetyKeyboardRequestParams) this.mParams, this.mType, this.mOnSafetyKeyboardCallback, this.mThirdPartyContext);
                return;
            case 42:
                this.mUPTsmAddon.getEncryptData((GetEncryptDataRequestParams) this.mParams, this.mCallback);
                return;
            default:
                return;
        }
    }

    private void updateSessionKeyTimestamp(int i, String str) {
        Context context = this.mUPTsmAddon.getContext();
        if (context == null) {
            return;
        }
        if (1000 == i) {
            IUPJniInterface.auSKT(context.getPackageName(), str);
        } else if (1001 == i) {
            IUPJniInterface.auSKT(Constant.PREFIX + context.getPackageName(), str);
        }
    }

    private String makeSessionKey() {
        return IUPJniInterface.amSK();
    }

    private void setSessionKey(String str) {
        IUPJniInterface.asSK(str);
    }

    private String decryptMsg(String str) {
        return IUPJniInterface.adM(str);
    }

    private String rsaEncrypt(String str, String str2) {
        return IUPJniInterface.arEWK(str, str2);
    }
}
