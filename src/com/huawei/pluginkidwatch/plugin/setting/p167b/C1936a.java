package com.huawei.pluginkidwatch.plugin.setting.p167b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1388d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* compiled from: CheckBillAdapter */
public class C1936a extends BaseAdapter {
    private LayoutInflater f6704a;
    private List<C1388d> f6705b = null;
    private C1938c f6706c;
    private Context f6707d;

    public C1936a(Context context, List<C1388d> list) {
        this.f6707d = context;
        this.f6704a = LayoutInflater.from(this.f6707d);
        m10127a((List) list);
    }

    public int getCount() {
        return this.f6705b.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    @SuppressLint({"InflateParams"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6704a.inflate(h.check_bill_listview_item, null);
            m10125a(view);
        } else {
            this.f6706c = (C1938c) view.getTag();
        }
        C1388d c1388d = (C1388d) this.f6705b.get(i);
        if (c1388d == null) {
            c1388d = new C1388d();
        }
        CharSequence charSequence = c1388d.f3041b;
        Date date = new Date(m10122a(i));
        this.f6706c.f6712b.setText(m10123a(date) + C1485e.m6849a(date, "HH:mm") + "");
        this.f6706c.f6711a.setText(C1485e.m6849a(new Date(m10122a(i)), "MM/dd") + "");
        this.f6706c.f6713c.setText(c1388d.f3041b);
        this.f6706c.f6720j.setOnClickListener(new C1937b(this, i, this.f6706c));
        this.f6706c.f6714d.setText(c1388d.f3043d + this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_settings_check_bill_main_feeBalance_unit));
        this.f6706c.f6715e.setText(c1388d.f3044e);
        this.f6706c.f6713c.setText(charSequence);
        m10130c(c1388d);
        m10129b(c1388d);
        m10126a(c1388d);
        return view;
    }

    private void m10125a(View view) {
        this.f6706c = new C1938c();
        this.f6706c.f6711a = (TextView) view.findViewById(g.item_check_bill_time_mmdd_tv);
        this.f6706c.f6712b = (TextView) view.findViewById(g.item_check_bill_time_hhmm_tv);
        this.f6706c.f6713c = (TextView) view.findViewById(g.item_check_bill_content_tv);
        this.f6706c.f6714d = (TextView) view.findViewById(g.item_check_bill_Fee_balance_tv);
        this.f6706c.f6715e = (TextView) view.findViewById(g.item_check_bill_have_message_tv);
        this.f6706c.f6716f = (TextView) view.findViewById(g.item_check_bill_message_time_tv);
        this.f6706c.f6720j = (ImageView) view.findViewById(g.item_check_bill_switch_imageView);
        this.f6706c.f6721k = (RelativeLayout) view.findViewById(g.item_check_bill_Modify_message_relay);
        this.f6706c.f6722l = (RelativeLayout) view.findViewById(g.item_check_bill_Source_message_relay);
        this.f6706c.f6718h = (TextView) view.findViewById(g.item_check_bill_have_message_tv_title);
        this.f6706c.f6719i = (TextView) view.findViewById(g.item_check_bill_message_time_tv_title);
        this.f6706c.f6717g = (TextView) view.findViewById(g.item_check_bill_balance_tv_title);
        view.setTag(this.f6706c);
    }

    private void m10126a(C1388d c1388d) {
        if (c1388d.f3045f) {
            this.f6706c.f6721k.setVisibility(8);
            this.f6706c.f6722l.setVisibility(0);
            this.f6706c.f6720j.setBackground(this.f6707d.getResources().getDrawable(C1617f.bill_kw_telephone_switch_press));
            return;
        }
        this.f6706c.f6721k.setVisibility(0);
        this.f6706c.f6722l.setVisibility(8);
        this.f6706c.f6720j.setBackground(this.f6707d.getResources().getDrawable(C1617f.bill_kw_telephone_switch));
    }

    private void m10129b(C1388d c1388d) {
        if (c1388d.f3043d == null || c1388d.f3043d.isEmpty()) {
            this.f6706c.f6714d.setVisibility(8);
            this.f6706c.f6717g.setVisibility(8);
        } else {
            this.f6706c.f6714d.setVisibility(0);
            this.f6706c.f6717g.setVisibility(0);
        }
        if (c1388d.f3044e == null || c1388d.f3044e.isEmpty()) {
            this.f6706c.f6715e.setVisibility(8);
            this.f6706c.f6718h.setVisibility(8);
        } else {
            this.f6706c.f6715e.setVisibility(0);
            this.f6706c.f6718h.setVisibility(0);
        }
        if (c1388d.f3040a == null || c1388d.f3040a.isEmpty()) {
            this.f6706c.f6716f.setVisibility(8);
            this.f6706c.f6719i.setVisibility(8);
            return;
        }
        this.f6706c.f6716f.setVisibility(0);
        this.f6706c.f6719i.setVisibility(0);
    }

    private void m10130c(C1388d c1388d) {
        if ((c1388d.f3043d == null || c1388d.f3043d.isEmpty()) && (c1388d.f3044e == null || c1388d.f3044e.isEmpty())) {
            c1388d.f3045f = true;
            this.f6706c.f6720j.setVisibility(8);
            return;
        }
        this.f6706c.f6720j.setVisibility(0);
    }

    private void m10127a(List<C1388d> list) {
        if (list.size() <= 20) {
            this.f6705b = list;
        } else {
            this.f6705b = list.subList(list.size() - 20, list.size());
        }
    }

    private long m10122a(int i) {
        return C1492l.m6922f(((C1388d) this.f6705b.get(i)).f3042c);
    }

    public boolean isEnabled(int i) {
        return false;
    }

    private String m10123a(Date date) {
        String[] strArr = new String[]{this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_common_sunday), this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_common_monday), this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_common_tuesday), this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_common_wednesday), this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_common_thursday), this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_common_friday), this.f6707d.getResources().getString(C1680l.IDS_plugin_kidwatch_common_saturday)};
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return strArr[instance.get(7) - 1];
    }
}
