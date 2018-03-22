package com.huawei.android.pushagent.p020b.p328d.p329a;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

public class C4085a implements C4084b {
    public long f15459a;
    public long f15460b;
    public long f15461c;
    public long f15462d;

    public C4085a(long j, long j2) {
        this.f15459a = j;
        this.f15460b = j2;
        this.f15461c = 0;
        this.f15462d = 0;
    }

    public String mo4375a() {
        String str = ";";
        return new StringBuffer().append(4).append(str).append(this.f15459a).append(str).append(this.f15460b).append(str).append(this.f15461c).append(str).append(this.f15462d).toString();
    }

    public boolean mo4376a(long j) {
        e.a("PushLogAC2712", "enter FlowSimpleControl::canApply(num:" + j + ", curVol:" + this.f15461c + ", maxVol:" + this.f15460b + ")");
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (valueOf.longValue() < this.f15462d || valueOf.longValue() - this.f15462d >= this.f15459a) {
            e.a("PushLogAC2712", " fistrControlTime:" + new Date(this.f15462d) + " interval:" + (valueOf.longValue() - this.f15462d) + " statInterval:" + this.f15459a + " change fistrControlTime to cur");
            this.f15462d = valueOf.longValue();
            this.f15461c = 0;
        } else {
            try {
                Calendar instance = Calendar.getInstance(Locale.getDefault());
                instance.setTimeInMillis(this.f15462d);
                int i = instance.get(2);
                instance.setTimeInMillis(valueOf.longValue());
                if (i != instance.get(2)) {
                    this.f15462d = valueOf.longValue();
                    this.f15461c = 0;
                }
            } catch (Throwable e) {
                e.c("PushLogAC2712", e.toString(), e);
            } catch (Throwable e2) {
                e.c("PushLogAC2712", e2.toString(), e2);
            } catch (Throwable e22) {
                e.c("PushLogAC2712", e22.toString(), e22);
            }
        }
        return this.f15461c + j <= this.f15460b;
    }

    public boolean mo4377a(C4084b c4084b) {
        if (!(c4084b instanceof C4085a)) {
            return false;
        }
        C4085a c4085a = (C4085a) c4084b;
        return this.f15459a == c4085a.f15459a && this.f15460b == c4085a.f15460b;
    }

    public boolean m20041a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                e.b("PushLogAC2712", "in loadFromString, info is empty!");
                return false;
            }
            e.a("PushLogAC2712", "begin to parse:" + str);
            String[] split = str.split(";");
            if (split.length == 0) {
                return false;
            }
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 4 && parseInt == split.length - 1) {
                this.f15459a = Long.parseLong(split[1]);
                this.f15460b = Long.parseLong(split[2]);
                this.f15461c = Long.parseLong(split[3]);
                this.f15462d = Long.parseLong(split[4]);
                return true;
            }
            e.d("PushLogAC2712", "in fileNum:" + parseInt + ", but need " + 4 + " parse " + str + " failed");
            return false;
        } catch (PatternSyntaxException e) {
            return false;
        } catch (NumberFormatException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        }
    }

    public boolean mo4378b(long j) {
        this.f15461c += j;
        return true;
    }
}
