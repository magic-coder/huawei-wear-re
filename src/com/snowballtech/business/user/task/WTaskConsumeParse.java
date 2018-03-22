package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.inner.BusinessCardConsume;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.PluginUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class WTaskConsumeParse implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_CONSUME_PARSE;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        if (ValueUtil.isEmpty(taskParam.getInputParam())) {
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_NULL);
        }
        Object taskResult = new TaskResult();
        int checkParam = CommonUtils.getInstance().checkParam(taskParam, this, false, false);
        if (checkParam == 0) {
            checkParam = PluginUtils.getInstance().validateParam(taskParam, this);
        }
        if (checkParam == 0) {
            WSProviderBean wSProviderBean = (WSProviderBean) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), WSProviderBean.class);
            taskResult = new BusinessCardConsume(0).consumeParse(wSProviderBean.getInstance_id(), wSProviderBean.getData());
        } else {
            LogUtil.loge(this.TAG, "executeTask param is invalid");
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return serializeObject;
    }

    public boolean isNeedNetWork(Context context) {
        return false;
    }
}
