package com.snowballtech.common.synctask;

import com.snowballtech.common.log.LogUtil;

public class SynchronizedControl {
    private String TAG = "SynchronizedManager";
    private Object locker;
    private long wait_time = 5000;

    public SynchronizedControl(long j) {
        this.wait_time = j;
        this.locker = new Object();
    }

    public long getWait_time() {
        return this.wait_time;
    }

    public void lock() {
        try {
            synchronized (this.locker) {
                LogUtil.log(this.TAG, "locker.wait(),wait_time=" + this.wait_time);
                this.locker.wait(this.wait_time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            LogUtil.loge(this.TAG, "Lock exception: " + e.getMessage());
        }
    }

    public void unLock() {
        synchronized (this.locker) {
            LogUtil.log(this.TAG, "locker.notify()");
            this.locker.notify();
        }
    }
}
