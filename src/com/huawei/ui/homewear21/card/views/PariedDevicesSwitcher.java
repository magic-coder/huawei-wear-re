package com.huawei.ui.homewear21.card.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.p137a.C1383f;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.device.activity.adddevice.AddDeviceActivity;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.homewear21.card.p176a.C2243a;
import com.huawei.ui.homewear21.f;
import com.huawei.ui.homewear21.g;
import com.huawei.ui.homewear21.i;
import java.util.ArrayList;
import java.util.List;

public class PariedDevicesSwitcher extends AbsoluteLayout {
    private static final String f8209b = PariedDevicesSwitcher.class.getSimpleName();
    public ImageView f8210a;
    private TextView f8211c;
    private ImageView f8212d;
    private ImageView f8213e;
    private IBaseResponseCallback f8214f;
    private boolean f8215g = true;
    private PopupWindow f8216h = null;
    private Context f8217i;
    private ListView f8218j;
    private C2260a f8219k = null;
    private List<C2262c> f8220l = new ArrayList();
    private String f8221m = null;
    private String f8222n = null;
    private OnClickListener f8223o = null;
    private Animation f8224p;
    private Animation f8225q;
    private C2243a f8226r;
    private LocalBroadcastManager f8227s;
    private List<DeviceInfo> f8228t = null;
    private final Object f8229u = new Object();
    private Handler f8230v = new C2263d(this);

    public PariedDevicesSwitcher(Context context) {
        super(context);
        this.f8217i = context;
        m11662a(context);
    }

