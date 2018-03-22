package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import com.huawei.pluginkidwatch.g;

/* compiled from: CustomSingleChoiceDialog */
class ac implements OnItemClickListener {
    ac() {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CheckBox checkBox = (CheckBox) view.findViewById(g.chk_selectone);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        } else {
            checkBox.setChecked(true);
        }
    }
}
