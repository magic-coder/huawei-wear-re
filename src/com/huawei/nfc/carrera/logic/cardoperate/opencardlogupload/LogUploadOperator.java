package com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.login.ui.login.a;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.server.card.request.ReportEventBaseRequest;
import com.huawei.wallet.utils.TimeUtil;

public final class LogUploadOperator {
    public static final String OPEN_CARD_CHANNEL_BANK_APP_JUMP = "1";
    public static final String OPEN_CARD_CHANNEL_BANK_APP_VERIFY = "2";
    public static final String OPEN_CARD_CHANNEL_WALLET = "3";
    public static final String RESULT_CODE_ACTIVE_CARD_FAILED = "3109";
    public static final String RESULT_CODE_ACTIVE_CARD_FAILED_DES = "active card failed";
    public static final String RESULT_CODE_APPLY_CARD_FAILED = "3105";
    public static final String RESULT_CODE_APPLY_CARD_FAILED_DES = "apply_card";
    public static final String RESULT_CODE_APPLY_ISSUE_ORDER_FAIL = "1300";
    public static final String RESULT_CODE_APPLY_RECHARGE_ORDER = "1501";
    public static final String RESULT_CODE_APPLY_RECHARGE_ORDER_DES = "apply_recharge_order";
    public static final String RESULT_CODE_CREATE_AMSD_FAIL = "3102";
    public static final String RESULT_CODE_CREATE_AMSD_FAIL_DES = "create_amsd_fail";
    public static final String RESULT_CODE_CREATE_SSD_FAIL = "1101";
    public static final String RESULT_CODE_DELETE_BANK_CARD_FAILED = "3201";
    public static final String RESULT_CODE_DELETE_BANK_CARD_FAILED_DES = "delete_bank_card_failed";
    public static final String RESULT_CODE_IDENTIFY_CARD_NUM_FAILED = "3104";
    public static final String RESULT_CODE_IDENTIFY_CARD_NUM_FAILED_DES = "identify_card_num";
    public static final String RESULT_CODE_INIT_UNIONPAY_ADDON_FAILED = "3103";
    public static final String RESULT_CODE_INIT_UNIONPAY_ADDON_FAILED_DES = "init_unionpay_addon";
    public static final String RESULT_CODE_ISSUE_CARD_FAIL = "1102";
    public static final String RESULT_CODE_LOAD_CAP_FAILED = "3107";
    public static final String RESULT_CODE_LOAD_CAP_FAILED_DES = "load_cap_failed";
    public static final String RESULT_CODE_OPEN_CARD_SUCCESS = "1000";
    public static final String RESULT_CODE_PAY_FAIL = "1400";
    public static final String RESULT_CODE_QUERY_ISSUE_MONEY_FAIL = "1200";
    public static final String RESULT_CODE_QUERY_ISSUE_ORDER_FAIL = "1103";
    public static final String RESULT_CODE_QUERY_RECHARGE_MONEY_FAIL = "1503";
    public static final String RESULT_CODE_RECHARGE = "1502";
    public static final String RESULT_CODE_RECHARGE_DES = "recharge";
    public static final String RESULT_CODE_SET_FINGER_PRINT_PWD_FAILED = "3110";
    public static final String RESULT_CODE_SET_FINGER_PRINT_PWD_FAILED_DES = "set_finger_print_pwd_failed";
    public static final String RESULT_CODE_TRANSFER_IN_APPLY_ORDER_DES = "apply_transfer_in_order";
    public static final String RESULT_CODE_TRANSFER_IN_APPLY_ORDER_FAIL = "2202";
    public static final String RESULT_CODE_TRANSFER_IN_CREATE_DMSD_DES = "transfer_in_create_dmsd";
    public static final String RESULT_CODE_TRANSFER_IN_CREATE_DMSD_FAIL = "2201";
    public static final String RESULT_CODE_TRANSFER_IN_DES = "do_transfer_in";
    public static final String RESULT_CODE_TRANSFER_IN_FAIL = "2203";
    public static final String RESULT_CODE_TRANSFER_IN_QUERY_MOVE_CODE_DES = "transfer_in_query_move_code";
    public static final String RESULT_CODE_TRANSFER_IN_QUERY_MOVE_CODE_FAIL = "2207";
    public static final String RESULT_CODE_TRANSFER_IN_RECHARGE_APPLY_ORDER_DES = "transfer_in_recharge_apply_order";
    public static final String RESULT_CODE_TRANSFER_IN_RECHARGE_APPLY_ORDER_FAIL = "2205";
    public static final String RESULT_CODE_TRANSFER_IN_RECHARGE_DES = "transfer_in_recharge";
    public static final String RESULT_CODE_TRANSFER_IN_RECHARGE_FAIL = "2206";
    public static final String RESULT_CODE_TRANSFER_IN_REPORT_STATUS_DES = "report_transfer_in_status";
    public static final String RESULT_CODE_TRANSFER_IN_REPORT_STATUS_FAIL = "2204";
    public static final String RESULT_CODE_TRANSFER_IN_SUCCESS = "2200";
    public static final String RESULT_CODE_TRANSFER_IN_SUCCESS_DES = "transfer_in_success";
    public static final String RESULT_CODE_TRANSFER_OUT_APPLY_ORDER_DES = "transfer_out_apply_order";
    public static final String RESULT_CODE_TRANSFER_OUT_APPLY_ORDER_FAIL = "2101";
    public static final String RESULT_CODE_TRANSFER_OUT_DELETE_SSD_DES = "transfer_out_delete_ssd";
    public static final String RESULT_CODE_TRANSFER_OUT_DELETE_SSD_FAIL = "2105";
    public static final String RESULT_CODE_TRANSFER_OUT_DES = "do_transfer_out";
    public static final String RESULT_CODE_TRANSFER_OUT_FAIL = "2102";
    public static final String RESULT_CODE_TRANSFER_OUT_GET_BALANCE_STATUS_DES = "transfer_out_get_balance";
    public static final String RESULT_CODE_TRANSFER_OUT_GET_BALANCE_STATUS_FAIL = "2106";
    public static final String RESULT_CODE_TRANSFER_OUT_REPORT_STATUS_DES = "report_transfer_out_status";
    public static final String RESULT_CODE_TRANSFER_OUT_REPORT_STATUS_FAIL = "2103";
    public static final String RESULT_CODE_TRANSFER_OUT_SUCCESS = "2100";
    public static final String RESULT_CODE_TRANSFER_OUT_SUCCESS_DES = "transfer_out_success";
    public static final String RESULT_CODE_TRANSFER_OUT_SYNC_ESE_INFO_DES = "transfer_out_sync_ese_info";
    public static final String RESULT_CODE_TRANSFER_OUT_SYNC_ESE_INFO_FAIL = "2104";
    public static final String RESULT_CODE_UNIONPAY_ADDON_DOWNLOAD_DES = "unionpay_addon_download";
    public static final String RESULT_CODE_UNIONPAY_ADDON_DOWNLOAD_FAIL = "3101";
    public static final String RESULT_CODE_UPDATE_APPLET_FAIL = "1104";
    public static final String RESULT_CODE_UPDATE_PERSONALIZED_INFO_INTO_TA_FAILED = "3108";
    public static final String RESULT_CODE_UPDATE_PERSONALIZED_INFO_INTO_TA_FAILED_DES = "update_personalized_info_into_ta_failed";
    public static final String RESULT_CODE_WAITING_LOAD_CAP_STARTTIMEOUT_DES = "waiting_load_cap_start_timeout";
    public static final String RESULT_CODE_WAITING_LOAD_CAP_START_TIMEOUT = "3106";
    public static final String RESULT_DESC_APPLY_ISSUE_ORDER = "apply issue order";
    public static final String RESULT_DESC_CREATE_SSD = "create ssd";
    public static final String RESULT_DESC_ISSUE_CARD = "issue card";
    public static final String RESULT_DESC_OPEN_CARD = "open card success";
    public static final String RESULT_DESC_PAY = "pay issue card money";
    public static final String RESULT_DESC_QUERY_ISSUE_MONEY = "query issue money";
    public static final String RESULT_DESC_QUERY_ISSUE_ORDER = "query issue order";
    public static final String RESULT_DESC_QUERY_RECHARGE_MONEY_FAIL = "query recharge money failed";
    public static final String RESULT_DESC_UPDATE_APPLET = "update applet";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "LogUploadOperator";
    private static volatile LogUploadOperator instance;
    private final Context context;
    private final Handler taskHandler;

