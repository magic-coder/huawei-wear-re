package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import android.text.TextUtils;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: CommandUnpackageUtil */
public class C5000c {
    public static DataOtaParametersV2 m24022a(C4754u c4754u) {
        C2538c.c("CommandUnpackageUtil", new Object[]{"5.9.2 unGetOtaParametersV2 enter.. "});
        DataOtaParametersV2 dataOtaParametersV2 = new DataOtaParametersV2();
        List<C4752s> list = c4754u.f17337a;
        if (list != null && list.size() > 0) {
            for (C4752s c4752s : list) {
                int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
                String b = c4752s.m22733b();
                switch (parseInt) {
                    case 1:
                        dataOtaParametersV2.setAppWaitTimeout(Integer.parseInt(b, 16));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaParametersV2.setAppWaitTimeout:" + Integer.parseInt(b, 16)});
                        break;
                    case 2:
                        dataOtaParametersV2.setDeviceRestartTimeout(Integer.parseInt(b, 16));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaParametersV2.setDeviceRestartTimeout:" + Integer.parseInt(b, 16)});
                        break;
                    case 3:
                        dataOtaParametersV2.setOtaUnitSize(Integer.parseInt(b, 16));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaParametersV2.setOtaUnitSize:" + Integer.parseInt(b, 16)});
                        break;
                    case 4:
                        dataOtaParametersV2.setOtaInterval(Long.parseLong(b, 16));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaParametersV2.setOtaInterval:" + Long.parseLong(b, 16)});
                        break;
                    case 5:
                        dataOtaParametersV2.setAckEnable(Long.parseLong(b, 16));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaParametersV2.setAckEnable:" + Long.parseLong(b, 16)});
                        break;
                    default:
                        break;
                }
            }
        }
        return dataOtaParametersV2;
    }

    public static C5001d m24025b(C4754u c4754u) {
        C2538c.c("CommandUnpackageUtil", new Object[]{"5.9.3 unDeviceApply enter.. "});
        C5001d c5001d = new C5001d();
        List<C4752s> list = c4754u.f17337a;
        if (list != null && list.size() > 0) {
            for (C4752s c4752s : list) {
                int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
                String b = c4752s.m22733b();
                switch (parseInt) {
                    case 1:
                        c5001d.m24027a(Long.parseLong(b, 16));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaApplyReport.setFileOffset:" + Long.parseLong(b, 16)});
                        break;
                    case 2:
                        c5001d.m24030b(Long.parseLong(b, 16));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaApplyReport.setFileLength:" + Long.parseLong(b, 16)});
                        break;
                    case 3:
                        c5001d.m24028a(C5000c.m24024a(b));
                        C2538c.c("CommandUnpackageUtil", new Object[]{"dataOtaApplyReport.setBitmap:" + b});
                        break;
                    default:
                        break;
                }
            }
        }
        return c5001d;
    }

    public static List<Integer> m24024a(String str) {
        List<Integer> arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            C2538c.e("CommandUnpackageUtil", new Object[]{"parseAck , bitmapHex is empty"});
            return arrayList;
        }
        int i;
        byte[] b = C0973a.b(str);
        StringBuilder stringBuilder = new StringBuilder("");
        for (byte a : b) {
            stringBuilder.append(new StringBuffer(C5000c.m24023a(a)).reverse().toString());
        }
        String stringBuilder2 = stringBuilder.toString();
        C2538c.c("CommandUnpackageUtil", new Object[]{"parseAck, bufferStr = " + stringBuilder2});
        for (i = 0; i < stringBuilder2.length(); i++) {
            if ("0".equalsIgnoreCase(stringBuilder2.charAt(i) + "")) {
                arrayList.add(Integer.valueOf(0));
                C2538c.c("CommandUnpackageUtil", new Object[]{"mErrorPackages, error package_index = " + i});
            } else {
                arrayList.add(Integer.valueOf(1));
            }
        }
        return arrayList;
    }

    private static String m24023a(byte b) {
        return "" + ((byte) ((b >> 7) & 1)) + ((byte) ((b >> 6) & 1)) + ((byte) ((b >> 5) & 1)) + ((byte) ((b >> 4) & 1)) + ((byte) ((b >> 3) & 1)) + ((byte) ((b >> 2) & 1)) + ((byte) ((b >> 1) & 1)) + ((byte) ((b >> 0) & 1));
    }
}
