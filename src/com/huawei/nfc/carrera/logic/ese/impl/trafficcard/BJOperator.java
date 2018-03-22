package com.huawei.nfc.carrera.logic.ese.impl.trafficcard;

import com.huawei.nfc.carrera.logic.ese.impl.BaseOperator;
import com.huawei.nfc.carrera.logic.ese.impl.Command;
import com.huawei.nfc.carrera.logic.ese.model.TradeRecord;
import com.huawei.nfc.carrera.logic.ese.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardBalanceResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardBaseResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardNumResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardValidityDateResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryTradeRecordsResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.snowballtech.common.util.DateTimeUtil;
import com.snowballtech.common.util.ValueUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.simalliance.openmobileapi.C6649a;

public class BJOperator extends BaseOperator {
    private static final String INVALID_TIME = String.format(Locale.getDefault(), "%06d", new Object[]{Integer.valueOf(0)});
    private static final int QUERY_RECORDS_CNT = 10;
    private static final String READ_BLACKLIST_LABEL = "00B0850001";
    private static final String READ_CARD_BALANCE = "805C000204";
    private static final String READ_CARD_ENABLE_LABEL = "00B0840901";
    private static final String READ_CARD_NUM = "00B0840000";
    private static final String READ_CARD_OVERDRAFT_BALANCE = "00B0850504";
    private static final String READ_CARD_RECORDS = "00B2%02XC400";
    private static final String READ_EXPIRE_DATE = "00B0841808";
    private static final String SELECT_1001 = ("00A40000" + ValueUtil.toLV("1001"));
    private static List<Command> sBJCardCheckCommands = new ArrayList();
    private static List<Command> sBJQueryCardBalanceCommands = new ArrayList();
    private static List<Command> sBJQueryCardDateCommands = new ArrayList();
    private static List<Command> sBJQueryCardNumCommands = new ArrayList();
    private static List<Command> sBJQueryRecordsCommands = new ArrayList();

    static {
        sBJCardCheckCommands.add(new Command(READ_CARD_ENABLE_LABEL, BaseOperator.COMMON_CHECKER));
        sBJCardCheckCommands.add(new Command(READ_BLACKLIST_LABEL, BaseOperator.COMMON_CHECKER));
        sBJQueryCardNumCommands.add(new Command(READ_CARD_NUM, BaseOperator.COMMON_CHECKER));
        sBJQueryCardBalanceCommands.add(new Command(READ_CARD_OVERDRAFT_BALANCE, BaseOperator.COMMON_CHECKER1));
        sBJQueryCardBalanceCommands.add(new Command(SELECT_1001, BaseOperator.COMMON_CHECKER1));
        sBJQueryCardBalanceCommands.add(new Command(READ_CARD_BALANCE, BaseOperator.COMMON_CHECKER));
        sBJQueryRecordsCommands.add(new Command(SELECT_1001, BaseOperator.COMMON_CHECKER));
        sBJQueryCardDateCommands.add(new Command(READ_EXPIRE_DATE, BaseOperator.COMMON_CHECKER));
    }

    private QueryCardBalanceResponse readCardBalance(C6649a c6649a) {
        int i = 0;
        int i2 = 0;
        for (Command command : sBJQueryCardBalanceCommands) {
            if (command.excuteCommand(c6649a)) {
                int i3;
                String commandResult = command.getCommandResult();
                LogX.d("excuteQueryBalanceApdu. response apdu : " + command.getCommand() + " rpdu : " + command.getCommandResult(), false);
                commandResult = commandResult.substring(0, commandResult.length() - 4);
                if (READ_CARD_OVERDRAFT_BALANCE.equals(command.getCommand())) {
                    String substring = commandResult.substring(0, 8);
                    if ("ffffffff".equalsIgnoreCase(substring)) {
                        i3 = 0;
                    } else {
                        i3 = new BigInteger(substring, 16).intValue();
                    }
                    int i4 = i;
                    i = i3;
                    i3 = i4;
                } else if (READ_CARD_BALANCE.equals(command.getCommand())) {
                    i3 = Integer.parseInt(commandResult.substring(0, 8), 16);
                    i = i2;
                } else {
                    i3 = i;
                    i = i2;
                }
                i2 = i;
                i = i3;
            } else {
                LogX.w("excuteQueryBalanceApdu failed. response apdu : " + command.getCommand() + " rpdu : " + command.getCommandResult(), false);
                return new QueryCardBalanceResponse(-1, null);
            }
        }
        if (i2 < 0) {
            return new QueryCardBalanceResponse(-8, null);
        }
        if (i2 <= 0 || i <= 0) {
            return new QueryCardBalanceResponse(0, String.valueOf(i - i2));
        }
        return new QueryCardBalanceResponse(-4, null);
    }

