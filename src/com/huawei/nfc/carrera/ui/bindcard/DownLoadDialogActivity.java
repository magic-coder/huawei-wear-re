package com.huawei.nfc.carrera.ui.bindcard;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.application.b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.UnionpayComponent;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.DownLoadCallback;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.UnionpayInfoCallback;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.UnionpayInstallCallBack;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.p473a.p476b.C5587b;
import com.huawei.pay.p473a.p476b.C5720a;
import com.huawei.pay.ui.PayAlertDialogFragment;
import com.huawei.pay.ui.PayAlertDialogFragment.AlertDialogListener;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.pay.ui.widget.DownloadProgressDialog;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.log.LogC;
import java.io.File;

public class DownLoadDialogActivity extends FragmentActivity implements DownLoadCallback, UnionpayInfoCallback, UnionpayInstallCallBack, AlertDialogListener {
    private static final int REMINDER_DIALOG = 301;
    private DownloadProgressDialog downloadDialog;
    private C6022u mSureDialog = null;
    private C6002a progress;
    private PayAlertDialogFragment reminderDialog;
    private String savePath;
    private String signature;
    private String totalSize;
    private UnionpayComponent unComponent;
    private String url;

    class C55901 implements OnClickListener {
        C55901() {
        }

        public void onClick(View view) {
            DownLoadDialogActivity.this.startProgress(DownLoadDialogActivity.this.getString(R.string.nfc_loading));
            DownLoadDialogActivity.this.startAppDownOrInstall(DownLoadDialogActivity.this.mSureDialog);
        }
    }

    class C55912 implements OnClickListener {
        C55912() {
        }

        public void onClick(View view) {
            DownLoadDialogActivity.this.mSureDialog.dismiss();
            DownLoadDialogActivity.this.finish();
        }
    }

