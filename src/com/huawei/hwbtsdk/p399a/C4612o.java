package com.huawei.hwbtsdk.p399a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

@SuppressLint({"NewApi"})
/* compiled from: CommandPackage */
public class C4612o {
    private static C4612o f16865a = null;
    private static int f16866b = 0;
    private static final byte[] f16867c = new byte[]{TagName.ELECTRONIC, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_CONTENT, TagName.ELECTRONIC_TYPE_ID, TagName.TERMINAL_BACK_CONTENT};
    private static final byte[] f16868d = new byte[]{TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.PAY_ORDER_ID, TagName.ELECTRONIC_STATE, TagName.PUBLISH_END_TIME, (byte) 119};
    private static final byte[] f16869e = new byte[]{TagName.OPERATE_TIMING, TagName.NOTICE_ID, TagName.APK_SIZE, TagName.PAY_ORDER_ID, TagName.PRODUCT_ID, (byte) 102};
    private byte[] f16870f = C4612o.m22005a(f16867c, C4599c.f16820a, C4597a.f16817a);
    private byte[] f16871g = C4612o.m22005a(f16868d, C4599c.f16821b, C4613p.f16874a);
    private byte[] f16872h = C4612o.m22005a(f16869e, C4599c.f16822c, C4619w.f16883a);
    private String f16873i = "";

    public byte[] m22012a() {
        return C0973a.b(C0973a.a(this.f16870f));
    }

