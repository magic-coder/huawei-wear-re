package com.huawei.pluginkidwatch.common.lib.utils;

import android.content.Context;
import com.huawei.common.Constant;
import com.huawei.common.util.EncryptUtil;
import com.huawei.hwdatamigrate.common.a.a;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: EncryptUtil */
public class C1487g {
    public static String m6873a(Context context, String str) {
        return C1487g.m6874a(context, str, 0);
    }

    private static String m6874a(Context context, String str, int i) {
        if (context == null || str == null) {
            return null;
        }
        try {
            if (str.length() < 32) {
                return null;
            }
            byte[] b;
            String substring = str.substring(0, 32);
            if (1 == i) {
                b = C1487g.m6879b(context);
            } else {
                b = C1487g.m6876a(context);
            }
            return C1481a.m6814c(str.substring(32), b, C1487g.m6877a(substring));
        } catch (Exception e) {
            C2538c.m12680e(EncryptUtil.TAG, "decrypt--Exception:", e.getMessage());
            return null;
        }
    }

    private static byte[] m6876a(Context context) {
        return a.a(String.valueOf(C1487g.m6874a(context, C1487g.m6878b(context, "yTelk"), 1)));
    }

    private static byte[] m6879b(Context context) {
        int i = 0;
        char[] toCharArray = com.huawei.whitebox.a.a().b().toCharArray();
        char[] toCharArray2 = Constant.ADL2.toCharArray();
        String b = C1487g.m6878b(context, "d58C0");
        if (b == null || b.isEmpty()) {
            return new byte[]{(byte) 0};
        }
        char[] toCharArray3 = b.toCharArray();
        char[] cArr = new char[toCharArray.length];
        while (i < toCharArray.length) {
            cArr[i] = (char) ((((toCharArray3[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray[i]) >> 4);
            i++;
        }
        return a.a(String.valueOf(cArr));
    }

    private static String m6878b(Context context, String str) {
        InputStream open;
        IOException e;
        Throwable th;
        String str2 = null;
        try {
            open = context.getAssets().open(str);
            if (open != null) {
                try {
                    str2 = C1487g.m6875a(open);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C2538c.m12680e(EncryptUtil.TAG, "getSecretKeyS(1)", e.getMessage());
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e3) {
                                C2538c.m12680e(EncryptUtil.TAG, "getSecretKeyS(2)", e3.getMessage());
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e32) {
                                C2538c.m12680e(EncryptUtil.TAG, "getSecretKeyS(2)", e32.getMessage());
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
                    C2538c.m12680e(EncryptUtil.TAG, "getSecretKeyS(2)", e322.getMessage());
                }
            }
        } catch (IOException e4) {
            e322 = e4;
            open = str2;
            C2538c.m12680e(EncryptUtil.TAG, "getSecretKeyS(1)", e322.getMessage());
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

    public static String m6875a(InputStream inputStream) throws IOException {
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

    private static byte[] m6877a(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }
}
