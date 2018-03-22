package com.huawei.p111o.p478b;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;

/* compiled from: Base64 */
public class C5699d extends C5698e {
    static final byte[] f19432a = new byte[]{TagName.PAY_CHANNEL, (byte) 10};
    private static final char[] f19433c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] f19434d = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.USER_LOCK_TIME, TagName.CARD_FORM};
    private static final byte[] f19435e = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.APK_UPDATE_FLAG, TagName.MOC};
    private static final byte[] f19436f = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, TagName.CARD_BUSINESS_ORDER_STATUS, (byte) -1, TagName.CARD_BUSINESS_ORDER_STATUS, (byte) -1, TagName.CARD_APP_ACTIVATION_STATUS, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.BUSINESS_ORDER_OP_TYPE, TagName.CARD_APP_RAMDOM, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.CARD_APP_VERSION, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, TagName.IDENTIFYING_TYPE, TagName.IDENTIFYING_CODE, TagName.PAY_CHANNEL, (byte) 14, (byte) 15, (byte) 16, (byte) 17, TagName.THIRD_PAY_NUMBER, TagName.ORDER_DATE, TagName.ORDER_TIME, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.ORDER_QUERY_PARAM, (byte) -1, (byte) -1, (byte) -1, (byte) -1, TagName.CARD_APP_ACTIVATION_STATUS, (byte) -1, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.APK_DOWNLOAD_URL, (byte) 29, TagName.ORDER_CHANNEL, TagName.TRADE_STATUS, (byte) 32, (byte) 33, (byte) 34, (byte) 35, TagName.USER_LOGIN_FAIL_COUNT, TagName.ORDER_RANGE_TYPE, TagName.QUERY_RECORD_COUNT, (byte) 39, TagName.CARD_APP_BLANCE, (byte) 41, (byte) 42, TagName.USER_LOCK_TIME, TagName.SYSTEM_NEW_VERSION, TagName.APK_UPDATE_FLAG, TagName.SIM_SEID, TagName.CARD_FORM, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST};
    private final byte[] f19437g;
    private final byte[] f19438h;
    private final byte[] f19439i;
    private final int f19440j;
    private final int f19441k;

    public C5699d() {
        this(0);
    }

    public C5699d(boolean z) {
        this(76, f19432a, z);
    }

    public C5699d(int i) {
        this(i, f19432a);
    }

    public C5699d(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public C5699d(int i, byte[] bArr, boolean z) {
        int i2;
        if (bArr == null) {
            i2 = 0;
        } else {
            i2 = bArr.length;
        }
        super(3, 4, i, i2);
        this.f19438h = f19436f;
        if (bArr == null) {
            this.f19441k = 4;
            this.f19439i = null;
        } else if (m26301e(bArr)) {
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + C5703i.m26313a(bArr) + "]");
        } else if (i > 0) {
            this.f19441k = bArr.length + 4;
            this.f19439i = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f19439i, 0, bArr.length);
        } else {
            this.f19441k = 4;
            this.f19439i = null;
        }
        this.f19440j = this.f19441k - 1;
        this.f19437g = z ? f19435e : f19434d;
    }

    void mo5085a(byte[] bArr, int i, int i2, C5700f c5700f) {
        if (!c5700f.f19446e) {
            int i3;
            int i4;
            if (i2 < 0) {
                c5700f.f19446e = true;
                if (c5700f.f19448g != 0 || this.b != 0) {
                    Object a = m26295a(this.f19441k, c5700f);
                    i3 = c5700f.f19444c;
                    switch (c5700f.f19448g) {
                        case 0:
                            break;
                        case 1:
                            i4 = c5700f.f19444c;
                            c5700f.f19444c = i4 + 1;
                            a[i4] = this.f19437g[(c5700f.f19442a >> 2) & 63];
                            i4 = c5700f.f19444c;
                            c5700f.f19444c = i4 + 1;
                            a[i4] = this.f19437g[(c5700f.f19442a << 4) & 63];
                            if (this.f19437g == f19434d) {
                                i4 = c5700f.f19444c;
                                c5700f.f19444c = i4 + 1;
                                a[i4] = 61;
                                i4 = c5700f.f19444c;
                                c5700f.f19444c = i4 + 1;
                                a[i4] = 61;
                                break;
                            }
                            break;
                        case 2:
                            i4 = c5700f.f19444c;
                            c5700f.f19444c = i4 + 1;
                            a[i4] = this.f19437g[(c5700f.f19442a >> 10) & 63];
                            i4 = c5700f.f19444c;
                            c5700f.f19444c = i4 + 1;
                            a[i4] = this.f19437g[(c5700f.f19442a >> 4) & 63];
                            i4 = c5700f.f19444c;
                            c5700f.f19444c = i4 + 1;
                            a[i4] = this.f19437g[(c5700f.f19442a << 2) & 63];
                            if (this.f19437g == f19434d) {
                                i4 = c5700f.f19444c;
                                c5700f.f19444c = i4 + 1;
                                a[i4] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + c5700f.f19448g);
                    }
                    c5700f.f19447f = (c5700f.f19444c - i3) + c5700f.f19447f;
                    if (this.b > 0 && c5700f.f19447f > 0) {
                        System.arraycopy(this.f19439i, 0, a, c5700f.f19444c, this.f19439i.length);
                        c5700f.f19444c += this.f19439i.length;
                        return;
                    }
                    return;
                }
                return;
            }
            i3 = 0;
            while (i3 < i2) {
                Object a2 = m26295a(this.f19441k, c5700f);
                c5700f.f19448g = (c5700f.f19448g + 1) % 3;
                i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                c5700f.f19442a = i5 + (c5700f.f19442a << 8);
                if (c5700f.f19448g == 0) {
                    i5 = c5700f.f19444c;
                    c5700f.f19444c = i5 + 1;
                    a2[i5] = this.f19437g[(c5700f.f19442a >> 18) & 63];
                    i5 = c5700f.f19444c;
                    c5700f.f19444c = i5 + 1;
                    a2[i5] = this.f19437g[(c5700f.f19442a >> 12) & 63];
                    i5 = c5700f.f19444c;
                    c5700f.f19444c = i5 + 1;
                    a2[i5] = this.f19437g[(c5700f.f19442a >> 6) & 63];
                    i5 = c5700f.f19444c;
                    c5700f.f19444c = i5 + 1;
                    a2[i5] = this.f19437g[c5700f.f19442a & 63];
                    c5700f.f19447f += 4;
                    if (this.b > 0 && this.b <= c5700f.f19447f) {
                        System.arraycopy(this.f19439i, 0, a2, c5700f.f19444c, this.f19439i.length);
                        c5700f.f19444c += this.f19439i.length;
                        c5700f.f19447f = 0;
                    }
                }
                i3++;
                i = i4;
            }
        }
    }

    void mo5087b(byte[] bArr, int i, int i2, C5700f c5700f) {
        if (!c5700f.f19446e) {
            int i3;
            if (i2 < 0) {
                c5700f.f19446e = true;
            }
            int i4 = 0;
            while (i4 < i2) {
                byte[] a = m26295a(this.f19440j, c5700f);
                i3 = i + 1;
                byte b = bArr[i];
                if (b == TagName.CARD_APP_VERSION) {
                    c5700f.f19446e = true;
                    break;
                }
                if (b >= (byte) 0 && b < f19436f.length) {
                    b = f19436f[b];
                    if (b >= (byte) 0) {
                        c5700f.f19448g = (c5700f.f19448g + 1) % 4;
                        c5700f.f19442a = b + (c5700f.f19442a << 6);
                        if (c5700f.f19448g == 0) {
                            int i5 = c5700f.f19444c;
                            c5700f.f19444c = i5 + 1;
                            a[i5] = (byte) ((c5700f.f19442a >> 16) & 255);
                            i5 = c5700f.f19444c;
                            c5700f.f19444c = i5 + 1;
                            a[i5] = (byte) ((c5700f.f19442a >> 8) & 255);
                            i5 = c5700f.f19444c;
                            c5700f.f19444c = i5 + 1;
                            a[i5] = (byte) (c5700f.f19442a & 255);
                        }
                    }
                }
                i4++;
                i = i3;
            }
            if (c5700f.f19446e && c5700f.f19448g != 0) {
                byte[] a2 = m26295a(this.f19440j, c5700f);
                switch (c5700f.f19448g) {
                    case 1:
                        return;
                    case 2:
                        c5700f.f19442a >>= 4;
                        i3 = c5700f.f19444c;
                        c5700f.f19444c = i3 + 1;
                        a2[i3] = (byte) (c5700f.f19442a & 255);
                        return;
                    case 3:
                        c5700f.f19442a >>= 2;
                        i3 = c5700f.f19444c;
                        c5700f.f19444c = i3 + 1;
                        a2[i3] = (byte) ((c5700f.f19442a >> 8) & 255);
                        i3 = c5700f.f19444c;
                        c5700f.f19444c = i3 + 1;
                        a2[i3] = (byte) (c5700f.f19442a & 255);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + c5700f.f19448g);
                }
            }
        }
    }

    public static byte[] m26304a(byte[] bArr) {
        return C5699d.m26305a(bArr, false);
    }

    public static String m26308b(byte[] bArr) {
        return C5703i.m26313a(C5699d.m26305a(bArr, false));
    }

    public static byte[] m26305a(byte[] bArr, boolean z) {
        return C5699d.m26306a(bArr, z, false);
    }

    public static byte[] m26306a(byte[] bArr, boolean z, boolean z2) {
        return C5699d.m26307a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] m26307a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C5699d c5699d = z ? new C5699d(z2) : new C5699d(0, f19432a, z2);
        long f = c5699d.m26302f(bArr);
        if (f <= ((long) i)) {
            return c5699d.m26300d(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + f + ") than the specified maximum size of " + i);
    }

    public static byte[] m26303a(String str) {
        return new C5699d().m26297b(str);
    }

    protected boolean mo5086a(byte b) {
        return b >= (byte) 0 && b < this.f19438h.length && this.f19438h[b] != (byte) -1;
    }
}
