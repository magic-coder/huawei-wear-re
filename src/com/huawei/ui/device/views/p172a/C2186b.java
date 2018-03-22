package com.huawei.ui.device.views.p172a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import com.huawei.ui.device.i;
import java.util.List;

/* compiled from: SelectDeviceListAdapterNew */
public class C2186b extends BaseAdapter {
    private List<C2188d> f7775a;
    private LayoutInflater f7776b;

    public C2186b(Context context, List<C2188d> list) {
        this.f7775a = list;
        this.f7776b = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.f7775a.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public Object getItem(int i) {
        return this.f7775a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            C2188d c2188d = (C2188d) this.f7775a.get(i);
            if (view == null) {
                view = this.f7776b.inflate(f.activity_select_device_list_item_info_black_new, null);
            }
            m11201a(view, c2188d);
            return view;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private void m11201a(View view, C2188d c2188d) {
        TextView textView = (TextView) view.findViewById(e.select_device_title_new);
        TextView textView2 = (TextView) view.findViewById(e.select_device_content_new);
        TextView textView3 = (TextView) view.findViewById(e.add_device_no_device);
        ImageView imageView = (ImageView) view.findViewById(e.select_device_icon_new);
        if (c2188d.m11219c() != null) {
            textView.setText(c2188d.m11219c());
            textView.setVisibility(0);
        }
        if (100 == c2188d.m11217b()) {
            imageView.setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(0);
            int[] iArr = new int[]{BaseApplication.m2632b().getString(i.IDS_device_manager_no_device_text2, new Object[]{BaseApplication.m2632b().getString(i.IDS_device_manager_no_device_text_new)}).indexOf(r0)};
            CharSequence spannableString = new SpannableString(r1);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0D9FFB")), iArr[0], r0.length() + iArr[0], 33);
            textView3.setText(spannableString);
            if (c2188d.m11221e() != null) {
                view.setOnClickListener(c2188d.m11221e());
                return;
            }
            return;
        }
        textView3.setVisibility(8);
        imageView.setVisibility(0);
        textView.setVisibility(0);
        textView2.setVisibility(0);
        if (c2188d.m11220d() != null) {
            CharSequence stringBuffer = new StringBuffer();
            if (c2188d.m11220d().length < 5) {
                for (String append : c2188d.m11220d()) {
                    stringBuffer.append(append);
                    stringBuffer.append("\n");
                }
            } else {
                stringBuffer.append(c2188d.m11220d()[0]).append("\n").append(c2188d.m11220d()[1]).append("\n").append(c2188d.m11220d()[2]).append("\n").append("...");
            }
            textView2.setText(stringBuffer);
            textView2.setVisibility(0);
        }
        if (-1 != c2188d.m11217b()) {
            imageView.setBackgroundResource(c2188d.m11217b());
            imageView.setVisibility(0);
        }
        if (c2188d.m11221e() != null) {
            view.setOnClickListener(c2188d.m11221e());
        }
    }
}
