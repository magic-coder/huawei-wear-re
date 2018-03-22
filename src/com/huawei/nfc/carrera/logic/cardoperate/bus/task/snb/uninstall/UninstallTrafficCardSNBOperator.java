package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.uninstall;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.UninstallTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class UninstallTrafficCardSNBOperator {
    private Context mContext;
    private IssuerInfoItem mInfo;
    private UninstallTrafficCardResultHandler mResultHandler;

    public UninstallTrafficCardSNBOperator(Context context, IssuerInfoItem issuerInfoItem, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = uninstallTrafficCardResultHandler;
    }

    public void uninstall() {
        String aid = this.mInfo.getAid();
        String productId = this.mInfo.getProductId();
        if (StringUtil.isEmpty(aid, true)) {
            LogX.w("UninstallTrafficCardSNBOperator uninstall failed. aid is illegal.");
            this.mResultHandler.handleResult(10);
            return;
        }
        Map hashMap = new HashMap();
        if (!StringUtil.isEmpty(productId, true)) {
            CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
            if (cacheCardProductInfoItem != null) {
                hashMap.put("city_code", cacheCardProductInfoItem.getSnbCityBusCode());
            }
        }
        int deleteCard = SPIServiceFactory.createSNBService(this.mContext).deleteCard(aid, hashMap);
        if (deleteCard != 0) {
            LogX.w("UninstallTrafficCardSNBOperator uninstall failed. snb deleteCard failed. result : " + deleteCard);
            this.mResultHandler.handleResult(SpiResultCodeTranslator.getSnbResultCode(deleteCard));
        } else if (updateTaAndReport(aid)) {
            this.mResultHandler.handleResult(0);
        } else {
            this.mResultHandler.handleResult(99);
        }
    }

    private boolean updateTaAndReport(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).removeCardByAid(str);
            CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(str, null);
            return true;
        } catch (Throwable e) {
            LogX.w("UninstallTrafficCardTask updateTaAndReport WalletTaCardNotExistException, ta removeCard failed", e);
            return false;
        } catch (Throwable e2) {
            LogX.w("UninstallTrafficCardTask updateTaAndReport WalletTaSystemErrorException, ta removeCard failed", e2);
            return false;
        }
    }
}
