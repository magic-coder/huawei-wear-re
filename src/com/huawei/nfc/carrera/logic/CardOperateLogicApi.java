package com.huawei.nfc.carrera.logic;

import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.ApplyPayOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryAndHandleUnfinishedOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryOfflineTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryRecordsListCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RefundCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.UninstallTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.response.ActiveCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener;
import com.huawei.nfc.carrera.logic.cardoperate.response.CardTypeIdentifyCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.CheckCUPCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.HandleCUPOperateResultCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.HandleCUPPersonalizedResultCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.InitCUPCardOperatorCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.InitEseResultCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.InstallCardResultCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.NullifyCardResultCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.RequestVerifyCodeCallback;
import java.util.ArrayList;

public interface CardOperateLogicApi {
    public static final int HANDLE_ALL_FAILED_ORDERS = 1;
    public static final int HANDLE_ISSUE_FAILED_ORDERS = 0;
    public static final int HANDLE_RECHARGE_FAILED_ORDERS = 1;
    public static final int ORDER_TYPE_ISSUECARD = 1;
    public static final int ORDER_TYPE_ISSUECARD_RECHARGE = 3;
    public static final int ORDER_TYPE_RECHARGE = 2;
    public static final int ORDER_TYPE_SHIFT_CARD_IN = 5;
    public static final int ORDER_TYPE_SHIFT_CARD_OUT = 4;
    public static final int PAY_TYPE_HW = 1;
    public static final int PAY_TYPE_WX = 2;
    public static final int PRIOR_QUERY_DONE_RECORDS = 0;
    public static final int PRIOR_QUERY_UNDONE_RECORDS = 1;
    public static final int PRIOR_QUERY_UNDONE_RECORDS_ONLY = 3;
    public static final int READ_CARDINFO_BALANCE_BIT = 2;
    public static final int READ_CARDINFO_NUM_BIT = 1;
    public static final int READ_CARDINFO_VALIDITY_DATE_BIT = 4;

    void activeCard(String str, int i, String str2, ActiveCardCallback activeCardCallback);

    void applyPayOrder(String str, double d, int i, int i2, String str2, ApplyPayOrderCallback applyPayOrderCallback);

    void applyPayOrder(String str, ApplyOrderInfo applyOrderInfo, ApplyPayOrderCallback applyPayOrderCallback);

    void checkCUPInterruptedCard(boolean z, CheckCUPCardCallback checkCUPCardCallback);

    void identifyCardType(String str, CardTypeIdentifyCallback cardTypeIdentifyCallback);

    void initCUPCardOperator(InitCUPCardOperatorCallback initCUPCardOperatorCallback);

    void initEseInfo();

    void initEseInfo(InitEseResultCallback initEseResultCallback);

    void issueTrafficCard(String str, TrafficOrder trafficOrder, IssueTrafficCardCallback issueTrafficCardCallback);

    void notifyCUPCardOperation(String str, String str2, String str3, ArrayList<String> arrayList, HandleCUPOperateResultCallback handleCUPOperateResultCallback);

    void notifyCUPCardPersonalized(String str, String str2, String str3, HandleCUPPersonalizedResultCallback handleCUPPersonalizedResultCallback);

    void nullifyCard(String str, int i, String str2, NullifyCardResultCallback nullifyCardResultCallback);

    void openCard(int i, OpenCardInfo openCardInfo, InstallCardResultCallback installCardResultCallback);

    void preIssueTrafficCard(String str);

    void queryAndHandleUnfinfishedOrders(String str, int i, QueryAndHandleUnfinishedOrderCallback queryAndHandleUnfinishedOrderCallback);

    void queryOfflineTrafficCardInfo(String str, int i, QueryOfflineTrafficCardInfoCallback queryOfflineTrafficCardInfoCallback);

    void queryRecords(String str, int i, QueryRecordsListCallback queryRecordsListCallback);

    void recharge(String str, TrafficOrder trafficOrder, RechargeCallback rechargeCallback);

    void refund(String str, TrafficOrder trafficOrder, RefundCallback refundCallback);

    void registerCUPOperationListener(String str, String str2, CUPOperationListener cUPOperationListener);

    void requestActiveSmsCode(String str, int i, RequestVerifyCodeCallback requestVerifyCodeCallback);

    void requestNullifySmsCode(String str, int i, RequestVerifyCodeCallback requestVerifyCodeCallback);

    void retryDownloadCard(String str, String str2, InstallCardResultCallback installCardResultCallback);

    void uninstallTrafficCard(String str, UninstallTrafficCardCallback uninstallTrafficCardCallback);

    void unregisterCUPOperationListener(String str, String str2, CUPOperationListener cUPOperationListener);
}
