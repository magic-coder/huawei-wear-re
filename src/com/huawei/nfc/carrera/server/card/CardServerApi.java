package com.huawei.nfc.carrera.server.card;

import com.huawei.nfc.carrera.server.card.request.ApplyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.request.ApplyCUPVerificationRequest;
import com.huawei.nfc.carrera.server.card.request.CardServerBaseRequest;
import com.huawei.nfc.carrera.server.card.request.CardStatusQueryRequest;
import com.huawei.nfc.carrera.server.card.request.CardStatusReportRequest;
import com.huawei.nfc.carrera.server.card.request.DeviceStatusReportRequest;
import com.huawei.nfc.carrera.server.card.request.IdentifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.request.NullifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.request.PushInfoReportRequest;
import com.huawei.nfc.carrera.server.card.request.QueryAidRequest;
import com.huawei.nfc.carrera.server.card.request.QueryCardProductInfoRequest;
import com.huawei.nfc.carrera.server.card.request.QueryDicsRequset;
import com.huawei.nfc.carrera.server.card.request.QueryIssuerInfoRequest;
import com.huawei.nfc.carrera.server.card.request.QueryRFConfURLResquest;
import com.huawei.nfc.carrera.server.card.request.QuerySupportedCardListByTerminalRequest;
import com.huawei.nfc.carrera.server.card.request.QueryUnionPayPushRequest;
import com.huawei.nfc.carrera.server.card.request.ReportEventBaseRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessApplyAPDURequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessApplyOrderRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessDeleteAppletRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessDownloadAndInstallAppletRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessPersonalizeAppletRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessQueryAmountRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessQueryOrderRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessRechargeRequest;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.request.VerifiyCUPRequest;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.ApplyUPCardResponse;
import com.huawei.nfc.carrera.server.card.response.ApplyVerificationResponse;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.nfc.carrera.server.card.response.IdentifyCUPCardResponse;
import com.huawei.nfc.carrera.server.card.response.NullifyCardResponse;
import com.huawei.nfc.carrera.server.card.response.QueryAidResponse;
import com.huawei.nfc.carrera.server.card.response.QueryCardProductInfoResponse;
import com.huawei.nfc.carrera.server.card.response.QueryDicsResponse;
import com.huawei.nfc.carrera.server.card.response.QueryIssuerInfoResponse;
import com.huawei.nfc.carrera.server.card.response.QueryRFConfURLResponse;
import com.huawei.nfc.carrera.server.card.response.QuerySupportedCardListByTerminalResponse;
import com.huawei.nfc.carrera.server.card.response.QueryUnionPayPushResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessApplyAPDUResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessApplyOrderResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessDeleteAppletResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessDownloadAndInstallAppletResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessPersonalizeAppletResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessQueryAmountResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessQueryOrderResponse;
import com.huawei.nfc.carrera.server.card.response.ServerAccessRechargeResponse;
import com.huawei.nfc.carrera.server.card.response.SignDataResponse;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;

public interface CardServerApi {
    ServerAccessApplyAPDUResponse applyAPDU(ServerAccessApplyAPDURequest serverAccessApplyAPDURequest);

    ApplyUPCardResponse applyCUPCard(ApplyCUPCardRequest applyCUPCardRequest);

    ApplyVerificationResponse applyCUPVerification(ApplyCUPVerificationRequest applyCUPVerificationRequest);

    ServerAccessApplyOrderResponse applyOrder(ServerAccessApplyOrderRequest serverAccessApplyOrderRequest);

    ServerAccessDeleteAppletResponse deleteApplet(ServerAccessDeleteAppletRequest serverAccessDeleteAppletRequest);

    ServerAccessDownloadAndInstallAppletResponse downloadAndInstallApplet(ServerAccessDownloadAndInstallAppletRequest serverAccessDownloadAndInstallAppletRequest);

    IdentifyCUPCardResponse identifyCUPCard(IdentifyCUPCardRequest identifyCUPCardRequest);

