package com.huawei.sim.esim.qrcode.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.C3709a;
import com.google.zxing.C3934m;
import com.huawei.p190v.C2538c;
import com.huawei.sim.esim.qrcode.QrCodeActivity;
import com.huawei.sim.esim.qrcode.p506a.C5905c;
import com.huawei.sim.esim.qrcode.view.C5919a;
import com.huawei.sim.g;

import java.util.Vector;

public final class CaptureActivityHandler extends Handler {
    private static final String f20260a = CaptureActivityHandler.class.getSimpleName();
    private final QrCodeActivity f20261b;
    private C5912a f20262c = C5912a.SUCCESS;
    private final C5914c f20263d;

    public CaptureActivityHandler(QrCodeActivity qrCodeActivity, Vector<C3709a> vector, String str) {
        this.f20261b = qrCodeActivity;
        this.f20263d = new C5914c(qrCodeActivity, vector, str, new C5919a(qrCodeActivity.m27143b()));
        this.f20263d.start();
        C5905c.m27159a().m27168e();
        m27176b();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == g.sim_auto_focus) {
            if (this.f20262c == C5912a.PREVIEW) {
                C5905c.m27159a().m27162a(this, g.sim_auto_focus);
            }
        } else if (message.what == g.sim_restart_preview) {
            C2538c.c(f20260a, new Object[]{"Got restart preview message"});
            m27176b();
        } else if (message.what == g.sim_decode_succeeded) {
            C2538c.c(f20260a, new Object[]{"Got decode succeeded message"});
            this.f20262c = C5912a.SUCCESS;
            Bundle data = message.getData();
            Bitmap bitmap = data == null ? null : (Bitmap) data.getParcelable("barcode_bitmap");
            String a = ((C3934m) message.obj).m19572a();
            C2538c.c(f20260a, new Object[]{"===www123======--str_result:" + a});
            m27175a((C3934m) message.obj, bitmap);
        } else if (message.what == g.sim_decode_failed) {
            this.f20262c = C5912a.PREVIEW;
            C5905c.m27159a().m27165b(this.f20263d.m27179a(), g.sim_decode);
        } else if (message.what == g.sim_return_scan_result) {
            C2538c.c(f20260a, new Object[]{"Got return scan result message"});
            this.f20261b.setResult(-1, (Intent) message.obj);
            this.f20261b.finish();
        }
    }

    private void m27175a(C3934m c3934m, Bitmap bitmap) {
        if (c3934m != null && !"".equals(c3934m.toString())) {
            String c3934m2 = c3934m.toString();
            C2538c.b(f20260a, new Object[]{"result: " + c3934m2});
            this.f20261b.m27142a(c3934m, bitmap);
        }
    }

    public void m27177a() {
        this.f20262c = C5912a.DONE;
        C5905c.m27159a().m27167d();
        Message.obtain(this.f20263d.m27179a(), g.sim_quit).sendToTarget();
        try {
            this.f20263d.join();
        } catch (InterruptedException e) {
            C2538c.e(f20260a, new Object[]{"Exception e = " + e.getMessage()});
        }
        removeMessages(g.sim_decode_succeeded);
        removeMessages(g.sim_decode_failed);
    }

    private void m27176b() {
        if (this.f20262c == C5912a.SUCCESS) {
            this.f20262c = C5912a.PREVIEW;
            C5905c.m27159a().m27165b(this.f20263d.m27179a(), g.sim_decode);
            C5905c.m27159a().m27162a(this, g.sim_auto_focus);
            this.f20261b.m27145d();
        }
    }
}
