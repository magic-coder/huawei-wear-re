package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SyncInfosFromServerCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.RequestParam;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryCardProductInfoRequest;
import com.huawei.nfc.carrera.server.card.request.QueryDicsRequset;
import com.huawei.nfc.carrera.server.card.request.QueryIssuerInfoRequest;
import com.huawei.nfc.carrera.server.card.response.CardProductInfoServerItem;
import com.huawei.nfc.carrera.server.card.response.DicItem;
import com.huawei.nfc.carrera.server.card.response.IssuerInfoServerItem;
import com.huawei.nfc.carrera.server.card.response.QueryCardProductInfoResponse;
import com.huawei.nfc.carrera.server.card.response.QueryDicsResponse;
import com.huawei.nfc.carrera.server.card.response.QueryIssuerInfoResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SyncInfosFromServerTask implements Runnable {
    private final String PRODUCT_ID_SHANGHAI = "P0000012";
    private CardInfoDBManager cardDBManager;
    private SyncInfosFromServerCallback mCallback;
    private Context mContext;

    public SyncInfosFromServerTask(Context context, SyncInfosFromServerCallback syncInfosFromServerCallback) {
        this.mContext = context;
        this.cardDBManager = new CardInfoDBManager(context);
        this.mCallback = syncInfosFromServerCallback;
    }

    public void syncIssuerInfoFromServer() {
        LogX.i("syncIssuerInfoFromServer begin");
        long j = 0;
        for (IssuerInfoItem issuerInfoItem : this.cardDBManager.queryIssuerInfo()) {
            j = j > issuerInfoItem.getTimeStamp() ? j : issuerInfoItem.getTimeStamp();
        }
        QueryIssuerInfoRequest queryIssuerInfoRequest = new QueryIssuerInfoRequest();
        queryIssuerInfoRequest.timeStamp = j;
        QueryIssuerInfoResponse queryIssuerInfo = ServerServiceFactory.createCardServerApi(this.mContext).queryIssuerInfo(queryIssuerInfoRequest);
        int size = queryIssuerInfo.issueInfos.size();
        LogX.i("syncIssuerInfoFromServer queryIssuerInfo response.returnCode : " + queryIssuerInfo.returnCode + " size : " + size);
        if (queryIssuerInfo.returnCode == 0) {
            List arrayList = new ArrayList();
            for (IssuerInfoServerItem issuerInfoItem2 : queryIssuerInfo.issueInfos) {
                arrayList.add(new IssuerInfoItem(issuerInfoItem2));
            }
            if (!arrayList.isEmpty()) {
                this.cardDBManager.insertOrUpdateIssuerInfos(arrayList);
                if (this.mCallback != null) {
                    this.mCallback.syncIssuerInfosFromServerResult(arrayList);
                }
            }
        } else if (queryIssuerInfo.returnCode == -4) {
            Map hashMap = new HashMap();
            String str = "refreshLocalIssuerInfo queryIssuerInfo server overload 503";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_OVERLOAD_ERR, hashMap, str, false, false);
        } else {
            Map hashMap2 = new HashMap();
            String str2 = "refreshLocalIssuerInfo queryIssuerInfo fail, errorcode : " + queryIssuerInfo.returnCode + " size = " + size;
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR, hashMap2, str2, false, false);
        }
        LogX.i("syncIssuerInfoFromServer end");
    }

    public void syncCardProductInfoFromServer() {
        LogX.i("syncCardProductInfoFromServer begin");
        List<CardProductInfoItem> queryCardProductInfo = this.cardDBManager.queryCardProductInfo();
        List<IssuerInfoItem> queryIssuerInfo = this.cardDBManager.queryIssuerInfo();
        if (queryCardProductInfo != null && queryIssuerInfo != null) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            for (IssuerInfoItem issuerInfoItem : queryIssuerInfo) {
                hashMap.put(issuerInfoItem.getIssuerId(), issuerInfoItem);
            }
            for (CardProductInfoItem cardProductInfoItem : queryCardProductInfo) {
                hashMap2.put(cardProductInfoItem.getProductId(), cardProductInfoItem);
            }
            boolean isEmpty = hashMap2.isEmpty();
            QueryCardProductInfoRequest queryCardProductInfoRequest = new QueryCardProductInfoRequest();
            Set newOpenCardRequestParam = getNewOpenCardRequestParam(hashMap, hashMap2);
            if (newOpenCardRequestParam.isEmpty()) {
                queryCardProductInfoRequest = getAllCardRequestParam(hashMap, hashMap2);
            } else if (isEmpty) {
                newOpenCardRequestParam.addAll(getAllTrafficCardReqestParams(hashMap));
                queryCardProductInfoRequest.setTimeStamp(0);
                queryCardProductInfoRequest.setFilters(convertParams(newOpenCardRequestParam));
            } else {
                queryCardProductInfoRequest.setTimeStamp(0);
                queryCardProductInfoRequest.setFilters(convertParams(newOpenCardRequestParam));
            }
            QueryCardProductInfoResponse queryCardProductInfoList = ServerServiceFactory.createCardServerApi(this.mContext).queryCardProductInfoList(queryCardProductInfoRequest);
            int size = queryCardProductInfoList.items.size();
            LogX.i("syncCardProductInfoFromServer queryCardProductInfoList response.returnCode : " + queryCardProductInfoList.returnCode + " size : " + size);
            if (queryCardProductInfoList.returnCode == 0) {
                saveCardInfoToDB(queryCardProductInfoRequest.getFilters(), queryCardProductInfoList);
            } else if (queryCardProductInfoList.returnCode == -4) {
                r0 = new HashMap();
                r1 = "refreshLocalCardProductInfo QueryCardProductInfo server overload 503";
                r0.put(ShowBindBusResultActivity.FAIL_REASON_KEY, r1);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_OVERLOAD_ERR, r0, r1, false, false);
            } else if (queryCardProductInfoList.returnCode == -1 || queryCardProductInfoList.returnCode == -2) {
                LogX.e("syncCardProductInfoFromServer returnCode " + queryCardProductInfoList.returnCode);
            } else {
                r0 = new HashMap();
                r1 = "refreshLocalCardProductInfo QueryCardProductInfo fail code : " + queryCardProductInfoList.returnCode + " size = " + size;
                r0.put(ShowBindBusResultActivity.FAIL_REASON_KEY, r1);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR, r0, r1, false, false);
            }
            LogX.i("syncCardProductInfoFromServer end");
        }
    }

    private void updateMtkinfoAndreserved(List<CardProductInfoItem> list) {
        LogX.i("updateMtkinfoAndreserved enter");
        for (CardProductInfoItem cardProductInfoItem : list) {
            if (cardProductInfoItem != null && "P0000012".equals(cardProductInfoItem.getProductId())) {
                String str = "P0000012_mktInfo";
                String str2 = "P0000012_reserved";
                String deviceModel = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceModel();
                if (StringUtil.isEmpty(deviceModel, true)) {
                    LogX.e("updateMtkinfoAndreserved,deviceModel is empty.");
                    return;
                }
                str = getinfoFromDic(str, deviceModel);
                str2 = getinfoFromDic(str2, deviceModel);
                if (!(str == null || str2 == null)) {
                    cardProductInfoItem.setMktInfo(str);
                    cardProductInfoItem.setReservedInfo(str2);
                }
            }
        }
    }

    private String getinfoFromDic(String str, String str2) {
        QueryDicsRequset queryDicsRequset = new QueryDicsRequset();
        queryDicsRequset.dicName = str;
        queryDicsRequset.itemName = str2;
        QueryDicsResponse queryDics = ServerServiceFactory.createCardServerApi(this.mContext).queryDics(queryDicsRequset);
        if (queryDics == null || queryDics.returnCode != 0) {
            LogX.d("queryDics Response is null object");
            return null;
        }
        LogX.d("queryDics SUCCESS");
        if (queryDics.dicItems.size() > 0) {
            String value = ((DicItem) queryDics.dicItems.get(0)).getValue();
            if (value == null || value.equals("")) {
                value = null;
            } else {
                LogX.d("queryDics info : " + value);
            }
            return value;
        }
        LogX.d("queryDics The size of result's dictory is zero");
        return null;
    }

    private Set<RequestParam> getNewOpenCardRequestParam(Map<String, IssuerInfoItem> map, Map<String, CardProductInfoItem> map2) {
        Set<RequestParam> hashSet = new HashSet();
        if (map == null || map2 == null) {
            return hashSet;
        }
        ArrayList cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (!(cardList == null || cardList.isEmpty())) {
            Iterator it = cardList.iterator();
            while (it.hasNext()) {
                TACardInfo tACardInfo = (TACardInfo) it.next();
                if (!(tACardInfo == null || map2.containsKey(tACardInfo.getProductId()))) {
                    IssuerInfoItem issuerInfoItem = (IssuerInfoItem) map.get(tACardInfo.getIssuerId());
                    if (issuerInfoItem != null) {
                        int mode = issuerInfoItem.getMode();
                        if (Constant.CITIC_ISSUER_ID.equals(tACardInfo.getIssuerId())) {
                            mode = 13;
                        }
                        hashSet.add(new RequestParam(tACardInfo.getProductId(), mode, tACardInfo.getCardType(), tACardInfo.getIssuerId()));
                    }
                }
            }
        }
        return hashSet;
    }

    private QueryCardProductInfoRequest getAllCardRequestParam(Map<String, IssuerInfoItem> map, Map<String, CardProductInfoItem> map2) {
        QueryCardProductInfoRequest queryCardProductInfoRequest = new QueryCardProductInfoRequest();
        Set hashSet = new HashSet();
        queryCardProductInfoRequest.setTimeStamp(0);
        queryCardProductInfoRequest.setFilters(convertParams(hashSet));
        if (map == null || map2 == null) {
            return queryCardProductInfoRequest;
        }
        long j = 0;
        for (CardProductInfoItem cardProductInfoItem : map2.values()) {
            if (cardProductInfoItem != null) {
                if (j <= cardProductInfoItem.getTimeStamp()) {
                    j = cardProductInfoItem.getTimeStamp();
                }
                IssuerInfoItem issuerInfoItem = (IssuerInfoItem) map.get(cardProductInfoItem.getIssuerId());
                if (issuerInfoItem != null) {
                    int mode = issuerInfoItem.getMode();
                    if (Constant.CITIC_ISSUER_ID.equals(cardProductInfoItem.getIssuerId())) {
                        mode = 13;
                    }
                    hashSet.add(new RequestParam(cardProductInfoItem.getProductId(), mode, cardProductInfoItem.getType(), issuerInfoItem.getIssuerId()));
                }
            }
        }
        hashSet.addAll(getAllTrafficCardReqestParams(map));
        queryCardProductInfoRequest.setTimeStamp(j);
        queryCardProductInfoRequest.setFilters(convertParams(hashSet));
        return queryCardProductInfoRequest;
    }

    private Set<RequestParam> getAllTrafficCardReqestParams(Map<String, IssuerInfoItem> map) {
        Set<RequestParam> hashSet = new HashSet();
        if (map == null || map.isEmpty()) {
            return hashSet;
        }
        for (IssuerInfoItem issuerInfoItem : map.values()) {
            if (issuerInfoItem != null && issuerInfoItem.getIssuerType() == 2) {
                hashSet.add(new RequestParam(issuerInfoItem.getProductId(), issuerInfoItem.getMode(), 11, issuerInfoItem.getIssuerId()));
            }
        }
        return hashSet;
    }

    private void saveCardInfoToDB(Set<Map<String, String>> set, QueryCardProductInfoResponse queryCardProductInfoResponse) {
        List arrayList = new ArrayList();
        boolean z = false;
        for (CardProductInfoServerItem cardProductInfoServerItem : queryCardProductInfoResponse.items) {
            boolean z2;
            for (Map map : set) {
                String productId;
                if (cardProductInfoServerItem.getProductId().equals(map.get("productid"))) {
                    productId = cardProductInfoServerItem.getProductId();
                    continue;
                } else {
                    productId = null;
                    continue;
                }
                if (productId != null) {
                    CardProductInfoItem cardProductInfoItem = new CardProductInfoItem(cardProductInfoServerItem);
                    cardProductInfoItem.setProductId(productId);
                    if ("P0000012".equals(productId)) {
                        cardProductInfoItem.setMktInfo("");
                        cardProductInfoItem.setReservedInfo("");
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    arrayList.add(cardProductInfoItem);
                    z = z2;
                }
            }
            z2 = z;
            z = z2;
        }
        LogX.i("saveCardInfoToDB ,isShangHaiUpdate= " + z);
        if (!z) {
            for (CardProductInfoItem cardProductInfoItem2 : this.cardDBManager.queryCardProductInfo()) {
                if ("P0000012".equals(cardProductInfoItem2.getProductId())) {
                    cardProductInfoItem2.setMktInfo("");
                    cardProductInfoItem2.setReservedInfo("");
                    arrayList.add(cardProductInfoItem2);
                }
            }
        }
        LogX.i("saveCardInfoToDB ,insertDBItems.isEmpty()= " + arrayList.isEmpty());
        int size = queryCardProductInfoResponse.items.size();
        LogX.i("saveCardInfoToDB ,insertDBItems.response()= " + size);
        if (!arrayList.isEmpty()) {
            updateMtkinfoAndreserved(arrayList);
            this.cardDBManager.insertOrUpdateCardProductInfos(arrayList);
        }
        if (this.mCallback != null && size > 0) {
            this.mCallback.syncCardProductInfosFromServerResult(arrayList);
        }
    }

    private Set<Map<String, String>> convertParams(Set<RequestParam> set) {
        Set<Map<String, String>> hashSet = new HashSet();
        if (set == null) {
            return hashSet;
        }
        for (RequestParam requestParam : set) {
            if (requestParam != null) {
                hashSet.add(requestParam.convert2Map());
            }
        }
        return hashSet;
    }

    public void run() {
        LogX.i("sync infos from server begin");
        syncIssuerInfoFromServer();
        syncCardProductInfoFromServer();
        LogX.i("sync infos from server end");
    }
}
