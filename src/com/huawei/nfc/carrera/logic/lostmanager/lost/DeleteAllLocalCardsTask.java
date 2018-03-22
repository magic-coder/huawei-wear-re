package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.CardOperateLogic;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeviceRepairCallback;
import com.huawei.nfc.carrera.logic.lostmanager.report.ReportDeviceStatusTask;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

public class DeleteAllLocalCardsTask extends CUPTsmLibDataWaiter implements Runnable {
    public static final int DELETE_TYPE_LOST = 1;
    public static final int DELETE_TYPE_REPAIR = 0;
    public static final int REPAIR_DEVICE_STATUS_DEL_CARDS = 2;
    public static final int REPAIR_DEVICE_STATUS_ERR = 1;
    private static final String TAG = "DeleteAllLocalCardsTask";
    private final HandleDeviceRepairCallback mCallback;
    private final Context mContext;

    public DeleteAllLocalCardsTask(Context context, int i, HandleDeviceRepairCallback handleDeviceRepairCallback) {
        super(context, CUPCardOperator.OPERATE_EVENT_WIPEOUT);
        this.mContext = context;
        this.mCallback = handleDeviceRepairCallback;
    }

    public void run() {
        boolean z = true;
        List<TACardInfo> cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        String queryCplc = ESEInfoManager.getInstance(this.mContext).queryCplc();
        if (cardList == null || cardList.isEmpty()) {
            LogX.d("dev repair task, but no local card.");
            sendDeviceStatusNormal();
            notifyRepairResult(true);
            return;
        }
        List list = null;
        boolean z2 = true;
        for (TACardInfo tACardInfo : cardList) {
            IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(tACardInfo.issuerId);
            if (cacheIssuerInfoItem == null) {
                LogX.d("clean local card info, no issuer info failed.");
                z2 = false;
            } else {
                boolean z3 = 13 == cacheIssuerInfoItem.getMode() || (11 == cacheIssuerInfoItem.getMode() && !Constant.CITIC_CARD_AID.equals(tACardInfo.getAid()));
                if (z3) {
                    LogX.d("cup card existed, refId: " + tACardInfo.getDpanDigest());
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(tACardInfo);
                } else {
                    z2 = deleteCommonCard(tACardInfo.aid, tACardInfo.dpanDigest, queryCplc, tACardInfo.cardStatus);
                }
            }
        }
        boolean cleanCUPCard;
        if (list != null) {
            LogX.d("===123===设备挂失，且有银行卡，擦除银行卡操作");
            cleanCUPCard = cleanCUPCard(list);
        } else {
            cleanCUPCard = true;
        }
        if (z2 && r0) {
            LogX.d("===123===擦除成功后，上报正确状态");
            sendDeviceStatusNormal();
        }
        if (!(z2 && r0)) {
            z = false;
        }
        notifyRepairResult(z);
    }

    private boolean cleanCUPCard(List<TACardInfo> list) {
        if (!requestSwipeCupCard()) {
            return false;
        }
        CardOperateLogic.getInstance(this.mContext).registerCUPOperationListener(CUPCardOperator.OPERATE_EVENT_WIPEOUT, null, this);
        List arrayList = new ArrayList();
        for (TACardInfo tACardInfo : list) {
            arrayList.add(tACardInfo.dpanDigest);
        }
        C2538c.b(TAG, new Object[]{" cleanCUPCard waitOperationResult "});
        boolean waitOperationResult = waitOperationResult(arrayList);
        CardOperateLogic.getInstance(this.mContext).unregisterCUPOperationListener(CUPCardOperator.OPERATE_EVENT_WIPEOUT, null, this);
        checkAndCleanCupTAData(arrayList);
        return waitOperationResult;
    }

    private boolean requestSwipeCupCard() {
        LogX.i("requestSwipeCupCard   begin");
        WipeAllCUPCardRequest wipeAllCUPCardRequest = new WipeAllCUPCardRequest();
        wipeAllCUPCardRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        wipeAllCUPCardRequest.setRsaKeyIndex(-1);
        wipeAllCUPCardRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        wipeAllCUPCardRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        wipeAllCUPCardRequest.event = WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD;
        CardServerBaseResponse wipeAllCUPCard = ServerServiceFactory.createCardServerApi(this.mContext).wipeAllCUPCard(wipeAllCUPCardRequest);
        if (wipeAllCUPCard == null || wipeAllCUPCard.returnCode != 0) {
            return false;
        }
        LogX.d("requestSwipeCupCard success.");
        return true;
    }

    private void sendDeviceStatusNormal() {
        LogX.d("sendDeviceStatusNormal.");
        new ReportDeviceStatusTask(this.mContext, "0").run();
    }

    private boolean deleteCommonCard(String str, String str2, String str3, int i) {
        boolean z = true;
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(str2, 3);
        } catch (WalletTaCardNotExistException e) {
            LogX.d("checkCardNullifiedStatus, set card nullified in ta failed, WalletTaCardNotExistException");
            z = false;
        } catch (WalletTaSystemErrorException e2) {
            LogX.d("checkCardNullifiedStatus, set card nullified in ta failed, WalletTaSystemErrorException");
            z = false;
        }
        if (z && i != 3) {
            CardInfoManager.getInstance(this.mContext).refreshCardList();
        }
        return new CardNullifiedModifier(str, this.mContext).modifyLocalCardStatus(false);
    }

    private void notifyRepairResult(boolean z) {
        if (this.mCallback != null) {
            this.mCallback.handleDeviceRepairCallback(z);
        }
    }
}