    public PariedDevicesSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8217i = context;
        this.f8227s = LocalBroadcastManager.getInstance(this.f8217i);
        m11662a(context);
    }

    public void setFocus(boolean z) {
        synchronized (this.f8229u) {
            this.f8215g = z;
        }
    }

    private boolean getFocus() {
        return this.f8215g;
    }

    public void m11687a(DeviceInfo... deviceInfoArr) {
        CharSequence string = this.f8217i.getResources().getString(i.IDS_app_name);
        DeviceInfo deviceInfo = null;
        int length = deviceInfoArr.length;
        int i = 0;
        while (i < length) {
            deviceInfo = deviceInfoArr[i];
            C2538c.m12674b(f8209b, "Enter no deviceInfo");
            i++;
            deviceInfo = deviceInfoArr[0];
        }
        if (deviceInfo == null) {
            this.f8226r = C2243a.m11601a();
            deviceInfo = this.f8226r.m11614c();
        }
        if (deviceInfo != null) {
            if (TextUtils.isEmpty(deviceInfo.getDeviceName())) {
                string = C1988p.m10381a(this.f8217i).m10391b(deviceInfo.getProductType());
            } else {
                string = deviceInfo.getDeviceName();
            }
        }
        C2538c.m12674b(f8209b, "title:" + string);
        this.f8211c.setText(string);
    }

    private void m11662a(Context context) {
        C2538c.m12674b(f8209b, "Enter initView");
        View inflate = LayoutInflater.from(context).inflate(g.paire_devices_switcher_layout_21, null);
        this.f8211c = (TextView) inflate.findViewById(f.deviceName);
        this.f8210a = (ImageView) inflate.findViewById(f.switchPopwindow);
        m11687a(new DeviceInfo[0]);
        this.f8221m = this.f8217i.getResources().getString(i.IDS_btsdk_set_up_device);
        this.f8222n = this.f8217i.getResources().getString(i.IDS_huaweiwatch_content);
        inflate.setOnClickListener(new C2265f(this));
        addView(inflate);
    }

    private void m11663a(View view) {
        if (this.f8216h == null) {
            View inflate = ((LayoutInflater) this.f8217i.getSystemService("layout_inflater")).inflate(g.devicelist_popwindow, null);
            this.f8212d = (ImageView) inflate.findViewById(f.pop_null_title_space);
            this.f8213e = (ImageView) inflate.findViewById(f.pop_null_content_space);
            this.f8223o = new C2267h(this);
            this.f8212d.setOnClickListener(this.f8223o);
            this.f8213e.setOnClickListener(this.f8223o);
            this.f8218j = (ListView) inflate.findViewById(f.deviceslist);
            this.f8220l = m11688b();
            this.f8219k = new C2260a(this.f8217i, this.f8220l);
            this.f8218j.setAdapter(this.f8219k);
            this.f8218j.setItemsCanFocus(true);
            this.f8218j.setOnItemClickListener(new C2268i(this));
            this.f8216h = new PopupWindow(inflate, -1, -1);
        } else if (this.f8219k != null) {
            this.f8220l = m11688b();
            if (this.f8220l != null) {
                this.f8219k.m11694a(this.f8220l);
                this.f8219k.notifyDataSetChanged();
            }
        }
        if (this.f8216h != null) {
            this.f8216h.setFocusable(true);
            this.f8216h.setBackgroundDrawable(new BitmapDrawable());
            this.f8216h.setOnDismissListener(new C2269j(this));
            this.f8216h.update();
            this.f8216h.showAtLocation(view, 49, 0, 0);
            m11679f();
        }
    }

    private void m11668a(String str, String str2, int i) {
        C2538c.m12677c(f8209b, "enter showReplaceDeviceDialog():mOldDevice = " + str + ", mNewDevice = " + str2);
        u a = new w(this.f8217i).a(i.IDS_device_replace_dialog_title_notification).b(String.format(getResources().getString(i.IDS_replace_device_dialog_content), new Object[]{str, str2})).b(i.IDS_settings_button_cancal, new C2271l(this)).a(i.IDS_settings_button_ok, new C2270k(this, i)).a();
        a.setCancelable(false);
        a.show();
    }

    private void m11661a(int i) {
        C2538c.m12677c(f8209b, "enter clickDeviceToConnect():" + i);
        this.f8228t = C2243a.m11601a().m11617f();
        String str = "";
        str = "";
        String d = ((C2262c) this.f8220l.get(i)).m11705d();
        str = ((C2262c) this.f8220l.get(i)).m11695a();
        if (i >= this.f8228t.size()) {
            C2538c.m12677c(f8209b, "enter clickDeviceToConnect() return");
            return;
        }
        C2538c.m12677c(f8209b, "用户要连接的设备为：" + d + "," + str);
        m11667a(str);
    }

    public void m11686a() {
        this.f8228t = C2243a.m11601a().m11617f();
        if (this.f8228t == null || this.f8228t.size() <= 0) {
            C2538c.m12677c(f8209b, "enter resetCurrentDevice() else");
            return;
        }
        m11667a(((DeviceInfo) this.f8228t.get(0)).getDeviceIdentify());
    }

    private void m11667a(String str) {
        for (DeviceInfo deviceInfo : this.f8228t) {
            if (deviceInfo == null) {
                C2538c.m12674b(f8209b, "clickDeviceToConnect(): deviceInfo is null!");
            } else if (deviceInfo.getDeviceIdentify().equalsIgnoreCase(str)) {
                deviceInfo.setDeviceActiveState(1);
                m11687a(deviceInfo);
                if (this.f8214f != null) {
                    this.f8214f.onResponse(100, deviceInfo);
                }
                C2538c.m12674b(f8209b, "更新DeviceActiveState为enable,设备为：" + deviceInfo.getDeviceIdentify() + ",name = " + deviceInfo.getDeviceName());
            } else {
                deviceInfo.setDeviceActiveState(0);
                C2538c.m12674b(f8209b, "更新DeviceActiveState为disable,设备为：" + deviceInfo.getDeviceIdentify() + ",name = " + deviceInfo.getDeviceName());
            }
        }
        C2243a.m11601a().m11610a(this.f8228t);
        ah.m10316a(this.f8217i).m10350q();
        C2538c.m12677c(f8209b, "清除升级inter数据");
    }

    private boolean m11672b(String str) {
        if (str == null || !str.equals(this.f8217i.getString(i.IDS_btsdk_set_up_device))) {
            return false;
        }
        m11684h();
        return true;
    }

    private boolean m11674c(String str) {
        if (str != null) {
            if (str.equals(this.f8217i.getString(i.IDS_app_display_name_k1))) {
                C1383f.m6188a(this.f8217i).m6189a(5);
                return true;
            } else if (str.equals(this.f8217i.getString(i.IDS_app_display_name_k2))) {
                C1383f.m6188a(this.f8217i).m6189a(7);
                return true;
            }
        }
        return false;
    }

    private void m11677e() {
        if (this.f8216h != null) {
            this.f8230v.post(new C2272m(this));
        }
    }

    private void m11679f() {
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, GroundOverlayOptions.NO_DIMENSION, 1, 0.0f);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setDuration(300);
        this.f8224p = animationSet;
        this.f8218j.startAnimation(this.f8224p);
    }

    private void m11682g() {
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, GroundOverlayOptions.NO_DIMENSION);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setDuration(300);
        this.f8225q = animationSet;
        this.f8225q.setAnimationListener(new C2273n(this));
        this.f8218j.startAnimation(this.f8225q);
    }

    public List<C2262c> m11688b() {
        if (this.f8220l == null) {
            return null;
        }
        C2262c c2262c;
        this.f8220l.clear();
        try {
            for (DeviceInfo deviceInfo : C2243a.m11601a().m11617f()) {
                C2538c.m12674b(f8209b, "======test======listDeviceInfo==conectstate:=" + deviceInfo.toString());
                C2262c c2262c2 = new C2262c();
                c2262c2.m11701b(deviceInfo.getDeviceName());
                c2262c2.m11700b(deviceInfo.getDeviceActiveState());
                c2262c2.m11706d(deviceInfo.getDeviceBTType());
                c2262c2.m11704c(deviceInfo.getDeviceConnectState());
                c2262c2.m11697a(deviceInfo.getDeviceIdentify());
                c2262c2.m11696a(deviceInfo.getProductType());
                if (1 == deviceInfo.getDeviceActiveState()) {
                    c2262c2.m11702b(true);
                    m11687a(new DeviceInfo[0]);
                } else {
                    c2262c2.m11702b(false);
                }
                this.f8220l.add(c2262c2);
            }
        } catch (Exception e) {
            C2538c.m12677c(f8209b, "ERROR Exception ", e.getMessage());
        }
        C1383f a = C1383f.m6188a(this.f8217i);
        if (a.m6194d()) {
            C2262c c2262c3 = new C2262c();
            c2262c3.m11701b(this.f8217i.getResources().getString(i.IDS_app_display_name_k1));
            c2262c3.m11696a(2);
            this.f8220l.add(c2262c3);
        }
        if (a.m6195e()) {
            c2262c = new C2262c();
            c2262c.m11701b(this.f8217i.getResources().getString(i.IDS_app_display_name_k2));
            c2262c.m11696a(9);
            this.f8220l.add(c2262c);
        }
        c2262c = new C2262c(this.f8222n);
        c2262c.m11698a(false);
        c2262c.m11696a(3);
        C2538c.m12674b(f8209b, "creatPairedDeviceInfoList w1 = " + c2262c.toString());
        c2262c = new C2262c(this.f8221m);
        c2262c.m11696a(10010);
        this.f8220l.add(c2262c);
        return this.f8220l;
    }

    private void m11684h() {
        Intent intent = new Intent();
        intent.setClass(this.f8217i, AddDeviceActivity.class);
        this.f8217i.startActivity(intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C2538c.m12674b(f8209b, "OnKeyListener ", keyEvent.toString());
        if (i == 4 && !getFocus()) {
            if (this.f8216h != null) {
                this.f8230v.post(new C2264e(this));
            }
            setFocus(true);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setBaseResponseCallback(IBaseResponseCallback iBaseResponseCallback) {
        this.f8214f = iBaseResponseCallback;
    }

    public void m11689c() {
        if (this.f8219k != null) {
            this.f8220l = m11688b();
            if (this.f8220l != null) {
                this.f8219k.m11694a(this.f8220l);
                this.f8219k.notifyDataSetChanged();
            }
        }
    }
}
