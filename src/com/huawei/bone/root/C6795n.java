package com.huawei.bone.root;

import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import com.huawei.ui.homewear21.a.cf;
import java.lang.ref.WeakReference;

/* compiled from: MainActivity */
public class C6795n extends cf {
    private WeakReference<DrawerLayout> f23336c = null;
    private WeakReference<FrameLayout> f23337d = null;

    public C6795n(DrawerLayout drawerLayout, FrameLayout frameLayout) {
        this.f23336c = new WeakReference(drawerLayout);
        this.f23337d = new WeakReference(frameLayout);
    }

    public void m30213a() {
        DrawerLayout drawerLayout = (DrawerLayout) this.f23336c.get();
        FrameLayout frameLayout = (FrameLayout) this.f23337d.get();
        if (drawerLayout != null && frameLayout != null && drawerLayout.isDrawerOpen(frameLayout)) {
            drawerLayout.closeDrawers();
        }
    }
}
