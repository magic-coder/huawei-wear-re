package com.tencent.wxop.stat.p547b;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;

final class C6516k extends C6514i {
    static final /* synthetic */ boolean f22701g = (!C6513h.class.desiredAssertionStatus());
    private static final byte[] f22702h = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.USER_LOCK_TIME, TagName.CARD_FORM};
    private static final byte[] f22703i = new byte[]{TagName.TERMINAL_BACK_CONTENT, TagName.INVOICE_TOKEN, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_OS_VERSION, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BASEBAND_VERSION, TagName.ACTIVITY_INFO, TagName.BUSINESS_ORDER_TYPE, TagName.ORDER_BRIEF_INFO, (byte) 74, (byte) 75, TagName.TERMINAL_OP_TYPE, (byte) 77, (byte) 78, TagName.CP_NO, TagName.ORDER_BRIEF_INFO_LIST, (byte) 81, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_BACK_INFO_LIST, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.QUERY_DATA_SORT_TYPE, (byte) 87, TagName.CARD_BUSINESS_OP_RECOMMENED, (byte) 89, TagName.PREDEPOSIT_TOTAL, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102, TagName.PRODUCT_ID, TagName.DEVICE_MODEL, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.ELECTRONIC, TagName.ELECTRONIC_LIST, TagName.PUBLISH_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_ID, TagName.ELECTRONIC_TYPE_ID, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_TYPE, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 119, TagName.ELECTRONIC_APP_TYPE, TagName.ELECTRONIC_STATE, TagName.ELECTRONIC_OUT_STATE, TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.APK_UPDATE_FLAG, TagName.MOC};
    int f22704c;
    public final boolean f22705d;
    public final boolean f22706e;
    public final boolean f22707f;
    private final byte[] f22708j;
    private int f22709k;
    private final byte[] f22710l;

    public C6516k() {
        this.a = null;
        this.f22705d = true;
        this.f22706e = true;
        this.f22707f = false;
        this.f22710l = f22702h;
        this.f22708j = new byte[2];
        this.f22704c = 0;
        this.f22709k = this.f22706e ? 19 : -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m29726a(byte[] r14, int r15) {
        /*
        r13 = this;
        r6 = 2;
        r12 = 13;
        r11 = 10;
        r3 = 1;
        r4 = 0;
        r7 = r13.f22710l;
        r8 = r13.a;
        r2 = r13.f22709k;
        r9 = r15 + 0;
        r0 = -1;
        r1 = r13.f22704c;
        switch(r1) {
            case 0: goto L_0x00a4;
            case 1: goto L_0x00a8;
            case 2: goto L_0x00c4;
            default: goto L_0x0015;
        };
    L_0x0015:
        r5 = r0;
        r1 = r4;
    L_0x0017:
        r0 = -1;
        if (r5 == r0) goto L_0x01ef;
    L_0x001a:
        r0 = r5 >> 18;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r4] = r0;
        r0 = r5 >> 12;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r3] = r0;
        r0 = r5 >> 6;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r6] = r0;
        r6 = 3;
        r0 = 4;
        r5 = r5 & 63;
        r5 = r7[r5];
        r8[r6] = r5;
        r2 = r2 + -1;
        if (r2 != 0) goto L_0x01eb;
    L_0x003e:
        r2 = r13.f22707f;
        if (r2 == 0) goto L_0x0046;
    L_0x0042:
        r2 = 4;
        r0 = 5;
        r8[r2] = r12;
    L_0x0046:
        r5 = r0 + 1;
        r8[r0] = r11;
        r0 = 19;
        r6 = r0;
    L_0x004d:
        r0 = r1 + 3;
        if (r0 > r9) goto L_0x00e2;
    L_0x0051:
        r0 = r14[r1];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r2 = r1 + 1;
        r2 = r14[r2];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r0 = r0 | r2;
        r2 = r1 + 2;
        r2 = r14[r2];
        r2 = r2 & 255;
        r0 = r0 | r2;
        r2 = r0 >> 18;
        r2 = r2 & 63;
        r2 = r7[r2];
        r8[r5] = r2;
        r2 = r5 + 1;
        r10 = r0 >> 12;
        r10 = r10 & 63;
        r10 = r7[r10];
        r8[r2] = r10;
        r2 = r5 + 2;
        r10 = r0 >> 6;
        r10 = r10 & 63;
        r10 = r7[r10];
        r8[r2] = r10;
        r2 = r5 + 3;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r2] = r0;
        r2 = r1 + 3;
        r1 = r5 + 4;
        r0 = r6 + -1;
        if (r0 != 0) goto L_0x01e6;
    L_0x0093:
        r0 = r13.f22707f;
        if (r0 == 0) goto L_0x01e3;
    L_0x0097:
        r0 = r1 + 1;
        r8[r1] = r12;
    L_0x009b:
        r5 = r0 + 1;
        r8[r0] = r11;
        r0 = 19;
        r1 = r2;
        r6 = r0;
        goto L_0x004d;
    L_0x00a4:
        r5 = r0;
        r1 = r4;
        goto L_0x0017;
    L_0x00a8:
        if (r6 > r9) goto L_0x0015;
    L_0x00aa:
        r0 = r13.f22708j;
        r0 = r0[r4];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r1 = r14[r4];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r0 = r0 | r1;
        r1 = r14[r3];
        r1 = r1 & 255;
        r0 = r0 | r1;
        r13.f22704c = r4;
        r5 = r0;
        r1 = r6;
        goto L_0x0017;
    L_0x00c4:
        if (r9 <= 0) goto L_0x0015;
    L_0x00c6:
        r0 = r13.f22708j;
        r0 = r0[r4];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r1 = r13.f22708j;
        r1 = r1[r3];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r0 = r0 | r1;
        r1 = r14[r4];
        r1 = r1 & 255;
        r0 = r0 | r1;
        r13.f22704c = r4;
        r5 = r0;
        r1 = r3;
        goto L_0x0017;
    L_0x00e2:
        r0 = r13.f22704c;
        r0 = r1 - r0;
        r2 = r9 + -1;
        if (r0 != r2) goto L_0x0146;
    L_0x00ea:
        r0 = r13.f22704c;
        if (r0 <= 0) goto L_0x013f;
    L_0x00ee:
        r0 = r13.f22708j;
        r0 = r0[r4];
        r2 = r3;
    L_0x00f3:
        r0 = r0 & 255;
        r4 = r0 << 4;
        r0 = r13.f22704c;
        r0 = r0 - r2;
        r13.f22704c = r0;
        r2 = r5 + 1;
        r0 = r4 >> 6;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r5] = r0;
        r0 = r2 + 1;
        r4 = r4 & 63;
        r4 = r7[r4];
        r8[r2] = r4;
        r2 = r13.f22705d;
        if (r2 == 0) goto L_0x011e;
    L_0x0112:
        r2 = r0 + 1;
        r4 = 61;
        r8[r0] = r4;
        r0 = r2 + 1;
        r4 = 61;
        r8[r2] = r4;
    L_0x011e:
        r2 = r13.f22706e;
        if (r2 == 0) goto L_0x0130;
    L_0x0122:
        r2 = r13.f22707f;
        if (r2 == 0) goto L_0x012b;
    L_0x0126:
        r2 = r0 + 1;
        r8[r0] = r12;
        r0 = r2;
    L_0x012b:
        r2 = r0 + 1;
        r8[r0] = r11;
        r0 = r2;
    L_0x0130:
        r5 = r0;
    L_0x0131:
        r0 = f22701g;
        if (r0 != 0) goto L_0x01ce;
    L_0x0135:
        r0 = r13.f22704c;
        if (r0 == 0) goto L_0x01ce;
    L_0x0139:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x013f:
        r2 = r1 + 1;
        r0 = r14[r1];
        r1 = r2;
        r2 = r4;
        goto L_0x00f3;
    L_0x0146:
        r0 = r13.f22704c;
        r0 = r1 - r0;
        r2 = r9 + -2;
        if (r0 != r2) goto L_0x01b6;
    L_0x014e:
        r0 = r13.f22704c;
        if (r0 <= r3) goto L_0x01aa;
    L_0x0152:
        r0 = r13.f22708j;
        r0 = r0[r4];
        r4 = r3;
    L_0x0157:
        r0 = r0 & 255;
        r10 = r0 << 10;
        r0 = r13.f22704c;
        if (r0 <= 0) goto L_0x01b0;
    L_0x015f:
        r0 = r13.f22708j;
        r2 = r4 + 1;
        r0 = r0[r4];
        r4 = r2;
    L_0x0166:
        r0 = r0 & 255;
        r0 = r0 << 2;
        r0 = r0 | r10;
        r2 = r13.f22704c;
        r2 = r2 - r4;
        r13.f22704c = r2;
        r2 = r5 + 1;
        r4 = r0 >> 12;
        r4 = r4 & 63;
        r4 = r7[r4];
        r8[r5] = r4;
        r4 = r2 + 1;
        r5 = r0 >> 6;
        r5 = r5 & 63;
        r5 = r7[r5];
        r8[r2] = r5;
        r2 = r4 + 1;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r4] = r0;
        r0 = r13.f22705d;
        if (r0 == 0) goto L_0x01e1;
    L_0x0190:
        r0 = r2 + 1;
        r4 = 61;
        r8[r2] = r4;
    L_0x0196:
        r2 = r13.f22706e;
        if (r2 == 0) goto L_0x01a8;
    L_0x019a:
        r2 = r13.f22707f;
        if (r2 == 0) goto L_0x01a3;
    L_0x019e:
        r2 = r0 + 1;
        r8[r0] = r12;
        r0 = r2;
    L_0x01a3:
        r2 = r0 + 1;
        r8[r0] = r11;
        r0 = r2;
    L_0x01a8:
        r5 = r0;
        goto L_0x0131;
    L_0x01aa:
        r2 = r1 + 1;
        r0 = r14[r1];
        r1 = r2;
        goto L_0x0157;
    L_0x01b0:
        r2 = r1 + 1;
        r0 = r14[r1];
        r1 = r2;
        goto L_0x0166;
    L_0x01b6:
        r0 = r13.f22706e;
        if (r0 == 0) goto L_0x0131;
    L_0x01ba:
        if (r5 <= 0) goto L_0x0131;
    L_0x01bc:
        r0 = 19;
        if (r6 == r0) goto L_0x0131;
    L_0x01c0:
        r0 = r13.f22707f;
        if (r0 == 0) goto L_0x01df;
    L_0x01c4:
        r0 = r5 + 1;
        r8[r5] = r12;
    L_0x01c8:
        r5 = r0 + 1;
        r8[r0] = r11;
        goto L_0x0131;
    L_0x01ce:
        r0 = f22701g;
        if (r0 != 0) goto L_0x01da;
    L_0x01d2:
        if (r1 == r9) goto L_0x01da;
    L_0x01d4:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x01da:
        r13.b = r5;
        r13.f22709k = r6;
        return r3;
    L_0x01df:
        r0 = r5;
        goto L_0x01c8;
    L_0x01e1:
        r0 = r2;
        goto L_0x0196;
    L_0x01e3:
        r0 = r1;
        goto L_0x009b;
    L_0x01e6:
        r6 = r0;
        r5 = r1;
        r1 = r2;
        goto L_0x004d;
    L_0x01eb:
        r6 = r2;
        r5 = r0;
        goto L_0x004d;
    L_0x01ef:
        r6 = r2;
        r5 = r4;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.b.k.a(byte[], int):boolean");
    }
}
