package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.common.exception.SnowballException;

public class WTaskPostService implements IWalletServiceTask {
    private WTaskBase mWTaskBase;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        this.mWTaskBase = new WTaskBase();
        return this.mWTaskBase.executeTask(taskParam);
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }
}
