package com.huawei.pluginkidwatch.common.ui.p150a;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.huawei.crowdtestsdk.constants.SdkConstants;

/* compiled from: CustomShowDialog */
public class C1507h extends Dialog {
    public C1507h(Context context, int i, int i2, boolean z) {
        this(context, SdkConstants.REQUEST_CAMERA_VIDEO, 240, i, i2, z);
        setCanceledOnTouchOutside(z);
    }

    public C1507h(Context context, int i, int i2, int i3, int i4, boolean z) {
        super(context, i4);
        setContentView(i3);
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        float a = m6980a(context);
        if (i > 0) {
            attributes.width = (int) (((float) i) * a);
        } else {
            attributes.width = (int) (324.0f * a);
        }
        if (i2 > 0) {
            attributes.height = (int) (a * ((float) i2));
        }
        attributes.gravity = 17;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(z);
    }

    public float m6980a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }
}
