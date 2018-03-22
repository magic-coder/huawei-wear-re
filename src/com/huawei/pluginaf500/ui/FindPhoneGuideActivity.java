package com.huawei.pluginaf500.ui;

import android.os.Bundle;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;

public class FindPhoneGuideActivity extends AF500BaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.find_phone);
    }

    protected int mo5104a() {
        return f.act_findphone_guide;
    }

    protected void onDestroy() {
        super.onDestroy();
        d.n(this);
    }
}
