package com.huawei.crowdtestsdk.feedback.widgets;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.crowdtestsdk.bases.ProjectItem;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.Mode;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullToRefreshLayout;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullToRefreshLayout.OnRefreshListener;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullableListView;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.crowdtestsdk.utils.DialogManager;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import com.huawei.uploadlog.p188c.C2515k;
import java.util.LinkedList;
import java.util.List;

public class ActivityDialog {
    private AlertDialog activityDialog;
    private List<ProjectItem> activityList = new LinkedList();
    private Context context;
    private List<String> items = new LinkedList();
    private ArrayAdapter<String> mAdapter;
    private FrameLayout mContentView;
    private PullToRefreshLayout mDialogProjectListLayout;
    private PullableListView mDialogProjectListView;
    private LinearLayout mEmptyView;
    private OnDismissListener onDismissListener;
    private OnGetActivityListener onGetActivityListener;

    public interface OnGetActivityListener {
        void onGetActivity(String str, String str2, CommonDevice commonDevice);
    }

    class C07131 extends Handler {
        C07131() {
        }

        public void handleMessage(Message message) {
            ActivityDialog.this.mDialogProjectListLayout.autoRefresh();
        }
    }

    class C07142 implements OnItemClickListener {
        C07142() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            DialogManager.dismissDialog(ActivityDialog.this.activityDialog);
            if (i >= 0 && ActivityDialog.this.activityList != null && i < ActivityDialog.this.activityList.size()) {
                ProjectItem projectItem = (ProjectItem) ActivityDialog.this.activityList.get(i);
                C2511g.m12484d("BETACLUB_SDK", "HAOHAO" + projectItem.getProjectName());
                ActivityDialog.this.onGetActivityListener.onGetActivity(projectItem.getProjectId(), projectItem.getProjectName(), null);
                C2515k.m12548b(projectItem.getProjectId());
                C2515k.m12551c(projectItem.getProjectName());
                C2515k.m12547b(ActivityDialog.this.context);
            }
        }
    }

    class C07153 implements OnRefreshListener {
        C07153() {
        }

        public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
            C2511g.m12477a("BETACLUB_SDK", "[ActivityDialog.onRefresh]Loading the project list...");
            ActivityDialog.this.refreshToGetProjectList();
        }

        public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
        }
    }

    public class GetProjectListTask extends AsyncTask<Void, Void, Boolean> {
        protected Boolean doInBackground(Void... voidArr) {
            try {
                ActivityDialog.this.getProjectListFromWeb();
                if (ActivityDialog.this.activityList != null) {
                    ActivityDialog.this.items.clear();
                    for (ProjectItem projectName : ActivityDialog.this.activityList) {
                        ActivityDialog.this.items.add(projectName.getProjectName());
                    }
                    C2511g.m12484d("BETACLUB_SDK", "[ActivityDialog.GetProjectListTask.doInBackground] return true");
                    return Boolean.valueOf(true);
                }
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "[ActivityDialog.GetProjectListTask.doInBackground]Exception:", e);
            }
            C2511g.m12484d("BETACLUB_SDK", "[ActivityDialog.GetProjectListTask.doInBackground] return false");
            return Boolean.valueOf(false);
        }

        protected void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                ActivityDialog.this.mAdapter.notifyDataSetChanged();
                ActivityDialog.this.mDialogProjectListLayout.refreshFinish(0);
                if (ActivityDialog.this.mAdapter.getCount() == 0) {
                    ActivityDialog.this.showEmptyView();
                    return;
                }
                return;
            }
            ActivityDialog.this.mDialogProjectListLayout.refreshFinish(1);
            ActivityDialog.this.showEmptyView();
        }
    }

    public ActivityDialog(Context context, OnGetActivityListener onGetActivityListener, OnDismissListener onDismissListener) {
        this.context = context;
        this.onGetActivityListener = onGetActivityListener;
        this.onDismissListener = onDismissListener;
        init();
    }

    public void init() {
        initView();
        refresh2GetProjectList();
    }

    private void refresh2GetProjectList() {
        if (this.mAdapter.getCount() == 0) {
            new C07131().sendEmptyMessageDelayed(0, 200);
        }
    }

    private void initView() {
        View inflate = View.inflate(this.context, ResUtil.getResId(this.context, "sdk_crowdtest_layout_dialog_activity_spinner", ResUtil.TYPE_LAYOUT), null);
        this.mEmptyView = (LinearLayout) inflate.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_activity_empty_view", "id"));
        this.mContentView = (FrameLayout) inflate.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_activity_content_container", "id"));
        this.mDialogProjectListLayout = (PullToRefreshLayout) inflate.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_dialog_project_list_layout", "id"));
        this.mDialogProjectListView = (PullableListView) inflate.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_dialog_project_list_view", "id"));
        this.mAdapter = new ArrayAdapter(this.context, ResUtil.getResId(this.context, "sdk_crowdtest_layout_item_spinner_text", ResUtil.TYPE_LAYOUT), this.items);
        this.mDialogProjectListView.setAdapter(this.mAdapter);
        this.activityDialog = new Builder(this.context).create();
        if (this.onDismissListener != null) {
            this.activityDialog.setOnDismissListener(this.onDismissListener);
        }
        DialogManager.showDialog(this.activityDialog);
        this.activityDialog.getWindow().setContentView(inflate);
        this.mDialogProjectListView.setOnItemClickListener(new C07142());
        this.mDialogProjectListView.setMode(Mode.REFRESH_ONLY);
        this.mDialogProjectListLayout.setOnRefreshListener(new C07153());
    }

    public void refreshToGetProjectList() {
        new GetProjectListTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void getProjectListFromWeb() {
        int d = C2514j.m12526d();
        C2511g.m12483c("BETACLUB_SDK", "[ActivityDialog.getProjectListFromWeb]prodType:" + d);
        preHandleProjectList(HttpBetaAccess.getInstance().getMyProjectListFromWeb(d));
    }

    private void preHandleProjectList(List<ProjectItem> list) {
        if (list == null || this.activityList == null) {
            C2511g.m12483c("BETACLUB_SDK", "[ActivityDialog.preHandleProjectList]at least one list is null!");
            return;
        }
        this.activityList.clear();
        for (ProjectItem add : list) {
            this.activityList.add(add);
        }
        C2511g.m12483c("BETACLUB_SDK", "[ActivityDialog.preHandleProjectList]activityList:" + this.activityList.toString());
    }

    private void showEmptyView() {
        this.mContentView.setVisibility(4);
        this.mEmptyView.setVisibility(0);
    }
}
