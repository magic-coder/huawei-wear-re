package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.common.exception.SnowballException;

public interface IWalletServiceTask {
    String executeTask(TaskParam taskParam) throws SnowballException;

    boolean isNeedNetWork(Context context) throws SnowballException;
}
