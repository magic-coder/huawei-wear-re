package com.huawei.nfc.carrera.logic.cardoperate.cup.install;

import android.content.Context;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.lifecycle.cupoperate.CUPOperateServiceManager;
import com.huawei.nfc.carrera.lifecycle.push.data.PushCUPOperateMessage;
import com.huawei.nfc.carrera.lifecycle.push.data.PushMessageParser;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.HandleInstallCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.request.QueryUnionPayPushRequest;
import com.huawei.nfc.carrera.server.card.response.QueryUnionPayPushResponse;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;

public abstract class DownloadObserver implements CUPOperationListener {
    private static final int DOWNLOAD_OPERATION_FINISHED = 1;
    private static final int DOWNLOAD_OPERATION_NOT_START = -1;
    private static final int DOWNLOAD_OPERATION_RESULT_UNINIT = 99;
    private static final int DOWNLOAD_OPERATION_STARTED = 0;
    private static final int FIRST_WAIT_OPERATION_TIME_OUT = 6000;
    private static final int NOTIFY_INSTALL_RESULT_DELAY = 180000;
    private static final int WAITING_TIMES = 6;
    private static final int WAIT_OPERATION_TIME_OUT = 3000;
    protected final CUPCardOperator curOperator;
    private int downloadOperationResult = 99;
    private int downloadOperationStatus = -1;
    protected final Context mContext;
    protected final HandleInstallCardResultTask mResultTask;
    protected final CardServerApi mServerApi;
    public PluginPayAdapter pluginPayAdapter;

    abstract void cleanUnstartedData(String str);

    public DownloadObserver(Context context, HandleInstallCardResultTask handleInstallCardResultTask, CUPCardOperator cUPCardOperator, CardServerApi cardServerApi) {
        this.mContext = context;
        this.curOperator = cUPCardOperator;
        this.mResultTask = handleInstallCardResultTask;
        this.mServerApi = cardServerApi;
        this.pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter();
    }

    public void operateStart() {
        LogX.d("operateStart now.");
        synchronized (this) {
            this.downloadOperationStatus = 0;
            notifyAll();
        }
    }

    public void operateFinished(int i) {
        LogX.d("operateFinished result: " + i);
        synchronized (this) {
            this.downloadOperationStatus = 1;
            this.downloadOperationResult = i;
            notifyAll();
        }
    }

    protected void observeDownloadResult(String str, String str2) {
        this.curOperator.registerOperationListener(CUPCardOperator.OPERATE_EVENT_DOWNLOAD, str, this);
        waitDownloadStarted(str);
        waitAndHandleDownloadResult(str, str2);
        this.curOperator.unregisterOperationListener(CUPCardOperator.OPERATE_EVENT_DOWNLOAD, str, this);
        CardInfoManager.getInstance(this.mContext).refreshCardList();
    }

    protected boolean isCardDownload(String str) {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
        if (card == null || (2 != card.cardStatus && 1 != card.cardStatus)) {
            return false;
        }
        return true;
    }

    private int getWatchConnectedStatus() {
        LogX.d("enter getWatchConnectedStatus ");
        return this.pluginPayAdapter.getDeviceConnectState();
    }

    private synchronized void waitDownloadStarted(String str) {
        int i = 0;
        do {
            try {
                LogX.d("getTsmLibData getWatchConnectedStatus() : " + getWatchConnectedStatus());
                if (getWatchConnectedStatus() != 2 || !C4026a.m19819a(this.mContext)) {
                    LogX.d("watch or network is disConnected .");
                    break;
                }
                if (i == 0) {
                    wait(6000);
                } else {
                    wait(3000);
                }
                i++;
                if (-1 == this.downloadOperationStatus) {
                    LogX.d("===123===leibinsheng 轮训获取aid start getTsmLibData ");
                    if (getTsmLibData(str)) {
                        wait(3000);
                    }
                    LogX.d("end getTsmLibData ");
                }
                if (i > 6 || this.downloadOperationStatus == 0) {
                    LogX.d("wait download operation start, timeout.");
                }
            } catch (InterruptedException e) {
                LogX.e("wait download operation time out.");
            }
        } while (1 != this.downloadOperationStatus);
        LogX.d("wait download operation start, timeout.");
    }

