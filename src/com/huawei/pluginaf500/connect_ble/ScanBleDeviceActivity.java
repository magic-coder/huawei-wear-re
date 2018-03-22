package com.huawei.pluginaf500.connect_ble;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.i;
import com.huawei.pluginaf500.ui.AF500BaseActivity;
import com.huawei.pluginaf500.view.C5828b;
import java.util.ArrayList;
import java.util.List;

public class ScanBleDeviceActivity extends AF500BaseActivity {
    private static final String f19581g = "ScanBleDeviceActivity".toString();
    TextView f19582a;
    Button f19583b;
    int[] f19584c = new int[]{e.rescan_btn_layout, e.bind_btn_layout, e.bind_success_btn_layout, e.jump_btn_layout, e.scan_cancel_btn_layout};
    int[] f19585d = new int[]{e.scan_view, e.scan_fail, e.scan_success, e.scan_dev_list};
    private List<BleDeviceInfo> f19586h;
    private C5782h f19587i;
    private BluetoothAdapter f19588j;
    private boolean f19589k = false;
    private boolean f19590l = false;
    private ImageView f19591m;
    private ImageView f19592n;
    private C5828b f19593o = null;
    private Dialog f19594p;
    private boolean f19595q = false;
    private Handler f19596r = new C5786l(this);
    private BroadcastReceiver f19597s = new C5787m(this);

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.act_scan_after_guide);
        if (VERSION.SDK_INT <= 17 || !getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            finish();
            return;
        }
        this.f19588j = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        if (this.f19588j == null) {
            finish();
            return;
        }
        this.f19591m = (ImageView) findViewById(e.setting_bracelet_picture);
        this.f19592n = (ImageView) findViewById(e.globule);
        this.f19582a = (TextView) findViewById(e.scan_note);
        m26539j();
        new Thread(new C5785k(this)).start();
        m26530c(e.scan_view);
    }

    private void m26539j() {
        this.f19582a = (TextView) findViewById(e.scan_note);
        this.f19583b = (Button) findViewById(e.dev_name_btn);
        this.f19586h = new ArrayList();
    }

    public void onResume() {
        super.onResume();
        if (this.f19588j.isEnabled()) {
            this.f19587i = new C5782h(this.f19588j, this.f19596r);
            this.f19587i.m26579a(true);
            registerReceiver(this.f19597s, new IntentFilter("com.fenda.hwbracelet.CONNECTION_STATE"), "com.af500.permission.MYBRODCAST", null);
            return;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
    }

    public void onPause() {
        super.onPause();
        if (this.f19589k) {
            this.f19587i.m26579a(false);
            if (this.f19593o != null) {
                this.f19593o.m26930a(true);
            }
            this.f19589k = false;
        }
    }

    public void onStop() {
        super.onStop();
        if (this.f19589k) {
            this.f19587i.m26579a(false);
            if (this.f19593o != null) {
                this.f19593o.m26930a(true);
            }
            this.f19589k = false;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f19589k) {
            this.f19587i.m26579a(false);
            if (this.f19593o != null) {
                this.f19593o.m26930a(true);
            }
            this.f19589k = false;
        }
        try {
            unregisterReceiver(this.f19597s);
        } catch (Exception e) {
        }
    }

    private void m26522a(BleDeviceInfo bleDeviceInfo) {
        if (!this.f19590l && bleDeviceInfo != null) {
            this.f19586h.clear();
            this.f19586h.add(bleDeviceInfo);
        }
    }

    private void m26541k() {
        if (this.f19594p != null) {
            this.f19594p.cancel();
            this.f19594p = null;
        }
        this.f19594p = new Dialog(this, i.dialog);
        this.f19594p.setCanceledOnTouchOutside(false);
        this.f19594p.setContentView(LayoutInflater.from(this).inflate(f.ble_connect_dialog, null));
        this.f19594p.show();
    }

    public void viewOnClick(View view) {
        if (e.done_btn == view.getId()) {
            finish();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 != -1) {
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void m26527b(int i) {
        int i2 = 0;
        findViewById(i).setVisibility(0);
        while (i2 < this.f19584c.length) {
            if (i != this.f19584c[i2]) {
                findViewById(this.f19584c[i2]).setVisibility(8);
            }
            i2++;
        }
    }

    private void m26530c(int i) {
        findViewById(i).setVisibility(0);
        for (int i2 = 0; i2 < this.f19585d.length; i2++) {
            if (i != this.f19585d[i2]) {
                findViewById(this.f19585d[i2]).setVisibility(8);
            }
        }
        if (i == e.scan_dev_list) {
            this.f19582a.setVisibility(8);
            return;
        }
        this.f19582a.setVisibility(0);
        if (i == e.scan_view) {
            this.f19582a.setText("正在搜索中...");
        } else if (i == e.scan_fail) {
            this.f19582a.setText("搜索失败");
        } else if (i == e.scan_success) {
            this.f19582a.setText("新ColorBand配对成功");
        }
    }

    protected int mo5104a() {
        return 0;
    }
}
