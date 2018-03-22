package com.huawei.hwbtsdk.p399a;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.tsm.business.constants.Constants;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwcommonmodel.datatypes.C4755v;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.p190v.C2538c;
import com.snowballtech.business.constant.BusinessCode;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: CommandTransfer */
public class C4613p {
    static final byte[] f16874a = new byte[]{TagName.TagApdu, Constants.TagName.ACTIVITY_CODE_LIST, Constants.TagName.NOTICE_END_TIME, TagName.TagSerial, Constants.TagName.ELECTRONIC_STATE};
    private static final String[][] f16875b;
    private static final HashMap<String, String> f16876c = new C4614q();
    private static final HashMap<String, String> f16877d = new C4615r();

    static {
        r0 = new String[198][];
        r0[0] = new String[]{"1_2_44", "1_4_1"};
        r0[1] = new String[]{"1_2_45", "1_4_2"};
        r0[2] = new String[]{"1_2_46", "1_4_3"};
        r0[3] = new String[]{"1_2_4", "1_5_1"};
        r0[4] = new String[]{"1_2_5", "1_5_2"};
        r0[5] = new String[]{"1_2_35", "1_13_1"};
        r0[6] = new String[]{"1_1_4", "1_6_1"};
        r0[7] = new String[]{"1_1_5", "1_6_2"};
        r0[8] = new String[]{"5_1_1", "1_7_1"};
        r0[9] = new String[]{"5_1_2", "1_7_2"};
        r0[10] = new String[]{"5_1_3", "1_7_3"};
        r0[11] = new String[]{"5_1_4", "1_7_4"};
        r0[12] = new String[]{"5_1_5", "1_7_5"};
        r0[13] = new String[]{"5_1_6", "1_7_6"};
        r0[14] = new String[]{"5_1_7", "1_7_7"};
        r0[15] = new String[]{"5_1_9", "1_7_8"};
        r0[16] = new String[]{"5_1_13", "1_7_9"};
        r0[17] = new String[]{"5_1_14", "1_7_10"};
        r0[18] = new String[]{"5_1_15", "1_7_11"};
        r0[19] = new String[]{"1_1_36", "1_8_1"};
        r0[20] = new String[]{"1_2_15", "1_9_1"};
        r0[21] = new String[]{"1_3_53", "1_10_1"};
        r0[22] = new String[]{"1_3_54", "1_10_2"};
        r0[23] = new String[]{"1_3_55", "1_10_3"};
        r0[24] = new String[]{"1_3_56", "1_10_4"};
        r0[25] = new String[]{"1_3_57", "1_10_5"};
        r0[26] = new String[]{"1_3_58", "1_10_6"};
        r0[27] = new String[]{"1_3_59", "1_10_7"};
        r0[28] = new String[]{"1_4_53", "1_11_1"};
        r0[29] = new String[]{"1_4_54", "1_11_2"};
        r0[30] = new String[]{"1_2_53", "1_12_1"};
        r0[31] = new String[]{"1_2_54", "1_12_2"};
        r0[32] = new String[]{"1_2_55", "1_12_3"};
        r0[33] = new String[]{"1_2_56", "1_12_4"};
        r0[34] = new String[]{"1_2_57", "1_12_5"};
        r0[35] = new String[]{"1_2_58", "1_12_6"};
        r0[36] = new String[]{"1_2_59", "1_12_7"};
        r0[37] = new String[]{"4_1_40", "1_20_1"};
        r0[38] = new String[]{"5_0_16", "1_16_1"};
        r0[39] = new String[]{"5_0_17", "1_16_2"};
        r0[40] = new String[]{"5_0_18", "1_16_3"};
        r0[41] = new String[]{"5_0_19", "1_16_4"};
        r0[42] = new String[]{"5_0_20", "1_16_5"};
        r0[43] = new String[]{"5_0_21", "1_16_6"};
        r0[44] = new String[]{"5_0_22", "1_16_7"};
        r0[45] = new String[]{"5_0_23", "1_16_8"};
        r0[46] = new String[]{"5_0_24", "1_16_9"};
        r0[47] = new String[]{"5_0_28", "1_16_10"};
        r0[48] = new String[]{"6_2_5", "1_14_1"};
        r0[49] = new String[]{"6_2_6", "1_14_2"};
        r0[50] = new String[]{"6_2_7", "1_14_3"};
        r0[51] = new String[]{"6_2_8", "1_14_4"};
        r0[52] = new String[]{"6_2_12", "1_14_5"};
        r0[53] = new String[]{"6_2_13", "1_14_6"};
        r0[54] = new String[]{"6_1_9", "1_15_1"};
        r0[55] = new String[]{"6_1_10", "1_15_2"};
        r0[56] = new String[]{"6_1_12", "1_15_3"};
        r0[57] = new String[]{"6_1_14", "1_15_4"};
        r0[58] = new String[]{"6_1_15", "1_15_5"};
        r0[59] = new String[]{"6_1_13", "1_15_6"};
        r0[60] = new String[]{"6_1_17", "1_15_7"};
        r0[61] = new String[]{"8_2_26", "2_1_1"};
        r0[62] = new String[]{"8_2_1", "2_1_2"};
        r0[63] = new String[]{"8_2_2", "2_1_3"};
        r0[64] = new String[]{"8_2_3", "2_1_4"};
        r0[65] = new String[]{"8_2_27", "2_1_5"};
        r0[66] = new String[]{"8_2_5", "2_1_6"};
        r0[67] = new String[]{"8_2_28", "2_1_7"};
        r0[68] = new String[]{"8_2_6", "2_1_8"};
        r0[69] = new String[]{"8_2_7", "2_1_9"};
        r0[70] = new String[]{"8_2_8", "2_1_10"};
        r0[71] = new String[]{"8_2_9", "2_1_11"};
        r0[72] = new String[]{"8_2_29", "2_1_12"};
        r0[73] = new String[]{"8_2_10", "2_1_13"};
        r0[74] = new String[]{"8_2_30", "2_1_14"};
        r0[75] = new String[]{"8_2_11", "2_1_15"};
        r0[76] = new String[]{"8_2_12", "2_1_16"};
        r0[77] = new String[]{"8_1_38", "2_2_1"};
        r0[78] = new String[]{"8_1_24", "2_2_2"};
        r0[79] = new String[]{"8_1_1", "2_2_3"};
        r0[80] = new String[]{"8_1_36", "2_2_4"};
        r0[81] = new String[]{"8_1_52", "2_2_5"};
        r0[82] = new String[]{"8_1_53", "2_2_6"};
        r0[83] = new String[]{"8_1_31", "2_2_7"};
        r0[84] = new String[]{"8_1_32", "2_2_8"};
        r0[85] = new String[]{"8_1_33", "2_2_9"};
        r0[86] = new String[]{"8_1_34", "2_2_10"};
        r0[87] = new String[]{"8_1_35", "2_2_11"};
        r0[88] = new String[]{"8_1_6", "2_2_12"};
        r0[89] = new String[]{"8_1_7", "2_2_13"};
        r0[90] = new String[]{"8_1_8", "2_2_14"};
        r0[91] = new String[]{"8_1_20", "2_2_15"};
        r0[92] = new String[]{"8_1_54", "2_2_16"};
        r0[93] = new String[]{"8_1_23", "2_2_17"};
        r0[94] = new String[]{"8_1_30", "2_2_18"};
        r0[95] = new String[]{"8_1_25", "2_2_19"};
        r0[96] = new String[]{"8_1_21", "2_2_20"};
        r0[97] = new String[]{"8_2_47", "2_4_1"};
        r0[98] = new String[]{"8_2_48", "2_4_2"};
        r0[99] = new String[]{"8_2_49", "2_4_3"};
        r0[100] = new String[]{"8_1_42", "15_2_1"};
        r0[101] = new String[]{"8_2_39", "15_1_1"};
        r0[102] = new String[]{"8_2_40", "15_1_2"};
        r0[103] = new String[]{"8_2_41", "15_1_3"};
        r0[104] = new String[]{"8_2_43", "15_1_4"};
        r0[105] = new String[]{"8_2_44", "15_1_5"};
        r0[106] = new String[]{"8_2_45", "15_1_6"};
        r0[107] = new String[]{"8_2_46", "15_1_7"};
        r0[108] = new String[]{"7_2_1", "7_1_1"};
        r0[109] = new String[]{"7_2_2", "7_1_2"};
        r0[110] = new String[]{"7_2_3", "7_1_3"};
        r0[111] = new String[]{"7_2_15", "7_1_4"};
        r0[112] = new String[]{"7_2_4", "7_1_5"};
        r0[113] = new String[]{"7_2_5", "7_1_6"};
        r0[114] = new String[]{"7_2_6", "7_1_7"};
        r0[115] = new String[]{"7_2_39", "7_1_8"};
        r0[SpecialIssueType.BUG_TYPE_ID_CHARGE] = new String[]{"7_2_7", "7_2_1"};
        r0[117] = new String[]{"7_2_8", "7_2_2"};
        r0[118] = new String[]{"7_2_9", "7_2_3"};
        r0[Constants.TagName.ELECTRONIC_USE_COUNT] = new String[]{"7_2_99", "7_2_4"};
        r0[120] = new String[]{"7_2_10", "7_2_5"};
        r0[121] = new String[]{"7_2_11", "7_2_6"};
        r0[122] = new String[]{"7_2_12", "7_2_7"};
        r0[ReportInfoUtils.FEEDBACK_SUCCESS] = new String[]{"17_2_7", "7_9_1"};
        r0[ReportInfoUtils.FEEDBACK_FAILED] = new String[]{"17_2_8", "7_9_2"};
        r0[125] = new String[]{"17_2_9", "7_9_3"};
        r0[TransportMediator.KEYCODE_MEDIA_PLAY] = new String[]{"17_2_99", "7_9_4"};
        r0[127] = new String[]{"17_2_10", "7_9_5"};
        r0[128] = new String[]{"17_2_11", "7_9_6"};
        r0[129] = new String[]{"17_2_12", "7_9_7"};
        r0[TransportMediator.KEYCODE_MEDIA_RECORD] = new String[]{"7_1_13", "7_3_1"};
        r0[131] = new String[]{"7_1_57", "7_3_2"};
        r0[132] = new String[]{"7_1_14", "7_3_3"};
        r0[133] = new String[]{"7_1_15_13", "7_3_4"};
        r0[134] = new String[]{"7_1_16_13", "7_3_5"};
        r0[135] = new String[]{"7_1_17_13", "7_3_6"};
        r0[SyslogAppender.LOG_LOCAL1] = new String[]{"7_1_18_13", "7_3_7"};
        r0[137] = new String[]{"7_1_46", "7_3_8"};
        r0[138] = new String[]{"7_1_50", "7_4_1"};
        r0[139] = new String[]{"7_1_19", "7_4_2"};
        r0[140] = new String[]{"7_1_51", "7_4_3"};
        r0[141] = new String[]{"7_1_52", "7_4_4"};
        r0[142] = new String[]{"7_1_48_50", "7_4_5"};
        r0[143] = new String[]{"7_1_22", "7_8_1"};
        r0[SyslogAppender.LOG_LOCAL2] = new String[]{"7_1_20", "7_8_2"};
        r0[145] = new String[]{"7_1_21", "7_8_3"};
        r0[146] = new String[]{"7_1_23", "7_8_4"};
        r0[147] = new String[]{"7_1_64", "7_8_5"};
        r0[148] = new String[]{"7_1_25", "7_8_6"};
        r0[149] = new String[]{"7_1_24", "7_8_7"};
        r0[150] = new String[]{"7_1_15_22", "7_8_8"};
        r0[151] = new String[]{"7_1_16_22", "7_8_9"};
        r0[SyslogAppender.LOG_LOCAL3] = new String[]{"7_1_17_22", "7_8_10"};
        r0[153] = new String[]{"7_1_18_22", "7_8_11"};
        r0[154] = new String[]{"7_1_30", "7_8_12"};
        r0[155] = new String[]{"7_1_47", "7_5_1"};
        r0[BusinessCode.CURRENCY_CODE_RMB] = new String[]{"7_1_48_47", "7_5_2"};
        r0[157] = new String[]{"7_1_49", "7_5_3"};
        r0[158] = new String[]{"7_2_33", "7_7_1"};
        r0[159] = new String[]{"7_2_34", "7_7_2"};
        r0[SyslogAppender.LOG_LOCAL4] = new String[]{"7_2_35", "7_7_3"};
        r0[161] = new String[]{"7_2_36", "7_7_4"};
        r0[162] = new String[]{"7_2_37", "7_7_5"};
        r0[163] = new String[]{"7_2_38", "7_7_6"};
        r0[164] = new String[]{"1_2_6", "8_1_1"};
        r0[165] = new String[]{"1_2_7", "8_1_2"};
        r0[166] = new String[]{"1_2_8_6", "8_1_3"};
        r0[167] = new String[]{"1_2_9_6", "8_1_4"};
        r0[SyslogAppender.LOG_LOCAL5] = new String[]{"1_2_10_6", "8_1_5"};
        r0[169] = new String[]{"1_2_11_6", "8_1_6"};
        r0[HiUserInfo.HEIGHT_DEFAULT] = new String[]{"1_2_42", "8_1_7"};
        r0[171] = new String[]{"1_2_43", "8_2_1"};
        r0[172] = new String[]{"1_2_40", "8_2_2"};
        r0[173] = new String[]{"1_2_8_43", "8_2_3"};
        r0[174] = new String[]{"1_2_9_43", "8_2_4"};
        r0[175] = new String[]{"1_2_10_43", "8_2_5"};
        r0[SyslogAppender.LOG_LOCAL6] = new String[]{"1_2_11_43", "8_2_6"};
        r0[177] = new String[]{"1_2_41", "8_2_7"};
        r0[178] = new String[]{"12_2_14", "12_1_1"};
        r0[179] = new String[]{"6_2_1", "11_2_1"};
        r0[180] = new String[]{"6_0_4", "11_1_1"};
        r0[181] = new String[]{"16_2_26", "2_3_1"};
        r0[182] = new String[]{"16_2_1", "2_3_2"};
        r0[183] = new String[]{"16_2_2", "2_3_3"};
        r0[SyslogAppender.LOG_LOCAL7] = new String[]{"16_2_3", "2_3_4"};
        r0[185] = new String[]{"16_2_27", "2_3_5"};
        r0[186] = new String[]{"16_2_5", "2_3_6"};
        r0[187] = new String[]{"16_2_28", "2_3_7"};
        r0[188] = new String[]{"16_2_6", "2_3_8"};
        r0[189] = new String[]{"16_2_7", "2_3_9"};
        r0[190] = new String[]{"16_2_8", "2_3_10"};
        r0[191] = new String[]{"16_2_9", "2_3_11"};
        r0[192] = new String[]{"16_2_29", "2_3_12"};
        r0[193] = new String[]{"16_2_10", "2_3_13"};
        r0[194] = new String[]{"16_2_30", "2_3_14"};
        r0[195] = new String[]{"16_2_11", "2_3_15"};
        r0[196] = new String[]{"16_2_12", "2_3_16"};
        r0[197] = new String[]{"8_0_51", "4_1_1"};
        f16875b = r0;
    }

