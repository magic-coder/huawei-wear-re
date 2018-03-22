package com.huawei.crowdtestsdk.feedback.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView extends ImageView {
    private final Paint maskPaint;
    private float rect_adius;
    private final RectF roundRect;
    private final Paint zonePaint;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.roundRect = new RectF();
        this.rect_adius = 6.0f;
        this.maskPaint = new Paint();
        this.zonePaint = new Paint();
        init();
    }

    private void init() {
        this.maskPaint.setAntiAlias(true);
        this.maskPaint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.zonePaint.setAntiAlias(true);
        this.zonePaint.setColor(-1);
        this.rect_adius = getResources().getDisplayMetrics().density * this.rect_adius;
    }

    public void setRectAdius(float f) {
        this.rect_adius = f;
        invalidate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.roundRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public void draw(Canvas canvas) {
        canvas.saveLayer(this.roundRect, this.zonePaint, 31);
        canvas.drawRoundRect(this.roundRect, this.rect_adius, this.rect_adius, this.zonePaint);
        canvas.saveLayer(this.roundRect, this.maskPaint, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
