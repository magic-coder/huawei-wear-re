package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.spi.snb.response.IssueCardActResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class QueryIssueCardCoupon extends BaseOperatorB {
    private Map<String, String> errorMsgs = new HashMap();
    private SNBProviderHelper mSnbProviderHelper;

    public QueryIssueCardCoupon(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public IssueCardActResponse queryIssueCardCoupon(String str, String str2) {
        this.errorMsgs.put("aid", str);
        this.errorMsgs.put("cardId", str2);
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true)) {
            LogX.w("SNBServiceImpl queryIssueCardCoupon param is illegal. aid = " + str + " cardId = " + str2);
            IssueCardActResponse issueCardActResponse = new IssueCardActResponse();
            issueCardActResponse.setReturnCd(100002);
            return issueCardActResponse;
        }
        LogX.i("SNBServiceImpl queryIssueCardCoupon start = ");
        String cardCoupon = this.mSnbProviderHelper.cardCoupon(str2, str);
        LogX.i("SNBServiceImpl queryIssueCardCoupon respStr = " + cardCoupon);
        SNBBaseResponse analyzeResult = analyzeResult(cardCoupon);
        if (analyzeResult instanceof IssueCardActResponse) {
            return (IssueCardActResponse) analyzeResult;
        }
        issueCardActResponse = new IssueCardActResponse();
        issueCardActResponse.setReturnCd(100002);
        return issueCardActResponse;
    }

    protected SNBBaseResponse makeSuccessResponse(String str) throws JSONException {
        SNBBaseResponse build = IssueCardActResponse.build(str);
        build.setReturnCd(0);
        return build;
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse issueCardActResponse = new IssueCardActResponse();
        issueCardActResponse.setReturnCd(i);
        return issueCardActResponse;
    }

    protected void reportEmptyErrorMsg() {
        String str = "SNBServiceImpl queryIssueCardCoupon failed. response is empty";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_ISSUE_COUPON_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportFailErrorMsg(int i, String str) {
        String str2 = "SNBServiceImpl queryIssueCardCoupon failed. returnCd : " + i + " msg : " + str;
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_ISSUE_COUPON_FAIL, this.errorMsgs, str2, false, false);
    }

    protected void reportDataEmptyErrorMsg() {
        String str = "SNBServiceImpl queryIssueCardCoupon failed. data field does not exist in response.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_ISSUE_COUPON_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        String str = "SNBServiceImpl queryIssueCardCoupon failed. JSONException.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        this.errorMsgs.put("fail_stack", Log.getStackTraceString(jSONException));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_ISSUE_COUPON_FAIL, this.errorMsgs, str + Log.getStackTraceString(jSONException), false, false);
    }
}
