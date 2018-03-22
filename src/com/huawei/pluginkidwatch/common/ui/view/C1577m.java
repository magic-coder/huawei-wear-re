package com.huawei.pluginkidwatch.common.ui.view;

import com.huawei.pluginkidwatch.common.ui.p150a.C1505f;
import java.util.Date;
import java.util.List;

/* compiled from: CalendarView */
class C1577m {
    public C1505f f3906a = C1505f.m6969a();
    public Date f3907b;
    public List<Date> f3908c;
    public List<Date> f3909d;

    public C1577m(Date date, List<Date> list) {
        this.f3907b = date;
        this.f3908c = list;
        this.f3909d = m7272a(0);
    }

    public boolean m7273a(Date date) {
        if (this.f3908c == null || date == null) {
            return false;
        }
        for (int i = 0; i < this.f3908c.size(); i++) {
            if (date.equals(this.f3908c.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean m7274b(Date date) {
        return date.after(new Date());
    }

    public List<Date> m7272a(int i) {
        return this.f3906a.m6971a(this.f3907b, i);
    }
}
