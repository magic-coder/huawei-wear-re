package com.huawei.nfc.carrera.logic.swipe.channel;

import com.huawei.nfc.carrera.logic.ta.TACardInfo;

class ChannelManager$GetDefaultCardCallbackRunnable implements Runnable {
    private GetDefaultCardCallback mCallback;
    private TACardInfo mDefaultCard;

    ChannelManager$GetDefaultCardCallbackRunnable(GetDefaultCardCallback getDefaultCardCallback, TACardInfo tACardInfo) {
        this.mCallback = getDefaultCardCallback;
        this.mDefaultCard = tACardInfo;
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.getDefaultCardCallback(this.mDefaultCard);
        }
    }
}
