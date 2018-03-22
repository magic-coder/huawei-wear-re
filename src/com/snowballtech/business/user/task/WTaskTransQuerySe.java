package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.inner.BusinessCardTransaction;
import com.snowballtech.business.util.CardStatuCacheUtils;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class WTaskTransQuerySe implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_TRANS_QUERY_SE;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        if (ValueUtil.isEmpty(taskParam.getInputParam())) {
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_NULL);
        }
        int validateEnvironment = CommonUtils.getInstance().validateEnvironment(taskParam.getContext(), false, false);
        Object taskResult = new TaskResult();
        if (validateEnvironment == 0) {
            taskResult = new BusinessCardTransaction(0).fetchCardTransSe(taskParam.getContext(), taskParam.getInputParam());
        } else {
            LogUtil.loge(this.TAG, "executeTask param is invalid");
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
