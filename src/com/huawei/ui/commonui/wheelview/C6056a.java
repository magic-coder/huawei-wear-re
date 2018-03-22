package com.huawei.ui.commonui.wheelview;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6036m;
import com.huawei.ui.commonui.dialog.C6004c;
import com.huawei.ui.commonui.dialog.CustomAlertDialog;

/* compiled from: CustomWheelView */
public class C6056a extends RelativeLayout {
    private C6069o f20919a;
    private C6059e f20920b;
    private C6059e f20921c;
    private int f20922d;
    private Context f20923e;
    private View f20924f;
    private WheelView f20925g;
    private WheelView f20926h;
    private WheelView f20927i;
    private LinearLayout f20928j;
    private LinearLayout f20929k;
    private LinearLayout f20930l;
    private CustomAlertDialog f20931m;

    public C6056a(Context context, int i) {
        this(context, null);
        this.f20923e = context;
        this.f20922d = i;
        this.f20924f = LayoutInflater.from(this.f20923e).inflate(C6031h.commonui_dialog_wheelview, null);
        m27717d();
    }

    public C6056a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20919a = null;
        this.f20920b = null;
        this.f20921c = null;
        this.f20922d = -1;
        this.f20931m = null;
        if (attributeSet != null) {
            this.f20923e = context;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6036m.custom_wheel_view);
            this.f20922d = obtainStyledAttributes.getInteger(C6036m.custom_wheel_view_wheelType, -1);
            obtainStyledAttributes.recycle();
            this.f20924f = ((LayoutInflater) this.f20923e.getSystemService("layout_inflater")).inflate(C6031h.commonui_custom_wheelview, this);
            m27717d();
        }
    }

    private void m27717d() {
        this.f20928j = (LinearLayout) this.f20924f.findViewById(C6030g.left_picker_layout);
        this.f20928j.setVisibility(8);
        this.f20929k = (LinearLayout) this.f20924f.findViewById(C6030g.middle_picker_layout);
        this.f20929k.setVisibility(8);
        this.f20930l = (LinearLayout) this.f20924f.findViewById(C6030g.right_picker_layout);
        this.f20930l.setVisibility(8);
        this.f20925g = (WheelView) this.f20924f.findViewById(C6030g.left_picker);
        this.f20926h = (WheelView) this.f20924f.findViewById(C6030g.middle_picker);
        this.f20927i = (WheelView) this.f20924f.findViewById(C6030g.right_picker);
        switch (this.f20922d) {
            case 0:
                this.f20920b = new C6059e(this.f20923e, this.f20925g, this.f20926h, this.f20927i);
                return;
            case 1:
                this.f20928j.setVisibility(0);
                this.f20930l.setVisibility(0);
                this.f20921c = new C6059e(this.f20923e, this.f20925g, this.f20927i);
                return;
            case 2:
                this.f20928j.setVisibility(0);
                this.f20929k.setVisibility(0);
                this.f20930l.setVisibility(0);
                this.f20919a = new C6069o(this.f20925g, this.f20926h, this.f20927i);
                return;
            case 3:
                this.f20928j.setVisibility(0);
                this.f20929k.setVisibility(0);
                this.f20930l.setVisibility(0);
                this.f20919a = new C6069o(this.f20925g, this.f20926h, this.f20927i);
                return;
            default:
                this.f20928j.setVisibility(0);
                this.f20929k.setVisibility(0);
                this.f20930l.setVisibility(0);
                this.f20920b = new C6059e(this.f20923e, this.f20925g, this.f20926h, this.f20927i);
                return;
        }
    }

    public void m27721a(String str, String str2, String str3) {
        if (2 == this.f20922d && this.f20919a != null) {
            this.f20919a.m27758a(str, str2, str3);
        } else if (3 == this.f20922d) {
            this.f20919a.m27761b(str, str2, str3);
        }
    }

    public void m27722a(String[] strArr, int i, boolean z) {
        if (this.f20922d == 0 && this.f20920b != null) {
            this.f20928j.setVisibility(0);
            this.f20920b.m27734a(strArr, i, z);
        } else if (1 == this.f20922d && this.f20921c != null) {
            this.f20928j.setVisibility(0);
            this.f20921c.m27734a(strArr, i, z);
        }
    }

    public void m27724b(String[] strArr, int i, boolean z) {
        if (this.f20922d == 0 && this.f20920b != null) {
            this.f20929k.setVisibility(0);
            this.f20920b.m27737b(strArr, i, z);
        }
    }

    public void m27726c(String[] strArr, int i, boolean z) {
        if (this.f20922d == 0 && this.f20920b != null) {
            this.f20930l.setVisibility(0);
            this.f20920b.m27739c(strArr, i, z);
        } else if (1 == this.f20922d && this.f20921c != null) {
            this.f20930l.setVisibility(0);
            this.f20921c.m27739c(strArr, i, z);
        }
    }

    public void setOnWheelChangedListener(C5691c c5691c) {
        if (this.f20922d == 0 && this.f20920b != null) {
            this.f20920b.m27733a(c5691c);
        } else if ((3 == this.f20922d || 2 == this.f20922d) && this.f20919a != null) {
            this.f20919a.m27757a(c5691c);
        } else if (1 == this.f20922d && this.f20921c != null) {
            this.f20921c.m27733a(c5691c);
        }
    }

    public void setFirstWheelViewChangedListener(C5691c c5691c) {
        if (this.f20922d == 0 && this.f20920b != null) {
            this.f20920b.m27736b(c5691c);
        }
    }

    public String getFisrtPickerValue() {
        if (3 == this.f20922d || 2 == this.f20922d) {
            if (this.f20919a != null) {
                return String.valueOf(this.f20919a.m27755a());
            }
            return null;
        } else if (1 == this.f20922d) {
            if (this.f20921c != null) {
                return this.f20921c.m27732a();
            }
            return null;
        } else if (this.f20920b != null) {
            return this.f20920b.m27732a();
        } else {
            return null;
        }
    }

    public String getSecondPickerValue() {
        if (3 == this.f20922d || 2 == this.f20922d) {
            if (this.f20919a != null) {
                return String.valueOf(this.f20919a.m27759b());
            }
            return null;
        } else if (this.f20920b != null) {
            return this.f20920b.m27735b();
        } else {
            return null;
        }
    }

    public String getThirdPickerValue() {
        if (3 == this.f20922d || 2 == this.f20922d) {
            if (this.f20919a != null) {
                return String.valueOf(this.f20919a.m27762c());
            }
            return null;
        } else if (1 == this.f20922d) {
            if (this.f20921c != null) {
                return this.f20921c.m27738c();
            }
            return null;
        } else if (this.f20920b != null) {
            return this.f20920b.m27738c();
        } else {
            return null;
        }
    }

    public CustomAlertDialog m27718a(String str, OnClickListener onClickListener, CharSequence charSequence, OnClickListener onClickListener2, CharSequence charSequence2) {
        if (this.f20931m == null) {
            this.f20931m = new C6004c(this.f20923e).m27540a(str).m27538a(this.f20924f).m27545c(charSequence2, onClickListener2).m27539a(charSequence, onClickListener).m27535a();
        }
        this.f20931m.setOnDismissListener(new C6057b(this));
        this.f20931m.show();
        return this.f20931m;
    }

    public void m27719a() {
        this.f20929k.setVisibility(8);
    }

    public void m27723b() {
        this.f20929k.setVisibility(0);
    }

    public void m27725c() {
        this.f20930l.setVisibility(8);
    }

    public void setFirstWheelPickValueUnit(String str) {
        this.f20925g.setUnit(str);
    }

    public void setSecondWheelPickValueUnit(String str) {
        this.f20926h.setUnit(str);
    }

    public void setThirdWheelPickValueUnit(String str) {
        this.f20927i.setUnit(str);
    }

    public View getView() {
        return this.f20924f;
    }

    public void m27720a(int i, int i2) {
        this.f20925g.m27706c(i, i2);
        this.f20926h.m27706c(i, i2);
        this.f20927i.m27706c(i, i2);
    }
}
