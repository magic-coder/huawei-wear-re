package com.snowballtech.business.user.task;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.snowballtech.apdu.IApdu;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.ConfigUtil;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.env.IEnv;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;

public class WTaskSetDevice implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_SET_DEVICE;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        long currentTimeMillis = System.currentTimeMillis();
        int checkParam = CommonUtils.getInstance().checkParam(taskParam, this, false, false);
        TaskResult taskResult = new TaskResult();
        if (checkParam != 0) {
            LogUtil.loge(this.TAG, " CardInfo_Param not valid, do NOT setDevice for IEnv");
            taskResult.setResult_code("1");
            taskResult.setResult_msg("Param not valid");
        } else if (ConfigUtil.getInstance().isCanSetDevice()) {
            IEnv instanceEnv = ConfigUtil.getInstance().instanceEnv();
            IApdu instanceOma = ConfigUtil.getInstance().instanceOma();
            if (instanceEnv == null || instanceOma == null) {
                LogUtil.loge(this.TAG, " CardInfo_envParam or apdu is null, skip and do NOT setDevice for IEnv");
                taskResult.setResult_code("1");
                taskResult.setResult_msg("env or apdu is null");
            } else {
                instanceEnv.SetDevice(taskParam.getInputParam());
                instanceOma.SetDevice(taskParam.getInputParam());
                taskResult.setResult_code("0");
                taskResult.setResult_msg("SetDevice success");
            }
        } else {
            LogUtil.loge(this.TAG, " CardInfo_not smart device, skip and do NOT setDevice for IEnv");
            taskResult.setResult_code("1");
            taskResult.setResult_msg("not smart device");
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + HwAccountConstants.BLANK + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return serializeObject;
    }

    public boolean isNeedNetWork(Context context) throws SnowballException {
        return false;
    }
}
