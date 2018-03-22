package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleServerCardLostMsgCallback;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class HandleServerModifyCardStatusTask implements Runnable {
    private HandleServerCardLostMsgCallback callback;
    private String cplcFromServer;
    private String dpanidFromServer;
    private String mAid;
    private Context mContext;
    private String serverAction;

    public HandleServerModifyCardStatusTask(Context context, String str, String str2, String str3, String str4, HandleServerCardLostMsgCallback handleServerCardLostMsgCallback) {
        this.mContext = context;
        this.mAid = str;
        this.cplcFromServer = str3;
        this.serverAction = str2;
        this.callback = handleServerCardLostMsgCallback;
        this.dpanidFromServer = str4;
    }

    public void run() {
        boolean z = false;
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(this.mAid);
        if (cardInfoByAid == null || !(this.dpanidFromServer == null || this.dpanidFromServer.equals(cardInfoByAid.dpanDigest))) {
            LogX.d("HandleServerModifyCardStatusTask, taCardInfo not existed or dpanid mismatch");
            handleResult(false, this.mAid, this.cplcFromServer);
            return;
        }
        boolean updateCardToNullified;
        if ("5".equals(this.serverAction)) {
            updateCardToNullified = updateCardToNullified(cardInfoByAid.dpanDigest);
            LogX.d("HandleServerModifyCardStatusTask,  isUpdateSuccess = " + updateCardToNullified);
            if (updateCardToNullified && 3 != cardInfoByAid.cardStatus) {
                LogX.d("HandleServerModifyCardStatusTask,  refreshCardList =");
                CardInfoManager.getInstance(this.mContext).refreshCardList();
            }
        }
        IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(cardInfoByAid.issuerId);
        if (cacheIssuerInfoItem == null) {
            LogX.d("HandleServerModifyCardStatusTask, issuer info not existed.");
            handleResult(false, this.mAid, this.cplcFromServer);
            return;
        }
        updateCardToNullified = 13 == cacheIssuerInfoItem.getMode() || (11 == cacheIssuerInfoItem.getMode() && !Constant.CITIC_CARD_AID.equals(cardInfoByAid.getAid()));
        if (updateCardToNullified) {
            LogX.d("HandleServerModifyCardStatusTask, cup card.");
            z = new CUPCardModifier(this.mContext, cardInfoByAid.getDpanDigest(), this.serverAction).modify();
            LogX.d("HandleServerModifyCardStatusTask, isCardLocalModifiedSuccess =" + z);
            if (z) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
            }
            handleResult(z, this.mAid, this.cplcFromServer);
            return;
        }
        CardStatusBaseModifier cardStatusBaseModifier = null;
        LogX.d("HandleServerModifyCardStatusTask, serverAction=" + this.serverAction);
        if ("2".equals(this.serverAction) || "1".equals(this.serverAction)) {
            cardStatusBaseModifier = new CardPauseModifier(this.mAid, this.mContext);
        } else if ("5".equals(this.serverAction)) {
            cardStatusBaseModifier = new CardNullifiedModifier(this.mAid, this.mContext);
        } else if ("00".equals(this.serverAction)) {
            cardStatusBaseModifier = new CardResumeModifier(this.mAid, this.mContext);
        } else {
            LogX.e("unknown server action.");
        }
        if (cardStatusBaseModifier != null) {
            z = cardStatusBaseModifier.modifyLocalCardStatus(false);
        }
        handleResult(z, this.mAid, this.cplcFromServer);
    }

    private boolean updateCardToNullified(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 3);
            return true;
        } catch (WalletTaCardNotExistException e) {
            LogX.d("checkCardNullifiedStatus, set card nullified in ta failed, WalletTaCardNotExistException");
            return false;
        } catch (WalletTaSystemErrorException e2) {
            LogX.d("checkCardNullifiedStatus, set card nullified in ta failed, WalletTaSystemErrorException");
            return false;
        }
    }

    private void handleResult(boolean z, String str, String str2) {
        if (this.callback != null) {
            this.callback.handleServerMsgResult(z, str, str2);
        }
    }
}
