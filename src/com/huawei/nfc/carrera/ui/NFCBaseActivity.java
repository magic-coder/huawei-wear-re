package com.huawei.nfc.carrera.ui;

import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.application.b;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6004c;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;
import com.huawei.ui.commonui.p513c.C5995a;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.wallet.R;

public class NFCBaseActivity extends BaseActivity {
    public static final String ADD_CARD_ACTIVITY = "AddBankOrBusCardActivity";
    public static final String AW_NAME_CN = "com.google.android.wearable.app.cn";
    public static final String BANKCARDMODE = "BANKCARDMODE";
    public static final String BANKCARREFERENCEID = "BANKCARREFERENCEID";
    public static final String BIND_CARD_ACTIVITY = "BindCardActivity";
    private static final int BTTYPEISAW = 0;
    public static final int CREDIT_BANK_CARD = 3;
    public static final int DEBIT_BANK_CARD = 2;
    public static final String DETAIL_CARD_ACTIVITY = "CardInfoDetailActivity";
    private static final int DISPLAY_HW_NO_SPLIT_LINE = 32768;
    private static final int DOUBLE_BUTTON = 2;
    private static final int EMUI4_DEFAULT_COLOR = -986896;
    public static final String FROM_ADD_CARD_PAGE = "FROM_ADD_CARD_PAGE";
    public static final int INCONSISTENT_ACCOUNTS_ATYPISM_STATUS = 100004;
    public static final int INCONSISTENT_ACCOUNTS_STATUS = 100000;
    public static final String LOCKSCREENSTATUS = "LOCKSCREENSTATUS";
    public static final float PERCENT_MARGIN_30 = 0.3f;
    private static final int SINGLE_BUTTON = 1;
    private static final String TAG = "NFCBaseActivity";
    private static final int THREE_BUTTON = 3;
    public static final int TO_ADD = 222;
    private static final int WAIT_TIME = 3000;
    private BroadcastReceiver NetworkReceiver = new C55592();
    C6002a customLoadingDialog;
    private boolean hasLeftHomeView = false;
    private AnimationDrawable loadingAnimation;
    private TextView mAbnormalTipJumpTv;
    private TextView mAbnormalTipTv;
    private LinearLayout mAbnormalTiplyt;
    public int mAcountStatus = -1;
    protected ActionBar mActionBar;
    private C6004c mAlertDialog;
    public Context mContext;
    private int mDeviceBTType = -1;
    public int mDevicesConnecteStatus = -1;
    private CustomAlertDialog mDialog = null;
    private LinearLayout mGoToSettingLyt;
    private Handler mHandler = new C55614();
    protected C6002a mLoadingDialog21;
    public int mLockscreenStatus = -1;
    public boolean mNetConnected = false;
    private ImageView mNetWorkWaitImg;
    private LinearLayout mNetWorkWaitLyt;
    private final BroadcastReceiver mNonLocalBroadcastReceiver = new C55581();
    OnClickListener onClickListener = new C55625();
    protected LinearLayout parentBodyLinearLayout;
    public PluginPayAdapter pluginPayAdapter;
    private CustomTitleBar titleBar;

    class C55581 extends BroadcastReceiver {
        C55581() {
        }

        public void onReceive(Context context, Intent intent) {
            C2538c.c(NFCBaseActivity.TAG, new Object[]{" NFCBaseActivity connectedChanged mNonLocalBroadcastReceiver(): intent = " + intent.getAction()});
            String action = intent.getAction();
            if (action != null && action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED")) {
                DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                if (deviceInfo != null) {
                    int deviceConnectState = deviceInfo.getDeviceConnectState();
                    C2538c.b(NFCBaseActivity.TAG, new Object[]{"connectedChanged(): " + deviceInfo.getDeviceName() + ",state = " + deviceConnectState});
                    NFCBaseActivity.this.mDevicesConnecteStatus = deviceConnectState;
                    NFCBaseActivity.this.refreshView(true);
                    return;
                }
                C2538c.e(NFCBaseActivity.TAG, new Object[]{"deviceInfo is null!"});
            }
        }
    }

