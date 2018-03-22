package com.huawei.crowdtestsdk.history;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.androidcommon.utils.NetworkUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.bases.BetaQuestionItem;
import com.huawei.crowdtestsdk.bases.IssueItem;
import com.huawei.crowdtestsdk.common.QuesStatus;
import com.huawei.crowdtestsdk.constants.FeedbackProjectConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.history.net.HistoryTbdtsAccess;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.List;

public class BetaIssueListAdapter extends BaseAdapter {
    private static final int UPDATE_BETA_QUESTION_FAIL = 2;
    private static final int UPDATE_BETA_QUESTION_SUCCESS = 1;
    private BetaQuestionItem betaQuestionItem;
    private Context context;
    private boolean isReject = false;
    private List<IssueItem> issueList;
    private final Handler mHandler = new C07594();
    private SparseArray<IssueListViewCache> viewMap = new SparseArray();

    class C07594 extends Handler {
        C07594() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    BetaIssueListAdapter.this.onUpdateBetaQuestionSuccess();
                    break;
                case 2:
                    BetaIssueListAdapter.this.onUpdateBetaQuestionFail();
                    break;
            }
            super.handleMessage(message);
        }
    }

    class GetBetaQuestionRunnable implements Runnable {
        private String mQuesNo;

        public GetBetaQuestionRunnable(String str) {
            this.mQuesNo = str;
        }

        public void run() {
            BetaIssueListAdapter.this.betaQuestionItem = HistoryTbdtsAccess.getInstance().getBetaQuestionDetail(this.mQuesNo);
            if (BetaIssueListAdapter.this.betaQuestionItem != null) {
                C2511g.m12481b("BETACLUB_SDK", "[IssueConfirmDialog.GetBetaQuestionRunnable]Get issue information success!");
                BetaIssueListAdapter.this.handleBetaQuestion();
                return;
            }
            C2511g.m12481b("BETACLUB_SDK", "[IssueConfirmDialog.GetBetaQuestionRunnable]Get issue information failed!");
        }
    }

    final class IssueListViewCache {
        LinearLayout btnHandle;
        LinearLayout btnModify;
        LinearLayout btnRecord;
        TextView tvBrief;
        TextView tvIssueNo;
        TextView tvOccurrence;

        IssueListViewCache() {
        }
    }

    class UpdateBetaQuestionRunnable implements Runnable {
        private boolean isReject;
        private BetaQuestionItem item;

        public UpdateBetaQuestionRunnable(BetaQuestionItem betaQuestionItem, boolean z) {
            this.item = betaQuestionItem;
            this.isReject = z;
        }

        public void run() {
            String updateBetaDealQuestion = HistoryTbdtsAccess.getInstance().updateBetaDealQuestion(this.item, this.isReject);
            if (updateBetaDealQuestion == null || updateBetaDealQuestion.isEmpty() || !updateBetaDealQuestion.equalsIgnoreCase("1")) {
                C2511g.m12481b("BETACLUB_SDK", "[IssueConfirmDialog.UpdateBetaQuestionRunnable]Update issue information failed!");
                BetaIssueListAdapter.this.mHandler.sendEmptyMessage(2);
                return;
            }
            C2511g.m12481b("BETACLUB_SDK", "[IssueConfirmDialog.UpdateBetaQuestionRunnable]Update issue information success!");
            BetaIssueListAdapter.this.mHandler.sendEmptyMessage(1);
            BetaIssueListAdapter.this.context.getApplicationContext().sendBroadcast(new Intent(SdkConstants.UPDATE_ISSUE_LIST), SdkConstants.USE_CROWDTESTSDK_PERMISSION);
        }
    }

    public BetaIssueListAdapter(Context context, List<IssueItem> list) {
        this.context = context;
        this.issueList = list;
    }

    public void setData(List<IssueItem> list) {
        this.issueList = list;
    }

    public int getCount() {
        if (this.issueList == null) {
            return 0;
        }
        return this.issueList.size();
    }

    public Object getItem(int i) {
        return this.issueList.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        IssueListViewCache issueListViewCache;
        if (view == null) {
            issueListViewCache = new IssueListViewCache();
            view = LayoutInflater.from(this.context).inflate(ResUtil.getResId(this.context, "sdk_crowdtest_layout_item_project_issue_list", ResUtil.TYPE_LAYOUT), null);
            issueListViewCache.tvIssueNo = (TextView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_issue_item_issue_number", "id"));
            issueListViewCache.tvOccurrence = (TextView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_log_date", "id"));
            issueListViewCache.tvBrief = (TextView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_log_description_content", "id"));
            issueListViewCache.btnModify = (LinearLayout) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_issue_item_button_modify", "id"));
            issueListViewCache.btnRecord = (LinearLayout) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_issue_item_button_history_record", "id"));
            issueListViewCache.btnHandle = (LinearLayout) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_issue_item_button_handle", "id"));
            view.setTag(issueListViewCache);
            this.viewMap.put(i, issueListViewCache);
        } else {
            issueListViewCache = (IssueListViewCache) view.getTag();
        }
        issueListViewCache.tvIssueNo.setText(((IssueItem) this.issueList.get(i)).getTbdtsQuesNo());
        issueListViewCache.tvOccurrence.setText(((IssueItem) this.issueList.get(i)).getCreatedDate());
        issueListViewCache.tvBrief.setText(((IssueItem) this.issueList.get(i)).getBrief());
        final String str = (String) IssueStatusConstants.issueCurrentStatusType.get(((IssueItem) this.issueList.get(i)).getQuesStatus());
        C2511g.m12481b("BETACLUB_SDK", "[IssueListAdapter.getView]quesStatus:" + str);
        issueListViewCache.btnModify.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (NetworkUtils.getNetworkType(BetaIssueListAdapter.this.context) < 0) {
                    Toast.makeText(BetaIssueListAdapter.this.context, ResUtil.getResId(BetaIssueListAdapter.this.context, "sdk_crowdtest_check_net_connection", ResUtil.TYPE_STRING), 1).show();
                } else if (QuesStatus.isResubmitStatus(str)) {
                    r1 = new Intent(BetaIssueListAdapter.this.context, ModifyIssueActivity.class);
                    r1.putExtra("QuesID", ((IssueItem) BetaIssueListAdapter.this.issueList.get(i)).getTbdtsQuesNo());
                    r1.putExtra("Resubmit", true);
                    C2511g.m12481b("BETACLUB_SDK", "[IssueListAdapter.getView]btnModify onClick-->QuesID:" + ((IssueItem) BetaIssueListAdapter.this.issueList.get(i)).getTbdtsQuesNo());
                    BetaIssueListAdapter.this.context.startActivity(r1);
                } else {
                    r1 = new Intent(BetaIssueListAdapter.this.context, ModifyIssueActivity.class);
                    r1.putExtra("QuesID", ((IssueItem) BetaIssueListAdapter.this.issueList.get(i)).getQuesId());
                    r1.putExtra("Resubmit", false);
                    C2511g.m12481b("BETACLUB_SDK", "[IssueListAdapter.getView]btnModify onClick-->QuesID:" + ((IssueItem) BetaIssueListAdapter.this.issueList.get(i)).getQuesId());
                    BetaIssueListAdapter.this.context.startActivity(r1);
                }
            }
        });
        if (QuesStatus.isUserHandleStatus(str)) {
            issueListViewCache.btnHandle.setVisibility(0);
            issueListViewCache.btnHandle.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    BetaIssueListAdapter.this.startGetBetaQuestion(((IssueItem) BetaIssueListAdapter.this.issueList.get(i)).getTbdtsQuesNo());
                }
            });
            issueListViewCache.btnHandle.setVisibility(8);
        }
        if (QuesStatus.isUserHandleStatus(str) || QuesStatus.isCloseStatus(str)) {
            issueListViewCache.btnModify.setVisibility(8);
        } else {
            issueListViewCache.btnModify.setVisibility(0);
        }
        if (!QuesStatus.isUserHandleStatus(str)) {
            issueListViewCache.btnHandle.setVisibility(8);
        }
        issueListViewCache.btnRecord.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                IssueDetailDialog issueDetailDialog = new IssueDetailDialog(BetaIssueListAdapter.this.context, ((IssueItem) BetaIssueListAdapter.this.issueList.get(i)).getTbdtsQuesNo());
            }
        });
        return view;
    }

    private void onUpdateBetaQuestionFail() {
        ToastUtil.showLongToast(this.context, (CharSequence) "onUpdateBetaQuestionFail");
    }

    private void onUpdateBetaQuestionSuccess() {
        C2511g.m12481b("BETACLUB_SDK", "IssueConfirmDialog projectID is " + this.betaQuestionItem.getProjectId());
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri uri = FeedbackProjectConstants.CONTENT_URI_PROJECT;
        String str = "project_id = ?";
        Cursor query = contentResolver.query(uri, new String[]{FeedbackProjectConstants.COLUMN_NAME_PROJECT_UNHANDLE_COUNT}, str, new String[]{r6}, null);
        while (query.moveToNext()) {
            ContentValues contentValues = new ContentValues();
            String string = query.getString(query.getColumnIndex(FeedbackProjectConstants.COLUMN_NAME_PROJECT_UNHANDLE_COUNT));
            if (StringUtils.isNullOrEmpty(string)) {
                string = "0";
            }
            int parseInt = Integer.parseInt(string);
            if (parseInt > 0) {
                parseInt--;
            }
            C2511g.m12481b("BETACLUB_SDK", "IssueConfirm_COUNT:" + parseInt);
            contentValues.put(FeedbackProjectConstants.COLUMN_NAME_PROJECT_UNHANDLE_COUNT, String.valueOf(parseInt));
            contentResolver.update(uri, contentValues, str, new String[]{r6});
        }
        IOUtils.close(query);
        Intent intent = new Intent();
        intent.setAction("com.huawei.crowdtest.UnHandleReceive");
        this.context.sendBroadcast(intent, SdkConstants.USE_CROWDTESTSDK_PERMISSION);
        C2511g.m12481b("BETACLUB_SDK", "IssueConfirmDialog sendBroadcast");
        ToastUtil.showLongToast(this.context, (CharSequence) "onUpdateBetaQuestionSuccess");
    }

    private void startGetBetaQuestion(String str) {
        new Thread(new GetBetaQuestionRunnable(str)).start();
    }

    private void handleBetaQuestion() {
        if (this.betaQuestionItem != null) {
            BetaQuestionItem betaQuestionItem = new BetaQuestionItem();
            betaQuestionItem.setTbdtsQuesNo(this.betaQuestionItem.getTbdtsQuesNo());
            betaQuestionItem.setProjectName(this.betaQuestionItem.getProjectName());
            betaQuestionItem.setProjectId(this.betaQuestionItem.getProjectId());
            betaQuestionItem.setQuesId(this.betaQuestionItem.getQuesId());
            betaQuestionItem.setLastUpdatedName(this.betaQuestionItem.getLastUpdatedName());
            betaQuestionItem.setCreatedName(this.betaQuestionItem.getCreatedName());
            betaQuestionItem.setImeiNo(this.betaQuestionItem.getImeiNo());
            betaQuestionItem.setProdbNO(this.betaQuestionItem.getProdbNO());
            betaQuestionItem.setQuesAddress(this.betaQuestionItem.getQuesAddress());
            betaQuestionItem.setQuesTel(this.betaQuestionItem.getQuesTel());
            betaQuestionItem.setRecure(this.betaQuestionItem.getRecure());
            betaQuestionItem.setActivityQuestionNO(this.betaQuestionItem.getActivityQuestionNO());
            betaQuestionItem.setAppearDate(this.betaQuestionItem.getAppearDate());
            betaQuestionItem.setSolveDate(this.betaQuestionItem.getSolveDate());
            betaQuestionItem.setBrief(this.betaQuestionItem.getBrief());
            betaQuestionItem.setDetail(this.betaQuestionItem.getDetail());
            betaQuestionItem.setAttachmentBatchId(this.betaQuestionItem.getAttachmentBatchId());
            betaQuestionItem.setOrganizerIdea(this.betaQuestionItem.getOrganizerIdea());
            betaQuestionItem.setManagerSure(this.betaQuestionItem.getManagerSure());
            betaQuestionItem.setSeverity(this.betaQuestionItem.getSeverity());
            betaQuestionItem.setOrganizerRemarks(this.betaQuestionItem.getOrganizerRemarks());
            betaQuestionItem.setManagerSuggertions(this.betaQuestionItem.getManagerSuggertions());
            betaQuestionItem.setRecurrenceStatus(this.betaQuestionItem.getRecurrenceStatus());
            betaQuestionItem.setDtsExcelStatus(this.betaQuestionItem.getDtsExcelStatus());
            betaQuestionItem.setRecurrenceEdition(this.betaQuestionItem.getRecurrenceEdition());
            betaQuestionItem.setIsReasonable(this.betaQuestionItem.getIsReasonable());
            if (this.isReject) {
                betaQuestionItem.setQuesStatus("2");
                betaQuestionItem.setFlowStatus("2");
            } else {
                betaQuestionItem.setQuesStatus("6");
                betaQuestionItem.setFlowStatus("6");
            }
            new Thread(new UpdateBetaQuestionRunnable(betaQuestionItem, this.isReject)).start();
        }
    }
}
