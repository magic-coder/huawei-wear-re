package com.huawei.pluginaf500.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
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

public class AlarmEditListActivity extends AF500BaseActivity {
    boolean f19709a = false;
    private String f19710b = "AlarmEditListActivity";
    private ListView f19711c;
    private C5813v f19712d;
    private List<Alarm> f19713g;
    private List<Alarm> f19714h;
    private OnClickListener f19715i = new C5810s(this);
    private OnClickListener f19716j = new C5811t(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26507a(h.alarm_edit);
        m26671j();
    }

    private void m26671j() {
        m26672k();
        this.f19711c = (ListView) findViewById(e.listView);
        this.f19712d = new C5813v(this, this);
        this.f19711c.setAdapter(this.f19712d);
        this.f19711c.setOnItemClickListener(new C5808q(this));
    }

    private void m26672k() {
        List l = m26673l();
        if (l == null || l.size() <= 0) {
            this.f19713g = new ArrayList();
        } else {
            this.f19713g = l;
        }
    }

    protected void onResume() {
        super.onResume();
        m26672k();
        this.f19712d.notifyDataSetChanged();
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

    private List<Alarm> m26673l() {
        Collection a = new C3565a(this).m17898a();
        if (a != null) {
            this.f19714h = new ArrayList(a);
        } else {
            this.f19714h = new ArrayList();
        }
        return new C3565a(this).m17898a();
    }

    public void viewOnClick(View view) {
        super.viewOnClick(view);
        int id = view.getId();
        if (id == e.btn_add_alarm) {
            if (this.f19713g.size() >= 3) {
                Toast.makeText(this, getString(h.three_is_largest), 1).show();
            } else {
                startActivity(new Intent(this, AlarmAddActivity.class));
            }
        } else if (id == e.btn_ok) {
            if (m26677p()) {
                C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19715i, this.f19716j);
            } else {
                finish();
            }
        } else if (id == e.btn_cancel) {
            finish();
        }
    }

    public void mo5112a(Message message) {
        super.mo5112a(message);
        switch (message.what) {
            case 3:
                C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
                if (m26677p()) {
                    m26674m();
                    break;
                }
                break;
        }
        switch (C5812u.f19974a[C5793b.m26878a(message.what).ordinal()]) {
            case 1:
                m26676o();
                m26512c();
                m26678q();
                finish();
                return;
            case 2:
                m26512c();
                C5826i.m26921a(this, h.syn_title, h.syn_time_out, h.syn_sure, h.syn_cancel, this.f19715i, this.f19716j);
                return;
            default:
                return;
        }
    }

    private void m26674m() {
        this.f19709a = true;
        C3620c a = C5774a.m26501a(this.f19713g);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26665b(10);
    }

    private void m26675n() {
        this.f19709a = true;
        C3620c a = C5774a.m26501a(this.f19713g);
        if (m26514e() != null) {
            m26514e().m26559a(a.m18151a());
        }
        m26665b(5);
    }

    private void m26665b(int i) {
        C5818a.m26894a().m26895a(C5820c.SYNC_ALARM, i, new C5809r(this));
    }

    private void m26676o() {
        C5818a.m26894a().m26897b(C5820c.SYNC_ALARM);
        this.f19709a = true;
    }

    protected void onDestroy() {
        m26676o();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (m26677p()) {
            C5826i.m26921a(this, h.syn_title, h.syn_note_content, h.syn_sure, h.syn_cancel, this.f19715i, this.f19716j);
        } else {
            super.onBackPressed();
        }
    }

    private boolean m26677p() {
        if (this.f19714h.size() != this.f19713g.size()) {
            return true;
        }
        for (int i = 0; i < this.f19714h.size(); i++) {
            if (!((Alarm) this.f19714h.get(i)).getName().equals(((Alarm) this.f19713g.get(i)).getName())) {
                return true;
            }
            if (!((Alarm) this.f19714h.get(i)).getTime().equals(((Alarm) this.f19713g.get(i)).getTime())) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getSun() != ((Alarm) this.f19713g.get(i)).getSun()) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getMon() != ((Alarm) this.f19713g.get(i)).getMon()) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getTue() != ((Alarm) this.f19713g.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getWed() != ((Alarm) this.f19713g.get(i)).getWed()) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getTue() != ((Alarm) this.f19713g.get(i)).getTue()) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getFri() != ((Alarm) this.f19713g.get(i)).getFri()) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getSta() != ((Alarm) this.f19713g.get(i)).getSta()) {
                return true;
            }
            if (((Alarm) this.f19714h.get(i)).getOnOff() != ((Alarm) this.f19713g.get(i)).getOnOff()) {
                return true;
            }
        }
        return false;
    }

    private void m26678q() {
        new C3565a(this).m17901a(this.f19713g);
    }

    private void m26679r() {
        if (this.f19714h == null || this.f19714h.size() <= 0) {
            new C3565a(this).m17902b();
        } else {
            new C3565a(this).m17901a(this.f19714h);
        }
    }

    protected int mo5104a() {
        return f.act_edit_alarm;
    }
}
