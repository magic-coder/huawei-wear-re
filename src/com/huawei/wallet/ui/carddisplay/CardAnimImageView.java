package com.huawei.wallet.ui.carddisplay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.huawei.b.d;
import com.huawei.b.e;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.utils.bitmap.BitmapLruCacheForLocal;

public class CardAnimImageView extends ImageView {
    private Bitmap f21347a;
    private Bitmap f21348b;
    private String f21349c;
    private Paint f21350d;
    private float f21351e;
    private float f21352f;
    private float f21353g;

    public CardAnimImageView(Context context, String str, String str2, int i, String str3) {
        super(context);
        setScaleType(ScaleType.FIT_XY);
        C2538c.c("CardAnimImageView", new Object[]{"CardAnimImageView, localPath: " + str2 + " productId : " + str3});
        this.f21347a = BitmapLruCacheForLocal.m28495a().m28497a(str2);
        if (this.f21347a == null) {
            if (2 == i) {
                this.f21347a = BitmapFactory.decodeResource(getResources(), e.bus_card_default);
            } else {
                this.f21347a = BitmapFactory.decodeResource(getResources(), e.card_default);
            }
        }
        setImageBitmap(this.f21347a);
        this.f21349c = str;
        this.f21351e = context.getResources().getDimension(d.card_num_size);
        this.f21352f = context.getResources().getDimension(d.card_num_left_space);
        this.f21353g = context.getResources().getDimension(d.card_num_bottom_space);
        this.f21350d = new Paint(1);
        this.f21350d.setColor(-1);
        if (Constant.ZX_PRODUCT_ID.equals(str3)) {
            this.f21350d.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.f21350d.setTextSize(this.f21351e);
    }

    public String getCardNumberString() {
        return this.f21349c;
    }

    public void setCardNumberString(String str) {
        this.f21349c = str;
    }

    public void setCardStateBitmap(Bitmap bitmap) {
        this.f21348b = bitmap;
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m28161a(canvas);
    }

    private void m28161a(Canvas canvas) {
        if (this.f21348b != null) {
            canvas.drawBitmap(this.f21348b, (float) (canvas.getWidth() - this.f21348b.getWidth()), (float) getTop(), null);
        }
        if (this.f21349c != null) {
            canvas.drawText(this.f21349c, this.f21352f, ((float) canvas.getHeight()) - this.f21353g, this.f21350d);
        }
    }

    public void setCardBitmap(Bitmap bitmap) {
        this.f21347a = bitmap;
    }
}
