package com.huawei.common.applog;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.InputDeviceCompat;
import com.huawei.common.applog.bean.C0673d;
import com.huawei.feedback.C0811c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.logupload.p090c.C1103f;

public class SdCardPermissionActvity extends Activity {
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == InputDeviceCompat.SOURCE_TOUCHSCREEN) {
            C1103f.m4880d("AppLogApi/SdCardPermissionActvity", "agree sdcard permission ?=" + m2670a(iArr));
            m2669a(m2670a(iArr));
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        getWindow().setSoftInputMode(16);
        if (!C0811c.m2770a((Activity) this, "android.permission.WRITE_EXTERNAL_STORAGE", (int) InputDeviceCompat.SOURCE_TOUCHSCREEN)) {
            m2669a(true);
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        C1103f.m4880d("AppLogApi/SdCardPermissionActvity", "in onstop() not allowed sdcard permission");
        m2669a(false);
        finish();
    }

    private void m2669a(boolean z) {
        synchronized (C0673d.m2673a().m2678c()) {
            C0673d.m2673a().m2675a(false);
            C0673d.m2673a().m2676b(z);
            C0673d.m2673a().m2678c().notifyAll();
        }
    }

    private boolean m2670a(int[] iArr) {
        if (iArr == null || iArr.length < 1 || iArr[0] != 0) {
            return false;
        }
        return true;
    }
}
