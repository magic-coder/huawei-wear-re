package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QuerySupportedCardListByTerminalRequest;
import com.huawei.nfc.carrera.server.card.response.QuerySupportedCardListByTerminalResponse;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.utils.PackageUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class QuerySupportedCardListTask<T> {
    private static final String CLIENT_VERSION_CODE = "client_version_code";
    private static final String DEVICE_SN_OF_SUPPORT_CARD = "device_sn_of_support_card";
    private static final String HUAWEI_WEAR = "HUAWEI-WEAR";
    private static final String KEY_QUERY_SUPPORTED_CARD_ISSUERS = "query_supported_card_issuers";
    private static final String KEY_QUERY_SUPPORTED_CARD_TIME = "query_supported_card_time";
    private static final long QUERY_SUPPORT_CARD_VALID_TIME = 43200000;
    private static final String ROM_VERSION = "rom_version";
    private static final String TAG = "QuerySupportedCardListTask";
    protected Context mContext;

    protected abstract T getSupportedCard(IssuerInfoItem issuerInfoItem);

    public QuerySupportedCardListTask(Context context) {
        this.mContext = context;
    }

    public Map<String, T> getSupportedCardList() {
        Map<String, T> linkedHashMap = new LinkedHashMap();
        Map cacheIssuerInfoItems = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItems();
        if (cacheIssuerInfoItems.isEmpty()) {
            return linkedHashMap;
        }
        List localSupportedIssuers = getLocalSupportedIssuers();
        LogX.i("getSupportedCardList getLocalSupportedIssuers size : " + localSupportedIssuers.size());
        long longValue = NFCPreferences.getInstance(this.mContext).getLong(KEY_QUERY_SUPPORTED_CARD_TIME, Long.valueOf(0)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (localSupportedIssuers.size() == 0 || !isLastCheckTimeValid(longValue, currentTimeMillis) || isRomOrClientVersionChanged()) {
            localSupportedIssuers = querySupportedIssuersFromServer();
            LogX.i("getSupportedCardList querySupportedIssuersFromServer size : " + localSupportedIssuers.size());
        }
        for (String str : r0) {
            IssuerInfoItem issuerInfoItem = (IssuerInfoItem) cacheIssuerInfoItems.get(str);
            if (issuerInfoItem != null) {
                Object supportedCard = getSupportedCard(issuerInfoItem);
                if (supportedCard != null) {
                    linkedHashMap.put(issuerInfoItem.getIssuerId(), supportedCard);
                }
            }
        }
        LogX.i("getSupportedCardList end");
        return linkedHashMap;
    }

    private boolean isLastCheckTimeValid(long j, long j2) {
        return Math.abs(j2 - j) < QUERY_SUPPORT_CARD_VALID_TIME;
    }

    private boolean isRomOrClientVersionChanged() {
        boolean z;
        boolean z2;
        C2538c.b(TAG, new Object[]{"enter isRomOrClientVersionChanged "});
        int b = PackageUtil.m28462b(this.mContext);
        String wearRomVersion = getWearRomVersion();
        String deviceSN = getDeviceSN();
        C2538c.b(TAG, new Object[]{" new get clientVersionCode : " + b + " ; romVersion : " + wearRomVersion});
        int i = NFCPreferences.getInstance(this.mContext).getInt(CLIENT_VERSION_CODE, 0);
        String string = NFCPreferences.getInstance(this.mContext).getString("rom_version", "");
        String string2 = NFCPreferences.getInstance(this.mContext).getString(DEVICE_SN_OF_SUPPORT_CARD, "");
        C2538c.b(TAG, new Object[]{" local localClientVersion : " + i + " ; localRomVersion : " + string + " ; localDevice_SN : " + string2});
        boolean z3 = i == 0 || b != i;
        if (StringUtil.isEmpty(string, true) || !wearRomVersion.equals(string)) {
            z = true;
        } else {
            z = false;
        }
        if (StringUtil.isEmpty(string2, true) || !deviceSN.equals(string2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z3) {
            NFCPreferences.getInstance(this.mContext).putInt(CLIENT_VERSION_CODE, b);
        }
        if (z) {
            NFCPreferences.getInstance(this.mContext).putString("rom_version", wearRomVersion);
        }
        if (z2) {
            NFCPreferences.getInstance(this.mContext).putString(DEVICE_SN_OF_SUPPORT_CARD, deviceSN);
        }
        if (z3 || z || z2) {
            return true;
        }
        return false;
    }

    private List<String> querySupportedIssuersFromServer() {
        int b = PackageUtil.m28462b(this.mContext);
        String wearModle = getWearModle();
        String wearRomVersion = getWearRomVersion();
        QuerySupportedCardListByTerminalRequest querySupportedCardListByTerminalRequest = new QuerySupportedCardListByTerminalRequest();
        querySupportedCardListByTerminalRequest.setTerminal(wearModle);
        querySupportedCardListByTerminalRequest.setRomVersion(wearRomVersion);
        querySupportedCardListByTerminalRequest.setWalletVersion(String.valueOf(b));
        QuerySupportedCardListByTerminalResponse querySupportedCardListByTerminal = ServerServiceFactory.createCardServerApi(this.mContext).querySupportedCardListByTerminal(querySupportedCardListByTerminalRequest);
        LogX.i("getSupportedCardList querySupportedCardListByTerminal returnCode : " + querySupportedCardListByTerminal.returnCode);
        String str;
        if (querySupportedCardListByTerminal.returnCode == 0) {
            str = querySupportedCardListByTerminal.issuersString;
            if (!StringUtil.isEmpty(str, true)) {
                NFCPreferences.getInstance(this.mContext).putString(KEY_QUERY_SUPPORTED_CARD_ISSUERS, str);
                NFCPreferences.getInstance(this.mContext).putLong(KEY_QUERY_SUPPORTED_CARD_TIME, Long.valueOf(System.currentTimeMillis()));
                return Arrays.asList(str.split("\\|"));
            }
        } else if (querySupportedCardListByTerminal.returnCode == -4) {
            Map hashMap = new HashMap();
            wearModle = "getSupportedCardList querySupportedCardListByTerminal server overload 503";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, wearModle);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_OVERLOAD_ERR, hashMap, wearModle, false, false);
        } else if (querySupportedCardListByTerminal.returnCode == -1 || querySupportedCardListByTerminal.returnCode == -2) {
            LogX.e("getSupportedCardList querySupportedCardListByTerminal " + querySupportedCardListByTerminal.returnCode);
        } else {
            Map hashMap2 = new HashMap();
            str = "getSupportedCardList querySupportedCardListByTerminal fail, error code : " + querySupportedCardListByTerminal.returnCode;
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR, hashMap2, str, false, false);
        }
        return new ArrayList();
    }

    private List<String> getLocalSupportedIssuers() {
        String string = NFCPreferences.getInstance(this.mContext).getString(KEY_QUERY_SUPPORTED_CARD_ISSUERS, "");
        if (StringUtil.isEmpty(string, true)) {
            return new ArrayList();
        }
        return Arrays.asList(string.split("\\|"));
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
