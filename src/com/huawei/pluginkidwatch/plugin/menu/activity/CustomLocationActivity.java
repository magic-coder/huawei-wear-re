package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.PositioningFrequency;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomLocationActivity extends KidWatchBaseActivity implements OnClickListener {
    private final String f5628b = "CustomLocationActivity";
    private RelativeLayout f5629c;
    private RelativeLayout f5630d;
    private RelativeLayout f5631e;
    private TextView f5632f;
    private TextView f5633g;
    private TextView f5634h;
    private TextView f5635i;
    private TextView f5636j;
    private TextView f5637k;
    private Context f5638l;
    private ImageView f5639m;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_custom_location);
        m9272d();
    }

    private void m9272d() {
        this.f5638l = this;
        this.f5629c = (RelativeLayout) findViewById(g.menu_location_define_hione);
        this.f5630d = (RelativeLayout) findViewById(g.menu_location_define_hitwo);
        this.f5631e = (RelativeLayout) findViewById(g.menu_location_define_low);
        this.f5632f = (TextView) findViewById(g.menu_location_tv_hione_time);
        this.f5633g = (TextView) findViewById(g.menu_location_tv_hione_str);
        this.f5634h = (TextView) findViewById(g.menu_location_tv_hitwo_time);
        this.f5635i = (TextView) findViewById(g.menu_location_tv_hitwo_str);
        this.f5636j = (TextView) findViewById(g.menu_location_tv_low_time);
        this.f5637k = (TextView) findViewById(g.menu_location_tv_low_str);
        this.f5639m = (ImageView) findViewById(g.addcontact_cancle);
        this.f5639m.setOnClickListener(this);
        this.f5629c.setOnClickListener(this);
        this.f5630d.setOnClickListener(this);
        this.f5631e.setOnClickListener(this);
        List<PositioningFrequency> s = C1462f.m6759s();
        if (s != null) {
            PositioningFrequency positioningFrequency;
            String str;
            CharSequence valueOf;
            Collection arrayList = new ArrayList(s.size() - 1);
            Collection arrayList2 = new ArrayList(s.size());
            for (PositioningFrequency positioningFrequency2 : s) {
                if (positioningFrequency2 == null || positioningFrequency2.getStrategyType() != 2) {
                    arrayList.add(positioningFrequency2);
                } else {
                    arrayList2.add(positioningFrequency2);
                    String str2 = String.valueOf(positioningFrequency2.getStartTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getStartTime()).substring(2, 4);
                    str = String.valueOf(positioningFrequency2.getEndTime()).substring(0, 2) + ":" + String.valueOf(((PositioningFrequency) s.get(2)).getEndTime()).substring(2, 4);
                    valueOf = String.valueOf(positioningFrequency2.getLabel());
                    this.f5636j.setText("");
                    this.f5637k.setText("");
                    this.f5636j.setText(str2 + "-" + str);
                    this.f5637k.setText(valueOf);
                }
            }
            m9270a(arrayList);
            if (arrayList.size() > 0) {
                String str3;
                positioningFrequency2 = (PositioningFrequency) arrayList.get(0);
                if (positioningFrequency2 != null) {
                    str = String.valueOf(positioningFrequency2.getStartTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getStartTime()).substring(2, 4);
                    str3 = String.valueOf(positioningFrequency2.getEndTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getEndTime()).substring(2, 4);
                    valueOf = String.valueOf(positioningFrequency2.getLabel());
                    this.f5632f.setText("");
                    this.f5633g.setText("");
                    this.f5632f.setText(str + "-" + str3);
                    this.f5633g.setText(valueOf);
                }
                if (arrayList.size() > 1) {
                    positioningFrequency2 = (PositioningFrequency) arrayList.get(1);
                    if (positioningFrequency2 != null) {
                        str = String.valueOf(positioningFrequency2.getStartTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getStartTime()).substring(2, 4);
                        str3 = String.valueOf(positioningFrequency2.getEndTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getEndTime()).substring(2, 4);
                        valueOf = String.valueOf(positioningFrequency2.getLabel());
                        this.f5634h.setText(str + "-" + str3);
                        this.f5635i.setText(valueOf);
                    }
                }
            }
            arrayList2.addAll(0, arrayList);
            C1462f.m6759s().clear();
            C1462f.m6759s().addAll(arrayList2);
        }
    }

    public static void m9270a(List<PositioningFrequency> list) {
        if (list != null && list.size() != 0 && 1 != list.size()) {
            Collections.sort(list, new cx());
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        if (g.menu_location_define_hione == id) {
            intent = new Intent();
            intent.putExtra("edittime", "hione");
            intent.setClass(this.f5638l, EditCustomTimeActivity.class);
            startActivity(intent);
        } else if (g.menu_location_define_hitwo == id) {
            intent = new Intent();
            intent.putExtra("edittime", "hitwo");
            intent.setClass(this.f5638l, EditCustomTimeActivity.class);
            startActivity(intent);
        } else if (g.menu_location_define_low == id) {
            intent = new Intent();
            intent.putExtra("edittime", "low");
            intent.setClass(this.f5638l, EditCustomTimeActivity.class);
            startActivity(intent);
        } else if (g.addcontact_cancle == id) {
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        if (C1462f.m6733d()) {
            if (!("".equals(C1462f.m6761u()) || "".equals(C1462f.m6762v()) || "".equals(C1462f.m6763w()) || "".equals(C1462f.m6764x()))) {
                m9273e();
            }
            C1462f.m6727b(false);
        }
        List s = C1462f.m6759s();
        if (s != null) {
            m9271b(s);
        }
    }

    private void m9271b(List<PositioningFrequency> list) {
        List arrayList = new ArrayList(list.size() - 1);
        for (PositioningFrequency positioningFrequency : list) {
            PositioningFrequency positioningFrequency2;
            if (positioningFrequency2 != null && positioningFrequency2.getStrategyType() == 1) {
                arrayList.add(positioningFrequency2);
            }
        }
        m9270a(arrayList);
        if (arrayList.size() > 0) {
            String str;
            CharSequence valueOf;
            positioningFrequency2 = (PositioningFrequency) arrayList.get(0);
            if (positioningFrequency2 != null) {
                str = String.valueOf(positioningFrequency2.getStartTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getStartTime()).substring(2, 4);
                String str2 = String.valueOf(positioningFrequency2.getEndTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getEndTime()).substring(2, 4);
                valueOf = String.valueOf(positioningFrequency2.getLabel());
                this.f5632f.setText("");
                this.f5633g.setText("");
                this.f5632f.setText(str + "-" + str2);
                this.f5633g.setText(valueOf);
            }
            positioningFrequency2 = (PositioningFrequency) arrayList.get(1);
            if (positioningFrequency2 != null) {
                String str3 = String.valueOf(positioningFrequency2.getStartTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getStartTime()).substring(2, 4);
                str = String.valueOf(positioningFrequency2.getEndTime()).substring(0, 2) + ":" + String.valueOf(positioningFrequency2.getEndTime()).substring(2, 4);
                valueOf = String.valueOf(positioningFrequency2.getLabel());
                this.f5634h.setText(str3 + "-" + str);
                this.f5635i.setText(valueOf);
            }
        }
    }

    private void m9273e() {
        if (C1462f.m6761u().equals("hione")) {
            this.f5633g.setText(C1462f.m6764x());
            this.f5632f.setText(C1462f.m6762v() + "-" + C1462f.m6763w());
        } else if (C1462f.m6761u().equals("hitwo")) {
            this.f5634h.setText(C1462f.m6762v() + "-" + C1462f.m6763w());
            this.f5635i.setText(C1462f.m6764x());
        } else if (C1462f.m6761u().equals("low")) {
            this.f5636j.setText(C1462f.m6762v() + "-" + C1462f.m6763w());
            this.f5637k.setText(C1462f.m6764x());
        }
    }
}
