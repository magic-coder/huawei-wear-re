package com.huawei.crowdtestsdk.feedback.widgets;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.utils.ComponentUtils;
import com.huawei.crowdtestsdk.utils.ResUtil;

public class ChoiceWidgets extends LinearLayout {
    private Context mContext;
    private RadioGroup rgChoiceOption;
    private TextView tvChoiceTitle;

    public ChoiceWidgets(Context context) {
        this(context, null);
    }

    public ChoiceWidgets(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoiceWidgets(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_description_choice_widget", ResUtil.TYPE_LAYOUT), this);
        initView();
    }

    private void initView() {
        this.tvChoiceTitle = (TextView) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_choice_widget_title", "id"));
        this.rgChoiceOption = (RadioGroup) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_choice_widget_option", "id"));
    }

    public void setTitle(String str) {
        this.tvChoiceTitle.setText(Html.fromHtml(str));
    }

    public void setTitle(int i) {
        this.tvChoiceTitle.setText(Html.fromHtml(this.mContext.getString(i)));
    }

    public String getTitle() {
        return this.tvChoiceTitle.getText().toString();
    }

    public void addOption(String[] strArr) {
        if (strArr != null) {
            for (CharSequence charSequence : strArr) {
                RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mContext).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_item_option", ResUtil.TYPE_LAYOUT), null);
                radioButton.setLayoutParams(new LayoutParams(-1, -2));
                radioButton.setText(charSequence);
                this.rgChoiceOption.addView(radioButton);
            }
        }
    }

    public void addOption(int i) {
        String[] stringArray = this.mContext.getResources().getStringArray(i);
        if (stringArray != null) {
            for (CharSequence charSequence : stringArray) {
                RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mContext).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_item_option", ResUtil.TYPE_LAYOUT), null);
                radioButton.setLayoutParams(new LayoutParams(-1, -2));
                radioButton.setText(charSequence);
                this.rgChoiceOption.addView(radioButton);
            }
        }
    }

    public String getString() {
        if (this.rgChoiceOption.getCheckedRadioButtonId() == -1) {
            return null;
        }
        String str = (String) ((RadioButton) this.rgChoiceOption.getChildAt(this.rgChoiceOption.indexOfChild(this.rgChoiceOption.findViewById(this.rgChoiceOption.getCheckedRadioButtonId())))).getText();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SdkConstants.DESCRIPTION_SEPARATOR).append("\n");
        stringBuilder.append(this.tvChoiceTitle.getText());
        stringBuilder.append(":").append(str).append("\n");
        return stringBuilder.toString();
    }

    public void parseString(String str) {
        String parseValue = ComponentUtils.parseValue(getTitle(), str);
        if (!StringUtils.isNullOrEmpty(parseValue)) {
            for (int i = 0; i < this.rgChoiceOption.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) this.rgChoiceOption.getChildAt(i);
                if (radioButton.getText().equals(parseValue)) {
                    radioButton.toggle();
                }
            }
        }
    }

    public boolean checkInput() {
        if (this.rgChoiceOption.getCheckedRadioButtonId() == -1) {
            return false;
        }
        return true;
    }
}
