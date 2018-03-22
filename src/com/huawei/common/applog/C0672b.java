package com.huawei.common.applog;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import com.huawei.common.applog.bean.C0673d;
import com.huawei.feedback.C0811c;
import com.huawei.feedback.C0821e;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.logupload.C0670g.C0671a;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.huawei.phoneserviceuni.common.p132d.C1372a;
import com.huawei.phoneserviceuni.common.p132d.p133a.p135b.C1371b;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: AppLogPackLogService */
class C0672b extends C0671a {
    final /* synthetic */ AppLogPackLogService f1226a;

    C0672b(AppLogPackLogService appLogPackLogService) {
        this.f1226a = appLogPackLogService;
    }

    public Bundle mo2127a() {
        Context applicationContext = this.f1226a.getApplicationContext();
        C0671a c0671a = this.f1226a.f1225b;
        if (C0811c.m2772a(applicationContext, C0671a.getCallingUid())) {
            Bundle b;
            String str = this.f1226a.getApplicationContext().getFilesDir().getPath() + File.separator + "feedbacklogs";
            String str2 = Build.MODEL;
            String str3 = Build.DISPLAY;
            String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String a = C1371b.m6104a(C1372a.m6117c(this.f1226a.getApplicationContext()).toUpperCase(Locale.US));
            String str4 = "app-" + this.f1226a.getApplicationContext().getPackageName();
            String b2 = C1372a.m6114b(this.f1226a.getApplicationContext().getPackageName(), this.f1226a.getApplicationContext());
            str2 = str2.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
            str3 = str3.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
            str4 = str4.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
            if (b2 != null) {
                b2 = b2.replace(HwAccountConstants.SPLIIT_UNDERLINE, "-");
            }
            String str5 = "/" + str2 + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + format + HwAccountConstants.SPLIIT_UNDERLINE + str4 + HwAccountConstants.SPLIIT_UNDERLINE + b2 + LightCloudConstants.ZIP_POSTFIX;
            str2 = str + ("/temp_" + str2 + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + format + HwAccountConstants.SPLIIT_UNDERLINE + str4 + HwAccountConstants.SPLIIT_UNDERLINE + b2 + LightCloudConstants.ZIP_POSTFIX);
            str3 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Huawei/phoneservice" + str5;
            byte[] bArr = new byte[11];
            C0821e.m2884a(bArr);
            format = "AESV2" + Base64.encodeToString(bArr, 2);
            if (VERSION.SDK_INT >= 24 && this.f1226a.checkSelfPermission("android.permission.WRITE_MEDIA_STORAGE") == 0) {
                b = this.f1226a.m2668b(str3, str2, str, format);
            } else if (VERSION.SDK_INT <= 22 || this.f1226a.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                b = this.f1226a.m2668b(str3, str2, str, format);
            } else {
                Intent intent = new Intent();
                intent.setFlags(32768);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClass(this.f1226a.getApplicationContext(), SdCardPermissionActvity.class);
                this.f1226a.startActivity(intent);
                synchronized (this.f1226a.f1224a) {
                    C0673d.m2673a().m2674a(this.f1226a.f1224a);
                    while (C0673d.m2673a().m2677b()) {
                        try {
                            C1103f.m4880d("AppLogApi/AppLogPackLogService", "AppLogPackLogService wait....");
                            this.f1226a.f1224a.wait();
                        } catch (InterruptedException e) {
                            C1103f.m4880d("AppLogApi/AppLogPackLogService", "AppLogPackLogService  InterruptedException" + e.getMessage());
                        }
                    }
                }
                if (C0673d.m2673a().m2679d()) {
                    b = this.f1226a.m2668b(str3, str2, str, format);
                } else {
                    this.f1226a.m2663a();
                    return this.f1226a.m2662a(RetCode.FAILED_100002, "no sdcard permission", "", "");
                }
            }
            this.f1226a.m2663a();
            return b;
        }
        C1103f.m4880d("AppLogApi/AppLogPackLogService", "auth fail");
        this.f1226a.stopSelf();
        return this.f1226a.m2662a("100001", "auth fail", "", "");
    }
}
