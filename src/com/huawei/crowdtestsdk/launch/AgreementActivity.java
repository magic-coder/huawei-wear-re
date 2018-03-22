package com.huawei.crowdtestsdk.launch;

import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.feedback.BaseActivity;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;

public class AgreementActivity extends BaseActivity {
    TextView futPolicyView;

    protected void initLayout() {
        setContentView(R.layout.sdk_crowdtest_activity_agreement);
    }

    protected void initView() {
        this.futPolicyView = (TextView) findViewById(R.id.sdk_crowdtest_fut_policy_view);
        initBetaPolicyContent();
    }

    protected void setTitle() {
        setTitle(R.string.sdk_crowdtest_launch_beta_user_license_agreement);
    }

    private void initBetaPolicyContent() {
        String str;
        if (getResources().getConfiguration().locale.getLanguage().endsWith(PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH)) {
            str = "userAgreementZh";
        } else {
            str = "userAgreementUs";
        }
        this.futPolicyView.setText(Html.fromHtml(FileUtils.getContentFromAssets(this, "html/" + str + ".html")));
        this.futPolicyView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
