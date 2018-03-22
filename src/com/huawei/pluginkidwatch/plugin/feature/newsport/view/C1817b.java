package com.huawei.pluginkidwatch.plugin.feature.newsport.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1399o;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.Date;
import java.util.List;

/* compiled from: NewSportDayItemView */
public class C1817b extends RelativeLayout {
    private RelativeLayout f5061a = null;
    private TextView f5062b;
    private TextView f5063c;
    private TextView f5064d;
    private TextView f5065e;
    private TextView f5066f;
    private TextView f5067g;
    private TextView f5068h;
    private TextView f5069i;
    private TextView f5070j;
    private TextView f5071k;
    private Date f5072l;
    private NewSportDayDiagramView f5073m;
    private C1399o f5074n = null;

    public void m8681a(List<C1399o> list) {
        String str = "NewSportDayItemView";
        Object[] objArr = new Object[1];
        objArr[0] = "onSportReceivedData... totalSportData = " + (list == null ? "" : list.toString());
        C2538c.m12674b(str, objArr);
        if (list == null || list.size() == 0) {
            this.f5063c.setText(m8675b(0));
            this.f5064d.setText(m8676c(0));
            this.f5065e.setText(m8677d(0));
            this.f5066f.setText(m8678e(0));
            this.f5067g.setText(m8675b(0));
            this.f5068h.setText(m8676c(0));
            this.f5069i.setText(m8677d(0));
            this.f5070j.setText(m8678e(0));
            this.f5073m.m8671a(null, false);
            this.f5062b.setText(String.valueOf(0));
            m8674a(0);
            return;
        }
        int[] iArr = new int[1440];
        int[] iArr2 = new int[1440];
        this.f5074n = new C1399o();
        int[] iArr3 = iArr;
        iArr = iArr2;
        for (C1399o c1399o : list) {
            if (1 == c1399o.m6369d()) {
                this.f5063c.setText(m8675b(c1399o.m6372e()));
                this.f5064d.setText(m8676c(c1399o.m6378g()));
                this.f5065e.setText(m8677d(c1399o.m6380h()));
                this.f5066f.setText(m8678e(c1399o.m6375f()));
                iArr3 = m8682a(c1399o.m6366c());
            } else if (2 == c1399o.m6369d()) {
                this.f5067g.setText(m8675b(c1399o.m6372e()));
                this.f5068h.setText(m8676c(c1399o.m6378g()));
                this.f5069i.setText(m8677d(c1399o.m6380h()));
                this.f5070j.setText(m8678e(c1399o.m6375f()));
                iArr = m8682a(c1399o.m6366c());
            }
            this.f5074n.m6365b(c1399o.m6366c());
            this.f5074n.m6367c(this.f5074n.m6372e() + c1399o.m6372e());
            this.f5074n.m6370d(this.f5074n.m6375f() + c1399o.m6375f());
            this.f5074n.m6376f(c1399o.m6380h() + this.f5074n.m6380h());
        }
        this.f5074n.f3126a = m8683a(iArr3, iArr);
        this.f5073m.m8671a(this.f5074n, false);
        this.f5062b.setText(String.valueOf(this.f5074n.m6372e()));
        m8674a(this.f5074n.m6372e());
    }

    public C1817b(Context context) {
        super(context);
        m8680a(context, null);
    }

