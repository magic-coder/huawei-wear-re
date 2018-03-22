package com.huawei.pluginkidwatch.common.ui.p150a;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* compiled from: CalendarUtil */
public class C1505f {
    private static C1505f f3516b;
    private Calendar f3517a = Calendar.getInstance();

    public static C1505f m6969a() {
        if (f3516b == null) {
            f3516b = new C1505f();
        }
        return f3516b;
    }

    public List<Date> m6971a(Date date, int i) {
        Date c = m6975c(date, i);
        Date d = m6976d(date, i + 1);
        List<Date> arrayList = new ArrayList();
        for (int i2 = 0; i2 < m6970a(c); i2++) {
            arrayList.add(null);
        }
        Date date2 = c;
        while (!date2.after(d)) {
            arrayList.add(date2);
            date2 = m6974c(date2);
        }
        return arrayList;
    }

    public Date m6973b(Date date, int i) {
        this.f3517a.setTime(date);
        this.f3517a.add(2, i);
        return this.f3517a.getTime();
    }

    public int m6970a(Date date) {
        this.f3517a.setTime(date);
        return this.f3517a.get(7) - 1;
    }

    public Date m6975c(Date date, int i) {
        this.f3517a.setTime(date);
        this.f3517a.add(2, i);
        this.f3517a.add(5, 1 - this.f3517a.get(5));
        return this.f3517a.getTime();
    }

    public Date m6972b(Date date) {
        return m6976d(date, 1);
    }

    public Date m6976d(Date date, int i) {
        this.f3517a.setTime(date);
        this.f3517a.add(2, i);
        this.f3517a.add(5, -this.f3517a.get(5));
        return this.f3517a.getTime();
    }

    public Date m6974c(Date date) {
        this.f3517a.setTime(date);
        this.f3517a.add(5, 1);
        return this.f3517a.getTime();
    }
}
