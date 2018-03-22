package cn.com.xy.sms.sdk.p208d.p211c.p212a;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3049n;

final class C2930h implements Runnable {
    private final /* synthetic */ String f9937a;
    private final /* synthetic */ String f9938b;

    C2930h(String str, String str2) {
        this.f9937a = str;
        this.f9938b = str2;
    }

    public final void run() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isuse", "1");
            if (C3049n.m13653e(this.f9937a)) {
                C2922b.m13133a("tb_public_num_info", contentValues, " num = ? ", new String[]{this.f9938b});
                return;
            }
            C2922b.m13133a("tb_public_num_info", contentValues, " num = ? and areaCode LIKE '%" + this.f9937a + "%'", new String[]{this.f9938b});
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoManager updateNumIsUse: " + th.getMessage(), th);
        }
    }
}
