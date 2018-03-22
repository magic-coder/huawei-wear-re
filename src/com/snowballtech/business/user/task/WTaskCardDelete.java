package com.snowballtech.business.user.task;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;

public class WTaskCardDelete implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_CARD_DELETE;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        String executeTask;
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        if (CommonUtils.getInstance().checkParam(taskParam, this, true, false) == 0) {
            WTaskAppletManage wTaskAppletManage = new WTaskAppletManage();
            WSProviderBean wSProviderBean = (WSProviderBean) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), WSProviderBean.class);
            wSProviderBean.setCategory("deleteapp");
            taskParam.setInputParam(JsonUtil.getInstance().serializeObject(wSProviderBean, new boolean[0]));
            wTaskAppletManage.setTAG(Constant.LOG_FLAG_CARD_DELETE);
            executeTask = wTaskAppletManage.executeTask(taskParam);
        } else {
            LogUtil.loge(this.TAG, "executeTask param is invalid");
            executeTask = JsonUtil.getInstance().serializeObject(new TaskResult(), new boolean[0]);
        }
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + HwAccountConstants.BLANK + LogUtil.RESPONSE_RESULT + "  result =" + executeTask + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return executeTask;
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }
}
