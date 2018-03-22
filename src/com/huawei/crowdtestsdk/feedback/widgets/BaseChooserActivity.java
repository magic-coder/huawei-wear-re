package com.huawei.crowdtestsdk.feedback.widgets;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.crowdtestsdk.utils.ActivityManagerUtils;

public class BaseChooserActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManagerUtils.getInstance().addActivity(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ActivityManagerUtils.getInstance().removeActivity(this);
    }
}