    public static int m22018a(String str) {
        if (str == null) {
            return -1;
        }
        int parseInt;
        String str2 = (String) f16876c.get(str);
        if (str2 != null) {
            int indexOf = str2.indexOf(95);
            if (indexOf >= 0) {
                parseInt = Integer.parseInt(str2.substring(0, indexOf));
                if (-1 != parseInt) {
                }
                return parseInt;
            }
        }
        parseInt = -1;
        if (-1 != parseInt) {
        }
        return parseInt;
    }

    public static int m22023b(String str) {
        if (str == null) {
            return -1;
        }
        int parseInt;
        String str2 = (String) f16876c.get(str);
        if (str2 != null) {
            int indexOf = str2.indexOf(95);
            if (indexOf >= 0) {
                str2 = str2.substring(indexOf + 1, str2.length());
                indexOf = str2.indexOf(95);
                if (indexOf >= 0) {
                    parseInt = Integer.parseInt(str2.substring(0, indexOf));
                    if (-1 != parseInt) {
                    }
                    return parseInt;
                }
            }
        }
        parseInt = -1;
        if (-1 != parseInt) {
        }
        return parseInt;
    }

    public static int m22024c(String str) {
        if (str == null) {
            return -1;
        }
        int parseInt;
        String str2 = (String) f16876c.get(str);
        if (str2 != null) {
            int indexOf = str2.indexOf(95);
            if (indexOf >= 0) {
                str2 = str2.substring(indexOf + 1, str2.length());
                indexOf = str2.indexOf(95);
                if (indexOf >= 0) {
                    str2 = str2.substring(indexOf + 1, str2.length());
                    indexOf = str2.indexOf(95);
                    parseInt = indexOf < 0 ? Integer.parseInt(str2) : Integer.parseInt(str2.substring(0, indexOf));
                    if (-1 != parseInt) {
                    }
                    return parseInt;
                }
            }
        }
        parseInt = -1;
        if (-1 != parseInt) {
        }
        return parseInt;
    }

