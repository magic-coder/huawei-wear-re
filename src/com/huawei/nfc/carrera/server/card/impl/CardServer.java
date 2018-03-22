package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.CardServerApi;
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
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.utils.PackageUtil;

public class CardServer implements CardServerApi {
    private final Context mContext;
    private final String serverTotalUrl = ("https://nfcws.hicloud.com/Wallet/wallet/gateway.action?clientVersion=" + PackageUtil.m28462b(this.mContext));

    public CardServer(Context context) {
        this.mContext = context;
        LogX.i("====123========reportCardStatus serverTotalUrl." + this.serverTotalUrl);
    }

    public CardServerBaseResponse reportCardStatus(CardStatusReportRequest cardStatusReportRequest) {
        LogX.i("reportCardStatus begin.");
        return (CardServerBaseResponse) new CardStatusReportTask(this.mContext, this.serverTotalUrl).processTask(cardStatusReportRequest);
    }

    public CardStatusQueryResponse queryCardStatus(CardStatusQueryRequest cardStatusQueryRequest) {
        LogX.i("queryCardStatus begin.");
        return (CardStatusQueryResponse) new CardStatusQueryTask(this.mContext, this.serverTotalUrl).processTask(cardStatusQueryRequest);
    }

    public TsmParamQueryResponse queryInstallTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryInstallTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.install.APP").processTask(tsmParamQueryRequest);
    }

    public TsmParamQueryResponse queryDeleteAppletTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryDeleteAppletTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.del.APP").processTask(tsmParamQueryRequest);
    }

    public TsmParamQueryResponse queryDeleteSSDTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryDeleteSSDTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.del.SSD").processTask(tsmParamQueryRequest);
    }

    public SignDataResponse querySignDataForApplyAid(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForApplyAid begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "APPLYIDCARDACTION").processTask(cardServerBaseRequest);
    }

    public SignDataResponse querySignDataForApplyCard(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForApplyCard begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "APPLYCARDACTION").processTask(cardServerBaseRequest);
    }

    public SignDataResponse querySignDataForActivation(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForActivation begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "ACTIVATEACTION").processTask(cardServerBaseRequest);
    }

    public SignDataResponse querySignDataForPersonal(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForPersonal begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "PERSONALIZEACTION").processTask(cardServerBaseRequest);
    }

    public SignDataResponse querySignDataForNullify(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForNullify begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "NULLIFYACTION").processTask(cardServerBaseRequest);
    }

    public SignDataResponse querySignDataForBillList(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForBillList begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "BILLLISTACTION").processTask(cardServerBaseRequest);
    }

    public SignDataResponse querySignDataForQueryCashLimit(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForQueryCashLimit begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "CASHLIMITSEARCHACTION").processTask(cardServerBaseRequest);
    }

    public SignDataResponse querySignDataForSetCashLimit(CardServerBaseRequest cardServerBaseRequest) {
        LogX.i("querySignDataForSetCashLimit begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, "CASHLIMITACTION").processTask(cardServerBaseRequest);
    }

    public TsmParamQueryResponse queryLockAppletTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryLockAppletTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.lock.APP").processTask(tsmParamQueryRequest);
    }

    public TsmParamQueryResponse queryUnockAppletTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryUnockAppletTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.unlock.APP").processTask(tsmParamQueryRequest);
    }

    public TsmParamQueryResponse queryInfoInitTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryInfoInitTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.NotifyInfoInit").processTask(tsmParamQueryRequest);
    }

    public CardServerBaseResponse reportPushInfo(PushInfoReportRequest pushInfoReportRequest) {
        LogX.i("reportPushInfo begin.");
        return (CardServerBaseResponse) new PushInfoReportTask(this.mContext, this.serverTotalUrl).processTask(pushInfoReportRequest);
    }

    public CardServerBaseResponse reportDeviceStatus(DeviceStatusReportRequest deviceStatusReportRequest) {
        LogX.i("reportRepairStatus begin.");
        return (CardServerBaseResponse) new DeviceStatusReportTask(this.mContext, this.serverTotalUrl).processTask(deviceStatusReportRequest);
    }

    public IdentifyCUPCardResponse identifyCUPCard(IdentifyCUPCardRequest identifyCUPCardRequest) {
        LogX.i("identifyCUPCard begin.");
        return (IdentifyCUPCardResponse) new IdentifyCUPCardTask(this.mContext, this.serverTotalUrl).processTask(identifyCUPCardRequest);
    }

    public ApplyUPCardResponse applyCUPCard(ApplyCUPCardRequest applyCUPCardRequest) {
        LogX.i("applyCUPCard begin.");
        return (ApplyUPCardResponse) new ApplyCUPCardTask(this.mContext, this.serverTotalUrl).processTask(applyCUPCardRequest);
    }

    public ApplyVerificationResponse applyCUPVerification(ApplyCUPVerificationRequest applyCUPVerificationRequest) {
        LogX.i("applyCUPVerification begin.");
        return (ApplyVerificationResponse) new ApplyCUPVerificationTask(this.mContext, this.serverTotalUrl).processTask(applyCUPVerificationRequest);
    }

    public CardServerBaseResponse verifyOnCUP(VerifiyCUPRequest verifiyCUPRequest) {
        LogX.i("verifyOnCUP begin.");
        return (CardServerBaseResponse) new VerifyCUPTask(this.mContext, this.serverTotalUrl).processTask(verifiyCUPRequest);
    }

    public NullifyCardResponse nullifyCUPCard(NullifyCUPCardRequest nullifyCUPCardRequest) {
        LogX.i("nullifyCUPCard begin.");
        return (NullifyCardResponse) new NullifyCUPCardTask(this.mContext, this.serverTotalUrl).processTask(nullifyCUPCardRequest);
    }

    public QueryAidResponse queryAidOnCUP(QueryAidRequest queryAidRequest) {
        LogX.i("queryAidOnCUP begin.");
        return (QueryAidResponse) new QueryAidOnCUPCardTask(this.mContext, this.serverTotalUrl).processTask(queryAidRequest);
    }

    public QueryDicsResponse queryDics(QueryDicsRequset queryDicsRequset) {
        LogX.i("queryDics begin.");
        QueryDicsResponse queryDicsResponse = (QueryDicsResponse) new DicsQueryTask(this.mContext, this.serverTotalUrl).processTask(queryDicsRequset);
        LogX.i("queryDics end.");
        return queryDicsResponse;
    }

    public QueryIssuerInfoResponse queryIssuerInfo(QueryIssuerInfoRequest queryIssuerInfoRequest) {
        LogX.i("queryIssuerInfo begin.");
        QueryIssuerInfoResponse queryIssuerInfoResponse = (QueryIssuerInfoResponse) new IssuerInfoQueryTask(this.mContext, this.serverTotalUrl).processTask(queryIssuerInfoRequest);
        LogX.i("queryIssuerInfo end.");
        return queryIssuerInfoResponse;
    }

    public QueryCardProductInfoResponse queryCardProductInfoList(QueryCardProductInfoRequest queryCardProductInfoRequest) {
        LogX.i("queryCardProductInfoList begin.");
        QueryCardProductInfoResponse queryCardProductInfoResponse = (QueryCardProductInfoResponse) new CardProductInfoQueryTask(this.mContext, this.serverTotalUrl).processTask(queryCardProductInfoRequest);
        LogX.i("queryCardProductInfoList end.");
        return queryCardProductInfoResponse;
    }

    public TsmParamQueryResponse queryCreateSSDTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryCreateSSDTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.create.SSD").processTask(tsmParamQueryRequest);
    }

    public SignDataResponse querySignData(CardServerBaseRequest cardServerBaseRequest, String str, String str2) {
        LogX.i("querySignData begin.");
        return (SignDataResponse) new SignatureQueryTask(this.mContext, this.serverTotalUrl, str, str2).processTask(cardServerBaseRequest);
    }

    public TsmParamQueryResponse queryUpdateTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryUpdateTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.transit.temp.update.APP").processTask(tsmParamQueryRequest);
    }

    public CardServerBaseResponse wipeAllCUPCard(WipeAllCUPCardRequest wipeAllCUPCardRequest) {
        LogX.i("wipeAllCUPCard begin.");
        return (CardServerBaseResponse) new WipeAllCUPCardTask(this.mContext, this.serverTotalUrl).processTask(wipeAllCUPCardRequest);
    }

    public TsmParamQueryResponse queryInfoSynTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryInfoSynTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.get.NotifyEseInfoSync").processTask(tsmParamQueryRequest);
    }

    public TsmParamQueryResponse queryUnLockEseTsmParam(TsmParamQueryRequest tsmParamQueryRequest) {
        LogX.i("queryUnLockEseTsmParam begin.");
        return (TsmParamQueryResponse) new TsmParamQueryTask(this.mContext, this.serverTotalUrl, "nfc.se.unlock").processTask(tsmParamQueryRequest);
    }

    public ServerAccessApplyAPDUResponse applyAPDU(ServerAccessApplyAPDURequest serverAccessApplyAPDURequest) {
        LogX.i("CardServer applyAPDU begin");
        return (ServerAccessApplyAPDUResponse) new ServerAccessApplyAPDUTask(this.mContext, this.serverTotalUrl).processTask(serverAccessApplyAPDURequest);
    }

    public QueryUnionPayPushResponse queryUnionPayPush(QueryUnionPayPushRequest queryUnionPayPushRequest) {
        LogX.i("queryUnionPayPush begin.");
        return (QueryUnionPayPushResponse) new QueryUnionPayPushTask(this.mContext, this.serverTotalUrl).processTask(queryUnionPayPushRequest);
    }

    public CardServerBaseResponse reportOpenCardEvent(ReportEventBaseRequest reportEventBaseRequest) {
        LogX.i("reportOpenCardEvent begin.");
        return (CardServerBaseResponse) new ReportOpenCardEventTask(this.mContext, this.serverTotalUrl).processTask(reportEventBaseRequest);
    }

    public QuerySupportedCardListByTerminalResponse querySupportedCardListByTerminal(QuerySupportedCardListByTerminalRequest querySupportedCardListByTerminalRequest) {
        LogX.i("querySupportedCardListByTerminal begin.");
        return (QuerySupportedCardListByTerminalResponse) new QuerySupportedCardListByTerminalTask(this.mContext, this.serverTotalUrl).processTask(querySupportedCardListByTerminalRequest);
    }

    public QueryRFConfURLResponse queryRFConfURL(QueryRFConfURLResquest queryRFConfURLResquest) {
        LogX.i("queryRFConfURL begin.");
        return (QueryRFConfURLResponse) new QueryRFConfURLTask(this.mContext, this.serverTotalUrl).processTask(queryRFConfURLResquest);
    }

    public ServerAccessApplyOrderResponse applyOrder(ServerAccessApplyOrderRequest serverAccessApplyOrderRequest) {
        LogX.i("CardServer applyOrder begin");
        return (ServerAccessApplyOrderResponse) new ServerAccessApplyOrderTask(this.mContext, this.serverTotalUrl).processTask(serverAccessApplyOrderRequest);
    }

    public ServerAccessDownloadAndInstallAppletResponse downloadAndInstallApplet(ServerAccessDownloadAndInstallAppletRequest serverAccessDownloadAndInstallAppletRequest) {
        LogX.i("CardServer downloadAndInstallApplet begin");
        return (ServerAccessDownloadAndInstallAppletResponse) new ServerAccessDownloadAndInstallAppletTask(this.mContext, this.serverTotalUrl).processTask(serverAccessDownloadAndInstallAppletRequest);
    }

    public ServerAccessPersonalizeAppletResponse personalizeApplet(ServerAccessPersonalizeAppletRequest serverAccessPersonalizeAppletRequest) {
        LogX.i("CardServer personalizeApplet begin");
        return (ServerAccessPersonalizeAppletResponse) new ServerAccessPersonalizeAppletTask(this.mContext, this.serverTotalUrl).processTask(serverAccessPersonalizeAppletRequest);
    }

    public ServerAccessRechargeResponse recharge(ServerAccessRechargeRequest serverAccessRechargeRequest) {
        LogX.i("CardServer recharge begin");
        return (ServerAccessRechargeResponse) new ServerAccessRechargeTask(this.mContext, this.serverTotalUrl).processTask(serverAccessRechargeRequest);
    }

    public ServerAccessDeleteAppletResponse deleteApplet(ServerAccessDeleteAppletRequest serverAccessDeleteAppletRequest) {
        LogX.i("CardServer deleteApplet begin");
        return (ServerAccessDeleteAppletResponse) new ServerAccessDeleteAppletTask(this.mContext, this.serverTotalUrl).processTask(serverAccessDeleteAppletRequest);
    }

    public ServerAccessQueryOrderResponse queryOrder(ServerAccessQueryOrderRequest serverAccessQueryOrderRequest) {
        LogX.i("CardServer queryOrder begin");
        return (ServerAccessQueryOrderResponse) new ServerAccessQueryOrderTask(this.mContext, this.serverTotalUrl).processTask(serverAccessQueryOrderRequest);
    }

    public ServerAccessQueryAmountResponse queryIssueOrRechargeAmount(ServerAccessQueryAmountRequest serverAccessQueryAmountRequest) {
        LogX.i("CardServer queryIssueOrRechargeAmount begin");
        return (ServerAccessQueryAmountResponse) new ServerAccessQueryAmountTask(this.mContext, this.serverTotalUrl).processTask(serverAccessQueryAmountRequest);
    }
}
