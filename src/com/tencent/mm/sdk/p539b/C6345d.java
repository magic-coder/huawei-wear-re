package com.tencent.mm.sdk.p539b;

import com.tencent.mm.p536a.C6334a;

public final class C6345d {
    private final C6334a f22091E;
    private C6344c<String, String> f22092F;

    public final String m29042i(String str) {
        try {
            if (str.startsWith("!")) {
                if (this.f22092F.m29041a(str)) {
                    return (String) this.f22092F.get(str);
                }
                String substring = str.substring(1);
                try {
                    String[] split = substring.split("@");
                    if (split.length > 1) {
                        String str2 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring2 = substring.substring(str2.length() + 1, (str2.length() + 1) + intValue);
                        String str3 = this.f22091E.m29019h(substring2) + substring.substring(intValue + (str2.length() + 1));
                        this.f22092F.put(str, str3);
                        return str3;
                    }
                    str = substring;
                } catch (Exception e) {
                    str = substring;
                    Exception exception = e;
                    exception.printStackTrace();
                    str = "[td]" + str;
                    return str;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            exception.printStackTrace();
            str = "[td]" + str;
            return str;
        }
        return str;
    }
}
