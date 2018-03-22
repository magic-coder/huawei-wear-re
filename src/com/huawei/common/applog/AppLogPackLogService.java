package com.huawei.common.applog;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.common.applog.bean.C0673d;
import com.huawei.feedback.C0811c;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.logupload.C0670g.C0671a;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.phoneserviceuni.common.p132d.p133a.p134a.C1369a;
import com.huawei.phoneserviceuni.common.p132d.p133a.p135b.p136a.C1370a;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.File;

public class AppLogPackLogService extends Service {
    public final Object f1224a = new Object();
    C0671a f1225b = new C0672b(this);

    public IBinder onBind(Intent intent) {
        C1103f.m4879c("AppLogApi/AppLogPackLogService", "onBind");
        return this.f1225b;
    }

    private Bundle m2662a(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("status", str);
        bundle.putString(WBConstants.ACTION_LOG_TYPE_MESSAGE, str2);
        bundle.putString("filePath", str3);
        bundle.putString("encryKey", str4);
        return bundle;
    }

    private Bundle m2668b(String str, String str2, String str3, String str4) {
        String[] strArr;
        int i = 0;
        if (TextUtils.isEmpty(str3)) {
            strArr = null;
        } else {
            C1103f.m4878b("AppLogApi/AppLogPackLogService", "logwritePath" + str3);
            strArr = C0811c.m2776a(str3);
        }
        if (strArr == null) {
            return m2662a("100004", "get log fail", "", "");
        }
        int length = strArr.length;
        if (length > 0) {
            File[] fileArr = new File[length];
            for (int i2 = 0; i2 < length; i2++) {
                C1103f.m4878b("AppLogApi/AppLogPackLogService", UploadFile.FILE_NAME + strArr[i2]);
                fileArr[i2] = new File(strArr[i2]);
            }
            File file = new File(str2);
            C1103f.m4878b("AppLogApi/AppLogPackLogService", "waitUploadZipfile" + file.getPath());
            while (i < 2) {
                if (C0811c.m2775a(fileArr, file, getApplicationContext())) {
                    C1103f.m4878b("AppLogApi/AppLogPackLogService", "waitUploadZipfile zipflag good");
                    if (TextUtils.isEmpty(str4)) {
                        m2665a(file);
                        return m2662a("100005", "secretKey is null", "", "");
                    }
                    String a = C1369a.m6093a(str4);
                    if (TextUtils.isEmpty(a)) {
                        m2665a(file);
                        C1103f.m4880d("AppLogApi/AppLogPackLogService", "encryptKey null,encryptFile failed!");
                        return m2662a("100005", "secretKey is null", "", "");
                    }
                    File a2 = C1370a.m6098a(file, a, true, getApplicationContext());
                    if (a2 == null || !a2.exists()) {
                        return m2662a("100003", "Write data to sdcard failed ", "", "");
                    }
                    m2666a(a2, new File(str));
                    m2665a(file);
                    return m2662a("0", "", str, str4);
                } else if (i == 1) {
                    C1103f.m4879c("AppLogApi/AppLogPackLogService", "zipflag fail!");
                    return m2662a("100004", "zip fail", "", "");
                } else {
                    i++;
                }
            }
        }
        return m2662a("100005", "other exception", "", "");
    }

    private boolean m2666a(File file, File file2) {
        return file.renameTo(file2);
    }

    private void m2665a(File file) {
        if (file.exists()) {
            int i = 0;
            while (i < 2) {
                boolean delete = file.delete();
                C1103f.m4878b("AppLogApi/AppLogPackLogService", "resultZipFile delete success ? " + delete);
                if (!delete) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void m2663a() {
        stopSelf();
        C0673d.m2673a().m2680e();
    }

    public void onDestroy() {
        super.onDestroy();
        C0673d.m2673a().m2680e();
    }
}
