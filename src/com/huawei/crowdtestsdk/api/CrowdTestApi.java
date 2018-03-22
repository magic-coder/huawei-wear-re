package com.huawei.crowdtestsdk.api;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.util.Log;
import com.google.gson.Gson;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.bases.bean_new.CloudLoginBean;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.devices.DeviceHelper;
import com.huawei.crowdtestsdk.feedback.FeedbackDescriptionActivity.FeedbackCallback;
import com.huawei.crowdtestsdk.home.LoginManager;
import com.huawei.crowdtestsdk.home.LoginTask;
import com.huawei.crowdtestsdk.home.SendLogTask;
import com.huawei.crowdtestsdk.home.SendLogTask.Callback;
import com.huawei.crowdtestsdk.utils.ActivityManagerUtils;
import com.huawei.crowdtestsdk.utils.AppManagerUtils;
import com.huawei.crowdtestsdk.utils.CustomCrashHandler;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import java.io.File;

public class CrowdTestApi implements IApi {
    private static CrowdTestApi instance = null;
    private FeedbackCallback mFeedbackCallback;
    private Handler mHandler;

    public static CrowdTestApi getInstance() {
        if (instance == null) {
            instance = new CrowdTestApi();
        }
        return instance;
    }

    public void init(Context context, int i) {
        AppContext.getInstance().setApplicationContext(context);
        initEnvironment(context);
        C2514j.m12508a(i);
        initExceptionGetter(context);
        initLog(context);
    }

    private void initExceptionGetter(Context context) {
        Log.d("BETACLUB_SDK", "[CrowdTestApi.initExceptionGetter]start...");
        CustomCrashHandler.getInstance().setCustomCrashHanler(context);
    }

    private void initEnvironment(Context context) {
        Log.d("BETACLUB_SDK", "[CrowdTestApi.initEnvironment] is called!");
        if (!new File(SdkConstants.getTargetLogPathString(context)).exists()) {
            Log.d("BETACLUB_SDK", "[CrowdTestApi.initEnvironment] /BetaClub/Log/ not exist!");
            FileUtils.createDir(SdkConstants.getTargetLogPathString(context));
        }
        if (!new File(SdkConstants.getTempTargetLogPath(context)).exists()) {
            FileUtils.createDir(SdkConstants.getTempTargetLogPath(context));
        }
        if (!new File(SdkConstants.getTargetUploadPathString(context)).exists()) {
            FileUtils.createDir(SdkConstants.getTargetUploadPathString(context));
        }
    }

    public FeedbackCallback getFeedbackCallback() {
        return this.mFeedbackCallback;
    }

    public void setFeedbackCallback(FeedbackCallback feedbackCallback) {
        this.mFeedbackCallback = feedbackCallback;
    }

    public void gotoFeedback(Context context, CloudLoginBean cloudLoginBean, FeedbackParams feedbackParams, FeedbackCallback feedbackCallback) {
        C2511g.m12481b("BETACLUB_SDK", "[CrowdTestApi.gotoFeedback]is called");
        C2514j.m12525c(new Gson().toJson((Object) cloudLoginBean));
        LoginManager.getInstance().showProgress(context);
        this.mHandler = LoginManager.getInstance().getHandler();
        LoginTask loginTask = new LoginTask(context, cloudLoginBean, feedbackParams, feedbackCallback, this.mHandler);
        LoginManager.getInstance().setLoginTask(loginTask);
        loginTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        sendDelayedTimeoutMsg();
    }

    private void sendDelayedTimeoutMsg() {
        this.mHandler.sendEmptyMessageDelayed(2, 120000);
    }

    private void initLog(Context context) {
        Log.d("BETACLUB_SDK", "[MainApplication.initLog]start...");
        C2511g.m12478a(SdkConstants.getMyOwnLogPathDirectory(context), "crowdtestsdk_debug.log", "BETACLUB_SDK");
        C2511g.m12477a("BETACLUB_SDK", "MainApplication initLog finish");
    }

    public void unInit(Context context) {
        AppManagerUtils.getsInstance(context).logout();
        ActivityManagerUtils.getInstance().finishAllActivity();
    }

    public void sendLog(Context context, FeedbackParams feedbackParams, String str, boolean z, Callback callback) {
        if (context != null && feedbackParams != null && !StringUtils.isNullOrEmpty(str) && callback != null) {
            C2511g.m12481b("BETACLUB_SDK", "[CrowdTestApi.sendLog]logPath-> " + str);
            int d = C2514j.m12526d();
            C2511g.m12481b("BETACLUB_SDK", "[CrowdTestApi.sendLog]productType:" + d);
            if (d == -1) {
                C2511g.m12481b("BETACLUB_SDK", "[CrowdTestApi.sendLog]crowdtestsdk is not init");
                callback.onFailed("sdk is not init");
                return;
            }
            SendLogTask sendLogTask = new SendLogTask(context, feedbackParams, new CommonDevice(new DeviceHelper(d)), Boolean.valueOf(z), callback);
            if (Status.RUNNING.equals(sendLogTask.getStatus())) {
                callback.onFailed("sendLogTask status is running");
                return;
            }
            if (Status.PENDING.equals(sendLogTask.getStatus())) {
                C2511g.m12481b("BETACLUB_SDK", "[CrowdTestApi.sendLog]sendLogTask.getStatus()==Status.PENDING");
                sendLogTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
            }
            C2511g.m12481b("BETACLUB_SDK", "[CrowdTestApi.sendLog]End");
        }
    }
}
