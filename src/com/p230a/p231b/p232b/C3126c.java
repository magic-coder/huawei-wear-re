package com.p230a.p231b.p232b;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.p230a.p231b.p232b.p233a.C3112j;
import com.p230a.p231b.p235a.C3081a;
import com.p230a.p231b.p235a.C3083c;
import com.p230a.p231b.p235a.C3084d;
import com.p230a.p231b.p237c.C3128a;
import com.p230a.p231b.p237c.C3132e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.cookie.SM;

public class C3126c {
    private static C3126c f10478a;
    private static KeyGenerator f10479b;
    private static Cipher f10480c;
    private static boolean f10481d = false;
    private static byte[] f10482e = null;
    private static byte[] f10483f = new byte[]{TagName.CARD_FORM, (byte) -82, TagName.ELECTRONIC_TYPE, TagName.TERMINAL_BACK_INFO_TYPE, (byte) 33, (byte) -85, (byte) -26, TagName.RENT_HANDLE_DATD, (byte) -7, TagName.URL_TYPE, TagName.TERMINAL_BACK_QUESTION_FLAG, (byte) -18, TagName.NOTICE_START_TIME, (byte) -3, (byte) -2, Byte.MIN_VALUE};

    public static C3126c m13916a() {
        if (f10478a == null) {
            f10478a = new C3126c();
        }
        return f10478a;
    }

    private static String m13917a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        Map b = C3126c.m13921b(str);
        Map b2 = C3126c.m13921b(str2);
        b.putAll(b2);
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : b.entrySet()) {
            stringBuilder.append(new StringBuilder(String.valueOf((String) entry.getKey())).append("=").append((String) entry.getValue()).append(";").toString());
        }
        b.clear();
        b2.clear();
        return stringBuilder.toString();
    }

    private static byte[] m13918a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr2;
    }

    private static byte[] m13919a(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = f10483f;
        }
        byte[] bArr3 = null;
        if (!f10481d) {
            C3126c.m13923c();
        }
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            f10480c.init(1, secretKeySpec, new IvParameterSpec(f10482e));
            bArr3 = f10480c.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr3;
    }

    public static HashMap m13920b() {
        HashMap hashMap = new HashMap(10);
        hashMap.clear();
        hashMap.put("Content-Type", "text/xml");
        hashMap.put("MAP_CLIENTID", C3084d.f10347a);
        hashMap.put("CLIENTNAME", C3084d.f10348b);
        hashMap.put("MAP_DATATYPE", "form");
        hashMap.put("map_clientversion", C3084d.f10349c);
        hashMap.put("MAP_XINFO", C3084d.f10350d);
        hashMap.put("IMEI", C3084d.f10351e);
        hashMap.put("IMSI", C3084d.f10352f);
        hashMap.put("PHONENUM", C3084d.f10353g);
        hashMap.put("ICCID", C3084d.f10354h);
        hashMap.put("CLIENTIP", C3084d.f10355i);
        hashMap.put("MAP_Channel", C3084d.f10356j);
        hashMap.put("MAP_DataEncoding", "AES");
        hashMap.put("MAPAccept-Encoding", "gzip");
        return hashMap;
    }

    private static Map m13921b(String str) {
        Map hashMap = new HashMap(1);
        for (String str2 : str.split(";")) {
            if (str2 != null && str2.length() > 0) {
                String[] split = str2.split("=");
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    private static byte[] m13922b(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = f10483f;
        }
        byte[] bArr3 = null;
        if (!f10481d) {
            C3126c.m13923c();
        }
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            f10480c.init(2, secretKeySpec, new IvParameterSpec(f10482e));
            bArr3 = f10480c.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr3;
    }

    private static void m13923c() {
        f10482e = "0123456789ABCDEF".getBytes();
        try {
            f10479b = KeyGenerator.getInstance("AES");
            f10480c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            f10479b.init(128);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        }
        f10481d = true;
    }

    public String m13924a(C3112j c3112j, String str) {
        byte[] bArr = c3112j.f10433b;
        if (c3112j != null) {
            try {
                if (c3112j.f10434c != null) {
                    String str2 = (String) c3112j.f10434c.get(SM.SET_COOKIE);
                    if (str2 != null && str2.length() > 0) {
                        Object obj;
                        String str3 = "/";
                        int indexOf = str2.indexOf("Path=");
                        if (indexOf > 0) {
                            int i = indexOf + 5;
                            indexOf = str2.indexOf(";", i);
                            str3 = indexOf >= i ? str2.substring(i, indexOf) : str2.substring(i);
                        }
                        if (str.indexOf("://") >= 0 && str.indexOf("/", str.indexOf("://") + 3) > 10) {
                            obj = str.substring(0, str.indexOf("/", 10)) + str3;
                        }
                        if (C3083c.m13791a().m13792b() != null) {
                            C3083c.m13791a().m13792b().put(obj, C3126c.m13917a((String) C3083c.m13791a().m13792b().get(obj), str2));
                        }
                    }
                }
            } catch (UnsupportedEncodingException e) {
                return "DataError";
            }
        }
        byte[] b = (c3112j.f10434c == null || !"aes".equalsIgnoreCase((String) c3112j.f10434c.get("MAP_DataEncoding"))) ? bArr : C3126c.m13922b(bArr, C3126c.m13918a(C3084d.f10347a.getBytes()));
        if (c3112j.f10434c != null && "gzip".equalsIgnoreCase((String) c3112j.f10434c.get("MAPContent-Encoding"))) {
            b = C3128a.m13931a(b);
        }
        return new String(b, "utf-8");
    }

    public Map m13925a(String str) {
        Map b = C3126c.m13920b();
        if (str != null && C3083c.m13791a().m13792b() != null && C3083c.m13791a().m13792b().size() > 0) {
            for (Entry entry : C3083c.m13791a().m13792b().entrySet()) {
                if (str.startsWith((String) entry.getKey(), 0)) {
                    b.put("COOKIE", (String) entry.getValue());
                    break;
                }
            }
        }
        return b;
    }

    public byte[] m13926a(HashMap hashMap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getValue();
                if (!(((String) entry.getKey()) == null || str == null)) {
                    str = URLEncoder.encode((String) entry.getKey(), "utf-8");
                    String encode = URLEncoder.encode((String) entry.getValue(), "utf-8");
                    byteArrayOutputStream.write(String.format("&%s=%s", new Object[]{str, encode}).getBytes());
                }
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] m13927a(Map map, byte[] bArr) {
        try {
            Object a = C3126c.m13919a(bArr, C3126c.m13918a(C3084d.f10347a.getBytes()));
            byte[] bArr2 = new byte[(a.length + C3081a.f10344a.length)];
            System.arraycopy(a, 0, bArr2, 0, a.length);
            System.arraycopy(C3081a.f10344a, 0, bArr2, a.length, C3081a.f10344a.length);
            map.put("MAP_CHECKKEY", C3132e.m13952a(C3126c.m13918a(bArr2)));
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
