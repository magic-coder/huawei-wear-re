package com.snowballtech.business.user.task;

import android.content.Context;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.inner.BusinessCardSetDefault;
import com.snowballtech.business.util.CardStatuCacheUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class WTaskCardDeactivate implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_CARD_DEACTIVATE;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask  start");
        if (ValueUtil.isEmpty(taskParam.getInputParam())) {
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_NULL);
        }
        long currentTimeMillis = System.currentTimeMillis();
        TaskResult taskResult = new TaskResult();
        int deactivateCard = new BusinessCardSetDefault(0).deactivateCard(taskParam.getContext(), taskParam.getInputParam());
        taskResult.setResult_code(deactivateCard + "");
        if (deactivateCard == 0) {
            taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return serializeObject;
    }

    public boolean isNeedNetWork(Context context) throws SnowballException {
        if (ValueUtil.isEmpty(CardStatuCacheUtils.getInstance().getCardCacheByString(context))) {
            return true;
        }
        return false;
    }
}
