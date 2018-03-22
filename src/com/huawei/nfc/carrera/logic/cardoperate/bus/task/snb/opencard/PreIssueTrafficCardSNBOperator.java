package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.CreateSSDTsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

public class PreIssueTrafficCardSNBOperator {
    private static final String TAG = "PreIssueTrafficCardSNBOperator";
    private Context mContext;
    private IssuerInfoItem mInfos;

    public PreIssueTrafficCardSNBOperator(Context context, IssuerInfoItem issuerInfoItem) {
        this.mContext = context;
        this.mInfos = issuerInfoItem;
    }

    public void preIssueTrafficCard() {
        SPIServiceFactory.createSNBService(this.mContext);
        LogX.i("tsm preIssueTrafficCard begin");
        if (this.mInfos == null) {
            LogX.w("tsm PreIssueTrafficCardSNBTask installSSD failed, can not find issuer info.");
            return;
        }
        String aid = this.mInfos.getAid();
        if (StringUtil.isEmpty(aid, true)) {
            LogX.w("tsm PreIssueTrafficCardSNBTask installSSD failed, aid or productId is illegal. aid = " + aid);
            return;
        }
        CreateSSDTsmOperator createSSDTsmOperator = new CreateSSDTsmOperator(this.mContext, aid, this.mInfos.getIssuerId());
        C2538c.b(TAG, new Object[]{" CardEvent CREATESSD bus cardEvent START_LOCK"});
        WalletTaManager.getInstance(this.mContext).cardEvent(aid, 2);
        int excute = createSSDTsmOperator.excute();
        if (excute != 0) {
            String str = "tsm PreIssueTrafficCardSNBTask installSSD, create ssd failed response = " + excute;
            Map hashMap = new HashMap();
            hashMap.put("aid", aid);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excute));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_DMSD_INSTALL_FAIL, hashMap, str, false, false);
            return;
        }
        LogX.i("create SSD  successfully");
        String productId = this.mInfos.getProductId();
        if (StringUtil.isEmpty(productId, true)) {
            LogX.w("PreIssueTrafficCardSNBTask loadAndInstallApplet failed, productId is illegal. productId = " + productId);
            return;
        }
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
        if (cacheCardProductInfoItem == null) {
            LogX.e("preIssueTrafficCardSNBTask loadAndInstallApplet failed, can not get card product info! ");
            return;
        }
        String queryCityAndCardList;
        Map hashMap2 = new HashMap();
        if (Constant.LNT_CARD_ISSERID.equals(cacheCardProductInfoItem.getIssuerId())) {
            queryCityAndCardList = new QueryCityAndCardListSNBOperator(this.mContext).queryCityAndCardList(aid);
            if (StringUtil.isEmpty(queryCityAndCardList, true)) {
                LogX.e("preIssueTrafficCardSNBTask loadAndInstallApplet failed, get lnt cityCode failed!");
                return;
            }
            hashMap2.put("city_code", queryCityAndCardList);
        } else if (!StringUtil.isEmpty(cacheCardProductInfoItem.getSnbCityBusCode(), true)) {
            hashMap2 = new HashMap();
            hashMap2.put("city_code", cacheCardProductInfoItem.getSnbCityBusCode());
        }
        LogX.i("preIssueTrafficCardSNBTask SNB issuerId LNT , issuerId" + cacheCardProductInfoItem.getIssuerId());
        if (Constant.LNT_CARD_ISSERID.equals(cacheCardProductInfoItem.getIssuerId())) {
            LogX.i("preIssueTrafficCard SNB issuerId is LNT return , successfully end");
            return;
        }
        LogX.i("preIssueTrafficCardSNBTask SNB loadAndInstallApplet begin.");
        excute = SPIServiceFactory.createSNBService(this.mContext).loadAndInstallApplet(aid, hashMap2);
        if (excute != 0) {
            str = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
            queryCityAndCardList = "preIssueTrafficCardSNBTask SNBService loadAndInstallApplet failed. response = " + excute;
            Map hashMap3 = new HashMap();
            hashMap3.put("aid", aid);
            hashMap3.put("cplc", str);
            hashMap3.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excute));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_LOAD_AND_INSTALL_APPLET_FAIL, hashMap3, queryCityAndCardList, false, false);
            return;
        }
        LogX.i("preIssueTrafficCardSNBTask SNB loadAndInstallApplet success.response" + excute);
        LogX.i("preIssueTrafficCard successfully end");
    }
}
