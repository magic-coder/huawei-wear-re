package cn.com.fmsh.util.algorithm;

import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static /* synthetic */ FMLog f9852a = LogFactory.getInstance().getLog();

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null && bArr.length >= 1 && bArr2 != null && bArr2.length >= 1) {
            try {
                KeyGenerator instance = KeyGenerator.getInstance(FM_CN.equals("\u0019\f\t", 5));
                instance.init(128, new SecureRandom(bArr2));
                Key secretKeySpec = new SecretKeySpec(instance.generateKey().getEncoded(), FM_Bytes.concat("\u001aKR", 4, 19));
                Cipher instance2 = Cipher.getInstance(FM_Long.copyValueOf("KBW", 2));
                instance2.init(2, secretKeySpec);
                bArr3 = instance2.doFinal(bArr);
            } catch (Exception e) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
                }
            } catch (Exception e2) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
                }
            } catch (Exception e22) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
                }
            } catch (Exception e222) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
                }
            } catch (Exception e2222) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
                }
            }
        }
        return bArr3;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null && bArr.length >= 1 && bArr2 != null && bArr2.length >= 1) {
            try {
                KeyGenerator instance = KeyGenerator.getInstance(FM_Utils.regionMatches(188, 125, "MLU"));
                instance.init(128, new SecureRandom(bArr2));
                Key secretKeySpec = new SecretKeySpec(instance.generateKey().getEncoded(), FM_Long.copyValueOf("\u0019\u0010\u0001", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED));
                Cipher instance2 = Cipher.getInstance(Util4Java.endsWith("@D\u0012", 4, 32));
                instance2.init(1, secretKeySpec);
                bArr3 = instance2.doFinal(bArr);
            } catch (Exception e) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
                }
            } catch (Exception e2) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2));
                }
            } catch (Exception e22) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e22));
                }
            } catch (Exception e222) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e222));
                }
            } catch (Exception e2222) {
                if (f9852a != null) {
                    f9852a.error(DES.class.getName(), Util4Java.getExceptionInfo(e2222));
                }
            }
        }
        return bArr3;
    }

    public static void main(String[] strArr) {
        byte[] bytes = FM_Long.copyValueOf("<3541hime0{/yqtj?4dc+/+ t&z/w!t", 5).getBytes();
        byte[] encrypt = encrypt(FM_Utils.regionMatches(88, 93, "<le:n").getBytes(), bytes);
        System.out.println(FM_Bytes.bytesToHexString(encrypt));
        System.out.println(new StringBuilder(BCCUtil.getChars("#b.f%+/", 1, 54)).append(new String(decrypt(encrypt, bytes))).toString());
    }
}
