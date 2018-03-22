package com.huawei.bone.root;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import com.huawei.p190v.C2538c;

/* compiled from: MainActivity */
class C6784c implements DrawerListener {
    final /* synthetic */ MainActivity f23322a;

    C6784c(MainActivity mainActivity) {
        this.f23322a = mainActivity;
    }

    public void onDrawerSlide(View view, float f) {
    }

    public void onDrawerOpened(View view) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"==========Enter onDrawerOpened()"});
        this.f23322a.f23217h.a(this.f23322a.f23220k);
        this.f23322a.f23217h.b();
        this.f23322a.f23217h.c();
    }

    public void onDrawerClosed(View view) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"==========Enter onDrawerClosed()"});
    }

    public void onDrawerStateChanged(int i) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"==========Enter onDrawerStateChanged()"});
    }
}
