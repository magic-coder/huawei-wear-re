package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;

/* compiled from: TailorContactActivity */
class gi extends AsyncTask<String, Void, String> {
    final /* synthetic */ gh f6152a;

    gi(gh ghVar) {
        this.f6152a = ghVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9631a((String[]) objArr);
    }

    protected String m9631a(String... strArr) {
        String str = "";
        try {
            str = C1906x.m9697a(this.f6152a.f6151a.getApplicationContext());
            C2538c.m12674b("TailorContactActivity", "==ww== 第一步：获取大头像result， getuploadinfo response = " + str);
            int a = C1906x.m9693a(str, this.f6152a.f6151a.f5880F, 1, this.f6152a.f6151a.f5878D, this.f6152a.f6151a);
            this.f6152a.f6151a.f5876B = C1906x.m9703b();
            String str2;
            int a2;
            if (200 == a) {
                C2538c.m12674b("TailorContactActivity", "==ww== 第二步 解析第一次获取的 result success  codeBig=" + a);
                str2 = "";
                str2 = C1906x.m9697a(this.f6152a.f6151a.getApplicationContext());
                C2538c.m12674b("TailorContactActivity", "==ww== 第三步：获取小头像result ， response = " + str2);
                a2 = C1906x.m9693a(str2, this.f6152a.f6151a.f5880F, 2, this.f6152a.f6151a.f5878D, this.f6152a.f6151a);
                this.f6152a.f6151a.f5875A = C1906x.m9696a();
                if (200 == a2) {
                    C2538c.m12674b("TailorContactActivity", "==ww== 第四步 解析第二次获取的result success  codeSmall=" + a2);
                    this.f6152a.f6151a.f5877C.sendEmptyMessage(11);
                    C2538c.m12674b("TailorContactActivity", "==ww== 第五步 发送添加联系人handler");
                    return str;
                }
                a = C1906x.m9693a(str2, this.f6152a.f6151a.f5880F, 2, this.f6152a.f6151a.f5878D, this.f6152a.f6151a);
                this.f6152a.f6151a.f5875A = C1906x.m9696a();
                if (200 == a) {
                    this.f6152a.f6151a.f5877C.sendEmptyMessage(11);
                    C2538c.m12674b("TailorContactActivity", "==ww== 第二次上传小头像成功 发送添加联系人handler");
                    return str;
                }
                C2538c.m12674b("TailorContactActivity", "==ww== 第二次上传小头失败result error  codeSmall=" + a);
                this.f6152a.f6151a.f5877C.sendEmptyMessage(56);
                return str;
            }
            a2 = C1906x.m9693a(str, this.f6152a.f6151a.f5880F, 1, this.f6152a.f6151a.f5878D, this.f6152a.f6151a);
            this.f6152a.f6151a.f5876B = C1906x.m9703b();
            if (200 == a2) {
                C2538c.m12674b("TailorContactActivity", "==ww== 第二步 解析第一次获取的 result success  codeBig=" + a);
                str2 = "";
                a = C1906x.m9693a(C1906x.m9697a(this.f6152a.f6151a.getApplicationContext()), this.f6152a.f6151a.f5880F, 2, this.f6152a.f6151a.f5878D, this.f6152a.f6151a);
                this.f6152a.f6151a.f5875A = C1906x.m9696a();
                if (200 == a) {
                    this.f6152a.f6151a.f5877C.sendEmptyMessage(11);
                    C2538c.m12674b("TailorContactActivity", "==ww== 第二次上传大头像成功后，上传小头像成功  发送添加联系人handler");
                    return str;
                }
                C2538c.m12674b("TailorContactActivity", "==ww== 第二次上传大头像成功后，上传小头像失败result error  codeSmall=" + a);
                this.f6152a.f6151a.f5877C.sendEmptyMessage(56);
                return str;
            }
            C2538c.m12674b("TailorContactActivity", "==ww== 第二次上传大头像 失败result error  codeBig=" + a2);
            this.f6152a.f6151a.f5877C.sendEmptyMessage(56);
            return str;
        } catch (Exception e) {
            this.f6152a.f6151a.f5877C.sendEmptyMessage(56);
            C2538c.m12680e("TailorContactActivity", "==ww==  Exceptioncatch e = " + e.getMessage());
            return "";
        }
    }
}
