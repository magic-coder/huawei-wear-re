package com.huawei.crowdtestsdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huawei.crowdtestsdk.bases.bean_new.CloudLoginBean;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.constants.UrlConstants;
import com.huawei.crowdtestsdk.home.AuthManager;
import com.huawei.crowdtestsdk.httpaccess.HttpClient;
import com.huawei.crowdtestsdk.httpaccess.HttpResult;
import com.huawei.crowdtestsdk.utils.OtherUtils;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;

public class HttpCommonAccess {
    protected static HttpCommonAccess mInstance;
    private Context mContext;

    public static HttpCommonAccess getInstance() {
        if (mInstance == null) {
            mInstance = new HttpCommonAccess(AppContext.getInstance().getApplicationContext());
        }
        return mInstance;
    }

    HttpCommonAccess(Context context) {
        this.mContext = context;
    }

    public boolean loginWithHwAccount(CloudLoginBean cloudLoginBean) {
        try {
            String str = UrlConstants.loginHwAccountUrl;
            C2511g.m12477a(SdkConstants.TAG_HTTP, "[HttpCommonAccess.loginWithHwAccount]url:" + str);
            HttpResult postDataWithRetryOnly = HttpClient.getInstance().postDataWithRetryOnly(str, new Gson().toJson((Object) cloudLoginBean), null);
            C2511g.m12477a(SdkConstants.TAG_HTTP, "[HttpCommonAccess.loginWithHwAccount]cloudLoginBean:" + new Gson().toJson((Object) cloudLoginBean));
            if (postDataWithRetryOnly == null || !postDataWithRetryOnly.isResponseOK()) {
                return false;
            }
            C2511g.m12481b(SdkConstants.TAG_HTTP, "[HttpCommonAccess.loginWithHwAccount]ret:" + postDataWithRetryOnly.toString());
            return true;
        } catch (Throwable e) {
            C2511g.m12482b(SdkConstants.TAG_HTTP, "[HttpCommonAccess.loginWithHwAccount]Error ", e);
            return false;
        }
    }

    public boolean loadEnvironment() {
        try {
            C2511g.m12477a(SdkConstants.TAG_HTTP, "[HttpCommonAccess.loadEnvironment]");
            HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.environmentUrl);
            if (!OtherUtils.isHttpResultCorrect(dataWithRetry)) {
                return false;
            }
            C2511g.m12477a(SdkConstants.TAG_HTTP, "[HttpCommonAccess.loadEnvironment]ret.content:" + dataWithRetry.content);
            Object obj = dataWithRetry.content;
            if (TextUtils.isEmpty(obj)) {
                return false;
            }
            String replaceFirst = obj.replaceFirst("workspaceVO=", "");
            C2511g.m12481b("BETACLUB_SDK", "[HttpCommonAccess.loadEnvironment]content after replace : " + replaceFirst);
            JsonObject asJsonObject = new JsonParser().parse(replaceFirst).getAsJsonObject().getAsJsonObject("user");
            String asString = asJsonObject.get("userId").getAsString();
            String asString2 = asJsonObject.get("userAccount").getAsString();
            replaceFirst = asJsonObject.get("userType").getAsString();
            C2514j.m12514a(asString);
            C2514j.m12522b(asString2);
            C2514j.m12527d(replaceFirst);
            return true;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HttpCommonAccess.loadEnvironment]Error:", e);
            return false;
        }
    }

    public int checkLicense() {
        C2511g.m12481b("BETACLUB_SDK", "[HttpCommonAccess.checkLicense]is called!");
        if (this.mContext == null) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpCommonAccess.checkLicense]context == null");
            return 0;
        }
        int checkLicense = AuthManager.checkLicense(this.mContext);
        C2511g.m12481b("BETACLUB_SDK", "[HttpCommonAccess.checkLicense]licenseCode:" + checkLicense);
        return checkLicense;
    }

    int getIntegerValueByString(String str) {
        int i = -1;
        if (!(str == null || str.isEmpty() || str.equalsIgnoreCase("null"))) {
            C2511g.m12481b("BETACLUB_SDK", "prodString is " + str);
            try {
                i = Integer.parseInt(str);
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "NumberFormatException!", e);
            }
        }
        return i;
    }

    public boolean isNetworkConnected() {
        C2511g.m12481b("BETACLUB_SDK", "[HttpCommonAccess.isNetworkConnected]Check network connection!");
        if (this.mContext == null) {
            C2511g.m12481b("BETACLUB_SDK", "[HttpCommonAccess.isNetworkConnected]context == null");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo state : allNetworkInfo) {
                    if (state.getState() == State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        C2511g.m12481b("BETACLUB_SDK", "[HttpCommonAccess.isNetworkConnected]Network invalid!");
        return false;
    }
}
