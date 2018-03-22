package com.huawei.nfc.carrera.logic.util;

import android.content.Context;
import android.os.Build;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.logic.bi.HiAnalyticsManager;

public class NfcHianalyticsUtil {
    private static final String CARD_OPENED_ACTION_KEY = "nfc_open";
    private static final String CARD_OPENED_KEY = "nfc_card_opened";
    private static final String CARD_SELECT_KEY = "card_selected";
    private static final String CARD_SWIPE_ACTION_KEY = "nfc_swipe";
    private static final String SCANPAY_KEY = "scan_payform";
    private static final String SWIPE_FINISH_KEY = "nfc_swipe_finish";
    private static final String SWIPE_FINISH_SCANPAY_KEY = "scan_finish";
    private static final String USER_ACCESS_NFC_KEY = "nfc_user_access_nfc_number";

    public static void onReportForSwipeFinish(Context context, String str, String str2) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForSwipeFinish.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append("1");
            stringBuilder.append("|");
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(str2);
            String str3 = Build.MODEL;
            if (!StringUtil.isEmpty(str3, true)) {
                stringBuilder.append("|");
                stringBuilder.append(str3);
            }
            stringBuilder.append("|");
            stringBuilder.append("");
            LogX.i("onReportForSwipeFinish.builder=" + stringBuilder.toString(), true);
            LogX.i("onReportForSwipeFinish success.", false);
            HiAnalyticsManager.m27964a(context, SWIPE_FINISH_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    public static void onReportForUserAccessNfc(Context context) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForUserAccessNfc.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append("1");
            String str = Build.MODEL;
            if (!StringUtil.isEmpty(str, true)) {
                stringBuilder.append("|");
                stringBuilder.append(str);
            }
            stringBuilder.append("|");
            stringBuilder.append("");
            LogX.i("onReportForUserAccessNfc.builder=" + stringBuilder.toString(), true);
            LogX.i("onReportForUserAccessNfc success.", false);
            HiAnalyticsManager.m27964a(context, USER_ACCESS_NFC_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    public static void onReportForCardOpened(Context context, String str, String str2, String str3, int i) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForCardOpened.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(str2);
            String str4 = Build.MODEL;
            if (!StringUtil.isEmpty(str4, true)) {
                stringBuilder.append("|");
                stringBuilder.append(str4);
            }
            stringBuilder.append("|");
            stringBuilder.append("");
            if (!StringUtil.isEmpty(str3, true)) {
                stringBuilder.append("|");
                stringBuilder.append(str3);
            }
            stringBuilder.append("|");
            stringBuilder.append(i);
            LogX.i("onReportForCardOpened.builder=" + stringBuilder.toString(), true);
            LogX.i("onReportForCardOpened success.", false);
            HiAnalyticsManager.m27964a(context, CARD_OPENED_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    public static void onReportForCardOpenAction(Context context, String str, String str2, String str3) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForCardOpenAction.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            if (!StringUtil.isEmpty(str, true)) {
                stringBuilder.append("|");
                stringBuilder.append(str);
            }
            stringBuilder.append("|");
            stringBuilder.append(str3);
            stringBuilder.append("|");
            stringBuilder.append(str2);
            stringBuilder.append("|");
            stringBuilder.append("");
            LogX.i("onReportForCardOpenAction.builder=" + stringBuilder.toString(), true);
            LogX.i("onReportForCardOpenAction success.", false);
            HiAnalyticsManager.m27964a(context, CARD_OPENED_ACTION_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    public static void onReportForSwipeAction(Context context, String str, String str2, String str3) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForSwipeAction.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(str3);
            stringBuilder.append("|");
            stringBuilder.append(str2);
            LogX.i("onReportForSwipeAction.builder=" + stringBuilder.toString(), true);
            LogX.i("onReportForSwipeAction success.", false);
            HiAnalyticsManager.m27964a(context, CARD_SWIPE_ACTION_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    public static void onReportForSelectCard(Context context, String str, int i) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForSelectCard.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(i);
            stringBuilder.append("|");
            stringBuilder.append("");
            LogX.i("onReportForSelectCard.builder=" + stringBuilder.toString(), false);
            LogX.i("onReportForSelectCard success.", false);
            HiAnalyticsManager.m27964a(context, CARD_SELECT_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    public static void onReportForScanPay(Context context, String str) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForScanPay.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append("");
            stringBuilder.append("|");
            stringBuilder.append(str);
            LogX.i("onReportForScanPay.builder=" + stringBuilder.toString(), false);
            LogX.i("onReportForScanPay success.", false);
            HiAnalyticsManager.m27964a(context, SCANPAY_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }

    public static void onReportForScanSwipeFinish(Context context, String str, int i, long j) {
        if (!HiAnalyticsManager.m27965a(context)) {
            if (context == null) {
                LogX.i("onReportForScanSwipeFinish.context is null.");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("" + System.currentTimeMillis());
            stringBuilder.append("|");
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(i);
            stringBuilder.append("|");
            stringBuilder.append("");
            if (j > 0) {
                stringBuilder.append("|");
                stringBuilder.append(j);
            }
            LogX.i("onReportForScanSwipeFinish.builder=" + stringBuilder.toString(), false);
            LogX.i("onReportForScanSwipeFinish success.", false);
            HiAnalyticsManager.m27964a(context, SWIPE_FINISH_SCANPAY_KEY, stringBuilder.toString());
            HiAnalyticsManager.m27966b(context);
        }
    }
}
