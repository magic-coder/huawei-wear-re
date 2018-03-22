package com.huawei.nfc.carrera.logic.cardinfo.impl;

import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;

class SetDefaultCardCallbackTask implements Runnable {
    private SetCardDefaultCallback mCallback;
    private boolean setDefaultResult;

    SetDefaultCardCallbackTask(SetCardDefaultCallback setCardDefaultCallback, boolean z) {
        this.mCallback = setCardDefaultCallback;
        this.setDefaultResult = z;
    }

    public void run() {
        this.mCallback.setResultCallback(this.setDefaultResult ? 0 : -1);
    }
}
