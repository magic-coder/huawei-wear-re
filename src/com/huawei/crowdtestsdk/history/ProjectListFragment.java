package com.huawei.crowdtestsdk.history;

import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.FeedbackProjectConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.feedback.ProjectActivity;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.Mode;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullToRefreshLayout;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullToRefreshLayout.OnRefreshListener;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullableListView;
import com.huawei.crowdtestsdk.history.LoadWebProjectListTask.OnLoadWebProjectListListener;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2514j;
import de.greenrobot.event.C2687c;

public class ProjectListFragment extends BaseFragment {
    private Context appContext;
    private FragmentActivity context;
    private LinearLayout emptyView;
    private LoadWebProjectListTask loadWebProjectListTask;
    LoaderCallbacks<Cursor> loader = new C07761();
    private ProjectListViewAdapter mAdapter;
    private PullToRefreshLayout mProjectListLayout;
    private PullableListView mProjectListView;
    private UnHandleReceive mReceive;
    OnItemClickListener onItemClickListener = new C07772();
    private View rootView;

    class C07761 implements LoaderCallbacks<Cursor> {
        C07761() {
        }

        public void onLoaderReset(Loader<Cursor> loader) {
        }

        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new CursorLoader(ProjectListFragment.this.context, FeedbackProjectConstants.CONTENT_URI_PROJECT, null, null, null, "_id ASC");
        }

        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            if (cursor == null) {
                ProjectListFragment.this.isShowEmptyView();
                C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.LoaderCallbacks]onLoadFinished:cursor == null");
            } else if (ProjectListFragment.this.mAdapter == null) {
                ProjectListFragment.this.mAdapter = new ProjectListViewAdapter(ProjectListFragment.this.context, ResUtil.getResId(ProjectListFragment.this.context, "sdk_crowdtest_layout_item_history_project", ResUtil.TYPE_LAYOUT), cursor, true);
                ProjectListFragment.this.mProjectListView.setAdapter(ProjectListFragment.this.mAdapter);
                ProjectListFragment.this.isShowEmptyView();
                ProjectListFragment.this.mProjectListView.setOnItemClickListener(ProjectListFragment.this.onItemClickListener);
            } else {
                ProjectListFragment.this.mAdapter.swapCursor(cursor);
                if (ProjectListFragment.this.mProjectListView.getAdapter() == null) {
                    ProjectListFragment.this.mProjectListView.setAdapter(ProjectListFragment.this.mAdapter);
                    ProjectListFragment.this.isShowEmptyView();
                }
            }
        }
    }

    class C07772 implements OnItemClickListener {
        C07772() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Cursor query = ProjectListFragment.this.context.getContentResolver().query(ContentUris.withAppendedId(FeedbackProjectConstants.CONTENT_ID_URI_BASE, j), null, null, null, null);
            if (query != null && query.moveToFirst()) {
                String string = query.getString(1);
                String string2 = query.getString(2);
                if (!StringUtils.isNullOrEmpty(string) && !StringUtils.isNullOrEmpty(string2)) {
                    Intent intent = new Intent(ProjectListFragment.this.context, ProjectActivity.class);
                    intent.putExtra("projectId", string);
                    intent.putExtra("projectName", string2);
                    ProjectListFragment.this.startActivity(intent);
                } else {
                    return;
                }
            }
            IOUtils.close(query);
        }
    }

    class C07783 extends Handler {
        C07783() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            ProjectListFragment.this.mProjectListLayout.autoRefresh();
        }
    }

    class C07794 implements OnRefreshListener {
        C07794() {
        }

        public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
            ProjectListFragment.this.emptyView.setVisibility(8);
            ProjectListFragment.this.getIssueListFromWeb();
            ProjectListFragment.this.isShowEmptyView();
        }

        public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
            ProjectListFragment.this.getIssueListFromWeb();
            ProjectListFragment.this.isShowEmptyView();
        }
    }

    class C07805 implements OnLoadWebProjectListListener {
        C07805() {
        }

        public void loadComplete() {
            C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.getIssueListFromWeb]loadComplete is called!");
            if (ProjectListFragment.this.mAdapter != null) {
                ProjectListFragment.this.mAdapter.notifyDataSetChanged();
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.getIssueListFromWeb]mAdapter is null:" + (ProjectListFragment.this.mAdapter == null));
            }
            ProjectListFragment.this.context.getSupportLoaderManager().restartLoader(103, null, ProjectListFragment.this.loader);
        }
    }

    class EndGetProjectEvent {
        public EndGetProjectEvent() {
            C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.EndGetProjectEvent]EndGetProjectEvent");
        }
    }

    class UnHandleReceive extends BroadcastReceiver {
        UnHandleReceive() {
        }

        public void onReceive(Context context, Intent intent) {
            C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.UnHandleReceive].onReceive");
            if (ProjectListFragment.this.mAdapter != null) {
                ProjectListFragment.this.mAdapter.notifyDataSetChanged();
                ProjectListFragment.this.isShowEmptyView();
            }
            ProjectListFragment.this.context.getSupportLoaderManager().restartLoader(103, null, ProjectListFragment.this.loader);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.rootView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
        } else {
            this.appContext = AppContext.getInstance().getApplicationContext();
            this.rootView = layoutInflater.inflate(ResUtil.getResId(this.appContext, "sdk_crowdtest_fragment_history_project", ResUtil.TYPE_LAYOUT), viewGroup, false);
            initView(this.rootView);
        }
        return this.rootView;
    }

    protected void initView(View view) {
        this.mProjectListLayout = (PullToRefreshLayout) view.findViewById(ResUtil.getResId(this.appContext, "sdk_crowdtest_project_list_layout", "id"));
        this.mProjectListView = (PullableListView) view.findViewById(ResUtil.getResId(this.appContext, "sdk_crowdtest_project_list_view", "id"));
        this.emptyView = (LinearLayout) view.findViewById(ResUtil.getResId(this.appContext, "sdk_crowdtest_project_list_empty_layout", "id"));
        initProjectListView();
        isShowEmptyView();
    }

    private void autoRefreshProjectList() {
        if (NetworkUtils.checkNetworkStatus(this.context)) {
            new C07783().sendEmptyMessageAtTime(0, 600000);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.context = getActivity();
        startWork();
        autoRefreshProjectList();
        this.mReceive = new UnHandleReceive();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.crowdtest.UnHandleReceive");
        this.context.registerReceiver(this.mReceive, intentFilter, SdkConstants.USE_CROWDTESTSDK_PERMISSION, null);
        C2687c.m12831a().m12841a((Object) this);
    }

    protected void startWork() {
        this.context.getSupportLoaderManager().initLoader(103, null, this.loader);
        if (checkToUpdate()) {
            getIssueListFromWeb();
        }
    }

    public boolean onBackPressed() {
        return false;
    }

    private void initProjectListView() {
        this.mProjectListView.setMode(Mode.BOTH);
        this.mProjectListLayout.setOnRefreshListener(new C07794());
    }

    private void isShowEmptyView() {
        C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.isShowEmptyView] mAdapter is null:" + (this.mAdapter == null));
        if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
            this.emptyView.setVisibility(0);
        } else {
            this.emptyView.setVisibility(8);
        }
    }

    private boolean checkToUpdate() {
        if (System.currentTimeMillis() - C2514j.m12530f() < 36000) {
            return false;
        }
        return NetworkUtils.checkNetworkStatus(this.context);
    }

    private void getIssueListFromWeb() {
        if (this.loadWebProjectListTask == null || this.loadWebProjectListTask.getStatus() == Status.FINISHED) {
            this.loadWebProjectListTask = new LoadWebProjectListTask(this.context);
            this.loadWebProjectListTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            this.loadWebProjectListTask.setOnLoadWebProjectListListener(new C07805());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.loadWebProjectListTask = null;
        this.context.unregisterReceiver(this.mReceive);
        C2687c.m12831a().m12842b(this);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onEvent(EndGetProjectEvent endGetProjectEvent) {
        C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.onEvent]start");
        if (endGetProjectEvent != null) {
            C2511g.m12481b("BETACLUB_SDK", "[ProjectListFragment.onEvent]mProjectListLayout.refreshFinish");
            this.mProjectListLayout.refreshFinish(0);
        }
    }
}
