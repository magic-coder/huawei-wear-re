package com.tencent.mm.sdk.p539b;

import android.util.Log;
import com.tencent.mm.sdk.p539b.C6342a.C6341a;

final class C6343b implements C6341a {
    C6343b() {
    }

    public final void mo5305e(String str, String str2) {
        if (C6342a.level <= 2) {
            Log.i(str, str2);
        }
    }

    public final void mo5306f(String str, String str2) {
        if (C6342a.level <= 1) {
            Log.d(str, str2);
        }
    }

    public final void mo5307g(String str, String str2) {
        if (C6342a.level <= 3) {
            Log.w(str, str2);
        }
    }

    public final int mo5308h() {
        return C6342a.level;
    }

    public final void mo5309h(String str, String str2) {
        if (C6342a.level <= 4) {
            Log.e(str, str2);
        }
    }
}
