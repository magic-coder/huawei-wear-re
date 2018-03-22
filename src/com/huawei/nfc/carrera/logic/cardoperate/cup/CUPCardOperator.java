package com.huawei.nfc.carrera.logic.cardoperate.cup;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.nfc.carrera.logic.cardoperate.citic.HandleNullifyCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.HandleActiveCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.HandleInstallCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.HandleVerifyCodeResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.active.ActiveCUPCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.identifycard.CUPCardIdentifier;
import com.huawei.nfc.carrera.logic.cardoperate.cup.identifycard.IdentifyCardResult;
import com.huawei.nfc.carrera.logic.cardoperate.cup.install.CheckInstallInterruptedCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.install.HandleCheckCUPCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.install.InstallCupCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.install.RetryInstallCupCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.nullify.NullifyCupCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.CardOperateListener;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.HandleCardDeleteTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.HandleCardDownloadTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.HandleCardOperateBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.HandleCardSwipeTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.operation.HandleOperationResutTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.verifycode.RuquestCUPVerifyCodeTask;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.helpers.FileWatchdog;

public class CUPCardOperator implements CardOperateListener {
    private static final int CHECK_INTERRUPTED_DELAY_TIME = 60000;
    private static final Object LISTENERS_LOCK = new Object();
    public static final String OPERATE_EVENT_DELETE = "DELETE";
    public static final String OPERATE_EVENT_DOWNLOAD = "DOWNLOAD";
    public static final String OPERATE_EVENT_WIPEOUT = "WIPEOUT";
    private static final String TAG = "CUPCardOperator";
    private Handler cardModifyHandler;
    private final CardServerApi cardServerApi = ServerServiceFactory.createCardServerApi(this.mContext);
    private final CUPService cupServiceApi = SPIServiceFactory.createUPService(this.mContext);
    private Map<String, CUPOperationListener> deleteListeners;
    private Map<String, CUPOperationListener> downloadListeners;
    private final Context mContext;
    private final Handler operateHandler;
    private List<CUPOperationListener> wipeoutListeners;

    public CUPCardOperator(Context context, Handler handler) {
        this.mContext = context;
        this.operateHandler = handler;
    }

    public void init(InitCUPServiceResultTask initCUPServiceResultTask) {
        this.operateHandler.post(new InitCUPServiceTask(this.mContext, this.cupServiceApi, initCUPServiceResultTask));
    }

    public IdentifyCardResult indentifyCUPCard(String str) {
        return new CUPCardIdentifier(this.mContext, this.cupServiceApi, this.cardServerApi).indentifyCUPCard(str);
    }

    public void install(OpenCardInfo openCardInfo, HandleInstallCardResultTask handleInstallCardResultTask) {
        synchronized (LISTENERS_LOCK) {
            this.operateHandler.post(new InstallCupCardTask(this.mContext, this.cardServerApi, this.cupServiceApi, openCardInfo, handleInstallCardResultTask, this));
        }
    }

    public void reinstall(String str, String str2, HandleInstallCardResultTask handleInstallCardResultTask) {
        synchronized (LISTENERS_LOCK) {
            this.operateHandler.post(new RetryInstallCupCardTask(this.mContext, str, str2, this.cardServerApi, handleInstallCardResultTask, this));
        }
    }

    public void requestActiveVerifyCode(String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask) {
        synchronized (LISTENERS_LOCK) {
            this.operateHandler.post(new RuquestCUPVerifyCodeTask(this.mContext, this.cardServerApi, str, handleVerifyCodeResultTask));
        }
    }

    public void active(String str, String str2, HandleActiveCardResultTask handleActiveCardResultTask) {
        synchronized (LISTENERS_LOCK) {
            this.operateHandler.post(new ActiveCUPCardTask(this.mContext, this.cardServerApi, str, str2, handleActiveCardResultTask));
        }
    }

