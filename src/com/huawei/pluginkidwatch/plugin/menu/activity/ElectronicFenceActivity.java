package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.FenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;
import com.huawei.pluginkidwatch.common.entity.model.HandleFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.title.CustomTitle;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.common.ui.view.TextImgButton;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.ad;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1901r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ElectronicFenceActivity extends KidWatchBaseActivity {
    protected Handler f5706b = new dv(this);
    private ad f5707c;
    private ArrayList<FenceItem> f5708d = new ArrayList();
    private C1413d f5709e;
    private C1507h f5710f = null;
    private ListView f5711g;
    private TextImgButton f5712h = null;
    private View f5713i = null;
    private ImageView f5714j;
    private C1507h f5715k = null;
    private ArrayList<Integer> f5716l = null;
    private CustomTitle f5717m;
    private int f5718n = 0;
    private Context f5719o = null;
    private TextView f5720p;
    private View f5721q;
    private Button f5722r;
    private OnClickListener f5723s = new dm(this);
    private OnClickListener f5724t = new ds(this);
    private OnClickListener f5725u = new dx(this);
    private OnClickListener f5726v = new dy(this);
    private C1378e f5727w = new dz(this);
    private OnItemLongClickListener f5728x = new dn(this);
    private OnItemClickListener f5729y = new dr(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_electronic_fence);
        this.f5709e = C1417a.m6594a(getApplicationContext());
        this.f5719o = this;
        this.f5712h = (TextImgButton) findViewById(g.menu_electronic_delete_fence);
        this.f5713i = findViewById(g.menu_electronic_add_fence);
        this.f5713i.setEnabled(false);
        this.f5707c = new ad(this);
        this.f5707c.m8818a(this.f5706b);
        this.f5711g = (ListView) findViewById(g.menu_elec_fence_list);
        this.f5711g.setAdapter(this.f5707c);
        this.f5711g.setOnItemClickListener(this.f5729y);
        this.f5711g.setOnItemLongClickListener(this.f5728x);
        this.f5713i.setOnClickListener(this.f5723s);
        this.f5712h.setOnClickListener(this.f5724t);
        this.f5712h.setEnabled(false);
        this.f5714j = (ImageView) findViewById(g.menu_elec_headimage);
        this.f5720p = (TextView) findViewById(g.menu_elec_alert_get_fence_now);
        this.f5721q = findViewById(g.menu_elec_net_panel);
        this.f5722r = (Button) findViewById(g.menu_elec_net_restart);
        this.f5722r.setOnClickListener(this.f5726v);
        C1395k a = C1392h.m6269a(this.f5719o, C1462f.m6744i(), C1462f.m6746j());
        if (2 == a.f3091k) {
            this.f5714j.setImageDrawable(getResources().getDrawable(C1617f.kw_pic_user_boy));
        } else if (1 == a.f3091k) {
            this.f5714j.setImageDrawable(getResources().getDrawable(C1617f.kw_pic_user_girl));
        } else {
            C2538c.m12680e("ElectronicFenceActivity", "=====Can't get the sex of Kid,so used the default image of head");
        }
        C1565a c1565a = new C1565a();
        if (C1462f.m6748k() != null) {
            Bitmap a2 = c1565a.m7218a(this.f5719o, C1462f.m6748k().f3098r);
            if (a2 != null) {
                this.f5714j.setImageBitmap(a2);
            }
        }
        this.f5717m = (CustomTitle) findViewById(g.menu_elec_fence_title);
        this.f5716l = new ArrayList();
        m9364e();
        C1901r.m9679b(false);
    }

    private void m9361d() {
        C2538c.m12674b("ElectronicFenceActivity", "=====================deleteElecFence");
        HandleFenceIOEntityModel handleFenceIOEntityModel = new HandleFenceIOEntityModel();
        this.f5712h.setClickable(false);
        handleFenceIOEntityModel.type = 3;
        if (this.f5716l.size() > 0) {
            C2538c.m12674b("ElectronicFenceActivity", "----deleteSms mFence_deleteFenceId.get(0) is:" + this.f5716l.get(0));
            handleFenceIOEntityModel.fenceId = String.valueOf(this.f5716l.get(0));
            this.f5716l.remove(0);
            m9347a(handleFenceIOEntityModel);
            return;
        }
        this.f5712h.setClickable(true);
    }

    private void m9347a(HandleFenceIOEntityModel handleFenceIOEntityModel) {
        C2538c.m12674b("ElectronicFenceActivity", "=====================Enter deleteFenceFromCloud");
        this.f5709e.mo2488a(handleFenceIOEntityModel, new dt(this, handleFenceIOEntityModel));
    }

    private void m9348a(HandleFenceIOEntityModel handleFenceIOEntityModel, int i) {
        C2538c.m12674b("ElectronicFenceActivity", "=====================Enter deleteOneFenceFromCloud");
        this.f5709e.mo2488a(handleFenceIOEntityModel, new du(this, handleFenceIOEntityModel, i));
    }

    private void m9354a(ArrayList<Integer> arrayList) {
        C2538c.m12674b("ElectronicFenceActivity", "=======Enter deleteFromList 一次删除多个");
        if (arrayList == null || arrayList.size() == 0) {
            C1483c.m6832c(getApplicationContext(), getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_toast_delte_str));
            return;
        }
        C2538c.m12674b("ElectronicFenceActivity", "=======mFence_deleteFenceId.size:", arrayList.size() + "");
        for (int i = 0; i < arrayList.size(); i++) {
            C2538c.m12674b("ElectronicFenceActivity", "=======fencdId:", String.valueOf(arrayList.get(i)));
            int i2 = -1;
            for (int i3 = 0; i3 < this.f5708d.size(); i3++) {
                if (((FenceItem) this.f5708d.get(i3)).getmFenceId().trim().equals(String.valueOf(arrayList.get(i)))) {
                    C2538c.m12674b("ElectronicFenceActivity", "=======index:" + i3);
                    i2 = i3;
                }
            }
            if (-1 != i2) {
                C2538c.m12674b("ElectronicFenceActivity", "====删除一个");
                this.f5708d.remove(i2);
            }
        }
        m9369h();
    }

    private void m9346a(FenceItem fenceItem, int i) {
        C2538c.m12674b("ElectronicFenceActivity", "=========Enter changeFenceState");
        HandleFenceIOEntityModel handleFenceIOEntityModel = new HandleFenceIOEntityModel();
        handleFenceIOEntityModel.fenceId = fenceItem.getmFenceId();
        handleFenceIOEntityModel.type = i;
        C2538c.m12674b("ElectronicFenceActivity", "=========开始关闭电子围栏状态");
        this.f5709e.mo2488a(handleFenceIOEntityModel, new dw(this, i, fenceItem));
    }

    private void m9364e() {
        this.f5708d.clear();
        FenceIOEntityModel fenceIOEntityModel = new FenceIOEntityModel();
        fenceIOEntityModel.deviceCode = C1462f.m6746j();
        this.f5709e.mo2480a(fenceIOEntityModel, this.f5727w);
    }

    private void m9365f() {
        C2538c.m12674b("ElectronicFenceActivity", "===========Enter displayDeleteMode ====");
        this.f5718n = 1;
        Iterator it = this.f5708d.iterator();
        while (it.hasNext()) {
            ((FenceItem) it.next()).setmIsShowCheck(true);
        }
        this.f5713i.setVisibility(8);
        m9369h();
        this.f5717m.setBackBtnBackground(getResources().getDrawable(C1617f.title_delete));
        this.f5717m.getBackBt().setOnClickListener(this.f5725u);
    }

    private void m9367g() {
        C2538c.m12674b("ElectronicFenceActivity", "----displayListMode Enter====");
        this.f5718n = 0;
        Iterator it = this.f5708d.iterator();
        while (it.hasNext()) {
            FenceItem fenceItem = (FenceItem) it.next();
            fenceItem.setmIsShowCheck(false);
            fenceItem.setmIsSelected(false);
        }
        this.f5713i.setVisibility(0);
        m9369h();
        this.f5717m.setBackBtnBackground(null);
    }

    private void m9355a(boolean z) {
        this.f5712h.setEnabled(z);
    }

    private void m9345a(int i, String str) {
        this.f5715k = new C1507h(this.f5719o, h.dialog_contact_delete, m.servicedialog, false);
        TextView textView = (TextView) this.f5715k.findViewById(g.menu_tv_contactdelete_content);
        ((TextView) this.f5715k.findViewById(g.menu_tv_contactdelete_title)).setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_delete));
        textView.setText(getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_delete_content));
        this.f5715k.show();
        ((TextView) this.f5715k.findViewById(g.menu_tv_contactcancle)).setOnClickListener(new dp(this));
        ((TextView) this.f5715k.findViewById(g.menu_tv_suredeletecontact)).setOnClickListener(new dq(this, i, str));
    }

    private void m9349a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    private void m9357b(int i, String str) {
        C2538c.m12674b("ElectronicFenceActivity", "============Enter deleteOneFence ");
        HandleFenceIOEntityModel handleFenceIOEntityModel = new HandleFenceIOEntityModel();
        handleFenceIOEntityModel.type = 3;
        handleFenceIOEntityModel.fenceId = str;
        m9348a(handleFenceIOEntityModel, i);
    }

    private void m9369h() {
        C2538c.m12674b("ElectronicFenceActivity", "=======Enter updateShowingFenceList");
        if (this.f5708d == null || this.f5708d.size() == 0) {
            m9355a(false);
        } else {
            m9355a(true);
        }
        List arrayList = new ArrayList();
        if (this.f5708d == null) {
            this.f5708d = new ArrayList();
        } else {
            arrayList.addAll(this.f5708d);
        }
        this.f5707c.m8819a(arrayList);
    }

    public void onBackClick(View view) {
        C2538c.m12674b("ElectronicFenceActivity", "----onBackClick====");
        if (this.f5718n == 1) {
            m9367g();
        } else {
            onBackPressed();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        C2538c.m12674b("ElectronicFenceActivity", "========Enter onKeyUp");
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (1 == this.f5718n) {
            m9367g();
            return true;
        }
        onBackPressed();
        return true;
    }

    protected void onResume() {
        C2538c.m12674b("ElectronicFenceActivity", "========Enter onResume");
        C2538c.m12674b("ElectronicFenceActivity", "MenuCache.isNEED_UPDATE()==" + C1901r.m9681c());
        if (C1901r.m9681c()) {
            m9364e();
            C1901r.m9679b(false);
        }
        super.onResume();
    }

    protected void onDestroy() {
        C2538c.m12674b("ElectronicFenceActivity", "========Enter onDestroy");
        C1901r.m9679b(false);
        super.onDestroy();
    }
}
