package com.huawei.nfc.carrera.ui.carddetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.CardInfoManagerApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;
import com.huawei.nfc.carrera.logic.cardoperate.response.NullifyCardResultCallback;
import com.huawei.nfc.carrera.logic.model.AppInfo;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.ui.bindcard.CardLockScreenActivity;
import com.huawei.nfc.carrera.ui.bindcard.DownLoadDialogActivity;
import com.huawei.nfc.carrera.ui.bindcard.VerifySmsCodeActivity;
import com.huawei.nfc.carrera.ui.nullifycard.NullifyCardActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.pay.p130e.C5730c;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.R;
import com.huawei.wallet.ui.cardholder.CardHolderActivity;
import com.huawei.wallet.utils.PackageUtil;
import java.util.List;

public class CardInfoDetailActivity extends NFCBaseActivity implements OnClickListener, QueryBankCardInfoCallback, QueryBankIssuerInfoCallback, NullifyCardResultCallback {
    private static final int CARDINFO_MASSAGE_DELETE_LOAD = 4;
    private static final int CARDINFO_MASSAGE_DISMSS_LOAD = 3;
    private static final int CARDINFO_MASSAGE_JUMP_TO_DELETE = 5;
    private static final int CARDINFO_MASSAGE_SHOW_DIALOG = 1;
    private static final int CARDINFO_MASSAGE_SHOW_LOAD = 2;
    private static int DELETE_PAGE = 999;
    private static final String DIAL_HEAD = "tel:";
    public static final String ISSUER_ID = "issuerId";
    private static final int LOCK_SCREEN = 1;
    private static final int LOCK_SCREEN_UNENABLE_LOCK = 3;
    public static final String REFERENCE_ID = "referenceId";
    private static final String TAG = "CardInfoDetailActivity";
    private TextView cardDeviceNumTextView;
    private TextView cardEntityNumTextView;
    private ImageView cardIconImageView;
    private String cardName;
    private TextView cardNameTextView;
    private TextView cardOpenTextView;
    private String contactNumber;
    private AppInfo currentAppInfo;
    private Button deleteButton;
    private AppOpenOrDownHelper helper;
    private View hotlineView;
    private boolean isDebitCard;
    private String issuerId;
    private BankCardInfo mBankCardInfo;
    private Handler mHandler = new C56424();
    private int mMode = -1;
    private String referenceId;
    private String webSite;
    private View websiteView;

    class C56391 implements OnClickListener {
        C56391() {
        }

        public void onClick(View view) {
        }
    }

    class C56402 implements OnClickListener {
        C56402() {
        }

        public void onClick(View view) {
            CardInfoDetailActivity.this.clickDeleteCard();
        }
    }

    class C56413 implements Runnable {
        C56413() {
        }

        public void run() {
            CardInfoDetailActivity.this.mHandler.sendEmptyMessage(2);
            CardInfoDetailActivity.this.mLockscreenStatus = CardInfoDetailActivity.this.pluginPayAdapter.getLockscreenStatus();
            LogX.i("checkWatchStatus mLockscreenStatus : " + CardInfoDetailActivity.this.mLockscreenStatus);
            int deviceConnectState = CardInfoDetailActivity.this.pluginPayAdapter.getDeviceConnectState();
            LogX.i("== checkWatchStatus btconnect : " + deviceConnectState);
            CardInfoDetailActivity.this.mHandler.sendEmptyMessage(3);
            if ((CardInfoDetailActivity.this.mLockscreenStatus == 1 || CardInfoDetailActivity.this.mLockscreenStatus == 3) && deviceConnectState == 2) {
                Intent intent = new Intent();
                intent.setClass(CardInfoDetailActivity.this, CardLockScreenActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(NFCBaseActivity.BANKCARDMODE, CardInfoDetailActivity.this.mMode);
                bundle.putString(NFCBaseActivity.BANKCARREFERENCEID, CardInfoDetailActivity.this.referenceId);
                bundle.putInt(NFCBaseActivity.LOCKSCREENSTATUS, CardInfoDetailActivity.this.mLockscreenStatus);
                bundle.putString(NFCBaseActivity.FROM_ADD_CARD_PAGE, "CardInfoDetailActivity");
                intent.putExtras(bundle);
                CardInfoDetailActivity.this.startActivity(intent);
                CardInfoDetailActivity.this.finish();
                return;
            }
            CardInfoDetailActivity.this.mHandler.sendEmptyMessage(5);
        }
    }

