package com.huawei.nfc.carrera.logic.lostmanager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.huawei.nfc.carrera.logic.lostmanager.callback.CheckDeviceStatusCallback;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeleteLocalCardsCallback;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeviceRepairCallback;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleServerCardLostMsgCallback;
import com.huawei.nfc.carrera.logic.lostmanager.lost.CheckAndHandleCardStatusModifiedTask;
import com.huawei.nfc.carrera.logic.lostmanager.lost.CleanAllLocalBankCardsTask;
import com.huawei.nfc.carrera.logic.lostmanager.lost.ClearAllNullifiedCardTask;
import com.huawei.nfc.carrera.logic.lostmanager.lost.DeleteAllLocalCardsTask;
import com.huawei.nfc.carrera.logic.lostmanager.lost.HandleCardNullifiedTask;
import com.huawei.nfc.carrera.logic.lostmanager.lost.HandleServerModifyCardStatusTask;
import com.huawei.nfc.carrera.logic.lostmanager.report.CheckAndReportStatusTask;
import com.huawei.nfc.carrera.logic.lostmanager.report.ReportCardStatusTask;
import com.huawei.nfc.carrera.logic.lostmanager.report.ReportDeviceStatusTask;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

public final class CardLostManager implements CardLostManagerApi {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "CardLostManager";
    private static CardLostManager instance;
    private Context mContext;
    private final Looper mServiceLooper;
    private final Handler taskHandler;

    private CardLostManager(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        HandlerThread handlerThread = new HandlerThread(TAG, 10);
        handlerThread.start();
        this.mServiceLooper = handlerThread.getLooper();
        this.taskHandler = new Handler(this.mServiceLooper);
    }

    public static CardLostManager getInstance(Context context) {
        CardLostManager cardLostManager;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new CardLostManager(context);
            }
            cardLostManager = instance;
        }
        return cardLostManager;
    }

    public void reportCardOpenedNotActiveStatus(String str, String str2, String str3, String str4) {
        LogX.m5475i("reportCardOpenedAvailableStatus, aid: " + str);
        if (StringUtil.isEmpty(str, true)) {
            LogX.m5469e("reportCardOpenedButNotAvailableStatus, illegal params");
            return;
        }
        this.taskHandler.post(new ReportCardStatusTask(this.mContext, str, "7", str2, str3, str4));
    }

    public void reportCardOpenedAvailableStatus(String str, String str2, String str3, String str4, String str5, int i) {
        LogX.m5475i("reportCardOpenedAvailableStatus, aid: " + str);
        if (StringUtil.isEmpty(str, true)) {
            LogX.m5469e("reportCardOpenedAvailableStatus, but card id is illegal.");
            return;
        }
        this.taskHandler.post(new ReportCardStatusTask(this.mContext, str, "0", str2, str3, str4, str5, i));
    }

    public void reportCardLockedStatus(String str, String str2) {
        LogX.m5475i("reportCardLockedStatus, aid: " + str);
        if (StringUtil.isEmpty(str, true)) {
            LogX.m5469e("reportCardLockedStatus, but card id is illegal.");
            return;
        }
        this.taskHandler.post(new ReportCardStatusTask(this.mContext, str, "3", str2, null, null));
    }

    public void reportCardDeletedStatus(String str, String str2) {
        LogX.m5475i("reportCardDeletedStatus, aid: " + str);
        if (StringUtil.isEmpty(str, true)) {
            LogX.m5469e("reportCardDeletedStatus, but card id is illegal.");
            return;
        }
        this.taskHandler.post(new ReportCardStatusTask(this.mContext, str, "6", str2, null, null));
    }

    public void reportCardDeletedStatus(String str, String str2, boolean z) {
        LogX.m5475i("reportCardDeletedStatus, aid: " + str);
        if (StringUtil.isEmpty(str, true)) {
            LogX.m5469e("reportCardDeletedStatus, but card id is illegal.");
            return;
        }
        this.taskHandler.post(new ReportCardStatusTask(this.mContext, str, "6", str2, null, null, z));
    }

    public void checkCardStatusWaitingReport() {
        LogX.m5465d("checkCardStatusWaitingReport");
        this.taskHandler.post(new CheckAndReportStatusTask(this.mContext));
    }

    public void clearNullifiedCardLocalInfo(String str) {
        LogX.m5475i("clearNullifiedCardLocalInfo, aid: " + str);
        if (StringUtil.isEmpty(str, true)) {
            LogX.m5469e("clearNullifiedCardLocalInfo, but params illegal.");
            return;
        }
        this.taskHandler.post(new HandleCardNullifiedTask(this.mContext, str));
    }

    public void handleServerCardLostMessage(String str, String str2, String str3, String str4, HandleServerCardLostMsgCallback handleServerCardLostMsgCallback) {
        LogX.m5475i("handleServerCardLostMessage, aid: " + str + ", status: " + str2);
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true) || StringUtil.isEmpty(str3, true)) {
            LogX.m5469e("handleServerCardLostMessage, but params illegal.");
            if (handleServerCardLostMsgCallback != null) {
                handleServerCardLostMsgCallback.handleServerMsgResult(false, str, str3);
            }
        } else if ("5".equals(str2) || "2".equals(str2) || "1".equals(str2) || "00".equals(str2)) {
            this.taskHandler.post(new HandleServerModifyCardStatusTask(this.mContext, str, str2, str3, str4, handleServerCardLostMsgCallback));
        } else {
            LogX.m5469e("handleServerCardLostMessage, invalid status, no need to handle it.");
            if (handleServerCardLostMsgCallback != null) {
                handleServerCardLostMsgCallback.handleServerMsgResult(false, str, str3);
            }
        }
    }

    public void checkDeviceStatus(CheckDeviceStatusCallback checkDeviceStatusCallback) {
        LogX.m5475i("checkDeviceStatus");
        this.taskHandler.post(new CheckAndHandleCardStatusModifiedTask(this.mContext, checkDeviceStatusCallback));
    }

    public void handleDeviceRepair(int i, HandleDeviceRepairCallback handleDeviceRepairCallback) {
        switch (i) {
            case 1:
                LogX.m5465d("repair task, update server info");
                this.taskHandler.post(new ReportDeviceStatusTask(this.mContext, "01"));
                return;
            case 2:
                LogX.m5465d("repair task, wait for del cards");
                this.taskHandler.post(new DeleteAllLocalCardsTask(this.mContext, 0, handleDeviceRepairCallback));
                return;
            default:
                LogX.m5465d("repair task, get error code : " + i);
                return;
        }
    }

    public void deleteLocalBankCards(HandleDeleteLocalCardsCallback handleDeleteLocalCardsCallback) {
        LogX.m5475i("deleteLocalCards");
        this.taskHandler.post(new CleanAllLocalBankCardsTask(this.mContext, handleDeleteLocalCardsCallback));
    }

    public void clearAllNullifiedCardLocalInfo() {
        LogX.m5475i("clearAllNullifiedCardLocalInfo");
        this.taskHandler.post(new ClearAllNullifiedCardTask(this.mContext));
    }
}
