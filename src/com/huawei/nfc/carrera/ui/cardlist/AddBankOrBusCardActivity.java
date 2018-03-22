package com.huawei.nfc.carrera.ui.cardlist;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.cp3.widget.p382a.p383a.C4371b;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.CardInfoManagerApi;
import com.huawei.nfc.carrera.logic.CardOperateLogicApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardinfo.model.WalletSupportInfo;
import com.huawei.nfc.carrera.logic.cardoperate.response.InitCUPCardOperatorCallback;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeleteLocalCardsCallback;
import com.huawei.nfc.carrera.server.card.model.CaptureMethod;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.ui.bindcard.CardLockScreenActivity;
import com.huawei.nfc.carrera.ui.bindcard.DownLoadDialogActivity;
import com.huawei.nfc.carrera.ui.bindcard.InputCardNumActivity;
import com.huawei.nfc.carrera.ui.bus.opencard.BindBusCardSwitchActivity;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.nfc.carrera.ui.util.PaySecurityManagerSettingUtils;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p473a.p476b.C5587b;
import com.huawei.pay.p473a.p476b.C5720a;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.wallet.R;
import com.huawei.wallet.logic.cardidentify.CardCameraIdentifyHelper;
import com.huawei.wallet.logic.cardidentify.CardIdentifyInfo;
import com.huawei.wallet.logic.cardidentify.ICardIdentifyCallBack;
import com.huawei.wallet.utils.PackageUtil;
import java.util.ArrayList;

public class AddBankOrBusCardActivity extends NFCBaseActivity implements OnClickListener, InitCUPCardOperatorCallback {
    private static final int ADD_BANK_REQUESTCODE = 888;
    private static final int ADD_BUS_REQUESTCODE = 889;
    private static final int CARDINFO_JUMPTOADDCARDACTIVITY = 5;
    private static final int CARDINFO_JUMPTOTRAFFICCARDACTIVITY = 7;
    private static final int CARDINFO_MASSAGE_DISMSS_LOAD = 4;
    private static final int CARDINFO_MASSAGE_SHOW_LOAD = 3;
    private static final int CARDINFO_SHOWCARDOUTOFNUMBERDIALOG = 6;
    private static final int CARDINFO_SUPPORT_BUSINESS = 8;
    private static final int HANDLER_MASSAGE_SHOW_DIALOG = 1;
    private static final int HANDLER_MASSAGE_SHOW_RETRY_DIALOG = 2;
    private static final int OPEN_CARD_NUMBER_LIMIT = 8;
    private static final String SUPPORT_CARD_LIST = "SUPPORT_CARD_LIST";
    private static final String SUPPROT_BANK_TYPE = "0010";
    private static final String SUPPROT_BUS_AND_BANK_TYPE = "0011";
    private static final String TAG = "PluginPay AddBankOrBusCardActivity";
    private Button addBankCard;
    private Button addBusCard;
    private TextView addCardTisps;
    private String addCardTispsInfo;
    private CardInfoManagerApi cardInfoManagerApi;
    private int currentOnclickButtonType;
    private Handler mHandler = new C56529();
    private ImageView mIconImg;
    private RelativeLayout mIdImgRely;
    private String mSupportBusiness;
    private ArrayList<String> supportList = null;

    class C56441 implements Runnable {
        C56441() {
        }

        public void run() {
            AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(3);
            ESEInfoManager instance = ESEInfoManager.getInstance(AddBankOrBusCardActivity.this.mContext);
            WalletSupportInfo walletAbility = instance.getWalletAbility();
            if (walletAbility != null) {
                C2538c.c(AddBankOrBusCardActivity.TAG, new Object[]{" getWalletSupport  walletabillity :  " + walletAbility.toString()});
            } else {
                walletAbility = new WalletSupportInfo("");
            }
            AddBankOrBusCardActivity.this.mSupportBusiness = walletAbility.getSupportBusiness();
            AddBankOrBusCardActivity.this.supportList = walletAbility.getSupportList();
            instance.setSupportList(AddBankOrBusCardActivity.this.supportList);
            AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(4);
            AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(8);
        }
    }

    class C56452 implements Runnable {
        C56452() {
        }

