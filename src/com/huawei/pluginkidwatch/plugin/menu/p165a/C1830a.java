package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.button.SlipButtonView;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1889e;
import java.util.List;

/* compiled from: AlarmListAdapter */
public class C1830a extends BaseAdapter {
    private LayoutInflater f5145a;
    private List<AlarmItem> f5146b;
    private Context f5147c;
    private Handler f5148d;
    private String f5149e;
    private boolean f5150f;
    private boolean f5151g;

    public C1830a(Context context) {
        this.f5146b = null;
        this.f5148d = null;
        this.f5149e = "12345";
        this.f5150f = true;
        this.f5151g = false;
        this.f5147c = context;
        this.f5145a = LayoutInflater.from(context);
    }

    public C1830a(Context context, boolean z) {
        this(context);
        this.f5151g = z;
    }

    public void m8812a(Handler handler) {
        this.f5148d = handler;
    }

    public int getCount() {
        if (this.f5146b == null) {
            return 0;
        }
        return this.f5146b.size();
    }

    public Object getItem(int i) {
        if (this.f5146b == null) {
            return null;
        }
        return this.f5146b.get(i);
    }

    public long getItemId(int i) {
        if (this.f5146b == null) {
            return 0;
        }
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1832c a;
        if (view == null) {
            C2538c.m12674b("MessageModeAdapter", "getView convertView == null");
            view = this.f5145a.inflate(h.item_peroidlist, viewGroup, false);
            a = m8801a(view);
        } else {
            a = (C1832c) view.getTag();
        }
        AlarmItem alarmItem = (AlarmItem) this.f5146b.get(i);
        if (alarmItem == null || a == null) {
            C2538c.m12674b("MessageModeAdapter", "getView  null == alarmItem || null == holder ");
        } else {
            boolean z;
            a.f5261d = i;
            a.f5262e = alarmItem;
            m8811b(a, alarmItem);
            String a2 = m8802a(alarmItem);
            a.f5260c.setText(m8800a(alarmItem.label, a2, alarmItem.isActive));
            m8807a(a, alarmItem.label);
            alarmItem.isActive = alarmItem.isActive.replace(".0", "");
            if (1 == m8797a(a, alarmItem)) {
                z = true;
            } else {
                z = false;
            }
            m8808a(a, a2, z);
        }
        return view;
    }

    private int m8797a(C1832c c1832c, AlarmItem alarmItem) {
        if ("1.0".equals(alarmItem.isActive) || "1".equals(alarmItem.isActive)) {
            m8805a(c1832c.f5264g, true);
            c1832c.f5259b.setTextColor(this.f5147c.getResources().getColor(d.alarm_item_title_text_color_select));
            c1832c.f5258a.setTextColor(this.f5147c.getResources().getColor(d.item_tv_alarm_content_select));
            return 1;
        }
        m8805a(c1832c.f5264g, false);
        c1832c.f5259b.setTextColor(this.f5147c.getResources().getColor(d.alarm_item_title_text_color_nomel));
        c1832c.f5258a.setTextColor(this.f5147c.getResources().getColor(d.alarm_item_title_text_color_nomel));
        return 0;
    }

    private void m8808a(C1832c c1832c, String str, boolean z) {
        c1832c.f5263f.setChecked(z);
        c1832c.f5263f.setOnChangedListener(new C1831b(this, c1832c, str));
    }

    private void m8811b(C1832c c1832c, AlarmItem alarmItem) {
        Object obj = "";
        String str = "";
        if (alarmItem.startTime.length() == 4) {
            obj = alarmItem.startTime.subSequence(0, 2) + ":" + alarmItem.startTime.subSequence(2, 4);
        }
        c1832c.f5258a.setText(obj);
        if (!this.f5150f) {
            if (alarmItem.endTime.length() == 4) {
                str = alarmItem.endTime.subSequence(0, 2) + ":" + alarmItem.endTime.subSequence(2, 4);
            }
            c1832c.f5258a.setText(obj + " - " + str);
        }
    }

    @NonNull
    private C1832c m8801a(View view) {
        C1832c c1832c = new C1832c();
        c1832c.f5258a = (TextView) view.findViewById(g.item_tv_alarm_content);
        c1832c.f5260c = (TextView) view.findViewById(g.item_tv_alarm_title);
        c1832c.f5259b = (TextView) view.findViewById(g.alarm_item_title);
        c1832c.f5263f = (SlipButtonView) view.findViewById(g.alarm_item_switch);
        c1832c.f5264g = (ImageView) view.findViewById(g.alarm_item_pic);
        view.setTag(c1832c);
        return c1832c;
    }

