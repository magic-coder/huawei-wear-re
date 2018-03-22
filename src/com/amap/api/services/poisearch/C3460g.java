package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.services.core.C3387r;

/* compiled from: PoiHandler */
abstract class C3460g<T, V> extends C3387r<T, V> {
    public C3460g(Context context, T t) {
        super(context, t);
    }

    protected boolean mo4100a(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return true;
        }
        return false;
    }
}
