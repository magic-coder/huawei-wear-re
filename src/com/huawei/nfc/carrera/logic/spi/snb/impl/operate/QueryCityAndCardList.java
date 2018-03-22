package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryCityAndCardListResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class QueryCityAndCardList extends BaseOperatorB {
    private final Map<String, String> errorMsgs = new HashMap();
    private final SNBProviderHelper mSnbProviderHelper;

    public QueryCityAndCardList(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public QueryCityAndCardListResponse queryCityAndCardList(String str, String str2) {
        this.errorMsgs.put("longitude", str);
        this.errorMsgs.put("latitue", str2);
        String cityAndCardList = this.mSnbProviderHelper.cityAndCardList(str, str2);
        LogX.i("SNBServiceImpl queryCityAndCardList respStr = " + cityAndCardList);
        SNBBaseResponse analyzeResult = analyzeResult(cityAndCardList);
        if (analyzeResult instanceof QueryCityAndCardListResponse) {
            return (QueryCityAndCardListResponse) analyzeResult;
        }
        QueryCityAndCardListResponse queryCityAndCardListResponse = new QueryCityAndCardListResponse();
        queryCityAndCardListResponse.setReturnCd(100002);
        return queryCityAndCardListResponse;
    }

    protected QueryCityAndCardListResponse makeSuccessResponse(String str) throws JSONException {
        return QueryCityAndCardListResponse.build(str, 0);
    }

    protected QueryCityAndCardListResponse makeErrorResponse(int i) {
        QueryCityAndCardListResponse queryCityAndCardListResponse = new QueryCityAndCardListResponse();
        queryCityAndCardListResponse.setReturnCd(i);
        return queryCityAndCardListResponse;
    }

    protected void reportEmptyErrorMsg() {
        String str = "SNBServiceImpl queryCityAndCardList failed. response is empty";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_CITY_AND_CADR_LIST_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportFailErrorMsg(int i, String str) {
        String str2 = "SNBServiceImpl queryCityAndCardList failed. returnCd : " + i + " msg : " + str;
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_CITY_AND_CADR_LIST_FAIL, this.errorMsgs, str2, false, false);
    }

    protected void reportDataEmptyErrorMsg() {
        String str = "SNBServiceImpl queryCityAndCardList failed. data field does not exist in response.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_CITY_AND_CADR_LIST_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        String str = "SNBServiceImpl queryCityAndCardList failed. JSONException.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        this.errorMsgs.put("fail_stack", Log.getStackTraceString(jSONException));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_CITY_AND_CADR_LIST_FAIL, this.errorMsgs, str + Log.getStackTraceString(jSONException), false, false);
    }
}
