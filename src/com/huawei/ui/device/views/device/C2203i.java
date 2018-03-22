package com.huawei.ui.device.views.device;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.d;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.p170a.C1988p;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: DeviceListScanAdapter */
public class C2203i extends BaseAdapter {
    private LayoutInflater f7900a;
    private List<String> f7901b = new ArrayList();
    private List<BluetoothDevice> f7902c = new ArrayList();
    private C1988p f7903d;

    public C2203i(Context context) {
        this.f7900a = LayoutInflater.from(context);
        this.f7903d = C1988p.m10381a(context);
    }

    public void m11329a(List<BluetoothDevice> list) {
        this.f7902c.clear();
        this.f7902c.addAll(list);
        notifyDataSetChanged();
    }

    public void m11331b(List<String> list) {
        this.f7901b = list;
    }

    public int getCount() {
        return this.f7902c.size();
    }

    public Object getItem(int i) {
        return this.f7902c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2204j c2204j;
        if (view == null) {
            view = this.f7900a.inflate(f.device_scan_item_layout, null);
            c2204j = new C2204j();
            c2204j.f7904a = (TextView) view.findViewById(e.item_device_name_text);
            c2204j.f7905b = (ImageView) view.findViewById(e.item_device_name_image);
            view.setTag(c2204j);
        } else {
            c2204j = (C2204j) view.getTag();
        }
        if (TextUtils.isEmpty(((BluetoothDevice) this.f7902c.get(i)).getName())) {
            c2204j.f7904a.setText(((BluetoothDevice) this.f7902c.get(i)).getAddress());
        } else if (m11330a(((BluetoothDevice) this.f7902c.get(i)).getName())) {
            c2204j.f7904a.setText(((BluetoothDevice) this.f7902c.get(i)).getName());
            c2204j.f7905b.setBackgroundResource(m11328b(((BluetoothDevice) this.f7902c.get(i)).getName()));
        } else {
            c2204j.f7904a.setText(((BluetoothDevice) this.f7902c.get(i)).getAddress());
        }
        return view;
    }

    private int m11328b(String str) {
        C1988p c1988p = this.f7903d;
        int a = C1988p.m10380a(str);
        int i = d.ic_spinner_scan_band;
        switch (a) {
            case 5:
                return d.ic_spinner_scan_s1;
            case 8:
                return d.ic_spinner_scan_s1;
            case 11:
                return d.ic_spinner_scan_r1;
            default:
                return i;
        }
    }

    public boolean m11330a(String str) {
        if (TextUtils.isEmpty(str)) {
            C2538c.m12672b("01", 0, "DeviceListScanAdapter", "filterToNames(), deviceName = null, return true!");
            return false;
        }
        boolean z;
        C2538c.m12661a("01", 0, "DeviceListScanAdapter", "after toUpperCase deviceName = " + str.toUpperCase(Locale.US));
        int i = 0;
        while (i < this.f7901b.size()) {
            C2538c.m12677c("DeviceListScanAdapter", "after toUpperCase mNameFilter[" + i + "] = " + ((String) this.f7901b.get(i)).toUpperCase());
            C2538c.m12661a("01", 0, "DeviceListScanAdapter", "after toUpperCase mNameFilter[" + i + "] = " + ((String) this.f7901b.get(i)).toUpperCase());
            if (!TextUtils.isEmpty((CharSequence) this.f7901b.get(i)) && r4.contains(((String) this.f7901b.get(i)).toUpperCase())) {
                z = true;
                break;
            }
            i++;
        }
        z = false;
        C2538c.m12661a("01", 0, "DeviceListScanAdapter", "filterToNames(), flagFilter =" + z);
        return z;
    }
}
