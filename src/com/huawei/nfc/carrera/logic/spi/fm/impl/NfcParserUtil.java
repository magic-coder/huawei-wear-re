package com.huawei.nfc.carrera.logic.spi.fm.impl;

import cn.com.fmsh.nfcos.client.service.huawei.CardAppInfo;
import cn.com.fmsh.nfcos.client.service.huawei.CardAppRecord;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosMainOrder;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosPayOrder;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.MainOrder;
import cn.com.fmsh.tsm.business.bean.PayOrder;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NfcParserUtil {
    private static final String TAG = "NfcParserUtil";

    protected static NfcosMainOrder parseMainOrder2NfcType(MainOrder mainOrder) {
        NfcosMainOrder nfcosMainOrder = new NfcosMainOrder();
        if (mainOrder != null) {
            nfcosMainOrder.businessOrders = parseBusinessOrders2NfcsType(mainOrder.getBusinessOrders());
            nfcosMainOrder.payOrders = parsePayOrders2Nfcs(mainOrder.getPayOrders());
            nfcosMainOrder.amount = mainOrder.getAmount();
            nfcosMainOrder.date = mainOrder.getDate();
            nfcosMainOrder.id = mainOrder.getId();
            nfcosMainOrder.state = mainOrder.getState().getId();
            nfcosMainOrder.time = mainOrder.getTime();
        }
        return nfcosMainOrder;
    }

    protected static List<NfcosBusinessOrder> parseBusinessOrders2NfcsType(BusinessOrder[] businessOrderArr) {
        Object arrayList = new ArrayList();
        if (businessOrderArr != null) {
            for (BusinessOrder parseBusinessOrder2NfcosType : businessOrderArr) {
                arrayList.add(parseBusinessOrder2NfcosType(parseBusinessOrder2NfcosType));
            }
        }
        return arrayList;
    }

    protected static List<NfcosPayOrder> parsePayOrders2Nfcs(PayOrder[] payOrderArr) {
        Object arrayList = new ArrayList();
        if (payOrderArr != null) {
            for (PayOrder parsePayOrder2NfcosOrder : payOrderArr) {
                arrayList.add(parsePayOrder2NfcosOrder(parsePayOrder2NfcosOrder));
            }
        }
        return arrayList;
    }

    protected static NfcosBusinessOrder parseBusinessOrder2NfcosType(BusinessOrder businessOrder) {
        NfcosBusinessOrder nfcosBusinessOrder = new NfcosBusinessOrder();
        if (businessOrder != null) {
            nfcosBusinessOrder.faceNo = businessOrder.getTac();
            nfcosBusinessOrder.tradeTime = businessOrder.getTradeTime();
            nfcosBusinessOrder.tradeState = businessOrder.getTradeState().getId();
            nfcosBusinessOrder.tradeDate = businessOrder.getTradeDate();
            nfcosBusinessOrder.amount = businessOrder.getAmount();
            nfcosBusinessOrder.businessOrderType = businessOrder.getBusinessOrderType().getId();
            nfcosBusinessOrder.cardIoType = businessOrder.getCardIoType().getId();
            nfcosBusinessOrder.deviceModel = businessOrder.getDeviceModel();
            nfcosBusinessOrder.invoiceStatus = businessOrder.getInvoiceStatus();
            nfcosBusinessOrder.mainOrder = businessOrder.getMainOrder();
            nfcosBusinessOrder.order = businessOrder.getOrder();
            nfcosBusinessOrder.seid = businessOrder.getSeid();
            C2538c.c(TAG, new Object[]{"faceNo : " + nfcosBusinessOrder.faceNo + " ; tradeTime : " + nfcosBusinessOrder.tradeTime + " ; amount : " + nfcosBusinessOrder.amount + " ; businessOrderType :" + nfcosBusinessOrder.businessOrderType + " ; cardIoType : " + nfcosBusinessOrder.cardIoType});
        }
        return nfcosBusinessOrder;
    }

    protected static NfcosPayOrder parsePayOrder2NfcosOrder(PayOrder payOrder) {
        NfcosPayOrder nfcosPayOrder = new NfcosPayOrder();
        if (payOrder != null) {
            nfcosPayOrder.amount = payOrder.getAmount();
            nfcosPayOrder.channel = payOrder.getChannel();
            nfcosPayOrder.date = payOrder.getDate();
            nfcosPayOrder.id = payOrder.getId();
            nfcosPayOrder.mainOrder = payOrder.getMainOrder();
            nfcosPayOrder.state = payOrder.getState().getId();
            nfcosPayOrder.thirdPayInfo = payOrder.getThirdPayInfo();
            nfcosPayOrder.time = payOrder.getTime();
            C2538c.c(TAG, new Object[]{" order.amount : " + nfcosPayOrder.amount + " ; order.state : " + nfcosPayOrder.state + " ;order.thirdPayInfo " + nfcosPayOrder.thirdPayInfo + " ; order.mainOrder :" + nfcosPayOrder.mainOrder});
        }
        return nfcosPayOrder;
    }

    protected static CardAppInfo parseCardAppInfo2NfcosType(cn.com.fmsh.tsm.business.bean.CardAppInfo cardAppInfo) {
        CardAppInfo cardAppInfo2 = new CardAppInfo();
        if (cardAppInfo != null) {
            cardAppInfo2.appNo = cardAppInfo.getCardAppNo();
            cardAppInfo2.time4Validity = cardAppInfo.getTime4Validity();
            cardAppInfo2.cardFaceNo = cardAppInfo.getFaceId();
            cardAppInfo2.cardType = cardAppInfo.getCardType();
            cardAppInfo2.moc = cardAppInfo.getMoc();
            cardAppInfo2.records = parseCardAppRecords2Nfcos(cardAppInfo.getRecords());
            LogX.i(TAG, " parseCardAppInfo2NfcosType info.appNo : " + cardAppInfo2.appNo + " ; info.time4Validity : " + cardAppInfo2.time4Validity + " ; info.cardFaceNo : " + cardAppInfo2.cardFaceNo + " ; info.cardType : " + cardAppInfo2.cardType + " ; info.moc : " + cardAppInfo2.moc);
            try {
                Integer balance = cardAppInfo.getBalance();
                if (balance != null) {
                    cardAppInfo2.balance = balance.intValue();
                } else {
                    cardAppInfo2.balance = 0;
                }
            } catch (Exception e) {
                LogX.e(TAG, " parseCardAppInfo2NfcosType error : " + e.getMessage());
                cardAppInfo2.balance = 0;
            }
        }
        return cardAppInfo2;
    }

    protected static CardAppRecord[] parseCardAppRecords2Nfcos(cn.com.fmsh.tsm.business.bean.CardAppRecord[] cardAppRecordArr) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (cardAppRecordArr == null) {
            return new CardAppRecord[0];
        }
        CardAppRecord[] cardAppRecordArr2 = new CardAppRecord[cardAppRecordArr.length];
        Calendar instance = Calendar.getInstance();
        int length = cardAppRecordArr.length;
        while (i < length) {
            cn.com.fmsh.tsm.business.bean.CardAppRecord cardAppRecord = cardAppRecordArr[i];
            if (cardAppRecord.getAmount() == 0) {
                LogX.i(TAG, " Amount is 0 ,do not show ! ");
            } else {
                CardAppRecord cardAppRecord2 = new CardAppRecord();
                cardAppRecord2.amount = cardAppRecord.getAmount();
                cardAppRecord2.balance = cardAppRecord.getBalance();
                if (cardAppRecord.getTradeDate().length() == 4) {
                    cardAppRecord2.tradeDate = instance.get(1) + cardAppRecord.getTradeDate();
                } else {
                    cardAppRecord2.tradeDate = cardAppRecord.getTradeDate();
                }
                cardAppRecord2.tradeTime = cardAppRecord.getTradeTime();
                cardAppRecord2.tradeType = cardAppRecord.getTradeType().getId();
                LogX.i(TAG, " parseCardAppInfo2NfcosType cardAppRecord.amount : " + cardAppRecord2.amount + " ; balance : " + cardAppRecord2.balance + " ; tradeDate : " + cardAppRecord2.tradeDate + " ; tradeTime : " + cardAppRecord2.tradeTime + " ; tradeType : " + cardAppRecord2.tradeType);
                arrayList.add(cardAppRecord2);
            }
            i++;
        }
        return (CardAppRecord[]) arrayList.toArray(cardAppRecordArr2);
    }

    protected static ArrayList<EnumOrderStatus> getEnumOrderStatuses(int[] iArr) {
        ArrayList<EnumOrderStatus> arrayList = new ArrayList();
        for (int i : iArr) {
            switch (i) {
                case 2:
                    arrayList.add(EnumOrderStatus.hasPaid);
                    break;
                case 4:
                    arrayList.add(EnumOrderStatus.failure);
                    break;
                case 5:
                    arrayList.add(EnumOrderStatus.unsettled);
                    break;
                case 6:
                    arrayList.add(EnumOrderStatus.apilyForRefund);
                    break;
                case 7:
                    arrayList.add(EnumOrderStatus.hasRefunded);
                    break;
                case 8:
                    arrayList.add(EnumOrderStatus.refundFailure);
                    break;
                case 11:
                    arrayList.add(EnumOrderStatus.recharging);
                    break;
                case 12:
                    arrayList.add(EnumOrderStatus.dubious);
                    break;
                default:
                    break;
            }
        }
        return arrayList;
    }

    protected static EnumBusinessOrderType getEnumBusinessOrderType(int i) {
        switch (i) {
            case 1:
                return EnumBusinessOrderType.ORDER_TYPE_RECHARGE;
            case 2:
                return EnumBusinessOrderType.ORDER_TYPE_ISSUE;
            default:
                return EnumBusinessOrderType.ORDER_TYPE_ISSUE;
        }
    }
}
