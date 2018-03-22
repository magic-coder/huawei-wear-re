package com.huawei.ui.commonui.wheelview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: TrackTargetWheelView */
class C6066l extends Drawable {
    final /* synthetic */ TrackTargetWheelView f20958a;

    C6066l(TrackTargetWheelView trackTargetWheelView) {
        this.f20958a = trackTargetWheelView;
    }

    public void draw(Canvas canvas) {
        canvas.drawLine((float) (this.f20958a.f20865n * 0), (float) this.f20958a.m27664b()[0], (float) (this.f20958a.f20865n * 1), (float) this.f20958a.m27664b()[0], this.f20958a.f20864m);
        canvas.drawLine((float) (this.f20958a.f20865n * 0), (float) this.f20958a.m27664b()[1], (float) (this.f20958a.f20865n * 1), (float) this.f20958a.m27664b()[1], this.f20958a.f20864m);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
