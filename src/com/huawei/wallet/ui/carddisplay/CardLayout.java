package com.huawei.wallet.ui.carddisplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.huawei.b.f;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import com.huawei.wallet.utils.log.LogC;

public class CardLayout extends RelativeLayout {
    private int f21380A;
    private OnDragPosChanageListener f21381B;
    private int f21382C;
    private View f21383D;
    private Scroller f21384E;
    private VelocityTracker f21385F;
    private int f21386G;
    private int f21387H;
    private int f21388I;
    private OnRemovedListener f21389J;
    private OnItemClickListener f21390K;
    private boolean f21391L;
    private float f21392M;
    private int f21393N;
    private int f21394O;
    private HwScrollView f21395P;
    private final Handler f21396Q;
    private final Runnable f21397R;
    private Runnable f21398S;
    protected int f21399a;
    protected volatile int f21400b;
    protected int f21401c;
    protected int f21402d;
    protected int f21403e;
    protected int f21404f;
    protected int f21405g;
    protected int f21406h;
    protected ImageView f21407i;
    protected int f21408j;
    protected int f21409k;
    protected int f21410l;
    protected int f21411m;
    protected MoveDirection f21412n;
    protected DecelerateInterpolator f21413o;
    protected int f21414p;
    private boolean f21415q;
    private int f21416r;
    private boolean f21417s;
    private boolean f21418t;
    private boolean f21419u;
    private boolean f21420v;
    private Vibrator f21421w;
    private WindowManager f21422x;
    private LayoutParams f21423y;
    private Bitmap f21424z;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    class C61551 implements Runnable {
        final /* synthetic */ CardLayout f21427a;

        C61551(CardLayout cardLayout) {
            this.f21427a = cardLayout;
        }

        public void run() {
            LogC.m28524a("CardLayout", "mLongClickRunnable isHorSlide=" + this.f21427a.f21419u + ",isAllCollapse=" + this.f21427a.f21391L, false);
            if (!this.f21427a.f21419u && this.f21427a.f21391L && this.f21427a.f21383D.getId() != f.card_virtual) {
                boolean z = this.f21427a.f21393N == 2 && !this.f21427a.f21420v;
                if (this.f21427a.f21393N == 0 || z) {
                    this.f21427a.f21417s = true;
                    this.f21427a.f21421w.vibrate(50);
                    this.f21427a.f21383D.setVisibility(4);
                    this.f21427a.m28224a(this.f21427a.f21424z, this.f21427a.f21403e, this.f21427a.f21402d);
                    this.f21427a.f21386G = this.f21427a.f21399a;
                    if (this.f21427a.f21395P != null) {
                        this.f21427a.f21395P.setCanRebound(false);
                    }
                    this.f21427a.getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
        }
    }

    class C61562 implements Runnable {
        final /* synthetic */ CardLayout f21428a;

        C61562(CardLayout cardLayout) {
            this.f21428a = cardLayout;
        }

        public void run() {
            if (this.f21428a.f21407i != null && this.f21428a.f21395P != null) {
                int height = this.f21428a.f21395P.getHeight();
                int i = this.f21428a.f21405g - this.f21428a.f21408j;
                int i2 = this.f21428a.f21405g + this.f21428a.f21409k;
                int scrollY = this.f21428a.f21395P.getScrollY();
                if ((i2 >= height + scrollY) && this.f21428a.f21412n == MoveDirection.DOWM_DIRECTION) {
                    height = 20;
                    this.f21428a.f21410l -= 20;
                } else if (i >= scrollY || this.f21428a.f21412n != MoveDirection.UP_DIRECTION) {
                    this.f21428a.f21396Q.removeCallbacks(this.f21428a.f21398S);
                    height = 0;
                } else {
                    height = -20;
                    this.f21428a.f21410l += 20;
                }
                this.f21428a.requestDisallowInterceptTouchEvent(false);
                this.f21428a.f21395P.scrollBy(0, height);
            }
        }
    }

    public interface CardLayoutSAI1 {
    }

    public interface CardLayoutSAI2 {
    }

    public interface CardLayoutSAI3 {
    }

    public interface CardLayoutSAI4 {
    }

    public interface CardLayoutSAI5 {
    }

    public interface CardLayoutSAI6 {
    }

    public enum MoveDirection {
        RIGHT_DIRECTION,
        LEFT_DIRECTION,
        UP_DIRECTION,
        DOWM_DIRECTION
    }

    public interface OnDragPosChanageListener {
        void mo5162a(int i, int i2);

        void mo5163b(int i, int i2);
    }

    public interface OnRemovedListener {
        void m28266a(MoveDirection moveDirection, int i);
    }

    public class SwapAnimatorListener extends AnimatorListenerAdapter {
        final /* synthetic */ CardLayout f21434a;
        private int f21435b;

        public SwapAnimatorListener(CardLayout cardLayout, int i) {
            this.f21434a = cardLayout;
            this.f21435b = i;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f21434a.f21381B != null) {
                this.f21434a.f21381B.mo5162a(this.f21434a.f21399a, this.f21435b);
            }
            this.f21434a.f21399a = this.f21435b;
            super.onAnimationEnd(animator);
        }
    }

    public CardLayout(Context context) {
        this(context, null);
    }

    public CardLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21415q = false;
        this.f21417s = false;
        this.f21418t = false;
        this.f21419u = false;
        this.f21391L = true;
        this.f21393N = -1;
        this.f21396Q = new Handler();
        this.f21397R = new C61551(this);
        this.f21398S = new C61562(this);
        this.f21422x = (WindowManager) context.getSystemService("window");
        this.f21382C = this.f21422x.getDefaultDisplay().getWidth();
        this.f21384E = new Scroller(context);
        this.f21388I = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f21392M = context.getResources().getDisplayMetrics().density;
        this.f21421w = (Vibrator) context.getSystemService("vibrator");
        this.f21380A = m28222a(context);
        this.f21411m = (int) (50.0f * this.f21392M);
        this.f21387H = (int) (20.0f * this.f21392M);
        this.f21413o = new DecelerateInterpolator(1.5f);
    }

