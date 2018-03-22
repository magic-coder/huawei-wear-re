package com.huawei.ui.main.stories.about.activity.developoption;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import com.huawei.bone.C6753R;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.commonui.switchbutton.CustomSwitchButton;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;

public class DevelopOptionActivity extends BaseActivity {
    private CustomSwitchButton f8348a;
    private CustomSwitchButton f8349b;
    private Button f8350c;
    private Button f8351d;
    private Handler f8352e = new Handler();
    private u f8353f;
    private u f8354g;
    private a f8355h = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_develop_option);
        m11804a();
    }

    private void m11804a() {
        boolean a = com.huawei.hwappdfxmgr.a.a(this).a();
        this.f8348a = (CustomSwitchButton) d.a(this, f.upload_log_enable);
        this.f8348a.setChecked(a);
        this.f8348a.setOnCheckedChangeListener(new C2296a(this));
        this.f8349b = (CustomSwitchButton) d.a(this, f.locat_switch_enable);
        this.f8349b.setChecked(C2538c.m12681e());
        this.f8349b.setOnCheckedChangeListener(new C2297b(this));
        this.f8350c = (Button) d.a(this, f.develop_option_back_id);
        this.f8350c.setOnClickListener(new C2298c(this));
        this.f8351d = (Button) d.a(this, f.develop_option_copy_id);
        this.f8351d.setOnClickListener(new C2299d(this));
    }

    private void m11807b() {
        C2538c.m12674b("DevelopOptionActivity", "copyLog enter");
        m11806a(getString(j.IDS_data_migration_tip));
        com.huawei.hwappdfxmgr.a.a(this).a(new C2300e(this));
    }

    protected void m11813a(int i) {
        C2538c.m12674b("DevelopOptionActivity", "showErrDialog ");
        if (this.f8353f == null) {
            C2538c.m12674b("DevelopOptionActivity", "showErrDialog000000 ");
            w wVar = new w(this);
            wVar.a(j.IDS_service_area_notice_title);
            wVar.b(i);
            wVar.a(j.IDS_settings_button_ok, new C2302g(this));
            this.f8353f = wVar.a();
            this.f8353f.setCancelable(true);
        }
        if (!isFinishing()) {
            C2538c.m12674b("DevelopOptionActivity", "showErrDialog111111 ");
            this.f8353f.show();
        }
    }

    private void m11809c() {
        if (this.f8354g == null) {
            this.f8354g = new w(this).a(j.IDS_hw_show_exit_develop_option).b(j.IDS_hw_show_exit_develop_option_title).a(j.IDS_hw_show_exit_develop_option_button, new C2304i(this)).b(j.IDS_settings_button_cancal, new C2303h(this)).a();
            this.f8354g.setCancelable(false);
        }
        if (!isFinishing()) {
            this.f8354g.show();
        }
    }

    private void m11806a(String str) {
        C2538c.m12677c("DevelopOptionActivity", "showLoadingDialog()");
        if (!isFinishing()) {
            if (this.f8355h == null) {
                a aVar = new a(this, C6753R.style.black_12sp_65alpha);
                this.f8355h = a.a(this);
                this.f8355h.a(str);
                this.f8355h.setCancelable(false);
            } else {
                this.f8355h.a(str);
            }
            if (this.f8355h != null) {
                this.f8355h.a();
                C2538c.m12677c("DevelopOptionActivity", "mLoadingUserInformationDialog.show()");
            }
        }
    }

    private void m11812d() {
        if (!isFinishing()) {
            C2538c.m12677c("DevelopOptionActivity", "enter dismissLoadingDialog()");
            if (this.f8355h != null && this.f8355h.isShowing()) {
                C2538c.m12677c("DevelopOptionActivity", "dismissLoadingDialog()!");
                this.f8355h.cancel();
                this.f8355h = null;
            }
        }
    }
}
