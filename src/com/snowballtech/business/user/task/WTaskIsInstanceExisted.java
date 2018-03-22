package com.snowballtech.business.user.task;

import android.content.Context;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.inner.BusinessCardIsInstanceExist;
import com.snowballtech.business.util.CardStatuCacheUtils;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class WTaskIsInstanceExisted implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_IS_INSTANCE_EXISTED;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        if (ValueUtil.isEmpty(taskParam.getInputParam())) {
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_NULL);
        }
        String str;
        int validateEnvironment = CommonUtils.getInstance().validateEnvironment(taskParam.getContext(), false, true);
        TaskResult taskResult = new TaskResult();
        if (validateEnvironment == 0) {
            validateEnvironment = new BusinessCardIsInstanceExist(0).isInstanceExist(taskParam.getContext(), taskParam.getInputParam(), false);
            if (validateEnvironment == 1 || validateEnvironment == 2) {
                taskResult.setResult_code("0");
                StringBuilder append = new StringBuilder().append("instance_id:").append(taskParam.getInputParam()).append(",");
                if (validateEnvironment == 1) {
                    str = "已安装";
                } else {
                    str = "已个人化";
                }
                taskResult.setResult_msg(append.append(str).toString());
            } else {
                taskResult.setResult_code("499999");
                taskResult.setResult_msg("instance_id:" + taskParam.getInputParam() + "未安装");
            }
        } else if (validateEnvironment == 400001) {
            taskResult.setResult_code(RetCode.SUC_400001);
            taskResult.setResult_msg(com.snowballtech.common.constant.CodeMessage.ENVIRONMENT_NETWORK_DISABLED_MSG);
        } else if (validateEnvironment == 400002) {
            taskResult.setResult_code(RetCode.FAILED_400002);
            taskResult.setResult_msg(CodeMessage.ENVIRONMENT_NFC_DISABLED_MSG);
        } else {
            LogUtil.loge(this.TAG, this.TAG + " should never come here ");
        }
        str = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + str + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return str;
    }

    public boolean isNeedNetWork(Context context) throws SnowballException {
        if (ValueUtil.isEmpty(CardStatuCacheUtils.getInstance().getCardCacheByString(context))) {
            return true;
        }
        return false;
    }
}
