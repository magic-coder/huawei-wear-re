package com.huawei.nfc.carrera.logic.cardoperate.cup;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.util.LogX;

class InitCUPServiceTask implements Runnable {
    private final CUPService mCUPApi;
    private final InitCUPServiceResultTask resultHandler;

    InitCUPServiceTask(Context context, CUPService cUPService, InitCUPServiceResultTask initCUPServiceResultTask) {
        this.mCUPApi = cUPService;
        this.resultHandler = initCUPServiceResultTask;
    }

    public void run() {
        handleInitResult(translateInitServiceReturnCode(this.mCUPApi.init()));
    }

    private int translateInitServiceReturnCode(int i) {
        int i2 = -3;
        if (i == 0) {
            i2 = 0;
        } else if (i != -3) {
            if (i == -5) {
                i2 = -5;
            } else {
                i2 = -99;
            }
        }
        LogX.i("translateInitServiceReturnCode callbackReturnCode " + i2);
        return i2;
    }

    private void handleInitResult(int i) {
        if (this.resultHandler != null) {
            this.resultHandler.handleResult(i);
        }
    }
}
