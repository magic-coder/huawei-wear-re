package okio;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.io.UnsupportedEncodingException;

final class Base64 {
    private static final byte[] MAP = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.USER_LOCK_TIME, TagName.CARD_FORM};
    private static final byte[] URL_MAP = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.APK_UPDATE_FLAG, TagName.MOC};

    private Base64() {
    }

    public static byte[] decode(String str) {
        int i;
        int length = str.length();
        while (length > 0) {
            char charAt = str.charAt(length - 1);
            if (charAt != '=' && charAt != '\n' && charAt != '\r' && charAt != ' ' && charAt != '\t') {
                break;
            }
            length--;
        }
        Object obj = new byte[((int) ((((long) length) * 6) / 8))];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < length) {
            charAt = str.charAt(i2);
            if (charAt >= 'A' && charAt <= 'Z') {
                i = charAt - 65;
            } else if (charAt >= 'a' && charAt <= 'z') {
                i = charAt - 71;
            } else if (charAt >= '0' && charAt <= '9') {
                i = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i = 62;
            } else if (charAt == '/' || charAt == '_') {
                i = 63;
            } else if (charAt == '\n' || charAt == '\r' || charAt == ' ') {
                i = i3;
                i3 = i4;
                i4 = i5;
                i2++;
                i5 = i4;
                i4 = i3;
                i3 = i;
            } else if (charAt != '\t') {
                return null;
            } else {
                i = i3;
                i3 = i4;
                i4 = i5;
                i2++;
                i5 = i4;
                i4 = i3;
                i3 = i;
            }
            i = ((byte) i) | (i3 << 6);
            i3 = i4 + 1;
            if (i3 % 4 == 0) {
                i4 = i5 + 1;
                obj[i5] = (byte) (i >> 16);
                i5 = i4 + 1;
                obj[i4] = (byte) (i >> 8);
                i4 = i5 + 1;
                obj[i5] = (byte) i;
            } else {
                i4 = i5;
            }
            i2++;
            i5 = i4;
            i4 = i3;
            i3 = i;
        }
        i = i4 % 4;
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            i = i5 + 1;
            obj[i5] = (byte) ((i3 << 12) >> 16);
            i5 = i;
        } else if (i == 3) {
            i = i3 << 6;
            i3 = i5 + 1;
            obj[i5] = (byte) (i >> 16);
            i5 = i3 + 1;
            obj[i3] = (byte) (i >> 8);
        }
        if (i5 == obj.length) {
            return obj;
        }
        byte[] bArr = new byte[i5];
        System.arraycopy(obj, 0, bArr, 0, i5);
        return bArr;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, MAP);
    }

    public static String encodeUrl(byte[] bArr) {
        return encode(bArr, URL_MAP);
    }

    private static String encode(byte[] bArr, byte[] bArr2) {
        int i = 0;
        byte[] bArr3 = new byte[(((bArr.length + 2) * 4) / 3)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            i = i3 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i2 + 1] & 255) >> 4)];
            int i4 = i + 1;
            bArr3[i] = bArr2[((bArr[i2 + 1] & 15) << 2) | ((bArr[i2 + 2] & 255) >> 6)];
            i3 = i4 + 1;
            bArr3[i4] = bArr2[bArr[i2 + 2] & 63];
            i2 += 3;
            i = i3;
        }
        switch (bArr.length % 3) {
            case 1:
                i2 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                i = i2 + 1;
                bArr3[i2] = bArr2[(bArr[length] & 3) << 4];
                i2 = i + 1;
                bArr3[i] = TagName.CARD_APP_VERSION;
                i = i2 + 1;
                bArr3[i2] = TagName.CARD_APP_VERSION;
                break;
            case 2:
                i2 = i + 1;
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                i = i2 + 1;
                bArr3[i2] = bArr2[((bArr[length] & 3) << 4) | ((bArr[length + 1] & 255) >> 4)];
                i2 = i + 1;
                bArr3[i] = bArr2[(bArr[length + 1] & 15) << 2];
                i = i2 + 1;
                bArr3[i2] = TagName.CARD_APP_VERSION;
                break;
        }
        try {
            return new String(bArr3, 0, i, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
