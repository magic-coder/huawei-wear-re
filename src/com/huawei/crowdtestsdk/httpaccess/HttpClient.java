package com.huawei.crowdtestsdk.httpaccess;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.crowdtestsdk.bases.bean_new.CloudLoginBean;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.net.HttpCommonAccess;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import java.util.Map;

public class HttpClient {
    private static HttpClient instance = null;
    private Context context;

    private HttpClient(Context context) {
        this.context = context;
    }

    public static HttpClient getInstance() {
        if (instance == null) {
            instance = new HttpClient(AppContext.getInstance().getApplicationContext());
        }
        return instance;
    }

    public Context getContext() {
        return this.context;
    }

    public HttpResult getDataWithRetry(String str) {
        return getDataWithRetryWithHwAccount(str);
    }

    public HttpResult postDataWithRetry(String str, String str2, Map<String, String> map) {
        return postDataWithRetryWithHwAccount(str, str2, map);
    }

    public HttpResult postDataWithRetryOnly(String str, String str2, Map<String, String> map) {
        HttpResult httpResult = null;
        for (int i = 0; i < 2; i++) {
            httpResult = HttpUtils.getInstance().postData(str, "", str2, map);
            if (httpResult != null && httpResult.isResponseOK()) {
                break;
            }
        }
        return httpResult;
    }

    public HttpResult getDataWithRetryWithHwAccount(String str) {
        HttpResult httpResult = null;
        for (int i = 0; i < 2; i++) {
            httpResult = HttpUtils.getInstance().getData(str);
            if (httpResult != null && httpResult.isResponseOK()) {
                break;
            }
            loginHwAccount();
        }
        return httpResult;
    }

    public HttpResult postDataWithRetryWithHwAccount(String str, String str2, Map<String, String> map) {
        HttpResult httpResult = null;
        for (int i = 0; i < 2; i++) {
            httpResult = HttpUtils.getInstance().postData(str, "", str2, map);
            if (httpResult != null && httpResult.isResponseOK()) {
                break;
            }
            loginHwAccount();
        }
        return httpResult;
    }

    public void loginHwAccount() {
        CloudLoginBean cloudLoginBean;
        String e = C2514j.m12529e();
        C2511g.m12481b("BETACLUB_SDK", "[HttpClient.loginHwAccount]cloudInfo:" + e);
        try {
            cloudLoginBean = (CloudLoginBean) new Gson().fromJson(e, CloudLoginBean.class);
        } catch (Throwable e2) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpClient.loginHwAccount] error!", e2);
            cloudLoginBean = null;
        }
        if (cloudLoginBean != null) {
            HttpCommonAccess.getInstance().loginWithHwAccount(cloudLoginBean);
        }
    }

    public void logout() {
        HttpUtils.getInstance().clearCookies();
    }
}