    class C56424 extends Handler {
        C56424() {
        }

        public void dispatchMessage(Message message) {
            if (1 == message.what) {
                CardInfoDetailActivity.this.showDialog();
            } else if (2 == message.what) {
                CardInfoDetailActivity.this.showLoadingDialog(R.string.huaweipay_loading);
            } else if (3 == message.what) {
                CardInfoDetailActivity.this.destroyLoadingDialog();
            } else if (4 == message.what) {
                CardInfoDetailActivity.this.showLoadingDialog(R.string.nfc_nullify_card_nullifying);
            } else if (5 == message.what) {
                CardInfoDetailActivity.this.jumpToDeleteCard();
            }
        }
    }

    class DeleteDialogNegativeListener implements DialogInterface.OnClickListener {
        DeleteDialogNegativeListener() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    class DeleteDialogOnKeyListener implements OnKeyListener {
        DeleteDialogOnKeyListener() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && 1 == keyEvent.getAction()) {
                dialogInterface.dismiss();
            }
            return true;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        if (initParams()) {
            CardInfoManagerApi createCardManager = LogicApiFactory.createCardManager(this);
            createCardManager.queryBankCardInfo(this.referenceId, this);
            createCardManager.queryBankIssuerInfo(this.issuerId, this);
            setContentView(R.layout.nfc_cardinfo_detail_layout);
            initView();
            return;
        }
        finish();
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e("bundle is null.");
            return false;
        }
        this.referenceId = extras.getString(REFERENCE_ID);
        this.issuerId = extras.getString("issuerId");
        if (!StringUtil.isEmpty(this.referenceId, true) && !StringUtil.isEmpty(this.issuerId, true)) {
            return true;
        }
        LogX.e("params is illegal.");
        return false;
    }

    @SuppressLint({"NewApi"})
    private void initView() {
        setTitle(R.string.nfc_cardlist_detail);
        this.cardIconImageView = (ImageView) findViewById(R.id.bankcard_detail_icon_iv);
        this.cardNameTextView = (TextView) findViewById(R.id.bankcard_detail_name_tv);
        this.cardOpenTextView = (TextView) findViewById(R.id.bankcard_detail_open_tv);
        this.hotlineView = findViewById(R.id.bankcard_detail_hotline_rl);
        this.websiteView = findViewById(R.id.bankcard_detail_website_rl);
        this.hotlineView.setOnClickListener(this);
        this.websiteView.setOnClickListener(this);
        this.cardEntityNumTextView = (TextView) findViewById(R.id.bankcard_detail_entity_num_tv);
        this.cardDeviceNumTextView = (TextView) findViewById(R.id.bankcard_detail_device_num_tv);
        this.deleteButton = (Button) findViewById(R.id.card_info_delete_applet);
        this.deleteButton.setOnClickListener(this);
        this.cardOpenTextView.setOnClickListener(this);
        updateLookupOrOpenShow();
        forbidClickEvent();
    }

    private void forbidClickEvent() {
        this.hotlineView.setClickable(false);
        this.websiteView.setClickable(false);
        this.deleteButton.setClickable(false);
        this.cardOpenTextView.setClickable(false);
    }

    private void allowClickEventForCard() {
        this.deleteButton.setClickable(true);
    }

    private void allowClickEventForIssuer() {
        this.hotlineView.setClickable(true);
        this.websiteView.setClickable(true);
        this.cardOpenTextView.setClickable(true);
    }

    private void updateLookupOrOpenShow() {
        if (this.currentAppInfo != null) {
            Object issuerAppPkg = this.currentAppInfo.getIssuerAppPkg();
            if (!TextUtils.isEmpty(issuerAppPkg)) {
                if (PackageUtil.m28463b(this, issuerAppPkg)) {
                    this.cardOpenTextView.setText(R.string.hwpay_open);
                } else {
                    this.cardOpenTextView.setText(R.string.hwpay_lookup);
                }
            }
        }
    }

