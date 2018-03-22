package com.huawei.nfc.carrera.logic.swipe.channel;

class ChannelManager$ChannelCloseResultRunnable implements Runnable {
    private ChannelCloseCallback mCallback;
    private boolean mResult;

    ChannelManager$ChannelCloseResultRunnable(ChannelCloseCallback channelCloseCallback, boolean z) {
        this.mCallback = channelCloseCallback;
        this.mResult = z;
    }

    public void run() {
        if (this.mCallback != null) {
            this.mCallback.closeChannelResult(this.mResult);
        }
    }
}
