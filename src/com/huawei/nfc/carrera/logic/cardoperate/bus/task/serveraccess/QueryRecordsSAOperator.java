package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.appletcardinfo.AppletInfoApiFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.TransactionRecord;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryRecordsListResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryOrderResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.utils.TimeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryRecordsSAOperator {
    private static final String TAG = "QueryRecordsSAOperator";
    private Context mContext;
    private IssuerInfoItem mInfo;
    private int mPriorType;
    private QueryRecordsListResultHandler mResultHandler;
    private List<RecordInfo> mTradeRecords = new ArrayList();
    private List<RecordInfo> mUnfinishedRecords = new ArrayList();

    public QueryRecordsSAOperator(Context context, IssuerInfoItem issuerInfoItem, int i, QueryRecordsListResultHandler queryRecordsListResultHandler) {
        this.mContext = context;
        this.mPriorType = i;
        this.mResultHandler = queryRecordsListResultHandler;
        this.mInfo = issuerInfoItem;
    }

    public void queryRecords() {
        C2538c.c(TAG, new Object[]{"QueryRecordsSAOperator queryRecords begin, prior type=" + this.mPriorType});
        if (this.mPriorType == 1) {
            this.mResultHandler.handleResult(1, queryUnfinishedOrders(), this.mUnfinishedRecords);
            this.mResultHandler.handleResult(0, queryTradeRecords(), this.mTradeRecords);
        } else if (this.mPriorType == 3) {
            this.mResultHandler.handleResult(1, queryUnfinishedOrders(), this.mUnfinishedRecords);
        } else {
            this.mResultHandler.handleResult(0, queryTradeRecords(), this.mTradeRecords);
            this.mResultHandler.handleResult(1, queryUnfinishedOrders(), this.mUnfinishedRecords);
        }
    }

    private int queryTradeRecords() {
        this.mTradeRecords.clear();
        AppletCardResult readTrafficCardTransactionRecord = AppletInfoApiFactory.createAppletCardInfoReader(this.mContext).readTrafficCardTransactionRecord(this.mInfo.getAid(), this.mInfo.getProductId());
        if (readTrafficCardTransactionRecord.getResultCode() != 0) {
            return SpiResultCodeTranslator.geteSEErrorCode(readTrafficCardTransactionRecord.getResultCode());
        }
        List<TransactionRecord> list = (List) readTrafficCardTransactionRecord.getData();
        if (!(list == null || list.isEmpty())) {
            for (TransactionRecord transactionRecord : list) {
                if (transactionRecord.getRecordAmount() != 0) {
                    int i = 11;
                    if ("1".equals(transactionRecord.getRecordType())) {
                        i = 10;
                    }
                    this.mTradeRecords.add(new RecordInfo(i, 0, TimeUtil.m28481a(transactionRecord.getRecordTime(), "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss"), transactionRecord.getAmountByYuanUint()));
                }
            }
        }
        return 0;
    }

    private int queryUnfinishedOrders() {
        this.mUnfinishedRecords.clear();
        ESEInfoManager instance = ESEInfoManager.getInstance(this.mContext);
        QueryOrderRequest queryOrderRequest = new QueryOrderRequest(this.mInfo.getIssuerId(), instance.queryCplc(), this.mInfo.getAid(), instance.getDeviceModel(), instance.getBusChipManu());
        queryOrderRequest.setAccountUserId(((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID());
        queryOrderRequest.setOrderStatus("1");
        QueryOrderResponse queryOrder = SPIServiceFactory.createServerAccessService(this.mContext).queryOrder(queryOrderRequest);
        if (queryOrder.getResultCode() != 0) {
            return handleCommenErr(queryOrder.getResultCode(), queryOrder.getResultDesc());
        }
        List<QueryOrder> orderList = queryOrder.getOrderList();
        if (orderList != null && orderList.size() > 0) {
            for (QueryOrder queryOrder2 : orderList) {
                int i = 3;
                if (QueryOrder.STATUS_REFUND_FAIL.equals(queryOrder2.getStatus())) {
                    i = 1;
                }
                this.mUnfinishedRecords.add(new RecordInfo(10, i, queryOrder2.getOrderTime(), queryOrder2.getAmount()));
            }
        }
        return 0;
    }

    private int handleCommenErr(int i, String str) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
                return 25;
            default:
                reportErr(i, str);
                return 99;
        }
    }

    private void reportErr(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        hashMap.put("issuerID", String.valueOf(this.mInfo.getIssuerId()));
        C2538c.e(TAG, new Object[]{"907125867" + hashMap, "ApplyPayOrderOperator err : " + str});
    }
}
