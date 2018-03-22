package com.huawei.crowdtestsdk.feedback.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.bases.TbdtsCreationUnit;
import com.huawei.crowdtestsdk.bases.TbdtsStatus;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.crowdtestsdk.utils.DialogManager;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.nfc.carrera.logic.spi.citic.response.SmsCodeResponse;
import com.huawei.uploadlog.p188c.C2511g;

public class CreateIssueTask {
    private Context context;
    private CreateIssueAsyncTask createIssueAsyncTask;
    private ProgressDialog progressDialog;

    public interface OnCreationCallback {
        void callback(TbdtsStatus tbdtsStatus);
    }

    class CreateIssueAsyncTask extends AsyncTask<Void, Void, TbdtsStatus> {
        private TbdtsCreationUnit creationUnit;
        private OnCreationCallback onCreationCallback;

        public CreateIssueAsyncTask(TbdtsCreationUnit tbdtsCreationUnit, OnCreationCallback onCreationCallback) {
            this.creationUnit = tbdtsCreationUnit;
            this.onCreationCallback = onCreationCallback;
        }

        protected TbdtsStatus doInBackground(Void... voidArr) {
            String toJsonString = this.creationUnit.toJsonString();
            C2511g.m12481b("BETACLUB_SDK", "[CreateIssueTask.onCreation]content:" + toJsonString);
            return HttpBetaAccess.getInstance().submitTbdtsIssue(toJsonString);
        }

        protected void onPostExecute(TbdtsStatus tbdtsStatus) {
            DialogManager.dismissDialog(CreateIssueTask.this.progressDialog);
            if (this.onCreationCallback != null) {
                this.onCreationCallback.callback(tbdtsStatus);
            }
        }
    }

    public CreateIssueTask(Context context) {
        this.context = context;
    }

    public void onCreation(TbdtsCreationUnit tbdtsCreationUnit, OnCreationCallback onCreationCallback) {
        if (tbdtsCreationUnit != null && onCreationCallback != null) {
            showProgress();
            this.createIssueAsyncTask = new CreateIssueAsyncTask(tbdtsCreationUnit, onCreationCallback);
            this.createIssueAsyncTask.execute(new Void[0]);
        }
    }

    private void showProgress() {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(this.context);
            this.progressDialog.setProgressStyle(0);
            this.progressDialog.setMessage(this.context.getString(ResUtil.getResId(this.context, "sdk_crowdtest_description_fragment_create_tbdts_wait", ResUtil.TYPE_STRING)));
            this.progressDialog.setIndeterminate(false);
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.setCancelable(false);
        }
        DialogManager.showDialog(this.progressDialog);
    }

    public void onDestroy() {
        DialogManager.dismissDialog(this.progressDialog);
        this.context = null;
        if (this.createIssueAsyncTask != null && this.createIssueAsyncTask.getStatus() == Status.RUNNING) {
            this.createIssueAsyncTask.cancel(true);
        }
        this.createIssueAsyncTask = null;
    }

    public static boolean parseTbdtsStatus(TbdtsStatus tbdtsStatus) {
        if (tbdtsStatus.getStatus() == 1) {
            return true;
        }
        return false;
    }

    public static void parseTbdtsStatusRetCode(Context context, int i) {
        if (context != null) {
            switch (i) {
                case SmsCodeResponse.RESULT_CODE_GETSMS_EXCEED_LIMIT /*-21*/:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_CREATE_QUES_SYSEXCEPTION", ResUtil.TYPE_STRING));
                    return;
                case -20:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_CREATE_QUES_APPEXCEPTION", ResUtil.TYPE_STRING));
                    return;
                case -12:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_GET_LOGIN_USERID_FAIL", ResUtil.TYPE_STRING));
                    return;
                case -11:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_AUTO_LOGIN_FAIL", ResUtil.TYPE_STRING));
                    return;
                case -10:
                    ToastUtil.showLongToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_ACCOUNT_VALIDATE_FAIL", ResUtil.TYPE_STRING));
                    return;
                case -6:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_INPUTPARAMS_ERROR", ResUtil.TYPE_STRING));
                    return;
                case -5:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_CREATEPROCESS_FAIL", ResUtil.TYPE_STRING));
                    return;
                case -4:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_GETBUGINFO_FAIL", ResUtil.TYPE_STRING));
                    return;
                case -3:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_MATCHPRODBNUM_FAIL", ResUtil.TYPE_STRING));
                    return;
                case -2:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_MATCHCREATENAME_FAIL", ResUtil.TYPE_STRING));
                    return;
                case -1:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_MATCHACTIVTITY_FAIL", ResUtil.TYPE_STRING));
                    return;
                default:
                    ToastUtil.showShortToast(context, ResUtil.getResId(context, "sdk_crowdtest_description_fragment_create_tbdts_fail", ResUtil.TYPE_STRING));
                    return;
            }
        }
    }

    public static String getErrorMsgByRetCode(Context context, int i) {
        if (context == null) {
            return "";
        }
        switch (i) {
            case SmsCodeResponse.RESULT_CODE_GETSMS_EXCEED_LIMIT /*-21*/:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_CREATE_QUES_SYSEXCEPTION", ResUtil.TYPE_STRING));
            case -20:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_CREATE_QUES_APPEXCEPTION", ResUtil.TYPE_STRING));
            case -12:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_GET_LOGIN_USERID_FAIL", ResUtil.TYPE_STRING));
            case -11:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_AUTO_LOGIN_FAIL", ResUtil.TYPE_STRING));
            case -10:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_ACCOUNT_VALIDATE_FAIL", ResUtil.TYPE_STRING));
            case -6:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_INPUTPARAMS_ERROR", ResUtil.TYPE_STRING));
            case -5:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_CREATEPROCESS_FAIL", ResUtil.TYPE_STRING));
            case -4:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_GETBUGINFO_FAIL", ResUtil.TYPE_STRING));
            case -3:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_MATCHPRODBNUM_FAIL", ResUtil.TYPE_STRING));
            case -2:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_MATCHCREATENAME_FAIL", ResUtil.TYPE_STRING));
            case -1:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_create_issue_error_code_INT_MATCHACTIVTITY_FAIL", ResUtil.TYPE_STRING));
            default:
                return context.getResources().getString(ResUtil.getResId(context, "sdk_crowdtest_description_fragment_create_tbdts_fail", ResUtil.TYPE_STRING));
        }
    }
}
