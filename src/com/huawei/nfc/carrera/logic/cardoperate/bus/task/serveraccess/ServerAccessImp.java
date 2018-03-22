package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.carrera.logic.appletcardinfo.AppletInfoApiFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OfflineTrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.IssueTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryAndHandleUnfinishedOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryOfflineTrafficCardInfoResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryRecordsListResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RechargeResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RefundResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.UninstallTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.p190v.C2538c;

public class ServerAccessImp implements TrafficCardOperator {
    private static final String TAG = "ServerAccessImp";
    private Context mContext;

    public ServerAccessImp(Context context) {
        this.mContext = context;
    }

    public void preIssueTrafficCard(IssuerInfoItem issuerInfoItem) {
        new InitDmsdAndDownloadAppletOperator(this.mContext, issuerInfoItem.getAid(), issuerInfoItem.getIssuerId(), true).excute();
    }

    public void issueTrafficCard(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler) {
        new PersonalizingBusCardOprator(this.mContext, issuerInfoItem, trafficOrder, issueTrafficCardResultHandler).issueTrafficCard();
    }

    public void applyPayOrder(IssuerInfoItem issuerInfoItem, double d, int i, int i2, String str, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
    }

    public void applyPayOrder(IssuerInfoItem issuerInfoItem, ApplyOrderInfo applyOrderInfo, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        new ApplyPayOrderOperator(this.mContext, issuerInfoItem, applyOrderInfo, applyPayOrderResultHandler).doApplyPayOrder();
    }

    public void uninstallTrafficCard(IssuerInfoItem issuerInfoItem, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler) {
        C2538c.c(TAG, new Object[]{" enter uninstallTrafficCard "});
        new UninstallTrafficCardSAOperator(this.mContext, issuerInfoItem, uninstallTrafficCardResultHandler).uninstall();
    }

    public void recharge(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler) {
        new RechargeSAOperator(this.mContext, issuerInfoItem, trafficOrder, rechargeResultHandler).recharge("0");
        C2538c.c(TAG, new Object[]{"recharge end"});
    }

    public void queryAndHandleUnfinfishedOrders(IssuerInfoItem issuerInfoItem, int i, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler) {
        new QueryAndHandleUnfinishedOrdersSAOperator(this.mContext, issuerInfoItem, i, true, queryAndHandleUnfinishedOrderResultHandler).queryAndHandleUnfinishedOrders();
    }

    public void queryRecords(IssuerInfoItem issuerInfoItem, int i, QueryRecordsListResultHandler queryRecordsListResultHandler) {
        new QueryRecordsSAOperator(this.mContext, issuerInfoItem, i, queryRecordsListResultHandler).queryRecords();
    }

    public void refund(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RefundResultHandler refundResultHandler) {
    }

    public TrafficActivityInfo getIssueCardCoupon(String str, IssuerInfoItem issuerInfoItem) {
        return new QueryAmountSAOperator("1", this.mContext, issuerInfoItem).queryAmount();
    }

    public TrafficActivityInfo getRechargeCoupon(IssuerInfoItem issuerInfoItem) {
        C2538c.c(TAG, new Object[]{"enter getRechargeCoupon "});
        return new QueryAmountSAOperator("2", this.mContext, issuerInfoItem).queryAmount();
    }

    public void queryOfflineCardInfo(IssuerInfoItem issuerInfoItem, int i, QueryOfflineTrafficCardInfoResultHandler queryOfflineTrafficCardInfoResultHandler) {
        int i2;
        String aid = issuerInfoItem.getAid();
        if ((i & 1) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((i & 2) != 0) {
            i2 |= 2;
        }
        if ((i & 4) != 0) {
            i2 |= 4;
        }
        AppletCardResult readTrafficCardInfo = AppletInfoApiFactory.createAppletCardInfoReader(this.mContext).readTrafficCardInfo(aid, issuerInfoItem.getProductId(), i2);
        if (readTrafficCardInfo.getResultCode() == 0) {
            OfflineTrafficCardInfo offlineTrafficCardInfo = new OfflineTrafficCardInfo();
            CardInfo cardInfo = (CardInfo) readTrafficCardInfo.getData();
            offlineTrafficCardInfo.setCardNo(cardInfo.getCardNum());
            if ((i & 2) != 0) {
                offlineTrafficCardInfo.setBalance(cardInfo.getFormatedBalanceByYuanUnit());
            }
            if ((i & 4) != 0) {
                offlineTrafficCardInfo.setExpireDate(cardInfo.getFormatedExpireDate("yyyy/MM/dd"));
            }
            if (queryOfflineTrafficCardInfoResultHandler != null) {
                queryOfflineTrafficCardInfoResultHandler.handleResult(0, offlineTrafficCardInfo);
            }
        } else if (queryOfflineTrafficCardInfoResultHandler != null) {
            queryOfflineTrafficCardInfoResultHandler.handleResult(SpiResultCodeTranslator.geteSEErrorCode(readTrafficCardInfo.getResultCode()), null);
        }
    }
}
