package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;

/* compiled from: SetKidWatchNumActivity */
class cc implements C1378e {
    final /* synthetic */ SetKidWatchNumActivity f6655a;

    cc(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6655a = setKidWatchNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b(this.f6655a.f6500b, "============设置手表电话返回 errorCode：" + baseEntityModel.retCode);
        if (baseEntityModel.retCode == 0) {
            if (this.f6655a.f6517s) {
                this.f6655a.m10031a(this.f6655a.f6516r);
                Intent intent = new Intent();
                intent.putExtra("in_guide", true);
                intent.setClass(this.f6655a.f6504f, ProfileSettingActivity.class);
                this.f6655a.m10035d();
                this.f6655a.m10037e();
                this.f6655a.startActivity(intent);
            } else {
                C1395k k = C1462f.m6748k();
                k.f3093m = this.f6655a.f6503e.getText().toString();
                C1462f.m6718a(k);
                C1392h.m6287a(this.f6655a.f6504f, C1462f.m6744i(), k, false);
                C2538c.m12674b(this.f6655a.f6500b, "=====HOME_ENTER_ADD_DEVICE_FROM_SETTING true==== curDeviceInfo = " + C1462f.m6748k() + ", table.SimCardNum = " + k.f3093m);
            }
            this.f6655a.finish();
            return;
        }
        this.f6655a.f6506h.setClickable(true);
        this.f6655a.f6505g.setText("");
        C1483c.m6824a(this.f6655a, C1680l.IDS_plugin_kidwatch_settings_verification_code_fail);
        this.f6655a.m10028a(-1);
    }
}