    private void m8805a(ImageView imageView, boolean z) {
        if (z) {
            if (this.f5151g) {
                imageView.setImageResource(C1617f.kw_pic_settings_watch_default);
            } else {
                imageView.setImageResource(C1617f.kw_pic_settings_alarm_clock_on);
            }
        } else if (this.f5151g) {
            imageView.setImageResource(C1617f.kw_pic_settings_watch_disable);
        } else {
            imageView.setImageResource(C1617f.kw_pic_settings_alarm_clock_off);
        }
    }

    private void m8807a(C1832c c1832c, String str) {
        c1832c.f5259b.setVisibility(8);
    }

    public void m8813a(List<AlarmItem> list) {
        this.f5146b = list;
        notifyDataSetChanged();
    }

    private String m8802a(AlarmItem alarmItem) {
        C2538c.m12674b("AlarmListAdapter", "========== Enter getWeekRemindInfo");
        String str = "";
        if (alarmItem == null) {
            C2538c.m12674b("AlarmListAdapter", "==========null == clock");
            return str;
        }
        alarmItem.cycle = alarmItem.cycle.replace(".0", "");
        if (alarmItem.cycle.contains("-") || alarmItem.cycle.contains(".")) {
            C2538c.m12674b("AlarmListAdapter", "========== contains(negative)");
            return str;
        } else if ("-1".equals(alarmItem.cycle.trim()) || alarmItem.cycle.trim().length() < 1) {
            return "";
        } else {
            str = m8803a(alarmItem, str);
            if (str.length() > 1) {
                str = str.substring(0, str.length() - 1);
            }
            C2538c.m12674b("AlarmListAdapter", "=====holder.label：", str);
            return str;
        }
    }

    private String m8803a(AlarmItem alarmItem, String str) {
        if (7 == alarmItem.cycle.length()) {
            return this.f5147c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_alarm_everyday) + HwAccountConstants.BLANK;
        }
        if (alarmItem.cycle.equals(this.f5149e)) {
            return this.f5147c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_workday) + HwAccountConstants.BLANK;
        }
        return m8810b(alarmItem, str);
    }

    private String m8810b(AlarmItem alarmItem, String str) {
        int i = 0;
        while (i < alarmItem.cycle.trim().length()) {
            if (!".".equals(alarmItem.cycle.substring(i, i + 1)) && C1492l.m6919c(alarmItem.cycle.substring(i, i + 1))) {
                str = m8804a(alarmItem, str, i);
            }
            i++;
        }
        return str;
    }

    private String m8804a(AlarmItem alarmItem, String str, int i) {
        switch (C1492l.m6920d(alarmItem.cycle.substring(i, i + 1))) {
            case 1:
                return str + this.f5147c.getString(C1680l.IDS_plugin_kidwatch_common_monday) + HwAccountConstants.BLANK;
            case 2:
                return str + this.f5147c.getString(C1680l.IDS_plugin_kidwatch_common_tuesday) + HwAccountConstants.BLANK;
            case 3:
                return str + this.f5147c.getString(C1680l.IDS_plugin_kidwatch_common_wednesday) + HwAccountConstants.BLANK;
            case 4:
                return str + this.f5147c.getString(C1680l.IDS_plugin_kidwatch_common_thursday) + HwAccountConstants.BLANK;
            case 5:
                return str + this.f5147c.getString(C1680l.IDS_plugin_kidwatch_common_friday) + HwAccountConstants.BLANK;
            case 6:
                return str + this.f5147c.getString(C1680l.IDS_plugin_kidwatch_common_saturday) + HwAccountConstants.BLANK;
            case 7:
                return str + this.f5147c.getString(C1680l.IDS_plugin_kidwatch_common_sunday) + HwAccountConstants.BLANK;
            default:
                return str;
        }
    }

    private SpannableStringBuilder m8800a(String str, String str2, String str3) {
        if (C1889e.m9657a(str)) {
            str = "";
        } else if (!C1889e.m9657a(str2)) {
            str = str + "  ";
        }
        CharSequence spannableString = new SpannableString(str);
        CharSequence spannableString2 = new SpannableString(str2);
        if ("1".equals(str3)) {
            spannableString.setSpan(new ForegroundColorSpan(-12599099), 0, str.length(), 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(-5066062), 0, str.length(), 33);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spannableString).append(spannableString2);
        return spannableStringBuilder;
    }

    public void m8814a(boolean z) {
        this.f5150f = z;
    }
}
