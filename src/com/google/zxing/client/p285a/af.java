package com.google.zxing.client.p285a;

import com.google.zxing.C3934m;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: VCardResultParser */
public final class af extends C3741u {
    private static final Pattern f14551a = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern f14552b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    private static final Pattern f14553c = Pattern.compile("\r\n[ \t]");
    private static final Pattern f14554d = Pattern.compile("\\\\[nN]");
    private static final Pattern f14555e = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern f14556f = Pattern.compile("=");
    private static final Pattern f14557g = Pattern.compile(";");
    private static final Pattern f14558h = Pattern.compile("(?<!\\\\);+");
    private static final Pattern f14559i = Pattern.compile(",");
    private static final Pattern f14560j = Pattern.compile("[;,]");

    public /* synthetic */ C3743q mo4308b(C3934m c3934m) {
        return m18863a(c3934m);
    }

    public C3746d m18863a(C3934m c3934m) {
        String c = C3741u.m18830c(c3934m);
        Matcher matcher = f14551a.matcher(c);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        String[] strArr;
        List list;
        List a = af.m18855a("FN", c, true, false);
        if (a == null) {
            a = af.m18855a("N", c, true, false);
            af.m18857a((Iterable) a);
        }
        Collection collection = a;
        a = af.m18861b("NICKNAME", c, true, false);
        if (a == null) {
            strArr = null;
        } else {
            strArr = f14559i.split((CharSequence) a.get(0));
        }
        Collection a2 = af.m18855a("TEL", c, true, false);
        Collection a3 = af.m18855a("EMAIL", c, true, false);
        List b = af.m18861b("NOTE", c, false, false);
        Collection a4 = af.m18855a("ADR", c, true, true);
        List b2 = af.m18861b("ORG", c, true, true);
        List b3 = af.m18861b("BDAY", c, true, false);
        if (b3 == null || af.m18859a((CharSequence) b3.get(0))) {
            list = b3;
        } else {
            list = null;
        }
        List b4 = af.m18861b("TITLE", c, true, false);
        Collection a5 = af.m18855a("URL", c, true, false);
        List b5 = af.m18861b("IMPP", c, true, false);
        a = af.m18861b("GEO", c, true, false);
        String[] split = a == null ? null : f14560j.split((CharSequence) a.get(0));
        if (!(split == null || split.length == 2)) {
            split = null;
        }
        return new C3746d(af.m18860a(collection), strArr, null, af.m18860a(a2), af.m18862b(a2), af.m18860a(a3), af.m18862b(a3), af.m18854a(b5), af.m18854a(b), af.m18860a(a4), af.m18862b(a4), af.m18854a(b2), af.m18854a(list), af.m18854a(b4), af.m18860a(a5), split);
    }

