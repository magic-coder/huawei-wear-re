package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryUnfinishedOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class QueryUnfinishedOrders extends BaseOperatorB {
    private Map<String, String> errorMsgs = new HashMap();
    private SNBProviderHelper mSnbProviderHelper;

    public QueryUnfinishedOrders(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public QueryUnfinishedOrdersResponse queryUnfinishedOrders(String str) {
        this.errorMsgs.put("aid", str);
        String orderQuery = this.mSnbProviderHelper.orderQuery(str);
        LogX.i("SNBServiceImpl queryUnfinishedOrders respStr = " + orderQuery);
        SNBBaseResponse analyzeResult = analyzeResult(orderQuery);
        if (analyzeResult instanceof QueryUnfinishedOrdersResponse) {
            return (QueryUnfinishedOrdersResponse) analyzeResult;
        }
        QueryUnfinishedOrdersResponse queryUnfinishedOrdersResponse = new QueryUnfinishedOrdersResponse();
        queryUnfinishedOrdersResponse.setReturnCd(100002);
        return queryUnfinishedOrdersResponse;
    }

    protected SNBBaseResponse makeSuccessResponse(String str) throws JSONException {
        return QueryUnfinishedOrdersResponse.build(str, 0);
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse queryUnfinishedOrdersResponse = new QueryUnfinishedOrdersResponse();
        queryUnfinishedOrdersResponse.setReturnCd(i);
        return queryUnfinishedOrdersResponse;
    }

    protected void reportEmptyErrorMsg() {
        String str = "SNBServiceImpl queryUnfinishedOrders failed. response is empty";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_UNFINISHED_ORDERS_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportFailErrorMsg(int i, String str) {
        String str2 = "SNBServiceImpl queryUnfinishedOrders failed. returnCd : " + i + " msg : " + str;
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_UNFINISHED_ORDERS_FAIL, this.errorMsgs, str2, false, false);
    }

    protected void reportDataEmptyErrorMsg() {
        String str = "SNBServiceImpl queryUnfinishedOrders failed. data field does not exist in response.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_UNFINISHED_ORDERS_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        String str = "SNBServiceImpl queryUnfinishedOrders failed. JSONException.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        this.errorMsgs.put("fail_stack", Log.getStackTraceString(jSONException));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_UNFINISHED_ORDERS_FAIL, this.errorMsgs, str + Log.getStackTraceString(jSONException), false, false);
    }
}
