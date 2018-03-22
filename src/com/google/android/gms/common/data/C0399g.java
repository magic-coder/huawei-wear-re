package com.google.android.gms.common.data;

import java.util.ArrayList;

public final class C0399g {
    public static <T, E extends C0398f<T>> ArrayList<T> m468a(Iterable<E> iterable) {
        ArrayList<T> arrayList = new ArrayList();
        for (E freeze : iterable) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }
}
