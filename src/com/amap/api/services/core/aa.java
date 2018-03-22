package com.amap.api.services.core;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt */
public class aa {
    private static final char[] f12306a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] f12307b = new byte[128];

    static {
        int i;
        for (i = 0; i < 128; i++) {
            f12307b[i] = (byte) -1;
        }
        for (i = 65; i <= 90; i++) {
            f12307b[i] = (byte) (i - 65);
        }
        for (i = 97; i <= 122; i++) {
            f12307b[i] = (byte) ((i - 97) + 26);
        }
        for (i = 48; i <= 57; i++) {
            f12307b[i] = (byte) ((i - 48) + 52);
        }
        f12307b[43] = TagName.CARD_BUSINESS_ORDER_STATUS;
        f12307b[47] = TagName.CARD_APP_ACTIVATION_STATUS;
    }

    static byte[] m16585a(byte[] bArr, byte[] bArr2) {
        try {
            return m16588b(bArr, bArr2);
        } catch (Throwable e) {
            ay.m16709a(e, "Encrypt", "aesEncrypt");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            ay.m16709a(e2, "Encrypt", "aesEncrypt");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            ay.m16709a(e22, "Encrypt", "aesEncrypt");
            e22.printStackTrace();
            return null;
        } catch (Throwable e222) {
            ay.m16709a(e222, "Encrypt", "aesEncrypt");
            e222.printStackTrace();
            return null;
        } catch (Throwable e2222) {
            ay.m16709a(e2222, "Encrypt", "aesEncrypt");
            e2222.printStackTrace();
            return null;
        } catch (Throwable e22222) {
            ay.m16709a(e22222, "Encrypt", "aesEncrypt");
            e22222.printStackTrace();
            return null;
        }
    }

    private static byte[] m16588b(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    static byte[] m16584a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    public static String m16582a(String str) {
        return new String(m16587b(str));
    }

    public static byte[] m16587b(String str) {
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i < length) {
            byte b;
            while (true) {
                int i2 = i + 1;
                byte b2 = f12307b[bytes[i]];
                byte b3;
                byte b4;
                if (i2 >= length || b2 != (byte) -1) {
                    if (b2 != (byte) -1) {
                        while (true) {
                            i = i2 + 1;
                            b = f12307b[bytes[i2]];
                            if (i >= length || b != (byte) -1) {
                                if (b == (byte) -1) {
                                    break;
                                }
                                byteArrayOutputStream.write((b2 << 2) | ((b & 48) >>> 4));
                                while (true) {
                                    i2 = i + 1;
                                    b3 = bytes[i];
                                    if (b3 != TagName.CARD_APP_VERSION) {
                                        return byteArrayOutputStream.toByteArray();
                                    }
                                    b2 = f12307b[b3];
                                    if (i2 >= length || b2 != (byte) -1) {
                                        if (b2 == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(((b & 15) << 4) | ((b2 & 60) >>> 2));
                                        while (true) {
                                            i = i2 + 1;
                                            b4 = bytes[i2];
                                            if (b4 == TagName.CARD_APP_VERSION) {
                                                return byteArrayOutputStream.toByteArray();
                                            }
                                            b4 = f12307b[b4];
                                            if (i >= length || b4 != (byte) -1) {
                                                if (b4 == (byte) -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(b4 | ((b2 & 3) << 6));
                                            } else {
                                                i2 = i;
                                            }
                                        }
                                        if (b4 == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(b4 | ((b2 & 3) << 6));
                                    } else {
                                        i = i2;
                                    }
                                }
                                if (b2 == (byte) -1) {
                                    byteArrayOutputStream.write(((b & 15) << 4) | ((b2 & 60) >>> 2));
                                    while (true) {
                                        i = i2 + 1;
                                        b4 = bytes[i2];
                                        if (b4 == TagName.CARD_APP_VERSION) {
                                            b4 = f12307b[b4];
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
                                    byteArrayOutputStream.write(b4 | ((b2 & 3) << 6));
                                } else {
                                    break;
                                }
                            }
                            i2 = i;
                        }
                        if (b == (byte) -1) {
                            byteArrayOutputStream.write((b2 << 2) | ((b & 48) >>> 4));
                            while (true) {
                                i2 = i + 1;
                                b3 = bytes[i];
                                if (b3 != TagName.CARD_APP_VERSION) {
                                    b2 = f12307b[b3];
                                    if (i2 >= length) {
                                        break;
                                    }
                                    break;
                                }
                                return byteArrayOutputStream.toByteArray();
                                i = i2;
                            }
                            if (b2 == (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(((b & 15) << 4) | ((b2 & 60) >>> 2));
                            while (true) {
                                i = i2 + 1;
                                b4 = bytes[i2];
                                if (b4 == TagName.CARD_APP_VERSION) {
                                    b4 = f12307b[b4];
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
                            byteArrayOutputStream.write(b4 | ((b2 & 3) << 6));
                        } else {
                            break;
                        }
                    }
                    break;
                }
                i = i2;
            }
            if (b2 != (byte) -1) {
                break;
            }
            while (true) {
                i = i2 + 1;
                b = f12307b[bytes[i2]];
                if (i >= length) {
                    break;
                }
                break;
                i2 = i;
            }
            if (b == (byte) -1) {
                break;
            }
            byteArrayOutputStream.write((b2 << 2) | ((b & 48) >>> 4));
            while (true) {
                i2 = i + 1;
                b3 = bytes[i];
                if (b3 != TagName.CARD_APP_VERSION) {
                    b2 = f12307b[b3];
                    if (i2 >= length) {
                        break;
                    }
                    break;
                }
                return byteArrayOutputStream.toByteArray();
                i = i2;
            }
            if (b2 == (byte) -1) {
                byteArrayOutputStream.write(((b & 15) << 4) | ((b2 & 60) >>> 2));
                while (true) {
                    i = i2 + 1;
                    b4 = bytes[i2];
                    if (b4 == TagName.CARD_APP_VERSION) {
                        b4 = f12307b[b4];
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
                byteArrayOutputStream.write(b4 | ((b2 & 3) << 6));
            } else {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static String m16589c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(f12306a[i3 >>> 2]);
                stringBuffer.append(f12306a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i4 == length) {
                stringBuffer.append(f12306a[i3 >>> 2]);
                stringBuffer.append(f12306a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(f12306a[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            i4 = bArr[i4] & 255;
            stringBuffer.append(f12306a[i3 >>> 2]);
            stringBuffer.append(f12306a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
            stringBuffer.append(f12306a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
            stringBuffer.append(f12306a[i4 & 63]);
        }
        return stringBuffer.toString();
    }

    public static String m16583a(byte[] bArr) {
        try {
            return m16589c(bArr);
        } catch (Throwable th) {
            ay.m16709a(th, "Encrypt", "encodeBase64");
            th.printStackTrace();
            return null;
        }
    }

    public static String m16586b(byte[] bArr) {
        try {
            return m16589c(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
