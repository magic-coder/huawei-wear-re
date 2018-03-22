package com.huawei.hwcommonmodel.datatypes;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

/* compiled from: TLVUtils */
public class C4756w {
    public C4754u m22743a(String str) throws C4753t {
        int i = 0;
        C4754u c4754u = new C4754u();
        while (i != str.length()) {
            String substring = str.substring(i, i + 2);
            C4757x a = m22741a(str, i + substring.length());
            int a2 = a.m22745a();
            i = a.m22746b();
            String str2 = "";
            if (a2 == 0) {
                c4754u.f17337a.add(new C4752s(substring, a2, str2));
            } else if ((a2 * 2) + i > str.length()) {
                throw new C4753t();
            } else {
                try {
                    str2 = str.substring(i, (a2 * 2) + i);
                    i += str2.length();
                    if ((Integer.parseInt(substring, 16) >>> 7) == 1) {
                        c4754u.f17338b.add(m22743a(str2));
                    } else {
                        c4754u.f17337a.add(new C4752s(substring, a2, str2));
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new C4753t();
                }
            }
        }
        return c4754u;
    }

    public C4755v m22744a(C4755v c4755v, String str, int i) throws C4753t {
        int i2 = 0;
        if (c4755v == null || str == null || i < 0) {
            return null;
        }
        while (i2 != str.length()) {
            String substring = str.substring(i2, i2 + 2);
            int i3 = (i + i2) / 2;
            C4757x a = m22741a(str, i2 + substring.length());
            int a2 = a.m22745a();
            i2 = a.m22746b();
            String str2 = "";
            if (a2 == 0) {
                substring = Integer.toString(Integer.parseInt(substring, 16));
                if ('0' == substring.charAt(0)) {
                    substring = substring.substring(1, substring.length());
                }
                c4755v.f17339a.add(new C4755v(i3, substring, substring));
            } else if ((a2 * 2) + i2 > str.length()) {
                throw new C4753t();
            } else {
                String substring2 = str.substring(i2, (a2 * 2) + i2);
                int i4 = i + i2;
                i2 += substring2.length();
                if ((Integer.parseInt(substring, 16) >>> 7) == 1) {
                    substring = Integer.toString(Integer.parseInt(substring, 16) & 127);
                    if ('0' == substring.charAt(0)) {
                        substring = substring.substring(1, substring.length());
                    }
                    c4755v.f17339a.add(new C4755v(i3, substring, substring));
                    m22744a(c4755v, substring2, i4);
                } else {
                    try {
                        substring = Integer.toString(Integer.parseInt(substring, 16));
                        if ('0' == substring.charAt(0)) {
                            substring = substring.substring(1, substring.length());
                        }
                        c4755v.f17339a.add(new C4755v(i3, substring, substring));
                    } catch (IndexOutOfBoundsException e) {
                        throw new C4753t();
                    }
                }
            }
        }
        return c4755v;
    }

    private C4757x m22741a(String str, int i) throws C4753t {
        try {
            int i2 = 0;
            int i3 = 0;
            int parseInt = Integer.parseInt(str.substring(i, i + 2), 16);
            int i4 = 0;
            while (((parseInt >>> 7) & 1) == 1) {
                if (i2 < 4) {
                    i += 2;
                    parseInt &= 127;
                    switch (i2) {
                        case 0:
                            break;
                        case 1:
                            i4 = parseInt;
                            parseInt = i3;
                            break;
                        default:
                            parseInt = i3;
                            break;
                    }
                    i2++;
                    i3 = parseInt;
                    parseInt = Integer.parseInt(str.substring(i, i + 2), 16);
                } else {
                    throw new C4753t();
                }
            }
            if (2 == i2) {
                i4 = ((i4 * 128) + ((i3 * 128) * 128)) + parseInt;
            } else if (1 == i2) {
                i4 = (i3 * 128) + parseInt;
            } else {
                i4 = 0 + parseInt;
            }
            return new C4757x(i4, i + 2);
        } catch (IndexOutOfBoundsException e) {
            throw new C4753t();
        }
    }

    public static boolean m22742a(byte[] bArr) {
        if (TagName.ELECTRONIC_PUBLISH_START_TIME != bArr[2]) {
            return false;
        }
        String a = a.a(bArr);
        if (100009 == Integer.parseInt(a.substring(8, a.length()), 16)) {
            return true;
        }
        return false;
    }
}
