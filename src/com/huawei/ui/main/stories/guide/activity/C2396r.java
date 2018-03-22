package com.huawei.ui.main.stories.guide.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.main.j;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: BasicInfoSettingActivity */
class C2396r implements OnClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8664a;

    C2396r(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8664a = basicInfoSettingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Date parse;
        Date parse2;
        ParseException e;
        C2538c.m12677c("BasicInfoSettingActivity", "同意更改birthday");
        String fisrtPickerValue = this.f8664a.f8576C.getFisrtPickerValue();
        String secondPickerValue = this.f8664a.f8576C.getSecondPickerValue();
        String thirdPickerValue = this.f8664a.f8576C.getThirdPickerValue();
        if (1 == secondPickerValue.length()) {
            secondPickerValue = "0" + secondPickerValue;
        }
        if (1 == thirdPickerValue.length()) {
            thirdPickerValue = "0" + thirdPickerValue;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "birthday = " + (fisrtPickerValue + secondPickerValue + thirdPickerValue));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            parse = simpleDateFormat.parse(fisrtPickerValue + secondPickerValue + thirdPickerValue);
            try {
                parse2 = simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis())));
            } catch (ParseException e2) {
                e = e2;
                C2538c.m12677c("BasicInfoSettingActivity", "ParseException = " + e.getMessage());
                parse2 = null;
                if (parse != null) {
                }
                this.f8664a.m12036K();
                if (this.f8664a.f8616v != null) {
                    this.f8664a.f8616v.dismiss();
                    this.f8664a.f8616v = null;
                    return;
                }
                C2538c.m12677c("BasicInfoSettingActivity", "同意更改birthday mSettingBirthDialog is null");
            }
        } catch (ParseException e3) {
            e = e3;
            parse = null;
            C2538c.m12677c("BasicInfoSettingActivity", "ParseException = " + e.getMessage());
            parse2 = null;
            if (parse != null) {
            }
            this.f8664a.m12036K();
            if (this.f8664a.f8616v != null) {
                C2538c.m12677c("BasicInfoSettingActivity", "同意更改birthday mSettingBirthDialog is null");
            }
            this.f8664a.f8616v.dismiss();
            this.f8664a.f8616v = null;
            return;
        }
        if (parse != null || parse2 == null) {
            this.f8664a.m12036K();
        } else {
            C2538c.m12677c("BasicInfoSettingActivity", "setDate.getTime() = " + parse.getTime() + " localDate.getTime() = " + parse2.getTime());
            if (parse.getTime() <= parse2.getTime()) {
                this.f8664a.m12036K();
            } else {
                a.a(this.f8664a.f8596a, j.IDS_date_not_pair);
            }
        }
        if (this.f8664a.f8616v != null) {
            this.f8664a.f8616v.dismiss();
            this.f8664a.f8616v = null;
            return;
        }
        C2538c.m12677c("BasicInfoSettingActivity", "同意更改birthday mSettingBirthDialog is null");
    }
}
