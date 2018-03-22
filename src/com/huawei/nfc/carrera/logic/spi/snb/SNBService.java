package com.huawei.nfc.carrera.logic.spi.snb;

import com.huawei.nfc.carrera.logic.ese.response.CardQueryResponse;
import com.huawei.nfc.carrera.logic.ese.response.GetFullCardNoResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.IssueCardActResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.PayOrderResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryCityAndCardListResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryOnlineRechargeRecordsResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryTradeRecordsOfSeResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryUnfinishedOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeActResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeResponse;
import java.util.Map;

public interface SNBService {
    CardQueryResponse cardQuery(String str);

    int cardSwitch(String str);

    int deleteCard(String str, Map<String, String> map);

    GetFullCardNoResponse getFullCardNo(String str);

    PayOrderResponse getPayOrder(String str, String str2, double d, int i, double d2, int i2);

    int issueCard(String str, String str2, Map<String, String> map);

    int loadAndInstallApplet(String str, Map<String, String> map);

    QueryCityAndCardListResponse queryCityAndCardList(String str, String str2);

    IssueCardActResponse queryIssueCardCoupon(String str, String str2);

    QueryOnlineRechargeRecordsResponse queryOnlineRechargeRecords(String str, int i);

    RechargeActResponse queryRechargeCoupon(String str, String str2);

    QueryUnfinishedOrdersResponse queryUnfinishedOrders(String str);

    RechargeResponse recharge(String str, String str2, Map<String, String> map);

    int refund(String str, String str2);

    QueryTradeRecordsOfSeResponse transQuerySe(String str);
}
