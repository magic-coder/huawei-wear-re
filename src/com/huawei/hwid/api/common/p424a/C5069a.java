package com.huawei.hwid.api.common.p424a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.p430b.p431a.C5125a;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.openapi.out.OutReturn.ParamStr;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBConstants;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: ChangeSTToATReq */
public class C5069a {
    private String f18299a;

    public C5069a(String str) {
        this.f18299a = str;
    }

    public C5069a(Context context, String str, String str2, String str3, String str4, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        String packageName = context.getPackageName();
        bundle2.putString(WBConstants.AUTH_PARAMS_CLIENT_ID, str3);
        C5165e.m24906b("ChangeSTToATReq", "clientId= " + str3 + " packageName = " + packageName);
        bundle2.putString(WBConstants.AUTH_PARAMS_REDIRECT_URL, str2);
        bundle2.putString(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, SNBConstant.FIELD_TOKEN);
        bundle2.putString("scope", str);
        if (!(bundle == null || bundle.isEmpty())) {
            bundle2.putAll(bundle);
        }
        if (!TextUtils.isEmpty(str4)) {
            String b = C5182m.m25054b(context);
            bundle2.putString(SNBConstant.FIELD_DEVICE_ID, b);
            bundle2.putString("device_type", C5182m.m25049a(context, b));
            bundle2.putString("sso_st", str4);
            bundle2.putString("packageName", packageName);
        }
        this.f18299a = new StringBuffer().append(C5125a.m24675b()).append(LocationInfo.NA).append(C5070b.m24393a(bundle2)).toString();
        C5165e.m24904a("ChangeSTToATReq", "in ChangeSTToATReq, params ");
    }

    public String m24391a() {
        return this.f18299a;
    }

    public HttpUriRequest m24392b() {
        return m24389c();
    }

    public Bundle m24390a(HttpResponse httpResponse) {
        Bundle bundle = new Bundle();
        if (httpResponse != null) {
            bundle.putInt(ParamStr.RET_RES_CODE, httpResponse.getStatusLine().getStatusCode());
            bundle.putString(ParamStr.RET_RES_CONTENT, m24388b(httpResponse));
            Header[] allHeaders = httpResponse.getAllHeaders();
            Bundle bundle2 = new Bundle();
            for (Header header : allHeaders) {
                if (header != null) {
                    bundle2.putString(header.getName(), header.getValue());
                }
            }
            bundle.putBundle(ParamStr.RET_RES_HEAD, bundle2);
        }
        return bundle;
    }

    private String m24388b(HttpResponse httpResponse) {
        try {
            return EntityUtils.toString(httpResponse.getEntity(), GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            C5165e.m24911d("ChangeSTToATReq", e.getMessage(), e);
            return null;
        }
    }

    private final HttpUriRequest m24387a(HttpUriRequest httpUriRequest) {
        httpUriRequest.addHeader("Connection", "Keep-Alive");
        httpUriRequest.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpUriRequest.getParams().setIntParameter("http.socket.timeout", 15000);
        httpUriRequest.getParams().setIntParameter("http.connection.timeout", 15000);
        HttpClientParams.setRedirecting(httpUriRequest.getParams(), false);
        return httpUriRequest;
    }

    private HttpGet m24389c() {
        HttpUriRequest httpGet = new HttpGet(m24391a());
        m24387a(httpGet);
        return httpGet;
    }
}