    private static byte[] m22005a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr2);
            byteArrayOutputStream.write(bArr3);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    public String m22014b() {
        return this.f16873i;
    }

    private C4612o(Context context) {
    }

    public static C4612o m22004a(Context context) {
        if (f16865a == null) {
            f16865a = new C4612o(context);
        }
        return f16865a;
    }

    public String m22010a(String str, Context context, byte[] bArr) {
        this.f16873i = m22008a(str, context);
        C2538c.a("01", 1, "CommandPackage", new Object[]{"createKey() begin "});
        if (this.f16873i == null || this.f16873i.equals("")) {
            int size;
            SharedPreferences sharedPreferences = context.getSharedPreferences("btsdk_sharedpreferences_name4", 0);
            byte[] b = C0973a.b(C0973a.e(str.replace(":", "") + "0000"));
            if (sharedPreferences.getAll() != null) {
                size = sharedPreferences.getAll().size();
            } else {
                size = 0;
            }
            C2538c.a("01", 0, "CommandPackage", new Object[]{"createKey() SharedPreferences.size() = " + size});
            if (size != 0) {
                m22015b(context);
            }
            byte[] b2 = m22006b(this.f16871g, this.f16872h, b);
            String e = m22007e();
            if (bArr != null) {
                b2 = C4618u.m22032a(1, C0973a.b(e), b2, bArr);
                if (b2 != null) {
                    this.f16873i = C0973a.a(bArr) + C0973a.a(b2);
                } else {
                    C2538c.a("01", 0, "CommandPackage", new Object[]{"keys_encrypt is null."});
                }
            } else {
                b2 = C4618u.m22032a(1, C0973a.b(e), b2, this.f16870f);
                C2538c.a("01", 0, "CommandPackage", new Object[]{"Enter old iv."});
                if (b2 != null) {
                    this.f16873i = C0973a.a(b2);
                } else {
                    C2538c.a("01", 0, "CommandPackage", new Object[]{"keys_encrypt is null."});
                }
            }
        }
        C2538c.a("01", 0, "CommandPackage", new Object[]{"createKey() finish"});
        return this.f16873i;
    }

    public String m22008a(String str, Context context) {
        if (str == null || context == null) {
            C2538c.a("01", 0, "CommandPackage", new Object[]{"getKeyFromSharedpreferences with parameter incorrect."});
            return null;
        }
        String string = context.getSharedPreferences("btsdk_sharedpreferences_name4", 0).getString(str, "");
        C2538c.a("01", 0, "CommandPackage", new Object[]{"getKeyFromSharedpreferences ok"});
        return string;
    }

    public String m22009a(String str, Context context, String str2, byte[] bArr) {
        String str3 = null;
        if (!(str == null || str.equals(""))) {
            C2538c.a("01", 0, "CommandPackage", new Object[]{"decrypt before"});
            SharedPreferences sharedPreferences = context.getSharedPreferences("btsdk_sharedpreferences_name1", 0);
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("btsdk_sharedpreferences_name2", 0);
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("btsdk_sharedpreferences_name3", 0);
            byte[] b = C0973a.b(sharedPreferences.getString(str2, ""));
            byte[] b2 = C0973a.b(sharedPreferences2.getString(str2, ""));
            byte[] b3 = C0973a.b(sharedPreferences3.getString(str2, ""));
            if (bArr != null) {
                str3 = C0973a.a(C4618u.m22035b(1, C0973a.b(str), m22006b(b, b2, b3), bArr));
            } else {
                str3 = C0973a.a(C4618u.m22035b(1, C0973a.b(str), m22006b(b, b2, b3), this.f16870f));
            }
            C2538c.a("01", 0, "CommandPackage", new Object[]{"decrypt after "});
        }
        return str3;
    }

    public void m22011a(String str, byte[] bArr, String str2, Context context) {
        Editor edit = context.getSharedPreferences(str2, 0).edit();
        String a = a.a(bArr);
        edit.clear();
        edit.commit();
        edit.putString(str, a);
        C2538c.a("01", 0, "CommandPackage", new Object[]{"putKeyToSharedpreferences()"});
        edit.commit();
    }

    private byte[] m22006b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i;
        byte[] bArr4 = new byte[bArr.length];
        for (i = 0; i < bArr.length; i++) {
            bArr4[i] = (byte) ((bArr[i] << 4) ^ bArr2[i]);
        }
        C2538c.a("01", 0, "CommandPackage", new Object[]{"createKeyData() step1"});
        bArr4 = C4618u.m22033a(bArr4);
        C2538c.a("01", 0, "CommandPackage", new Object[]{"createKeyData() step2"});
        String a = a.a(bArr4);
        byte[] bArr5 = new byte[bArr4.length];
        if (bArr5.length == 0 || bArr3.length == 0) {
            C2538c.a("01", 0, "CommandPackage", new Object[]{"key_data len or C3 len = 0."});
            return null;
        }
        for (i = 0; i < bArr4.length; i++) {
            bArr5[i] = (byte) ((Integer.parseInt(a.substring(i * 2, (i * 2) + 2), 16) >> 6) ^ bArr3[i]);
        }
        C2538c.a("01", 0, "CommandPackage", new Object[]{"createKeyData() step3"});
        byte[] a2 = C4618u.m22033a(bArr5);
        C2538c.a("01", 0, "CommandPackage", new Object[]{"createKeyData() step4"});
        return a2;
    }

    public void m22015b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("btsdk_sharedpreferences_name1", 0);
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("btsdk_sharedpreferences_name2", 0);
        SharedPreferences sharedPreferences3 = context.getSharedPreferences("btsdk_sharedpreferences_name3", 0);
        SharedPreferences sharedPreferences4 = context.getSharedPreferences("btsdk_sharedpreferences_name4", 0);
        Editor edit = sharedPreferences.edit();
        Editor edit2 = sharedPreferences2.edit();
        Editor edit3 = sharedPreferences3.edit();
        Editor edit4 = sharedPreferences4.edit();
        edit.clear();
        edit2.clear();
        edit3.clear();
        edit4.clear();
        edit.commit();
        edit2.commit();
        edit3.commit();
        edit4.commit();
    }

    private String m22007e() {
        SecureRandom secureRandom = new SecureRandom();
        char[] toCharArray = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        byte[] bArr = new byte[16];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) toCharArray[secureRandom.nextInt(36)];
        }
        return C0973a.a(bArr);
    }

    public byte[] m22013a(byte[] bArr) {
        int[] iArr = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935, 4657, 528, 12915, 8786, 21173, 17044, 29431, 25302, 37689, 33560, 45947, 41818, 54205, 50076, 62463, 58334, 9314, 13379, 1056, 5121, 25830, 29895, 17572, 21637, 42346, 46411, 34088, 38153, 58862, 62927, 50604, 54669, 13907, 9842, 5649, 1584, 30423, 26358, 22165, 18100, 46939, 42874, 38681, 34616, 63455, 59390, 55197, 51132, 18628, 22757, 26758, 30887, 2112, 6241, 10242, 14371, 51660, 55789, 59790, 63919, 35144, 39273, 43274, 47403, 23285, 19156, 31415, 27286, 6769, 2640, 14899, 10770, 56317, 52188, 64447, 60318, 39801, 35672, 47931, 43802, 27814, 31879, 19684, 23749, 11298, 15363, 3168, 7233, 60846, 64911, 52716, 56781, 44330, 48395, 36200, 40265, 32407, 28342, 24277, 20212, 15891, 11826, 7761, 3696, 65439, 61374, 57309, 53244, 48923, 44858, 40793, 36728, 37256, 33193, 45514, 41451, 53516, 49453, 61774, 57711, 4224, 161, 12482, 8419, 20484, 16421, 28742, 24679, 33721, 37784, 41979, 46042, 49981, 54044, 58239, 62302, 689, 4752, 8947, 13010, 16949, 21012, 25207, 29270, 46570, 42443, 38312, 34185, 62830, 58703, 54572, 50445, 13538, 9411, 5280, 1153, 29798, 25671, 21540, 17413, 42971, 47098, 34713, 38840, 59231, 63358, 50973, 55100, 9939, 14066, 1681, 5808, 26199, 30326, 17941, 22068, 55628, 51565, 63758, 59695, 39368, 35305, 47498, 43435, 22596, 18533, 30726, 26663, 6336, 2273, 14466, 10403, 52093, 56156, 60223, 64286, 35833, 39896, 43963, 48026, 19061, 23124, 27191, 31254, 2801, 6864, 10931, 14994, 64814, 60687, 56684, 52557, 48554, 44427, 40424, 36297, 31782, 27655, 23652, 19525, 15522, 11395, 7392, 3265, 61215, 65342, 53085, 57212, 44955, 49082, 36825, 40952, 28183, 32310, 20053, 24180, 11923, 16050, 3793, 7920};
        int i = 0;
        for (byte b : bArr) {
            i = (short) (iArr[((i >> 8) ^ b) & 255] ^ (i << 8));
        }
        byte[] bArr2 = new byte[]{(byte) 0, (byte) 0};
        bArr2[1] = (byte) i;
        bArr2[0] = (byte) (i >> 8);
        return bArr2;
    }

    public byte[] m22016c() {
        if (this.f16871g == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.f16871g);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    public byte[] m22017d() {
        if (this.f16872h == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.f16872h);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }
}
