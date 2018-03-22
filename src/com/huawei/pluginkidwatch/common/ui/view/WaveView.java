package com.huawei.pluginkidwatch.common.ui.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.widget.AutoScrollHelper;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.android.volley.DefaultRetryPolicy;

public class WaveView extends View {
    private Path f3812a;
    private Path f3813b;
    private Path f3814c;
    private Paint f3815d;
    private Paint f3816e;
    private int f3817f;
    private int f3818g;
    private int f3819h;
    private float f3820i;
    private float f3821j;
    private float f3822k;
    private float f3823l;
    private ao f3824m;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ap();
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readFloat();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.progress);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.restore();
        this.f3814c.reset();
        this.f3814c.addRect(new RectF(0.0f, 0.0f, (float) this.f3817f, (float) this.f3818g), Direction.CW);
        canvas.clipPath(this.f3814c, Op.INTERSECT);
        canvas.drawPath(this.f3813b, this.f3816e);
        this.f3814c.addRect(new RectF(0.0f, 0.0f, (float) this.f3817f, (float) this.f3818g), Direction.CW);
        canvas.clipPath(this.f3814c, Op.INTERSECT);
        canvas.drawPath(this.f3812a, this.f3815d);
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        this.f3817f = MeasureSpec.getSize(i);
        this.f3818g = MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f3817f, this.f3818g);
    }

    private void m7209a() {
        float f = 0.0f;
        this.f3812a.reset();
        this.f3813b.reset();
        int i = this.f3818g;
        getWaveOffset();
        this.f3812a.moveTo(0.0f, (float) i);
        for (float f2 = 0.0f; 70.0f * f2 <= ((float) this.f3817f) + 7.0f; f2 += 0.1f) {
            this.f3812a.lineTo(70.0f * f2, ((float) (Math.cos((double) (this.f3821j + f2)) * 20.0d)) + ((float) this.f3819h));
        }
        this.f3812a.lineTo((float) this.f3817f, (float) i);
        this.f3813b.moveTo(0.0f, (float) i);
        while (70.0f * f <= ((float) this.f3817f) + 7.0f) {
            this.f3813b.lineTo(70.0f * f, ((float) (Math.cos((double) (this.f3822k + f)) * 20.0d)) + ((float) this.f3819h));
            f += 0.1f;
        }
        this.f3813b.lineTo((float) this.f3817f, (float) i);
    }

    public void setProgress(float f) {
        if (f > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        this.f3820i = f;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3824m = new ao();
        post(this.f3824m);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3824m);
    }

    private void getWaveOffset() {
        if (this.f3822k > AutoScrollHelper.NO_MAX) {
            this.f3822k = 0.0f;
        } else {
            this.f3822k += this.f3823l;
        }
        if (this.f3821j > AutoScrollHelper.NO_MAX) {
            this.f3821j = 0.0f;
        } else {
            this.f3821j += this.f3823l;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.f3820i;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
    }
}
