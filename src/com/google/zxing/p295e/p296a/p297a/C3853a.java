package com.google.zxing.p295e.p296a.p297a;

import com.google.zxing.p278b.C3712a;
import java.util.List;

/* compiled from: BitArrayBuilder */
final class C3853a {
    static C3712a m19172a(List<C3854b> list) {
        int i;
        int size = (list.size() << 1) - 1;
        if (((C3854b) list.get(list.size() - 1)).m19176b() == null) {
            i = size - 1;
        } else {
            i = size;
        }
        C3712a c3712a = new C3712a(i * 12);
        int a = ((C3854b) list.get(0)).m19176b().m19219a();
        size = 11;
        i = 0;
        while (size >= 0) {
            if (((1 << size) & a) != 0) {
                c3712a.m18681b(i);
            }
            size--;
            i++;
        }
        int i2 = i;
        for (size = 1; size < list.size(); size++) {
            C3854b c3854b = (C3854b) list.get(size);
            int a2 = c3854b.m19175a().m19219a();
            a = 11;
            while (a >= 0) {
                if (((1 << a) & a2) != 0) {
                    c3712a.m18681b(i2);
                }
                a--;
                i2++;
            }
            if (c3854b.m19176b() != null) {
                a = c3854b.m19176b().m19219a();
                for (i = 11; i >= 0; i--) {
                    if (((1 << i) & a) != 0) {
                        c3712a.m18681b(i2);
                    }
                    i2++;
                }
            }
        }
        return c3712a;
    }
}
