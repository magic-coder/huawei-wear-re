package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.business.inner.BusinessCardsStatus;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;

public class WTaskAppletManage implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_APPLET_MANAGE;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        int checkParam = CommonUtils.getInstance().checkParam(taskParam, this, true, false);
        TaskResult taskResult = new TaskResult();
        WSProviderBean wSProviderBean = (WSProviderBean) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), WSProviderBean.class);
        boolean z;
        if (checkParam == 0) {
            if (wSProviderBean.getInstance_id().equals("none")) {
                LogUtil.log(this.TAG + " instance_id is none,not loadinstall,no need to synchronized card status ");
                z = false;
            } else {
                LogUtil.log(this.TAG + " instance_id is " + wSProviderBean.getInstance_id() + " maybe loadinstall, need to synchronized card status ");
                z = true;
            }
            taskResult = new WTaskProcess().operate(RequestKey.KEY_APPLETMANNAGE, taskParam.getInputParam(), taskParam.getContext());
        } else {
            LogUtil.loge(this.TAG, "executeTask param is invalid");
            z = true;
        }
        LogUtil.log(this.TAG, this.TAG + "  result =" + taskResult.getResult_code());
        if (taskResult.getResult_code().equals("0") && r0) {
            new BusinessCardsStatus(0).synchronizedCardsStatusFromServer(taskParam.getContext(), true);
            LogUtil.log(this.TAG, this.TAG + "executeTask  synchronized the cardstatus successfully ");
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return serializeObject;
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }

    public String getTAG() {
        return this.TAG;
    }

    public void setTAG(String str) {
        this.TAG = str;
    }
}
