package com.huawei.crowdtestsdk.feedback;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.history.BetaIssueListFragment;
import com.huawei.crowdtestsdk.history.IssueListFragment;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.Iterator;

public class ProjectActivity extends BaseTableWidgetActivity {
    private String projectId;
    private String projectName;
    private BroadcastReceiver updateReceiver = new C06921();

    class C06921 extends BroadcastReceiver {
        C06921() {
        }

        public void onReceive(Context context, Intent intent) {
            ArrayList fragmentList = ProjectActivity.this.getFragmentList();
            if (fragmentList != null) {
                Iterator it = fragmentList.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    if (fragment instanceof IssueListFragment) {
                        ((IssueListFragment) fragment).updateIssueList();
                    }
                }
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2511g.m12481b("BETACLUB_SDK", "[ProjectActivity.onCreate] is called!");
        registerReceiver(this.updateReceiver, new IntentFilter(SdkConstants.UPDATE_ISSUE_LIST), SdkConstants.USE_CROWDTESTSDK_PERMISSION, null);
    }

    protected void getFragmentData() {
        if (getIntent() != null) {
            this.projectId = getIntent().getStringExtra("projectId");
            this.projectName = getIntent().getStringExtra("projectName");
            if (StringUtils.isNullOrEmpty(this.projectId) && StringUtils.isNullOrEmpty(this.projectName)) {
                finish();
            }
            C2511g.m12481b("BETACLUB_SDK", "[ProjectActivity.initData]projectId:" + this.projectId + ",projectName:" + this.projectName);
            addFragment(BetaIssueListFragment.newInstance(this.projectId));
        }
    }

    protected void setTitle() {
        setTitleImageAndText(R.drawable.sdk_crowdtest_titlebar_history_project, this.projectName);
    }

    protected void onDestroy() {
        try {
            unregisterReceiver(this.updateReceiver);
        } catch (Throwable e) {
            C2511g.m12479a("BETACLUB_SDK", "[ProjectActivity.onDestroy]UnregisterReceiver Error", e);
        }
        super.onDestroy();
    }
}
