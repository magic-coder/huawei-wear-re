package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;

/* compiled from: AddContactActivity */
class C1875q extends AsyncTask<String, Void, String> {
    final /* synthetic */ AddContactActivity f6180a;

    C1875q(AddContactActivity addContactActivity) {
        this.f6180a = addContactActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9635a((String[]) objArr);
    }

    protected String m9635a(String... strArr) {
        String a;
        Exception e;
        String str = "";
        try {
            a = C1906x.m9697a(this.f6180a.getApplicationContext());
            try {
                C2538c.m12674b("AddContactActivity", "==ww== 第一步：获取大头像result， getuploadinfo response = " + a);
                int a2 = C1906x.m9693a(a, this.f6180a.f5415z, 1, this.f6180a.f5413x, this.f6180a);
                this.f6180a.f5411v = C1906x.m9703b();
                if (200 == a2) {
                    C2538c.m12674b("AddContactActivity", "==ww== 第二步 解析第一次获取的 result success  codeParsh=" + a2);
                    str = "";
                    str = C1906x.m9697a(this.f6180a.getApplicationContext());
                    C2538c.m12674b("AddContactActivity", "==ww== 第三步：获取小头像result ， response = " + str);
                    int a3 = C1906x.m9693a(str, this.f6180a.f5415z, 2, this.f6180a.f5413x, this.f6180a);
                    this.f6180a.f5410u = C1906x.m9696a();
                    if (200 == a3) {
                        C2538c.m12674b("AddContactActivity", "==ww== 第四步 解析第二次获取的result success  samllParshCode=" + a3);
                        this.f6180a.f5412w.sendEmptyMessage(5);
                        C2538c.m12674b("AddContactActivity", "==ww== 第五步 发送添加联系人handler");
                    } else {
                        a2 = C1906x.m9693a(str, this.f6180a.f5415z, 2, this.f6180a.f5413x, this.f6180a);
                        this.f6180a.f5410u = C1906x.m9696a();
                        if (200 == a2) {
                            this.f6180a.f5412w.sendEmptyMessage(5);
                            C2538c.m12674b("AddContactActivity", "==ww== 第二次上传小头像成功 发送添加联系人handler");
                        } else {
                            C2538c.m12674b("AddContactActivity", "==ww== 第二次上传小头像 失败 result error  samllParshCode=" + a2);
                            this.f6180a.f5412w.sendEmptyMessage(56);
                        }
                    }
                } else {
                    a2 = C1906x.m9693a(a, this.f6180a.f5415z, 1, this.f6180a.f5413x, this.f6180a);
                    this.f6180a.f5411v = C1906x.m9703b();
                    if (200 == a2) {
                        C2538c.m12674b("AddContactActivity", "==ww== 第二次上传大头像头功， response = " + a2);
                        str = "";
                        a2 = C1906x.m9693a(C1906x.m9697a(this.f6180a.getApplicationContext()), this.f6180a.f5415z, 2, this.f6180a.f5413x, this.f6180a);
                        this.f6180a.f5410u = C1906x.m9696a();
                        if (200 == a2) {
                            this.f6180a.f5412w.sendEmptyMessage(5);
                            C2538c.m12674b("AddContactActivity", "==ww== 大头像第二次成功后 第一次上传小头像成功 发送添加联系人handler");
                        } else {
                            C2538c.m12674b("AddContactActivity", "==ww== 大头像第二次成功后 第一次上传小头像失败 result error  samllParshCode=" + a2);
                            this.f6180a.f5412w.sendEmptyMessage(56);
                        }
                    } else {
                        C2538c.m12674b("AddContactActivity", "==ww== 第二次上传大头像失败 result error  codeParsh=" + a2);
                        this.f6180a.f5412w.sendEmptyMessage(56);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                C2538c.m12680e("AddContactActivity", "==ww==  upload error IOException e = " + e.getMessage());
                this.f6180a.f5412w.sendEmptyMessage(56);
                return a;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            a = str;
            e = exception;
            C2538c.m12680e("AddContactActivity", "==ww==  upload error IOException e = " + e.getMessage());
            this.f6180a.f5412w.sendEmptyMessage(56);
            return a;
        }
        return a;
    }
}
