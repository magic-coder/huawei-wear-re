package com.snowballtech.business;

import android.content.Context;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.user.task.IWalletServiceTask;
import com.snowballtech.business.user.task.TaskParam;
import com.snowballtech.business.util.ConfigUtil;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.DeviceUtil;
import com.snowballtech.common.util.JsonUtil;

public class BusinessProcess implements IBusinessProcess {
    public static final String TAG = "BusinessProcess";

    public String process(IWalletServiceTask iWalletServiceTask, Context context, String str, String str2) {
        return checkoutEvn(iWalletServiceTask, context, str, str2);
    }

    public synchronized String processSynchronized(IWalletServiceTask iWalletServiceTask, Context context, String str, String str2) {
        return checkoutEvn(iWalletServiceTask, context, str, str2);
    }

    private boolean checkContext(Context context, TaskResult<String> taskResult) {
        if (context != null) {
            return false;
        }
        taskResult.setResult_msg(CodeMessage.BUSINESS_PARAM_CONTEXT_NULL_MSG);
        taskResult.setResult_code("410001");
        return true;
    }

    private boolean checkNetWork(Context context, TaskResult<String> taskResult) {
        if (!ConfigUtil.getInstance().isNeedCheckNetwork() || !DeviceUtil.getInstance().checkNetWorkDisable(context)) {
            return false;
        }
        LogUtil.loge(TAG, " checkNetWork Need network but network disabled");
        taskResult.setResult_msg(com.snowballtech.common.constant.CodeMessage.ENVIRONMENT_NETWORK_DISABLED_MSG);
        taskResult.setResult_code(RetCode.SUC_400001);
        return true;
    }

    private boolean checkNFC(Context context, TaskResult<String> taskResult) {
        if (!ConfigUtil.getInstance().isNeedCheckNfc() || !DeviceUtil.getInstance().checkNFCDisable(context)) {
            return false;
        }
        LogUtil.loge(TAG, " checkNFC Need Nfc but Nfc disabled");
        taskResult.setResult_msg(CodeMessage.ENVIRONMENT_NFC_DISABLED_MSG);
        taskResult.setResult_code(RetCode.FAILED_400002);
        return true;
    }

    private String checkoutEvn(IWalletServiceTask iWalletServiceTask, Context context, String str, String str2) {
        TaskResult taskResult = new TaskResult();
        String str3 = "";
        LogUtil.log(TAG, " ws sdk process the business:_call_api_request_param==" + str2 + LogUtil.REQUEST_OPERATION + str);
        if (iWalletServiceTask != null) {
            LogUtil.log(TAG, " ws sdk process the wsTask is" + iWalletServiceTask.getClass().getCanonicalName());
            TaskParam taskParam = new TaskParam();
            taskParam.setContext(context.getApplicationContext());
            taskParam.setOperation(str);
            taskParam.setInputParam(str2);
            if (checkContext(taskParam.getContext(), taskResult)) {
                return JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
            }
            if (checkNFC(taskParam.getContext(), taskResult)) {
                return JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
            }
            try {
                if (iWalletServiceTask.isNeedNetWork(taskParam.getContext()) && checkNetWork(taskParam.getContext(), taskResult)) {
                    return JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
                }
                return iWalletServiceTask.executeTask(taskParam);
            } catch (SnowballException e) {
                e.printStackTrace();
                LogUtil.loge(TAG, "snowballexception code is " + e.getResult_code() + "message " + e.getMessage());
                taskResult.setResult_code(e.getResult_code() + "");
                taskResult.setResult_msg(e.getMessage());
                return JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
            }
        }
        LogUtil.log(TAG, " ws sdk process the wsTask is null");
        taskResult.setResult_code("499999");
        taskResult.setResult_msg(com.snowballtech.common.constant.CodeMessage.EXCEPTION_ERROR_MSG);
        return JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
    }
}
