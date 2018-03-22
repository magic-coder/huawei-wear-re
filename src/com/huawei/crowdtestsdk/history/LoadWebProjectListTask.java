package com.huawei.crowdtestsdk.history;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.huawei.crowdtestsdk.bases.ProjectItem;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.crowdtestsdk.net.HttpCommonAccess;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import de.greenrobot.event.C2687c;
import java.util.List;

public class LoadWebProjectListTask extends AsyncTask<Void, Void, Boolean> {
    Context context;
    private OnLoadWebProjectListListener onLoadWebProjectListListener;
    List<ProjectItem> projectItemList;

    public interface OnLoadWebProjectListListener {
        void loadComplete();
    }

    public LoadWebProjectListTask(Context context) {
        this.context = context;
    }

    public void setOnLoadWebProjectListListener(OnLoadWebProjectListListener onLoadWebProjectListListener) {
        this.onLoadWebProjectListListener = onLoadWebProjectListListener;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected Boolean doInBackground(Void... voidArr) {
        if (!HttpCommonAccess.getInstance().isNetworkConnected()) {
            return Boolean.valueOf(false);
        }
        C2511g.m12481b("BETACLUB_SDK", "-----LoadWebProjectListTask--doInBackground-------");
        this.projectItemList = HttpBetaAccess.getInstance().getAllProjectListFromWeb();
        if (this.projectItemList == null || this.projectItemList.isEmpty()) {
            C2511g.m12481b("BETACLUB_SDK", "-----LoadWebProjectListTask--projectItemList null-------");
            return Boolean.valueOf(false);
        }
        for (ProjectItem projectItem : this.projectItemList) {
            C2511g.m12481b("BETACLUB_SDK", "[LoadWebProjectListTask.doInBackground]projectItemList===>item:" + projectItem.toString());
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.crowdtest.UnHandleReceive");
        this.context.sendBroadcast(intent, SdkConstants.USE_CROWDTESTSDK_PERMISSION);
        C2511g.m12481b("BETACLUB_SDK", "发送了一条HandleCount的广播");
        return Boolean.valueOf(true);
    }

    protected void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            C2514j.m12509a(System.currentTimeMillis());
            if (this.onLoadWebProjectListListener != null) {
                this.onLoadWebProjectListListener.loadComplete();
            }
        }
        C2687c.m12831a().m12843c(new EndGetProjectEvent());
    }

    protected void onCancelled() {
        super.onCancelled();
    }
}
