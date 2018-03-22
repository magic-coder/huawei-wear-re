package com.huawei.nfc.carrera.logic.appletcardinfo.configdata;

import android.content.Context;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.ApduSet;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ConfigDataManager implements ConfigData {
    private static final String APDU_QUERY_CARD_NUM = "00B2011400";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "ConfigData";
    private static volatile ConfigDataManager sInstance;
    private ApduSet currentApduSet;
    private Map<String, List<HciConfigInfo>> hciConfigDatas = new HashMap();
    private Map<String, List<ApduCommand>> localApduRepo = new HashMap();
    private Context mContext;
    private Map<String, ApduSet> oriApduDatas = new HashMap();

    private ConfigDataManager(Context context) {
        this.mContext = context;
    }

    public static ConfigDataManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (SYNC_LOCK) {
                if (sInstance == null) {
                    sInstance = new ConfigDataManager(context);
                }
            }
        }
        return sInstance;
    }

    private void prepareApdus(String str) throws AppletCardException {
        ApduSet apduSet = (ApduSet) this.oriApduDatas.get(str);
        if (apduSet == null) {
            parseJson2ApduSet(str);
            apduSet = (ApduSet) this.oriApduDatas.get(str);
        }
        this.currentApduSet = apduSet;
    }

    public boolean isSameApduNumAndDate(String str) throws AppletCardException {
        prepareApdus(str);
        return this.currentApduSet.isSameApduNumAndDate();
    }

    public List<ApduCommand> getApudList(String str, int i) throws AppletCardException {
        C2538c.c(TAG, new Object[]{" getApudList begin. productId : " + str + " type : " + i});
        prepareApdus(str);
        List<ApduCommand> list = null;
        switch (i) {
            case 0:
                list = this.currentApduSet.getApduByType("status");
                break;
            case 1:
                list = this.currentApduSet.getApduByType(Constants.FIELD_APPLET_CONFIG_NUM);
                break;
            case 2:
                list = this.currentApduSet.getApduByType("date");
                break;
            case 3:
                list = this.currentApduSet.getApduByType("amount");
                break;
            case 4:
                list = this.currentApduSet.getApduByType("records");
                break;
        }
        if (list != null || i == 0) {
            C2538c.c(TAG, new Object[]{" getApudList end. productId : " + str + " type : " + i});
            return list;
        }
        throw new AppletCardException(2, "apdu is null for card " + str + " apdu type : " + i);
    }

    private void parseJson2ApduSet(String str) {
        C2538c.c(TAG, new Object[]{"parseJson2ApduSet begin for " + str});
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(str);
        if (cacheCardProductInfoItem == null) {
            C2538c.c(TAG, new Object[]{" parseJson2ApduSet infoItem is null  "});
            return;
        }
        List reservedNField = cacheCardProductInfoItem.getReservedNField();
        if (reservedNField == null) {
            C2538c.c(TAG, new Object[]{"parseJson2ApduSet oriDatas is null "});
            return;
        }
        try {
            ApduSet parseJson2ApduSet = new AppletInfoConfigDataParser(this.mContext, reservedNField).parseJson2ApduSet(str);
            C2538c.c(TAG, new Object[]{"parseJson2ApduSet end for " + str});
            this.oriApduDatas.put(str, parseJson2ApduSet);
        } catch (AppletCardException e) {
            C2538c.c(TAG, new Object[]{"AppletCardException e : " + e.getMessage()});
        }
    }
}
