package com.huawei.hihealth.data.p396c;

import android.util.SparseArray;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import org.apache.log4j.Priority;

/* compiled from: HiHealthDataType */
public class C4556c {
    private static SparseArray<int[]> f16770a = new SparseArray(4);

    static {
        f16770a.put(10001, new int[]{IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION, 2009, 2010, TradeCode.ALIPAY_ONE_KEY_SIGN, 2012, 2013, 2014, 2015});
        f16770a.put(10002, new int[]{IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION, 2018});
        f16770a.put(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE, new int[]{2016, 2017, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NOAID});
        f16770a.put(HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION, new int[]{2004, 2001});
    }

    public static int[] m21808a(int i) {
        return (int[]) f16770a.get(i);
    }

    public static C4557d m21809b(int i) {
        if (i < 1) {
            return C4557d.UNKOWN;
        }
        if (i < 10000) {
            return C4557d.POINT;
        }
        if (i < 20000) {
            return C4557d.SET;
        }
        if (i < 30000) {
            return C4557d.SESSION;
        }
        if (i < Priority.ERROR_INT) {
            return C4557d.SEQUENCE;
        }
        if (i < 50000) {
            return C4557d.STAT;
        }
        if (i < 70000) {
            return C4557d.REALTIME;
        }
        return C4557d.UNKOWN;
    }

    public static int m21811c(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                return 20001;
            case 2002:
            case 2018:
            case 2019:
            case 2020:
            case TradeCode.ALIPAY_ONE_KEY_QUERY /*2021*/:
                return i;
            default:
                return 0;
        }
    }

    public static int[] m21807a() {
        return new int[]{40011, 40012, 40013, 40031, 40032, 40033, 40034, 40041, 40042, 40043, 40044, 40021, 40022, 40023, 40024, 40005};
    }

    public static int[] m21810b() {
        return new int[]{44101, 44102, 44103, 44104, 44105, 44106, 44107, 44108, 44201, 44202, 44203, 44204, 44205, 44206, 44207, 44208};
    }
}
