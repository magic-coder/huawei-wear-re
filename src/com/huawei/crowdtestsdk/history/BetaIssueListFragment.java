package com.huawei.crowdtestsdk.history;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.crowdtestsdk.bases.IssueItem;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.db.FeedbackIssueConstants;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.Mode;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullToRefreshLayout;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullToRefreshLayout.OnRefreshListener;
import com.huawei.crowdtestsdk.feedback.widgets.pulltorefreshandload.PullableListView;
import com.huawei.crowdtestsdk.history.net.HistoryTbdtsAccess;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.List;

public class BetaIssueListFragment extends IssueListFragment {
    private static final int MSG_UPDATE_LIST = 1;
    private BetaIssueListAdapter adapter;
    private Context appContext;
    private LinearLayout emptyView;
    private PullToRefreshLayout mAllIssueListLayout;
    private PullableListView mAllIssueListView;
    private FragmentActivity mContext;
    private Handler mHandler = new C07601();
    private List<IssueItem> mIssueItemList = new ArrayList();
    private String projectId;
    private View rootView;

    class C07601 extends Handler {
        C07601() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    C2511g.m12481b("BETACLUB_SDK", "[IssueListFragment.mHandler] handle MSG_UPDATE_LIST");
                    break;
            }
            super.handleMessage(message);
        }
    }

    class C07612 extends Handler {
        C07612() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            BetaIssueListFragment.this.mAllIssueListLayout.autoRefresh();
        }
    }

    class C07623 implements OnRefreshListener {
        C07623() {
        }

        public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
            try {
                C2511g.m12481b("BETACLUB_SDK", "[IssueListFragment.initIssueListView]onPullDownToRefresh!");
                new GetDataTask(BetaIssueListFragment.this.projectId, BetaIssueListFragment.this.mIssueItemList.size(), true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e) {
                C2511g.m12483c("BETACLUB_SDK", "[BetaIssueListFragment.initIssueListView]onPullDownToRefresh Exception!");
            }
        }

        public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
            BetaIssueListFragment.this.emptyView.setVisibility(8);
            try {
                C2511g.m12481b("BETACLUB_SDK", "[BetaIssueListFragment.initIssueListView]onPullUpToRefresh!");
                new GetDataTask(BetaIssueListFragment.this.projectId, BetaIssueListFragment.this.mIssueItemList.size(), false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e) {
                C2511g.m12483c("BETACLUB_SDK", "[BetaIssueListFragment.initIssueListView]onPullUpToRefresh Exception!");
            }
        }
    }

    class C07634 implements Runnable {
        C07634() {
        }

        public void run() {
            BetaIssueListFragment.this.adapter.notifyDataSetChanged();
        }
    }

    public class GetDataTask extends AsyncTask<Void, Void, String[]> {
        private int currentListSize = 0;
        private boolean isDropDown = true;
        private int pageSize = 15;
        private String projectId;

        public GetDataTask(String str, int i, boolean z) {
            this.projectId = str;
            this.currentListSize = i;
            this.isDropDown = z;
        }

        protected String[] doInBackground(Void... voidArr) {
            C2511g.m12481b("BETACLUB_SDK", "[IssueListFragment.GetDataTask.doInBackground]Start");
            if (this.isDropDown) {
                List<IssueItem> issueListByProjectIDFromWeb = HistoryTbdtsAccess.getInstance().getIssueListByProjectIDFromWeb(this.projectId, 1);
                if (issueListByProjectIDFromWeb != null && issueListByProjectIDFromWeb.size() > 0) {
                    for (IssueItem issueItem : issueListByProjectIDFromWeb) {
                        C2511g.m12481b("BETACLUB_SDK", "[BetaIssueListFragment.GetDataTask.doInBackground]item:" + issueItem.toString());
                    }
                    HistoryTbdtsAccess.getInstance().writeIssueListByProjectIdToLocal(this.projectId, issueListByProjectIDFromWeb);
                    BetaIssueListFragment.this.getIssueListFromLocal();
                }
            } else {
                List arrayList = new ArrayList();
                if (this.currentListSize < this.pageSize) {
                    arrayList = HistoryTbdtsAccess.getInstance().getIssueListByProjectIDFromWeb(this.projectId, 1);
                } else {
                    int i = (this.currentListSize + this.pageSize) / this.pageSize;
                    for (int i2 = 0; i2 < i; i2++) {
                        arrayList.addAll(HistoryTbdtsAccess.getInstance().getIssueListByProjectIDFromWeb(this.projectId, i2 + 1));
                    }
                }
                if (!(BetaIssueListFragment.this.mIssueItemList == null || arrayList == null || arrayList.size() <= 0)) {
                    HistoryTbdtsAccess.getInstance().writeIssueListByProjectIdToLocal(this.projectId, arrayList);
                    BetaIssueListFragment.this.getIssueListFromLocal();
                }
            }
            return null;
        }

        protected void onPostExecute(String[] strArr) {
            try {
                BetaIssueListFragment.this.updateIssueListView();
                if (this.isDropDown) {
                    BetaIssueListFragment.this.mAllIssueListLayout.refreshFinish(0);
                    C2511g.m12481b("BETACLUB_SDK", "[IssueListFragment.GetDataTask.onPostExecute]mAllIssueListLayout.refreshFinish");
                } else {
                    BetaIssueListFragment.this.mAllIssueListLayout.loadMoreFinish(0);
                    BetaIssueListFragment.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                    C2511g.m12481b("BETACLUB_SDK", "[IssueListFragment.GetDataTask.onPostExecute]mAllIssueListLayout.loadMoreFinish");
                }
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "[GetDataTask.onPostExecute] Error!", e);
            }
            super.onPostExecute(strArr);
            BetaIssueListFragment.this.isShowEmptyView();
        }
    }

    public BetaIssueListFragment() {
        C2511g.m12481b("BETACLUB_SDK", "BetaIssueListFragment non-parameter constructor...");
    }

    public static Fragment newInstance(String str) {
        Fragment betaIssueListFragment = new BetaIssueListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ProjectId", str);
        betaIssueListFragment.setArguments(bundle);
        return betaIssueListFragment;
    }

    public static Fragment newInstance(String str, boolean z) {
        Fragment betaIssueListFragment = new BetaIssueListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("projectId", str);
        bundle.putBoolean("IsAddAttachMode", z);
        betaIssueListFragment.setArguments(bundle);
        return betaIssueListFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.projectId = getArguments().getString("ProjectId");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.rootView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
        } else {
            this.appContext = AppContext.getInstance().getApplicationContext();
            this.rootView = layoutInflater.inflate(ResUtil.getResId(this.appContext, "sdk_crowdtest_fragment_issue_list", ResUtil.TYPE_LAYOUT), viewGroup, false);
            initView(this.rootView);
        }
        return this.rootView;
    }

    protected void initView(View view) {
        this.mAllIssueListLayout = (PullToRefreshLayout) view.findViewById(ResUtil.getResId(this.appContext, "sdk_crowdtest_history_all_issue_list_layout", "id"));
        this.mAllIssueListView = (PullableListView) view.findViewById(ResUtil.getResId(this.appContext, "sdk_crowdtest_history_all_issue_list_view", "id"));
        this.emptyView = (LinearLayout) view.findViewById(ResUtil.getResId(this.appContext, "sdk_crowdtest_issue_list_empty_layout", "id"));
    }

    private void autoRefreshIssueList() {
        if (NetworkUtils.checkNetworkStatus(this.mContext)) {
            new C07612().sendEmptyMessageAtTime(0, 600000);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getActivity();
        startWork();
        autoRefreshIssueList();
    }

    protected void startWork() {
        getIssueListFromLocal();
        initIssueListView();
    }

    private void initIssueListView() {
        this.mAllIssueListView.setMode(Mode.BOTH);
        this.mAllIssueListLayout.setOnRefreshListener(new C07623());
        this.adapter = new BetaIssueListAdapter(this.mContext, this.mIssueItemList);
        this.mAllIssueListView.setAdapter(this.adapter);
        isShowEmptyView();
    }

    private void isShowEmptyView() {
        if (this.mIssueItemList.size() == 0) {
            this.emptyView.setVisibility(0);
        } else {
            this.emptyView.setVisibility(8);
        }
    }

    private void getIssueListFromLocal() {
        C2511g.m12481b("BETACLUB_SDK", "[IssueListFragment.getIssueListFromLocal] start...");
        String[] strArr = new String[]{this.projectId};
        Cursor query = this.mContext.getContentResolver().query(FeedbackIssueConstants.CONTENT_URI_ISSUES, null, "project_id=?", strArr, "_id ASC");
        if (this.mIssueItemList != null) {
            this.mIssueItemList.clear();
        }
        if (query != null && query.getCount() > 0) {
            IssueItem issueItem;
            query.moveToFirst();
            while (!query.isAfterLast()) {
                issueItem = new IssueItem();
                issueItem.setTbdtsQuesNo(query.getString(2));
                issueItem.setProjectId(this.projectId);
                issueItem.setQuesId(query.getString(3));
                issueItem.setQuesStatus(query.getString(4));
                issueItem.setBrief(query.getString(5));
                issueItem.setCreatedDate(query.getString(6));
                issueItem.setNextProccess(query.getString(7));
                issueItem.setUserAccount(query.getString(8));
                this.mIssueItemList.add(issueItem);
                query.moveToNext();
            }
            for (IssueItem issueItem2 : this.mIssueItemList) {
                if (issueItem2 != null) {
                }
            }
            this.mHandler.sendEmptyMessage(1);
        }
        C2511g.m12481b("BETACLUB_SDK", "[IssueListFragment.getIssueListFromLocal] end...");
        IOUtils.close(query);
    }

    private void updateIssueListView() {
        C2511g.m12481b("BETACLUB_SDK", "[BetaIssueListFragment.updateIssueListView]is called!");
        if (this.adapter == null) {
            return;
        }
        if (getActivity() != null) {
            getActivity().runOnUiThread(new C07634());
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[BetaIssueListFragment.updateIssueListView] notifyDataSetChanged is failed!");
        }
    }

    public boolean onBackPressed() {
        return false;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void updateIssueList() {
        try {
            C2511g.m12481b("BETACLUB_SDK", "[BetaIssueListFragment.updateIssueList]onDropDown!");
            new GetDataTask(this.projectId, this.mIssueItemList.size(), true).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } catch (Exception e) {
            C2511g.m12483c("BETACLUB_SDK", "[BetaIssueListFragment.updateIssueList]onDropDown Exception");
        }
    }
}
