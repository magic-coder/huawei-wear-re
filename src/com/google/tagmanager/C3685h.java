package com.google.tagmanager;

import java.util.List;

/* compiled from: DataLayer */
class C3685h implements C3684l {
    final /* synthetic */ C3681f f14339a;

    C3685h(C3681f c3681f) {
        this.f14339a = c3681f;
    }

    public void mo4294a(List<C3686i> list) {
        for (C3686i c3686i : list) {
            this.f14339a.m18561b(this.f14339a.m18568a(c3686i.f14340a, c3686i.f14341b));
        }
        this.f14339a.f14338i.countDown();
    }
}
