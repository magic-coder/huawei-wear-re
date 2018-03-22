package com.snowballtech.business.constant;

import java.util.HashMap;
import java.util.Map;

public class RequestKey {
    public static final String KEY_APPLETMANNAGE = "appletManage";
    public static final String KEY_CARDCOUPON = "cardCoupon";
    public static final String KEY_CARDDEACTIVATE = "cardDeactivate";
    public static final String KEY_CARDDELETE = "cardDelete";
    public static final String KEY_CARDLISTQUERY = "cardListQuery";
    public static final String KEY_CARDQUERY = "cardQuery";
    public static final String KEY_CARDSSTATUS = "cardsStatus";
    public static final String KEY_CARDSWITCH = "cardSwitch";
    public static final String KEY_CARDTOPUP = "cardTopup";
    public static final String KEY_CONSUMEPARSE = "consumeParse";
    public static final String KEY_GETPAYORDER = "getPayOrder";
    public static final String KEY_GET_CPLC = "getCplc";
    public static final String KEY_INIT = "init";
    public static final String KEY_INITSE = "initSe";
    public static final String KEY_ISINSTANCEEXISTED = "isInstanceExisted";
    public static final String KEY_ISSUECARD = "issueCard";
    public static final String KEY_ORDERQUERY = "orderQuery";
    public static final String KEY_QUERYORDERSTATUS = "queryOrderStatus";
    public static final String KEY_RECHARGECOUPON = "rechargeCoupon";
    public static final String KEY_RECORDSONLINEQUERY = "recordsOnlineQuery";
    public static final String KEY_REFUND = "refund";
    public static final String KEY_SETUID = "setUid";
    public static final String KEY_SWITCH_LOG = "switchLog";
    public static final String KEY_TRANSFERREFUND = "transferRefund";
    public static final String KEY_TRANSQUERYSE = "transQuerySe";
    public static Map<String, String> NONSYNCTASKMAP = new C62312();
    public static Map<String, String> TASKMAP = new C62301();
    private static final String taskClassPath = "com.snowballtech.business.user.task.";

    final class C62301 extends HashMap<String, String> {
        C62301() {
            put(RequestKey.KEY_APPLETMANNAGE, "com.snowballtech.business.user.task.WTaskAppletManage");
            put(RequestKey.KEY_ISSUECARD, "com.snowballtech.business.user.task.WTaskIssueCard");
            put(RequestKey.KEY_CARDTOPUP, "com.snowballtech.business.user.task.WTaskCardTopup");
            put(RequestKey.KEY_CARDLISTQUERY, "com.snowballtech.business.user.task.WTaskCardListQuery");
            put(RequestKey.KEY_GET_CPLC, "com.snowballtech.business.user.task.WTaskGetCplc");
            put(RequestKey.KEY_CARDDELETE, "com.snowballtech.business.user.task.WTaskCardDelete");
            put(RequestKey.KEY_INITSE, "com.snowballtech.business.user.task.WTaskInitSe");
            put(RequestKey.KEY_ISINSTANCEEXISTED, "com.snowballtech.business.user.task.WTaskIsInstanceExisted");
            put(RequestKey.KEY_CARDQUERY, "com.snowballtech.business.user.task.WTaskCardQuery");
            put(RequestKey.KEY_CARDSWITCH, "com.snowballtech.business.user.task.WTaskCardSwitch");
            put(RequestKey.KEY_CARDDEACTIVATE, "com.snowballtech.business.user.task.WTaskCardDeactivate");
            put(RequestKey.KEY_TRANSQUERYSE, "com.snowballtech.business.user.task.WTaskTransQuerySe");
            put(RequestKey.KEY_SETUID, "com.snowballtech.business.user.task.WTaskSetUid");
            put("init", "com.snowballtech.business.user.task.WTaskInit");
            put(RequestKey.KEY_TRANSFERREFUND, "com.snowballtech.business.user.task.WTaskTansferRefund");
        }
    }

    final class C62312 extends HashMap<String, String> {
        C62312() {
            put(RequestKey.KEY_CONSUMEPARSE, "com.snowballtech.business.user.task.WTaskConsumeParse");
            put(RequestKey.KEY_SWITCH_LOG, "com.snowballtech.business.user.task.WTaskSwitchLog");
        }
    }
}
