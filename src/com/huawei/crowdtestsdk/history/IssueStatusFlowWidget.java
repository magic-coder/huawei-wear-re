package com.huawei.crowdtestsdk.history;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.crowdtestsdk.bases.IssueStatusFlow;
import com.huawei.crowdtestsdk.history.net.HistoryTbdtsAccess;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueStatusFlowWidget extends LinearLayout {
    private static final int COMPLETE_GET_ISSUE_FLOW = 1;
    private static final int GET_ISSUE_FLOW_TIME_OUT = 20000;
    private static final int MSG_GET_ISSUE_FLOW_TIME_OUT = 2;
    private List<IssueStatusFlow> issueStatusFlowList;
    IssueStatusFlow item1 = new IssueStatusFlow();
    IssueStatusFlow item2 = new IssueStatusFlow();
    IssueStatusFlow item3 = new IssueStatusFlow();
    IssueStatusFlow item4 = new IssueStatusFlow();
    IssueStatusFlow item5 = new IssueStatusFlow();
    private LoadIssueFlowStatusTask loadIssueFlowStatusTask;
    private Handler mHandler = new C07651();

    class C07651 extends Handler {
        C07651() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    IssueStatusFlowWidget.this.refresh();
                    return;
                case 2:
                    IssueStatusFlowWidget.this.removeAllHandlerMsg();
                    return;
                default:
                    return;
            }
        }
    }

    public interface OnLoadIssueFlowStatusListener {
        void loadComplete(List<IssueStatusFlow> list);
    }

    class C07662 implements OnLoadIssueFlowStatusListener {
        C07662() {
        }

        public void loadComplete(List<IssueStatusFlow> list) {
            IssueStatusFlowWidget.this.issueStatusFlowList = list;
            IssueStatusFlowWidget.this.mHandler.sendEmptyMessage(1);
        }
    }

    public class LoadIssueFlowStatusTask extends AsyncTask<Void, Void, Boolean> {
        String issueId;
        List<IssueStatusFlow> issueStatusFlowList;
        List<IssueWorkFlowItem> issueWorkFlowItemList;
        OnLoadIssueFlowStatusListener loadListener;

        LoadIssueFlowStatusTask(Context context, String str) {
            this.issueId = str;
        }

        public void setOnLoadIssueFlowStatusListener(OnLoadIssueFlowStatusListener onLoadIssueFlowStatusListener) {
            this.loadListener = onLoadIssueFlowStatusListener;
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Boolean doInBackground(Void... voidArr) {
            C2511g.m12481b("BETACLUB_SDK", "[IssueStatusFlowWidget.LoadIssueFlowStatusTask.doInBackground]Start");
            this.issueWorkFlowItemList = HistoryTbdtsAccess.getInstance().getIssueHistoryWorkFlowStatus(this.issueId);
            Collections.reverse(this.issueWorkFlowItemList);
            this.issueStatusFlowList = new ArrayList();
            for (IssueWorkFlowItem issueWorkFlowItem : this.issueWorkFlowItemList) {
                IssueStatusFlow issueStatusFlow = new IssueStatusFlow();
                issueStatusFlow.setStatus((String) IssueStatusConstants.issueStatueType.get(issueWorkFlowItem.taskDefName));
                C2511g.m12481b("BETACLUB_SDK", "[IssueStatusFlowWidget]LoadIssueFlowStatusTask -> doInBackground:flowItem.taskDefName:" + issueWorkFlowItem.taskDefName);
                issueStatusFlow.setUpdateTime(IssueStatusFlowWidget.this.formatTime(issueWorkFlowItem.lastUpdateDate));
                issueStatusFlow.setAssignee(issueWorkFlowItem.assignee);
                issueStatusFlow.setRemarks(issueWorkFlowItem.description);
                issueStatusFlow.setCurrentFlow(false);
                this.issueStatusFlowList.add(issueStatusFlow);
            }
            IssueStatusFlow issueCurrentWorkFlowStatus = HistoryTbdtsAccess.getInstance().getIssueCurrentWorkFlowStatus(this.issueId);
            if (issueCurrentWorkFlowStatus != null) {
                String status = issueCurrentWorkFlowStatus.getStatus();
                issueCurrentWorkFlowStatus.setStatus((String) IssueStatusConstants.issueCurrentStatusType.get(issueCurrentWorkFlowStatus.getStatus()));
                C2511g.m12481b("BETACLUB_SDK", "[IssueStatusFlowWidget]LoadIssueFlowStatusTask -> doInBackground:currentItem.getStatus():" + issueCurrentWorkFlowStatus.getStatus());
                issueCurrentWorkFlowStatus.setUpdateTime(IssueStatusFlowWidget.this.formatTime(issueCurrentWorkFlowStatus.getUpdateTime()));
                this.issueStatusFlowList.add(issueCurrentWorkFlowStatus);
                this.issueStatusFlowList.addAll(IssueStatusFlowWidget.this.getFutureWorkFlowStatus(status));
            }
            return Boolean.valueOf(false);
        }

        protected void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            this.loadListener.loadComplete(this.issueStatusFlowList);
        }

        protected void onCancelled() {
            super.onCancelled();
        }
    }

    public IssueStatusFlowWidget(Context context) {
        super(context);
    }

    public IssueStatusFlowWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IssueStatusFlowWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        this.item1.setAssignee("");
        this.item1.setStatus(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_text_ques_flow_name_complete_issue", ResUtil.TYPE_STRING)));
        this.item1.setCurrentFlow(false);
        this.item1.setUpdateTime("");
        this.item2.setAssignee("");
        this.item2.setStatus(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_text_ques_flow_name_test_manager_approve", ResUtil.TYPE_STRING)));
        this.item2.setCurrentFlow(false);
        this.item2.setUpdateTime("");
        this.item3.setAssignee("");
        this.item3.setStatus(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_text_ques_flow_name_review", ResUtil.TYPE_STRING)));
        this.item3.setCurrentFlow(false);
        this.item3.setUpdateTime("");
        this.item4.setAssignee("");
        this.item4.setStatus(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_text_ques_flow_name_creater_handle", ResUtil.TYPE_STRING)));
        this.item4.setCurrentFlow(false);
        this.item4.setUpdateTime("");
        this.item5.setAssignee("");
        this.item5.setStatus(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_text_ques_flow_name_close", ResUtil.TYPE_STRING)));
        this.item5.setCurrentFlow(false);
        this.item5.setUpdateTime("");
    }

    public void setIssueNumber(String str) {
        C2511g.m12481b("BETACLUB_SDK", "[IssueStatusFlowWidget.setIssueNumber]number:" + str);
        this.loadIssueFlowStatusTask = new LoadIssueFlowStatusTask(this.mContext, str);
        this.loadIssueFlowStatusTask.setOnLoadIssueFlowStatusListener(new C07662());
        init();
    }

    public void start() {
        if (this.loadIssueFlowStatusTask != null && Status.PENDING.equals(this.loadIssueFlowStatusTask.getStatus())) {
            this.loadIssueFlowStatusTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            sendDelayedTimeoutMsg();
        }
    }

    private void sendDelayedTimeoutMsg() {
        this.mHandler.sendEmptyMessageDelayed(2, 20000);
    }

    private void removeAllHandlerMsg() {
        this.mHandler.removeCallbacksAndMessages(null);
        removeAllViews();
        View textView = new TextView(this.mContext);
        textView.setText(ResUtil.getResId(this.mContext, "sdk_crowdtest_text_get_flow_list_failed", ResUtil.TYPE_STRING));
        textView.setTextColor(Color.rgb(0, 0, 0));
        textView.setTextSize(14.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, HttpStatus.SC_BAD_REQUEST);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        addView(textView);
    }

    private void refresh() {
        if (this.issueStatusFlowList == null || this.issueStatusFlowList.size() <= 0) {
            removeAllHandlerMsg();
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        removeAllViews();
        int size = this.issueStatusFlowList.size() - 1;
        for (int i = 0; i < this.issueStatusFlowList.size(); i++) {
            View issueStatusFlowUnit = new IssueStatusFlowUnit(this.mContext);
            IssueStatusFlow issueStatusFlow = (IssueStatusFlow) this.issueStatusFlowList.get(i);
            if (issueStatusFlow.isCurrentFlow()) {
                issueStatusFlowUnit.setIsCurrent(true);
            }
            if (i == this.issueStatusFlowList.size() - 1) {
                issueStatusFlowUnit.setIsLast(true);
            }
            issueStatusFlowUnit.setStatus(issueStatusFlow.getStatus());
            issueStatusFlowUnit.setAssigneeName(issueStatusFlow.getAssignee());
            issueStatusFlowUnit.setStatusRemarks(issueStatusFlow.getRemarks());
            C2511g.m12481b("BETACLUB_SDK", "[IssueStatusFlowWidget.refresh]issueStatusFlow.getRemarks():" + issueStatusFlow.getRemarks());
            issueStatusFlowUnit.setStatusUpdateTime(issueStatusFlow.getUpdateTime());
            if (i == 0) {
                issueStatusFlowUnit.setStartFlow();
            }
            if (i == this.issueStatusFlowList.size() - 1) {
                issueStatusFlowUnit.setEndFlow();
            }
            if (issueStatusFlow.isCurrentFlow()) {
                issueStatusFlowUnit.setCurrentFlow();
                size = i;
            }
            if (i > size) {
                issueStatusFlowUnit.setUnCompleteFlow();
            }
            addView(issueStatusFlowUnit);
        }
    }

    public String formatTime(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            int indexOf = str.indexOf("T");
            return str.substring(0, indexOf) + HwAccountConstants.BLANK + str.substring(indexOf + 1, str.indexOf("."));
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[IssueStatusFlowWidget.formatTime] Error!", e);
            return "";
        }
    }

    private List<IssueStatusFlow> getFutureWorkFlowStatus(String str) {
        List<IssueStatusFlow> arrayList = new ArrayList();
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 1) {
                arrayList.add(this.item1);
                arrayList.add(this.item2);
                arrayList.add(this.item3);
                arrayList.add(this.item4);
                arrayList.add(this.item5);
            } else if (parseInt == 2) {
                arrayList.add(this.item2);
                arrayList.add(this.item3);
                arrayList.add(this.item4);
                arrayList.add(this.item5);
            } else if (parseInt == 3) {
                arrayList.add(this.item3);
                arrayList.add(this.item4);
                arrayList.add(this.item5);
            } else if (parseInt == 4) {
                arrayList.add(this.item4);
                arrayList.add(this.item5);
            } else if (parseInt == 5) {
                arrayList.add(this.item5);
            }
        } catch (Exception e) {
            C2511g.m12483c("BETACLUB_SDK", "[IssueStatusFlowWidget.getFutureWorkFlowStatus]Exception!");
        }
        return arrayList;
    }
}