    public void m8680a(Context context, AttributeSet attributeSet) {
        this.f5061a = (RelativeLayout) LayoutInflater.from(context).inflate(h.item_newsport_viewpager_day_data, this);
        this.f5073m = (NewSportDayDiagramView) this.f5061a.findViewById(g.sport_ddvs_details_step_diagram_view);
        this.f5062b = (TextView) this.f5061a.findViewById(g.sport_tv_total_step);
        this.f5063c = (TextView) this.f5061a.findViewById(g.sport_tv_total_walk_step);
        this.f5064d = (TextView) this.f5061a.findViewById(g.sport_tv_total_walk_time);
        this.f5065e = (TextView) this.f5061a.findViewById(g.sport_tv_total_walk_distance);
        this.f5066f = (TextView) this.f5061a.findViewById(g.sport_tv_total_walk_calories);
        this.f5067g = (TextView) this.f5061a.findViewById(g.sport_tv_total_run_step);
        this.f5068h = (TextView) this.f5061a.findViewById(g.sport_tv_total_run_time);
        this.f5069i = (TextView) this.f5061a.findViewById(g.sport_tv_total_run_distance);
        this.f5070j = (TextView) this.f5061a.findViewById(g.sport_tv_total_run_calories);
        this.f5071k = (TextView) this.f5061a.findViewById(g.sport_tv_total_expend_power);
    }

    public void m8679a() {
        C2538c.m12674b("NewSportDayItemView", "onResetSportData... DATE = " + this.f5072l.toString());
        String str = "NewSportDayItemView";
        Object[] objArr = new Object[1];
        objArr[0] = "onResetSportData... totalSportData = " + (this.f5074n == null ? null : this.f5074n.toString());
        C2538c.m12674b(str, objArr);
        this.f5063c.setText(m8675b(0));
        this.f5064d.setText(m8676c(0));
        this.f5065e.setText(m8677d(0));
        this.f5066f.setText(m8678e(0));
        this.f5067g.setText(m8675b(0));
        this.f5068h.setText(m8676c(0));
        this.f5069i.setText(m8677d(0));
        this.f5070j.setText(m8678e(0));
        this.f5073m.m8670a();
        this.f5062b.setText(String.valueOf(0));
        m8674a(0);
    }

    private void m8674a(int i) {
        if (i == 0) {
            this.f5071k.setText("");
            return;
        }
        String string;
        String string2;
        if (3000 > i) {
            string = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_movement_less);
            string2 = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_kid_movement_less);
        } else if (3000 > i || 7000 < i) {
            string = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_movement_many);
            string2 = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_kid_health);
        } else {
            string = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_movement_moderate);
            string2 = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_kid_keep);
        }
        this.f5071k.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_movement_advice, new Object[]{string, string2}));
    }

    public void setDate(Date date) {
        this.f5072l = date == null ? null : (Date) date.clone();
    }

    public Date getDate() {
        return this.f5072l;
    }

    public int[] m8682a(String str) {
        int[] iArr = new int[str.length()];
        String[] split = str.split(",");
        for (int i = 360; i < 1320; i++) {
            if (i < split.length) {
                iArr[i] = C1492l.m6920d(split[i]);
            }
        }
        return iArr;
    }

    public int[] m8683a(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[1440];
        for (int i = 0; i < 1440; i++) {
            iArr3[i] = iArr[i] + iArr2[i];
        }
        return iArr3;
    }

    private String m8675b(int i) {
        return i + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_step);
    }

    private String m8676c(int i) {
        String str = "";
        str = "";
        str = "";
        int i2 = i / 60;
        int i3 = i % 60;
        if (i2 > 0) {
            if (i3 == 0) {
                str = i2 + getResources().getString(C1680l.IDS_plugin_kidwatch_common_time_hour);
            } else {
                str = i2 + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_timehour);
                str = str + (i3 + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_timeminute));
            }
        }
        if (i2 == 0) {
            return i3 + getResources().getString(C1680l.IDS_plugin_kidwatch_common_time_minute);
        }
        return str;
    }

    private String m8677d(int i) {
        String str = "";
        if (i == 0) {
            return 0 + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_distance_metre);
        }
        if (i > 0 && i < 1000) {
            return i + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_distance_metre);
        }
        if (i == 1000 || i > 1000) {
            return (((float) i) / 1000.0f) + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_distance_kilometre);
        }
        return str;
    }

    private String m8678e(int i) {
        String str = "";
        if (i == 0) {
            return 0 + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_calories_kcal);
        }
        return (i / 1000) + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_calories_kcal);
    }
}
