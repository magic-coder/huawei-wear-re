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
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeleteLocalCardsCallback;
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

public class CleanAllLocalBankCardsTask extends CUPTsmLibDataWaiter implements Runnable {
    private static final String TAG = "CleanAllLocalBankCardsTask";
    private final HandleDeleteLocalCardsCallback mCallback;
    private final Context mContext;

    public CleanAllLocalBankCardsTask(Context context, HandleDeleteLocalCardsCallback handleDeleteLocalCardsCallback) {
        super(context, CUPCardOperator.OPERATE_EVENT_WIPEOUT);
        this.mContext = context;
        this.mCallback = handleDeleteLocalCardsCallback;
    }

    public void run() {
        boolean z = true;
        LogX.i("CleanAllLocalCardsTask run");
        List<TACardInfo> cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        String queryCplc = ESEInfoManager.getInstance(this.mContext).queryCplc();
        if (cardList == null || cardList.isEmpty()) {
            LogX.d("delete all bank card task, but no local card.");
            notifyDeleteResult(true);
            return;
        }
        boolean z2;
        List list = null;
        boolean z3 = false;
        boolean z4 = true;
        for (TACardInfo tACardInfo : cardList) {
            if (tACardInfo.cardGroupType == 2) {
                LogX.d("DeleteAllLocalBankCardsTask, bus card no need to handle");
            } else {
                IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(tACardInfo.issuerId);
                if (cacheIssuerInfoItem == null) {
                    LogX.d("clean local card info, no issuer info failed.");
                    z4 = false;
                } else {
                    boolean z5 = 13 == cacheIssuerInfoItem.getMode() || (11 == cacheIssuerInfoItem.getMode() && !Constant.CITIC_CARD_AID.equals(tACardInfo.getAid()));
                    if (z5) {
                        List arrayList;
                        LogX.d("cup card existed, refId: " + tACardInfo.getDpanDigest());
                        if (list == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = list;
                        }
                        arrayList.add(tACardInfo);
                        list = arrayList;
                    } else {
                        if (11 == cacheIssuerInfoItem.getMode() || 12 == cacheIssuerInfoItem.getMode()) {
                            z3 = true;
                        }
                        if (deleteCommonCard(tACardInfo.getAid(), tACardInfo.getDpanDigest(), queryCplc, tACardInfo.getCardStatus(), z3)) {
                            z2 = z4;
                        } else {
                            z2 = false;
                        }
                        z4 = z2;
                    }
                }
            }
        }
        if (list != null) {
            LogX.d("===123===发起擦除银行卡 ");
            z2 = cleanCUPCard(list);
        } else {
            z2 = true;
        }
        LogX.i("deleteLocalCards run isCleanLocalCardSuccess : " + z4 + " ; cleanCUPCardResult : " + z2);
        if (!(z4 && z2)) {
            z = false;
        }
        notifyDeleteResult(z);
    }

    private boolean cleanCUPCard(List<TACardInfo> list) {
        boolean waitOperationResult;
        boolean checkAndCleanCupTAData;
        if (requestSwipeCupCard()) {
            CardOperateLogic.getInstance(this.mContext).registerCUPOperationListener(CUPCardOperator.OPERATE_EVENT_WIPEOUT, null, this);
            List arrayList = new ArrayList();
            for (TACardInfo tACardInfo : list) {
                arrayList.add(tACardInfo.dpanDigest);
            }
            C2538c.b(TAG, new Object[]{" cleanCUPCard waitOperationResult "});
            waitOperationResult = waitOperationResult(arrayList);
            CardOperateLogic.getInstance(this.mContext).unregisterCUPOperationListener(CUPCardOperator.OPERATE_EVENT_WIPEOUT, null, this);
            checkAndCleanCupTAData = checkAndCleanCupTAData(arrayList);
        } else {
            checkAndCleanCupTAData = false;
            waitOperationResult = false;
        }
        LogX.d("cleanCUPCard result  " + waitOperationResult + " ; remove : " + checkAndCleanCupTAData);
        if (waitOperationResult && checkAndCleanCupTAData) {
            return true;
        }
        return false;
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

    private boolean deleteCommonCard(String str, String str2, String str3, int i, boolean z) {
        Object obj = 1;
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(str2, 3);
        } catch (WalletTaCardNotExistException e) {
            LogX.d("checkCardNullifiedStatus, set card nullified in ta failed, WalletTaCardNotExistException");
            obj = null;
        } catch (WalletTaSystemErrorException e2) {
            LogX.d("checkCardNullifiedStatus, set card nullified in ta failed, WalletTaSystemErrorException");
            obj = null;
        }
        if (!(obj == null || i == 3)) {
            CardInfoManager.getInstance(this.mContext).refreshCardList();
        }
        return new CardNullifiedModifier(str, this.mContext).modifyLocalCardStatus(z);
    }

    private void notifyDeleteResult(boolean z) {
        LogX.i("notifyDeleteResult isSuccess" + z);
        if (this.mCallback != null) {
            this.mCallback.handleDeletelocalcardCallback(z);
        }
    }
}
