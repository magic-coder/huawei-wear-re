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

public class SZTOperator extends BaseOperator {
    private static final String INVALID_TIME = String.format(Locale.getDefault(), "%014d", new Object[]{Integer.valueOf(0)});
    private static final int QUERY_RECORDS_CNT = 10;
    private static final String READ_CARD_BALANCE = "805C000204";
    private static final String READ_CARD_NUM = "00B0950000";
    private static final String READ_CARD_RECORDS = "00B2%02XC400";
    private static final String SELECT_1001 = ("00A40000" + ValueUtil.toLV("1001"));
    private static List<Command> sSZTQueryCardInfoCommands = new ArrayList();
    private static List<Command> sSZTQueryRecordsCommands = new ArrayList();

    static {
        sSZTQueryCardInfoCommands.add(new Command(SELECT_1001, BaseOperator.COMMON_CHECKER));
        sSZTQueryCardInfoCommands.add(new Command(READ_CARD_NUM, BaseOperator.COMMON_CHECKER));
        sSZTQueryCardInfoCommands.add(new Command(READ_CARD_BALANCE, BaseOperator.COMMON_CHECKER));
        sSZTQueryRecordsCommands.add(new Command(SELECT_1001, BaseOperator.COMMON_CHECKER));
    }

    protected int getCardStatus(C6649a c6649a) {
        return 0;
    }

    protected QueryCardInfoResponse queryTrafficCardInfo(C6649a c6649a, int i) {
        QueryCardInfoResponse queryCardInfoResponse = new QueryCardInfoResponse();
        TrafficCardInfo trafficCardInfo = new TrafficCardInfo();
        queryCardInfoResponse.cardInfo = trafficCardInfo;
        queryCardInfoResponse.resultCode = 0;
        for (Command command : sSZTQueryCardInfoCommands) {
            if (command.excuteCommand(c6649a)) {
                String commandResult = command.getCommandResult();
                if (READ_CARD_NUM.equals(command.getCommand())) {
                    parseCardNumForSZT(commandResult, trafficCardInfo);
                    parseCardValidityForSZT(commandResult, trafficCardInfo);
                }
                if (READ_CARD_BALANCE.equals(command.getCommand())) {
                    parseCardBalanceForSZT(commandResult, trafficCardInfo);
                }
            } else {
                LogX.w("queryTrafficCardInfo failed. response apdu : " + command.getCommand() + " rpdu : " + command.getCommandResult(), true);
                queryCardInfoResponse.resultCode = -1;
                return queryCardInfoResponse;
            }
        }
        return queryCardInfoResponse;
    }

    protected QueryTradeRecordsResponse queryTradeRecordsApdu(C6649a c6649a) {
        Command command;
        for (Command command2 : sSZTQueryRecordsCommands) {
            if (!command2.excuteCommand(c6649a)) {
                LogX.w("queryTradeRecordsApdu failed. response apdu : " + command2.getCommand() + " rpdu : " + command2.getCommandResult(), true);
                return new QueryTradeRecordsResponse(-1, null);
            }
        }
        List arrayList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            command2 = new Command(String.format(READ_CARD_RECORDS, new Object[]{Integer.valueOf(i)}), BaseOperator.COMMON_CHECKER);
            command2.excuteCommand(c6649a);
            String commandResult = command2.getCommandResult();
            if (!commandResult.endsWith("9000") || commandResult.length() < 46) {
                LogX.w("queryTradeRecordsApdu failed. query record[" + i + "] apdu : " + commandResult, true);
            } else {
                String substring = commandResult.substring(32, 46);
                if (!INVALID_TIME.equals(substring)) {
                    substring = formatDatetimeForTransaction(substring);
                    String substring2 = commandResult.substring(10, 18);
                    substring2 = String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(Integer.parseInt(substring2, 16))});
                    commandResult = commandResult.substring(18, 20);
                    if (commandResult.matches("10|02|01")) {
                        commandResult = "1";
                    } else if (commandResult.matches("11|09|06|05")) {
                        commandResult = "2";
                    }
                    arrayList.add(new TradeRecord(substring2, commandResult, substring));
                }
            }
        }
        return new QueryTradeRecordsResponse(0, arrayList);
    }

    private String formatDatetimeForTransaction(String str) {
        if (ValueUtil.isEmpty(str)) {
            return null;
        }
        String currentDateString = DateTimeUtil.currentDateString("yyyy");
        if (str.length() <= 12) {
            str = currentDateString.substring(0, 2) + str;
        }
        return DateTimeUtil.format(DateTimeUtil.parseDateString(str, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss");
    }

    private void parseCardBalanceForSZT(String str, TrafficCardInfo trafficCardInfo) {
        if (!StringUtil.isEmpty(str, true) && str.length() >= 12 && trafficCardInfo != null) {
            String substring = str.substring(0, 8);
            String str2 = "";
            int parseInt = Integer.parseInt(substring.substring(0, 2), 16);
            if ((parseInt & 128) != 128) {
                str2 = "-";
            }
            parseInt &= 127;
            substring = String.format("%02X", new Object[]{Integer.valueOf(parseInt)}) + substring.substring(2);
            trafficCardInfo.setBalance(str2 + String.format("%d", new Object[]{Integer.valueOf(Integer.parseInt(substring, 16))}));
        }
    }

    private void parseCardNumForSZT(String str, TrafficCardInfo trafficCardInfo) {
        if (!StringUtil.isEmpty(str, true) && trafficCardInfo != null) {
            String substring = str.substring(0, str.length() - 4);
            if (substring.length() >= 40) {
                substring = substring.substring(20, 40);
                if (substring.length() >= 8) {
                    substring = substring.substring(substring.length() - 8);
                    substring = String.valueOf(Integer.parseInt(substring.substring(6, 8) + substring.substring(4, 6) + substring.substring(2, 4) + substring.substring(0, 2), 16));
                }
                trafficCardInfo.setCardNo(substring);
            }
        }
    }

    private void parseCardValidityForSZT(String str, TrafficCardInfo trafficCardInfo) {
        if (!StringUtil.isEmpty(str, true) && str.length() >= 60 && trafficCardInfo != null) {
            trafficCardInfo.setExpireDate(str.substring(48, 56));
        }
    }
}
