package android.support.graphics.drawable;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils */
class C0007g {
    public static boolean m20a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float m17a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0007g.m20a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static boolean m19a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0007g.m20a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static int m18a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0007g.m20a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static int m21b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0007g.m20a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