    public void nullify(String str, HandleNullifyCardResultTask handleNullifyCardResultTask) {
        synchronized (LISTENERS_LOCK) {
            this.operateHandler.post(new NullifyCupCardTask(this.mContext, this.cardServerApi, str, handleNullifyCardResultTask));
        }
    }

    public void notifyCardOperation(String str, String str2, String str3, ArrayList<String> arrayList, HandleOperationResutTask handleOperationResutTask) {
        synchronized (LISTENERS_LOCK) {
            if (this.cardModifyHandler == null) {
                HandlerThread handlerThread = new HandlerThread("cup_card_modify_thread");
                handlerThread.start();
                this.cardModifyHandler = new Handler(handlerThread.getLooper());
            }
            HandleCardOperateBaseTask handleCardOperateBaseTask = null;
            if (OPERATE_EVENT_DOWNLOAD.equals(str)) {
                handleCardOperateBaseTask = new HandleCardDownloadTask(this.mContext, this.cupServiceApi, handleOperationResutTask, this);
            } else if ("DELETE".equals(str)) {
                handleCardOperateBaseTask = new HandleCardDeleteTask(this.mContext, this.cupServiceApi, handleOperationResutTask, this);
            } else if (OPERATE_EVENT_WIPEOUT.equals(str)) {
                handleCardOperateBaseTask = new HandleCardSwipeTask(this.mContext, this.cupServiceApi, handleOperationResutTask, this);
            } else {
                LogX.e("notifyCardOperation, illegal event.");
            }
            if (handleCardOperateBaseTask != null) {
                handleCardOperateBaseTask.doTask(str2, str3, arrayList, this.cardModifyHandler);
            }
        }
    }

    public void registerOperationListener(String str, String str2, CUPOperationListener cUPOperationListener) {
        LogX.d("registerOperationListener, registerOperationListener");
        synchronized (LISTENERS_LOCK) {
            if (OPERATE_EVENT_DOWNLOAD.equals(str)) {
                if (this.downloadListeners == null) {
                    this.downloadListeners = new HashMap();
                }
                this.downloadListeners.put(str2, cUPOperationListener);
            } else if ("DELETE".equals(str)) {
                if (this.deleteListeners == null) {
                    this.deleteListeners = new HashMap();
                }
                this.deleteListeners.put(str2, cUPOperationListener);
            } else if (OPERATE_EVENT_WIPEOUT.equals(str)) {
                if (this.wipeoutListeners == null) {
                    this.wipeoutListeners = new ArrayList();
                }
                this.wipeoutListeners.add(cUPOperationListener);
            } else {
                LogX.e("registerOperationListener, illegal event.");
            }
        }
    }

    public void unregisterOperationListener(String str, String str2, CUPOperationListener cUPOperationListener) {
        LogX.d("registerOperationListener, unregisterOperationListener");
        synchronized (LISTENERS_LOCK) {
            if (OPERATE_EVENT_DOWNLOAD.equals(str) && this.downloadListeners != null) {
                this.downloadListeners.remove(str2);
            } else if ("DELETE".equals(str) && this.deleteListeners != null) {
                this.deleteListeners.remove(str2);
            } else if (!OPERATE_EVENT_WIPEOUT.equals(str) || this.wipeoutListeners == null) {
                LogX.e("unregisterOperationListener, illegal event.");
            } else if (cUPOperationListener != null) {
                this.wipeoutListeners.remove(cUPOperationListener);
            }
        }
    }

    public void notifyCardPesonalized(String str, String str2, String str3, HandlePersonalizedResultTask handlePersonalizedResultTask) {
        synchronized (LISTENERS_LOCK) {
            if (this.cardModifyHandler == null) {
                HandlerThread handlerThread = new HandlerThread("cup_card_modify_thread");
                handlerThread.start();
                this.cardModifyHandler = new Handler(handlerThread.getLooper());
            }
            this.cardModifyHandler.post(new HandlePersonalizedTask(this.mContext, str, str2, str3, handlePersonalizedResultTask, this));
        }
    }

