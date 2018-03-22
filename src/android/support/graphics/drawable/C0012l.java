package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import com.android.volley.DefaultRetryPolicy;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: VectorDrawableCompat */
class C0012l {
    final ArrayList<Object> f59a = new ArrayList();
    private final Matrix f60b = new Matrix();
    private float f61c = 0.0f;
    private float f62d = 0.0f;
    private float f63e = 0.0f;
    private float f64f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f65g = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f66h = 0.0f;
    private float f67i = 0.0f;
    private final Matrix f68j = new Matrix();
    private int f69k;
    private int[] f70l;
    private String f71m = null;

    public C0012l(C0012l c0012l, ArrayMap<String, Object> arrayMap) {
        this.f61c = c0012l.f61c;
        this.f62d = c0012l.f62d;
        this.f63e = c0012l.f63e;
        this.f64f = c0012l.f64f;
        this.f65g = c0012l.f65g;
        this.f66h = c0012l.f66h;
        this.f67i = c0012l.f67i;
        this.f70l = c0012l.f70l;
        this.f71m = c0012l.f71m;
        this.f69k = c0012l.f69k;
        if (this.f71m != null) {
            arrayMap.put(this.f71m, this);
        }
        this.f68j.set(c0012l.f68j);
        ArrayList arrayList = c0012l.f59a;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof C0012l) {
                this.f59a.add(new C0012l((C0012l) obj, arrayMap));
            } else {
                C0009m c0011k;
                if (obj instanceof C0011k) {
                    c0011k = new C0011k((C0011k) obj);
                } else if (obj instanceof C0010j) {
                    c0011k = new C0010j((C0010j) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f59a.add(c0011k);
                if (c0011k.f44n != null) {
                    arrayMap.put(c0011k.f44n, c0011k);
                }
            }
        }
    }

    public String m40a() {
        return this.f71m;
    }

    public Matrix m42b() {
        return this.f68j;
    }

    public void m41a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = C0000h.obtainAttributes(resources, theme, attributeSet, C0001a.f30b);
        m35a(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    private void m35a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f70l = null;
        this.f61c = C0007g.m17a(typedArray, xmlPullParser, "rotation", 5, this.f61c);
        this.f62d = typedArray.getFloat(1, this.f62d);
        this.f63e = typedArray.getFloat(2, this.f63e);
        this.f64f = C0007g.m17a(typedArray, xmlPullParser, "scaleX", 3, this.f64f);
        this.f65g = C0007g.m17a(typedArray, xmlPullParser, "scaleY", 4, this.f65g);
        this.f66h = C0007g.m17a(typedArray, xmlPullParser, "translateX", 6, this.f66h);
        this.f67i = C0007g.m17a(typedArray, xmlPullParser, "translateY", 7, this.f67i);
        String string = typedArray.getString(0);
        if (string != null) {
            this.f71m = string;
        }
        m38c();
    }

    private void m38c() {
        this.f68j.reset();
        this.f68j.postTranslate(-this.f62d, -this.f63e);
        this.f68j.postScale(this.f64f, this.f65g);
        this.f68j.postRotate(this.f61c, 0.0f, 0.0f);
        this.f68j.postTranslate(this.f66h + this.f62d, this.f67i + this.f63e);
    }
}
