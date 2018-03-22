package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class C0350c {
    private Set<Scope> f234a = new HashSet();
    private boolean f235b;
    private boolean f236c;
    private boolean f237d;
    private String f238e;
    private Account f239f;
    private String f240g;
    private Map<Integer, zzg> f241h = new HashMap();

    public C0350c m280a() {
        this.f234a.add(GoogleSignInOptions.zzakj);
        return this;
    }

    public C0350c m281a(Scope scope, Scope... scopeArr) {
        this.f234a.add(scope);
        this.f234a.addAll(Arrays.asList(scopeArr));
        return this;
    }

    public C0350c m282b() {
        this.f234a.add(GoogleSignInOptions.zzakh);
        return this;
    }

    public GoogleSignInOptions m283c() {
        if (this.f237d && (this.f239f == null || !this.f234a.isEmpty())) {
            m280a();
        }
        return new GoogleSignInOptions(3, new ArrayList(this.f234a), this.f239f, this.f237d, this.f235b, this.f236c, this.f238e, this.f240g, this.f241h);
    }
}
