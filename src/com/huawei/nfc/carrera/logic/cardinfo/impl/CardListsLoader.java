package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushServiceManager;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportBankInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportedTrafficCardListCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.RefreshLocalIconCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SyncRFConfFilesCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.UpdateCardTimeStampCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicRescManager;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.IssueMoney;
import com.huawei.nfc.carrera.logic.cardinfo.model.LogicModelConverter;
import com.huawei.nfc.carrera.logic.cardinfo.model.RechargeMoney;
import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardOrderInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.swipe.channel.ChannelManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CardListsLoader extends Handler {
    private static final String BUNDLE_KEY_BUSINESSCODE = "businessCode";
    private static final String BUNDLE_KEY_CITYCODE = "bundle_key_citycode";
    private static final String BUNDLE_KEY_DEFAULT_REFID = "set_default_ref_id";
    private static final String BUNDLE_KEY_DEFAULT_TIMESTAMP = "update_card_timestamp";
    private static final String BUNDLE_KEY_ISSUERID = "issuerId";
    private static final int CARD_LIST_DB_LOAD = 1;
    private static final int CARD_LIST_DB_REFRESH = 2;
    public static final int INCONSISTENT_ACCOUNTS_ATYPISM_STATUS = 100004;
    private static final int QUERY_BANK_CARD_INFO = 8;
    private static final int QUERY_BANK_ISSUER_INFO = 7;
    private static final int QUERY_SUPPORTED_BANK = 9;
    private static final int QUERY_SUPPORTED_TRAFFIC = 10;
    private static final int QUERY_TRAFFIC_CARD_INFO = 11;
    private static final int REFRESH_RFCONF_FILES = 12;
    private static final String TAG = "CardListsLoader";
    private static final int UPDATE_CARD_STIMESTAMP = 5;
    private static PluginPayAdapter pluginPayAdapter;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
    private final CardInfoDBManager cardDBManager;
    private final CardPicRescManager cardPicRescManager;
    private boolean hasSyncRFConf;
    private final Context mContext;
    private final CardAndIssuerInfoCache mInfoCache;
    RefreshLocalIconCallback mRefreshLocalIconCallback = new LogoDownloadCallback();
    private final SPIOperatorManager mSpiOperatorManager;
    private SyncRFConfFilesCallback mSyncRFConfFilesCallback = new C55402();
    private final CardInfoRefresher mUIHandler;
    private Map<String, UpdateCardTimeStampCallback> updateCardTimeStampCallbacks;

    class C55402 implements SyncRFConfFilesCallback {
        C55402() {
        }

        public void syncRFConfFilesResult(final String str, int i) {
            CardListsLoader.this.hasSyncRFConf = i != 3;
            C2538c.c(CardListsLoader.TAG, new Object[]{"CardListsLoader syncRFConfFilesResult : " + i + " issuerid : " + str + " hasSyncRFConf : " + CardListsLoader.this.hasSyncRFConf + "thread==" + Thread.currentThread()});
            if (i == 1) {
                CardListsLoader.threadPool.execute(new Runnable() {
                    public void run() {
                        new SyncFileToWatchTask(CardListsLoader.this.mContext).getTACardToSendFile(str);
                        TACardInfo defaultCard = WalletTaManager.getInstance(CardListsLoader.this.mContext).getDefaultCard();
                        if (defaultCard != null && defaultCard.getIssuerId().equals(str)) {
                            C2538c.c(CardListsLoader.TAG, new Object[]{"syncRFConfFilesResult : the new ver conf downloaded,set new conf for <" + str + "> defaultcard."});
                            ChannelManager.getInstance(CardListsLoader.this.mContext).setDefaultCardRFConf(1, true);
                        }
                    }
                });
            }
        }
    }

    class LogoDownloadCallback implements RefreshLocalIconCallback {
        LogoDownloadCallback() {
        }

        public void refreshPicResult(int i) {
        }
    }

    CardListsLoader(Context context, Looper looper, CardInfoRefresher cardInfoRefresher) {
        super(looper);
        this.mContext = context;
        this.cardDBManager = new CardInfoDBManager(context);
        this.cardPicRescManager = CardPicRescManager.getInstance(this.mContext);
        this.updateCardTimeStampCallbacks = new HashMap();
        this.mUIHandler = cardInfoRefresher;
        this.mSpiOperatorManager = new SPIOperatorManager(context, this);
        this.mInfoCache = CardAndIssuerInfoCache.getInstance(context);
        initPluginPay();
    }

    private void initPluginPay() {
        pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter();
    }

    void loadCardLists() {
        sendEmptyMessage(1);
        sendEmptyMessage(2);
    }

    void loadCardListDate() {
        sendEmptyMessage(1);
    }

    void queryTrafficCardInfo(String str, int i, String str2, QueryTrafficCardInfoCallback queryTrafficCardInfoCallback) {
        Message message = new Message();
        message.what = 11;
        message.obj = queryTrafficCardInfoCallback;
        Bundle bundle = new Bundle();
        bundle.putString("issuerId", str);
        bundle.putInt(BUNDLE_KEY_BUSINESSCODE, i);
        bundle.putString(BUNDLE_KEY_CITYCODE, str2);
        message.setData(bundle);
        sendMessage(message);
    }

    void queryBankIssuerInfo(String str, QueryBankIssuerInfoCallback queryBankIssuerInfoCallback) {
        Message message = new Message();
        message.what = 7;
        message.obj = queryBankIssuerInfoCallback;
        Bundle bundle = new Bundle();
        bundle.putString("issuerId", str);
        message.setData(bundle);
        sendMessage(message);
    }

    void queryBankCardInfo(String str, QueryBankCardInfoCallback queryBankCardInfoCallback) {
        Message message = new Message();
        message.what = 8;
        message.obj = queryBankCardInfoCallback;
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_DEFAULT_REFID, str);
        message.setData(bundle);
        sendMessage(message);
    }

    void querySupportNFCBankInfos(QuerySupportBankInfoCallback querySupportBankInfoCallback) {
        Message message = new Message();
        message.what = 9;
        message.obj = querySupportBankInfoCallback;
        sendMessage(message);
    }

    void querySupportTrafficCardList(QuerySupportedTrafficCardListCallback querySupportedTrafficCardListCallback) {
        Message message = new Message();
        message.what = 10;
        message.obj = querySupportedTrafficCardListCallback;
        sendMessage(message);
    }

    void refreshRFConfs(boolean z) {
        Message message = new Message();
        message.what = 12;
        message.obj = Boolean.valueOf(z);
        sendMessage(message);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                removeMessages(1);
                loadCardListData();
                return;
            case 2:
                removeMessages(2);
                refreshCardListDB();
                return;
            case 5:
                updateCardTimeStampImpl(message.getData().getString(BUNDLE_KEY_DEFAULT_REFID), message.getData().getLong(BUNDLE_KEY_DEFAULT_TIMESTAMP), (UpdateCardTimeStampCallback) message.obj);
                return;
            case 7:
                getBankIssuerInfo(message.getData().getString("issuerId"), (QueryBankIssuerInfoCallback) message.obj);
                return;
            case 8:
                getBankCardInfo(message.getData().getString(BUNDLE_KEY_DEFAULT_REFID), (QueryBankCardInfoCallback) message.obj);
                return;
            case 9:
                getSupportNFCBankInfos((QuerySupportBankInfoCallback) message.obj);
                return;
            case 10:
                getSupportTrafficCardList((QuerySupportedTrafficCardListCallback) message.obj);
                return;
            case 11:
                QueryTrafficCardInfoCallback queryTrafficCardInfoCallback = (QueryTrafficCardInfoCallback) message.obj;
                Bundle data = message.getData();
                getTrafficCardinfo(data.getString("issuerId"), data.getInt(BUNDLE_KEY_BUSINESSCODE), data.getString(BUNDLE_KEY_CITYCODE), queryTrafficCardInfoCallback);
                return;
            case 12:
                refreshRFConfFiles(Boolean.parseBoolean(message.obj.toString()));
                return;
            default:
                return;
        }
    }

    private void loadCardListData() {
        C2538c.c(TAG, new Object[]{"loadCardListData   enter"});
        List cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        ESEInfoManager.getInstance(this.mContext).getWalletAbility();
        if (cardList == null || cardList.isEmpty()) {
            C2538c.c(TAG, new Object[]{"loadCardListData, but TA is empty."});
            CardInfoManager.getInstance(this.mContext).cardListLoaded(null);
            return;
        }
        C2538c.c(TAG, new Object[]{"loadCardListData , taCardInfos.size= " + cardList.size()});
        initCardOrder(cardList);
        filterCardList(cardList);
        cardList = convertFromCardTAList(cardList);
        C2538c.b(TAG, new Object[]{"befor sort loadCardListData lists=" + cardList.size()});
        checkDefaultCard(cardList);
        sortCardList(cardList);
        C2538c.b(TAG, new Object[]{"stop sort loadCardListData lists=" + cardList.size()});
        CardInfoManager.getInstance(this.mContext).cardListLoaded(cardList);
        matchCardStatusToServer();
    }

    private void checkDefaultCard(List<UniCardInfo> list) {
        UniCardInfo uniCardInfo = null;
        UniCardInfo uniCardInfo2 = null;
        for (UniCardInfo uniCardInfo3 : list) {
            UniCardInfo uniCardInfo32;
            if (2 == uniCardInfo32.m28102a()) {
                if (uniCardInfo32.m28116e()) {
                    LogX.d("default card existed, aid: " + uniCardInfo32.m28107b());
                    break;
                }
                if (uniCardInfo2 != null && uniCardInfo32.m28125l() <= uniCardInfo2.m28125l()) {
                    uniCardInfo32 = uniCardInfo2;
                }
                uniCardInfo2 = uniCardInfo32;
            }
        }
        uniCardInfo = uniCardInfo2;
        if (uniCardInfo != null) {
            LogX.d("set card default automatically, aid: " + uniCardInfo.m28107b());
            uniCardInfo.m28106a(true);
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        WalletTaManager.getInstance(CardListsLoader.this.mContext).setDefaultCard(uniCardInfo.m28110c());
                    } catch (WalletTaCardNotExistException e) {
                        LogX.d("set card default fail, WalletTaCardNotExistException: " + e.getMessage());
                    } catch (WalletTaSystemErrorException e2) {
                        LogX.d("set card default fail, WalletTaSystemErrorException: " + e2.getMessage());
                    }
                }
            });
        }
    }

    private void initCardOrder(List<TACardInfo> list) {
        List queryCardOrderInfo = this.cardDBManager.queryCardOrderInfo();
        if (queryCardOrderInfo == null) {
            C2538c.c(TAG, new Object[]{"ll == cardOrderInfo"});
            initCardOrderDB(list);
        } else if (queryCardOrderInfo.size() != list.size()) {
            this.cardDBManager.deleteAllCardOrderInfos();
            initCardOrderDB(list);
        }
    }

    private void initCardOrderDB(List<TACardInfo> list) {
        long j = 0;
        int i = 0;
        List arrayList = new ArrayList();
        arrayList.clear();
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        long j2 = 0;
        while (i < size) {
            TACardInfo tACardInfo = (TACardInfo) list.get(i);
            if (tACardInfo.isDefaultCard) {
                j = tACardInfo.statusUpdateTime;
                i2 = i;
            }
            if (i == 0) {
                j2 = tACardInfo.statusUpdateTime;
            } else if (tACardInfo.statusUpdateTime < j2) {
                j2 = tACardInfo.statusUpdateTime;
                i3 = i;
            }
            arrayList.add(new CardOrderInfoItem(tACardInfo.dpanDigest, tACardInfo.statusUpdateTime));
            i++;
        }
        if (j > j2) {
            ((CardOrderInfoItem) arrayList.get(i2)).setTimestamp(j2);
            ((CardOrderInfoItem) arrayList.get(i3)).setTimestamp(j);
        }
        this.cardDBManager.insertOrUpdateCardOrderInfos(arrayList);
    }

    private void filterCardList(List<TACardInfo> list) {
        LogX.d("the card in TA filterCardList");
        initPluginPay();
        Iterator it = list.iterator();
        int i = -1;
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            int i2;
            TACardInfo tACardInfo = (TACardInfo) it.next();
            C2538c.b(TAG, new Object[]{"filterCardList taCardInfo=" + tACardInfo.toString()});
            if (98 == tACardInfo.cardStatus || 97 == tACardInfo.cardStatus || 96 == tACardInfo.cardStatus || 95 == tACardInfo.cardStatus) {
                LogX.d("Cup error card existed.");
                z = true;
            }
            if (tACardInfo.cardStatus == 2 || tACardInfo.cardStatus == 1 || tACardInfo.cardStatus == 99 || tACardInfo.cardStatus == 92 || tACardInfo.cardStatus == 95 || tACardInfo.cardStatus == 96 || tACardInfo.cardStatus == 97 || tACardInfo.cardStatus == 94 || tACardInfo.cardStatus == 98 || tACardInfo.cardStatus == 11 || tACardInfo.cardStatus == 12 || tACardInfo.cardStatus == 13 || tACardInfo.cardStatus == 93 || tACardInfo.cardStatus == 3) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                LogX.d("The card should not be showed, aid: " + tACardInfo.aid + " and status: " + tACardInfo.cardStatus);
                it.remove();
                i2 = i;
            } else {
                if (1 == tACardInfo.cardGroupType) {
                    if (pluginPayAdapter == null) {
                        C2538c.e(TAG, new Object[]{"pluginPayAdapter is null "});
                        return;
                    }
                    String userID = pluginPayAdapter.getUserID();
                    C2538c.c(TAG, new Object[]{"== checkWatchStatus userID : " + userID + ",mAcountStatus=" + i});
                    if (!StringUtil.isEmpty(userID, true) && -1 == i) {
                        i = pluginPayAdapter.sendAccount(userID);
                        C2538c.e(TAG, new Object[]{"enter filterCardList ,mAcountStatus=" + i});
                    }
                    C2538c.b(TAG, new Object[]{"== checkWatchStatus sendAccount  " + i});
                    if (100004 == i) {
                        LogX.d("enter getCacheAccountstate");
                        it.remove();
                    }
                }
                i2 = i;
            }
            i = i2;
        }
        LogX.d("enter isCupErrorCardExisted=" + z);
        if (z) {
            LogicApiFactory.createCardOperateApi(this.mContext).checkCUPInterruptedCard(false, null);
        }
    }

    private List<UniCardInfo> convertFromCardTAList(List<TACardInfo> list) {
        List<UniCardInfo> arrayList = new ArrayList();
        for (TACardInfo tACardInfo : list) {
            String string;
            UniCardInfo convertToUniCardInfo = LogicModelConverter.convertToUniCardInfo(tACardInfo);
            convertToUniCardInfo.m28120g(this.cardPicRescManager.getCardIconDirPath(tACardInfo.productId));
            if (tACardInfo.cardStatus == 2) {
                string = this.mContext.getString(R.string.nfc_card_description_activited);
            } else if (tACardInfo.cardStatus == 1) {
                string = this.mContext.getString(R.string.nfc_card_description_unactivited);
            } else if (tACardInfo.cardStatus == 99 || tACardInfo.cardStatus == 92 || tACardInfo.cardStatus == 96 || tACardInfo.cardStatus == 95) {
                string = this.mContext.getString(R.string.nfc_card_locked);
            } else {
                string = this.mContext.getString(R.string.nfc_card_description_unused);
            }
            if (tACardInfo.cardGroupType == 1) {
                convertToUniCardInfo.m28115e(this.mContext.getString(R.string.nfc_card_num_show, new Object[]{tACardInfo.fpanFour}));
            } else {
                convertToUniCardInfo.m28115e(tACardInfo.fpanFour);
            }
            convertToUniCardInfo.m28114d(string);
            arrayList.add(convertToUniCardInfo);
        }
        return arrayList;
    }

    private void sortCardList(List<UniCardInfo> list) {
        List<CardOrderInfoItem> queryCardOrderInfo = this.cardDBManager.queryCardOrderInfo();
        if (queryCardOrderInfo == null || queryCardOrderInfo.isEmpty()) {
            LogX.e("sortCardList  queryCardOrderInfo  erro");
        } else {
            for (CardOrderInfoItem cardOrderInfoItem : queryCardOrderInfo) {
                for (UniCardInfo uniCardInfo : list) {
                    if (cardOrderInfoItem.getReference_id().equals(uniCardInfo.m28110c())) {
                        uniCardInfo.m28104a(cardOrderInfoItem.getTimestamp());
                        LogX.i("cardListItem.statusUpdateTime::" + cardOrderInfoItem.getTimestamp());
                    }
                }
            }
        }
        Collections.sort(list, new UniCardInfoComparator());
    }

    private void refreshCardListDB() {
        LogX.d("refreshCardListDB");
        this.mInfoCache.loadLocalIssuerInfo();
        this.mInfoCache.loadLocalCardProductInfo();
        refreshLocalCardPic();
        refreshLocalIssuerLogo();
    }

    private void refreshRFConfFiles(boolean z) {
        C2538c.c(TAG, new Object[]{"CardListsLoader refreshRFConfFiles begin. hasSyncRFConf : " + this.hasSyncRFConf + " forceSync : " + z});
        if (!this.hasSyncRFConf || z) {
            new SyncRFConfFilesTask(this.mContext, this.mUIHandler, this.mSyncRFConfFilesCallback).refreshRFConfFiles();
        }
    }

    private void refreshLocalIssuerLogo() {
        Map cacheIssuerInfoItems = this.mInfoCache.cacheIssuerInfoItems();
        if (cacheIssuerInfoItems.size() > 0) {
            IssuerInfoItem issuerInfoItem;
            Iterator it = cacheIssuerInfoItems.values().iterator();
            while (it.hasNext()) {
                issuerInfoItem = (IssuerInfoItem) it.next();
                if (issuerInfoItem.getIssuerType() == 2) {
                    this.cardPicRescManager.refreshLocalCardLogo(issuerInfoItem.getIssuerId(), issuerInfoItem.getLogoUrl(), this.mRefreshLocalIconCallback);
                    it.remove();
                }
            }
            for (IssuerInfoItem issuerInfoItem2 : cacheIssuerInfoItems.values()) {
                this.cardPicRescManager.refreshCardSmlPics(issuerInfoItem2.getIssuerId(), issuerInfoItem2.getLogoUrl(), issuerInfoItem2.getAppInfos(), this.mRefreshLocalIconCallback);
            }
        }
    }

    private void refreshLocalCardPic() {
        LogX.d("refreshaLocalCardPic");
        Map cacheCardProductInfoItems = this.mInfoCache.cacheCardProductInfoItems();
        if (cacheCardProductInfoItems.size() <= 0) {
            LogX.e("no card info in db, no need to refresh local pic.");
            return;
        }
        CardProductInfoItem cardProductInfoItem;
        Object cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (cardList == null || cardList.isEmpty()) {
            LogX.d("loadCardListDBData, but TA is empty.");
        } else {
            filterCardList(cardList);
        }
        if (cardList != null) {
            Iterator it = cardList.iterator();
            while (it.hasNext()) {
                cardProductInfoItem = (CardProductInfoItem) cacheCardProductInfoItems.remove(((TACardInfo) it.next()).getProductId());
                if (cardProductInfoItem != null) {
                    final String productId = cardProductInfoItem.getProductId();
                    this.cardPicRescManager.refreshLocalCardIcon(productId, cardProductInfoItem.getPictureUrl(), new RefreshLocalIconCallback() {
                        public void refreshPicResult(int i) {
                            LogX.i("refresh local card icon in ta, result: " + i + " productId : " + productId);
                            if (i == 1) {
                                CardListsLoader.this.sendEmptyMessage(1);
                                new SyncFileToWatchTask(CardListsLoader.this.mContext).sendBTOfCardPicInfor(productId);
                            }
                        }
                    });
                }
            }
        }
        for (CardProductInfoItem cardProductInfoItem2 : cacheCardProductInfoItems.values()) {
            if (cardProductInfoItem2.getType() == 11) {
                final String productId2 = cardProductInfoItem2.getProductId();
                this.cardPicRescManager.refreshLocalCardIcon(productId2, cardProductInfoItem2.getPictureUrl(), new RefreshLocalIconCallback() {
                    public void refreshPicResult(int i) {
                        LogX.i("refresh local card icon in ta, result: " + i + " productId : " + productId2);
                        if (i == 1) {
                            CardListsLoader.this.sendEmptyMessage(1);
                        }
                    }
                });
            }
        }
    }

    private void matchCardStatusToServer() {
        NFCPushServiceManager.getInstance(this.mContext).getPushToken();
    }

    public void updateCardTimeStamp(String str, long j, UpdateCardTimeStampCallback updateCardTimeStampCallback) {
        if (this.updateCardTimeStampCallbacks == null) {
            this.updateCardTimeStampCallbacks = new HashMap();
        }
        if (!this.updateCardTimeStampCallbacks.containsKey(str)) {
            this.updateCardTimeStampCallbacks.put(str, updateCardTimeStampCallback);
        }
        Message message = new Message();
        message.what = 5;
        message.obj = updateCardTimeStampCallback;
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_DEFAULT_REFID, str);
        bundle.putLong(BUNDLE_KEY_DEFAULT_TIMESTAMP, j);
        message.setData(bundle);
        sendMessage(message);
    }

    private void updateCardTimeStampImpl(String str, long j, UpdateCardTimeStampCallback updateCardTimeStampCallback) {
        int i;
        try {
            WalletTaManager.getInstance(this.mContext).updateCardTimeStamp(str, j);
            i = 1;
        } catch (WalletTaCardNotExistException e) {
            LogX.w("updateCardTimeStampImpl , WalletTaCardNotExistException");
            i = 0;
        } catch (WalletTaSystemErrorException e2) {
            LogX.w("updateCardTimeStampImpl , WalletTaSystemErrorException");
            i = 0;
        }
        if (i != 0) {
            this.updateCardTimeStampCallbacks.remove(str);
        }
        if (this.updateCardTimeStampCallbacks.size() < 1) {
            updateCardTimeStampCallback.updateCardTimeStamp(0);
        }
    }

    private void getBankIssuerInfo(String str, QueryBankIssuerInfoCallback queryBankIssuerInfoCallback) {
        IssuerInfoItem cacheIssuerInfoItem = this.mInfoCache.cacheIssuerInfoItem(str);
        if (cacheIssuerInfoItem == null) {
            this.mUIHandler.handleQueryBankIssuerInfoResult(-1, null, queryBankIssuerInfoCallback);
            return;
        }
        BankIssuerInfo bankIssuerInfo = new BankIssuerInfo(cacheIssuerInfoItem);
        bankIssuerInfo.setLogoIcon(this.cardPicRescManager.getCardLogo(cacheIssuerInfoItem.getIssuerId()));
        this.cardPicRescManager.getCardApkIcons(cacheIssuerInfoItem.getAppInfos());
        this.mUIHandler.handleQueryBankIssuerInfoResult(0, bankIssuerInfo, queryBankIssuerInfoCallback);
    }

    private void getBankCardInfo(String str, QueryBankCardInfoCallback queryBankCardInfoCallback) {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
        if (card == null) {
            this.mUIHandler.handleQueryBankCardInfoResult(-1, null, queryBankCardInfoCallback);
            return;
        }
        String str2 = card.issuerId;
        String str3 = card.productId;
        if (StringUtil.isEmpty(str2, true) || StringUtil.isEmpty(str3, true)) {
            this.mUIHandler.handleQueryBankCardInfoResult(-1, null, queryBankCardInfoCallback);
            return;
        }
        IssuerInfoItem cacheIssuerInfoItem = this.mInfoCache.cacheIssuerInfoItem(str2);
        CardProductInfoItem cacheCardProductInfoItem = this.mInfoCache.cacheCardProductInfoItem(str3);
        if (cacheIssuerInfoItem != null) {
            BankCardInfo bankCardInfo = new BankCardInfo(card, cacheIssuerInfoItem, cacheCardProductInfoItem);
            bankCardInfo.cardIcon = this.cardPicRescManager.getCardIcon(str3, 1);
            this.mUIHandler.handleQueryBankCardInfoResult(0, bankCardInfo, queryBankCardInfoCallback);
        } else if (C4026a.m19819a(this.mContext)) {
            this.mUIHandler.handleQueryBankCardInfoResult(-1, null, queryBankCardInfoCallback);
        } else {
            this.mUIHandler.handleQueryBankCardInfoResult(-2, null, queryBankCardInfoCallback);
        }
    }

    private void getSupportNFCBankInfos(QuerySupportBankInfoCallback querySupportBankInfoCallback) {
        this.mUIHandler.handleQuerySupportedBankCardInfoResult(new QuerySupportedBankCardListTask(this.mContext).getSupportedCardList(), querySupportBankInfoCallback);
    }

    private void getSupportTrafficCardList(QuerySupportedTrafficCardListCallback querySupportedTrafficCardListCallback) {
        this.mUIHandler.handleQuerySupportedTrafficCardsResult(new QuerySupportedTrafficCardListTask(this.mContext).getSupportedCardList(), querySupportedTrafficCardListCallback);
    }

    private void getTrafficCardinfo(String str, int i, String str2, QueryTrafficCardInfoCallback queryTrafficCardInfoCallback) {
        int i2 = 0;
        LogX.i("CardListsLoader getTrafficCardinfo begin");
        if (StringUtil.isEmpty(str, true)) {
            this.mUIHandler.handleQueryTrafficCardInfoResult(-1, null, queryTrafficCardInfoCallback);
            return;
        }
        IssuerInfoItem cacheIssuerInfoItem = this.mInfoCache.cacheIssuerInfoItem(str);
        if (cacheIssuerInfoItem == null) {
            LogX.w("CardListsLoader getTrafficCardinfo failed. issuer info does not exists. issuerId = " + str);
            if (C4026a.m19819a(this.mContext)) {
                this.mUIHandler.handleQueryTrafficCardInfoResult(-1, null, queryTrafficCardInfoCallback);
                return;
            }
            LogX.d("processTask, no network.");
            this.mUIHandler.handleQueryTrafficCardInfoResult(-2, null, queryTrafficCardInfoCallback);
            return;
        }
        String productId = cacheIssuerInfoItem.getProductId();
        if (StringUtil.isEmpty(productId, true)) {
            this.mUIHandler.handleQueryTrafficCardInfoResult(-1, null, queryTrafficCardInfoCallback);
            return;
        }
        this.mInfoCache.loadLocalCardProductInfo();
        CardProductInfoItem cacheCardProductInfoItem = this.mInfoCache.cacheCardProductInfoItem(productId);
        if (cacheCardProductInfoItem == null) {
            LogX.w("CardListsLoader getTrafficCardinfo failed. card info does not exists. productId = " + productId);
            if (C4026a.m19819a(this.mContext)) {
                this.mUIHandler.handleQueryTrafficCardInfoResult(-1, null, queryTrafficCardInfoCallback);
                return;
            }
            LogX.d("processTask, no network.");
            this.mUIHandler.handleQueryTrafficCardInfoResult(-2, null, queryTrafficCardInfoCallback);
            return;
        }
        TrafficCardInfo trafficCardInfo = new TrafficCardInfo(cacheIssuerInfoItem, cacheCardProductInfoItem);
        trafficCardInfo.setCardIcon(this.cardPicRescManager.getCardIcon(cacheCardProductInfoItem.getProductId(), 2));
        trafficCardInfo.setCardLogo(this.cardPicRescManager.getCardLogo(cacheIssuerInfoItem.getIssuerId()));
        this.mUIHandler.handleQueryTrafficCardInfoResult(0, trafficCardInfo, queryTrafficCardInfoCallback);
        int mode = cacheIssuerInfoItem.getMode();
        switch (i) {
            case 1:
                i2 = handleSpecialOpenCardBusiness(mode, str2, cacheIssuerInfoItem, trafficCardInfo);
                break;
            case 2:
                i2 = handleSpecialRechargeBusiness(mode, cacheIssuerInfoItem, trafficCardInfo);
                break;
            case 3:
                i2 = handleSpecialOpenCardAndRechargeBusiness(mode, cacheIssuerInfoItem, trafficCardInfo);
                break;
        }
        this.mUIHandler.handleQueryTrafficCardInfoResult(i2, trafficCardInfo, queryTrafficCardInfoCallback);
    }

    private int handleSpecialRechargeBusiness(int i, IssuerInfoItem issuerInfoItem, TrafficCardInfo trafficCardInfo) {
        TrafficCardOperator trafficCardOpertor = this.mSpiOperatorManager.getTrafficCardOpertor(i);
        if (trafficCardOpertor == null) {
            return 0;
        }
        TrafficActivityInfo rechargeCoupon = trafficCardOpertor.getRechargeCoupon(issuerInfoItem);
        if (rechargeCoupon.getReturnCd() != 0) {
            if (rechargeCoupon.getReturnCd() == 11) {
                return -2;
            }
            if (rechargeCoupon.getReturnCd() != 1) {
                return -1;
            }
            return 0;
        } else if (rechargeCoupon.getRechargeStdAmounts().length != rechargeCoupon.getRechargeActAmounts().length) {
            LogX.w("handleSpecialRechargeBusiness failed. amounts config error.");
            return -1;
        } else {
            trafficCardInfo.clearRechargeAmounts();
            String str = null;
            String str2 = null;
            int i2 = 0;
            while (i2 < rechargeCoupon.getRechargeStdAmounts().length) {
                try {
                    str2 = rechargeCoupon.getRechargeStdAmounts()[i2];
                    str = rechargeCoupon.getRechargeActAmounts()[i2];
                    RechargeMoney rechargeMoney = new RechargeMoney();
                    rechargeMoney.setPayMoney(Double.parseDouble(str));
                    rechargeMoney.setRechargeMoney(Double.parseDouble(str2));
                    trafficCardInfo.getRechargeAmounts().add(rechargeMoney);
                    i2++;
                } catch (NumberFormatException e) {
                    LogX.w("handleSpecialRechargeBusiness exception. stdAmount = " + str2 + " actAmount = " + str);
                    return -1;
                }
            }
            return 0;
        }
    }

    private int handleSpecialOpenCardBusiness(int i, String str, IssuerInfoItem issuerInfoItem, TrafficCardInfo trafficCardInfo) {
        TrafficCardOperator trafficCardOpertor = this.mSpiOperatorManager.getTrafficCardOpertor(i);
        if (trafficCardOpertor == null) {
            return 0;
        }
        TrafficActivityInfo issueCardCoupon = trafficCardOpertor.getIssueCardCoupon(str, issuerInfoItem);
        if (issueCardCoupon.getReturnCd() != 0) {
            if (issueCardCoupon.getReturnCd() == 11) {
                return -2;
            }
            if (issueCardCoupon.getReturnCd() == 1) {
                return 0;
            }
            return -1;
        } else if (Constant.TFTONG_CARD_ISSERID.equals(issuerInfoItem.getIssuerId())) {
            List arrayList = new ArrayList();
            r6 = Double.parseDouble(issueCardCoupon.getIssueActAmount());
            double parseDouble = Double.parseDouble(issueCardCoupon.getIssueStdAmount());
            if (r6 < 0.0d || parseDouble < 0.0d) {
                return -1;
            }
            if (!(issueCardCoupon.getRechargeStdAmounts().length == 0 || issueCardCoupon.getRechargeActAmounts().length == 0)) {
                if (issueCardCoupon.getRechargeStdAmounts().length != issueCardCoupon.getRechargeActAmounts().length) {
                    return -1;
                }
                for (int i2 = 0; i2 < issueCardCoupon.getRechargeStdAmounts().length; i2++) {
                    double parseDouble2 = Double.parseDouble(issueCardCoupon.getRechargeStdAmounts()[i2]);
                    double parseDouble3 = Double.parseDouble(issueCardCoupon.getRechargeActAmounts()[i2]);
                    if (parseDouble2 < 0.0d || parseDouble3 < 0.0d) {
                        return -1;
                    }
                    IssueMoney issueMoney = new IssueMoney();
                    issueMoney.setIssueStdMoney(parseDouble);
                    issueMoney.setIssueMoney(r6);
                    issueMoney.setRechargeMoney(parseDouble2);
                    issueMoney.setPayMoney(r6 + parseDouble3);
                    arrayList.add(issueMoney);
                }
            }
            trafficCardInfo.setIssueAmounts(arrayList);
            LogX.i("handleSpecialGetDetailBusiness TrafficCardInfo info.getIssueAmounts =" + trafficCardInfo.getIssueAmounts());
            return 0;
        } else {
            try {
                double parseDouble4 = Double.parseDouble(issueCardCoupon.getIssueActAmount());
                r6 = Double.parseDouble(issueCardCoupon.getIssueStdAmount());
                trafficCardInfo.setProductCode(issueCardCoupon.getProductCode());
                if (Constant.FM_LNT_CARD_ISSERID.equals(issuerInfoItem.getIssuerId())) {
                    return 0;
                }
                for (IssueMoney issueMoney2 : trafficCardInfo.getIssueAmounts()) {
                    issueMoney2.setIssueMoney(parseDouble4);
                    issueMoney2.setIssueStdMoney(r6);
                    issueMoney2.setRechargeMoney(issueMoney2.getPayMoney() - issueMoney2.getIssueMoney());
                }
                return 0;
            } catch (NumberFormatException e) {
                LogX.i("handleSpecialGetDetailBusiness exception need check the config. issueCardCost = " + issueCardCoupon.getIssueActAmount());
                return -1;
            }
        }
    }

    private int handleSpecialOpenCardAndRechargeBusiness(int i, IssuerInfoItem issuerInfoItem, TrafficCardInfo trafficCardInfo) {
        TrafficCardOperator trafficCardOpertor = this.mSpiOperatorManager.getTrafficCardOpertor(i);
        if (trafficCardOpertor == null) {
            return 0;
        }
        TrafficActivityInfo issueCardCoupon = trafficCardOpertor.getIssueCardCoupon("", issuerInfoItem);
        if (issueCardCoupon.getReturnCd() == 0) {
            try {
                double parseDouble = Double.parseDouble(issueCardCoupon.getIssueActAmount());
                double parseDouble2 = Double.parseDouble(issueCardCoupon.getIssueStdAmount());
                LogX.i("handleSpecialOpenCardAndRechargeBusiness issueCardCost = " + parseDouble + " ,issueStdCost = " + parseDouble2);
                TrafficActivityInfo rechargeCoupon = trafficCardOpertor.getRechargeCoupon(issuerInfoItem);
                if (rechargeCoupon.getReturnCd() != 0) {
                    if (rechargeCoupon.getReturnCd() == 11) {
                        return -2;
                    }
                    if (rechargeCoupon.getReturnCd() == 1) {
                        return 0;
                    }
                    return -1;
                } else if (rechargeCoupon.getRechargeStdAmounts().length != rechargeCoupon.getRechargeActAmounts().length) {
                    LogX.w("handleSpecialOpenCardAndRechargeBusiness failed. amounts config error.");
                    return -1;
                } else {
                    trafficCardInfo.clearRechargeAmounts();
                    trafficCardInfo.getIssueAmounts().clear();
                    String str = null;
                    String str2 = null;
                    int i2 = 0;
                    while (i2 < rechargeCoupon.getRechargeStdAmounts().length) {
                        try {
                            str = rechargeCoupon.getRechargeStdAmounts()[i2];
                            str2 = rechargeCoupon.getRechargeActAmounts()[i2];
                            RechargeMoney rechargeMoney = new RechargeMoney();
                            rechargeMoney.setPayMoney(Double.parseDouble(str2));
                            rechargeMoney.setRechargeMoney(Double.parseDouble(str));
                            IssueMoney issueMoney = new IssueMoney();
                            issueMoney.setIssueMoney(parseDouble);
                            issueMoney.setIssueStdMoney(parseDouble2);
                            issueMoney.setRechargeMoney(Double.parseDouble(str2));
                            issueMoney.setPayMoney(issueMoney.getIssueMoney() + issueMoney.getRechargeMoney());
                            LogX.i("handleSpecialOpenCardAndRechargeBusiness issueMoney.getIssueMoney() = " + issueMoney.getIssueMoney() + " ,issueMoney.getRechargeMoney() = " + issueMoney.getRechargeMoney());
                            trafficCardInfo.getRechargeAmounts().add(rechargeMoney);
                            trafficCardInfo.getIssueAmounts().add(issueMoney);
                            i2++;
                        } catch (NumberFormatException e) {
                            LogX.w("handleSpecialOpenCardAndRechargeBusiness exception. stdAmount = " + str + " actAmount = " + str2);
                            return -1;
                        }
                    }
                    return 0;
                }
            } catch (NumberFormatException e2) {
                LogX.w("handleSpecialOpenCardAndRechargeBusiness exception need check the config. issueCardCost = " + issueCardCoupon.getIssueActAmount());
                return -1;
            }
        } else if (issueCardCoupon.getReturnCd() == 11) {
            return -2;
        } else {
            if (issueCardCoupon.getReturnCd() == 1) {
                return 0;
            }
            return -1;
        }
    }

    public void setHasSyncRFConf(boolean z) {
        C2538c.b(TAG, new Object[]{"enter setHasSyncRFConf hasSyncRFConf : " + z});
        this.hasSyncRFConf = z;
    }
}
