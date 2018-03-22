package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.uninstall;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class DeleteTrafficCardSNBOperator {
    private String aid;
    private Context mContext;

    public DeleteTrafficCardSNBOperator(Context context, String str) {
        this.mContext = context;
        this.aid = str;
    }

    public boolean uninstall() {
        if (StringUtil.isEmpty(this.aid, true)) {
            LogX.e("DeleteTrafficCardSNBOperator delete failed. aid is illegal.");
            return false;
        }
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(this.aid);
        if (cardInfoByAid == null) {
            LogX.d("DeleteTrafficCardSNBOperator, taCardInfo not existed ");
            return false;
        }
        IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(cardInfoByAid.issuerId);
        if (cacheIssuerInfoItem == null) {
            LogX.e("DeleteTrafficCardSNBOperator, uninstall failed.IssuerInfoItem not existed ");
            return false;
        }
        String productId = cacheIssuerInfoItem.getProductId();
        Map hashMap = new HashMap();
        if (!StringUtil.isEmpty(productId, true)) {
            CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
            if (cacheCardProductInfoItem != null) {
                hashMap.put("city_code", cacheCardProductInfoItem.getSnbCityBusCode());
            }
        }
        LogX.d("DeleteTrafficCardSNBOperator, delete aid is : " + this.aid);
        int deleteCard = SPIServiceFactory.createSNBService(this.mContext).deleteCard(this.aid, hashMap);
        if (deleteCard == 0) {
            return true;
        }
        LogX.d("DeleteTrafficCardSNBOperator delete failed. snb deleteCard failed. result : " + deleteCard);
        return false;
    }
}