    static List<List<String>> m18855a(CharSequence charSequence, String str, boolean z, boolean z2) {
        int i = 0;
        int length = str.length();
        List<List<String>> list = null;
        while (i < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:]*))?:", 2).matcher(str);
            if (i > 0) {
                i--;
            }
            if (!matcher.find(i)) {
                break;
            }
            String str2;
            List list2;
            int end = matcher.end(0);
            CharSequence group = matcher.group(1);
            List list3 = null;
            Object obj = null;
            String str3 = null;
            if (group != null) {
                String[] split = f14557g.split(group);
                int length2 = split.length;
                int i2 = 0;
                while (i2 < length2) {
                    Object obj2;
                    group = split[i2];
                    if (list3 == null) {
                        list3 = new ArrayList(1);
                    }
                    list3.add(group);
                    String[] split2 = f14556f.split(group, 2);
                    if (split2.length > 1) {
                        String str4 = split2[0];
                        str2 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str2)) {
                            obj2 = 1;
                            i2++;
                            obj = obj2;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str3 = str2;
                            obj2 = obj;
                            i2++;
                            obj = obj2;
                        }
                    }
                    obj2 = obj;
                    i2++;
                    obj = obj2;
                }
                str2 = str3;
                list2 = list3;
            } else {
                str2 = null;
                list2 = null;
            }
            i = end;
            while (true) {
                i = str.indexOf(10, i);
                if (i < 0) {
                    break;
                } else if (i >= str.length() - 1 || (str.charAt(i + 1) != ' ' && str.charAt(i + 1) != '\t')) {
                    if (obj == null || ((i < 1 || str.charAt(i - 1) != '=') && (i < 2 || str.charAt(i - 2) != '='))) {
                        break;
                    }
                    i++;
                } else {
                    i += 2;
                }
            }
            if (i < 0) {
                i = length;
            } else if (i > end) {
                Object a;
                if (list == null) {
                    list = new ArrayList(1);
                }
                if (i >= 1 && str.charAt(i - 1) == '\r') {
                    i--;
                }
                CharSequence substring = str.substring(end, i);
                if (z) {
                    substring = substring.trim();
                }
                if (obj != null) {
                    a = af.m18853a(substring, str2);
                    if (z2) {
                        a = f14558h.matcher(a).replaceAll("\n").trim();
                    }
                } else {
                    if (z2) {
                        substring = f14558h.matcher(substring).replaceAll("\n").trim();
                    }
                    a = f14555e.matcher(f14554d.matcher(f14553c.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                }
                if (list2 == null) {
                    List arrayList = new ArrayList(1);
                    arrayList.add(a);
                    list.add(arrayList);
                } else {
                    list2.add(0, a);
                    list.add(list2);
                }
                i++;
            } else {
                i++;
            }
        }
        return list;
    }

    private static String m18853a(CharSequence charSequence, String str) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            switch (charAt) {
                case '\n':
                case '\r':
                    break;
                case '=':
                    if (i >= length - 2) {
                        break;
                    }
                    charAt = charSequence.charAt(i + 1);
                    if (!(charAt == '\r' || charAt == '\n')) {
                        char charAt2 = charSequence.charAt(i + 2);
                        int a = C3741u.m18824a(charAt);
                        int a2 = C3741u.m18824a(charAt2);
                        if (a >= 0 && a2 >= 0) {
                            byteArrayOutputStream.write((a << 4) + a2);
                        }
                        i += 2;
                        break;
                    }
                default:
                    af.m18856a(byteArrayOutputStream, str, stringBuilder);
                    stringBuilder.append(charAt);
                    break;
            }
            i++;
        }
        af.m18856a(byteArrayOutputStream, str, stringBuilder);
        return stringBuilder.toString();
    }

    private static void m18856a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder stringBuilder) {
        if (byteArrayOutputStream.size() > 0) {
            String str2;
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(toByteArray, Charset.forName(GameManager.DEFAULT_CHARSET));
            } else {
                try {
                    str2 = new String(toByteArray, str);
                } catch (UnsupportedEncodingException e) {
                    str2 = new String(toByteArray, Charset.forName(GameManager.DEFAULT_CHARSET));
                }
            }
            byteArrayOutputStream.reset();
            stringBuilder.append(str2);
        }
    }

    static List<String> m18861b(CharSequence charSequence, String str, boolean z, boolean z2) {
        List a = af.m18855a(charSequence, str, z, z2);
        return (a == null || a.isEmpty()) ? null : (List) a.get(0);
    }

    private static String m18854a(List<String> list) {
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static String[] m18860a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            String str = (String) list.get(0);
            if (!(str == null || str.isEmpty())) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static String[] m18862b(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        List arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            Object substring;
            int i = 1;
            while (i < list.size()) {
                String str = (String) list.get(i);
                int indexOf = str.indexOf(61);
                if (indexOf < 0) {
                    break;
                } else if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                    substring = str.substring(indexOf + 1);
                    break;
                } else {
                    i++;
                }
            }
            substring = null;
            arrayList.add(substring);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static boolean m18859a(CharSequence charSequence) {
        return charSequence == null || f14552b.matcher(charSequence).matches();
    }

    private static void m18857a(Iterable<List<String>> iterable) {
        if (iterable != null) {
            for (List list : iterable) {
                String str = (String) list.get(0);
                String[] strArr = new String[5];
                int i = 0;
                int i2 = 0;
                while (i < strArr.length - 1) {
                    int indexOf = str.indexOf(59, i2);
                    if (indexOf < 0) {
                        break;
                    }
                    strArr[i] = str.substring(i2, indexOf);
                    i++;
                    i2 = indexOf + 1;
                }
                strArr[i] = str.substring(i2);
                StringBuilder stringBuilder = new StringBuilder(100);
                af.m18858a(strArr, 3, stringBuilder);
                af.m18858a(strArr, 1, stringBuilder);
                af.m18858a(strArr, 2, stringBuilder);
                af.m18858a(strArr, 0, stringBuilder);
                af.m18858a(strArr, 4, stringBuilder);
                list.set(0, stringBuilder.toString().trim());
            }
        }
    }

    private static void m18858a(String[] strArr, int i, StringBuilder stringBuilder) {
        if (strArr[i] != null && !strArr[i].isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(strArr[i]);
        }
    }
}
