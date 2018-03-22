package com.google.zxing.client.android.decode;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.C3709a;
import com.google.zxing.C3880e;
import com.google.zxing.C3934m;
import com.google.zxing.client.android.C3817n;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.p286a.C3775e;
import com.google.zxing.client.android.p292e.C3804b;
import java.util.Collection;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

public final class CaptureActivityHandler extends Handler {
    private static final String f14752a = CaptureActivityHandler.class.getSimpleName();
    private final CaptureActivity f14753b;
    private final C3797c f14754c;
    private C3795a f14755d;
    private final C3775e f14756e;
    private C3817n f14757f = null;

    public CaptureActivityHandler(CaptureActivity captureActivity, Collection<C3709a> collection, Map<C3880e, ?> map, String str, C3775e c3775e) {
        this.f14753b = captureActivity;
        this.f14757f = new C3817n(captureActivity);
        this.f14754c = new C3797c(captureActivity, collection, map, str, new C3804b(captureActivity.m18960a()));
        this.f14754c.start();
        this.f14755d = C3795a.SUCCESS;
        this.f14756e = c3775e;
        c3775e.m18995c();
        m19026b();
    }

    public void handleMessage(Message message) {
        String str = null;
        if (message.what == this.f14757f.m19061c("restart_preview")) {
            Log.d(f14752a, "Got restart preview message");
            m19026b();
        } else if (message.what == this.f14757f.m19061c("decode_succeeded")) {
            Bitmap copy;
            float f;
            Log.d(f14752a, "Got decode succeeded message");
            this.f14755d = C3795a.SUCCESS;
            Bundle data = message.getData();
            float f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            if (data != null) {
                f2 = data.getFloat("barcode_scaled_factor");
                byte[] byteArray = data.getByteArray("barcode_bitmap");
                if (byteArray != null) {
                    copy = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Config.ARGB_8888, true);
                    f = f2;
                    this.f14753b.m18962a((C3934m) message.obj, copy, f);
                }
            }
            copy = null;
            f = f2;
            this.f14753b.m18962a((C3934m) message.obj, copy, f);
        } else if (message.what == this.f14757f.m19061c("decode_failed")) {
            this.f14755d = C3795a.PREVIEW;
            this.f14756e.m18990a(this.f14754c.m19030a(), this.f14757f.m19061c("decode"));
        } else if (message.what == this.f14757f.m19061c("return_scan_result")) {
            Log.d(f14752a, "Got return scan result message");
            this.f14753b.setResult(-1, (Intent) message.obj);
            this.f14753b.finish();
        } else if (message.what == this.f14757f.m19061c("launch_product_query")) {
            Log.d(f14752a, "Got product query message");
            String str2 = (String) message.obj;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(524288);
            intent.setData(Uri.parse(str2));
            ResolveInfo resolveActivity = this.f14753b.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity.activityInfo != null) {
                str = resolveActivity.activityInfo.packageName;
                Log.d(f14752a, "Using browser in package " + str);
            }
            if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                intent.setPackage(str);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("com.android.browser.application_id", str);
            }
            try {
                this.f14753b.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Log.w(f14752a, "Can't find anything to handle VIEW of URI " + str2);
            }
        }
    }

    public void m19027a() {
        this.f14755d = C3795a.DONE;
        this.f14756e.m18996d();
        Message.obtain(this.f14754c.m19030a(), this.f14757f.m19061c("quit")).sendToTarget();
        try {
            this.f14754c.join(500);
        } catch (InterruptedException e) {
        }
        removeMessages(this.f14757f.m19061c("decode_succeeded"));
        removeMessages(this.f14757f.m19061c("decode_failed"));
    }

    private void m19026b() {
        if (this.f14755d == C3795a.SUCCESS) {
            this.f14755d = C3795a.PREVIEW;
            this.f14756e.m18990a(this.f14754c.m19030a(), this.f14757f.m19061c("decode"));
            this.f14753b.m18968g();
            this.f14753b.m18969h();
        }
    }
}
