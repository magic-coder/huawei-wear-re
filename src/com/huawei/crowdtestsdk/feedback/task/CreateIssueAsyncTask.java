package com.huawei.crowdtestsdk.feedback.task;

import android.os.AsyncTask;
import com.huawei.crowdtestsdk.bases.TbdtsCreationUnit;
import com.huawei.crowdtestsdk.bases.TbdtsStatus;
import com.huawei.crowdtestsdk.feedback.task.CreateIssueTask.OnCreationCallback;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.uploadlog.p188c.C2511g;

public class CreateIssueAsyncTask extends AsyncTask<Void, Void, TbdtsStatus> {
    private TbdtsCreationUnit creationUnit;
    private OnCreationCallback onCreationCallback;

    public CreateIssueAsyncTask(TbdtsCreationUnit tbdtsCreationUnit, OnCreationCallback onCreationCallback) {
        this.creationUnit = tbdtsCreationUnit;
        this.onCreationCallback = onCreationCallback;
    }

    protected TbdtsStatus doInBackground(Void... voidArr) {
        String toJsonString = this.creationUnit.toJsonString();
        C2511g.m12481b("BETACLUB_SDK", "[CreateIssueAsyncTask.doInBackground]content:" + toJsonString);
        TbdtsStatus submitTbdtsIssue = HttpBetaAccess.getInstance().submitTbdtsIssue(toJsonString);
        if (submitTbdtsIssue != null) {
            C2511g.m12481b("BETACLUB_SDK", "[CreateIssueAsyncTask.doInBackground]result:" + submitTbdtsIssue.toString());
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[CreateIssueAsyncTask.doInBackground]result is null");
        }
        return submitTbdtsIssue;
    }

    protected void onPostExecute(TbdtsStatus tbdtsStatus) {
        if (this.onCreationCallback != null) {
            this.onCreationCallback.callback(tbdtsStatus);
        }
    }
}
