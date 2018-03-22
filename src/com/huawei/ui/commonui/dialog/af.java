package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.C5996c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6034k;
import com.huawei.ui.commonui.C6035l;
import com.huawei.ui.commonui.C6036m;

/* compiled from: HuaweiMobileServiceSettingDialog */
public class af {
    private Context f20634a;
    private String f20635b;
    private String f20636c;
    private OnClickListener f20637d;

    public af(Context context) {
        this.f20634a = context;
    }

    public ae m27498a() {
        C2538c.c(ae.f20633a, new Object[]{"enter HuaweiMobileServiceSettingDialog create:"});
        ae aeVar = new ae(this.f20634a, C6035l.CustomDialog);
        View inflate = ((LayoutInflater) this.f20634a.getSystemService("layout_inflater")).inflate(C6031h.huawei_mobile_service_setting_switch_dialog, null);
        TextView textView = (TextView) inflate.findViewById(C6030g.smswd_title);
        TextView textView2 = (TextView) inflate.findViewById(C6030g.smswd_message);
        textView2.setText(this.f20634a.getResources().getString(C6034k.IDS_hw_plugin_account_hwid_back_run_note));
        Button button = (Button) inflate.findViewById(C6030g.smswd_positiveButton);
        if (this.f20635b != null) {
            textView.setText(this.f20635b);
        }
        if (this.f20636c != null) {
            textView2.setText(this.f20636c);
        }
        if (this.f20637d == null) {
            button.setOnClickListener(new ag(this, aeVar));
        } else {
            button.setOnClickListener(new ah(this, aeVar));
        }
        TypedValue typedValue = new TypedValue();
        this.f20634a.getTheme().resolveAttribute(C5996c.customDialogStyleRefer, typedValue, true);
        TypedArray obtainStyledAttributes = this.f20634a.getTheme().obtainStyledAttributes(typedValue.resourceId, C6036m.customDialogDefinition);
        TypedValue typedValue2 = new TypedValue();
        TypedValue typedValue3 = new TypedValue();
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_titleTextSize, typedValue2);
        obtainStyledAttributes.getValue(C6036m.customDialogDefinition_contentTextSize, typedValue3);
        textView.setTextSize(1, (float) ((int) TypedValue.complexToFloat(typedValue2.data)));
        textView2.setTextSize(1, (float) ((int) TypedValue.complexToFloat(typedValue3.data)));
        Drawable drawable = obtainStyledAttributes.getDrawable(C6036m.customDialogDefinition_dialogBackground);
        obtainStyledAttributes.recycle();
        inflate.setBackground(drawable);
        aeVar.setContentView(inflate);
        aeVar.setCancelable(false);
        Window window = aeVar.getWindow();
        window.setGravity(80);
        Display defaultDisplay = ((WindowManager) this.f20634a.getSystemService("window")).getDefaultDisplay();
        LayoutParams attributes = window.getAttributes();
        int a = m27497a(this.f20634a, 8.0f);
        attributes.width = defaultDisplay.getWidth() - (a * 2);
        attributes.y = a;
        window.setAttributes(attributes);
        window.setWindowAnimations(C6035l.track_dialog_anim);
        return aeVar;
    }

    public int m27497a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void m27499a(ae aeVar) {
        C2538c.c(ae.f20633a, new Object[]{"enter dismissDialog."});
        if (aeVar != null && aeVar.isShowing()) {
            aeVar.dismiss();
        }
    }
}
