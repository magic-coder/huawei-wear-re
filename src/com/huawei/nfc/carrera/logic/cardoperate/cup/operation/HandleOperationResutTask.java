package com.huawei.nfc.carrera.logic.cardoperate.cup.operation;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.HandleCUPOperateResultCallback;

public class HandleOperationResutTask implements Runnable {
    private Handler mExcuteHandler;
    private HandleCUPOperateResultCallback mResultCallback;
    private int resultCode;

    public HandleOperationResutTask(Handler handler, HandleCUPOperateResultCallback handleCUPOperateResultCallback) {
        this.mExcuteHandler = handler;
        this.mResultCallback = handleCUPOperateResultCallback;
    }

    public void notifyOperateResult(int i) {
        this.resultCode = i;
        this.mExcuteHandler.post(this);
    }

    public void run() {
        if (this.mResultCallback != null) {
            this.mResultCallback.operateResultCallback(this.resultCode);
        }
    }
}
