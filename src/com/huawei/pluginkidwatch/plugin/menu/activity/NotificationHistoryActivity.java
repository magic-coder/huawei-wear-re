package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.huawei.login.ui.login.C1093a;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.p165a.ah;
import java.util.ArrayList;
import java.util.Date;

public class NotificationHistoryActivity extends KidWatchBaseActivity {
    private ListView f5781b;
    private RelativeLayout f5782c;
    private LinearLayout f5783d;
    private ah f5784e;
    private Context f5785f;
    private int f5786g = 0;
    private ArrayList<C1401q> f5787h;
    private int f5788i = 20;
    private int f5789j = 0;
    private View f5790k;
    private boolean f5791l = true;
    private Handler f5792m = new Handler();
    private BroadcastReceiver f5793n;
    private Handler f5794o = new fd(this);
    private OnScrollListener f5795p = new fe(this);

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_notification_history);
        this.f5785f = getApplicationContext();
        this.f5793n = new fg(this);
        LocalBroadcastManager.getInstance(this.f5785f).registerReceiver(this.f5793n, new IntentFilter("com.huawei.pluginkidwatch.plugin.menu.notification.history"));
        this.f5781b = (ListView) findViewById(g.menu_lv_notification_history);
        this.f5783d = (LinearLayout) findViewById(g.menu_llyt_notification_history_nodata);
        this.f5782c = (RelativeLayout) findViewById(g.menu_rlyt_notification_history);
        this.f5790k = getLayoutInflater().inflate(h.notification_footer, null);
        this.f5781b.setOnScrollListener(this.f5795p);
        m9459d();
    }

    private void m9459d() {
        this.f5784e = new ah(this.f5785f);
        m9461e();
        this.f5781b.addFooterView(this.f5790k);
        this.f5781b.setAdapter(this.f5784e);
        this.f5781b.removeFooterView(this.f5790k);
    }

    private void m9461e() {
        C1401q c1401q = new C1401q();
        c1401q.f3146b = C1093a.m4739a(this.f5785f).m4750c();
        if (this.f5787h != null) {
            this.f5787h.clear();
        } else {
            this.f5787h = new ArrayList();
        }
        this.f5787h = C1392h.m6271a(this.f5785f, c1401q);
        this.f5789j = this.f5787h.size();
        if (this.f5789j > 0) {
            if (this.f5789j > this.f5788i) {
                m9453a(0, this.f5788i);
            } else {
                m9453a(0, this.f5789j);
            }
            this.f5794o.sendEmptyMessage(1);
            return;
        }
        this.f5794o.sendEmptyMessage(2);
    }

    private void m9463f() {
        int count = this.f5784e.getCount() - this.f5786g;
        if (this.f5788i + count < this.f5789j) {
            m9453a(count, this.f5788i + count);
        } else {
            m9453a(count, this.f5789j);
        }
    }

    private void m9453a(int i, int i2) {
        if (i == 0) {
            C1401q c1401q = new C1401q();
            c1401q.f3150f = m9452a(0);
            this.f5784e.m8869b(c1401q);
            this.f5786g = 1;
        }
        this.f5784e.m8868a((C1401q) this.f5787h.get(i));
        int i3 = i;
        while (i3 < i2) {
            if (i3 < this.f5789j - 1 && i3 - i < this.f5788i - 1) {
                if (!C1485e.m6847a(C1492l.m6922f(((C1401q) this.f5787h.get(i3)).f3150f)).substring(0, 8).equals(C1485e.m6847a(C1492l.m6922f(((C1401q) this.f5787h.get(i3 + 1)).f3150f)).substring(0, 8))) {
                    c1401q = new C1401q();
                    c1401q.f3150f = m9452a(i3 + 1);
                    this.f5784e.m8869b(c1401q);
                    this.f5786g++;
                }
                this.f5784e.m8868a((C1401q) this.f5787h.get(i3 + 1));
            }
            i3++;
        }
    }

    private String m9452a(int i) {
        Date date = new Date();
        String d = C1485e.m6867d(date);
        String a = C1485e.m6847a(C1492l.m6922f(((C1401q) this.f5787h.get(i)).f3150f));
        String d2 = C1485e.m6867d(C1485e.m6852a(date));
        if (a.startsWith(d)) {
            return getResources().getString(C1680l.IDS_plugin_kidwatch_menu_notification_history_today);
        }
        if (a.startsWith(d2)) {
            return getResources().getString(C1680l.IDS_plugin_kidwatch_menu_notification_history_yesterday);
        }
        return C1485e.m6870g(a);
    }

    protected void onResume() {
        super.onResume();
        C1495o.m6928a(this, 0);
    }

    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this.f5785f).unregisterReceiver(this.f5793n);
        super.onDestroy();
    }
}
