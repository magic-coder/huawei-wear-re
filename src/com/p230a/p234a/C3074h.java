package com.p230a.p234a;

import java.util.HashMap;

public final class C3074h extends C3067e {
    protected final String mo3638a(String str) {
        if (str != null) {
            if ("activateCard".equals(str)) {
                return "smsObtainRequest.action";
            }
            if ("thawAction".equals(str)) {
                return "thawSmsObtain.action";
            }
            if ("nullifyAction".equals(str)) {
                return "annulSmsObtain.action";
            }
        }
        return "";
    }

    protected final HashMap mo3639a(HashMap hashMap) {
        return hashMap;
    }
}
