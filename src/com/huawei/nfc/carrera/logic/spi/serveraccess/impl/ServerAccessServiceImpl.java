package com.huawei.nfc.carrera.logic.spi.serveraccess.impl;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.nfc.carrera.logic.oma.OmaApduManager;
import com.huawei.nfc.carrera.logic.oma.TaskResult;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.nfc.carrera.logic.oma.model.ChannelID;
import com.huawei.nfc.carrera.logic.spi.serveraccess.ServerAccessService;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.ApplyOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.IssueAmount;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.RechargeAmount;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.ApplyOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.DeleteAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.DownloadAndInstallAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.PersonalizeAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryAmountRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.RechargeRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.ApplyOrderResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.BaseResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.DeleteAppletResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.DownloadAndInstallAppletResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.PersonalizeAppletResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryAmountResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryOrderResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.RechargeResponse;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import com.huawei.nfc.carrera.server.card.model.ServerAccessApplyOrder;
import com.huawei.nfc.carrera.server.card.model.ServerAccessIssueAmount;
import com.huawei.nfc.carrera.server.card.model.ServerAccessQueryOrder;
import com.huawei.nfc.carrera.server.card.model.ServerAccessRechargeAmount;
import com.huawei.nfc.carrera.server.card.request.ServerAccessApplyAPDURequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessApplyOrderRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessDeleteAppletRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessDownloadAndInstallAppletRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessPersonalizeAppletRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessQueryAmountRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessQueryOrderRequest;
import com.huawei.nfc.carrera.server.card.request.ServerAccessRechargeRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ServerAccessServiceImpl implements ServerAccessService {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "ServerAccessServiceImpl";
    private static volatile ServerAccessServiceImpl instance = null;
    private CardServerApi cardServer = null;
    private Context mContext = null;
    private IOmaService omaService = null;

    private ServerAccessServiceImpl(Context context) {
        this.mContext = context.getApplicationContext();
        this.cardServer = ServerServiceFactory.createCardServerApi(this.mContext);
        this.omaService = OmaApduManager.getInstance(this.mContext);
    }

    public static ServerAccessService getInstance(Context context) {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null && context != null) {
                    instance = new ServerAccessServiceImpl(context);
                }
            }
        }
        return instance;
    }

    public ApplyOrderResponse applyOrder(ApplyOrderRequest applyOrderRequest) {
        BaseResponse applyOrderResponse = new ApplyOrderResponse();
        if (applyOrderRequest == null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl applyOrder, invalid param"});
            applyOrderResponse.setResultCode(1);
            applyOrderResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return applyOrderResponse;
        }
        ServerAccessApplyOrderRequest serverAccessApplyOrderRequest = new ServerAccessApplyOrderRequest(applyOrderRequest.getIssuerId(), applyOrderRequest.getCplc(), applyOrderRequest.getAppletAid(), applyOrderRequest.getScene(), applyOrderRequest.getDeviceModel(), applyOrderRequest.getSeChipManuFacturer());
        serverAccessApplyOrderRequest.setCardId(applyOrderRequest.getTrafficCardId());
        serverAccessApplyOrderRequest.setActualIssuePayment(applyOrderRequest.getActualIssuePayment());
        serverAccessApplyOrderRequest.setTheoreticalIssuePayment(applyOrderRequest.getTheoreticalIssuePayment());
        serverAccessApplyOrderRequest.setActualRecharegePayment(applyOrderRequest.getActualRecharegePayment());
        serverAccessApplyOrderRequest.setTheoreticalRecharegePayment(applyOrderRequest.getTheoreticalRecharegePayment());
        serverAccessApplyOrderRequest.setCurrency(applyOrderRequest.getCurrency());
        serverAccessApplyOrderRequest.setPayType(applyOrderRequest.getPayType());
        serverAccessApplyOrderRequest.setPhoneNumber(applyOrderRequest.getPhoneNumber());
        serverAccessApplyOrderRequest.setReserved(applyOrderRequest.getReserved());
        serverAccessApplyOrderRequest.setTheoreticalIssuePayment(applyOrderRequest.getTheoreticalIssuePayment());
        serverAccessApplyOrderRequest.setUserID(applyOrderRequest.getAccountUserId());
        ServerAccessBaseResponse applyOrder = this.cardServer.applyOrder(serverAccessApplyOrderRequest);
        if (applyOrder != null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl applyOrder, response = " + applyOrder.returnCode});
            if (applyOrder.returnCode == 0) {
                applyOrderResponse.setResultCode(0);
                List<ServerAccessApplyOrder> orderList = applyOrder.getOrderList();
                if (!(orderList == null || orderList.isEmpty())) {
                    List arrayList = new ArrayList();
                    for (ServerAccessApplyOrder serverAccessApplyOrder : orderList) {
                        ApplyOrder applyOrder2 = new ApplyOrder();
                        applyOrder2.setAccessMode(serverAccessApplyOrder.getAccessMode());
                        applyOrder2.setAmount(serverAccessApplyOrder.getAmount());
                        applyOrder2.setApplicationId(serverAccessApplyOrder.getApplicationId());
                        applyOrder2.setCurrency(serverAccessApplyOrder.getCurrency());
                        applyOrder2.setOrderId(serverAccessApplyOrder.getOrderId());
                        applyOrder2.setOrderTime(serverAccessApplyOrder.getOrderTime());
                        applyOrder2.setOrderType(serverAccessApplyOrder.getOrderType());
                        applyOrder2.setPackageName(serverAccessApplyOrder.getPackageName());
                        applyOrder2.setProductDesc(serverAccessApplyOrder.getProductDesc());
                        applyOrder2.setProductName(serverAccessApplyOrder.getProductName());
                        applyOrder2.setServiceCatalog(serverAccessApplyOrder.getServiceCatalog());
                        applyOrder2.setSign(serverAccessApplyOrder.getSign());
                        applyOrder2.setSignType(serverAccessApplyOrder.getSignType());
                        applyOrder2.setSPMerchantId(serverAccessApplyOrder.getSPMerchantId());
                        applyOrder2.setMerchantName(serverAccessApplyOrder.getMerchantName());
                        applyOrder2.setUrl(serverAccessApplyOrder.getUrl());
                        applyOrder2.setUrlVer(serverAccessApplyOrder.getUrlVer());
                        applyOrder2.setSdkChannel(serverAccessApplyOrder.getSdkChannel());
                        arrayList.add(applyOrder2);
                    }
                    applyOrderResponse.setOrderList(arrayList);
                }
            } else {
                translateErrorCode(applyOrder, applyOrderResponse);
            }
        }
        return applyOrderResponse;
    }

    public DownloadAndInstallAppletResponse downloadAndInstallApplet(DownloadAndInstallAppletRequest downloadAndInstallAppletRequest) {
        C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl downloadAndInstallApplet, enter"});
        BaseResponse downloadAndInstallAppletResponse = new DownloadAndInstallAppletResponse();
        if (downloadAndInstallAppletRequest == null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl downloadAndInstallApplet, invalid param"});
            downloadAndInstallAppletResponse.setResultCode(1);
            downloadAndInstallAppletResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return downloadAndInstallAppletResponse;
        }
        ServerAccessDownloadAndInstallAppletRequest serverAccessDownloadAndInstallAppletRequest = new ServerAccessDownloadAndInstallAppletRequest(downloadAndInstallAppletRequest.getIssuerId(), downloadAndInstallAppletRequest.getCplc(), downloadAndInstallAppletRequest.getAppletAid(), downloadAndInstallAppletRequest.getDeviceModel(), downloadAndInstallAppletRequest.getSeChipManuFacturer());
        serverAccessDownloadAndInstallAppletRequest.setImei(downloadAndInstallAppletRequest.getImei());
        serverAccessDownloadAndInstallAppletRequest.setOrderId(downloadAndInstallAppletRequest.getOrderId());
        serverAccessDownloadAndInstallAppletRequest.setPhoneManufacturer(downloadAndInstallAppletRequest.getPhoneManufacturer());
        serverAccessDownloadAndInstallAppletRequest.setPhoneNumber(downloadAndInstallAppletRequest.getPhoneNumber());
        serverAccessDownloadAndInstallAppletRequest.setReserved(downloadAndInstallAppletRequest.getReserved());
        serverAccessDownloadAndInstallAppletRequest.setUserID(downloadAndInstallAppletRequest.getAccountUserId());
        ServerAccessBaseResponse downloadAndInstallApplet = this.cardServer.downloadAndInstallApplet(serverAccessDownloadAndInstallAppletRequest);
        if (downloadAndInstallApplet != null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl downloadAndInstallApplet, response = " + downloadAndInstallApplet.returnCode});
            if (downloadAndInstallApplet.returnCode == 0) {
                String transactionId = downloadAndInstallApplet.getTransactionId();
                List apduList = downloadAndInstallApplet.getApduList();
                if (apduList == null || apduList.isEmpty()) {
                    downloadAndInstallAppletResponse.setResultCode(0);
                } else {
                    executeCommand(transactionId, apduList, downloadAndInstallAppletResponse, serverAccessDownloadAndInstallAppletRequest.getIssuerId(), serverAccessDownloadAndInstallAppletRequest.getAppletAid(), serverAccessDownloadAndInstallAppletRequest.getCplc(), serverAccessDownloadAndInstallAppletRequest.getDeviceModel(), serverAccessDownloadAndInstallAppletRequest.getSeChipManuFacturer());
                }
            } else {
                translateErrorCode(downloadAndInstallApplet, downloadAndInstallAppletResponse);
            }
        }
        return downloadAndInstallAppletResponse;
    }

    public PersonalizeAppletResponse personalizeApplet(PersonalizeAppletRequest personalizeAppletRequest) {
        BaseResponse personalizeAppletResponse = new PersonalizeAppletResponse();
        if (personalizeAppletRequest == null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl personalizeApplet, invalid param"});
            personalizeAppletResponse.setResultCode(1);
            personalizeAppletResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return personalizeAppletResponse;
        }
        ServerAccessPersonalizeAppletRequest serverAccessPersonalizeAppletRequest = new ServerAccessPersonalizeAppletRequest(personalizeAppletRequest.getIssuerId(), personalizeAppletRequest.getOrderId(), personalizeAppletRequest.getCplc(), personalizeAppletRequest.getAppletAid(), personalizeAppletRequest.getDeviceModel(), personalizeAppletRequest.getSeChipManuFacturer());
        serverAccessPersonalizeAppletRequest.setBasebandVersion(personalizeAppletRequest.getBasebandVersion());
        serverAccessPersonalizeAppletRequest.setSeChipManuFacturer(personalizeAppletRequest.getSeChipManuFacturer());
        serverAccessPersonalizeAppletRequest.setImei(personalizeAppletRequest.getImei());
        serverAccessPersonalizeAppletRequest.setSeCosVersion(personalizeAppletRequest.getSeCosVersion());
        serverAccessPersonalizeAppletRequest.setSystemType(personalizeAppletRequest.getSystemType());
        serverAccessPersonalizeAppletRequest.setSystemVersion(personalizeAppletRequest.getSystemVersion());
        serverAccessPersonalizeAppletRequest.setOrderId(personalizeAppletRequest.getOrderId());
        serverAccessPersonalizeAppletRequest.setPhoneManufacturer(personalizeAppletRequest.getPhoneManufacturer());
        serverAccessPersonalizeAppletRequest.setPhoneNumber(personalizeAppletRequest.getPhoneNumber());
        serverAccessPersonalizeAppletRequest.setReserved(personalizeAppletRequest.getReserved());
        serverAccessPersonalizeAppletRequest.setUserID(personalizeAppletRequest.getAccountUserId());
        ServerAccessBaseResponse personalizeApplet = this.cardServer.personalizeApplet(serverAccessPersonalizeAppletRequest);
        if (personalizeApplet != null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl personalizeApplet, response = " + personalizeApplet.returnCode});
            if (personalizeApplet.returnCode == 0) {
                String transactionId = personalizeApplet.getTransactionId();
                List apduList = personalizeApplet.getApduList();
                if (apduList == null || apduList.isEmpty()) {
                    personalizeAppletResponse.setResultCode(0);
                } else {
                    executeCommand(transactionId, apduList, personalizeAppletResponse, serverAccessPersonalizeAppletRequest.getIssuerId(), serverAccessPersonalizeAppletRequest.getAppletAid(), serverAccessPersonalizeAppletRequest.getCplc(), serverAccessPersonalizeAppletRequest.getDeviceModel(), serverAccessPersonalizeAppletRequest.getSeChipManuFacturer());
                }
            } else {
                translateErrorCode(personalizeApplet, personalizeAppletResponse);
            }
        }
        C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl personalizeApplet end "});
        return personalizeAppletResponse;
    }

    public RechargeResponse recharge(RechargeRequest rechargeRequest) {
        BaseResponse rechargeResponse = new RechargeResponse();
        if (rechargeRequest == null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl recharge, invalid param"});
            rechargeResponse.setResultCode(1);
            rechargeResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return rechargeResponse;
        }
        ServerAccessRechargeRequest serverAccessRechargeRequest = new ServerAccessRechargeRequest(rechargeRequest.getIssuerId(), rechargeRequest.getAppletAid(), rechargeRequest.getCplc(), rechargeRequest.getOrderId(), rechargeRequest.getTrafficCardId(), rechargeRequest.getSystemType(), rechargeRequest.getSystemVersion(), rechargeRequest.getDeviceModel(), rechargeRequest.getSeChipManuFacturer());
        serverAccessRechargeRequest.setPayType(rechargeRequest.getPayType());
        serverAccessRechargeRequest.setImei(rechargeRequest.getImei());
        serverAccessRechargeRequest.setPhoneNumber(rechargeRequest.getPhoneNumber());
        serverAccessRechargeRequest.setRechargeMode(rechargeRequest.getRechargeMode());
        serverAccessRechargeRequest.setReserved(rechargeRequest.getReserved());
        serverAccessRechargeRequest.setUserID(rechargeRequest.getAccountUserId());
        ServerAccessBaseResponse recharge = this.cardServer.recharge(serverAccessRechargeRequest);
        if (recharge != null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl recharge, response = " + recharge.returnCode});
            if (recharge.returnCode == 0) {
                String transactionId = recharge.getTransactionId();
                List apduList = recharge.getApduList();
                if (apduList == null || apduList.isEmpty()) {
                    rechargeResponse.setResultCode(0);
                } else {
                    C2538c.c(TAG, new Object[]{" doRecharge executeCommand: "});
                    executeCommand(transactionId, apduList, rechargeResponse, serverAccessRechargeRequest.getIssuerId(), serverAccessRechargeRequest.getAppletAid(), serverAccessRechargeRequest.getCplc(), serverAccessRechargeRequest.getDeviceModel(), serverAccessRechargeRequest.getSeChipManuFacturer());
                }
            } else {
                translateErrorCode(recharge, rechargeResponse);
            }
        }
        return rechargeResponse;
    }

    public DeleteAppletResponse deleteApplet(DeleteAppletRequest deleteAppletRequest) {
        C2538c.c(TAG, new Object[]{" enter deleteApplet "});
        BaseResponse deleteAppletResponse = new DeleteAppletResponse();
        if (deleteAppletRequest == null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl deleteApplet, invalid param"});
            deleteAppletResponse.setResultCode(1);
            deleteAppletResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return deleteAppletResponse;
        }
        ServerAccessDeleteAppletRequest serverAccessDeleteAppletRequest = new ServerAccessDeleteAppletRequest(deleteAppletRequest.getIssuerId(), deleteAppletRequest.getCplc(), deleteAppletRequest.getAppletAid(), deleteAppletRequest.getDeviceModel(), deleteAppletRequest.getSeChipManuFacturer());
        serverAccessDeleteAppletRequest.setCardId(deleteAppletRequest.getTrafficCardId());
        serverAccessDeleteAppletRequest.setImei(deleteAppletRequest.getImei());
        serverAccessDeleteAppletRequest.setPhoneNumber(deleteAppletRequest.getPhoneNumber());
        serverAccessDeleteAppletRequest.setPhoneManufacturer(deleteAppletRequest.getPhoneManufacturer());
        serverAccessDeleteAppletRequest.setReason(deleteAppletRequest.getReason());
        serverAccessDeleteAppletRequest.setRefundTicketId(deleteAppletRequest.getRefundTicketId());
        serverAccessDeleteAppletRequest.setReserved(deleteAppletRequest.getReserved());
        serverAccessDeleteAppletRequest.setUserID(deleteAppletRequest.getAccountUserId());
        ServerAccessBaseResponse deleteApplet = this.cardServer.deleteApplet(serverAccessDeleteAppletRequest);
        if (deleteApplet != null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl deleteApplet, response = " + deleteApplet.returnCode});
            if (deleteApplet.returnCode == 0) {
                String transactionId = deleteApplet.getTransactionId();
                List apduList = deleteApplet.getApduList();
                if (apduList == null || apduList.isEmpty()) {
                    deleteAppletResponse.setResultCode(0);
                } else {
                    executeCommand(transactionId, apduList, deleteAppletResponse, serverAccessDeleteAppletRequest.getIssuerId(), serverAccessDeleteAppletRequest.getAppletAid(), serverAccessDeleteAppletRequest.getCplc(), serverAccessDeleteAppletRequest.getDeviceModel(), serverAccessDeleteAppletRequest.getSeChipManuFacturer());
                }
            } else {
                translateErrorCode(deleteApplet, deleteAppletResponse);
            }
        }
        return deleteAppletResponse;
    }

    public QueryOrderResponse queryOrder(QueryOrderRequest queryOrderRequest) {
        BaseResponse queryOrderResponse = new QueryOrderResponse();
        if (queryOrderRequest == null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl queryOrder, invalid param"});
            queryOrderResponse.setResultCode(1);
            queryOrderResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return queryOrderResponse;
        }
        ServerAccessQueryOrderRequest serverAccessQueryOrderRequest = new ServerAccessQueryOrderRequest(queryOrderRequest.getIssuerId(), queryOrderRequest.getCplc(), queryOrderRequest.getAppletAid(), queryOrderRequest.getDeviceModel(), queryOrderRequest.getSeChipManuFacturer());
        serverAccessQueryOrderRequest.setOrderId(queryOrderRequest.getOrderId());
        serverAccessQueryOrderRequest.setOrderStatus(queryOrderRequest.getOrderStatus());
        serverAccessQueryOrderRequest.setPhoneNumber(queryOrderRequest.getPhoneNumber());
        serverAccessQueryOrderRequest.setReserved(queryOrderRequest.getReserved());
        serverAccessQueryOrderRequest.setUserID(queryOrderRequest.getAccountUserId());
        C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl queryOrder, request.getIssuerId() = " + queryOrderRequest.getIssuerId() + " request.getCplc() = " + queryOrderRequest.getCplc() + " request.getAppletAid() = " + queryOrderRequest.getAppletAid() + " request.getDeviceModel() = " + queryOrderRequest.getDeviceModel() + " request.getDeviceModel() = " + queryOrderRequest.getDeviceModel() + " request.getSeChipManuFacturer() = " + queryOrderRequest.getSeChipManuFacturer() + " request.getOrderId() = " + queryOrderRequest.getOrderId() + " request.getOrderStatus() = " + queryOrderRequest.getOrderStatus() + " request.getPhoneNumber() = " + queryOrderRequest.getPhoneNumber() + " request.getReserved()= " + queryOrderRequest.getReserved()});
        C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl queryOrder, req = " + serverAccessQueryOrderRequest.toString()});
        ServerAccessBaseResponse queryOrder = this.cardServer.queryOrder(serverAccessQueryOrderRequest);
        if (queryOrder != null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl queryOrder, response = " + queryOrder.returnCode});
            if (queryOrder.returnCode == 0) {
                queryOrderResponse.setResultCode(0);
                List<ServerAccessQueryOrder> orderList = queryOrder.getOrderList();
                if (!(orderList == null || orderList.isEmpty())) {
                    List arrayList = new ArrayList();
                    for (ServerAccessQueryOrder serverAccessQueryOrder : orderList) {
                        QueryOrder queryOrder2 = new QueryOrder();
                        queryOrder2.setIssuerId(serverAccessQueryOrder.getIssuerId());
                        queryOrder2.setOrderId(serverAccessQueryOrder.getOrderId());
                        queryOrder2.setOrderType(serverAccessQueryOrder.getOrderType());
                        queryOrder2.setStatus(serverAccessQueryOrder.getStatus());
                        queryOrder2.setCurrency(serverAccessQueryOrder.getCurrency());
                        queryOrder2.setAmount(serverAccessQueryOrder.getAmount());
                        queryOrder2.setOrderTime(serverAccessQueryOrder.getOrderTime());
                        arrayList.add(queryOrder2);
                    }
                    queryOrderResponse.setOrderList(arrayList);
                }
            } else {
                translateErrorCode(queryOrder, queryOrderResponse);
            }
        }
        return queryOrderResponse;
    }

    private void executeCommand(String str, List<ServerAccessAPDU> list, BaseResponse baseResponse, String str2, String str3, String str4, String str5, String str6) {
        if (StringUtil.isEmpty(str, true) || list == null || list.isEmpty()) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl executeCommand, invalid param"});
            baseResponse.setResultCode(1);
            baseResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return;
        }
        ChannelID channelID = null;
        do {
            List changeServerAccessAPDU2ApduCommand = changeServerAccessAPDU2ApduCommand(list);
            TaskResult excuteApduListEx = this.omaService.excuteApduListEx(changeServerAccessAPDU2ApduCommand, channelID);
            channelID = (ChannelID) excuteApduListEx.getData();
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl executeCommand, oma execute command result = " + excuteApduListEx.getResultCode()});
            List changeApduCommand2ServerAccessAPDU = changeApduCommand2ServerAccessAPDU(changeServerAccessAPDU2ApduCommand, excuteApduListEx.getLastExcutedCommand());
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl applyAPDU, apduList " + changeApduCommand2ServerAccessAPDU.size() + changeApduCommand2ServerAccessAPDU});
            ServerAccessApplyAPDURequest serverAccessApplyAPDURequest = new ServerAccessApplyAPDURequest(str2, str3, str4, str, changeApduCommand2ServerAccessAPDU.size(), changeApduCommand2ServerAccessAPDU, str5, str6);
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl applyAPDU, start"});
            ServerAccessBaseResponse applyAPDU = this.cardServer.applyAPDU(serverAccessApplyAPDURequest);
            if (applyAPDU == null) {
                C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl executeCommand, invalid apply apdu response"});
                break;
            }
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl executeCommand, apply apdu response = " + applyAPDU.returnCode});
            if (applyAPDU.returnCode == 0) {
                list = applyAPDU.getApduList();
                if (list == null || list.isEmpty()) {
                    baseResponse.setResultCode(0);
                }
                if (list == null) {
                    break;
                }
            } else {
                translateErrorCode(applyAPDU, baseResponse);
                if (applyAPDU.returnCode == 6002) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(applyAPDU.getResultDesc());
                    stringBuilder.append("\n");
                    stringBuilder.append("ServerAccessService Interface, scene : ");
                    stringBuilder.append(baseResponse.getClass());
                    stringBuilder.append("\n");
                    stringBuilder.append("OMA result : ");
                    stringBuilder.append(excuteApduListEx.getPrintMsg());
                    stringBuilder.append("apud commands : \n");
                    int size = changeApduCommand2ServerAccessAPDU.size();
                    for (int i = 0; i < size; i++) {
                        ServerAccessAPDU serverAccessAPDU = (ServerAccessAPDU) changeApduCommand2ServerAccessAPDU.get(i);
                        stringBuilder.append(((ApduCommand) changeServerAccessAPDU2ApduCommand.get(i)).getApdu());
                        stringBuilder.append(", ");
                        stringBuilder.append(serverAccessAPDU.getApduStatus());
                        stringBuilder.append("\n");
                    }
                    baseResponse.setResultDesc(stringBuilder.toString());
                }
            }
        } while (!list.isEmpty());
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(BaseApplication.b()).getAdapter();
        if (pluginPayAdapter != null) {
            pluginPayAdapter.closeChannel();
        }
    }

    private List<ApduCommand> changeServerAccessAPDU2ApduCommand(List<ServerAccessAPDU> list) {
        List<ApduCommand> arrayList = new ArrayList();
        for (ServerAccessAPDU serverAccessAPDU : list) {
            String apduId = serverAccessAPDU.getApduId();
            if (StringUtil.isEmpty(apduId, true)) {
                C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl changeServerAccessAPDU2ApduCommand, invalid apduId"});
            } else {
                try {
                    ApduCommand apduCommand = new ApduCommand();
                    apduCommand.setIndex(Integer.parseInt(apduId));
                    apduCommand.setApdu(serverAccessAPDU.getApduContent());
                    if (serverAccessAPDU.getApduStatus() != null) {
                        apduCommand.setChecker(serverAccessAPDU.getApduStatus().split("[|]"));
                    }
                    arrayList.add(apduCommand);
                    C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl apduCommand, apduid" + apduCommand.getIndex() + "apducontent" + apduCommand.getApdu() + "apdustatus" + apduCommand.getChecker()});
                } catch (NumberFormatException e) {
                    C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl changeServerAccessAPDU2ApduCommand, NumberFormatException"});
                }
            }
        }
        return arrayList;
    }

    private List<ServerAccessAPDU> changeApduCommand2ServerAccessAPDU(List<ApduCommand> list, ApduCommand apduCommand) {
        List<ServerAccessAPDU> arrayList = new ArrayList();
        if (apduCommand != null) {
            for (ApduCommand apduCommand2 : list) {
                if (apduCommand2.getIndex() > apduCommand.getIndex()) {
                    break;
                }
                ServerAccessAPDU serverAccessAPDU = new ServerAccessAPDU();
                serverAccessAPDU.setApduId(String.valueOf(apduCommand2.getIndex()));
                if (StringUtil.isEmpty(apduCommand2.getSw(), true)) {
                    serverAccessAPDU.setApduContent("");
                    serverAccessAPDU.setApduStatus(null);
                } else {
                    serverAccessAPDU.setApduContent(apduCommand2.getRapdu() + apduCommand2.getSw());
                    serverAccessAPDU.setApduStatus(apduCommand2.getSw());
                }
                arrayList.add(serverAccessAPDU);
            }
        }
        return arrayList;
    }

    private void translateErrorCode(ServerAccessBaseResponse serverAccessBaseResponse, BaseResponse baseResponse) {
        C2538c.c(TAG, new Object[]{" doRecharge translateErrorCode: "});
        Map hashMap;
        String str;
        switch (serverAccessBaseResponse.returnCode) {
            case -99:
            case -98:
            case -4:
            case 3:
            case 4:
            case 5:
                baseResponse.setResultCode(-99);
                baseResponse.setResultDesc(serverAccessBaseResponse.getResultDesc());
                hashMap = new HashMap();
                str = "ServerAccessService Interface, " + serverAccessBaseResponse.getResultDesc() + ", scene : " + baseResponse.getClass();
                hashMap.put(CloudEyeLogger.FAIL_CODE, "" + serverAccessBaseResponse.returnCode);
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                C2538c.c(TAG, new Object[]{Integer.valueOf(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR), hashMap, str, Boolean.valueOf(false), Boolean.valueOf(false)});
                return;
            case -2:
                baseResponse.setResultCode(3);
                baseResponse.setResultDesc(serverAccessBaseResponse.getResultDesc());
                return;
            case -1:
                baseResponse.setResultCode(2);
                baseResponse.setResultDesc(serverAccessBaseResponse.getResultDesc());
                return;
            case 1:
                baseResponse.setResultCode(1);
                baseResponse.setResultDesc(serverAccessBaseResponse.getResultDesc());
                hashMap = new HashMap();
                str = "ServerAccessService Interface, " + serverAccessBaseResponse.getResultDesc() + ", scene : " + baseResponse.getClass();
                hashMap.put(CloudEyeLogger.FAIL_CODE, "" + serverAccessBaseResponse.returnCode);
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                C2538c.c(TAG, new Object[]{Integer.valueOf(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR), hashMap, str, Boolean.valueOf(false), Boolean.valueOf(false)});
                return;
            case 2:
                baseResponse.setResultCode(4);
                baseResponse.setResultDesc(serverAccessBaseResponse.getResultDesc());
                return;
            default:
                baseResponse.setResultCode(serverAccessBaseResponse.returnCode);
                baseResponse.setResultDesc(serverAccessBaseResponse.getResultDesc());
                return;
        }
    }

    public QueryAmountResponse queryAmount(QueryAmountRequest queryAmountRequest) {
        BaseResponse queryAmountResponse = new QueryAmountResponse();
        if (queryAmountRequest == null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl queryAmount, invalid param"});
            queryAmountResponse.setResultCode(1);
            queryAmountResponse.setResultDesc(BaseResponse.RESULT_DESC_INVALID_PARAM);
            return queryAmountResponse;
        }
        ServerAccessBaseResponse queryIssueOrRechargeAmount = this.cardServer.queryIssueOrRechargeAmount(new ServerAccessQueryAmountRequest(queryAmountRequest.getIssuerId(), queryAmountRequest.getFlag(), queryAmountRequest.getCplc(), queryAmountRequest.getAppletAid(), queryAmountRequest.getDeviceModel(), queryAmountRequest.getSeChipManuFacturer()));
        if (queryIssueOrRechargeAmount != null) {
            C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl queryAmount, response = " + queryIssueOrRechargeAmount.returnCode});
            if (queryIssueOrRechargeAmount.returnCode == 0) {
                queryAmountResponse.setResultCode(0);
                List<ServerAccessIssueAmount> issueAmountList = queryIssueOrRechargeAmount.getIssueAmountList();
                if (!(issueAmountList == null || issueAmountList.isEmpty())) {
                    List arrayList = new ArrayList();
                    for (ServerAccessIssueAmount serverAccessIssueAmount : issueAmountList) {
                        C2538c.c(TAG, new Object[]{"ServerAccessServiceImpl queryAmount, ia.getDenomination() = " + serverAccessIssueAmount.getDenomination() + " ; ia.getPriceEnroll() : " + serverAccessIssueAmount.getPriceEnroll() + " ; ia.getPriceRecharge() : " + serverAccessIssueAmount.getPriceRecharge()});
                        IssueAmount issueAmount = new IssueAmount(serverAccessIssueAmount.getDenomination(), serverAccessIssueAmount.getPriceEnroll(), serverAccessIssueAmount.getPriceRecharge());
                        issueAmount.setAmountEnroll(serverAccessIssueAmount.getAmountEnroll());
                        issueAmount.setAmountRecharge(serverAccessIssueAmount.getAmountRecharge());
                        arrayList.add(issueAmount);
                    }
                    queryAmountResponse.setIssueAmountList(arrayList);
                }
                List<ServerAccessRechargeAmount> rechargeAmountList = queryIssueOrRechargeAmount.getRechargeAmountList();
                if (!(rechargeAmountList == null || rechargeAmountList.isEmpty())) {
                    List arrayList2 = new ArrayList();
                    for (ServerAccessRechargeAmount serverAccessRechargeAmount : rechargeAmountList) {
                        arrayList2.add(new RechargeAmount(serverAccessRechargeAmount.getDenomination(), serverAccessRechargeAmount.getAmountRecharge()));
                    }
                    queryAmountResponse.setRechargeAmountList(arrayList2);
                }
            } else {
                translateErrorCode(queryIssueOrRechargeAmount, queryAmountResponse);
            }
        }
        return queryAmountResponse;
    }
}
