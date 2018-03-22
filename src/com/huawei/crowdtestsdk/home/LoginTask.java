package com.huawei.crowdtestsdk.home;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.huawei.crowdtestsdk.api.CrowdTestApi;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.bases.bean_new.CloudLoginBean;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.feedback.FeedbackDescriptionActivity.FeedbackCallback;
import com.huawei.crowdtestsdk.launch.TermsAndConditionsActivity;
import com.huawei.crowdtestsdk.net.HttpCommonAccess;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import net.sqlcipher.database.SQLiteDatabase;

public class LoginTask extends AsyncTask<Void, String, Boolean> {
    private FeedbackCallback callback;
    private CloudLoginBean cloudLoginBean;
    private Context context;
    private Handler handler;
    private boolean isNetworkConnected = false;
    private boolean isValidLoginBean = false;
    private boolean isValidParam = false;
    private int licenseCode;
    private FeedbackParams params;

    public LoginTask(Context context, CloudLoginBean cloudLoginBean, FeedbackParams feedbackParams, FeedbackCallback feedbackCallback, Handler handler) {
        this.context = context;
        this.cloudLoginBean = cloudLoginBean;
        this.params = feedbackParams;
        this.callback = feedbackCallback;
        this.handler = handler;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        CrowdTestApi.getInstance().setFeedbackCallback(this.callback);
        if (this.context != null && this.params != null) {
            this.isValidParam = true;
        } else if (this.callback != null) {
            this.callback.onFailed("invalid params");
        }
        if (this.cloudLoginBean != null) {
            this.isValidLoginBean = true;
        } else if (this.callback != null) {
            this.callback.onFailed("user info is empty");
        }
        if (HttpCommonAccess.getInstance().isNetworkConnected()) {
            this.isNetworkConnected = true;
            return;
        }
        this.isNetworkConnected = false;
        this.callback.onFailed("network connected failed");
    }

    protected Boolean doInBackground(Void... voidArr) {
        C2511g.m12481b("BETACLUB_SDK", "[LoginTask.doInBackground]Start");
        boolean z = false;
        if (this.isValidParam && this.isValidLoginBean && this.isNetworkConnected) {
            if (LoginManager.getInstance().isLoggedIn()) {
                return Boolean.valueOf(true);
            }
            z = loadRemoteConfigData();
        }
        return Boolean.valueOf(z);
    }

    protected void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            C2514j.m12518a(true);
            this.handler.sendEmptyMessage(1);
            return;
        }
        Message obtain = Message.obtain();
        obtain.arg1 = this.licenseCode;
        obtain.what = -100;
        this.handler.sendMessage(obtain);
    }

    private boolean loadRemoteConfigData() {
        boolean z;
        boolean loginWithHwAccount = HttpCommonAccess.getInstance().loginWithHwAccount(this.cloudLoginBean);
        C2511g.m12481b(SdkConstants.TAG_HTTP, "[CrowdTestApi.login]ret1 : " + loginWithHwAccount);
        boolean loadEnvironment = HttpCommonAccess.getInstance().loadEnvironment();
        C2511g.m12481b(SdkConstants.TAG_HTTP, "[CrowdTestApi.login]ret2 : " + loadEnvironment);
        this.licenseCode = HttpCommonAccess.getInstance().checkLicense();
        if (this.licenseCode == 1) {
            z = true;
        } else {
            z = false;
        }
        C2511g.m12481b(SdkConstants.TAG_HTTP, "[CrowdTestApi.login]ret3 : " + z);
        if (loginWithHwAccount && loadEnvironment && z) {
            return true;
        }
        return false;
    }

    private String getAppVersionName(Context context) {
        Throwable e;
        String str = "";
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str2 != null) {
                try {
                    if (str2.length() > 0) {
                        return str2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.e("VersionInfo", "Exception", e);
                    return str2;
                }
            }
            return "";
        } catch (Throwable e3) {
            Throwable th = e3;
            str2 = str;
            e = th;
            Log.e("VersionInfo", "Exception", e);
            return str2;
        }
    }

    public void gotoFeedback() {
        C2511g.m12481b("BETACLUB_SDK", "[CrowdTestApi.gotoFeedback]is called");
        Intent intent = new Intent(this.context, TermsAndConditionsActivity.class);
        Bundle bundle = new Bundle();
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        bundle.putParcelable(SdkConstants.FEEDBACK_PARAMS, this.params);
        bundle.putString(SdkConstants.APP_VERSION_NAME, getAppVersionName(this.context));
        intent.putExtras(bundle);
        this.context.startActivity(intent);
    }
}
