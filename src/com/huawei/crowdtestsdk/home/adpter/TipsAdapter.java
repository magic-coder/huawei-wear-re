package com.huawei.crowdtestsdk.home.adpter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.common.IssueType;
import com.huawei.crowdtestsdk.common.IssueTypeParser;
import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.feedback.FeedbackDescriptionActivity;
import com.huawei.uploadlog.p188c.C2511g;

public class TipsAdapter extends BaseAdapter {
    private String appVersionName;
    private Context context;
    private FeedbackParams feedbackParams;

    public TipsAdapter(Context context, FeedbackParams feedbackParams, String str) {
        this.context = context;
        this.feedbackParams = feedbackParams;
        this.appVersionName = str;
    }

    public int getCount() {
        return IssueTypeParser.getIssueTypeSize();
    }

    public Object getItem(int i) {
        return IssueTypeParser.getIssueTypeByIndex(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final IssueType issueTypeByIndex = IssueTypeParser.getIssueTypeByIndex(i);
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.TipsAdapter.getView]item is null->" + (issueTypeByIndex == null));
        if (issueTypeByIndex == null) {
            return null;
        }
        TipsViewHolder tipsViewHolder;
        C2511g.m12481b("BETACLUB_SDK", "[FeedbackFragment.TipsAdapter.getView]item->" + issueTypeByIndex.toString());
        if (view == null) {
            TipsViewHolder tipsViewHolder2 = new TipsViewHolder();
            view = LayoutInflater.from(this.context).inflate(R.layout.sdk_crowdtest_item_grid_view_layout, viewGroup, false);
            tipsViewHolder2.setImageView((ImageView) view.findViewById(R.id.sdk_crowdtest_tips_imageview));
            tipsViewHolder2.setTextViewTitle((TextView) view.findViewById(R.id.sdk_crowdtest_tips_title));
            tipsViewHolder2.setTextViewContent((TextView) view.findViewById(R.id.sdk_crowdtest_tips_content));
            view.setTag(tipsViewHolder2);
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    TipsAdapter.this.gotoFeedbackPage(TipsAdapter.this.context, issueTypeByIndex);
                }
            });
            tipsViewHolder = tipsViewHolder2;
        } else {
            tipsViewHolder = (TipsViewHolder) view.getTag();
        }
        tipsViewHolder.getImageView().setBackgroundResource(issueTypeByIndex.getImageId());
        tipsViewHolder.getTextViewTitle().setText(issueTypeByIndex.getTitle());
        tipsViewHolder.getTextViewContent().setText(issueTypeByIndex.getDesc());
        return view;
    }

    private void gotoFeedbackPage(Context context, IssueType issueType) {
        C2511g.m12481b("BETACLUB_SDK", "[TipAdapter.gotoFeedbackPage] is called!");
        C2511g.m12481b("BETACLUB_SDK", "start FeedbackDescriptionActivity with bug type id!");
        Intent intent = new Intent(context, FeedbackDescriptionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(SdkConstants.FEEDBACK_PARAMS, this.feedbackParams);
        bundle.putString(SdkConstants.APP_VERSION_NAME, this.appVersionName);
        bundle.putInt(IntegrationConstants.BUG_TYPE, issueType.getBugTypeId());
        C2511g.m12481b("BETACLUB_SDK", "[TipsAdapter.gotoFeedbackPage]bug type id is:" + issueType.getBugTypeId());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