    public void setParentScrollView(HwScrollView hwScrollView) {
        this.f21395P = (HwScrollView) C0978h.a(hwScrollView);
    }

    public void setOnChangeListener(OnDragPosChanageListener onDragPosChanageListener) {
        this.f21381B = (OnDragPosChanageListener) C0978h.a(onDragPosChanageListener);
    }

    public void setInitTopCardY(int i) {
        this.f21414p = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setLastClickItemPos(int i) {
        this.f21400b = i;
    }

    public int getLastClickItemPos() {
        return this.f21400b;
    }

    private void m28224a(Bitmap bitmap, int i, int i2) {
        if (this.f21383D != null) {
            int[] iArr = new int[2];
            this.f21383D.getLocationOnScreen(iArr);
            this.f21394O = iArr[0];
        } else {
            this.f21394O = getPaddingLeft();
        }
        this.f21423y = new LayoutParams();
        this.f21423y.format = 1;
        this.f21423y.gravity = 51;
        this.f21423y.x = this.f21394O;
        this.f21423y.y = ((i2 - this.f21408j) + this.f21410l) - this.f21380A;
        this.f21423y.width = -2;
        this.f21423y.height = -2;
        this.f21423y.flags = 24;
        this.f21407i = new ImageView(getContext());
        this.f21407i.setImageBitmap(bitmap);
        this.f21422x.addView(this.f21407i, this.f21423y);
    }

    public void m28256b() {
        this.f21417s = false;
        if (this.f21407i != null) {
            this.f21422x.removeView(this.f21407i);
            this.f21407i = null;
            if (this.f21381B != null) {
                this.f21381B.mo5163b(this.f21386G, this.f21399a);
            }
            mo5158a();
        }
        if (this.f21424z != null) {
            this.f21424z.recycle();
            this.f21424z = null;
        }
    }

    private void m28230b(int i, int i2) {
        this.f21423y.x = this.f21394O;
        this.f21423y.y = ((i2 - this.f21408j) + this.f21410l) - this.f21380A;
        this.f21422x.updateViewLayout(this.f21407i, this.f21423y);
        m28254a(i, i2);
        if (this.f21395P != null) {
            boolean c = this.f21395P.m28271c();
            boolean b = this.f21395P.m28270b();
            if (this.f21412n != MoveDirection.DOWM_DIRECTION || !c) {
                if (this.f21412n != MoveDirection.UP_DIRECTION || !b) {
                    this.f21396Q.post(this.f21398S);
                }
            }
        }
    }

    protected void m28254a(int i, int i2) {
        int c = m28235c(i, i2 - this.f21408j);
        LogC.m28528b("CardLayout", "tempPosition=" + c + ",slidePosition=" + this.f21399a + ", mLastTempPosition=" + this.f21401c, false);
        if (c != -1 && c < getChildCount()) {
            if (c != this.f21399a) {
                if (this.f21381B != null) {
                    this.f21381B.mo5162a(this.f21399a, c);
                }
                mo5159a(c);
            } else if (this.f21401c == -1) {
                mo5160b(c);
            }
        }
        this.f21401c = c;
    }

    protected void mo5159a(int i) {
        ObjectAnimator a = AnimUtil.m28150a(getChildAt(i), this.f21399a, (float) this.f21411m);
        a.setInterpolator(this.f21413o);
        a.start();
        this.f21399a = i;
    }

    protected void mo5160b(int i) {
        int i2;
        if (this.f21412n == MoveDirection.DOWM_DIRECTION) {
            LogC.m28528b("CardLayout", "onSwapItem this.moveDirection == MoveDirection.DOWM mSlidePosition=" + this.f21399a, false);
            i2 = i + 1;
            if (i2 < getChildCount()) {
                ObjectAnimator a = AnimUtil.m28150a(getChildAt(i), this.f21399a, (float) this.f21411m);
                a.addListener(new SwapAnimatorListener(this, i2));
                a.setInterpolator(this.f21413o);
                a.start();
                return;
            }
            return;
        }
        LogC.m28528b("CardLayout", "onSwapItem this.moveDirection == MoveDirection.up  mSlidePosition=" + this.f21399a, false);
        i2 = i - 1;
        if (i2 >= 0) {
            a = AnimUtil.m28150a(getChildAt(i), this.f21399a, (float) this.f21411m);
            a.addListener(new SwapAnimatorListener(this, i2));
            a.start();
        }
    }

    private void m28239e() {
        LogC.m28528b("CardLayout", "onStopDrag slidePosition= " + this.f21399a + ",mDragImageView=" + this.f21407i, false);
        if (this.f21395P != null) {
            this.f21395P.setCanRebound(true);
        }
        m28256b();
    }

    protected void mo5158a() {
        ObjectAnimator a = AnimUtil.m28151a(getChildAt(this.f21399a), this.f21405g - this.f21408j, this.f21399a, (float) this.f21411m);
        a.setInterpolator(this.f21413o);
        a.start();
    }

    private static int m28222a(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (ClassNotFoundException e) {
                LogC.m28533d("CardLayout", " getStatusHeight ClassNotFoundException", false);
            } catch (InstantiationException e2) {
                LogC.m28533d("CardLayout", " getStatusHeight InstantiationException", false);
            } catch (IllegalAccessException e3) {
                LogC.m28533d("CardLayout", " getStatusHeight IllegalAccessException", false);
            } catch (NumberFormatException e4) {
                LogC.m28533d("CardLayout", " getStatusHeight NumberFormatException", false);
            } catch (IllegalArgumentException e5) {
                LogC.m28533d("CardLayout", " getStatusHeight IllegalArgumentException", false);
            } catch (NoSuchFieldException e6) {
                LogC.m28533d("CardLayout", " getStatusHeight NoSuchFieldException", false);
            }
        }
        return i;
    }

