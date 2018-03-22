package com.snowballtech.apdu.smartdevice_oma;

import android.content.Context;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.apdu.IApdu;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.apdu.constant.CodeMessage;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.apdu.service.SnowballNfcException;
import com.snowballtech.apdu.smartdevice_oma.constant.SmartDeviceCode;
import com.snowballtech.apdu.smartdevice_oma.constant.SmartDeviceCodeMessage;
import com.snowballtech.apdu.smartdevice_oma.fundation.McuService;
import com.snowballtech.apdu.smartdevice_oma.fundation.NfcObject;
import com.snowballtech.apdu.util.Utils;
import com.snowballtech.common.bean.Command;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ByteHelperUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ObjectUtil;
import com.snowballtech.common.util.ValueUtil;
import com.snowballtech.smartdevice.Device;
import com.snowballtech.smartdevice.SnowBallAPDU;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SmartDeviceApdu implements IApdu {
    private String TAG = "SmartDeviceApdu";
    private SnowBallAPDU apdu;
    private String curuuid = "";
    private McuService mcuService = new McuService();
    private String oldUid = "";
    private Device smartDevice = null;

    public TaskResult<Content> executeApdu(Context context, Content content) {
        TaskResult<Content> executeApduKeep = executeApduKeep(context, content);
        closeChannel(content);
        return executeApduKeep;
    }

    public TaskResult<Content> executeApduKeep(Context context, Content content) {
        TaskResult<Content> taskResult = new TaskResult();
        try {
            if (this.mcuService == null) {
                this.mcuService = new McuService();
            }
            return handler(context, content);
        } catch (Exception e) {
            e.printStackTrace();
            if (!ValueUtil.isEmpty(taskResult.getResult_code())) {
                return taskResult;
            }
            taskResult.setResult_code("499999");
            taskResult.setResult_msg(e.getMessage());
            return taskResult;
        }
    }

    public TaskResult<INfcChannel> fetchChannel(Context context, Content content) {
        TaskResult<INfcChannel> taskResult = new TaskResult();
        if (initSnowballApduInside()) {
            try {
                NfcObject pullChannel = this.mcuService.pullChannel(this.apdu, content.getInstance_id(), content.getChannelType(), content.getMediaType());
                if (pullChannel != null) {
                    String toHexString = ByteHelperUtil.toHexString(pullChannel.getResponse());
                    if (ValueUtil.isEmpty(toHexString) || !toHexString.endsWith("9000")) {
                        taskResult.setResult_code("499999");
                        taskResult.setResult_msg(toHexString);
                    } else {
                        taskResult.setData(pullChannel.getNfcChannel());
                        taskResult.setResult_code("0");
                        taskResult.setResult_msg(" fetchChannel successfully ");
                    }
                }
            } catch (SnowballNfcException e) {
                e.printStackTrace();
                taskResult.setResult_code(Utils.convertDetailErrorCodeForSe(CodeMessage.NFC_CHANNEL_CHANNEL_NULL, e.getMessage()) + "");
                taskResult.setResult_msg("fetch channle failure " + e.getMessage());
            }
            if (taskResult.getResult_code().equals("400903")) {
                release();
                LogUtil.loge(this.TAG, " because basic channel in use,shutdown seservice ");
            }
        } else {
            taskResult.setResult_code(SmartDeviceCodeMessage.INIT_SNOWBALLAPDU_FAILD);
            taskResult.setResult_msg(SmartDeviceCodeMessage.INIT_SNOWBALLAPDU_FAILD_MSG);
        }
        return taskResult;
    }

    public void closeChannel(Content content) {
        this.mcuService.closeChannel(content);
    }

    public void closeChannlAll() {
        this.mcuService.closeChannelAll();
    }

    public void release() {
        this.mcuService.closeChannelAll();
        this.apdu = null;
    }

    public void SetDevice(String str) {
        this.smartDevice = (Device) JsonUtil.getInstance().deSerializeString(str, Device.class);
        LogUtil.log(this.TAG, " SetDevice done ");
    }

    private TaskResult<Content> handler(Context context, Content content) {
        String str = " handler ";
        TaskResult<Content> taskResult = new TaskResult();
        taskResult.setResult_code("0");
        taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        if (this.apdu == null) {
            initSnowballApdu(taskResult);
        } else if (this.oldUid.equals(this.smartDevice.getDevice_uid())) {
            LogUtil.log(this.TAG, str + " handler, uid not change");
        } else {
            LogUtil.log(this.TAG, str + " device changed, need release all channels ");
            release();
            initSnowballApdu(taskResult);
        }
        try {
            Content content2 = new Content();
            taskResult.setData(content2);
            LogUtil.log(this.TAG, str + " start  ");
            if (content == null || ValueUtil.isEmpty(content.getInstance_id())) {
                LogUtil.loge(this.TAG, str + " end content or instance_id is null");
                taskResult.setResult_code("499999");
                taskResult.setResult_msg(com.snowballtech.common.constant.CodeMessage.EXCEPTION_ERROR_MSG);
                return taskResult;
            }
            ObjectUtil.updateAllValueOfBean(content2, content, "command_list");
            List arrayList = new ArrayList();
            if (content.getCommands() != null && content.getCommands().size() > 0) {
                for (Command command : content.getCommands()) {
                    Command command2 = new Command();
                    ObjectUtil.updateAllValueOfBean(command2, command, new String[0]);
                    arrayList.add(command2);
                }
            }
            content2.setCommands(arrayList);
            NfcObject pullChannel = this.mcuService.pullChannel(this.apdu, content.getInstance_id(), content.getChannelType(), content.getMediaType());
            String toHexString = ByteHelperUtil.toHexString(pullChannel.getResponse());
            LogUtil.log(this.TAG, " apdu-execute:aid=" + content.getInstance_id() + ",response:" + toHexString);
            if (toHexString == null || toHexString.length() < 4 || !"9000".equals(toHexString.substring(toHexString.length() - 4))) {
                if (toHexString != null) {
                    setSmartDeviceCode(taskResult, toHexString);
                } else {
                    LogUtil.loge(this.TAG, " openChannel failed ");
                    taskResult.setResult_code("400903");
                    taskResult.setResult_msg(CodeMessage.NFC_BASIC_CHANNEL_IN_USE_MSG);
                }
                return taskResult;
            }
            content2.setChannel_status(toHexString.substring(toHexString.length() - 4));
            LogUtil.log(this.TAG, " apdu-execute:aid=" + content.getInstance_id());
            for (Command command3 : content2.getCommands()) {
                String str2 = command3.getProgress() != null ? command3.getProgress() + "" : "";
                if (!ValueUtil.isEmpty(str2)) {
                    content.setProgress_current("" + str2);
                    content2.setProgress_current("" + str2);
                }
                LogUtil.log(this.TAG, str + " apdu-execute:progress=" + command3.getProgress());
                LogUtil.log(this.TAG, str + " apdu-execute:command=" + command3.getCommand());
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Object hexStringToByteArray = ByteHelperUtil.hexStringToByteArray(command3.getCommand());
                    LogUtil.log(this.TAG, str + " apdu-execute:ad:" + hexStringToByteArray + "," + hexStringToByteArray.length);
                    LogUtil.log(this.TAG, str + " apdu-execute:nfcchannel:" + pullChannel.getNfcChannel() + currentTimeMillis);
                    str2 = ByteHelperUtil.toHexString(pullChannel.getNfcChannel().transmit(hexStringToByteArray));
                    command3.setResult(str2);
                    LogUtil.log(this.TAG, " apdu-execute:response=" + str2 + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                    String checker = command3.getChecker();
                    if (!ValueUtil.isEmpty(checker)) {
                        LogUtil.log(this.TAG, " need use regex judge ");
                        if (!Pattern.matches(checker, str2)) {
                            LogUtil.loge(this.TAG, " apdu-response match regex failure " + checker);
                            setSmartDeviceCode(taskResult, str2);
                            break;
                        }
                        LogUtil.log(this.TAG, " apdu-response match regex successfully " + checker);
                    } else if (command3.getCommand().equals(SeConstants.COMMAND_UID)) {
                        LogUtil.log(this.TAG, " no need judge,uid no response sw ");
                    } else {
                        LogUtil.log(this.TAG, " no need use regex judge ");
                        if (!str2.endsWith("9000")) {
                            LogUtil.loge(this.TAG, " no need use regex judge but res:" + str2);
                            setSmartDeviceCode(taskResult, str2);
                            break;
                        }
                        LogUtil.log(this.TAG, " no need use regex judge and res:" + str2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtil.loge(this.TAG, " apdu-execute exception " + e.getMessage());
                    taskResult.setResult_msg(e.getMessage());
                    taskResult.setResult_code("499999");
                }
            }
            return taskResult;
        } catch (Exception e2) {
            e2.printStackTrace();
            taskResult.setResult_msg(e2.getMessage());
            taskResult.setResult_code("499999");
        }
    }

    private void setSmartDeviceCode(TaskResult<Content> taskResult, String str) {
        LogUtil.log(this.TAG, "start to reSet code" + str);
        if (str.equalsIgnoreCase(SmartDeviceCode.FAIL)) {
            taskResult.setResult_code("400902");
            taskResult.setResult_msg(CodeMessage.NFC_APDU_EXECUTE_ERROR_MSG);
        } else if (str.equalsIgnoreCase(SmartDeviceCode.AID_NOT_EXIST)) {
            taskResult.setResult_code("400907");
            taskResult.setResult_msg(CodeMessage.NFC_AID_NO_EXIST_MSG);
        } else {
            taskResult.setResult_code("400902");
            taskResult.setResult_msg(CodeMessage.NFC_APDU_EXECUTE_ERROR_MSG);
        }
    }

    private void initSnowballApdu(TaskResult<Content> taskResult) {
        if (!initSnowballApduInside()) {
            taskResult.setResult_code(SmartDeviceCodeMessage.INIT_SNOWBALLAPDU_FAILD);
            taskResult.setResult_msg(SmartDeviceCodeMessage.INIT_SNOWBALLAPDU_FAILD_MSG);
        }
    }

    private boolean initSnowballApduInside() {
        try {
            this.apdu = new SnowBallAPDU(JsonUtil.getInstance().serializeObject(this.smartDevice, new boolean[0]));
            this.oldUid = this.smartDevice.getDevice_uid();
            if (this.apdu != null) {
                return true;
            }
            LogUtil.loge(this.TAG, " SnowBallAPDU constructor return null ");
            return false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
