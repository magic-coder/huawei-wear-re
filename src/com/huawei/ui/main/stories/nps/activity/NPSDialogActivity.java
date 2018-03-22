package com.huawei.ui.main.stories.nps.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.k;

public class NPSDialogActivity extends Activity {
    private static final String f8718a = NPSDialogActivity.class.getSimpleName();
    private C2426a f8719b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_nps_dialog);
        this.f8719b = C2426a.m12202a();
        Window window = getWindow();
        window.setGravity(80);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        window.setWindowAnimations(k.track_dialog_anim);
        m12178a();
    }

    private void m12178a() {
        ((TextView) d.a(this, f.nps_tv_dialog_title)).setText(this.f8719b.m12205b());
        C2538c.m12674b(f8718a, "content = " + this.f8719b.m12208c());
        ((TextView) d.a(this, f.nps_tv_dialog_message)).setText(this.f8719b.m12208c());
        Button button = (Button) d.a(this, f.nps_btn_dialog_positive);
        button.setText(this.f8719b.m12209d());
        button.setOnClickListener(new C2430e(this));
        button = (Button) d.a(this, f.nps_btn_dialog_negative);
        button.setText(this.f8719b.m12211f());
        button.setOnClickListener(new C2429d(this));
    }
}
