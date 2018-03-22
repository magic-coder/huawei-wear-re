package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1901r;

/* compiled from: AddFenceActivity */
class C1882x implements C1378e {
    final /* synthetic */ AddFenceActivity f6190a;

    C1882x(AddFenceActivity addFenceActivity) {
        this.f6190a = addFenceActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("AddFenceActivity", "==========onResponse");
        if (this.f6190a.isFinishing()) {
            C2538c.m12674b("AddFenceActivity", "===== addFence 页面已经被杀死，不再去更新");
            return;
        }
        this.f6190a.ab.setVisibility(8);
        this.f6190a.ab.m7206a(false);
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("AddFenceActivity", "==========保存成功");
            C1901r.m9679b(true);
            if (this.f6190a.f5462v != null) {
                C2538c.m12674b("AddFenceActivity", "=========电子围栏保存最后一次定位的位置：", this.f6190a.f5449i.toJson(this.f6190a.f5462v));
                C1497q.m6943a(this.f6190a.f5418C, "save_fence_map_last_app_position", r0);
            }
            this.f6190a.finish();
        } else if (baseEntityModel != null && 13205 == baseEntityModel.retCode) {
            C2538c.m12674b("AddFenceActivity", "==========保存失败,添加电子围栏达到上限");
            this.f6190a.f5431P = false;
            this.f6190a.f5426K.setClickable(true);
            C1483c.m6832c(this.f6190a.f5418C, this.f6190a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_limit_up));
        } else if (baseEntityModel == null || 13204 != baseEntityModel.retCode) {
            C2538c.m12674b("AddFenceActivity", "==========保存失败,将保存按钮置为可点击");
            this.f6190a.f5431P = false;
            this.f6190a.f5426K.setClickable(true);
            C1483c.m6824a(this.f6190a.f5418C, C1680l.IDS_plugin_kidwatch_menu_electronic_add_fence_fail);
        } else {
            C2538c.m12674b("AddFenceActivity", "==========保存失败,该电子围栏已经被删除，不存在");
            this.f6190a.f5431P = false;
            this.f6190a.f5426K.setClickable(true);
            C1483c.m6832c(this.f6190a.f5418C, this.f6190a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_has_del));
            C1901r.m9679b(true);
        }
    }
}
