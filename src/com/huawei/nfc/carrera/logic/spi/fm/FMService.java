package com.huawei.nfc.carrera.logic.spi.fm;

import com.huawei.nfc.carrera.logic.spi.fm.request.ApplyIssueOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.ApplyRechargeOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.DoIssueRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.MoveOrDeleteAppRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrdersRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryProductsRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.RechargeOrDoUnsolvedOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.MainOrderResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrderResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryProductsResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryTradeResponse;

public interface FMService {
    MainOrderResponse applyIssueOrder(ApplyIssueOrderRequest applyIssueOrderRequest, int i);

    MainOrderResponse applyIssueOrderByproduct(ApplyIssueOrderRequest applyIssueOrderRequest, int i);

    MainOrderResponse applyRechargeOrder(ApplyRechargeOrderRequest applyRechargeOrderRequest, int i);

    FMBaseResponse deleteApp(MoveOrDeleteAppRequest moveOrDeleteAppRequest);

    FMBaseResponse doUnsolvedOrder(RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest);

    FMBaseResponse downloadCAP(DoIssueRequest doIssueRequest);

    FMBaseResponse installAndPersonalizeApplet(DoIssueRequest doIssueRequest);

    FMBaseResponse moveApp(MoveOrDeleteAppRequest moveOrDeleteAppRequest);

    QueryBusinessOrderResponse queryBusinessOrder(QueryBusinessOrderRequest queryBusinessOrderRequest);

    QueryBusinessOrdersResponse queryBusinessOrders(QueryBusinessOrdersRequest queryBusinessOrdersRequest);

    QueryCardInfoResponse queryCardInfo(int i, String str);

    QueryProductsResponse queryProducts(QueryProductsRequest queryProductsRequest);

    QueryTradeResponse queryTrade(String str);

    FMBaseResponse recharge(RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest);

    FMBaseResponse retryInstallApplet(DoIssueRequest doIssueRequest);
}
