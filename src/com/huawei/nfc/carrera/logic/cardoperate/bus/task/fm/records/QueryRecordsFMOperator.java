package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.records;

import android.content.Context;
import cn.com.fmsh.nfcos.client.service.huawei.CardAppRecord;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryRecordsListResultHandler;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrdersRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryTradeResponse;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class QueryRecordsFMOperator {
    private String mAid;
    private Context mContext;
    private int mPriorType;
    private List<RecordInfo> mRechargeRecords = new ArrayList();
    private QueryRecordsListResultHandler mResultHandler;
    private List<RecordInfo> mTradeRecords = new ArrayList();

    public QueryRecordsFMOperator(Context context, int i, QueryRecordsListResultHandler queryRecordsListResultHandler, String str) {
        this.mContext = context;
        this.mPriorType = i;
        this.mResultHandler = queryRecordsListResultHandler;
        this.mAid = str;
    }

    public void queryRecords() {
        LogX.i("QueryRecordsFMOperator queryRecords begin, prior type=" + this.mPriorType);
        if (this.mPriorType == 1) {
            this.mResultHandler.handleResult(1, queryRechargeRecords(), this.mRechargeRecords);
            this.mResultHandler.handleResult(0, queryTradeRecords(), this.mTradeRecords);
            return;
        }
        this.mResultHandler.handleResult(0, queryTradeRecords(), this.mTradeRecords);
        this.mResultHandler.handleResult(1, queryRechargeRecords(), this.mRechargeRecords);
    }

    int queryTradeRecords() {
        LogX.i("QueryRecordsFMOperator queryTradeRecords begin");
        this.mTradeRecords.clear();
        LogX.d(" CardEvent queryTrade bus cardEvent START_LOCK");
        WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mAid);
        LogX.i("queryTradeRecords  myAid : " + this.mAid);
        QueryTradeResponse queryTrade = SPIServiceFactory.createFMService(this.mContext, this.mAid).queryTrade(this.mAid);
        LogX.i(" CardEvent queryTrade bus cardEvent END_LOCK");
        WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mAid);
        if (queryTrade.resultCode != 0) {
            Map hashMap = new HashMap();
            String str = "QueryRecordsFMOperator queryTradeRecords, query trade records fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryTrade.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_READ_TRADE_RECORDS_FAIL, hashMap, str, false, false);
            return 99;
        } else if (queryTrade.tradeRecords == null) {
            return 0;
        } else {
            LogX.i(" CardEvent queryTrade .response.tradeRecords.length : " + queryTrade.tradeRecords.length);
            for (CardAppRecord cardAppRecord : queryTrade.tradeRecords) {
                if (!(cardAppRecord == null || cardAppRecord.amount == 0)) {
                    int i;
                    String formatDate2String = formatDate2String(parseString2Date(cardAppRecord.tradeDate + cardAppRecord.tradeTime, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss");
                    LogX.i(" CardEvent queryTrade .time : " + formatDate2String);
                    if (cardAppRecord.tradeType == 12 || cardAppRecord.tradeType == 6) {
                        i = 10;
                    } else {
                        i = 11;
                    }
                    this.mTradeRecords.add(new RecordInfo(i, 0, formatDate2String, MoneyUtil.convertFenToYuan(String.valueOf(cardAppRecord.amount))));
                }
            }
            return 0;
        }
    }

    int queryRechargeRecords() {
        LogX.i("QueryRecordsFMOperator queryRechargeRecords begin");
        this.mRechargeRecords.clear();
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(0, new int[]{2, 4, 5, 12, 6, 7, 8, 11}, 1, null, this.mAid);
        while (true) {
            LogX.d(" CardEvent RECHARGE bus cardEvent START_LOCK");
            WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mAid);
            LogX.i("queryRechargeRecords  myAid : " + this.mAid);
            QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mAid).queryBusinessOrders(build);
            LogX.d(" CardEvent RECHARGE bus cardEvent END_LOCK");
            WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mAid);
            if (queryBusinessOrders.resultCode != 0) {
                break;
            } else if (queryBusinessOrders.orderList == null) {
                return 0;
            } else {
                int size = queryBusinessOrders.orderList.size();
                for (int i = 0; i < size; i++) {
                    NfcosBusinessOrder nfcosBusinessOrder = (NfcosBusinessOrder) queryBusinessOrders.orderList.get(i);
                    this.mRechargeRecords.add(new RecordInfo(10, convertStatus(nfcosBusinessOrder.tradeState), formatDate2String(parseString2Date(nfcosBusinessOrder.tradeDate + nfcosBusinessOrder.tradeTime, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss"), MoneyUtil.convertFenToYuan(String.valueOf(nfcosBusinessOrder.amount))));
                }
                if (size < 10) {
                    return 0;
                }
                build.setStart(build.getStart() + 10);
            }
        }
        if (queryBusinessOrders.resultCode == -2) {
            LogX.e("QueryRecordsFMOperator queryRechargeRecords, NETWORK_ERROR");
            return 11;
        }
        Map hashMap = new HashMap();
        String str = "QueryRecordsFMOperator queryRechargeRecords, query unfinished orders fail";
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryBusinessOrders.FMCode));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_QUERY_UNFINISHED_ORDERS_FAIL, hashMap, str, false, false);
        return 99;
    }

    private int convertStatus(int i) {
        if (i == 7) {
            return 2;
        }
        if (i == 6) {
            return 1;
        }
        return 3;
    }

    private Date parseString2Date(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            LogX.e("QueryRecordsFMOperator parseString2Date ParseException, dateStr=" + str);
            return null;
        }
    }

    private String formatDate2String(Date date, String str) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }
}
