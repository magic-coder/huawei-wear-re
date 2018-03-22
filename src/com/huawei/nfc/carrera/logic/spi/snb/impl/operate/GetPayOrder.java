package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.PayInfo;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.logic.spi.snb.response.PayOrderResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class GetPayOrder extends BaseOperatorB {
    private Map<String, String> errorMsgs = new HashMap();
    protected Context mContext;
    protected SNBProviderHelper mSnbProviderHelper;
    private int type;

    public GetPayOrder(Context context, SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
        this.mContext = context;
    }

    public PayOrderResponse getPayOrder(String str, String str2, double d, int i, double d2, int i2) {
        this.type = i;
        String str3 = "SNBServiceImpl getPayOrder input param : aid : " + str + " busCode : " + str2 + " amount : " + d + " type : " + i + " issueCardCost : " + d2 + " actFlg : " + i2;
        LogX.i(str3);
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true) || d < 0.0d || d2 < 0.0d) {
            LogX.w("SNBServiceImpl getPayOrder failed. param illegal.aid : " + str + " busCode : " + str2 + " amount : " + d + " issueCardCost : " + d2);
            PayOrderResponse payOrderResponse = new PayOrderResponse();
            payOrderResponse.setReturnCd(100001);
            return payOrderResponse;
        }
        this.errorMsgs.put("inputParam", str3);
        this.errorMsgs.put("aid", str);
        String str4 = SNBConstant.DEFAULT_CARD_NO;
        if (i == 2) {
            QueryCardInfoResponse queryTrafficCardInfo = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryTrafficCardInfo(str, 1);
            if (queryTrafficCardInfo.resultCode != 0) {
                str3 = "apply snb recharge order, query card num failed. code : " + queryTrafficCardInfo.resultCode;
                this.errorMsgs.put("fail_pos", "getPayOrder at SNBServiceImpl");
                this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str3);
                this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryTrafficCardInfo.resultCode));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_READ_CARDNUM_FAIL, this.errorMsgs, str3, false, false);
                payOrderResponse = new PayOrderResponse();
                payOrderResponse.setReturnCd(queryTrafficCardInfo.resultCode);
                return payOrderResponse;
            }
            str4 = queryTrafficCardInfo.cardInfo.getCardNo();
        }
        SNBBaseResponse analyzeResult = analyzeResult(this.mSnbProviderHelper.getPayOrder(str, str2, d, i, d2, i2, str4));
        if (analyzeResult instanceof PayOrderResponse) {
            return (PayOrderResponse) analyzeResult;
        }
        payOrderResponse = new PayOrderResponse();
        payOrderResponse.setReturnCd(100002);
        return payOrderResponse;
    }

    protected void reportEmptyErrorMsg() {
        String str = "SNBServiceImpl getPayOrder failed. response is empty.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_APPLY_ORDER_FAIL, this.errorMsgs, str, false, false);
    }

    protected void reportFailErrorMsg(int i, String str) {
        String str2 = "SNBServiceImpl getPayOrder failed. returnCd : " + i + " msg : " + str;
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        this.errorMsgs.put(SNBConstant.FIELD_ORDER_TYPE, this.type == 2 ? "RECHARGE" : "ISSUE CARD");
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_APPLY_ORDER_FAIL, this.errorMsgs, str2, false, false);
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        String str = "SNBServiceImpl getPayOrder parse json failed.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        this.errorMsgs.put("fail_stack", Log.getStackTraceString(jSONException));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_APPLY_ORDER_FAIL, this.errorMsgs, str + Log.getStackTraceString(jSONException), false, false);
    }

    protected SNBBaseResponse makeSuccessResponse(String str) {
        return new PayOrderResponse(PayInfo.build(str, true), 0);
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse payOrderResponse = new PayOrderResponse();
        payOrderResponse.setReturnCd(i);
        return payOrderResponse;
    }

    protected void reportDataEmptyErrorMsg() {
        String str = "SNBServiceImpl getPayOrder failed. response is empty.";
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_APPLY_ORDER_FAIL, this.errorMsgs, str, false, false);
    }
}
