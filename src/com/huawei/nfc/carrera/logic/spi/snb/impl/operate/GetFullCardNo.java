package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.content.Context;
import com.huawei.nfc.carrera.logic.ese.model.GetFullCardNoInfo;
import com.huawei.nfc.carrera.logic.ese.response.GetFullCardNoResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class GetFullCardNo extends BaseOperatorB {
    private static final String TAG = "GetFullCardNo";
    private Map<String, String> errorMsgs = new HashMap();
    protected Context mContext;
    protected SNBProviderHelper mSnbProviderHelper;

    public GetFullCardNo(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public GetFullCardNoResponse getFullCardNo(String str) {
        C2538c.d(TAG, new Object[]{"enter getPayOrder  "});
        C2538c.c("SNBServiceImpl getFullCardNo input param : aid : " + str + " ; ", new Object[0]);
        if (StringUtil.isEmpty(str, true)) {
            C2538c.d(TAG, new Object[]{"SNBServiceImpl getFullCardNo  failed. param illegal.aid : " + str});
            GetFullCardNoResponse getFullCardNoResponse = new GetFullCardNoResponse();
            getFullCardNoResponse.setReturnCd(100001);
            return getFullCardNoResponse;
        }
        this.errorMsgs.put("aid", str);
        String fullCardNo = this.mSnbProviderHelper.getFullCardNo(str);
        C2538c.d(TAG, new Object[]{"SNBServiceImpl getFullCardNo respStr " + fullCardNo});
        SNBBaseResponse analyzeResult = analyzeResult(fullCardNo);
        if (analyzeResult instanceof GetFullCardNoResponse) {
            getFullCardNoResponse = (GetFullCardNoResponse) analyzeResult;
            C2538c.c(TAG, new Object[]{"GetFullCardNo 转换成功"});
        } else {
            C2538c.c(TAG, new Object[]{"GetFullCardNo 转换失败"});
            getFullCardNoResponse = new GetFullCardNoResponse();
            getFullCardNoResponse.setReturnCd(100002);
        }
        if (getFullCardNoResponse.getReturnCd() == 0) {
            return getFullCardNoResponse;
        }
        String str2 = "GetFullCardNo , query card num failed. code : " + getFullCardNoResponse.getReturnCd();
        this.errorMsgs.put("fail_pos", "getPayOrder at SNBServiceImpl");
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(getFullCardNoResponse.getReturnCd()));
        C2538c.e(TAG, new Object[]{"errorcode : 907125777 ; errorMsgs : " + this.errorMsgs + " ; message : " + str2});
        GetFullCardNoResponse getFullCardNoResponse2 = new GetFullCardNoResponse();
        getFullCardNoResponse2.setReturnCd(getFullCardNoResponse.getReturnCd());
        return getFullCardNoResponse2;
    }

    protected SNBBaseResponse makeSuccessResponse(String str) throws JSONException {
        C2538c.c(TAG, new Object[]{"GetFullCardNoResponse makeSuccessResponse"});
        C2538c.c(TAG, new Object[]{"GetFullCardNoResponse makeSuccessResponse dataJson " + str});
        return new GetFullCardNoResponse(GetFullCardNoInfo.build(str), 0);
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse getFullCardNoResponse = new GetFullCardNoResponse();
        getFullCardNoResponse.setReturnCd(i);
        return getFullCardNoResponse;
    }

    protected void reportEmptyErrorMsg() {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " GetFullCardNo failed. response is empty");
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + " GetFullCardNo failed. response is empty"});
    }

    protected void reportFailErrorMsg(int i, String str) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " GetFullCardNo failed. response is Fail Error resultMsg : " + str);
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + r0});
    }

    protected void reportDataEmptyErrorMsg() {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " GetFullCardNo failed. Data is empty");
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + " GetFullCardNo failed. Data is empty"});
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " GetFullCardNo failed. Json Exp e : " + jSONException.getMessage());
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + r0});
    }
}
