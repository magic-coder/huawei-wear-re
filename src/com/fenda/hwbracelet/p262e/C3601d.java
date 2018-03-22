package com.fenda.hwbracelet.p262e;

import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.fenda.hwbracelet.mode.C3619b;
import com.fenda.hwbracelet.mode.C3628k;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/* compiled from: XbMessageFactory */
public class C3601d extends C3599b {
    private static final C3601d f13771a = new C3601d();

    private C3601d() {
    }

    public static C3601d m18065a() {
        return f13771a;
    }

    public C3598a m18075b() {
        C3598a c3600c = new C3600c(C3602e.DATE_TIME);
        ByteBuffer a = c3600c.mo4215a();
        m18074a(a, new GregorianCalendar());
        m18066a(a);
        return c3600c;
    }

    private void m18066a(ByteBuffer byteBuffer) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("Etc/GMT+0"));
        m18074a(byteBuffer, instance);
    }

    public void m18074a(ByteBuffer byteBuffer, Calendar calendar) {
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = calendar.get(13);
        if (byteBuffer != null) {
            byteBuffer.putShort((short) i);
            byteBuffer.put((byte) i2);
            byteBuffer.put((byte) i3);
            byteBuffer.put((byte) i4);
            byteBuffer.put((byte) i5);
            byteBuffer.put((byte) i6);
        }
    }

    public C3600c m18076c() {
        C3600c c3600c = new C3600c(C3602e.APP_KEY);
        byte[] bArr = new byte["fendaxlab".length()];
        for (int i = 0; i < "fendaxlab".length(); i++) {
            bArr[i] = (byte) ("fendaxlab".charAt(i) & 255);
            char[] toChars = Character.toChars(bArr[i]);
            C2538c.b("XbMessageFactory", new Object[]{"-----" + String.valueOf(toChars[0])});
        }
        c3600c.mo4216a(bArr);
        return c3600c;
    }

    public C3598a m18070a(List<C3619b> list) {
        C3598a c3600c = new C3600c(C3602e.ALERT_ALARM);
        ByteBuffer a = c3600c.mo4215a();
        for (int i = 0; i < list.size(); i++) {
            C3619b c3619b = (C3619b) list.get(i);
            if (c3619b.f13871b > (byte) 0) {
                a.put(c3619b.f13870a);
                a.put((byte) (c3619b.f13872c / 60));
                a.put((byte) (c3619b.f13872c % 60));
                a.put(c3619b.f13873d);
            }
        }
        return c3600c;
    }

    public C3598a m18068a(C3628k c3628k) {
        C3598a c3600c = new C3600c(C3602e.ALERT_SPORT_REMINDER);
        if (c3628k.f13901a) {
            ByteBuffer a = c3600c.mo4215a();
            a.put(c3628k.f13906f);
            a.put((byte) (c3628k.f13902b / 60));
            a.put((byte) (c3628k.f13902b % 60));
            a.put(c3628k.f13907g);
            a.put((byte) (c3628k.f13903c / 60));
            a.put((byte) (c3628k.f13903c % 60));
            a.put((byte) (c3628k.f13904d / 60));
            a.put((byte) (c3628k.f13904d % 60));
            a.put((byte) (c3628k.f13905e / 60));
            a.put((byte) (c3628k.f13905e % 60));
        }
        return c3600c;
    }

    public C3598a m18067a(byte b, byte b2, byte b3, byte b4, byte b5) {
        C3598a c3600c = new C3600c(C3602e.AUTO_SLEEP_TIME);
        if (b > (byte) 0) {
            ByteBuffer a = c3600c.mo4215a();
            a.put(b2);
            a.put(b3);
            a.put(b4);
            a.put(b5);
        }
        return c3600c;
    }

    public C3600c m18071a(int i, int i2) {
        C3600c c3600c = new C3600c(C3602e.PERSONAL_PROFILE);
        ByteBuffer a = c3600c.mo4215a();
        a.put((byte) i);
        a.put((byte) i2);
        return c3600c;
    }

    public C3600c m18072a(int i, int i2, int i3) {
        C3600c c3600c = new C3600c(C3602e.PERSONAL_GOAL);
        ByteBuffer a = c3600c.mo4215a();
        a.put((byte) (i / 256));
        a.put((byte) (i % 256));
        a.put((byte) (i2 / 256));
        a.put((byte) (i2 % 256));
        a.put((byte) (i3 / 256));
        a.put((byte) (i3 % 256));
        return c3600c;
    }

    public C3600c m18077d() {
        return new C3600c(C3602e.ACTIVE_DISCONNECT);
    }

    public C3600c m18078e() {
        return new C3600c(C3602e.ALERT_LOST_PHONE);
    }

    public C3600c m18073a(boolean z) {
        if (z) {
            return new C3600c(C3602e.LOST_PHONE_ON);
        }
        return new C3600c(C3602e.LOST_PHONE_OFF);
    }

    public C3598a m18079f() {
        return m18064a(C3602e.ALERT_CALL_IDLE, "unkown");
    }

    private C3600c m18064a(C3602e c3602e, String str) {
        C3602e c3602e2 = C3602e.CHAOS;
        if (c3602e == C3602e.ALERT_CALL_IDLE || c3602e == C3602e.ALERT_CALL_OFFHOOK || c3602e == C3602e.ALERT_CALL_NUMBER || c3602e == C3602e.ALERT_CALL_RINGING) {
            c3602e2 = c3602e;
        }
        C3600c c3600c = new C3600c(c3602e2);
        if (c3602e == C3602e.ALERT_CALL_NUMBER) {
            ByteBuffer a = c3600c.mo4215a();
            if (str.equals("unkown")) {
                a.put((byte) -1);
            } else {
                try {
                    byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
                    int i = 0;
                    while (i < bytes.length) {
                        if (bytes[i] >= TagName.APK_SIZE && bytes[i] <= ScriptToolsConst.TagName.TagApdu) {
                            bytes[i] = (byte) (bytes[i] - 48);
                            a.put(bytes[i]);
                        }
                        i++;
                    }
                } catch (UnsupportedEncodingException e) {
                    a.put((byte) -1);
                } catch (BufferOverflowException e2) {
                    C2538c.b("XbMessageFactory", new Object[]{"exception  is " + e2.getMessage()});
                }
            }
        }
        return c3600c;
    }

    public C3598a m18069a(String str) {
        if (str == null || str.length() <= 2) {
            return new C3600c(C3602e.ALERT_CALL_RINGING);
        }
        return m18064a(C3602e.ALERT_CALL_NUMBER, str);
    }

    public C3598a m18080g() {
        C3598a c3600c = new C3600c(C3602e.SYNC_CONFIRM);
        c3600c.mo4215a().put(C3602e.SYNC_END.m18082a());
        return c3600c;
    }
}
