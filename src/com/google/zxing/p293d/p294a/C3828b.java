package com.google.zxing.p293d.p294a;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.zxing.p278b.C3720e;
import com.unionpay.tsmservice.data.Constant;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: DecodedBitStreamParser */
final class C3828b {
    private static final NumberFormat f14844a = new DecimalFormat("000000000");
    private static final NumberFormat f14845b = new DecimalFormat(Constant.DEFAULT_CVN2);
    private static final String[] f14846c = new String[]{"\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\u001c\u001d\u001e￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\u001c\u001d\u001e￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\u001c\u001d\u001e￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a￺￼￼\u001b￻\u001c\u001d\u001e\u001f ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    static C3720e m19097a(byte[] bArr, int i) {
        StringBuilder stringBuilder = new StringBuilder(SyslogAppender.LOG_LOCAL2);
        switch (i) {
            case 2:
            case 3:
                Object format;
                if (i == 2) {
                    format = new DecimalFormat("0000000000".substring(0, C3828b.m19100c(bArr))).format((long) C3828b.m19101d(bArr));
                } else {
                    format = C3828b.m19102e(bArr);
                }
                String format2 = f14845b.format((long) C3828b.m19095a(bArr));
                String format3 = f14845b.format((long) C3828b.m19099b(bArr));
                stringBuilder.append(C3828b.m19098a(bArr, 10, 84));
                if (!stringBuilder.toString().startsWith("[)>\u001e01\u001d")) {
                    stringBuilder.insert(0, new StringBuilder(String.valueOf(format)).append('\u001d').append(format2).append('\u001d').append(format3).append('\u001d').toString());
                    break;
                }
                stringBuilder.insert(9, new StringBuilder(String.valueOf(format)).append('\u001d').append(format2).append('\u001d').append(format3).append('\u001d').toString());
                break;
            case 4:
                stringBuilder.append(C3828b.m19098a(bArr, 1, 93));
                break;
            case 5:
                stringBuilder.append(C3828b.m19098a(bArr, 1, 77));
                break;
        }
        return new C3720e(bArr, stringBuilder.toString(), null, String.valueOf(i));
    }

    private static int m19094a(int i, byte[] bArr) {
        int i2 = i - 1;
        if (((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0) {
            return 0;
        }
        return 1;
    }

    private static int m19096a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i < bArr2.length) {
            i2 += C3828b.m19094a(bArr2[i], bArr) << ((bArr2.length - i) - 1);
            i++;
        }
        return i2;
    }

    private static int m19095a(byte[] bArr) {
        return C3828b.m19096a(bArr, new byte[]{(byte) 53, TagName.NOTICE_START_TIME, TagName.USER_LOCK_TIME, TagName.SYSTEM_NEW_VERSION, TagName.APK_UPDATE_FLAG, TagName.SIM_SEID, TagName.CARD_FORM, TagName.APK_SIZE, TagName.ORDER_RANGE_TYPE, TagName.QUERY_RECORD_COUNT});
    }

    private static int m19099b(byte[] bArr) {
        return C3828b.m19096a(bArr, new byte[]{TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.BUSINESS_ORDER_OP_TYPE, TagName.CARD_APP_RAMDOM, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY});
    }

    private static int m19100c(byte[] bArr) {
        return C3828b.m19096a(bArr, new byte[]{(byte) 39, TagName.CARD_APP_BLANCE, (byte) 41, (byte) 42, TagName.TRADE_STATUS, (byte) 32});
    }

    private static int m19101d(byte[] bArr) {
        return C3828b.m19096a(bArr, new byte[]{(byte) 33, (byte) 34, (byte) 35, TagName.USER_LOGIN_FAIL_COUNT, TagName.ORDER_QUERY_PARAM, TagName.BUSINESS_ORDER, TagName.BUSINESS_ORDER_LIST, TagName.APK_DOWNLOAD_URL, (byte) 29, TagName.ORDER_CHANNEL, TagName.ORDER_DATE, TagName.ORDER_TIME, TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.PAY_CHANNEL, (byte) 14, (byte) 15, (byte) 16, (byte) 17, TagName.THIRD_PAY_NUMBER, (byte) 7, (byte) 8, (byte) 9, (byte) 10, TagName.IDENTIFYING_TYPE, TagName.IDENTIFYING_CODE, (byte) 1, (byte) 2});
    }

    private static String m19102e(byte[] bArr) {
        return String.valueOf(new char[]{f14846c[0].charAt(C3828b.m19096a(bArr, new byte[]{(byte) 39, TagName.CARD_APP_BLANCE, (byte) 41, (byte) 42, TagName.TRADE_STATUS, (byte) 32})), f14846c[0].charAt(C3828b.m19096a(bArr, new byte[]{(byte) 33, (byte) 34, (byte) 35, TagName.USER_LOGIN_FAIL_COUNT, TagName.ORDER_QUERY_PARAM, TagName.BUSINESS_ORDER})), f14846c[0].charAt(C3828b.m19096a(bArr, new byte[]{TagName.BUSINESS_ORDER_LIST, TagName.APK_DOWNLOAD_URL, (byte) 29, TagName.ORDER_CHANNEL, TagName.ORDER_DATE, TagName.ORDER_TIME})), f14846c[0].charAt(C3828b.m19096a(bArr, new byte[]{TagName.ORDER_TRADE_STATUS, TagName.ORDER_TRADE_NO, TagName.ORDER_TERMINAL, TagName.ORDER_INVOICE_STATUS, TagName.PAY_CHANNEL, (byte) 14})), f14846c[0].charAt(C3828b.m19096a(bArr, new byte[]{(byte) 15, (byte) 16, (byte) 17, TagName.THIRD_PAY_NUMBER, (byte) 7, (byte) 8})), f14846c[0].charAt(C3828b.m19096a(bArr, new byte[]{(byte) 9, (byte) 10, TagName.IDENTIFYING_TYPE, TagName.IDENTIFYING_CODE, (byte) 1, (byte) 2}))});
    }

    private static String m19098a(byte[] bArr, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i3 = i;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (i3 < i + i2) {
            int i7;
            char charAt = f14846c[i5].charAt(bArr[i3]);
            switch (charAt) {
                case '￰':
                case '￱':
                case '￲':
                case '￳':
                case '￴':
                    i6 = 1;
                    i7 = i5;
                    i5 = i3;
                    i3 = charAt - 65520;
                    i4 = i7;
                    break;
                case '￵':
                    i6 = 2;
                    i4 = i5;
                    i5 = i3;
                    i3 = 0;
                    break;
                case '￶':
                    i6 = 3;
                    i4 = i5;
                    i5 = i3;
                    i3 = 0;
                    break;
                case '￷':
                    i5 = i3;
                    i6 = -1;
                    i3 = 0;
                    break;
                case '￸':
                    i5 = i3;
                    i6 = -1;
                    i3 = 1;
                    break;
                case '￹':
                    i6 = -1;
                    i7 = i5;
                    i5 = i3;
                    i3 = i7;
                    break;
                case '￻':
                    i3++;
                    i3++;
                    i3++;
                    i3++;
                    i3++;
                    stringBuilder.append(f14844a.format((long) (((((bArr[i3] << 24) + (bArr[i3] << 18)) + (bArr[i3] << 12)) + (bArr[i3] << 6)) + bArr[i3])));
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                    break;
                default:
                    stringBuilder.append(charAt);
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                    break;
            }
            int i8 = i6 - 1;
            if (i6 == 0) {
                i3 = i4;
            }
            i6 = i8;
            i7 = i3;
            i3 = i5 + 1;
            i5 = i7;
        }
        while (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '￼') {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
