package com.huawei.crowdtestsdk.feedback.description.component;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.androidcommon.utils.DateTimeUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.constants.SdfConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.feedback.description.DescriptionParas;
import com.huawei.crowdtestsdk.feedback.widgets.ActivityDialog;
import com.huawei.crowdtestsdk.feedback.widgets.ActivityDialog.OnGetActivityListener;
import com.huawei.crowdtestsdk.feedback.widgets.TimeDialog;
import com.huawei.crowdtestsdk.feedback.widgets.TimeDialog.OnGetTimeListener;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2515k;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;

public class DescriptionCommonComponent extends LinearLayout implements IComponent {
    protected String activityId;
    protected ViewGroup activityLayout;
    protected String activityName;
    protected AtomicBoolean alertDialog;
    protected EditText etSummary;
    protected ViewGroup occurrenceLayout;
    protected long occurrenceTime;
    protected OnDismissListener onDismissListener;
    protected int probabilityIndex;
    protected ViewGroup probabilityLayout;
    protected TextView tvActivity;
    protected TextView tvActivityTitle;
    protected TextView tvOccurrence;
    protected TextView tvOccurrenceTitle;
    protected TextView tvProbability;
    protected TextView tvProbabilityTitle;
    protected TextView tvSummaryTitle;

    class C06991 implements OnDismissListener {
        C06991() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            C2511g.m12481b("BETACLUB_SDK", "[DescriptionActivity.onDismissListener]Dismiss]");
            DescriptionCommonComponent.this.alertDialog.set(false);
        }
    }

    class C07002 implements OnClickListener {
        C07002() {
        }

        public void onClick(View view) {
            DescriptionCommonComponent.this.onSelectActivity();
        }
    }

    class C07013 implements OnClickListener {
        C07013() {
        }

        public void onClick(View view) {
            DescriptionCommonComponent.this.onSelectProbability();
        }
    }

    class C07024 implements OnClickListener {
        C07024() {
        }

        public void onClick(View view) {
            DescriptionCommonComponent.this.onSelectOccurrenceTime();
        }
    }

    class C07035 implements OnGetActivityListener {
        C07035() {
        }

        public void onGetActivity(String str, String str2, CommonDevice commonDevice) {
            DescriptionCommonComponent.this.setActivity(str, str2);
        }
    }

    class C07057 implements OnGetTimeListener {
        C07057() {
        }

        public void onGetTime(long j) {
            DescriptionCommonComponent.this.setOccurrenceTime(j);
        }
    }

    public DescriptionCommonComponent(Context context) {
        this(context, null);
    }

    public DescriptionCommonComponent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DescriptionCommonComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.probabilityIndex = -1;
        this.alertDialog = new AtomicBoolean(false);
        this.onDismissListener = new C06991();
        this.occurrenceTime = -1;
        init();
    }

    private void init() {
        View.inflate(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_description_common_component", ResUtil.TYPE_LAYOUT), this);
        initView();
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionCommonComponent.init] is called");
    }

    private void getDefaultActivity() {
        String c = C2515k.m12549c();
        String d = C2515k.m12552d();
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionCommonComponent.getDefaultActivity] activityId:" + c + ",activityName:" + d);
        setActivity(c, d);
    }

    private void initView() {
        this.activityLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_layout", "id"));
        this.probabilityLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_layout", "id"));
        this.occurrenceLayout = (ViewGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_layout", "id"));
        this.tvActivity = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_text", "id"));
        this.tvProbability = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_text", "id"));
        this.tvOccurrence = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_text", "id"));
        this.tvActivityTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_title", "id"));
        this.tvProbabilityTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_title", "id"));
        this.tvOccurrenceTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_title", "id"));
        this.tvSummaryTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_summary_title", "id"));
        this.etSummary = (EditText) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_summary_text", "id"));
        this.tvActivityTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_activity_title", ResUtil.TYPE_STRING))));
        this.tvProbabilityTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability_title", ResUtil.TYPE_STRING))));
        this.tvOccurrenceTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_occurrence_title", ResUtil.TYPE_STRING))));
        this.tvSummaryTitle.setText(Html.fromHtml(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_summary_title", ResUtil.TYPE_STRING))));
        this.activityLayout.setOnClickListener(new C07002());
        this.probabilityLayout.setOnClickListener(new C07013());
        this.occurrenceLayout.setOnClickListener(new C07024());
    }

    protected void onSelectActivity() {
        showActivityAlertDialog();
    }

    protected void onSelectProbability() {
        showProbabilityAlertDialog();
    }

    protected void onSelectOccurrenceTime() {
        showTimeAlertDialog();
    }

    protected void showActivityAlertDialog() {
        if (!this.alertDialog.get()) {
            this.alertDialog.set(true);
            ActivityDialog activityDialog = new ActivityDialog(this.mContext, new C07035(), this.onDismissListener);
        }
    }

    public void setActivity(String str, String str2) {
        this.activityId = str;
        this.activityName = str2;
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionCommonComponent.setActivity] activityId:" + str + ",activityName:" + str2);
        this.tvActivity.setText(str2);
    }

    protected void setDefaultActivity(String str, String str2) {
        C2515k.m12548b(str);
        C2515k.m12551c(str2);
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionCommonComponent.setDefaultActivity] activityId:" + str + ",activityName:" + str2);
    }

    protected void showProbabilityAlertDialog() {
        if (!this.alertDialog.get()) {
            this.alertDialog.set(true);
            ListAdapter arrayAdapter = new ArrayAdapter(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_item_spinner_text", ResUtil.TYPE_LAYOUT), this.mContext.getResources().getStringArray(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability", ResUtil.TYPE_ARRAY)));
            View inflate = LayoutInflater.from(this.mContext).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_dialog_spinner_text", ResUtil.TYPE_LAYOUT), null);
            ListView listView = (ListView) inflate.findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_dialog_spinner_list_view", "id"));
            listView.setAdapter(arrayAdapter);
            final AlertDialog create = new Builder(this.mContext).create();
            create.show();
            create.getWindow().setContentView(inflate);
            create.setOnDismissListener(this.onDismissListener);
            listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    DescriptionCommonComponent.this.setProbabilityIndex(i);
                    create.dismiss();
                }
            });
        }
    }

    public void setProbabilityIndex(int i) {
        String[] stringArray = this.mContext.getResources().getStringArray(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_probability", ResUtil.TYPE_ARRAY));
        if (i >= 0 && i < stringArray.length) {
            this.probabilityIndex = i;
            this.tvProbability.setText(stringArray[i]);
        }
    }

    protected void showTimeAlertDialog() {
        if (!this.alertDialog.get()) {
            this.alertDialog.set(true);
            TimeDialog timeDialog = new TimeDialog(this.mContext, new C07057(), this.onDismissListener);
        }
    }

    public void setOccurrenceTime(long j) {
        this.occurrenceTime = j;
        C2511g.m12481b("BETACLUB_SDK", "[DescriptionCommonComponent.setOccurrenceTime]" + j);
        if (j == -1) {
            this.tvOccurrence.setText("");
        } else {
            this.tvOccurrence.setText(DateTimeUtils.getDateTimeStrWithMillSec(j));
        }
    }

    public boolean checkInput() {
        return false;
    }

    public boolean checkSendAvailable() {
        if (StringUtils.isNullOrEmpty(this.activityId) || StringUtils.isNullOrEmpty(this.activityName)) {
            ToastUtil.showShortToast(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_null_activity", ResUtil.TYPE_STRING));
            return false;
        } else if (StringUtils.isNullOrEmpty(getProbabilityText())) {
            ToastUtil.showShortToast(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_null_probability", ResUtil.TYPE_STRING));
            return false;
        } else if (this.occurrenceTime == -1) {
            ToastUtil.showShortToast(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_null_occurrence", ResUtil.TYPE_STRING));
            return false;
        } else if (!StringUtils.isNullOrEmpty(getSummary())) {
            return true;
        } else {
            ToastUtil.showShortToast(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_null_description", ResUtil.TYPE_STRING));
            return false;
        }
    }

    public String getProbabilityText() {
        return (String) DescriptionParas.recure.get(this.probabilityIndex);
    }

    public String getSummary() {
        return this.etSummary.getText().toString();
    }

    public void onDestroy() {
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(R.string.sdk_crowdtest_description_brief_title));
        stringBuilder.append(getSummary());
        stringBuilder.append(this.mContext.getString(R.string.sdk_crowdtest_description_old_detail_title));
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public String getOccurrenceTimeTextFormat() {
        return SdfConstants.getDateTime(this.occurrenceTime);
    }

    public String getOccurrenceTimeZone() {
        return TimeZone.getDefault().getID();
    }

    public int getProbabilityIndex() {
        return this.probabilityIndex;
    }

    public long getOccurrenceTime() {
        return this.occurrenceTime;
    }

    public boolean etSummaryIsFocused() {
        if (this.etSummary == null) {
            return false;
        }
        return this.etSummary.isFocused();
    }
}
