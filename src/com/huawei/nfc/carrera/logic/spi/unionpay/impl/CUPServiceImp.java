package com.huawei.nfc.carrera.logic.spi.unionpay.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.logic.spi.unionpay.response.CUPEncryptResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.utils.PackageUtil;
import com.unionpay.tsmservice.ITsmCallback.Stub;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.result.EncryptDataResult;
import java.util.ArrayList;
import java.util.List;

public class CUPServiceImp implements CUPService, UPTsmConnectionListener {
    private static final int BINDING_TIME_OUT = 2000;
    private static final String CUP_TSM_APP_PACKAGE_NAME = "com.unionpay.tsmbleuniteservice";
    private final TsmCallback initResult;
    private final CUPResponseCodeInterpreter interpreter;
    private final Object lock = new Object();
    private final Context mContext;
    private final UPTsmAddon mUPTsmAddon;

    class TsmCallback extends Stub {
        private ClassLoader mClassLoader;
        String mErrorMsg;
        int resultCode;
        Object resultObject;

        TsmCallback() {
        }

        TsmCallback(ClassLoader classLoader) {
            this.mClassLoader = classLoader;
        }

        public void onError(String str, String str2) throws RemoteException {
            LogX.i("errorInfo, errorCode: " + str + " ,errorMsg: " + str2);
            LogX.d("onError threadId: " + Thread.currentThread().getId());
            synchronized (CUPServiceImp.this.lock) {
                this.resultCode = Integer.parseInt(str);
                this.mErrorMsg = str2;
                CUPServiceImp.this.lock.notifyAll();
            }
        }

        public void onResult(Bundle bundle) throws RemoteException {
            LogX.i("onResult.");
            LogX.d("onResult threadId: " + Thread.currentThread().getId());
            synchronized (CUPServiceImp.this.lock) {
                this.resultCode = 10000;
                if (this.mClassLoader != null) {
                    bundle.setClassLoader(this.mClassLoader);
                    this.resultObject = bundle.get("result");
                }
                CUPServiceImp.this.lock.notifyAll();
            }
        }
    }

    public CUPServiceImp(Context context) {
        this.mContext = context;
        this.interpreter = new CUPResponseCodeInterpreter();
        this.initResult = new TsmCallback();
        this.mUPTsmAddon = UPTsmAddon.getInstance(this.mContext);
        this.mUPTsmAddon.addConnectionListener(this);
    }

    public int init() {
        int initUPTsmAddon;
        synchronized (this.lock) {
            LogX.i("initService now.");
            initUPTsmAddon = initUPTsmAddon();
            if (initUPTsmAddon != 0) {
                LogX.d("initService, init up tsm addon failed.");
            } else {
                try {
                    int translateReponseCode;
                    if (this.initResult.resultCode != 10000) {
                        this.initResult.resultCode = 0;
                        InitRequestParams initRequestParams = new InitRequestParams();
                        initRequestParams.setType(3);
                        this.mUPTsmAddon.init(initRequestParams, this.initResult);
                        LogX.d("===123====initResult.resultCode: " + this.initResult.resultCode);
                        while (this.initResult.resultCode == 0 && this.mUPTsmAddon.isConnected()) {
                            LogX.d("initService threadId: " + Thread.currentThread().getId());
                            this.lock.wait(2000);
                        }
                    }
                    if (this.mUPTsmAddon.isConnected()) {
                        translateReponseCode = this.interpreter.translateReponseCode(this.initResult.resultCode, "initService", this.initResult.mErrorMsg);
                    } else {
                        LogX.e("cup tsm exception, when initing.");
                        translateReponseCode = this.interpreter.translateReponseCode(99999, "initService", null);
                    }
                    LogX.i("initService responseCode: " + translateReponseCode);
                    initUPTsmAddon = translateReponseCode;
                } catch (Throwable e) {
                    LogX.e("initService, remote exception: " + Log.getStackTraceString(e));
                    initUPTsmAddon = -99;
                } catch (Throwable e2) {
                    LogX.e("initService, interrupted exception: " + Log.getStackTraceString(e2));
                    initUPTsmAddon = -99;
                }
            }
        }
        return initUPTsmAddon;
    }

