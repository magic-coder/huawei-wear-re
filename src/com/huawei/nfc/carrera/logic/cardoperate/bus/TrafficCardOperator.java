package com.huawei.nfc.carrera.logic.cardoperate.bus;

import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
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

public interface TrafficCardOperator {
    void applyPayOrder(IssuerInfoItem issuerInfoItem, double d, int i, int i2, String str, ApplyPayOrderResultHandler applyPayOrderResultHandler);

    void applyPayOrder(IssuerInfoItem issuerInfoItem, ApplyOrderInfo applyOrderInfo, ApplyPayOrderResultHandler applyPayOrderResultHandler);

    TrafficActivityInfo getIssueCardCoupon(String str, IssuerInfoItem issuerInfoItem);

    TrafficActivityInfo getRechargeCoupon(IssuerInfoItem issuerInfoItem);

    void issueTrafficCard(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler);

    void preIssueTrafficCard(IssuerInfoItem issuerInfoItem);

    void queryAndHandleUnfinfishedOrders(IssuerInfoItem issuerInfoItem, int i, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler);

    void queryOfflineCardInfo(IssuerInfoItem issuerInfoItem, int i, QueryOfflineTrafficCardInfoResultHandler queryOfflineTrafficCardInfoResultHandler);

    void queryRecords(IssuerInfoItem issuerInfoItem, int i, QueryRecordsListResultHandler queryRecordsListResultHandler);

    void recharge(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler);

    void refund(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RefundResultHandler refundResultHandler);

    void uninstallTrafficCard(IssuerInfoItem issuerInfoItem, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler);
}
