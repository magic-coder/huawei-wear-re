package com.huawei.ui.device.activity.onelevelmenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.bone.C6753R;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.ai;
import com.huawei.ui.commonui.dialog.ak;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.p170a.af;
import com.huawei.ui.device.views.onelevelmenu.dragonelevelsortlistview.C2104c;
import com.huawei.ui.device.views.onelevelmenu.dragonelevelsortlistview.C2209a;
import com.huawei.ui.device.views.onelevelmenu.dragonelevelsortlistview.MenuDragListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OneLevelMenuManagerActivity extends BaseActivity implements C2104c {
    Map<String, byte[]> f7432a = new HashMap();
    private Context f7433b;
    private CustomTitleBar f7434c;
    private C2209a f7435d = null;
    private C1990r f7436e;
    private af f7437f;
    private ArrayList<Integer> f7438g = null;
    private ArrayList<Integer> f7439h = null;
    private ArrayList<Integer> f7440i = null;
    private LinearLayout f7441j;
    private LinearLayout f7442k;
    private MenuDragListView f7443l;
    private LinearLayout f7444m;
    private LinearLayout f7445n;
    private LinearLayout f7446o;
    private LinearLayout f7447p;
    private ImageView f7448q;
    private ImageView f7449r;
    private LinearLayout f7450s;
    private boolean f7451t = false;
    private ai f7452u;
    private AnimationDrawable f7453v;
    private Handler f7454w = new C2115k(this, this);
    private OnClickListener f7455x = new C2109e(this);
    private OnClickListener f7456y = new C2112h(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.activity_one_level_menu_activity);
        m10873b();
        m10877c();
    }

    private void m10873b() {
        this.f7433b = this;
        this.f7436e = C1990r.m10400a(this.f7433b);
        this.f7437f = af.m10306a();
        this.f7438g = new ArrayList();
        this.f7439h = new ArrayList();
        this.f7440i = new ArrayList();
        C2538c.m12677c("OneLevelMenuManagerActivity", "mContactTables size = " + this.f7438g.size());
    }

    private void m10877c() {
        this.f7434c = (CustomTitleBar) d.a(this, e.one_level_menu_titlebar);
        this.f7434c.setRightButtonOnClickListener(new C2107c(this));
        this.f7434c.setLeftButtonOnClickListener(new C2108d(this));
        this.f7441j = (LinearLayout) d.a(this, e.one_level_menu_add_bottom_layout);
        this.f7441j.setOnClickListener(this.f7456y);
        this.f7442k = (LinearLayout) d.a(this, e.one_level_menu_add_bottom_no_content_layout);
        this.f7442k.setOnClickListener(this.f7456y);
        this.f7444m = (LinearLayout) d.a(this, e.one_level_menu_bottom_textview);
        this.f7445n = (LinearLayout) d.a(this, e.one_level_menu_loading_view);
        this.f7449r = (ImageView) d.a(this, e.one_level_menu_loading_image);
        this.f7453v = (AnimationDrawable) this.f7433b.getResources().getDrawable(C6753R.drawable.app_update_checking);
        this.f7449r.setBackground(this.f7453v);
        this.f7446o = (LinearLayout) d.a(this, e.one_level_menu_retry_view);
        this.f7447p = (LinearLayout) d.a(this, e.one_level_menu_listview);
        this.f7450s = (LinearLayout) d.a(this, e.one_level_menu_no_content_view);
        this.f7448q = (ImageView) d.a(this, e.one_level_menu_retry_image);
        this.f7448q.setOnClickListener(this.f7455x);
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===mOneMenuHandler=" + this.f7454w);
        this.f7443l = (MenuDragListView) d.a(this, e.one_level_menu_drag_list);
        this.f7454w.sendEmptyMessage(2);
        this.f7454w.sendEmptyMessageDelayed(3, 5000);
        this.f7435d = new C2209a(this.f7433b, this.f7438g, this);
        this.f7443l.setAdapter(this.f7435d);
        m10894k();
    }

    private void m10880d() {
        C2538c.m12677c("OneLevelMenuManagerActivity", "Enter dealBackButton");
        C2538c.m12677c("OneLevelMenuManagerActivity", "Enter dealBackButton mMenuTables" + this.f7438g);
        C2538c.m12677c("OneLevelMenuManagerActivity", "Enter dealBackButton mMenuItemFromBandTables" + this.f7440i);
        if (this.f7437f.m10312b(this.f7438g, this.f7440i)) {
            finish();
        } else {
            m10882e();
        }
    }

    private void m10882e() {
        C2538c.m12677c("OneLevelMenuManagerActivity", "showPromptSaveDialog()");
        ak akVar = new ak(this);
        akVar.a(i.IDS_alarm_settings_save_changes).a(this.f7433b.getResources().getString(i.IDS_save).toUpperCase(), new C2111g(this)).b(this.f7433b.getResources().getString(i.IDS_btn_discard).toUpperCase(), new C2110f(this));
        this.f7452u = akVar.a();
        this.f7452u.setCancelable(false);
        if (!this.f7452u.isShowing()) {
            this.f7452u.show();
        }
    }

    private void m10884f() {
        if (this.f7438g == null || this.f7438g.size() <= 0) {
            this.f7444m.setVisibility(8);
            this.f7450s.setVisibility(0);
            this.f7442k.setVisibility(0);
            this.f7441j.setVisibility(8);
            return;
        }
        C2538c.m12680e("OneLevelMenuManagerActivity", "get null DBdata, the activity will be shut down!");
        this.f7444m.setVisibility(0);
        this.f7450s.setVisibility(8);
        this.f7442k.setVisibility(8);
        this.f7441j.setVisibility(0);
    }

    private void m10869a(MenuDragListView menuDragListView, C2209a c2209a) {
        if (c2209a != null && c2209a.getCount() != 0) {
            View view = c2209a.getView(0, null, menuDragListView);
            view.measure(0, 0);
            int measuredHeight = view.getMeasuredHeight();
            int dividerHeight = menuDragListView.getDividerHeight();
            LayoutParams layoutParams = menuDragListView.getLayoutParams();
            layoutParams.width = -1;
            if (c2209a.getCount() > 7) {
                layoutParams.height = (int) (((double) (measuredHeight + dividerHeight)) * 7.5d);
            } else {
                layoutParams.height = (measuredHeight + dividerHeight) * c2209a.getCount();
            }
            menuDragListView.setLayoutParams(layoutParams);
        }
    }

    private void m10885g() {
        Intent intent = new Intent();
        intent.setClass(this.f7433b, OneLevelMenuAddActivity.class);
        intent.putIntegerArrayListExtra("intent_to_next_all_list", this.f7439h);
        intent.putIntegerArrayListExtra("intent_to_next_open_list", this.f7438g);
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123====mMenuTables" + this.f7438g);
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123====mAllList" + this.f7439h);
        startActivityForResult(intent, 1);
    }

    private void m10887h() {
        C2538c.m12677c("OneLevelMenuManagerActivity", "saveData() data mContactTables = " + this.f7438g);
        if (this.f7436e == null) {
            C2538c.m12677c("OneLevelMenuManagerActivity", "mDeviceSettingsInteractors of saveData error null!");
            return;
        }
        if (C1988p.m10381a(this.f7433b).m10396d() != 2) {
            a.b(this.f7433b, i.IDS_music_management_disconnection);
        }
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123====mOneLevelMenuInteractor.isListEqual(mMenuTables,mMenuItemFromBandTables)" + this.f7437f.m10312b(this.f7438g, this.f7440i));
        m10891j();
    }

    protected void onDestroy() {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===onDestroy");
        super.onDestroy();
        m10890i();
    }

    private void m10890i() {
        if (this.f7454w != null) {
            this.f7454w.removeCallbacksAndMessages(null);
        }
    }

    public void mo2637a() {
        m10869a(this.f7443l, this.f7435d);
        this.f7454w.sendEmptyMessage(1);
    }

    private void m10870a(boolean z) {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===showLoadingView isShow" + z);
        if (z) {
            this.f7444m.setVisibility(8);
            this.f7447p.setVisibility(8);
            this.f7446o.setVisibility(8);
            this.f7445n.setVisibility(0);
            this.f7441j.setVisibility(8);
            this.f7453v.start();
            return;
        }
        this.f7444m.setVisibility(0);
        this.f7447p.setVisibility(0);
        this.f7441j.setVisibility(0);
        this.f7446o.setVisibility(8);
        this.f7445n.setVisibility(8);
        this.f7453v.stop();
    }

    private void m10875b(boolean z) {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===showRetryView isShow=");
        if (z) {
            this.f7444m.setVisibility(8);
            this.f7447p.setVisibility(8);
            this.f7446o.setVisibility(0);
            this.f7445n.setVisibility(8);
            this.f7441j.setVisibility(8);
            return;
        }
        this.f7444m.setVisibility(0);
        this.f7447p.setVisibility(0);
        this.f7441j.setVisibility(0);
        this.f7446o.setVisibility(8);
        this.f7445n.setVisibility(8);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2538c.m12677c("OneLevelMenuManagerActivity", "requestCode=" + i + "， resultCode=" + i2);
        switch (i2) {
            case 1:
                C2538c.m12677c("OneLevelMenuManagerActivity", "===123====mMenuTables fromnext mMenuTables" + this.f7438g);
                this.f7438g.addAll(intent.getIntegerArrayListExtra("intent_from_next_open_list"));
                this.f7454w.sendEmptyMessage(5);
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        m10880d();
        return false;
    }

    private void m10891j() {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===Enter sendDataToBand");
        this.f7436e.m10424b(this.f7433b, this.f7438g, new C2113i(this));
    }

    private void m10894k() {
        C2538c.m12677c("OneLevelMenuManagerActivity", "===123===Enter getDataFromBand()");
        this.f7436e.m10423b(this.f7433b, new C2114j(this));
    }
}