    public static LogUploadOperator getInstance(Context context) {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new LogUploadOperator(context);
                }
            }
        }
        return instance;
    }

    private LogUploadOperator(Context context) {
        if (context instanceof Activity) {
            this.context = context.getApplicationContext();
        } else {
            this.context = context;
        }
        HandlerThread handlerThread = new HandlerThread(TAG, 10);
        handlerThread.start();
        this.taskHandler = new Handler(handlerThread.getLooper());
    }

    public void init(String str, String str2, String str3, int i) {
        ReportEventBaseRequest reportEventBaseRequest = new ReportEventBaseRequest();
        reportEventBaseRequest.setUid(a.a(this.context).c());
        reportEventBaseRequest.setCardIssuerid(str);
        reportEventBaseRequest.setTime(TimeUtil.m28480a("yyyy-MM-dd HH:mm:ss"));
        reportEventBaseRequest.setCardType(i);
        reportEventBaseRequest.setTerminal(ESEApiFactory.createESEInfoManagerApi(this.context).getDeviceModel());
        reportEventBaseRequest.setResult(str2);
        reportEventBaseRequest.setErrorDesc(str3);
        reportEventBaseRequest.setRequestNum(String.valueOf(System.currentTimeMillis()));
        this.taskHandler.post(new LogUploadTask(this.context, reportEventBaseRequest));
    }
}
