package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;

public class WTaskCardTopup implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_CARD_TOPUP;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        int checkParam = CommonUtils.getInstance().checkParam(taskParam, this, true, false);
        TaskResult taskResult = new TaskResult();
        String str = "";
        if (checkParam == 0) {
            taskResult = new WTaskProcess().operate(RequestKey.KEY_CARDTOPUP, taskParam.getInputParam(), taskParam.getContext());
            LogUtil.log(this.TAG, this.TAG + "  result =" + taskResult.getResult_code());
            str = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        } else {
            LogUtil.loge(this.TAG, "executeTask param is invalid");
        }
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + str + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return str;
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }
}
