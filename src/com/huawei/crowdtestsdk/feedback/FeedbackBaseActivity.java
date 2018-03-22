package com.huawei.crowdtestsdk.feedback;

import android.os.Bundle;

public abstract class FeedbackBaseActivity extends BaseActivity {
    public static final String COMPLAIN_FEEDBACK_ACTIVITY_ID = "8062";

    protected abstract void bindFeedbackService();

    protected abstract void unBindFeedbackService();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initEnv();
    }

    protected void initEnv() {
        bindFeedbackService();
    }

    protected void onDestroy() {
        unBindFeedbackService();
        super.onDestroy();
    }
}
