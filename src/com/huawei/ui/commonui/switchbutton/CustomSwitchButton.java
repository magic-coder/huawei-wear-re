package com.huawei.ui.commonui.switchbutton;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Switch;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.C5996c;

public class CustomSwitchButton extends Switch {
    private Context f20783a;

    public CustomSwitchButton(Context context) {
        super(context);
        this.f20783a = context;
        m27614a();
    }

    public CustomSwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20783a = context;
        m27614a();
    }

    private void m27614a() {
        Theme theme = this.f20783a.getTheme();
        if (theme == null) {
            C2538c.e("CustomSwitchButton", new Object[]{"initView() if (t == null)"});
            return;
        }
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{C5996c.swithTrack});
        if (obtainStyledAttributes != null) {
            C2538c.c("CustomSwitchButton", new Object[]{"initView() if (arraySwitchTrack != null)"});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                C2538c.c("CustomSwitchButton", new Object[]{"initView() if (drawableSwitchTrack != null)"});
                setTrackDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
        }
        TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(new int[]{C5996c.swithInner});
        if (obtainStyledAttributes2 != null) {
            C2538c.c("CustomSwitchButton", new Object[]{"initView() if (arraySwitchThumb != null)"});
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            if (drawable2 != null) {
                C2538c.c("CustomSwitchButton", new Object[]{"initView() if (drawableSwitchThumb != null)"});
                setThumbDrawable(drawable2);
            }
            obtainStyledAttributes2.recycle();
        }
    }
}
