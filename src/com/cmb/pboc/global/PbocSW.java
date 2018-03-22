package com.cmb.pboc.global;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

public class PbocSW {
    public static final byte[] f13419a;
    public static final byte[] f13420b = new byte[]{TagName.PAY_ORDER_ID, TagName.ACTIVITY_NAME};
    public static final byte[] f13421c;

    static {
        byte[] bArr = new byte[2];
        bArr[0] = TagName.SYSTEM_VERSION;
        f13419a = bArr;
        bArr = new byte[2];
        bArr[0] = TagName.MAIN_ORDER_LIST;
        f13421c = bArr;
    }
}
