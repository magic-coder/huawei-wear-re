package com.huawei.crowdtestsdk.launch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.crowdtestsdk.R;
import com.huawei.crowdtestsdk.feedback.BaseActivity;
import com.huawei.crowdtestsdk.home.HomeActivity;
import com.huawei.crowdtestsdk.home.LoginManager;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.crowdtestsdk.utils.ActivityManagerUtils;
import com.huawei.crowdtestsdk.widgets.LineClickableSpan;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import com.huawei.uploadlog.p188c.C2514j;
import com.huawei.uploadlog.p188c.C2516l;

public class TermsAndConditionsActivity extends BaseActivity {
    public static final int AGREEMENT_VERSION = 1;
    private final int MODE_AGREE = 1;
    private final int MODE_REFUSE = 2;
    private Bundle bundle;
    private Context context;
    private int launchMode = 1;
    TextView launchPolicyAgreement;
    TextView launchPolicyWords;
    TextView signAgreementTime;
    Button userAgreeAndLoginButton;
    Button userRefuseButton;

    class C07861 implements OnClickListener {
        C07861() {
        }

        public void onClick(View view) {
            TermsAndConditionsActivity.this.onAgreeAndFeedback();
        }
    }

    class C07872 implements OnClickListener {
        C07872() {
        }

        public void onClick(View view) {
            TermsAndConditionsActivity.this.onRefuse();
        }
    }

    class C07883 implements Runnable {
        C07883() {
        }

        public void run() {
            C2511g.m12481b("BETACLUB_SDK", "[TermsAndConditionsActivity.uploadUserAgreement] update Beta agreement result is :" + HttpBetaAccess.getInstance().updateBetaUserAgreement(true));
        }
    }

    class C07894 implements DialogInterface.OnClickListener {
        C07894() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    @SuppressLint({"ParcelCreator"})
    class MyParcelable implements Parcelable {
        MyParcelable() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }
    }

    protected void initLayout() {
        setContentView(R.layout.sdk_crowdtest_activity_terms_conditions);
    }

    protected void initView() {
        this.launchPolicyWords = (TextView) findViewById(R.id.sdk_crowdtest_launch_policy_words);
        this.launchPolicyAgreement = (TextView) findViewById(R.id.sdk_crowdtest_launch_policy_agreement);
        this.signAgreementTime = (TextView) findViewById(R.id.sdk_crowdtest_sign_agreement_time);
        this.userAgreeAndLoginButton = (Button) findViewById(R.id.sdk_crowdtest_user_agree_and_login_button);
        this.userRefuseButton = (Button) findViewById(R.id.sdk_crowdtest_user_refuse_button);
        this.userAgreeAndLoginButton.setOnClickListener(new C07861());
        this.userRefuseButton.setOnClickListener(new C07872());
    }

    protected void setTitle() {
    }

    protected void onCreate(Bundle bundle) {
        C2511g.m12481b("BETACLUB_SDK", "[TermsAndConditionsActivity.onCreate]is called!");
        super.onCreate(bundle);
        getData(getIntent());
        initData();
        initDiffView();
        showContent();
    }

    private void getData(Intent intent) {
        C2511g.m12481b("BETACLUB_SDK", "[TermsAndConditionsActivity.getData] is called!");
        if (intent == null) {
            C2511g.m12481b("BETACLUB_SDK", "TermsAndConditionsActivity get intent is null");
            return;
        }
        this.bundle = intent.getExtras();
        if (this.bundle == null) {
            C2511g.m12483c("BETACLUB_SDK", "[TermsAndConditionsActivity.getIntentDate] bundle is null!");
        }
    }

    private void initDiffView() {
        if (LoginManager.getInstance().isLoggedIn() && C2514j.m12537k()) {
            turnToNextPage();
        } else {
            C2511g.m12484d("BETACLUB_SDK", "[TermsAndConditionsActivity.initDiffView]is logged in:" + LoginManager.getInstance().isLoggedIn());
        }
    }

    private void initData() {
        this.context = this;
    }

    private void showContent() {
        C2511g.m12481b("BETACLUB_SDK", "[TermsAndConditionsActivity.showContent] is called!");
        String string = getString(R.string.sdk_crowdtest_launch_policy_words_agreement);
        if (this.launchMode == 2) {
            string = getString(R.string.sdk_crowdtest_launch_policy_words_agreement_refuse);
        }
        String string2 = getString(R.string.sdk_crowdtest_agree_with_beta_protocol);
        if (this.launchMode == 1) {
            string2 = getString(R.string.sdk_crowdtest_agree_user_license_agreement);
        } else if (this.launchMode == 2) {
            string2 = getString(R.string.sdk_crowdtest_refuse_user_license_agreement);
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(String.format(string, new Object[]{string2, getString(R.string.sdk_crowdtest_launch_beta_user_license_agreement), getString(R.string.sdk_crowdtest_launch_huawei_privacy_policy)}));
        LineClickableSpan lineClickableSpan = new LineClickableSpan(this, R.string.sdk_crowdtest_launch_beta_user_license_agreement);
        LineClickableSpan lineClickableSpan2 = new LineClickableSpan(this, R.string.sdk_crowdtest_launch_huawei_privacy_policy);
        int[] iArr = new int[]{string.indexOf(r2), string.indexOf(r3)};
        spannableStringBuilder.setSpan(lineClickableSpan, iArr[0], r2.length() + iArr[0], 17);
        spannableStringBuilder.setSpan(lineClickableSpan2, iArr[1], iArr[1] + r3.length(), 17);
        this.launchPolicyWords.setText(Html.fromHtml(FileUtils.getContentFromAssets(this, "html/userAgreement.html")));
        this.launchPolicyWords.setMovementMethod(LinkMovementMethod.getInstance());
        this.launchPolicyAgreement.setText(spannableStringBuilder);
        this.launchPolicyAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        setTitle(R.string.sdk_crowdtest_launch_user_license_title);
        if (this.launchMode == 1) {
            this.signAgreementTime.setVisibility(8);
            this.userAgreeAndLoginButton.setVisibility(0);
            this.userRefuseButton.setVisibility(0);
        } else if (this.launchMode == 2) {
            this.signAgreementTime.setVisibility(0);
            this.userAgreeAndLoginButton.setVisibility(8);
            this.userRefuseButton.setVisibility(0);
        }
    }

    public void onAgreeAndFeedback() {
        C2511g.m12481b("BETACLUB_SDK", "[TermsAndConditionsActivity.onAgreeAndFeedback]is called!");
        if (this.launchMode == 1) {
            uploadUserAgreement();
            C2514j.m12513a(this.context, true);
            C2516l.m12554a();
            C2514j.m12510a((Context) this, 1);
            turnToNextPage();
        }
    }

    private void uploadUserAgreement() {
        C2511g.m12481b("BETACLUB_SDK", "[TermsAndConditionsActivity.uploadUserAgreement] is called!");
        new Thread(new C07883()).start();
    }

    protected void turnToNextPage() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtras(this.bundle);
        startActivity(intent);
        finish();
    }

    public void onRefuse() {
        C2511g.m12481b("BETACLUB_SDK", "[TermsAndConditionsActivity.onRefuse] is called!");
        switch (this.launchMode) {
            case 1:
                ActivityManagerUtils.getInstance().finishAllActivity();
                return;
            case 2:
                showConfirmationDialog();
                return;
            default:
                return;
        }
    }

    private void showConfirmationDialog() {
        C2513i.m12495a((Context) this, R.string.sdk_crowdtest_refuse_user_license_agreement_hint, new C07894());
    }
}
