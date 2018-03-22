package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.callback.RefreshLocalIconCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicRescManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.util.LogX;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class CardAndIssuerInfoCache {
    public static final String BUS_DIC_NAME = "bus_support";
    private static final Object SYNC_LOCK = new Object();
    public static final Object sCardBusSupprotLock = new Object();
    public static final Object sCardInfoLock = new Object();
    private static CardAndIssuerInfoCache sInstance;
    public static final Object sIssuerInfoLock = new Object();
    private final CardInfoDBManager cardDBManager;
    private final CardPicRescManager cardPicRescManager;
    private final Map<String, CardProductInfoItem> mCardInfos = new HashMap();
    private final Context mContext;
    private final Map<String, IssuerInfoItem> mIssuerInfos = new LinkedHashMap();
    RefreshLocalIconCallback mRefreshLocalIconCallback = new IconDownloadCallback();

    class IconDownloadCallback implements RefreshLocalIconCallback {
        IconDownloadCallback() {
        }

        public void refreshPicResult(int i) {
        }
    }

    private CardAndIssuerInfoCache(Context context) {
        this.mContext = context;
        this.cardDBManager = new CardInfoDBManager(context);
        this.cardPicRescManager = CardPicRescManager.getInstance(context);
    }

    public static CardAndIssuerInfoCache getInstance(Context context) {
        CardAndIssuerInfoCache cardAndIssuerInfoCache;
        synchronized (SYNC_LOCK) {
            if (sInstance == null) {
                sInstance = new CardAndIssuerInfoCache(context);
            }
            cardAndIssuerInfoCache = sInstance;
        }
        return cardAndIssuerInfoCache;
    }

    void loadLocalIssuerInfo() {
        LogX.d("loadLocalIssuerInfo begin.");
        synchronized (sIssuerInfoLock) {
            List<IssuerInfoItem> queryIssuerInfo = this.cardDBManager.queryIssuerInfo();
            this.mIssuerInfos.clear();
            if (!(queryIssuerInfo == null || queryIssuerInfo.isEmpty())) {
                Collections.sort(queryIssuerInfo, new IssuerInfoComparator());
                for (IssuerInfoItem issuerInfoItem : queryIssuerInfo) {
                    this.mIssuerInfos.put(issuerInfoItem.getIssuerId(), issuerInfoItem);
                }
            }
        }
        LogX.d("loadLocalIssuerInfo end.");
    }

    void loadLocalCardProductInfo() {
        LogX.d("loadLocalCardProductInfo begin.");
        synchronized (sCardInfoLock) {
            List<CardProductInfoItem> queryCardProductInfo = this.cardDBManager.queryCardProductInfo();
            this.mCardInfos.clear();
            for (CardProductInfoItem cardProductInfoItem : queryCardProductInfo) {
                this.mCardInfos.put(cardProductInfoItem.getProductId(), cardProductInfoItem);
            }
        }
        LogX.d("loadLocalCardProductInfo end.");
    }

    Map<String, IssuerInfoItem> cacheIssuerInfoItems() {
        Map<String, IssuerInfoItem> linkedHashMap;
        synchronized (sIssuerInfoLock) {
            if (this.mIssuerInfos.isEmpty()) {
                loadLocalIssuerInfo();
                if (this.mIssuerInfos.isEmpty()) {
                    LogX.i("cacheIssuerInfoItems query db is empty, query from server.");
                    new SyncInfosFromServerTask(this.mContext, null).syncIssuerInfoFromServer();
                    loadLocalIssuerInfo();
                } else {
                    linkedHashMap = new LinkedHashMap(this.mIssuerInfos);
                }
            }
            linkedHashMap = new LinkedHashMap(this.mIssuerInfos);
        }
        return linkedHashMap;
    }

    Map<String, CardProductInfoItem> cacheCardProductInfoItems() {
        Map<String, CardProductInfoItem> hashMap;
        synchronized (sCardInfoLock) {
            if (this.mCardInfos.isEmpty()) {
                loadLocalCardProductInfo();
                if (this.mCardInfos.isEmpty()) {
                    LogX.i("cacheCardProductInfoItems query db is empty, query from server.");
                    new SyncInfosFromServerTask(this.mContext, null).syncIssuerInfoFromServer();
                    loadLocalCardProductInfo();
                } else {
                    hashMap = new HashMap(this.mCardInfos);
                }
            }
            hashMap = new HashMap(this.mCardInfos);
        }
        return hashMap;
    }

    public IssuerInfoItem cacheIssuerInfoItem(String str) {
        IssuerInfoItem issuerInfoItem;
        synchronized (sIssuerInfoLock) {
            issuerInfoItem = (IssuerInfoItem) this.mIssuerInfos.get(str);
            if (issuerInfoItem == null) {
                LogX.d("cacheIssuerInfoItem cache is miss, query from db. issuerId = " + str);
                loadLocalIssuerInfo();
                issuerInfoItem = (IssuerInfoItem) this.mIssuerInfos.get(str);
                if (issuerInfoItem != null) {
                } else {
                    LogX.i("cacheIssuerInfoItem query db is miss, query from server. issuerId = " + str);
                    new SyncInfosFromServerTask(this.mContext, null).syncIssuerInfoFromServer();
                    loadLocalIssuerInfo();
                    issuerInfoItem = (IssuerInfoItem) this.mIssuerInfos.get(str);
                    if (issuerInfoItem != null) {
                        this.cardPicRescManager.refreshCardSmlPics(str, issuerInfoItem.getLogoUrl(), issuerInfoItem.getAppInfos(), this.mRefreshLocalIconCallback);
                    }
                }
            }
        }
        return issuerInfoItem;
    }

    public CardProductInfoItem cacheCardProductInfoItem(String str) {
        CardProductInfoItem cardProductInfoItem;
        synchronized (sCardInfoLock) {
            cardProductInfoItem = (CardProductInfoItem) this.mCardInfos.get(str);
            if (cardProductInfoItem == null) {
                LogX.d("cacheCardProductInfoItem cache is miss, query from db. productId = " + str);
                loadLocalCardProductInfo();
                cardProductInfoItem = (CardProductInfoItem) this.mCardInfos.get(str);
                if (cardProductInfoItem != null) {
                } else {
                    LogX.i("cacheCardProductInfoItem query db is miss, query from server. productId = " + str);
                    new SyncInfosFromServerTask(this.mContext, null).syncCardProductInfoFromServer();
                    loadLocalCardProductInfo();
                    cardProductInfoItem = (CardProductInfoItem) this.mCardInfos.get(str);
                    if (cardProductInfoItem != null) {
                        this.cardPicRescManager.refreshLocalCardIcon(str, cardProductInfoItem.getPictureUrl(), this.mRefreshLocalIconCallback);
                    }
                }
            }
        }
        return cardProductInfoItem;
    }
}
