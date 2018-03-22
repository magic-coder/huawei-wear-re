package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.cardinfo.callback.RefreshLocalIconCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.RefreshLocalRFConfCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SyncRFConfFilesCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicRescManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.RFConfInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryRFConfURLResquest;
import com.huawei.nfc.carrera.server.card.response.QueryRFConfURLResponse;
import com.huawei.nfc.carrera.server.card.response.RFConfServerInfo;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class SyncRFConfFilesTask {
    private static final int DELETE_CONF_FAILED = -1;
    private static final int DELETE_CONF_NOT_EXISTS = 1;
    private static final int DELETE_CONF_SUCCESS = 0;
    private static final String DEVICE_SN_OF_RF = "DEVICE_SN_OF_RF";
    private static final String HUAWEI_WEAR = "HUAWEI-WEAR";
    private static final String TAG = "SyncRFConfFilesTask";
    private CardInfoDBManager cardInfoDBManager;
    private CardPicRescManager cardPicRescManager;
    private Context mContext;
    private RefreshLocalIconCallback mRFSyncCallback = new C55451();
    private SyncRFConfFilesCallback mResultCallback;
    private CardInfoRefresher mUIHandler;

    class C55451 implements RefreshLocalRFConfCallback {
        C55451() {
        }

        public void refreshPicResult(int i) {
            C2538c.c(SyncRFConfFilesTask.TAG, new Object[]{" refreshRFConfFile result. refreshResultCode : " + i});
        }

        public void refreshPicResult(String str, int i) {
            int i2 = 1;
            C2538c.c(SyncRFConfFilesTask.TAG, new Object[]{" refreshRFConfFile result. issuerId : " + str + " refreshResultCode : " + i});
            if (1 != i) {
                if (i == 0) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
            }
            if (SyncRFConfFilesTask.this.mResultCallback != null) {
                SyncRFConfFilesTask.this.mUIHandler.handleSyncRFConfFileResult(i2, str, SyncRFConfFilesTask.this.mResultCallback);
            }
        }
    }

    public SyncRFConfFilesTask(Context context, CardInfoRefresher cardInfoRefresher, SyncRFConfFilesCallback syncRFConfFilesCallback) {
        this.mContext = context;
        this.mUIHandler = cardInfoRefresher;
        this.mResultCallback = syncRFConfFilesCallback;
        this.cardPicRescManager = CardPicRescManager.getInstance(context);
        this.cardInfoDBManager = new CardInfoDBManager(context);
    }

    public void refreshRFConfFiles() {
        Iterator it;
        C2538c.c(TAG, new Object[]{" refreshRFConfFiles begin"});
        HashMap syncRFConfURLInfoFromServer = syncRFConfURLInfoFromServer();
        if (syncRFConfURLInfoFromServer.isEmpty()) {
            C2538c.c(TAG, new Object[]{" syncRFConfURLInfoFromServer no newer records get from server."});
            syncRFConfURLInfoFromServer = this.cardInfoDBManager.queryRFConfInfo();
            if (syncRFConfURLInfoFromServer == null) {
                syncRFConfURLInfoFromServer = new HashMap();
            }
            it = syncRFConfURLInfoFromServer.entrySet().iterator();
        } else {
            it = syncRFConfURLInfoFromServer.entrySet().iterator();
        }
        if (it.hasNext()) {
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                String str = (String) entry.getKey();
                RFConfInfoItem rFConfInfoItem = (RFConfInfoItem) entry.getValue();
                C2538c.c(TAG, new Object[]{" refreshRFConfFiles issuerId : " + str});
                this.cardPicRescManager.refreshLocalRFConfFiles(str, rFConfInfoItem.getRfURL(), this.mRFSyncCallback);
            }
        } else if (this.mResultCallback != null) {
            this.mUIHandler.handleSyncRFConfFileResult(2, "", this.mResultCallback);
        }
        C2538c.c(TAG, new Object[]{" refreshRFConfFiles end"});
    }

    private HashMap<String, RFConfInfoItem> syncRFConfURLInfoFromServer() {
        HashMap<String, RFConfInfoItem> hashMap = new HashMap();
        List<QueryRFConfURLResquest> createQueryRFConfRequset = createQueryRFConfRequset();
        if (createQueryRFConfRequset == null) {
            return hashMap;
        }
        List<RFConfServerInfo> arrayList = new ArrayList();
        for (QueryRFConfURLResquest queryRFConfURL : createQueryRFConfRequset) {
            QueryRFConfURLResponse queryRFConfURL2 = ServerServiceFactory.createCardServerApi(this.mContext).queryRFConfURL(queryRFConfURL);
            if (queryRFConfURL2 == null || queryRFConfURL2.returnCode != 0) {
                Object obj;
                String str = TAG;
                Object[] objArr = new Object[1];
                StringBuilder append = new StringBuilder().append(" syncRFConfURLInfoFromServer failed. query server failed. retCode = ");
                if (queryRFConfURL2 == null) {
                    obj = "response is null";
                } else {
                    obj = Integer.valueOf(queryRFConfURL2.returnCode);
                }
                objArr[0] = append.append(obj).toString();
                C2538c.d(str, objArr);
            } else if (queryRFConfURL2.rfConfInfos != null) {
                arrayList.add(queryRFConfURL2.rfConfInfos);
            }
        }
        if (arrayList.isEmpty()) {
            return hashMap;
        }
        for (RFConfServerInfo rFConfServerInfo : arrayList) {
            if (rFConfServerInfo != null) {
                int deleteRFConf = deleteRFConf(rFConfServerInfo.getIssuerId());
                if (deleteRFConf == 0 || deleteRFConf == 1) {
                    hashMap.put(rFConfServerInfo.getIssuerId(), new RFConfInfoItem(rFConfServerInfo));
                }
            }
        }
        this.cardInfoDBManager.insertOrUpdateRFConfInfos(new ArrayList(hashMap.values()));
        return hashMap;
    }

    private List<QueryRFConfURLResquest> createQueryRFConfRequset() {
        C2538c.c(TAG, new Object[]{" enter createQueryRFConfRequset "});
        ArrayList cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (cardList == null || cardList.isEmpty()) {
            return null;
        }
        HashMap hashMap;
        HashMap queryRFConfInfo = this.cardInfoDBManager.queryRFConfInfo();
        C2538c.c(TAG, new Object[]{"  queryRFConfInfo end "});
        if (queryRFConfInfo == null) {
            hashMap = new HashMap();
        } else {
            hashMap = queryRFConfInfo;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = cardList.iterator();
        while (it.hasNext()) {
            TACardInfo tACardInfo = (TACardInfo) it.next();
            if (!(tACardInfo == null || tACardInfo.getCardGroupType() != 2 || hashMap.keySet().contains(tACardInfo.getIssuerId()))) {
                arrayList.add(tACardInfo.getIssuerId());
            }
        }
        List<QueryRFConfURLResquest> arrayList2 = new ArrayList();
        String wearModle = getWearModle();
        String wearRomVersion = getWearRomVersion();
        String deviceSN = getDeviceSN();
        String string = NFCPreferences.getInstance(this.mContext).getString(DEVICE_SN_OF_RF, "");
        C2538c.c(TAG, new Object[]{"  issuerIds is :  " + arrayList.isEmpty()});
        if (arrayList.isEmpty()) {
            Iterator it2 = hashMap.values().iterator();
            while (it2 != null && it2.hasNext()) {
                RFConfInfoItem rFConfInfoItem = (RFConfInfoItem) it2.next();
                arrayList.add(rFConfInfoItem.getIssuerId());
                long timeStamp = rFConfInfoItem.getTimeStamp();
                String romVersion = rFConfInfoItem.getRomVersion();
                if (!(StringUtil.isEmpty(romVersion, true) || romVersion.length() <= 0 || wearRomVersion.equals(romVersion))) {
                    timeStamp = 0;
                }
                if (!deviceSN.equals(string)) {
                    timeStamp = 0;
                }
                arrayList2.add(new QueryRFConfURLResquest(wearModle, wearRomVersion, rFConfInfoItem.getIssuerId(), timeStamp));
            }
        } else {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                arrayList2.add(new QueryRFConfURLResquest(wearModle, wearRomVersion, (String) it3.next(), 0));
            }
        }
        NFCPreferences.getInstance(this.mContext).putString(DEVICE_SN_OF_RF, deviceSN);
        return arrayList2;
    }

    private String getWearRomVersion() {
        C2538c.b(TAG, new Object[]{"enter getWearRomVersion"});
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(HUAWEI_WEAR).append(HwAccountConstants.SPLIIT_UNDERLINE).append(getWearModle()).append(HwAccountConstants.SPLIIT_UNDERLINE).append(getWearBTVersion());
        return stringBuffer.toString();
    }

    private String getWearBTVersion() {
        C2538c.b(TAG, new Object[]{"enter getWearBTVersion"});
        if (this.mContext == null) {
            return "";
        }
        String versionStr = getVersionStr(ESEInfoManager.getInstance(this.mContext).getDeviceBTVersion());
        if (!StringUtil.isEmpty(versionStr, true)) {
            return versionStr;
        }
        C2538c.b(TAG, new Object[]{"getWearBTVersion btVersion is null"});
        return "";
    }

    private String getWearModle() {
        C2538c.b(TAG, new Object[]{"enter getWearModle"});
        if (this.mContext == null) {
            return "";
        }
        String deviceModel = ESEInfoManager.getInstance(this.mContext).getDeviceModel();
        if (!StringUtil.isEmpty(deviceModel, true)) {
            return deviceModel;
        }
        C2538c.b(TAG, new Object[]{"getWearModle watchModle is null"});
        return "";
    }

    private String getVersionStr(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = "";
        if (str == null) {
            return str2;
        }
        String[] split = str.split("\\.");
        if (split.length > 2) {
            return stringBuffer.append(split[0]).append(".").append(split[1]).append(".").append(split[2]).toString();
        }
        return str;
    }

    private int deleteRFConf(String str) {
        File file = new File(this.cardPicRescManager.getCardRFConfFilePath(str));
        if (file.exists()) {
            return file.delete() ? 0 : -1;
        } else {
            return 1;
        }
    }

    private String getDeviceSN() {
        C2538c.b(TAG, new Object[]{"enter getDeviceSN"});
        if (this.mContext == null) {
            return "";
        }
        String deviceSN = ESEInfoManager.getInstance(this.mContext).getDeviceSN();
        if (!StringUtil.isEmpty(deviceSN, true)) {
            return deviceSN;
        }
        C2538c.b(TAG, new Object[]{"getDeviceSN watchModle is null"});
        return "";
    }
}
