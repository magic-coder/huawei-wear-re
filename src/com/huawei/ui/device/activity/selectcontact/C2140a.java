package com.huawei.ui.device.activity.selectcontact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.views.selectcontact.C2211a;
import com.huawei.ui.device.views.selectcontact.C2212b;

/* compiled from: ContactDeleteActivity */
class C2140a implements OnItemClickListener {
    final /* synthetic */ ContactDeleteActivity f7599a;

    C2140a(ContactDeleteActivity contactDeleteActivity) {
        this.f7599a = contactDeleteActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2212b c2212b = (C2212b) view.getTag();
        if (c2212b == null) {
            C2538c.m12680e(this.f7599a.f7553e, "holder == null");
            return;
        }
        C2538c.m12677c(this.f7599a.f7553e, "ContactDeleteListAdapter ViewHolder = " + c2212b);
        c2212b.f7954c.toggle();
        C2211a.m11359a().put(Integer.valueOf(i), Boolean.valueOf(c2212b.f7954c.isChecked()));
        C2538c.m12677c(this.f7599a.f7553e, "arg2 = " + i + "checkBox.isChecked() = " + c2212b.f7954c.isChecked());
        C2538c.m12677c(this.f7599a.f7553e, "ContactDeleteListAdapter map = " + C2211a.m11359a());
        if (true == c2212b.f7954c.isChecked()) {
            this.f7599a.f7563o = this.f7599a.f7563o + 1;
        } else {
            this.f7599a.f7563o = this.f7599a.f7563o - 1;
        }
        C2538c.m12677c(this.f7599a.f7553e, "mcheckNum = " + this.f7599a.f7563o);
        this.f7599a.f7560l.setTitleCountNum(this.f7599a.f7563o);
        if (this.f7599a.f7563o == this.f7599a.f7549a.size()) {
            this.f7599a.m10982i();
        } else {
            this.f7599a.m10980h();
        }
    }
}
