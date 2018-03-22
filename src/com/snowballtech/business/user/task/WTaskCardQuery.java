package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.inner.BusinessCardDetail;
import com.snowballtech.business.util.CardStatuCacheUtils;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.PluginUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class WTaskCardQuery implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_CARD_QUERY;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        Object fetchCardDetail;
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        int checkParam = CommonUtils.getInstance().checkParam(taskParam, this, false, false);
        if (checkParam == 0) {
            checkParam = PluginUtils.getInstance().validateParam(taskParam, this);
        }
        TaskResult taskResult = new TaskResult();
        if (checkParam == 0) {
            WSProviderBean wSProviderBean = (WSProviderBean) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), WSProviderBean.class);
            fetchCardDetail = new BusinessCardDetail(0).fetchCardDetail(taskParam.getContext(), wSProviderBean.getInstance_id(), wSProviderBean.getTag());
        } else {
            LogUtil.loge(this.TAG, "executeTask param is invalid");
            TaskResult taskResult2 = taskResult;
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(fetchCardDetail, new boolean[0]);
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
