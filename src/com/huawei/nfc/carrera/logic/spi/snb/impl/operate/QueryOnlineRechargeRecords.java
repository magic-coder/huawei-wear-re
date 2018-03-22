package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryOnlineRechargeRecordsResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class QueryOnlineRechargeRecords extends BaseOperatorB {
    private Map<String, String> errorMsgs = new HashMap();
    private SNBProviderHelper mSnbProviderHelper;

    public QueryOnlineRechargeRecords(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public QueryOnlineRechargeRecordsResponse queryOnlineRechargeRecords(String str, int i) {
        LogX.i("SNBServiceImpl queryOnlineRechargeRecords begin");
        this.errorMsgs.put("count", "" + i);
        this.errorMsgs.put("aid", str);
        SNBBaseResponse analyzeResult = analyzeResult(this.mSnbProviderHelper.recordsOnlineQuery(str, i));
        if (analyzeResult instanceof QueryOnlineRechargeRecordsResponse) {
            return (QueryOnlineRechargeRecordsResponse) analyzeResult;
        }
        QueryOnlineRechargeRecordsResponse queryOnlineRechargeRecordsResponse = new QueryOnlineRechargeRecordsResponse();
        queryOnlineRechargeRecordsResponse.setReturnCd(100002);
        return queryOnlineRechargeRecordsResponse;
    }

    protected SNBBaseResponse makeSuccessResponse(String str) throws JSONException {
        SNBBaseResponse build = QueryOnlineRechargeRecordsResponse.build(str);
        LogX.i("SNBServiceImpl queryOnlineRechargeRecords end");
        build.setReturnCd(0);
        return build;
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse queryOnlineRechargeRecordsResponse = new QueryOnlineRechargeRecordsResponse();
        queryOnlineRechargeRecordsResponse.setReturnCd(100002);
        return queryOnlineRechargeRecordsResponse;
    }

    protected void reportEmptyErrorMsg() {
        String str = "SNBServiceImpl queryOnlineRechargeRecords failed. response is empty";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_RECORDS_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportFailErrorMsg(int i, String str) {
        String str2 = "SNBServiceImpl queryOnlineRechargeRecords failed. returnCd : " + i + " msg : " + str;
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_RECORDS_FAIL, this.errorMsgs, str2, false, false);
    }

    protected void reportDataEmptyErrorMsg() {
        String str = "SNBServiceImpl queryOnlineRechargeRecords failed. data field does not exist in response.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_RECORDS_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        String str = "SNBServiceImpl queryOnlineRechargeRecords failed. JSONException.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        this.errorMsgs.put("fail_stack", Log.getStackTraceString(jSONException));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_RECORDS_FAIL, this.errorMsgs, str + Log.getStackTraceString(jSONException), false, false);
    }
}
