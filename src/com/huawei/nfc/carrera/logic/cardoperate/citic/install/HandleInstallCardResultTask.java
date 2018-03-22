package com.huawei.nfc.carrera.logic.cardoperate.citic.install;

import android.os.Handler;
import com.huawei.nfc.carrera.logic.cardoperate.response.InstallCardResultCallback;

public class HandleInstallCardResultTask implements Runnable {
    private Handler mExcuteHandler;
    private InstallCardResultCallback mResultCallback;
    private int resultCode;
    private String resultProductId;
    private String resultRefId;

    public HandleInstallCardResultTask(Handler handler, InstallCardResultCallback installCardResultCallback) {
        this.mExcuteHandler = handler;
        this.mResultCallback = installCardResultCallback;
    }

    public void notifyInstallResult(int i, String str, String str2) {
        this.resultCode = i;
        this.resultProductId = str;
        this.resultRefId = str2;
        this.mExcuteHandler.post(this);
    }

    public void run() {
        if (this.mResultCallback != null) {
            this.mResultCallback.installResultCallback(this.resultCode, this.resultProductId, this.resultRefId);
        }
    }
}
