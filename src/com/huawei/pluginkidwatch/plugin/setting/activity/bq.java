package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: RelationSettingActivity */
class bq implements OnClickListener {
    final /* synthetic */ RelationSettingActivity f6638a;

    bq(RelationSettingActivity relationSettingActivity) {
        this.f6638a = relationSettingActivity;
    }

    public void onClick(View view) {
        CharSequence obj = this.f6638a.f6441s.getText().toString();
        if (obj == null || "".equals(obj.trim())) {
            C1483c.m6824a(this.f6638a.f6438p, C1680l.IDS_plugin_kidwatch_settings_relation_info);
        } else if (!C1492l.m6917b(obj.replace(String.valueOf('·'), "").replace(HwAccountConstants.BLANK, ""))) {
            C1483c.m6824a(this.f6638a.f6438p, C1680l.IDS_plugin_kidwatch_common_illegal);
        } else if (!"".equals(obj)) {
            this.f6638a.f6427e.setSelected(true);
            this.f6638a.f6428f.setSelected(false);
            this.f6638a.f6429g.setSelected(false);
            this.f6638a.f6425c.setSelected(false);
            this.f6638a.f6426d.setSelected(false);
            this.f6638a.f6432j.setTextSize(20.0f);
            this.f6638a.f6433k.setTextSize(17.0f);
            this.f6638a.f6434l.setTextSize(17.0f);
            this.f6638a.f6430h.setTextSize(17.0f);
            this.f6638a.f6431i.setTextSize(17.0f);
            this.f6638a.f6435m.setImageResource(C1617f.kw_img_other);
            this.f6638a.f6442t = "0";
            C1462f.m6743h(obj);
            this.f6638a.f6424b.setEnabled(true);
            this.f6638a.f6432j.setText(obj);
            this.f6638a.f6437o.cancel();
            this.f6638a.f6437o = null;
        }
    }
}
