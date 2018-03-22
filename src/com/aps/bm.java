package com.aps;

import android.text.TextUtils;
import com.huawei.hwid.core.datatype.SiteCountryInfo;
import java.util.zip.CRC32;

/* compiled from: Req */
public class bm {
    public byte[] f13026A = null;
    public String f13027B = null;
    public String f13028C = null;
    public String f13029D = null;
    public String f13030E = null;
    public String f13031a = "1";
    public short f13032b = (short) 0;
    public String f13033c = null;
    public String f13034d = null;
    public String f13035e = null;
    public String f13036f = null;
    public String f13037g = null;
    public String f13038h = null;
    public String f13039i = null;
    public String f13040j = null;
    public String f13041k = null;
    public String f13042l = null;
    public String f13043m = null;
    public String f13044n = null;
    public String f13045o = null;
    public String f13046p = null;
    public String f13047q = null;
    public String f13048r = null;
    public String f13049s = null;
    public String f13050t = null;
    public String f13051u = null;
    public String f13052v = null;
    public String f13053w = null;
    public String f13054x = null;
    public String f13055y = null;
    public String f13056z = null;

    public byte[] m17427a() {
        Object bytes;
        int length;
        Object b;
        String[] split;
        m17426b();
        int i = 3072;
        if (this.f13026A != null) {
            i = 3072 + (this.f13026A.length + 1);
        }
        Object obj = new byte[i];
        obj[0] = Byte.parseByte(this.f13031a);
        Object b2 = bq.m17440b(this.f13032b);
        System.arraycopy(b2, 0, obj, 1, b2.length);
        i = b2.length + 1;
        try {
            bytes = this.f13033c.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13034d.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e2) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13044n.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e3) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13035e.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e4) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13036f.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e5) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13037g.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e6) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13048r.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e7) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13038h.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e8) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13045o.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e9) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13046p.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e10) {
            obj[i] = null;
            i++;
        }
        if (TextUtils.isEmpty(this.f13047q)) {
            obj[i] = null;
            i++;
        } else {
            bytes = m17424a(this.f13047q);
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        try {
            bytes = this.f13027B.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e11) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13028C.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e12) {
            obj[i] = null;
            i++;
        }
        try {
            bytes = this.f13049s.getBytes("GBK");
            obj[i] = (byte) bytes.length;
            i++;
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        } catch (Exception e13) {
            obj[i] = null;
            i++;
        }
        obj[i] = Byte.parseByte(this.f13050t);
        i++;
        obj[i] = Byte.parseByte(this.f13040j);
        i++;
        if (this.f13040j.equals("1")) {
            try {
                obj[i] = Byte.parseByte(this.f13029D);
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.f13040j.equals("1") || this.f13040j.equals("2")) {
            bytes = bq.m17437a(Integer.parseInt(this.f13041k));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        if (this.f13040j.equals("1") || this.f13040j.equals("2")) {
            bytes = bq.m17437a(Integer.parseInt(this.f13042l));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        if (this.f13040j.equals("1") || this.f13040j.equals("2")) {
            bytes = bq.m17441b(this.f13043m);
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
        }
        obj[i] = Byte.parseByte(this.f13051u);
        i++;
        if (this.f13051u.equals("1")) {
            bytes = bq.m17441b(m17425b(SiteCountryInfo.TAG_MCC));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17441b(m17425b("mnc"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17441b(m17425b("lac"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17439a(m17425b("cellid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            length = bytes.length + i;
            i = Integer.parseInt(m17425b("signal"));
            if (i > 127) {
                i = 0;
            } else if (i < -128) {
                i = 0;
            }
            obj[length] = (byte) i;
            i = length + 1;
            if (this.f13053w.length() == 0) {
                obj[i] = null;
                i++;
            } else {
                int length2 = this.f13053w.split("\\*").length;
                obj[i] = (byte) length2;
                i++;
                length = 0;
                while (length < length2) {
                    b = bq.m17441b(m17423a("lac", length));
                    System.arraycopy(b, 0, obj, i, b.length);
                    i += b.length;
                    b = bq.m17439a(m17423a("cellid", length));
                    System.arraycopy(b, 0, obj, i, b.length);
                    int length3 = b.length + i;
                    i = Integer.parseInt(m17423a("signal", length));
                    if (i > 127) {
                        i = 0;
                    } else if (i < -128) {
                        i = 0;
                    }
                    obj[length3] = (byte) i;
                    length++;
                    i = length3 + 1;
                }
            }
        } else if (this.f13051u.equals("2")) {
            bytes = bq.m17441b(m17425b(SiteCountryInfo.TAG_MCC));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17441b(m17425b("sid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17441b(m17425b("nid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17441b(m17425b("bid"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17439a(m17425b("lon"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            i += bytes.length;
            bytes = bq.m17439a(m17425b("lat"));
            System.arraycopy(bytes, 0, obj, i, bytes.length);
            length = bytes.length + i;
            i = Integer.parseInt(m17425b("signal"));
            if (i > 127) {
                i = 0;
            } else if (i < -128) {
                i = 0;
            }
            obj[length] = (byte) i;
            i = length + 1;
            obj[i] = null;
            i++;
        }
        if (this.f13054x.length() == 0) {
            obj[i] = null;
            i++;
        } else {
            obj[i] = 1;
            i++;
            try {
                split = this.f13054x.split(",");
                b = m17424a(split[0]);
                System.arraycopy(b, 0, obj, i, b.length);
                i += b.length;
                b = split[2].getBytes("GBK");
                obj[i] = (byte) b.length;
                i++;
                System.arraycopy(b, 0, obj, i, b.length);
                i += b.length;
            } catch (Exception e14) {
                obj[i] = (byte) 0;
                i++;
            } catch (Throwable th2) {
                bytes = m17424a("00:00:00:00:00:00");
                System.arraycopy(bytes, 0, obj, i, bytes.length);
                i += bytes.length;
                obj[i] = null;
                i++;
                obj[i] = Byte.parseByte("0");
                i++;
            }
            length = Integer.parseInt(split[1]);
            if (length > 127) {
                length = 0;
            } else if (length < -128) {
                length = 0;
            }
            obj[i] = Byte.parseByte(String.valueOf(length));
            i++;
        }
        String[] split2 = this.f13055y.split("\\*");
        if (TextUtils.isEmpty(this.f13055y) || split2.length == 0) {
            obj[i] = null;
            i++;
        } else {
            obj[i] = (byte) split2.length;
            i++;
            length3 = 0;
            while (length3 < split2.length) {
                split = split2[length3].split(",");
                Object a = m17424a(split[0]);
                System.arraycopy(a, 0, obj, i, a.length);
                i += a.length;
                try {
                    a = split[2].getBytes("GBK");
                    obj[i] = (byte) a.length;
                    i++;
                    System.arraycopy(a, 0, obj, i, a.length);
                    i += a.length;
                } catch (Exception e15) {
                    obj[i] = null;
                    i++;
                }
                length = Integer.parseInt(split[1]);
                if (length > 127) {
                    length = 0;
                } else if (length < -128) {
                    length = 0;
                }
                obj[i] = Byte.parseByte(String.valueOf(length));
                length3++;
                i++;
            }
            if (this.f13030E != null && this.f13030E.length() > 0) {
                try {
                    bytes = bq.m17440b(Integer.parseInt(this.f13030E));
                    System.arraycopy(bytes, 0, obj, i, bytes.length);
                    i += bytes.length;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
        try {
            bytes = this.f13056z.getBytes("GBK");
            if (bytes.length > 127) {
                bytes = null;
            }
            if (bytes == null) {
                obj[i] = (byte) 0;
                i++;
            } else {
                obj[i] = (byte) bytes.length;
                i++;
                System.arraycopy(bytes, 0, obj, i, bytes.length);
                i += bytes.length;
            }
        } catch (Exception e16) {
            obj[i] = null;
            i++;
        }
        if (this.f13026A != null) {
            length = this.f13026A.length;
        } else {
            length = 0;
        }
        b = bq.m17440b(length);
        System.arraycopy(b, 0, obj, i, b.length);
        i += b.length;
        if (length > 0) {
            System.arraycopy(this.f13026A, 0, obj, i, this.f13026A.length);
            i += this.f13026A.length;
        }
        bytes = new byte[i];
        System.arraycopy(obj, 0, bytes, 0, i);
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        b = bq.m17438a(crc32.getValue());
        obj = new byte[(b.length + i)];
        System.arraycopy(bytes, 0, obj, 0, i);
        System.arraycopy(b, 0, obj, i, b.length);
        i += b.length;
        return obj;
    }

    private byte[] m17424a(String str) {
        String[] split = str.split(":");
        if (split == null || split.length != 6) {
            String[] strArr = new String[6];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = "0";
            }
            split = strArr;
        }
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].length() > 2) {
                split[i2] = split[i2].substring(0, 2);
            }
            bArr[i2] = (byte) Integer.parseInt(split[i2], 16);
        }
        return bArr;
    }

    private String m17425b(String str) {
        if (!this.f13052v.contains(str + ">")) {
            return "0";
        }
        int indexOf = this.f13052v.indexOf(str + ">");
        return this.f13052v.substring((indexOf + str.length()) + 1, this.f13052v.indexOf("</" + str));
    }

    private String m17423a(String str, int i) {
        String[] split = this.f13053w.split("\\*")[i].split(",");
        if (str.equals("lac")) {
            return split[0];
        }
        if (str.equals("cellid")) {
            return split[1];
        }
        if (str.equals("signal")) {
            return split[2];
        }
        return null;
    }

    private void m17426b() {
        if (TextUtils.isEmpty(this.f13031a)) {
            this.f13031a = "";
        }
        if (TextUtils.isEmpty(this.f13033c)) {
            this.f13033c = "";
        }
        if (TextUtils.isEmpty(this.f13034d)) {
            this.f13034d = "";
        }
        if (TextUtils.isEmpty(this.f13035e)) {
            this.f13035e = "";
        }
        if (TextUtils.isEmpty(this.f13036f)) {
            this.f13036f = "";
        }
        if (TextUtils.isEmpty(this.f13037g)) {
            this.f13037g = "";
        }
        if (TextUtils.isEmpty(this.f13038h)) {
            this.f13038h = "";
        }
        if (TextUtils.isEmpty(this.f13039i)) {
            this.f13039i = "";
        }
        if (TextUtils.isEmpty(this.f13040j)) {
            this.f13040j = "0";
        } else if (!(this.f13040j.equals("1") || this.f13040j.equals("2"))) {
            this.f13040j = "0";
        }
        if (TextUtils.isEmpty(this.f13029D)) {
            this.f13029D = "0";
        } else if (!(this.f13029D.equals("0") || this.f13029D.equals("1"))) {
            this.f13029D = "0";
        }
        if (TextUtils.isEmpty(this.f13041k)) {
            this.f13041k = "";
        } else {
            this.f13041k = String.valueOf(Double.valueOf(Double.parseDouble(this.f13041k) * 1200000.0d).intValue());
        }
        if (TextUtils.isEmpty(this.f13042l)) {
            this.f13042l = "";
        } else {
            this.f13042l = String.valueOf(Double.valueOf(Double.parseDouble(this.f13042l) * 1000000.0d).intValue());
        }
        if (TextUtils.isEmpty(this.f13043m)) {
            this.f13043m = "";
        }
        if (TextUtils.isEmpty(this.f13044n)) {
            this.f13044n = "";
        }
        if (TextUtils.isEmpty(this.f13045o)) {
            this.f13045o = "";
        }
        if (TextUtils.isEmpty(this.f13046p)) {
            this.f13046p = "";
        }
        if (TextUtils.isEmpty(this.f13047q)) {
            this.f13047q = "";
        }
        if (TextUtils.isEmpty(this.f13048r)) {
            this.f13048r = "";
        }
        if (TextUtils.isEmpty(this.f13027B)) {
            this.f13027B = "";
        }
        if (TextUtils.isEmpty(this.f13028C)) {
            this.f13028C = "";
        }
        if (TextUtils.isEmpty(this.f13049s)) {
            this.f13049s = "";
        }
        if (TextUtils.isEmpty(this.f13050t)) {
            this.f13050t = "0";
        } else if (!(this.f13050t.equals("1") || this.f13050t.equals("2"))) {
            this.f13050t = "0";
        }
        if (TextUtils.isEmpty(this.f13051u)) {
            this.f13051u = "0";
        } else if (!(this.f13051u.equals("1") || this.f13051u.equals("2"))) {
            this.f13051u = "0";
        }
        if (TextUtils.isEmpty(this.f13052v)) {
            this.f13052v = "";
        }
        if (TextUtils.isEmpty(this.f13053w)) {
            this.f13053w = "";
        }
        if (TextUtils.isEmpty(this.f13054x)) {
            this.f13054x = "";
        }
        if (TextUtils.isEmpty(this.f13055y)) {
            this.f13055y = "";
        }
        if (TextUtils.isEmpty(this.f13030E)) {
            this.f13030E = "";
        }
        if (TextUtils.isEmpty(this.f13056z)) {
            this.f13056z = "";
        }
        if (this.f13026A == null) {
            this.f13026A = new byte[0];
        }
    }
}
