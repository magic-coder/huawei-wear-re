package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.hwbtsdk.C6698c;
import com.huawei.hwbtsdk.C6699d;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: DeviceListAdapter */
public class C4616s extends BaseAdapter {
    private LayoutInflater f16878a;
    private List<String> f16879b = new ArrayList();
    private List<BluetoothDevice> f16880c = new ArrayList();

    public C4616s(Context context) {
        this.f16878a = LayoutInflater.from(context);
    }

    public void m22028a(List<BluetoothDevice> list) {
        this.f16880c.clear();
        this.f16880c.addAll(list);
        notifyDataSetChanged();
    }

    public void m22030b(List<String> list) {
        this.f16879b = list;
    }

    public int getCount() {
        return this.f16880c.size();
    }

    public Object getItem(int i) {
        return this.f16880c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C4617t c4617t;
        if (view == null) {
            view = this.f16878a.inflate(C6699d.device_item_layout, null);
            c4617t = new C4617t();
            c4617t.f16881a = (TextView) view.findViewById(C6698c.item_device_name);
            view.setTag(c4617t);
        } else {
            c4617t = (C4617t) view.getTag();
        }
        if (TextUtils.isEmpty(((BluetoothDevice) this.f16880c.get(i)).getName())) {
            c4617t.f16881a.setText(((BluetoothDevice) this.f16880c.get(i)).getAddress());
        } else if (m22029a(((BluetoothDevice) this.f16880c.get(i)).getName())) {
            c4617t.f16881a.setText(((BluetoothDevice) this.f16880c.get(i)).getName());
        } else {
            c4617t.f16881a.setText(((BluetoothDevice) this.f16880c.get(i)).getAddress());
        }
        return view;
    }

    public boolean m22029a(String str) {
        if (TextUtils.isEmpty(str)) {
            C2538c.b("01", 1, "DeviceListAdapter", new Object[]{"filterToNames(), deviceName = null, return true!"});
            return true;
        }
        C2538c.a("01", 1, "DeviceListAdapter", new Object[]{"after toUpperCase deviceName = " + str.toUpperCase(Locale.US)});
        boolean z = false;
        for (int i = 0; i < this.f16879b.size(); i++) {
            C2538c.a("01", 1, "DeviceListAdapter", new Object[]{"after toUpperCase mNameFilter[" + i + "] = " + ((String) this.f16879b.get(i)).toUpperCase()});
            if (TextUtils.isEmpty((CharSequence) this.f16879b.get(i))) {
                z = true;
            } else if (r5.contains(((String) this.f16879b.get(i)).toUpperCase())) {
                z = true;
                break;
            }
        }
        C2538c.a("01", 1, "DeviceListAdapter", new Object[]{"filterToNames(), flagFilter =" + z});
        return z;
    }
}
