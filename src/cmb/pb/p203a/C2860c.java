package cmb.pb.p203a;

import android.util.Log;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class C2860c {
    static byte[] f9239a = new byte[]{TagName.APP_TYPE, TagName.IMEI, (byte) 1, (byte) -46, (byte) -82, (byte) 78, (byte) -3, ScriptToolsConst.TagName.ScriptDown, (byte) 7, (byte) 10, ScriptToolsConst.TagName.TagApdu, (byte) -23, TagName.RENT_HANDLE_DATD, (byte) 75, (byte) -50, TagName.THIRD_PAY_NUMBER, TagName.USER_LOGIN_FAIL_COUNT, (byte) 9, (byte) -35, (byte) -43, TagName.URL_TYPE, (byte) 6, TagName.PAY_CHANNEL_MIN, TagName.BUSINESS_ORDER_LIST, (byte) -91, TagName.APK_DOWNLOAD_URL, TagName.ORDER_BRIEF_INFO_LIST, TagName.ORDER_BRIEF_INFO, TagName.PAY_ORDER_LIST, (byte) -2, (byte) 75, (byte) 14, TagName.PAY_ORDER_ID, TagName.MAIN_ORDER, TagName.MAIN_ORDER_LIST, (byte) 74, TagName.MAIN_ORDER_LIST, (byte) 1, (byte) -18, TagName.APP_TYPE, TagName.NOTICE_TITLE, TagName.PRODUCT_INFO, (byte) 74, (byte) 42, TagName.ACTIVITY_INFO, (byte) -2, (byte) -45, TagName.INVOICE_TOKEN_OBJECT, (byte) -87, TagName.ELECTRONIC_PRICE_FAVOURABLE, (byte) 42, TagName.UNSOLVED_NOTICES, TagName.PAY_ORDER, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.APK_SIZE, TagName.PAY_ORDER_ID, TagName.PAY_CHANNEL, TagName.PATCH_DATA, (byte) 14, TagName.ELECTRONIC_LIST, TagName.PRICE, (byte) 32, (byte) -27, TagName.CARD_APP_ACTIVATION_STATUS, (byte) -43, TagName.TERMINAL_OS_VERSION, TagName.PRODUCT_NAME, (byte) 77, TagName.NOTICE_START_TIME, TagName.OPERATION_STEP, (byte) -85, TagName.ORDER_TRADE_STATUSES, TagName.RENT_HANDLE_TYPE, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_MODEL_NUMBER, TagName.CARD_APP_BLANCE, (byte) -49, (byte) -53, TagName.BUSINESS_ORDER_TYPE, TagName.PAY_CHANNEL_NAME, (byte) -12, TagName.ACTIVITY_END, TagName.ACTIVITY_REMAINDER, TagName.USER_PLATFORM_ID, (byte) 9, TagName.PREDEPOSIT_LIST, TagName.CARD_APP_VERSION, (byte) 78, TagName.ELECTRONIC_ID, (byte) -52, TagName.TERMINAL_MODEL_NUMBER, TagName.BUSINESS_ORDER_OP_TYPE, ScriptToolsConst.TagName.ResponseSingle, TagName.ELECTRONIC_END_TIME, (byte) 7, TagName.TEXT_NOTICE, (byte) -18, (byte) -5, TagName.USER_PLATFORM_TYPE, TagName.ORDER_TERMINAL, TagName.PRODUCT_ID, TagName.CP_NO, TagName.URL_LIST, TagName.ORDER_TRADE_NO, TagName.ORDER_TYPE, ScriptToolsConst.TagName.ResponseSingle, (byte) -35, (byte) -38, (byte) 89, (byte) -37, (byte) 94, TagName.EUID, TagName.PREDEPOSIT_LIST, TagName.OPERATION_STEP, (byte) 35, (byte) -88, TagName.ELECTRONIC_PUBLISH_START_TIME, TagName.CITY_CODE, (byte) -33, TagName.ELECTRONIC_APP_TYPE, TagName.MAIN_ORDER, TagName.OPERATION_ID, (byte) -20, (byte) 16, (byte) 42, (byte) -38, TagName.ORDER_TERMINAL, (byte) -97};
    static String f9240b = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk+PFDSFypJvT2VZOvh7L3fUf52aAgtSjxZT4ifKEyj1PIDaj8FCC3880xD0chYEXg+CpkVnj9WYCfBDqeDpNYdRBSKIf2LP/26CObifDxd9VK+4VY/vsiW0qtqjuxVtLHficIjeB34FhdTve7mzXOaecepdwaRSMbzPsonIdeb3ysiSC20XYuzYmfolNVDQIgMVq8tRvacKhc65nLHRovBUTmeUa7tu+1rftsXW8/WbfsHp1YftnqFnb1V/MCtCUcmp3q3fYzxMjukS0lvIodw3zDyuC2vC9ne3ICAg60OHRbEWSKjxlvqrKNdnAYbaKgPbDwBLo2wBCC5qfFpMppQIDAQAB";
    static PublicKey f9241c = null;
    private static char[] f9242d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String m12954a(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 == null || str2.length() < 5) {
            String l = Long.toString(System.currentTimeMillis());
            str2 = l.substring(l.length() - 12);
        }
        byte[] bytes = ("AAA" + str2.substring(str2.length() - 5) + str).getBytes();
        if (bytes != null) {
            try {
                if (f9241c != null) {
                    Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    instance.init(1, f9241c);
                    bytes = instance.doFinal(bytes);
                    return C2858a.m12950b(bytes);
                }
            } catch (InvalidKeyException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeySpecException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            } catch (BadPaddingException e6) {
                e6.printStackTrace();
                return null;
            }
        }
        bytes = null;
        return C2858a.m12950b(bytes);
    }

    private static PublicKey m12955a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static void m12956a(String str) {
        Log.v("pbkey", str);
        Key a = C2860c.m12955a(C2858a.m12949a(f9240b));
        byte[] a2 = C2858a.m12949a(str);
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, a);
        f9241c = C2860c.m12955a(instance.doFinal(a2));
    }
}