    class C55923 implements OnKeyListener {
        C55923() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && 1 == keyEvent.getAction()) {
                dialogInterface.dismiss();
                DownLoadDialogActivity.this.finish();
            }
            return true;
        }
    }

    class C55945 implements OnKeyListener {
        C55945() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0) {
                DownLoadDialogActivity.this.createCancelDialog();
            }
            return false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R.layout.nfc_download_dialog);
        loadApplicationTheme();
        initSystemBar();
        startProgress(getString(R.string.nfc_loading));
        getUnionPayData();
    }

    private void getUnionPayData() {
        this.unComponent = new UnionpayComponent(this);
        this.unComponent.registerListeners(this, this, this);
        this.unComponent.getUnionpayAPKInfo();
    }

    private void showDialog() {
        if (this.mSureDialog == null) {
            this.mSureDialog = new C6024w(this).m27591a(R.string.nfc_card_list_dialog_title).m27596b(R.string.nfc_relativite_apk_download_tip).m27597b(R.string.huaweipay_hcoin_use_flow_cancel, new C55912()).m27593a(R.string.huaweipay_hcoin_use_flow_sure, new C55901()).m27590a();
            this.mSureDialog.setCancelable(false);
        }
        if (!isFinishing()) {
            this.mSureDialog.show();
        }
        this.mSureDialog.setOnKeyListener(new C55923());
    }

    private void startAppDownOrInstall(final C6022u c6022u) {
        C5720a.m26366a().m26370a(getApplicationContext());
        C5720a.m26366a().m26371a(new C5587b() {
            public void onRequestPermissionsResult(int[] iArr) {
                if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    LogC.m28530b("UpgradeDialogActivity install apk read sdcard have not permission", false);
                    if (c6022u != null) {
                        c6022u.dismiss();
                    }
                    ToastManager.show(DownLoadDialogActivity.this, R.string.huaweiwallet_check_sdcard_permissions);
                    DownLoadDialogActivity.this.finish();
                    return;
                }
                LogC.m28530b("UpgradeDialogActivity install apk read sdcard have permission", false);
                DownLoadDialogActivity.this.downOrInstallApp(c6022u);
            }
        }, (Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private void downOrInstallApp(DialogInterface dialogInterface) {
        if (new File(this.unComponent.getAPKPath()).exists()) {
            installApk();
        } else if (C4026a.m19819a(getApplicationContext())) {
            downloadAPP(dialogInterface);
        } else {
            ToastManager.show((Context) this, R.string.no_network);
            dialogInterface.dismiss();
            finish();
        }
    }

    private void downloadAPP(DialogInterface dialogInterface) {
        this.unComponent.cleanTemp();
        this.savePath = this.unComponent.getLocalSavePath();
        this.unComponent.download(this.url, this.savePath);
        dialogInterface.dismiss();
    }

    private void showDownloadProgress(int i, String str) {
        if (!isFinishing()) {
            if (this.downloadDialog == null) {
                this.downloadDialog = new DownloadProgressDialog(this, R.style.common_dialog21);
            }
            if (!this.downloadDialog.isShowing()) {
                this.downloadDialog.setCanceledOnTouchOutside(false);
                this.downloadDialog.setCancelable(false);
                this.downloadDialog.show();
                this.downloadDialog.setOnKeyListener(new C55945());
            }
            this.downloadDialog.updateProgress(i, str);
        }
    }

    private void downloadDismiss() {
        if (this.downloadDialog != null && this.downloadDialog.isShowing()) {
            this.downloadDialog.dismiss();
        }
    }

    private void startProgress(String str) {
        if (this.progress == null) {
            C6002a c6002a = new C6002a(this, R.style.app_update_dialogActivity);
            this.progress = C6002a.m27468a((Context) this);
            this.progress.m27476a(str);
            this.progress.m27474a();
        }
        if (!isFinishing() && this.progress != null) {
            this.progress.show();
        }
    }

    private void installApk() {
        this.unComponent.install(this.signature);
        if (this.unComponent.isAppHasInstallPermission()) {
            startProgress(getString(R.string.nfc_relativite_apk_install_tip));
        } else {
            finish();
        }
    }

    private void createCancelDialog() {
        this.reminderDialog = PayAlertDialogFragment.newInstance(301, getString(R.string.nfc_card_list_dialog_title), getString(R.string.huaweipay_hcoin_cancel_download), getString(R.string.huaweipay_hcoin_use_flow_sure), getString(R.string.huaweipay_hcoin_use_flow_cancel), true);
        showFragmentTransactionDialogs(this.reminderDialog);
    }

    private void hidePromptDialog() {
        if (this.reminderDialog != null) {
            this.reminderDialog.dismiss();
        }
    }

    public void showFragmentTransactionDialogs(DialogFragment dialogFragment) {
        try {
            if (!isFinishing()) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.add(dialogFragment, "alertdialog");
                beginTransaction.commitAllowingStateLoss();
            }
        } catch (IllegalStateException e) {
            LogX.e("IllegalStateException", false);
        }
    }

    public void success(String str, String str2) {
        if (this.progress == null || !this.progress.isShowing()) {
            finish();
            return;
        }
        this.url = str;
        this.signature = str2;
        this.progress.dismiss();
        showDialog();
    }

    public void failed(int i, String str) {
        if (this.progress != null && this.progress.isShowing()) {
            this.progress.dismiss();
            ToastManager.show((Context) this, getString(R.string.no_network));
        }
        finish();
    }

    public void onAlertDialogPositiveClick(int i) {
        if (301 == i) {
            this.unComponent.cancelDown();
        }
    }

    public void onAlertDialogNegativeClick(int i) {
        if (301 == i) {
            hidePromptDialog();
        }
    }

    public void onAlertDialogKeyBack(int i) {
        if (301 == i) {
            hidePromptDialog();
        }
    }

    public void installSuccess() {
        if (this.progress != null && this.progress.isShowing()) {
            this.progress.dismiss();
        }
        this.unComponent.delete();
        setResult(-1);
        finish();
    }

    public void installFailed(int i, String str) {
        if (this.progress != null && this.progress.isShowing()) {
            this.progress.dismiss();
            ToastManager.show((Context) this, R.string.nfc_relativite_apk_install_failed);
        }
        this.unComponent.delete();
        finish();
    }

    public void downLoadSuccess(String str) {
        downloadDismiss();
        installApk();
    }

    public void downLoadFailed(int i) {
        if (this.progress != null && this.progress.isShowing()) {
            this.progress.dismiss();
        }
        if (i == 5) {
            ToastManager.show((Context) this, getString(R.string.nfc_relativite_apk_download_cancel));
        } else {
            ToastManager.show((Context) this, getString(R.string.nfc_relativite_apk_download_fail));
        }
        downloadDismiss();
        finish();
    }

    public void downProgress(int i, long j) {
        showDownloadProgress(i, Formatter.formatFileSize(this, j) + File.separator + this.totalSize);
    }

    public void downLoadConnected(long j) {
        this.totalSize = Formatter.formatFileSize(this, j);
        showDownloadProgress(0, Formatter.formatFileSize(this, 0) + File.separator + this.totalSize);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.unComponent != null) {
            this.unComponent.unregisterListeners();
        }
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

    private void loadApplicationTheme() {
        if (getApplicationContext().getTheme() == null) {
            LogX.i("loadApplicationTheme() if (theme == null)", false);
            return;
        }
        int identifier;
        if (BaseApplication.c() == b.b) {
            identifier = getResources().getIdentifier("HealthTheme", "style", WeChat.HEALTH_PACKAGE_NAME);
        } else {
            identifier = getResources().getIdentifier("WearTheme", "style", "com.huawei.bone");
        }
        if (identifier == 0) {
            LogX.i("onCreate if (themeId == 0)", false);
            return;
        }
        LogX.i("onCreate if (themeId == 0) ELSE themeId=" + identifier, false);
        setTheme(identifier);
    }
}
