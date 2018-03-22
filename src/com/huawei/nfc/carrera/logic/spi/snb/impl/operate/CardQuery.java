package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.content.Context;
import com.huawei.nfc.carrera.logic.ese.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.ese.response.CardQueryResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.SNBBaseResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class CardQuery extends BaseOperatorB {
    private static final String TAG = "CardQuery";
    private Map<String, String> errorMsgs = new HashMap();
    protected Context mContext;
    protected SNBProviderHelper mSnbProviderHelper;

    public CardQuery(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public CardQueryResponse cardquery(String str, String str2) {
        C2538c.d(TAG, new Object[]{"enter getPayOrder "});
        C2538c.c("SNBServiceImpl queryCard input param : aid : " + str + " ; tag : " + str2, new Object[0]);
        if (StringUtil.isEmpty(str, true)) {
            C2538c.d(TAG, new Object[]{"SNBServiceImpl queryCard failed. param illegal.aid : " + str});
            CardQueryResponse cardQueryResponse = new CardQueryResponse();
            cardQueryResponse.setReturnCd(100001);
            return cardQueryResponse;
        }
        this.errorMsgs.put("aid", str);
        String cardQuery = this.mSnbProviderHelper.cardQuery(str, str2);
        C2538c.d(TAG, new Object[]{"SNBServiceImpl queryCard respStr " + cardQuery});
        SNBBaseResponse analyzeResult = analyzeResult(cardQuery);
        if (analyzeResult instanceof CardQueryResponse) {
            cardQueryResponse = (CardQueryResponse) analyzeResult;
            C2538c.c(TAG, new Object[]{"Cardquery 转换成功"});
        } else {
            C2538c.c(TAG, new Object[]{"Cardquery 转换失败"});
            cardQueryResponse = new CardQueryResponse();
            cardQueryResponse.setReturnCd(100002);
        }
        if (cardQueryResponse.getReturnCd() == 0) {
            return cardQueryResponse;
        }
        String str3 = "Cardquery , query card num failed. code : " + cardQueryResponse.getReturnCd();
        this.errorMsgs.put("fail_pos", "getPayOrder at SNBServiceImpl");
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str3);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(cardQueryResponse.getReturnCd()));
        C2538c.e(TAG, new Object[]{"errorcode : 907125777 ; errorMsgs : " + this.errorMsgs + " ; message : " + str3});
        CardQueryResponse cardQueryResponse2 = new CardQueryResponse();
        cardQueryResponse2.setReturnCd(cardQueryResponse.getReturnCd());
        return cardQueryResponse2;
    }

    protected SNBBaseResponse makeSuccessResponse(String str) throws JSONException {
        C2538c.c(TAG, new Object[]{"CardQueryResponse makeSuccessResponse"});
        C2538c.c(TAG, new Object[]{"CardQueryResponse makeSuccessResponse dataJson " + str});
        return new CardQueryResponse(TrafficCardInfo.build(str), 0);
    }

    protected SNBBaseResponse makeErrorResponse(int i) {
        SNBBaseResponse cardQueryResponse = new CardQueryResponse();
        cardQueryResponse.setReturnCd(i);
        return cardQueryResponse;
    }

    protected void reportEmptyErrorMsg() {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " CardQuery failed. response is empty");
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + " CardQuery failed. response is empty"});
    }

    protected void reportFailErrorMsg(int i, String str) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " CardQuery failed. response is Fail Error resultMsg : " + str);
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + r0});
    }

    protected void reportDataEmptyErrorMsg() {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " CardQuery failed. Data is empty");
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + " CardQuery failed. Data is empty"});
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, " CardQuery failed. Json Exp e : " + jSONException.getMessage());
        C2538c.e(TAG, new Object[]{"errorMsgs : " + this.errorMsgs + " ; message : " + r0});
    }
}
