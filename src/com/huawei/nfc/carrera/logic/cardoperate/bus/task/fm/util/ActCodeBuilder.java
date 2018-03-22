package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.util;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import com.huawei.nfc.carrera.constant.Constant;

public class ActCodeBuilder extends ServiceCodeBuilder {
    private static final String DISCOUNT_ACT_NO = "0300000400100023";
    private String actNo;
    private int discountIssueMoney;
    private String mAid;
    private int stdIssueMoney;
    private int totalMoney;

    public ActCodeBuilder(Context context, String str) {
        super(context);
        this.actNo = str;
    }

    public ActCodeBuilder(Context context, String str, int i, int i2, int i3, String str2) {
        super(context);
        this.actNo = str;
        this.totalMoney = i;
        this.stdIssueMoney = i2;
        this.discountIssueMoney = i3;
        this.mAid = str2;
    }

    protected String getServiceNo(int i) {
        return this.actNo;
    }

    protected byte[] getServiceData(String str) {
        byte[] join = FM_Bytes.join(new byte[]{(byte) 2, (byte) 3}, FM_CN.intToBcdBytes(this.totalMoney, 3));
        byte[] join2 = FM_Bytes.join(new byte[]{(byte) 8, (byte) 3}, FM_CN.intToBcdBytes(this.stdIssueMoney - this.discountIssueMoney, 3));
        byte[] bArr = new byte[]{(byte) 9, (byte) 14};
        byte[] join3 = FM_Bytes.join(new byte[]{TagName.THIRD_PAY_NUMBER, (byte) 1}, FM_CN.intToBcdBytes(89, 1));
        byte[] join4 = FM_Bytes.join(new byte[]{TagName.ORDER_INVOICE_STATUS, (byte) 1}, FM_CN.intToBcdBytes(70, 1));
        byte[] bArr2 = new byte[]{(byte) 33, (byte) 1};
        if (str.equals(Constant.LNT_CARD_AID)) {
            bArr2 = FM_Bytes.join(bArr2, FM_CN.intToBcdBytes(2, 1));
        } else {
            bArr2 = FM_Bytes.join(bArr2, FM_CN.intToBcdBytes(1, 1));
        }
        return FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(FM_Bytes.join(join, join2), join3), join4), bArr2), bArr);
    }
}
