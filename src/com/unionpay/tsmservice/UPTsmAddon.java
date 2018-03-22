package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.unionpay.tsmservice.ITsmService.Stub;
import com.unionpay.tsmservice.data.ApplyActivityStyle;
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
import com.unionpay.tsmservice.result.AppDownloadApplyResult;
import com.unionpay.tsmservice.result.BleKeyExchangeResult;
import com.unionpay.tsmservice.result.CheckBinCodeResult;
import com.unionpay.tsmservice.result.ECashTopUpResult;
import com.unionpay.tsmservice.result.EncryptDataResult;
import com.unionpay.tsmservice.result.GetAccountBalanceResult;
import com.unionpay.tsmservice.result.GetAccountInfoResult;
import com.unionpay.tsmservice.result.GetActivityApplyDeleteResult;
import com.unionpay.tsmservice.result.GetActivityUniteApplyResult;
import com.unionpay.tsmservice.result.GetAppDetailResult;
import com.unionpay.tsmservice.result.GetAppListResult;
import com.unionpay.tsmservice.result.GetAssociatedAppResult;
import com.unionpay.tsmservice.result.GetCardInfoResult;
import com.unionpay.tsmservice.result.GetDefaultCardResult;
import com.unionpay.tsmservice.result.GetEncryptDataResult;
import com.unionpay.tsmservice.result.GetSMSAuthCodeResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.GetSeIdResult;
import com.unionpay.tsmservice.result.GetSupportedCardTypeListResult;
import com.unionpay.tsmservice.result.GetTransElementsResult;
import com.unionpay.tsmservice.result.GetTransRecordResult;
import com.unionpay.tsmservice.result.GetUniteAppListResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;
import com.unionpay.tsmservice.result.UniteCardActiveResult;
import com.unionpay.tsmservice.utils.IUPJniInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UPTsmAddon {
    private static final String ACTION_TSM_SERVICE = "com.unionpay.tsmservice.UPTsmBleUniteService";
    private static final int MSG_TSM_SERVICE_CONNECTED = 0;
    private static final int MSG_TSM_SERVICE_DISCONNECTED = 1;
    private static final String PACKAGE_NAME_TSM_SERVICE = "com.unionpay.tsmbleuniteservice";
    private static final String TAG = "UPTsmAddon";
    private static UPTsmAddon sInstance = null;
    private static CopyOnWriteArrayList<UPTsmConnectionListener> sTsmConnectionListeners = null;
    private final int CALL_INTERFACE_LONG_OVERTIME = 65;
    private final int CALL_INTERFACE_MID_OVERTIME = 50;
    private final int CALL_INTERFACE_SHORT_OVERTIME = 35;
    private final int CALL_INTERFACE_SUPER_LONG_OVERTIME = 90;
    private final Handler callInterfaceOvertimehandler = new C65532();
    private boolean isConnected = false;
    private HashMap<String, ITsmCallback> mActivityApplyDeleteListeners = new HashMap();
    private HashMap<String, ITsmCallback> mActivityUniteApplyListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppDataUpdateListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppDownloadApplyListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppECashTopupListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppGetAccountBalanceListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppGetAccountInfoListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppGetActiveCodeListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppGetSMSAuthCodeListeners = new HashMap();
    private HashMap<String, ITsmCallback> mAppGetTransRecordListeners = new HashMap();
    private HashMap<String, ITsmActivityCallback> mApplyActivityLsteners = new HashMap();
    private HashMap<String, ITsmActivityCallback> mApplyUniteActivityLsteners = new HashMap();
    private HashMap<String, ITsmCallback> mBleKeyExchangeListeners = new HashMap();
    private final Callback mCallback = new C65521();
    private HashMap<String, ITsmCallback> mCheckBinCodeListeners = new HashMap();
    private HashMap<String, ITsmCallback> mCloseChannelListeners = new HashMap();
    private Context mContext = null;
    private HashMap<String, ITsmActivityCallback> mDetailActivityLsteners = new HashMap();
    private HashMap<String, ITsmCallback> mEncryptDataListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetAppDetailListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetAppListListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetAppStatusListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetAssoAppListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetCardInfoListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetDefaultCardListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetEncryptDataListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetSEAppListListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetSeIdListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetSupportedCardTypeListListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetTransElementsListeners = new HashMap();
    private HashMap<String, ITsmCallback> mGetUniteAppListListeners = new HashMap();
    private final Handler mHandler = new Handler(Looper.getMainLooper(), this.mCallback);
    private ITsmService mITsmService = null;
    private HashMap<String, ITsmCallback> mInitListeners = new HashMap();
    private HashMap<String, ITsmCallback> mOpenChannelListeners = new HashMap();
    private HashMap<String, ITsmCallback> mSendApduListeners = new HashMap();
    private ServiceConnection mServiceConnection = null;
    private HashMap<String, ITsmCallback> mSetDefaultCardListeners = new HashMap();
    private HashMap<String, ITsmActivityCallback> mShowSaftyboardActivityListeners = new HashMap();
    private HashMap<String, ITsmCallback> mUniteAppActiveListeners = new HashMap();

    public interface UPTsmConnectionListener {
        void onTsmConnected();

        void onTsmDisconnected();
    }

    class C65521 implements Callback {
        C65521() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    UPTsmAddon.this.onTsmServiceConnected();
                    return true;
                case 1:
                    UPTsmAddon.this.onTsmServiceDisconnected();
                    return true;
                default:
                    return false;
            }
        }
    }

    class C65532 extends Handler {
        C65532() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            int intValue = ((Integer) message.obj).intValue();
            ITsmCallback iTsmCallback = (ITsmCallback) UPTsmAddon.this.getCallbackMap(i).get(UPTsmAddon.this.getPackageName());
            if (iTsmCallback != null && intValue == iTsmCallback.hashCode()) {
                UPTsmAddon.this.onCallbackResult(iTsmCallback, UPTsmAddon.this.buildOvertimeResult());
                UPTsmAddon.this.getCallbackMap(i).remove(UPTsmAddon.this.getPackageName());
            }
        }
    }

    class C65543 implements ServiceConnection {
        C65543() {
        }

        public void onServiceDisconnected(ComponentName componentName) {
            UPTsmAddon.this.isConnected = false;
            UPTsmAddon.this.mITsmService = null;
            UPTsmAddon.this.mHandler.sendEmptyMessage(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            UPTsmAddon.this.isConnected = true;
            UPTsmAddon.this.mITsmService = Stub.asInterface(iBinder);
            UPTsmAddon.this.mHandler.sendEmptyMessage(0);
        }
    }

    public class TsmActivityCallback extends ITsmActivityCallback.Stub {
        private int mActivityCallbackId;

        public TsmActivityCallback(int i) {
            this.mActivityCallbackId = i;
        }

        public void StartActivity(String str, String str2, Bundle bundle) throws RemoteException {
            UPTsmAddon.this.onActivityCallBack((ITsmActivityCallback) UPTsmAddon.this.getActivityCallbackMap(this.mActivityCallbackId).get(UPTsmAddon.this.getPackageName()), str, str2, bundle);
        }
    }

    public class TsmCallback extends ITsmCallback.Stub {
        private int mCallbackId;

        public TsmCallback(int i) {
            this.mCallbackId = i;
        }

        public void onResult(Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            UPTsmAddon.this.onCallbackResult((ITsmCallback) UPTsmAddon.this.getCallbackMap(this.mCallbackId).get(UPTsmAddon.this.getPackageName()), getCallbackDecryptResultData(this.mCallbackId, bundle));
            UPTsmAddon.this.getCallbackMap(this.mCallbackId).remove(UPTsmAddon.this.getPackageName());
        }

        public void onError(String str, String str2) throws RemoteException {
            Log.e(UPTsmAddon.TAG, "errorCode:" + str + ", errorDesc:" + str2);
            Bundle bundle = new Bundle();
            bundle.putString(Constant.KEY_ERROR_CODE, str);
            bundle.putString(Constant.KEY_ERROR_DESC, str2);
            UPTsmAddon.this.onCallbackResult((ITsmCallback) UPTsmAddon.this.getCallbackMap(this.mCallbackId).get(UPTsmAddon.this.getPackageName()), bundle);
            UPTsmAddon.this.getCallbackMap(this.mCallbackId).remove(UPTsmAddon.this.getPackageName());
        }

        private Bundle getCallbackDecryptResultData(int i, Bundle bundle) {
            Log.i(Constant.ADDON_LOG_TAG, "=====getCallbackDecryptResultData");
            Bundle bundle2 = new Bundle();
            String string = bundle.getString(Constant.KEY_ERROR_CODE);
            byte[] decode = Base64.decode(IUPJniInterface.adM(bundle.getString("result")), 0);
            bundle2.putString(Constant.KEY_ERROR_CODE, string);
            Parcel obtain = Parcel.obtain();
            if (!(decode == null || decode.length == 0)) {
                obtain.unmarshall(decode, 0, decode.length);
                obtain.setDataPosition(0);
            }
            if (obtain.dataSize() == 0) {
                obtain.recycle();
                return bundle2;
            }
            switch (i) {
                case 42:
                    bundle2.putParcelable("result", (GetEncryptDataResult) obtain.readParcelable(GetEncryptDataResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1000:
                    bundle2.putParcelable("result", (InitResult) obtain.readParcelable(InitResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1001:
                    bundle2.putParcelable("result", (GetAssociatedAppResult) obtain.readParcelable(GetAssociatedAppResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1002:
                    bundle2.putParcelable("result", (GetTransElementsResult) obtain.readParcelable(GetTransElementsResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1003:
                    bundle2.putParcelable("result", (GetSMSAuthCodeResult) obtain.readParcelable(GetSMSAuthCodeResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1004:
                    bundle2.putParcelable("result", (GetAccountInfoResult) obtain.readParcelable(GetAccountInfoResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1005:
                    bundle2.putParcelable("result", (GetAccountBalanceResult) obtain.readParcelable(GetAccountBalanceResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1006:
                    bundle2.putParcelable("result", (AppDownloadApplyResult) obtain.readParcelable(AppDownloadApplyResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1009:
                    bundle2.putParcelable("result", (GetAppListResult) obtain.readParcelable(GetAppListResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1010:
                    bundle2.putParcelable("result", (GetAppDetailResult) obtain.readParcelable(GetAppDetailResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1011:
                    bundle2.putParcelable("result", (OpenChannelResult) obtain.readParcelable(OpenChannelResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1012:
                    bundle2.putParcelable("result", (SendApduResult) obtain.readParcelable(SendApduResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1014:
                    bundle2.putParcelable("result", (GetSeAppListResult) obtain.readParcelable(GetSeAppListResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1015:
                    bundle2.putParcelable("result", (GetDefaultCardResult) obtain.readParcelable(GetDefaultCardResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1017:
                    bundle2.putParcelable("result", (GetTransRecordResult) obtain.readParcelable(GetTransRecordResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1018:
                    bundle2.putParcelable("result", (ECashTopUpResult) obtain.readParcelable(ECashTopUpResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1019:
                    bundle2.putParcelable("result", (GetSeIdResult) obtain.readParcelable(GetSeIdResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1023:
                    bundle2.putParcelable("result", (EncryptDataResult) obtain.readParcelable(EncryptDataResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1024:
                    bundle2.putParcelable("result", (GetCardInfoResult) obtain.readParcelable(GetCardInfoResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case Constant.CALLBACK_BLE_KEY_EXCHANGE /*1027*/:
                    Log.i(Constant.ADDON_LOG_TAG, "====CALLBACK_BLE_KEY_EXCHANGE");
                    BleKeyExchangeResult bleKeyExchangeResult = (BleKeyExchangeResult) obtain.readParcelable(BleKeyExchangeResult.class.getClassLoader());
                    Log.i(Constant.ADDON_LOG_TAG, "====CALLBACK_BLE_KEY_EXCHANGE");
                    bundle2.putParcelable("result", bleKeyExchangeResult);
                    bundle = bundle2;
                    break;
                case 1028:
                    bundle2.putParcelable("result", (GetActivityApplyDeleteResult) obtain.readParcelable(GetActivityApplyDeleteResult.class.getClassLoader()));
                    Log.i(Constant.ADDON_LOG_TAG, "1028");
                    bundle = bundle2;
                    break;
                case Constant.CALLBACK_CHECK_BIN_CODE /*1030*/:
                    bundle2.putParcelable("result", (CheckBinCodeResult) obtain.readParcelable(CheckBinCodeResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case 1031:
                    bundle2.putParcelable("result", (GetActivityUniteApplyResult) obtain.readParcelable(GetActivityUniteApplyResult.class.getClassLoader()));
                    Log.i(Constant.ADDON_LOG_TAG, "1031");
                    bundle = bundle2;
                    break;
                case Constant.CALLBACK_UNITE_APP_LIST /*1032*/:
                    bundle2.putParcelable("result", (GetUniteAppListResult) obtain.readParcelable(GetUniteAppListResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case Constant.CALLBACK_GET_ACTIVE_CODE /*1033*/:
                    bundle2.putParcelable("result", (GetSMSAuthCodeResult) obtain.readParcelable(GetSMSAuthCodeResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case Constant.CALLBACK_UNITE_CARD_ACTIVE /*1034*/:
                    bundle2.putParcelable("result", (UniteCardActiveResult) obtain.readParcelable(UniteCardActiveResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
                case Constant.CALLBACK_GET_SUPPORTED_CARD_TYPE_LIST /*1037*/:
                    bundle2.putParcelable("result", (GetSupportedCardTypeListResult) obtain.readParcelable(GetSupportedCardTypeListResult.class.getClassLoader()));
                    bundle = bundle2;
                    break;
            }
            obtain.recycle();
            return bundle;
        }
    }

    static {
        try {
            System.loadLibrary("uptsmaddon");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private UPTsmAddon(Context context) {
        this.mContext = context;
        if (!IUPJniInterface.aiJNIE(context)) {
            throw new RuntimeException();
        }
    }

    public static UPTsmAddon getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (sInstance == null) {
            sInstance = new UPTsmAddon(context.getApplicationContext());
        }
        if (sTsmConnectionListeners == null) {
            sTsmConnectionListeners = new CopyOnWriteArrayList();
        }
        return sInstance;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public boolean bind() {
        return bindUPTsmService();
    }

    public void unbind() throws RemoteException {
        Log.i(Constant.ADDON_LOG_TAG, "开始解绑蓝牙服务");
        if (this.mITsmService != null) {
            this.mITsmService.unbindBleService();
        }
        unbindUPTsmService();
    }

    public void addConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            sTsmConnectionListeners.add(uPTsmConnectionListener);
        }
    }

    public void removeConnectionListener(UPTsmConnectionListener uPTsmConnectionListener) {
        if (uPTsmConnectionListener != null) {
            sTsmConnectionListeners.remove(uPTsmConnectionListener);
        }
    }

    public int getListenerCount() {
        if (sTsmConnectionListeners != null) {
            return sTsmConnectionListeners.size();
        }
        return 0;
    }

    public int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        InitRequestParams initRequestParams2 = new InitRequestParams();
        if (initRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        Log.i(Constant.ADDON_LOG_TAG, "===进入Addon  init");
        this.mInitListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            Log.i(Constant.ADDON_LOG_TAG, "===下一步进入Stub  init");
            initRequestParams2.setType(initRequestParams.getType());
            int init = this.mITsmService.init(initRequestParams2, new TsmCallback(1000));
            Message message = new Message();
            message.what = 1000;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 90000);
            if (-2 != init) {
                return init;
            }
            onSessionKeyInvalid(27, (RequestParams) initRequestParams, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(27, (RequestParams) initRequestParams, iTsmCallback);
        return 0;
    }

    public int getSupportedCardTypeList(ITsmCallback iTsmCallback) throws RemoteException {
        Log.i(Constant.ADDON_LOG_TAG, "===进入getSupportedCardTypeList");
        this.mGetSupportedCardTypeListListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            int supportedCardTypeList = this.mITsmService.getSupportedCardTypeList(new TsmCallback(Constant.CALLBACK_GET_SUPPORTED_CARD_TYPE_LIST));
            Message message = new Message();
            message.what = Constant.CALLBACK_GET_SUPPORTED_CARD_TYPE_LIST;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 50000);
            if (-2 != supportedCardTypeList) {
                return supportedCardTypeList;
            }
            onSessionKeyInvalid(39, null, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(39, null, iTsmCallback);
        return 0;
    }

    public int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        EncryptDataRequestParams encryptDataRequestParams2 = new EncryptDataRequestParams();
        if (encryptDataRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        this.mEncryptDataListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            ArrayList arrayList = (ArrayList) encryptDataRequestParams.getData();
            if (arrayList != null) {
                int size = arrayList.size();
                if (size == 0) {
                    return -3;
                }
                List arrayList2 = new ArrayList();
                for (int i = 0; i < size; i++) {
                    String str = (String) arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        arrayList2.add(IUPJniInterface.aeM(str));
                    }
                }
                encryptDataRequestParams.setData(arrayList2);
            }
            encryptDataRequestParams2.setData(encryptDataRequestParams.getData());
            int encryptData = this.mITsmService.encryptData(encryptDataRequestParams2, new TsmCallback(1023));
            Message message = new Message();
            message.what = 1023;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 35000);
            if (-2 != encryptData) {
                return encryptData;
            }
            encryptDataRequestParams.setData(arrayList);
            onSessionKeyInvalid(26, (RequestParams) encryptDataRequestParams, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(26, (RequestParams) encryptDataRequestParams, iTsmCallback);
        return 0;
    }

    public synchronized int executeCmd(ExecuteCmdRequestParams executeCmdRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        int i = 0;
        synchronized (this) {
            if (executeCmdRequestParams == null || iTsmCallback == null) {
                i = -3;
            } else {
                ExecuteCmdRequestParams executeCmdRequestParams2 = new ExecuteCmdRequestParams();
                if (this.mITsmService == null) {
                    i = -1;
                } else if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
                    Object ssid = executeCmdRequestParams.getSsid();
                    Object sign = executeCmdRequestParams.getSign();
                    if (!TextUtils.isEmpty(ssid)) {
                        executeCmdRequestParams2.setSsid(IUPJniInterface.aeM(ssid));
                    }
                    if (!TextUtils.isEmpty(sign)) {
                        executeCmdRequestParams2.setSign(IUPJniInterface.aeM(sign));
                    }
                    try {
                        int executeCmd = this.mITsmService.executeCmd(executeCmdRequestParams2, iTsmCallback, iTsmProgressCallback);
                        if (-2 == executeCmd) {
                            onSessionKeyInvalid(28, executeCmdRequestParams, iTsmCallback, iTsmProgressCallback);
                        } else {
                            i = executeCmd;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RemoteException();
                    }
                } else {
                    onSessionKeyInvalid(28, executeCmdRequestParams, iTsmCallback, iTsmProgressCallback);
                }
            }
        }
        return i;
    }

    public synchronized int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException {
        int i = 0;
        synchronized (this) {
            if (safetyKeyboardRequestParams == null) {
                i = -3;
            } else if (this.mITsmService == null) {
                i = -1;
            } else if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
                try {
                    int safetyKeyboardBitmap = this.mITsmService.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
                    if (-2 == safetyKeyboardBitmap) {
                        onSessionKeyInvalid(40, (RequestParams) safetyKeyboardRequestParams, null);
                    } else {
                        i = safetyKeyboardBitmap;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RemoteException();
                }
            } else {
                onSessionKeyInvalid(40, (RequestParams) safetyKeyboardRequestParams, null);
            }
        }
        return i;
    }

    public synchronized int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) throws RemoteException {
        int i2;
        if (safetyKeyboardRequestParams == null || i < 2000 || i > 2001) {
            i2 = -3;
        } else if (this.mITsmService == null) {
            i2 = -1;
        } else if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            this.mShowSaftyboardActivityListeners.put(getPackageName(), new TsmActivityListener(context));
            try {
                i2 = this.mITsmService.showSafetyKeyboard(safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, new TsmActivityCallback(Constant.CALLBACK_SHOW_SAFETYKEYBOARD));
                if (i2 != 0) {
                    this.mShowSaftyboardActivityListeners.remove(getPackageName());
                }
                if (-2 == i2) {
                    onSessionKeyInvalid(41, safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, context);
                    i2 = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            onSessionKeyInvalid(41, safetyKeyboardRequestParams, i, onSafetyKeyboardCallback, context);
            i2 = 0;
        }
        return i2;
    }

    public synchronized int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        int i = -3;
        synchronized (this) {
            if (!(iTsmCallback == null || getEncryptDataRequestParams == null)) {
                int type = getEncryptDataRequestParams.getType();
                Object pan = getEncryptDataRequestParams.getPan();
                if (type >= 2000 && type <= 2001 && !(type == 2000 && TextUtils.isEmpty(pan))) {
                    if (this.mITsmService == null) {
                        i = -1;
                    } else if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
                        GetEncryptDataRequestParams getEncryptDataRequestParams2 = new GetEncryptDataRequestParams();
                        if (type == 2000) {
                            getEncryptDataRequestParams2.setPan(IUPJniInterface.aeM(pan));
                        }
                        getEncryptDataRequestParams2.setType(type);
                        this.mGetEncryptDataListeners.put(getPackageName(), iTsmCallback);
                        try {
                            i = this.mITsmService.getEncryptData(getEncryptDataRequestParams2, new TsmCallback(42));
                            if (i != 0) {
                                this.mGetEncryptDataListeners.remove(getPackageName());
                            }
                            if (-2 == i) {
                                onSessionKeyInvalid(42, (RequestParams) getEncryptDataRequestParams, iTsmCallback);
                                i = 0;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new RemoteException();
                        }
                    } else {
                        onSessionKeyInvalid(42, (RequestParams) getEncryptDataRequestParams, iTsmCallback);
                        i = 0;
                    }
                }
            }
        }
        return i;
    }

    public synchronized int clearEncryptData(int i) throws RemoteException {
        int i2;
        if (i < 2000 || i > 2001) {
            i2 = -3;
        } else if (this.mITsmService == null) {
            i2 = -1;
        } else if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            try {
                i2 = this.mITsmService.clearEncryptData(i);
                if (-2 == i2) {
                    onSessionKeyInvalid(43, null, i, null, null);
                    i2 = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            onSessionKeyInvalid(43, null, i, null, null);
            i2 = 0;
        }
        return i2;
    }

    public synchronized int hideKeyboard() throws RemoteException {
        int i;
        if (this.mITsmService == null) {
            i = -1;
        } else if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            try {
                i = this.mITsmService.hideKeyboard();
                if (-2 == i) {
                    onSessionKeyInvalid(44, null, 0, null, null);
                    i = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RemoteException();
            }
        } else {
            onSessionKeyInvalid(44, null, 0, null, null);
            i = 0;
        }
        return i;
    }

    public int checkBinCode(CheckBinRequestParams checkBinRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        CheckBinRequestParams checkBinRequestParams2 = new CheckBinRequestParams();
        if (checkBinRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        Log.i(Constant.ADDON_LOG_TAG, "===进入checkbincode");
        this.mCheckBinCodeListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            if (!TextUtils.isEmpty(checkBinRequestParams.getSPan())) {
                checkBinRequestParams2.setSPan(IUPJniInterface.aeM(checkBinRequestParams.getSPan()));
                checkBinRequestParams.setSPan(IUPJniInterface.aeM(checkBinRequestParams.getSPan()));
            }
            int checkBinCode = this.mITsmService.checkBinCode(checkBinRequestParams2, new TsmCallback(Constant.CALLBACK_CHECK_BIN_CODE));
            Message message = new Message();
            message.what = Constant.CALLBACK_CHECK_BIN_CODE;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 90000);
            if (-2 != checkBinCode) {
                return checkBinCode;
            }
            onSessionKeyInvalid(32, (RequestParams) checkBinRequestParams, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(32, (RequestParams) checkBinRequestParams, iTsmCallback);
        return 0;
    }

    public int getUniteAppList(GetUniteAppListRequestParams getUniteAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        if (getUniteAppListRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        GetUniteAppListRequestParams getUniteAppListRequestParams2 = new GetUniteAppListRequestParams();
        this.mGetUniteAppListListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            int i;
            String[] status = getUniteAppListRequestParams.getStatus();
            if (status != null) {
                int length = status.length;
                String[] strArr = new String[length];
                for (i = 0; i < length; i++) {
                    if (!TextUtils.isEmpty(status[i])) {
                        strArr[i] = IUPJniInterface.aeM(status[i]);
                    }
                }
                getUniteAppListRequestParams2.setStatus(strArr);
            } else {
                getUniteAppListRequestParams2.setStatus(new String[0]);
            }
            i = this.mITsmService.getUniteAppList(getUniteAppListRequestParams2, new TsmCallback(Constant.CALLBACK_UNITE_APP_LIST));
            Message message = new Message();
            message.what = Constant.CALLBACK_UNITE_APP_LIST;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 65000);
            if (-2 != i) {
                return i;
            }
            onSessionKeyInvalid(35, (RequestParams) getUniteAppListRequestParams, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(35, (RequestParams) getUniteAppListRequestParams, iTsmCallback);
        return 0;
    }

    public int bleKeyExchange(BleKeyExchangeRequestParams bleKeyExchangeRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        Log.i(Constant.ADDON_LOG_TAG, "=====进入addon bleKeyExchange");
        if (bleKeyExchangeRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        BleKeyExchangeRequestParams bleKeyExchangeRequestParams2 = new BleKeyExchangeRequestParams();
        this.mBleKeyExchangeListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            AppID appID = bleKeyExchangeRequestParams.getAppID();
            if (appID != null) {
                Object appAid = appID.getAppAid();
                Object appVersion = appID.getAppVersion();
                if (!(TextUtils.isEmpty(appAid) || TextUtils.isEmpty(appVersion))) {
                    bleKeyExchangeRequestParams.setAppID(new AppID(IUPJniInterface.aeM(appAid), IUPJniInterface.aeM(appVersion)));
                }
            }
            Log.i(Constant.ADDON_LOG_TAG, "=====准备进入mITsmService bleKeyExchange");
            bleKeyExchangeRequestParams2.setAppID(bleKeyExchangeRequestParams.getAppID());
            int bleKeyExchange = this.mITsmService.bleKeyExchange(bleKeyExchangeRequestParams2, new TsmCallback(Constant.CALLBACK_BLE_KEY_EXCHANGE));
            Message message = new Message();
            message.what = Constant.CALLBACK_BLE_KEY_EXCHANGE;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 50000);
            if (-2 != bleKeyExchange) {
                return bleKeyExchange;
            }
            bleKeyExchangeRequestParams.setAppID(appID);
            onSessionKeyInvalid(29, (RequestParams) bleKeyExchangeRequestParams, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(29, (RequestParams) bleKeyExchangeRequestParams, iTsmCallback);
        return 0;
    }

    public int UniteAppDownload(UniteAppDownloadRequestParams uniteAppDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        if (uniteAppDownloadRequestParams == null || iTsmCallback == null || iTsmProgressCallback == null) {
            return -3;
        }
        UniteAppDownloadRequestParams uniteAppDownloadRequestParams2 = new UniteAppDownloadRequestParams();
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            Object mPanId = uniteAppDownloadRequestParams.getMPanId();
            if (TextUtils.isEmpty(mPanId)) {
                return -3;
            }
            uniteAppDownloadRequestParams2.setMPanId(IUPJniInterface.aeM(mPanId));
            int uniteAppDownload = this.mITsmService.uniteAppDownload(uniteAppDownloadRequestParams2, iTsmCallback, iTsmProgressCallback);
            if (-2 != uniteAppDownload) {
                return uniteAppDownload;
            }
            onSessionKeyInvalid(34, uniteAppDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
            return 0;
        }
        onSessionKeyInvalid(34, uniteAppDownloadRequestParams, iTsmCallback, iTsmProgressCallback);
        return 0;
    }

    public int uniteAppDelete(UniteAppDeleteRequestParams uniteAppDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        if (uniteAppDeleteRequestParams == null || iTsmCallback == null || iTsmProgressCallback == null) {
            return -3;
        }
        UniteAppDeleteRequestParams uniteAppDeleteRequestParams2 = new UniteAppDeleteRequestParams();
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            Object mPanId = uniteAppDeleteRequestParams.getMPanId();
            if (TextUtils.isEmpty(mPanId)) {
                return -3;
            }
            uniteAppDeleteRequestParams2.setMPanId(IUPJniInterface.aeM(mPanId));
            int uniteAppDelete = this.mITsmService.uniteAppDelete(uniteAppDeleteRequestParams2, iTsmCallback, iTsmProgressCallback);
            if (-2 != uniteAppDelete) {
                return uniteAppDelete;
            }
            onSessionKeyInvalid(36, uniteAppDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
            return 0;
        }
        onSessionKeyInvalid(36, uniteAppDeleteRequestParams, iTsmCallback, iTsmProgressCallback);
        return 0;
    }

    public int getActiveCode(GetActiveCodeRequestParams getActiveCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        if (getActiveCodeRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        GetActiveCodeRequestParams getActiveCodeRequestParams2 = new GetActiveCodeRequestParams();
        this.mAppGetActiveCodeListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            Object mPanId = getActiveCodeRequestParams.getMPanId();
            Object activeType = getActiveCodeRequestParams.getActiveType();
            if (TextUtils.isEmpty(mPanId)) {
                return -3;
            }
            getActiveCodeRequestParams2.setMPanId(IUPJniInterface.aeM(mPanId));
            if (TextUtils.isEmpty(activeType)) {
                return -3;
            }
            getActiveCodeRequestParams2.setActiveType(IUPJniInterface.aeM(activeType));
            int activeCode = this.mITsmService.getActiveCode(getActiveCodeRequestParams2, new TsmCallback(Constant.CALLBACK_GET_ACTIVE_CODE));
            Message message = new Message();
            message.what = Constant.CALLBACK_GET_ACTIVE_CODE;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 50000);
            if (-2 != activeCode) {
                return activeCode;
            }
            onSessionKeyInvalid(37, (RequestParams) getActiveCodeRequestParams, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(37, (RequestParams) getActiveCodeRequestParams, iTsmCallback);
        return 0;
    }

    public int uniteCardActive(UniteCardActiveRequestParams uniteCardActiveRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        if (uniteCardActiveRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        UniteCardActiveRequestParams uniteCardActiveRequestParams2 = new UniteCardActiveRequestParams();
        this.mUniteAppActiveListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            Object mPanId = uniteCardActiveRequestParams.getMPanId();
            Object activeCode = uniteCardActiveRequestParams.getActiveCode();
            if (TextUtils.isEmpty(mPanId)) {
                return -3;
            }
            uniteCardActiveRequestParams2.setMPanId(IUPJniInterface.aeM(mPanId));
            if (TextUtils.isEmpty(activeCode)) {
                return -3;
            }
            uniteCardActiveRequestParams2.setActiveCode(IUPJniInterface.aeM(activeCode));
            int uniteCardActive = this.mITsmService.uniteCardActive(uniteCardActiveRequestParams2, new TsmCallback(Constant.CALLBACK_UNITE_CARD_ACTIVE));
            Message message = new Message();
            message.what = Constant.CALLBACK_UNITE_CARD_ACTIVE;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 50000);
            if (-2 != uniteCardActive) {
                return uniteCardActive;
            }
            onSessionKeyInvalid(38, (RequestParams) uniteCardActiveRequestParams, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(38, (RequestParams) uniteCardActiveRequestParams, iTsmCallback);
        return 0;
    }

    public int getCardInfo(String[] strArr, ITsmCallback iTsmCallback) throws RemoteException {
        int length = strArr.length;
        if (strArr == null || length == 0) {
            return -3;
        }
        int i = 0;
        while (i < length && strArr[i] == null) {
            i++;
        }
        this.mGetCardInfoListeners.put(getPackageName(), iTsmCallback);
        if (i == length) {
            return -3;
        }
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            int i2;
            String[] strArr2 = new String[length];
            for (i2 = 0; i2 < length; i2++) {
                if (strArr[i2] == null) {
                    strArr2[i2] = strArr[i2];
                } else {
                    strArr2[i2] = IUPJniInterface.aeM(strArr[i2]);
                }
            }
            i2 = this.mITsmService.getCardInfo(strArr2, new TsmCallback(1024));
            Message message = new Message();
            message.what = 1024;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 65000);
            if (-2 != i2) {
                return i2;
            }
            onSessionKeyInvalid(13, (Object) strArr, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(13, (Object) strArr, iTsmCallback);
        return 0;
    }

    public int setDefaultCard(String str, ITsmCallback iTsmCallback) throws RemoteException {
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            int defaultCard = this.mITsmService.setDefaultCard(IUPJniInterface.aeM(str), iTsmCallback);
            Message message = new Message();
            message.what = 1016;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 35000);
            if (-2 != defaultCard) {
                return defaultCard;
            }
            onSessionKeyInvalid(14, (Object) str, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(14, (Object) str, iTsmCallback);
        return 0;
    }

    public int getDefaultCard(ITsmCallback iTsmCallback) throws RemoteException {
        if (iTsmCallback == null) {
            return -3;
        }
        this.mGetDefaultCardListeners.put(getPackageName(), iTsmCallback);
        if (this.mITsmService == null) {
            return -1;
        }
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            int defaultCard = this.mITsmService.getDefaultCard(new TsmCallback(1015));
            Log.i(Constant.ADDON_LOG_TAG, "获取默认卡addon");
            Message message = new Message();
            message.what = 1015;
            message.obj = Integer.valueOf(iTsmCallback.hashCode());
            this.callInterfaceOvertimehandler.sendMessageDelayed(message, 35000);
            if (-2 != defaultCard) {
                return defaultCard;
            }
            onSessionKeyInvalid(20, null, iTsmCallback);
            return 0;
        }
        onSessionKeyInvalid(20, null, iTsmCallback);
        return 0;
    }

    public int getPubKey(ITsmCallback iTsmCallback) throws RemoteException {
        if (iTsmCallback == null) {
            return -3;
        }
        if (this.mITsmService != null) {
            return this.mITsmService.getPubKey(iTsmCallback);
        }
        return -1;
    }

    public int exchangeKey(ExchangeKeyRequestParams exchangeKeyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
        if (exchangeKeyRequestParams == null || iTsmCallback == null) {
            return -3;
        }
        if (this.mITsmService != null) {
            return this.mITsmService.exchangeKey(exchangeKeyRequestParams, iTsmCallback);
        }
        return -1;
    }

    public int openUniteCardApplyActivity(OpenUniteCardApplyActivityRequestParams openUniteCardApplyActivityRequestParams, Context context, ITsmCallback iTsmCallback) throws RemoteException {
        if (openUniteCardApplyActivityRequestParams == null) {
            return -3;
        }
        OpenUniteCardApplyActivityRequestParams openUniteCardApplyActivityRequestParams2 = new OpenUniteCardApplyActivityRequestParams();
        if (this.mITsmService == null) {
            return -1;
        }
        this.mActivityUniteApplyListeners.put(getPackageName(), iTsmCallback);
        this.mApplyUniteActivityLsteners.put(getPackageName(), new TsmActivityListener(context));
        if (IUPJniInterface.acSKV(this.mContext.getPackageName())) {
            Object span = openUniteCardApplyActivityRequestParams.getSpan();
            Object tCUrl = openUniteCardApplyActivityRequestParams.getTCUrl();
            Object bankName = openUniteCardApplyActivityRequestParams.getBankName();
            Object cardType = openUniteCardApplyActivityRequestParams.getCardType();
            ApplyActivityStyle applyActivityStyle = openUniteCardApplyActivityRequestParams.getmApplyActivityStyle();
            if (span == null || TextUtils.isEmpty(span)) {
                return -3;
            }
            openUniteCardApplyActivityRequestParams2.setSpan(IUPJniInterface.aeM(span));
            if (tCUrl == null || TextUtils.isEmpty(tCUrl)) {
                return -3;
            }
            openUniteCardApplyActivityRequestParams2.setTCUrl(IUPJniInterface.aeM(tCUrl));
            if (bankName == null || TextUtils.isEmpty(bankName)) {
                return -3;
            }
            openUniteCardApplyActivityRequestParams2.setBankName(IUPJniInterface.aeM(bankName));
            if (cardType == null || TextUtils.isEmpty(cardType)) {
                return -3;
            }
            openUniteCardApplyActivityRequestParams2.setCardType(IUPJniInterface.aeM(cardType));
            if (applyActivityStyle != null) {
                openUniteCardApplyActivityRequestParams2.setmApplyActivityStyle(applyActivityStyle);
            }
            int openUniteCardApplyActivity = this.mITsmService.openUniteCardApplyActivity(openUniteCardApplyActivityRequestParams2, new TsmActivityCallback(1031), new TsmCallback(1031));
            if (-2 != openUniteCardApplyActivity) {
                return openUniteCardApplyActivity;
            }
            onSessionKeyInvalid(33, (RequestParams) openUniteCardApplyActivityRequestParams, null);
            return 0;
        }
        onSessionKeyInvalid(33, (RequestParams) openUniteCardApplyActivityRequestParams, null);
        return 0;
    }

    private void onSessionKeyInvalid(int i, Object obj, ITsmCallback iTsmCallback) throws RemoteException {
        new SessionKeyReExchange(sInstance, i, obj, iTsmCallback).reGetPubKey();
    }

    private void onSessionKeyInvalid(int i, RequestParams requestParams, ITsmCallback iTsmCallback) throws RemoteException {
        new SessionKeyReExchange(sInstance, i, requestParams, iTsmCallback).reGetPubKey();
    }

    private void onSessionKeyInvalid(int i, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
        new SessionKeyReExchange(sInstance, i, requestParams, iTsmCallback, iTsmProgressCallback).reGetPubKey();
    }

    private void onSessionKeyInvalid(int i, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i2, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) throws RemoteException {
        new SessionKeyReExchange(sInstance, i, safetyKeyboardRequestParams, i2, onSafetyKeyboardCallback, context).reGetPubKey();
    }

    private boolean bindUPTsmService() {
        if (this.mServiceConnection == null) {
            this.mServiceConnection = new C65543();
        }
        if (this.isConnected) {
            return true;
        }
        Intent intent = new Intent(ACTION_TSM_SERVICE);
        intent.setPackage("com.unionpay.tsmbleuniteservice");
        return this.mContext.bindService(intent, this.mServiceConnection, 1);
    }

    private void unbindUPTsmService() {
        if (this.mServiceConnection != null && this.isConnected) {
            this.mContext.unbindService(this.mServiceConnection);
            this.isConnected = false;
        }
    }

    private void onTsmServiceConnected() {
        if (sTsmConnectionListeners != null && sTsmConnectionListeners.size() > 0) {
            Iterator it = sTsmConnectionListeners.iterator();
            while (it.hasNext()) {
                UPTsmConnectionListener uPTsmConnectionListener = (UPTsmConnectionListener) it.next();
                if (uPTsmConnectionListener != null) {
                    uPTsmConnectionListener.onTsmConnected();
                }
            }
        }
    }

    private void onTsmServiceDisconnected() {
        if (sTsmConnectionListeners != null && sTsmConnectionListeners.size() > 0) {
            Iterator it = sTsmConnectionListeners.iterator();
            while (it.hasNext()) {
                UPTsmConnectionListener uPTsmConnectionListener = (UPTsmConnectionListener) it.next();
                if (uPTsmConnectionListener != null) {
                    uPTsmConnectionListener.onTsmDisconnected();
                }
            }
        }
    }

    private String getPackageName() {
        return this.mContext.getPackageName();
    }

    private HashMap<String, ITsmActivityCallback> getActivityCallbackMap(int i) {
        switch (i) {
            case 1028:
                return this.mApplyActivityLsteners;
            case 1029:
                return this.mDetailActivityLsteners;
            case 1031:
                return this.mApplyUniteActivityLsteners;
            case Constant.CALLBACK_SHOW_SAFETYKEYBOARD /*1039*/:
                return this.mShowSaftyboardActivityListeners;
            default:
                return null;
        }
    }

    private HashMap<String, ITsmCallback> getCallbackMap(int i) {
        switch (i) {
            case 42:
                return this.mGetEncryptDataListeners;
            case 1000:
                return this.mInitListeners;
            case 1001:
                return this.mGetAssoAppListeners;
            case 1002:
                return this.mGetTransElementsListeners;
            case 1003:
                return this.mAppGetSMSAuthCodeListeners;
            case 1004:
                return this.mAppGetAccountInfoListeners;
            case 1005:
                return this.mAppGetAccountBalanceListeners;
            case 1006:
                return this.mAppDownloadApplyListeners;
            case 1009:
                return this.mGetAppListListeners;
            case 1010:
                return this.mGetAppDetailListeners;
            case 1011:
                return this.mOpenChannelListeners;
            case 1012:
                return this.mSendApduListeners;
            case 1014:
                return this.mGetSEAppListListeners;
            case 1015:
                return this.mGetDefaultCardListeners;
            case 1016:
                return this.mSetDefaultCardListeners;
            case 1017:
                return this.mAppGetTransRecordListeners;
            case 1018:
                return this.mAppECashTopupListeners;
            case 1019:
                return this.mGetSeIdListeners;
            case 1022:
                return this.mAppDataUpdateListeners;
            case 1023:
                return this.mEncryptDataListeners;
            case 1024:
                return this.mGetCardInfoListeners;
            case Constant.CALLBACK_GET_APP_STATUS /*1026*/:
                return this.mGetAppStatusListeners;
            case Constant.CALLBACK_BLE_KEY_EXCHANGE /*1027*/:
                return this.mBleKeyExchangeListeners;
            case 1028:
                return this.mActivityApplyDeleteListeners;
            case Constant.CALLBACK_CHECK_BIN_CODE /*1030*/:
                return this.mCheckBinCodeListeners;
            case 1031:
                return this.mActivityUniteApplyListeners;
            case Constant.CALLBACK_UNITE_APP_LIST /*1032*/:
                return this.mGetUniteAppListListeners;
            case Constant.CALLBACK_GET_ACTIVE_CODE /*1033*/:
                return this.mAppGetActiveCodeListeners;
            case Constant.CALLBACK_UNITE_CARD_ACTIVE /*1034*/:
                return this.mUniteAppActiveListeners;
            case Constant.CALLBACK_GET_SUPPORTED_CARD_TYPE_LIST /*1037*/:
                return this.mGetSupportedCardTypeListListeners;
            default:
                return null;
        }
    }

    private Bundle buildOvertimeResult() {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.KEY_ERROR_CODE, ResultCode.ERROR_INTERFACE_CALL_OVERTIME);
        bundle.putString(Constant.KEY_ERROR_DESC, "调用超时，请确认网络或者蓝牙状态");
        return bundle;
    }

    private void onCallbackResult(ITsmCallback iTsmCallback, Bundle bundle) {
        if (iTsmCallback != null) {
            try {
                String string = bundle.getString(Constant.KEY_ERROR_CODE);
                if ("10000".equals(string)) {
                    iTsmCallback.onResult(bundle);
                } else if (ResultCode.FAKE_ERROR_DUPLICATE_ACTIVE.equals(string)) {
                    iTsmCallback.onResult(bundle);
                } else {
                    iTsmCallback.onError(string, bundle.getString(Constant.KEY_ERROR_DESC));
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void onActivityCallBack(ITsmActivityCallback iTsmActivityCallback, String str, String str2, Bundle bundle) {
        if (iTsmActivityCallback != null) {
            try {
                iTsmActivityCallback.StartActivity(str, str2, bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
