package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.util.AttributeSet;
import com.android.volley.DefaultRetryPolicy;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: VectorDrawableCompat */
class C0011k extends C0009m {
    int f46a = 0;
    float f47b = 0.0f;
    int f48c = 0;
    float f49d = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    int f50e;
    float f51f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    float f52g = 0.0f;
    float f53h = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    float f54i = 0.0f;
    Cap f55j = Cap.BUTT;
    Join f56k = Join.MITER;
    float f57l = 4.0f;
    private int[] f58p;

    public C0011k(C0011k c0011k) {
        super(c0011k);
        this.f58p = c0011k.f58p;
        this.f46a = c0011k.f46a;
        this.f47b = c0011k.f47b;
        this.f49d = c0011k.f49d;
        this.f48c = c0011k.f48c;
        this.f50e = c0011k.f50e;
        this.f51f = c0011k.f51f;
        this.f52g = c0011k.f52g;
        this.f53h = c0011k.f53h;
        this.f54i = c0011k.f54i;
        this.f55j = c0011k.f55j;
        this.f56k = c0011k.f56k;
        this.f57l = c0011k.f57l;
    }

    private Cap m30a(int i, Cap cap) {
        switch (i) {
            case 0:
                return Cap.BUTT;
            case 1:
                return Cap.ROUND;
            case 2:
                return Cap.SQUARE;
            default:
                return cap;
        }
    }

    private Join m31a(int i, Join join) {
        switch (i) {
            case 0:
                return Join.MITER;
            case 1:
                return Join.ROUND;
            case 2:
                return Join.BEVEL;
            default:
                return join;
        }
    }

    public void m33a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = C0000h.obtainAttributes(resources, theme, attributeSet, C0001a.f31c);
        m32a(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    private void m32a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f58p = null;
        if (C0007g.m20a(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(2);
            if (string != null) {
                this.m = PathParser.m13a(string);
            }
            this.f48c = C0007g.m21b(typedArray, xmlPullParser, "fillColor", 1, this.f48c);
            this.f51f = C0007g.m17a(typedArray, xmlPullParser, "fillAlpha", 12, this.f51f);
            this.f55j = m30a(C0007g.m18a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f55j);
            this.f56k = m31a(C0007g.m18a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f56k);
            this.f57l = C0007g.m17a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f57l);
            this.f46a = C0007g.m21b(typedArray, xmlPullParser, "strokeColor", 3, this.f46a);
            this.f49d = C0007g.m17a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f49d);
            this.f47b = C0007g.m17a(typedArray, xmlPullParser, "strokeWidth", 4, this.f47b);
            this.f53h = C0007g.m17a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f53h);
            this.f54i = C0007g.m17a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f54i);
            this.f52g = C0007g.m17a(typedArray, xmlPullParser, "trimPathStart", 5, this.f52g);
        }
    }
}
