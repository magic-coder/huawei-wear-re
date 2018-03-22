package com.huawei.sim.esim.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.huawei.sim.esim.qrcode.QrCodeActivity;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

public class ScanFailActivity extends BaseActivity implements OnClickListener {
    private Button f20399a;
    private CustomTitleBar f20400b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_scan_failed);
        this.f20399a = (Button) findViewById(g.rescan_qrcode_button);
        this.f20399a.setOnClickListener(this);
        this.f20400b = (CustomTitleBar) findViewById(g.scan_fail_title_bar);
        this.f20400b.setLeftButtonClickable(true);
        this.f20400b.setLeftButtonOnClickListener(new ak(this));
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public void onClick(View view) {
        if (view.getId() == g.rescan_qrcode_button) {
            startActivity(new Intent(this, QrCodeActivity.class));
            finish();
        }
    }
}
