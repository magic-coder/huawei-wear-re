package com.huawei.ui.main.stories.guide.activity;

import com.huawei.p190v.C2538c;
import java.io.File;
import java.io.IOException;

/* compiled from: BasicInfoSettingActivity */
class C2402x implements Runnable {
    final /* synthetic */ String f8670a;
    final /* synthetic */ BasicInfoSettingActivity f8671b;

    C2402x(BasicInfoSettingActivity basicInfoSettingActivity, String str) {
        this.f8671b = basicInfoSettingActivity;
        this.f8670a = str;
    }

    public void run() {
        this.f8671b.f8579F = this.f8670a + this.f8671b.f8578E.substring(this.f8671b.f8578E.lastIndexOf(File.separator) + 1);
        C2538c.m12674b("BasicInfoSettingActivity", "onCorpComplete() Thread mHeadPicFilePath =" + this.f8671b.f8579F);
        try {
            new File(this.f8671b.f8579F).createNewFile();
        } catch (IOException e) {
            C2538c.m12680e("BasicInfoSettingActivity", "onCorpComplete() Thread Exception e = " + e.getMessage());
        }
        this.f8671b.m12055a(new File(this.f8670a), new File(this.f8671b.f8579F));
        C2538c.m12677c("BasicInfoSettingActivity", "onCorpComplete() Thread mHeadPicFilePath=" + this.f8671b.f8579F);
        this.f8671b.f8581H.setPicPath(this.f8671b.f8579F);
        this.f8671b.f8592T.sendEmptyMessage(5);
    }
}
