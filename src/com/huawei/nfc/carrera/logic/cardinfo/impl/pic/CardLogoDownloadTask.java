package com.huawei.nfc.carrera.logic.cardinfo.impl.pic;

import android.content.Context;
import com.huawei.nfc.carrera.util.LogX;

class CardLogoDownloadTask extends CardPicDownloadTask {
    private CardIconDownloadResultCallback mCallback;

    CardLogoDownloadTask(Context context, String str, String str2, CardIconDownloadResultCallback cardIconDownloadResultCallback) {
        super(context, str, str2);
        this.mCallback = cardIconDownloadResultCallback;
    }

    protected String getPicDirPath() {
        return CardPicPathConfig.getCardLogoDirPath(this.mContext);
    }

    protected String getPicFilePath() {
        return CardPicPathConfig.getCardLogoPath(this.mContext, this.curId);
    }

    protected void handleDownloadResult(String str, int i) {
        LogX.i("card logo downloaded issuerId: " + str + ",result: " + i);
        this.mCallback.downloadIconResult(1, str, i);
    }

    protected boolean editPicFile(String str) {
        return false;
    }
}
