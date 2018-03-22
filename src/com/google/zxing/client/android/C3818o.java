package com.google.zxing.client.android;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: PictureFetcher */
public class C3818o {
    private static final ThreadFactory f14827b = new C3819p();
    private static final Executor f14828c = Executors.newFixedThreadPool(1, f14827b);
    private Context f14829a = null;

    public C3818o(Context context) {
        this.f14829a = context;
    }

    public void m19070a(int i, C3811r c3811r) {
        new C3820q(this, i, c3811r).executeOnExecutor(f14828c, new Void[0]);
    }

    public String m19069a(int i) {
        return m19068a(Uri.parse("content://media/external/images/media/" + i));
    }

    private String m19068a(Uri uri) {
        Exception e;
        Throwable th;
        String str = "";
        Cursor query;
        try {
            String string;
            query = this.f14829a.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    query.moveToFirst();
                    string = query.getString(query.getColumnIndex("_data"));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.e("PictureFecher", "Exception " + e.getMessage());
                        if (query != null) {
                            return str;
                        }
                        query.close();
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            string = str;
            if (query == null) {
                return string;
            }
            query.close();
            return string;
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.e("PictureFecher", "Exception " + e.getMessage());
            if (query != null) {
                return str;
            }
            query.close();
            return str;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
