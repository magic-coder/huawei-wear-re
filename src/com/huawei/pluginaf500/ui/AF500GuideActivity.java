package com.huawei.pluginaf500.ui;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.fenda.hwbracelet.p261d.C3597a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.connect_ble.BleDeviceInfo;
import com.huawei.pluginaf500.connect_ble.C5775a;
import com.huawei.pluginaf500.connect_ble.C5782h;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.utils.C5823f;
import com.huawei.pluginaf500.utils.C5825h;
import com.huawei.pluginaf500.utils.CustomDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AF500GuideActivity extends AF500BaseActivity implements OnClickListener, OnItemClickListener {
    C5775a f19643a = null;
    boolean f19644b = false;
    private int[] f19645c = new int[]{f.startup_guidance_second_activity, f.startup_guidance_third_activity, f.startup_guidance_fourth_activity};
    private LinearLayout f19646d;
    private Button f19647g;
    private Button f19648h;
    private Button f19649i;
    private Button f19650j;
    private ListView f19651k = null;
    private boolean f19652l = false;
    private List<BleDeviceInfo> f19653m;
    private C5782h f19654n;
    private BluetoothAdapter f19655o;
    private boolean f19656p = false;
    private boolean f19657q = false;
    private boolean f19658r = false;
    private CustomDialog f19659s = null;
    private Context f19660t;
    private int f19661u = 0;
    private int f19662v = 0;
    private Date f19663w = null;
    private String f19664x = null;
    private Handler f19665y = new C5794c(this);
    private C3597a f19666z = new C5797e(this);

    protected int mo5104a() {
        return f.af500_frame;
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        }
        this.f19660t = BaseApplication.b();
        this.f19646d = (LinearLayout) findViewById(e.af500_bt_paired_guide);
        this.f19652l = getIntent().getBooleanExtra("isStartupGuide", false);
        this.f19655o = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        this.f19653m = new ArrayList();
        this.f19643a = C5775a.m26544a(this.f19660t);
        if (this.f19643a != null) {
            this.f19643a.m26554a(this.f19666z);
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (this.f19655o != null) {
            if (!this.f19655o.isEnabled()) {
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
            } else if (!this.f19656p && !this.f19657q && !this.f19658r) {
                this.f19654n = new C5782h(this.f19655o, this.f19665y);
                this.f19654n.m26579a(true);
            }
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.f19656p) {
            if (this.f19654n != null) {
                this.f19654n.m26579a(false);
            }
            this.f19656p = false;
        }
        this.f19654n = null;
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f19656p) {
            if (this.f19654n != null) {
                this.f19654n.m26579a(false);
            }
            this.f19656p = false;
        }
        this.f19654n = null;
        this.f19665y.removeCallbacksAndMessages(null);
        if (this.f19643a != null) {
            this.f19643a.m26561b(this.f19666z);
        }
        m26618r();
        d.n(this.f19660t);
    }

    public void onBackPressed() {
        if (!this.f19658r) {
            super.onBackPressed();
        }
    }

    private void m26608j() {
        this.f19646d.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(f.af500_guide_third_view, null);
        this.f19650j = (Button) inflate.findViewById(e.btn_done);
        this.f19650j.setOnClickListener(this);
        this.f19646d.addView(inflate, -1, -1);
    }

    private void m26595b(int i) {
        int i2;
        this.f19646d.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(f.af500_guide_fourth_view, null);
        TextView textView = (TextView) inflate.findViewById(e.af500_pair_err_tip);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(e.af500_note_layout);
        ImageView imageView = (ImageView) inflate.findViewById(e.ImageView_mac_Address_click);
        TextView textView2 = (TextView) inflate.findViewById(e.af500_note_step_1);
        TextView textView3 = (TextView) inflate.findViewById(e.af500_note_step_2);
        TextView textView4 = (TextView) inflate.findViewById(e.af500_note_step_3);
        TextView textView5 = (TextView) inflate.findViewById(e.af500_note_step_4);
        int i3;
        int i4;
        switch (i) {
            case -6:
                i3 = h.connect_error;
                imageView.setImageResource(com.huawei.pluginaf500.d.af500_connect_failed_by_net_status);
                linearLayout.setVisibility(8);
                i2 = i3;
                break;
            case -5:
                i3 = h.bind_device_failed_another_device;
                imageView.setImageResource(com.huawei.pluginaf500.d.af500_connect_fail);
                imageView.setOnClickListener(this);
                linearLayout.setVisibility(8);
                i2 = i3;
                break;
            case -4:
            case -1:
                i4 = h.af500_search_failed;
                imageView.setImageResource(com.huawei.pluginaf500.d.af500_connect_fail);
                textView2.setText(getString(h.af500_sync_failed_explain1));
                textView3.setText(getString(h.af500_sync_failed_explain2));
                textView4.setText(getString(h.af500_sync_failed_explain3));
                textView5.setText(getString(h.af500_sync_failed_explain4));
                linearLayout.setVisibility(0);
                i2 = i4;
                break;
            case -3:
                i3 = h.bind_device_failed_another_user;
                imageView.setImageResource(com.huawei.pluginaf500.d.af500_connect_fail);
                linearLayout.setVisibility(8);
                i2 = i3;
                break;
            case -2:
                i4 = h.pair_bt_failed;
                imageView.setImageResource(com.huawei.pluginaf500.d.af500_connect_failed_by_ios_band);
                textView2.setText(getString(h.af500_connect_failed_explain1));
                textView3.setText(getString(h.af500_connect_failed_explain2));
                textView4.setText(getString(h.af500_connect_failed_explain3));
                textView5.setText(getString(h.af500_connect_failed_explain4));
                linearLayout.setVisibility(0);
                i2 = i4;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 > 0) {
            textView.setText(i2);
        }
        this.f19647g = (Button) inflate.findViewById(e.btn_skip_paired2);
        this.f19647g.setOnClickListener(this);
        this.f19649i = (Button) inflate.findViewById(e.btn_re_search);
        this.f19649i.setOnClickListener(this);
        this.f19646d.addView(inflate, -1, -1);
    }

    private void m26609k() {
        if (!this.f19652l) {
            onDestroy();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == e.btn_skip_paired_result) {
            m26617q();
        } else if (id == e.btn_re_search_pair_result) {
            m26616p();
        } else if (id == e.btn_skip_paired2) {
            m26617q();
        } else if (id == e.btn_re_search) {
            this.f19662v = 0;
            m26616p();
        } else if (id == e.btn_done) {
            m26609k();
        } else if (id == e.btn_cancel_search) {
            this.f19657q = true;
            if (this.f19654n != null) {
                this.f19654n.m26579a(false);
            }
            m26595b(-1);
        } else if (id == e.ImageView_mac_Address_click) {
            if (m26612l()) {
                this.f19661u++;
            } else {
                this.f19661u = 0;
            }
            if (this.f19661u >= 2 && this.f19662v <= 8) {
                this.f19661u = 0;
            }
            if (this.f19661u >= 2) {
                this.f19661u = 0;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m26612l() {
        /*
        r6 = this;
        r0 = 1;
        r1 = r6.f19663w;
        if (r1 != 0) goto L_0x000c;
    L_0x0005:
        r1 = r6.m26619s();
        r6.f19663w = r1;
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = 0;
        r2 = r6.m26619s();
        r3 = r2.getYear();
        r4 = r6.f19663w;
        r4 = r4.getYear();
        if (r3 != r4) goto L_0x0068;
    L_0x001d:
        r3 = r2.getMonth();
        r4 = r6.f19663w;
        r4 = r4.getMonth();
        if (r3 != r4) goto L_0x0068;
    L_0x0029:
        r3 = r2.getDay();
        r4 = r6.f19663w;
        r4 = r4.getDay();
        if (r3 != r4) goto L_0x0068;
    L_0x0035:
        r3 = r2.getHours();
        r3 = r3 * 1000;
        r4 = r2.getMinutes();
        r4 = r4 * 100;
        r3 = r3 + r4;
        r4 = r2.getSeconds();
        r3 = r3 + r4;
        r4 = r6.f19663w;
        r4 = r4.getHours();
        r4 = r4 * 1000;
        r5 = r6.f19663w;
        r5 = r5.getMinutes();
        r5 = r5 * 100;
        r4 = r4 + r5;
        r5 = r6.f19663w;
        r5 = r5.getSeconds();
        r4 = r4 + r5;
        r3 = r3 - r4;
        if (r3 < 0) goto L_0x0068;
    L_0x0062:
        r4 = 2;
        if (r3 >= r4) goto L_0x0068;
    L_0x0065:
        r6.f19663w = r2;
        goto L_0x000b;
    L_0x0068:
        r0 = r1;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginaf500.ui.AF500GuideActivity.l():boolean");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 != -1) {
            Toast.makeText(this, getString(h.blue_not_open), 0).show();
            finish();
        }
    }

    private void m26613m() {
        this.f19646d.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(f.af500_guide_second_view, null);
        this.f19648h = (Button) inflate.findViewById(e.btn_cancel_search);
        this.f19648h.setOnClickListener(this);
        this.f19646d.addView(inflate, -1, -1);
    }

    private void m26614n() {
        this.f19646d.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(f.af500_search_result_layout, null);
        this.f19651k = (ListView) inflate.findViewById(16908298);
        this.f19651k.setOnItemClickListener(this);
        this.f19647g = (Button) inflate.findViewById(e.btn_skip_paired_result);
        this.f19647g.setOnClickListener(this);
        this.f19649i = (Button) inflate.findViewById(e.btn_re_search_pair_result);
        this.f19649i.setOnClickListener(this);
        this.f19646d.addView(inflate, -1, -1);
    }

    private void m26591a(BleDeviceInfo bleDeviceInfo) {
        if (!this.f19657q && bleDeviceInfo != null) {
            this.f19653m.clear();
            this.f19653m.add(bleDeviceInfo);
        }
    }

    private void m26615o() {
        if (this.f19653m.size() > 0) {
            String str = ((BleDeviceInfo) this.f19653m.get(0)).address;
            this.f19651k.setAdapter(new ArrayAdapter(this, 17367043, new String[]{str}));
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BleDeviceInfo bleDeviceInfo = (BleDeviceInfo) this.f19653m.get(i);
        if (this.f19643a != null && bleDeviceInfo != null) {
            C2538c.c("AF500GuideActivity", new Object[]{"Start to connect AF500 Device"});
            this.f19643a.m26557a(bleDeviceInfo.address, new C5796d(this));
        }
    }

    private void m26616p() {
        if (this.f19654n != null) {
            this.f19654n.m26579a(true);
            m26613m();
        }
    }

    private void m26617q() {
        if (this.f19652l) {
            m26609k();
        } else {
            finish();
        }
    }

    private void m26599c(int i) {
        if (this.f19659s == null && !isFinishing()) {
            this.f19659s = new C5823f(this).m26919b(i).m26918a(C5825h.PROGRESS).m26914a();
            this.f19659s.setCanceledOnTouchOutside(false);
            this.f19659s.show();
        }
    }

    private void m26618r() {
        if (this.f19659s != null) {
            this.f19659s.dismiss();
            this.f19659s = null;
        }
    }

    private Date m26619s() {
        return Calendar.getInstance().getTime();
    }
}
