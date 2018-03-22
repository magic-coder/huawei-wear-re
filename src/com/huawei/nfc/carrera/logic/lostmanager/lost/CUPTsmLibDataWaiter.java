package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.lifecycle.cupoperate.CUPOperateServiceManager;
import com.huawei.nfc.carrera.lifecycle.push.data.PushCUPOperateMessage;
import com.huawei.nfc.carrera.lifecycle.push.data.PushMessageParser;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.response.CUPOperationListener;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryAidRequest;
import com.huawei.nfc.carrera.server.card.request.QueryUnionPayPushRequest;
import com.huawei.nfc.carrera.server.card.response.QueryAidResponse;
import com.huawei.nfc.carrera.server.card.response.QueryUnionPayPushResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

public abstract class CUPTsmLibDataWaiter implements CUPOperationListener {
    private static final int FIRST_WAIT_OPERATION_START_TIME_OUT = 6000;
    private static final int OPERATION_FINISHED = 1;
    private static final int OPERATION_NOT_START = -1;
    private static final int OPERATION_STARTED = 0;
    private static final String TAG = "CUPTsmLibDataWaiter";
    private static final int WAITING_TIMES = 6;
    private static final int WAIT_OPERATION_START_TIME_OUT = 3000;
    private static final int WAIT_OPERATION_TIME_OUT = 60000;
    protected final Context mContext;
    private int mOperationResult = -1;
    private int mOperationStatus = -1;
    protected final String mOperationType;

    public CUPTsmLibDataWaiter(Context context, String str) {
        this.mContext = context;
        this.mOperationType = str;
    }

    protected boolean waitOperationResult(List<String> list) {
        C2538c.b(TAG, new Object[]{"enter waitOperationResult  "});
        waitDeleteStarted(list);
        return waitAndHandleDeleteResult(list);
    }

    private synchronized boolean waitAndHandleDeleteResult(List<String> list) {
        boolean z = false;
        synchronized (this) {
            if (-1 != this.mOperationStatus) {
                try {
                    LogX.d("check delete operation result: " + this.mOperationStatus);
                    while (this.mOperationStatus == 0) {
                        wait(FileWatchdog.DEFAULT_DELAY);
                        LogX.d("after wait for a while, the delete operation result: " + this.mOperationStatus);
                        if (this.mOperationResult == 0 || this.mOperationResult == -99) {
                        }
                    }
                } catch (InterruptedException e) {
                    LogX.e("install cup card wait the download result, but interrupted.");
                }
                if (this.mOperationResult == 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    protected boolean checkAndCleanCupTAData(List<String> list) {
        if (list == null || list.size() <= 0) {
            return true;
        }
        boolean z = true;
        for (String str : list) {
            boolean z2;
            if (WalletTaManager.getInstance(this.mContext).getCard(str) != null) {
                QueryAidRequest queryAidRequest = new QueryAidRequest();
                queryAidRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
                queryAidRequest.setRsaKeyIndex(-1);
                queryAidRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
                queryAidRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
                queryAidRequest.cardRefId = str;
                QueryAidResponse queryAidOnCUP = ServerServiceFactory.createCardServerApi(this.mContext).queryAidOnCUP(queryAidRequest);
                if (queryAidOnCUP != null) {
                    LogX.i("QueryAidResponse, resultCode: " + queryAidOnCUP.returnCode);
                    if (queryAidOnCUP.returnCode == -5) {
                        removeTaInfo(str);
                        z2 = z;
                    } else {
                        z2 = false;
                    }
                    z = z2;
                }
            }
            z2 = z;
            z = z2;
        }
        return z;
    }

    protected boolean removeTaInfo(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).removeCard(str);
            return true;
        } catch (WalletTaCardNotExistException e) {
            LogX.e("WalletTaCardNotExistException, mRefID : " + str);
            return true;
        } catch (WalletTaSystemErrorException e2) {
            LogX.e("WalletTaSystemErrorException, mRefID : " + str);
            return false;
        }
    }

    private synchronized void waitDeleteStarted(List<String> list) {
        int i = 0;
        synchronized (this) {
            C2538c.b(TAG, new Object[]{"enter waitDeleteStarted "});
            do {
                if (i == 0) {
                    wait(6000);
                    C2538c.b(TAG, new Object[]{"waitDeleteStarted wait 6s"});
                } else {
                    try {
                        wait(3000);
                        C2538c.b(TAG, new Object[]{"waitDeleteStarted wait 3s"});
                    } catch (InterruptedException e) {
                        C2538c.e(TAG, new Object[]{"wait delete operation time out."});
                    }
                }
                i++;
                if (-1 == this.mOperationStatus) {
                    C2538c.b(TAG, new Object[]{"wait delete operation start, quire tsmlibData"});
                    if (getTsmLibData(list)) {
                        wait(3000);
                    }
                }
                C2538c.b(TAG, new Object[]{"wait delete getTsmLibData end mOperationStatus : " + this.mOperationStatus});
                if (i > 6 || this.mOperationStatus == 0) {
                    C2538c.b(TAG, new Object[]{"wait delete operation start, or timeout."});
                }
            } while (1 != this.mOperationStatus);
            C2538c.b(TAG, new Object[]{"wait delete operation start, or timeout."});
        }
    }

    protected boolean getTsmLibData(List<String> list) {
        QueryUnionPayPushRequest queryUnionPayPushRequest = new QueryUnionPayPushRequest();
        queryUnionPayPushRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        QueryUnionPayPushResponse queryUnionPayPush = ServerServiceFactory.createCardServerApi(this.mContext).queryUnionPayPush(queryUnionPayPushRequest);
        if (queryUnionPayPush != null && queryUnionPayPush.returnCode == 0) {
            String pushMsg = queryUnionPayPush.getPushMsg();
            if (pushMsg != null) {
                Object parsePushMessage = new PushMessageParser().parsePushMessage(pushMsg);
                if (parsePushMessage instanceof PushCUPOperateMessage) {
                    return handlePushMessage((PushCUPOperateMessage) parsePushMessage, list);
                }
            }
        }
        return false;
    }

    private boolean handlePushMessage(PushCUPOperateMessage pushCUPOperateMessage, List<String> list) {
        if (pushCUPOperateMessage.getVirtualCards() != null && this.mOperationType.equals(pushCUPOperateMessage.getEvent()) && (CUPCardOperator.OPERATE_EVENT_WIPEOUT.equals(this.mOperationType) || pushCUPOperateMessage.getVirtualCards().equals(list))) {
            LogX.i("startCUPOperateService, mRefIDs size : " + list.size());
            if (this.mOperationStatus == -1) {
                CUPOperateServiceManager.startCUPOperateService(this.mContext, this.mOperationType, pushCUPOperateMessage.getSsid(), pushCUPOperateMessage.getSign(), pushCUPOperateMessage.getVirtualCards());
            }
            return true;
        }
        LogX.i("query CUP tsmlibdata unstatified!");
        return false;
    }

    public void operateStart() {
        LogX.d("operateStart now.");
        synchronized (this) {
            this.mOperationStatus = 0;
            notifyAll();
        }
    }

    public void operateFinished(int i) {
        LogX.d("operateFinished result: " + i);
        synchronized (this) {
            this.mOperationStatus = 1;
            this.mOperationResult = i;
            notifyAll();
        }
    }
}