    NullifyCardResponse nullifyCUPCard(NullifyCUPCardRequest nullifyCUPCardRequest);

    ServerAccessPersonalizeAppletResponse personalizeApplet(ServerAccessPersonalizeAppletRequest serverAccessPersonalizeAppletRequest);

    QueryAidResponse queryAidOnCUP(QueryAidRequest queryAidRequest);

    QueryCardProductInfoResponse queryCardProductInfoList(QueryCardProductInfoRequest queryCardProductInfoRequest);

    CardStatusQueryResponse queryCardStatus(CardStatusQueryRequest cardStatusQueryRequest);

    TsmParamQueryResponse queryCreateSSDTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    TsmParamQueryResponse queryDeleteAppletTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    TsmParamQueryResponse queryDeleteSSDTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    QueryDicsResponse queryDics(QueryDicsRequset queryDicsRequset);

    TsmParamQueryResponse queryInfoInitTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    TsmParamQueryResponse queryInfoSynTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    TsmParamQueryResponse queryInstallTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    ServerAccessQueryAmountResponse queryIssueOrRechargeAmount(ServerAccessQueryAmountRequest serverAccessQueryAmountRequest);

    QueryIssuerInfoResponse queryIssuerInfo(QueryIssuerInfoRequest queryIssuerInfoRequest);

    TsmParamQueryResponse queryLockAppletTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    ServerAccessQueryOrderResponse queryOrder(ServerAccessQueryOrderRequest serverAccessQueryOrderRequest);

    QueryRFConfURLResponse queryRFConfURL(QueryRFConfURLResquest queryRFConfURLResquest);

    SignDataResponse querySignData(CardServerBaseRequest cardServerBaseRequest, String str, String str2);

    SignDataResponse querySignDataForActivation(CardServerBaseRequest cardServerBaseRequest);

    SignDataResponse querySignDataForApplyAid(CardServerBaseRequest cardServerBaseRequest);

    SignDataResponse querySignDataForApplyCard(CardServerBaseRequest cardServerBaseRequest);

    SignDataResponse querySignDataForBillList(CardServerBaseRequest cardServerBaseRequest);

    SignDataResponse querySignDataForNullify(CardServerBaseRequest cardServerBaseRequest);

    SignDataResponse querySignDataForPersonal(CardServerBaseRequest cardServerBaseRequest);

    SignDataResponse querySignDataForQueryCashLimit(CardServerBaseRequest cardServerBaseRequest);

    SignDataResponse querySignDataForSetCashLimit(CardServerBaseRequest cardServerBaseRequest);

    QuerySupportedCardListByTerminalResponse querySupportedCardListByTerminal(QuerySupportedCardListByTerminalRequest querySupportedCardListByTerminalRequest);

    TsmParamQueryResponse queryUnLockEseTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    QueryUnionPayPushResponse queryUnionPayPush(QueryUnionPayPushRequest queryUnionPayPushRequest);

    TsmParamQueryResponse queryUnockAppletTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    TsmParamQueryResponse queryUpdateTsmParam(TsmParamQueryRequest tsmParamQueryRequest);

    ServerAccessRechargeResponse recharge(ServerAccessRechargeRequest serverAccessRechargeRequest);

    CardServerBaseResponse reportCardStatus(CardStatusReportRequest cardStatusReportRequest);

    CardServerBaseResponse reportDeviceStatus(DeviceStatusReportRequest deviceStatusReportRequest);

    CardServerBaseResponse reportOpenCardEvent(ReportEventBaseRequest reportEventBaseRequest);

    CardServerBaseResponse reportPushInfo(PushInfoReportRequest pushInfoReportRequest);

    CardServerBaseResponse verifyOnCUP(VerifiyCUPRequest verifiyCUPRequest);

    CardServerBaseResponse wipeAllCUPCard(WipeAllCUPCardRequest wipeAllCUPCardRequest);
}
