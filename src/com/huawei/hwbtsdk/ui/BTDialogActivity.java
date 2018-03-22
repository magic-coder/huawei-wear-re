package com.huawei.hwbtsdk.ui;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hwbtsdk.C6698c;
import com.huawei.hwbtsdk.C6699d;
import com.huawei.hwbtsdk.p059c.BTSDKApi;
import com.huawei.hwbtsdk.C6700e;
import com.huawei.hwbtsdk.p399a.C4616s;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

public class BTDialogActivity extends Activity {
    private C4616s f17067a;
    private ListView f17068b;
    private int f17069c = 0;
    private int f17070d = 0;
    private Button f17071e;
    private Button f17072f;
    private TextView f17073g;
    private Button f17074h;
    private Handler f17075i = new C4670i(this, this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
        m22403a();
    }

    private void m22403a() {
        BTSDKApi.a(this).a(this.f17075i);
        Intent intent = getIntent();
        if (intent != null) {
            this.f17069c = intent.getIntExtra("style", 0);
            C2538c.a("01", 1, "BTDialogActivity", new Object[]{"style:" + this.f17069c + ";content:" + intent.getIntExtra("content", 0)});
            switch (this.f17069c) {
                case 1:
                    this.f17070d = intent.getIntExtra("content", 0);
                    m22411d();
                    break;
                case 2:
                    this.f17075i.sendEmptyMessageDelayed(1, 5000);
                    m22414e();
                    break;
                case 3:
                    m22404a(intent.getIntExtra("device_type", -1));
                    break;
            }
            setFinishOnTouchOutside(false);
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            getWindow().setAttributes(attributes);
            return;
        }
        C2538c.a("01", 1, "BTDialogActivity", new Object[]{"intent is null."});
    }

