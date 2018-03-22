package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.C0367a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.dl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class C0443x {
    private final Account f448a;
    private final Set<Scope> f449b;
    private final Set<Scope> f450c;
    private final Map<C0367a<?>, C0444y> f451d;
    private final int f452e;
    private final View f453f;
    private final String f454g;
    private final String f455h;
    private final dl f456i;
    private Integer f457j;

    public C0443x(Account account, Set<Scope> set, Map<C0367a<?>, C0444y> map, int i, View view, String str, String str2, dl dlVar) {
        Map map2;
        this.f448a = account;
        this.f449b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f451d = map2;
        this.f453f = view;
        this.f452e = i;
        this.f454g = str;
        this.f455h = str2;
        this.f456i = dlVar;
        Set hashSet = new HashSet(this.f449b);
        for (C0444y c0444y : this.f451d.values()) {
            hashSet.addAll(c0444y.f458a);
        }
        this.f450c = Collections.unmodifiableSet(hashSet);
    }

    public Account m756a() {
        return this.f448a;
    }

    public void m757a(Integer num) {
        this.f457j = num;
    }

    public Account m758b() {
        return this.f448a != null ? this.f448a : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> m759c() {
        return this.f449b;
    }

    public Set<Scope> m760d() {
        return this.f450c;
    }

    public Map<C0367a<?>, C0444y> m761e() {
        return this.f451d;
    }

    public String m762f() {
        return this.f454g;
    }

    public String m763g() {
        return this.f455h;
    }

    public dl m764h() {
        return this.f456i;
    }

    public Integer m765i() {
        return this.f457j;
    }
}
