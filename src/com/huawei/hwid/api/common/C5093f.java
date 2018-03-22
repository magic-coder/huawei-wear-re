package com.huawei.hwid.api.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.C5183n;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: CloudAccountManagerDialog */
public class C5093f extends Builder {
    private CloudRequestHandler f18366a;
    private String f18367b;
    private Context f18368c;
    private AlertDialog f18369d;
    private String f18370e;
    private String f18371f;

    public C5093f(Activity activity, String str, final Bundle bundle, CloudRequestHandler cloudRequestHandler) {
        super(activity, C5183n.m25066a(activity));
        this.f18368c = activity;
        this.f18366a = cloudRequestHandler;
        this.f18367b = str;
        if (bundle != null) {
            this.f18370e = bundle.getString("serviceToken");
            this.f18371f = bundle.getString(CloudAccount.KEY_APP_ID_WEB);
        }
        setAdapter(new ArrayAdapter(this.f18368c, C5180k.m25031d(this.f18368c, "cs_listview_item_more_account"), C5180k.m25032e(this.f18368c, "id_txt"), activity.getResources().getTextArray(C5180k.m25030c(this.f18368c, "CS_account_manager_array"))), new OnClickListener(this) {
            final /* synthetic */ C5093f f18365b;

            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        if (C5088d.m24488a(this.f18365b.f18368c, this.f18365b.f18367b)) {
                            this.f18365b.m24538a(this.f18365b.f18368c);
                            return;
                        } else {
                            this.f18365b.m24539a(this.f18365b.f18368c, bundle);
                            return;
                        }
                    case 1:
                        this.f18365b.m24537a();
                        return;
                    case 2:
                        this.f18365b.m24540b();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void m24538a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.hwid.ACTION_MAIN_SETTINGS");
            intent.setPackage("com.huawei.hwid");
            intent.putExtra(HwAccountConstants.EXTRA_IS_GOTO_WELCOME, true);
            context.startActivity(intent);
        } catch (Throwable e) {
            C5165e.m24909c("CloudAccountManagerDialog", e.getMessage(), e);
        }
    }

    public void m24539a(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction(HwAccountConstants.ACTION_ACCOUNT_CENTER_CLOUD);
            intent.putExtra(CloudAccount.KEY_SERVICE_TOKEN_WEB, this.f18370e);
            intent.putExtra(CloudAccount.KEY_APP_ID_WEB, this.f18371f);
            intent.putExtra(CloudAccount.KEY_USER_ACCOUNT_WEB, this.f18367b);
            intent.putExtras(bundle);
            if (context != null) {
                intent.setPackage(context.getPackageName());
                context.startActivity(intent);
            }
        } catch (Throwable e) {
            C5165e.m24909c("CloudAccountManagerDialog", e.getMessage(), e);
        }
    }

    public void m24537a() {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", 1);
        this.f18366a.onFinish(bundle);
    }

    public void m24540b() {
        if (this.f18369d != null && this.f18369d.isShowing()) {
            this.f18369d.dismiss();
        }
    }

    public AlertDialog show() {
        this.f18369d = super.show();
        return this.f18369d;
    }
}
