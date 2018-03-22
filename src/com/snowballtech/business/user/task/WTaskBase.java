package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.business.bean.SNBResponse;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.util.RequestSNBSeviceUtil;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class WTaskBase implements IWalletServiceTask {
    private String TAG = "WTaskBase";
    private RequestSNBSeviceUtil mRequestSNBSeviceUtil;
    private TaskResult<String> mTaskResult;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask start ");
        if (this.mRequestSNBSeviceUtil == null) {
            this.mRequestSNBSeviceUtil = new RequestSNBSeviceUtil(taskParam.getContext());
        }
        if (taskParam == null || ValueUtil.isEmpty(taskParam.getInputParam()) || ValueUtil.isEmpty(taskParam.getOperation())) {
            LogUtil.loge(this.TAG, "executeTask param is invalid");
            setFaildTask("410005", CodeMessage.BUSINESS_PARAM_DATA_NULL_MSG);
        } else {
            this.TAG = taskParam.getOperation();
            TaskResult postService = this.mRequestSNBSeviceUtil.postService(taskParam.getOperation(), taskParam.getInputParam(), SNBResponse.class);
            LogUtil.log(this.TAG, "server data back is" + JsonUtil.getInstance().serializeObject(postService, new boolean[0]));
            checkPostResult(postService);
        }
        LogUtil.log(this.TAG, "executeTask end");
        return JsonUtil.getInstance().serializeObject(this.mTaskResult, new boolean[0]);
    }

    private void checkPostResult(TaskResult<SNBResponse> taskResult) {
        if (taskResult != null && taskResult.getData() != null) {
            LogUtil.log(this.TAG, "checkPostResult taskServer.getData is " + JsonUtil.getInstance().serializeObject(taskResult.getData(), new boolean[0]));
            reSetTaskResult((SNBResponse) taskResult.getData());
        } else if (taskResult == null || taskResult.getResult_code() == null || taskResult.getResult_msg() == null) {
            LogUtil.loge(this.TAG, "checkPostResult taskServer is invalid");
        } else {
            setFaildTask(taskResult.getResult_code(), taskResult.getResult_msg());
        }
    }

    private void reSetTaskResult(SNBResponse sNBResponse) {
        if (this.mTaskResult == null) {
            this.mTaskResult = new TaskResult();
        }
        if (sNBResponse == null || sNBResponse.getResp_code() == null || sNBResponse.getResp_msg() == null) {
            LogUtil.loge(this.TAG, "reSetTaskResult  response is null or has no resp_code/resp_msg");
        } else {
            if (sNBResponse.getResp_code().equals("0000")) {
                this.mTaskResult.setResult_code("0");
            } else {
                this.mTaskResult.setResult_code(sNBResponse.getResp_code());
            }
            this.mTaskResult.setData(sNBResponse.getData());
            this.mTaskResult.setResult_msg(sNBResponse.getResp_msg());
        }
        LogUtil.log(this.TAG, "mTaskResult is" + JsonUtil.getInstance().serializeObject(this.mTaskResult, new boolean[0]));
    }

    private void setFaildTask(String str, String str2) {
        if (this.mTaskResult == null) {
            this.mTaskResult = new TaskResult();
        }
        this.mTaskResult.setResult_code(str);
        this.mTaskResult.setResult_msg(str2);
    }

    public boolean isNeedNetWork(Context context) {
        return true;
    }
}
