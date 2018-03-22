package com.huawei.crowdtestsdk.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.bases.FeedbackParams;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.utils.ActivityManagerUtils;
import com.huawei.uploadlog.p188c.C2511g;

public class HomeActivity extends FragmentActivity {
    private String appVersionName = "";
    private FeedbackParams feedbackParam;

    protected void initLayout() {
        setContentView(R.layout.sdk_crowdtest_activity_home);
    }

    protected void onCreate(Bundle bundle) {
        C2511g.m12481b("BETACLUB_SDK", "[HomeActivity.onCreate] is called!");
        super.onCreate(bundle);
        requestWindowFeature(1);
        ActivityManagerUtils.getInstance().addActivity(this);
        if (!LoginManager.getInstance().isLoggedIn()) {
            C2511g.m12481b("BETACLUB_SDK", "[HomeActivity.onCreate] user is not login!");
            finish();
        }
        getIntentData();
        initLayout();
        getFragmentData();
    }

    private void getIntentData() {
        C2511g.m12481b("BETACLUB_SDK", "HomeActivity getIntentData is called!");
        Intent intent = getIntent();
        if (intent == null) {
            C2511g.m12481b("BETACLUB_SDK", "HomeActivity get intent is null");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.feedbackParam = (FeedbackParams) extras.getParcelable(SdkConstants.FEEDBACK_PARAMS);
            this.appVersionName = extras.getString(SdkConstants.APP_VERSION_NAME);
            return;
        }
        C2511g.m12481b("BETACLUB_SDK", "[HomeActivity.getIntentDate] bundle is null!");
    }

    public void getFragmentData() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.sdk_crowdtest_issue_type_container, new FeedbackFragment());
        beginTransaction.commit();
    }

    public FeedbackParams getFeedbackParam() {
        return this.feedbackParam;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    protected void onDestroy() {
        super.onDestroy();
        ActivityManagerUtils.getInstance().removeActivity(this);
    }
}
