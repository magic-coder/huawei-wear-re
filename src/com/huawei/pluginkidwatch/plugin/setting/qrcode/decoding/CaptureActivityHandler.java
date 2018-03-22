package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.a;
import com.google.zxing.client.a.q;
import com.google.zxing.client.a.u;
import com.google.zxing.m;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.plugin.setting.activity.BindbyQrActivity;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a.C1947d;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.view.C1970a;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.view.ViewfinderView;
import java.util.Vector;

public final class CaptureActivityHandler extends Handler {
    private static final String f6787a = ("KIDWATCH_" + CaptureActivityHandler.class.getSimpleName());
    private final C1964k f6788b;
    private C1962i f6789c = C1962i.f6811b;
    private boolean f6790d;
    private String f6791e;
    private Context f6792f;
    private Activity f6793g;
    private C1966m f6794h;
    private ViewfinderView f6795i;

    public CaptureActivityHandler(Context context, C1966m c1966m, ViewfinderView viewfinderView, Vector<a> vector, String str) {
        this.f6792f = context;
        this.f6793g = (Activity) context;
        this.f6794h = c1966m;
        this.f6795i = viewfinderView;
        this.f6788b = new C1964k(this, vector, str, new C1970a(viewfinderView));
        this.f6788b.start();
        C1947d.m10193a().m10201d();
        m10225c();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == g.auto_focus) {
            if (this.f6789c == C1962i.PREVIEW) {
                C1947d.m10193a().m10199b(this, g.auto_focus);
            }
        } else if (message.what == g.restart_preview) {
            C2538c.m12674b(f6787a, "Got restart preview message");
            m10225c();
        } else if (message.what == g.decode_succeeded) {
            C2538c.m12674b(f6787a, "Got decode succeeded message");
            this.f6789c = C1962i.f6811b;
            Bundle data = message.getData();
            Bitmap bitmap = data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap");
            String a = ((m) message.obj).a();
            C2538c.m12674b(f6787a, "===www123======--str_result:" + a);
            m10212a((m) message.obj, bitmap);
        } else if (message.what == g.decode_failed) {
            this.f6789c = C1962i.PREVIEW;
            C1947d.m10193a().m10196a(this.f6788b.m10228a(), g.decode);
        } else if (message.what == g.return_scan_result) {
            C2538c.m12674b(f6787a, "Got return scan result message");
            this.f6793g.setResult(-1, (Intent) message.obj);
            this.f6793g.finish();
        }
    }

    private void m10212a(m mVar, Bitmap bitmap) {
        if (mVar != null && !"".equals(mVar.toString())) {
            String[] split;
            String mVar2 = mVar.toString();
            if (mVar2.contains("#")) {
                split = mVar2.split("#");
            } else {
                split = mVar2.split(";");
            }
            if (split.length >= 4) {
                m10213a(mVar, bitmap, split);
            } else {
                m10209a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title, C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_nothing_msg, C1680l.IDS_plugin_kidwatch_common_cancel, C1680l.IDS_plugin_kidwatch_common_restart_str);
            }
        }
    }

    private void m10213a(m mVar, Bitmap bitmap, String[] strArr) {
        String str = strArr[2];
        String str2 = null;
        if (strArr.length >= 4) {
            str2 = strArr[3];
        }
        String substring = str.substring("IMEI:".length(), str.length());
        if (!str.startsWith("IMEI:") || "".equals(substring)) {
            m10209a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title, C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_nothing_msg, C1680l.IDS_plugin_kidwatch_common_cancel, C1680l.IDS_plugin_kidwatch_common_restart_str);
            return;
        }
        int d = C1467b.m6789d(this.f6792f);
        C2538c.m12677c(f6787a, "===www123========Enter processScanResult currentDeviceType=======" + d);
        C2538c.m12674b(f6787a, "===www123========Enter processScanResult str.length=======" + strArr.length);
        if (!m10219a(mVar, bitmap, strArr, str2, d)) {
            m10215a(str2, mVar, bitmap);
        }
    }

    private boolean m10219a(m mVar, Bitmap bitmap, String[] strArr, String str, int i) {
        if (strArr.length > 4) {
            C2538c.m12674b(f6787a, "===www123======Enter processScanResult have deviceType=======");
            String str2 = strArr[4];
            C2538c.m12677c(f6787a, "===www123======Enter processScanResult deviceType=======" + str2);
            if (m10218a(mVar, bitmap, str, i, str2)) {
                return true;
            }
        }
        C2538c.m12677c(f6787a, "===www123========Enter processScanResult k2 进入 k1=======");
        this.f6791e = this.f6792f.getResources().getString(C1680l.f4396xd64b2e7c, new Object[]{this.f6792f.getResources().getString(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k1)});
        C1467b.m6788c(this.f6792f, 5);
        if (7 == i) {
            m10216a(this.f6791e, str, mVar, bitmap);
            return true;
        }
        return false;
    }

    private boolean m10218a(m mVar, Bitmap bitmap, String str, int i, String str2) {
        if (7 == i) {
            if ("DT:1".equals(str2)) {
                C2538c.m12677c(f6787a, "===www123========Enter processScanResult 从K2进入=======结果为K2");
                C1467b.m6788c(this.f6792f, 7);
            } else {
                C1467b.m6788c(this.f6792f, 5);
                this.f6791e = this.f6792f.getResources().getString(C1680l.f4396xd64b2e7c, new Object[]{this.f6792f.getResources().getString(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k1)});
                m10216a(this.f6791e, str, mVar, bitmap);
                return true;
            }
        } else if (5 == i) {
            if ("DT:0".equals(str2) || "".equals(str2)) {
                C2538c.m12677c(f6787a, "===www123========Enter processScanResult 从K1进入=======结果为K1");
                C1467b.m6788c(this.f6792f, 5);
            } else {
                C1467b.m6788c(this.f6792f, 7);
                this.f6791e = this.f6792f.getResources().getString(C1680l.f4396xd64b2e7c, new Object[]{this.f6792f.getResources().getString(C1680l.IDS_plugin_kidwatch_common_kids_watch_name_k2)});
                m10216a(this.f6791e, str, mVar, bitmap);
                return true;
            }
        }
        return false;
    }

    private void m10215a(String str, m mVar, Bitmap bitmap) {
        if (str != null && str.startsWith("ST:")) {
            String substring = str.substring("ST:".length(), str.length());
            if ("00".equals(substring) || "05".equals(substring)) {
                m10217a(mVar);
            } else if ("01".equals(substring)) {
                m10210a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title, String.format(this.f6792f.getResources().getString(C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_status_1), new Object[]{Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(10)}), C1680l.IDS_plugin_kidwatch_common_cancel, C1680l.IDS_plugin_kidwatch_common_restart_str);
            } else if ("03".equals(substring)) {
                m10209a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title, C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_status_3, C1680l.IDS_plugin_kidwatch_common_cancel, C1680l.IDS_plugin_kidwatch_common_restart_str);
            } else if ("06".equals(substring)) {
                m10209a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title, C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_status_6, C1680l.IDS_plugin_kidwatch_common_cancel, C1680l.IDS_plugin_kidwatch_common_restart_str);
            } else {
                m10209a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title, C1680l.IDS_plugin_kidwatch_settings_bind_qrcode_scan_status_other, C1680l.IDS_plugin_kidwatch_common_cancel, C1680l.IDS_plugin_kidwatch_common_restart_str);
            }
        } else if (!m10217a(mVar)) {
            C1947d.m10193a().m10202e();
        }
    }

    private boolean m10217a(m mVar) {
        this.f6794h.m10231b();
        q qVar = null;
        if (mVar != null) {
            qVar = u.d(mVar);
        }
        Intent intent = new Intent();
        intent.setPackage(this.f6792f.getPackageName());
        intent.setClass(this.f6792f, BindbyQrActivity.class);
        if (qVar == null) {
            intent.putExtra("qrcode_result", "");
        } else {
            intent.putExtra("qrcode_result", qVar.toString());
        }
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        this.f6792f.startActivity(intent);
        return true;
    }

    private void m10216a(String str, String str2, m mVar, Bitmap bitmap) {
        C2538c.m12674b(f6787a, "======Enter processError");
        m10211a(C1680l.IDS_plugin_kidwatch_common_ui_notice_title, str, C1680l.IDS_plugin_kidwatch_common_know_tips, C1680l.IDS_plugin_kidwatch_common_know_tips, str2, mVar, bitmap);
    }

    private void m10211a(int i, String str, int i2, int i3, String str2, m mVar, Bitmap bitmap) {
        this.f6790d = true;
        C1595v c1595v = new C1595v(this.f6792f);
        c1595v.m7339a(i);
        c1595v.m7351b(str);
        c1595v.m7340a(i2, new C1954a(this));
        c1595v.m7347a(false);
        CustomDialog a = c1595v.m7338a();
        a.setOnDismissListener(new C1955b(this, str2, mVar, bitmap));
        a.show();
    }

    private void m10210a(int i, String str, int i2, int i3) {
        this.f6790d = true;
        C1595v c1595v = new C1595v(this.f6792f);
        c1595v.m7339a(i);
        c1595v.m7351b(str);
        c1595v.m7340a(i2, new C1956c(this));
        c1595v.m7349b(i3, new C1957d(this));
        CustomDialog a = c1595v.m7338a();
        a.setOnDismissListener(new C1958e(this));
        a.show();
    }

    private void m10209a(int i, int i2, int i3, int i4) {
        this.f6790d = true;
        C1595v c1595v = new C1595v(this.f6792f);
        c1595v.m7339a(i);
        c1595v.m7348b(i2);
        c1595v.m7349b(i4, new C1959f(this));
        c1595v.m7340a(i3, new C1960g(this));
        CustomDialog a = c1595v.m7338a();
        a.setOnDismissListener(new C1961h(this));
        a.show();
    }

    public void m10226a() {
        this.f6789c = C1962i.DONE;
        C1947d.m10193a().m10202e();
        Message.obtain(this.f6788b.m10228a(), g.quit).sendToTarget();
        try {
            this.f6788b.join();
        } catch (InterruptedException e) {
            C2538c.m12680e(f6787a, "Exception e = " + e.getMessage());
        }
        removeMessages(g.decode_succeeded);
        removeMessages(g.decode_failed);
    }

    private void m10225c() {
        if (this.f6789c == C1962i.f6811b) {
            this.f6789c = C1962i.PREVIEW;
            C1947d.m10193a().m10196a(this.f6788b.m10228a(), g.decode);
            C1947d.m10193a().m10199b(this, g.auto_focus);
            this.f6795i.m10232a();
        }
    }
}