    private QueryCardNumResponse readCardNum(C6649a c6649a) {
        String str = null;
        for (Command command : sBJQueryCardNumCommands) {
            if (command.excuteCommand(c6649a)) {
                str = command.getCommandResult();
            } else {
                LogX.w("excuteQueryCardNumApdu failed. response apdu : " + command.getCommand() + " rpdu : " + command.getCommandResult(), true);
                return new QueryCardNumResponse(-1, null);
            }
        }
        if (StringUtil.isEmpty(str, true)) {
            return new QueryCardNumResponse(-1, null);
        }
        return new QueryCardNumResponse(0, str.substring(0, 16));
    }

    private QueryCardValidityDateResponse readCardValidityDate(C6649a c6649a) {
        QueryCardValidityDateResponse queryCardValidityDateResponse = null;
        for (Command command : sBJQueryCardDateCommands) {
            if (!command.excuteCommand(c6649a)) {
                return new QueryCardValidityDateResponse(-1);
            }
            QueryCardValidityDateResponse queryCardValidityDateResponse2;
            String commandResult = command.getCommandResult();
            if (READ_EXPIRE_DATE.equals(command.getCommand())) {
                queryCardValidityDateResponse2 = new QueryCardValidityDateResponse(0, commandResult);
            } else {
                queryCardValidityDateResponse2 = queryCardValidityDateResponse;
            }
            queryCardValidityDateResponse = queryCardValidityDateResponse2;
        }
        return queryCardValidityDateResponse;
    }

    protected QueryTradeRecordsResponse queryTradeRecordsApdu(C6649a c6649a) {
        for (Command command : sBJQueryRecordsCommands) {
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
            LogX.d("excuteQueryTradeRecordsApdu. query record[" + i + "] rpdu : " + commandResult);
            boolean matches = commandResult.matches("^0+9000$");
            if (commandResult.matches(".*(9000|6A83)$") && commandResult.length() >= 46 && !matches) {
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
            } else if (!matches) {
                LogX.w("excuteQueryTradeRecordsApdu failed. query record[" + i + "] apdu : " + commandResult);
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

    protected int getCardStatus(C6649a c6649a) {
        for (Command command : sBJCardCheckCommands) {
            if (!command.excuteCommand(c6649a)) {
                return -1;
            }
            String commandResult = command.getCommandResult();
            if (READ_CARD_ENABLE_LABEL.equals(command.getCommand()) && !"02".equals(commandResult.substring(0, 2))) {
                return -2;
            }
            if (READ_BLACKLIST_LABEL.equals(command.getCommand()) && "A5".equals(commandResult.substring(0, 2))) {
                return -3;
            }
        }
        return 0;
    }

    protected QueryCardInfoResponse queryTrafficCardInfo(C6649a c6649a, int i) {
        QueryCardBaseResponse readCardValidityDate;
        QueryCardInfoResponse queryCardInfoResponse = new QueryCardInfoResponse(0, new TrafficCardInfo());
        if ((i & 4) != 0) {
            readCardValidityDate = readCardValidityDate(c6649a);
            if (!(readCardValidityDate == null || queryCardInfoResponse.setResultCdforFailed(readCardValidityDate))) {
                queryCardInfoResponse.setCardValidity(readCardValidityDate);
            }
            return queryCardInfoResponse;
        }
        if ((i & 1) != 0) {
            readCardValidityDate = readCardNum(c6649a);
            if (!queryCardInfoResponse.setResultCdforFailed(readCardValidityDate)) {
                queryCardInfoResponse.setCardNo(readCardValidityDate);
            }
            return queryCardInfoResponse;
        }
        if ((i & 2) != 0) {
            readCardValidityDate = readCardBalance(c6649a);
            if (!queryCardInfoResponse.setResultCdforFailed(readCardValidityDate)) {
                queryCardInfoResponse.setBalance(readCardValidityDate);
            }
        }
        return queryCardInfoResponse;
    }
}
