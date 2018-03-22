package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class C0348a implements Comparator<Scope> {
    C0348a() {
    }

    public int m278a(Scope scope, Scope scope2) {
        return scope.zzvt().compareTo(scope2.zzvt());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m278a((Scope) obj, (Scope) obj2);
    }
}
