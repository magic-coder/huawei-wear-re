package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.os.AsyncTask;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1481a;
import com.huawei.pluginkidwatch.common.lib.utils.C1494n;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: ProfileSettingActivity */
class bk extends AsyncTask<String, Void, String> {
    final /* synthetic */ ProfileSettingActivity f6632a;

    bk(ProfileSettingActivity profileSettingActivity) {
        this.f6632a = profileSettingActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m10105a((String[]) objArr);
    }

    protected String m10105a(String... strArr) {
        String str = "";
        try {
            String a = C1906x.m9697a(this.f6632a.getApplicationContext());
            JSONObject jSONObject = (JSONObject) new JSONTokener(a).nextValue();
            str = jSONObject.getString(JoinConstants.ACTION);
            String string = jSONObject.getString("callback");
            String string2 = jSONObject.getString("secret");
            String string3 = jSONObject.getString("nspTs");
            String string4 = jSONObject.getString(LightCloudConstants.DOWNLOAD_URL);
            this.f6632a.f6382N = jSONObject.getString(SMSKeyInfo.TAG_KEY);
            this.f6632a.f6402i = this.f6632a.f6382N + string4;
            if ("".equals(this.f6632a.f6402i)) {
                this.f6632a.f6379K.sendEmptyMessage(2);
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==   bigHeadIcon is null");
                return "";
            }
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "============保存图片到本地 downLoadUrl：" + this.f6632a.f6402i);
            if (this.f6632a.f6404k.isRecycled()) {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==  mHeadImgBmp isRecycled");
                this.f6632a.f6379K.sendEmptyMessage(2);
                return "";
            }
            ac.m7223a(this.f6632a.f6398e, this.f6632a.f6402i, this.f6632a.f6404k);
            HttpUriRequest httpPut = new HttpPut(str);
            HttpClient defaultHttpClient = new DefaultHttpClient();
            defaultHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            String a2 = C1481a.m6811a(this.f6632a.f6400g, this.f6632a.f6382N.substring(0, 16).getBytes(GameManager.DEFAULT_CHARSET), this.f6632a.f6382N.substring(16, this.f6632a.f6382N.length()).getBytes(GameManager.DEFAULT_CHARSET));
            Object byteArrayEntity = new ByteArrayEntity(a2.getBytes(GameManager.DEFAULT_CHARSET));
            C1906x.m9698a(str, string, string2, string3, C1494n.m6927a(a2), httpPut);
            httpPut.setEntity(byteArrayEntity);
            byteArrayEntity.setContentType("binary/octet-stream");
            HttpResponse execute = defaultHttpClient.execute(httpPut);
            defaultHttpClient.getConnectionManager().shutdown();
            C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==  code==" + execute.getStatusLine().getStatusCode(), ", message = ", r1.getReasonPhrase());
            if (execute.getStatusLine().getStatusCode() == 200) {
                str = C1906x.m9697a(this.f6632a.getApplicationContext());
                if (str == null || "".equals(str)) {
                    C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==  小头像getuplaodinfo返回值为null");
                    this.f6632a.f6379K.sendEmptyMessage(2);
                    this.f6632a.m9927q();
                    return "";
                }
                int a3 = C1906x.m9693a(str, this.f6632a.f6382N, 2, C1906x.m9702a(this.f6632a.f6400g, 128, 128), this.f6632a);
                this.f6632a.f6401h = C1906x.m9696a();
                if (this.f6632a.f6401h == null || "".equals(this.f6632a.f6401h)) {
                    this.f6632a.f6379K.sendEmptyMessage(2);
                    C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==   smallHeadIcon  is null");
                    return "";
                } else if (a3 == 200) {
                    this.f6632a.f6379K.sendEmptyMessage(1);
                } else {
                    C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==   error smallCode==" + a3);
                    this.f6632a.f6379K.sendEmptyMessage(2);
                }
            } else {
                C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "==ww==   error code==" + r2);
                this.f6632a.f6379K.sendEmptyMessage(2);
            }
            if (!this.f6632a.f6404k.isRecycled()) {
                this.f6632a.f6404k.recycle();
            }
            return a;
        } catch (Exception e) {
            this.f6632a.f6379K.sendEmptyMessage(2);
            C2538c.m12680e("KIDWATCH_ProfileSettingActivity", "==ww==   JSONException =" + e.getMessage());
            return "";
        }
    }
}
