package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.nfc.carrera.logic.CardInfoManagerApi;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryPayableCardCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportBankInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportedTrafficCardListCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SyncInfosFromServerCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.UpdateCardTimeStampCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicRescManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardOrderInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.ui.carddisplay.CardListInfoListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class CardInfoManager implements CardInfoManagerApi {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static CardInfoManager instance;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(1);
    private final CardInfoDBManager cardDBManager;
    private final CardPicRescManager cardPicRescManager;
    private final CardListsLoader listsLoader;
    private Context mContext;
    private final SyncInfosFromServerCallback mSyncInfoCallback = new C55321();
    private final CardInfoRefresher refresher;
    private final Handler syncInfoHandler;
    private final SyncInfosFromServerTask syncInfoTask;

    class C55321 implements SyncInfosFromServerCallback {
        C55321() {
        }

        public void syncIssuerInfosFromServerResult(List<IssuerInfoItem> list) {
            int size = list.size();
            if (size > 0) {
                LogX.i("syncIssuerInfosFromServerResult remove the old logo. sz : " + size);
                for (IssuerInfoItem issuerId : list) {
                    CardInfoManager.this.cardPicRescManager.removeLogo(issuerId.getIssuerId());
                }
                CardInfoManager.this.listsLoader.loadCardLists();
            }
        }

        public void syncCardProductInfosFromServerResult(List<CardProductInfoItem> list) {
            int size = list.size();
            if (size > 0) {
                LogX.i("syncCardProductInfosFromServerResult remove the old icon. sz : " + size);
                for (CardProductInfoItem productId : list) {
                    CardInfoManager.this.cardPicRescManager.removeCardIcon(productId.getProductId());
                }
                CardInfoManager.this.listsLoader.loadCardLists();
            }
        }
    }

    private CardInfoManager(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        this.refresher = new CardInfoRefresher(this.mContext.getMainLooper());
        this.cardDBManager = new CardInfoDBManager(this.mContext);
        this.cardPicRescManager = CardPicRescManager.getInstance(context);
        HandlerThread handlerThread = new HandlerThread("CardListsLoader");
        handlerThread.start();
        this.listsLoader = new CardListsLoader(this.mContext, handlerThread.getLooper(), this.refresher);
        handlerThread = new HandlerThread("LocalInfoSyncer");
        handlerThread.start();
        this.syncInfoHandler = new Handler(handlerThread.getLooper());
        this.syncInfoTask = new SyncInfosFromServerTask(this.mContext, this.mSyncInfoCallback);
    }

    public static CardInfoManager getInstance(Context context) {
        CardInfoManager cardInfoManager;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new CardInfoManager(context);
            }
            cardInfoManager = instance;
        }
        return cardInfoManager;
    }

    public void registerCardListListener(CardListInfoListener cardListInfoListener) {
        this.refresher.addCardListInfoListener(cardListInfoListener);
    }

    public void unregisterCardListListener(CardListInfoListener cardListInfoListener) {
        this.refresher.removeCardListInfoListener(cardListInfoListener);
    }

    void cardListLoaded(List<UniCardInfo> list) {
        this.refresher.cardListRefreshed(list);
        CardLostManager.getInstance(this.mContext).checkCardStatusWaitingReport();
    }

    public void refreshCardList() {
        LogX.i("refreshCardList now");
        this.listsLoader.loadCardLists();
        this.listsLoader.refreshRFConfs(false);
        this.syncInfoHandler.post(this.syncInfoTask);
    }

    public void setCardDefault(final String str, final SetCardDefaultCallback setCardDefaultCallback) {
        LogX.i("setCardDefault now, refId: " + str);
        if (setCardDefaultCallback == null) {
            LogX.e("setCardDefault, callback is illegal.");
        } else if (StringUtil.isEmpty(str, true)) {
            LogX.e("setCardDefault, but refId is illegal.");
            setCardDefaultCallback.setResultCallback(-1);
        } else {
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        WalletTaManager.getInstance(CardInfoManager.this.mContext).setDefaultCard(str);
                        CardInfoManager.this.setCardDefaultCallback(setCardDefaultCallback, true);
                        LogX.e("setCardDefaultCallback  true");
                    } catch (WalletTaCardNotExistException e) {
                        LogX.e("setCardDefaultCallback  WalletTaCardNotExistException");
                        CardInfoManager.this.setCardDefaultCallback(setCardDefaultCallback, false);
                    } catch (WalletTaSystemErrorException e2) {
                        LogX.e("setCardDefaultCallback  WalletTaSystemErrorException");
                        CardInfoManager.this.setCardDefaultCallback(setCardDefaultCallback, false);
                    }
                }
            });
        }
    }

    void setCardDefaultCallback(SetCardDefaultCallback setCardDefaultCallback, boolean z) {
        this.refresher.post(new SetDefaultCardCallbackTask(setCardDefaultCallback, z));
    }

    public void querySupportNFCBankInfos(QuerySupportBankInfoCallback querySupportBankInfoCallback) {
        if (querySupportBankInfoCallback == null) {
            LogX.e("querySupportNFCBankInfos, callback is illegal.");
        } else {
            this.listsLoader.querySupportNFCBankInfos(querySupportBankInfoCallback);
        }
    }

    public void querySupportedTrafficCardList(QuerySupportedTrafficCardListCallback querySupportedTrafficCardListCallback) {
        if (querySupportedTrafficCardListCallback == null) {
            LogX.e("querySupportedTrafficCardList, but callback is illegal.");
        } else {
            this.listsLoader.querySupportTrafficCardList(querySupportedTrafficCardListCallback);
        }
    }

    public int checkAvaiableCard() {
        ArrayList cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (cardList == null || cardList.size() == 0) {
            return 0;
        }
        Iterator it = cardList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            TACardInfo tACardInfo = (TACardInfo) it.next();
            if (tACardInfo.getCardStatus() == 3 || tACardInfo.getCardStatus() == 0) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        return i;
    }

    public boolean isExsitGroupTypeCard(int i) {
        List<TACardInfo> cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (cardList == null || cardList.isEmpty()) {
            LogX.i("isExsitGroupTypeCard but the crad list from ta is null");
            return false;
        }
        for (TACardInfo cardGroupType : cardList) {
            if (cardGroupType.getCardGroupType() == i) {
                return true;
            }
        }
        return false;
    }

    public void updateTACardTimeStamp(String str, UpdateCardTimeStampCallback updateCardTimeStampCallback, long j) {
        LogX.i("setCardDefault now, referenceId: " + str);
        if (updateCardTimeStampCallback == null) {
            LogX.e("setCardDefault, callback is illegal.");
            return;
        }
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("setCardDefault, but refId is illegal.");
        }
        this.listsLoader.updateCardTimeStamp(str, j, updateCardTimeStampCallback);
    }

    public void queryPayableCardInfos(QueryPayableCardCallback queryPayableCardCallback) {
        if (queryPayableCardCallback == null) {
            LogX.e("queryPayableCardInfos, callback is illegal.");
        }
    }

    public Bitmap getCardIcon(String str, int i) {
        return this.cardPicRescManager.getCardIcon(str, i);
    }

    public void updateCardOrder(int i, int i2, List<UniCardInfo> list) {
        LogX.i("updateCardOrder begin，from=" + i + ",to=" + i2);
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            if (i > size - 1 || i2 > size - 1) {
                LogX.e("updateCardOrder from or to biger than list size");
                return;
            }
            List queryCardOrderInfo = this.cardDBManager.queryCardOrderInfo();
            List arrayList = new ArrayList();
            int i3;
            CardOrderInfoItem cardOrderInfoItem;
            if (i < i2) {
                for (i3 = i; i3 < i2; i3++) {
                    cardOrderInfoItem = new CardOrderInfoItem();
                    cardOrderInfoItem.setReference_id(((UniCardInfo) list.get(i3 + 1)).m28110c());
                    cardOrderInfoItem.setTimestamp(((UniCardInfo) list.get(i3)).m28125l());
                    LogX.i("OrderItem  ， OrderItem.reference_id=" + cardOrderInfoItem.getReference_id());
                    arrayList.add(cardOrderInfoItem);
                }
            } else if (i > i2) {
                for (i3 = i; i3 > i2; i3--) {
                    cardOrderInfoItem = new CardOrderInfoItem();
                    cardOrderInfoItem.setReference_id(((UniCardInfo) list.get(i3 - 1)).m28110c());
                    cardOrderInfoItem.setTimestamp(((UniCardInfo) list.get(i3)).m28125l());
                    LogX.i("OrderItem  ， OrderItem.reference_id=" + cardOrderInfoItem.getReference_id());
                    arrayList.add(cardOrderInfoItem);
                }
            }
            arrayList.add(new CardOrderInfoItem(((UniCardInfo) list.get(i)).m28110c(), ((UniCardInfo) list.get(i2)).m28125l()));
            this.cardDBManager.insertOrUpdateCardOrderInfos(arrayList);
            sortCardListItem(list, arrayList);
            if (i2 == size - 1 || i == size - 1) {
                setDefaultCardIfNecessary(i, i2, list, queryCardOrderInfo);
            }
            LogX.i("updateCardOrder    end");
        }
    }

    private void setDefaultCardIfNecessary(int i, int i2, List<UniCardInfo> list, final List<CardOrderInfoItem> list2) {
        int size = list.size();
        final UniCardInfo uniCardInfo;
        if (i2 == size - 1) {
            uniCardInfo = (UniCardInfo) list.get(i);
            setCardDefault(uniCardInfo.m28110c(), new SetCardDefaultCallback() {
                public void setResultCallback(int i) {
                    CardInfoManager.this.dealWithsetDefaultResult(list2, uniCardInfo, i);
                }
            });
        } else if (i == size - 1) {
            uniCardInfo = (UniCardInfo) list.get(size - 2);
            setCardDefault(uniCardInfo.m28110c(), new SetCardDefaultCallback() {
                public void setResultCallback(int i) {
                    CardInfoManager.this.dealWithsetDefaultResult(list2, uniCardInfo, i);
                }
            });
        }
    }

    private void dealWithsetDefaultResult(List<CardOrderInfoItem> list, UniCardInfo uniCardInfo, int i) {
        if (i == 0) {
            String string;
            CardProductInfoItem queryCardProductInfoById = this.cardDBManager.queryCardProductInfoById(uniCardInfo.m28117f());
            if (queryCardProductInfoById == null || StringUtil.isEmpty(queryCardProductInfoById.getProductName(), true)) {
                string = this.mContext.getResources().getString(R.string.nfc_set_last_as_default_card_success);
            } else {
                string = String.format(this.mContext.getResources().getString(R.string.nfc_set_default_card_success_info), new Object[]{queryCardProductInfoById.getProductName()});
            }
            ToastManager.show(this.mContext, string);
        } else {
            ToastManager.show(this.mContext, R.string.nfc_set_default_card_fail);
            this.cardDBManager.insertOrUpdateCardOrderInfos(list);
        }
        refreshCardList();
    }

    private void sortCardListItem(List<UniCardInfo> list, List<CardOrderInfoItem> list2) {
        if (list2 == null || list2.isEmpty()) {
            LogX.i("sortCardListItem  queryCardOrderInfo  erro");
            return;
        }
        for (CardOrderInfoItem cardOrderInfoItem : list2) {
            for (UniCardInfo uniCardInfo : list) {
                if (cardOrderInfoItem.getReference_id().equals(uniCardInfo.m28110c())) {
                    uniCardInfo.m28104a(cardOrderInfoItem.getTimestamp());
                    LogX.i("cardListItem.statusUpdateTime::" + cardOrderInfoItem.getTimestamp());
                }
            }
        }
    }

    public void queryTrafficCardInfo(String str, int i, String str2, QueryTrafficCardInfoCallback queryTrafficCardInfoCallback) {
        if (queryTrafficCardInfoCallback == null) {
            LogX.e("CardInfoManager queryTrafficCardInfo, null == callback");
        } else if (StringUtil.isEmpty(str, true)) {
            LogX.e("CardInfoManager queryTrafficCardInfo, param isserId is illegal.");
            queryTrafficCardInfoCallback.queryTrafficCardInfoCallback(-1, null);
        } else {
            this.listsLoader.queryTrafficCardInfo(str, i, str2, queryTrafficCardInfoCallback);
        }
    }

    public void queryBankIssuerInfo(String str, QueryBankIssuerInfoCallback queryBankIssuerInfoCallback) {
        LogX.d("queryBankIssuerInfo issuerId == issuerId" + str);
        if (queryBankIssuerInfoCallback == null) {
            LogX.e("CardInfoManager queryBankIssuerInfo, null == callback");
        } else if (StringUtil.isEmpty(str, true)) {
            queryBankIssuerInfoCallback.queryBankIssuerInfoCallback(-1, null);
        } else {
            this.listsLoader.queryBankIssuerInfo(str, queryBankIssuerInfoCallback);
        }
    }

    public void queryBankCardInfo(String str, QueryBankCardInfoCallback queryBankCardInfoCallback) {
        if (queryBankCardInfoCallback == null) {
            LogX.e("CardInfoManager queryBankCardInfo, null == callback");
        } else if (StringUtil.isEmpty(str, true)) {
            queryBankCardInfoCallback.queryBankCardInfoCallback(-1, null);
        } else {
            this.listsLoader.queryBankCardInfo(str, queryBankCardInfoCallback);
        }
    }

    public void syncRFConfFiles(boolean z) {
        this.listsLoader.refreshRFConfs(z);
    }

    public void setRefreshRF(boolean z) {
        this.listsLoader.setHasSyncRFConf(z);
    }
}
