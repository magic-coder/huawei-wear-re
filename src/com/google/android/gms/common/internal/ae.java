package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.C0389b;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.api.C0380r;
import com.google.android.gms.common.api.C0381s;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.util.Set;

public abstract class ae<T extends IInterface> extends zzf<T> implements C0372j, ai {
    private final C0443x f388e;
    private final Set<Scope> f389f;
    private final Account f390g;

    protected ae(Context context, Looper looper, int i, C0443x c0443x, C0380r c0380r, C0381s c0381s) {
        this(context, looper, aj.m593a(context), C0389b.m424a(), i, c0443x, (C0380r) C0424f.m649a((Object) c0380r), (C0381s) C0424f.m649a((Object) c0381s));
    }

    protected ae(Context context, Looper looper, aj ajVar, C0389b c0389b, int i, C0443x c0443x, C0380r c0380r, C0381s c0381s) {
        super(context, looper, ajVar, c0389b, i, m572a(c0380r), m573a(c0381s), c0443x.m763g());
        this.f388e = c0443x;
        this.f390g = c0443x.m756a();
        this.f389f = m574b(c0443x.m760d());
    }

    @Nullable
    private static C0418o m572a(C0380r c0380r) {
        return c0380r == null ? null : new af(c0380r);
    }

    @Nullable
    private static C0419p m573a(C0381s c0381s) {
        return c0381s == null ? null : new ag(c0381s);
    }

    private Set<Scope> m574b(@NonNull Set<Scope> set) {
        Set<Scope> a = m575a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    @NonNull
    protected Set<Scope> m575a(@NonNull Set<Scope> set) {
        return set;
    }

    public final Account mo1759o() {
        return this.f390g;
    }

    public zzc[] mo1760p() {
        return new zzc[0];
    }

    protected final Set<Scope> mo1761w() {
        return this.f389f;
    }
}
