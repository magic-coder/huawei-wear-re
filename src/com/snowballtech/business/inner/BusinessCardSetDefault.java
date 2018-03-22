package com.snowballtech.business.inner;

import android.content.Context;
import com.snowballtech.apdu.bean.Content;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.business.bean.Tlv;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.ApduUtil;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.ConfigUtil;
import com.snowballtech.common.bean.Command;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessCardSetDefault extends BusinessCommon {
    private String TAG = Constant.LOG_FLAG_CARD_SWITCH;

    public BusinessCardSetDefault(int i) {
        super(i);
    }

    private int deactivateTransitProxyCardAndMifare(List<String> list, String str, Context context) throws SnowballException {
        TaskResult executeApdu;
        LogUtil.log(this.TAG, " enter proxy deactivateTransitProxyCardAndMifare ");
        List arrayList = new ArrayList();
        Object obj = null;
        Command command;
        if (str.equals(SeConstants.MIFARE_VCM_INSTANCE_ID)) {
            command = new Command();
            command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS)));
            command.setChecker(".*");
            arrayList.add(command);
            command = new Command();
            command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.MIFARE_VCM_INSTANCE_ID)));
            arrayList.add(command);
            command = new Command();
            command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.MIFARE_VSM_INSTANCE_ID)));
            arrayList.add(command);
        } else {
            obj = 1;
            command = new Command();
            command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(str)));
            arrayList.add(command);
            command = new Command();
            command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS)));
            command.setChecker(".*");
            arrayList.add(command);
        }
        Content content = new Content();
        content.setCommands(arrayList);
        content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID);
        TaskResult executeApdu2 = ConfigUtil.getInstance().instanceOma().executeApdu(context, content);
        if (obj != null) {
            LogUtil.log(this.TAG, "  need to deactive proxy app ");
            if (executeApdu2 == null || !executeApdu2.getResult_code().equals("0")) {
                LogUtil.log(this.TAG, "  don't deactive proxy app,because deactive failure ");
            } else {
                LogUtil.log(this.TAG, "  deactive proxy app ");
                content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS);
                arrayList.clear();
                Command command2 = new Command();
                command2.setCommand("80F00000" + ValueUtil.toLV("4F" + ValueUtil.toLV(str)));
                arrayList.add(command2);
                executeApdu = ConfigUtil.getInstance().instanceOma().executeApdu(context, content);
                return ValueUtil.parseInt(executeApdu.getResult_code());
            }
        }
        executeApdu = executeApdu2;
        return ValueUtil.parseInt(executeApdu.getResult_code());
    }

    private int deactivateStandardCard(List<String> list, String str, Context context) throws SnowballException {
        LogUtil.log(this.TAG, " enter standard deactivateStandardCard ");
        Content content = new Content();
        content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID);
        List arrayList = new ArrayList();
        content.setCommands(arrayList);
        Command command = new Command();
        command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(str)));
        arrayList.add(command);
        return ValueUtil.parseInt(ConfigUtil.getInstance().instanceOma().executeApdu(context, content).getResult_code());
    }

    public int deactivateCard(Context context, String str) throws SnowballException {
        if (ValueUtil.isEmpty(str)) {
            LogUtil.log(this.TAG, " CardInfo_ instance_id is null ");
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
        } else if (fetchInstallStatus(context, str) != 2) {
            LogUtil.log(this.TAG, " CardInfo_ instance_id:" + str + " no perso,so no need to execute  ");
            throw new SnowballException(CodeMessage.BUSINESS_INSTANCE_NO_PERSAO_MSG, (int) CodeMessage.BUSINESS_INSTANCE_NO_PERSAO);
        } else {
            LogUtil.log(this.TAG, "");
            String str2 = "D616|BA1D|DA3E|E753|2198";
            String str3 = "8ED5|A998";
            String str4 = (String) ApduUtil.getInstance().getCPLC(context, getMediaType()).getData();
            if (ValueUtil.isEmpty(str4)) {
                LogUtil.log(this.TAG, " cplc is null ");
                throw new SnowballException("异常错误 cplc is null ");
            }
            str4 = str4.substring(12, 16);
            Map fetchHaveActivatedCards = fetchHaveActivatedCards(context, str4);
            LogUtil.log(this.TAG, " se os version:" + str4);
            if (CommonUtils.getInstance().isCardBank(str)) {
                return deactivateStandardCard((List) fetchHaveActivatedCards.get("bank"), str, context);
            }
            if (str4.matches(str3)) {
                LogUtil.log(this.TAG, " CardInfo_ proxy ");
                str4 = SeConstants.GREE_MF_AID + "|" + SeConstants.GREE_MF_AID1 + "|" + SeConstants.GREE_MF_AID2 + "|" + SeConstants.GREE_MF_AID3 + "|" + SeConstants.GREE_MF_AID4;
                if (!str.matches("315041592E5359532E4444463031|535A542E57414C4C45542E454E56|9156000014010001") && !str.matches(str4)) {
                    return deactivateTransitProxyCardAndMifare((List) fetchHaveActivatedCards.get("transit"), str, context);
                }
                LogUtil.log(this.TAG, LogUtil.CARD_INFO + str + " is not in proxy list,need to call standard method ");
                return deactivateStandardCard((List) fetchHaveActivatedCards.get("transit"), str, context);
            } else if (str4.matches(str2)) {
                LogUtil.log(this.TAG, " CardInfo_ standard transit ");
                return deactivateStandardCard((List) fetchHaveActivatedCards.get("transit"), str, context);
            } else {
                LogUtil.log(this.TAG, " CardInfo_ no match  ");
                return com.snowballtech.common.constant.CodeMessage.EXCEPTION_ERROR;
            }
        }
    }

    public int switchCard(Context context, String str) throws SnowballException {
        if (ValueUtil.isEmpty(str)) {
            LogUtil.log(this.TAG, " CardInfo_ instance_id is null ");
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
        } else if (fetchInstallStatus(context, str) != 2) {
            LogUtil.log(this.TAG, " CardInfo_ instance_id:" + str + " no perso,so no need to execute  ");
            throw new SnowballException(CodeMessage.BUSINESS_INSTANCE_NO_PERSAO_MSG, (int) CodeMessage.BUSINESS_INSTANCE_NO_PERSAO);
        } else {
            LogUtil.log(this.TAG, "");
            String str2 = "D616|BA1D|DA3E|E753|2198";
            String str3 = "8ED5|A998";
            String str4 = (String) ApduUtil.getInstance().getCPLC(context, getMediaType()).getData();
            if (ValueUtil.isEmpty(str4)) {
                LogUtil.log(this.TAG, " cplc is null ");
                throw new SnowballException("异常错误 cplc is null ");
            }
            str4 = str4.substring(12, 16);
            Map fetchHaveActivatedCards = fetchHaveActivatedCards(context, str4);
            LogUtil.log(this.TAG, " se os version:" + str4);
            if (CommonUtils.getInstance().isCardBank(str)) {
                return switchStandardCard((List) fetchHaveActivatedCards.get("bank"), str, context);
            }
            if (str4.matches(str3)) {
                LogUtil.log(this.TAG, " CardInfo_ proxy ");
                str4 = SeConstants.GREE_MF_AID + "|" + SeConstants.GREE_MF_AID1 + "|" + SeConstants.GREE_MF_AID2 + "|" + SeConstants.GREE_MF_AID3 + "|" + SeConstants.GREE_MF_AID4;
                if (!str.matches("315041592E5359532E4444463031|535A542E57414C4C45542E454E56|9156000014010001") && !str.matches(str4)) {
                    return switchTransitProxyCardAndMifare((List) fetchHaveActivatedCards.get("transit"), str, context);
                }
                LogUtil.log(this.TAG, LogUtil.CARD_INFO + str + " is not in proxy list,need to call standard method ");
                return switchStandardCard((List) fetchHaveActivatedCards.get("transit"), str, context);
            } else if (str4.matches(str2)) {
                LogUtil.log(this.TAG, " CardInfo_ standard transit ");
                return switchStandardCard((List) fetchHaveActivatedCards.get("transit"), str, context);
            } else {
                LogUtil.log(this.TAG, " CardInfo_ no match  ");
                return com.snowballtech.common.constant.CodeMessage.EXCEPTION_ERROR;
            }
        }
    }

    private int switchStandardCard(List<String> list, String str, Context context) throws SnowballException {
        LogUtil.log(this.TAG, " enter standard setdefaultcard ");
        Content content = new Content();
        content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID);
        List arrayList = new ArrayList();
        content.setCommands(arrayList);
        if (list == null || list.size() <= 0) {
            LogUtil.log(this.TAG, " don't have any have actived card ");
        } else {
            for (String str2 : list) {
                Command command = new Command();
                command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(str2)));
                arrayList.add(command);
            }
        }
        Command command2 = new Command();
        command2.setCommand("80F00101" + ValueUtil.toLV("4F" + ValueUtil.toLV(str)));
        arrayList.add(command2);
        return ValueUtil.parseInt(ConfigUtil.getInstance().instanceOma().executeApdu(context, content).getResult_code());
    }

    private int switchTransitProxyCardAndMifare(List<String> list, String str, Context context) throws SnowballException {
        TaskResult executeApdu;
        LogUtil.log(this.TAG, " enter proxy switchTransitProxyCardAndMifare ");
        List arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                Command command = new Command();
                command.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(str2)));
                LogUtil.log(this.TAG, "  deactive instance_id " + str2);
                arrayList.add(command);
            }
        }
        Object obj = null;
        Command command2;
        if (str.equals(SeConstants.MIFARE_VCM_INSTANCE_ID)) {
            command2 = new Command();
            command2.setCommand("80F00100" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS)));
            command2.setChecker(".*");
            arrayList.add(command2);
            command2 = new Command();
            command2.setCommand("80F00101" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.MIFARE_VCM_INSTANCE_ID)));
            arrayList.add(command2);
            command2 = new Command();
            command2.setCommand("80F00101" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.MIFARE_VSM_INSTANCE_ID)));
            arrayList.add(command2);
        } else {
            obj = 1;
            command2 = new Command();
            command2.setCommand("80F00101" + ValueUtil.toLV("4F" + ValueUtil.toLV(str)));
            arrayList.add(command2);
            command2 = new Command();
            command2.setCommand("80F00101" + ValueUtil.toLV("4F" + ValueUtil.toLV(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS)));
            command2.setChecker(".*");
            arrayList.add(command2);
        }
        Content content = new Content();
        content.setCommands(arrayList);
        content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID);
        TaskResult executeApdu2 = ConfigUtil.getInstance().instanceOma().executeApdu(context, content);
        if (obj != null) {
            LogUtil.log(this.TAG, "  need to active proxy app ");
            if (executeApdu2 == null || !executeApdu2.getResult_code().equals("0")) {
                LogUtil.log(this.TAG, "  don't active proxy app,because deactive failure ");
            } else {
                LogUtil.log(this.TAG, "  active proxy app ");
                content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID_BUS);
                arrayList.clear();
                Command command3 = new Command();
                command3.setCommand("80F00001" + ValueUtil.toLV("4F" + ValueUtil.toLV(str)));
                arrayList.add(command3);
                executeApdu = ConfigUtil.getInstance().instanceOma().executeApdu(context, content);
                return ValueUtil.parseInt(executeApdu.getResult_code());
            }
        }
        executeApdu = executeApdu2;
        return ValueUtil.parseInt(executeApdu.getResult_code());
    }

    private Map<String, List<String>> fetchHaveActivatedCards(Context context, String str) throws SnowballException {
        String[] retriveCardStatusForProxy = ApduUtil.getInstance().retriveCardStatusForProxy(context, getMediaType());
        LogUtil.log(this.TAG, " have actived  instance_id: " + retriveCardStatusForProxy[1] + ",activation_status:" + retriveCardStatusForProxy[0]);
        Map<String, List<String>> hashMap = new HashMap();
        List arrayList = new ArrayList();
        List<String> arrayList2 = new ArrayList();
        hashMap.put("bank", arrayList);
        hashMap.put("transit", arrayList2);
        Content content = new Content();
        content.setInstance_id(SeConstants.ALL_ACTIVE_CARD_INSTANCE_ID);
        List arrayList3 = new ArrayList();
        Command command = new Command();
        command.setCommand("80F24002024F00");
        command.setChecker(".*(9000|6310)$");
        arrayList3.add(command);
        content.setCommands(arrayList3);
        TaskResult executeApduKeep = ConfigUtil.getInstance().instanceOma().executeApduKeep(context, content);
        if (executeApduKeep != null && executeApduKeep.getResult_code().equals("0")) {
            String result = ((Command) ((Content) executeApduKeep.getData()).getCommands().get(0)).getResult();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(result.substring(0, result.length() - 4));
            while (result.substring(result.length() - 4).equals("6310")) {
                command.setCommand("80F24003024F00");
                command.setChecker(".*(9000|6310)$");
                TaskResult executeApduKeep2 = ConfigUtil.getInstance().instanceOma().executeApduKeep(context, content);
                if (executeApduKeep2 != null) {
                    result = ((Command) ((Content) executeApduKeep2.getData()).getCommands().get(0)).getResult();
                    if (executeApduKeep2.getResult_code().equals("0")) {
                        stringBuilder.append(result.substring(0, result.length() - 4));
                    }
                } else {
                    result = "0000";
                    LogUtil.log(this.TAG, " break, error happened when running 80F24003024F00 ");
                }
            }
            ConfigUtil.getInstance().instanceOma().closeChannlAll();
            List<Tlv> fetchTlvs = fetchTlvs("61", stringBuilder.toString());
            if (fetchTlvs != null && fetchTlvs.size() > 0) {
                Object obj;
                Tlv tlv = null;
                Tlv tlv2 = null;
                Object obj2 = null;
                for (Tlv value : fetchTlvs) {
                    Tlv tlv3;
                    List<Tlv> fetchTlvsExclude = fetchTlvsExclude(value.getValue(), "A4", "A6");
                    if (fetchTlvsExclude == null || fetchTlvsExclude.size() <= 0) {
                        obj = obj2;
                        tlv3 = tlv2;
                        tlv2 = tlv;
                    } else {
                        for (Tlv value2 : fetchTlvsExclude) {
                            if (value2.getTag().equals("4F")) {
                                tlv = value2;
                            } else if (value2.getTag().equals("9F70")) {
                                tlv2 = value2;
                            }
                            if (tlv != null && tlv2 != null) {
                                obj2 = 1;
                                LogUtil.log(this.TAG, " find instance_id " + tlv.getValue() + ",activation_status:" + tlv2.getValue());
                                break;
                            }
                        }
                        if (obj2 == null) {
                            LogUtil.log(this.TAG, " the tlv data exists problem or the data need to ignore  ");
                        } else if (tlv2.getValue().substring(2).equals("01")) {
                            if (CommonUtils.getInstance().isCardBank(tlv.getValue())) {
                                arrayList.add(tlv.getValue());
                                LogUtil.log(this.TAG, " add bank list instance_id " + tlv.getValue() + "," + tlv2.getValue());
                            } else if (CommonUtils.getInstance().isNoBank(tlv.getValue())) {
                                arrayList2.add(tlv.getValue());
                                LogUtil.log(this.TAG, " add transit list instance_id " + tlv.getValue() + "," + tlv2.getValue());
                            }
                        }
                        obj = null;
                        tlv3 = null;
                        tlv2 = null;
                    }
                    tlv = tlv2;
                    tlv2 = tlv3;
                    obj2 = obj;
                }
                if (retriveCardStatusForProxy != null && retriveCardStatusForProxy.length > 1 && !ValueUtil.isEmpty(retriveCardStatusForProxy[1]) && str.matches("8ED5|A998") && arrayList2 != null && arrayList2.size() > 0) {
                    for (String str2 : arrayList2) {
                        if (retriveCardStatusForProxy[0].equals("1") && retriveCardStatusForProxy[1].equals(str2)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        arrayList2.add(retriveCardStatusForProxy[1]);
                        LogUtil.log(this.TAG, " add transit list instance_id " + retriveCardStatusForProxy[1] + " from proxy ");
                    }
                }
            }
        }
        return hashMap;
    }
}
