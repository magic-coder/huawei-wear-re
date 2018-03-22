package com.huawei.ui.device.activity.notification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwmessagenotifymgr.a.a;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;

/* compiled from: NotificationSettingActivity */
class C2101h extends BaseAdapter {
    final /* synthetic */ NotificationSettingActivity f7417a;

    private C2101h(NotificationSettingActivity notificationSettingActivity) {
        this.f7417a = notificationSettingActivity;
    }

    public /* synthetic */ Object getItem(int i) {
        return m10858a(i);
    }

    public int getCount() {
        return this.f7417a.f7399j.size();
    }

    public a m10858a(int i) {
        return (a) this.f7417a.f7399j.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f7417a.f7392c).inflate(f.notification_list_item, null);
        }
        ImageView imageView = (ImageView) view.findViewById(e.app_icon);
        TextView textView = (TextView) view.findViewById(e.app_name);
        Switch switchR = (Switch) view.findViewById(e.app_switch);
        if (i < getCount()) {
            a aVar = (a) this.f7417a.f7399j.get(i);
            imageView.setImageDrawable(aVar.a());
            textView.setText(aVar.b());
            switchR.setOnCheckedChangeListener(null);
            switchR.setChecked(aVar.d() == 1);
        }
        switchR.setOnCheckedChangeListener(new C2102i(this, i));
        boolean equals = "true".equals(C0996a.m3612a(this.f7417a.f7392c, String.valueOf(10001), "KEY_NOTIFICATION_SETTINGS_FIRST_OPEN_FLAG"));
        C2538c.m12677c("NotificationSettingActivity", "getView() ", "  isSetFirstOpen = ", Boolean.valueOf(equals), ", position = ", Integer.valueOf(i), ", getCount = ", Integer.valueOf(getCount()));
        if (getCount() != 0 && getCount() > i) {
            C2538c.m12677c("NotificationSettingActivity", "packagename:" + ((a) this.f7417a.f7399j.get(i)).b() + "is autho: " + ((a) this.f7417a.f7399j.get(i)).d() + "is auto 2 :" + this.f7417a.f7398i.m10300a(((a) this.f7417a.f7399j.get(i)).c()));
            if (this.f7417a.f7398i.m10300a(((a) this.f7417a.f7399j.get(i)).c()) == 1) {
                C1035a.m4176b().m4184b(((a) this.f7417a.f7399j.get(i)).c(), 1);
            }
        }
        return view;
    }
}
