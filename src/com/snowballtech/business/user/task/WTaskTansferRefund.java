package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.bean.Spid;
import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.business.inner.BusinessCardsStatus;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;

public class WTaskTansferRefund implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_TRANSFERREFUND;
    private String sp_id;
    CommonUtils utils = CommonUtils.getInstance();

    public String executeTask(TaskParam taskParam) throws SnowballException {
        TaskResult operate;
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        int checkParam = this.utils.checkParam(taskParam, this, true, false);
        TaskResult taskResult = new TaskResult();
        WSProviderBean wSProviderBean = new WSProviderBean();
        wSProviderBean = (WSProviderBean) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), WSProviderBean.class);
        boolean z;
        if (checkParam == 0) {
            if ("none".equals(wSProviderBean.getInstance_id())) {
                wSProviderBean.setInstance_id("");
                LogUtil.log(this.TAG, " instance_id is none,not loadinstall,no need to synchronized card status ");
                z = false;
            } else {
                LogUtil.log(this.TAG, " instance_id is " + wSProviderBean.getInstance_id() + " maybe loadinstall, need to synchronized card status ");
                z = true;
            }
            Spid spid = (Spid) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), Spid.class);
            if (!(spid == null || spid.getSp_id() == null)) {
                this.sp_id = spid.getSp_id();
            }
            wSProviderBean.setCategory("deleteapp");
            wSProviderBean.setRefundData(taskParam.getInputParam());
            WTaskProcess wTaskProcess = new WTaskProcess();
            wTaskProcess.setSp_id(this.sp_id);
            operate = wTaskProcess.operate(RequestKey.KEY_TRANSFERREFUND, JsonUtil.getInstance().serializeObject(wSProviderBean, new boolean[0]), taskParam.getContext());
            LogUtil.log(this.TAG, this.TAG + "executeTask  result =" + operate.getResult_code());
        } else {
            LogUtil.loge(this.TAG, this.TAG + "executeTask  result =" + taskResult.getResult_code());
            z = true;
            operate = taskResult;
        }
        if (operate.getResult_code().equals("0") || (operate.getResult_code().equals("0000") && r2)) {
            new BusinessCardsStatus(0).synchronizedCardsStatusFromServer(taskParam.getContext(), true);
            LogUtil.log(this.TAG, this.TAG + "  synchronized the cardstatus successfully ");
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(operate, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return serializeObject;
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }
}
