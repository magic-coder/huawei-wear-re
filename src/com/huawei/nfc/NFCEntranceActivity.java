package com.huawei.nfc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import com.huawei.cp3.widget.p382a.p383a.C4371b;
import com.huawei.nfc.carrera.logic.cardinfo.impl.NFCOpenLogic;
import com.huawei.nfc.carrera.ui.bus.detail.BuscardDetailActivity;
import com.huawei.nfc.carrera.ui.carddetail.CardInfoDetailActivity;
import com.huawei.nfc.carrera.ui.cardlist.AddBankOrBusCardActivity;
import com.huawei.nfc.carrera.ui.cardlist.listener.EnableNFCListener;
import com.huawei.nfc.carrera.ui.nullifycard.NullifyVerifyPasswordActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.wallet.R;

public class NFCEntranceActivity extends Activity implements EnableNFCListener {
    public static final String CARD_PACKAGE_JUMP_TO_ADD_CARD_ACTION = "com.huawei.nfc.intent.action.NFC_ADD_CARD";
    public static final String CARD_PACKAGE_JUMP_TO_CARD__DETAIL_ACTION = "com.huawei.nfc.intent.action.NFC_ENTER_CARD_DETAIL";
    public static final String OPEN_NFC_SETTING_ACTION = "com.huawei.nfc.intent.action.OPEN_NFC_SETTING";
    public static final String OTO_JUMP_TO_SWIPE_ACTION = "com.huawei.nfc.intent.action.NFC_SWIPE";
    private Intent intent;
    private int openNFCTimes = 0;
    private C4371b progress;

    class C55181 implements OnClickListener {
        C55181() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            LogX.i("cancel to openNFC");
            NFCEntranceActivity.this.stopProgress();
            ToastManager.show(NFCEntranceActivity.this, R.string.nfc_card_list_cancel_tip);
            NFCEntranceActivity.this.finish();
        }
    }

    class C55192 implements OnClickListener {
        C55192() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            NFCEntranceActivity.this.startProgress(NFCEntranceActivity.this.getString(R.string.nfc_open_swipe_setting));
            NFCOpenLogic.getInstance(NFCEntranceActivity.this).setAutoOpenNFC();
            NFCOpenLogic.getInstance(NFCEntranceActivity.this).openNFCEnvironment(NFCEntranceActivity.this);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        requestWindowFeature(1);
        initAction();
    }

    private void initAction() {
        this.intent = getIntent();
        if (this.intent == null || StringUtil.isEmpty(this.intent.getAction(), true)) {
            finish();
        } else {
            jumpByAction();
        }
    }

    private void jumpByAction() {
        String action = this.intent.getAction();
        if (OTO_JUMP_TO_SWIPE_ACTION.equals(action)) {
            preparJumpToSwipeactivity();
        } else if (CARD_PACKAGE_JUMP_TO_ADD_CARD_ACTION.equals(action)) {
            preparjumpToAddcardActivity();
        } else if (CARD_PACKAGE_JUMP_TO_CARD__DETAIL_ACTION.equals(action)) {
            preparjumpToCardDetaiActivity();
        } else if (OPEN_NFC_SETTING_ACTION.equals(action)) {
            finish();
        }
    }

    private void preparjumpToCardDetaiActivity() {
        Bundle bundleExtra = this.intent.getBundleExtra("CARD_INFO");
        if (bundleExtra == null) {
            LogX.e(" preparjumpToCardDetaiActivity  fail  ");
            finish();
            return;
        }
        int i = bundleExtra.getInt(NullifyVerifyPasswordActivity.CARD_GROUP_TYPE);
        String string = bundleExtra.getString("issuerId");
        String string2 = bundleExtra.getString("productId");
        String string3 = bundleExtra.getString(CardInfoDetailActivity.REFERENCE_ID);
        if (2 == i) {
            LogX.i("preparjumpToCardDetaiActivity : jump to traffic card detail activity");
            if (StringUtil.isEmpty(string, true) || StringUtil.isEmpty(string2, true)) {
                finish();
            } else {
                jumpToTrafficCardDetailActivity(string, string2);
            }
        } else if (StringUtil.isEmpty(string, true) || StringUtil.isEmpty(string3, true)) {
            finish();
        } else {
            jumpToBankCardDetailActivity(string, string3);
        }
    }

    private void preparjumpToAddcardActivity() {
        jumpToAddcardActivity();
    }

    private void preparJumpToSwipeactivity() {
    }

    private void jumpToTrafficCardDetailActivity(String str, String str2) {
        Intent intent = new Intent(this, BuscardDetailActivity.class);
        intent.putExtra(BuscardDetailActivity.EXTRA_KEY_CARD_ISSUERID, str);
        intent.putExtra(BuscardDetailActivity.EXTRA_KEY_CARD_PRODUCTD, str2);
        startActivity(intent);
        finish();
    }

    private void jumpToBankCardDetailActivity(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("issuerId", str);
        intent.putExtra(CardInfoDetailActivity.REFERENCE_ID, str2);
        intent.setClass(this, CardInfoDetailActivity.class);
        startActivity(intent);
        finish();
    }

    private void jumpToAddcardActivity() {
        startActivity(new Intent(this, AddBankOrBusCardActivity.class));
        finish();
    }

    protected void onResume() {
        super.onResume();
        LogX.i("NFCEntranceActivity  onResume.");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogX.i("NFCEntanceActivity requestCode = " + i + ", resultCode = " + i2, false);
        if (i != 0) {
            return;
        }
        if (i2 == 0) {
            ToastManager.show((Context) this, R.string.nfc_card_list_cancel_tip);
            finish();
        } else if (i2 == -1) {
            enableNFCSuccess();
        } else {
            enableNFCFailed();
        }
    }

    public boolean checkNFC() {
        if (NfcUtil.isSupportNFCSwipe(this)) {
            return true;
        }
        NFCOpenLogic.getInstance(this).registEnableListener(this);
        if (NFCOpenLogic.getInstance(this).isAutoOpenNFC()) {
            startProgress(getString(R.string.nfc_open_swipe_setting));
            NFCOpenLogic.getInstance(this).openNFCEnvironment(this);
        } else {
            showOpenNFCDialog();
        }
        return false;
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
        }
    }

    private void showOpenNFCDialog() {
        LogX.i("showOpenNFCDialog");
        C4370a a = C4372a.m20997a((Context) this);
        a.setTitle(R.string.nfc_card_list_dialog_title);
        a.setCancelable(false);
        a.mo4431b(getString(R.string.nfc_open_swipe_setting_dialogTip));
        a.mo4425a(R.string.nfc_ok, new C55192()).mo4429b(R.string.nfc_cancel, new C55181());
        a.setCanceledOnTouchOutside(false);
        a.show();
    }

    public void dealDefaultPay() {
        stopProgress();
    }

    public void enableNFCFailed() {
        stopProgress();
        if (this.openNFCTimes == 2) {
            ToastManager.show((Context) this, R.string.nfc_card_list_cancel_tip);
            finish();
            return;
        }
        showOpenNFCDialog();
        this.openNFCTimes++;
    }

    public void enableNFCSuccess() {
        stopProgress();
        initAction();
    }

    protected void onDestroy() {
        super.onDestroy();
        LogX.i("NFCEntranceActivity  onDestroy");
        NFCOpenLogic.getInstance(this).unRegistEnableListener(this);
    }

    protected void onPause() {
        LogX.i("NFCEntranceActivity  onPause");
        super.onPause();
    }

    protected void onStop() {
        LogX.i("NFCEntranceActivity  onStop");
        super.onStop();
    }
}
