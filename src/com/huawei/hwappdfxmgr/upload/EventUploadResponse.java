package com.huawei.hwappdfxmgr.upload;

import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

public class EventUploadResponse {
    private static final String LOG_TAG = "EventUploadResponse";
    private static final String RESULT_CODE = "resultCode";
    private static final String RESULT_DESC = "resultDesc";
    public static final int SUCCESS = 10000;
    private int resultCode;
    private String resultDesc;

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultDesc(String str) {
        this.resultDesc = str;
    }

    public int parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1001;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                if (jSONObject.has("resultCode")) {
                    this.resultCode = jSONObject.getInt("resultCode");
                    C2538c.c(LOG_TAG, new Object[]{"resultCode " + this.resultCode});
                }
                if (!jSONObject.has(RESULT_DESC)) {
                    return 0;
                }
                this.resultDesc = jSONObject.getString(RESULT_DESC);
                C2538c.c(LOG_TAG, new Object[]{"RESULT_DESC " + this.resultDesc});
                return 0;
            } catch (JSONException e) {
                C2538c.c(LOG_TAG, new Object[]{"JSONException " + e.getMessage()});
                return 1008;
            }
        } catch (JSONException e2) {
            C2538c.c(LOG_TAG, new Object[]{"Exception " + e2.getMessage()});
            return 1008;
        }
    }
}
