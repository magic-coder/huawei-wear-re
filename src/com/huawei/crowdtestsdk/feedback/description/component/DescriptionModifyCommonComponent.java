package com.huawei.crowdtestsdk.feedback.description.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.bases.IQuestionItem;
import com.huawei.crowdtestsdk.common.IssueTypeParser;
import com.huawei.crowdtestsdk.constants.SdfConstants;
import com.huawei.crowdtestsdk.feedback.description.DescriptionParas;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.Date;

public class DescriptionModifyCommonComponent extends LinearLayout {
    private ViewGroup activityLayout;
    private EditText etSummary;
    private boolean isResubmit = false;
    private IQuestionItem issueItem;
    private ViewGroup issueNoLayout;
    private ViewGroup issueTypeLayout;
    private ImageView ivIssueTypeArrow;
    private ImageView ivProbabilityArrow;
    private ViewGroup occurrenceLayout;
    private ViewGroup probabilityLayout;
    private TextView tvActivity;
    private TextView tvActivityTitle;
    private TextView tvIssueNo;
    private TextView tvIssueNoTitle;
    private TextView tvIssueType;
    private TextView tvIssueTypeTitle;
    private TextView tvOccurrence;
    private TextView tvOccurrenceTitle;
    private TextView tvProbability;
    private TextView tvProbabilityTitle;
    private TextView tvSummaryTitle;

    class C07081 implements OnClickListener {
        C07081() {
        }

        public void onClick(View view) {
            DescriptionModifyCommonComponent.this.showNonsupportToast();
        }
    }

    class C07092 implements OnClickListener {
        C07092() {
        }

        public void onClick(View view) {
            DescriptionModifyCommonComponent.this.showNonsupportToast();
        }
    }

    class C07103 implements OnClickListener {
        C07103() {
        }

        public void onClick(View view) {
            DescriptionModifyCommonComponent.this.showNonsupportToast();
        }
    }

    class C07114 implements OnClickListener {
        C07114() {
        }

        public void onClick(View view) {
            DescriptionModifyCommonComponent.this.showNonsupportToast();
        }
    }

    class C07125 implements OnClickListener {
        C07125() {
        }

        public void onClick(View view) {
            DescriptionModifyCommonComponent.this.showNonsupportToast();
        }
    }

    public DescriptionModifyCommonComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(context.obtainStyledAttributes(attributeSet, new int[]{ResUtil.getResId(context, "sdk_crowdtest_ModifyComponent", ResUtil.TYPE_STYLEABLE)}));
        init();
    }

    private void parseAttributes(TypedArray typedArray) {
        try {
            this.isResubmit = typedArray.getBoolean(ResUtil.getResId(this.mContext, "sdk_crowdtest_ModifyComponent_isResubmit", ResUtil.TYPE_STYLEABLE), false);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[DescriptionModifyCommonComponent.parseAttributes]Exception:", e);
        } finally {
            typedArray.recycle();
        }
    }

    private void init() {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_description_modify_common_component", ResUtil.TYPE_LAYOUT), this);
        initView();
    }

    private void initView() {
        this.issueNoLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_no_layout", "id"));
        this.issueTypeLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_type_layout", "id"));
        this.activityLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_layout", "id"));
        this.probabilityLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_layout", "id"));
        this.occurrenceLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_layout", "id"));
        this.tvIssueNo = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_no_text", "id"));
        this.tvActivity = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_text", "id"));
        this.tvProbability = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_text", "id"));
        this.tvOccurrence = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_text", "id"));
        this.tvIssueType = (TextView) findViewById(R.id.sdk_crowdtest_description_issue_type_text);
        this.tvIssueNoTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_no_title", "id"));
        this.tvIssueTypeTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_type_title", "id"));
        this.tvActivityTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_title", "id"));
        this.tvProbabilityTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_title", "id"));
        this.tvOccurrenceTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_title", "id"));
        this.tvSummaryTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_summary_title", "id"));
        this.ivIssueTypeArrow = (ImageView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_type_arrow_image", "id"));
        this.ivProbabilityArrow = (ImageView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_arrow_image", "id"));
        this.tvIssueNoTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_no_title", ResUtil.TYPE_STRING))));
        this.tvIssueTypeTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_issue_type_title", ResUtil.TYPE_STRING))));
        this.tvActivityTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_title", ResUtil.TYPE_STRING))));
        this.tvProbabilityTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_title", ResUtil.TYPE_STRING))));
        this.tvOccurrenceTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_title", ResUtil.TYPE_STRING))));
        this.tvSummaryTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_summary_title", ResUtil.TYPE_STRING))));
        this.etSummary = (EditText) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_summary_text", "id"));
        this.issueNoLayout.setOnClickListener(new C07081());
        this.issueTypeLayout.setOnClickListener(new C07092());
        this.activityLayout.setOnClickListener(new C07103());
        this.probabilityLayout.setOnClickListener(new C07114());
        this.occurrenceLayout.setOnClickListener(new C07125());
        setResubmitState();
    }

    private void setResubmitState() {
        int i;
        int i2 = 0;
        ImageView imageView = this.ivIssueTypeArrow;
        if (this.isResubmit) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        ImageView imageView2 = this.ivProbabilityArrow;
        if (!this.isResubmit) {
            i2 = 8;
        }
        imageView2.setVisibility(i2);
    }

    public void setResubmitState(boolean z) {
        this.isResubmit = z;
        setResubmitState();
    }

    public boolean getResubmitState() {
        return this.isResubmit;
    }

    private void showNonsupportToast() {
        Toast.makeText(this.mContext, "不支持修改", 0).show();
    }

    public void setQuesInfo(IQuestionItem iQuestionItem) {
        this.issueItem = iQuestionItem;
        updateQuesInfo();
    }

    private void updateQuesInfo() {
        if (this.issueItem != null) {
            this.tvIssueNo.setText(this.issueItem.getTbdtsQuesNo());
            this.tvActivity.setText(this.issueItem.getProjectName());
            this.tvOccurrence.setText(getCreatedDate(this.issueItem.getCreatedDate()));
            this.tvIssueType.setText(IssueTypeParser.getIssueTypeByBetaId(this.mContext, this.issueItem.getNewQuesType()).getDesc());
            int intValue = ((Integer) DescriptionParas.recureIndexMap.get(this.issueItem.getRecure())).intValue();
            String[] stringArray = this.mContext.getResources().getStringArray(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability", ResUtil.TYPE_ARRAY));
            if (intValue >= 0 && intValue < stringArray.length) {
                this.tvProbability.setText(stringArray[intValue]);
            }
            this.etSummary.setText(this.issueItem.getBrief());
        }
    }

    public String getCreatedDate(String str) {
        try {
            str = SdfConstants.getDateTime(SdfConstants.getDateTime(str));
        } catch (Exception e) {
        }
        return str;
    }

    public String getBrief() {
        return this.etSummary.getText().toString();
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_brief_title", ResUtil.TYPE_STRING)));
        stringBuilder.append(this.etSummary.getText().toString());
        stringBuilder.append(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_old_detail_title", ResUtil.TYPE_STRING)));
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public int getProbabilityIndex() {
        try {
            return ((Integer) DescriptionParas.recureIndexMap.get(this.issueItem.getRecure())).intValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public long getOccurrenceTime() {
        Date dateTime = SdfConstants.getDateTime(this.issueItem.getCreatedDate());
        if (dateTime != null) {
            return dateTime.getTime();
        }
        return 0;
    }
}
