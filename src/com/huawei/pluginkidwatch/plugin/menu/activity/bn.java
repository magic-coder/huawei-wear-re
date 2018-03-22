package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;

/* compiled from: ContactInfoActivity */
class bn extends AsyncTask<String, Void, String> {
    final /* synthetic */ ContactInfoActivity f5972a;

    bn(ContactInfoActivity contactInfoActivity) {
        this.f5972a = contactInfoActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9582a((String[]) objArr);
    }

    protected String m9582a(String... strArr) {
        String str = "";
        try {
            str = C1906x.m9697a(this.f5972a.getApplicationContext());
            int a = C1906x.m9693a(str, this.f5972a.f5532E, 1, this.f5972a.f5534G, this.f5972a);
            this.f5972a.f5574x = C1906x.m9703b();
            this.f5972a.f5533F.bigHeadIcon = this.f5972a.f5574x;
            String str2;
            if (200 == a) {
                C2538c.m12674b("ContactInfoActivity", "==ww==  第一次上传大头像成功 ");
                str2 = "";
                str2 = C1906x.m9697a(this.f5972a.getApplicationContext());
                int a2 = C1906x.m9693a(str2, this.f5972a.f5532E, 2, this.f5972a.f5534G, this.f5972a);
                this.f5972a.f5540M = C1906x.m9696a();
                this.f5972a.f5533F.headIcon = this.f5972a.f5540M;
                if (200 == a2) {
                    C2538c.m12674b("ContactInfoActivity", "==ww==  第一次上传小头像成功 ");
                    this.f5972a.f5536I.sendEmptyMessage(5);
                    return str;
                }
                a = C1906x.m9693a(str2, this.f5972a.f5532E, 2, this.f5972a.f5534G, this.f5972a);
                this.f5972a.f5540M = C1906x.m9696a();
                this.f5972a.f5533F.headIcon = this.f5972a.f5540M;
                if (200 == a) {
                    C2538c.m12674b("ContactInfoActivity", "==ww==  第二次上传小头像成功 ");
                    this.f5972a.f5536I.sendEmptyMessage(5);
                    return str;
                }
                C2538c.m12674b("ContactInfoActivity", "==ww==  第二次上传小头像失败  codeSmall400=" + a);
                this.f5972a.f5536I.sendEmptyMessage(56);
                return str;
            }
            a = C1906x.m9693a(str, this.f5972a.f5532E, 1, this.f5972a.f5534G, this.f5972a);
            this.f5972a.f5574x = C1906x.m9703b();
            this.f5972a.f5533F.bigHeadIcon = this.f5972a.f5574x;
            if (200 == a) {
                C2538c.m12674b("ContactInfoActivity", "==ww==  第二次上传大头像成功 ");
                str2 = "";
                a = C1906x.m9693a(C1906x.m9697a(this.f5972a.getApplicationContext()), this.f5972a.f5532E, 2, this.f5972a.f5534G, this.f5972a);
                this.f5972a.f5540M = C1906x.m9696a();
                this.f5972a.f5533F.headIcon = this.f5972a.f5540M;
                if (200 == a) {
                    C2538c.m12674b("ContactInfoActivity", "==ww==   第二次上传大头像成功，上传小头像成功 ");
                    this.f5972a.f5536I.sendEmptyMessage(5);
                    return str;
                }
                C2538c.m12674b("ContactInfoActivity", "==ww==   第二次上传大头像成功，上传小头像失败 codeSmall = " + a);
                this.f5972a.f5536I.sendEmptyMessage(56);
                return str;
            }
            C2538c.m12674b("ContactInfoActivity", "==ww==  第二次上传大头像失败 codeBig400 = " + a);
            this.f5972a.f5536I.sendEmptyMessage(56);
            return str;
        } catch (Exception e) {
            C2538c.m12680e("ContactInfoActivity", "==ww==  +executeGet  catch");
            this.f5972a.f5536I.sendEmptyMessage(56);
            C2538c.m12680e("ContactInfoActivity", "IOException e = " + e.getMessage());
            return "";
        }
    }
}
