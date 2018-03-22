package com.snowballtech.business.inner;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.apdu.internal.INfcChannel;
import com.snowballtech.apdu.smartdevice_oma.constant.SmartDeviceCode;
import com.snowballtech.business.bean.ODInventory;
import com.snowballtech.business.bean.RecordTopupsForSe;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BusinessCardTransaction extends BusinessCommon {
    private String TAG = Constant.LOG_FLAG_TRANS_QUERY_SE;

    class C62321 implements Comparator<ODInventory> {
        C62321() {
        }

        public int compare(ODInventory oDInventory, ODInventory oDInventory2) {
            return oDInventory.getTransaction_time().compareTo(oDInventory2.getTransaction_time()) * -1;
        }
    }

    public BusinessCardTransaction(int i) {
        super(i);
    }

    public TaskResult<String> fetchCardTransSe(Context context, String str) throws SnowballException {
        TaskResult<String> taskResult = new TaskResult();
        if (fetchInstallStatus(context, str) == 2) {
            RecordTopupsForSe recordTopupsForSe = new RecordTopupsForSe();
            List arrayList = new ArrayList();
            recordTopupsForSe.setRecords(arrayList);
            setCardTransaction(context, recordTopupsForSe, str);
            if (arrayList != null && arrayList.size() > 0) {
                Collections.sort(arrayList, new C62321());
            }
            taskResult.setResult_code("0");
            taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
            taskResult.setData(JsonUtil.getInstance().serializeObject(recordTopupsForSe, new boolean[0]));
        } else {
            taskResult.setData(null);
            taskResult.setResult_msg("instance_id:" + str + "未个人化");
        }
        return taskResult;
    }

    private void updateBankCardTransaction(Context context, String str, RecordTopupsForSe recordTopupsForSe) throws SnowballException {
        Content content = new Content();
        content.setInstance_id(str);
        TaskResult fetchChannel = ConfigUtil.getInstance().instanceOma().fetchChannel(context, content);
        if (fetchChannel.getResult_code().equals("0")) {
            List arrayList = new ArrayList();
            if (isPBOC2((INfcChannel) fetchChannel.getData())) {
                LogUtil.log(this.TAG, this.TAG + HwAccountConstants.BLANK + LogUtil.CARD_INFO + " pboc2 ");
                arrayList.addAll(queryAllPBOC2((INfcChannel) fetchChannel.getData()));
            } else {
                LogUtil.log(this.TAG, this.TAG + HwAccountConstants.BLANK + LogUtil.CARD_INFO + " pboc3 ");
                arrayList.addAll(queryConsumePBOC3((INfcChannel) fetchChannel.getData()));
                arrayList.addAll(queryTopupPBOC3((INfcChannel) fetchChannel.getData()));
            }
            recordTopupsForSe.setRecords(arrayList);
            ConfigUtil.getInstance().instanceOma().closeChannlAll();
        }
    }

    private void updateTaiZhouCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (!command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)}))) {
                    int i;
                    ODInventory oDInventory = new ODInventory();
                    oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                    String format = String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))});
                    oDInventory.setTransaction_amount(format);
                    if (command.getIndex() >= 101 && command.getIndex() <= 110) {
                        String substring = command.getResult().substring(18, 20);
                        if (substring.matches("10|02|01")) {
                            substring = "1";
                        } else if (substring.matches("11|09|06|05")) {
                            substring = "2";
                        } else {
                            LogUtil.loge(this.TAG, "updateTaiZhouCardTransaction type:" + substring + " Not handled.");
                        }
                        oDInventory.setTransaction_type(substring);
                        i = 1;
                    } else if (command.getIndex() >= 201 && command.getIndex() <= 210) {
                        oDInventory.setTransaction_type("3");
                        i = 1;
                    } else if (command.getIndex() < 301 || command.getIndex() > 310) {
                        LogUtil.loge(this.TAG, "updateTaiZhouCardTransaction command.index:" + command.getIndex() + " Not handled.");
                        i = 0;
                    } else {
                        oDInventory.setTransaction_amount(format);
                        oDInventory.setTransaction_type("1");
                        i = 1;
                    }
                    if (i != 0) {
                        recordTopupsForSe.getRecords().add(oDInventory);
                    }
                }
            }
        }
    }

    private void updateStandardCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getResult().length() >= 46) {
                    if (!command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)}))) {
                        if (command.getIndex() < 101 || command.getIndex() > 110) {
                            LogUtil.loge(this.TAG, "updateStandardCardTransaction command.index:" + command.getIndex() + " Not handled.");
                        } else {
                            ODInventory oDInventory = new ODInventory();
                            oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                            oDInventory.setTransaction_amount(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))}));
                            String substring = command.getResult().substring(18, 20);
                            if (substring.matches("10|02|01")) {
                                substring = "1";
                            } else if (substring.matches("11|09|06|05|0A")) {
                                substring = "2";
                            } else {
                                LogUtil.loge(this.TAG, "updateStandardCardTransaction type:" + substring + " Not handled.");
                            }
                            oDInventory.setTransaction_type(substring);
                            recordTopupsForSe.getRecords().add(oDInventory);
                        }
                    }
                }
            }
        }
    }

    private void updateTFTCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getResult().length() >= 46) {
                    if (!command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)}))) {
                        ODInventory oDInventory = new ODInventory();
                        oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                        oDInventory.setTransaction_amount(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))}));
                        if (command.getIndex() >= 101 && command.getIndex() <= 110) {
                            String substring = command.getResult().substring(18, 20);
                            if (substring.matches("10|02|01")) {
                                substring = "1";
                            } else if (substring.matches("11|09|06|05")) {
                                substring = "2";
                            } else {
                                LogUtil.loge(this.TAG, "updateTFTCardTransaction type:" + substring + " Not handled.");
                            }
                            oDInventory.setTransaction_type(substring);
                        } else if (command.getIndex() < 201 || command.getIndex() > 210) {
                            LogUtil.loge(this.TAG, "updateTFTCardTransaction command.index:" + command.getIndex() + " Not handled.");
                        } else {
                            oDInventory.setTransaction_type("2");
                        }
                        recordTopupsForSe.getRecords().add(oDInventory);
                    }
                }
            }
        }
    }

    private void setCardTransaction(Context context, RecordTopupsForSe recordTopupsForSe, String str) throws SnowballException {
        if (!(recordTopupsForSe == null || ValueUtil.isEmpty(str))) {
            if (CommonUtils.getInstance().isCardBank(str)) {
                LogUtil.log(this.TAG, " bank transaction ");
                updateBankCardTransaction(context, str, recordTopupsForSe);
            } else {
                LogUtil.log(this.TAG, " transit transaction " + str);
                TaskResult executeApdu = ConfigUtil.getInstance().instanceOma().executeApdu(context, buildApdu(str));
                if (executeApdu == null || !executeApdu.getResult_code().equals("0")) {
                    throw new SnowballException(executeApdu.getResult_msg(), Integer.parseInt(executeApdu.getResult_code()));
                }
                List commands = ((Content) executeApdu.getData()).getCommands();
                if (commands == null || commands.size() <= 0) {
                    LogUtil.loge(this.TAG, "setCardTransaction after execute apdu,the result is null ");
                } else if (str.equals(SeConstants.PSE_AID)) {
                    updateTaiZhouCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.WH_AID)) {
                    updateStandardCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.WH_SUBWAY_AID)) {
                    updateStandardCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.CQ_PSE_AID)) {
                    updateStandardCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.SZ_AID)) {
                    updateStandardCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.SZT_INSTANCE_AID)) {
                    updateStandardCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.TF_AID)) {
                    updateTFTCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.BJ_AID)) {
                    updateStandardCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.LNT_AID)) {
                    updateLNTCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.CS_AID)) {
                    updateCSCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.JL_AID)) {
                    updateJLCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.XJ_AID)) {
                    updateXJCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.HB_AID)) {
                    updateHBCardTransaction(recordTopupsForSe, commands);
                } else if (str.equals(SeConstants.GX_AID)) {
                    updateGXCardTransaction(recordTopupsForSe, commands);
                } else {
                    LogUtil.loge(this.TAG, "setCardTransaction instance_id:" + str + " NOT handled");
                }
            }
        }
        LogUtil.log(this.TAG, " CardInfo_ cardTransaction successfully ");
    }

    private Content buildApdu(String str) {
        if (ValueUtil.isEmpty(str)) {
            return null;
        }
        Content content = new Content();
        content.setMediaType(getMediaType());
        content.setInstance_id(str);
        List arrayList = new ArrayList();
        content.setCommands(arrayList);
        Command command;
        int i;
        Command command2;
        if (str.equals(SeConstants.PSE_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 100);
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 200);
                command2.setCommand(String.format("00B2%02X8400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 300);
                command2.setCommand(String.format("00B2%02XD400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu taizhou successfully ");
            return content;
        } else if (str.equals(SeConstants.WH_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("0020000003123456");
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 100);
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu whgj successfully ");
            return content;
        } else if (str.equals(SeConstants.WH_SUBWAY_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
                command2.setIndex(i + 100);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu whdt successfully ");
            return content;
        } else if (str.equals(SeConstants.CQ_PSE_AID)) {
            command = new Command();
            command.setCommand("00a40000" + ValueUtil.toLV("3F01"));
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 100);
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu cq successfully ");
            return content;
        } else if (str.equals(SeConstants.SZ_AID)) {
            command = new Command();
            command.setCommand("00a40000" + ValueUtil.toLV("DF01"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("0020000003123456");
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 100);
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu sz successfully ");
            return content;
        } else if (str.equals(SeConstants.SZT_INSTANCE_AID) || str.equals(SeConstants.BJ_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 100);
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu szt successfully ");
            return content;
        } else if (str.equals(SeConstants.TF_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                command2.setIndex(i + 100);
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 200);
                command2.setCommand(String.format("00B2%02X8400", new Object[]{Integer.valueOf(i)}));
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu tft successfully ");
            return content;
        } else if (str.equals(SeConstants.BJ_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("1001"));
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 100);
                command2.setCommand(String.format("00B2%02X9C17", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu bj successfully ");
            return content;
        } else if (str.equals(SeConstants.LNT_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("ddf1"));
            arrayList.add(command);
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("ADF3"));
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 100);
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu lnt successfully ");
            return content;
        } else if (str.equals(SeConstants.CS_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            command.setIndex(1);
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                command2.setIndex(i + 100);
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 200);
                command2.setCommand(String.format("00B2%02X8400", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 300);
                command2.setCommand(String.format("00B2%02XD400", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu tft successfully ");
            return content;
        } else if (str.equals(SeConstants.JL_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            command.setIndex(1);
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                command2.setIndex(i + 100);
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 300);
                command2.setCommand(String.format("00B2%02XFC00", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu jl successfully ");
            return content;
        } else if (str.equals(SeConstants.XJ_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            command.setIndex(1);
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                command2.setIndex(i + 100);
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 300);
                command2.setCommand(String.format("00B2%02XFC00", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu xj successfully ");
            return content;
        } else if (str.equals(SeConstants.HB_AID)) {
            command = new Command();
            command.setCommand("00A40000" + ValueUtil.toLV("3F01"));
            command.setIndex(1);
            arrayList.add(command);
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                command2.setIndex(i + 100);
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 300);
                command2.setCommand(String.format("00B2%02XFC00", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu hb successfully ");
            return content;
        } else if (!str.equals(SeConstants.GX_AID)) {
            return content;
        } else {
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setCommand(String.format("00B2%02XC400", new Object[]{Integer.valueOf(i)}));
                command2.setIndex(i + 100);
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            for (i = 1; i <= 10; i++) {
                command2 = new Command();
                command2.setIndex(i + 300);
                command2.setCommand(String.format("00B2%02XFC00", new Object[]{Integer.valueOf(i)}));
                command2.setChecker(".*(9000|6A83)$");
                arrayList.add(command2);
            }
            LogUtil.log(this.TAG, " CardInfo_ buildApdu gx successfully ");
            return content;
        }
    }

    public boolean isPBOC2(INfcChannel iNfcChannel) {
        try {
            String toHexString = ByteHelperUtil.toHexString(iNfcChannel.transmit(ByteHelperUtil.hexStringToByteArray("00b2016400")));
            LogUtil.log(this.TAG, " CardInfo_execute apdu:00b2016400, result:" + toHexString);
            if (ValueUtil.isEmpty(toHexString) || !toHexString.endsWith(SmartDeviceCode.AID_NOT_EXIST)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    List<ODInventory> queryAllPBOC2(INfcChannel iNfcChannel) {
        LogUtil.log(this.TAG, " CardInfo_queryAllPBOC2 start");
        List<ODInventory> arrayList = new ArrayList();
        String toHex = ValueUtil.toHex(92, 2, "");
        int i = 1;
        while (i <= 10) {
            String format = String.format("00B20%s" + toHex + "00", new Object[]{ValueUtil.toHex(i, 1, "")});
            try {
                String toHexString = ByteHelperUtil.toHexString(iNfcChannel.transmit(ByteHelperUtil.hexStringToByteArray(format)));
                LogUtil.log(this.TAG, " CardInfo_execute apdu:" + format + ",result:" + toHexString);
                if (ValueUtil.isEmpty(toHexString) || !toHexString.endsWith("9000")) {
                    break;
                }
                CharSequence substring = toHexString.substring(84, 86);
                ODInventory oDInventory = new ODInventory();
                oDInventory.setTransaction_time(DateTimeUtil.currentDateString("yyyy").substring(0, 2) + toHexString.substring(0, 2) + "-" + toHexString.substring(2, 4) + "-" + toHexString.substring(4, 6) + HwAccountConstants.BLANK + toHexString.substring(6, 8) + ":" + toHexString.substring(8, 10) + ":" + toHexString.substring(10, 12));
                oDInventory.setTransaction_status(0);
                if (TextUtils.isEmpty(substring) || !"00".equals(substring)) {
                    oDInventory.setTransaction_type("1");
                    oDInventory.setTransaction_amount(ValueUtil.parseInt(toHexString.substring(24, 36)) + "");
                } else {
                    oDInventory.setTransaction_type("2");
                    oDInventory.setTransaction_amount(ValueUtil.parseInt(toHexString.substring(12, 24)) + "");
                }
                arrayList.add(oDInventory);
                LogUtil.log(this.TAG, " CardInfo_queryAllPBOC2 end record:" + JsonUtil.getInstance().serializeObject(arrayList, new boolean[0]));
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    List<ODInventory> queryConsumePBOC3(INfcChannel iNfcChannel) {
        LogUtil.log(this.TAG, " CardInfo_queryConsumePBOC3 start");
        List<ODInventory> arrayList = new ArrayList();
        String toHex = ValueUtil.toHex(92, 2, "");
        int i = 1;
        while (i <= 10) {
            String format = String.format("00B20%s" + toHex + "00", new Object[]{ValueUtil.toHex(i, 1, "")});
            try {
                String toHexString = ByteHelperUtil.toHexString(iNfcChannel.transmit(ByteHelperUtil.hexStringToByteArray(format)));
                LogUtil.log(this.TAG, " CardInfo_execute apdu:" + format + ",result:" + toHexString);
                if (ValueUtil.isEmpty(toHexString) || !toHexString.endsWith("9000")) {
                    break;
                }
                CharSequence substring = toHexString.substring(84, 86);
                if (!TextUtils.isEmpty(substring) && "00".equals(substring)) {
                    ODInventory oDInventory = new ODInventory();
                    oDInventory.setTransaction_time(DateTimeUtil.currentDateString("yyyy").substring(0, 2) + toHexString.substring(0, 2) + "-" + toHexString.substring(2, 4) + "-" + toHexString.substring(4, 6) + HwAccountConstants.BLANK + toHexString.substring(6, 8) + ":" + toHexString.substring(8, 10) + ":" + toHexString.substring(10, 12));
                    oDInventory.setTransaction_amount(ValueUtil.parseInt(toHexString.substring(12, 24)) + "");
                    oDInventory.setTransaction_status(0);
                    oDInventory.setTransaction_type("2");
                    arrayList.add(oDInventory);
                }
                LogUtil.log(this.TAG, " CardInfo_queryConsumePBOC3 end record:" + JsonUtil.getInstance().serializeObject(arrayList, new boolean[0]));
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    List<ODInventory> queryTopupPBOC3(INfcChannel iNfcChannel) {
        int i = 0;
        LogUtil.log(this.TAG, " CardInfo_queryTopup start");
        List<ODInventory> arrayList = new ArrayList();
        String str = "00B200" + ValueUtil.toHex(100, 2, "") + "00";
        try {
            String toHexString = ByteHelperUtil.toHexString(iNfcChannel.transmit(ByteHelperUtil.hexStringToByteArray(str)));
            LogUtil.log(this.TAG, " CardInfo_execute apdu:" + str + ",result:" + toHexString);
            if (!TextUtils.isEmpty(toHexString) && toHexString.endsWith("9000")) {
                int i2;
                Object substring = toHexString.substring(4, 6);
                if (TextUtils.isEmpty(substring)) {
                    i2 = 0;
                } else {
                    i2 = ValueUtil.parseInt(substring, 16);
                }
                toHexString = toHexString.substring(6, toHexString.length() - 12);
                while (i < i2) {
                    ODInventory oDInventory = new ODInventory();
                    String substring2 = toHexString.substring(i * 44, (i * 44) + 44);
                    LogUtil.log(this.TAG, " CardInfo_ date -- >" + substring2 + ",i=" + i + ",N=" + 44);
                    oDInventory.setTransaction_time(DateTimeUtil.currentDateString("yyyy").substring(0, 2) + substring2.substring(28, 30) + "-" + "" + substring2.substring(30, 32) + "-" + substring2.substring(32, 34) + HwAccountConstants.BLANK + substring2.substring(34, 36) + ":" + substring2.substring(36, 38) + ":" + substring2.substring(38, 40));
                    oDInventory.setTransaction_amount((ValueUtil.parseInt(substring2.substring(16, 28)) - ValueUtil.parseInt(substring2.substring(4, 16))) + "");
                    oDInventory.setTransaction_status(0);
                    oDInventory.setTransaction_type("1");
                    arrayList.add(oDInventory);
                    i++;
                }
            }
            LogUtil.log(this.TAG, " CardInfo_queryTopup end record:" + JsonUtil.getInstance().serializeObject(arrayList, new boolean[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private void updateLNTCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getResult().length() < 48 || command.getIndex() < 101 || command.getIndex() > 110) {
                    LogUtil.loge(this.TAG, "updateLNTCardTransaction  rpdu length is worry");
                } else if (ValueUtil.matchZero(command.getResult().substring(36, 46))) {
                    LogUtil.log(this.TAG + "date is all 0, ignore");
                } else {
                    ODInventory oDInventory = new ODInventory();
                    oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(36, 46)));
                    oDInventory.setTransaction_amount(String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))}));
                    String substring = command.getResult().substring(18, 20);
                    if (substring.equals("01") || substring.equals("02")) {
                        oDInventory.setTransaction_type("1");
                    } else if (substring.equals("06") || substring.equals("09")) {
                        oDInventory.setTransaction_type("2");
                    } else {
                        LogUtil.loge(this.TAG, "updateLNTCardTransaction  transtype:" + substring + " Not handled.");
                    }
                    recordTopupsForSe.getRecords().add(oDInventory);
                }
            }
        }
    }

    private void updateCSCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getIndex() == 1) {
                    if (!command.getResult().endsWith("9000")) {
                        return;
                    }
                } else if (command.getResult().length() >= 50) {
                    if (!(command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)})) || command.getResult().substring(32, 46).equals("FFFFFFFFFFFFFF"))) {
                        int i;
                        ODInventory oDInventory = new ODInventory();
                        oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                        String format = String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))});
                        oDInventory.setTransaction_amount(format);
                        if (command.getIndex() >= 101 && command.getIndex() <= 110) {
                            String substring = command.getResult().substring(18, 20);
                            if (substring.matches("10|02|01")) {
                                substring = "1";
                            } else if (substring.matches("11|09|06|05")) {
                                substring = "2";
                            } else {
                                LogUtil.loge(this.TAG, "updateCSCardTransaction type:" + substring + " Not handled.");
                            }
                            oDInventory.setTransaction_type(substring);
                            i = 1;
                        } else if (command.getIndex() >= 201 && command.getIndex() <= 210) {
                            oDInventory.setTransaction_type("3");
                            i = 1;
                        } else if (command.getIndex() < 301 || command.getIndex() > 310) {
                            LogUtil.loge(this.TAG, "updateCSCardTransaction command.index:" + command.getIndex() + " Not handled.");
                            i = 0;
                        } else {
                            oDInventory.setTransaction_amount(format);
                            oDInventory.setTransaction_type("1");
                            i = 1;
                        }
                        if (i != 0) {
                            recordTopupsForSe.getRecords().add(oDInventory);
                        }
                    }
                }
            }
        }
    }

    private void updateJLCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getIndex() == 1) {
                    if (!command.getResult().endsWith("9000")) {
                        return;
                    }
                } else if (command.getResult().length() >= 50) {
                    if (!(command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)})) || command.getResult().substring(32, 46).equals("FFFFFFFFFFFFFF"))) {
                        int i;
                        ODInventory oDInventory = new ODInventory();
                        oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                        String format = String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))});
                        oDInventory.setTransaction_amount(format);
                        if (command.getIndex() >= 101 && command.getIndex() <= 110) {
                            String substring = command.getResult().substring(18, 20);
                            if (substring.matches("10|02|01")) {
                                substring = "1";
                            } else if (substring.matches("11|09|06|05")) {
                                substring = "2";
                            } else {
                                LogUtil.loge(this.TAG, "updateJLCardTransaction type:" + substring + " Not handled.");
                            }
                            oDInventory.setTransaction_type(substring);
                            i = 1;
                        } else if (command.getIndex() < 301 || command.getIndex() > 310) {
                            LogUtil.loge(this.TAG, "updateJLCardTransaction command.index:" + command.getIndex() + " Not handled.");
                            i = 0;
                        } else {
                            oDInventory.setTransaction_amount(format);
                            oDInventory.setTransaction_type("1");
                            i = 1;
                        }
                        if (i != 0) {
                            recordTopupsForSe.getRecords().add(oDInventory);
                        }
                    }
                }
            }
        }
    }

    private void updateXJCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getIndex() == 1) {
                    if (!command.getResult().endsWith("9000")) {
                        return;
                    }
                } else if (command.getResult().length() >= 50) {
                    if (!(command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)})) || command.getResult().substring(32, 46).equals("FFFFFFFFFFFFFF"))) {
                        int i;
                        ODInventory oDInventory = new ODInventory();
                        oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                        String format = String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))});
                        oDInventory.setTransaction_amount(format);
                        if (command.getIndex() >= 101 && command.getIndex() <= 110) {
                            String substring = command.getResult().substring(18, 20);
                            if (substring.matches("10|02|01")) {
                                substring = "1";
                            } else if (substring.matches("11|09|06|05")) {
                                substring = "2";
                            } else {
                                LogUtil.loge(this.TAG, "updateXJCardTransaction type:" + substring + " Not handled.");
                            }
                            oDInventory.setTransaction_type(substring);
                            i = 1;
                        } else if (command.getIndex() < 301 || command.getIndex() > 310) {
                            LogUtil.loge(this.TAG, "updateXJCardTransaction command.index:" + command.getIndex() + " Not handled.");
                            i = 0;
                        } else {
                            oDInventory.setTransaction_amount(format);
                            oDInventory.setTransaction_type("1");
                            i = 1;
                        }
                        if (i != 0) {
                            recordTopupsForSe.getRecords().add(oDInventory);
                        }
                    }
                }
            }
        }
    }

    private void updateHBCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getIndex() == 1) {
                    if (!command.getResult().endsWith("9000")) {
                        return;
                    }
                } else if (command.getResult().length() >= 50) {
                    if (!(command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)})) || command.getResult().substring(32, 46).equals("FFFFFFFFFFFFFF"))) {
                        int i;
                        ODInventory oDInventory = new ODInventory();
                        oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                        String format = String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))});
                        oDInventory.setTransaction_amount(format);
                        if (command.getIndex() >= 101 && command.getIndex() <= 110) {
                            String substring = command.getResult().substring(18, 20);
                            if (substring.matches("10|02|01")) {
                                substring = "1";
                            } else if (substring.matches("11|09|06|05")) {
                                substring = "2";
                            } else {
                                LogUtil.loge(this.TAG, "updateHBCardTransaction type:" + substring + " Not handled.");
                            }
                            oDInventory.setTransaction_type(substring);
                            i = 1;
                        } else if (command.getIndex() < 301 || command.getIndex() > 310) {
                            LogUtil.loge(this.TAG, "updateHBCardTransaction command.index:" + command.getIndex() + " Not handled.");
                            i = 0;
                        } else {
                            oDInventory.setTransaction_amount(format);
                            oDInventory.setTransaction_type("1");
                            i = 1;
                        }
                        if (i != 0) {
                            recordTopupsForSe.getRecords().add(oDInventory);
                        }
                    }
                }
            }
        }
    }

    private void updateGXCardTransaction(RecordTopupsForSe recordTopupsForSe, List<Command> list) {
        if (list != null && list.size() > 0 && recordTopupsForSe != null) {
            if (recordTopupsForSe.getRecords() == null) {
                recordTopupsForSe.setRecords(new ArrayList());
            }
            for (Command command : list) {
                if (command.getIndex() == 1) {
                    if (!command.getResult().endsWith("9000")) {
                        return;
                    }
                } else if (command.getResult().length() >= 50) {
                    if (!(command.getResult().substring(32, 46).equals(String.format("%014d", new Object[]{Integer.valueOf(0)})) || command.getResult().substring(32, 46).equals("FFFFFFFFFFFFFF"))) {
                        int i;
                        ODInventory oDInventory = new ODInventory();
                        oDInventory.setTransaction_time(formatDatetimeForTransaction(command.getResult().substring(32, 46)));
                        String format = String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(command.getResult().substring(10, 18), 16))});
                        oDInventory.setTransaction_amount(format);
                        if (command.getIndex() >= 101 && command.getIndex() <= 110) {
                            String substring = command.getResult().substring(18, 20);
                            if (substring.matches("10|02|01")) {
                                substring = "1";
                            } else if (substring.matches("11|09|06|05")) {
                                substring = "2";
                            } else {
                                LogUtil.loge(this.TAG, "updateGXCardTransaction type:" + substring + " Not handled.");
                            }
                            oDInventory.setTransaction_type(substring);
                            i = 1;
                        } else if (command.getIndex() < 301 || command.getIndex() > 310) {
                            LogUtil.loge(this.TAG, "updateGXCardTransaction command.index:" + command.getIndex() + " Not handled.");
                            i = 0;
                        } else {
                            oDInventory.setTransaction_amount(format);
                            oDInventory.setTransaction_type("1");
                            i = 1;
                        }
                        if (i != 0) {
                            recordTopupsForSe.getRecords().add(oDInventory);
                        }
                    }
                }
            }
        }
    }
}
