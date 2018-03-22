package com.huawei.nfc.carrera.ui.bindcard;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardoperate.response.NullifyCardResultCallback;
import com.huawei.nfc.carrera.server.card.model.CaptureMethod;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p473a.p476b.C5587b;
import com.huawei.pay.p473a.p476b.C5720a;
import com.huawei.ui.commonui.dialog.C6004c;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.wallet.R;
import com.huawei.wallet.logic.cardidentify.CardCameraIdentifyHelper;
import com.huawei.wallet.logic.cardidentify.CardIdentifyInfo;
import com.huawei.wallet.logic.cardidentify.ICardIdentifyCallBack;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;

public class CardLockScreenActivity extends NFCBaseActivity implements OnClickListener, NullifyCardResultCallback {
    private static final int CARDINFO_MASSAGE_DELETE_LOAD = 5;
    private static final int CARDINFO_MASSAGE_DISMSS_LOAD = 2;
    private static final int CARDINFO_MASSAGE_REFRESH_VIEW = 3;
    private static final int HANDLER_MASSAGE_SHOW_BACK_ACTIVITY = 7;
    private static final int HANDLER_MASSAGE_SHOW_LODING = 1;
    private static final int HANDLER_MASSAGE_SHOW_SETLOCK_DIALOG = 6;
    private static final int HANDLER_MASSAGE_SHOW_UNLOCK_DIALOG = 4;
    private static final int LOCK_SCREEN = 1;
    private static final int LOCK_SCREEN_NORMAL_STATE = 0;
    private static final int LOCK_SCREEN_NOT_SET_OR_NOT_ACTIVE = 2;
    private static final int LOCK_SCREEN_UNENABLE_LOCK = 3;
    private static final int LOCK_SCREEN_UNENABLE_NOT_ACTIVE = 4;
    private static final String REQUEST_WATCH_TO_SET_THE_ACTIVE = "com.huawei.bone.ActiveAdminScreen";
    private static final String REQUEST_WATCH_TO_SET_THE_LOCK_SCREEN = "com.huawei.bone.UnlockScreen";
    private static final String REQUEST_WATCH_TO_SET_THE_LOCK_SCREEN_PASSWORD = "com.huawei.bone.LockPassword";
    private static final String TAG = "CardLockScreenActivity";
    private String fromPage = "";
    private boolean isStatusNotChange = false;
    private LinearLayout mCardLockScreenContentLly;
    private LinearLayout mCardLockScreenMultiContentLly;
    private Context mContext;
    private CustomAlertDialog mCustomDlg = null;
    private String mDialogMsg = "";
    private String mDialogRightBtnMsg = "";
    private Handler mHandler = new C55823();
    private TextView mLockScreenTv;
    private ImageView mLockScreeniImageV;
    private int mMode = -1;
    private Button mNextButton;
    private ai mNoTitleDlg = null;
    private String mReferenceId = "";
    private Button mSetLockScreenButton;
    private ImageView mSetLockScreeniImageV;

    class C55801 implements Runnable {
        C55801() {
        }

