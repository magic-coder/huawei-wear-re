package com.huawei.bone.root;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ServiceCountryActivity */
class af implements OnItemClickListener {
    final /* synthetic */ ServiceCountryActivity f23300a;

    af(ServiceCountryActivity serviceCountryActivity) {
        this.f23300a = serviceCountryActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.c("ServiceCountryActivity", new Object[]{"setOnItemClickListener: strCountry=" + ((String) this.f23300a.f23271a.get(i))});
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("service_area_country", (String) this.f23300a.f23271a.get(i));
        intent.putExtras(bundle);
        this.f23300a.setResult(0, intent);
        this.f23300a.finish();
    }
}
