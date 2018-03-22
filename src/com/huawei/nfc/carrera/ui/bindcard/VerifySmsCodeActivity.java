package com.huawei.nfc.carrera.ui.bindcard;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.cardoperate.response.RequestVerifyCodeCallback;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;

public abstract class VerifySmsCodeActivity extends NFCBaseActivity implements RequestVerifyCodeCallback {
    public static final String ISSUER_MODE = "issuerMode";
    public static final String REF_ID = "refId";
    private static final int SMS_LENGTH_LIMIT = 4;
    private TextView getVerifyCodeButton;
    protected String mRefId;
    private int mode;
    private Button nextStepButton;
    private VerifyCodeTimer verifyCodeGetTimer;
    private EditText verifyCodeInputView;
    private TextView verifyPhoneNumTip;

    class C56101 implements TextWatcher {
        C56101() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (StringUtil.isEmpty(obj, true) || obj.length() < 4) {
                VerifySmsCodeActivity.this.nextStepButton.setEnabled(false);
            } else {
                VerifySmsCodeActivity.this.nextStepButton.setEnabled(true);
            }
        }
    }

    class C56112 implements OnClickListener {
        C56112() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            VerifySmsCodeActivity.this.jumpToHomeActivity();
        }
    }

    protected abstract int getButtonNameResId();

    protected abstract void getSmsCode(String str, int i);

    protected abstract int getTitleResId();

    protected abstract void verifySmsCode(String str, int i, String str2);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        if (initParams()) {
            setTitle(getTitleResId());
            setContentView(R.layout.nfc_activity_verify_sms);
            initViews();
            return;
        }
        finish();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            LogX.e("initParams intent empty.");
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e("bundle empty.");
            return false;
        }
        this.mRefId = extras.getString("refId");
        this.mode = extras.getInt(ISSUER_MODE);
        if (!StringUtil.isEmpty(this.mRefId, true) && this.mode > 0) {
            return true;
        }
        LogX.e("params is illegal.");
        return false;
    }

    private void initViews() {
        this.verifyPhoneNumTip = (TextView) findViewById(R.id.verify_phone_num_tip);
        this.verifyPhoneNumTip.setText(getString(R.string.nfc_verify_phone_tip));
        this.verifyCodeInputView = (EditText) findViewById(R.id.sms_code_input);
        this.verifyCodeInputView.addTextChangedListener(new C56101());
        this.getVerifyCodeButton = (TextView) findViewById(R.id.get_sms_code);
        this.nextStepButton = (Button) findViewById(R.id.get_sms_next_step);
        this.nextStepButton.setText(getButtonNameResId());
        if (getButtonNameColor() != -1) {
            LogX.d("getButtonNameColor() ::" + getButtonNameColor());
            this.nextStepButton.setTextColor(getResources().getColor(getButtonNameColor()));
        }
        if (C4026a.m19819a(this)) {
            startRetryCountDown();
            getSmsCode(this.mRefId, this.mode);
            return;
        }
        showToast(R.string.no_network);
    }

    protected int getButtonNameColor() {
        return -1;
    }

    protected void showVerifyNumTip(String str) {
        this.verifyPhoneNumTip.setText(getString(R.string.nfc_verify_phone_tip_content, new Object[]{str}));
        this.verifyPhoneNumTip.setVisibility(0);
    }

    public void onClickEvent(View view) {
        int id = view.getId();
        if (R.id.get_sms_code == id) {
            if (C4026a.m19819a(this)) {
                startRetryCountDown();
                getSmsCode(this.mRefId, this.mode);
                return;
            }
            showToast(R.string.no_network);
        } else if (R.id.get_sms_next_step != id) {
        } else {
            if (StringUtil.isEmpty(this.verifyCodeInputView.getText().toString(), true)) {
                showToast(R.string.nfc_input_legal_sms_code_toast);
                return;
            }
            hideSoftInputWindow(this.verifyCodeInputView);
            verifySmsCode(this.mRefId, this.mode, this.verifyCodeInputView.getText().toString());
        }
    }

    private void startRetryCountDown() {
        if (this.verifyCodeGetTimer == null) {
            this.verifyCodeGetTimer = new VerifyCodeTimer(getApplicationContext(), this.getVerifyCodeButton, this.verifyPhoneNumTip);
        }
        this.verifyCodeGetTimer.startTimer();
    }

    protected void stopRetryCountDown() {
        if (this.verifyCodeGetTimer != null) {
            this.verifyCodeGetTimer.stopTimer();
        }
    }

    public void requestResultCallback(int i, String str) {
        if (!isFinishing()) {
            LogX.d("===123=== resultCode" + i);
            switch (i) {
                case -9:
                    stopRetryCountDown();
                    showToast(R.string.nfc_bind_card_fail_contact_bank);
                    return;
                case -8:
                    stopRetryCountDown();
                    showToast(R.string.nfc_request_sms_fail_retry_later_or_contact_bank);
                    return;
                case -7:
                    stopRetryCountDown();
                    hideSoftInputWindow(this.verifyCodeInputView);
                    return;
                case -5:
                    stopRetryCountDown();
                    hideSoftInputWindow(this.verifyCodeInputView);
                    showToast(R.string.nfc_card_allready_activited);
                    finish();
                    return;
                case -4:
                    stopRetryCountDown();
                    showVerifyDialog();
                    return;
                case -3:
                    stopRetryCountDown();
                    showToast(R.string.nfc_request_sms_code_servererror);
                    return;
                case -1:
                    stopRetryCountDown();
                    showToast(R.string.nfc_request_sms_code_overcount);
                    return;
                case 0:
                    if (StringUtil.isEmpty(str, true)) {
                        this.verifyPhoneNumTip.setText(getString(R.string.nfc_verify_phone_tip_without_phone_num));
                        return;
                    } else {
                        showVerifyNumTip(str);
                        return;
                    }
                default:
                    stopRetryCountDown();
                    showToast(R.string.nfc_request_sms_code_otherreason);
                    return;
            }
        }
    }

    protected void showVerifyDialog() {
        C4370a a = C4372a.m20997a((Context) this);
        a.setTitle(R.string.nfc_card_list_dialog_title);
        a.mo4424a(R.string.nfc_detail_active_card_entrance_delete);
        a.mo4425a(R.string.nfc_ok, new C56112());
        a.setCanceledOnTouchOutside(false);
        a.show();
    }

    private void jumpToHomeActivity() {
        Intent intent = new Intent();
        intent.setClass(this, CardHolderActivity.class);
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        intent.setPackage(getPackageName());
        startActivity(intent);
        finish();
    }

    private void hideSoftInputWindow(EditText editText) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
