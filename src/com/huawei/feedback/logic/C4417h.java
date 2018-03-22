package com.huawei.feedback.logic;

import android.text.TextUtils;
import com.huawei.phoneserviceuni.common.d.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FeedbackScoreResponse */
public class C4417h {
    private int f16401a;
    private String f16402b = "status";
    private String f16403c = "questionId";
    private String f16404d;

    public int m21262a(String str) {
        if (TextUtils.isEmpty(str)) {
            c.d("FeedbackScoreResponse", "Input param invalid.");
            return 1001;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                m21263a(Integer.parseInt(jSONObject.getString(this.f16402b)));
                try {
                    m21264b(jSONObject.getString(this.f16403c));
                    return 0;
                } catch (Exception e) {
                    c.d("FeedbackScoreResponse", "unknown_error...");
                    return -1;
                }
            } catch (Exception e2) {
                c.d("FeedbackScoreResponse", "number_format_exception...");
                return 1007;
            }
        } catch (JSONException e3) {
            c.d("FeedbackScoreResponse", "JSONException - new JSONObject error...");
            return 1008;
        }
    }

    public int m21261a() {
        return this.f16401a;
    }

    public void m21263a(int i) {
        this.f16401a = i;
    }

    public void m21264b(String str) {
        this.f16404d = str;
    }
}
