package com.amap.api.mapcore.util;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
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

/* compiled from: Encrypt */
public class br {
    private static final char[] f11539a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] f11540b = new byte[128];

    public static String m15747a(String str) {
        try {
            return new String(m15752b(str), GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return new String(m15752b(str));
        }
    }

    public static String m15748a(byte[] bArr) {
        try {
            return m15754c(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static {
        int i;
        for (i = 0; i < 128; i++) {
            f11540b[i] = (byte) -1;
        }
        for (i = 65; i <= 90; i++) {
            f11540b[i] = (byte) (i - 65);
        }
        for (i = 97; i <= 122; i++) {
            f11540b[i] = (byte) ((i - 97) + 26);
        }
        for (i = 48; i <= 57; i++) {
            f11540b[i] = (byte) ((i - 48) + 52);
        }
        f11540b[43] = TagName.CARD_BUSINESS_ORDER_STATUS;
        f11540b[47] = TagName.CARD_APP_ACTIVATION_STATUS;
    }

    static byte[] m15750a(byte[] bArr, byte[] bArr2) {
        try {
            return m15753b(bArr, bArr2);
        } catch (Throwable e) {
            cd.m15825a(e, "Encrypt", "aesEncrypt");
            return null;
        } catch (Throwable e2) {
            cd.m15825a(e2, "Encrypt", "aesEncrypt");
            return null;
        } catch (Throwable e22) {
            cd.m15825a(e22, "Encrypt", "aesEncrypt");
            return null;
        } catch (Throwable e222) {
            cd.m15825a(e222, "Encrypt", "aesEncrypt");
            return null;
        } catch (Throwable e2222) {
            cd.m15825a(e2222, "Encrypt", "aesEncrypt");
            return null;
        } catch (Throwable e22222) {
            cd.m15825a(e22222, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    private static byte[] m15753b(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bw.m15803a());
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return instance.doFinal(bArr2);
    }

    static byte[] m15749a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    public static byte[] m15752b(String str) {
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bytes;
        try {
            bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                byte b = f11540b[bytes[i]];
                byte b2;
                byte b3;
                byte b4;
                if (i2 >= length || b != (byte) -1) {
                    if (b != (byte) -1) {
                        while (true) {
                            i = i2 + 1;
                            b2 = f11540b[bytes[i2]];
                            if (i >= length || b2 != (byte) -1) {
                                if (b2 == (byte) -1) {
                                    break;
                                }
                                byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                                while (true) {
                                    i2 = i + 1;
                                    b3 = bytes[i];
                                    if (b3 != TagName.CARD_APP_VERSION) {
                                        return byteArrayOutputStream.toByteArray();
                                    }
                                    b = f11540b[b3];
                                    if (i2 >= length || b != (byte) -1) {
                                        if (b == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                                        while (true) {
                                            i = i2 + 1;
                                            b4 = bytes[i2];
                                            if (b4 == TagName.CARD_APP_VERSION) {
                                                return byteArrayOutputStream.toByteArray();
                                            }
                                            b4 = f11540b[b4];
                                            if (i >= length || b4 != (byte) -1) {
                                                if (b4 == (byte) -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                            } else {
                                                i2 = i;
                                            }
                                        }
                                        if (b4 == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                    } else {
                                        i = i2;
                                    }
                                }
                                if (b == (byte) -1) {
                                    byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                                    while (true) {
                                        i = i2 + 1;
                                        b4 = bytes[i2];
                                        if (b4 == TagName.CARD_APP_VERSION) {
                                            b4 = f11540b[b4];
                                            if (i >= length) {
                                                break;
                                            }
                                            break;
                                        }
                                        return byteArrayOutputStream.toByteArray();
                                        i2 = i;
                                    }
                                    if (b4 == (byte) -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                } else {
                                    break;
                                }
                            }
                            i2 = i;
                        }
                        if (b2 == (byte) -1) {
                            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                            while (true) {
                                i2 = i + 1;
                                b3 = bytes[i];
                                if (b3 != TagName.CARD_APP_VERSION) {
                                    b = f11540b[b3];
                                    if (i2 >= length) {
                                        break;
                                    }
                                    break;
                                }
                                return byteArrayOutputStream.toByteArray();
                                i = i2;
                            }
                            if (b == (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                            while (true) {
                                i = i2 + 1;
                                b4 = bytes[i2];
                                if (b4 == TagName.CARD_APP_VERSION) {
                                    b4 = f11540b[b4];
                                    if (i >= length) {
                                        break;
                                    }
                                    break;
                                }
                                return byteArrayOutputStream.toByteArray();
                                i2 = i;
                            }
                            if (b4 == (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                        } else {
                            break;
                        }
                    }
                    break;
                }
                i = i2;
            }
            if (b != (byte) -1) {
                break;
            }
            while (true) {
                i = i2 + 1;
                b2 = f11540b[bytes[i2]];
                if (i >= length) {
                    break;
                }
                break;
                i2 = i;
            }
            if (b2 == (byte) -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
            while (true) {
                i2 = i + 1;
                b3 = bytes[i];
                if (b3 != TagName.CARD_APP_VERSION) {
                    b = f11540b[b3];
                    if (i2 >= length) {
                        break;
                    }
                    break;
                }
                return byteArrayOutputStream.toByteArray();
                i = i2;
            }
            if (b == (byte) -1) {
                byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                while (true) {
                    i = i2 + 1;
                    b4 = bytes[i2];
                    if (b4 == TagName.CARD_APP_VERSION) {
                        b4 = f11540b[b4];
                        if (i >= length) {
                            break;
                        }
                        break;
                    }
                    return byteArrayOutputStream.toByteArray();
                    i2 = i;
                }
                if (b4 == (byte) -1) {
                    break;
                }
                byteArrayOutputStream.write(b4 | ((b & 3) << 6));
            } else {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static String m15754c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(f11539a[i3 >>> 2]);
                stringBuffer.append(f11539a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i4 == length) {
                stringBuffer.append(f11539a[i3 >>> 2]);
                stringBuffer.append(f11539a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(f11539a[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            i4 = bArr[i4] & 255;
            stringBuffer.append(f11539a[i3 >>> 2]);
            stringBuffer.append(f11539a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
            stringBuffer.append(f11539a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
            stringBuffer.append(f11539a[i4 & 63]);
        }
        return stringBuffer.toString();
    }

    public static String m15751b(byte[] bArr) {
        try {
            return m15754c(bArr);
        } catch (Throwable th) {
            cd.m15825a(th, "Encrypt", "encodeBase64");
            return null;
        }
    }
}
