package com.huawei.crowdtestsdk.home;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.bases.bean_new.CloudLoginBean;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.crowdtestsdk.utils.DialogManager;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;

public class LoginManager {
    private static LoginManager Instance;
    private LoginTask loginTask;
    protected Handler mHandler = new C07821();
    protected ProgressDialog progressDialog;

    class C07821 extends Handler {
        C07821() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case SdkConstants.STAT_LOGIN_FAIL /*-100*/:
                    LoginManager.this.loginFailed(message.arg1);
                    break;
                case 1:
                    LoginManager.this.loginSuccessfully();
                    break;
                case 2:
                    LoginManager.this.loginTimeout();
                    break;
            }
            super.handleMessage(message);
        }
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void setLoginTask(LoginTask loginTask) {
        this.loginTask = loginTask;
    }

    public static LoginManager getInstance() {
        if (Instance == null) {
            Instance = new LoginManager();
        }
        return Instance;
    }

    public void login(Context context, CloudLoginBean cloudLoginBean) {
        C2511g.m12481b("BETACLUB_SDK", "[LoginManager.login] is called!");
        if (cloudLoginBean != null && NetworkUtils.checkNetworkStatus(context)) {
            if (isLoggedIn()) {
                HttpBetaAccess.getInstance().logout();
            }
            C2514j.m12525c(new Gson().toJson((Object) cloudLoginBean));
        }
    }

    public boolean isLoggedIn() {
        return (C2514j.m12523c().isEmpty() || C2514j.m12529e().isEmpty() || !C2514j.m12538l()) ? false : true;
    }

    private void loginSuccessfully() {
        C2511g.m12481b("BETACLUB_SDK", "[LoginManager.loginSuccessfully] is called!");
        DialogManager.dismissDialog(this.progressDialog);
        this.loginTask.gotoFeedback();
    }

    private void loginFailed(int i) {
        C2511g.m12481b("BETACLUB_SDK", "[LoginManager.loginFailed] is called!");
        parseLicenseCode(i);
        DialogManager.dismissDialog(this.progressDialog);
    }

    private void parseLicenseCode(int i) {
        switch (i) {
            case -20:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_network_error);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for network error");
                return;
            case -15:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_no_crowdtest_projects);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for no_crowdtest_projects(015)");
                return;
            case -14:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_all_crowdtest_project_expire);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for Your activity has expired(014)");
                return;
            case -13:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_no_projects2);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for no projects2");
                return;
            case -12:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_all_project_expired4);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for no project or projects expired4");
                return;
            case -11:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_no_projects1);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for no projects1");
                return;
            case -10:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_all_project_expired3);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for no project or projects expired3");
                return;
            case -9:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_all_project_expired2);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for no project or projects expired2");
                return;
            case -8:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_all_project_expired1);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for no project or projects expired1");
                return;
            case -6:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_time_error);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for timestamp error");
                return;
            case -2:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_username_no_match_imei);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for username no match");
                return;
            default:
                showToast(R.string.sdk_crowdtest_login_activity_text_login_fail_check_license_fail);
                C2511g.m12481b("BETACLUB_SDK", "[LoginManager.parseLicenseCode]Login fail for checking license fail");
                return;
        }
    }

    private void showToast(int i) {
        Context applicationContext = AppContext.getInstance().getApplicationContext();
        ToastUtil.showLongToast(applicationContext, applicationContext.getString(i));
    }

    private void loginTimeout() {
        if (this.loginTask != null && this.loginTask.getStatus() != Status.FINISHED) {
            ToastUtil.showLongToast(AppContext.getInstance().getApplicationContext(), R.string.sdk_crowdtest_login_activity_text_login_timeout);
            this.loginTask.cancel(true);
            removeAllHandlerMsg();
        }
    }

    private void removeAllHandlerMsg() {
        this.mHandler.removeCallbacksAndMessages(null);
        DialogManager.dismissDialog(this.progressDialog);
    }

    public void showProgress(Context context) {
        C2511g.m12481b("BETACLUB_SDK", "[LoginManager.showProgress] is call");
        this.progressDialog = new ProgressDialog(context);
        if (this.progressDialog == null) {
            C2511g.m12481b("BETACLUB_SDK", "[LoginManager.showProgress] progressDialog is null");
        }
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(context.getString(R.string.sdk_crowdtest_login_activity_text_logining_hint));
        this.progressDialog.setIndeterminate(false);
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setCancelable(false);
        DialogManager.showDialog(this.progressDialog);
        C2511g.m12481b("BETACLUB_SDK", "[LoginManager.showProgress] showToast");
    }
}