    public CUPEncryptResponse encryptCardInfo(String str) {
        synchronized (this.lock) {
            LogX.i("encryptCardInfo now.");
            CUPEncryptResponse cUPEncryptResponse = new CUPEncryptResponse();
            if (StringUtil.isEmpty(str, true)) {
                LogX.d("encryptCardInfo, params illegal.");
                cUPEncryptResponse.responseCode = -2;
                return cUPEncryptResponse;
            }
            int init = init();
            if (init != 0) {
                LogX.d("encryptCardInfo, init response error code: " + init);
                cUPEncryptResponse.responseCode = init;
                return cUPEncryptResponse;
            }
            try {
                EncryptDataRequestParams encryptDataRequestParams = new EncryptDataRequestParams();
                List arrayList = new ArrayList();
                arrayList.add(str);
                encryptDataRequestParams.setData(arrayList);
                TsmCallback tsmCallback = new TsmCallback(EncryptDataResult.class.getClassLoader());
                this.mUPTsmAddon.encryptData(encryptDataRequestParams, tsmCallback);
                while (tsmCallback.resultCode == 0 && this.mUPTsmAddon.isConnected()) {
                    LogX.d("encryptCardInfo threadId: " + Thread.currentThread().getId());
                    this.lock.wait(2000);
                }
                if (this.mUPTsmAddon.isConnected()) {
                    cUPEncryptResponse.responseCode = this.interpreter.translateReponseCode(tsmCallback.resultCode, "encryptCardInfo", tsmCallback.mErrorMsg);
                } else {
                    LogX.e("cup tsm service killed, when encrypting.");
                    cUPEncryptResponse.responseCode = this.interpreter.translateReponseCode(99999, "encryptCardInfo", null);
                }
                if (cUPEncryptResponse.responseCode == 0 && tsmCallback.resultObject != null) {
                    cUPEncryptResponse.encrytedStr = (String) ((EncryptDataResult) tsmCallback.resultObject).getEncryptData().get(0);
                }
            } catch (Throwable e) {
                LogX.e("encryptCardInfo, remote exception: " + Log.getStackTraceString(e));
                cUPEncryptResponse.responseCode = -99;
            } catch (Throwable e2) {
                LogX.e("encryptCardInfo, interrupted exception: " + Log.getStackTraceString(e2));
                cUPEncryptResponse.responseCode = -99;
            }
            LogX.i("encryptCardInfo result: " + cUPEncryptResponse.responseCode);
            return cUPEncryptResponse;
        }
    }

    public int excuteCMD(String str, String str2) {
        int i;
        synchronized (this.lock) {
            LogX.i("excuteCMD");
            if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true)) {
                LogX.d("excuteCMD, params illegal.");
                i = -2;
            } else {
                i = init();
                if (i != 0) {
                    LogX.d("excuteCMD, init response error code: " + i);
                } else {
                    try {
                        ExecuteCmdRequestParams executeCmdRequestParams = new ExecuteCmdRequestParams();
                        executeCmdRequestParams.setSign(str2);
                        executeCmdRequestParams.setSsid(str);
                        TsmCallback tsmCallback = new TsmCallback();
                        this.mUPTsmAddon.executeCmd(executeCmdRequestParams, tsmCallback, null);
                        while (this.mUPTsmAddon.isConnected() && tsmCallback.resultCode == 0) {
                            LogX.d("excuteCMD threadId: " + Thread.currentThread().getId());
                            this.lock.wait();
                        }
                        if (this.mUPTsmAddon.isConnected()) {
                            i = this.interpreter.translateReponseCode(tsmCallback.resultCode, "excuteCMD", tsmCallback.mErrorMsg);
                        } else {
                            LogX.e("cup tsm service killed, when excuteCMDing.");
                            i = this.interpreter.translateReponseCode(99999, "excuteCMD", null);
                        }
                    } catch (Throwable e) {
                        LogX.e("excuteCMD, remote exception: " + Log.getStackTraceString(e));
                        i = -99;
                    } catch (Throwable e2) {
                        LogX.e("excuteCMD, interrupted exception: " + Log.getStackTraceString(e2));
                        i = -99;
                    }
                    LogX.i("excuteCMD responseCode: " + i);
                }
            }
        }
        return i;
    }

    private int initUPTsmAddon() {
        int i;
        synchronized (this.lock) {
            if (PackageUtil.m28463b(this.mContext, "com.unionpay.tsmbleuniteservice")) {
                while (!this.mUPTsmAddon.isConnected()) {
                    LogX.i("initUPTsmAddon, bind tsm addon now.");
                    this.mUPTsmAddon.bind();
                    try {
                        LogX.d("initUPTsmAddon threadId: " + Thread.currentThread().getId());
                        this.lock.wait(2000);
                        if (!this.mUPTsmAddon.isConnected()) {
                            i = -5;
                            break;
                        }
                    } catch (InterruptedException e) {
                        LogX.e("initUPTsmAddon, interruptedException.");
                    }
                }
                i = 0;
            } else {
                LogX.e("initUPTsmAddon, but package is not installed.");
                i = -1;
            }
        }
        return i;
    }

    public void onTsmConnected() {
        LogX.i("UPTsmAddon connected.");
        LogX.d("onTsmConnected threadId: " + Thread.currentThread().getId());
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public void onTsmDisconnected() {
        LogX.i("UPTsmAddon disconnected.");
        LogX.d("onTsmDisconnected threadId: " + Thread.currentThread().getId());
        synchronized (this.lock) {
            this.initResult.resultCode = 99999;
            this.lock.notifyAll();
        }
    }
}
