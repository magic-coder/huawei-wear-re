package cn.com.xy.sms.sdk.p208d.p211c;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.List;

final class C2936c implements C2904g {
    private final /* synthetic */ List f9963a;
    private final /* synthetic */ C2937d f9964b;

    C2936c(List list, C2937d c2937d) {
        this.f9963a = list;
        this.f9964b = c2937d;
    }

    public final void execute(Object... objArr) {
        try {
            C2922b.m13134a("tb_update_task", "id IN (" + C2934a.m13208b(this.f9963a) + ")", null);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "UpdateTaskManager deleTaskByTid(String taskIds): " + th.getMessage(), th);
        }
        C2934a.m13204a(this.f9964b);
    }
}
