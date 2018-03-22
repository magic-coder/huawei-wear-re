package com.amap.api.location.core;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;

/* compiled from: Base64Util */
public class C3190b {
    private static final char[] f10683a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] f10684b = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, TagName.CARD_BUSINESS_ORDER_STATUS, (byte) -1, (byte) -1, (byte) -1, TagName.CARD_APP_ACTIVATION_STATUS, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.BUSINESS_ORDER_OP_TYPE, TagName.CARD_APP_RAMDOM, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.CARD_APP_VERSION, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, TagName.IDENTIFYING_TYPE, TagName.IDENTIFYING_CODE, TagName.PAY_CHANNEL, (byte) 14, (byte) 15, (byte) 16, (byte) 17, TagName.THIRD_PAY_NUMBER, TagName.ORDER_DATE, TagName.ORDER_TIME, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_QUERY_PARAM, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.APK_DOWNLOAD_URL, (byte) 29, TagName.ORDER_CHANNEL, TagName.TRADE_STATUS, (byte) 32, (byte) 33, (byte) 34, (byte) 35, TagName.USER_LOGIN_FAIL_COUNT, TagName.ORDER_RANGE_TYPE, TagName.QUERY_RECORD_COUNT, (byte) 39, TagName.CARD_APP_BLANCE, (byte) 41, (byte) 42, TagName.USER_LOCK_TIME, TagName.SYSTEM_NEW_VERSION, TagName.APK_UPDATE_FLAG, TagName.SIM_SEID, TagName.CARD_FORM, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};

    private C3190b() {
    }

    public static String m14117a(byte[] bArr) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                int i3 = bArr[i] & 255;
                if (i2 == length) {
                    stringBuffer.append(f10683a[i3 >>> 2]);
                    stringBuffer.append(f10683a[(i3 & 3) << 4]);
                    stringBuffer.append("==");
                    break;
                }
                int i4 = i2 + 1;
                i2 = bArr[i2] & 255;
                if (i4 == length) {
                    stringBuffer.append(f10683a[i3 >>> 2]);
                    stringBuffer.append(f10683a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                    stringBuffer.append(f10683a[(i2 & 15) << 2]);
                    stringBuffer.append("=");
                    break;
                }
                i = i4 + 1;
                i4 = bArr[i4] & 255;
                stringBuffer.append(f10683a[i3 >>> 2]);
                stringBuffer.append(f10683a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(f10683a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
                stringBuffer.append(f10683a[i4 & 63]);
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static byte[] m14118a(String str) {
        try {
            byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
            int i = 0;
            while (i < length) {
                byte b;
                int i2;
                do {
                    i2 = i;
                    i = i2 + 1;
                    b = f10684b[bytes[i2]];
                    if (i >= length) {
                        break;
                    }
                } while (b == (byte) -1);
                if (b != (byte) -1) {
                    byte b2;
                    do {
                        i2 = i;
                        i = i2 + 1;
                        b2 = f10684b[bytes[i2]];
                        if (i >= length) {
                            break;
                        }
                    } while (b2 == (byte) -1);
                    if (b2 == (byte) -1) {
                        break;
                    }
                    byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                    do {
                        i2 = i;
                        i = i2 + 1;
                        byte b3 = bytes[i2];
                        if (b3 != TagName.CARD_APP_VERSION) {
                            b = f10684b[b3];
                            if (i >= length) {
                                break;
                            }
                        } else {
                            return byteArrayOutputStream.toByteArray();
                        }
                    } while (b == (byte) -1);
                    if (b == (byte) -1) {
                        break;
                    }
                    byte b4;
                    byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                    while (true) {
                        i2 = i + 1;
                        b4 = bytes[i];
                        if (b4 == TagName.CARD_APP_VERSION) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        b4 = f10684b[b4];
                        if (i2 >= length || b4 != (byte) -1) {
                            if (b4 != (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                            i = i2;
                        } else {
                            i = i2;
                        }
                    }
                    if (b4 != (byte) -1) {
                        break;
                    }
                    byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                    i = i2;
                } else {
                    break;
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
