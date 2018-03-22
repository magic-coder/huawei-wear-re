package com.snowballtech.business.user.task;

import android.content.Context;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;

public class WTaskInit implements IWalletServiceTask {
    private String TAG = "init";

    public String executeTask(TaskParam taskParam) throws SnowballException {
        TaskResult taskResult = new TaskResult();
        long currentTimeMillis = System.currentTimeMillis();
        TaskResult taskResult2 = (TaskResult) JsonUtil.getInstance().deSerializeString(new WTaskGetCplc().executeTask(taskParam), TaskResult.class);
        if (String.valueOf(0).equals(taskResult2.getResult_code())) {
            taskResult.setResult_code("0");
            taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        } else {
            taskResult.setResult_code(taskResult2.getResult_code());
            taskResult.setResult_msg(taskResult2.getResult_msg());
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return serializeObject;
    }

    public boolean isNeedNetWork(Context context) {
        return false;
    }
}
