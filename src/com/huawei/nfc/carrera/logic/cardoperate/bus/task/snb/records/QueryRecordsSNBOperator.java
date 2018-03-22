package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.records;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.RecordInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryRecordsListResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.ese.model.TradeRecord;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryTradeRecordsOfSeResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryUnfinishedOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RecordServerInfo;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class QueryRecordsSNBOperator {
    private Context mContext;
    private IssuerInfoItem mInfo;
    private int mPriorType;
    private List<RecordInfo> mRechargeRecords = new ArrayList();
    private QueryRecordsListResultHandler mResultHandler;
    private List<RecordInfo> mTradeRecords = new ArrayList();

    public QueryRecordsSNBOperator(Context context, IssuerInfoItem issuerInfoItem, int i, QueryRecordsListResultHandler queryRecordsListResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mPriorType = i;
        this.mResultHandler = queryRecordsListResultHandler;
    }

    public void queryRecords() {
        if (this.mPriorType == 1) {
            this.mResultHandler.handleResult(1, queryUnfinishedOrders(), this.mRechargeRecords);
            this.mResultHandler.handleResult(0, queryTradeRecords(), this.mTradeRecords);
            return;
        }
        this.mResultHandler.handleResult(0, queryTradeRecords(), this.mTradeRecords);
        this.mResultHandler.handleResult(1, queryUnfinishedOrders(), this.mRechargeRecords);
    }

    int queryTradeRecords() {
        this.mTradeRecords.clear();
        QueryTradeRecordsOfSeResponse transQuerySe = ESEInfoManager.getInstance(this.mContext).transQuerySe(this.mInfo.getAid());
        if (transQuerySe.getReturnCd() != 0) {
            return SpiResultCodeTranslator.geteSEErrorCode(transQuerySe.getReturnCd());
        }
        List<TradeRecord> list = transQuerySe.records;
        if (!(list == null || list.isEmpty())) {
            for (TradeRecord tradeRecord : list) {
                int i = 11;
                if ("1".equals(tradeRecord.getType())) {
                    i = 10;
                }
                this.mTradeRecords.add(new RecordInfo(i, 0, tradeRecord.getTime(), MoneyUtil.convertFenToYuan(tradeRecord.getAmount())));
            }
        }
        return 0;
    }

    int queryUnfinishedOrders() {
        String aid = this.mInfo.getAid();
        this.mRechargeRecords.clear();
        QueryUnfinishedOrdersResponse queryUnfinishedOrders = SPIServiceFactory.createSNBService(this.mContext).queryUnfinishedOrders(aid);
        if (queryUnfinishedOrders.getReturnCd() != 0) {
            return SpiResultCodeTranslator.getSnbResultCode(queryUnfinishedOrders.getReturnCd());
        }
        for (RecordServerInfo recordServerInfo : queryUnfinishedOrders.unfinishedOrders) {
            int i;
            String str;
            switch (recordServerInfo.getOrderStatus()) {
                case 1001:
                case 1002:
                case 1005:
                case 1006:
                case 1007:
                    i = 3;
                    break;
                case 1004:
                    i = 1;
                    break;
                case 1008:
                    i = 2;
                    break;
                default:
                    i = 3;
                    break;
            }
            if (StringUtil.isEmpty(recordServerInfo.getOrderAmount(), true)) {
                str = "0.00";
            } else {
                str = MoneyUtil.convertFenToYuan(recordServerInfo.getOrderAmount());
            }
            this.mRechargeRecords.add(new RecordInfo(10, i, recordServerInfo.getOrderTime(), str));
        }
        return 0;
    }
}
