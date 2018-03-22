package cn.com.xy.sms.sdk.p216h.p217a;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C2983a {
    private static String f10104a;
    private static Pattern f10105b;

    static {
        String str = "#(\\d+)\\{([^}]+)\\}";
        f10104a = str;
        f10105b = Pattern.compile(str);
    }

    public static List<C2986d> m13417a(String str) {
        List<C2986d> list = null;
        if (!(str == null || str.trim().length() == 0)) {
            Matcher matcher = f10105b.matcher(str);
            if (matcher.find()) {
                list = new ArrayList();
                do {
                    String group = matcher.group(1);
                    list.add(new C2986d(Integer.valueOf(group).intValue(), matcher.group(2)));
                } while (matcher.find());
            }
        }
        return list;
    }
}