    private void m22406b() {
        C2538c.c("BTDialogActivity", new Object[]{"====BT_GPS confirmBtnFun mDialogContent = " + this.f17070d});
        if (3 == this.f17070d) {
            BTSDKApi.a(this).a(true);
            finish();
        } else if (1 == this.f17070d) {
            BTSDKApi.a(this).a(true);
            startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1);
        } else if (2 == this.f17070d) {
            startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1);
        } else if (4 == this.f17070d) {
            BTSDKApi.a(this).g();
            finish();
        } else if (5 == this.f17070d) {
            BTSDKApi.a(this).c(false);
            finish();
        } else if (6 == this.f17070d) {
            C2538c.a("01", 1, "BTDialogActivity", new Object[]{"go to application set"});
            startActivityForResult(new Intent("android.settings.SETTINGS"), 2);
        }
    }

    private void m22409c() {
        if (3 == this.f17070d || 1 == this.f17070d) {
            BTSDKApi.a(this).a(false);
            finish();
        } else if (2 == this.f17070d) {
            m22415f();
        } else if (4 == this.f17070d) {
            BTSDKApi.a(this).c(false);
            finish();
        } else if (5 == this.f17070d) {
            m22415f();
        } else if (6 == this.f17070d) {
            m22415f();
        }
    }

    private void m22411d() {
        setContentView(C6699d.dialog_layout_confirm);
        this.f17071e = (Button) findViewById(C6698c.btn_ok);
        this.f17072f = (Button) findViewById(C6698c.btn_cancel);
        if (4 == this.f17070d) {
            this.f17072f.setText(C6700e.IDS_btsdk_confirm_repair);
            this.f17071e.setText(C6700e.IDS_btsdk_confirm_connect);
        } else if (5 == this.f17070d) {
            this.f17071e.setText(C6700e.IDS_btsdk_confirm_connect);
        } else if (6 == this.f17070d) {
            this.f17071e.setText(C6700e.IDS_settings_button_ok);
        }
        this.f17071e.setOnClickListener(new C4666e(this));
        this.f17072f.setOnClickListener(new C4667f(this));
        this.f17073g = (TextView) findViewById(C6698c.tv_dialog_title);
        if (3 == this.f17070d) {
            this.f17073g.setText(C6700e.IDS_btsdk_turn_on_BT);
        } else if (1 == this.f17070d) {
            this.f17073g.setText(C6700e.IDS_btsdk_turn_on_location_BT);
        } else if (2 == this.f17070d) {
            this.f17073g.setText(C6700e.IDS_btsdk_turn_on_location);
        } else if (4 == this.f17070d) {
            r0 = BTSDKApi.a(this).h();
            this.f17073g.setText(String.format(getResources().getString(C6700e.IDS_btsdk_confirm_connected_content), new Object[]{r0}));
        } else if (5 == this.f17070d) {
            r0 = BTSDKApi.a(this).i();
            this.f17073g.setText(String.format(getResources().getString(C6700e.IDS_btsdk_confirm_reconnect_content), new Object[]{r0, r0}));
        } else if (6 == this.f17070d) {
            this.f17073g.setText(C6700e.IDS_btsdk_get_loacation_permiassion);
        }
    }

    private void m22414e() {
        setContentView(C6699d.dialog_waiting);
    }

    private void m22404a(int i) {
        setContentView(C6699d.dialog_listview);
        this.f17068b = (ListView) findViewById(C6698c.device_list);
        this.f17067a = new C4616s(BaseApplication.b());
        this.f17068b.setAdapter(this.f17067a);
        BTSDKApi.a(this).a(this.f17067a);
        this.f17068b.setOnItemClickListener(new C4668g(this));
        this.f17074h = (Button) findViewById(C6698c.scan_cancel);
        this.f17074h.setOnClickListener(new C4669h(this));
        if (m22408b(i)) {
            BTSDKApi.a(this).b();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C2538c.a("01", 1, "BTDialogActivity", new Object[]{"onActivityResult requestCode:" + i + "   resultCode:" + i2});
        if (1 == i) {
            if (m22417h() || com.huawei.hwcommonmodel.d.d.a()) {
                finish();
                C2538c.a("01", 1, "BTDialogActivity", new Object[]{"showDeviceList 3"});
                BTSDKApi.a(this).c(true);
            }
        } else if (2 == i) {
            if (VERSION.SDK_INT < 23) {
                return;
            }
            if (checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                finish();
                C2538c.a("01", 1, "BTDialogActivity", new Object[]{"showDeviceList 4"});
                BTSDKApi.a(this).c(true);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onDestroy() {
        C2538c.c("BTDialogActivity", new Object[]{"===222==onDestroy"});
        this.f17075i.removeCallbacksAndMessages(null);
        super.onDestroy();
        com.huawei.hwcommonmodel.d.d.n(BaseApplication.b());
    }

    public void onBackPressed() {
        if (2 != this.f17069c) {
            m22415f();
            if (3 == this.f17069c) {
                C2538c.c("BTDialogActivity", new Object[]{"===222======back cancel"});
                BTSDKApi.a(this).d();
            }
        }
    }

    private boolean m22408b(int i) {
        if (2 != i && 1 != i) {
            return false;
        }
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        if (!com.huawei.hwcommonmodel.d.d.a() || 2 == i) {
            if (checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
                return false;
            } else if (m22416g()) {
                C2538c.c("BTDialogActivity", new Object[]{"permission allowed"});
            } else {
                requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
                return false;
            }
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 1:
                if (iArr == null || iArr.length <= 0) {
                    C2538c.a("01", 1, "BTDialogActivity", new Object[]{"grantResults is null or length is incorrect."});
                    return;
                }
                C2538c.a("01", 1, "BTDialogActivity", new Object[]{"grant result:" + (iArr[0] == 0)});
                if (!(iArr[0] == 0)) {
                    finish();
                    BTSDKApi.a(this).c();
                    return;
                } else if (m22416g()) {
                    BTSDKApi.a(this).b();
                    return;
                } else {
                    finish();
                    BTSDKApi.a(this).c();
                    return;
                }
            default:
                return;
        }
    }

    private void m22415f() {
        BTSDKApi.a(this).f();
        finish();
    }

    private boolean m22416g() {
        boolean z;
        C2538c.c("BTDialogActivity", new Object[]{"isLocationEnable :" + ((AppOpsManager) getSystemService("appops")).checkOp("android:coarse_location", Process.myUid(), getPackageName())});
        if (((AppOpsManager) getSystemService("appops")).checkOp("android:coarse_location", Process.myUid(), getPackageName()) != 0) {
            z = false;
        } else {
            z = true;
        }
        C2538c.c("BTDialogActivity", new Object[]{"isLocationEnable res:" + z + "  0：allowed  other：nopermission"});
        return z;
    }

    private boolean m22417h() {
        boolean isProviderEnabled;
        boolean isProviderEnabled2;
        if (VERSION.SDK_INT >= 23) {
            LocationManager locationManager = (LocationManager) getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
            isProviderEnabled = locationManager.isProviderEnabled("gps");
            C2538c.a("01", 1, "BTDialogActivity", new Object[]{"btdailog isGPSLocationEnable：" + isProviderEnabled});
            isProviderEnabled2 = locationManager.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER);
            C2538c.a("01", 1, "BTDialogActivity", new Object[]{"btdialog isNetWorkLocationEnable：" + isProviderEnabled2});
        } else {
            isProviderEnabled2 = true;
            isProviderEnabled = true;
        }
        return isProviderEnabled || isProviderEnabled2;
    }

    private void m22418i() {
        C2538c.c("BTDialogActivity", new Object[]{"===222==cancelScanDevice"});
        BTSDKApi.a(this).d();
    }
}