    private synchronized void waitAndHandleDownloadResult(String str, String str2) {
        if (-1 == this.downloadOperationStatus) {
            LogX.e("DOWNLOAD_OPERATION_NOT_START!");
            if (this instanceof InstallCupCardTask) {
                TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
                if (card != null) {
                    try {
                        WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 3);
                        if (card.cardStatus == 98) {
                            LogX.e("== cleanUnstartedData");
                            cleanUnstartedData(str);
                        }
                    } catch (WalletTaCardNotExistException e) {
                        LogX.d("card info has been already deleted! refID = " + str);
                    } catch (WalletTaSystemErrorException e2) {
                        LogX.w("updateCardStatus err! refID = " + str);
                    }
                }
            }
            handleResult(-4, null, null);
        } else {
            try {
                LogX.d("check download operation result: " + this.downloadOperationResult);
                while (99 == this.downloadOperationResult) {
                    LogX.d("===123===开始等待 ");
                    wait(180000);
                    LogX.d("after wait for a while, the download operation result: " + this.downloadOperationResult);
                    if (this.downloadOperationResult == 0 || -99 == this.downloadOperationResult) {
                    }
                }
            } catch (InterruptedException e3) {
                LogX.e("install cup card wait the download result, but interrupted.");
            }
            handleDownloadResult(str2, str);
        }
    }

    private void handleDownloadResult(String str, String str2) {
        int i = -99;
        if (this.downloadOperationResult == 0 || 99 == this.downloadOperationResult) {
            LogX.d("===123====返回结果INSTALL_RESULT_CODE_SUCCESS");
            i = false;
        } else if (-1 == this.downloadOperationResult) {
            LogX.d("===123====OPERATE_RESULT_FAILED_DATA_OUT_OF_USE");
            updateTaCardStatusToErr(str2, true);
            i = -19;
        } else if (-98 == this.downloadOperationResult) {
            LogX.d("===123====OPERATE_RESULT_DEAL");
            updateTaCardStatusToErr(str2, true);
            i = -4;
        } else {
            LogX.d("===123====updateTaCardStatusToErr");
            updateTaCardStatusToErr(str2, false);
        }
        LogX.d("===123===getTsmLibData getWatchConnectedStatus() : " + getWatchConnectedStatus());
        if (!(getWatchConnectedStatus() == 2 && C4026a.m19819a(this.mContext))) {
            LogX.d("watch or network is disConnected .");
            i = -4;
        }
        handleResult(i, str, str2);
    }

    protected void handleResult(int i, String str, String str2) {
        if (this.mResultTask != null) {
            this.mResultTask.notifyInstallResult(i, str, str2);
        }
    }

    private void updateTaCardStatusToErr(String str, boolean z) {
        int i = 94;
        Object obj = 1;
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
        if (card == null) {
            LogX.i("updateTaCardStatusToErr, card is null");
        } else if (z) {
            deleteCard(str);
        } else {
            if (!(card.cardStatus == 93 || card.cardStatus == 94 || card.cardStatus == 1 || card.cardStatus == 2)) {
                obj = null;
            }
            if (obj == null) {
                if (card.cardStatus == 96 || card.cardStatus == 95) {
                    i = 93;
                }
                try {
                    WalletTaManager.getInstance(this.mContext).updateCardStatus(str, i);
                } catch (WalletTaCardNotExistException e) {
                    LogX.d("card info has been already deleted! refID = " + str);
                } catch (WalletTaSystemErrorException e2) {
                    LogX.w("updateCardStatus err! refID = " + str);
                }
            }
        }
    }

    protected void deleteCard(String str) {
        LogX.d("DownloadObserver  and refid is :" + str);
        Object obj = null;
        String str2 = null;
        try {
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
            if (card != null) {
                WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 3);
                obj = 1;
                str2 = card.getAid();
            }
        } catch (WalletTaCardNotExistException e) {
            LogX.d("deleteCard card info has been already deleted! refID = " + str);
        } catch (WalletTaSystemErrorException e2) {
            LogX.d("deleteCard updateCardStatus NULLIFIED err! refID = " + str);
        }
        if (obj != null) {
            CardInfoManager.getInstance(this.mContext).refreshCardList();
            CardLostManager.getInstance(this.mContext).clearNullifiedCardLocalInfo(str2);
        }
    }

    protected boolean getTsmLibData(String str) {
        QueryUnionPayPushRequest queryUnionPayPushRequest = new QueryUnionPayPushRequest();
        queryUnionPayPushRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        QueryUnionPayPushResponse queryUnionPayPush = this.mServerApi.queryUnionPayPush(queryUnionPayPushRequest);
        if (queryUnionPayPush != null && queryUnionPayPush.returnCode == 0) {
            String pushMsg = queryUnionPayPush.getPushMsg();
            if (pushMsg != null) {
                Object parsePushMessage = new PushMessageParser().parsePushMessage(pushMsg);
                if (parsePushMessage instanceof PushCUPOperateMessage) {
                    return handlePushMessage((PushCUPOperateMessage) parsePushMessage, str);
                }
            }
        }
        return false;
    }

    private boolean handlePushMessage(PushCUPOperateMessage pushCUPOperateMessage, String str) {
        if (CUPCardOperator.OPERATE_EVENT_DOWNLOAD.equals(pushCUPOperateMessage.getEvent())) {
            ArrayList virtualCards = pushCUPOperateMessage.getVirtualCards();
            if (virtualCards != null && virtualCards.size() == 1) {
                String str2 = (String) virtualCards.get(0);
                if (str2 != null && str2.equals(str)) {
                    LogX.i("startCUPOperateService, download refid : ");
                    LogX.i(str2, true);
                    CUPOperateServiceManager.startCUPOperateService(this.mContext, CUPCardOperator.OPERATE_EVENT_DOWNLOAD, pushCUPOperateMessage.getSsid(), pushCUPOperateMessage.getSign(), virtualCards);
                    return true;
                }
            }
        }
        LogX.i("query CUP tsmlibdata unstatified!");
        return false;
    }
}
