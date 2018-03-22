package com.huawei.ui.device.views.selectcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.datatype.Contact;
import com.huawei.datatype.PhoneNumber;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import java.util.HashMap;
import java.util.List;

/* compiled from: ContactDeleteListAdapter */
public class C2211a extends BaseAdapter {
    private static HashMap<Integer, Boolean> f7949b;
    private List<Contact> f7950a;
    private LayoutInflater f7951c;

    public C2211a(Context context, List<Contact> list) {
        this.f7950a = list;
        m11360b();
        this.f7951c = LayoutInflater.from(context);
    }

    private void m11360b() {
        if (f7949b == null) {
            f7949b = new HashMap();
        }
        for (int i = 0; i < this.f7950a.size(); i++) {
            f7949b.put(Integer.valueOf(i), Boolean.valueOf(false));
        }
    }

    public int getCount() {
        return this.f7950a.size();
    }

    public Object getItem(int i) {
        return this.f7950a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            Contact contact = (Contact) this.f7950a.get(i);
            C2538c.m12677c("ContactDeleteListAdapter", "ContactDeleteListAdapter getView() vie=" + view + ", item=" + contact);
            C2212b c2212b = new C2212b();
            View inflate = this.f7951c.inflate(f.activity_device_settings_contact_delete_item_layout_black, null);
            c2212b.f7952a = (TextView) d.a(inflate, e.content);
            c2212b.f7953b = (TextView) d.a(inflate, e.summary);
            c2212b.f7954c = (CheckBox) d.a(inflate, e.isCheckBox);
            inflate.setTag(c2212b);
            c2212b.f7952a.setText(contact.getName());
            c2212b.f7953b.setText(((PhoneNumber) contact.getPhoneNumbers().get(0)).getPhone_number());
            c2212b.f7954c.setChecked(((Boolean) f7949b.get(Integer.valueOf(i))).booleanValue());
            return inflate;
        } catch (IndexOutOfBoundsException e) {
            C2538c.m12680e("ContactDeleteListAdapter", e.getMessage());
            return null;
        }
    }

    public static HashMap<Integer, Boolean> m11359a() {
        return f7949b;
    }
}
