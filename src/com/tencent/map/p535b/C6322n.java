package com.tencent.map.p535b;

import android.os.Message;

final class C6322n extends Thread {
    private String f22029a = null;
    private String f22030b = null;
    private String f22031c = null;
    private /* synthetic */ C6313f f22032d;

    public C6322n(C6313f c6313f, String str) {
        this.f22032d = c6313f;
        this.f22029a = str;
        this.f22030b = (c6313f.f21964B == 0 ? "http://lstest.map.soso.com/loc?c=1" : "http://lbs.map.qq.com/loc?c=1") + "&mars=" + c6313f.f21984l;
    }

    private String m28990a(byte[] bArr, String str) {
        this.f22032d.f21972J = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(new String(bArr, str));
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public final void run() {
        Message message = new Message();
        message.what = 8;
        try {
            byte[] a = C6326s.m29002a(this.f22029a.getBytes());
            this.f22032d.f21986n = true;
            C6331x a2 = C6306a.m28915a(this.f22030b, "SOSO MAP LBS SDK", a);
            this.f22032d.f21986n = false;
            this.f22031c = m28990a(C6326s.m29003b(a2.f22070a), a2.f22071b);
            if (this.f22031c != null) {
                message.arg1 = 0;
                message.obj = this.f22031c;
            } else {
                message.arg1 = 1;
            }
        } catch (Exception e) {
            int i = 0;
            while (true) {
                i++;
                if (i > 3) {
                    break;
                }
                try {
                    C6322n.sleep(1000);
                    byte[] a3 = C6326s.m29002a(this.f22029a.getBytes());
                    this.f22032d.f21986n = true;
                    C6331x a4 = C6306a.m28915a(this.f22030b, "SOSO MAP LBS SDK", a3);
                    this.f22032d.f21986n = false;
                    this.f22031c = m28990a(C6326s.m29003b(a4.f22070a), a4.f22071b);
                    if (this.f22031c != null) {
                        message.arg1 = 0;
                        message.obj = this.f22031c;
                    } else {
                        message.arg1 = 1;
                    }
                } catch (Exception e2) {
                }
            }
            this.f22032d.f21986n = false;
            message.arg1 = 1;
        }
        C6313f.m28963h(this.f22032d);
        this.f22032d.f21987o.sendMessage(message);
    }
}
