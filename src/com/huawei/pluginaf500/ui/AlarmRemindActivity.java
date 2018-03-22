package com.huawei.pluginaf500.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.fenda.hwbracelet.mode.Alarm;
import com.fenda.hwbracelet.mode.C3620c;
import com.fenda.p255a.p256a.C3565a;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.p498b.C5774a;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import com.huawei.pluginaf500.utils.C5826i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AlarmRemindActivity extends AF500BaseActivity {
    Button f19717a;
    boolean f19718b = false;
    private ListView f19719c;
    private ad f19720d;
    private List<Alarm> f19721g;
    private List<Alarm> f19722h;
    private boolean f19723i = true;
    private OnClickListener f19724j = new aa(this);
    private OnClickListener f19725k = new ab(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.alarm_clock);
        m26692j();
    }

    private void m26692j() {
        this.f19717a = (Button) findViewById(e.btn_edit);
        m26693k();
        this.f19719c = (ListView) findViewById(e.listView);
        this.f19720d = new ad(this, this);
        this.f19719c.setAdapter(this.f19720d);
        this.f19719c.setOnItemClickListener(new C5816y(this));
    }

    private void m26693k() {
        List l = m26694l();
        if (l == null || l.size() <= 0) {
            this.f19721g = new ArrayList();
        } else {
            this.f19721g = l;
        }
    }

    protected void onResume() {
        super.onResume();
        m26693k();
        this.f19720d.notifyDataSetChanged();
        if (this.f19721g == null || this.f19721g.size() == 0) {
            this.f19717a.setText(h.alarm_add);
        } else {
            this.f19717a.setText(h.alarm_edit);
        }
        IntentFilter intentFilter = new IntentFilter("com.fenda.hwbracelet.CONNECTION_STATE");
        intentFilter.addAction("com.fenda.hwbracelet.ALARM_SET_FAIL");
        intentFilter.addAction("com.fenda.hwbracelet.ALARM_SET_SUCCESS");
        m26508a(intentFilter);
    }

    protected void onStop() {
        super.onStop();
        m26513d();
        this.e = false;
    }

    private List<Alarm> m26694l() {
        Collection a = new C3565a(this).m17898a();
        if (a != null) {
            this.f19722h = new ArrayList(a);
        } else {
            this.f19722h = new ArrayList();
        }
        return new C3565a(this).m17898a();
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        if (view.getId() != e.btn_edit) {
            return;
        }
        if (this.f19721g == null || this.f19721g.size() == 0) {
            startActivity(new Intent(this, AlarmAddActivity.class));
        } else {
            startActivity(new Intent(this, AlarmEditListActivity.class));
        }
    }

    public void mo5112a(Message message) {
        super.mo5112a(message);
        switch (message.what) {
            case 3:
                C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
                if (m26698p()) {
                    m26695m();
                    break;
                }
                break;
        }
        switch (ac.f19873a[C5793b.m26878a(message.what).ordinal()]) {
            case 1:
                m26697o();
                m26512c();
                m26699q();
                return;
            case 2:
                m26512c();
                C5826i.m26921a(this, h.syn_title, h.syn_time_out, h.syn_sure, h.syn_cancel, this.f19724j, this.f19725k);
                return;
            default:
                return;
        }
    }

    private void m26695m() {
        this.f19718b = true;
        C3620c a = C5774a.m26501a(this.f19721g);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26684b(10);
    }

    private void m26696n() {
        this.f19718b = true;
        C3620c a = C5774a.m26501a(this.f19721g);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26684b(5);
    }

    private void m26684b(int i) {
        C5818a.m26894a().m26895a(C5820c.SYNC_ALARM, i, new C5817z(this));
    }

    private void m26697o() {
        C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
        this.f19718b = true;
    }

    protected void onDestroy() {
        m26697o();
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private boolean m26698p() {
        if (this.f19722h.size() != this.f19721g.size()) {
            return true;
        }
        for (int i = 0; i < this.f19722h.size(); i++) {
            if (!((Alarm) this.f19722h.get(i)).getName().equals(((Alarm) this.f19721g.get(i)).getName())) {
                return true;
            }
            if (!((Alarm) this.f19722h.get(i)).getTime().equals(((Alarm) this.f19721g.get(i)).getTime())) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getSun() != ((Alarm) this.f19721g.get(i)).getSun()) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getMon() != ((Alarm) this.f19721g.get(i)).getMon()) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getTue() != ((Alarm) this.f19721g.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getWed() != ((Alarm) this.f19721g.get(i)).getWed()) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getTue() != ((Alarm) this.f19721g.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getFri() != ((Alarm) this.f19721g.get(i)).getFri()) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getSta() != ((Alarm) this.f19721g.get(i)).getSta()) {
                return true;
            }
            if (((Alarm) this.f19722h.get(i)).getOnOff() != ((Alarm) this.f19721g.get(i)).getOnOff()) {
                return true;
            }
        }
        return false;
    }

    private void m26699q() {
        new C3565a(this).m17901a(this.f19721g);
        m26693k();
        this.f19720d.notifyDataSetChanged();
    }

    private void m26700r() {
        if (this.f19722h == null || this.f19722h.size() <= 0) {
            new C3565a(this).m17902b();
            return;
        }
        new C3565a(this).m17901a(this.f19722h);
        Collection a = new C3565a(this).m17898a();
        if (a != null) {
            this.f19721g = new ArrayList(a);
        } else {
            this.f19721g = new ArrayList();
        }
        if (this.f19720d != null) {
            this.f19720d.notifyDataSetChanged();
        }
    }

    protected int mo5104a() {
        return f.act_alarm_list;
    }
}
