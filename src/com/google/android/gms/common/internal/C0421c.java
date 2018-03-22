package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;
import java.util.Arrays;

public final class C0421c {
    public static int m645a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static C0423e m646a(Object obj) {
        return new C0423e(obj);
    }

    public static boolean m647a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
