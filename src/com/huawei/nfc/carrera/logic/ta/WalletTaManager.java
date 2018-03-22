package com.huawei.nfc.carrera.logic.ta;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardOrderInfoItem;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaAccountNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaBadParammeterException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardAlreadyExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNumReachMaxException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaDefaultCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaFingerIdMismatchException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaFingerIdNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class WalletTaManager {
    public static final int NOTIFICATION_CARD_EVENT_ACTIVTE = 4;
    public static final int NOTIFICATION_CARD_EVENT_BUS_TOP_UP = 1;
    public static final int NOTIFICATION_CARD_EVENT_DEFAULT = 0;
    public static final int NOTIFICATION_CARD_EVENT_END_LOCK = 3;
    public static final int NOTIFICATION_CARD_EVENT_START_LOCK = 2;
    private static final int OPEN_CARD_NUMBER_LIMIT = 8;
    private static final String TAG = "WalletTaManager";
    private static ArrayList<TACardInfo> cardInfoListCache = null;
    private static final Object cardInfoListLock = new Object();
    private static volatile WalletTaManager instance;
    private static PluginPayAdapter pluginPayAdapter = null;
    private CardInfoDBManager dbManager;
    private Context mContext;
    long timeStamp = System.currentTimeMillis();

    private WalletTaManager(Context context) {
        C2538c.b(TAG, new Object[]{"WalletTaManager enter"});
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        this.dbManager = new CardInfoDBManager(this.mContext);
        synchronized (cardInfoListLock) {
            try {
                cardInfoListCache = getCardListFromTa();
            } catch (WalletTaException e) {
                LogX.e("cardInfoListCache init, getCardListFromTa failed, errorCode = " + e.getCode());
            }
        }
    }

    private void setNewTimeStamp(String str, long j) {
        CardOrderInfoItem cardOrderInfoItem = new CardOrderInfoItem(str, j);
        List arrayList = new ArrayList();
        arrayList.add(cardOrderInfoItem);
        this.dbManager.insertOrUpdateCardOrderInfos(arrayList);
    }

    private void deleteCardFromDB(String str) {
        this.dbManager.deleteCardOrderItem(str);
    }

    public static WalletTaManager getInstance(Context context) {
        WalletTaManager walletTaManager;
        try {
            pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(context).getAdapter();
        } catch (ClassCastException e) {
            C2538c.e(TAG, new Object[]{"ClassCastException() e = " + e.getMessage()});
        }
        C2538c.b(TAG, new Object[]{"WalletTaManager getInstance ,pluginPayAdapter=" + pluginPayAdapter + ",instance=" + instance});
        synchronized (cardInfoListLock) {
            if (instance == null) {
                instance = new WalletTaManager(context);
            }
            walletTaManager = instance;
        }
        return walletTaManager;
    }

    public void setFingerId(int i) throws WalletTaSystemErrorException {
    }

    public int getFingerId() throws WalletTaFingerIdNotExistException, WalletTaSystemErrorException {
        return -1;
    }

    public void removeFingerId() throws WalletTaSystemErrorException {
    }

    public void setDefaultCard(String str) throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        TACardInfo cardFromCardListCache;
        removeDefaultCard();
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null) {
                cardInfoListCache = getCardListFromTa();
            }
            cardFromCardListCache = getCardFromCardListCache(str);
            if (cardFromCardListCache == null) {
                LogX.i("setDefaultCard failed, card is not exsit");
                throw new WalletTaException().newWalletTaCardNotExistException();
            } else {
                updateCardDefault(str, true);
            }
        }
        cardFromCardListCache.isDefaultCard = true;
        this.dbManager.updateDefalutCardOrderInfo(cardFromCardListCache.dpanDigest);
    }

    private void removeDefaultCard() throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        TACardInfo defaulBusCard = getDefaulBusCard();
        if (defaulBusCard != null) {
            updateCardDefault(defaulBusCard.dpanDigest, false);
        } else {
            LogX.i("no defaultCard");
        }
    }

    public TACardInfo getDefaultCard() {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null || cardInfoListCache.isEmpty()) {
                LogX.i("getDefaultCard failed, default card not exist");
                return null;
            }
            Iterator it = cardInfoListCache.iterator();
            while (it.hasNext()) {
                TACardInfo tACardInfo = (TACardInfo) it.next();
                if (tACardInfo.isDefaultCard) {
                    tACardInfo = tACardInfo.clone();
                    return tACardInfo;
                }
            }
            LogX.i("getDefaultCard failed, default card not exist");
            return null;
        }
    }

    public TACardInfo getDefaulBusCard() {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null || cardInfoListCache.isEmpty()) {
                LogX.i("getDefaultCard failed, default card not exist");
                return null;
            }
            Iterator it = cardInfoListCache.iterator();
            while (it.hasNext()) {
                TACardInfo tACardInfo = (TACardInfo) it.next();
                if (tACardInfo.isDefaultCard && 2 == tACardInfo.cardGroupType) {
                    tACardInfo = tACardInfo.clone();
                    return tACardInfo;
                }
            }
            LogX.i("getDefaultCard failed, default card not exist");
            return null;
        }
    }

    public void activateCardByFpPwd(int i) throws WalletTaFingerIdMismatchException, WalletTaSystemErrorException, WalletTaDefaultCardNotExistException, WalletTaCardNotExistException {
    }

    public void activateCardByPayPwd(int i) throws WalletTaSystemErrorException, WalletTaDefaultCardNotExistException, WalletTaCardNotExistException {
    }

    public void deactivateCard(int i) throws WalletTaSystemErrorException {
    }

    public void setUserAccount(String str) throws WalletTaSystemErrorException {
    }

    public boolean checkUserAccount(String str) throws WalletTaAccountNotExistException, WalletTaSystemErrorException {
        return false;
    }

    public void removeUserAccount() throws WalletTaSystemErrorException {
    }

    public boolean updateTaCardInfoForCUP(String str, String str2, int i) {
        synchronized (cardInfoListLock) {
            TACardInfo card = getCard(str);
            if (card == null) {
                LogX.w("updateCardForCUP target card does not exists.");
                return false;
            }
            try {
                removeCard(str);
                boolean z = true;
            } catch (Throwable e) {
                LogX.e("updateCardForCUP remove card exception: " + Log.getStackTraceString(e));
                z = false;
            } catch (Throwable e2) {
                LogX.e("updateCardForCUP remove card exception: " + Log.getStackTraceString(e2));
                z = false;
            }
            if (z) {
                card.aid = str2;
                card.cardStatus = i;
                try {
                    addCard(card);
                    return true;
                } catch (Throwable e3) {
                    LogX.e("updateCardForCUP add card exception: " + Log.getStackTraceString(e3));
                    return false;
                } catch (Throwable e32) {
                    LogX.e("updateCardForCUP add card exception: " + Log.getStackTraceString(e32));
                    return false;
                } catch (Throwable e322) {
                    LogX.e("updateCardForCUP add card exception: " + Log.getStackTraceString(e322));
                    return false;
                } catch (Throwable e3222) {
                    LogX.e("updateCardForCUP add card exception: " + Log.getStackTraceString(e3222));
                    return false;
                }
            }
        }
    }

    public void addCard(TACardInfo tACardInfo) throws WalletTaCardAlreadyExistException, WalletTaCardNumReachMaxException, WalletTaBadParammeterException, WalletTaSystemErrorException {
        if (tACardInfo == null || tACardInfo.aid == null || tACardInfo.getTaCardInfoJsonStr() == null) {
            LogX.i("addCard failed, bad parameter");
            throw new WalletTaException().newWalletTaBadParammeterException();
        }
        tACardInfo.statusUpdateTime = System.currentTimeMillis();
        String taCardInfoJsonStr = tACardInfo.getTaCardInfoJsonStr();
        boolean z = false;
        if (pluginPayAdapter != null) {
            z = pluginPayAdapter.addCard2Watch(taCardInfoJsonStr);
        }
        if (z) {
            setNewTimeStamp(tACardInfo.dpanDigest, tACardInfo.statusUpdateTime);
            synchronized (cardInfoListLock) {
                if (cardInfoListCache == null) {
                    cardInfoListCache = getCardListFromTa();
                } else {
                    cardInfoListCache.add(tACardInfo);
                }
            }
        } else if (checkAvaiableCard() >= 8) {
            throw new WalletTaException().newWalletTaCardNumReachMaxException();
        } else if (isCardAdded(tACardInfo.fpanDigest)) {
            throw new WalletTaException().newWalletTaCardAlreadyExistException();
        } else {
            throw new WalletTaException().newWalletTaBadParammeterException();
        }
    }

    private int checkAvaiableCard() {
        ArrayList cardList = getCardList();
        if (cardList == null || cardList.size() == 0) {
            return 0;
        }
        Iterator it = cardList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            TACardInfo tACardInfo = (TACardInfo) it.next();
            if (tACardInfo.cardStatus == 3 || tACardInfo.cardStatus == 0) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        return i;
    }

    private boolean isCardAdded(String str) {
        TACardInfo card = getInstance(this.mContext).getCard(str);
        if (card == null || (2 != card.cardStatus && 1 != card.cardStatus)) {
            return false;
        }
        return true;
    }

    public void updateCardStatus(String str, int i) throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null) {
                cardInfoListCache = getCardListFromTa();
            }
            TACardInfo cardFromCardListCache = getCardFromCardListCache(str);
            if (cardFromCardListCache == null) {
                LogX.i("updateCardStatus failed, card is not exsit");
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
            TACardInfo clone = cardFromCardListCache.clone();
            clone.cardStatus = i;
            long currentTimeMillis = System.currentTimeMillis();
            clone.statusUpdateTime = currentTimeMillis;
            boolean z = false;
            if (pluginPayAdapter != null) {
                z = pluginPayAdapter.updateCardInfo(clone.getTaCardInfoJsonStr());
            }
            if (z) {
                cardFromCardListCache.cardStatus = i;
                cardFromCardListCache.statusUpdateTime = currentTimeMillis;
            } else {
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
        }
    }

    public void updateCardName(String str, String str2) throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null) {
                cardInfoListCache = getCardListFromTa();
            }
            TACardInfo cardFromCardListCache = getCardFromCardListCache(str);
            if (cardFromCardListCache == null) {
                LogX.i("updateCardStatus failed, card is not exsit");
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
            TACardInfo clone = cardFromCardListCache.clone();
            clone.name = str2;
            long currentTimeMillis = System.currentTimeMillis();
            clone.statusUpdateTime = currentTimeMillis;
            if (pluginPayAdapter == null || pluginPayAdapter.updateCardInfo(clone.getTaCardInfoJsonStr())) {
                cardFromCardListCache.name = str2;
                cardFromCardListCache.statusUpdateTime = currentTimeMillis;
            } else {
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
        }
    }

    public void updateCardDefault(String str, boolean z) throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        LogX.i("updateCardDefault ,referenceId=" + str);
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null) {
                cardInfoListCache = getCardListFromTa();
            }
            TACardInfo cardFromCardListCache = getCardFromCardListCache(str);
            if (cardFromCardListCache == null) {
                LogX.i("updateCardDefault failed, card is not exsit");
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
            TACardInfo clone = cardFromCardListCache.clone();
            clone.isDefaultCard = z;
            long currentTimeMillis = System.currentTimeMillis();
            clone.statusUpdateTime = currentTimeMillis;
            if (pluginPayAdapter == null || pluginPayAdapter.updateCardInfo(clone.getTaCardInfoJsonStr())) {
                cardFromCardListCache.isDefaultCard = z;
                cardFromCardListCache.statusUpdateTime = currentTimeMillis;
            } else {
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
        }
    }

    public void updateCardTimeStamp(String str, long j) throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null) {
                cardInfoListCache = getCardListFromTa();
            }
            TACardInfo cardFromCardListCache = getCardFromCardListCache(str);
            if (cardFromCardListCache == null) {
                LogX.i("updateCardTimeStamp failed, card is not exsit");
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
            TACardInfo clone = cardFromCardListCache.clone();
            clone.statusUpdateTime = j;
            boolean z = false;
            if (pluginPayAdapter != null) {
                z = pluginPayAdapter.updateCardInfo(clone.getTaCardInfoJsonStr());
            }
            if (z) {
                cardFromCardListCache.statusUpdateTime = j;
            } else {
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
        }
    }

    public void removeCard(String str) throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null) {
                cardInfoListCache = getCardListFromTa();
            }
            TACardInfo cardFromCardListCache = getCardFromCardListCache(str);
            if (cardFromCardListCache == null) {
                LogX.i("removeCard failed, card is not exsit");
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
            boolean z = false;
            if (pluginPayAdapter != null) {
                z = pluginPayAdapter.deleteCard(cardFromCardListCache.getTaCardInfoJsonStr());
            }
            if (z) {
                deleteCardFromDB(str);
                Iterator it = cardInfoListCache.iterator();
                while (it.hasNext()) {
                    TACardInfo tACardInfo = (TACardInfo) it.next();
                    if (tACardInfo.cardGroupType == cardFromCardListCache.cardGroupType && tACardInfo.dpanDigest.equals(cardFromCardListCache.dpanDigest)) {
                        cardInfoListCache.remove(tACardInfo);
                        return;
                    }
                }
                return;
            }
            LogX.i("deleteCard failed");
            throw new WalletTaException().newWalletTaCardNotExistException();
        }
    }

    public void removeCardByAid(String str) throws WalletTaCardNotExistException, WalletTaSystemErrorException {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null) {
                cardInfoListCache = getCardListFromTa();
            }
            TACardInfo tACardInfo = null;
            Iterator it = cardInfoListCache.iterator();
            while (it.hasNext()) {
                TACardInfo tACardInfo2 = (TACardInfo) it.next();
                if (!tACardInfo2.aid.equals(str)) {
                    tACardInfo2 = tACardInfo;
                }
                tACardInfo = tACardInfo2;
            }
            if (tACardInfo == null) {
                LogX.i("removeCardByAid failed, card is not exsit");
                throw new WalletTaException().newWalletTaCardNotExistException();
            }
            boolean z = false;
            if (pluginPayAdapter != null) {
                z = pluginPayAdapter.deleteCard(tACardInfo.getTaCardInfoJsonStr());
            }
            if (z) {
                it = cardInfoListCache.iterator();
                while (it.hasNext()) {
                    tACardInfo2 = (TACardInfo) it.next();
                    if (tACardInfo2.cardGroupType == tACardInfo.cardGroupType && tACardInfo2.aid.equals(tACardInfo.aid)) {
                        cardInfoListCache.remove(tACardInfo2);
                        return;
                    }
                }
                return;
            }
            LogX.i("removeCardByAid failed");
            throw new WalletTaException().newWalletTaCardNotExistException();
        }
    }

    public TACardInfo getCard(String str) {
        TACardInfo tACardInfo = null;
        synchronized (cardInfoListLock) {
            C2538c.b(TAG, new Object[]{"getCard(),referenceId=" + str});
            if (cardInfoListCache == null || cardInfoListCache.isEmpty()) {
            } else {
                TACardInfo cardFromCardListCache = getCardFromCardListCache(str);
                if (cardFromCardListCache == null) {
                } else {
                    tACardInfo = cardFromCardListCache.clone();
                }
            }
        }
        return tACardInfo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.nfc.carrera.logic.ta.TACardInfo getCardInfoByAid(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        r0 = "WalletTaManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "getCardInfoByAid(),aid=";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r2[r3] = r4;
        com.huawei.v.c.b(r0, r2);
        r2 = cardInfoListLock;
        monitor-enter(r2);
        r0 = cardInfoListCache;	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x002e;
    L_0x0026:
        r0 = cardInfoListCache;	 Catch:{ all -> 0x0051 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x0031;
    L_0x002e:
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        r0 = r1;
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = cardInfoListCache;	 Catch:{ all -> 0x0051 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0051 }
    L_0x0037:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x0054;
    L_0x003d:
        r0 = r3.next();	 Catch:{ all -> 0x0051 }
        r0 = (com.huawei.nfc.carrera.logic.ta.TACardInfo) r0;	 Catch:{ all -> 0x0051 }
        r4 = r0.aid;	 Catch:{ all -> 0x0051 }
        r4 = r4.equals(r7);	 Catch:{ all -> 0x0051 }
        if (r4 == 0) goto L_0x0037;
    L_0x004b:
        r0 = r0.clone();	 Catch:{ all -> 0x0051 }
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        goto L_0x0030;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        throw r0;
    L_0x0054:
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        r0 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.logic.ta.WalletTaManager.getCardInfoByAid(java.lang.String):com.huawei.nfc.carrera.logic.ta.TACardInfo");
    }

    public ArrayList<TACardInfo> getCardList() {
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null || cardInfoListCache.isEmpty()) {
                return null;
            }
            ArrayList<TACardInfo> arrayList = new ArrayList();
            Iterator it = cardInfoListCache.iterator();
            while (it.hasNext()) {
                arrayList.add(((TACardInfo) it.next()).clone());
            }
            return arrayList;
        }
    }

    private ArrayList<TACardInfo> getCardListFromTa() throws WalletTaSystemErrorException {
        C2538c.b(TAG, new Object[]{"getCardListFromTa enter"});
        ArrayList<TACardInfo> arrayList = new ArrayList();
        if (pluginPayAdapter != null) {
            List<String> obtainCardList = pluginPayAdapter.obtainCardList();
            if (obtainCardList != null && obtainCardList.size() > 0) {
                for (String str : obtainCardList) {
                    C2538c.b(TAG, new Object[]{"cardInfoStr = " + str});
                    TACardInfo tACardInfo = new TACardInfo(str);
                    handleTACardInfoUpdate(tACardInfo);
                    arrayList.add(tACardInfo);
                }
            }
        } else {
            C2538c.e(TAG, new Object[]{"pluginPayAdapter is null"});
        }
        C2538c.b(TAG, new Object[]{"getCardListFromTa end.cardList.size()=" + arrayList.size()});
        return arrayList;
    }

    private void handleTACardInfoUpdate(TACardInfo tACardInfo) throws WalletTaSystemErrorException {
        if (!Constant.CITIC_CARD_AID.equals(tACardInfo.aid)) {
            LogX.d("handleTACardInfoUpdate, not citic card, no need to upgrade.");
        } else if (StringUtil.isEmpty(tACardInfo.productId, true)) {
            LogX.i("upgrade citic ta info now.");
            tACardInfo.cardType = 3;
            tACardInfo.productId = Constant.ZX_PRODUCT_ID;
            tACardInfo.issuerId = Constant.CITIC_ISSUER_ID;
        } else {
            LogX.d("handleTACardInfoUpdate, productId existed, no need to upgrade.");
        }
    }

    private TACardInfo getCardFromCardListCache(String str) {
        if (cardInfoListCache != null) {
            Iterator it = cardInfoListCache.iterator();
            while (it.hasNext()) {
                TACardInfo tACardInfo = (TACardInfo) it.next();
                if (!StringUtil.isEmpty(tACardInfo.dpanDigest, true) && tACardInfo.dpanDigest.equals(str)) {
                    return tACardInfo;
                }
            }
        }
        return null;
    }

    public void addESELockTimes() throws WalletTaSystemErrorException {
    }

    public void cardEvent(String str, int i) {
        if (pluginPayAdapter != null) {
            pluginPayAdapter.cardEvent(str, i);
        }
    }

    public void activteCardEvent(String str) {
        C2538c.b(TAG, new Object[]{"activteCardEvent.refId." + str});
        cardEvent(str, 4);
    }

    public void lockCardEvent(String str) {
        C2538c.b(TAG, new Object[]{"lockCardEvent.refId." + str});
        cardEvent(str, 2);
    }

    public void unLockCardEvent(String str) {
        C2538c.b(TAG, new Object[]{"lockCardEvent.refId." + str});
        cardEvent(str, 3);
    }

    public static void destroy() {
        C2538c.b(TAG, new Object[]{"destroy"});
        instance = null;
    }

    public void updateCardRFFileName(TACardInfo tACardInfo) {
        C2538c.b(TAG, new Object[]{"updateCardRFFileName(),enter"});
        if (tACardInfo != null) {
            String taCardInfoJsonStr = tACardInfo.getTaCardInfoJsonStr();
            if (pluginPayAdapter != null) {
                pluginPayAdapter.updateCardInfo(taCardInfoJsonStr);
            }
        }
    }

    public boolean updateCardInfo(TACardInfo tACardInfo) {
        synchronized (cardInfoListLock) {
            C2538c.b(TAG, new Object[]{"updateCardInfo(),enter"});
            if (tACardInfo == null) {
                return false;
            }
            TACardInfo cardFromCardListCache = getCardFromCardListCache(tACardInfo.getDpanDigest());
            if (cardFromCardListCache == null) {
                LogX.i("updateCardDefault failed, card is not exsit");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            tACardInfo.statusUpdateTime = currentTimeMillis;
            if (pluginPayAdapter == null || pluginPayAdapter.updateCardInfo(tACardInfo.getTaCardInfoJsonStr())) {
                cardFromCardListCache.aid = tACardInfo.aid;
                cardFromCardListCache.cardGroupType = tACardInfo.cardGroupType;
                cardFromCardListCache.cardStatus = tACardInfo.cardStatus;
                cardFromCardListCache.cardType = tACardInfo.cardType;
                cardFromCardListCache.dpanDigest = tACardInfo.dpanDigest;
                cardFromCardListCache.dpanFour = tACardInfo.dpanFour;
                cardFromCardListCache.fpanDigest = tACardInfo.fpanDigest;
                cardFromCardListCache.fpanFour = tACardInfo.fpanFour;
                cardFromCardListCache.isDefaultCard = tACardInfo.isDefaultCard;
                cardFromCardListCache.issuerId = tACardInfo.issuerId;
                cardFromCardListCache.productId = tACardInfo.productId;
                cardFromCardListCache.Rf_file_name = tACardInfo.Rf_file_name;
                cardFromCardListCache.background_file_name = tACardInfo.background_file_name;
                cardFromCardListCache.statusUpdateTime = currentTimeMillis;
                cardFromCardListCache.name = tACardInfo.getName();
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.nfc.carrera.logic.ta.TACardInfo getCardInfoByIssuerId(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        r0 = "WalletTaManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "getCardInfoByIssuerId(),issuerId=";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r4 = r4.toString();
        r2[r3] = r4;
        com.huawei.v.c.b(r0, r2);
        r2 = cardInfoListLock;
        monitor-enter(r2);
        r0 = cardInfoListCache;	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x002e;
    L_0x0026:
        r0 = cardInfoListCache;	 Catch:{ all -> 0x0051 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x0031;
    L_0x002e:
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        r0 = r1;
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = cardInfoListCache;	 Catch:{ all -> 0x0051 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0051 }
    L_0x0037:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0051 }
        if (r0 == 0) goto L_0x0054;
    L_0x003d:
        r0 = r3.next();	 Catch:{ all -> 0x0051 }
        r0 = (com.huawei.nfc.carrera.logic.ta.TACardInfo) r0;	 Catch:{ all -> 0x0051 }
        r4 = r0.issuerId;	 Catch:{ all -> 0x0051 }
        r4 = r4.equals(r7);	 Catch:{ all -> 0x0051 }
        if (r4 == 0) goto L_0x0037;
    L_0x004b:
        r0 = r0.clone();	 Catch:{ all -> 0x0051 }
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        goto L_0x0030;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        throw r0;
    L_0x0054:
        monitor-exit(r2);	 Catch:{ all -> 0x0051 }
        r0 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.logic.ta.WalletTaManager.getCardInfoByIssuerId(java.lang.String):com.huawei.nfc.carrera.logic.ta.TACardInfo");
    }

    public String getCardproductIdByIssuerId(String str) {
        String str2;
        C2538c.b(TAG, new Object[]{"getCardproductIdByIssuerId(),issuerId=" + str});
        synchronized (cardInfoListLock) {
            if (cardInfoListCache == null || cardInfoListCache.isEmpty()) {
                str2 = "";
            } else {
                Iterator it = cardInfoListCache.iterator();
                while (it.hasNext()) {
                    TACardInfo tACardInfo = (TACardInfo) it.next();
                    if (!StringUtil.isEmpty(tACardInfo.issuerId, true) && tACardInfo.issuerId.equals(str)) {
                        str2 = tACardInfo.getProductId();
                        break;
                    }
                }
                str2 = "";
            }
        }
        return str2;
    }
}
