package com.huawei.feedback.logic;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.feedback.a.b.a;
import com.huawei.feedback.bean.C4410d;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyCommitParam;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: GetFeedbackBatchAnswerTask */
public class C4423n implements Runnable {
    private Handler f16425a = null;
    private C4410d f16426b = null;

    public C4423n(Context context, Handler handler) {
        c.c("GetFeedbackBatchAnswerTask", "GetFeedbackBatchAnswerTask was contructed ");
        this.f16425a = handler;
    }

    public void run() {
        Object a = m21268a();
        c.c("GetFeedbackBatchAnswerTask", "get feedback ,URL is = " + a);
        if (TextUtils.isEmpty(a)) {
            Message obtain = Message.obtain();
            obtain.what = IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION;
            this.f16425a.sendMessage(obtain);
            return;
        }
        String a2 = m21269a(a);
        c.c("GetFeedbackBatchAnswerTask", "get feedback response ,response is " + a2);
        List b = m21270b(a2);
        if (b.size() > 0) {
            Message obtain2 = Message.obtain();
            obtain2.what = IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NOAID;
            obtain2.obj = b;
            this.f16425a.sendMessage(obtain2);
            return;
        }
        obtain = Message.obtain();
        obtain.what = IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION;
        this.f16425a.sendMessage(obtain);
    }

    private String m21269a(String str) {
        HttpsURLConnection c = com.huawei.feedback.c.c(str);
        if (c == null) {
            return "";
        }
        return com.huawei.feedback.c.a(c);
    }

    private List<C4410d> m21270b(String str) {
        List<C4410d> arrayList = new ArrayList();
        if (str != null) {
            try {
                JSONArray jSONArray = ((JSONObject) new JSONTokener(str).nextValue()).getJSONArray(QstnSurveyCommitParam.answers);
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string = jSONObject.getString("questionId");
                        String str2 = "";
                        String str3 = "";
                        if (jSONObject.has("answer") && jSONObject.optString("answer") != null) {
                            str2 = jSONObject.getString("answer");
                        }
                        if (jSONObject.has("picUrl") && jSONObject.optString("picUrl") != null) {
                            str3 = jSONObject.getString("picUrl");
                        }
                        if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(str2))) {
                            this.f16426b = new C4410d();
                            this.f16426b.m21211h(string);
                            this.f16426b.m21217k(str2);
                            this.f16426b.m21219l(str3);
                            arrayList.add(this.f16426b);
                        }
                        c.b("GetFeedbackBatchAnswerTask", "questionId = " + string + " answer = " + str2 + " picUrl = " + str3);
                    }
                }
            } catch (JSONException e) {
                c.d("GetFeedbackBatchAnswerTask", "parse feedback response error,error is json exc ");
            } catch (Exception e2) {
                c.d("GetFeedbackBatchAnswerTask", "parse feedback response error,error is unkown error");
            }
        }
        return arrayList;
    }

    private String m21268a() {
        List c = f.c();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("https://iservice.vmall.com:443/osg/feedbackBatchAction!getRespMsg.htm?");
            if (c.size() <= 0) {
                return "";
            }
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i) != null) {
                    stringBuffer.append("questionIds=").append(URLEncoder.encode((String) c.get(i), GameManager.DEFAULT_CHARSET)).append(SNBConstant.FILTER);
                }
            }
            if (TextUtils.isEmpty(a.a().f())) {
                a.a().e();
            }
            String f = a.a().f();
            if (TextUtils.isEmpty(f)) {
                f = "000000000000000";
            }
            stringBuffer.append("deviceID=" + f);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            c.b("GetFeedbackBatchAnswerTask", "UnsupportedEncodingException dealUrl");
            return "";
        }
    }
}
