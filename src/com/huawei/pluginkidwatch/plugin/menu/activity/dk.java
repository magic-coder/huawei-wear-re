package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: EditRelationSettingActivity */
class dk implements OnClickListener {
    final /* synthetic */ EditRelationSettingActivity f6035a;

    dk(EditRelationSettingActivity editRelationSettingActivity) {
        this.f6035a = editRelationSettingActivity;
    }

    public void onClick(View view) {
        String obj = this.f6035a.f5698s.getText().toString();
        if (obj == null || "".equals(obj.trim())) {
            C1483c.m6824a(this.f6035a.f5696q, C1680l.IDS_plugin_kidwatch_settings_relation_info);
        } else if (!C1492l.m6917b(obj.replace(String.valueOf('·'), "").replace(HwAccountConstants.BLANK, ""))) {
            C1483c.m6824a(this.f6035a.f5696q, C1680l.IDS_plugin_kidwatch_common_illegal);
        } else if (!"".equals(obj)) {
            this.f6035a.f5683d.setSelected(true);
            this.f6035a.f5684e.setSelected(false);
            this.f6035a.f5685f.setSelected(false);
            this.f6035a.f5686g.setSelected(false);
            this.f6035a.f5687h.setSelected(false);
            this.f6035a.f5688i.setTextSize(20.0f);
            this.f6035a.f5689j.setTextSize(17.0f);
            this.f6035a.f5690k.setTextSize(17.0f);
            this.f6035a.f5691l.setTextSize(17.0f);
            this.f6035a.f5692m.setTextSize(17.0f);
            this.f6035a.f5693n.setImageResource(C1617f.kw_img_other);
            this.f6035a.f5699t = "0";
            C1497q.m6943a(this.f6035a.f5696q, "editname", "0");
            C1497q.m6943a(this.f6035a.f5696q, "othername", obj);
            this.f6035a.f5681b.setEnabled(true);
            this.f6035a.f5688i.setText(obj);
            this.f6035a.f5695p.cancel();
            this.f6035a.f5695p = null;
        }
    }
}
