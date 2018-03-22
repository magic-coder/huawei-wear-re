package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.webview.LegalInfoWebViewActivity;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;
import com.huawei.ui.main.stories.about.p179a.C2285g;
import com.huawei.ui.main.stories.about.p179a.C2286h;
import com.huawei.ui.main.stories.about.p179a.C2288j;
import com.huawei.ui.main.stories.about.p179a.C2289k;
import java.util.ArrayList;
import java.util.List;

public class LegalInformationActivity extends BaseActivity {
    private ListView f8374a;
    private List f8375b;
    private Context f8376c;
    private int f8377d = -1;
    private String f8378e;
    private int[] f8379f = new int[]{j.IDS_hw_privacy, j.IDS_huawei_wear_user_protocol, j.IDS_huawei_privacy_notice, j.IDS_setting_user_agreement, j.IDS_setting_software_notice};
    private C2286h f8380g;
    private OnItemClickListener f8381h = new C2313a(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_legal_information);
        this.f8376c = this;
        this.f8380g = C2286h.m11749a();
        DeviceInfo b = this.f8380g.m11755b();
        if (b != null) {
            this.f8377d = b.getProductType();
            this.f8378e = String.format(this.f8376c.getResources().getString(j.IDS_setting_software_notice), new Object[]{this.f8380g.m11753a(this.f8377d)});
        }
        this.f8374a = (ListView) d.a(this, f.info_detail_list);
        m11823c();
        this.f8374a.setAdapter(new ArrayAdapter(this, g.legal_info_item_layout, f.setting_legal_info_item_text, this.f8375b));
        this.f8374a.setOnItemClickListener(this.f8381h);
    }

    private void m11815a() {
        Intent intent = new Intent(this.f8376c, LegalInfoWebViewActivity.class);
        intent.putExtra("LegalInfoWebViewActivity.URL_TYPE_KEY", 1001);
        intent.putExtra("LegalInfoWebViewActivity.TITLE_KEY", this.f8376c.getString(j.IDS_huawei_wear_user_protocol));
        intent.putExtra("LegalInfoWebViewActivity.URL_KEY", C2289k.m11764a(this.f8376c));
        this.f8376c.startActivity(intent);
    }

    private void m11822b() {
        C2285g c2285g = new C2285g(this.f8376c);
        Intent intent = new Intent(this.f8376c, LegalInfoWebViewActivity.class);
        intent.putExtra("LegalInfoWebViewActivity.URL_TYPE_KEY", 1001);
        intent.putExtra("LegalInfoWebViewActivity.TITLE_KEY", this.f8376c.getString(j.IDS_setting_user_agreement));
        intent.putExtra("LegalInfoWebViewActivity.URL_KEY", c2285g.m11748a());
        this.f8376c.startActivity(intent);
    }

    private void m11823c() {
        this.f8375b = new ArrayList();
        for (int string : this.f8379f) {
            this.f8375b.add(getResources().getString(string));
        }
        this.f8375b.remove(getResources().getString(j.IDS_setting_software_notice));
        m11825d();
        this.f8375b.remove(getResources().getString(j.IDS_setting_open_source_license));
        this.f8375b.remove(getResources().getString(j.IDS_setting_cookies));
    }

    private void m11825d() {
        if (m11818a(this.f8377d) && this.f8375b != null) {
            this.f8375b.add(this.f8378e);
        }
    }

    private boolean m11818a(int i) {
        if (i == 5 || i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    private String m11821b(int i) {
        switch (i) {
            case 1:
                return "Open_Source_Software_Notice_00.02.01";
            case 2:
                return "Open_Source_Software_Notice_01.00.01";
            case 5:
                return "Open_Source_Software_Notice_00.00.01";
            default:
                return null;
        }
    }

    private void m11816a(Context context, String str, String str2) {
        C2288j c2288j = new C2288j(this.f8376c);
        Intent intent = new Intent(context, LegalInfoWebViewActivity.class);
        intent.putExtra("LegalInfoWebViewActivity.URL_TYPE_KEY", 1002);
        intent.putExtra("LegalInfoWebViewActivity.TITLE_KEY", str2);
        intent.putExtra("LegalInfoWebViewActivity.URL_KEY", c2288j.m11763a(str));
        context.startActivity(intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        C0977d.m3575n(this.f8376c);
    }
}
