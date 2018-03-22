package cn.com.xy.sms.sdk.p208d.p211c;

import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p215g.C2982a;

final class C2935b implements C2904g {
    private final /* synthetic */ ai f9962a;

    C2935b(ai aiVar) {
        this.f9962a = aiVar;
    }

    public final void execute(Object... objArr) {
        try {
            C2922b.m13134a("tb_update_task", "id = ?", new String[]{String.valueOf(this.f9962a.f9959b)});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "UpdateTaskManager deleTaskByTid(long tid): " + th.getMessage(), th);
        }
        C2934a.m13204a(C2937d.UPDATE_PUBINFO);
    }
}
