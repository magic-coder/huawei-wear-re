package com.snowballtech.business.inner;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.business.bean.CardBaseSe;
import com.snowballtech.business.bean.Tlv;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.ConfigUtil;
import com.snowballtech.common.bean.Command;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ByteHelperUtil;
import com.snowballtech.common.util.DateTimeUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.ValueUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BusinessCardDetail extends BusinessCommon {
    private String TAG = Constant.LOG_FLAG_CARD_QUERY;

    public BusinessCardDetail(int i) {
        super(i);
    }

    public TaskResult<String> fetchCardDetail(Context context, String str, String str2) throws SnowballException {
        String str3;
        Object obj = null;
        long currentTimeMillis = System.currentTimeMillis();
        BusinessCardActivation businessCardActivation = new BusinessCardActivation(getMediaType());
        TaskResult<String> taskResult = new TaskResult();
        String str4 = "";
        if (ValueUtil.isEmpty(str)) {
            str3 = "instance_id is null ";
            LogUtil.log(this.TAG, " CardInfo_ instance_id is null ");
        } else {
            CardBaseSe cardBaseSe;
            taskResult.setResult_code("0");
            taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
            CardBaseSe cardBaseSe2 = new CardBaseSe();
            cardBaseSe2.setInstance_id(str);
            setCardDetail(context, cardBaseSe2, taskResult);
            if (taskResult.getResult_code().equals("0")) {
                if (ValueUtil.isEmpty(str2)) {
                    cardBaseSe2.setInstall_status(fetchInstallStatus(context, str) + "");
                    if (cardBaseSe2.getInstall_status().equals("2")) {
                        cardBaseSe2.setActivation_status(businessCardActivation.fetchActivation(context, str));
                        cardBaseSe = cardBaseSe2;
                        str3 = str4;
                    } else {
                        cardBaseSe2.setActivation_status("0");
                        cardBaseSe2.setCard_number(null);
                        cardBaseSe2.setValidity(null);
                        cardBaseSe2.setBalance(null);
                        cardBaseSe2.setStartdate(null);
                        cardBaseSe2.setLogicCardType(null);
                        cardBaseSe2.setRegion_id(null);
                        cardBaseSe2.setTotal_monthly_amount(null);
                    }
                } else {
                    if (str2.toLowerCase().contains("install_status")) {
                        cardBaseSe2.setInstall_status(fetchInstallStatus(context, str) + "");
                    }
                    if (str2.toLowerCase().contains("activation_status")) {
                        if (cardBaseSe2.getInstall_status().equals("2")) {
                            cardBaseSe2.setActivation_status(businessCardActivation.fetchActivation(context, str));
                        } else {
                            cardBaseSe2.setActivation_status("0");
                            cardBaseSe2.setCard_number(null);
                            cardBaseSe2.setValidity(null);
                            cardBaseSe2.setBalance(null);
                            cardBaseSe2.setStartdate(null);
                            cardBaseSe2.setLogicCardType(null);
                            cardBaseSe2.setRegion_id(null);
                            cardBaseSe2.setTotal_monthly_amount(null);
                        }
                    }
                    if (!str2.toLowerCase().contains("card_number")) {
                        cardBaseSe2.setCard_number(null);
                    }
                    if (!str2.toLowerCase().contains("balance")) {
                        cardBaseSe2.setBalance(null);
                    }
                    if (!str2.toLowerCase().contains(SNBConstant.FIELD_VALIDITY)) {
                        cardBaseSe2.setValidity(null);
                    }
                    if (!str2.toLowerCase().contains(SNBConstant.FIELD_STARTDATE)) {
                        cardBaseSe2.setStartdate(null);
                    }
                    if (!str2.toLowerCase().contains("logiccardtype")) {
                        cardBaseSe2.setLogicCardType(null);
                    }
                    if (!str2.toLowerCase().contains("region_id")) {
                        cardBaseSe2.setRegion_id(null);
                    }
                    if (!str2.toLowerCase().contains("total_monthly_amount")) {
                        cardBaseSe2.setTotal_monthly_amount(null);
                        cardBaseSe = cardBaseSe2;
                        str3 = str4;
                    }
                }
            }
            cardBaseSe = cardBaseSe2;
            str3 = str4;
        }
        if (!taskResult.getResult_code().equals("0") && !ValueUtil.isEmpty(str3)) {
            taskResult.setResult_msg(str3);
        } else if (obj != null) {
            taskResult.setData(JsonUtil.getInstance().serializeObject(obj, new boolean[0]));
        }
        LogUtil.log(this.TAG, this.TAG + LogUtil.CARD_INFO + " execute apdu end,resultCode=" + taskResult.getResult_code() + ",result=" + ((String) taskResult.getData()) + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return taskResult;
    }

    private void updateBankCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateBankCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(0)).getResult();
        Tlv fetchTlvFirst = fetchTlvFirst("9F79", result.substring(0, result.length() - 4));
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(fetchTlvFirst.getValue()))}));
        result = ((Command) list.get(1)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setCard_number(fetchTlvFirst("5A", result).getValue());
        cardBaseSe.setValidity(formatValidate(fetchTlvFirst("5F24", result).getValue()));
    }

    private void updateTaiZhouCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateTaiZhouCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(1)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setCard_number(result.substring(24, 40));
        cardBaseSe.setValidity(formatValidate(result.substring(48, 56)));
        result = ((Command) list.get(2)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(result.substring(0, 8), 16))}));
    }

    private void updateWhgjCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateWhgjCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(2)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setCard_number(result.substring(24, 40));
        cardBaseSe.setCard_number(generateCardNumberForWHTransit(cardBaseSe.getCard_number()));
        cardBaseSe.setValidity(formatValidate(result.substring(48, 56)));
        result = ((Command) list.get(3)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(result.substring(0, 8), 16))}));
    }

    private void updateWhdtCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateWhdtCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(0)).getResult();
        cardBaseSe.setCard_number(result.substring(0, result.length() - 4).substring(16, 32));
        result = ((Command) list.get(2)).getResult();
        cardBaseSe.setValidity(formatValidate(result.substring(0, result.length() - 4).substring(16, 28)));
        result = ((Command) list.get(3)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(result.substring(0, 8), 16))}));
    }

    private void updateCqCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateCqCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(0)).getResult();
        cardBaseSe.setCard_number(result.substring(0, result.length() - 4).substring(24, 40));
        result = ((Command) list.get(2)).getResult();
        cardBaseSe.setValidity(formatValidate(result.substring(0, result.length() - 4).substring(16, 24)));
        result = ((Command) list.get(3)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(result.substring(0, 8), 16))}));
    }

    private void updateSzCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateSzCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(1)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setCard_number(result.substring(0, 16));
        cardBaseSe.setValidity(formatValidate(result.substring(48, 56)));
        result = ((Command) list.get(3)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(result.substring(0, 8), 16))}));
    }

    private void updateSztCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list != null && list.size() > 0) {
            String result = ((Command) list.get(1)).getResult();
            if (result.length() >= 60) {
                result = result.substring(0, result.length() - 4);
                cardBaseSe.setCard_number(result.substring(20, 40));
                cardBaseSe.setCard_number(generateCardNumberForSZT(cardBaseSe.getCard_number()));
                cardBaseSe.setValidity(formatValidate(result.substring(48, 56)));
            } else {
                LogUtil.loge(this.TAG, " CardInfo_ apdu response for reading basic info is too short ");
            }
            if (((Command) list.get(2)).getResult().length() >= 8) {
                cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf((int) (Long.parseLong(((Command) list.get(2)).getResult().substring(0, ((Command) list.get(2)).getResult().length() - 4).substring(0, 8), 16) - -2147483648L))}));
                return;
            }
            LogUtil.loge(this.TAG, " CardInfo_ apdu response for reading balance is too short ");
        }
    }

    private void updateTftCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateTftCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(1)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setCard_number(result.substring(0, 16));
        cardBaseSe.setValidity(formatValidate(result.substring(48, 56)));
        result = ((Command) list.get(2)).getResult();
        result = result.substring(0, result.length() - 4);
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(result.substring(0, 8), 16))}));
    }

    private boolean processCommand(TaskResult<String> taskResult, INfcChannel iNfcChannel, Command command) {
        long currentTimeMillis = System.currentTimeMillis();
        LogUtil.log(this.TAG, "apdu-execute:command=" + command.getCommand());
        try {
            String toHexString = ByteHelperUtil.toHexString(iNfcChannel.transmit(ByteHelperUtil.hexStringToByteArray(command.getCommand())));
            LogUtil.log(this.TAG, "apdu-execute:response=" + toHexString + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (toHexString == null || !checkResponseForSe(command, toHexString)) {
                LogUtil.log(this.TAG, "apdu-execute failed:response=" + toHexString + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                taskResult.setResult_code("430001");
                taskResult.setResult_msg(CodeMessage.BUSINESS_CARD_INFO_ERROR_MSG);
                return false;
            }
            command.setResult(toHexString);
            return true;
        } catch (SnowballException e) {
            LogUtil.log(this.TAG, "apdu-execute failed:exception=" + e.getMessage() + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            taskResult.setResult_code(e.getResult_code() + "");
            taskResult.setResult_msg(e.getMessage());
            return false;
        }
    }

    private boolean checkResponseForSe(Command command, String str) {
        String checker = command.getChecker();
        if (ValueUtil.isEmpty(checker)) {
            LogUtil.log(this.TAG, " no need use regex judge ");
            if (!str.endsWith("9000")) {
                return false;
            }
            LogUtil.loge(this.TAG, " apdu-response is:" + str);
            return true;
        }
        LogUtil.log(this.TAG, " need use regex judge ");
        if (Pattern.matches(checker, str)) {
            LogUtil.log(this.TAG, " apdu-response match regex successfully " + checker);
            return true;
        }
        LogUtil.loge(this.TAG, " apdu-response match regex failure " + checker);
        return false;
    }

    private void updateBjCardDetail(Context context, Content content, CardBaseSe cardBaseSe, TaskResult<String> taskResult, INfcChannel iNfcChannel) {
        if (!processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(0)) || !processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(1))) {
            return;
        }
        if (!((Command) content.getCommands().get(1)).getResult().substring(0, 2).equals("02")) {
            taskResult.setResult_code("430004");
            taskResult.setResult_msg(CodeMessage.BUSINESS_NO_USE_MSG);
        } else if (!processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(2))) {
        } else {
            if (((Command) content.getCommands().get(2)).getResult().substring(0, 2).equals("A5")) {
                taskResult.setResult_code("430005");
                taskResult.setResult_msg(CodeMessage.BUSINESS_BLANK_LIST_MSG);
            } else if (processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(3))) {
                String substring = ((Command) content.getCommands().get(3)).getResult().substring(0, 2);
                if (!substring.equals("01") && !substring.equals("06")) {
                    taskResult.setResult_code("430009");
                    taskResult.setResult_msg(CodeMessage.BUSINESS_LOGICAL_CARD_TYPE_ERROR_MSG);
                } else if (processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(4))) {
                    String substring2 = ((Command) content.getCommands().get(4)).getResult().substring(48, 56);
                    if (isValidDate(substring2)) {
                        String substring3 = ((Command) content.getCommands().get(4)).getResult().substring(56, 64);
                        if (!isValidDate(substring3)) {
                            taskResult.setResult_code("430008");
                            taskResult.setResult_msg(CodeMessage.BUSINESS_CARD_END_DATE_ERROR_MSG);
                            return;
                        } else if (processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(5))) {
                            int i;
                            int parseLong = (int) ValueUtil.parseLong(((Command) content.getCommands().get(5)).getResult().substring(0, 8), 16);
                            if (parseLong >= 0) {
                                i = parseLong;
                            } else if (parseLong == -1) {
                                i = 0;
                            } else {
                                taskResult.setResult_code("430007");
                                taskResult.setResult_msg(CodeMessage.BUSINESS_OVERDRAFT_MONEY_LESS_ZERO_ERROR_MSG);
                                return;
                            }
                            if (processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(6)) && processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(7))) {
                                if (ValueUtil.parseInt(((Command) content.getCommands().get(7)).getResult().substring(0, 8), 16) != 0 && i != 0) {
                                    taskResult.setResult_code("430003");
                                    taskResult.setResult_msg(CodeMessage.BUSINESS_WALLET_FORMATE_ERROR_MSG);
                                    return;
                                } else if (processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(8))) {
                                    if (parseBalance(((Command) content.getCommands().get(8)).getResult().substring(6, 12)) < parseBalance(((Command) content.getCommands().get(8)).getResult().substring(0, 6))) {
                                        taskResult.setResult_code("430006");
                                        taskResult.setResult_msg(CodeMessage.BUSINESS_WALLET_ERROR_MSG);
                                        return;
                                    } else if (processCommand(taskResult, iNfcChannel, (Command) content.getCommands().get(9))) {
                                        int i2;
                                        String result = ((Command) content.getCommands().get(9)).getResult();
                                        parseLong = 0;
                                        if (!ValueUtil.isEmpty(result)) {
                                            if (result.length() > 12) {
                                                result = result.substring(0, 12);
                                                if (result.startsWith(DateTimeUtil.currentDateString("yyMM"))) {
                                                    result = result.substring(6, 12);
                                                    if (result.matches("^[0-9|a-e|A-E]{6}$")) {
                                                        parseLong = Integer.parseInt(result.substring(4) + result.substring(2, 4) + result.substring(0, 2), 16);
                                                    } else {
                                                        LogUtil.log(this.TAG, "total monthly amount is invalid " + result);
                                                    }
                                                } else {
                                                    LogUtil.log(this.TAG, "not current month " + result);
                                                }
                                                i2 = parseLong;
                                                cardBaseSe.setCard_number(((Command) content.getCommands().get(4)).getResult().substring(0, 16));
                                                cardBaseSe.setValidity(formatValidate(substring3));
                                                cardBaseSe.setStartdate(formatValidate(substring2));
                                                cardBaseSe.setLogicCardType(substring);
                                                cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(r6 - i)}));
                                                cardBaseSe.setTotal_monthly_amount(String.format("%d", new Object[]{Integer.valueOf(i2)}));
                                                return;
                                            }
                                            LogUtil.log(this.TAG, "apdu length is too short when reading total monthly amount " + result);
                                        }
                                        i2 = 0;
                                        cardBaseSe.setCard_number(((Command) content.getCommands().get(4)).getResult().substring(0, 16));
                                        cardBaseSe.setValidity(formatValidate(substring3));
                                        cardBaseSe.setStartdate(formatValidate(substring2));
                                        cardBaseSe.setLogicCardType(substring);
                                        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(r6 - i)}));
                                        cardBaseSe.setTotal_monthly_amount(String.format("%d", new Object[]{Integer.valueOf(i2)}));
                                        return;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    taskResult.setResult_code("430002");
                    taskResult.setResult_msg(CodeMessage.BUSINESS_CARD_START_DATE_ERROR_MSG);
                }
            }
        }
    }

    public int parseBalance(String str) {
        if (ValueUtil.isEmpty(str)) {
            LogUtil.loge(this.TAG, "parseBalance banlance is null");
            return 0;
        }
        if (str.substring(0, 2).equalsIgnoreCase("ff")) {
            str = "FF" + str;
        }
        return (int) Long.parseLong(str, 16);
    }

    private void updateLNTCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateLNTCardDetail commands is null");
            return;
        }
        String result = ((Command) list.get(1)).getResult();
        cardBaseSe.setCard_number(result.substring(16, 32));
        cardBaseSe.setValidity(formatValidate(result.substring(54, 62)));
        cardBaseSe.setRegion_id(result.substring(98, 100));
        result = ((Command) list.get(3)).getResult();
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(result.substring(0, result.length() - 4).substring(0, 8), 16))}));
    }

    private void updateCSCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateCSCardDetail commands is null");
            return;
        }
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(((Command) list.get(1)).getResult().substring(0, 8), 16))}));
        String result = ((Command) list.get(2)).getResult();
        cardBaseSe.setCard_number(result.substring(24, 40));
        cardBaseSe.setStartdate(result.substring(40, 48));
        cardBaseSe.setValidity(result.substring(48, 56));
    }

    private void updateJLCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateJLCardDetail commands is null");
            return;
        }
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(((Command) list.get(1)).getResult().substring(0, 8), 16))}));
        String result = ((Command) list.get(2)).getResult();
        cardBaseSe.setCard_number(result.substring(21, 40));
        cardBaseSe.setStartdate(result.substring(40, 48));
        cardBaseSe.setValidity(result.substring(48, 56));
    }

    private void updateXJCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateXJCardDetail commands is null");
            return;
        }
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(((Command) list.get(1)).getResult().substring(0, 8), 16))}));
        String result = ((Command) list.get(2)).getResult();
        cardBaseSe.setCard_number(result.substring(21, 40));
        cardBaseSe.setStartdate(result.substring(40, 48));
        cardBaseSe.setValidity(result.substring(48, 56));
    }

    private void updateHBCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateHBCardDetail commands is null");
            return;
        }
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(((Command) list.get(1)).getResult().substring(0, 8), 16))}));
        String result = ((Command) list.get(2)).getResult();
        cardBaseSe.setCard_number(result.substring(21, 40));
        cardBaseSe.setStartdate(result.substring(40, 48));
        cardBaseSe.setValidity(result.substring(48, 56));
    }

    private void updateGXCardDetail(CardBaseSe cardBaseSe, List<Command> list) {
        if (list == null || list.size() <= 0) {
            LogUtil.loge(this.TAG, "updateGXCardDetail commands is null");
            return;
        }
        cardBaseSe.setBalance(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(((Command) list.get(0)).getResult().substring(0, 8), 16))}));
        String result = ((Command) list.get(1)).getResult();
        cardBaseSe.setCard_number(result.substring(21, 40));
        cardBaseSe.setStartdate(result.substring(40, 48));
        cardBaseSe.setValidity(result.substring(48, 56));
    }

    private void setCardDetail(Context context, CardBaseSe cardBaseSe, TaskResult<String> taskResult) {
        long currentTimeMillis = System.currentTimeMillis();
        if (cardBaseSe != null) {
            try {
                if (!ValueUtil.isEmpty(cardBaseSe.getInstance_id())) {
                    Content buildApdu = buildApdu(cardBaseSe.getInstance_id());
                    TaskResult fetchChannel;
                    if (cardBaseSe.getInstance_id().equals(SeConstants.BJ_AID)) {
                        fetchChannel = ConfigUtil.getInstance().instanceOma().fetchChannel(context, buildApdu);
                        LogUtil.log(this.TAG, "apdu-execute:aid=" + buildApdu.getInstance_id());
                        if (fetchChannel.getResult_code().equals("0")) {
                            updateBjCardDetail(context, buildApdu, cardBaseSe, taskResult, (INfcChannel) fetchChannel.getData());
                        } else {
                            LogUtil.log(this.TAG, "apdu-execute:aid=" + buildApdu.getInstance_id() + " failure:" + fetchChannel.getResult_code() + "," + fetchChannel.getResult_msg());
                        }
                        ConfigUtil.getInstance().instanceOma().closeChannel(buildApdu);
                        LogUtil.log(this.TAG, " CardInfo_ setCardDetail successfully costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                    fetchChannel = ConfigUtil.getInstance().instanceOma().executeApdu(context, buildApdu);
                    if (fetchChannel == null || !fetchChannel.getResult_code().equals("0")) {
                        LogUtil.log(this.TAG, " fetch carddetail failure " + fetchChannel.getResult_msg());
                        LogUtil.log(this.TAG, " CardInfo_ setCardDetail successfully costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                    List commands = ((Content) fetchChannel.getData()).getCommands();
                    if (commands == null || commands.size() <= 0) {
                        LogUtil.log(this.TAG, " after execute apdu,the result is null ");
                        LogUtil.log(this.TAG, " CardInfo_ setCardDetail successfully costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                    if (CommonUtils.getInstance().isCardBank(cardBaseSe.getInstance_id())) {
                        updateBankCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.PSE_AID)) {
                        updateTaiZhouCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.WH_AID)) {
                        updateWhgjCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.WH_SUBWAY_AID)) {
                        updateWhdtCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.CQ_PSE_AID)) {
                        updateCqCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.SZ_AID)) {
                        updateSzCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.SZT_INSTANCE_AID)) {
                        updateSztCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.TF_AID)) {
                        updateTftCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.LNT_AID)) {
                        updateLNTCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.CS_AID)) {
                        updateCSCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.JL_AID)) {
                        updateJLCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.XJ_AID)) {
                        updateXJCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.HB_AID)) {
                        updateHBCardDetail(cardBaseSe, commands);
                    } else if (cardBaseSe.getInstance_id().equals(SeConstants.GX_AID)) {
                        updateGXCardDetail(cardBaseSe, commands);
                    } else {
                        LogUtil.loge(this.TAG, "setCardDetail instance_id:" + cardBaseSe.getInstance_id() + " NOT handled");
                    }
                    LogUtil.log(this.TAG, " CardInfo_ setCardDetail successfully costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
            } catch (SnowballException e) {
                taskResult.setResult_code(e.getResult_code() + "");
                taskResult.setResult_msg(e.getMessage());
                LogUtil.loge(this.TAG, " fetch carddetail exception:" + taskResult.getResult_msg());
            }
        }
        LogUtil.loge(this.TAG, "setCardDetail cardBaseSe is null or instance_id not set");
        LogUtil.log(this.TAG, " CardInfo_ setCardDetail successfully costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    private Content buildApdu(String str) {
        if (ValueUtil.isEmpty(str)) {
            return null;
        }
        Content content = new Content();
        content.setInstance_id(str);
        List arrayList = new ArrayList();
        content.setCommands(arrayList);
        Command command;
        if (CommonUtils.getInstance().isCardBank(str)) {
            command = new Command();
            command.setCommand("80CA9F7900");
            Command command2 = new Command();
            command2.setCommand("00B20114");
            arrayList.add(command);
            arrayList.add(command2);
            content.setCommands(arrayList);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu bank successfully ");
            return content;
        } else if (str.equals(SeConstants.PSE_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("00b0950000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu taizhou successfully ");
            return content;
        } else if (str.equals(SeConstants.WH_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("0020000003123456");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu whgj successfully ");
            return content;
        } else if (str.equals(SeConstants.WH_SUBWAY_AID)) {
            command = new Command();
            command.setCommand("00B0850000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu whdt successfully ");
            return content;
        } else if (str.equals(SeConstants.CQ_PSE_AID)) {
            command = new Command();
            command.setCommand("00B0850000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00a40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu cq successfully ");
            return content;
        } else if (str.equals(SeConstants.SZ_AID)) {
            command = new Command();
            command.setCommand("00a40000" + ValueUtil.toLV("DF01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("00b0950000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("0020000003123456");
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000104");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu sz successfully ");
            return content;
        } else if (str.equals(SeConstants.SZT_INSTANCE_AID) || str.equals(SeConstants.TF_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu szt or tft successfully ");
            return content;
        } else if (str.equals(SeConstants.BJ_AID)) {
            command = new Command();
            command.setCommand("00A40000023F00");
            command.setChecker(".*(9000|61.{2})$");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0840901");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0850001");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0840801");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0840000");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0850504");
            command.setChecker(".*(9000|61.{2})$");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            command.setChecker(".*(9000|61.{2})$");
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B2019C17");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0952506");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu bj successfully ");
            return content;
        } else if (str.equals(SeConstants.LNT_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("DDF1"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950058");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("ADF3"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu lnt successfully ");
            return content;
        } else if (str.equals(SeConstants.CS_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu lnt successfully ");
            return content;
        } else if (str.equals(SeConstants.JL_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu jl successfully ");
            return content;
        } else if (str.equals(SeConstants.XJ_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu xj successfully ");
            return content;
        } else if (str.equals(SeConstants.HB_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu hb successfully ");
            return content;
        } else if (str.equals(SeConstants.GX_AID)) {
            command = new Command();
            command.setCommand("805C000204");
            arrayList.add(command);
            command = new Command();
            command.setCommand("00B0950000");
            arrayList.add(command);
            LogUtil.log(this.TAG, " CardInfo_ buildApdu gx successfully ");
            return content;
        } else {
            LogUtil.loge(this.TAG, "buildApdu instance_id:" + str + " NOT handled");
            return content;
        }
    }

    private static String generateCardNumberForWHTransit(String str) {
        int i = 0;
        if (str == null || str.trim().equals("") || str.length() <= 9) {
            return str;
        }
        String substring = str.substring(str.length() - 9);
        int i2 = 0;
        while (i < substring.length()) {
            if (i == 0) {
                i2 = Integer.valueOf(String.valueOf(substring.charAt(i))).intValue();
            } else {
                i2 ^= Integer.valueOf(String.valueOf(substring.charAt(i))).intValue();
            }
            i++;
        }
        return substring + (i2 % 10);
    }

    private static String generateCardNumberForSZT(String str) {
        if (str == null || str.trim().equals("") || str.length() < 8) {
            return str;
        }
        String substring = str.substring(str.length() - 8);
        return String.valueOf(Integer.parseInt(substring.substring(6, 8) + substring.substring(4, 6) + substring.substring(2, 4) + substring.substring(0, 2), 16));
    }

    private String formatValidate(String str) {
        if (ValueUtil.isEmpty(str)) {
            LogUtil.loge(this.TAG, " formatValidate validate is null ");
            return str;
        }
        if (str.length() == 6) {
            String currentDateString = DateTimeUtil.currentDateString("yyyy");
            LogUtil.log(this.TAG, " formatValidate validate:" + str + " length is 6 need add the  year ,currentYear:" + currentDateString);
            str = currentDateString.substring(0, 2) + str;
        }
        if (str.length() == 8) {
            LogUtil.log(this.TAG, " formatValidate validate:" + str + " length is 8 need format ");
            if (isValidDate(str)) {
                return DateTimeUtil.format(DateTimeUtil.parseDateString(str, "yyyyMMdd"), "yyyy-MM-dd");
            }
            LogUtil.loge(this.TAG, " formatValidate validate:" + str + " is wrong format");
            return null;
        }
        LogUtil.loge(this.TAG, " formatValidate validate:" + str + " length is not right ");
        return str;
    }

    public boolean isValidDate(String str) {
        boolean z = true;
        if (!str.matches("[0-9]*")) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(str);
        } catch (ParseException e) {
            z = false;
        }
        return z;
    }
}
