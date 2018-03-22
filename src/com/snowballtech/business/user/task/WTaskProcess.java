package com.snowballtech.business.user.task;

import android.content.Context;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.business.bean.SNBRequest;
import com.snowballtech.business.bean.SNBResponse;
import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.business.inner.BusinessApduAccess;
import com.snowballtech.business.util.ApduUtil;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.RequestSNBSeviceUtil;
import com.snowballtech.common.bean.Command;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.constant.CodeMessage;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.DeviceUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WTaskProcess {
    private String TAG = WTaskProcess.class.getCanonicalName();
    private BusinessApduAccess apduAccess = new BusinessApduAccess();
    private ApduUtil apduUtil = ApduUtil.getInstance();
    private int code = 1;
    private Map<String, String> headerParam;
    private Context mContext;
    private RequestSNBSeviceUtil mSeviceUtil;
    private TaskResult<String> mTaskResult;
    private String sp_id;

    public TaskResult<String> operate(String str, String str2, Context context) throws SnowballException {
        this.mContext = context;
        if (this.mSeviceUtil == null) {
            this.mSeviceUtil = new RequestSNBSeviceUtil(this.mContext);
        }
        if (RequestKey.KEY_TRANSFERREFUND.equals(str)) {
            this.mSeviceUtil.setSp_id(this.sp_id);
        }
        this.headerParam = CommonUtils.getInstance().getProviderRequestHeader(context, 0);
        LogUtil.log(this.TAG, "jsonParam is " + str2);
        WSProviderBean wSProviderBean = (WSProviderBean) JsonUtil.getInstance().deSerializeString(str2, WSProviderBean.class);
        LogUtil.log(this.TAG, "wsProviderBean is " + JsonUtil.getInstance().serializeObject(wSProviderBean, new boolean[0]));
        wSProviderBean.setToken(checkContent(wSProviderBean.getToken()));
        wSProviderBean.setExtra_info(checkContent(wSProviderBean.getExtra_info()));
        SNBRequest sNBRequest = new SNBRequest();
        sNBRequest.setToken(wSProviderBean.getToken());
        if (wSProviderBean.getCategory() != null) {
            sNBRequest.setCommand(wSProviderBean.getCategory());
        } else {
            sNBRequest.setCommand(wSProviderBean.getOperation());
        }
        sNBRequest.setTarget_id(wSProviderBean.getInstance_id());
        sNBRequest.setExtra_info(wSProviderBean.getExtra_info());
        sNBRequest.setRefundData(wSProviderBean.getRefundData());
        sNBRequest.setPackage_name(DeviceUtil.getInstance().getCurrentPackageName(context));
        sNBRequest.setPackage_version_code(DeviceUtil.getInstance().getVersionCode(context) + "");
        sNBRequest.setPackage_version_name(DeviceUtil.getInstance().getVersionName(context));
        String str3 = str;
        TaskResult<String> recursion = recursion(this.mContext, str3, new TaskResult(), sNBRequest, new SNBResponse(), null, true);
        this.apduAccess.getApdu().closeChannlAll();
        return recursion;
    }

    private TaskResult<String> recursion(Context context, String str, TaskResult<String> taskResult, SNBRequest sNBRequest, SNBResponse sNBResponse, INfcChannel iNfcChannel, boolean z) throws SnowballException {
        LogUtil.log(this.TAG, " recursion start ");
        if (sNBRequest == null || sNBResponse == null) {
            taskResult.setResult_code(taskResult.getResult_code() + "");
            taskResult.setResult_msg(CodeMessage.EXCEPTION_ERROR_MSG);
        } else {
            try {
                INfcChannel iNfcChannel2;
                if (sNBResponse.getCommands() != null) {
                    List commands = sNBResponse.getCommands();
                    TaskResult executeApduList = this.apduAccess.executeApduList(context, commands, iNfcChannel);
                    INfcChannel iNfcChannel3 = (INfcChannel) executeApduList.getData();
                    Content content = new Content();
                    if (executeApduList.getResult_code().equals("0")) {
                        content.setSucceed(Boolean.valueOf(true));
                        if ("01".equals(sNBResponse.getEnd_flag())) {
                            this.code = 0;
                            LogUtil.log(this.TAG, " apdu execute success and finish");
                        }
                    } else {
                        content.setSucceed(Boolean.valueOf(false));
                        LogUtil.loge(this.TAG, " apdu execute failed");
                        printCommandListForError(commands);
                    }
                    content.setResults(commands);
                    sNBRequest.setCommand_results(content);
                    LogUtil.log(this.TAG, " execute apdu current step:" + sNBResponse.getNext_step());
                    iNfcChannel2 = iNfcChannel3;
                } else {
                    iNfcChannel2 = iNfcChannel;
                }
                if (ValueUtil.isEmpty(sNBResponse.getNext_step()) || !(ValueUtil.isEmpty(sNBResponse.getNext_step()) || sNBResponse.getNext_step().toLowerCase().equalsIgnoreCase("eof"))) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TaskResult postService = this.mSeviceUtil.postService(this.headerParam, str, JsonUtil.getInstance().serializeObject(sNBRequest, new boolean[0]), SNBResponse.class);
                    if (postService == null || !postService.getResult_code().equals("0")) {
                        if (this.code == 0) {
                            LogUtil.log(this.TAG, " apdu execute success and finish,but get signdate from server failed! ");
                            this.code = 1;
                        } else if (postService != null) {
                            taskResult.setResult_code(postService.getResult_code());
                            taskResult.setResult_msg(postService.getResult_msg());
                            if (!ValueUtil.isEmpty(sNBResponse.getToken())) {
                                taskResult.setData(sNBResponse.getToken());
                            }
                        } else {
                            taskResult.setResult_code("400814");
                            taskResult.setResult_msg(com.snowballtech.data.interaction.constants.CodeMessage.SERVER_NO_DATA_FROM_SERVER_MSG);
                        }
                        LogUtil.loge(this.TAG, "The last request=" + JsonUtil.getInstance().serializeObject(sNBRequest, new boolean[0]));
                        LogUtil.loge(this.TAG, " request server failure result_code=" + taskResult.getResult_code());
                    } else {
                        int parseInt;
                        SNBResponse sNBResponse2 = (SNBResponse) postService.getData();
                        try {
                            parseInt = ValueUtil.parseInt(sNBResponse2.getResp_code());
                        } catch (Exception e) {
                            e.printStackTrace();
                            LogUtil.loge(this.TAG, " request server successfully,server response info error ");
                            parseInt = 0;
                        }
                        taskResult.setResult_code(parseInt + "");
                        taskResult.setResult_msg(sNBResponse2.getResp_msg());
                        taskResult.setData(sNBResponse2.getData());
                        LogUtil.log(this.TAG, " request server successfully,server response code: " + parseInt);
                        if (parseInt == 0) {
                            sNBRequest.setSession(sNBResponse2.getSession());
                            sNBRequest.setCurrent_step(sNBResponse2.getNext_step());
                            sNBRequest.setCommand_results(null);
                            if (!ValueUtil.isEmpty(sNBResponse2.getToken())) {
                                taskResult.setData(sNBResponse2.getToken());
                            }
                            LogUtil.log(this.TAG, " request server finish execute_stemp:" + sNBResponse2.getNext_step() + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms,resultStr=" + taskResult);
                            taskResult = recursion(context, str, taskResult, sNBRequest, sNBResponse2, iNfcChannel2, false);
                        } else {
                            if (!(sNBResponse2 == null || ValueUtil.isEmpty(sNBResponse2.getToken()))) {
                                taskResult.setData(sNBResponse2.getToken());
                            }
                            LogUtil.loge(this.TAG, "The last request=" + JsonUtil.getInstance().serializeObject(sNBRequest, new boolean[0]));
                            LogUtil.loge(this.TAG, " request server successfully,server response code is not equal with 0 " + parseInt + ",resultStr=" + ((String) taskResult.getData()));
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new SnowballException(e2.getMessage(), (int) CodeMessage.EXCEPTION_ERROR);
            }
        }
        LogUtil.log(this.TAG, " recursion end result_code=" + taskResult.getResult_code());
        return taskResult;
    }

    public String getSp_id() {
        return this.sp_id;
    }

    public void setSp_id(String str) {
        this.sp_id = str;
    }

    private String checkContent(String str) {
        Map parsetoken = CommonUtils.getInstance().parsetoken(str);
        if (parsetoken == null || parsetoken.size() <= 0) {
            return "";
        }
        Map hashMap = new HashMap();
        for (String str2 : parsetoken.keySet()) {
            if (!ValueUtil.isEmpty((String) parsetoken.get(str2))) {
                String str3 = "x-snbps-" + str2;
                if (this.headerParam.containsKey(str3)) {
                    this.headerParam.put(str3, parsetoken.get(str2));
                } else {
                    hashMap.put(str2, parsetoken.get(str2));
                }
            }
        }
        return CommonUtils.getInstance().compositetoken(hashMap);
    }

    private void printCommandListForError(List<Command> list) {
        if (list != null) {
            int i = 0;
            for (Command command : list) {
                if (command != null) {
                    LogUtil.loge(this.TAG, "printCommandListForError, " + i + "th command,  index:" + command.getIndex() + "; apdu command:" + command.getCommand() + "; apdu response:" + command.getResult());
                } else {
                    LogUtil.loge(this.TAG, "printCommandListForError, " + i + "th command is null");
                }
                i++;
            }
        }
        LogUtil.loge(this.TAG, "printCommandListForError, command list is null");
    }
}
