package com.huawei.nfc.carrera.ui.nullifycard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4371b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.UninstallTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.NullifyCardResultCallback;
import com.huawei.nfc.carrera.ui.bindcard.VerifySmsCodeActivity;
import com.huawei.nfc.carrera.ui.nullifycard.fragment.NullifyVerifyFpPasswordFragment;
import com.huawei.nfc.carrera.ui.verifypassword.VerifyPasswordActivity;
import com.huawei.nfc.carrera.ui.verifypassword.fragment.VerifyFpPasswordFragment;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFingerPrintResultListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;

public class NullifyVerifyPasswordActivity extends VerifyPasswordActivity implements QueryBankCardInfoCallback, QueryTrafficCardInfoCallback, UninstallTrafficCardCallback, NullifyCardResultCallback {
    public static final String CARD_GROUP_TYPE = "cardGroup";
    public static final String CARD_NAME = "cardName";
    public static final String ISSURE_ID = "issuerId";
    public static final String REF_ID = "refId";
    private static final String TAG = "NullifyVerifyPasswordActivity";
    private BankCardInfo mBankCardInfo;
    private int mCardGroupType;
    private ImageView mCardInfoLayout;
    private TextView mCardNumTextView;
    private String mIssureId;
    private String mRefId;
    private TrafficCardInfo mTrafficCardInfo;
    private C4371b progress;
    private String title;

    protected void onCreate(Bundle bundle) {
        LogX.i("VerifyPasswordActivity onCreate.");
        setRequestedOrientation(1);
        super.onCreate(bundle);
        if (initParams()) {
            setTitle(this.title);
            setContentView(R.layout.nfc_nullifyverifypassword_activity);
            initView();
            if (this.mCardGroupType == 1) {
                LogicApiFactory.createCardManager(getApplicationContext()).queryBankCardInfo(this.mRefId, this);
            } else if (this.mCardGroupType == 2) {
                LogicApiFactory.createCardManager(getApplicationContext()).queryTrafficCardInfo(this.mIssureId, 0, "", this);
            }
            initVerifyFpView();
            return;
        }
        finish();
    }

