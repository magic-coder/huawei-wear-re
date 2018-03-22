package com.huawei.nfc.carrera.logic.swipe.channel;

class ChannelManager$ChannelOpenResultRunnable implements Runnable {
    private ChannelOpenCallback mCallback;
    private boolean mResult;

    ChannelManager$ChannelOpenResultRunnable(ChannelOpenCallback channelOpenCallback, boolean z) {
        this.mCallback = channelOpenCallback;
        this.mResult = z;
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.openChannelResult(this.mResult);
        }
    }
}
