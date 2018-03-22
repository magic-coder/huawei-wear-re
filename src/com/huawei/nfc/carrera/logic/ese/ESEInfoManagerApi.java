package com.huawei.nfc.carrera.logic.ese;

import com.huawei.nfc.carrera.logic.cardinfo.model.WalletSupportInfo;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.ese.response.QueryTradeRecordsResponse;
import java.util.ArrayList;

public interface ESEInfoManagerApi {
    public static final int OPERATION_QUERY_BALANCE = 101;
    public static final int OPERATION_QUERY_CARD_NUM = 100;
    public static final int OPERATION_QUERY_TRADE_RECORDS = 102;
    public static final int READ_CARD_BALANCE = 2;
    public static final int READ_CARD_NUM = 1;
    public static final int READ_CARD_VALIDITY_DATE = 4;
    public static final int RESULT_FAILED_CARD_BALANCE_ERROR = -4;
    public static final int RESULT_FAILED_CARD_STATUS_AFTER_EXPIRE_DATE_ERROR = -7;
    public static final int RESULT_FAILED_CARD_STATUS_BEFORE_ENABLE_DATE_ERROR = -6;
    public static final int RESULT_FAILED_CARD_STATUS_DATE_ERROR = -5;
    public static final int RESULT_FAILED_CARD_STATUS_DISABLED = -2;
    public static final int RESULT_FAILED_CARD_STATUS_IN_BLACKLIST = -3;
    public static final int RESULT_FAILED_CARD_STATUS_OVERDRAFT_ERROR = -8;
    public static final int RESULT_FAILED_COMMAND_EXCUTE_FAILED = -1;
    public static final int RESULT_FAILED_OTHER = -99;
    public static final int RESULT_SUCCESS = 0;

    boolean addBusCard(String str, String str2, String str3);

    boolean esePowerOff();

    boolean esePowerOn();

    String getBusChipManu();

    String getDeviceBTVersion();

    String getDeviceModel();

    String getDeviceSN();

    String getDeviceSoftVersion();

    ArrayList<String> getSupportList();

    WalletSupportInfo getWalletAbility();

    String queryCardNum(String str);

    String queryCplc();

    int queryOpenMobileChannel();

    byte[] querySeid();

    QueryCardInfoResponse queryTrafficCardInfo(String str, int i);

    QueryTradeRecordsResponse queryTrafficCardTradeRecord(String str);

    void setSupportList(ArrayList<String> arrayList);
}