    public void checkInterruptedCard(boolean z, HandleCheckCUPCardResultTask handleCheckCUPCardResultTask) {
        synchronized (LISTENERS_LOCK) {
            Runnable checkInstallInterruptedCardTask = new CheckInstallInterruptedCardTask(this.mContext, handleCheckCUPCardResultTask);
            if (z) {
                this.operateHandler.postDelayed(checkInstallInterruptedCardTask, FileWatchdog.DEFAULT_DELAY);
            } else {
                this.operateHandler.post(checkInstallInterruptedCardTask);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void operateStart(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        r0 = "CUPCardOperator, operateStart";
        com.huawei.nfc.carrera.util.LogX.d(r0);
        r1 = LISTENERS_LOCK;
        monitor-enter(r1);
        r0 = 0;
        r2 = "DOWNLOAD";
        r2 = r2.equals(r7);	 Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0060;
    L_0x0011:
        r2 = r6.downloadListeners;	 Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0060;
    L_0x0015:
        r0 = "CUPCardOperator";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0088 }
        r3 = 0;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0088 }
        r4.<init>();	 Catch:{ all -> 0x0088 }
        r5 = " CardEvent DOWNLOAD bank cardEvent refId : ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0088 }
        r4 = r4.append(r8);	 Catch:{ all -> 0x0088 }
        r4 = r4.toString();	 Catch:{ all -> 0x0088 }
        r2[r3] = r4;	 Catch:{ all -> 0x0088 }
        com.huawei.v.c.b(r0, r2);	 Catch:{ all -> 0x0088 }
        r0 = 1;
        r0 = com.huawei.nfc.carrera.util.StringUtil.isEmpty(r8, r0);	 Catch:{ all -> 0x0088 }
        if (r0 != 0) goto L_0x0051;
    L_0x003a:
        r0 = "CUPCardOperator";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0088 }
        r3 = 0;
        r4 = " CardEvent DOWNLOAD bank cardEvent START_LOCK";
        r2[r3] = r4;	 Catch:{ all -> 0x0088 }
        com.huawei.v.c.b(r0, r2);	 Catch:{ all -> 0x0088 }
        r0 = r6.mContext;	 Catch:{ all -> 0x0088 }
        r0 = com.huawei.nfc.carrera.logic.ta.WalletTaManager.getInstance(r0);	 Catch:{ all -> 0x0088 }
        r2 = 2;
        r0.cardEvent(r8, r2);	 Catch:{ all -> 0x0088 }
    L_0x0051:
        r0 = r6.downloadListeners;	 Catch:{ all -> 0x0088 }
        r0 = r0.values();	 Catch:{ all -> 0x0088 }
    L_0x0057:
        if (r0 != 0) goto L_0x008b;
    L_0x0059:
        r0 = "operateStart, but no listeners.";
        com.huawei.nfc.carrera.util.LogX.d(r0);	 Catch:{ all -> 0x0088 }
        monitor-exit(r1);	 Catch:{ all -> 0x0088 }
    L_0x005f:
        return;
    L_0x0060:
        r2 = "DELETE";
        r2 = r2.equals(r7);	 Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0073;
    L_0x0068:
        r2 = r6.deleteListeners;	 Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0073;
    L_0x006c:
        r0 = r6.deleteListeners;	 Catch:{ all -> 0x0088 }
        r0 = r0.values();	 Catch:{ all -> 0x0088 }
        goto L_0x0057;
    L_0x0073:
        r2 = "WIPEOUT";
        r2 = r2.equals(r7);	 Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0082;
    L_0x007b:
        r2 = r6.wipeoutListeners;	 Catch:{ all -> 0x0088 }
        if (r2 == 0) goto L_0x0082;
    L_0x007f:
        r0 = r6.wipeoutListeners;	 Catch:{ all -> 0x0088 }
        goto L_0x0057;
    L_0x0082:
        r2 = "operateStart, illegal event or empty listeners.";
        com.huawei.nfc.carrera.util.LogX.e(r2);	 Catch:{ all -> 0x0088 }
        goto L_0x0057;
    L_0x0088:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0088 }
        throw r0;
    L_0x008b:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0088 }
        r2.<init>();	 Catch:{ all -> 0x0088 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0088 }
    L_0x0094:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0088 }
        if (r0 == 0) goto L_0x00a6;
    L_0x009a:
        r0 = r3.next();	 Catch:{ all -> 0x0088 }
        r0 = (com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener) r0;	 Catch:{ all -> 0x0088 }
        if (r0 == 0) goto L_0x0094;
    L_0x00a2:
        r2.add(r0);	 Catch:{ all -> 0x0088 }
        goto L_0x0094;
    L_0x00a6:
        monitor-exit(r1);	 Catch:{ all -> 0x0088 }
        r1 = r2.iterator();
    L_0x00ab:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x005f;
    L_0x00b1:
        r0 = r1.next();
        r0 = (com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener) r0;
        if (r0 == 0) goto L_0x00ab;
    L_0x00b9:
        r0.operateStart();
        goto L_0x00ab;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator.operateStart(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void operateFinished(java.lang.String r5, java.lang.String r6, int r7) {
        /*
        r4 = this;
        r0 = "CUPCardOperator, operateFinished";
        com.huawei.nfc.carrera.util.LogX.d(r0);
        r1 = LISTENERS_LOCK;
        monitor-enter(r1);
        r0 = 0;
        r2 = "DOWNLOAD";
        r2 = r2.equals(r5);	 Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x0024;
    L_0x0011:
        r2 = r4.downloadListeners;	 Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r4.downloadListeners;	 Catch:{ all -> 0x0051 }
        r0 = r0.values();	 Catch:{ all -> 0x0051 }
    L_0x001b:
        if (r0 != 0) goto L_0x0054;
    L_0x001d:
        r0 = "operateStart, but no listeners.";
        com.huawei.nfc.carrera.util.LogX.d(r0);	 Catch:{ all -> 0x0051 }
        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
    L_0x0023:
        return;
    L_0x0024:
        r2 = "DELETE";
        r2 = r2.equals(r5);	 Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x003c;
    L_0x002c:
        r2 = r4.deleteListeners;	 Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x003c;
    L_0x0030:
        r0 = "CUPCardOperator, enter operateFinished  OPERATE_EVENT_DELETE";
        com.huawei.nfc.carrera.util.LogX.d(r0);	 Catch:{ all -> 0x0051 }
        r0 = r4.deleteListeners;	 Catch:{ all -> 0x0051 }
        r0 = r0.values();	 Catch:{ all -> 0x0051 }
        goto L_0x001b;
    L_0x003c:
        r2 = "WIPEOUT";
        r2 = r2.equals(r5);	 Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x004b;
    L_0x0044:
        r2 = r4.wipeoutListeners;	 Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x004b;
    L_0x0048:
        r0 = r4.wipeoutListeners;	 Catch:{ all -> 0x0051 }
        goto L_0x001b;
    L_0x004b:
        r2 = "operateStart, illegal event.";
        com.huawei.nfc.carrera.util.LogX.e(r2);	 Catch:{ all -> 0x0051 }
        goto L_0x001b;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
        throw r0;
    L_0x0054:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0051 }
        r2.<init>();	 Catch:{ all -> 0x0051 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0051 }
    L_0x005d:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x006f;
    L_0x0063:
        r0 = r3.next();	 Catch:{ all -> 0x0051 }
        r0 = (com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener) r0;	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x005d;
    L_0x006b:
        r2.add(r0);	 Catch:{ all -> 0x0051 }
        goto L_0x005d;
    L_0x006f:
        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
        r1 = r2.iterator();
    L_0x0074:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0023;
    L_0x007a:
        r0 = r1.next();
        r0 = (com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener) r0;
        if (r0 == 0) goto L_0x0074;
    L_0x0082:
        r0.operateFinished(r7);
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator.operateFinished(java.lang.String, java.lang.String, int):void");
    }
}
