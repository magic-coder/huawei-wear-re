package com.huawei.ui.device.activity.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.l.a.c;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.p137a.C1383f;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.device.activity.adddevice.AddDeviceActivity;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.j;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.device.views.device.C2198d;
import com.huawei.ui.device.views.device.C2202h;
import com.huawei.ui.device.views.device.C2206m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeviceManagerListActivity extends BaseActivity {
    private static int f7110k;
    private static ExecutorService f7111v = Executors.newFixedThreadPool(2);
    OnCancelListener f7112a = new C2030a(this);
    IBaseResponseCallback f7113b = new C2050t();
    private Context f7114c;
    private LocalBroadcastManager f7115d;
    private List<DeviceInfo> f7116e = null;
    private ArrayList<C2202h> f7117f = new ArrayList();
    private C2198d f7118g = null;
    private RecyclerView f7119h = null;
    private LinearLayout f7120i;
    private LinearLayout f7121j;
    private a f7122l;
    private u f7123m;
    private LinearLayout f7124n;
    private Button f7125o;
    private LinearLayout f7126p;
    private TextView f7127q;
    private HandlerThread f7128r = null;
    private Handler f7129s = null;
    private boolean f7130t = false;
    private Handler f7131u = new C2048r(this, this);
    private OnClickListener f7132w = new C2038i(this);
    private final BroadcastReceiver f7133x = new C2031b(this);
    private final BroadcastReceiver f7134y = new C2032c(this);
    private final BroadcastReceiver f7135z = new C2033d(this);

    private void m10630b(int i) {
        if (1 == i) {
            this.f7130t = true;
            return;
        }
        this.f7130t = false;
        m10640e();
    }

    private void m10637d() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter showConnectingDeviceNoteDialog():");
        if (this.f7122l == null) {
            a aVar = new a(this, j.app_update_dialogActivity);
            this.f7122l = a.a(this);
            this.f7122l.a(getResources().getString(i.IDS_device_connecting_now_please_wait));
            this.f7122l.setCancelable(true);
            this.f7122l.a();
            this.f7122l.setOnCancelListener(this.f7112a);
        }
    }

    private void m10640e() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter dismissConnectingDeviceNoteDialog():");
        if (this.f7122l != null) {
            this.f7122l.cancel();
            this.f7122l = null;
        }
    }

    private void m10643f() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter showDataSynchronizingDialog():");
        this.f7123m = new w(this).a(i.IDS_device_replace_dialog_title_notification).b(i.IDS_device_synchronizing_data_content).a();
        this.f7123m.setCancelable(true);
        this.f7123m.show();
    }

    private void m10644g() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter dismissDataSynchronizingDialog():");
        if (this.f7123m != null && this.f7123m.isShowing()) {
            this.f7123m.cancel();
        }
    }

    private void m10646h() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter freshDeviceRecyclerView()");
        if (this.f7117f == null || this.f7118g == null) {
            C2538c.m12679d("DeviceManagerListActivity", "if (mDeviceItemList == null || mDeviceListAdapter == null)");
            return;
        }
        Iterator it = this.f7117f.iterator();
        while (it.hasNext()) {
            C2202h c2202h = (C2202h) it.next();
            C2538c.m12677c("DeviceManagerListActivity", "deviceListItem:" + c2202h.toString());
        }
        this.f7118g.notifyDataSetChanged();
        C2538c.m12677c("DeviceManagerListActivity", "通知更新adapter，刷新RecyclerView");
    }

    public void onCreate(Bundle bundle) {
        C2538c.m12677c("DeviceManagerListActivity", "Enter onCreate()");
        super.onCreate(bundle);
        setContentView(f.activity_device_manager_list);
        this.f7114c = BaseApplication.m2632b();
        this.f7115d = LocalBroadcastManager.getInstance(this.f7114c);
        this.f7128r = new HandlerThread("DeviceManagerListActivity");
        this.f7128r.start();
        this.f7129s = new Handler(this.f7128r.getLooper());
        this.f7129s.post(new C2034e(this));
        m10648i();
        m10668a();
    }

    public void onStart() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter onStart()");
        super.onStart();
    }

    public void m10668a() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter refreshDeviceBattery()");
        f7111v.execute(new C2035f(this));
    }

    private void m10648i() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter initView()");
        this.f7126p = (LinearLayout) d.a(this, e.device_list_tips_layout);
        this.f7126p.setVisibility(8);
        this.f7126p.setOnClickListener(this.f7132w);
        this.f7127q = (TextView) d.a(this, e.list_device_tips_text);
        this.f7120i = (LinearLayout) d.a(this, e.device_manager_list_add_device);
        this.f7120i.setOnClickListener(new C2036g(this));
        this.f7124n = (LinearLayout) d.a(this, e.no_device_add);
        this.f7125o = (Button) d.a(this, e.no_device_add_button);
        this.f7125o.setOnClickListener(new C2037h(this));
        m10650j();
        this.f7119h = (RecyclerView) findViewById(e.device_manager_list_item);
        m10627a(true);
        m10653k();
        Iterator it = this.f7117f.iterator();
        while (it.hasNext()) {
            C2202h c2202h = (C2202h) it.next();
            C2538c.m12677c("DeviceManagerListActivity", "initView() end, deviceListItem:" + c2202h.toString());
        }
    }

    private void m10650j() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter initDeviceAdvertisementView()");
        this.f7121j = (LinearLayout) d.a(this, e.device_manager_list_no_device);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        LayoutParams layoutParams = (LayoutParams) this.f7121j.getLayoutParams();
        layoutParams.topMargin = ((int) (((float) displayMetrics.heightPixels) * NFCBaseActivity.PERCENT_MARGIN_30)) - ((int) ((this.f7114c.getResources().getDisplayMetrics().density * 50.0f) + 0.5f));
        this.f7121j.setLayoutParams(layoutParams);
    }

    private void m10653k() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter initListAdapter()");
        this.f7119h.setLayoutManager(new LinearLayoutManager(this.f7114c));
        if (this.f7114c != null) {
            this.f7118g = new C2198d(this.f7114c, this.f7117f, this.f7131u);
        }
        this.f7119h.setAdapter(this.f7118g);
        this.f7119h.addItemDecoration(new C2206m(this));
        this.f7118g.m11304a(new C2040j(this));
    }

    private void m10635c(int i) {
        if (i < 0 || i >= this.f7117f.size()) {
            C2538c.m12677c("DeviceManagerListActivity", "onClick position invalid return!");
        } else if (1 == ((C2202h) this.f7117f.get(i)).m11320b() || 2 == ((C2202h) this.f7117f.get(i)).m11320b()) {
            C2538c.m12677c("DeviceManagerListActivity", "onClick device is current device!");
            setResult(2);
            finish();
        } else {
            C2538c.m12677c("DeviceManagerListActivity", "onClick position device synchronizing = " + C0996a.m3612a(this.f7114c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG"));
            if ("true".equals(C0996a.m3612a(this.f7114c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG"))) {
                m10643f();
                return;
            }
            C2538c.m12677c("DeviceManagerListActivity", "Enter onItemClick():position = " + i);
            if (!m10628a(((C2202h) this.f7117f.get(i)).m11316a())) {
                m10638d(i);
                setResult(2);
                finish();
            }
        }
    }

    private void m10638d(int i) {
        C2538c.m12677c("DeviceManagerListActivity", "enter clickDeviceToConnect():");
        this.f7116e = C1988p.m10381a(BaseApplication.m2632b()).m10392b();
        if (1 == ((C2202h) this.f7117f.get(i)).m11320b() || 2 == ((C2202h) this.f7117f.get(i)).m11320b()) {
            C2538c.m12677c("DeviceManagerListActivity", "clickDeviceToConnect() device is connecting or connected status");
            return;
        }
        String a = ((C2202h) this.f7117f.get(i)).m11316a();
        C2538c.m12677c("DeviceManagerListActivity", "用户要连接的设备为：" + a + "," + ((C2202h) this.f7117f.get(i)).m11326e());
        if (this.f7116e != null) {
            for (DeviceInfo deviceInfo : this.f7116e) {
                if (deviceInfo != null) {
                    deviceInfo.resetDeviceInfo(deviceInfo, r2);
                } else {
                    C2538c.m12674b("DeviceManagerListActivity", "clickDeviceToConnect(): deviceInfo is null!");
                }
            }
            C1988p.m10381a(BaseApplication.m2632b()).m10390a(this.f7116e);
            ah.m10316a(this.f7114c).m10350q();
            C2538c.m12677c("DeviceManagerListActivity", "清除升级inter数据");
            return;
        }
        C2538c.m12680e("DeviceManagerListActivity", "mDeviceInfoList is null!");
    }

    private boolean m10628a(String str) {
        if (str != null) {
            if (str.equals(this.f7114c.getString(i.IDS_app_display_name_k1))) {
                C1383f.m6188a(this.f7114c).m6189a(5);
                return true;
            } else if (str.equals(this.f7114c.getString(i.IDS_app_display_name_k2))) {
                C1383f.m6188a(this.f7114c).m6189a(7);
                return true;
            }
        }
        return false;
    }

    private void m10627a(boolean z) {
        C2538c.m12677c("DeviceManagerListActivity", "Enter updateDeviceListItem()");
        this.f7129s.post(new C2041k(this, z));
    }

    private void m10618a(int i, String str, int i2, int i3, String str2, int i4) {
        C2538c.m12677c("DeviceManagerListActivity", "enter createDeviceListItem():");
        C2202h c2202h = new C2202h(i, str, str2, i2, i3, i4);
        C2538c.m12677c("DeviceManagerListActivity", "deviceListItem = " + c2202h.toString());
        C2538c.m12677c("DeviceManagerListActivity", "mDeviceItemList = " + this.f7117f.toString());
        if (this.f7117f.contains(c2202h)) {
            C2538c.m12680e("DeviceManagerListActivity", "createDeviceListItem: mDeviceItem is exist already. ");
            return;
        }
        this.f7117f.add(c2202h);
    }

    private void m10626a(Object obj) {
        C2538c.m12677c("DeviceManagerListActivity", "enter showDeleteReminderDialog()");
        int intValue = ((Integer) obj).intValue();
        List<DeviceInfo> b = C1988p.m10381a(BaseApplication.m2632b()).m10392b();
        if (b != null) {
            int size = this.f7117f.size();
            C2538c.m12677c("DeviceManagerListActivity", "mDeviceItemList.size=" + size + ",i=" + intValue);
            if (size > 0 && intValue < size) {
                C2202h c2202h = (C2202h) this.f7117f.get(intValue);
                String e = c2202h.m11326e();
                Map hashMap = new HashMap();
                switch (c2202h.m11327f()) {
                    case -2:
                        hashMap.put("devicename", "AF500");
                        break;
                    case 0:
                        hashMap.put("devicename", "B1");
                        break;
                    case 1:
                        hashMap.put("devicename", "B2");
                        break;
                    case 2:
                        hashMap.put("devicename", "k1");
                        break;
                    case 3:
                        hashMap.put("devicename", "huawei watch");
                        break;
                    case 5:
                        hashMap.put("devicename", "B0");
                        break;
                    case 7:
                        hashMap.put("devicename", "B3");
                        break;
                    case 8:
                        hashMap.put("devicename", "metis");
                        break;
                    case 9:
                        hashMap.put("devicename", "k2");
                        break;
                    case 10:
                        hashMap.put("devicename", "huawei watch2");
                        break;
                    case 11:
                        hashMap.put("devicename", "HUAWEI AM-R1");
                        break;
                    case 12:
                        hashMap.put("devicename", "A2");
                        break;
                    case 13:
                        hashMap.put("devicename", "NYX");
                        break;
                    case 14:
                        hashMap.put("devicename", "Grus");
                        break;
                    case 15:
                        hashMap.put("devicename", "ERIS");
                        break;
                    default:
                        hashMap.put("devicename", "unknown");
                        break;
                }
                if (3 == c2202h.m11327f() || 10 == c2202h.m11327f()) {
                    C1204c.m5370a(this.f7114c).m5425a(new C2047q(this, hashMap));
                } else {
                    hashMap.put("mac", c2202h.m11326e());
                    c.a().a(BaseApplication.m2632b(), com.huawei.hwcommonmodel.b.a.B.a(), hashMap, 0);
                }
                this.f7117f.remove(intValue);
                C2538c.m12677c("DeviceManagerListActivity", "mNewDeviceList：newDeviceListSize =" + b.size());
                for (DeviceInfo deviceInfo : b) {
                    C2538c.m12677c("DeviceManagerListActivity", "mNewDeviceList：" + deviceInfo.toString());
                }
                if (intValue < r4) {
                    C2538c.m12677c("DeviceManagerListActivity", "deleteDevice deleteDeviceState = " + ((DeviceInfo) b.get(intValue)).getDeviceConnectState());
                    if (1 == ((DeviceInfo) b.get(intValue)).getDeviceConnectState()) {
                        C2538c.m12677c("DeviceManagerListActivity", "deleteDevice: deleted device is connecting!");
                        this.f7130t = false;
                    }
                    b.remove(intValue);
                    for (DeviceInfo deviceInfo2 : b) {
                        C2538c.m12677c("DeviceManagerListActivity", "删除后的mNewDeviceList：" + deviceInfo2.toString());
                    }
                    C2538c.m12677c("DeviceManagerListActivity", "删除第" + (intValue + 1) + "行list");
                    C1988p.m10381a(BaseApplication.m2632b()).m10390a((List) b);
                } else {
                    C2538c.m12677c("DeviceManagerListActivity", "mNewDeviceList：i > newDeviceListSize");
                }
                if (e != null) {
                    Intent intent = new Intent("action_delete_debice_in_device_manager_list");
                    intent.putExtra("key_device_mac", e.toLowerCase());
                    this.f7115d.sendBroadcast(intent);
                } else {
                    C2538c.m12677c("DeviceManagerListActivity", "deleteMac is null");
                }
            }
            if (C1988p.m10381a(BaseApplication.m2632b()).m10392b() != null && C1988p.m10381a(BaseApplication.m2632b()).m10392b().size() == 0) {
                C2538c.m12677c("DeviceManagerListActivity", "list被全部删除");
            }
        } else {
            C2538c.m12680e("DeviceManagerListActivity", "mNewDeviceList is null!");
        }
        C0996a.m3611a(this.f7114c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG", "false", null);
        ah.m10316a(this.f7114c).m10350q();
        C2538c.m12677c("DeviceManagerListActivity", "清除升级inter数据");
        C0972a.m3501a(new DeviceInfo());
        C2538c.m12677c("DeviceManagerListActivity", "delete deviceInfo:" + C0972a.m3502b().toString());
    }

    public void onDestroy() {
        C0977d.m3575n(this.f7114c);
        super.onDestroy();
        m10659n();
        m10663p();
        m10667r();
        if (this.f7131u != null) {
            this.f7131u.removeCallbacksAndMessages(null);
        }
        if (this.f7129s != null) {
            this.f7129s.removeCallbacksAndMessages(null);
        }
        this.f7113b = null;
    }

    private void m10655l() {
        C2538c.m12677c("DeviceManagerListActivity", " enterAddDeviceActivity():");
        if (this.f7114c != null) {
            Intent intent = new Intent();
            intent.setClass(this.f7114c, AddDeviceActivity.class);
            startActivityForResult(intent, 1);
            return;
        }
        C2538c.m12680e("DeviceManagerListActivity", " enterAddDeviceActivity():mContext is null!");
    }

    public void onPause() {
        C2538c.m12677c("DeviceManagerListActivity", " 进入onPause():");
        super.onPause();
    }

    private void m10657m() {
        C2538c.m12677c("DeviceManagerListActivity", "Enter registerDeviceListChangedBroadcast():");
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.DEVICE_LIST_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.DEVICE_LIST_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.ACTION_GET_KIDWATCH_SUCCESS");
        if (this.f7114c != null) {
            this.f7114c.registerReceiver(this.f7133x, intentFilter, C0976c.f1642a, null);
        }
    }

    private void m10659n() {
        try {
            if (this.f7114c != null) {
                this.f7114c.unregisterReceiver(this.f7133x);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("DeviceManagerListActivity", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("DeviceManagerListActivity", e2.getMessage());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C2538c.m12677c("DeviceManagerListActivity", " Enter onActivityResult():");
        if (1 == i && 2 == i2) {
            setResult(2);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    private void m10661o() {
        this.f7114c.registerReceiver(this.f7134y, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), C0976c.f1642a, null);
    }

    private void m10663p() {
        try {
            C2538c.m12677c("DeviceManagerListActivity", "Enter unregisterNonLocalBroadcast()!");
            if (this.f7114c != null) {
                this.f7114c.unregisterReceiver(this.f7134y);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("DeviceManagerListActivity", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("DeviceManagerListActivity", e2.getMessage());
        }
    }

    private void m10619a(DeviceInfo deviceInfo) {
        C2538c.m12677c("DeviceManagerListActivity", "handleConnectStateChanged()");
        String deviceIdentify = deviceInfo.getDeviceIdentify();
        String deviceName = deviceInfo.getDeviceName();
        int deviceConnectState = deviceInfo.getDeviceConnectState();
        int productType = deviceInfo.getProductType();
        C2538c.m12677c("DeviceManagerListActivity", "handleConnectStateChanged():deviceName = " + deviceName + ",deviceIdentify = " + deviceIdentify + ",state = " + deviceConnectState + ",productType = " + productType);
        if (deviceIdentify == null) {
            C2538c.m12680e("DeviceManagerListActivity", "deviceIdentify is null!");
            return;
        }
        int i;
        Iterator it;
        C2202h c2202h;
        Message message;
        Iterator it2;
        Message message2;
        if (-1 == productType) {
            C2538c.m12680e("DeviceManagerListActivity", "productType is -1!");
            this.f7116e = C1988p.m10381a(BaseApplication.m2632b()).m10392b();
            if (this.f7116e != null) {
                i = productType;
                for (DeviceInfo deviceInfo2 : this.f7116e) {
                    if (deviceInfo2.getDeviceName().equalsIgnoreCase(deviceName)) {
                        productType = deviceInfo2.getProductType();
                        C2538c.m12677c("DeviceManagerListActivity", "从list中查询，productType为：" + productType);
                    } else {
                        productType = i;
                    }
                    i = productType;
                }
                switch (deviceConnectState) {
                    case 1:
                        C2538c.m12677c("DeviceManagerListActivity", " mConnectStateChangedReceiver():DEVICE_CONNECTING");
                        it = this.f7117f.iterator();
                        while (it.hasNext()) {
                            c2202h = (C2202h) it.next();
                            C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECTING，mDeviceItemList = " + this.f7117f);
                            if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                                if (-1 != i) {
                                    C2538c.m12677c("DeviceManagerListActivity", "connecting state，productType != -1 !");
                                    if (11 == i || !TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                        c2202h.m11322b(com.huawei.n.a.a(i).f());
                                    } else {
                                        c2202h.m11322b(com.huawei.n.a.j().f());
                                    }
                                }
                                c2202h.m11317a(1);
                                c2202h.m11324c(1);
                                C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECTING，刷新item！");
                                message = new Message();
                                message.arg1 = 1;
                                message.what = 1;
                                this.f7131u.sendMessage(message);
                            }
                        }
                        return;
                    case 2:
                        C2538c.m12677c("DeviceManagerListActivity", "mConnectStateChangedReceiver():DEVICE_CONNECTED!");
                        C1988p.m10381a(BaseApplication.m2632b()).m10387a(this.f7113b);
                        C2538c.m12677c("DeviceManagerListActivity", "连接成功，发命令查询电量！");
                        if (C1988p.m10381a(BaseApplication.m2632b()).m10384a() == null) {
                            C2538c.m12679d("DeviceManagerListActivity", "connect state，deviceConnectedMac = ", C1988p.m10381a(BaseApplication.m2632b()).m10384a().getDeviceIdentify());
                            if (C1988p.m10381a(BaseApplication.m2632b()).m10384a().getDeviceIdentify() == null) {
                                it2 = this.f7117f.iterator();
                                while (it2.hasNext()) {
                                    c2202h = (C2202h) it2.next();
                                    if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                                        if (-1 != i) {
                                            C2538c.m12677c("DeviceManagerListActivity", "connect state，productType != -1 !");
                                            if (11 == i || !TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                                c2202h.m11322b(com.huawei.n.a.a(i).i());
                                            } else {
                                                c2202h.m11322b(com.huawei.n.a.j().i());
                                            }
                                        }
                                        C2538c.m12677c("DeviceManagerListActivity", "=====DEVICE_CONNECTED===" + c2202h.m11316a() + "=====" + deviceName);
                                        if (!(deviceName == null || deviceName.equalsIgnoreCase(c2202h.m11316a()))) {
                                            c2202h.m11318a(deviceName);
                                        }
                                        c2202h.m11317a(2);
                                        c2202h.m11324c(2);
                                        C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECTED，刷新item！");
                                        message = new Message();
                                        message.arg1 = 2;
                                        message.what = 1;
                                        this.f7131u.sendMessage(message);
                                    }
                                }
                                return;
                            }
                            C2538c.m12679d("DeviceManagerListActivity", "DEVICE_CONNECTED,deviceConnectedMac is null.");
                            return;
                        }
                        C2538c.m12679d("DeviceManagerListActivity", "DEVICE_CONNECTED,getCurrentDeviceInfo() is null.");
                        return;
                    case 3:
                        C2538c.m12677c("DeviceManagerListActivity", " mConnectStateChangedReceiver():DEVICE_DISCONNECTED!");
                        it = this.f7117f.iterator();
                        while (it.hasNext()) {
                            c2202h = (C2202h) it.next();
                            if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                                if (-1 != i) {
                                    C2538c.m12677c("DeviceManagerListActivity", "disconnect state，productType != -1 !");
                                    if (11 == i || !TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                        c2202h.m11322b(com.huawei.n.a.a(i).f());
                                    } else {
                                        c2202h.m11322b(com.huawei.n.a.j().f());
                                    }
                                }
                                c2202h.m11317a(3);
                                c2202h.m11324c(3);
                                C2538c.m12677c("DeviceManagerListActivity", "DEVICE_DISCONNECTED，刷新item！");
                                message2 = new Message();
                                message2.arg1 = 3;
                                message2.what = 1;
                                this.f7131u.sendMessage(message2);
                                c2202h.m11319a(c2202h.m11326e(), 0);
                            }
                        }
                        return;
                    case 4:
                        C2538c.m12677c("DeviceManagerListActivity", "mConnectStateChangedReceiver(): DEVICE_CONNECT_FAILED！");
                        it = this.f7117f.iterator();
                        while (it.hasNext()) {
                            c2202h = (C2202h) it.next();
                            if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                                if (-1 != i) {
                                    C2538c.m12677c("DeviceManagerListActivity", "connect failed state，productType != -1 !");
                                    if (11 == i || !TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                        c2202h.m11322b(com.huawei.n.a.a(i).f());
                                    } else {
                                        c2202h.m11322b(com.huawei.n.a.j().f());
                                    }
                                }
                                c2202h.m11317a(4);
                                c2202h.m11324c(3);
                                C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECT_FAILED，刷新item！");
                                message2 = new Message();
                                message2.arg1 = 4;
                                message2.what = 1;
                                this.f7131u.sendMessage(message2);
                                c2202h.m11319a(c2202h.m11326e(), 0);
                            }
                        }
                        return;
                    case 5:
                        C2538c.m12677c("DeviceManagerListActivity", " mConnectStateChangedReceiver():DEVICE_UNAVAILABLE");
                        it = this.f7117f.iterator();
                        while (it.hasNext()) {
                            c2202h = (C2202h) it.next();
                            if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                                if (-1 != i) {
                                    C2538c.m12677c("DeviceManagerListActivity", "device_unavailable state，productType != -1 !");
                                    if (11 == i || !TextUtils.equals(deviceInfo.getDeviceName(), "HUAWEI CM-R1P")) {
                                        c2202h.m11322b(com.huawei.n.a.a(i).f());
                                    } else {
                                        c2202h.m11322b(com.huawei.n.a.j().f());
                                    }
                                }
                                c2202h.m11317a(5);
                                c2202h.m11324c(3);
                                C2538c.m12677c("DeviceManagerListActivity", "DEVICE_UNAVAILABLE，刷新item！");
                                message2 = new Message();
                                message2.arg1 = 5;
                                message2.what = 1;
                                this.f7131u.sendMessage(message2);
                                c2202h.m11319a(c2202h.m11326e(), 0);
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
            C2538c.m12680e("DeviceManagerListActivity", "mDeviceInfoList is null!!");
        }
        i = productType;
        switch (deviceConnectState) {
            case 1:
                C2538c.m12677c("DeviceManagerListActivity", " mConnectStateChangedReceiver():DEVICE_CONNECTING");
                it = this.f7117f.iterator();
                while (it.hasNext()) {
                    c2202h = (C2202h) it.next();
                    C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECTING，mDeviceItemList = " + this.f7117f);
                    if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                        if (-1 != i) {
                            C2538c.m12677c("DeviceManagerListActivity", "connecting state，productType != -1 !");
                            if (11 == i) {
                                break;
                            }
                            c2202h.m11322b(com.huawei.n.a.a(i).f());
                        }
                        c2202h.m11317a(1);
                        c2202h.m11324c(1);
                        C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECTING，刷新item！");
                        message = new Message();
                        message.arg1 = 1;
                        message.what = 1;
                        this.f7131u.sendMessage(message);
                    }
                }
                return;
            case 2:
                C2538c.m12677c("DeviceManagerListActivity", "mConnectStateChangedReceiver():DEVICE_CONNECTED!");
                C1988p.m10381a(BaseApplication.m2632b()).m10387a(this.f7113b);
                C2538c.m12677c("DeviceManagerListActivity", "连接成功，发命令查询电量！");
                if (C1988p.m10381a(BaseApplication.m2632b()).m10384a() == null) {
                    C2538c.m12679d("DeviceManagerListActivity", "DEVICE_CONNECTED,getCurrentDeviceInfo() is null.");
                    return;
                }
                C2538c.m12679d("DeviceManagerListActivity", "connect state，deviceConnectedMac = ", C1988p.m10381a(BaseApplication.m2632b()).m10384a().getDeviceIdentify());
                if (C1988p.m10381a(BaseApplication.m2632b()).m10384a().getDeviceIdentify() == null) {
                    C2538c.m12679d("DeviceManagerListActivity", "DEVICE_CONNECTED,deviceConnectedMac is null.");
                    return;
                }
                it2 = this.f7117f.iterator();
                while (it2.hasNext()) {
                    c2202h = (C2202h) it2.next();
                    if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                        if (-1 != i) {
                            C2538c.m12677c("DeviceManagerListActivity", "connect state，productType != -1 !");
                            if (11 == i) {
                                break;
                            }
                            c2202h.m11322b(com.huawei.n.a.a(i).i());
                        }
                        C2538c.m12677c("DeviceManagerListActivity", "=====DEVICE_CONNECTED===" + c2202h.m11316a() + "=====" + deviceName);
                        c2202h.m11318a(deviceName);
                        c2202h.m11317a(2);
                        c2202h.m11324c(2);
                        C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECTED，刷新item！");
                        message = new Message();
                        message.arg1 = 2;
                        message.what = 1;
                        this.f7131u.sendMessage(message);
                        break;
                    }
                }
                return;
            case 3:
                C2538c.m12677c("DeviceManagerListActivity", " mConnectStateChangedReceiver():DEVICE_DISCONNECTED!");
                it = this.f7117f.iterator();
                while (it.hasNext()) {
                    c2202h = (C2202h) it.next();
                    if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                        if (-1 != i) {
                            C2538c.m12677c("DeviceManagerListActivity", "disconnect state，productType != -1 !");
                            if (11 == i) {
                                break;
                            }
                            c2202h.m11322b(com.huawei.n.a.a(i).f());
                        }
                        c2202h.m11317a(3);
                        c2202h.m11324c(3);
                        C2538c.m12677c("DeviceManagerListActivity", "DEVICE_DISCONNECTED，刷新item！");
                        message2 = new Message();
                        message2.arg1 = 3;
                        message2.what = 1;
                        this.f7131u.sendMessage(message2);
                        c2202h.m11319a(c2202h.m11326e(), 0);
                    }
                }
                return;
            case 4:
                C2538c.m12677c("DeviceManagerListActivity", "mConnectStateChangedReceiver(): DEVICE_CONNECT_FAILED！");
                it = this.f7117f.iterator();
                while (it.hasNext()) {
                    c2202h = (C2202h) it.next();
                    if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                        if (-1 != i) {
                            C2538c.m12677c("DeviceManagerListActivity", "connect failed state，productType != -1 !");
                            if (11 == i) {
                                break;
                            }
                            c2202h.m11322b(com.huawei.n.a.a(i).f());
                        }
                        c2202h.m11317a(4);
                        c2202h.m11324c(3);
                        C2538c.m12677c("DeviceManagerListActivity", "DEVICE_CONNECT_FAILED，刷新item！");
                        message2 = new Message();
                        message2.arg1 = 4;
                        message2.what = 1;
                        this.f7131u.sendMessage(message2);
                        c2202h.m11319a(c2202h.m11326e(), 0);
                    }
                }
                return;
            case 5:
                C2538c.m12677c("DeviceManagerListActivity", " mConnectStateChangedReceiver():DEVICE_UNAVAILABLE");
                it = this.f7117f.iterator();
                while (it.hasNext()) {
                    c2202h = (C2202h) it.next();
                    if (!deviceIdentify.equalsIgnoreCase(c2202h.m11326e())) {
                        if (-1 != i) {
                            C2538c.m12677c("DeviceManagerListActivity", "device_unavailable state，productType != -1 !");
                            if (11 == i) {
                                break;
                            }
                            c2202h.m11322b(com.huawei.n.a.a(i).f());
                        }
                        c2202h.m11317a(5);
                        c2202h.m11324c(3);
                        C2538c.m12677c("DeviceManagerListActivity", "DEVICE_UNAVAILABLE，刷新item！");
                        message2 = new Message();
                        message2.arg1 = 5;
                        message2.what = 1;
                        this.f7131u.sendMessage(message2);
                        c2202h.m11319a(c2202h.m11326e(), 0);
                    }
                }
                return;
            default:
                return;
        }
    }

    private void m10665q() {
        this.f7114c.registerReceiver(this.f7135z, new IntentFilter("com.huawei.bone.action.ACTION_DIALOG_DISMISS"), C0976c.f1642a, null);
    }

    private void m10667r() {
        try {
            C2538c.m12677c("DeviceManagerListActivity", "Enter unregisterDialogDismissBroadcast()!");
            if (this.f7114c != null) {
                this.f7114c.unregisterReceiver(this.f7135z);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12677c("DeviceManagerListActivity", e.getMessage());
        } catch (RuntimeException e2) {
            C2538c.m12677c("DeviceManagerListActivity", e2.getMessage());
        }
    }
}
