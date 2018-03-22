package com.huawei.ui.main.stories.about.activity.developoption;

import com.huawei.ui.main.j;

/* compiled from: DevelopOptionActivity */
class C2301f implements Runnable {
    final /* synthetic */ int f8361a;
    final /* synthetic */ C2300e f8362b;

    C2301f(C2300e c2300e, int i) {
        this.f8362b = c2300e;
        this.f8361a = i;
    }

    public void run() {
        this.f8362b.f8360a.m11812d();
        if (this.f8361a == 0) {
            this.f8362b.f8360a.m11813a(j.IDS_music_management_operation_success);
        } else {
            this.f8362b.f8360a.m11813a(j.IDS_music_management_operation_failed);
        }
    }
}
