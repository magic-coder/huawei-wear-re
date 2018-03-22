package com.huawei.bone.root;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.bone.C6753R;
import com.huawei.bone.p552b.C6756a;
import com.huawei.p190v.C2538c;

public class STTimeoutActivity extends Activity {
    private static final String f23251f = STTimeoutActivity.class.getSimpleName();
    public boolean f23252a = false;
    public boolean f23253b = false;
    public int f23254c = 0;
    Class<?> f23255d = MainActivity.class;
    final C6756a f23256e = new C6756a();
    private int f23257g = 2;
    private Button f23258h;
    private Button f23259i;
    private TextView f23260j;
    private boolean f23261k = false;
    private Context f23262l = null;
    private boolean f23263m = false;
    private Handler f23264n = new C6806y(this);
    private LocalBroadcastManager f23265o = null;
    private final BroadcastReceiver f23266p = new C6807z(this);

    protected void onCreate(Bundle bundle) {
        C2538c.c(f23251f, new Object[]{"onCreate()"});
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        this.f23262l = this;
        this.f23265o = LocalBroadcastManager.getInstance(this.f23262l.getApplicationContext());
        m30159c();
        m30158b();
    }

    private void m30158b() {
        m30161e();
    }

    private void m30159c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("hwid_finish");
        if (this.f23265o != null) {
            this.f23265o.registerReceiver(this.f23266p, intentFilter);
        }
    }

    private void m30160d() {
        try {
            this.f23265o.unregisterReceiver(this.f23266p);
        } catch (IllegalArgumentException e) {
            C2538c.c(f23251f, new Object[]{e.getMessage()});
        } catch (RuntimeException e2) {
            C2538c.c(f23251f, new Object[]{e2.getMessage()});
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        m30160d();
    }

    private void m30161e() {
        setContentView(C6753R.layout.dialog_layout_confirm);
        this.f23258h = (Button) findViewById(C6753R.id.btn_ok);
        this.f23259i = (Button) findViewById(C6753R.id.btn_cancel);
        this.f23260j = (TextView) findViewById(C6753R.id.tv_dialog_title);
        this.f23260j.setText(this.f23262l.getString(C6753R.string.IDS_main_sns_member_account_has_been_effective));
        this.f23258h.setOnClickListener(new aa(this));
        this.f23259i.setOnClickListener(new ab(this));
    }

    protected void onResume() {
        super.onResume();
    }
}
