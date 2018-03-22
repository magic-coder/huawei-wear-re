package org.p198a.p199a.p200a.p201a;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;

/* compiled from: Base64 */
public class C2765a extends C2764b {
    static final byte[] f9173a = new byte[]{TagName.PAY_CHANNEL, (byte) 10};
    private static final byte[] f9174i = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.USER_LOCK_TIME, TagName.CARD_FORM};
    private static final byte[] f9175j = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.APK_UPDATE_FLAG, TagName.MOC};
    private static final byte[] f9176k;
    private final byte[] f9177l;
    private final byte[] f9178m;
    private final byte[] f9179n;
    private final int f9180o;
    private final int f9181p;
    private int f9182q;

    static {
        byte[] bArr = new byte[ReportInfoUtils.FEEDBACK_SUCCESS];
        bArr[0] = (byte) -1;
        bArr[1] = (byte) -1;
        bArr[2] = (byte) -1;
        bArr[3] = (byte) -1;
        bArr[4] = (byte) -1;
        bArr[5] = (byte) -1;
        bArr[6] = (byte) -1;
        bArr[7] = (byte) -1;
        bArr[8] = (byte) -1;
        bArr[9] = (byte) -1;
        bArr[10] = (byte) -1;
        bArr[11] = (byte) -1;
        bArr[12] = (byte) -1;
        bArr[13] = (byte) -1;
        bArr[14] = (byte) -1;
        bArr[15] = (byte) -1;
        bArr[16] = (byte) -1;
        bArr[17] = (byte) -1;
        bArr[18] = (byte) -1;
        bArr[19] = (byte) -1;
        bArr[20] = (byte) -1;
        bArr[21] = (byte) -1;
        bArr[22] = (byte) -1;
        bArr[23] = (byte) -1;
        bArr[24] = (byte) -1;
        bArr[25] = (byte) -1;
        bArr[26] = (byte) -1;
        bArr[27] = (byte) -1;
        bArr[28] = (byte) -1;
        bArr[29] = (byte) -1;
        bArr[30] = (byte) -1;
        bArr[31] = (byte) -1;
        bArr[32] = (byte) -1;
        bArr[33] = (byte) -1;
        bArr[34] = (byte) -1;
        bArr[35] = (byte) -1;
        bArr[36] = (byte) -1;
        bArr[37] = (byte) -1;
        bArr[38] = (byte) -1;
        bArr[39] = (byte) -1;
        bArr[40] = (byte) -1;
        bArr[41] = (byte) -1;
        bArr[42] = (byte) -1;
        bArr[43] = TagName.CARD_BUSINESS_ORDER_STATUS;
        bArr[44] = (byte) -1;
        bArr[45] = TagName.CARD_BUSINESS_ORDER_STATUS;
        bArr[46] = (byte) -1;
        bArr[47] = TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[48] = TagName.NOTICE_BODY;
        bArr[49] = (byte) 53;
        bArr[50] = TagName.NOTICE_START_TIME;
        bArr[51] = TagName.NOTICE_END_TIME;
        bArr[52] = ScriptToolsConst.TagName.TagSerial;
        bArr[53] = ScriptToolsConst.TagName.TagApdu;
        bArr[54] = TagName.BUSINESS_ORDER_OP_TYPE;
        bArr[55] = TagName.CARD_APP_RAMDOM;
        bArr[56] = ScriptToolsConst.TagName.TagExpectationAndNext;
        bArr[57] = TagName.CARD_APP_VERSION;
        bArr[58] = (byte) -1;
        bArr[59] = (byte) -1;
        bArr[60] = (byte) -1;
        bArr[61] = (byte) -1;
        bArr[62] = (byte) -1;
        bArr[63] = (byte) -1;
        bArr[64] = (byte) -1;
        bArr[66] = (byte) 1;
        bArr[67] = (byte) 2;
        bArr[68] = (byte) 3;
        bArr[69] = (byte) 4;
        bArr[70] = (byte) 5;
        bArr[71] = (byte) 6;
        bArr[72] = (byte) 7;
        bArr[73] = (byte) 8;
        bArr[74] = (byte) 9;
        bArr[75] = (byte) 10;
        bArr[76] = TagName.IDENTIFYING_TYPE;
        bArr[77] = TagName.IDENTIFYING_CODE;
        bArr[78] = TagName.PAY_CHANNEL;
        bArr[79] = (byte) 14;
        bArr[80] = (byte) 15;
        bArr[81] = (byte) 16;
        bArr[82] = (byte) 17;
        bArr[83] = TagName.THIRD_PAY_NUMBER;
        bArr[84] = TagName.ORDER_DATE;
        bArr[85] = TagName.ORDER_TIME;
        bArr[86] = TagName.ORDER_TRADE_STATUS;
        bArr[87] = TagName.ORDER_TRADE_NO;
        bArr[88] = TagName.ORDER_TERMINAL;
        bArr[89] = TagName.ORDER_INVOICE_STATUS;
        bArr[90] = TagName.ORDER_QUERY_PARAM;
        bArr[91] = (byte) -1;
        bArr[92] = (byte) -1;
        bArr[93] = (byte) -1;
        bArr[94] = (byte) -1;
        bArr[95] = TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[96] = (byte) -1;
        bArr[97] = TagName.BUSINESS_ORDER;
        bArr[98] = TagName.BUSINESS_ORDER_LIST;
        bArr[99] = TagName.APK_DOWNLOAD_URL;
        bArr[100] = (byte) 29;
        bArr[101] = TagName.ORDER_CHANNEL;
        bArr[102] = TagName.TRADE_STATUS;
        bArr[103] = (byte) 32;
        bArr[104] = (byte) 33;
        bArr[105] = (byte) 34;
        bArr[106] = (byte) 35;
        bArr[107] = TagName.USER_LOGIN_FAIL_COUNT;
        bArr[108] = TagName.ORDER_RANGE_TYPE;
        bArr[109] = TagName.QUERY_RECORD_COUNT;
        bArr[110] = (byte) 39;
        bArr[111] = TagName.CARD_APP_BLANCE;
        bArr[112] = (byte) 41;
        bArr[113] = (byte) 42;
        bArr[114] = TagName.USER_LOCK_TIME;
        bArr[115] = TagName.SYSTEM_NEW_VERSION;
        bArr[SpecialIssueType.BUG_TYPE_ID_CHARGE] = TagName.APK_UPDATE_FLAG;
        bArr[117] = TagName.SIM_SEID;
        bArr[118] = TagName.CARD_FORM;
        bArr[TagName.ELECTRONIC_USE_COUNT] = TagName.APK_SIZE;
        bArr[120] = TagName.NOTICE_ID;
        bArr[121] = TagName.NOTICE_TITLE;
        bArr[122] = TagName.ACTIVITY_CODE_LIST;
        f9176k = bArr;
    }

    public C2765a() {
        this(0);
    }

    public C2765a(boolean z) {
        this(76, f9173a, z);
    }

    public C2765a(int i) {
        this(i, f9173a);
    }

    public C2765a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public C2765a(int i, byte[] bArr, boolean z) {
        int i2;
        if (bArr == null) {
            i2 = 0;
        } else {
            i2 = bArr.length;
        }
        super(3, 4, i, i2);
        this.f9178m = f9176k;
        if (bArr == null) {
            this.f9181p = 4;
            this.f9179n = null;
        } else if (m12865d(bArr)) {
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + C2766c.m12876a(bArr) + "]");
        } else if (i > 0) {
            this.f9181p = bArr.length + 4;
            this.f9179n = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f9179n, 0, bArr.length);
        } else {
            this.f9181p = 4;
            this.f9179n = null;
        }
        this.f9180o = this.f9181p - 1;
        this.f9177l = z ? f9175j : f9174i;
    }

    void mo3195a(byte[] bArr, int i, int i2) {
        if (!this.f) {
            int i3;
            int i4;
            if (i2 < 0) {
                this.f = true;
                if (this.h != 0 || this.c != 0) {
                    m12856a(this.f9181p);
                    i3 = this.e;
                    byte[] bArr2;
                    switch (this.h) {
                        case 1:
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f9177l[(this.f9182q >> 2) & 63];
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f9177l[(this.f9182q << 4) & 63];
                            if (this.f9177l == f9174i) {
                                bArr2 = this.d;
                                i4 = this.e;
                                this.e = i4 + 1;
                                bArr2[i4] = TagName.CARD_APP_VERSION;
                                bArr2 = this.d;
                                i4 = this.e;
                                this.e = i4 + 1;
                                bArr2[i4] = TagName.CARD_APP_VERSION;
                                break;
                            }
                            break;
                        case 2:
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f9177l[(this.f9182q >> 10) & 63];
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f9177l[(this.f9182q >> 4) & 63];
                            bArr2 = this.d;
                            i4 = this.e;
                            this.e = i4 + 1;
                            bArr2[i4] = this.f9177l[(this.f9182q << 2) & 63];
                            if (this.f9177l == f9174i) {
                                bArr2 = this.d;
                                i4 = this.e;
                                this.e = i4 + 1;
                                bArr2[i4] = TagName.CARD_APP_VERSION;
                                break;
                            }
                            break;
                    }
                    this.g = (this.e - i3) + this.g;
                    if (this.c > 0 && this.g > 0) {
                        System.arraycopy(this.f9179n, 0, this.d, this.e, this.f9179n.length);
                        this.e += this.f9179n.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i5 = 0;
            while (i5 < i2) {
                m12856a(this.f9181p);
                this.h = (this.h + 1) % 3;
                i4 = i + 1;
                i3 = bArr[i];
                if (i3 < 0) {
                    i3 += 256;
                }
                this.f9182q = i3 + (this.f9182q << 8);
                if (this.h == 0) {
                    byte[] bArr3 = this.d;
                    int i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f9177l[(this.f9182q >> 18) & 63];
                    bArr3 = this.d;
                    i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f9177l[(this.f9182q >> 12) & 63];
                    bArr3 = this.d;
                    i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f9177l[(this.f9182q >> 6) & 63];
                    bArr3 = this.d;
                    i6 = this.e;
                    this.e = i6 + 1;
                    bArr3[i6] = this.f9177l[this.f9182q & 63];
                    this.g += 4;
                    if (this.c > 0 && this.c <= this.g) {
                        System.arraycopy(this.f9179n, 0, this.d, this.e, this.f9179n.length);
                        this.e += this.f9179n.length;
                        this.g = 0;
                    }
                }
                i5++;
                i = i4;
            }
        }
    }

    void mo3197b(byte[] bArr, int i, int i2) {
        if (!this.f) {
            int i3;
            if (i2 < 0) {
                this.f = true;
            }
            int i4 = 0;
            while (i4 < i2) {
                m12856a(this.f9180o);
                i3 = i + 1;
                byte b = bArr[i];
                if (b == TagName.CARD_APP_VERSION) {
                    this.f = true;
                    break;
                }
                if (b >= (byte) 0 && b < f9176k.length) {
                    b = f9176k[b];
                    if (b >= (byte) 0) {
                        this.h = (this.h + 1) % 4;
                        this.f9182q = b + (this.f9182q << 6);
                        if (this.h == 0) {
                            byte[] bArr2 = this.d;
                            int i5 = this.e;
                            this.e = i5 + 1;
                            bArr2[i5] = (byte) ((this.f9182q >> 16) & 255);
                            bArr2 = this.d;
                            i5 = this.e;
                            this.e = i5 + 1;
                            bArr2[i5] = (byte) ((this.f9182q >> 8) & 255);
                            bArr2 = this.d;
                            i5 = this.e;
                            this.e = i5 + 1;
                            bArr2[i5] = (byte) (this.f9182q & 255);
                        }
                    }
                }
                i4++;
                i = i3;
            }
            if (this.f && this.h != 0) {
                m12856a(this.f9180o);
                byte[] bArr3;
                switch (this.h) {
                    case 2:
                        this.f9182q >>= 4;
                        bArr3 = this.d;
                        i3 = this.e;
                        this.e = i3 + 1;
                        bArr3[i3] = (byte) (this.f9182q & 255);
                        return;
                    case 3:
                        this.f9182q >>= 2;
                        bArr3 = this.d;
                        i3 = this.e;
                        this.e = i3 + 1;
                        bArr3[i3] = (byte) ((this.f9182q >> 8) & 255);
                        bArr3 = this.d;
                        i3 = this.e;
                        this.e = i3 + 1;
                        bArr3[i3] = (byte) (this.f9182q & 255);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static String m12867a(byte[] bArr) {
        return C2766c.m12876a(C2765a.m12869a(bArr, false));
    }

    public static byte[] m12869a(byte[] bArr, boolean z) {
        return C2765a.m12870a(bArr, z, false);
    }

    public static byte[] m12870a(byte[] bArr, boolean z, boolean z2) {
        return C2765a.m12871a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] m12871a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C2765a c2765a = z ? new C2765a(z2) : new C2765a(0, f9173a, z2);
        long e = c2765a.m12866e(bArr);
        if (e <= ((long) i)) {
            return c2765a.m12864c(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + e + ") than the specified maximum size of " + i);
    }

    public static byte[] m12868a(String str) {
        return new C2765a().m12861b(str);
    }

    protected boolean mo3196a(byte b) {
        return b >= (byte) 0 && b < this.f9178m.length && this.f9178m[b] != (byte) -1;
    }
}
