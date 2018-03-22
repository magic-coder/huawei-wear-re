package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p208d.p211c.ah;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import java.util.ArrayList;
import java.util.List;

public final class C2932j {
    public static long m13196a(String str, String str2, String str3, String str4) {
        long j = -1;
        C2962e c2962e = null;
        if (C3049n.m13653e(str) || C3049n.m13653e(str2) || C3049n.m13653e(str3)) {
            return j;
        }
        try {
            c2962e = C2922b.m13139a("tb_shard_data", new String[]{str}, "num=? AND encode_content=? ", new String[]{str, str2});
            if (c2962e != null && c2962e.m13323a() > 0) {
                return 0;
            }
            j = C2922b.m13135a("tb_shard_data", C2921a.m13130a(null, Constants.FIELD_APPLET_CONFIG_NUM, str, "encode_content", str2, "content_sign", str3, "msg_time", str4));
            C2962e.m13322a(c2962e, true);
            return j;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ShardDataManager insert error:" + th.getMessage(), th);
            return j;
        } finally {
            C2962e.m13322a(c2962e, true);
        }
    }

    public static long m13197a(List<String> list, C2933k c2933k) {
        try {
            int size = list.size();
            return (long) C2922b.m13133a("tb_shard_data", C2921a.m13130a(null, "status", c2933k.toString()), "content_sign IN(" + ah.m13243a(size) + ")", (String[]) list.toArray(new String[size]));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ShardDataManager updateStatusByContentSign(List<String> contentSigns, RequestStatus status) error:" + th.getMessage(), th);
            return -1;
        }
    }

    public static List<C2931i> m13198a(String str, String[] strArr, int i) {
        C2962e a;
        Throwable th;
        try {
            a = C2922b.m13141a(false, "tb_shard_data", new String[]{"id", Constants.FIELD_APPLET_CONFIG_NUM, "encode_content", "content_sign", "status", "msg_time"}, str, strArr, null, null, null, String.valueOf(i));
            if (a != null) {
                try {
                    if (a.m13323a() != 0) {
                        List<C2931i> arrayList = new ArrayList();
                        while (a.m13327b()) {
                            C2931i c2931i = new C2931i();
                            a.m13324a(a.m13325a("id"));
                            a.m13328c(a.m13325a(Constants.FIELD_APPLET_CONFIG_NUM));
                            c2931i.f9939a = a.m13328c(a.m13325a("encode_content"));
                            c2931i.f9940b = a.m13328c(a.m13325a("content_sign"));
                            a.m13324a(a.m13325a("status"));
                            a.m13326b(a.m13325a("msg_time"));
                            arrayList.add(c2931i);
                        }
                        C2962e.m13322a(a, true);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C2962e.m13322a(a, true);
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
    }
}
