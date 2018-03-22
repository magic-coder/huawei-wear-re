package com.squareup.leakcanary.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.squareup.leakcanary.R$string;

@TargetApi(23)
public class RequestStoragePermissionActivity extends Activity {
    public static PendingIntent createPendingIntent(Context context) {
        LeakCanaryInternals.setEnabledBlocking(context, RequestStoragePermissionActivity.class, true);
        Intent intent = new Intent(context, RequestStoragePermissionActivity.class);
        intent.setFlags(335544320);
        return PendingIntent.getActivity(context, 1, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            return;
        }
        if (hasStoragePermission()) {
            finish();
            return;
        }
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 42);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!hasStoragePermission()) {
            Toast.makeText(getApplication(), R$string.leak_canary_permission_not_granted, 1).show();
        }
        finish();
    }

    private boolean hasStoragePermission() {
        return checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
