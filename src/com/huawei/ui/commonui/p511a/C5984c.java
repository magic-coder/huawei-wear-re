package com.huawei.ui.commonui.p511a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import com.huawei.ui.commonui.C6030g;

/* compiled from: CheckAdapter */
public class C5984c implements OnItemClickListener {
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CheckBox checkBox = (CheckBox) view.findViewById(C6030g.chk_selectone);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        } else {
            checkBox.setChecked(true);
        }
    }
}
