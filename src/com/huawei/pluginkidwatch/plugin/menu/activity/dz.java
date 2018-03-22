package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.Fence;
import com.huawei.pluginkidwatch.common.entity.model.FenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import java.util.List;

/* compiled from: ElectronicFenceActivity */
class dz implements C1378e {
    final /* synthetic */ ElectronicFenceActivity f6062a;

    dz(ElectronicFenceActivity electronicFenceActivity) {
        this.f6062a = electronicFenceActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f6062a.f5711g.setVisibility(8);
            this.f6062a.f5721q.setVisibility(0);
            this.f6062a.f5722r.setVisibility(0);
            this.f6062a.f5722r.setFocusable(true);
            this.f6062a.f5720p.setText(this.f6062a.getResources().getString(C1680l.IDS_plugin_kidwatch_network_error_load_failed));
            C2538c.m12674b("ElectronicFenceActivity", "============getFences failuer");
            return;
        }
        this.f6062a.f5713i.setEnabled(true);
        this.f6062a.f5711g.setVisibility(0);
        this.f6062a.f5721q.setVisibility(8);
        this.f6062a.f5722r.setVisibility(8);
        FenceIOEntityModel fenceIOEntityModel = (FenceIOEntityModel) baseEntityModel;
        C2538c.m12674b("ElectronicFenceActivity", "============getFences success");
        List list = fenceIOEntityModel.fences;
        if (list != null) {
            if (list.size() < 1) {
                C2538c.m12674b("ElectronicFenceActivity", "===========删除置为不可点击");
                this.f6062a.m9355a(false);
            } else {
                C2538c.m12674b("ElectronicFenceActivity", "===========删除置为可点击");
                this.f6062a.m9355a(true);
            }
            for (int i = 0; i < list.size(); i++) {
                try {
                    Fence fence = (Fence) list.get(i);
                    String[] split = fence.fenceRange.split(",");
                    this.f6062a.f5708d.add(new FenceItem(i, fence.fenceId, C1492l.m6920d(split[2]), ((Fence) list.get(i)).name, fence.locationName, false, false, 1 == C1492l.m6920d(fence.isActive.trim()), Double.valueOf(split[1]).doubleValue(), Double.valueOf(split[0]).doubleValue()));
                } catch (NumberFormatException e) {
                    C2538c.m12680e("ElectronicFenceActivity", "============ ElectronicFenceActivity ERROR!!!");
                }
            }
        } else if (this.f6062a.f5708d == null || this.f6062a.f5708d.size() == 0) {
            C2538c.m12674b("ElectronicFenceActivity", "===========删除置为不可点击");
            this.f6062a.m9355a(false);
        }
        this.f6062a.m9367g();
    }
}
