package android.support.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.android.volley.DefaultRetryPolicy;
import java.io.IOException;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class VectorDrawableCompat extends C0000h {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final Mode DEFAULT_TINT_MODE = Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private C0014o mVectorState;

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new C0014o();
    }

    private VectorDrawableCompat(@NonNull C0014o c0014o) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = c0014o;
        this.mTintFilter = updateTintFilter(this.mTintFilter, c0014o.f90c, c0014o.f91d);
    }

    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
        } else if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new C0014o(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    Object getTargetByName(String str) {
        return this.mVectorState.f89b.f79g.get(str);
    }

    public ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) {
            return new C0015p(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.f88a = getChangingConfigurations();
        return this.mVectorState;
    }

    public void draw(Canvas canvas) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
            return;
        }
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            ColorFilter colorFilter = this.mColorFilter == null ? this.mTintFilter : this.mColorFilter;
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float abs = Math.abs(this.mTmpFloats[0]);
            float abs2 = Math.abs(this.mTmpFloats[4]);
            float abs3 = Math.abs(this.mTmpFloats[1]);
            float abs4 = Math.abs(this.mTmpFloats[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                abs = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            }
            int height = (int) (abs2 * ((float) this.mTmpBounds.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.mTmpBounds.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.mTmpBounds.left, (float) this.mTmpBounds.top);
                if (needMirroring()) {
                    canvas.translate((float) this.mTmpBounds.width(), 0.0f);
                    canvas.scale(GroundOverlayOptions.NO_DIMENSION, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                }
                this.mTmpBounds.offsetTo(0, 0);
                this.mVectorState.m61b(min, height);
                if (!this.mAllowCaching) {
                    this.mVectorState.m58a(min, height);
                } else if (!this.mVectorState.m62b()) {
                    this.mVectorState.m58a(min, height);
                    this.mVectorState.m63c();
                }
                this.mVectorState.m59a(canvas, colorFilter, this.mTmpBounds);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }
        return this.mVectorState.f89b.m52a();
    }

    public void setAlpha(int i) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(i);
        } else if (this.mVectorState.f89b.m52a() != i) {
            this.mVectorState.f89b.m54a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, colorStateList);
            return;
        }
        C0014o c0014o = this.mVectorState;
        if (c0014o.f90c != colorStateList) {
            c0014o.f90c = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, c0014o.f91d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, mode);
            return;
        }
        C0014o c0014o = this.mVectorState;
        if (c0014o.f91d != mode) {
            c0014o.f91d = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, c0014o.f90c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        return super.isStateful() || !(this.mVectorState == null || this.mVectorState.f90c == null || !this.mVectorState.f90c.isStateful());
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(iArr);
        }
        C0014o c0014o = this.mVectorState;
        if (c0014o.f90c == null || c0014o.f91d == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, c0014o.f90c, c0014o.f91d);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.f89b.f73a;
    }

    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.f89b.f74b;
    }

    public boolean canApplyTheme() {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.canApplyTheme(this.mDelegateDrawable);
        }
        return false;
    }

    public float getPixelSize() {
        if ((this.mVectorState == null && this.mVectorState.f89b == null) || this.mVectorState.f89b.f73a == 0.0f || this.mVectorState.f89b.f74b == 0.0f || this.mVectorState.f89b.f76d == 0.0f || this.mVectorState.f89b.f75c == 0.0f) {
            return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        float f = this.mVectorState.f89b.f73a;
        float f2 = this.mVectorState.f89b.f74b;
        return Math.min(this.mVectorState.f89b.f75c / f, this.mVectorState.f89b.f76d / f2);
    }

    @Nullable
    public static VectorDrawableCompat create(@NonNull Resources resources, @DrawableRes int i, @Nullable Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(resources, i, theme);
            vectorDrawableCompat.mCachedConstantStateDelegate = new C0015p(vectorDrawableCompat.mDelegateDrawable.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e(LOGTAG, "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e(LOGTAG, "parser error", e2);
            return null;
        }
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private static int applyAlpha(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (ViewCompat.MEASURED_SIZE_MASK & i);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0014o c0014o = this.mVectorState;
        c0014o.f89b = new C0013n();
        TypedArray obtainAttributes = C0000h.obtainAttributes(resources, theme, attributeSet, C0001a.f29a);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        c0014o.f88a = getChangingConfigurations();
        c0014o.f98k = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, c0014o.f90c, c0014o.f91d);
    }

    private static Mode parseTintModeCompat(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C0014o c0014o = this.mVectorState;
        C0013n c0013n = c0014o.f89b;
        c0014o.f91d = parseTintModeCompat(C0007g.m18a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0014o.f90c = colorStateList;
        }
        c0014o.f92e = C0007g.m19a(typedArray, xmlPullParser, "autoMirrored", 5, c0014o.f92e);
        c0013n.f75c = C0007g.m17a(typedArray, xmlPullParser, "viewportWidth", 7, c0013n.f75c);
        c0013n.f76d = C0007g.m17a(typedArray, xmlPullParser, "viewportHeight", 8, c0013n.f76d);
        if (c0013n.f75c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0013n.f76d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0013n.f73a = typedArray.getDimension(3, c0013n.f73a);
            c0013n.f74b = typedArray.getDimension(2, c0013n.f74b);
            if (c0013n.f73a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0013n.f74b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0013n.m53a(C0007g.m17a(typedArray, xmlPullParser, "alpha", 4, c0013n.m56b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0013n.f78f = string;
                    c0013n.f79g.put(string, c0013n);
                }
            }
        }
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C0014o c0014o = this.mVectorState;
        C0013n c0013n = c0014o.f89b;
        Stack stack = new Stack();
        stack.push(c0013n.f87p);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0012l c0012l = (C0012l) stack.peek();
                if ("path".equals(name)) {
                    C0011k c0011k = new C0011k();
                    c0011k.m33a(resources, attributeSet, theme, xmlPullParser);
                    c0012l.f59a.add(c0011k);
                    if (c0011k.m26b() != null) {
                        c0013n.f79g.put(c0011k.m26b(), c0011k);
                    }
                    obj2 = null;
                    c0014o.f88a = c0011k.o | c0014o.f88a;
                } else if (SHAPE_CLIP_PATH.equals(name)) {
                    C0010j c0010j = new C0010j();
                    c0010j.m28a(resources, attributeSet, theme, xmlPullParser);
                    c0012l.f59a.add(c0010j);
                    if (c0010j.m26b() != null) {
                        c0013n.f79g.put(c0010j.m26b(), c0010j);
                    }
                    c0014o.f88a |= c0010j.o;
                    obj2 = obj;
                } else {
                    if (SHAPE_GROUP.equals(name)) {
                        C0012l c0012l2 = new C0012l();
                        c0012l2.m41a(resources, attributeSet, theme, xmlPullParser);
                        c0012l.f59a.add(c0012l2);
                        stack.push(c0012l2);
                        if (c0012l2.m40a() != null) {
                            c0013n.f79g.put(c0012l2.m40a(), c0012l2);
                        }
                        c0014o.f88a |= c0012l2.f69k;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if (SHAPE_GROUP.equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    private void printGroupTree(C0012l c0012l, int i) {
        int i2;
        String str = "";
        for (i2 = 0; i2 < i; i2++) {
            str = str + "    ";
        }
        Log.v(LOGTAG, str + "current group is :" + c0012l.m40a() + " rotation is " + c0012l.f61c);
        Log.v(LOGTAG, str + "matrix is :" + c0012l.m42b().toString());
        for (i2 = 0; i2 < c0012l.f59a.size(); i2++) {
            Object obj = c0012l.f59a.get(i2);
            if (obj instanceof C0012l) {
                printGroupTree((C0012l) obj, i + 1);
            } else {
                ((C0009m) obj).m23a(i + 1);
            }
        }
    }

    void setAllowCaching(boolean z) {
        this.mAllowCaching = z;
    }

    private boolean needMirroring() {
        return false;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(i, i2, i3, i4);
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    public void setBounds(Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
        } else {
            super.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
