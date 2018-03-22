package com.google.zxing.client.android.p290c;

import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: GetNewestBitmap */
class C3786d extends AsyncTask<Void, Void, C3788f> {
    final /* synthetic */ C3784b f14728a;
    private final /* synthetic */ C3787e f14729b;

    C3786d(C3784b c3784b, C3787e c3787e) {
        this.f14728a = c3784b;
        this.f14729b = c3787e;
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m19015a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m19016a((C3788f) obj);
    }

    protected C3788f m19015a(Void... voidArr) {
        SQLException e;
        Throwable th;
        C3788f c3788f = new C3788f(this.f14728a);
        Cursor query;
        String string;
        Bitmap a;
        try {
            query = Media.query(this.f14728a.f14726c.getContentResolver(), Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data"}, null, null, "_id desc limit 1");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return c3788f;
            }
            try {
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    string = query.getString(query.getColumnIndex("_data"));
                    if (query != null) {
                        query.close();
                    }
                    if (TextUtils.isEmpty(string)) {
                        Log.e("GetNewestBitmap", "getRecentlyBitmap not validata.");
                        return c3788f;
                    }
                    a = C3783a.m19012a(string, 200, 200);
                    if (a == null) {
                        c3788f.f14731b = 1;
                    }
                    c3788f.f14730a = a;
                    return c3788f;
                }
                if (query != null) {
                    query.close();
                }
                return c3788f;
            } catch (SQLException e2) {
                e = e2;
                try {
                    Log.e("GetNewestBitmap", "getRecentlyBitmap SQLException" + e.getMessage());
                    if (query == null) {
                        string = null;
                    } else {
                        query.close();
                        string = null;
                    }
                    if (TextUtils.isEmpty(string)) {
                        Log.e("GetNewestBitmap", "getRecentlyBitmap not validata.");
                        return c3788f;
                    }
                    a = C3783a.m19012a(string, 200, 200);
                    if (a == null) {
                        c3788f.f14731b = 1;
                    }
                    c3788f.f14730a = a;
                    return c3788f;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLException e3) {
            e = e3;
            query = null;
            Log.e("GetNewestBitmap", "getRecentlyBitmap SQLException" + e.getMessage());
            if (query == null) {
                query.close();
                string = null;
            } else {
                string = null;
            }
            if (TextUtils.isEmpty(string)) {
                a = C3783a.m19012a(string, 200, 200);
                if (a == null) {
                    c3788f.f14731b = 1;
                }
                c3788f.f14730a = a;
                return c3788f;
            }
            Log.e("GetNewestBitmap", "getRecentlyBitmap not validata.");
            return c3788f;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    protected void m19016a(C3788f c3788f) {
        if (this.f14729b != null && c3788f != null) {
            this.f14729b.mo4313a(c3788f.f14730a, c3788f.f14731b);
        }
    }
}
