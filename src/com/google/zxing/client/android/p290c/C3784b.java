package com.google.zxing.client.android.p290c;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: GetNewestBitmap */
public class C3784b {
    private static final ThreadFactory f14724a = new C3785c();
    private static final Executor f14725b = Executors.newFixedThreadPool(1, f14724a);
    private Context f14726c;

    public C3784b(Context context) {
        this.f14726c = context;
    }

    public void m19014a(C3787e c3787e) {
        new C3786d(this, c3787e).executeOnExecutor(f14725b, new Void[0]);
    }
}
