package com.huawei.sim.esim.p505b;

import com.google.zxing.client.p285a.C3743q;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: QrCodeDataParse */
public class C5901b {
    private static int f20200a = 255;
    private ArrayList<String> f20201b = new ArrayList();

    private void m27116c(String str) {
        boolean contains = str.contains("$");
        while (contains) {
            Object substring;
            int indexOf = str.indexOf("$");
            if (indexOf > 0) {
                substring = str.substring(0, indexOf);
            } else {
                substring = "";
            }
            this.f20201b.add(substring);
            str = str.substring(indexOf + 1);
            contains = str.contains("$");
        }
        this.f20201b.add(str);
    }

    private boolean m27117d(C3743q c3743q) {
        if (c3743q == null || c3743q.toString() == null) {
            return true;
        }
        return false;
    }

    public boolean m27120a(C3743q c3743q) {
        C2538c.e("QrCodeDataParse", new Object[]{"qrCodeInvalid enter"});
        if (m27117d(c3743q)) {
            C2538c.e("QrCodeDataParse", new Object[]{"ACcode is null"});
            return true;
        }
        String c3743q2 = c3743q.toString();
        if (c3743q2.startsWith("LPA:")) {
            c3743q2 = c3743q2.substring("LPA:".length());
        }
        C2538c.b("QrCodeDataParse", new Object[]{"length:" + c3743q2.length() + "qrContent " + c3743q2});
        if (c3743q2.length() > f20200a || !c3743q2.startsWith("1$")) {
            return true;
        }
        m27116c(c3743q2);
        C2538c.e("QrCodeDataParse", new Object[]{"qrElement " + this.f20201b.toString()});
        if (this.f20201b.size() > 5 || this.f20201b.size() < 3) {
            C2538c.e("QrCodeDataParse", new Object[]{"ACcode is invalide"});
            return true;
        }
        boolean z;
        C2538c.b("QrCodeDataParse", new Object[]{"SM-DP+ Address " + ((String) this.f20201b.get(1))});
        if (5 == this.f20201b.size()) {
            if (m27118d((String) this.f20201b.get(1)) && m27119e((String) this.f20201b.get(2)) && "1".equals(this.f20201b.get(4))) {
                z = false;
            } else {
                z = true;
            }
        } else if (m27118d((String) this.f20201b.get(1)) && m27119e((String) this.f20201b.get(2))) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    private boolean m27118d(String str) {
        String b = m27122b(str);
        C2538c.b("QrCodeDataParse", new Object[]{"address:" + b + ":"});
        if (b == null || b.length() == 0 || -1 == b.indexOf(".")) {
            return false;
        }
        for (int i = 0; i < b.length(); i++) {
            char charAt = b.charAt(i);
            if (charAt > '~' || charAt < '!') {
                return false;
            }
        }
        char charAt2 = b.charAt(0);
        if ('-' == charAt2 || '_' == charAt2 || '.' == charAt2) {
            return false;
        }
        charAt2 = b.charAt(b.length() - 1);
        if ('-' == charAt2 || '_' == charAt2 || '.' == charAt2) {
            return false;
        }
        return true;
    }

    private boolean m27119e(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (('0' > charAt || '9' < charAt) && (('A' > charAt || 'Z' < charAt) && (('a' > charAt || 'z' < charAt) && '-' != charAt))) {
                return false;
            }
        }
        return true;
    }

    public boolean m27123b(C3743q c3743q) {
        return m27121a(m27124c(c3743q));
    }

    public String m27124c(C3743q c3743q) {
        C2538c.e("QrCodeDataParse", new Object[]{"getConformCode enter"});
        if (m27120a(c3743q)) {
            return null;
        }
        if (5 == this.f20201b.size()) {
            return (String) this.f20201b.get(4);
        }
        C2538c.b("QrCodeDataParse", new Object[]{"element length is not "});
        return null;
    }

    public boolean m27121a(String str) {
        if (str == null) {
            return false;
        }
        return "1".equals(str);
    }

    public String m27122b(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() - 1;
        C2538c.b("QrCodeDataParse", new Object[]{"start " + 0 + " last " + length});
        int i = 0;
        while (i <= length && str.charAt(i) == ' ') {
            i++;
        }
        int i2 = length;
        while (i2 >= i && str.charAt(i2) == ' ') {
            i2--;
        }
        C2538c.b("QrCodeDataParse", new Object[]{"start " + i + " end " + i2});
        if (i == 0 && i2 == length) {
            return str;
        }
        return i <= i2 ? str.substring(i, i2 + 1) : null;
    }
}
