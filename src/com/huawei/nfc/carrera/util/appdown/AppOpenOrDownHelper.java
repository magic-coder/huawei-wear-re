package com.huawei.nfc.carrera.util.appdown;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.nfc.carrera.ui.dialog.DialogUtils;
import com.huawei.nfc.carrera.ui.dialog.DialogUtils.CustomAlertDialog;
import com.huawei.nfc.carrera.ui.dialog.DialogUtils.CustomProgressBarDialog;
import com.huawei.nfc.carrera.ui.dialog.DialogUtils.CustomProgressDialog;
import com.huawei.nfc.carrera.ui.dialog.DialogUtils.OnDialogKeyBackListener;
import com.huawei.nfc.carrera.ui.dialog.DialogUtils.OnDialogListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.pay.p130e.C5730c;
import com.huawei.pay.p473a.p476b.C5587b;
import com.huawei.pay.p473a.p476b.C5720a;
import com.huawei.pay.ui.util.ToastManager;
import com.huawei.wallet.R;
import com.huawei.wallet.logic.down.AppBean;
import com.huawei.wallet.logic.down.AppDownManager;
import java.io.File;
import java.lang.ref.WeakReference;

public class AppOpenOrDownHelper {
    public static final String APP_ID_PARAM = "appId";
    private static final String DOWN_LOAD_URL = "http://a.vmall.com/appdl/C27162";
    private static final String PACKAGE_NAME = "com.huawei.appmarket";
    public static final String PACKAGE_NAME_PARAM = "packageName";
    private String apkFilePath = null;
    private String appIdInAppMarket = null;
    private String appPkgName = null;
    private CustomAlertDialog cancelDownTipDialog;
    private CustomProgressBarDialog downProgressDialog;
    private DownAndInstallHandler handler = new DownAndInstallHandler(this);
    private CustomProgressDialog installMarketProgressDialog;
    private Context mContext = null;
    private CustomAlertDialog remindDownMarketDialog;

    class C56921 extends Thread {
        C56921() {
        }

        public void run() {
            if (!TextUtils.isEmpty(AppOpenOrDownHelper.this.apkFilePath)) {
                File file = new File(AppOpenOrDownHelper.this.apkFilePath);
                if (file.exists() && !file.delete()) {
                    LogX.e("AppOpenOrDownHelper delete appMarket apkFile failed.", false);
                }
            }
        }
    }

    class CancelDownMarketListener implements OnDialogListener {
        private CancelDownMarketListener() {
        }

        public void onKeyBack() {
            AppOpenOrDownHelper.this.closeCancelDownDialog();
        }

        public void onPositiveButtonClick() {
            AppOpenOrDownHelper.this.closeCancelDownDialog();
            AppDownManager.m27995a(AppOpenOrDownHelper.this.mContext).m28006a();
        }

        public void onNegativeButtonClick() {
            AppOpenOrDownHelper.this.closeCancelDownDialog();
        }
    }

    class DownAndInstallHandler extends Handler {
        private WeakReference<AppOpenOrDownHelper> mWeakHelper;

        public DownAndInstallHandler(AppOpenOrDownHelper appOpenOrDownHelper) {
            this.mWeakHelper = new WeakReference(appOpenOrDownHelper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            AppOpenOrDownHelper appOpenOrDownHelper = (AppOpenOrDownHelper) this.mWeakHelper.get();
            if (appOpenOrDownHelper == null) {
                LogX.w("AppOpenOrDownHelper handler activity is null.", false);
            } else {
                appOpenOrDownHelper.dealWithMesg(message);
            }
        }
    }

    class DownloadProgressListener implements OnDialogKeyBackListener {
        private DownloadProgressListener() {
        }

        public void onKeyBack() {
            AppOpenOrDownHelper.this.createCancelDownDialog();
        }
    }

    class MyPermissionsResultsCallback implements C5587b {
        private MyPermissionsResultsCallback() {
        }

        public void onRequestPermissionsResult(int[] iArr) {
            boolean z = iArr != null && iArr.length > 0 && iArr[0] == 0;
            if (z) {
                LogX.i("AppOpenOrDownHelper down apk write sdcard have permission, start down.", false);
                AppOpenOrDownHelper.this.handleDownloadNow();
                return;
            }
            LogX.i("AppOpenOrDownHelper down apk write sdcard have not permission", false);
        }
    }

    class RemindDownMarketListener implements OnDialogListener {
        private RemindDownMarketListener() {
        }

        public void onKeyBack() {
            AppOpenOrDownHelper.this.closeRemindDownMarketDialog();
        }

        public void onPositiveButtonClick() {
            AppOpenOrDownHelper.this.startDownAppMarket();
        }

        public void onNegativeButtonClick() {
            AppOpenOrDownHelper.this.closeRemindDownMarketDialog();
        }
    }

    public AppOpenOrDownHelper(Context context, String str, String str2) {
        this.mContext = context;
        this.appPkgName = str;
        this.appIdInAppMarket = str2;
    }

