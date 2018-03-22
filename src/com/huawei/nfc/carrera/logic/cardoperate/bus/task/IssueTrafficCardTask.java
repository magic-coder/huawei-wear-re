package com.huawei.nfc.carrera.logic.cardoperate.bus.task;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicPathConfig;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.IssueTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.base.TrafficCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.impl.SPIOperatorManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

public class IssueTrafficCardTask extends TrafficCardBaseTask {
    private TrafficOrder mOrder;
    private IssueTrafficCardResultHandler mResultHandler;

    public IssueTrafficCardTask(Context context, SPIOperatorManager sPIOperatorManager, String str, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler) {
        super(context, sPIOperatorManager, str);
        this.mOrder = trafficOrder;
        this.mResultHandler = issueTrafficCardResultHandler;
    }

    protected void excuteAction(TrafficCardOperator trafficCardOperator, IssuerInfoItem issuerInfoItem) {
        addTempTaCard(this.mIssuerId);
        trafficCardOperator.issueTrafficCard(issuerInfoItem, this.mOrder, this.mResultHandler);
    }

    public int addTempTaCard(String str) {
        IssuerInfoItem cacheIssuerInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheIssuerInfoItem(str);
        if (cacheIssuerInfoItem == null) {
            return 99;
        }
        if (WalletTaManager.getInstance(this.mContext).getCard(cacheIssuerInfoItem.getAid()) != null) {
            return 0;
        }
        TACardInfo generateTaCardInfo = generateTaCardInfo(cacheIssuerInfoItem.getAid(), 11, str, cacheIssuerInfoItem.getProductId(), null, cacheIssuerInfoItem.getName());
        if (this.mOrder.getPayInfo() != null) {
            generateTaCardInfo.fpanDigest = this.mOrder.getPayInfo().getRequestId();
        }
        if (!StringUtil.isEmpty(this.mOrder.getPhoneNum(), true)) {
            generateTaCardInfo.dpanFour = this.mOrder.getPhoneNum();
        }
        return addCardToTa(generateTaCardInfo);
    }

    private TACardInfo generateTaCardInfo(String str, int i, String str2, String str3, String str4, String str5) {
        TACardInfo tACardInfo = new TACardInfo();
        tACardInfo.aid = str;
        tACardInfo.cardGroupType = 2;
        tACardInfo.cardStatus = i;
        tACardInfo.cardType = 11;
        tACardInfo.dpanDigest = str;
        tACardInfo.dpanFour = null;
        tACardInfo.fpanDigest = null;
        if (!StringUtil.isEmpty(str4, true) && str4.length() >= 4) {
            str4 = str4.substring(str4.length() - 4, str4.length());
        }
        tACardInfo.fpanFour = str4;
        tACardInfo.isDefaultCard = false;
        tACardInfo.issuerId = str2;
        tACardInfo.productId = str3;
        tACardInfo.statusUpdateTime = System.currentTimeMillis();
        tACardInfo.Rf_file_name = str3 + CardPicPathConfig.WALLET_CARD_STORAGE_NAME;
        tACardInfo.background_file_name = str3 + CardPicPathConfig.WALLET_CARD_ICON_STORAGE_NAME;
        tACardInfo.name = str5;
        return tACardInfo;
    }

    private int addCardToTa(TACardInfo tACardInfo) {
        try {
            WalletTaManager.getInstance(this.mContext).addCard(tACardInfo);
            return 0;
        } catch (Throwable e) {
            LogX.e("IssueTrafficCardTask addCardToTa failed WalletTaCardAlreadyExistException. ", Log.getStackTraceString(e));
            return 99;
        } catch (Throwable e2) {
            LogX.e("IssueTrafficCardTask addCardToTa failed WalletTaCardNumReachMaxException. ", Log.getStackTraceString(e2));
            return IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT;
        } catch (Throwable e3) {
            LogX.e("IssueTrafficCardTask addCardToTa failed WalletTaBadParammeterException. ", Log.getStackTraceString(e3));
            return 99;
        } catch (Throwable e32) {
            LogX.e("IssueTrafficCardTask addCardToTa failed WalletTaSystemErrorException. ", Log.getStackTraceString(e32));
            return 99;
        }
    }
}
