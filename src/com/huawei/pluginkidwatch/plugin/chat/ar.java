package com.huawei.pluginkidwatch.plugin.chat;

import android.os.Looper;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1484d;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1745b;

/* compiled from: ChatActivity */
class ar extends Thread {
    final /* synthetic */ ChatActivity f4823a;
    private C1744a f4824b;

    public ar(ChatActivity chatActivity, C1744a c1744a) {
        this.f4823a = chatActivity;
        this.f4824b = c1744a;
    }

    public void run() {
        Looper.prepare();
        try {
            C2538c.m12674b("ChatActivity", "=======Enter UploadThread run");
            if (this.f4824b == null) {
                C2538c.m12674b("ChatActivity", "=======mModal is null,return");
                return;
            }
            C1745b c1745b = new C1745b(this.f4823a.f4709Q);
            String a = c1745b.m8478a();
            C2538c.m12674b("ChatActivity", "UploadThread query ret = " + a);
            C2538c.m12674b("ChatActivity", "UploadThread query downLoadUrl = " + (c1745b.m8483b(a) + this.f4824b.f4767b.substring(this.f4824b.f4767b.lastIndexOf("/"))));
            String a2 = C1484d.m6837a(16);
            String a3 = C1484d.m6837a(16);
            C2538c.m12674b("ChatActivity", "=======key " + a2.length());
            C2538c.m12674b("ChatActivity", "=======iv " + a2.length());
            C2538c.m12674b("ChatActivity", "UploadThread query downLoadUrl = " + r2);
            if (c1745b.m8482a(a, this.f4824b.f4767b, a2, a3)) {
                C2538c.m12674b("ChatActivity", "========上传到网盘成功，向云发送消息");
                if (this.f4823a.isFinishing()) {
                    C2538c.m12674b("ChatActivity", "=====saveVoiceToCloudResult isFinishing ");
                } else {
                    this.f4823a.m8384a(r2, a2, a3, this.f4824b);
                }
                Looper.loop();
            }
            this.f4823a.m8383a(this.f4824b, 1);
            this.f4823a.ay.sendEmptyMessage(1004);
            Looper.loop();
        } catch (Exception e) {
            C2538c.m12674b("ChatActivity", "=======Exception  e:" + e.getMessage());
            this.f4823a.ay.sendEmptyMessage(1004);
            this.f4823a.m8383a(this.f4824b, 1);
        }
    }
}
