package com.huawei.nfc.carrera.logic.swipe.channel;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicRescManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p486d.p487a.C5725a;

import java.io.File;

public class RFConfChangeManager {
    public static final int RF_CHANGE_EVENT_TYPE_DEFAULTCARD_CHANGE = 1;
    public static final int RF_CHANGE_EVENT_TYPE_NFC_CONFIG_CHANGE = 2;
    private static final Object SYNC_LOCK = new Object();
    private static final String TAG = "RFConfChangeHandler";
    private static volatile RFConfChangeManager sInstance;
    private CardPicRescManager mCardPicRescManager;
    private Context mContext;
    private int mHandledCardGroupType;
    private String mHandledIssuerId;
    private String mPkg;
    private int mWaitingHandleCardGroupType;
    private String mWaitingHandleIssuerId;
    private WalletTaManager mWalletTaManager;

    private RFConfChangeManager(Context context) {
        if (context == null) {
            context = C5725a.m26393a().m26395b();
        }
        this.mContext = context;
        this.mWalletTaManager = WalletTaManager.getInstance(context);
        this.mCardPicRescManager = CardPicRescManager.getInstance(context);
        this.mPkg = this.mContext.getPackageName();
    }

    public static RFConfChangeManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (SYNC_LOCK) {
                if (sInstance == null) {
                    sInstance = new RFConfChangeManager(context);
                }
            }
        }
        return sInstance;
    }

    public void setDefaultCardRFConf(int i, boolean z) {
        C2538c.b("RFConfChangeHandler changeRFInfo begin eventType : " + i + " forceChange : " + z, new Object[0]);
        if (NfcUtil.isMatchPayCondition(this.mContext)) {
            TACardInfo defaultCard = this.mWalletTaManager.getDefaultCard();
            if (defaultCard == null) {
                C2538c.e("RFConfChangeHandler changeRFInfo failed end. default taCardInfo is null.", new Object[0]);
                return;
            }
            this.mWaitingHandleCardGroupType = defaultCard.getCardGroupType();
            int i2 = this.mWaitingHandleCardGroupType == 1 ? 1 : 0;
            if (z || (i == 2 && i2 == 0)) {
                this.mHandledIssuerId = null;
                this.mHandledCardGroupType = 0;
            }
            this.mWaitingHandleIssuerId = defaultCard.getIssuerId();
            this.mWaitingHandleCardGroupType = defaultCard.getCardGroupType();
            if (this.mWaitingHandleIssuerId.equals(this.mHandledIssuerId) || (this.mWaitingHandleCardGroupType == this.mHandledCardGroupType && i2 != 0)) {
                C2538c.b("RFConfChangeHandler changeRFInfo success end. duplicate set.mWaitingHandleIssuerId : " + this.mWaitingHandleIssuerId + " mHandledIssuerId : " + this.mHandledIssuerId + " mWaitingHandleType : " + defaultCard.getCardGroupType() + " mHandledCardGroupType : " + this.mHandledCardGroupType, new Object[0]);
                return;
            } else if (i2 != 0) {
                C2538c.b("RFConfChangeHandler changeRFInfo end.set default RF conf for bank card.", new Object[0]);
                return;
            } else {
                C2538c.b(TAG, new Object[]{" setDefaultCardRFConf path : " + this.mCardPicRescManager.getCardRFConfFilePath(this.mHandledIssuerId)});
                if (isFileExists(this.mCardPicRescManager.getCardRFConfFilePath(this.mHandledIssuerId))) {
                    C2538c.b("RFConfChangeHandler changeRFInfo end.set RF conf for bus card. IssuerId : " + this.mWaitingHandleIssuerId, new Object[0]);
                    return;
                } else {
                    C2538c.b("RFConfChangeHandler changeRFInfo end.RF conf for IssuerId<" + this.mWaitingHandleIssuerId + "> does not exists", new Object[0]);
                    return;
                }
            }
        }
        C2538c.b("RFConfChangeHandler changeRFInfo failed end.do not match HUAWEI PAY condition.", new Object[0]);
    }

    private boolean isFileExists(String str) {
        return new File(str).exists();
    }
}
