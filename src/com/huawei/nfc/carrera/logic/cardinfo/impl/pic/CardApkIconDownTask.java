package com.huawei.nfc.carrera.logic.cardinfo.impl.pic;

import android.content.Context;
import com.huawei.nfc.carrera.util.LogX;

public class CardApkIconDownTask extends CardPicDownloadTask {
    private CardIconDownloadResultCallback mCallback;

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    CardApkIconDownTask(Context context, String str, String str2, CardIconDownloadResultCallback cardIconDownloadResultCallback) {
        super(context, str, str2);
        this.mCallback = cardIconDownloadResultCallback;
    }

    protected String getPicDirPath() {
        return CardPicPathConfig.getCardApkIconDirPath(this.mContext);
    }

    protected String getPicFilePath() {
        return CardPicPathConfig.getCardApkIconPath(this.mContext, this.curId);
    }

    protected void handleDownloadResult(String str, int i) {
        LogX.i("card apk icon downloaded appId: " + str + ",result: " + i);
        this.mCallback.downloadIconResult(2, str, i);
    }

    protected boolean editPicFile(String str) {
        return false;
    }
}
