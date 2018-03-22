package com.huawei.nfc.carrera.logic.spi.snb.impl.operate;

import android.content.Context;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class CardSwitch extends BaseOperatorA {
    private static final String TAG = "GetPayOrder";
    private Map<String, String> errorMsgs = new HashMap();
    protected Context mContext;
    protected SNBProviderHelper mSnbProviderHelper;

    public CardSwitch(SNBProviderHelper sNBProviderHelper) {
        this.mSnbProviderHelper = sNBProviderHelper;
    }

    public int cardSwitch(String str) {
        String cardSwitch = this.mSnbProviderHelper.cardSwitch(str);
        C2538c.c(TAG, new Object[]{"SNBServiceImpl CardSwitch respStr = " + cardSwitch});
        return analyzeResult(cardSwitch);
    }

    protected void reportEmptyErrorMsg() {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "SNBServiceImpl CardSwitch failed. response is empty");
    }

    protected void reportFailErrorMsg(int i, String str) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "SNBServiceImpl CardSwitch failed. returnCd : " + i + " msg : " + str);
        this.errorMsgs.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
    }

    protected void reportJsonExpErrorMsg(JSONException jSONException) {
        this.errorMsgs.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "SNBServiceImpl CardSwitch failed. JSONException.");
        this.errorMsgs.put("fail_stack", jSONException.getMessage());
    }
}
