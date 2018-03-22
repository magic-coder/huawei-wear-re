package com.huawei.bone.root;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.huawei.bone.C6753R;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

public class ServiceCountryActivity extends BaseActivity {
    private List<String> f23271a = new ArrayList();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.b("ServiceCountryActivity", new Object[]{"onCreate()"});
        setContentView(C6753R.layout.service_country_layout);
        m30169a();
    }

    private void m30169a() {
        ListView listView = (ListView) findViewById(C6753R.id.service_country_list);
        this.f23271a = ServiceAreaActivity.m30163a();
        listView.setAdapter(new ArrayAdapter(this, C6753R.layout.service_country_list_item_layout, this.f23271a));
        listView.setOnItemClickListener(new af(this));
    }
}
