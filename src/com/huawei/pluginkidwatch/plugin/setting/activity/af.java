package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.l.a.c;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.activity.ImportContactActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: InviteManagerActivity */
class af implements OnClickListener {
    final /* synthetic */ InviteManagerActivity f6586a;

    af(InviteManagerActivity inviteManagerActivity) {
        this.f6586a = inviteManagerActivity;
    }

    public void onClick(View view) {
        if (g.btn_next == view.getId()) {
            Map hashMap = new HashMap();
            hashMap.put("click", "1");
            c.a().a(BaseApplication.m2632b(), a.X.a(), hashMap, 0);
            if ("".equals(this.f6586a.f6348n.getText().toString())) {
                C1483c.m6824a(this.f6586a, C1680l.IDS_plugin_kidwatch_settings_invite_relation_not_null);
            } else if ("".equals(this.f6586a.f6349o.getText().toString())) {
                C1483c.m6824a(this.f6586a, C1680l.IDS_plugin_kidwatch_settings_invite_phonenumber_not_null);
            } else {
                String replaceAll = this.f6586a.f6349o.getText().toString().replaceAll(HwAccountConstants.BLANK, "");
                if (replaceAll.startsWith("+86") && replaceAll.length() != 14) {
                    C1483c.m6824a(this.f6586a, C1680l.IDS_plugin_kidwatch_settings_invite_failed_wrong_number);
                } else if (replaceAll.startsWith("+86") || replaceAll.length() == 11) {
                    int i;
                    String obj = this.f6586a.f6349o.getText().toString();
                    replaceAll = C1497q.m6945b(this.f6586a.f6331B, "managerphonenumber", "");
                    if (!"".equals(replaceAll)) {
                        String[] split = replaceAll.split(SNBConstant.FILTER);
                        if (split != null && split.length > 0) {
                            for (Object equals : split) {
                                if (obj.equals(equals)) {
                                    C1483c.m6824a(this.f6586a.f6331B, C1680l.IDS_plugin_kidwatch_settings_invite_failed_ismanager);
                                    C2538c.m12680e("InviteManagerActivity", "==ww== is already manager");
                                    i = 1;
                                    break;
                                }
                            }
                        }
                    }
                    boolean z = false;
                    if (i == 0) {
                        this.f6586a.f6357w = new C1507h(this.f6586a, SdkConstants.REQUEST_CAMERA_VIDEO, 181, h.dialog_send_massage, m.servicedialog, false);
                        this.f6586a.f6357w.show();
                        this.f6586a.f6357w.findViewById(g.menu_tv_sendmsm_cancle).setOnClickListener(new ag(this));
                        this.f6586a.f6357w.findViewById(g.menu_tv_sendmsm_sure).setOnClickListener(new ah(this));
                    }
                } else {
                    C1483c.m6824a(this.f6586a, C1680l.IDS_plugin_kidwatch_settings_invite_failed_wrong_number);
                }
            }
        } else if (g.setting_tv_improt == view.getId()) {
            this.f6586a.startActivity(new Intent(this.f6586a, ImportContactActivity.class));
        } else if (g.iv_relation_mid_mom == view.getId()) {
            this.f6586a.f6360z = "2";
            m10099a(0, 4, 4, 4, this.f6586a.f6352r);
        } else if (g.iv_relation_mid_dad == view.getId()) {
            this.f6586a.f6360z = "1";
            m10099a(4, 0, 4, 4, this.f6586a.f6353s);
        } else if (g.iv_relation_mid_grandma == view.getId()) {
            this.f6586a.f6360z = "4";
            m10099a(4, 4, 0, 4, this.f6586a.f6355u);
        } else if (g.iv_relation_mid_grandpa == view.getId()) {
            this.f6586a.f6360z = "3";
            m10099a(4, 4, 4, 0, this.f6586a.f6354t);
        } else if (g.iv_cancle == view.getId()) {
            this.f6586a.f6360z = "0";
            if (this.f6586a.f6330A) {
                C2538c.m12674b("InviteManagerActivity", "=========从导航进入邀请界面，这是点击back，则直接跳到HomeActivity.java");
                this.f6586a.m9843d();
            } else {
                C2538c.m12674b("InviteManagerActivity", "=========finish 自己不跳转");
            }
            this.f6586a.finish();
        }
    }

    private void m10099a(int i, int i2, int i3, int i4, String str) {
        this.f6586a.f6348n.getText().clear();
        this.f6586a.f6343i.setVisibility(i);
        this.f6586a.f6344j.setVisibility(i2);
        this.f6586a.f6345k.setVisibility(i3);
        this.f6586a.f6346l.setVisibility(i4);
        this.f6586a.f6348n.setText(str);
        C1462f.m6743h(str);
    }
}
