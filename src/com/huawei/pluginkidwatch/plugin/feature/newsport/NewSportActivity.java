package com.huawei.pluginkidwatch.plugin.feature.newsport;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.p138a.C1399o;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1499a;
import com.huawei.pluginkidwatch.common.ui.p150a.C1500b;
import com.huawei.pluginkidwatch.common.ui.p150a.C1509k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1510l;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.feature.newsport.p163a.C1804a;
import com.huawei.pluginkidwatch.plugin.feature.newsport.view.C1817b;
import com.huawei.pluginkidwatch.plugin.feature.newsport.view.NewSportCanScrollViewPager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NewSportActivity extends KidWatchBaseActivity implements OnClickListener {
    private static int f4966c = 1;
    protected Date f4967b = null;
    private ImageView f4968d;
    private ImageView f4969e;
    private RelativeLayout f4970f;
    private TextView f4971g;
    private TextView f4972h;
    private List<Date> f4973i;
    private NewSportCanScrollViewPager f4974j;
    private C1804a<C1817b> f4975k;
    private C1510l f4976l = new C1510l();
    private C1413d f4977m;
    private Context f4978n;
    private String f4979o = "yyyy年MM月dd日";
    private C1509k f4980p = new C1812g(this);
    private Handler f4981q = new C1813h(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_new_sport);
        this.f4978n = this;
        this.f4977m = C1417a.m6594a(this.f4978n);
        this.f4968d = (ImageView) findViewById(g.feature_llyt_sport_topleft);
        this.f4969e = (ImageView) findViewById(g.feature_llyt_sport_topright);
        this.f4970f = (RelativeLayout) findViewById(g.feature_rlyt_sport_title_right);
        this.f4971g = (TextView) findViewById(g.feature_tv_sport_title_right);
        this.f4972h = (TextView) findViewById(g.feature_ftv_sport_data_detail_time);
        this.f4968d.setOnClickListener(this);
        this.f4969e.setOnClickListener(this);
        this.f4969e.setEnabled(false);
        this.f4970f.setOnClickListener(this);
        this.f4972h.setOnClickListener(this);
        this.f4972h.setText(C1485e.m6861c());
        this.f4971g.setText(C1485e.m6861c().substring(8, 10));
        this.f4974j = (NewSportCanScrollViewPager) findViewById(g.feature_vp_sport_detail_day_viewpager);
        this.f4973i = new ArrayList();
        this.f4967b = new Date(System.currentTimeMillis());
        this.f4973i.add(this.f4967b);
        this.f4973i.add(0, C1485e.m6852a(this.f4967b));
        m8616e();
        this.f4974j.setAdapter(this.f4975k);
        this.f4974j.setOnPageChangeListener(this.f4975k.f4983b);
        this.f4974j.setCurrentItem(1);
        m8619f();
        m8621g();
    }

    private void m8610a(Date date) {
        this.f4973i.clear();
        this.f4974j.removeAllViews();
        this.f4967b = date;
        this.f4973i.add(this.f4967b);
        this.f4973i.add(0, C1485e.m6852a(this.f4967b));
        this.f4975k.m8632a(this.f4973i);
        this.f4975k.notifyDataSetChanged();
        this.f4974j.setAdapter(this.f4975k);
        this.f4974j.setCurrentItem(1);
    }

    public C1817b m8623a(int i) {
        if (this.f4976l == null) {
            return null;
        }
        View a = this.f4976l.m6983a(i);
        if (a == null) {
            return null;
        }
        return a instanceof C1817b ? (C1817b) a : null;
    }

    private C1817b m8612b(Date date) {
        C1817b c1817b = new C1817b(this);
        c1817b.setDate(date);
        return c1817b;
    }

    private C1817b m8606a(int i, Date date) {
        View b = m8612b(date);
        this.f4976l.m6984a(i, b);
        return b;
    }

    private void m8616e() {
        this.f4975k = new C1811f(this, this.f4973i, this.f4976l, this.f4981q);
    }

    public void onClick(View view) {
        C2538c.m12674b("NewSportActivity", "view.getId() = " + view.getId());
        String trim = this.f4972h.getText().toString().trim();
        Iterator it = this.f4973i.iterator();
        while (it.hasNext()) {
            C2538c.m12674b("TAG", C1485e.m6849a((Date) it.next(), "yyyy年MM月dd日"));
        }
        String b;
        Date a;
        if (g.feature_llyt_sport_topleft == view.getId()) {
            this.f4969e.setEnabled(true);
            this.f4970f.setVisibility(0);
            b = C1485e.m6858b(trim, "yyyy年MM月dd日");
            if (b != null) {
                C2538c.m12674b("NewSportActivity", "getCurrentDayDate...  preDate = " + C1485e.m6851a(C1485e.m6866d(b)));
                C1499a.m6962a(a);
            }
            if (this.f4974j != null) {
                this.f4974j.setCurrentItem(this.f4974j.getCurrentItem() - 1, false);
            }
        } else if (g.feature_llyt_sport_topright == view.getId()) {
            b = C1485e.m6864c(trim, "yyyy年MM月dd日");
            if (b != null) {
                Date a2 = C1485e.m6851a(C1485e.m6866d(b));
                C2538c.m12674b("NewSportActivity", "getCurrentDayDate...  strNextDate = " + b);
                C1499a.m6962a(a2);
            }
            if (this.f4974j != null) {
                this.f4974j.setCurrentItem(this.f4974j.getCurrentItem() + 1, false);
            }
            if (C1485e.m6861c().equals(b)) {
                this.f4969e.setEnabled(false);
                this.f4970f.setVisibility(8);
            }
        } else if (g.feature_ftv_sport_data_detail_time == view.getId()) {
            C1500b.m6965a(this.f4978n, C1485e.m6851a(C1485e.m6866d(trim)), this.f4980p);
        } else if (g.feature_rlyt_sport_title_right == view.getId()) {
            a = C1485e.m6851a(C1485e.m6866d(C1485e.m6861c()));
            m8610a(a);
            m8619f();
            this.f4972h.setText(C1485e.m6861c());
            this.f4969e.setEnabled(false);
            this.f4970f.setVisibility(8);
            C1499a.m6962a(a);
        }
    }

    private void m8619f() {
        Message obtainMessage = this.f4981q.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = Long.valueOf(this.f4967b.getTime());
        obtainMessage.arg1 = f4966c;
        obtainMessage.sendToTarget();
    }

    private void m8621g() {
        new C1814i(this, this.f4978n, this.f4977m, this.f4967b).execute(new String[0]);
    }

    public void m8626a(long j, boolean z) {
        new C1815j(this, getApplicationContext(), C1810e.SportData, z).execute(new Long[]{Long.valueOf(j)});
    }

    public void m8625a(long j) {
        m8626a(j, true);
    }

    public void m8627a(List<C1399o> list) {
        C2538c.m12674b("NewSportActivity", "======updataDaySportUI========");
        C1817b a = m8623a(this.f4974j.getCurrentItem());
        if (a != null) {
            a.m8681a((List) list);
        }
    }

    protected void onPause() {
        super.onPause();
        C2538c.m12674b("NewSportActivity", "*****NewSportActivity onPause*****");
    }

    protected void onResume() {
        super.onResume();
        C2538c.m12674b("NewSportActivity", "*****NewSportActivity onResume*****");
    }

    protected void onDestroy() {
        super.onDestroy();
        C2538c.m12674b("NewSportActivity", "*****NewSportActivity onDestroy*****");
    }

    protected void onStart() {
        super.onStart();
        C2538c.m12674b("NewSportActivity", "*****NewSportActivity onStart*****");
    }

    protected void onStop() {
        super.onStop();
        C2538c.m12674b("NewSportActivity", "*****NewSportActivity onStop*****");
    }
}
