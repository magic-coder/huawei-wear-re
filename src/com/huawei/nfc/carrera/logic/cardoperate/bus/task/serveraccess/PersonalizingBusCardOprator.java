package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.appletcardinfo.AppletInfoApiFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.IssueTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.ApplyOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.PersonalizeAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.PersonalizeAppletResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.nfc.carrera.util.logger.LoggerConstant;
import java.util.List;

public class PersonalizingBusCardOprator {
    private final Context mContext;
    private final IssuerInfoItem mInfo;
    private final TrafficOrder mOrder;
    private final IssueTrafficCardResultHandler mResultHandler;

    public PersonalizingBusCardOprator(Context context, IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mOrder = trafficOrder;
        this.mResultHandler = issueTrafficCardResultHandler;
    }

    public int issueTrafficCard() {
        LogX.i("IssueTrafficCardSAOperator issueTrafficCard begin");
        if (this.mInfo == null || this.mInfo.getIssuerId() == null || this.mInfo.getAid() == null || this.mOrder == null) {
            String str = "IssueTrafficCardSAOperator issueTrafficCard, param is null";
            LogX.e(str);
            CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN).setFailCode(LoggerConstant.RESULT_CODE_ISSUE_CARD_OTHER_FAIL).setResultCode(10).setResultDesc(str).upload();
            handleResult(10);
            return 10;
        }
        int checkDownloadResult = checkDownloadResult();
        if (checkDownloadResult != 0) {
            String str2 = "IssueTrafficCardSAOperator issueTrafficCard, checkDownloadResult failed!";
            LogX.e(str2);
            CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN, LoggerConstant.RESULT_CODE_ISSUE_CARD_OTHER_FAIL, this.mInfo.getIssuerId()).setResultCode(checkDownloadResult).setResultDesc(str2).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).upload();
            handleResult(checkDownloadResult);
            return checkDownloadResult;
        }
        ESEInfoManager instance = ESEInfoManager.getInstance(this.mContext);
        String queryCplc = instance.queryCplc();
        String deviceSN = instance.getDeviceSN();
        String deviceModel = instance.getDeviceModel();
        String busChipManu = instance.getBusChipManu();
        String orderID = getOrderID();
        if (orderID == null) {
            CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN, LoggerConstant.RESULT_CODE_ISSUE_CARD_OTHER_FAIL, this.mInfo.getIssuerId()).setResultCode(10).setResultDesc("IssueTrafficCardSAOperator issueTrafficCard err, get orderID err.").appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).upload();
            handleResult(10);
            return 10;
        }
        addTaCard();
        PersonalizeAppletRequest personalizeAppletRequest = new PersonalizeAppletRequest(this.mInfo.getIssuerId(), orderID, queryCplc, this.mInfo.getAid(), deviceModel, busChipManu);
        personalizeAppletRequest.setAccountUserId(((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID());
        personalizeAppletRequest.setImei(deviceSN);
        PersonalizeAppletResponse personalizeApplet = SPIServiceFactory.createServerAccessService(this.mContext).personalizeApplet(personalizeAppletRequest);
        LogX.i("IssueTrafficCardSAOperator issueTrafficCard end");
        if (personalizeApplet.getResultCode() == 0) {
            str2 = getCardNum();
            if (StringUtil.isEmpty(str2, true)) {
                handleResult(IssueTrafficCardCallback.RETURN_FAILED_READ_CARDNUM_FAILED);
                LogX.i("PersonalizingBusCardOprator SA issuerCard failed. getCardNum failed.");
                return IssueTrafficCardCallback.RETURN_FAILED_READ_CARDNUM_FAILED;
            }
            checkDownloadResult = updateTaInfo(str2);
            if (checkDownloadResult != 0) {
                handleResult(checkDownloadResult);
                str2 = "PersonalizingBusCardOprator SA issuerCard failed. getCardNum failed.";
                LogX.i(str2);
                CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN, "1102", this.mInfo.getIssuerId()).setResultCode(checkDownloadResult).setResultDesc(str2).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).appendExtraInfo("orderNo", orderID).appendExtraInfo("aid", this.mInfo.getAid()).upload();
                LogUploadOperator.getInstance(this.mContext).init(this.mInfo.getIssuerId(), "1102", "issue card,server," + checkDownloadResult, 11);
                return checkDownloadResult;
            }
            report(this.mInfo.getAid(), this.mInfo.getIssuerId(), str2);
            handleResult(0);
            return 0;
        }
        CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN, "1102", this.mInfo.getIssuerId()).setResultCode(personalizeApplet.getResultCode()).setResultDesc("PersonalizingBusCardOperator SA issuerCard failed." + personalizeApplet.getResultDesc()).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).appendExtraInfo("orderNo", orderID).upload();
        LogUploadOperator.getInstance(this.mContext).init(this.mInfo.getIssuerId(), "1102", "issue card,server," + personalizeApplet.getResultCode(), 11);
        return handleErrCode(personalizeApplet.getResultCode(), personalizeApplet.getResultDesc());
    }

    private int checkDownloadResult() {
        int excute = new InitDmsdAndDownloadAppletOperator(this.mContext, this.mInfo.getAid(), this.mInfo.getIssuerId(), false).excute();
        if (excute == 99) {
            return IssueTrafficCardCallback.RETURN_FAILED_SSD_INSTALL_FAILED;
        }
        return excute;
    }

    private int updateTaInfo(String str) {
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(this.mInfo.getAid());
        if (cardInfoByAid != null) {
            int i;
            cardInfoByAid.setFpanFour(str);
            cardInfoByAid.setCardStatus(2);
            cardInfoByAid.setStatusUpdateTime(System.currentTimeMillis());
            try {
                WalletTaManager.getInstance(this.mContext).removeCard(this.mInfo.getAid());
                i = 1;
            } catch (Throwable e) {
                LogX.e("WalletTaCardNotExistException ", e);
                i = 1;
            } catch (Throwable e2) {
                LogX.e("WalletTaSystemErrorException ", e2);
                i = 0;
            }
            if (i != 0) {
                try {
                    WalletTaManager.getInstance(this.mContext).addCard(cardInfoByAid);
                    return 0;
                } catch (Throwable e3) {
                    LogX.e("WalletTaCardAlreadyExistException ", e3);
                    return 99;
                } catch (Throwable e32) {
                    LogX.e("WalletTaSystemErrorException ", e32);
                    return IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT;
                } catch (Throwable e322) {
                    LogX.e("WalletTaSystemErrorException ", e322);
                    return 99;
                } catch (Throwable e3222) {
                    LogX.e("WalletTaSystemErrorException ", e3222);
                }
            }
        }
        return 99;
    }

    private String getCardNum() {
        AppletCardResult readTrafficCardInfo = AppletInfoApiFactory.createAppletCardInfoReader(this.mContext).readTrafficCardInfo(this.mInfo.getAid(), this.mInfo.getProductId(), 1);
        if (readTrafficCardInfo.getResultCode() == 0) {
            return ((CardInfo) readTrafficCardInfo.getData()).getCardNum();
        }
        CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN, "1102", this.mInfo.getIssuerId()).setResultCode(readTrafficCardInfo.getResultCode()).setResultDesc("PersonalizingBusCardOperator getCardNum failed. " + readTrafficCardInfo.getMsg()).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).appendExtraInfo("orderNo", this.mOrder.getPayInfo().getRequestId()).appendExtraInfo("aid", this.mInfo.getAid()).upload();
        LogUploadOperator.getInstance(this.mContext).init(this.mInfo.getIssuerId(), "1102", "issue card,server," + readTrafficCardInfo.getResultCode(), 11);
        return null;
    }

    private void addTaCard() {
        if (WalletTaManager.getInstance(this.mContext).getCardInfoByAid(this.mInfo.getAid()) != null) {
            LogX.i("add bus card to TA, allready add, do nothing.");
            return;
        }
        TACardInfo tACardInfo = new TACardInfo();
        tACardInfo.setAid(this.mInfo.getAid());
        tACardInfo.setIssuerId(this.mInfo.getIssuerId());
        tACardInfo.setProductId(this.mInfo.getProductId());
        tACardInfo.setCardGroupType(2);
        tACardInfo.setDefaultCard(false);
        tACardInfo.setDpanDigest(this.mInfo.getAid());
        tACardInfo.setDpanFour("");
        tACardInfo.setCardType(11);
        tACardInfo.setStatusUpdateTime(System.currentTimeMillis());
        tACardInfo.setCardStatus(11);
        try {
            WalletTaManager.getInstance(this.mContext).addCard(tACardInfo);
        } catch (Throwable e) {
            LogX.e("WalletTaCardAlreadyExistException ", e);
        } catch (Throwable e2) {
            LogX.e("WalletTaCardNumReachMaxException ", e2);
        } catch (Throwable e22) {
            LogX.e("WalletTaBadParammeterException ", e22);
        } catch (Throwable e222) {
            LogX.e("WalletTaSystemErrorException ", e222);
        }
    }

    private String getOrderID() {
        if (this.mOrder.getHasUnusedIssueOrder()) {
            return getUnfinishedOrderID();
        }
        List<ApplyOrder> applyOrders = this.mOrder.getApplyOrders();
        if (applyOrders == null || applyOrders.size() < 1) {
            LogX.e("IssueTrafficCardSAOperator issueTrafficCard, query orders err!");
            return null;
        }
        ApplyOrder applyOrder = null;
        ApplyOrder applyOrder2 = null;
        for (ApplyOrder applyOrder3 : applyOrders) {
            ApplyOrder applyOrder32;
            if ("0".equals(applyOrder32.getOrderType())) {
                ApplyOrder applyOrder4 = applyOrder;
                applyOrder = applyOrder32;
                applyOrder32 = applyOrder4;
            } else if ("2".equals(applyOrder32.getOrderType())) {
                applyOrder = applyOrder2;
            } else {
                applyOrder32 = applyOrder;
                applyOrder = applyOrder2;
            }
            applyOrder2 = applyOrder;
            applyOrder = applyOrder32;
        }
        if (applyOrder2 != null) {
            return applyOrder2.getOrderId();
        }
        if (applyOrder != null) {
            return applyOrder.getOrderId();
        }
        return null;
    }

    private String getUnfinishedOrderID() {
        List<QueryOrder> queryOrders = this.mOrder.getQueryOrders();
        if (queryOrders == null || queryOrders.size() < 1) {
            LogX.e("IssueTrafficCardSAOperator issueTrafficCard, query orders err!");
            return null;
        }
        QueryOrder queryOrder = null;
        QueryOrder queryOrder2 = null;
        for (QueryOrder queryOrder3 : queryOrders) {
            QueryOrder queryOrder32;
            if ("0".equals(queryOrder32.getOrderType())) {
                QueryOrder queryOrder4 = queryOrder;
                queryOrder = queryOrder32;
                queryOrder32 = queryOrder4;
            } else if ("2".equals(queryOrder32.getOrderType())) {
                queryOrder = queryOrder2;
            } else {
                queryOrder32 = queryOrder;
                queryOrder = queryOrder2;
            }
            queryOrder2 = queryOrder;
            queryOrder = queryOrder32;
        }
        if (queryOrder2 != null) {
            return queryOrder2.getOrderId();
        }
        if (queryOrder != null) {
            return queryOrder.getOrderId();
        }
        return null;
    }

    private void handleResult(int i) {
        if (this.mResultHandler != null) {
            this.mResultHandler.handleResult(i);
        }
    }

    private int handleErrCode(int i, String str) {
        int i2;
        LogX.e("PersonalizingBusCardOprator, code =" + i + ", desc = " + str);
        switch (i) {
            case 1:
                i2 = 10;
                break;
            case 2:
                i2 = 11;
                break;
            case 3:
                i2 = 25;
                break;
            default:
                i2 = IssueTrafficCardCallback.RETURN_FAILED_ISSUE_CARD_INNER_ERROR;
                break;
        }
        handleResult(i2);
        return i2;
    }

    private void report(String str, String str2, String str3) {
        String name = this.mInfo.getName();
        CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(str, null, name, str3, str2, 11);
        NfcHianalyticsUtil.onReportForCardOpened(this.mContext, str, name, str2, 11);
        LogUploadOperator.getInstance(this.mContext).init(str2, "1000", LogUploadOperator.RESULT_DESC_OPEN_CARD, 11);
        LogUploadOperator.getInstance(this.mContext).init(this.mInfo.getIssuerId(), "0", LogUploadOperator.RESULT_DESC_OPEN_CARD, 11);
    }
}
