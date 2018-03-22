package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p159b.C1694b;
import java.nio.charset.Charset;

/* compiled from: SendCommandUtil */
class av extends Handler {
    final /* synthetic */ as f4491a;

    public av(as asVar, Looper looper) {
        this.f4491a = asVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                byte[] byteArray = message.getData().getByteArray("command");
                int i = message.getData().getInt("version");
                C2538c.m12674b("SendCommandUtil", "handleMessage（）,message into the looper");
                C1620b c1620b = (C1620b) message.obj;
                this.f4491a.f4480f = c1620b;
                if (this.f4491a.f4481g == null || byteArray == null) {
                    String str;
                    C2538c.m12680e("SendCommandUtil", " mSendThread Is null or mData is NULL mSendThread = " + this.f4491a.f4481g);
                    String str2 = "SendCommandUtil";
                    Object[] objArr = new Object[1];
                    StringBuilder append = new StringBuilder().append(" mSendThread Is null or mData is NULL mSendThread = ").append(this.f4491a.f4481g).append(" mData =");
                    if (byteArray == null) {
                        str = "null";
                    } else {
                        str = new String(byteArray, Charset.defaultCharset());
                    }
                    objArr[0] = append.append(str).toString();
                    C2538c.m12674b(str2, objArr);
                    this.f4491a.m7991a(c1620b, 10, "");
                    return;
                }
                C1694b a = this.f4491a.f4481g.m8018a(byteArray);
                if (a == null) {
                    C2538c.m12674b("SendCommandUtil", "sycCommandResult is null");
                    this.f4491a.m7991a(c1620b, 16, "unknown error");
                    return;
                } else if (a.f4435a != 0 || a.f4436b == null) {
                    this.f4491a.m7991a(c1620b, a.f4435a, this.f4491a.m8000c(a.f4435a));
                    return;
                } else {
                    C2538c.m12674b("SendCommandUtil", "SendCommandUtil receive data is:" + C0973a.m3509a(a.f4436b));
                    this.f4491a.m7988a(a.f4436b.length, a.f4436b, i, c1620b);
                    return;
                }
            default:
                return;
        }
    }
}
