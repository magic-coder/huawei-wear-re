package com.snowballtech.common.synctask;

public class SynchronizedManager {
    private static volatile SynchronizedManager singleton;
    private SynchronizedControl sync = new SynchronizedControl(5000);

    public static SynchronizedManager getInstance() {
        if (singleton == null) {
            synchronized (SynchronizedManager.class) {
                if (singleton == null) {
                    singleton = new SynchronizedManager();
                }
            }
        }
        return singleton;
    }

    public SynchronizedControl getSm() {
        return this.sync;
    }

    public void setSm(long j) {
        if (this.sync != null && this.sync.getWait_time() == j) {
            this.sync = null;
        }
        this.sync = new SynchronizedControl(j);
    }
}
