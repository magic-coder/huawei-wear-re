package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.order;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicPathConfig;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.PayInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryAndHandleUnfinishedOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard.IssueTrafficCardSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard.PreIssueTrafficCardSNBOperator;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.ese.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryUnfinishedOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RecordServerInfo;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaBadParammeterException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardAlreadyExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNumReachMaxException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QueryAndHandleUnfinfishedOrdersSNBOperator {
    private static final String TAG = "QueryAndHandleUnfinfishedOrdersSNBOperator";
    private int mBussnessType;
    private Context mContext;
    private IssuerInfoItem mInfo;
    private QueryAndHandleUnfinishedOrderResultHandler mResultHandler;

    class QueryResult {
        OrderHandleResultInfo mResultInfo;
        List<RecordServerInfo> mUnfinishedOrders = new ArrayList();
        int returnCd;

        QueryResult() {
        }
    }

    public QueryAndHandleUnfinfishedOrdersSNBOperator(Context context, IssuerInfoItem issuerInfoItem, int i, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = queryAndHandleUnfinishedOrderResultHandler;
        this.mBussnessType = i;
    }

    public void queryAndHandleUnfinishedOrders() {
        String aid = this.mInfo.getAid();
        String productId = this.mInfo.getProductId();
        if (StringUtil.isEmpty(aid, true) || StringUtil.isEmpty(productId, true)) {
            LogX.w("QueryAndHandleUnfinfishedOrdersSNBOperator queryAndHandleUnfinishedOrders failed. aid or productId is illegal. aid = " + aid + " productId = " + productId);
            this.mResultHandler.handleResult(10, 10000, null);
            return;
        }
        QueryResult queryUnfinishedOrders = queryUnfinishedOrders(aid);
        if (queryUnfinishedOrders.returnCd == 0 || queryUnfinishedOrders.returnCd == 100002) {
            List list = queryUnfinishedOrders.mUnfinishedOrders;
            if (list != null && !list.isEmpty()) {
                this.mResultHandler.handleResult(0, 10001, queryUnfinishedOrders.mResultInfo);
                handleUnfinishedOrders(aid, productId, queryUnfinishedOrders);
                return;
            } else if (this.mBussnessType == 0 && handleSpecialIssuerOrder()) {
                OrderHandleResultInfo orderHandleResultInfo = new OrderHandleResultInfo(1, 0, 1, 0);
                this.mResultHandler.handleResult(0, 10001, orderHandleResultInfo);
                this.mResultHandler.handleResult(0, 10002, orderHandleResultInfo);
                return;
            } else {
                this.mResultHandler.handleResult(0, 10000, null);
                return;
            }
        }
        this.mResultHandler.handleResult(SpiResultCodeTranslator.getSnbResultCode(queryUnfinishedOrders.returnCd), 10000, null);
    }

    private QueryResult queryUnfinishedOrders(String str) {
        QueryResult queryResult = new QueryResult();
        QueryUnfinishedOrdersResponse queryUnfinishedOrders = SPIServiceFactory.createSNBService(this.mContext).queryUnfinishedOrders(str);
        if (queryUnfinishedOrders.getReturnCd() != 0) {
            queryResult.returnCd = queryUnfinishedOrders.getReturnCd();
            return queryResult;
        }
        Iterator it = queryUnfinishedOrders.unfinishedOrders.iterator();
        List<RecordServerInfo> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            RecordServerInfo recordServerInfo = (RecordServerInfo) it.next();
            switch (recordServerInfo.getOrderStatus()) {
                case 1001:
                    i2++;
                    arrayList.add(recordServerInfo);
                    it.remove();
                    break;
                case 1002:
                case 1007:
                    i3++;
                    break;
                case 1005:
                    i++;
                    break;
                case 1006:
                    if (recordServerInfo.getOrderType() != 1 && recordServerInfo.getOrderType() != 3) {
                        if (recordServerInfo.getOrderType() != 2) {
                            break;
                        }
                        i++;
                        break;
                    }
                    i2++;
                    arrayList.add(recordServerInfo);
                    it.remove();
                    break;
                    break;
                default:
                    it.remove();
                    break;
            }
        }
        for (RecordServerInfo recordServerInfo2 : arrayList) {
            queryUnfinishedOrders.unfinishedOrders.add(0, recordServerInfo2);
        }
        OrderHandleResultInfo orderHandleResultInfo = new OrderHandleResultInfo(queryUnfinishedOrders.unfinishedOrders.size(), i3, i2, i);
        queryResult.mUnfinishedOrders = queryUnfinishedOrders.unfinishedOrders;
        queryResult.mResultInfo = orderHandleResultInfo;
        return queryResult;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleUnfinishedOrders(java.lang.String r10, java.lang.String r11, com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.order.QueryAndHandleUnfinfishedOrdersSNBOperator.QueryResult r12) {
        /*
        r9 = this;
        r5 = 1;
        r2 = 0;
        r0 = r12.mUnfinishedOrders;
        r6 = r0.iterator();
        r1 = r2;
        r3 = r2;
        r4 = r2;
    L_0x000b:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x00b2;
    L_0x0011:
        r0 = r6.next();
        r0 = (com.huawei.nfc.carrera.logic.spi.snb.response.RecordServerInfo) r0;
        r7 = r0.getOrderStatus();
        switch(r7) {
            case 1001: goto L_0x007e;
            case 1002: goto L_0x0025;
            case 1003: goto L_0x001e;
            case 1004: goto L_0x001e;
            case 1005: goto L_0x0050;
            case 1006: goto L_0x0087;
            case 1007: goto L_0x0025;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = r1;
        r1 = r3;
        r3 = r4;
    L_0x0021:
        r4 = r3;
        r3 = r1;
        r1 = r0;
        goto L_0x000b;
    L_0x0025:
        r0 = r0.getOrderId();
        r0 = r9.recharge(r10, r0, r11);
        r4 = r4 + r0;
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "queryAndHandleUnfinishedOrders recharge ";
        r7 = r7.append(r8);
        if (r0 != r5) goto L_0x004d;
    L_0x003b:
        r0 = "succeed";
    L_0x003e:
        r0 = r7.append(r0);
        r0 = r0.toString();
        com.huawei.nfc.carrera.util.LogX.i(r0);
        r0 = r1;
        r1 = r3;
        r3 = r4;
        goto L_0x0021;
    L_0x004d:
        r0 = "failed";
        goto L_0x003e;
    L_0x0050:
        r7 = r9.mContext;
        r7 = com.huawei.nfc.carrera.logic.spi.SPIServiceFactory.createSNBService(r7);
        r0 = r0.getOrderId();
        r7 = r7.refund(r10, r0);
        if (r7 != 0) goto L_0x007c;
    L_0x0060:
        r0 = r5;
    L_0x0061:
        r1 = r1 + r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r8 = "queryAndHandleUnfinishedOrders refund result = ";
        r0 = r0.append(r8);
        r0 = r0.append(r7);
        r0 = r0.toString();
        com.huawei.nfc.carrera.util.LogX.i(r0);
        r0 = r1;
        r1 = r3;
        r3 = r4;
        goto L_0x0021;
    L_0x007c:
        r0 = r2;
        goto L_0x0061;
    L_0x007e:
        r0 = r9.handleIssueFailedOrder(r10, r11, r0);
        r3 = r3 + r0;
        r0 = r1;
        r1 = r3;
        r3 = r4;
        goto L_0x0021;
    L_0x0087:
        r7 = r0.getOrderType();
        if (r7 == r5) goto L_0x0094;
    L_0x008d:
        r7 = r0.getOrderType();
        r8 = 3;
        if (r7 != r8) goto L_0x009d;
    L_0x0094:
        r0 = r9.handleIssueFailedOrder(r10, r11, r0);
        r3 = r3 + r0;
        r0 = r1;
        r1 = r3;
        r3 = r4;
        goto L_0x0021;
    L_0x009d:
        r7 = r0.getOrderType();
        r8 = 2;
        if (r7 != r8) goto L_0x001e;
    L_0x00a4:
        r0 = r0.getOrderId();
        r0 = r9.recharge(r10, r0, r11);
        r4 = r4 + r0;
        r0 = r1;
        r1 = r3;
        r3 = r4;
        goto L_0x0021;
    L_0x00b2:
        r0 = r9.mBussnessType;
        if (r0 != 0) goto L_0x00c7;
    L_0x00b6:
        r0 = r12.mResultInfo;
        r0 = r0.getIssueCardOrderCnt();
        if (r0 > 0) goto L_0x00c7;
    L_0x00be:
        if (r3 > 0) goto L_0x00c7;
    L_0x00c0:
        r0 = r9.handleSpecialIssuerOrder();
        if (r0 == 0) goto L_0x00da;
    L_0x00c6:
        r3 = r3 + r5;
    L_0x00c7:
        r0 = new com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
        r5 = r12.mUnfinishedOrders;
        r5 = r5.size();
        r0.<init>(r5, r4, r3, r1);
        r1 = r9.mResultHandler;
        r3 = 10002; // 0x2712 float:1.4016E-41 double:4.9416E-320;
        r1.handleResult(r2, r3, r0);
        return;
    L_0x00da:
        r5 = r2;
        goto L_0x00c6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.order.QueryAndHandleUnfinfishedOrdersSNBOperator.handleUnfinishedOrders(java.lang.String, java.lang.String, com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.order.QueryAndHandleUnfinfishedOrdersSNBOperator$QueryResult):void");
    }

    private int handleIssueFailedOrder(String str, String str2, RecordServerInfo recordServerInfo) {
        int openCard = openCard(str, recordServerInfo.getOrderId(), str2);
        if (openCard == 1 && recordServerInfo.getOrderType() == 3) {
            LogX.i("queryAndHandleUnfinishedOrders issueTrafficCard recharge " + (recharge(str, recordServerInfo.getOrderId(), str2) == 0 ? " succeed" : "failed"));
        }
        return openCard;
    }

    private int recharge(String str, String str2, String str3) {
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(str3);
        Map hashMap = new HashMap();
        if (!(cacheCardProductInfoItem == null || StringUtil.isEmpty(cacheCardProductInfoItem.getSnbCityBusCode(), true))) {
            hashMap.put("city_code", cacheCardProductInfoItem.getSnbCityBusCode());
        }
        C2538c.b(TAG, new Object[]{" CardEvent RECHARGE bus cardEvent START_LOCK"});
        WalletTaManager.getInstance(this.mContext).cardEvent(str, 2);
        RechargeResponse recharge = SPIServiceFactory.createSNBService(this.mContext).recharge(str, str2, hashMap);
        C2538c.b(TAG, new Object[]{" CardEvent RECHARGE bus cardEvent END_LOCK"});
        WalletTaManager.getInstance(this.mContext).cardEvent(str, 3);
        if (recharge.getReturnCd() == 0) {
            return 1;
        }
        return 0;
    }

    private int openCard(String str, String str2, String str3) {
        int i;
        LogX.i("handleUnfinishedOrders openCard begin");
        new PreIssueTrafficCardSNBOperator(this.mContext, this.mInfo).preIssueTrafficCard();
        TrafficOrder trafficOrder = new TrafficOrder();
        trafficOrder.setPayInfo(new PayInfo());
        trafficOrder.getPayInfo().setRequestId(str2);
        if (new IssueTrafficCardSNBOperator(this.mContext, this.mInfo, trafficOrder, null).issueTrafficCard() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        LogX.i("queryAndHandleUnfinishedOrders issueTrafficCard " + (i != 0 ? " succeed" : "failed"));
        if (i != 0) {
            return 1;
        }
        return 0;
    }

    private boolean handleSpecialIssuerOrder() {
        LogX.i("handleSpecialIssuerOrder being");
        QueryCardInfoResponse queryTrafficCardInfo = ESEInfoManager.getInstance(this.mContext).queryTrafficCardInfo(this.mInfo.getAid(), 1);
        String str = "";
        if (queryTrafficCardInfo.cardInfo != null) {
            str = queryTrafficCardInfo.cardInfo.getCardNo();
        }
        boolean z = StringUtil.isEmpty(str, true) || str.matches("^0*$");
        if (!z) {
            return updateTaCardAvailable(str);
        }
        boolean z2;
        StringBuilder append = new StringBuilder().append("handleUnfinishedOrders checkExistsAndGetTaCardInfo failed. card exists in SE ? ");
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        LogX.w(append.append(z2).toString());
        try {
            LogX.i("handleUnfinishedOrders handleSpecialIssuerOrder failed. remove ta cardinfo for reopenning card is available.");
            WalletTaManager.getInstance(this.mContext).removeCard(this.mInfo.getAid());
            return false;
        } catch (WalletTaCardNotExistException e) {
            LogX.w("handleUnfinishedOrders handleSpecialIssuerOrder failed WalletTaCardNotExistException");
            return false;
        } catch (WalletTaSystemErrorException e2) {
            LogX.w("handleUnfinishedOrders handleSpecialIssuerOrder failed WalletTaSystemErrorException");
            return false;
        }
    }

    private TACardInfo checkExistsAndGetTaCardInfo() {
        boolean z = true;
        TrafficCardInfo trafficCardInfo = ESEInfoManager.getInstance(this.mContext).queryTrafficCardInfo(this.mInfo.getAid(), 1).cardInfo;
        QueryCardInfoResponse queryTrafficCardInfo = ESEInfoManager.getInstance(this.mContext).queryTrafficCardInfo(this.mInfo.getAid(), 1);
        LogX.i("queryTrafficCardInfo ,resultCode=" + queryTrafficCardInfo.resultCode);
        if (queryTrafficCardInfo.cardInfo == null) {
            return null;
        }
        String cardNo = queryTrafficCardInfo.cardInfo.getCardNo();
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mInfo.getAid());
        if (trafficCardInfo == null) {
            return card;
        }
        boolean z2 = StringUtil.isEmpty(cardNo, true) || cardNo.matches("^0*$");
        if (z2 || card == null) {
            boolean z3;
            StringBuilder append = new StringBuilder().append("handleUnfinishedOrders checkExistsAndGetTaCardInfo failed. card exists in SE ? ");
            if (z2) {
                z3 = false;
            } else {
                z3 = true;
            }
            StringBuilder append2 = append.append(z3).append(" card exists in TA ? ");
            if (card == null) {
                z = false;
            }
            LogX.w(append2.append(z).toString());
            return null;
        }
        if (!StringUtil.isEmpty(cardNo, true) && cardNo.length() >= 4) {
            cardNo = cardNo.substring(cardNo.length() - 4, cardNo.length());
        }
        card.fpanFour = cardNo;
        return card;
    }

    private boolean updateTaCardAvailable(String str) {
        WalletTaManager instance = WalletTaManager.getInstance(this.mContext);
        TACardInfo card = instance.getCard(this.mInfo.getAid());
        String str2 = "updateTaCardAvailable success.";
        if (card != null && card.getCardStatus() == 2) {
            return true;
        }
        boolean z;
        if (card != null) {
            try {
                instance.removeCard(this.mInfo.getAid());
            } catch (WalletTaCardNotExistException e) {
                LogX.w("handleUnfinishedOrders updateTaCardAvailable failed WalletTaCardNotExistException");
                z = false;
            } catch (WalletTaSystemErrorException e2) {
                LogX.w("handleUnfinishedOrders updateTaCardAvailable failed WalletTaSystemErrorException");
                z = false;
            } catch (WalletTaCardAlreadyExistException e3) {
                LogX.w("handleUnfinishedOrders updateTaCardAvailable failed WalletTaCardAlreadyExistException");
                z = false;
            } catch (WalletTaCardNumReachMaxException e4) {
                LogX.w("handleUnfinishedOrders updateTaCardAvailable failed WalletTaCardNumReachMaxException");
                z = false;
            } catch (WalletTaBadParammeterException e5) {
                LogX.w("handleUnfinishedOrders updateTaCardAvailable failed WalletTaBadParammeterException");
                z = false;
            }
        }
        instance.addCard(generateTaCardInfo(this.mInfo.getAid(), 2, this.mInfo.getIssuerId(), this.mInfo.getProductId(), str, this.mInfo.getName()));
        LogX.i("handleUnfinishedOrders updateTaCardAvailable success");
        z = true;
        return z;
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
        tACardInfo.fpanFour = str4;
        tACardInfo.isDefaultCard = false;
        tACardInfo.issuerId = str2;
        tACardInfo.productId = str3;
        tACardInfo.Rf_file_name = str3 + CardPicPathConfig.WALLET_CARD_STORAGE_NAME;
        tACardInfo.background_file_name = str3 + CardPicPathConfig.WALLET_CARD_ICON_STORAGE_NAME;
        tACardInfo.statusUpdateTime = System.currentTimeMillis();
        tACardInfo.name = str5;
        return tACardInfo;
    }
}
