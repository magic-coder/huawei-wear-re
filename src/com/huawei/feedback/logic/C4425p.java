package com.huawei.feedback.logic;

import android.text.TextUtils;
import com.huawei.phoneserviceuni.common.d.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SubmitFeedbackResponse */
public class C4425p {
    private int f16428a;
    private String f16429b;

    public int m21272a(String str) {
        c.b("SubmitFeedbackResponse", "rsp = " + str);
        if (TextUtils.isEmpty(str)) {
            c.d("SubmitFeedbackResponse", "Input param invalid.");
            return 1001;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.f16428a = Integer.parseInt(jSONObject.getString("status"));
                if (this.f16428a != 0) {
                    return this.f16428a;
                }
                try {
                    this.f16429b = jSONObject.getString("id");
                } catch (Exception e) {
                    c.d("SubmitFeedbackResponse", "jsonObject.getString error");
                    this.f16429b = "";
                }
                return 0;
            } catch (Exception e2) {
                c.d("SubmitFeedbackResponse", "NUMBER_FORMAT_EXCEPTION ...");
                return 1007;
            }
        } catch (JSONException e3) {
            c.d("SubmitFeedbackResponse", "JSONException ...");
            return 1008;
        }
    }

    public int m21271a() {
        return this.f16428a;
    }

    public String m21273b() {
        return this.f16429b;
    }
}
