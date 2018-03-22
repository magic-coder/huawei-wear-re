package com.huawei.crowdtestsdk.history;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.huawei.crowdtestsdk.feedback.BaseActivity;
import com.huawei.crowdtestsdk.feedback.ui.TitleBarLayout;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;

public class HistoryActivity extends BaseActivity {
    protected void initLayout() {
        C2511g.m12481b("BETACLUB_SDK", "[HistoryActivity.initLayout] is called!");
        setContentView(ResUtil.getResId(this, "sdk_crowdtest_layout_activity_history", ResUtil.TYPE_LAYOUT));
    }

    protected void initView() {
    }

    private void getFragmentData() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(ResUtil.getResId(this, "sdk_crowdtest_history_project_list_container", "id"), new ProjectListFragment());
        beginTransaction.commit();
    }

    protected void setTitle() {
        this.mTitleBarLayout = (TitleBarLayout) findViewById(ResUtil.getResId(this, "sdk_crowdtest_record_title_bar_layout", "id"));
        initTitleBar(ResUtil.getResId(this, "sdk_crowdtest_icon_feedback_record_pressed", ResUtil.TYPE_DRAWABLE), ResUtil.getResId(this, "sdk_crowdtest_text_feedback_record_title", ResUtil.TYPE_STRING));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentData();
    }
}
