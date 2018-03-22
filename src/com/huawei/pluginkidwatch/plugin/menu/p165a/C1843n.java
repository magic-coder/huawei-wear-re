package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: CustomMultiChoiceDialog */
public class C1843n {
    private Context f5296a;
    private String f5297b;
    private String f5298c;
    private String f5299d;
    private String f5300e;
    private View f5301f;
    private ListView f5302g;
    private OnClickListener f5303h;
    private OnClickListener f5304i;
    private OnItemClickListener f5305j;
    private String[] f5306k;
    private boolean[] f5307l;
    private boolean f5308m = false;
    private boolean f5309n = true;

    public void m8922a(boolean z) {
        this.f5309n = z;
    }

    public C1843n(Context context) {
        this.f5296a = context;
    }

    public boolean[] m8923a() {
        if (this.f5302g != null) {
            return ((C1848s) this.f5302g.getAdapter()).m8926a();
        }
        return null;
    }

    public C1843n m8919a(String str) {
        this.f5297b = str;
        return this;
    }

    public C1843n m8920a(String str, OnClickListener onClickListener) {
        this.f5299d = str;
        this.f5303h = onClickListener;
        return this;
    }

    public C1843n m8925b(String str, OnClickListener onClickListener) {
        this.f5300e = str;
        this.f5304i = onClickListener;
        return this;
    }

    public C1843n m8921a(String[] strArr, boolean[] zArr, int[] iArr, OnItemClickListener onItemClickListener, boolean z) {
        this.f5308m = true;
        if (zArr != null) {
            this.f5307l = new boolean[zArr.length];
            System.arraycopy(zArr, 0, this.f5307l, 0, zArr.length);
        } else if (strArr != null) {
            this.f5307l = new boolean[strArr.length];
        }
        if (strArr != null && strArr.length > 0) {
            this.f5306k = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f5306k, 0, strArr.length);
        }
        this.f5305j = onItemClickListener;
        return this;
    }

    public C1841l m8924b() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f5296a.getSystemService("layout_inflater");
        C1841l c1841l = new C1841l(this.f5296a, m.Dialog);
        View inflate = layoutInflater.inflate(h.dialog_multichoice_layout, null);
        ((TextView) inflate.findViewById(g.multichoic_title)).setText(this.f5297b);
        Button button = (Button) inflate.findViewById(g.positiveButton);
        Button button2 = (Button) inflate.findViewById(g.negativeButton);
        this.f5302g = (ListView) inflate.findViewById(g.multichoiceList);
        c1841l.addContentView(inflate, new LayoutParams(-2, -2));
        if (this.f5299d != null) {
            button.setText(this.f5299d);
            if (this.f5303h != null) {
                button.setOnClickListener(new C1844o(this, c1841l));
            } else {
                button.setOnClickListener(new C1845p(this, c1841l));
            }
        } else {
            button.setVisibility(8);
        }
        if (this.f5300e != null) {
            button2.setText(this.f5300e);
            if (this.f5304i != null) {
                button2.setOnClickListener(new C1846q(this, c1841l));
            } else {
                button2.setOnClickListener(new C1847r(this, c1841l));
            }
        } else {
            button2.setVisibility(8);
        }
        if (this.f5308m) {
            this.f5302g.setAdapter(new C1848s(this.f5296a, this.f5306k, this.f5307l));
            if (this.f5305j != null) {
                this.f5302g.setOnItemClickListener(this.f5305j);
            } else {
                this.f5302g.setOnItemClickListener(new C1850u());
            }
        }
        if (this.f5298c == null && this.f5301f != null) {
            ((LinearLayout) inflate.findViewById(g.content)).removeAllViews();
            ((LinearLayout) inflate.findViewById(g.content)).addView(this.f5301f, new LayoutParams(-2, -2));
        }
        c1841l.setContentView(inflate);
        return c1841l;
    }
}
