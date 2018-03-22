package com.google.zxing.client.android;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.google.zxing.C3740c;
import com.google.zxing.C3880e;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3725j;
import com.google.zxing.p303g.C3921a;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: QRUtil */
public class C3823v {
    public String m19079a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a = m19076a(m19077b(str));
        if (TextUtils.isEmpty(a)) {
            return m19076a(m19078c(str));
        }
        return a;
    }

    private String m19076a(Bitmap bitmap) {
        String str = null;
        try {
            Map hashtable = new Hashtable();
            hashtable.put(C3880e.CHARACTER_SET, "utf-8");
            C3934m a = new C3921a().mo4301a(new C3740c(new C3725j(new C3825w(bitmap))), hashtable);
            if (a != null) {
                str = a.m19572a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        return str;
    }

    private Bitmap m19077b(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = options.outHeight / HttpStatus.SC_BAD_REQUEST;
        if (options.inSampleSize <= 0) {
            options.inSampleSize = 1;
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private Bitmap m19078c(String str) {
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_4444;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }
}
