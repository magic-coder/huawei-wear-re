package com.huawei.nfc.carrera.logic.cardinfo.impl.pic;

import android.content.Context;
import com.huawei.wallet.storage.path.NfcStorageUtil;

public class CardRFConfFileDownloadTask extends CardPicDownloadTask {
    private CardIconDownloadResultCallback mCallback;

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public CardRFConfFileDownloadTask(Context context, String str, String str2, CardIconDownloadResultCallback cardIconDownloadResultCallback) {
        super(context, str, str2);
        this.mCallback = cardIconDownloadResultCallback;
    }

    protected boolean editPicFile(String str) {
        return false;
    }

    protected String getPicDirPath() {
        return NfcStorageUtil.m28138d(this.mContext);
    }

    protected String getPicFilePath() {
        return NfcStorageUtil.m28139d(this.mContext, this.curId);
    }

    protected void handleDownloadResult(String str, int i) {
        if (this.mCallback != null) {
            this.mCallback.downloadIconResult(3, str, i);
        }
    }
}
