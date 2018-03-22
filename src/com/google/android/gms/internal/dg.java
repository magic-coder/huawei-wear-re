package com.google.android.gms.internal;

import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.C0369f;
import com.google.android.gms.common.api.C0373k;
import com.google.android.gms.common.api.Scope;

public final class dg {
    public static final C0373k<dy> f684a = new C0373k();
    public static final C0373k<dy> f685b = new C0373k();
    public static final C0369f<dy, dl> f686c = new dh();
    static final C0369f<dy, dj> f687d = new di();
    public static final Scope f688e = new Scope("profile");
    public static final Scope f689f = new Scope("email");
    public static final C0367a<dl> f690g = new C0367a("SignIn.API", f686c, f684a);
    public static final C0367a<dj> f691h = new C0367a("SignIn.INTERNAL_API", f687d, f685b);
}
