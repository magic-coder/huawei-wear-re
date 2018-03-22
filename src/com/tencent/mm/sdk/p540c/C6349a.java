package com.tencent.mm.sdk.p540c;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.mm.sdk.p539b.C6342a;

public final class C6349a {

    public final class C6347a {
        public static Object m29044a(int i, String str) {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    try {
                        C6342a.m29029a("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
            }
        }
    }

    public final class C6348b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
