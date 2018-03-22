package com.huawei.nfc.carrera.logic.cardoperate.identifycard;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.CardTypeIdentifyCallback;
import com.huawei.nfc.carrera.util.LogX;

public class HandleIdentifyIssuerResultTask implements Runnable {
    private CardTypeIdentifyCallback mCallback;
    private Handler mHandler;
    private int resultCardType;
    private int resultIdentifyCode;
    private String resultIssuerId;
    private int resultMode;

    public HandleIdentifyIssuerResultTask(Handler handler, CardTypeIdentifyCallback cardTypeIdentifyCallback) {
        this.mHandler = handler;
        this.mCallback = cardTypeIdentifyCallback;
    }

    public void notifyIdentifyResult(int i, String str, int i2, int i3) {
        LogX.i("notifyIdentifyResult, resultCode: " + i + ",issuerId: " + str + ",cardType: " + i2 + ",mode: " + i3);
        this.resultIdentifyCode = i;
        this.resultIssuerId = str;
        this.resultCardType = i2;
        this.resultMode = i3;
        this.mHandler.post(this);
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.identifyResult(this.resultIdentifyCode, this.resultIssuerId, this.resultCardType, this.resultMode);
        }
    }
}
