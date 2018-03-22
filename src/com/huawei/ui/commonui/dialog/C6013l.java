package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6035l;
import com.huawei.ui.commonui.C6036m;
import java.util.Arrays;

/* compiled from: CustomSingleChoiceDialog */
public class C6013l {
    private Context f20713a;
    private String f20714b;
    private String f20715c;
    private String f20716d;
    private ListView f20717e;
    private OnClickListener f20718f;
    private OnClickListener f20719g;
    private OnItemClickListener f20720h;
    private String[] f20721i;
    private boolean[] f20722j;
    private boolean f20723k = false;

    public C6013l(Context context) {
        this.f20713a = context;
    }

    public ListView m27574a() {
        return this.f20717e;
    }

    public C6013l m27575a(String str) {
        this.f20714b = str;
        return this;
    }

    public C6013l m27576a(String str, OnClickListener onClickListener) {
        this.f20716d = str;
        this.f20719g = onClickListener;
        return this;
    }

    public C6013l m27577a(String[] strArr, boolean[] zArr, int[] iArr, OnItemClickListener onItemClickListener, boolean z) {
        this.f20723k = true;
        this.f20721i = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (zArr != null) {
            this.f20722j = Arrays.copyOf(zArr, zArr.length);
        } else {
            this.f20722j = new boolean[strArr.length];
        }
        this.f20720h = onItemClickListener;
        return this;
    }

    public C6011j m27578b() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f20713a.getSystemService("layout_inflater");
        C6011j c6011j = new C6011j(this.f20713a, C6035l.CustomDialog);
        View inflate = layoutInflater.inflate(C6031h.commonui_dialog_single_choice_layout, null);
        TypedValue typedValue = new TypedValue();
        this.f20713a.getTheme().resolveAttribute(C5996c.customDialogStyleRefer, typedValue, true);
        TypedArray obtainStyledAttributes = this.f20713a.getTheme().obtainStyledAttributes(typedValue.resourceId, C6036m.customDialogDefinition);
        Drawable drawable = obtainStyledAttributes.getDrawable(C6036m.customDialogDefinition_dialogBackground);
        TypedValue typedValue2 = new TypedValue();
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_titleTextSize, typedValue2);
        int complexToFloat = (int) TypedValue.complexToFloat(typedValue2.data);
        obtainStyledAttributes.recycle();
        inflate.setBackground(drawable);
        TextView textView = (TextView) inflate.findViewById(C6030g.custom_singel_choic_title);
        textView.setTextSize(1, (float) complexToFloat);
        textView.setText(this.f20714b);
        Button button = (Button) inflate.findViewById(C6030g.positiveButton);
        Button button2 = (Button) inflate.findViewById(C6030g.negativeButton);
        this.f20717e = (ListView) inflate.findViewById(C6030g.multichoiceList);
        c6011j.addContentView(inflate, new LayoutParams(-2, -2));
        if (this.f20715c != null) {
            button.setText(this.f20715c);
            if (this.f20718f != null) {
                button.setOnClickListener(new C6014m(this, c6011j));
            } else {
                button.setOnClickListener(new C6015n(this, c6011j));
            }
        } else {
            button.setVisibility(8);
        }
        if (this.f20716d != null) {
            button2.setText(this.f20716d);
            if (this.f20719g != null) {
                button2.setOnClickListener(new C6016o(this, c6011j));
            } else {
                button2.setOnClickListener(new C6017p(this, c6011j));
            }
        } else {
            button2.setVisibility(8);
        }
        if (this.f20723k) {
            this.f20717e.setAdapter(new C6018q(this.f20713a, this.f20721i, this.f20722j, this.f20720h));
            if (this.f20720h != null) {
                this.f20717e.setOnItemClickListener(this.f20720h);
            } else {
                this.f20717e.setOnItemClickListener(new C6021t());
            }
        }
        Window window = c6011j.getWindow();
        window.setGravity(80);
        Display defaultDisplay = ((WindowManager) this.f20713a.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int a = C6013l.m27569a(this.f20713a, 8.0f);
        attributes.width = defaultDisplay.getWidth() - (a * 2);
        attributes.y = a;
        window.setAttributes(attributes);
        window.setWindowAnimations(C6035l.track_dialog_anim);
        c6011j.setContentView(inflate);
        return c6011j;
    }

    public static int m27569a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