    protected void onResume() {
        super.onResume();
        updateLookupOrOpenShow();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.id.card_info_delete_applet == id) {
            this.mHandler.sendEmptyMessage(1);
        } else if (R.id.bankcard_detail_website_rl == id) {
            goIntoWebsite();
        } else if (R.id.bankcard_detail_hotline_rl == id) {
            callServicePhone();
        } else if (R.id.bankcard_detail_open_tv == id) {
            startOpenOrDownload();
        }
    }

    private void showDialog() {
        C2538c.b("CardInfoDetailActivity", new Object[]{"checkAccount showDialog"});
        C6024w c6024w = new C6024w(this.mContext);
        c6024w.m27591a(R.string.nfc_card_not_available_to_use_delete_card);
        c6024w.m27596b(R.string.nfc_delete_bankcard_dialog_message);
        c6024w.m27593a(R.string.nfc_ok, new C56402()).m27597b(R.string.nfc_cancel, new C56391());
        C6022u a = c6024w.m27590a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    private void goIntoWebsite() {
        if (!TextUtils.isEmpty(this.webSite)) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.webSite));
                startActivity(intent);
            } catch (Throwable e) {
                LogX.e("CardInfoDetailActivity goIntoWebsite:", e, false);
            }
        }
    }

    private void startOpenOrDownload() {
        if (this.currentAppInfo != null && !TextUtils.isEmpty(this.currentAppInfo.getIssuerAppPkg()) && !TextUtils.isEmpty(this.currentAppInfo.getIssuerAppMarketId())) {
            if (this.helper == null) {
                this.helper = new AppOpenOrDownHelper(this, this.currentAppInfo.getIssuerAppPkg(), this.currentAppInfo.getIssuerAppMarketId());
            }
            this.helper.startOpenOrDown();
        }
    }

    private void checkCardStatus() {
        this.deleteButton.setVisibility(0);
    }

    private void clickDeleteCard() {
        if (!PackageUtil.m28463b(this, Constant.UNIONPAY_PACKAGENAME) || PackageUtil.m28458a(this, Constant.UNIONPAY_PACKAGENAME) < 4) {
            jumpToDownload();
        } else {
            checkWatchStatus();
        }
    }

    private void callServicePhone() {
        if (!TextUtils.isEmpty(this.contactNumber)) {
            try {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(DIAL_HEAD + this.contactNumber)));
            } catch (Throwable e) {
                LogX.e("CardInfoDetailActivity jump to dial:", e, false);
            }
        }
    }

    private void jumpToDownload() {
        startActivityForResult(new Intent(this, DownLoadDialogActivity.class), DELETE_PAGE);
    }

    private void jumpToDeleteCard() {
        LogX.d("===123===Enter jumpToDeleteCard", false);
        if (WalletTaManager.getInstance(this).getCard(this.referenceId) == null) {
            LogX.d("===123===null == info", false);
            showToast(R.string.nfc_detail_nullify_card_entrance_success);
            finish();
            return;
        }
        toDeleteCard();
    }

    protected void toDeleteCard() {
        int mode = this.mBankCardInfo.getMode();
        if (mode != -1) {
            this.mHandler.sendEmptyMessage(4);
            if (11 == mode) {
                TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.referenceId);
                if (card != null && Constant.CITIC_CARD_AID.equals(card.getAid())) {
                    LogX.d("CITIC Nullify Card", false);
                    toNullifyCardActivity(mode);
                    return;
                }
            }
            LogicApiFactory.createCardOperateApi(getApplicationContext()).nullifyCard(this.referenceId, mode, null, this);
            return;
        }
        showToast(R.string.nfc_detail_nullify_card_entrance_others_fail);
    }

    private void toNullifyCardActivity(int i) {
        Intent intent = new Intent(this, NullifyCardActivity.class);
        intent.putExtra("refId", this.referenceId);
        intent.putExtra(VerifySmsCodeActivity.ISSUER_MODE, i);
        startActivity(intent);
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogX.i("queryBankCardInfo result is: " + i2 + " ; resultCode ： " + i2);
        if (i == DELETE_PAGE && i2 == -1) {
            checkWatchStatus();
        }
    }

    public void queryBankCardInfoCallback(int i, BankCardInfo bankCardInfo) {
        LogX.i("queryBankCardInfo result is: " + i);
        if (i != 0 || bankCardInfo == null) {
            bindViewsForNetError();
            showToast();
            return;
        }
        this.mBankCardInfo = bankCardInfo;
        this.mMode = this.mBankCardInfo.getMode();
        bindViewsForCard(bankCardInfo);
    }

    private void showToast() {
        if (C5730c.m26408a((Context) this)) {
            ToastManager.show((Context) this, R.string.nfc_bindcard_error_connection_failed);
        } else {
            ToastManager.show((Context) this, R.string.nfc_bindcard_error_no_network_failed);
        }
    }

    public void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo) {
        LogX.i("queryBankIssuerInfoCallback result is: " + i);
        if (i != 0 || bankIssuerInfo == null) {
            showToast();
        } else {
            bindViewsForIssuer(bankIssuerInfo);
        }
    }

    private AppInfo getCurrentAppInfo(boolean z, BankIssuerInfo bankIssuerInfo) {
        List<AppInfo> appInfos = bankIssuerInfo.getAppInfos();
        if (appInfos == null || appInfos.size() <= 0) {
            return null;
        }
        if (appInfos.size() == 1) {
            return (AppInfo) appInfos.get(0);
        }
        for (AppInfo appInfo : appInfos) {
            int supportType = appInfo.getSupportType();
            if (z) {
                if (supportType == 2) {
                    return appInfo;
                }
                if (supportType == 4) {
                    return appInfo;
                }
            } else if (supportType == 3) {
                return appInfo;
            } else {
                if (supportType == 4) {
                    return appInfo;
                }
            }
        }
        return null;
    }

    private void bindViewsForNetError() {
        if (WalletTaManager.getInstance(this).getCard(this.referenceId) != null) {
            this.cardEntityNumTextView.setText(getString(R.string.nfc_card_num_show, new Object[]{r0.fpanFour}));
            this.cardDeviceNumTextView.setText(getString(R.string.nfc_card_num_show, new Object[]{r0.dpanFour}));
        }
    }

    @SuppressLint({"NewApi"})
    private void bindViewsForCard(BankCardInfo bankCardInfo) {
        this.cardName = bankCardInfo.getCardName();
        this.isDebitCard = bankCardInfo.isCardType();
        this.cardEntityNumTextView.setText(getString(R.string.nfc_card_num_show, new Object[]{bankCardInfo.getFpanFour()}));
        this.cardDeviceNumTextView.setText(getString(R.string.nfc_card_num_show, new Object[]{bankCardInfo.getDpanFour()}));
        allowClickEventForCard();
        checkCardStatus();
    }

    @SuppressLint({"NewApi"})
    private void bindViewsForIssuer(BankIssuerInfo bankIssuerInfo) {
        this.currentAppInfo = getCurrentAppInfo(this.isDebitCard, bankIssuerInfo);
        this.webSite = this.isDebitCard ? bankIssuerInfo.getDebitWebsite() : bankIssuerInfo.getCreditWebsite();
        this.contactNumber = this.isDebitCard ? bankIssuerInfo.getDebitContactNumber() : bankIssuerInfo.getCrebitContactNumber();
        if (TextUtils.isEmpty(this.contactNumber)) {
            this.contactNumber = bankIssuerInfo.getContactNumber();
        }
        if (!(this.currentAppInfo == null || this.currentAppInfo.getApkIcon() == null)) {
            this.cardIconImageView.setImageBitmap(this.currentAppInfo.getApkIcon());
        }
        if (!(this.currentAppInfo == null || TextUtils.isEmpty(this.currentAppInfo.getApkName()))) {
            this.cardNameTextView.setText(this.currentAppInfo.getApkName());
        }
        allowClickEventForIssuer();
        updateLookupOrOpenShow();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.helper != null) {
            this.helper.onDestroy();
        }
    }

    public void nullifyResultCallback(int i) {
        this.mHandler.sendEmptyMessage(3);
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

    private void checkWatchStatus() {
        new Thread(new C56413()).start();
    }

    protected void refreshView(boolean z) {
        super.refreshView(z);
        if (this.deleteButton != null) {
            if (this.mDevicesConnecteStatus == 2 && this.mNetConnected) {
                this.deleteButton.setTextColor(this.mContext.getResources().getColor(R.color.nfc_tip_titile_text));
                this.deleteButton.setBackgroundResource(R.drawable.common_button_21);
                this.deleteButton.setEnabled(true);
                return;
            }
            this.deleteButton.setTextColor(this.mContext.getResources().getColor(R.color.nfc_tip_titile_text_20));
            this.deleteButton.setBackgroundResource(R.drawable.btn_popup_dark_disable);
            this.deleteButton.setEnabled(false);
        }
    }
}
