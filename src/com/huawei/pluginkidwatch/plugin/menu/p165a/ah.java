package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.b;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1893j;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1898o;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;

/* compiled from: NotificationHistoryAdapter */
public class ah extends BaseAdapter {
    private Context f5173a;
    private ArrayList<C1401q> f5174b = new ArrayList();
    private C1401q f5175c = new C1401q();
    private int f5176d;
    private TreeSet<Integer> f5177e = new TreeSet();
    private at f5178f = null;
    private ArrayList<Integer> f5179g = new ArrayList();
    private ArrayList<C1401q> f5180h = new ArrayList();
    private Timer f5181i = null;
    private TimerTask f5182j = null;
    private int f5183k = 0;
    private int f5184l = 0;
    private boolean f5185m = false;
    private boolean f5186n = false;
    private String f5187o = "00:00:00";

    private void m8836a() {
        C1401q c1401q = new C1401q();
        c1401q.f3146b = C1462f.m6744i();
        ArrayList a = C1392h.m6271a(this.f5173a, c1401q);
        for (int i = 0; i < a.size(); i++) {
            if (5 == ((C1401q) a.get(i)).f3149e) {
                this.f5180h.add(a.get(i));
                this.f5179g.add(Integer.valueOf(0));
            }
        }
    }

    private int m8855c(C1401q c1401q) {
        for (int i = 0; i < this.f5180h.size(); i++) {
            if (c1401q.f3145a == ((C1401q) this.f5180h.get(i)).f3145a) {
                return i;
            }
        }
        return -1;
    }

    public ah(Context context) {
        this.f5173a = context;
        m8836a();
    }

    public void m8868a(C1401q c1401q) {
        this.f5174b.add(c1401q);
    }

    public void m8869b(C1401q c1401q) {
        this.f5174b.add(c1401q);
        this.f5177e.add(Integer.valueOf(this.f5174b.size() - 1));
    }

    public int getCount() {
        return this.f5174b.size();
    }

    public Object getItem(int i) {
        return this.f5174b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int i) {
        return this.f5177e.contains(Integer.valueOf(i)) ? 0 : 1;
    }

    public boolean isEnabled(int i) {
        return !this.f5177e.contains(Integer.valueOf(i));
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        this.f5175c = (C1401q) this.f5174b.get(i);
        C2538c.m12674b("NotificationHistoryAdapter", "=======positon======" + i);
        C2538c.m12674b("NotificationHistoryAdapter", "=======Operation======" + this.f5175c.f3151g);
        int i2 = this.f5175c.f3149e;
        this.f5176d = getItemViewType(i);
        if (this.f5176d == 0) {
            return m8825a(view, this.f5175c);
        }
        if (1 == this.f5176d) {
            return m8824a(view, null, i2);
        }
        C2538c.m12674b("NotificationHistoryAdapter", "==========getView=====intType====" + i2);
        C2538c.m12674b("NotificationHistoryAdapter", "==========getView=====intCurrentType====" + this.f5176d);
        return m8822a(view);
    }