    public static int m22025d(String str) {
        if (str == null) {
            return -1;
        }
        int parseInt;
        String str2 = (String) f16877d.get(str);
        if (str2 != null) {
            int indexOf = str2.indexOf(95);
            if (indexOf >= 0) {
                parseInt = Integer.parseInt(str2.substring(0, indexOf));
                if (-1 != parseInt) {
                }
                return parseInt;
            }
        }
        parseInt = -1;
        if (-1 != parseInt) {
        }
        return parseInt;
    }

    public static int m22026e(String str) {
        if (str == null) {
            return -1;
        }
        int parseInt;
        String str2 = (String) f16877d.get(str);
        if (str2 != null) {
            int indexOf = str2.indexOf(95);
            if (indexOf >= 0) {
                str2 = str2.substring(indexOf + 1, str2.length());
                indexOf = str2.indexOf(95);
                if (indexOf >= 0) {
                    parseInt = Integer.parseInt(str2.substring(0, indexOf));
                    if (-1 != parseInt) {
                    }
                    return parseInt;
                }
            }
        }
        parseInt = -1;
        if (-1 != parseInt) {
        }
        return parseInt;
    }

    public static int m22027f(String str) {
        if (str == null) {
            return -1;
        }
        int parseInt;
        String str2 = (String) f16877d.get(str);
        if (str2 != null) {
            int indexOf = str2.indexOf(95);
            if (indexOf >= 0) {
                str2 = str2.substring(indexOf + 1, str2.length());
                indexOf = str2.indexOf(95);
                if (indexOf >= 0) {
                    str2 = str2.substring(indexOf + 1, str2.length());
                    indexOf = str2.indexOf(95);
                    parseInt = indexOf < 0 ? Integer.parseInt(str2) : Integer.parseInt(str2.substring(0, indexOf));
                    if (-1 != parseInt) {
                    }
                    return parseInt;
                }
            }
        }
        parseInt = -1;
        if (-1 != parseInt) {
        }
        return parseInt;
    }

