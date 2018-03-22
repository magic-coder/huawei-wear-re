package com.snowballtech.business.inner;

import android.content.Context;
import com.snowballtech.apdu.IApdu;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.apdu.util.Utils;
import com.snowballtech.business.util.ConfigUtil;
import com.snowballtech.common.bean.Command;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.constant.CodeMessage;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ByteHelperUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.List;
import java.util.regex.Pattern;

public class BusinessApduAccess {
    private String TAG = " BusinessApduAccess ";
    private IApdu apdu;

    public BusinessApduAccess() {
        try {
            this.apdu = ConfigUtil.getInstance().instanceOma();
        } catch (SnowballException e) {
            e.printStackTrace();
        }
    }

    public TaskResult<Content> executeApdu(Context context, Content content) {
        return this.apdu.executeApdu(context, content);
    }

    public TaskResult<INfcChannel> executeApduList(Context context, List<Command> list, INfcChannel iNfcChannel) throws SnowballException {
        String str = "executeApduList";
        TaskResult<INfcChannel> taskResult = new TaskResult();
        LogUtil.log(this.TAG, str + "  start  ");
        taskResult.setResult_code("0");
        Content content = new Content();
        for (Command command : list) {
            if (ValueUtil.isEmpty(command.getCommand())) {
                command.setResult(String.valueOf(CodeMessage.EXCEPTION_ERROR));
                taskResult.setResult_code("499999");
                LogUtil.loge(this.TAG, str + "  command is null! ");
                break;
            }
            if (command.getCommand().toUpperCase().startsWith(SeConstants.AID_FOR_APDULIST_PREFIX)) {
                if (iNfcChannel != null) {
                    this.apdu.closeChannlAll();
                }
                iNfcChannel = null;
                content.setInstance_id(command.getCommand().substring(SeConstants.AID_FOR_APDULIST_PREFIX.length() + 2));
                TaskResult fetchChannel = this.apdu.fetchChannel(context, content);
                if (fetchChannel.getResult_code().equals("0")) {
                    INfcChannel iNfcChannel2 = (INfcChannel) fetchChannel.getData();
                    taskResult.setData(iNfcChannel2);
                    command.setResult("9000");
                    iNfcChannel = iNfcChannel2;
                } else {
                    command.setResult(fetchChannel.getResult_code() + "");
                    taskResult.setResult_code(fetchChannel.getResult_code());
                    taskResult.setResult_msg(fetchChannel.getResult_msg());
                }
            }
            String specialCheckForOmaException;
            if (iNfcChannel == null) {
                LogUtil.loge(this.TAG, " executeApduList fetch Channel failed, last APDU command is" + command.getCommand());
                taskResult.setData(null);
                specialCheckForOmaException = Utils.specialCheckForOmaException(taskResult.getResult_msg());
                if ("".equals(specialCheckForOmaException)) {
                    command.setResult("400954");
                } else {
                    command.setResult(specialCheckForOmaException);
                }
                taskResult.setResult_code("400954");
                return taskResult;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                specialCheckForOmaException = ByteHelperUtil.toHexString(iNfcChannel.transmit(ByteHelperUtil.hexStringToByteArray(command.getCommand())));
                command.setResult(specialCheckForOmaException);
                LogUtil.log(this.TAG, "_apdu=" + command.getCommand() + " apdu-execute:response=" + specialCheckForOmaException + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                String checker = command.getChecker();
                if (!ValueUtil.isEmpty(checker)) {
                    LogUtil.log(this.TAG, " need use regex judge ");
                    if (!Pattern.matches(checker, specialCheckForOmaException)) {
                        LogUtil.loge(this.TAG, " apdu-response match regex failure " + checker);
                        taskResult.setResult_msg(specialCheckForOmaException + ",response error");
                        taskResult.setResult_code("400902");
                        break;
                    }
                    LogUtil.log(this.TAG, " apdu-response match regex successfully " + checker);
                } else if (command.getCommand().equals(SeConstants.COMMAND_UID)) {
                    LogUtil.loge(this.TAG, " no need judge,uid no response sw ");
                } else {
                    LogUtil.log(this.TAG, " no need use regex judge ");
                    if (!specialCheckForOmaException.endsWith("9000")) {
                        taskResult.setResult_msg(specialCheckForOmaException + ",response error");
                        taskResult.setResult_code("400902");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.loge(this.TAG, " apdu-execute exception " + e.getMessage() + " and last APDU command is" + command.getCommand());
                taskResult.setResult_msg(e.getMessage());
                int convertDetailErrorCodeForSe = Utils.convertDetailErrorCodeForSe(com.snowballtech.apdu.constant.CodeMessage.NFC_APDU_EXECUTE_ERROR, taskResult.getResult_msg());
                taskResult.setResult_code(convertDetailErrorCodeForSe + "");
                command.setResult(String.valueOf(convertDetailErrorCodeForSe));
            }
        }
        LogUtil.log(this.TAG, str + " end , apduAccess result =" + taskResult.getResult_code() + " costtime:" + (System.currentTimeMillis() - 0) + " ms");
        taskResult.setData(iNfcChannel);
        return taskResult;
    }

    public IApdu getApdu() {
        return this.apdu;
    }

    public void setApdu(IApdu iApdu) {
        this.apdu = iApdu;
    }
}