        public void run() {
            CardLockScreenActivity.this.mHandler.sendEmptyMessage(1);
            C2538c.b(CardLockScreenActivity.TAG, new Object[]{" jumpToActivity 前 status  : " + CardLockScreenActivity.this.mLockscreenStatus});
            if (CardLockScreenActivity.this.mLockscreenStatus == -1) {
                CardLockScreenActivity.this.isStatusNotChange = true;
            } else if (CardLockScreenActivity.this.mLockscreenStatus != CardLockScreenActivity.this.pluginPayAdapter.getLockscreenStatus()) {
                CardLockScreenActivity.this.isStatusNotChange = false;
            } else {
                CardLockScreenActivity.this.isStatusNotChange = true;
            }
            CardLockScreenActivity.this.mLockscreenStatus = CardLockScreenActivity.this.pluginPayAdapter.getLockscreenStatus();
            CardLockScreenActivity.this.mHandler.sendEmptyMessage(2);
            if (CardLockScreenActivity.this.mLockscreenStatus == 0) {
                CardLockScreenActivity.this.mHandler.sendEmptyMessage(7);
            } else if (CardLockScreenActivity.this.mLockscreenStatus == 1) {
                CardLockScreenActivity.this.mHandler.sendEmptyMessage(3);
                if (!CardLockScreenActivity.this.isStatusNotChange) {
                    return;
                }
                if (NFCBaseActivity.ADD_CARD_ACTIVITY.equals(CardLockScreenActivity.this.fromPage) || NFCBaseActivity.BIND_CARD_ACTIVITY.equals(CardLockScreenActivity.this.fromPage)) {
                    CardLockScreenActivity.this.mHandler.sendEmptyMessage(4);
                } else {
                    CardLockScreenActivity.this.mHandler.sendEmptyMessage(6);
                }
            } else if (CardLockScreenActivity.this.mLockscreenStatus == 2) {
                CardLockScreenActivity.this.mHandler.sendEmptyMessage(3);
                if (CardLockScreenActivity.this.isStatusNotChange) {
                    CardLockScreenActivity.this.mHandler.sendEmptyMessage(6);
                }
            } else if (CardLockScreenActivity.this.mLockscreenStatus == 3) {
                CardLockScreenActivity.this.mHandler.sendEmptyMessage(3);
                if (CardLockScreenActivity.this.isStatusNotChange) {
                    CardLockScreenActivity.this.mHandler.sendEmptyMessage(6);
                }
            } else if (CardLockScreenActivity.this.mLockscreenStatus == 4) {
                CardLockScreenActivity.this.mHandler.sendEmptyMessage(3);
                if (CardLockScreenActivity.this.isStatusNotChange) {
                    CardLockScreenActivity.this.mHandler.sendEmptyMessage(4);
                }
            }
        }
    }

    class C55812 implements Runnable {
        C55812() {
        }

        public void run() {
            CardLockScreenActivity.this.mHandler.sendEmptyMessage(1);
            CardLockScreenActivity.this.mLockscreenStatus = CardLockScreenActivity.this.pluginPayAdapter.getLockscreenStatus();
            CardLockScreenActivity.this.mHandler.sendEmptyMessage(2);
            C2538c.b(CardLockScreenActivity.TAG, new Object[]{" refreshStatus lockscreenstatus : " + CardLockScreenActivity.this.mLockscreenStatus});
            if (CardLockScreenActivity.this.mLockscreenStatus != 0) {
                CardLockScreenActivity.this.mHandler.sendEmptyMessage(3);
                CardLockScreenActivity.this.setWatchLockscreen(CardLockScreenActivity.this.getWatchLockscreen(CardLockScreenActivity.this.mLockscreenStatus));
            }
        }
    }

    class C55823 extends Handler {
        C55823() {
        }

        public void dispatchMessage(Message message) {
            if (1 == message.what) {
                CardLockScreenActivity.this.showLoadingDialog(R.string.huaweipay_loading);
            } else if (2 == message.what) {
                CardLockScreenActivity.this.destroyLoadingDialog();
            } else if (3 == message.what) {
                CardLockScreenActivity.this.refreshLockView(CardLockScreenActivity.this.mLockscreenStatus);
            } else if (4 == message.what) {
                CardLockScreenActivity.this.showDialogSetlock();
            } else if (5 == message.what) {
                CardLockScreenActivity.this.showLoadingDialog(R.string.nfc_nullify_card_nullifying);
            } else if (6 == message.what) {
                CardLockScreenActivity.this.showDialogUnlock(CardLockScreenActivity.this.mDialogMsg);
            } else if (7 == message.what) {
                CardLockScreenActivity.this.backActivity();
            }
        }
    }