    private static List<C4755v> m22019a(byte[] bArr, int i) {
        C4756w c4756w = new C4756w();
        C4755v c4755v = new C4755v();
        String a = a.a(bArr);
        try {
            C4755v a2 = c4756w.m22744a(c4755v, a.substring(i * 2, a.length()), 0);
            if (a2 != null) {
                return a2.f17339a;
            }
            return null;
        } catch (Exception e) {
            C2538c.a("0xA0200008", "01", 1, "CommandTransfer", new Object[]{"Exception = " + e.getMessage()});
            return null;
        }
    }

    public static byte[] m22020a(int i, int i2, int i3, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Object obj = new byte[(bArr.length - 1)];
        System.arraycopy(bArr, 1, obj, 0, bArr.length - 1);
        List a = C4613p.m22019a(bArr, 3);
        if (a != null) {
            String format = String.format(Locale.US, "%d_%d_%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            int a2 = C4613p.m22018a(format);
            int b = C4613p.m22023b(format);
            obj[0] = (byte) a2;
            obj[1] = (byte) b;
            for (a2 = 0; a2 < a.size(); a2++) {
                C4755v c4755v = (C4755v) a.get(a2);
                String c = c4755v.m22740c();
                if (127 == Integer.parseInt(c)) {
                    break;
                }
                if (1 == i && 2 == i2 && (c.equals(String.valueOf(8)) || c.equals(String.valueOf(9)) || c.equals(String.valueOf(10)) || c.equals(String.valueOf(11)))) {
                    c = String.format(Locale.US, "%d_%d_%s_%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), c, Integer.valueOf(i3)});
                } else if (7 == i && 1 == i2 && (c.equals(String.valueOf(48)) || c.equals(String.valueOf(15)) || c.equals(String.valueOf(16)) || c.equals(String.valueOf(17)) || c.equals(String.valueOf(18)))) {
                    c = String.format(Locale.US, "%d_%d_%s_%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), c, Integer.valueOf(i3)});
                } else {
                    c = String.format(Locale.US, "%d_%d_%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), c});
                }
                int c2 = C4613p.m22024c(c);
                if (-1 != c2) {
                    c4755v.m22737a(String.valueOf(c2));
                    if (128 == (bArr[c4755v.m22736a() + 3] & 128)) {
                        obj[c4755v.m22736a() + 2] = (byte) (c2 | 128);
                    } else {
                        obj[c4755v.m22736a() + 2] = (byte) c2;
                    }
                }
            }
        }
        return obj;
    }

    public static byte[] m22021a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        byte b2 = bArr[1];
        Object obj = new byte[(bArr.length + 1)];
        System.arraycopy(bArr, 0, obj, 1, bArr.length);
        List a = C4613p.m22019a(bArr, 2);
        if (a != null && a.size() > 0) {
            C4755v c4755v = (C4755v) a.get(0);
            String format = String.format(Locale.US, "%d_%d_%s", new Object[]{Integer.valueOf(b), Integer.valueOf(b2), c4755v.m22738b()});
            obj[1] = (byte) C4613p.m22025d(format);
            obj[2] = (byte) C4613p.m22026e(format);
            if ((byte) 1 == b && (byte) 16 == b2) {
                obj[2] = 2;
            }
            for (int i = 0; i < a.size(); i++) {
                c4755v = (C4755v) a.get(i);
                int f = C4613p.m22027f(String.format(Locale.US, "%d_%d_%s", new Object[]{Integer.valueOf(b), Integer.valueOf(b2), c4755v.m22738b()}));
                if (-1 != f) {
                    c4755v.m22739b(String.valueOf(f));
                    if (128 == (bArr[c4755v.m22736a() + 2] & 128)) {
                        obj[c4755v.m22736a() + 3] = (byte) f;
                        int a2 = c4755v.m22736a() + 3;
                        obj[a2] = (byte) (obj[a2] | 128);
                    } else {
                        obj[c4755v.m22736a() + 3] = (byte) f;
                    }
                }
            }
        }
        return obj;
    }
}
