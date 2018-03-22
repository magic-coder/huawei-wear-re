package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class C0349b implements Comparator<Scope> {
    C0349b() {
    }

    public int m279a(Scope scope, Scope scope2) {
        return scope.zzvt().compareTo(scope2.zzvt());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m279a((Scope) obj, (Scope) obj2);
    }
}
