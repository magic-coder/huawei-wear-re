package com.huawei.nfc.carrera.ui.swipe;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.cp3.widget.a;
import com.huawei.cp3.widget.a.a.b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.CardInfoManagerApi;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryPayableCardCallback;
import com.huawei.nfc.carrera.logic.cardinfo.impl.NFCOpenLogic;
import com.huawei.nfc.carrera.logic.cardinfo.model.CardListItem;
import com.huawei.nfc.carrera.logic.swipe.SwipeLogicManager;
import com.huawei.nfc.carrera.ui.cardlist.listener.EnableNFCListener;
import com.huawei.nfc.carrera.ui.swipe.fragment.SwipeVerifyFpPasswordFragment;
import com.huawei.nfc.carrera.ui.swipe.fragment.TransactionDoneFragment;
import com.huawei.nfc.carrera.ui.swipe.fragment.TransactionFailedFragment;
import com.huawei.nfc.carrera.ui.swipe.fragment.TransactionTimeoutFragment;
import com.huawei.nfc.carrera.ui.swipe.fragment.WaitingTransactionFragment;
import com.huawei.nfc.carrera.ui.swipe.listener.NeedReswipeListener;
import com.huawei.nfc.carrera.ui.swipe.listener.SwipeResultListener;
import com.huawei.nfc.carrera.ui.verifypassword.VerifyPasswordActivity;
import com.huawei.nfc.carrera.ui.verifypassword.fragment.VerifyFpPasswordFragment;
import com.huawei.nfc.carrera.ui.verifypassword.listener.VerifyFingerPrintResultListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.nfc.util.NFCFragmentUtil;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.List;