    private void initView() {
        this.mCardInfoLayout = (ImageView) findViewById(R.id.card_container_imageview);
        this.mCardNumTextView = (TextView) findViewById(R.id.card_num_info);
        setContainer((FrameLayout) findViewById(R.id.fragment_container_bottom));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            LayoutParams layoutParams = (LayoutParams) this.mCardInfoLayout.getLayoutParams();
            layoutParams.height = (int) (((double) this.mCardInfoLayout.getWidth()) / 1.6d);
            this.mCardInfoLayout.setLayoutParams(layoutParams);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e(TAG, "bundle is null.");
            return false;
        }
        this.title = extras.getString("cardName");
        this.mRefId = extras.getString("refId");
        this.mIssureId = extras.getString("issuerId");
        this.mCardGroupType = extras.getInt(CARD_GROUP_TYPE);
        if (!StringUtil.isEmpty(this.title, true) && (!StringUtil.isEmpty(this.mRefId, true) || !StringUtil.isEmpty(this.mIssureId, true))) {
            return true;
        }
        LogX.e(TAG, "params is illegal.");
        return false;
    }

    protected VerifyFpPasswordFragment getVerifyFpPasswordFragment(boolean z, VerifyFingerPrintResultListener verifyFingerPrintResultListener) {
        return new NullifyVerifyFpPasswordFragment(z, verifyFingerPrintResultListener);
    }

    protected void toNextStep() {
        if (this.mCardGroupType == 1) {
            int mode = this.mBankCardInfo.getMode();
            if (mode == -1) {
                showToast(R.string.nfc_detail_nullify_card_entrance_others_fail);
            } else if (11 == mode) {
                LogX.d(TAG, "CITIC Nullify Card");
                toNullifyCardActivity(mode);
            } else {
                startProgress(getString(R.string.nfc_nullify_card_nullifying));
                LogicApiFactory.createCardOperateApi(getApplicationContext()).nullifyCard(this.mRefId, mode, null, this);
            }
        } else if (this.mCardGroupType == 2) {
            startProgress(getString(R.string.nfc_card_deleting));
            LogicApiFactory.createCardOperateApi(getApplicationContext()).uninstallTrafficCard(this.mIssureId, this);
        }
    }

    private void toNullifyCardActivity(int i) {
        Intent intent = new Intent(this, NullifyCardActivity.class);
        intent.putExtra("refId", this.mRefId);
        intent.putExtra(VerifySmsCodeActivity.ISSUER_MODE, i);
        startActivity(intent);
        finish();
    }

    public void nullifyResultCallback(int i) {
        stopProgress();
        switch (i) {
            case -6:
                showToast(R.string.nfc_detail_nullify_card_entrance_smscode_overtime);
                break;
            case -5:
                showToast(R.string.nfc_detail_nullify_card_entrance_smscode_unmatch);
                break;
            case -4:
                showToast(R.string.nfc_bindcard_error_connection_failed);
                break;
            case -3:
                showToast(R.string.nfc_card_instruction_delete_desc_new);
                break;
            case 0:
                LogX.d("nullifyResultCallback: Delete card success,go to NFC HomeFragment.");
                showToast(R.string.nfc_detail_nullify_card_entrance_success);
                Intent intent = new Intent();
                intent.setClass(this, CardHolderActivity.class);
                intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                intent.setPackage(getPackageName());
                startActivity(intent);
                break;
            default:
                showToast(R.string.nfc_detail_nullify_card_entrance_others_fail);
                break;
        }
        finish();
    }

    private void startProgress(String str) {
        if (this.progress == null || !this.progress.isShowing()) {
            this.progress = C4372a.m21001b(this);
            this.progress.mo4438a(0);
            this.progress.mo4439a((CharSequence) str);
            this.progress.setCanceledOnTouchOutside(false);
            this.progress.show();
        }
    }

    private void stopProgress() {
        if (this.progress != null && this.progress.isShowing()) {
            this.progress.dismiss();
            this.progress = null;
        }
    }

    private void bindViews() {
        if (this.mCardGroupType == 1) {
            this.mCardInfoLayout.setImageBitmap(this.mBankCardInfo.cardIcon);
            this.mCardNumTextView.setText(getString(R.string.nfc_card_num_show, new Object[]{this.mBankCardInfo.getFpanFour()}));
            if (Constant.ZX_PRODUCT_ID.equals(this.mBankCardInfo.getProductId())) {
                this.mCardNumTextView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.mCardNumTextView.setTextColor(-1);
            }
        } else if (this.mCardGroupType == 2) {
            this.mCardInfoLayout.setImageBitmap(this.mTrafficCardInfo.getCardIcon());
            this.mCardNumTextView.setVisibility(8);
        }
    }

    public void queryBankCardInfoCallback(int i, BankCardInfo bankCardInfo) {
        if (i == 0 && bankCardInfo != null) {
            this.mBankCardInfo = bankCardInfo;
            bindViews();
        }
    }

    public void queryTrafficCardInfoCallback(int i, TrafficCardInfo trafficCardInfo) {
        if (i == 0 && trafficCardInfo != null) {
            this.mTrafficCardInfo = trafficCardInfo;
            bindViews();
        }
    }

    public void reSwipeFingerPrint(boolean z) {
        initVerifyFpView();
    }

    public void uninstallTrafficCardCallback(int i) {
        stopProgress();
        switch (i) {
            case 0:
                LogX.d("uninstallTrafficCardCallback: Delete card success,go to NFC HomeFragment.");
                showToast(R.string.nfc_card_delete_done);
                Intent intent = new Intent();
                intent.setClass(this, CardHolderActivity.class);
                intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
                intent.setPackage(getPackageName());
                startActivity(intent);
                break;
            case 11:
                showToast(R.string.error_no_network_failed);
                break;
            case 25:
                showToast(R.string.nfc_bindcard_error_connection_failed);
                break;
            default:
                showToast(R.string.nfc_card_delete_fail);
                break;
        }
        finish();
    }
}
