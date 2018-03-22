package com.huawei.wallet.logic.down;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.wallet.logic.install.PackageInstallHelper;
import com.huawei.wallet.utils.crypto.PBKDF2;
import com.huawei.wallet.utils.log.LogC;
import com.huawei.wallet.utils.log.LogErrorConstant;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

public class AppDownManager {
    private static volatile Context f21216a;
    private AppInstallReceive f21217b;
    private Handler f21218c;
    private String f21219d;
    private String f21220e;
    private String f21221f;

    class AppInstallReceive extends BroadcastReceiver {
        final /* synthetic */ AppDownManager f21210a;

        private AppInstallReceive(AppDownManager appDownManager) {
            this.f21210a = appDownManager;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                CharSequence charSequence = null;
                String dataString = intent.getDataString();
                if (dataString != null) {
                    LogC.m28530b("intentData is not null", false);
                    charSequence = dataString.substring(8);
                }
                if (!TextUtils.isEmpty(charSequence) && this.f21210a.f21221f.equals(charSequence)) {
                    LogC.m28530b("AppDownManager onReceive install package success.", false);
                    if (this.f21210a.f21218c != null) {
                        this.f21210a.f21218c.sendEmptyMessage(333);
                    } else {
                        LogC.m28530b("AppDownManager onReceive mHandler is null.", false);
                    }
                    this.f21210a.m28010b();
                }
            }
        }
    }

    class MyIDownloadTaskListener implements IDownloadTaskListener {
        final /* synthetic */ AppDownManager f21211a;
        private String f21212b;
        private String f21213c;
        private Handler f21214d;

        private MyIDownloadTaskListener(AppDownManager appDownManager, String str, String str2, Handler handler) {
            this.f21211a = appDownManager;
            this.f21212b = str;
            this.f21213c = str2;
            this.f21214d = handler;
        }

        public void mo5141a(DownloadEntity downloadEntity, int i) {
            LogC.m28530b("AppDownManager startDownloadApp setProgress.", false);
            this.f21211a.m27997a(this.f21214d, 1002, i, null);
        }

        public void mo5142a(DownloadEntity downloadEntity, String str) {
            LogC.m28530b("AppDownManager startDownloadApp setDownloadSize.", false);
            this.f21211a.m27997a(this.f21214d, 1007, 0, (Object) str);
        }

        public void mo5140a(DownloadEntity downloadEntity) {
            LogC.m28530b("AppDownManager startDownloadApp onDownloadFinish.", false);
            AppBean appBean = new AppBean();
            appBean.m27981b(downloadEntity.m28019d());
            appBean.m27979a(this.f21212b);
            this.f21211a.m27997a(this.f21214d, 1009, 0, (Object) appBean);
        }

        public void mo5143b(DownloadEntity downloadEntity, int i) {
            LogC.m28530b("AppDownManager startDownloadApp onDownloadFail.", false);
            this.f21211a.m27997a(this.f21214d, 1001, 0, null);
        }

        public boolean mo5144b(DownloadEntity downloadEntity) {
            LogC.m28530b("AppDownManager startDownloadApp validate.", false);
            return this.f21211a.m28000a(downloadEntity, this.f21213c);
        }

        public void mo5145c(DownloadEntity downloadEntity) {
        }
    }

    class SingletoneHolder {
        static final AppDownManager f21215a = new AppDownManager();

        private SingletoneHolder() {
        }
    }

    private AppDownManager() {
    }

    public static AppDownManager m27995a(Context context) {
        m28003b(context);
        return SingletoneHolder.f21215a;
    }

    private static void m28003b(Context context) {
        if (f21216a == null) {
            if (context == null) {
                LogC.m28527a("AppDownManager getInstance context is null.", false);
                return;
            }
            BaseCommonContext.m28012a().m28013a(context);
            f21216a = context.getApplicationContext();
        }
    }

    public void m28008a(Context context, Handler handler, String str, String str2, String str3, long j, long j2) {
        if (context == null) {
            m27997a(handler, 1001, 0, null);
            LogC.m28534d("AppDownManager startDownloadApp context is null.", false);
        } else if (TextUtils.isEmpty(str)) {
            m27997a(handler, 1001, 0, null);
            LogC.m28534d("AppDownManager startDownloadApp downUrl is null.", false);
        } else {
            this.f21220e = DownloadManager.m28022a().m28023a(str, new MyIDownloadTaskListener(str2, str3, handler), j, j2);
        }
    }

    private boolean m28000a(DownloadEntity downloadEntity, String str) {
        if (downloadEntity == null) {
            LogC.m28534d("AppDownManager dealWithValidate, but entity is null.", false);
            return false;
        }
        boolean a = m28001a(str, downloadEntity.m28019d());
        LogC.m28530b("AppDownManager dealWithValidate isValidateOk = " + a, false);
        return a;
    }

    private boolean m28001a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogC.m28530b("AppDownManager encrypPkgSignName is null, do not validate.", false);
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            LogC.m28527a("AppDownManager filePath is null.", false);
            return false;
        } else {
            PackageInfo packageArchiveInfo = f21216a.getPackageManager().getPackageArchiveInfo(str2, 192);
            if (packageArchiveInfo == null) {
                LogC.m28534d("AppDownManager packageInfo is null.", false);
                return false;
            } else if (packageArchiveInfo.signatures == null) {
                LogC.m28534d("AppDownManager packageInfo.signatures is null.", false);
                return false;
            } else if (packageArchiveInfo.signatures.length <= 0) {
                LogC.m28534d("AppDownManager packageInfo.signatures.length <= 0 .", false);
                return false;
            } else if (!m28004b(packageArchiveInfo.signatures[0].toCharsString(), str)) {
                return false;
            } else {
                LogC.m28530b("AppDownManager validate success.", false);
                return true;
            }
        }
    }

    private boolean m28004b(String str, String str2) {
        try {
            if (PBKDF2.m28515a(str, str2)) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            LogC.m28529b("AppDownManager PBKDF2 validate sign name cause exception: ", e, false);
            return false;
        } catch (Throwable e2) {
            LogC.m28529b("AppDownManager PBKDF2 validate sign name cause exception: ", e2, false);
            return false;
        }
    }

    public void m28007a(Context context, Handler handler, String str, String str2) {
        this.f21219d = str2;
        boolean z = context == null;
        boolean isEmpty = TextUtils.isEmpty(this.f21219d);
        if (TextUtils.isEmpty(str)) {
            this.f21221f = str;
        } else {
            this.f21221f = str.replaceAll(HwAccountConstants.BLANK, "");
        }
        boolean isEmpty2 = TextUtils.isEmpty(this.f21221f);
        if (z || isEmpty || isEmpty2) {
            LogC.m28530b("AppDownManager installPackage isContextNu=" + z + "  isApkFilePathNu=" + isEmpty + " isPackageNameNu=" + isEmpty2, false);
            handler.sendEmptyMessage(-2001);
            return;
        }
        this.f21218c = handler;
        int a = m27994a(context, handler);
        LogC.m28530b("AppDownManager installPackage installCode =" + a, false);
        if (a == 1) {
            LogC.m28530b("AppDownManager installPackage silence.", false);
            handler.sendEmptyMessage(1005);
        } else if (a == 2) {
            LogC.m28530b("AppDownManager installPackage normal.", false);
            m28005d();
        }
    }

    private int m27994a(Context context, Handler handler) {
        PackageInstallHelper packageInstallHelper = new PackageInstallHelper();
        if (packageInstallHelper.m28057a(context)) {
            LogC.m28530b("AppDownManager installAppStatus slient.", false);
            if (packageInstallHelper.m28060b(context, handler, this.f21219d, this.f21221f)) {
                return 1;
            }
            return 3;
        }
        LogC.m28530b("AppDownManager installAppStatus normal.", false);
        if (packageInstallHelper.m28059a(context, this.f21219d)) {
            return 2;
        }
        return 3;
    }

    public void m28006a() {
        LogC.m28530b("AppDownManager finishDownFile.", false);
        DownloadManager.m28022a().m28025a(this.f21220e);
    }

    private void m27997a(Handler handler, int i, int i2, Object obj) {
        if (handler == null) {
            LogC.m28527a("AppDownManager sendDownMsg handler is null.", false);
            return;
        }
        Message obtainMessage = handler.obtainMessage(i);
        obtainMessage.arg1 = i2;
        obtainMessage.obj = obj;
        handler.sendMessage(obtainMessage);
    }

    private void m28005d() {
        LogC.m28530b("AppDownManager registerInstallReceiver.", false);
        if (f21216a == null) {
            LogC.m28527a("AppDownManager registerInstallReceiver mContext is null.", false);
            return;
        }
        this.f21217b = new AppInstallReceive();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        f21216a.registerReceiver(this.f21217b, intentFilter);
    }

    public void m28010b() {
        LogC.m28530b("AppDownManager unRegisterInstallReceiver.", false);
        if (f21216a == null) {
            LogC.m28527a("AppDownManager unRegisterInstallReceiver mContext is null.", false);
        } else if (this.f21217b == null) {
            LogC.m28527a("AppDownManager unRegisterInstallReceiver appInstallReceive is null.", false);
        } else {
            f21216a.unregisterReceiver(this.f21217b);
            this.f21217b = null;
        }
    }

    public void m28009a(String str) {
        if (f21216a == null) {
            LogC.m28534d("AppDownManager openHwMarketDetail mContext is null.", false);
        } else if (TextUtils.isEmpty(str)) {
            LogC.m28534d("AppDownManager openHwMarketDetail appDetailId is null.", false);
        } else {
            try {
                Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withid");
                intent.setPackage("com.huawei.appmarket");
                intent.putExtra(AppOpenOrDownHelper.APP_ID_PARAM, str);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                f21216a.startActivity(intent);
            } catch (Throwable e) {
                LogC.m28525a(" AppDownManager openHwMarketDetail case exception:", e, 907118103, LogErrorConstant.m28535a("AppDownManager.openHwMarketDetail", e.getMessage()), false, false);
            }
        }
    }

    public boolean m28011c() {
        List<ApplicationInfo> installedApplications = f21216a.getPackageManager().getInstalledApplications(0);
        if (installedApplications == null) {
            LogC.m28534d("AppDownManager packages is null.", false);
            return false;
        }
        for (ApplicationInfo applicationInfo : installedApplications) {
            if ("com.huawei.appmarket".equals(applicationInfo.packageName)) {
                LogC.m28530b("AppDownManager isMarketPackageInstalled market install.", false);
                return true;
            }
        }
        return false;
    }
}
