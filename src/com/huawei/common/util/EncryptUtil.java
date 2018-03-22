package com.huawei.common.util;

import android.content.Context;
import android.util.Base64;
import com.huawei.common.Constant;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p111o.p478b.C5697c;
import com.huawei.p111o.p478b.C5699d;
import com.huawei.p190v.C2538c;
import com.huawei.whitebox.C6169a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {
    public static final String APP_ID = "3FFB01049E186846987AA51BC2107A52agM7UqaHcC64bjOiA68VDQH98aar+juSZvi6WYpb7is=";
    public static final String APP_SECRET = "CAC488A4BEFC11D873F6F6746B2B30CD/aXaw8c1YOvL9DTeOV67VTI63JIGkWj5Wvdqhv17Fbvsm5ZmI36OrTSwZR9CZb93";
    public static final String APP_ST_ENCR = "CAC488A4BEFC11D873F6F6746B2B3";
    private static final String EncrAPPID = "3FFB01049E186846987AA51BC2107A52agM";
    private static final String EncrCLIENTID = "E832F364390B078130AB43F693D2F169";
    private static final String EncrHEALTHCLIENTID = "722B230C97F19EB16A0EB7C";
    private static final String EncrHEALTHCLIENTIDTEST = "B39D9700F03C5B22CC7E3";
    public static final String HEALTH_APP_ID = "10131836";
    public static final String HEALTH_CLIENT_CLIENT_ID = "722B230C97F19EB16A0EB7CECD4B0852lX30N6yMgMtFmSWp60ACozxz3T9gmks0geHsq9qQGxs=";
    public static final String HEALTH_CLIENT_CLIENT_ID_TEST = "B39D9700F03C5B22CC7E38F6E09487C4KwEVRFTFcTFEsRB/ewYedEZ+K9CdUG09qpyRSf1ayTM=";
    public static final String HEALTH_CLIENT_ID = "10217331";
    public static final int IV_LENGTH = 32;
    public static final String TAG = "EncryptUtil";
    public static final int TYPE_REALKEY = 0;
    private static final int TYPE_ROOTKEY = 1;
    public static final String WEAR_CLIENT_CLIENT_ID_TEST = "E832F364390B078130AB43F693D2F169CelB0CKBY+GkPGRJA6jtPdKcDJ0Hvb64BEWAWxLB/uM=";

    public static String encrypt(Context context, String str) {
        return encryptin(context, str, 0);
    }

    public static String decrypt(Context context, String str) {
        return decryptin(context, str, 0);
    }

    private static String encryptin(Context context, String str, int i) {
        if (context == null || str == null) {
            return null;
        }
        try {
            byte[] rootKey;
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            if (1 == i) {
                rootKey = getRootKey(context);
            } else {
                rootKey = getRealKey(context);
            }
            return C0973a.a(bArr) + C5697c.m26287a(str, rootKey, bArr);
        } catch (Exception e) {
            C2538c.e(TAG, new Object[]{"encrypt--Exception:" + e.getMessage()});
            return null;
        }
    }

    private static String decryptin(Context context, String str, int i) {
        if (context == null || str == null) {
            return null;
        }
        try {
            if (str.length() < 32) {
                return null;
            }
            byte[] rootKey;
            String substring = str.substring(0, 32);
            if (1 == i) {
                rootKey = getRootKey(context);
            } else {
                rootKey = getRealKey(context);
            }
            return C5697c.m26289c(str.substring(32), rootKey, C0973a.g(substring));
        } catch (Exception e) {
            C2538c.e(TAG, new Object[]{"decrypt--Exception:" + e.getMessage()});
            return null;
        }
    }

    private static byte[] getRealKey(Context context) {
        return C5699d.m26303a(String.valueOf(decryptin(context, getSecretKeyS(context, "yTelk"), 1)));
    }

    private static byte[] getRootKey(Context context) {
        int i = 0;
        char[] toCharArray = C6169a.m28546a().m28549b().toCharArray();
        char[] toCharArray2 = Constant.ADL2.toCharArray();
        String secretKeyS = getSecretKeyS(context, "d58C0");
        if (secretKeyS == null || secretKeyS.isEmpty()) {
            return new byte[]{(byte) 0};
        }
        char[] toCharArray3 = secretKeyS.toCharArray();
        char[] cArr = new char[toCharArray.length];
        while (i < toCharArray.length) {
            cArr[i] = (char) ((((toCharArray3[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray[i]) >> 4);
            i++;
        }
        return C5699d.m26303a(String.valueOf(cArr));
    }

    private static String getSecretKeyS(Context context, String str) {
        InputStream open;
        IOException e;
        Throwable th;
        String str2 = null;
        try {
            open = context.getAssets().open(str);
            if (open != null) {
                try {
                    str2 = inputStream(open);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C2538c.e(TAG, new Object[]{"getSecretKeyS(1):" + e.getMessage()});
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e3) {
                                C2538c.e(TAG, new Object[]{"getSecretKeyS(2):" + e3.getMessage()});
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e32) {
                                C2538c.e(TAG, new Object[]{"getSecretKeyS(2):" + e32.getMessage()});
                            }
                        }
                        throw th;
                    }
                }
            }
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e322) {
                    C2538c.e(TAG, new Object[]{"getSecretKeyS(2):" + e322.getMessage()});
                }
            }
        } catch (IOException e4) {
            e322 = e4;
            open = str2;
            C2538c.e(TAG, new Object[]{"getSecretKeyS(1):" + e322.getMessage()});
            if (open != null) {
                open.close();
            }
            return str2;
        } catch (Throwable th3) {
            open = str2;
            th = th3;
            if (open != null) {
                open.close();
            }
            throw th;
        }
        return str2;
    }

    public static String inputStream(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return stringBuffer.toString();
            }
            stringBuffer.append(new String(bArr, 0, read, GameManager.DEFAULT_CHARSET));
        }
    }

    public static String hmacsha256(String str, String str2) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        if (str2 == null || str == null) {
            return "";
        }
        byte[] bytes = str2.getBytes(GameManager.DEFAULT_CHARSET);
        byte[] bytes2 = str.getBytes(GameManager.DEFAULT_CHARSET);
        Key secretKeySpec = new SecretKeySpec(bytes, "HMACSHA256");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKeySpec);
        return Base64.encodeToString(instance.doFinal(bytes2), 2);
    }
}
