package com.huawei.crowdtestsdk.feedback.description.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.huawei.crowdtestsdk.feedback.widgets.ChoiceWidgets;
import com.huawei.crowdtestsdk.utils.ResUtil;

public class DescriptionLastVersionExistsComponent extends LinearLayout {
    private ChoiceWidgets choiceWidgets;

    public DescriptionLastVersionExistsComponent(Context context) {
        this(context, null);
    }

    public DescriptionLastVersionExistsComponent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DescriptionLastVersionExistsComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(ResUtil.getResId(this.mContext, "sdk_crowdtest_layout_description_last_version_exists_component", ResUtil.TYPE_LAYOUT), this);
        initView();
    }

    private void initView() {
        this.choiceWidgets = (ChoiceWidgets) findViewById(ResUtil.getResId(this.mContext, "sdk_crowdtest_description_last_version_choice_widget", "id"));
        this.choiceWidgets.setTitle(this.mContext.getString(ResUtil.getResId(this.mContext, "sdk_crowdtest_wifi_option_last_version_exists_title", ResUtil.TYPE_STRING)));
        this.choiceWidgets.addOption(ResUtil.getResId(this.mContext, "sdk_crowdtest_wifi_option_last_version_exists", ResUtil.TYPE_ARRAY));
    }

    public String getLastVersionExistsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.choiceWidgets.getString());
        return stringBuilder.toString();
    }

    public boolean checkInput() {
        return this.choiceWidgets.checkInput();
    }

    public boolean checkSendAvailable() {
        if (this.choiceWidgets.checkInput()) {
            return true;
        }
        Toast.makeText(this.mContext, ResUtil.getResId(this.mContext, "sdk_crowdtest_description_null_last_version", ResUtil.TYPE_STRING), 0).show();
        return false;
    }

    public void onDestroy() {
    }
}
