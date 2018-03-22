package com.snowballtech.data.interaction.net;

import android.content.Context;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.constant.CodeMessage;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.DeviceUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;
import com.snowballtech.data.interaction.IRequester;
import com.snowballtech.data.interaction.RequesterParam;
import java.io.InputStream;

public class RequesterNet implements IRequester {
    String TAG = " RequesterNet ";
    private AccessServer accessServer = new AccessServer();

    public void init(Context context) {
    }

    public <P, R> TaskResult<R> requestData(RequesterParam<P> requesterParam, Class<R> cls) {
        TaskResult<R> taskResult = new TaskResult();
        taskResult.setResult_code("499999");
        taskResult.setResult_msg(CodeMessage.EXCEPTION_ERROR_MSG);
        if (requesterParam == null || cls == null) {
            taskResult.setResult_msg("requesterParam or cls is null-->异常错误");
        } else {
            int i = 0;
            while (i < 1) {
                long currentTimeMillis = System.currentTimeMillis();
                LogUtil.log(this.TAG, " access_server  interval_req_res  ( " + i + ")" + requesterParam.getServerUrl() + " start ");
                switch (requesterParam.getResponseType()) {
                    case 4:
                        try {
                            handlerResult(requesterParam, taskResult, cls);
                            break;
                        } catch (Exception e) {
                            taskResult.setResult_msg(taskResult.getResult_msg() + "-->" + e.getMessage());
                            taskResult.setResult_code("499999");
                            e.printStackTrace();
                            break;
                        }
                    case 5:
                        handlerResult(requesterParam, taskResult, cls);
                        break;
                }
                LogUtil.log(this.TAG, " access_server  interval_req_res  ( " + i + ")" + requesterParam.getServerUrl() + " end " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                if (taskResult.getResult_code().equals("400814")) {
                    Thread.sleep(5000);
                    i++;
                }
            }
        }
        return taskResult;
    }

    public <P> TaskResult<InputStream> requestData(RequesterParam<P> requesterParam) {
        TaskResult<InputStream> taskResult = new TaskResult();
        taskResult.setResult_code("499999");
        taskResult.setResult_msg(CodeMessage.EXCEPTION_ERROR_MSG);
        if (requesterParam != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                LogUtil.log(this.TAG, " access_server  interval_req_res " + requesterParam.getServerUrl() + " start ");
                if (DeviceUtil.getInstance().checkNetWorkDisable(requesterParam.getContext())) {
                    taskResult.setResult_code(RetCode.SUC_400001);
                    taskResult.setResult_msg(CodeMessage.ENVIRONMENT_NETWORK_DISABLED_MSG);
                } else {
                    handlerResult(requesterParam, taskResult);
                }
                LogUtil.log(this.TAG, " access_server  interval_req_res " + requesterParam.getServerUrl() + " end " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
            } catch (Exception e) {
                taskResult.setResult_msg(taskResult.getResult_msg() + "-->" + e.getMessage());
                taskResult.setResult_code("499999");
            }
        } else {
            taskResult.setResult_msg("requesterParam or cls is null-->异常错误");
        }
        return taskResult;
    }

    private <P> InputStream handlerInputStream(RequesterParam<P> requesterParam) {
        int i = 2;
        String serializeObject = JsonUtil.getInstance().serializeObject(requesterParam.getRequestObj(), new boolean[0]);
        if (requesterParam.getRequestMethod() != 1) {
            if (requesterParam.getRequestMethod() == 0) {
                i = 0;
            }
            i = 0;
        } else if (requesterParam.getRequestType() != 3) {
            if (requesterParam.getRequestType() == 2) {
                i = 1;
            }
            i = 0;
        }
        return this.accessServer.requestInputStream(requesterParam.getServerUrl(), requesterParam.getParam(), serializeObject, requesterParam.getHeaderParam(), i, requesterParam.getRequestMediaType());
    }

    private <P> void handlerResult(RequesterParam<P> requesterParam, TaskResult<InputStream> taskResult) {
        InputStream handlerInputStream = handlerInputStream(requesterParam);
        if (handlerInputStream != null) {
            taskResult.setResult_code("0");
            taskResult.setData(handlerInputStream);
            return;
        }
        taskResult.setResult_code("400814");
        taskResult.setResult_msg(com.snowballtech.data.interaction.constants.CodeMessage.SERVER_NO_DATA_FROM_SERVER_MSG);
    }

    private <P> String handlerString(RequesterParam<P> requesterParam) {
        int i = 2;
        String str = "";
        String serializeObject = JsonUtil.getInstance().serializeObject(requesterParam.getRequestObj(), new boolean[0]);
        if (requesterParam.getRequestMethod() != 1) {
            if (requesterParam.getRequestMethod() == 0) {
                i = 0;
            }
            i = 0;
        } else if (requesterParam.getRequestType() != 3) {
            if (requesterParam.getRequestType() == 2) {
                i = 1;
            }
            i = 0;
        }
        return this.accessServer.request(requesterParam.getServerUrl(), requesterParam.getParam(), serializeObject, requesterParam.getHeaderParam(), i, requesterParam.getRequestMediaType());
    }

    private <P, R> void handlerResult(RequesterParam<P> requesterParam, TaskResult<R> taskResult, Class<R> cls) {
        String handlerString = handlerString(requesterParam);
        if (ValueUtil.isEmpty(handlerString)) {
            taskResult.setResult_code("400814");
            taskResult.setResult_msg(com.snowballtech.data.interaction.constants.CodeMessage.SERVER_NO_DATA_FROM_SERVER_MSG);
        } else if (cls.getName().endsWith("String")) {
            taskResult.setData(handlerString);
        } else {
            Object deSerializeString = JsonUtil.getInstance().deSerializeString(handlerString, cls);
            if (deSerializeString == null) {
                taskResult.setResult_msg(handlerString);
                return;
            }
            taskResult.setResult_code("0");
            taskResult.setData(deSerializeString);
            taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        }
    }

    public void release() {
        this.accessServer.release();
        this.accessServer = null;
    }
}
