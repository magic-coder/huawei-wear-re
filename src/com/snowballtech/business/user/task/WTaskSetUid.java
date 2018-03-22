package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;

public class WTaskSetUid implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_SET_UID;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        taskParam.setInputParam("{\"category\":\"setuid\",\"instance_id\":\"none\"}");
        long currentTimeMillis = System.currentTimeMillis();
        String executeTask = new WTaskAppletManage().executeTask(taskParam);
        LogUtil.log(this.TAG, this.TAG + LogUtil.RESPONSE_RESULT + "  result =" + executeTask + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return executeTask;
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }
}
