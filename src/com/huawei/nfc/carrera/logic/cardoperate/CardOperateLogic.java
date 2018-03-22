package com.huawei.nfc.carrera.logic.cardoperate;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.nfc.carrera.logic.CardOperateLogicApi;
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
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.IssueTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryAndHandleUnfinishedOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryOfflineTrafficCardInfoResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryRecordsListResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RechargeResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RefundResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.UninstallTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.ApplyPayOrderTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.ApplyPayOrderTask1;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.IssueTrafficCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.PreIssueTrafficCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.QueryAndHandleUnfinishedOrdersTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.QueryRecordsListTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.QueryTrafficCardBalanceTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.RechargeTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.RefundTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.UninstallTrafficCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.HandleNullifyCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.HandleActiveCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.HandleInstallCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.HandleVerifyCodeResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.HandlePersonalizedResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.InitCUPServiceResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.install.HandleCheckCUPCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.HandleOperationResutTask;
import com.huawei.nfc.carrera.logic.cardoperate.identifycard.CardIssuerIdentifyTask;
import com.huawei.nfc.carrera.logic.cardoperate.identifycard.HandleIdentifyIssuerResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.EseTsmInitLoader;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.cardoperate.init.HandleInitEseResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.init.InitEseTask;
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
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;

public final class CardOperateLogic implements CardOperateLogicApi {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static CardOperateLogic instance;
    private Handler auxOperateHandler;
    private HandlerThread auxOperateHandlerThread;
    private final Context mContext;
    private TrafficCardBaseTask mQueryRecordsTask;
    private final Handler operateHandler;
    private final Handler operateResultHandler = new Handler(this.mContext.getMainLooper());
    private final SPIOperatorManager operatorManager = new SPIOperatorManager(this.mContext, this.operateHandler);

    private CardOperateLogic(Context context) {
        this.mContext = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("card_operate_thread");
        handlerThread.start();
        this.operateHandler = new Handler(handlerThread.getLooper());
    }

    private void startAuxOperateHandlerThread() {
        if (this.auxOperateHandlerThread == null) {
            this.auxOperateHandlerThread = new HandlerThread("aux_card_operate_thread");
            this.auxOperateHandlerThread.start();
            this.auxOperateHandler = new Handler(this.auxOperateHandlerThread.getLooper());
        } else if (!this.auxOperateHandlerThread.isAlive()) {
            this.auxOperateHandlerThread.start();
            this.auxOperateHandler = new Handler(this.auxOperateHandlerThread.getLooper());
        }
    }