    public void setOnItemRemovedListener(OnRemovedListener onRemovedListener) {
        this.f21389J = onRemovedListener;
    }

    public int getSlidePosition() {
        return this.f21399a;
    }

    public void setSlidePosition(int i) {
        this.f21399a = i;
    }

    public void setSlide(boolean z) {
        this.f21419u = z;
    }

    public View getItemView() {
        return this.f21383D;
    }

    public void setItemView(View view) {
        this.f21383D = view;
    }

    public void setCardDisplayHeight(int i) {
        this.f21411m = i;
    }

    private int m28235c(int i, int i2) {
        int childCount = getChildCount();
        int i3 = this.f21411m;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && m28233b(childAt, i, i2, i3)) {
                return i4;
            }
        }
        return -1;
    }

    private int m28237d(int i, int i2) {
        int childCount = getChildCount();
        if (this.f21391L) {
            return mo5157a(childCount, i, i2);
        }
        int i3 = childCount - 1;
        while (i3 >= 0) {
            View childAt = getChildAt(i3);
            int height;
            if (i3 == childCount - 2 || i3 == this.f21400b) {
                height = childAt.getHeight();
            } else {
                height = this.f21387H;
            }
            if (childAt.getVisibility() == 0 && m28255a(childAt, i, i2, r0)) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    protected int mo5157a(int i, int i2, int i3) {
        int i4 = this.f21411m;
        for (int i5 = 0; i5 < i; i5++) {
            View childAt = getChildAt(i5);
            if (i5 == i - 1) {
                i4 = childAt.getHeight();
            }
            if (childAt.getVisibility() == 0 && m28255a(childAt, i2, i3, r0)) {
                return i5;
            }
        }
        return -1;
    }

    protected boolean m28255a(View view, int i, int i2, int i3) {
        boolean z = true;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i;
        int i5 = iArr2[1] + i2;
        if (i4 < iArr[0] || i4 >= iArr[0] + view.getWidth()) {
            boolean z2 = false;
        } else {
            int i6 = 1;
        }
        if (i5 < iArr[1] || i5 >= iArr[1] + i3) {
            boolean z3 = false;
        } else {
            int i7 = 1;
        }
        if (i6 == 0 || r3 == 0) {
            z = false;
        }
        return z;
    }

    private boolean m28233b(View view, int i, int i2, int i3) {
        boolean z = true;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i;
        int i5 = iArr2[1] + i2;
        int i6 = i3 / 2;
        if (i4 < iArr[0] || i4 >= iArr[0] + view.getWidth()) {
            boolean z2 = false;
        } else {
            int i7 = 1;
        }
        if (i5 < iArr[1] || i5 >= iArr[1] + i6) {
            boolean z3 = false;
        } else {
            int i8 = 1;
        }
        if (i7 == 0 || r3 == 0) {
            z = false;
        }
        return z;
    }

    protected boolean m28258c() {
        if (this.f21399a == -1 || this.f21399a >= getChildCount()) {
            return false;
        }
        boolean z = (this.f21420v || this.f21417s || this.f21419u || this.f21383D.getId() == f.card_brief) ? false : true;
        boolean z2;
        if (getChildAt(this.f21399a).getId() == this.f21383D.getId()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f21393N = motionEvent.getAction();
        switch (this.f21393N) {
            case 0:
                m28231b(motionEvent);
                if (this.f21384E.isFinished()) {
                    this.f21403e = (int) motionEvent.getX();
                    this.f21402d = (int) motionEvent.getY();
                    this.f21406h = this.f21403e;
                    this.f21399a = m28237d(this.f21403e, this.f21402d);
                    LogC.m28528b("CardLayout", "dispatchTouchEvent ACTION_DOWN slidePosition= " + this.f21399a, false);
                    if (this.f21399a != -1) {
                        this.f21383D = getChildAt(this.f21399a);
                        int id = this.f21383D.getId();
                        if (id != f.card_brief && id != f.card_virtual) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            if (this.f21418t && getChildCount() > 1) {
                                this.f21396Q.postDelayed(this.f21397R, (long) ViewConfiguration.getLongPressTimeout());
                            }
                            this.f21401c = 0;
                            this.f21408j = (int) (((float) this.f21402d) - this.f21383D.getY());
                            this.f21409k = this.f21383D.getHeight() - this.f21408j;
                            this.f21410l = (int) (motionEvent.getRawY() - ((float) this.f21402d));
                            this.f21383D.setDrawingCacheEnabled(true);
                            this.f21424z = Bitmap.createBitmap(this.f21383D.getDrawingCache());
                            this.f21383D.destroyDrawingCache();
                            break;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                return super.dispatchTouchEvent(motionEvent);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                m28248i();
                this.f21396Q.removeCallbacks(this.f21397R);
                if (this.f21383D != null) {
                    LogC.m28528b("CardLayout", "dispatchTouchEvent ACTION_UP slidePosition= " + this.f21399a + ",isMove= " + this.f21420v + ",isDrag= " + this.f21417s + ",isHorSlide=" + this.f21419u + ", itemView.getId()=" + this.f21383D.getId(), false);
                    boolean c = m28258c();
                    LogC.m28528b("CardLayout", "flag is :" + c, false);
                    if (c && this.f21390K != null) {
                        this.f21400b = this.f21399a;
                        this.f21390K.onItemClick(this.f21383D, this.f21399a);
                        break;
                    }
                }
                break;
            case 2:
                m28225a(motionEvent);
                break;
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void m28225a(MotionEvent motionEvent) {
        LogC.m28528b("CardLayout", "dealMoveEvent itemView= " + this.f21383D, false);
        if (this.f21383D != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!this.f21391L) {
                return;
            }
            if (this.f21383D.getId() != f.card_virtual) {
                if ((Math.abs(getScrollVelocity()) > HeartRateDetail.HEART_RATE_TYPE_SPORT || (Math.abs(x - this.f21403e) > this.f21388I && Math.abs(y - this.f21402d) < this.f21388I)) && !this.f21417s) {
                    this.f21419u = true;
                    if (this.f21415q) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (Math.abs(x - this.f21403e) > this.f21388I || Math.abs(y - this.f21402d) > this.f21388I) {
                    this.f21420v = true;
                }
            } else if (Math.abs(x - this.f21403e) > this.f21388I || Math.abs(y - this.f21402d) > this.f21388I) {
                this.f21420v = true;
            }
        }
    }

    private void m28242f() {
        this.f21412n = MoveDirection.RIGHT_DIRECTION;
        int scrollX = this.f21382C + this.f21383D.getScrollX();
        this.f21384E.startScroll(this.f21383D.getScrollX(), 0, -scrollX, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void m28244g() {
        this.f21412n = MoveDirection.LEFT_DIRECTION;
        int scrollX = this.f21382C - this.f21383D.getScrollX();
        this.f21384E.startScroll(this.f21383D.getScrollX(), 0, scrollX, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void m28246h() {
        if (this.f21383D.getScrollX() >= this.f21382C / 2) {
            m28244g();
        } else if (this.f21383D.getScrollX() <= (-this.f21382C) / 2) {
            m28242f();
        } else {
            this.f21383D.scrollTo(0, 0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f21420v = false;
        }
        if (this.f21419u && this.f21399a != -1) {
            m28232b(motionEvent, action);
        } else if (this.f21417s && this.f21407i != null) {
            m28226a(motionEvent, action);
        }
        return true;
    }

    private void m28226a(MotionEvent motionEvent, int i) {
        switch (i) {
            case 1:
                m28239e();
                this.f21417s = false;
                return;
            case 2:
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                onTouchEvent(obtain);
                obtain.recycle();
                this.f21404f = (int) motionEvent.getX();
                this.f21405g = (int) motionEvent.getY();
                if (this.f21405g > this.f21406h) {
                    this.f21412n = MoveDirection.DOWM_DIRECTION;
                } else if (this.f21405g < this.f21406h) {
                    this.f21412n = MoveDirection.UP_DIRECTION;
                }
                this.f21406h = this.f21405g;
                m28230b(this.f21404f, this.f21405g);
                return;
            case 3:
                this.f21396Q.removeCallbacks(this.f21397R);
                return;
            default:
                return;
        }
    }

    private boolean m28232b(MotionEvent motionEvent, int i) {
        if (!this.f21417s) {
            m28231b(motionEvent);
            int x = (int) motionEvent.getX();
            switch (i) {
                case 0:
                    break;
                case 1:
                    if (this.f21415q) {
                        x = getScrollVelocity();
                        if (x > HeartRateDetail.HEART_RATE_TYPE_SPORT) {
                            m28242f();
                        } else if (x < -600) {
                            m28244g();
                        } else {
                            m28246h();
                        }
                    }
                    m28248i();
                    this.f21419u = false;
                    break;
                case 2:
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                    onTouchEvent(obtain);
                    obtain.recycle();
                    int i2 = this.f21403e - x;
                    this.f21403e = x;
                    if (this.f21415q) {
                        this.f21383D.scrollBy(i2, 0);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public void computeScroll() {
        if (this.f21384E.computeScrollOffset()) {
            this.f21383D.scrollTo(this.f21384E.getCurrX(), this.f21384E.getCurrY());
            postInvalidate();
            if (this.f21384E.isFinished()) {
                this.f21383D.scrollTo(0, 0);
                removeViewAt(this.f21399a);
                if (this.f21389J != null) {
                    this.f21389J.m28266a(this.f21412n, this.f21399a);
                }
            }
        }
    }

    private void m28231b(MotionEvent motionEvent) {
        if (this.f21385F == null) {
            this.f21385F = VelocityTracker.obtain();
        }
        this.f21385F.addMovement(motionEvent);
    }

    private void m28248i() {
        if (this.f21385F != null) {
            this.f21385F.recycle();
            this.f21385F = null;
        }
    }

    private int getScrollVelocity() {
        this.f21385F.computeCurrentVelocity(1000);
        return (int) this.f21385F.getXVelocity();
    }

    public int getTargetHeight() {
        return this.f21416r;
    }

    public void setTargetHeight(int i) {
        this.f21416r = i;
    }

    public boolean m28259d() {
        return this.f21391L;
    }

    public void setAllCollapse(boolean z) {
        this.f21391L = z;
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.f21390K = (OnItemClickListener) C0978h.a(onItemClickListener);
    }

    public void setHorSlideEnable(boolean z) {
        this.f21415q = z;
    }

    public void setDragEnable(boolean z) {
        this.f21418t = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }
}
