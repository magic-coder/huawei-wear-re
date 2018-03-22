package com.snowballtech.business.user.task;

import android.content.Context;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.snowballtech.business.bean.Cplc;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.ApduUtil;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;

public class WTaskGetCplc implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_GET_CPLC;
    private ApduUtil apduUtil = ApduUtil.getInstance();
    private CommonUtils commonUtils = CommonUtils.getInstance();

    public String executeTask(TaskParam taskParam) throws SnowballException {
        Exception exception;
        Exception exception2;
        String serializeObject;
        LogUtil.log(this.TAG, "executeTask  start");
        Object taskResult = new TaskResult();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int validateEnvironment = this.commonUtils.validateEnvironment(taskParam.getContext(), false, false);
            taskResult.setResult_code(validateEnvironment + "");
            if (validateEnvironment == 0) {
                TaskResult removeCplcCache;
                String inputParam = taskParam.getInputParam();
                if (UploadFile.REFRESH_LABEL.equals(inputParam)) {
                    removeCplcCache = this.apduUtil.removeCplcCache(taskParam.getContext(), 0);
                    try {
                        removeCplcCache = this.apduUtil.getCPLC(taskParam.getContext(), 0);
                    } catch (Exception e) {
                        exception = e;
                        taskResult = r1;
                        exception2 = exception;
                        taskResult.setResult_code("499999");
                        exception2.printStackTrace();
                        LogUtil.loge(this.TAG, " occur exception :" + exception2.getMessage());
                        taskResult.setResult_msg(exception2.getMessage());
                        serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
                        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        return serializeObject;
                    }
                } else if ("removecache".equals(inputParam)) {
                    removeCplcCache = this.apduUtil.removeCplcCache(taskParam.getContext(), 0);
                } else if (inputParam != null) {
                    taskResult.setResult_code("410003");
                    taskResult.setResult_msg(CodeMessage.BUSINESS_PARAM_VALID_MSG);
                    removeCplcCache = taskResult;
                } else {
                    removeCplcCache = this.apduUtil.getCPLC(taskParam.getContext(), 0);
                }
                try {
                    if (!removeCplcCache.getResult_code().equals("0")) {
                        LogUtil.loge(this.TAG, "executeTask getCPLC return:" + removeCplcCache.getResult_code());
                    } else if (!ValueUtil.isEmpty((String) removeCplcCache.getData())) {
                        Cplc cplc = new Cplc();
                        cplc.setCplc((String) removeCplcCache.getData());
                        removeCplcCache.setData(JsonUtil.getInstance().serializeObject(cplc, new boolean[0]));
                    }
                    taskResult = removeCplcCache;
                } catch (Exception e2) {
                    exception = e2;
                    taskResult = removeCplcCache;
                    exception2 = exception;
                    taskResult.setResult_code("499999");
                    exception2.printStackTrace();
                    LogUtil.loge(this.TAG, " occur exception :" + exception2.getMessage());
                    taskResult.setResult_msg(exception2.getMessage());
                    serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
                    LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                    return serializeObject;
                }
                serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
                LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                return serializeObject;
            }
            LogUtil.loge(this.TAG, "executeTask param is invalid");
            serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
            LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
            return serializeObject;
        } catch (Exception e3) {
            exception2 = e3;
            taskResult.setResult_code("499999");
            exception2.printStackTrace();
            LogUtil.loge(this.TAG, " occur exception :" + exception2.getMessage());
            taskResult.setResult_msg(exception2.getMessage());
            serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
            LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
            return serializeObject;
        }
    }

    public boolean isNeedNetWork(Context context) {
        return false;
    }
}
