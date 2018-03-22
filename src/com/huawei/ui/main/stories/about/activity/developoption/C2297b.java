package com.huawei.ui.main.stories.about.activity.developoption;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.p190v.C2538c;

/* compiled from: DevelopOptionActivity */
class C2297b implements OnCheckedChangeListener {
    final /* synthetic */ DevelopOptionActivity f8357a;

    C2297b(DevelopOptionActivity developOptionActivity) {
        this.f8357a = developOptionActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            C2538c.m12665a(true);
        } else {
            C2538c.m12665a(false);
        }
    }
}