        public void run() {
            int i = 0;
            if (AddBankOrBusCardActivity.this.pluginPayAdapter != null) {
                AddBankOrBusCardActivity.this.mLockscreenStatus = AddBankOrBusCardActivity.this.pluginPayAdapter.getLockscreenStatus();
                LogX.i("PluginPay AddBankOrBusCardActivity== checkWatchStatus LockscreenStatus : " + AddBankOrBusCardActivity.this.mLockscreenStatus);
                i = AddBankOrBusCardActivity.this.pluginPayAdapter.getDeviceConnectState();
                LogX.i("PluginPay AddBankOrBusCardActivity== checkWatchStatus btconnect : " + i);
            }
            if (AddBankOrBusCardActivity.this.mLockscreenStatus == 0 || r0 != 2) {
                AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(5);
            } else {
                AddBankOrBusCardActivity.this.gotoLockScreenActivity();
            }
        }
    }

    class C56463 implements C5587b {
        C56463() {
        }

        public void onRequestPermissionsResult(int[] iArr) {
            LogX.i("PluginPay AddBankOrBusCardActivityonRequestPermissionsResult ", false);
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                LogX.i("PluginPay AddBankOrBusCardActivityno CAMERA permission start Camera", false);
            } else {
                AddBankOrBusCardActivity.this.goToBankCardCaptureActivity();
            }
        }
    }

    class C56474 implements ICardIdentifyCallBack {
        C56474() {
        }

        public void onIndetify(CardIdentifyInfo cardIdentifyInfo) {
            if (cardIdentifyInfo != null) {
                AddBankOrBusCardActivity.this.goToInputCardNumActivity(cardIdentifyInfo);
            }
        }

        public void onSwitch2Input() {
            AddBankOrBusCardActivity.this.goToInputCardNumActivity(null);
        }

        public void onCardBackPressed() {
        }
    }

    class C56485 implements OnClickListener {
        C56485() {
        }

        public void onClick(View view) {
        }
    }

    class C56496 implements Runnable {
        C56496() {
        }

        public void run() {
            AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(3);
            String str = "";
            if (AddBankOrBusCardActivity.this.pluginPayAdapter != null) {
                str = AddBankOrBusCardActivity.this.pluginPayAdapter.getUserID();
            }
            if (str == null || "".equals(str)) {
                C2538c.e(AddBankOrBusCardActivity.TAG, new Object[]{"enter swipeActivity  but account not login"});
                AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(4);
                return;
            }
            if (AddBankOrBusCardActivity.this.pluginPayAdapter != null) {
                AddBankOrBusCardActivity.this.mAcountStatus = AddBankOrBusCardActivity.this.pluginPayAdapter.sendAccount(str);
            }
            C2538c.b(AddBankOrBusCardActivity.TAG, new Object[]{"== checkWatchStatus sendAccount  " + AddBankOrBusCardActivity.this.mAcountStatus});
            boolean isExsitGroupTypeCard = CardInfoManager.getInstance(AddBankOrBusCardActivity.this).isExsitGroupTypeCard(1);
            C2538c.b(AddBankOrBusCardActivity.TAG, new Object[]{"== checkWatchStatus isExsit  " + isExsitGroupTypeCard});
            if (AddBankOrBusCardActivity.this.mAcountStatus == 100004 && isExsitGroupTypeCard) {
                AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(4);
                AddBankOrBusCardActivity.this.mHandler.sendEmptyMessage(1);
                return;
            }
            AddBankOrBusCardActivity.this.doAddCard(AddBankOrBusCardActivity.this.currentOnclickButtonType);
        }
    }

    class C56507 implements OnClickListener {
        C56507() {
        }

        public void onClick(View view) {
            AddBankOrBusCardActivity.this.finish();
        }
    }

    class C56518 implements OnClickListener {
        C56518() {
        }

        public void onClick(View view) {
            if (!PackageUtil.m28463b(AddBankOrBusCardActivity.this, Constant.UNIONPAY_PACKAGENAME) || PackageUtil.m28458a(AddBankOrBusCardActivity.this, Constant.UNIONPAY_PACKAGENAME) < 4) {
                AddBankOrBusCardActivity.this.jumpToDownload(AddBankOrBusCardActivity.ADD_BUS_REQUESTCODE);
            } else {
                AddBankOrBusCardActivity.this.initCupService();
            }
        }
    }

    class C56529 extends Handler {
        C56529() {
        }

        public void dispatchMessage(Message message) {
            if (1 == message.what) {
                AddBankOrBusCardActivity.this.showDialog(false);
            } else if (2 == message.what) {
                AddBankOrBusCardActivity.this.showDialog(true);
            } else if (3 == message.what) {
                AddBankOrBusCardActivity.this.showLoadingDialog(R.string.huaweipay_loading);
            } else if (4 == message.what) {
                AddBankOrBusCardActivity.this.destroyLoadingDialog();
            } else if (5 == message.what) {
                AddBankOrBusCardActivity.this.jumpToAddCardActivity();
            } else if (6 == message.what) {
                AddBankOrBusCardActivity.this.showCardOutOfNumberDialog();
            } else if (7 == message.what) {
                AddBankOrBusCardActivity.this.jumpToAddTrafficCardActivity(AddBankOrBusCardActivity.this.supportList);
            } else if (8 == message.what) {
                AddBankOrBusCardActivity.this.showOrHideBankInfo();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        int deviceProtocol;
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R.layout.nfc_first_enter_layout);
        showHead(R.string.nfc_name1);
        getWalletSupport();
        this.cardInfoManagerApi = LogicApiFactory.createCardManager(this);
        this.addBankCard = (Button) findViewById(R.id.nfc_add_bank_card);
        this.addBusCard = (Button) findViewById(R.id.nfc_add_bus_card);
        this.addCardTisps = (TextView) findViewById(R.id.txt_add_card_tips);
        this.addBankCard.setOnClickListener(this);
        this.addBusCard.setOnClickListener(this);
        this.mIconImg = (ImageView) findViewById(R.id.imge_icon);
        this.mIdImgRely = (RelativeLayout) findViewById(R.id.mid_img_rely);
        this.pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter();
        if (this.pluginPayAdapter != null) {
            deviceProtocol = this.pluginPayAdapter.getDeviceProtocol();
        } else {
            deviceProtocol = 0;
        }
        if (deviceProtocol == 13) {
            this.mIdImgRely.setBackgroundResource(R.drawable.nfc_bt_bg_band);
            this.mIconImg.setVisibility(8);
            return;
        }
        this.mIdImgRely.setBackgroundResource(R.drawable.nfc_bt_bg_watch);
        this.mIconImg.setVisibility(0);
        this.mIconImg.setImageResource(R.drawable.ic_card);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.id.nfc_add_bus_card == id) {
            this.currentOnclickButtonType = 2;
            prepareToAddBankCard();
        } else if (R.id.nfc_add_bank_card == id) {
            this.currentOnclickButtonType = 1;
            checkUnionPayPackageInstalled();
        }
    }

    private void checkUnionPayPackageInstalled() {
        if (!PackageUtil.m28463b(this, Constant.UNIONPAY_PACKAGENAME) || PackageUtil.m28458a(this, Constant.UNIONPAY_PACKAGENAME) < 4) {
            jumpToDownload(ADD_BANK_REQUESTCODE);
        } else {
            prepareToAddBankCard();
        }
    }

    private void doAddCard(int i) {
        if (this.cardInfoManagerApi.checkAvaiableCard() < 8) {
            enterAddCard(i);
            return;
        }
        this.mHandler.sendEmptyMessage(4);
        this.mHandler.sendEmptyMessage(6);
    }

    private void enterAddCard(int i) {
        this.mHandler.sendEmptyMessage(4);
        if (i == 1) {
            getLockScreenStatus();
        } else {
            this.mHandler.sendEmptyMessage(7);
        }
    }

    private void getWalletSupport() {
        new Thread(new C56441()).start();
    }

    private void getLockScreenStatus() {
        new Thread(new C56452()).start();
    }

    private void jumpToAddCardActivity() {
        if (C4026a.m19819a(this)) {
            C5720a.m26366a().m26370a(getApplicationContext());
            C5720a.m26366a().m26371a(new C56463(), (Activity) this, "android.permission.CAMERA");
            return;
        }
        showToast(R.string.nfc_bindcard_error_no_network_failed);
    }

    private void gotoLockScreenActivity() {
        Intent intent = new Intent();
        intent.setClass(this, CardLockScreenActivity.class);
        intent.putExtra(NFCBaseActivity.LOCKSCREENSTATUS, this.mLockscreenStatus);
        intent.putExtra(NFCBaseActivity.FROM_ADD_CARD_PAGE, NFCBaseActivity.ADD_CARD_ACTIVITY);
        startActivity(intent);
    }

    private void goToBankCardCaptureActivity() {
        new CardCameraIdentifyHelper().m27968a(this, new C56474());
    }

    private void goToInputCardNumActivity(CardIdentifyInfo cardIdentifyInfo) {
        CaptureMethod.setCameraMode();
        Intent intent = new Intent();
        if (cardIdentifyInfo != null) {
            intent.putExtra(InputCardNumActivity.INTENT_KEY_CARD_NUM, cardIdentifyInfo.m27969a());
            intent.putExtra(InputCardNumActivity.INTENT_KRY_CARD_IMG, cardIdentifyInfo.m27972b());
        }
        intent.setClass(getApplication(), InputCardNumActivity.class);
        startActivity(intent);
        finish();
    }

    private void jumpToAddTrafficCardActivity(ArrayList<String> arrayList) {
        if (C4026a.m19819a(this)) {
            Intent intent = new Intent(this, BindBusCardSwitchActivity.class);
            intent.putStringArrayListExtra(SUPPORT_CARD_LIST, arrayList);
            startActivity(intent);
            finish();
            return;
        }
        showToast(R.string.nfc_bindcard_error_no_network_failed);
    }

    private void showCardOutOfNumberDialog() {
        C6024w c6024w = new C6024w(this.mContext);
        c6024w.m27591a(R.string.nfc_card_list_dialog_title);
        c6024w.m27596b(R.string.nfc_bind_card_fail_open_overcount);
        c6024w.m27593a(R.string.nfc_quick_pass_button_text, new C56485());
        C6022u a = c6024w.m27590a();
        a.setCancelable(false);
        if (!a.isShowing()) {
            a.show();
        }
    }

    private void jumpToDownload(int i) {
        startActivityForResult(new Intent(this, DownLoadDialogActivity.class), i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C2538c.b(TAG, new Object[]{"onActivityResult requestCode : " + i + " ; currentOnclickButtonType : " + this.currentOnclickButtonType});
        if (ADD_BANK_REQUESTCODE == i && i2 == -1) {
            this.mHandler.sendEmptyMessage(3);
            getLockScreenStatus();
        } else if (ADD_BUS_REQUESTCODE == i && i2 == -1) {
            initCupService();
        } else {
            C2538c.b(TAG, new Object[]{"No this resultCode in onActivityResult"});
        }
    }

    private void prepareToAddBankCard() {
        new Thread(new C56496()).start();
    }

    private void showDialog(boolean z) {
        C2538c.b(TAG, new Object[]{"checkAccount showDialog"});
        C6024w c6024w = new C6024w(this.mContext);
        c6024w.m27591a(R.string.nfc_card_list_dialog_title);
        if (z) {
            c6024w.m27596b(R.string.nfc_retry_clean);
        } else {
            c6024w.m27596b(R.string.nfc_bt_lock_clean_bankcard_message);
        }
        c6024w.m27592a(R.string.nfc_clear_empty, R.color.nfc_tip_titile_text, new C56518()).m27597b(R.string.hwpay_dialog_no, new C56507());
        C6022u a = c6024w.m27590a();
        a.setCancelable(false);
        if (!isFinishing() && !a.isShowing()) {
            a.show();
        }
    }

    private void initCupService() {
        C2538c.c(TAG, new Object[]{"enter initCupService"});
        CardOperateLogicApi createCardOperateApi = LogicApiFactory.createCardOperateApi(getApplicationContext());
        if (createCardOperateApi != null) {
            showLoadingDialog(R.string.CS_waiting_progress_message);
            createCardOperateApi.initCUPCardOperator(this);
        }
    }

    private void getClearCardResult(boolean z) {
        C2538c.c(TAG, new Object[]{"getClearCardResult isSuccess " + z});
        destroyLoadingDialog();
        if (z) {
            ToastManager.show((Context) this, R.string.nfc_clean_done);
            doAddCard(this.currentOnclickButtonType);
            return;
        }
        this.mHandler.sendEmptyMessage(2);
    }

    protected void refreshView(boolean z) {
        super.refreshView(z);
        if (this.addBankCard != null && this.addBusCard != null) {
            if (this.mDevicesConnecteStatus == 2 && this.mNetConnected) {
                this.addBankCard.setTextColor(this.mContext.getResources().getColor(R.color.nfc_enable_button_text_color));
                this.addBankCard.setBackgroundResource(R.drawable.common_button_21);
                this.addBankCard.setEnabled(true);
                this.addBusCard.setTextColor(this.mContext.getResources().getColor(R.color.nfc_enable_button_text_color));
                this.addBusCard.setBackgroundResource(R.drawable.common_button_21);
                this.addBusCard.setEnabled(true);
                getWalletSupport();
                return;
            }
            this.addBankCard.setTextColor(this.mContext.getResources().getColor(R.color.nfc_unenable_button_text_color));
            this.addBankCard.setBackgroundResource(R.drawable.btn_popup_dark_disable);
            this.addBankCard.setEnabled(false);
            this.addBusCard.setTextColor(this.mContext.getResources().getColor(R.color.nfc_unenable_button_text_color));
            this.addBusCard.setBackgroundResource(R.drawable.btn_popup_dark_disable);
            this.addBusCard.setEnabled(false);
        }
    }

    protected void showProgress(C4371b c4371b, String str, boolean z, OnCancelListener onCancelListener) {
        if (c4371b != null && !c4371b.isShowing()) {
            c4371b.mo4439a((CharSequence) str);
            c4371b.setCancelable(z);
            c4371b.setOnCancelListener(onCancelListener);
            c4371b.show();
        }
    }

    protected void dismissProgress(C4371b c4371b) {
        if (isFinishing()) {
            LogX.w("PluginPay AddBankOrBusCardActivitydismissProgress, activity is finishing");
        } else if (c4371b != null && c4371b.isShowing()) {
            c4371b.dismiss();
        }
    }

    private void showOrHideBankInfo() {
        if (this.mSupportBusiness == null || StringUtil.isEmpty(this.mSupportBusiness, true)) {
            C2538c.c(TAG, new Object[]{" SupportBusiness is null"});
            this.addCardTispsInfo = this.mContext.getResources().getString(R.string.nfc_add_buscard_or_bankcard_tip_new);
            this.addCardTisps.setText(this.addCardTispsInfo);
            this.addBankCard.setVisibility(8);
            return;
        }
        C2538c.c(TAG, new Object[]{" mSupportBusiness " + this.mSupportBusiness});
        if (this.mSupportBusiness.equals("0010") || this.mSupportBusiness.equals("0011")) {
            this.addBankCard.setVisibility(0);
            this.addCardTispsInfo = this.mContext.getResources().getString(R.string.nfc_add_buscard_or_bankcard_tip_new) + this.mContext.getResources().getString(R.string.nfc_add_buscard_or_bankcard_tip_new_add);
        } else {
            this.addCardTispsInfo = this.mContext.getResources().getString(R.string.nfc_add_buscard_or_bankcard_tip_new);
            this.addBankCard.setVisibility(8);
        }
        this.addCardTisps.setText(this.addCardTispsInfo);
    }

    public void initCUPCardOperatorResult(int i) {
        destroyLoadingDialog();
        C2538c.b(TAG, new Object[]{"====init bank apk resultCode =  " + i});
        switch (i) {
            case -5:
                C2538c.b(TAG, new Object[]{"init bank apk FAILED_CANNOT_BIND_CUP_SERVICE "});
                showBindFailDialog();
                return;
            case -3:
                C2538c.b(TAG, new Object[]{"init bank apk FAILED_CUP_TSM_SERVICE_UNREACHABLE "});
                showToast(R.string.error_no_network_failed);
                return;
            case 0:
                C2538c.b(TAG, new Object[]{"init bank apk SUCCESS "});
                cleanLocalBankCard();
                return;
            default:
                showDialog(true);
                C2538c.b(TAG, new Object[]{"init bank apk unknow "});
                return;
        }
    }

    private void showBindFailDialog() {
        PayManagerSettingSwitchDialog payManagerSettingSwitchDialog = new PayManagerSettingSwitchDialog(this.mContext, R.style.app_update_dialogActivity);
        payManagerSettingSwitchDialog = PayManagerSettingSwitchDialog.createNotice(this.mContext);
        payManagerSettingSwitchDialog.setNoticeTitle(this.mContext.getString(R.string.nfc_card_list_dialog_title));
        payManagerSettingSwitchDialog.setNoticeMessage(R.string.nfc_security_manager_setting_swich_message, R.string.nfc_security_manager_setting_swich_message1, this.mContext.getString(R.string.nfc_security_manager_setting_swich_message_more));
        payManagerSettingSwitchDialog.setPositiveButton(this.mContext.getString(R.string.nfc_card_dialog_getlocation_service_positive_text), new OnClickListener() {
            public void onClick(View view) {
                PaySecurityManagerSettingUtils.gotoSetting(AddBankOrBusCardActivity.this.mContext);
                payManagerSettingSwitchDialog.dismiss();
            }
        });
        payManagerSettingSwitchDialog.setNegativeButton(this.mContext.getString(R.string.nfc_cancel), new OnClickListener() {
            public void onClick(View view) {
                payManagerSettingSwitchDialog.dismiss();
            }
        });
        payManagerSettingSwitchDialog.startNotice();
    }

    private void cleanLocalBankCard() {
        showLoadingDialog(R.string.nfc_cleaning);
        C2538c.c(TAG, new Object[]{"AddBankOrBusCardActivity start clear card"});
        CardLostManager.getInstance(this).deleteLocalBankCards(new HandleDeleteLocalCardsCallback() {
            public void handleDeletelocalcardCallback(final boolean z) {
                AddBankOrBusCardActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        AddBankOrBusCardActivity.this.getClearCardResult(z);
                    }
                });
            }
        });
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
