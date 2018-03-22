package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;

public class WTaskSwitchLog implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_SWITCH_LOG;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        String inputParam = taskParam.getInputParam();
        LogUtil.switchLog(inputParam);
        return "{\"result_code\":\"0\",\"result_msg\":\"" + inputParam + " success\"}";
    }

    public boolean isNeedNetWork(Context context) {
        return false;
    }
}
