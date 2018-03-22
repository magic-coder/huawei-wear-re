package cn.com.fmsh.util.algorithm;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DES {
    private static /* synthetic */ FMLog f9853a = LogFactory.getInstance().getLog();

    public static byte[] decrypt4des(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, FM_Bytes.concat("W\t\u0016", 60, 25));
        byte[] bArr3 = null;
        try {
            Cipher instance = Cipher.getInstance(FM_Int.replace(5, "\u001e\u0018S,CJN \\zHzzemim"));
            instance.init(2, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (Exception e) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
        } catch (Exception e2222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
        }
        return bArr3;
    }

    public static byte[] decrypt4des3(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            f9853a.error(DES.class.getName(), FM_Exception.insert(280, 16, "寥敼捲辗蠐\u0018IO觯寚斺ｐ佬儹皈WIE扚聙忉勼寊皘敼捲乶290`"));
            return null;
        }
        if (bArr.length % 8 != 0) {
            f9853a.error(DES.class.getName(), FM_Int.replace(2, "宮攪挳进衏5MI\\觱寓旮７伾兤皀LOT皔散捸镦庺丒告沐"));
        }
        byte[] copyOf = FM_Bytes.copyOf(bArr, 8);
        return decrypt4des(copyOf, encrypt4des(FM_Bytes.copyOfRange(bArr, 8, bArr.length), decrypt4des(copyOf, bArr2)));
    }

    public static byte[] decrypt4des3CBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null) {
            f9853a.error(DES.class.getName(), FM_CN.equals("审改挴辐衐>ZJS覲宄斥ｈ伵兣皓C\u001c\u0013才聉徘劮寙皔敱挼乹:0zk", 5));
            return null;
        }
        if (bArr.length % 8 != 0) {
            f9853a.error(DES.class.getName(), FM_CN.equals("寬敶挹输蠕y_IN觭宙斦ｍ佲儦皐NS^盜改挴锴庺一吖泚", 290));
        }
        int length = bArr2.length / 8;
        byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{length, 8});
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr4[i][i2] = bArr2[(i << 3) + i2];
            }
        }
        byte[] xor = FM_Bytes.xor(decrypt4des3(bArr, bArr4[0]), bArr3);
        int i3 = 1;
        while (i3 < length) {
            byte[] join = FM_Bytes.join(xor, FM_Bytes.xor(decrypt4des3(bArr, bArr4[i3]), bArr4[i3 - 1]));
            i3++;
            xor = join;
        }
        return xor;
    }

    public static byte[] decrypt4desCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Key secretKeySpec = new SecretKeySpec(bArr, Util4Java.endsWith("D\u0014Q", 3, 81));
        byte[] bArr4 = null;
        String equals = FM_CN.equals("\u0011\u0003\u0004gZHX#\u0013!\u000f1%vjzb", TransportMediator.KEYCODE_MEDIA_RECORD);
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        try {
            Cipher instance = Cipher.getInstance(equals);
            instance.init(2, secretKeySpec, ivParameterSpec);
            bArr4 = instance.doFinal(bArr2);
        } catch (Exception e) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
        } catch (Exception e2222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
        } catch (Exception e22222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22222));
        }
        return bArr4;
    }

    public static byte[] decrypt4desPadding(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, FM_Exception.insert(5, 12, "MPR"));
        byte[] bArr3 = null;
        try {
            Cipher instance = Cipher.getInstance(FM_Utils.regionMatches(4, 34, "\u0010SKu\u0019]\u0002mTg,.e`7"));
            instance.init(2, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (Exception e) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
        } catch (Exception e2222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
        }
        return bArr3;
    }

    public static byte[] encrypt4des(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length > 8) {
            bArr = FM_Bytes.copyOf(bArr, 8);
        }
        Key secretKeySpec = new SecretKeySpec(bArr, Util4Java.endsWith("FM]", 5, 6));
        byte[] bArr3 = null;
        try {
            Cipher instance = Cipher.getInstance(FM_Exception.insert(3, 46, "CP\u0010>Z\u000eYf\u0019j\u0003`k9bw "));
            instance.init(1, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (Exception e) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
        } catch (Exception e2222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
        }
        return bArr3;
    }

    public static byte[] encrypt4des3(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            f9853a.error(DES.class.getName(), FM_Int.replace(6, "客攮捯迟衋9IU@劶察旪３伢兠皌@KH戂耒徟劽宆盇收挧乶!'94"));
            return null;
        }
        if (bArr.length % 8 != 0) {
            f9853a.error(DES.class.getName(), Util4Java.endsWith("对敶换迉衔-@OC劶寚斴ｄ佮儱盞\u000b\u0003\u0015盖攨挰镻庬丝吞泉", 3, 6));
        }
        byte[] copyOf = FM_Bytes.copyOf(bArr, 8);
        return encrypt4des(copyOf, decrypt4des(FM_Bytes.copyOfRange(bArr, 8, bArr.length), encrypt4des(copyOf, bArr2)));
    }

    public static byte[] encrypt4des3CBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null) {
            f9853a.error(DES.class.getName(), FM_Utils.regionMatches(HttpStatus.SC_MOVED_TEMPORARILY, 110, "寧敼挴输蠚wVE]勼完斮ｊ伴內皔\u0015\t\u0003扞耓征劲密益攬挤丢han<"));
            return null;
        }
        if (bArr.length % 8 != 0) {
            f9853a.error(DES.class.getName(), FM_Long.copyValueOf("寳敷捪迚蠒h\u001c\u0010\u0001勯宊斿ｊ佣儥盙\u0011\u0012\r盕放挥锷廣乏吗泉", 2));
        }
        int length = bArr2.length / 8;
        byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{length, 8});
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr4[i][i2] = bArr2[(i << 3) + i2];
            }
        }
        byte[] bArr5 = new byte[8];
        byte[] encrypt4des3 = encrypt4des3(bArr, FM_Bytes.xor(bArr4[0], bArr3));
        byte[] bArr6 = encrypt4des3;
        bArr5 = encrypt4des3;
        int i3 = 1;
        while (i3 < length) {
            bArr6 = encrypt4des3(bArr, FM_Bytes.xor(bArr6, bArr4[i3]));
            i3++;
            bArr5 = FM_Bytes.join(bArr5, bArr6);
        }
        return bArr5;
    }

    public static byte[] encrypt4des3Padding(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            f9853a.error(DES.class.getName(), FM_Bytes.concat("宥支捬连衄8JTG劷寜旫，伣兣皍GJK戃耝從劾宇盀攷挤乷>&:5", 5, 3));
            return null;
        }
        if (bArr.length % 8 != 0) {
            f9853a.error(DES.class.getName(), FM_Bytes.concat("宥敢挦迅蠘9\u0004\u0013_勢寞斸（伺儵皂\u0017W\u0011盚敤挤长廰丁告沍", 5, 54));
        }
        byte[] copyOf = FM_Bytes.copyOf(bArr, 8);
        return encrypt4desPadding(copyOf, decrypt4desPadding(FM_Bytes.copyOfRange(bArr, 8, bArr.length), encrypt4desPadding(copyOf, bArr2)));
    }

    public static byte[] encrypt4desCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null && bArr.length > 8) {
            bArr = FM_Bytes.copyOf(bArr, 8);
        }
        String insert = FM_Exception.insert(172, 25, "T\f\u0011tWO\u0005p\u0016~Z\"81gi'");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        Key secretKeySpec = new SecretKeySpec(bArr, Util4Java.endsWith("E\u001e\u0006", 4, 122));
        byte[] bArr4 = null;
        try {
            Cipher instance = Cipher.getInstance(insert);
            instance.init(1, secretKeySpec, ivParameterSpec);
            bArr4 = instance.doFinal(bArr2);
        } catch (Exception e) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
        } catch (Exception e2222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
        } catch (Exception e22222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22222));
        }
        return bArr4;
    }

    public static byte[] encrypt4desPadding(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length > 8) {
            bArr = FM_Bytes.copyOf(bArr, 8);
        }
        Key secretKeySpec = new SecretKeySpec(bArr, FM_Bytes.concat("\t\u001cV", 214, 44));
        byte[] bArr3 = null;
        try {
            Cipher instance = Cipher.getInstance(BCCUtil.getChars("\u0011E\u0018yD\u000f\u0015-\u001d9g*0j(", 5, 43));
            instance.init(1, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (Exception e) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
        } catch (Exception e222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
        } catch (Exception e2222) {
            f9853a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
        }
        return bArr3;
    }

    public static byte[] javaDes3(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, Util4Java.endsWith("FYE5.a", 5, 26));
        byte[] bArr3 = null;
        try {
            Cipher instance = Cipher.getInstance(FM_CN.equals("\u001c\f\t.xh", 5));
            instance.init(1, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchPaddingException e2) {
            System.out.println(e2.getMessage());
        } catch (IllegalBlockSizeException e3) {
            System.out.println(e3.getMessage());
        } catch (BadPaddingException e4) {
            System.out.println(e4.getMessage());
        } catch (InvalidKeyException e5) {
            System.out.println(e5.getMessage());
        }
        return bArr3;
    }

    public static void main(String[] strArr) {
    }

    public static void showArray(byte[] bArr) {
        for (byte b : bArr) {
            System.out.print(b + "\t");
        }
        System.out.println();
    }
}