    public void startOpenOrDown() {
        if (C5730c.m26409a(this.mContext, this.appPkgName)) {
            try {
                this.mContext.startActivity(this.mContext.getPackageManager().getLaunchIntentForPackage(this.appPkgName));
            } catch (Throwable e) {
                LogX.e("starting BankApp occurs ActivityNotFoundException.", e, false);
            }
        } else if (AppDownManager.m27995a(this.mContext).m28011c()) {
            AppDownManager.m27995a(this.mContext).m28009a(this.appIdInAppMarket);
        } else {
            createRemindDownMarketDialog();
        }
    }

    private void createRemindDownMarketDialog() {
        this.remindDownMarketDialog = DialogUtils.createAlertDialog(this.mContext, null, this.mContext.getString(R.string.reminder_down_market_description), this.mContext.getString(R.string.down_btn), this.mContext.getString(R.string.cancel), true, new RemindDownMarketListener());
        this.remindDownMarketDialog.show();
    }

    private void closeRemindDownMarketDialog() {
        if (this.remindDownMarketDialog != null) {
            this.remindDownMarketDialog.dismiss();
        }
    }

    private void startDownAppMarket() {
        C5720a.m26366a().m26370a(this.mContext.getApplicationContext());
        C5720a.m26366a().m26372a(new MyPermissionsResultsCallback(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private void handleDownloadNow() {
        if (C4026a.m19819a(this.mContext)) {
            createDownloadProgressDialog();
            AppDownManager.m27995a(this.mContext).m28008a(this.mContext, this.handler, DOWN_LOAD_URL, PACKAGE_NAME, null, 0, 0);
            return;
        }
        ToastManager.show(this.mContext, R.string.no_network);
    }

    private void createDownloadProgressDialog() {
        this.downProgressDialog = DialogUtils.createProgressBarDialog(this.mContext, new DownloadProgressListener());
        this.downProgressDialog.show();
    }

    private void closeDownProgressDialog() {
        if (this.downProgressDialog != null) {
            this.downProgressDialog.dismiss();
        }
    }

    private void createCancelDownDialog() {
        this.cancelDownTipDialog = DialogUtils.createAlertDialog(this.mContext, this.mContext.getString(R.string.huaweipay_hcoin_cancel_download), null, this.mContext.getString(R.string.huaweipay_hcoin_use_flow_sure), this.mContext.getString(R.string.huaweipay_hcoin_use_flow_cancel), true, new CancelDownMarketListener());
        this.cancelDownTipDialog.show();
    }

    private void closeCancelDownDialog() {
        if (this.cancelDownTipDialog != null) {
            this.cancelDownTipDialog.dismiss();
        }
    }

    private void createInstallMarketProgressDialog() {
        this.installMarketProgressDialog = DialogUtils.createProgressDialog(this.mContext, R.string.hwpay_installing);
        this.installMarketProgressDialog.show();
    }

    private void closeInstallMarketProgressDialog() {
        if (this.installMarketProgressDialog != null) {
            this.installMarketProgressDialog.dismiss();
        }
    }

    private void jumpToAppMarketDetail() {
        if (TextUtils.isEmpty(this.appIdInAppMarket)) {
            LogX.d("AppOpenOrDownHelper JumpHwMarketDetail appIdInAppMarket is null.", false);
        } else {
            AppDownManager.m27995a(this.mContext).m28009a(this.appIdInAppMarket);
        }
    }

    public void onDestroy() {
        AppDownManager.m27995a(this.mContext).m28010b();
    }

    private void dealWithMesg(Message message) {
        switch (message.what) {
            case -2001:
                LogX.i("AppOpenOrDownHelper install silence fail.", false);
                closeInstallMarketProgressDialog();
                deleteDownFile();
                return;
            case 1:
                LogX.i("AppOpenOrDownHelper install silence success.", false);
                closeInstallMarketProgressDialog();
                deleteDownFile();
                jumpToAppMarketDetail();
                return;
            case 333:
                LogX.i("AppOpenOrDownHelper install normal success.", false);
                jumpToAppMarketDetail();
                deleteDownFile();
                return;
            case 1001:
                LogX.d("AppOpenOrDownHelper down fail.", false);
                closeRemindDownMarketDialog();
                closeDownProgressDialog();
                closeCancelDownDialog();
                return;
            case 1002:
                this.downProgressDialog.updateProgress(message.arg1);
                return;
            case 1005:
                LogX.i("AppOpenOrDownHelper install silence.", false);
                createInstallMarketProgressDialog();
                return;
            case 1007:
                this.downProgressDialog.udpateView((String) message.obj);
                return;
            case 1009:
                LogX.i("AppOpenOrDownHelper down success.", false);
                closeRemindDownMarketDialog();
                closeDownProgressDialog();
                closeCancelDownDialog();
                dealDownSuccessMsg(message);
                return;
            default:
                return;
        }
    }

    private void dealDownSuccessMsg(Message message) {
        AppBean appBean = null;
        if (message.obj != null) {
            appBean = (AppBean) message.obj;
        }
        if (appBean != null) {
            this.apkFilePath = appBean.m27980b();
            AppDownManager.m27995a(this.mContext).m28007a(this.mContext, this.handler, appBean.m27978a(), appBean.m27980b());
            return;
        }
        LogX.e("AppOpenOrDownHelper dealDownSuccessMsg appBeans is null.", false);
    }

    private void deleteDownFile() {
        new C56921().start();
    }
}
