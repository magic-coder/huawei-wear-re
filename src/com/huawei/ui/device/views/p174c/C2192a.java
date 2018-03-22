package com.huawei.ui.device.views.p174c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.b;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.g;
import java.util.List;

/* compiled from: DeviceSettingFactoryBaseAdapter */
public class C2192a extends BaseAdapter {
    private List<C2194c> f7802a;
    private LayoutInflater f7803b;
    private Context f7804c;
    private C2193b f7805d;
    private C2194c f7806e;

    public C2192a(Context context, List<C2194c> list) {
        this.f7802a = list;
        this.f7803b = LayoutInflater.from(context);
        this.f7804c = context;
    }

    public int getCount() {
        C2538c.m12677c("DeviceSettingFactoryBaseAdapter", "getCount()" + this.f7802a.size());
        return this.f7802a.size();
    }

    public Object getItem(int i) {
        C2538c.m12677c("DeviceSettingFactoryBaseAdapter", "getItem()" + this.f7802a.get(i));
        return this.f7802a.get(i);
    }

    public long getItemId(int i) {
        C2538c.m12677c("DeviceSettingFactoryBaseAdapter", "getItemId()" + i);
        return (long) i;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getItemViewType(int i) {
        C2538c.m12677c("DeviceSettingFactoryBaseAdapter", "getItemViewType()" + ((C2194c) getItem(i)));
        return ((C2194c) getItem(i)).m11270e();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2538c.m12677c("DeviceSettingFactoryBaseAdapter", "getView() arg0 = " + i + ",+arg1 = " + view);
        C2193b c2193b = new C2193b();
        try {
            this.f7806e = (C2194c) this.f7802a.get(i);
            this.f7805d = c2193b;
            C2538c.m12674b("DeviceSettingFactoryBaseAdapter", "getView() vie=" + view + ", item=" + r0);
            View c = m11251c(m11249b(m11245a(view, i), i), i);
            c.setTag(c2193b);
            return c;
        } catch (IndexOutOfBoundsException e) {
            C2538c.m12677c("DeviceSettingFactoryBaseAdapter", e.getMessage());
            return null;
        }
    }

    private View m11245a(View view, int i) {
        switch (this.f7806e.m11270e()) {
            case 0:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_two_title_switch_item, null);
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
            case 1:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_title_switch_item, null);
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
        }
        return view;
    }

    private View m11249b(View view, int i) {
        switch (this.f7806e.m11270e()) {
            case 2:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_title_two_image_item, null);
                    if (c.e(this.f7804c)) {
                        ((ImageView) d.a(view, e.settings_switch)).setBackgroundResource(g.btn_list_leftarrow);
                    }
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
            case 3:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_title_image_item, null);
                    if (c.e(this.f7804c)) {
                        ((ImageView) d.a(view, e.settings_switch)).setBackgroundResource(g.btn_list_leftarrow);
                    }
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
            case 6:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_two_title_image_item, null);
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
        }
        return view;
    }

    private View m11251c(View view, int i) {
        switch (this.f7806e.m11270e()) {
            case 4:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_title_image_item_divider, null);
                    if (c.e(this.f7804c)) {
                        ((ImageView) d.a(view, e.settings_switch)).setBackgroundResource(g.btn_list_leftarrow);
                    }
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
            case 5:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_divider, null);
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
            default:
                if (view == null) {
                    view = this.f7803b.inflate(f.activity_device_settings_title_image_item, null);
                }
                m11246a(i, view, this.f7806e, this.f7805d);
                break;
        }
        return view;
    }

    private void m11248a(C2194c c2194c, C2193b c2193b, boolean z) {
        if (c2193b.f7807a != null) {
            if (c2194c.m11261b() != null) {
                c2193b.f7807a.setText(c2194c.m11261b());
                c2193b.f7807a.setVisibility(0);
            } else {
                c2193b.f7807a.setVisibility(8);
            }
            c2193b.f7807a.setEnabled(z);
        }
    }

    private void m11250b(C2194c c2194c, C2193b c2193b, boolean z) {
        if (c2193b.f7808b != null) {
            if (c2194c.m11265c() != null) {
                c2193b.f7808b.setText(c2194c.m11265c());
                c2193b.f7808b.setVisibility(0);
            } else {
                c2193b.f7808b.setVisibility(8);
            }
            c2193b.f7808b.setEnabled(z);
        }
    }

    private void m11252c(C2194c c2194c, C2193b c2193b, boolean z) {
        if (c2193b.f7809c != null) {
            if (c2194c.m11269d() != null) {
                c2193b.f7809c.setText(c2194c.m11269d());
                c2193b.f7809c.setVisibility(0);
            } else {
                c2193b.f7809c.setVisibility(8);
            }
            c2193b.f7809c.setEnabled(z);
            if (z) {
                c2193b.f7809c.setTextColor(this.f7804c.getResources().getColor(b.common_white_50alpha));
            } else {
                c2193b.f7809c.setTextColor(this.f7804c.getResources().getColor(b.common_white_20alpha));
            }
        }
    }

    private void m11253d(C2194c c2194c, C2193b c2193b, boolean z) {
        if (c2193b.f7810d != null) {
            if (true == c2194c.m11272g()) {
                c2193b.f7810d.setVisibility(0);
            } else {
                c2193b.f7810d.setVisibility(8);
            }
            c2193b.f7810d.setEnabled(z);
        }
    }

    private void m11254e(C2194c c2194c, C2193b c2193b, boolean z) {
        if (c2193b.f7811e != null) {
            if (c2194c.m11261b() != null) {
                c2193b.f7811e.setChecked(c2194c.m11271f());
                c2193b.f7811e.setVisibility(0);
                c2193b.f7811e.setOnCheckedChangeListener(c2194c.m11273h());
            } else {
                c2193b.f7811e.setVisibility(8);
            }
            c2193b.f7811e.setEnabled(z);
        }
    }

    private void m11255f(C2194c c2194c, C2193b c2193b, boolean z) {
        if (c2193b.f7812f != null) {
            if (c2194c.m11274i() != 0) {
                c2193b.f7812f.setImageResource(c2194c.m11274i());
                c2193b.f7812f.setVisibility(0);
            } else {
                c2193b.f7812f.setVisibility(8);
            }
            c2193b.f7812f.setEnabled(z);
        }
    }

    private void m11247a(C2193b c2193b, boolean z, int i) {
        if (c2193b.f7813g != null) {
            if (i < this.f7802a.size() - 1 && i >= 0) {
                c2193b.f7813g.setVisibility(0);
                if (((C2194c) this.f7802a.get(i + 1)).m11270e() == 5) {
                    c2193b.f7813g.setVisibility(8);
                }
            } else if (((C2194c) this.f7802a.get(i)).m11256a() == 17) {
                c2193b.f7813g.setVisibility(0);
            } else {
                c2193b.f7813g.setVisibility(8);
            }
            c2193b.f7813g.setEnabled(z);
        }
    }

    private void m11246a(int i, View view, C2194c c2194c, C2193b c2193b) {
        c2193b.f7807a = (TextView) view.findViewById(e.content);
        c2193b.f7808b = (TextView) view.findViewById(e.sub_content);
        c2193b.f7809c = (TextView) view.findViewById(e.right_text);
        c2193b.f7810d = (FrameLayout) view.findViewById(e.new_tip);
        c2193b.f7811e = (Switch) view.findViewById(e.switch_button);
        c2193b.f7812f = (ImageView) view.findViewById(e.item_icon);
        c2193b.f7813g = view.findViewById(e.item_line);
        boolean j = c2194c.m11275j();
        m11248a(c2194c, c2193b, j);
        m11250b(c2194c, c2193b, j);
        m11252c(c2194c, c2193b, j);
        m11253d(c2194c, c2193b, j);
        m11254e(c2194c, c2193b, j);
        m11255f(c2194c, c2193b, j);
        m11247a(c2193b, j, i);
    }

    public boolean isEnabled(int i) {
        C2538c.m12677c("DeviceSettingFactoryBaseAdapter", "isEnabled() position:" + i + "size:" + this.f7802a.size());
        if (i < this.f7802a.size()) {
            return ((C2194c) this.f7802a.get(i)).m11275j();
        }
        return super.isEnabled(i);
    }
}
