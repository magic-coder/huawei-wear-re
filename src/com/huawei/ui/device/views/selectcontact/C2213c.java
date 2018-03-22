package com.huawei.ui.device.views.selectcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.datatype.Contact;
import com.huawei.datatype.PhoneNumber;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import java.util.List;

/* compiled from: ContactMainListAdapter */
public class C2213c extends BaseAdapter {
    private List<Contact> f7955a;
    private LayoutInflater f7956b;

    public C2213c(Context context, List<Contact> list) {
        this.f7955a = list;
        this.f7956b = LayoutInflater.from(context);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f7955a.size();
    }

    public Object getItem(int i) {
        return this.f7955a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            C2538c.m12677c("ContactMainListAdapter", "=========test=========ContactMainListAdapter getView() vie=" + view + ", item=" + ((Contact) this.f7955a.get(i)));
            View inflate = this.f7956b.inflate(f.activity_device_settings_contact_main_item_layout_black, null);
            m11361a(inflate, r0);
            return inflate;
        } catch (IndexOutOfBoundsException e) {
            C2538c.m12680e("ContactMainListAdapter", e.getMessage());
            return null;
        }
    }

    private void m11361a(View view, Contact contact) {
        TextView textView = (TextView) d.a(view, e.summary);
        ((TextView) d.a(view, e.content)).setText(contact.getName());
        if (contact.getPhoneNumbers() == null || contact.getPhoneNumbers().get(0) == null) {
            C2538c.m12679d("ContactMainListAdapter", "if (item.getPhoneNumbers() != null && item.getPhoneNumbers().get(0) != null) ELSE");
            return;
        }
        textView.setText(((PhoneNumber) contact.getPhoneNumbers().get(0)).getPhone_number());
    }
}
