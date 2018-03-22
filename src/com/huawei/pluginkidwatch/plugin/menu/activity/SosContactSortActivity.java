package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.DeviceSOSPhoneIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.entity.model.UserPriority;
import com.huawei.pluginkidwatch.common.entity.p139a.C1414c;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseActivity;
import com.huawei.pluginkidwatch.common.ui.listview.C1521a;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.aw;
import com.huawei.pluginkidwatch.plugin.menu.utils.DragListViewMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SosContactSortActivity extends KidWatchBaseActivity implements OnClickListener {
    private C1507h f5866b = null;
    private DragListViewMenu f5867c;
    private C1521a f5868d;
    private List<UserInfo> f5869e = new ArrayList();
    private C1413d f5870f;
    private DeviceSOSPhoneIOEntityModel f5871g;
    private List<UserPriority> f5872h;
    private ImageView f5873i;
    private ImageView f5874j;

    protected void mo2517a() {
        requestWindowFeature(1);
        setContentView(h.activity_contact_sos_sort);
        this.f5870f = C1414c.m6542a((Context) this);
        this.f5872h = new ArrayList();
        this.f5871g = new DeviceSOSPhoneIOEntityModel();
        this.f5867c = (DragListViewMenu) findViewById(g.menu_lv_soscontact);
        this.f5873i = (ImageView) findViewById(g.menu_im_sort_cancle);
        this.f5874j = (ImageView) findViewById(g.menu_im_sort_ok);
        this.f5873i.setOnClickListener(this);
        this.f5874j.setOnClickListener(this);
        this.f5869e = C1462f.m6728c();
        C1483c.m6824a((Context) this, C1680l.IDS_plugin_kidwatch_menu_order);
        for (UserInfo userInfo : this.f5869e) {
            if (userInfo.deviceCode.equals("addDeviceCode")) {
                this.f5869e.remove(userInfo);
                break;
            }
        }
        this.f5868d = new aw(this, this.f5869e);
        this.f5867c.setAdapter(this.f5868d);
        if (1 < this.f5869e.size()) {
            this.f5867c.setExchangeDataListener(new gd(this));
        }
    }

    public void onBackPressed() {
        if (this.f5866b == null) {
            this.f5866b = new C1507h(this, h.dialog_contact_cancle, m.servicedialog, false);
        }
        this.f5866b.show();
        ((TextView) this.f5866b.findViewById(g.menu_tv_cancle)).setOnClickListener(new ge(this));
        ((TextView) this.f5866b.findViewById(g.menu_tv_sure)).setOnClickListener(new gf(this));
    }

    public void mo2518d() {
        C2538c.m12674b("SosContactSortActivity", "==========Enter onSaveClick()");
        if (1 == this.f5869e.size()) {
            finish();
            return;
        }
        m9531e();
        if (this.f5872h == null || this.f5872h.size() <= 0) {
            C2538c.m12674b("SosContactSortActivity", "==========listUp size = 0");
            return;
        }
        C2538c.m12674b("SosContactSortActivity", "==========listUp size > 0  size==" + this.f5872h.size());
        this.f5871g.deviceCode = C1462f.m6746j();
        this.f5871g.userPriorityList = this.f5872h;
        C1506g.m6978a(this, getResources().getString(C1680l.IDS_plugin_kidwatch_common_saving), false);
        this.f5870f.mo2478a(this.f5871g, new gg(this));
    }

    private void m9531e() {
        C2538c.m12674b("SosContactSortActivity", "========== to   getSosContacList");
        if (this.f5869e == null || this.f5869e.size() <= 0) {
            C2538c.m12674b("SosContactSortActivity", "========== listUs size = 0");
            return;
        }
        C2538c.m12674b("SosContactSortActivity", "========== listUs size > 0");
        for (int i = 0; i < this.f5869e.size(); i++) {
            UserInfo userInfo = (UserInfo) this.f5869e.get(i);
            UserPriority userPriority = new UserPriority();
            userPriority.setHuid(userInfo.huid);
            userPriority.setPriority(i + "");
            userPriority.setId(userInfo.id);
            this.f5872h.add(userPriority);
        }
    }

    private void m9527a(C1507h c1507h) {
        if (c1507h != null) {
            c1507h.cancel();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == g.menu_im_sort_cancle) {
            onBackPressed();
        } else if (id == g.menu_im_sort_ok) {
            Map hashMap = new HashMap();
            hashMap.put("click", "1");
            c.a().a(BaseApplication.m2632b(), a.aa.a(), hashMap, 0);
            mo2518d();
        }
    }

    public void onBackClick(View view) {
        onBackPressed();
        super.onBackClick(view);
    }
}