    public static CardOperateLogic getInstance(Context context) {
        CardOperateLogic cardOperateLogic;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new CardOperateLogic(context);
            }
            cardOperateLogic = instance;
        }
        return cardOperateLogic;
    }

    public void initEseInfo() {
        LogX.i("initEseInfo.");
        this.operateHandler.post(new EseTsmInitLoader(this.mContext));
    }

    public void initCUPCardOperator(InitCUPCardOperatorCallback initCUPCardOperatorCallback) {
        LogX.i("initCUPCardOperator");
        this.operatorManager.getCUPOperator().init(new InitCUPServiceResultTask(this.operateResultHandler, initCUPCardOperatorCallback));
    }

    public void identifyCardType(String str, CardTypeIdentifyCallback cardTypeIdentifyCallback) {
        LogX.i("identifyCardType now.");
        if (StringUtil.isEmpty(str, true) || str.length() < 6) {
            LogX.e("identifyCardType, cardNum is illegal.");
            cardTypeIdentifyCallback.identifyResult(-1, null, -1, -1);
            return;
        }
        this.operateHandler.post(new CardIssuerIdentifyTask(this.mContext, str, this.operatorManager, new HandleIdentifyIssuerResultTask(this.operateResultHandler, cardTypeIdentifyCallback)));
    }

    public void openCard(int i, OpenCardInfo openCardInfo, InstallCardResultCallback installCardResultCallback) {
        LogX.i("openCard now, mode: " + i);
        if (installCardResultCallback == null) {
            LogX.e("openCard, callback is illegal.");
            return;
        }
        HandleInstallCardResultTask handleInstallCardResultTask = new HandleInstallCardResultTask(this.operateResultHandler, installCardResultCallback);
        if (openCardInfo == null || StringUtil.isEmpty(openCardInfo.getCardNum(), true) || StringUtil.isEmpty(openCardInfo.getIssuerId(), true)) {
            LogX.e("openCard, input info is illegal.");
            handleInstallCardResultTask.notifyInstallResult(-1, null, null);
        } else if (this.operatorManager.isCmbMode(i)) {
            this.operatorManager.getCMBOperator().install(openCardInfo, handleInstallCardResultTask);
        } else if (this.operatorManager.isCupMode(i) || this.operatorManager.isCiticMode(i)) {
            this.operatorManager.getCUPOperator().install(openCardInfo, handleInstallCardResultTask);
        } else {
            LogX.e("opencard, but the mode is not supported.");
            handleInstallCardResultTask.notifyInstallResult(-2, null, null);
        }
    }

    public void requestActiveSmsCode(String str, int i, RequestVerifyCodeCallback requestVerifyCodeCallback) {
        LogX.i("requestActiveSmsCode now, refId: " + str + "mode = " + i + "operatorManager.isCiticMode(mode, refId)=" + this.operatorManager.isCiticMode(i, str));
        if (requestVerifyCodeCallback == null) {
            LogX.e("requestActiveSmsCode, but callback is illegal.");
        } else if (StringUtil.isEmpty(str, true)) {
            LogX.e("requestActiveSmsCode, but params is illegal.");
            requestVerifyCodeCallback.requestResultCallback(-99, null);
        } else {
            HandleVerifyCodeResultTask handleVerifyCodeResultTask = new HandleVerifyCodeResultTask(this.operateResultHandler, requestVerifyCodeCallback);
            if (this.operatorManager.isCiticMode(i, str)) {
                this.operatorManager.getCITICOperator().requestActiveVerifyCode(str, handleVerifyCodeResultTask);
            } else if (this.operatorManager.isCmbMode(i)) {
                this.operatorManager.getCMBOperator().requestActiveVerifyCode(str, handleVerifyCodeResultTask);
            } else if (this.operatorManager.isCupMode(i) || this.operatorManager.isCiticMode(i)) {
                this.operatorManager.getCUPOperator().requestActiveVerifyCode(str, handleVerifyCodeResultTask);
            } else {
                LogX.e("requestActiveSmsCode, but the mode is not supported.");
                requestVerifyCodeCallback.requestResultCallback(-99, null);
            }
        }
    }

    public void activeCard(String str, int i, String str2, ActiveCardCallback activeCardCallback) {
        LogX.i("requestActiveSmsCode now, refId: " + str + "mode = " + i + "operatorManager.isCiticMode(mode, refId)=" + this.operatorManager.isCiticMode(i, str));
        if (activeCardCallback == null) {
            LogX.e("activeCard, but callback is illegal.");
        } else if (StringUtil.isEmpty(str2, true) || StringUtil.isEmpty(str, true)) {
            LogX.e("activeCard, but params illegal.");
            activeCardCallback.activeResultCallback(-99);
        } else {
            HandleActiveCardResultTask handleActiveCardResultTask = new HandleActiveCardResultTask(this.operateResultHandler, activeCardCallback);
            if (this.operatorManager.isCiticMode(i, str)) {
                this.operatorManager.getCITICOperator().active(str, str2, handleActiveCardResultTask);
            } else if (this.operatorManager.isCmbMode(i)) {
                this.operatorManager.getCMBOperator().active(str, str2, handleActiveCardResultTask);
            } else if (this.operatorManager.isCupMode(i) || this.operatorManager.isCiticMode(i)) {
                this.operatorManager.getCUPOperator().active(str, str2, handleActiveCardResultTask);
            } else {
                LogX.e("requestActiveSmsCode, but the mode is not supported.");
                activeCardCallback.activeResultCallback(-5);
            }
        }
    }

    public void requestNullifySmsCode(String str, int i, RequestVerifyCodeCallback requestVerifyCodeCallback) {
        LogX.i("requestNullifySmsCode now, refId: " + str);
        if (requestVerifyCodeCallback == null) {
            LogX.e("requestNullifySmsCode, but callback is illegal.");
        } else if (StringUtil.isEmpty(str, true)) {
            LogX.e("requestNullifySmsCode, but productId is illegal.");
            requestVerifyCodeCallback.requestResultCallback(-99, null);
        } else {
            HandleVerifyCodeResultTask handleVerifyCodeResultTask = new HandleVerifyCodeResultTask(this.operateResultHandler, requestVerifyCodeCallback);
            if (this.operatorManager.isCiticMode(i, str)) {
                this.operatorManager.getCITICOperator().requestNullifyVerifyCode(str, handleVerifyCodeResultTask);
                return;
            }
            LogX.e("requestNullifySmsCode, but the mode is not supported.");
            requestVerifyCodeCallback.requestResultCallback(-99, null);
        }
    }

    public void nullifyCard(String str, int i, String str2, NullifyCardResultCallback nullifyCardResultCallback) {
        LogX.i("nullifyCard now, mode: " + i + " ,refId: " + str);
        if (nullifyCardResultCallback == null) {
            LogX.e("nullifyCard, callback is illegal.");
        } else if (StringUtil.isEmpty(str, true)) {
            LogX.e("nullifyCard, params is illegal.");
            nullifyCardResultCallback.nullifyResultCallback(-1);
        } else {
            HandleNullifyCardResultTask handleNullifyCardResultTask = new HandleNullifyCardResultTask(this.operateResultHandler, nullifyCardResultCallback);
            if (this.operatorManager.isCiticMode(i, str)) {
                if (StringUtil.isEmpty(str2, true)) {
                    LogX.e("nullifyCard mode is citic, sms code params is illegal.");
                    nullifyCardResultCallback.nullifyResultCallback(-1);
                    return;
                }
                this.operatorManager.getCITICOperator().nullify(str, str2, handleNullifyCardResultTask);
            } else if (this.operatorManager.isCmbMode(i)) {
                this.operatorManager.getCMBOperator().nullify(str, handleNullifyCardResultTask);
            } else if (this.operatorManager.isCupMode(i) || this.operatorManager.isCiticMode(i)) {
                this.operatorManager.getCUPOperator().nullify(str, handleNullifyCardResultTask);
            } else {
                LogX.e("nullifyCard, but the mode is not supported.");
                nullifyCardResultCallback.nullifyResultCallback(-2);
            }
        }
    }

    public void registerCUPOperationListener(String str, String str2, CUPOperationListener cUPOperationListener) {
        LogX.i("registerCUPOperationListener, event: " + str + ",refId: " + str2);
        this.operatorManager.getCUPOperator().registerOperationListener(str, str2, cUPOperationListener);
    }

    public void unregisterCUPOperationListener(String str, String str2, CUPOperationListener cUPOperationListener) {
        LogX.i("unregisterCUPOperationListener, event: " + str + ",refId: " + str2);
        this.operatorManager.getCUPOperator().unregisterOperationListener(str, str2, cUPOperationListener);
    }

    public void notifyCUPCardOperation(String str, String str2, String str3, ArrayList<String> arrayList, HandleCUPOperateResultCallback handleCUPOperateResultCallback) {
        LogX.i("notifyCUPCardOperation, event: " + str);
        if (handleCUPOperateResultCallback == null) {
            LogX.e("notifyCUPCardOperation, callback is illegal.");
        } else if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true) || StringUtil.isEmpty(str3, true)) {
            LogX.e("notifyCUPCardOperation, params is illegal.");
            handleCUPOperateResultCallback.operateResultCallback(-99);
        } else {
            this.operatorManager.getCUPOperator().notifyCardOperation(str, str2, str3, arrayList, new HandleOperationResutTask(this.operateResultHandler, handleCUPOperateResultCallback));
        }
    }

    public void notifyCUPCardPersonalized(String str, String str2, String str3, HandleCUPPersonalizedResultCallback handleCUPPersonalizedResultCallback) {
        LogX.i("notifyCUPCardPersonalized, refId: " + str2 + ",aid: " + str3);
        if (handleCUPPersonalizedResultCallback == null) {
            LogX.e("notifyCUPCardPersonalized, callback is illegal.");
        } else if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true) || StringUtil.isEmpty(str3, true)) {
            LogX.e("notifyCUPCardPersonalized, params is illegal.");
            handleCUPPersonalizedResultCallback.handleResultCallback(-1);
        } else {
            this.operatorManager.getCUPOperator().notifyCardPesonalized(str, str2, str3, new HandlePersonalizedResultTask(handleCUPPersonalizedResultCallback, this.operateResultHandler));
        }
    }

    public void checkCUPInterruptedCard(boolean z, CheckCUPCardCallback checkCUPCardCallback) {
        LogX.i("checkCUPInterruptedCard.");
        this.operatorManager.getCUPOperator().checkInterruptedCard(z, new HandleCheckCUPCardResultTask(checkCUPCardCallback, this.operateResultHandler));
    }

    public void preIssueTrafficCard(String str) {
        LogX.i("tsm preIssueTrafficCard");
        Runnable preIssueTrafficCardTask = new PreIssueTrafficCardTask(this.mContext, str, this.operatorManager);
        LogX.d("preIssueTrafficCard operateHandler is " + this.operateHandler);
        this.operateHandler.post(preIssueTrafficCardTask);
    }

    public void applyPayOrder(String str, ApplyOrderInfo applyOrderInfo, ApplyPayOrderCallback applyPayOrderCallback) {
        if (applyPayOrderCallback == null) {
            LogX.w("CardOperateLogic applyPayOrder, null == callback");
            return;
        }
        Handler handler;
        if (applyOrderInfo.getOrderType() == 1 || applyOrderInfo.getOrderType() == 3) {
            startAuxOperateHandlerThread();
            handler = this.auxOperateHandler;
        } else {
            handler = this.operateHandler;
        }
        handler.post(new ApplyPayOrderTask1(this.mContext, this.operatorManager, str, applyOrderInfo, new ApplyPayOrderResultHandler(this.operateResultHandler, applyPayOrderCallback)));
    }

    public void applyPayOrder(String str, double d, int i, int i2, String str2, ApplyPayOrderCallback applyPayOrderCallback) {
        if (applyPayOrderCallback == null) {
            LogX.w("CardOperateLogic applyPayOrder, null == callback");
            return;
        }
        Handler handler;
        LogX.d("applyPayOrder orderType is " + i);
        if (i == 1 || i == 3) {
            startAuxOperateHandlerThread();
            handler = this.auxOperateHandler;
        } else {
            handler = this.operateHandler;
        }
        Runnable applyPayOrderTask = new ApplyPayOrderTask(this.mContext, this.operatorManager, str, d, i, i2, str2, new ApplyPayOrderResultHandler(this.operateResultHandler, applyPayOrderCallback));
        LogX.d("applyPayOrder operateHandler is " + handler);
        handler.post(applyPayOrderTask);
    }

    public void issueTrafficCard(String str, TrafficOrder trafficOrder, IssueTrafficCardCallback issueTrafficCardCallback) {
        if (issueTrafficCardCallback == null) {
            LogX.w("CardOperateLogic issueTrafficCard, null == callback");
            return;
        }
        Runnable issueTrafficCardTask = new IssueTrafficCardTask(this.mContext, this.operatorManager, str, trafficOrder, new IssueTrafficCardResultHandler(this.operateResultHandler, issueTrafficCardCallback));
        LogX.d("issueTrafficCard operateHandler is " + this.operateHandler);
        this.operateHandler.post(issueTrafficCardTask);
    }

    public void uninstallTrafficCard(String str, UninstallTrafficCardCallback uninstallTrafficCardCallback) {
        if (uninstallTrafficCardCallback == null) {
            LogX.e("CardOperateLogic uninstallTrafficCard, null == callback");
            return;
        }
        this.operateHandler.post(new UninstallTrafficCardTask(this.mContext, this.operatorManager, str, new UninstallTrafficCardResultHandler(this.operateResultHandler, uninstallTrafficCardCallback)));
    }

    public void recharge(String str, TrafficOrder trafficOrder, RechargeCallback rechargeCallback) {
        if (rechargeCallback == null) {
            LogX.e("CardOperateLogic recharge, null == callback");
            return;
        }
        this.operateHandler.post(new RechargeTask(this.mContext, this.operatorManager, str, trafficOrder, new RechargeResultHandler(this.operateResultHandler, rechargeCallback)));
    }

    public void queryAndHandleUnfinfishedOrders(String str, int i, QueryAndHandleUnfinishedOrderCallback queryAndHandleUnfinishedOrderCallback) {
        if (queryAndHandleUnfinishedOrderCallback == null) {
            LogX.e("CardOperateLogic queryAndHandleUnfinfishedOrders, null == callback");
            return;
        }
        if (this.mQueryRecordsTask != null) {
            this.operateHandler.removeCallbacks(this.mQueryRecordsTask);
        }
        this.operateHandler.post(new QueryAndHandleUnfinishedOrdersTask(this.mContext, this.operatorManager, str, i, new QueryAndHandleUnfinishedOrderResultHandler(this.operateResultHandler, queryAndHandleUnfinishedOrderCallback)));
    }

    public void queryRecords(String str, int i, QueryRecordsListCallback queryRecordsListCallback) {
        LogX.i("CardOperateLogic queryRecords enter");
        if (queryRecordsListCallback == null) {
            LogX.e("CardOperateLogic queryRecords, null == callback");
            return;
        }
        if (this.mQueryRecordsTask != null) {
            this.operateHandler.removeCallbacks(this.mQueryRecordsTask);
        }
        this.mQueryRecordsTask = new QueryRecordsListTask(this.mContext, this.operatorManager, str, i, new QueryRecordsListResultHandler(this.operateResultHandler, queryRecordsListCallback));
        this.operateHandler.post(this.mQueryRecordsTask);
    }

    public void refund(String str, TrafficOrder trafficOrder, RefundCallback refundCallback) {
        if (refundCallback == null) {
            LogX.e("CardOperateLogic refund, null == callback");
            return;
        }
        this.operateHandler.post(new RefundTask(this.mContext, this.operatorManager, str, trafficOrder, new RefundResultHandler(this.operateResultHandler, refundCallback)));
    }

    public void queryOfflineTrafficCardInfo(String str, int i, QueryOfflineTrafficCardInfoCallback queryOfflineTrafficCardInfoCallback) {
        if (queryOfflineTrafficCardInfoCallback == null) {
            LogX.e("CardOperateLogic queryTrafficCardBalance, null == callback");
            return;
        }
        if (this.mQueryRecordsTask != null) {
            this.operateHandler.removeCallbacks(this.mQueryRecordsTask);
        }
        this.operateHandler.post(new QueryTrafficCardBalanceTask(this.mContext, this.operatorManager, str, i, new QueryOfflineTrafficCardInfoResultHandler(this.operateResultHandler, queryOfflineTrafficCardInfoCallback)));
    }

    public void retryDownloadCard(String str, String str2, InstallCardResultCallback installCardResultCallback) {
        LogX.i("retry Download Card now");
        if (installCardResultCallback == null) {
            LogX.e("retry Download Card, callback is illegal.");
            return;
        }
        this.operatorManager.getCUPOperator().reinstall(str, str2, new HandleInstallCardResultTask(this.operateResultHandler, installCardResultCallback));
    }

    public void initEseInfo(InitEseResultCallback initEseResultCallback) {
        this.operateHandler.post(new InitEseTask(this.mContext, new HandleInitEseResultTask(this.operateResultHandler, initEseResultCallback)));
    }
}
