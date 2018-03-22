package com.tencent.mm.p536a;

import android.util.Base64;
import javax.crypto.Cipher;

public final class C6334a {
    private Cipher f22072j;

    public final String m29019h(String str) {
        try {
            return new String(this.f22072j.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e) {
            return "[des]" + str + "|" + e.toString();
        }
    }
}