public class SwipeActivity extends VerifyPasswordActivity implements QueryPayableCardCallback, EnableNFCListener, NeedReswipeListener, SwipeResultListener {
    private static final int FINISH_ACTIVITY = 29;
    private static final int FINISH_DELAY = 1000;
    private static final String FRAGMENT_TAG_TRANSACTION_DONE = "transaction_done";
    private static final String FRAGMENT_TAG_TRANSACTION_FAILED = "transaction_failed";
    private static final String FRAGMENT_TAG_TRANSACTION_TIMEOUT = "transaction_timeout";
    private static final String FRAGMENT_TAG_WAITING_SWIPE = "waiting_swipe";
    private static final int REFRESH_PAYLIST = 10;
    private static final int REFRESH_SWIPELIST = 11;
    private CardInfoManagerApi cardInfoManagerApi;
    private TextView cardTip;
    private RelativeLayout cardTipRelative;
    @SuppressLint({"HandlerLeak"})
    Handler handler = new 2(this);
    private boolean isAccountRight = true;
    private volatile boolean isHasFocus;
    private boolean isNeedReswipe = true;
    private volatile boolean isScanPayMode = false;
    boolean isSupportNFC = false;
    private boolean isVerifyByFinger;
    private final List<CardListItem> listItems = new ArrayList();
    private TextView noScanPayTip;
    private int openNFCTimes = 0;
    private TextView payText;
    private b progress;
    private int screenHeight = 0;
    private int screenWidth = 0;
    private ScrollView scrollView;
    private SwipeListController swipeListController = null;
    private SwipeLogicManager swipeLogicManager = null;
    private long swipeStartTime = 0;
    private TransactionDoneFragment transactionDoneFragment;
    private TransactionFailedFragment transactionFailedFragment;
    private TransactionTimeoutFragment transactionTimeoutFragment;
    private WaitingTransactionFragment waitingTransactionFragment;

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(null);
        LogX.m5475i("SwipeActivity onCreate.taskid=" + String.valueOf(getTaskId()));
        setTitle(R.string.nfc_swipe_title);
        setTranslucentStatus();
        setContentView(R.layout.swipe_activity_new);
        initParam();
        initView();
    }

    @SuppressLint({"NewApi"})
    protected void setTranslucentStatus() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        if (VERSION.SDK_INT >= 19) {
            getWindow().setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS, HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            getWindow().setFlags(HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        }
    }

    private void initParam() {
        this.swipeStartTime = System.currentTimeMillis();
        this.swipeLogicManager = SwipeLogicManager.getInstance(this);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.screenHeight = displayMetrics.heightPixels;
        this.screenWidth = displayMetrics.widthPixels;
        this.isScanPayMode = QuickPayUtil.SCAN_ACTION.equals(getIntent().getAction());
        this.isSupportNFC = NFCFragmentUtil.getNFCShowPlan(this) == 2;
        LogX.m5475i("isSupportNFC :  " + this.isSupportNFC);
        LogX.m5475i("isNeedReswipe :  " + this.isNeedReswipe);
    }

    private void initView() {
        awakenScreen();
        this.scrollView = (ScrollView) findViewById(R.id.swipe_scroll);
        initTextViews();
        initCardListView();
    }

    private void initTextViews() {
        this.payText = (TextView) findViewById(R.id.swipe_paytext);
        this.noScanPayTip = (TextView) findViewById(R.id.swipe_no_scan);
        this.cardTip = (TextView) findViewById(R.id.swipe_card_tip);
        this.cardTipRelative = (RelativeLayout) findViewById(R.id.swipe_card_tip_relative);
        this.scrollView.setVisibility(0);
        this.payText.setVisibility(0);
        this.noScanPayTip.setVisibility(8);
        this.cardTip.setVisibility(8);
        this.cardTipRelative.setVisibility(8);
    }

    private void initCardListView() {
        if (this.swipeListController == null) {
            this.swipeListController = new SwipeListController(this, this.swipeLogicManager);
        }
        if (this.isNeedReswipe) {
            if (this.isSupportNFC) {
                this.handler.sendEmptyMessage(10);
            } else {
                this.handler.sendEmptyMessage(11);
            }
            this.isNeedReswipe = false;
        }
        LogX.m5475i("is ScanPayMode is:  " + this.isScanPayMode);
    }

    private void updateOrInitCardList() {
        if (this.isScanPayMode) {
            startProgress(getString(R.string.nfc_loading));
            this.swipeLogicManager.queryPayment(new 1(this));
            return;
        }
        refreshNFCListView();
    }

    private void refreshScanPayListView(List<String> list) {
        if (this.listItems.size() == 0) {
            if (!this.isSupportNFC) {
                this.payText.setVisibility(8);
                if (list == null || list.isEmpty()) {
                    showNoScanPayTextView();
                }
            } else if (this.isAccountRight) {
                showCardTip(getString(R.string.nfc_card_novisiblecard_tip));
            }
        }
        this.swipeListController.refreshScanPayListView(this.listItems, list);
    }

    private void refreshNFCListView() {
        if (this.listItems.size() == 0) {
            showCardTip(getString(R.string.nfc_card_novisiblecard_tip));
            return;
        }
        this.swipeListController.refreshNFCCardListView(this.listItems);
        this.scrollView.setVisibility(0);
    }

    public void checkAndStartNewSwipe() {
        initVerifyFpView();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogX.m5475i("SwipeActivity onNewIntent taskid=" + String.valueOf(getTaskId()));
        setIntent(intent);
        awakenScreen();
    }

    protected void onStart() {
        super.onStart();
        LogX.m5475i("SwipeActivity onStart. taskid=" + String.valueOf(getTaskId()));
    }

    protected void onResume() {
        super.onResume();
        LogX.m5475i("SwipeActivity onResume. taskid=" + String.valueOf(getTaskId()));
        boolean isScreenOn = ((PowerManager) getSystemService("power")).isScreenOn();
        LogX.m5475i("SwipeActivity onResume, isScreenOn: " + isScreenOn + ", isKeygu: " + ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode() + " ,isFocusOn: " + this.hasFocusTag);
    }

    protected void onPause() {
        super.onPause();
        LogX.m5475i("SwipeActivity onPause. taskid=" + String.valueOf(getTaskId()));
    }

    protected void onStop() {
        super.onStop();
        LogX.m5475i("SwipeActivity onStop. taskid=" + String.valueOf(getTaskId()));
        PowerManager powerManager = (PowerManager) getSystemService("power");
        boolean isScreenOn = powerManager.isScreenOn();
        if (!powerManager.isScreenOn()) {
            getWindow().clearFlags(2621568);
        }
        LogX.m5475i("SwipeActivity onStop, isScreenOn: " + isScreenOn + ", isKeygu: " + ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode() + " ,isFocusOn: " + this.hasFocusTag);
        LogX.m5475i("isHasFocus: " + this.isHasFocus);
        if (this.isHasFocus && !QuickPayUtil.getInstance().isAppLock(this.mContext)) {
            LogX.m5465d("finish SwipeActivity now. taskid=" + String.valueOf(getTaskId()));
            QuickPayUtil.getInstance().finishMiddleActivity();
            finish();
        }
    }

    protected void onDestroy() {
        QuickPayUtil.getInstance().finishMiddleActivity();
        super.onDestroy();
        LogX.m5475i("SwipeActivity onDestroy. taskid=" + String.valueOf(getTaskId()));
        NFCOpenLogic.getInstance(this).unRegistEnableListener(this);
    }

    private void awakenScreen() {
        if (!this.isScanPayMode) {
            LogX.m5465d("awakenScreen");
            WakeLock newWakeLock = ((PowerManager) getApplicationContext().getSystemService("power")).newWakeLock(805306378, "beginWakeLock");
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(10000);
            boolean inKeyguardRestrictedInputMode = ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            LogX.m5475i("cur sreen locked: " + inKeyguardRestrictedInputMode);
            if (inKeyguardRestrictedInputMode) {
                getWindow().addFlags(2621568);
            }
        }
    }

    public void swipeResult(int i) {
        LogX.m5465d("SwipeActivity swipeResult, resultCode: " + i);
        this.swipeLogicManager.saveLastPayForm(SwipeLogicManager.NFC_PAYFORM);
        LogX.m5475i("payform is :nfc");
        List fragments = getSupportFragmentManager().getFragments();
        if (i == 0) {
            updateSwipSuccess(fragments);
        } else if (2 == i) {
            updateSwipFailed(fragments);
        } else if (1 == i) {
            CardListItem defaultCard = this.swipeListController.getDefaultCard();
            if (defaultCard == null || 2 != defaultCard.getCardGroup()) {
                updateSwipTimeOut(fragments);
            } else {
                finish();
                return;
            }
        }
        sendFinishMessage();
    }

    private void sendFinishMessage() {
        this.handler.sendEmptyMessageDelayed(29, 1000);
    }

    private void updateSwipSuccess(List<Fragment> list) {
        if (this.transactionDoneFragment == null) {
            this.transactionDoneFragment = new TransactionDoneFragment(this);
        }
        addOrShowFragment(list, this.transactionDoneFragment, FRAGMENT_TAG_TRANSACTION_DONE);
        this.swipeLogicManager.reportBIOnSwipeFinished(this.swipeListController.getDefaultCard(), this.isScanPayMode, this.swipeStartTime);
    }

    private void updateSwipFailed(List<Fragment> list) {
        if (this.transactionFailedFragment == null) {
            this.transactionFailedFragment = new TransactionFailedFragment(this);
        }
        addOrShowFragment(list, this.transactionFailedFragment, FRAGMENT_TAG_TRANSACTION_FAILED);
    }

    private void updateSwipTimeOut(List<Fragment> list) {
        if (this.transactionTimeoutFragment == null) {
            this.transactionTimeoutFragment = new TransactionTimeoutFragment(this);
        }
        addOrShowFragment(list, this.transactionTimeoutFragment, FRAGMENT_TAG_TRANSACTION_TIMEOUT);
    }

    public void needReswipe() {
    }

    protected VerifyFpPasswordFragment getVerifyFpPasswordFragment(boolean z, VerifyFingerPrintResultListener verifyFingerPrintResultListener) {
        return new SwipeVerifyFpPasswordFragment(z, verifyFingerPrintResultListener, this);
    }

    public void verifyResult(boolean z) {
        this.isVerifyByFinger = true;
        super.verifyResult(z);
    }

    protected void onPayPassVerifySuccess(String str, boolean z) {
        this.isVerifyByFinger = false;
        super.onPayPassVerifySuccess(str, z);
    }

    protected void toNextStep() {
        if (this.waitingTransactionFragment == null) {
            this.waitingTransactionFragment = new WaitingTransactionFragment(this.isVerifyByFinger, this);
        }
        this.waitingTransactionFragment.updateCardType(this.swipeListController.getDefaultCard().getCardGroup());
        addOrShowFragment(getSupportFragmentManager().getFragments(), this.waitingTransactionFragment, FRAGMENT_TAG_WAITING_SWIPE);
    }

    private void showNoScanPayTextView() {
        this.scrollView.setVisibility(8);
        this.cardTip.setVisibility(8);
        this.cardTipRelative.setVisibility(8);
        this.noScanPayTip.setVisibility(0);
        this.noScanPayTip.setY((float) (((double) this.screenHeight) * 0.3d));
        LogX.m5475i("no enable payment and show NoScanPayTextView");
    }

    public void queryPayableCardCallback(List<CardListItem> list) {
        LogX.m5475i("queryPayableCardInfos end");
        this.listItems.clear();
        this.listItems.addAll(list);
        this.handler.sendEmptyMessage(11);
    }

    public void queryPayableError(int i) {
        this.isAccountRight = false;
        String str = "";
        if (i == 1) {
            str = getString(R.string.nfc_scanpay_no_login);
        } else {
            str = getString(R.string.nfc_support_cards_account_unmatch);
            if (this.isScanPayMode) {
                this.handler.sendEmptyMessage(11);
            }
        }
        showCardTip(str);
    }

    private void showCardTip(String str) {
        this.payText.setVisibility(0);
        this.noScanPayTip.setVisibility(8);
        this.cardTip.setText(str);
        this.cardTip.setVisibility(0);
        this.cardTipRelative.setVisibility(0);
        int dimension = (int) (((double) (this.screenWidth - (((int) this.mContext.getResources().getDimension(R.dimen.nfc_cardlist_leftorright_margin)) * 2))) / 1.6d);
        LayoutParams layoutParams = (LayoutParams) this.cardTipRelative.getLayoutParams();
        layoutParams.height = dimension;
        this.cardTipRelative.setLayoutParams(layoutParams);
        LogX.m5475i("showCardTip is:  " + str);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            return;
        }
        if (i2 == 0) {
            ToastManager.show(this, R.string.nfc_card_list_cancel_tip);
            finish();
        } else if (i2 == -1) {
            enableNFCSuccess();
        } else {
            enableNFCFailed();
        }
    }

    private void checkNFC() {
        if (!NfcUtil.isSupportNFCSwipe(this)) {
            NFCOpenLogic.getInstance(this).registEnableListener(this);
            if (NFCOpenLogic.getInstance(this).isAutoOpenNFC()) {
                startProgress(getString(R.string.nfc_open_swipe_setting));
                NFCOpenLogic.getInstance(this).openNFCEnvironment(this);
                return;
            }
            showOpenNFCDialog();
        }
    }

    private void startProgress(String str) {
        if (this.progress == null || !this.progress.isShowing()) {
            this.progress = a.b(this);
            this.progress.a(0);
            this.progress.a(str);
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
        LogX.m5475i("showOpenNFCDialog");
        com.huawei.cp3.widget.a.a.a a = a.a(this);
        a.setTitle(R.string.nfc_card_list_dialog_title);
        a.setCancelable(false);
        a.b(getString(R.string.nfc_open_swipe_setting_dialogTip));
        a.a(R.string.nfc_ok, new 4(this)).b(R.string.nfc_cancel, new 3(this));
        a.setCanceledOnTouchOutside(false);
        a.show();
    }

    public void dealDefaultPay() {
        stopProgress();
    }

    public void enableNFCFailed() {
        stopProgress();
        if (this.openNFCTimes == 2) {
            ToastManager.show(this, R.string.nfc_card_list_cancel_tip);
            finish();
            return;
        }
        showOpenNFCDialog();
        this.openNFCTimes++;
    }

    public void enableNFCSuccess() {
        stopProgress();
        this.handler.sendEmptyMessage(11);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        LogX.m5475i("onWindowFocusChanged: " + z);
        if (z) {
            if (this.isSupportNFC && !this.isHasFocus) {
                checkNFC();
            }
            this.isHasFocus = z;
        }
    }

    public void reSwipeFingerPrint(boolean z) {
        initVerifyFpView();
    }
}
