package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import android.content.Context;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: CommandUnpackage */
public class C4999b {
    private static C4999b f18118b = null;
    private C4756w f18119a = new C4756w();

    private C4999b(Context context) {
    }

    public static C4999b m24006a(Context context) {
        if (f18118b == null) {
            f18118b = new C4999b(context);
        }
        return f18118b;
    }

    public int[] m24008a(byte[] bArr) throws Exception {
        C2538c.c("CommandUnpackage", new Object[]{"Enter getErrorCode()"});
        String a = a.a(bArr);
        C2538c.c("CommandUnpackage", new Object[]{"Error Code:" + C4999b.m24007a(this.f18119a.m22743a(a.substring(6, a.length())))[0]});
        return C4999b.m24007a(this.f18119a.m22743a(a.substring(6, a.length())));
    }

    public static int[] m24007a(C4754u c4754u) {
        List list = c4754u.f17337a;
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            String b = ((C4752s) list.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                case 19:
                    if (iArr.length <= 1) {
                        break;
                    }
                    iArr[1] = Integer.parseInt(b, 16);
                    break;
                case 127:
                    if (iArr.length <= 0) {
                        break;
                    }
                    iArr[0] = Integer.parseInt(b, 16);
                    break;
                default:
                    break;
            }
        }
        return iArr;
    }

    public C5003f m24010b(byte[] bArr) throws Exception {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.1查询单板是否允许升级 Enter unQueryAllow()"});
        String a = a.a(bArr);
        return m24009b(this.f18119a.m22743a(a.substring(4, a.length())));
    }

    public DataOtaParametersV2 m24012c(byte[] bArr) throws Exception {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.2获取文件传输协商参数 unGetOtaParametersV2 enter... data = " + C0973a.a(bArr)});
        String a = a.a(bArr);
        return m24011c(this.f18119a.m22743a(a.substring(4, a.length())));
    }

    public C5001d m24014d(byte[] bArr) throws Exception {
        C2538c.c("CommandUnpackage", new Object[]{"unGetOtaParametersV2 enter... data = " + C0973a.a(bArr)});
        String a = a.a(bArr);
        return m24013d(this.f18119a.m22743a(a.substring(4, a.length())));
    }

    public C5002e m24016e(byte[] bArr) throws Exception {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.5升级包大小主动上报 Enter ... data = " + C0973a.a(bArr)});
        String a = a.a(bArr);
        return m24015e(this.f18119a.m22743a(a.substring(4, a.length())));
    }

    public int m24018f(byte[] bArr) throws Exception {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.6升级包校验结果主动上报 Enter ... data = " + C0973a.a(bArr)});
        String a = a.a(bArr);
        return m24017f(this.f18119a.m22743a(a.substring(4, a.length())));
    }

    public int m24020g(byte[] bArr) throws Exception {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.7设备升级状态主动上报 Enter ... data = " + C0973a.a(bArr)});
        String a = a.a(bArr);
        return m24019g(this.f18119a.m22743a(a.substring(4, a.length())));
    }

    public C5003f m24009b(C4754u c4754u) {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.1 unQueryAllow enter.. "});
        C5003f c5003f = new C5003f();
        List<C4752s> list = c4754u.f17337a;
        if (list != null && list.size() > 0) {
            for (C4752s c4752s : list) {
                int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
                String b = c4752s.m22733b();
                switch (parseInt) {
                    case 4:
                        c5003f.m24039b(Integer.parseInt(b, 16));
                        C2538c.c("CommandUnpackage", new Object[]{"dataOtaQueryAllow.setBatteryThreshold:" + Integer.parseInt(b, 16)});
                        break;
                    case 127:
                        c5003f.m24037a(Integer.parseInt(b, 16));
                        C2538c.c("CommandUnpackage", new Object[]{"dataOtaQueryAllow.setErrorCode:" + Integer.parseInt(b, 16)});
                        break;
                    default:
                        break;
                }
            }
        }
        return c5003f;
    }

    public DataOtaParametersV2 m24011c(C4754u c4754u) {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.2 unGetOtaParametersV2 enter.. "});
        return C5000c.m24022a(c4754u);
    }

    public C5001d m24013d(C4754u c4754u) {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.3 unDeviceApply enter.. "});
        return C5000c.m24025b(c4754u);
    }

    public C5002e m24015e(C4754u c4754u) {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.5 unPackassgeSizeReport enter.. "});
        C5002e c5002e = new C5002e();
        List<C4752s> list = c4754u.f17337a;
        if (list != null && list.size() > 0) {
            for (C4752s c4752s : list) {
                int parseInt = Integer.parseInt(c4752s.m22732a(), 16);
                String b = c4752s.m22733b();
                switch (parseInt) {
                    case 1:
                        c5002e.m24033a(Long.parseLong(b, 16));
                        C2538c.c("CommandUnpackage", new Object[]{"dataOtaPackageSizeReport.setPackageValidSize:" + Long.parseLong(b, 16)});
                        break;
                    case 2:
                        c5002e.m24035b(Long.parseLong(b, 16));
                        C2538c.c("CommandUnpackage", new Object[]{"dataOtaPackageSizeReport.setReceivedFileSize:" + Long.parseLong(b, 16)});
                        break;
                    default:
                        break;
                }
            }
        }
        return c5002e;
    }

    public int m24017f(C4754u c4754u) {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.6 unCheckResultsReport enter.. "});
        C2538c.c("CommandUnpackage", new Object[]{"unCheckResultsReport :" + Integer.parseInt(((C4752s) c4754u.f17337a.get(0)).m22733b(), 16)});
        return Integer.parseInt(((C4752s) c4754u.f17337a.get(0)).m22733b(), 16);
    }

    public int m24019g(C4754u c4754u) {
        C2538c.c("CommandUnpackage", new Object[]{"5.9.7 unOTAStatus enter.. "});
        C2538c.c("CommandUnpackage", new Object[]{"unOTAStatus :" + Integer.parseInt(((C4752s) c4754u.f17337a.get(0)).m22733b(), 16)});
        return Integer.parseInt(((C4752s) c4754u.f17337a.get(0)).m22733b(), 16);
    }

    public int m24021h(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        C2538c.c("CommandUnpackage", new Object[]{"unConnectParamReport enter... info = " + a});
        C2538c.c("CommandUnpackage", new Object[]{"Interval :" + Integer.parseInt(((C4752s) this.f18119a.m22743a(a.substring(4, a.length())).f17337a.get(0)).m22733b(), 16)});
        return Integer.parseInt(((C4752s) this.f18119a.m22743a(a.substring(4, a.length())).f17337a.get(0)).m22733b(), 16);
    }
}
