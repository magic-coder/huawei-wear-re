package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: VectorDrawableCompat */
class C0010j extends C0009m {
    public C0010j(C0010j c0010j) {
        super(c0010j);
    }

    public void m28a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        if (C0007g.m20a(xmlPullParser, "pathData")) {
            TypedArray obtainAttributes = C0000h.obtainAttributes(resources, theme, attributeSet, C0001a.f32d);
            m27a(obtainAttributes);
            obtainAttributes.recycle();
        }
    }

    private void m27a(TypedArray typedArray) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.n = string;
        }
        string = typedArray.getString(1);
        if (string != null) {
            this.m = PathParser.m13a(string);
        }
    }

    public boolean mo22a() {
        return true;
    }
}