    class C55834 implements DialogInterface.OnClickListener {
        C55834() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            CardLockScreenActivity.this.mCustomDlg.dismiss();
            CardLockScreenActivity.this.refreshStatus();
        }
    }

    class C55845 implements DialogInterface.OnClickListener {
        C55845() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            CardLockScreenActivity.this.mCustomDlg.dismiss();
            CardLockScreenActivity.this.mCustomDlg = null;
        }
    }

    class C55856 implements OnClickListener {
        C55856() {
        }

        public void onClick(View view) {
            CardLockScreenActivity.this.mNoTitleDlg.dismiss();
            CardLockScreenActivity.this.refreshStatus();
        }
    }

    class C55867 implements OnClickListener {
        C55867() {
        }

        public void onClick(View view) {
            CardLockScreenActivity.this.mNoTitleDlg.dismiss();
            CardLockScreenActivity.this.mNoTitleDlg = null;
        }
    }

    class C55888 implements C5587b {
        C55888() {
        }

        public void onRequestPermissionsResult(int[] iArr) {
            C2538c.b(CardLockScreenActivity.TAG, new Object[]{"onRequestPermissionsResult "});
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                C2538c.b(CardLockScreenActivity.TAG, new Object[]{"no CAMERA permission start Camera"});
                return;
            }
            CardLockScreenActivity.this.goToBankCardCaptureActivity();
            CardLockScreenActivity.this.finish();
        }
    }

    class C55899 implements ICardIdentifyCallBack {
        C55899() {
        }

        public void onIndetify(CardIdentifyInfo cardIdentifyInfo) {
            C2538c.b(CardLockScreenActivity.TAG, new Object[]{"goToBankCardCaptureActivity onIndetify"});
            if (cardIdentifyInfo != null) {
                C2538c.b(CardLockScreenActivity.TAG, new Object[]{"onIndetify cardIdentifyInfo in not null"});
                CardLockScreenActivity.this.goToInputCardNumActivity(cardIdentifyInfo);
            }
        }

        public void onSwitch2Input() {
            C2538c.b(CardLockScreenActivity.TAG, new Object[]{"goToBankCardCaptureActivity onSwitch2Input"});
            CardLockScreenActivity.this.goToInputCardNumActivity(null);
        }

        public void onCardBackPressed() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R.layout.act_lock_screen);
        this.mContext = this;
        this.mLockScreenTv = (TextView) findViewById(R.id.card_lock_screen_tip_tv);
        this.mSetLockScreenButton = (Button) findViewById(R.id.go_to_set_card_lock_screen_tv);
        this.mNextButton = (Button) findViewById(R.id.card_lock_screen_next_button);
        this.mLockScreeniImageV = (ImageView) findViewById(R.id.card_lock_screen_imageView);
        this.mSetLockScreeniImageV = (ImageView) findViewById(R.id.card_set_lock_screen_imageView);
        this.mCardLockScreenContentLly = (LinearLayout) findViewById(R.id.card_lock_screen_content_lly);
        this.mCardLockScreenMultiContentLly = (LinearLayout) findViewById(R.id.card_lock_screen_multi_content_lly);
        this.mNextButton.setOnClickListener(this);
        this.mSetLockScreenButton.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            C2538c.b(TAG, new Object[]{"bundle is null "});
            finish();
            return;
        }
        this.mMode = extras.getInt(NFCBaseActivity.BANKCARDMODE);
        this.fromPage = extras.getString(NFCBaseActivity.FROM_ADD_CARD_PAGE);
        this.mReferenceId = extras.getString(NFCBaseActivity.BANKCARREFERENCEID);
        int i = extras.getInt(NFCBaseActivity.LOCKSCREENSTATUS, -1);
        this.mLockscreenStatus = i;
        C2538c.b(TAG, new Object[]{" LockscreenStatus : " + i + " ; fromPage : " + this.fromPage});
        refreshLockView(i);
        setWatchLockscreen(getWatchLockscreen(i));
    }

    private void refreshLockView(int i) {
        C2538c.b(TAG, new Object[]{" refreshLockView : " + i});
        if (i == 1) {
            if (NFCBaseActivity.ADD_CARD_ACTIVITY.equals(this.fromPage) || NFCBaseActivity.BIND_CARD_ACTIVITY.equals(this.fromPage)) {
                this.mDialogRightBtnMsg = getString(R.string.nfc_bt_lock_setting);
                this.mCardLockScreenMultiContentLly.setVisibility(0);
                this.mCardLockScreenContentLly.setVisibility(8);
                this.mSetLockScreenButton.setText(getString(R.string.nfc_bt_lock_goto_setting));
                this.mNextButton.setText(getString(R.string.nfc_bt_lock_finish_setting));
                this.mLockScreeniImageV.setVisibility(8);
                this.mSetLockScreeniImageV.setVisibility(0);
                showHead(R.string.nfc_bt_lock_unlocked_and_activity);
            } else if (NFCBaseActivity.DETAIL_CARD_ACTIVITY.equals(this.fromPage)) {
                this.mDialogMsg = getString(R.string.nfc_bt_lock_unlocked_screen_meaasge);
                this.mDialogRightBtnMsg = getString(R.string.nfc_bt_lock_unlocked);
                this.mCardLockScreenMultiContentLly.setVisibility(8);
                this.mCardLockScreenContentLly.setVisibility(0);
                this.mLockScreenTv.setText(R.string.nfc_bt_lock_unlocked_screen_meaasge);
                this.mSetLockScreenButton.setText(getString(R.string.nfc_bt_lock_goto_unlocked));
                this.mNextButton.setText(getString(R.string.nfc_bt_lock_finish_unlocked));
                this.mLockScreeniImageV.setVisibility(0);
                this.mSetLockScreeniImageV.setVisibility(8);
                showHead(R.string.nfc_bt_lock_unlocked_watch);
            }
        } else if (i == 2) {
            this.mDialogMsg = getString(R.string.nfc_bt_lock_nfc_bt_lock_cannot_next_unlocked_password);
            this.mDialogRightBtnMsg = getString(R.string.nfc_bt_lock_setting);
            this.mCardLockScreenMultiContentLly.setVisibility(8);
            this.mCardLockScreenContentLly.setVisibility(0);
            this.mLockScreenTv.setText(R.string.nfc_bt_lock_add_card_unlocked_password);
            this.mLockScreeniImageV.setVisibility(8);
            this.mSetLockScreeniImageV.setVisibility(0);
            this.mNextButton.setText(getString(R.string.nfc_bt_lock_finish_setting));
            this.mSetLockScreenButton.setText(getString(R.string.nfc_bt_lock_goto_setting));
            showHead(R.string.nfc_bt_lock_screen_password);
        } else if (i == 3) {
            if (NFCBaseActivity.ADD_CARD_ACTIVITY.equals(this.fromPage) || NFCBaseActivity.BIND_CARD_ACTIVITY.equals(this.fromPage)) {
                this.mLockScreenTv.setText(R.string.nfc_bt_lock_add_card_unlocked);
                this.mDialogMsg = getString(R.string.nfc_bt_lock_cannot_next_message);
                this.mCardLockScreenMultiContentLly.setVisibility(8);
                this.mCardLockScreenContentLly.setVisibility(0);
            } else if (NFCBaseActivity.DETAIL_CARD_ACTIVITY.equals(this.fromPage)) {
                this.mLockScreenTv.setText(R.string.nfc_bt_lock_unlocked_screen_meaasge);
                this.mDialogMsg = getString(R.string.nfc_bt_lock_unlocked_screen_meaasge);
                this.mCardLockScreenMultiContentLly.setVisibility(8);
                this.mCardLockScreenContentLly.setVisibility(0);
            }
            this.mNextButton.setText(getString(R.string.nfc_bt_lock_finish_unlocked));
            this.mSetLockScreenButton.setText(getString(R.string.nfc_bt_lock_goto_unlocked));
            this.mDialogRightBtnMsg = getString(R.string.nfc_bt_lock_unlocked);
            this.mLockScreeniImageV.setVisibility(0);
            this.mSetLockScreeniImageV.setVisibility(8);
            showHead(R.string.nfc_bt_lock_unlocked_watch);
        } else if (i == 4) {
            this.mCardLockScreenMultiContentLly.setVisibility(8);
            this.mCardLockScreenContentLly.setVisibility(0);
            this.mDialogMsg = getString(R.string.nfc_bt_lock_open_huawei_wallet);
            this.mDialogRightBtnMsg = getString(R.string.nfc_bt_lock_set_activity);
            this.mLockScreenTv.setText(R.string.nfc_bt_lock_add_card_condition);
            this.mLockScreeniImageV.setVisibility(8);
            this.mSetLockScreeniImageV.setVisibility(0);
            this.mNextButton.setText(getString(R.string.nfc_bt_lock_finish_activity));
            this.mSetLockScreenButton.setText(getString(R.string.nfc_bt_lock_goto_activity));
            showHead(R.string.nfc_bt_lock_activity_administrator);
        }
    }

    private String getWatchLockscreen(int i) {
        String str = "";
        if (i == 1) {
            return REQUEST_WATCH_TO_SET_THE_LOCK_SCREEN;
        }
        if (i == 2) {
            return REQUEST_WATCH_TO_SET_THE_LOCK_SCREEN_PASSWORD;
        }
        if (i == 3) {
            return REQUEST_WATCH_TO_SET_THE_LOCK_SCREEN;
        }
        if (i == 4) {
            return REQUEST_WATCH_TO_SET_THE_ACTIVE;
        }
        return str;
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.go_to_set_card_lock_screen_tv) {
            refreshStatus();
        } else if (id == R.id.card_lock_screen_next_button) {
            jumpToActivity();
        }
    }

    private void jumpToActivity() {
        new Thread(new C55801()).start();
    }

    private void refreshStatus() {
        new Thread(new C55812()).start();
    }

    private void backActivity() {
        if (NFCBaseActivity.ADD_CARD_ACTIVITY.equals(this.fromPage)) {
            skipToBankCardCaptureActivity();
        } else if (NFCBaseActivity.DETAIL_CARD_ACTIVITY.equals(this.fromPage)) {
            toDeleteCard();
        } else {
            setResult(-1, new Intent());
            finish();
        }
    }

    private void showDialogSetlock() {
        if (this.mCustomDlg == null || !this.mCustomDlg.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.act_lock_screen_setlock_dialog, null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.act_lock_screen_dialog_lly);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.act_lock_screen_dialog_multi_content_lly);
            ((TextView) inflate.findViewById(R.id.act_lock_screen_dialog_tv)).setText(this.mDialogMsg);
            if (this.mLockscreenStatus == 1) {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
            } else {
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
            }
            C6004c a = new C6004c(this.mContext).m27536a(R.string.nfc_bt_lock_cannot_next).m27543b(R.string.hwpay_dialog_no, new C55845()).m27539a(this.mDialogRightBtnMsg, new C55834());
            this.mCustomDlg = a.m27535a();
            a.m27538a(inflate);
            this.mCustomDlg.setCancelable(false);
            if (!this.mCustomDlg.isShowing() && !isFinishing()) {
                this.mCustomDlg.show();
                return;
            }
            return;
        }
        C2538c.b(TAG, new Object[]{"showDialogSetlock Already show!"});
    }

    private void showDialogUnlock(String str) {
        if (this.mNoTitleDlg == null || !this.mNoTitleDlg.isShowing()) {
            this.mNoTitleDlg = new ak(this.mContext).m27513a(str).m27516b(R.string.hwpay_dialog_no, new C55867()).m27515a(this.mDialogRightBtnMsg, new C55856()).m27510a();
            this.mNoTitleDlg.setCancelable(false);
            if (!this.mNoTitleDlg.isShowing()) {
                this.mNoTitleDlg.show();
                return;
            }
            return;
        }
        C2538c.b(TAG, new Object[]{"showDialogUnlock Already show!"});
    }

    private void skipToBankCardCaptureActivity() {
        C5720a.m26366a().m26370a(this.mContext);
        C5720a.m26366a().m26371a(new C55888(), (Activity) this, "android.permission.CAMERA");
    }

    private void goToBankCardCaptureActivity() {
        C2538c.b(TAG, new Object[]{"goToBankCardCaptureActivity", Boolean.valueOf(false)});
        new CardCameraIdentifyHelper().m27968a(this, new C55899());
    }

    private void goToInputCardNumActivity(CardIdentifyInfo cardIdentifyInfo) {
        CaptureMethod.setCameraMode();
        Intent intent = new Intent();
        if (cardIdentifyInfo != null) {
            intent.putExtra(InputCardNumActivity.INTENT_KEY_CARD_NUM, cardIdentifyInfo.m27969a());
            intent.putExtra(InputCardNumActivity.INTENT_KRY_CARD_IMG, cardIdentifyInfo.m27972b());
        }
        intent.setClass(this, InputCardNumActivity.class);
        startActivity(intent);
    }

    protected void toDeleteCard() {
        if (this.mMode != -1) {
            this.mHandler.sendEmptyMessage(5);
            LogicApiFactory.createCardOperateApi(getApplicationContext()).nullifyCard(this.mReferenceId, this.mMode, null, this);
            return;
        }
        showToast(R.string.nfc_detail_nullify_card_entrance_others_fail);
    }

    public void nullifyResultCallback(int i) {
        this.mHandler.sendEmptyMessage(2);
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
                C2538c.b(TAG, new Object[]{"nullifyResultCallback: Delete card success,go to NFC HomeFragment."});
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
}
