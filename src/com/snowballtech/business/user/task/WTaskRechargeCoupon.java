package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.common.exception.SnowballException;

public class WTaskRechargeCoupon implements IWalletServiceTask {
    private WTaskBase mWTaskBase;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        if (this.mWTaskBase == null) {
            this.mWTaskBase = new WTaskBase();
        }
        taskParam.setOperation(RequestKey.KEY_RECHARGECOUPON);
        return this.mWTaskBase.executeTask(taskParam);
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }
}
