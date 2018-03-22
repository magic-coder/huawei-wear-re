package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.content.Context;
import com.huawei.nfc.carrera.logic.ese.model.TradeRecord;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryTradeRecordsOfSeResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransQuerySe extends BaseOperatorB {
    private static final String TAG = "TransQuerySe";
    private Map<String, String> errorMsgs = new HashMap();
    protected Context mContext;
    protected SNBProviderHelper mSnbProviderHelper;

    public TransQuerySe(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public QueryTradeRecordsOfSeResponse transQuerySe(String str) {
        C2538c.d(TAG, new Object[]{"enter CardListQuery "});
        C2538c.c("SNBServiceImpl transQuerySe input param : aid : " + str, new Object[0]);
        if (StringUtil.isEmpty(str, true)) {
            C2538c.d(TAG, new Object[]{"SNBServiceImpl transQuerySe failed. param illegal.aid : " + str});
            QueryTradeRecordsOfSeResponse queryTradeRecordsOfSeResponse = new QueryTradeRecordsOfSeResponse();
            queryTradeRecordsOfSeResponse.resultCode = 100001;
            return queryTradeRecordsOfSeResponse;
        }
        this.errorMsgs.put("aid", str);
        String transQuerySe = this.mSnbProviderHelper.transQuerySe(str);
        C2538c.d(TAG, new Object[]{"SNBServiceImpl transQuerySe respStr " + transQuerySe});
        SNBBaseResponse analyzeResult = analyzeResult(transQuerySe);
        if (analyzeResult instanceof QueryTradeRecordsOfSeResponse) {
            queryTradeRecordsOfSeResponse = (QueryTradeRecordsOfSeResponse) analyzeResult;
            C2538c.c(TAG, new Object[]{"transQuerySe 转换成功"});
        } else {
            C2538c.c(TAG, new Object[]{"transQuerySe 转换失败"});
            queryTradeRecordsOfSeResponse = new QueryTradeRecordsOfSeResponse();
            queryTradeRecordsOfSeResponse.setReturnCd(100002);
        }
        if (queryTradeRecordsOfSeResponse.getReturnCd() == 0) {
            return queryTradeRecordsOfSeResponse;
        }
        String str2 = "transQuerySe , query card num failed. code : " + queryTradeRecordsOfSeResponse.getReturnCd();
        this.errorMsgs.put("fail_pos", "transQuerySe at SNBServiceImpl");
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryTradeRecordsOfSeResponse.getReturnCd()));
        C2538c.e(TAG, new Object[]{"errorcode : 907125777 ; errorMsgs : " + this.errorMsgs + " ; message : " + str2});
        queryTradeRecordsOfSeResponse = new QueryTradeRecordsOfSeResponse();
        analyzeResult.setReturnCd(queryTradeRecordsOfSeResponse.getReturnCd());
        return queryTradeRecordsOfSeResponse;
    }

    protected SNBBaseResponse makeSuccessResponse(String str) throws JSONException {
        return new QueryTradeRecordsOfSeResponse(build(str), 0);
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse queryTradeRecordsOfSeResponse = new QueryTradeRecordsOfSeResponse();
        queryTradeRecordsOfSeResponse.setReturnCd(i);
        return queryTradeRecordsOfSeResponse;
    }

    protected void reportEmptyErrorMsg() {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " transQuerySe failed. response is empty");
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + " transQuerySe failed. response is empty"});
    }

    protected void reportFailErrorMsg(int i, String str) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " transQuerySe failed. response is Fail Error resultMsg : " + str);
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + r0});
    }

    protected void reportDataEmptyErrorMsg() {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " transQuerySe failed. Data is empty");
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + " transQuerySe failed. Data is empty"});
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " transQuerySe failed. Json Exp e : " + jSONException.getMessage());
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + r0});
    }

    public static List<TradeRecord> build(String str) throws JSONException {
        C2538c.b(TAG, new Object[]{"transQuerySe build json : " + str});
        List<TradeRecord> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("records");
            if (jSONArray == null) {
                C2538c.c("SNBServiceImpl queryUnfinishedOrders no orders in response", new Object[0]);
            } else {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(TradeRecord.build(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            C2538c.c("SNBServiceImpl JSONException e " + e.getMessage(), new Object[0]);
        }
        return arrayList;
    }
}
