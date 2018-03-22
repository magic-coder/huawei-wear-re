package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.IssueAmount;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.RechargeAmount;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryAmountRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryAmountResponse;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;
import java.util.List;

class QueryAmountSAOperator {
    static final String FLAG_ISSUE_RECHARGE = "1";
    static final String FLAG_RECHARGE = "2";
    private static final String TAG = "QueryAmountSAOperator";
    private Context context;
    private String flag;
    private IssuerInfoItem issuerInfo;

    QueryAmountSAOperator(String str, Context context, IssuerInfoItem issuerInfoItem) {
        this.flag = str;
        this.context = context;
        this.issuerInfo = issuerInfoItem;
    }

    TrafficActivityInfo queryAmount() {
        TrafficActivityInfo trafficActivityInfo = new TrafficActivityInfo();
        trafficActivityInfo.setReturnCd(99);
        ESEInfoManager instance = ESEInfoManager.getInstance(this.context);
        QueryAmountRequest queryAmountRequest = new QueryAmountRequest(this.issuerInfo.getIssuerId(), this.flag, instance.queryCplc(), this.issuerInfo.getAid(), instance.getDeviceModel(), instance.getBusChipManu());
        LogX.i("queryAmount request" + queryAmountRequest.toString());
        QueryAmountResponse queryAmount = SPIServiceFactory.createServerAccessService(this.context).queryAmount(queryAmountRequest);
        if (queryAmount.getResultCode() == 0) {
            LogX.i("queryAmount response.getResultCode()" + queryAmount.getResultCode());
            C2538c.c(TAG, new Object[]{"queryAmount flag" + this.flag});
            List issueAmountList;
            String priceEnroll;
            String amountEnroll;
            int size;
            int i;
            if ("1".equals(this.flag)) {
                C2538c.c(TAG, new Object[]{"QueryAmountRequest.FLAG_ISSUE_RECHARGE"});
                issueAmountList = queryAmount.getIssueAmountList();
                if (!(issueAmountList == null || issueAmountList.isEmpty())) {
                    priceEnroll = ((IssueAmount) issueAmountList.get(0)).getPriceEnroll();
                    amountEnroll = ((IssueAmount) issueAmountList.get(0)).getAmountEnroll();
                    if (StringUtil.isEmpty(amountEnroll, true)) {
                        amountEnroll = priceEnroll;
                    }
                    trafficActivityInfo.setIssueActAmount(amountEnroll);
                    trafficActivityInfo.setIssueStdAmount(priceEnroll);
                    LogX.i("queryAmount priceEnroll " + priceEnroll + " amountEnroll " + amountEnroll);
                    Object obj = new String[issueAmountList.size()];
                    Object obj2 = new String[issueAmountList.size()];
                    size = issueAmountList.size();
                    for (i = 0; i < size; i++) {
                        priceEnroll = ((IssueAmount) issueAmountList.get(i)).getPriceRecharge();
                        amountEnroll = ((IssueAmount) issueAmountList.get(i)).getAmountRecharge();
                        if (StringUtil.isEmpty(amountEnroll, true)) {
                            amountEnroll = priceEnroll;
                        }
                        obj[i] = amountEnroll;
                        obj2[i] = priceEnroll;
                    }
                    LogX.i("queryAmount rechargeActList " + obj + " rechargeStdList " + obj2);
                    trafficActivityInfo.setRechargeStdAmounts(obj2);
                    trafficActivityInfo.setRechargeActAmounts(obj);
                    trafficActivityInfo.setReturnCd(0);
                }
            } else if ("2".equals(this.flag)) {
                C2538c.c(TAG, new Object[]{"QueryAmountRequest.FLAG_RECHARGE"});
                issueAmountList = queryAmount.getRechargeAmountList();
                if (!(issueAmountList == null || issueAmountList.isEmpty())) {
                    String[] strArr = new String[issueAmountList.size()];
                    String[] strArr2 = new String[issueAmountList.size()];
                    size = issueAmountList.size();
                    for (i = 0; i < size; i++) {
                        priceEnroll = ((RechargeAmount) issueAmountList.get(i)).getDenomination();
                        amountEnroll = ((RechargeAmount) issueAmountList.get(i)).getAmountRecharge();
                        if (StringUtil.isEmpty(amountEnroll, true)) {
                            amountEnroll = priceEnroll;
                        }
                        strArr[i] = amountEnroll;
                        strArr2[i] = priceEnroll;
                        C2538c.c(TAG, new Object[]{"QueryAmountRequest. amountRecharge : " + amountEnroll + " ; priceRecharge " + priceEnroll});
                    }
                    trafficActivityInfo.setRechargeStdAmounts(strArr2);
                    trafficActivityInfo.setRechargeActAmounts(strArr);
                    trafficActivityInfo.setReturnCd(0);
                }
            }
        } else {
            trafficActivityInfo.setReturnCd(translateErrorCode(queryAmount.getResultCode()));
            LogX.e("QueryAmountSAOperator err, code : " + queryAmount.getResultCode() + ", desc : " + queryAmount.getResultDesc());
            reportErr(queryAmount.getResultCode(), queryAmount.getResultDesc());
        }
        return trafficActivityInfo;
    }

    private int translateErrorCode(int i) {
        switch (i) {
            case 2:
            case 3:
                return 11;
            case 4:
                return 14;
            default:
                return 99;
        }
    }

    private void reportErr(int i, String str) {
        String str2 = "QueryAmountSAOperator err : " + str;
        int i2 = -1;
        String str3 = "-1";
        if ("1".equals(this.flag)) {
            i2 = AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN;
            str3 = "1200";
            LogUploadOperator.getInstance(this.context).init(this.issuerInfo.getIssuerId(), "1200", "query issue money,server," + i, 11);
        } else if ("2".equals(this.flag)) {
            i2 = AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_RECHARGE;
            str3 = "1502";
            LogUploadOperator.getInstance(this.context).init(this.issuerInfo.getIssuerId(), LogUploadOperator.RESULT_CODE_QUERY_RECHARGE_MONEY_FAIL, "query recharge money failed,server," + i, 11);
        }
        CloudEyeLogger.build(i2, str3, this.issuerInfo.getIssuerId()).setResultCode(i).setResultDesc(str2).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.issuerInfo.getMode()).upload();
    }
}
