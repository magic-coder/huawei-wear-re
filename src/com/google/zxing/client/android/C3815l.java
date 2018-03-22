package com.google.zxing.client.android;

import android.content.Context;

/* compiled from: DipUtil */
public class C3815l {
    public static int m19055a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int m19056a(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }
}
