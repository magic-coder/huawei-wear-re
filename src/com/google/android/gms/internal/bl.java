package com.google.android.gms.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

public class bl {
    private final Object f617a;

    public boolean m1095a() {
        return this.f617a instanceof FragmentActivity;
    }

    public Activity m1096b() {
        return (Activity) this.f617a;
    }

    public FragmentActivity m1097c() {
        return (FragmentActivity) this.f617a;
    }
}