    private View m8824a(View view, View view2, int i) {
        C2538c.m12674b("NotificationHistoryAdapter", "==========getListViewItem=====intType====" + i);
        switch (i) {
            case 1:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_fence_out, C1617f.kw_pic_list_electricfence);
            case 2:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_fence_arrive, C1617f.kw_pic_list_electricfence);
            case 3:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_watch_detect, C1617f.kw_pic_list_pickwatch);
            case 4:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_low_battery, C1617f.kw_pic_list_battery_25);
            case 5:
                int c = m8855c(this.f5175c);
                if (-1 != c) {
                    return m8826a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_feature_send_emergency, c);
                }
                return view2;
            default:
                return m8847b(view, view2, i);
        }
    }

    private View m8847b(View view, View view2, int i) {
        C2538c.m12674b("NotificationHistoryAdapter", "==========getViewTypeStartPermission=====intType====" + i);
        switch (i) {
            case 9:
                return m8846b(view, view2);
            case 10:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_become_manager, C1617f.kw_pic_list_administrator);
            case 12:
                return m8823a(view, view2);
            case 14:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_watch_power, C1617f.kw_pic_list_power);
            case 15:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_no_charge, C1617f.kw_pic_list_battery_5);
            default:
                return m8856c(view, view2, i);
        }
    }

    private View m8856c(View view, View view2, int i) {
        C2538c.m12674b("NotificationHistoryAdapter", "==========getViewTypeStartWearOn=====intType====" + i);
        switch (i) {
            case 11:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_become_manager, C1617f.kw_pic_list_administrator);
            case 17:
                return m8848b(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_watch_wear_on, C1617f.kw_pic_list_pickwatch_on);
            case 23:
                return m8828a(view, this.f5175c, this.f5175c.f3152h, C1617f.kw_pic_list_administrator);
            case 26:
                return m8857c(view, this.f5175c, C1680l.IDS_plugin_kidwatch_miss_call_notify, C1617f.ic_mute);
            default:
                C2538c.m12674b("NotificationHistoryAdapter", "==========getViewTypeStartWearOn==default===intType====" + i);
                return m8822a(view);
        }
    }

    private View m8823a(View view, View view2) {
        if (this.f5175c.f3151g == 0 || 1 == this.f5175c.f3151g) {
            return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_add_contact, C1680l.f4388x9cedb620, C1617f.kw_pic_list_contact);
        } else if (2 != this.f5175c.f3151g) {
            return view2;
        } else {
            return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_notification_history_add_contact, C1680l.f4389x7071ef06, C1617f.kw_pic_list_contact);
        }
    }

    private View m8846b(View view, View view2) {
        if (this.f5175c.f3151g == 0 || 1 == this.f5175c.f3151g) {
            if (this.f5175c.f3155k == null || "".equals(this.f5175c.f3155k)) {
                return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_confirm_bind_nothing_finded, C1680l.f4390x7095c4ad, C1617f.kw_pic_list_administrator);
            }
            return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_confirm_bind_name_finded, C1680l.f4390x7095c4ad, C1617f.kw_pic_list_administrator);
        } else if (2 == this.f5175c.f3151g) {
            if (this.f5175c.f3155k == null || "".equals(this.f5175c.f3155k)) {
                return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_confirm_bind_nothing_finded, C1680l.f4391x11cbb219, C1617f.kw_pic_list_administrator);
            }
            return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_confirm_bind_name_finded, C1680l.f4391x11cbb219, C1617f.kw_pic_list_administrator);
        } else if (3 != this.f5175c.f3151g) {
            return view2;
        } else {
            if (this.f5175c.f3155k == null || "".equals(this.f5175c.f3155k)) {
                return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_confirm_bind_nothing_finded, C1680l.IDS_plugin_kidwatch_push_confirm_bind_noavail_operation_message, C1617f.kw_pic_list_administrator);
            }
            return m8827a(view, this.f5175c, C1680l.IDS_plugin_kidwatch_push_confirm_bind_name_finded, C1680l.IDS_plugin_kidwatch_push_confirm_bind_noavail_operation_message, C1617f.kw_pic_list_administrator);
        }
    }

    private View m8825a(View view, C1401q c1401q) {
        at atVar;
        if (view == null) {
            at atVar2 = new at();
            View inflate = LayoutInflater.from(this.f5173a).inflate(h.k1_notification_list_item, null);
            atVar2.f5214c = (LinearLayout) inflate.findViewById(g.menu_llyt_type_information);
            atVar2.f5212a = (LinearLayout) inflate.findViewById(g.menu_llyt_header);
            atVar2.f5219h = (LinearLayout) inflate.findViewById(g.menu_llyt_type_tap);
            atVar2.f5227p = (LinearLayout) inflate.findViewById(g.menu_llyt_type_sos);
            view = m8830a(atVar2, inflate);
            atVar = atVar2;
        } else {
            atVar = (at) view.getTag();
        }
        atVar.f5227p.setVisibility(8);
        atVar.f5214c.setVisibility(8);
        atVar.f5212a.setVisibility(0);
        atVar.f5219h.setVisibility(8);
        atVar.f5213b.setText(c1401q.f3150f);
        return view;
    }

    private View m8826a(View view, C1401q c1401q, int i, int i2) {
        at atVar;
        C1401q c1401q2 = (C1401q) this.f5180h.get(i2);
        if (view == null) {
            atVar = new at();
            view = m8829a(atVar);
        } else {
            atVar = (at) view.getTag();
        }
        m8837a(i, c1401q2, atVar);
        if (2 == ((Integer) this.f5179g.get(i2)).intValue()) {
            atVar.f5233v.setImageResource(C1617f.kw_pic_list_play);
        } else if (3 == ((Integer) this.f5179g.get(i2)).intValue()) {
            atVar.f5233v.setImageResource(C1617f.kw_pic_list_stop);
        }
        m8838a(i2, atVar);
        atVar.f5210D = i2;
        atVar.f5233v.setTag(atVar);
        atVar.f5231t.setTag(atVar);
        m8850b(-1, atVar);
        m8859c(atVar);
        m8852b(atVar);
        return view;
    }

    private void m8837a(int i, C1401q c1401q, at atVar) {
        atVar.f5227p.setVisibility(0);
        atVar.f5214c.setVisibility(8);
        atVar.f5212a.setVisibility(8);
        atVar.f5219h.setVisibility(8);
        atVar.f5234w.setText(String.format(this.f5173a.getResources().getString(i), new Object[]{c1401q.f3148d}));
        m8843a(atVar, C1485e.m6847a(C1492l.m6922f(c1401q.f3150f)));
        if ("".equals(c1401q.f3152h)) {
            atVar.f5237z.setVisibility(8);
        } else {
            atVar.f5237z.setVisibility(0);
            atVar.f5237z.setText(c1401q.f3152h);
        }
        atVar.f5209C.setText(C1893j.m9661a(c1401q.f3154j));
        c1401q.f3155k = TextUtils.isEmpty(c1401q.f3155k) ? "0" : c1401q.f3155k;
        Date b = C1485e.m6859b(C1492l.m6922f(c1401q.f3155k));
        if (b != null) {
            atVar.f5207A.setText(C1485e.m6849a(b, "dd/MM/yyyy"));
        } else {
            atVar.f5207A.setText("00/00/0000");
        }
    }

    private void m8838a(int i, at atVar) {
        if (this.f5178f != null && this.f5178f.f5210D == i && 3 == ((Integer) this.f5179g.get(i)).intValue()) {
            atVar.f5211E.setMax(this.f5184l);
            atVar.f5211E.setProgress(this.f5183k);
            atVar.f5208B.setText(this.f5187o);
            return;
        }
        atVar.f5211E.setMax(0);
        atVar.f5211E.setProgress(0);
        atVar.f5208B.setText("00:00:00");
    }

    private void m8843a(at atVar, String str) {
        if (C1485e.m6854a(this.f5173a)) {
            atVar.f5236y.setVisibility(8);
            atVar.f5235x.setText(C1485e.m6863c(str));
            return;
        }
        atVar.f5236y.setVisibility(0);
        atVar.f5235x.setText(C1485e.m6857b(str));
        atVar.f5236y.setText(C1485e.m6848a(this.f5173a, str));
    }

    private View m8829a(at atVar) {
        View inflate = LayoutInflater.from(this.f5173a).inflate(h.k1_notification_list_item, null);
        atVar.f5214c = (LinearLayout) inflate.findViewById(g.menu_llyt_type_information);
        atVar.f5212a = (LinearLayout) inflate.findViewById(g.menu_llyt_header);
        atVar.f5219h = (LinearLayout) inflate.findViewById(g.menu_llyt_type_tap);
        atVar.f5227p = (LinearLayout) inflate.findViewById(g.menu_llyt_type_sos);
        return m8830a(atVar, inflate);
    }

    private void m8852b(at atVar) {
        atVar.f5233v.setOnClickListener(new ai(this));
    }

    private void m8859c(at atVar) {
        atVar.f5231t.setOnClickListener(new aj(this));
    }

    private void m8861d(at atVar) {
        C1898o.m9669a(new ak(this, atVar), new am(this, atVar));
    }

    private void m8850b(int i, at atVar) {
        atVar.f5228q.setVisibility(8);
        atVar.f5229r.setVisibility(8);
        atVar.f5230s.setVisibility(8);
        atVar.f5232u.clearAnimation();
        if (i == 0) {
            atVar.f5228q.setVisibility(0);
        } else if (1 == i) {
            atVar.f5229r.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f5173a, b.roal);
            if (loadAnimation != null) {
                loadAnimation.setInterpolator(new LinearInterpolator());
                atVar.f5232u.startAnimation(loadAnimation);
            }
        } else if (2 == i) {
            atVar.f5230s.setVisibility(0);
        }
    }

    private View m8822a(View view) {
        at atVar;
        C2538c.m12674b("NotificationHistoryAdapter", "=======notificationInformationError is enter======");
        if (view == null) {
            at atVar2 = new at();
            View inflate = LayoutInflater.from(this.f5173a).inflate(h.k1_notification_list_item, null);
            atVar2.f5214c = (LinearLayout) inflate.findViewById(g.menu_llyt_type_information);
            atVar2.f5212a = (LinearLayout) inflate.findViewById(g.menu_llyt_header);
            atVar2.f5219h = (LinearLayout) inflate.findViewById(g.menu_llyt_type_tap);
            atVar2.f5227p = (LinearLayout) inflate.findViewById(g.menu_llyt_type_sos);
            view = m8830a(atVar2, inflate);
            atVar = atVar2;
        } else {
            atVar = (at) view.getTag();
        }
        atVar.f5214c.setVisibility(0);
        atVar.f5227p.setVisibility(8);
        atVar.f5212a.setVisibility(8);
        atVar.f5219h.setVisibility(8);
        atVar.f5215d.setVisibility(8);
        atVar.f5216e.setText("");
        atVar.f5217f.setText("");
        atVar.f5218g.setText("");
        return view;
    }

    private View m8848b(View view, C1401q c1401q, int i, int i2) {
        at atVar;
        if (view == null) {
            at atVar2 = new at();
            View inflate = LayoutInflater.from(this.f5173a).inflate(h.k1_notification_list_item, null);
            atVar2.f5214c = (LinearLayout) inflate.findViewById(g.menu_llyt_type_information);
            atVar2.f5212a = (LinearLayout) inflate.findViewById(g.menu_llyt_header);
            atVar2.f5219h = (LinearLayout) inflate.findViewById(g.menu_llyt_type_tap);
            atVar2.f5227p = (LinearLayout) inflate.findViewById(g.menu_llyt_type_sos);
            view = m8830a(atVar2, inflate);
            atVar = atVar2;
        } else {
            atVar = (at) view.getTag();
        }
        atVar.f5214c.setVisibility(0);
        atVar.f5227p.setVisibility(8);
        atVar.f5212a.setVisibility(8);
        atVar.f5219h.setVisibility(8);
        String str = c1401q.f3152h;
        int i3 = c1401q.f3149e;
        if (15 == i3) {
            str = "5%";
        } else if (4 == i3) {
            str = "25%";
        } else if (3 == i3) {
            str = "";
        } else if (17 == i3) {
            str = "";
        }
        atVar.f5215d.setImageResource(i2);
        atVar.f5216e.setText(String.format(this.f5173a.getResources().getString(i), new Object[]{c1401q.f3148d, str, Integer.valueOf(3), Integer.valueOf(5)}));
        m8853b(atVar, C1485e.m6847a(C1492l.m6922f(c1401q.f3150f)));
        return view;
    }

    private void m8853b(at atVar, String str) {
        if (C1485e.m6854a(this.f5173a)) {
            atVar.f5218g.setVisibility(8);
            atVar.f5217f.setText(C1485e.m6863c(str));
            return;
        }
        atVar.f5218g.setVisibility(0);
        atVar.f5217f.setText(C1485e.m6857b(str));
        atVar.f5218g.setText(C1485e.m6848a(this.f5173a, str));
    }

    private View m8857c(View view, C1401q c1401q, int i, int i2) {
        at atVar;
        CharSequence format;
        if (view == null) {
            at atVar2 = new at();
            View inflate = LayoutInflater.from(this.f5173a).inflate(h.k1_notification_list_item, null);
            atVar2.f5214c = (LinearLayout) inflate.findViewById(g.menu_llyt_type_information);
            atVar2.f5212a = (LinearLayout) inflate.findViewById(g.menu_llyt_header);
            atVar2.f5219h = (LinearLayout) inflate.findViewById(g.menu_llyt_type_tap);
            atVar2.f5227p = (LinearLayout) inflate.findViewById(g.menu_llyt_type_sos);
            view = m8830a(atVar2, inflate);
            atVar = atVar2;
        } else {
            atVar = (at) view.getTag();
        }
        atVar.f5214c.setVisibility(0);
        atVar.f5227p.setVisibility(8);
        atVar.f5212a.setVisibility(8);
        atVar.f5219h.setVisibility(8);
        String str = c1401q.f3152h;
        atVar.f5215d.setImageResource(i2);
        String str2 = "";
        if ("".equals(str) || str == null) {
            format = String.format(this.f5173a.getResources().getString(C1680l.IDS_plugin_kidwatch_miss_call_no_phonenum_notify), new Object[]{c1401q.f3148d});
        } else {
            format = String.format(this.f5173a.getResources().getString(i), new Object[]{str});
        }
        atVar.f5216e.setText(format);
        m8853b(atVar, C1485e.m6847a(C1492l.m6922f(c1401q.f3150f)));
        return view;
    }

    private View m8828a(View view, C1401q c1401q, String str, int i) {
        at atVar;
        if (view == null) {
            at atVar2 = new at();
            View inflate = LayoutInflater.from(this.f5173a).inflate(h.k1_notification_list_item, null);
            atVar2.f5214c = (LinearLayout) inflate.findViewById(g.menu_llyt_type_information);
            atVar2.f5212a = (LinearLayout) inflate.findViewById(g.menu_llyt_header);
            atVar2.f5219h = (LinearLayout) inflate.findViewById(g.menu_llyt_type_tap);
            atVar2.f5227p = (LinearLayout) inflate.findViewById(g.menu_llyt_type_sos);
            view = m8830a(atVar2, inflate);
            atVar = atVar2;
        } else {
            atVar = (at) view.getTag();
        }
        atVar.f5214c.setVisibility(0);
        atVar.f5227p.setVisibility(8);
        atVar.f5212a.setVisibility(8);
        atVar.f5219h.setVisibility(8);
        atVar.f5215d.setImageResource(i);
        atVar.f5216e.setText(str);
        m8853b(atVar, C1485e.m6847a(C1492l.m6922f(c1401q.f3150f)));
        return view;
    }

    private View m8827a(View view, C1401q c1401q, int i, int i2, int i3) {
        at atVar;
        String str = "";
        if (view == null) {
            at atVar2 = new at();
            View inflate = LayoutInflater.from(this.f5173a).inflate(h.k1_notification_list_item, null);
            atVar2.f5214c = (LinearLayout) inflate.findViewById(g.menu_llyt_type_information);
            atVar2.f5212a = (LinearLayout) inflate.findViewById(g.menu_llyt_header);
            atVar2.f5219h = (LinearLayout) inflate.findViewById(g.menu_llyt_type_tap);
            atVar2.f5227p = (LinearLayout) inflate.findViewById(g.menu_llyt_type_sos);
            view = m8830a(atVar2, inflate);
            atVar = atVar2;
        } else {
            atVar = (at) view.getTag();
        }
        atVar.f5227p.setVisibility(8);
        atVar.f5214c.setVisibility(8);
        atVar.f5212a.setVisibility(8);
        atVar.f5219h.setVisibility(0);
        atVar.f5220i.setImageResource(i3);
        String a = C1485e.m6847a(C1492l.m6922f(c1401q.f3150f));
        if (C1485e.m6854a(this.f5173a)) {
            atVar.f5223l.setVisibility(8);
            atVar.f5222k.setText(C1485e.m6863c(a));
        } else {
            atVar.f5223l.setVisibility(0);
            atVar.f5222k.setText(C1485e.m6857b(a));
            atVar.f5223l.setText(C1485e.m6848a(this.f5173a, a));
        }
        if (1 == c1401q.f3151g || 2 == c1401q.f3151g) {
            m8842a(atVar, c1401q, i2, false);
        } else if (3 == c1401q.f3151g) {
            m8842a(atVar, c1401q, i2, true);
        } else {
            CharSequence format;
            atVar.f5226o.setVisibility(0);
            if (9 == c1401q.f3149e) {
                format = String.format(this.f5173a.getResources().getString(i), new Object[]{c1401q.f3153i, c1401q.f3154j, c1401q.f3148d, c1401q.f3155k});
                m8841a(atVar, c1401q, C1680l.f4391x11cbb219, C1680l.f4390x7095c4ad);
            } else {
                format = String.format(this.f5173a.getResources().getString(i), new Object[]{c1401q.f3148d, c1401q.f3152h});
                m8841a(atVar, c1401q, C1680l.f4389x7071ef06, C1680l.f4388x9cedb620);
            }
            atVar.f5221j.setText(format);
        }
        return view;
    }

    private void m8842a(at atVar, C1401q c1401q, int i, boolean z) {
        CharSequence format;
        String str = "";
        str = "";
        atVar.f5226o.setVisibility(8);
        if (9 == c1401q.f3149e) {
            if (z) {
                str = c1401q.f3148d;
            }
            if (c1401q.f3155k == null || "".equals(c1401q.f3155k)) {
                format = String.format(this.f5173a.getResources().getString(i), new Object[]{c1401q.f3153i, str});
            } else {
                format = String.format(this.f5173a.getResources().getString(i), new Object[]{c1401q.f3155k, str});
            }
        } else {
            format = String.format(this.f5173a.getResources().getString(i), new Object[]{c1401q.f3148d, c1401q.f3152h});
        }
        C2538c.m12674b("NotificationHistoryAdapter", "==ww== strValue==" + format);
        atVar.f5221j.setText(format);
    }

    private void m8841a(at atVar, C1401q c1401q, int i, int i2) {
        atVar.f5224m.setOnClickListener(new an(this, c1401q, atVar, i));
        atVar.f5225n.setOnClickListener(new aq(this, c1401q, atVar, i2));
    }

    private View m8830a(at atVar, View view) {
        atVar.f5213b = (TextView) view.findViewById(g.menu_tv_header);
        atVar.f5215d = (ImageView) view.findViewById(g.menu_iv_information_img);
        atVar.f5216e = (TextView) view.findViewById(g.menu_tv_information_message);
        atVar.f5217f = (TextView) view.findViewById(g.menu_tv_information_time);
        atVar.f5218g = (TextView) view.findViewById(g.menu_tv_information_time_type);
        atVar.f5220i = (ImageView) view.findViewById(g.menu_iv_tap_img);
        atVar.f5221j = (TextView) view.findViewById(g.menu_tv_tap_message);
        atVar.f5222k = (TextView) view.findViewById(g.menu_tv_tap_time);
        atVar.f5223l = (TextView) view.findViewById(g.menu_tv_tap_time_type);
        atVar.f5224m = (Button) view.findViewById(g.menu_btn_tap_reject);
        atVar.f5225n = (Button) view.findViewById(g.menu_btn_tap_allow);
        atVar.f5226o = (LinearLayout) view.findViewById(g.menu_llyt_tap_btn);
        atVar.f5234w = (TextView) view.findViewById(g.menu_tv_sos_message);
        atVar.f5235x = (TextView) view.findViewById(g.menu_tv_sos_time);
        atVar.f5236y = (TextView) view.findViewById(g.menu_tv_sos_time_type);
        atVar.f5237z = (TextView) view.findViewById(g.menu_tv_sos_location);
        atVar.f5207A = (TextView) view.findViewById(g.menu_tv_sos_date);
        atVar.f5208B = (TextView) view.findViewById(g.menu_tv_sos_music_time);
        atVar.f5209C = (TextView) view.findViewById(g.menu_tv_sos_file_name);
        atVar.f5231t = (ImageView) view.findViewById(g.menu_iv_sos_download_img);
        atVar.f5228q = (LinearLayout) view.findViewById(g.menu_layout_sos_download);
        atVar.f5229r = (LinearLayout) view.findViewById(g.menu_layout_sos_downloading);
        atVar.f5230s = (LinearLayout) view.findViewById(g.menu_layout_sos_play);
        atVar.f5233v = (ImageView) view.findViewById(g.menu_iv_sos_play_start_img);
        atVar.f5232u = (ImageView) view.findViewById(g.menu_iv_sos_downloading_img);
        atVar.f5211E = (ProgressBar) view.findViewById(g.menu_iv_sos_play_progress);
        view.setTag(atVar);
        return view;
    }
}
