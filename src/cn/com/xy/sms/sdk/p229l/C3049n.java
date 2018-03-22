package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.register.mobile.Country;
import com.unionpay.tsmservice.data.UniteAppStatus;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class C3049n {
    public static String m13641a(String str) {
        return (C3049n.m13653e(str) || str.length() < 7) ? str : str.substring(0, 7);
    }

    public static String m13642a(Map<String, String> map, String str) {
        return (map == null || map.isEmpty() || C3049n.m13653e(str)) ? "" : (String) map.get(str);
    }

    public static Document m13643a(String str, String str2) {
        Throwable th;
        Throwable th2;
        Document document = null;
        if (!C3049n.m13653e(str)) {
            Closeable byteArrayInputStream;
            try {
                if (str.indexOf("?>") != -1) {
                    str = str.substring(str.indexOf("?>") + 2);
                }
                StringBuilder stringBuilder = new StringBuilder(str2);
                stringBuilder.append(str);
                DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
                byteArrayInputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes("utf-8"));
                try {
                    document = newInstance.newDocumentBuilder().parse(byteArrayInputStream);
                    C3055t.m13696a(byteArrayInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        C2982a.m13415a("XIAOYUAN", "stringConvertXML: " + th.getMessage(), th);
                        C3055t.m13696a(byteArrayInputStream);
                        return document;
                    } catch (Throwable th4) {
                        th2 = th4;
                        C3055t.m13696a(byteArrayInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                byteArrayInputStream = document;
                th2 = th5;
                C3055t.m13696a(byteArrayInputStream);
                throw th2;
            }
        }
        return document;
    }

    public static boolean m13644a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        for (String e : strArr) {
            if (C3049n.m13653e(e)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] m13645a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read == -1) {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return bArr2;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static String m13646b(String str) {
        if (C3049n.m13653e(str)) {
            return str;
        }
        str = str.replace(HwAccountConstants.BLANK, "").replace("-", "").replace("(", "").replace(")", "");
        return str.startsWith("+86") ? str.replaceFirst("\\+86", "") : str.startsWith(Country.CHINA_CODE) ? str.replaceFirst(Country.CHINA_CODE, "") : str.startsWith("86") ? str.replaceFirst("86", "") : (!str.startsWith("17951") || str.length() <= 10) ? (!str.startsWith("12593") || str.length() <= 10) ? (!str.startsWith("12520") || str.length() <= 10) ? str : str.replaceFirst("12520", "") : str.replaceFirst("12593", "") : str.replaceFirst("17951", "");
    }

    public static byte[] m13647b(byte[] bArr) {
        byte[] toByteArray;
        Throwable th;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                C2982a.m13415a("XIAOYUAN", "compressGZip: " + th.getMessage(), th);
                return toByteArray;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            toByteArray = null;
            th = th4;
            C2982a.m13415a("XIAOYUAN", "compressGZip: " + th.getMessage(), th);
            return toByteArray;
        }
        return toByteArray;
    }

    public static String m13648c(byte[] bArr) {
        try {
            StringBuilder stringBuilder = new StringBuilder(bArr.length << 1);
            for (int i = 0; i < bArr.length; i++) {
                stringBuilder.append("0123456789ABCDEF".charAt((bArr[i] & 240) >> 4));
                stringBuilder.append("0123456789ABCDEF".charAt(bArr[i] & 15));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "encode: " + e.getMessage(), e);
            return null;
        }
    }

    public static boolean m13649c(String str) {
        return C3049n.m13653e(str) ? false : C3049n.m13650d(C3049n.m13646b(str));
    }

    public static boolean m13650d(String str) {
        return (str == null || str.length() != 11 || "13800138000".equals(str)) ? false : str.startsWith("13") || str.startsWith("14") || str.startsWith("15") || str.startsWith("18");
    }

    public static byte[] m13651d(byte[] bArr) {
        MessageDigest instance;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "MD5: " + e.getMessage(), e);
            instance = null;
        }
        if (instance == null) {
            return null;
        }
        instance.update(bArr);
        return instance.digest();
    }

    public static String m13652e(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return null;
        }
        String str = "0123456789abcdef";
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        while (i2 < bArr.length) {
            cArr[i] = str.charAt((bArr[i2] >> 4) & 15);
            i++;
            cArr[i] = str.charAt(bArr[i2] & 15);
            i2++;
            i++;
        }
        return String.valueOf(cArr);
    }

    public static boolean m13653e(String str) {
        return str == null || str.trim().length() == 0 || str.trim().equalsIgnoreCase("null");
    }

    public static String m13654f(String str) {
        try {
            return C3049n.m13648c(str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "encode: " + th.getMessage(), th);
            return null;
        }
    }

    public static String m13655f(byte[] bArr) {
        return C3049n.m13652e(C3049n.m13651d(bArr));
    }

    public static byte[] m13656g(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
            int i = 0;
            while (i < str.length()) {
                try {
                    byteArrayOutputStream.write(("0123456789ABCDEF".indexOf(str.charAt(i)) << 4) | "0123456789ABCDEF".indexOf(str.charAt(i + 1)));
                    i += 2;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th4) {
                C2982a.m13415a("XIAOYUAN", "encode: " + th4.getMessage(), th4);
            }
        } catch (Throwable th42) {
            byteArrayOutputStream = null;
            th2 = th42;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th2;
        }
        return bArr;
    }

    public static String m13657h(String str) {
        try {
            return new String(C3049n.m13656g(str), GameManager.DEFAULT_CHARSET);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "encode: " + th.getMessage(), th);
            return null;
        }
    }

    public static String m13658i(String str) {
        return C3049n.m13655f(str.getBytes());
    }

    public static String m13659j(String str) {
        byte[] bArr = new byte[1024];
        try {
            InputStream fileInputStream = new FileInputStream(str);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return C3049n.m13655f(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public static String m13660k(String str) {
        return str == null ? "" : str.trim();
    }

    public static String m13661l(String str) {
        return C3049n.m13653e(str) ? "" : str.length() < 2 ? "0" + str : str.length() > 2 ? UniteAppStatus.ILLEGAL : str;
    }

    public static String m13662m(String str) {
        int i = 0;
        try {
            byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            int length = bytes.length;
            int i2 = 0;
            while (i < length) {
                bytes[i2] = Byte.valueOf(new StringBuilder(String.valueOf(bytes[i] - ((i2 + 1) % 3))).toString()).byteValue();
                i2++;
                i++;
            }
            return new String(bytes);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "handlerAssemble2: " + th.getMessage(), th);
            return "";
        }
    }
}
