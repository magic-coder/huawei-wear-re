package cn.com.fmsh.util.algorithm;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.log4j.net.SyslogAppender;

public class RSA {
    public static final String EXPONENT_KEY = "Exponent";
    public static final String MODULUS_KEY = "Modulus";
    public static final String PRIVAET_KEY = "privateKey";
    public static final String PUBLIC_KEY = "publicKey";
    private static /* synthetic */ FMLog f9858a = LogFactory.getInstance().getLog();

    private static /* synthetic */ byte[] m13062a(int i, Key key, byte[] bArr, boolean z) {
        Cipher instance;
        byte[] bArr2;
        int i2 = 0;
        if (z) {
            try {
                instance = Cipher.getInstance(FM_CN.equals("\u000f\u001d^?DQA{\u0015\u001d\u0004K8Jj8)7!'", 106));
            } catch (Exception e) {
                Exception exception = e;
                bArr2 = null;
                Exception exception2 = exception;
                f9858a.error(RSA.class.getName(), FM_CN.equals("\u0011\u0007\u0004劶(觻寏斬冱珬彏带", 368));
                f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(exception2));
                return bArr2;
            } catch (Exception e2) {
                exception = e2;
                bArr2 = null;
                exception2 = exception;
                f9858a.error(RSA.class.getName(), FM_Bytes.concat("\t\u0018Z勫4觨宝旽冡珻弙平", 4, 80));
                f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(exception2));
                return bArr2;
            } catch (Exception e22) {
                exception = e22;
                bArr2 = null;
                exception2 = exception;
                f9858a.error(RSA.class.getName(), FM_Int.replace(2, "\u0005\t\u001c加,觥寏旺凵玢弗帠"));
                f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(exception2));
                return bArr2;
            } catch (Exception e222) {
                exception = e222;
                bArr2 = null;
                exception2 = exception;
                f9858a.error(RSA.class.getName(), BCCUtil.getChars("\u0007\u0014\u0018勫2觬寇日凿珧彋幣", 5, 114));
                f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(exception2));
                return bArr2;
            } catch (Exception e2222) {
                exception = e2222;
                bArr2 = null;
                exception2 = exception;
                f9858a.error(RSA.class.getName(), FM_Exception.insert(3, 30, "UV\u0002勡p觾寝斯冭玥弑幩"));
                f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(exception2));
                return bArr2;
            } catch (Exception e22222) {
                exception = e22222;
                bArr2 = null;
                exception2 = exception;
                f9858a.error(RSA.class.getName(), Util4Java.endsWith("\u0001BN勭d觪寁斳冹玱彝幥", 214, 94));
                f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(exception2));
                return bArr2;
            }
        }
        instance = Cipher.getInstance(FM_Exception.insert(3, 59, "U\u0011\u001c7\u0016M\u000b+\u0011u\u0005q/b(2p"));
        instance.init(i, key);
        if (i == 2) {
            i2 = 128;
        }
        int i3 = i == 1 ? 117 : i2;
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        while (length - i4 > 0) {
            bArr2 = length - i4 > i3 ? instance.doFinal(bArr, i4, i3) : instance.doFinal(bArr, i4, length - i4);
            byteArrayOutputStream.write(bArr2, 0, bArr2.length);
            i4 += i3;
        }
        bArr2 = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            if (bArr2 != null) {
                int i5 = 0;
                while (i5 < bArr2.length) {
                    if (bArr2[i5] != (byte) 0) {
                        break;
                    }
                    i5++;
                }
                i5 = 0;
                bArr2 = FM_Bytes.copyOfRange(bArr2, i5, bArr2.length);
            }
        } catch (NoSuchAlgorithmException e3) {
            exception2 = e3;
        } catch (NoSuchPaddingException e4) {
            exception2 = e4;
        } catch (InvalidKeyException e5) {
            exception2 = e5;
        } catch (IllegalBlockSizeException e6) {
            exception2 = e6;
        } catch (BadPaddingException e7) {
            exception2 = e7;
        } catch (IOException e8) {
            exception2 = e8;
        }
        return bArr2;
    }

    public static byte[] decrtyByPrivate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        Key key = null;
        if (bArr == null || bArr.length < 1 || bArr2 == null || bArr2.length < 1 || bArr3 == null || bArr3.length < 1) {
            return key;
        }
        try {
            key = KeyFactory.getInstance(Util4Java.endsWith("R\tU", 3, 90)).generatePrivate(new RSAPrivateKeySpec(new BigInteger(1, bArr), new BigInteger(1, bArr2)));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), FM_Exception.insert(4, 105, "Z\u0002\u001b禂钩觶官冽珠弛帺"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), FM_Bytes.concat("\n\u0014\u0017禄钱觠寔击珠彝并", 1, 111));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        }
        return m13062a(2, key, bArr3, z);
    }

    public static byte[] decryptByPrivate(byte[] bArr, byte[] bArr2, boolean z) {
        Key key = null;
        try {
            key = KeyFactory.getInstance(FM_CN.equals("\n\u001a\u001b", 5)).generatePrivate(new PKCS8EncodedKeySpec(bArr));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), CRCUtil.substring(3, "BHG觲寚斱冨班彊幫"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), FM_Utils.regionMatches(4, 72, "\u0006OE覯寒斪凾珼弖幤"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        }
        return m13062a(2, key, bArr2, z);
    }

    public static byte[] decryptByPublic(PublicKey publicKey, byte[] bArr, boolean z) {
        return m13062a(2, publicKey, bArr, z);
    }

    public static byte[] decryptByPublic(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        Key key = null;
        if (bArr == null || bArr.length < 1 || bArr2 == null || bArr2.length < 1 || bArr3 == null || bArr3.length < 1) {
            return key;
        }
        try {
            key = KeyFactory.getInstance(FM_Bytes.concat("\b\u0015S", 3, 76)).generatePublic(new RSAPublicKeySpec(new BigInteger(1, bArr), new BigInteger(1, bArr2)));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), FM_Long.copyValueOf("[UB解宛斬冭珤当并", 1));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), FM_Utils.regionMatches(5, TransportMediator.KEYCODE_MEDIA_PLAY, "\u0007\u0000\u0010覬宋施决珷彇幻"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        }
        return m13062a(2, key, bArr3, z);
    }

    public static byte[] encrtyByPrivate(PrivateKey privateKey, byte[] bArr, boolean z) {
        return m13062a(1, privateKey, bArr, z);
    }

    public static byte[] encrtyByPrivate(byte[] bArr, byte[] bArr2, boolean z) {
        Key key = null;
        try {
            key = KeyFactory.getInstance(FM_Int.replace(106, "\r\u0011\u0004")).generatePrivate(new PKCS8EncodedKeySpec(bArr));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), BCCUtil.getChars("\u0010\f]秘铳勳寖凷珺彅帼", 114, 29));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), CRCUtil.substring(5, "@NI秒钻勩宒冥珺彗常"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        }
        return m13062a(1, key, bArr2, z);
    }

    public static byte[] encrtyByPrivate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        Key key = null;
        if (bArr == null || bArr2.length < 1 || bArr == null || bArr.length < 1 || bArr3 == null || bArr3.length < 1) {
            return key;
        }
        try {
            key = KeyFactory.getInstance(FM_Long.copyValueOf("XTE", 2)).generatePrivate(new RSAPrivateKeySpec(new BigInteger(1, bArr), new BigInteger(1, bArr2)));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), Util4Java.endsWith("\u0019R\u0016禌钦勹安凿珫当帿", 206, 86));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), FM_Exception.insert(FitnessSleepType.HW_FITNESS_WAKE, 27, "\u001cZE秞铿勵寖凱珶彃幤"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        }
        return m13062a(1, key, bArr3, z);
    }

    public static byte[] encrtyByPublic(byte[] bArr, byte[] bArr2, boolean z) {
        Key key = null;
        try {
            key = KeyFactory.getInstance(CRCUtil.substring(288, "_K\u0002")).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), FM_Bytes.concat("\u000b\u000e\u0000秄钬勭宗凯玩彟幹", 2, 100));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), BCCUtil.getChars("\nNC禆钩勱寐冡现彇帲", SyslogAppender.LOG_LOCAL1, 69));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        }
        return m13062a(1, key, bArr2, z);
    }

    public static byte[] encrtyByPublic(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        Key key = null;
        if (bArr == null || bArr.length < 1 || bArr2 == null || bArr2.length < 1 || bArr3 == null || bArr3.length < 1) {
            return key;
        }
        try {
            key = KeyFactory.getInstance(FM_Long.copyValueOf("_YF", 5)).generatePublic(new RSAPublicKeySpec(new BigInteger(1, bArr), new BigInteger(1, bArr2)));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), FM_Int.replace(3, "\n\b\u001f六钡劧富凷玠弑帮"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), BCCUtil.getChars("\u0000K_儨钯劰宐冦玲彊并", 2, 38));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        }
        return m13062a(1, key, bArr3, z);
    }

    public static byte[] encryptByPublic(PublicKey publicKey, byte[] bArr, boolean z) {
        return m13062a(1, publicKey, bArr, z);
    }

    public static Map<String, byte[]> generateKey(int i) {
        KeyPairGenerator instance;
        Map<String, byte[]> hashMap = new HashMap();
        try {
            instance = KeyPairGenerator.getInstance(FM_Utils.regionMatches(1, 118, "\u0003\u0014\u001c"));
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), FM_Int.replace(4, "\u000b\u000f\u001e亥甚寎钮凴玡弖帯"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
            instance = null;
        }
        if (instance == null) {
            return null;
        }
        instance.initialize(i, new SecureRandom());
        KeyPair generateKeyPair = instance.generateKeyPair();
        hashMap.put(Util4Java.endsWith("p1*`y7\u0013yy", 3, 100), generateKeyPair.getPublic().getEncoded());
        hashMap.put(FM_Utils.regionMatches(336, 20, "0&!*qp}\u0007%-"), generateKeyPair.getPrivate().getEncoded());
        return hashMap;
    }

    public static void main(String[] strArr) {
        System.out.println(FM_Bytes.bytesToHexString(encrtyByPublic(FM_Bytes.hexStringToBytes(FM_CN.equals("\u0016\u0005b\u000e_HY=\u0019\rkb\u0005!1'6\u0017\u0004o}_<_Kj|pbsWBPG\u0013\u000bhr^M%Ol`tk\u0007 5 Akymr(>\\78g\u0007e\u0001&7$In\foyY;.V9k\u0001\u0010q C Oj\tix(M2S4\u0010wfpT?!9byl~.%GQ3f\u0000es+1X:m\u000f\u001a\rpP@!0\u0014v\u0016|(;*<n\bkd\u0004PBU1osiz-HYLf}\u0003b\u0001!=V6e~k\u000fY9)O\u001b`\u0000\u0016\u0001'CT3a\nhz-L.M3g\u0007cqQ7S1a\fly,?[T@kr\u0015}/4,8\u001frd\f*I5$;\u0011}l\u0005%8 :it\u0019\b[T@QFc\u0001\u0012v(;,Ne\t\u001b\tp(2U7", 2)), FM_Bytes.hexStringToBytes(FM_CN.equals("u'7(9k", 210)), FM_Bytes.hexStringToBytes(CRCUtil.substring(5, "\"-8\".{dlza0>&7< ruhz~i4>")), true)));
    }

    public static Map<String, BigInteger> privateKey2RSA(PrivateKey privateKey) {
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) privateKey;
        Map<String, BigInteger> hashMap = new HashMap();
        hashMap.put(Util4Java.endsWith("L5w9ik$", 164, 57), rSAPrivateKey.getModulus());
        hashMap.put(FM_Bytes.concat("\u001fs,bp*n%", 3, 49), rSAPrivateKey.getPrivateExponent());
        return hashMap;
    }

    public static Map<String, BigInteger> publicKey2RSA(PublicKey publicKey) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
        Map<String, BigInteger> hashMap = new HashMap();
        hashMap.put(FM_Int.replace(3, "\u00154:thry"), rSAPublicKey.getModulus());
        hashMap.put(FM_Int.replace(316, "Tlgus%-2"), rSAPublicKey.getPublicExponent());
        return hashMap;
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = null;
        try {
            Signature instance = Signature.getInstance(FM_Exception.insert(4, 72, "[\u0018Yq9lh\u001aC\u0019"));
            instance.initSign(privateKey);
            instance.update(bArr);
            bArr2 = instance.sign();
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), Util4Java.endsWith("禞钣筳吙弙帺", 2, 7));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), FM_Bytes.concat("禛铣筬呓弈幮", 3, 76));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9858a.error(RSA.class.getName(), FM_Exception.insert(2, 74, "秇铵筤呉弌幠"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e22));
        }
        return bArr2;
    }

    public static byte[] sign(byte[] bArr, byte[] bArr2) {
        KeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr2);
        byte[] bArr3 = null;
        try {
            KeyFactory instance = KeyFactory.getInstance(FM_Int.replace(6, "\t\r@"));
            Signature instance2 = Signature.getInstance(FM_Long.copyValueOf("^BF5v7/0\u0007\u0001\u000e", 5));
            instance2.initSign(instance.generatePrivate(pKCS8EncodedKeySpec));
            instance2.update(bArr);
            bArr3 = instance2.sign();
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), FM_Utils.regionMatches(4, 82, "禕铣筦呇弞帶"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), CRCUtil.substring(4, "秐钹筹吟弟幰"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9858a.error(RSA.class.getName(), BCCUtil.getChars("禔钫筹呍彛幪", 5, 25));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9858a.error(RSA.class.getName(), FM_Exception.insert(266, 12, "秏钿筸吟弜干"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e222));
        }
        return bArr3;
    }

    public static byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        KeySpec rSAPrivateKeySpec = new RSAPrivateKeySpec(new BigInteger(1, bArr2), new BigInteger(1, bArr3));
        byte[] bArr4 = null;
        try {
            KeyFactory instance = KeyFactory.getInstance(FM_Int.replace(354, "\u0005\t\u001c"));
            Signature instance2 = Signature.getInstance(FM_Int.replace(5, "\t\u0015A2q`xg@FY"));
            instance2.initSign(instance.generatePrivate(rSAPrivateKeySpec));
            instance2.update(bArr);
            bArr4 = instance2.sign();
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), BCCUtil.getChars("禍铡笢呙彎幼", ReportInfoUtils.FEEDBACK_FAILED, 120));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), FM_Long.copyValueOf("秅钤笠呖彚幭", ReportInfoUtils.FEEDBACK_FAILED));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9858a.error(RSA.class.getName(), FM_Utils.regionMatches(120, 89, "禉铤筤呞彎帽"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9858a.error(RSA.class.getName(), FM_Utils.regionMatches(164, 56, "秕铩筺向彖帴"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e222));
        }
        return bArr4;
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        KeySpec rSAPublicKeySpec = new RSAPublicKeySpec(new BigInteger(1, bArr2), new BigInteger(1, bArr3));
        boolean z = false;
        try {
            KeyFactory instance = KeyFactory.getInstance(BCCUtil.getChars("\u0004UW", 6, 16));
            Signature instance2 = Signature.getInstance(FM_Int.replace(3, "\u000b\u0013\u001f0sn~eB@W"));
            instance2.initVerify(instance.generatePublic(rSAPublicKeySpec));
            instance2.update(bArr);
            z = instance2.verify(bArr4);
        } catch (Exception e) {
            f9858a.error(RSA.class.getName(), Util4Java.endsWith("儲铨骐笵弘帱", 1, 79));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9858a.error(RSA.class.getName(), FM_Utils.regionMatches(5, 48, "儹钠髙筻弗幽"));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9858a.error(RSA.class.getName(), FM_CN.equals("儻铭髕笴弙帴", 4));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9858a.error(RSA.class.getName(), Util4Java.endsWith("六钦髉笹弋帳", 4, 34));
            f9858a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e222));
        }
        return z;
    }
}
