package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeActResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class QueryRechargeCoupon extends BaseOperatorB {
    private Map<String, String> errorMsgs = new HashMap();
    private SNBProviderHelper mSnbProviderHelper;

    public QueryRechargeCoupon(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public RechargeActResponse queryRechargeCoupon(String str, String str2) {
        this.errorMsgs.put("aid", str);
        this.errorMsgs.put("cardId", str2);
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true)) {
            LogX.w("SNBServiceImpl queryRechargeCoupon param is illegal. aid = " + str + " cardId = " + str2);
            RechargeActResponse rechargeActResponse = new RechargeActResponse();
            rechargeActResponse.setReturnCd(100001);
            return rechargeActResponse;
        }
        SNBBaseResponse analyzeResult = analyzeResult(this.mSnbProviderHelper.rechargeCoupon(str, str2));
        if (analyzeResult instanceof RechargeActResponse) {
            return (RechargeActResponse) analyzeResult;
        }
        rechargeActResponse = new RechargeActResponse();
        rechargeActResponse.setReturnCd(100002);
        return rechargeActResponse;
    }

    protected SNBBaseResponse makeSuccessResponse(String str) throws JSONException {
        SNBBaseResponse build = RechargeActResponse.build(str);
        build.setReturnCd(0);
        return build;
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse rechargeActResponse = new RechargeActResponse();
        rechargeActResponse.setReturnCd(i);
        return rechargeActResponse;
    }

    protected void reportEmptyErrorMsg() {
        String str = "SNBServiceImpl queryRechargeCoupon failed. response is empty";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_COUPON_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportFailErrorMsg(int i, String str) {
        String str2 = "SNBServiceImpl queryRechargeCoupon failed. returnCd : " + i + " msg : " + str;
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_COUPON_FAIL, this.errorMsgs, str2, false, false);
    }

    protected void reportDataEmptyErrorMsg() {
        String str = "SNBServiceImpl queryRechargeCoupon failed. data field does not exist in response.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_COUPON_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        String str = "SNBServiceImpl queryRechargeCoupon failed. JSONException.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        this.errorMsgs.put("fail_stack", Log.getStackTraceString(jSONException));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_QUERY_RECHARGE_COUPON_FAIL, this.errorMsgs, str + Log.getStackTraceString(jSONException), false, false);
    }
}
