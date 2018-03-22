package com.huawei.crowdtestsdk.widgets;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.launch.AgreementActivity;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.uploadlog.p188c.C2511g;

public class LineClickableSpan extends ClickableSpan {
    Context mContext = null;
    int mStrId;

    public LineClickableSpan(Context context, int i) {
        this.mContext = context;
        this.mStrId = i;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.mContext.getResources().getColor(R.color.sdk_crowdtest_background_color_blue));
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        showInfo(this.mStrId);
    }

    private void showInfo(int i) {
        C2511g.m12481b("BETACLUB_SDK", "[LineClickableSpan.showInfo] is called! id is " + i);
        Intent intent;
        if (i == R.string.sdk_crowdtest_launch_huawei_privacy_policy) {
            try {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.HuaweiPrivacyPolicyActivity"));
                intent.setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                this.mContext.startActivity(intent);
            } catch (Exception e) {
                C2511g.m12481b("BETACLUB_SDK", "[LineClickableSpan.showInfo] " + e);
            }
        } else if (i == R.string.sdk_crowdtest_launch_beta_user_license_agreement) {
            try {
                intent = new Intent(this.mContext, AgreementActivity.class);
                intent.setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                this.mContext.startActivity(intent);
            } catch (Exception e2) {
                C2511g.m12481b("BETACLUB_SDK", "[LineClickableSpan.showInfo] " + e2);
            }
        } else {
            C2511g.m12481b("BETACLUB_SDK", "[LineClickableSpan.showInfo] is called! id not match!");
        }
    }
}
