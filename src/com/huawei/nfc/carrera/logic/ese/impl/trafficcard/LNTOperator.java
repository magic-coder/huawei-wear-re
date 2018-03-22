package com.huawei.nfc.carrera.logic.ese.impl.trafficcard;

import com.huawei.nfc.carrera.logic.ese.impl.BaseOperator;
import com.huawei.nfc.carrera.logic.ese.impl.Command;
import com.huawei.nfc.carrera.logic.ese.model.TradeRecord;
import com.huawei.nfc.carrera.logic.ese.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryTradeRecordsResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.snowballtech.common.util.DateTimeUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.simalliance.openmobileapi.C6649a;

public class LNTOperator extends BaseOperator {
    private static final int QUERY_RECORDS_CNT = 10;
    private static final String READ_CARD_BALANCE = "805C000204";
    private static final String READ_CARD_NUM = "00B0950058";
    private static final String READ_CARD_RECORDS = "00B2%02XC400";
    private static final String SELECT_ADF3 = ("00A40000" + ValueUtil.toLV("ADF3"));
    private static final String SELECT_DDF1 = ("00A40000" + ValueUtil.toLV("DDF1"));
    private static List<Command> sLNTQueryCardInfoCommands = new ArrayList();
    private static List<Command> sLNTQueryRecordsCommands = new ArrayList();

    static {
        sLNTQueryCardInfoCommands.add(new Command(SELECT_DDF1, BaseOperator.COMMON_CHECKER));
        sLNTQueryCardInfoCommands.add(new Command(READ_CARD_NUM, BaseOperator.COMMON_CHECKER));
        sLNTQueryCardInfoCommands.add(new Command(SELECT_ADF3, BaseOperator.COMMON_CHECKER));
        sLNTQueryCardInfoCommands.add(new Command(READ_CARD_BALANCE, BaseOperator.COMMON_CHECKER));
        sLNTQueryRecordsCommands.add(new Command(SELECT_DDF1, BaseOperator.COMMON_CHECKER));
        sLNTQueryRecordsCommands.add(new Command(SELECT_ADF3, BaseOperator.COMMON_CHECKER));
    }

    protected int getCardStatus(C6649a c6649a) {
        return 0;
    }

    protected QueryCardInfoResponse queryTrafficCardInfo(C6649a c6649a, int i) {
        QueryCardInfoResponse queryCardInfoResponse = new QueryCardInfoResponse();
        TrafficCardInfo trafficCardInfo = new TrafficCardInfo();
        queryCardInfoResponse.cardInfo = trafficCardInfo;
        queryCardInfoResponse.resultCode = 0;
        for (Command command : sLNTQueryCardInfoCommands) {
            if (command.excuteCommand(c6649a)) {
                String commandResult = command.getCommandResult();
                if (READ_CARD_NUM.equals(command.getCommand())) {
                    parseCardNumForLNT(commandResult, trafficCardInfo);
                    parseCardValidityForLNT(commandResult, trafficCardInfo);
                }
                if (READ_CARD_BALANCE.equals(command.getCommand())) {
                    parseCardBalanceForLNT(commandResult, trafficCardInfo);
                }
            } else {
                LogX.w("excuteQueryCardNumApdu failed. response apdu : " + command.getCommand() + " rpdu : " + command.getCommandResult(), true);
                queryCardInfoResponse.resultCode = -1;
                return queryCardInfoResponse;
            }
        }
        return queryCardInfoResponse;
    }

    protected QueryTradeRecordsResponse queryTradeRecordsApdu(C6649a c6649a) {
        for (Command command : sLNTQueryRecordsCommands) {
            Command command2;
            if (!command2.excuteCommand(c6649a)) {
                LogX.w("excuteQueryTradeRecordsApdu failed. response apdu : " + command2.getCommand() + " rpdu : " + command2.getCommandResult(), true);
                return new QueryTradeRecordsResponse(-1, null);
            }
        }
        List arrayList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            command2 = new Command(String.format(READ_CARD_RECORDS, new Object[]{Integer.valueOf(i)}), BaseOperator.COMMON_CHECKER);
            command2.excuteCommand(c6649a);
            String commandResult = command2.getCommandResult();
            boolean matches = commandResult.matches("^0+9000$");
            if (commandResult.matches(".*(9000|6A83)$") && commandResult.length() >= 48 && !matches) {
                String formatDatetimeForTransaction = formatDatetimeForTransaction(commandResult.substring(36, 46));
                String substring = commandResult.substring(10, 18);
                substring = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(Integer.parseInt(substring, 16))});
                commandResult = commandResult.substring(18, 20);
                if (commandResult.matches("01|02")) {
                    commandResult = "1";
                } else if (commandResult.matches("06|09")) {
                    commandResult = "2";
                }
                arrayList.add(new TradeRecord(substring, commandResult, formatDatetimeForTransaction));
            } else if (!matches) {
                LogX.w("excuteQueryTradeRecordsApdu failed. query record[" + i + "] apdu : " + commandResult, true);
            }
        }
        return new QueryTradeRecordsResponse(0, arrayList);
    }

    public String formatDatetimeForTransaction(String str) {
        if (ValueUtil.isEmpty(str)) {
            return null;
        }
        String currentDateString = DateTimeUtil.currentDateString("yyyy");
        if (str.length() == 10) {
            str = currentDateString + str;
        } else if (str.length() <= 12) {
            str = currentDateString.substring(0, 2) + str;
        }
        return DateTimeUtil.format(DateTimeUtil.parseDateString(str, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss");
    }

    private void parseCardBalanceForLNT(String str, TrafficCardInfo trafficCardInfo) {
        if (!StringUtil.isEmpty(str, true) && str.length() >= 12 && trafficCardInfo != null) {
            trafficCardInfo.setBalance(String.valueOf(Integer.parseInt(str.substring(0, 8), 16)));
        }
    }

    private void parseCardValidityForLNT(String str, TrafficCardInfo trafficCardInfo) {
        if (!StringUtil.isEmpty(str, true) && str.length() >= 66 && trafficCardInfo != null) {
            trafficCardInfo.setExpireDate(str.substring(54, 62));
        }
    }

    private void parseCardNumForLNT(String str, TrafficCardInfo trafficCardInfo) {
        if (!StringUtil.isEmpty(str, true) && str.length() >= 36 && trafficCardInfo != null) {
            trafficCardInfo.setCardNo(str.substring(16, 32));
        }
    }
}