    class C55592 extends BroadcastReceiver {
        C55592() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo2 == null || networkInfo.isConnected() || networkInfo2.isConnected()) {
                NFCBaseActivity.this.mNetConnected = true;
            } else {
                NFCBaseActivity.this.mNetConnected = false;
            }
            NFCBaseActivity.this.refreshView(false);
        }
    }

    class C55614 extends Handler {
        C55614() {
        }

        public void dispatchMessage(Message message) {
            if (1 == message.what) {
                NFCBaseActivity.this.isNetworkConnected(NFCBaseActivity.this.mContext);
                NFCBaseActivity.this.refreshView(false);
                NFCBaseActivity.this.loadingAnimation.stop();
            }
        }
    }

    class C55625 implements OnClickListener {
        C55625() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (R.id.nfc_tip_titile_text == id) {
                if (!NFCBaseActivity.this.mNetConnected) {
                    NFCBaseActivity.this.netWorkWaitView();
                }
            } else if (R.id.nfc_tip_goto_setting_text != id) {
            } else {
                if (NFCBaseActivity.this.mDevicesConnecteStatus != 2) {
                    NFCBaseActivity.this.jumpToAndroidWear();
                } else if (!NFCBaseActivity.this.mNetConnected) {
                    NFCBaseActivity.this.jumpToNetWorkSetting();
                }
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initVerHorSwitch();
        initParentView();
    }

    private final void initVerHorSwitch() {
        if (getResources().getBoolean(R.bool.IsSupportOrientation)) {
            setRequestedOrientation(3);
        } else {
            setRequestedOrientation(1);
        }
    }

    private void initParentView() {
        super.setContentView(R.layout.huaweipay_base_main_layout);
        this.titleBar = (CustomTitleBar) findViewById(R.id.third_party_title_bar);
        this.mContext = this;
        this.pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter();
        this.parentBodyLinearLayout = (LinearLayout) findViewById(R.id.base_main_body_linearlayout);
        this.mAbnormalTiplyt = (LinearLayout) findViewById(R.id.nfc_tip_titile_layout);
        this.mNetWorkWaitLyt = (LinearLayout) findViewById(R.id.nfc_tip_titile_netWorkWait_layout);
        this.mGoToSettingLyt = (LinearLayout) findViewById(R.id.nfc_tip_goto_setting_layout);
        this.mAbnormalTipTv = (TextView) findViewById(R.id.nfc_tip_titile_text);
        this.mAbnormalTipJumpTv = (TextView) findViewById(R.id.nfc_tip_goto_setting_text);
        this.mNetWorkWaitImg = (ImageView) findViewById(R.id.nfc_netWorkWait_imageview);
        this.mAbnormalTiplyt.setOnClickListener(this.onClickListener);
        this.mAbnormalTipTv.setOnClickListener(this.onClickListener);
        this.mAbnormalTipJumpTv.setOnClickListener(this.onClickListener);
        registerNonLocalBroadcast();
        registerReceiver();
    }

    public void showToast(int i) {
        ToastManager.show((Context) this, i);
    }

    public void showToast(String str) {
        ToastManager.show((Context) this, str);
    }

    public void showProgressDialog(String str, String str2, boolean z) {
        if (this.customLoadingDialog == null || !this.customLoadingDialog.isShowing()) {
            this.customLoadingDialog = C6002a.m27468a(this.mContext);
            this.customLoadingDialog.m27476a(str2);
            this.customLoadingDialog.setCancelable(z);
            this.customLoadingDialog.setTitle(str);
            this.customLoadingDialog.m27474a();
        }
    }

    public void dismissProgressDialog() {
        if (this.customLoadingDialog != null && this.customLoadingDialog.isShowing()) {
            this.customLoadingDialog.cancel();
        }
    }

    public void showDialog(int i, int i2, DialogInterface.OnClickListener onClickListener, String... strArr) {
        this.mAlertDialog = new C6004c(this);
        this.mAlertDialog.m27536a(i);
        this.mAlertDialog.m27542b(i2);
        this.mAlertDialog.m27541a(false);
        switch (strArr.length) {
            case 1:
                this.mAlertDialog.m27545c(strArr[0], onClickListener);
                break;
            case 2:
                this.mAlertDialog.m27545c(strArr[0], onClickListener);
                this.mAlertDialog.m27539a(strArr[1], onClickListener);
                break;
            case 3:
                this.mAlertDialog.m27545c(strArr[0], onClickListener);
                this.mAlertDialog.m27544b(strArr[1], onClickListener);
                this.mAlertDialog.m27539a(strArr[2], onClickListener);
                break;
            default:
                LogX.d("error btn size");
                return;
        }
        CustomAlertDialog a = this.mAlertDialog.m27535a();
        if (a == null || !a.isShowing()) {
            a.show();
        }
    }

    public final void setContentView(int i) {
        if (this.parentBodyLinearLayout != null) {
            this.parentBodyLinearLayout.removeAllViews();
            LayoutInflater.from(this).inflate(i, this.parentBodyLinearLayout);
            this.parentBodyLinearLayout.setVisibility(0);
            return;
        }
        super.setContentView(i);
    }

    public final void setContentView(View view) {
        if (this.parentBodyLinearLayout != null) {
            this.parentBodyLinearLayout.removeAllViews();
            this.parentBodyLinearLayout.addView(view);
            this.parentBodyLinearLayout.setVisibility(0);
            return;
        }
        super.setContentView(view);
    }

    public final void removeBodyViews() {
        if (this.parentBodyLinearLayout != null) {
            this.parentBodyLinearLayout.removeAllViews();
        }
    }

    protected final void showHead(int i) {
        setTitle(getString(i));
    }

    protected final void showHead(String str) {
        this.titleBar.setTitleText(str);
    }

    public void setTitle(int i) {
        setTitle(getString(i));
    }

    public void setTitle(String str) {
        this.titleBar.setTitleText(str);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            onHomeRetrunArrowClick();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onHomeRetrunArrowClick() {
        finish();
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        unregisterNonLocalBroadcast();
        super.onDestroy();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onResume() {
        super.onResume();
        initSystemBar();
        if (this.pluginPayAdapter != null) {
            this.mDevicesConnecteStatus = this.pluginPayAdapter.getDeviceConnectState();
            this.mDeviceBTType = this.pluginPayAdapter.getDeviceBTType();
        }
        isNetworkConnected(this.mContext);
        refreshView(false);
    }

    protected void initSystemBar() {
        if (BaseApplication.c() == b.a && VERSION.SDK_INT >= 19) {
            if (VERSION.SDK_INT > 23) {
                getWindow().setNavigationBarColor(0);
                getWindow().setStatusBarColor(0);
            } else {
                getWindow().setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS, HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            }
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }
        if (BaseApplication.c() == b.b && VERSION.SDK_INT >= 19) {
            if (VERSION.SDK_INT >= 21) {
                getWindow().setStatusBarColor(0);
            }
            if (VERSION.SDK_INT > 23) {
                getWindow().setNavigationBarColor(0);
            }
            getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    private void registerNonLocalBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
        registerReceiver(this.mNonLocalBroadcastReceiver, intentFilter, com.huawei.hwcommonmodel.b.c.a, null);
    }

    private void unregisterNonLocalBroadcast() {
        try {
            C2538c.c(TAG, new Object[]{"Enter unregisterNonLocalBroadcast()!"});
            unregisterReceiver(this.mNonLocalBroadcastReceiver);
            unregisterReceiver(this.NetworkReceiver);
        } catch (IllegalArgumentException e) {
            C2538c.e(TAG, new Object[]{e.getMessage()});
        }
    }

    protected void isNetworkConnected(Context context) {
        this.mNetConnected = C4026a.m19819a(context);
    }

    protected void jumpToNetWorkSetting() {
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    protected void jumpToAndroidWear() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.mContext.getPackageManager().getPackageInfo(AW_NAME_CN, 0);
        } catch (NameNotFoundException e) {
            C2538c.c(TAG, new Object[]{"onClick() androidWearNameCn, error = " + e.getMessage()});
            C5995a.m27436a(this.mContext, this.mContext.getString(R.string.IDS_device_hauwei_watch_download_android_wear_tips));
            packageInfo = null;
        }
        if (packageInfo != null) {
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) this.mContext.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                String str = resolveInfo.activityInfo.packageName;
                String str2 = resolveInfo.activityInfo.name;
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(str, str2));
                startActivity(intent);
            }
        }
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.NetworkReceiver, intentFilter);
    }

    protected void setWatchLockscreen(final String str) {
        LogX.d("enter setWatchLockscreen " + str);
        if (!StringUtil.isEmpty(str, true)) {
            new Thread(new Runnable() {
                public void run() {
                    if (NFCBaseActivity.this.pluginPayAdapter != null) {
                        NFCBaseActivity.this.pluginPayAdapter.notificationOpenPageOfBand(str);
                    }
                    LogX.d("getWatcStatus mLockscreenStatus  " + NFCBaseActivity.this.mLockscreenStatus);
                }
            }).start();
        }
    }

    private void netWorkWaitView() {
        if (this.mAbnormalTiplyt != null && this.mNetWorkWaitLyt != null && this.mNetWorkWaitImg != null) {
            this.mAbnormalTiplyt.setVisibility(8);
            this.mNetWorkWaitLyt.setVisibility(0);
            this.loadingAnimation = (AnimationDrawable) this.mContext.getResources().getDrawable(R.drawable.app_update_checking);
            this.mNetWorkWaitImg.setBackground(this.loadingAnimation);
            this.loadingAnimation.start();
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000);
        }
    }

    protected void refreshView(boolean z) {
        LogX.i("connectedChanged refreshView DevicesConnecteStatus " + this.mDevicesConnecteStatus + " ; NetConnected : " + this.mNetConnected);
        if (this.mAbnormalTiplyt != null && this.mAbnormalTipTv != null && this.mNetWorkWaitLyt != null) {
            this.mNetWorkWaitLyt.setVisibility(8);
            if (this.mDevicesConnecteStatus == 2 && this.mNetConnected) {
                this.mAbnormalTiplyt.setVisibility(8);
                return;
            }
            this.mAbnormalTiplyt.setVisibility(0);
            if (this.mDevicesConnecteStatus != 2) {
                this.mAbnormalTipTv.setText(R.string.nfc_bt_discontected_tip_text);
                this.mAbnormalTipJumpTv.setText(R.string.nfc_bt_connect_bluetooth);
                if (this.mDeviceBTType != 0) {
                    this.mGoToSettingLyt.setVisibility(8);
                }
            } else if (!this.mNetConnected) {
                this.mGoToSettingLyt.setVisibility(0);
                this.mAbnormalTipTv.setText(R.string.huaweipay_net_error_click_refresh);
                this.mAbnormalTipJumpTv.setText(R.string.nfc_bt_set_network);
            }
        }
    }

    protected void destroyLoadingDialog() {
        if (!isFinishing() && this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.cancel();
            this.mLoadingDialog21 = null;
            C2538c.c(TAG, new Object[]{"destroy mLoadingDialog21"});
        }
    }

    protected void showLoadingDialog(int i) {
        C2538c.c(TAG, new Object[]{"showLoadingDialog resId : " + i});
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(this.mContext, R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a(this.mContext);
            this.mLoadingDialog21.m27476a(this.mContext.getString(i));
            this.mLoadingDialog21.m27474a();
        }
        if (!isFinishing() && this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.show();
            C2538c.c(TAG, new Object[]{"mLoadingDialog.show()"});
        }
    }

    protected void showLoadingDialog(int i, boolean z, OnCancelListener onCancelListener) {
        C2538c.c(TAG, new Object[]{"showLoadingDialog : " + this.mLoadingDialog21 + " ; isCancelable " + z});
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(this.mContext, R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a(this.mContext);
            this.mLoadingDialog21.m27476a(this.mContext.getString(i));
            this.mLoadingDialog21.setOnCancelListener(onCancelListener);
            this.mLoadingDialog21.setCancelable(z);
            this.mLoadingDialog21.m27474a();
        }
        if (!isFinishing() && this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.show();
            C2538c.c(TAG, new Object[]{"mLoadingDialog.show()"});
        }
    }

    protected void showLoadingDialog(String str, boolean z, OnCancelListener onCancelListener) {
        C2538c.c(TAG, new Object[]{"showLoadingDialog : " + this.mLoadingDialog21 + " ; isCancelable " + z});
        if (this.mLoadingDialog21 == null) {
            C6002a c6002a = new C6002a(this.mContext, R.style.app_update_dialogActivity);
            this.mLoadingDialog21 = C6002a.m27468a(this.mContext);
            this.mLoadingDialog21.m27476a(str);
            this.mLoadingDialog21.setOnCancelListener(onCancelListener);
            this.mLoadingDialog21.setCancelable(z);
            this.mLoadingDialog21.m27474a();
        }
        if (!isFinishing() && this.mLoadingDialog21 != null) {
            this.mLoadingDialog21.show();
            C2538c.c(TAG, new Object[]{"mLoadingDialog.show()"});
        }
    }

    protected void watchConnectedChange(int i) {
    }
}
