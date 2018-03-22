package com.huawei.pay.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.ag.g;
import com.huawei.cp3.widget.C4372a;
import com.huawei.cp3.widget.p382a.p383a.C4370a;
import com.huawei.pay.e.c.a;
import com.huawei.pay.p473a.p476b.C5720a;
import com.huawei.pay.p473a.p476b.C5721c;
import com.huawei.pay.ui.baseactivity.BaseActivity;
import com.huawei.wallet.utils.UIUtil;
import com.huawei.wallet.utils.log.LogErrorConstant;

@SuppressLint({"NewApi"})
public final class PermissionsActivity extends BaseActivity {
    public static final String EXTRA_PERMISSION_REQUESTED_PERMISSIONS = "requested_permissions";
    public static final String EXTRA_PERMISSION_REQUEST_CODE = "request_code";
    private static final int INVALID_REQUEST_CODE = -1;
    public static final String PERMISSION_CACHE_NAME = "permission_requested_cache";
    private int mPendingRequestCode = -1;
    private SharedPreferences sp;

    public interface PermissionsActivitySAI1 {
    }

    public interface PermissionsActivitySAI2 {
    }

    public interface PermissionsActivitySAI3 {
    }

    public interface PermissionsActivitySAI4 {
    }

    public interface PermissionsActivitySAI5 {
    }

    public interface PermissionsActivitySAI6 {
    }

    private void setPermissionCache(String[] strArr, Boolean bool) {
        for (String putBoolean : strArr) {
            this.sp.edit().putBoolean(putBoolean, bool.booleanValue()).commit();
        }
    }

    private boolean isPermissionCached(String str) {
        return this.sp.getBoolean(str, false);
    }

    public static void run(Context context, int i, String... strArr) {
        Intent intent = new Intent(context.getApplicationContext(), PermissionsActivity.class);
        intent.putExtra(EXTRA_PERMISSION_REQUESTED_PERMISSIONS, strArr);
        intent.putExtra(EXTRA_PERMISSION_REQUEST_CODE, i);
        intent.addFlags(276824064);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        int i = -1;
        super.onCreate(bundle);
        UIUtil.m28490b(this);
        this.sp = getApplicationContext().getSharedPreferences(PERMISSION_CACHE_NAME, 0);
        a.b("permissions check onCreate", false);
        if (bundle != null) {
            i = bundle.getInt(EXTRA_PERMISSION_REQUEST_CODE, -1);
        }
        this.mPendingRequestCode = i;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(EXTRA_PERMISSION_REQUEST_CODE, this.mPendingRequestCode);
    }

    protected void onResume() {
        super.onResume();
        if (this.mPendingRequestCode == -1) {
            Bundle bundle = null;
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            }
            if (bundle != null) {
                String[] stringArray = bundle.getStringArray(EXTRA_PERMISSION_REQUESTED_PERMISSIONS);
                this.mPendingRequestCode = bundle.getInt(EXTRA_PERMISSION_REQUEST_CODE);
                if (C5721c.m26376a((Activity) this, stringArray) || isHaveFirstRequestPermission(stringArray)) {
                    C5721c.m26375a(this, this.mPendingRequestCode, stringArray);
                } else {
                    showPermissionDialog(this, this.mPendingRequestCode, stringArray);
                }
            }
        }
    }

    private boolean isHaveFirstRequestPermission(String[] strArr) {
        for (String isPermissionCached : strArr) {
            if (!isPermissionCached(isPermissionCached)) {
                return true;
            }
        }
        return false;
    }

    private void showPermissionDialog(final Activity activity, final int i, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(getString(g.permissions_tips));
        for (Object obj : strArr) {
            stringBuilder.append("\n");
            Integer num = (Integer) C5721c.f19500a.get(obj);
            if (num != null) {
                stringBuilder.append(getString(num.intValue()));
            }
        }
        C4370a a = C4372a.m20997a((Context) this);
        a.mo4428a(getString(g.huaweipay_note));
        a.mo4431b(stringBuilder.toString());
        a.mo4427a(getString(g.go_settings), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PermissionsActivity.this.openManangePermissionUI(activity, i);
                dialogInterface.dismiss();
            }
        });
        a.mo4430b(getString(g.cancel), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                PermissionsActivity.this.onRequestPermissionsResult(i, new String[0], new int[0]);
            }
        });
        a.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    dialogInterface.dismiss();
                    PermissionsActivity.this.onRequestPermissionsResult(i, new String[0], new int[0]);
                }
                return false;
            }
        });
        a.setCanceledOnTouchOutside(false);
        a.show();
    }

    public void openManangePermissionUI(Activity activity, int i) {
        if (activity == null) {
            a.c("openManangePermissionUI activity is null ", false);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), null));
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            a.a("start action android.intent.action.MANAGE_APP_PERMISSIONS ActivityNotFoundException error", 907118103, LogErrorConstant.m28535a("PermissionsActivity.openManangePermissionUI", e.getMessage()), false);
            onRequestPermissionsResult(i, new String[0], new int[0]);
        } catch (SecurityException e2) {
            a.a("start action android.intent.action.MANAGE_APP_PERMISSIONS java.lang.SecurityException==Permission Denial error", 907118104, LogErrorConstant.m28535a("PermissionsActivity.openManangePermissionUI", e2.getMessage()), false);
            onRequestPermissionsResult(i, new String[0], new int[0]);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        onRequestPermissionsResult(i, new String[0], new int[0]);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        a.b(" permission activity onRequestPermissionsResult ", false);
        this.mPendingRequestCode = -1;
        setPermissionCache(strArr, Boolean.valueOf(true));
        finish();
        C5720a.m26366a().m26369a(i, strArr, iArr);
    }
}
