package com.huawei.crowdtestsdk.home;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.common.IssueTypeParser;
import com.huawei.crowdtestsdk.history.BaseFragment;
import com.huawei.crowdtestsdk.home.adpter.TipsAdapter;
import com.huawei.crowdtestsdk.widgets.FeedBackGridView;
import com.huawei.uploadlog.p188c.C2511g;

public class FeedbackFragment extends BaseFragment {
    private static final int CURRENT_COMMERCIAL_STATE = 1;
    private static final int LOAD_FINISH = 4;
    private static final int SHOW_GRID = 3;
    private String appVersionName = "";
    private Activity context;
    private FeedbackParams feedbackParam;
    private Thread gridThread;
    private FeedBackGridView gridView;
    private Handler handler = new C07811();
    private View rootView;
    private ScrollView scrollView;
    private TypedArray xmlList;

    class C07811 extends Handler {
        C07811() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.handler]CURRENT_COMMERCIAL_STATE");
                    FeedbackFragment.this.gridThread = new GridDataThread();
                    FeedbackFragment.this.gridThread.start();
                    return;
                case 3:
                    C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.handler]SHOW_GRID");
                    return;
                case 4:
                    FeedbackFragment.this.setViewChange();
                    return;
                default:
                    return;
            }
        }
    }

    public class GridDataThread extends Thread {
        public void run() {
            C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.GridDataThread] is called!");
            FeedbackFragment.this.handler.sendEmptyMessage(4);
            FeedbackFragment.this.handler.sendEmptyMessage(3);
        }
    }

    private void setViewChange() {
        this.scrollView.smoothScrollTo(0, 0);
    }

    protected void initView(View view) {
        this.scrollView = (ScrollView) view.findViewById(R.id.sdk_crowdtest_issue_fragment_scroll_view);
        this.gridView = (FeedBackGridView) view.findViewById(R.id.sdk_crowdtest_issue_fragment_gv);
    }

    protected void startWork() {
        initData();
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.startWork] is called!");
        this.gridView.setAdapter(new TipsAdapter(this.context, this.feedbackParam, this.appVersionName));
        this.gridView.setNumColumns(3);
        this.handler.sendEmptyMessage(1);
    }

    public boolean onBackPressed() {
        return false;
    }

    private void initData() {
        this.xmlList = getResources().obtainTypedArray(R.array.sdk_product_types_xml);
        IssueTypeParser.getInstance().parseIssueType(this.context, this.xmlList.getResourceId(0, 0));
        if (IssueTypeParser.getIssueTypeSize() == 1) {
            this.gridView.setNumColumns(1);
        }
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessage(1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.onCreateView] is called!");
        if (this.rootView != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.rootView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
        } else {
            this.rootView = layoutInflater.inflate(R.layout.sdk_crowdtest_fragment_issue_type, viewGroup, false);
            initView(this.rootView);
        }
        return this.rootView;
    }

    public void onActivityCreated(Bundle bundle) {
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.onActivityCreated] is called!");
        super.onActivityCreated(bundle);
        this.context = getActivity();
        startWork();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.feedbackParam = ((HomeActivity) activity).getFeedbackParam();
        this.appVersionName = ((HomeActivity) activity).getAppVersionName();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.xmlList != null) {
            this.xmlList.recycle();
        }
    }
}
