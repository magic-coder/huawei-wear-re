package com.huawei.wallet.ui.carddisplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.b.e;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.utils.log.LogC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDisplayManager {
    protected OnAnimateListener f21357a;
    protected List<UniCardInfo> f21358b;
    protected CardLayout f21359c;
    protected ScreenParam f21360d;
    protected Activity f21361e;
    protected boolean f21362f = true;
    protected boolean f21363g = false;
    protected int f21364h = 1;
    protected int f21365i;
    protected int f21366j;
    protected float f21367k;
    protected int f21368l;
    protected float f21369m;
    protected float f21370n;
    protected View f21371o;
    protected float f21372p;
    protected List<Animator> f21373q;
    protected Handler f21374r = new C61541(this);

    public interface OnAnimateListener {
        void onAllAnimateEnd(boolean z);

        void onAnimateEnd(int i, boolean z);

        void onAnimateStart(int i, boolean z);

        void onAnimateUpdate(int i, float f, boolean z);
    }

    class C61541 extends Handler {
        final /* synthetic */ CardDisplayManager f21354a;

        C61541(CardDisplayManager cardDisplayManager) {
            this.f21354a = cardDisplayManager;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.f21354a.mo5156n();
        }
    }

    public class AnimateListener extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        final /* synthetic */ CardDisplayManager f21355a;
        private int f21356b;

        public AnimateListener(CardDisplayManager cardDisplayManager, int i) {
            this.f21355a = cardDisplayManager;
            this.f21356b = i;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f21356b == -1) {
                this.f21355a.f21363g = false;
                if (this.f21355a.f21357a != null) {
                    this.f21355a.f21357a.onAllAnimateEnd(this.f21355a.f21362f);
                }
            } else if (this.f21355a.f21357a != null) {
                this.f21355a.f21357a.onAnimateEnd(this.f21356b, this.f21355a.f21362f);
            }
            this.f21355a.f21373q.clear();
            super.onAnimationEnd(animator);
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f21355a.f21363g = true;
            if (this.f21355a.f21357a != null) {
                this.f21355a.f21357a.onAnimateStart(this.f21356b, this.f21355a.f21362f);
            }
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue("translationY")).floatValue();
            if (this.f21355a.f21357a != null && this.f21356b != -1) {
                this.f21355a.f21357a.onAnimateUpdate(this.f21356b, floatValue, this.f21355a.f21362f);
            }
        }
    }

    public CardDisplayManager(Activity activity, CardLayout cardLayout, int i, int i2) {
        m28165a(activity, cardLayout, i, i2);
    }

    private void m28165a(Activity activity, CardLayout cardLayout, int i, int i2) {
        m28164a(activity, cardLayout);
        m28199e(i2);
        m28201f(i);
        mo5155m();
    }

    private void mo5155m() {
        if (this.f21365i > 0) {
            this.f21367k = 0.25f * ((float) this.f21365i);
        } else {
            this.f21367k = 50.0f * this.f21360d.f21450c;
        }
        this.f21359c.setCardDisplayHeight(Float.valueOf(this.f21367k).intValue());
    }

    private void m28164a(Activity activity, CardLayout cardLayout) {
        this.f21360d = new ScreenParam();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f21360d.f21448a = displayMetrics.widthPixels;
        this.f21360d.f21449b = displayMetrics.heightPixels;
        this.f21360d.f21450c = displayMetrics.density;
        this.f21359c = cardLayout;
        this.f21361e = activity;
    }

    public void m28183a(OnAnimateListener onAnimateListener) {
        this.f21357a = (OnAnimateListener) C0978h.a(onAnimateListener);
    }

    public int m28169a() {
        return this.f21368l;
    }

    public void m28175a(int i) {
        this.f21368l = i;
    }

    public void m28184a(List<UniCardInfo> list) {
        this.f21358b = (List) C0978h.a(list);
    }

    private String m28163a(UniCardInfo uniCardInfo) {
        if (uniCardInfo.m28119g() == 2) {
            return uniCardInfo.m28122i();
        }
        String i = uniCardInfo.m28122i();
        if (!TextUtils.isEmpty(i)) {
            int length = i.length();
            if (length >= 4) {
                StringBuilder stringBuilder = new StringBuilder("**** ");
                stringBuilder.append(i.substring(length - 4));
                return stringBuilder.toString();
            }
        }
        return "";
    }

    protected void mo5151b() {
        if (this.f21358b != null) {
            LogC.m28528b("CardDisplayManager", "initCardAnimImageViewList cardAnimInfoList.SIZE=" + this.f21358b.size(), false);
            int i = 0;
            for (UniCardInfo a : this.f21358b) {
                m28172a(i, a).setY(((float) i) * this.f21367k);
                i++;
            }
        }
    }

    protected void mo5149a(int i, View view, int i2, float f) {
        if (this.f21358b != null) {
            int height;
            LogC.m28528b("CardDisplayManager", "initCardAnimImageViewList cardAnimInfoList.SIZE=" + this.f21358b.size(), false);
            int i3 = 0;
            if (this.f21368l == 0) {
                height = this.f21359c.getHeight();
            } else {
                height = this.f21368l;
            }
            int size = this.f21358b.size();
            for (UniCardInfo a : this.f21358b) {
                CardAnimImageView a2 = m28172a(i3, a);
                int abs = Math.abs((size - 1) - i3);
                if (i2 == 1) {
                    m28177a(i, i3, height, a2, abs);
                } else {
                    m28176a(i, i3, height, size, a2);
                }
                i3++;
            }
            if (view != null) {
                this.f21371o = view;
                this.f21359c.addView(view, this.f21359c.getChildCount());
                view.setY(((float) this.f21365i) + (((float) m28192c(i2)) * f));
            }
        }
    }

    protected void m28176a(int i, int i2, int i3, int i4, CardAnimImageView cardAnimImageView) {
        if (i2 == i) {
            cardAnimImageView.setY(0.0f);
            return;
        }
        float f;
        if (i2 <= i) {
            i2++;
        }
        int abs = Math.abs((i4 - i2) - 1);
        if (abs == 0) {
            f = (((float) i3) - (this.f21360d.f21450c * 20.0f)) + this.f21369m;
        } else {
            f = ((((float) i3) - (this.f21360d.f21450c * 20.0f)) - (((float) (abs * 6)) * this.f21360d.f21450c)) + this.f21369m;
        }
        cardAnimImageView.setY(f);
        if (this.f21372p < f) {
            this.f21372p = f;
        }
        cardAnimImageView.setScaleX(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((((float) Math.abs(abs)) * (4.0f * this.f21360d.f21450c)) / ((float) this.f21366j)));
    }

    protected void m28177a(int i, int i2, int i3, CardAnimImageView cardAnimImageView, int i4) {
        if (i2 <= i) {
            cardAnimImageView.setY(0.0f);
            return;
        }
        float f;
        if (i4 == 0) {
            f = (((float) i3) - (this.f21360d.f21450c * 20.0f)) + this.f21369m;
        } else {
            f = ((((float) i3) - (this.f21360d.f21450c * 20.0f)) - (((float) (i4 * 6)) * this.f21360d.f21450c)) + this.f21369m;
        }
        cardAnimImageView.setY(f);
        cardAnimImageView.setScaleX(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((((float) Math.abs(i4)) * (4.0f * this.f21360d.f21450c)) / ((float) this.f21366j)));
    }

    protected CardAnimImageView m28172a(int i, UniCardInfo uniCardInfo) {
        View cardAnimImageView = new CardAnimImageView(this.f21361e, m28163a(uniCardInfo), uniCardInfo.m28124k(), uniCardInfo.m28119g(), uniCardInfo.m28117f());
        int h = uniCardInfo.m28121h();
        if (h == 1) {
            cardAnimImageView.setCardStateBitmap(BitmapFactory.decodeResource(this.f21361e.getResources(), e.card_enable));
        } else if (h == 4) {
            cardAnimImageView.setCardStateBitmap(BitmapFactory.decodeResource(this.f21361e.getResources(), e.card_nonreal));
        } else if (h == 3) {
            cardAnimImageView.setCardStateBitmap(BitmapFactory.decodeResource(this.f21361e.getResources(), e.card_unreal));
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f21366j, this.f21365i);
        layoutParams.addRule(14);
        cardAnimImageView.setLayoutParams(layoutParams);
        cardAnimImageView.setId(i);
        this.f21359c.addView(cardAnimImageView, i);
        return cardAnimImageView;
    }

    public void m28193c() {
        LogC.m28528b("CardDisplayManager", "display cardContainer=" + this.f21359c, false);
        if (this.f21359c != null) {
            this.f21362f = true;
            this.f21359c.removeAllViews();
            this.f21359c.setAllCollapse(this.f21362f);
            mo5151b();
        }
    }

    public void m28178a(int i, View view, int i2) {
        m28190b(i, view, i2, 0.0f);
    }

    public void m28190b(int i, View view, int i2, float f) {
        if (this.f21359c != null) {
            this.f21359c.removeAllViews();
            this.f21362f = false;
            this.f21359c.setAllCollapse(this.f21362f);
            this.f21359c.setLastClickItemPos(i);
            mo5149a(i, view, i2, f);
        }
    }

    public int m28186b(int i) {
        return mo5147a(i, this.f21359c.getLastClickItemPos());
    }

    public int mo5147a(int i, int i2) {
        if (this.f21358b != null) {
            return m28171a(i, i2, this.f21358b.size());
        }
        return 0;
    }

    public int m28171a(int i, int i2, int i3) {
        int i4 = 0;
        if (i3 == 1) {
            return 0;
        }
        if (i == 2) {
            return (int) ((this.f21360d.f21450c * 20.0f) + ((((float) (i3 - 2)) * this.f21360d.f21450c) * 6.0f));
        }
        int i5 = (i3 - 2) - i2;
        if (i5 >= 0) {
            i4 = i5;
        }
        return (int) (((((float) i4) * this.f21360d.f21450c) * 6.0f) + (this.f21360d.f21450c * 20.0f));
    }

    public int m28192c(int i) {
        int height;
        if (this.f21368l == 0) {
            height = this.f21359c.getHeight();
        } else {
            height = this.f21368l;
        }
        return (height - m28186b(i)) - this.f21359c.getChildAt(0).getHeight();
    }

    public int mo5153d() {
        if (this.f21358b == null) {
            return 0;
        }
        int size = this.f21358b.size();
        if (size == 0) {
            return 0;
        }
        float f = this.f21367k * ((float) (size - 1));
        if (this.f21365i == 0) {
            this.f21365i = (int) (this.f21360d.f21450c * 203.0f);
        }
        return (int) (f + ((float) this.f21365i));
    }

    public void m28181a(View view, int i, View view2) {
        m28182a(view, i, view2, 0.0f);
    }

    public void m28182a(View view, int i, View view2, float f) {
        LogC.m28528b("CardDisplayManager", "onItemClick isAnimation:: " + this.f21363g, false);
        if (!this.f21363g) {
            if (!this.f21362f) {
                m28198e();
            } else if (i != -1) {
                m28180a(i, view, view2, this.f21364h, f);
            } else {
                return;
            }
            this.f21359c.setAllCollapse(this.f21362f);
        }
    }

    public void m28196d(int i) {
        this.f21364h = i;
    }

    protected void m28180a(int i, View view, View view2, int i2, float f) {
        int childCount;
        int height;
        this.f21371o = view2;
        this.f21362f = false;
        if (this.f21373q == null) {
            this.f21373q = new ArrayList();
        }
        if (view2 != null) {
            view2.setVisibility(4);
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-2, -2);
            }
            layoutParams.width = this.f21366j;
            view2.setY(((float) this.f21365i) + (((float) m28192c(1)) * f));
            view2.setLayoutParams(layoutParams);
            this.f21359c.addView(view2, this.f21359c.getChildCount());
            childCount = this.f21359c.getChildCount() - 1;
        } else {
            childCount = this.f21359c.getChildCount();
        }
        AnimUtil.m28156a(0);
        if (this.f21368l == 0) {
            height = this.f21359c.getHeight();
            LogC.m28528b("CardDisplayManager", " runAnimForOneExpand firstCardDistanceToBottom is 0 and height=" + height + ",size=" + childCount, false);
        } else {
            height = this.f21368l;
            LogC.m28528b("CardDisplayManager", " runAnimForOneExpand firstCardDistanceToBottom is not 0 and height=" + height + ",size=" + childCount, false);
        }
        if (i2 == 1) {
            this.f21373q = mo5150b(i, childCount, height, f);
        } else if (i2 == 2) {
            this.f21373q = mo5148a(i, childCount, height, f);
        }
        if (this.f21373q != null) {
            this.f21374r.sendEmptyMessageDelayed(1, ((Animator) this.f21373q.get(i)).getDuration() - 100);
            m28191b(this.f21373q);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
    }

    public ArrayList<Animator> mo5148a(int i, int i2, int i3, float f) {
        ArrayList<Animator> arrayList = new ArrayList();
        for (int i4 = 0; i4 < i2; i4++) {
            ObjectAnimator a = AnimUtil.m28152a(this.f21359c.getChildAt(i4), i4, i, this.f21360d.f21450c, i2, i3, this.f21369m);
            Object animateListener = new AnimateListener(this, i4);
            a.addUpdateListener(animateListener);
            a.addListener(animateListener);
            arrayList.add(a);
        }
        return arrayList;
    }

    public ArrayList<Animator> mo5150b(int i, int i2, int i3, float f) {
        ArrayList<Animator> arrayList = new ArrayList();
        for (int i4 = 0; i4 < i2; i4++) {
            ObjectAnimator b = AnimUtil.m28160b(this.f21359c.getChildAt(i4), i4, i, this.f21360d.f21450c, i2, i3, this.f21369m);
            Object animateListener = new AnimateListener(this, i4);
            b.addUpdateListener(animateListener);
            b.addListener(animateListener);
            arrayList.add(b);
        }
        return arrayList;
    }

    private ObjectAnimator m28162a(float f, View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat}).setDuration(100);
    }

    private void mo5156n() {
        if (this.f21371o != null) {
            this.f21371o.setVisibility(0);
            m28162a(0.0f, this.f21371o).start();
        }
    }

    protected void m28198e() {
        this.f21362f = true;
        if (this.f21373q == null) {
            this.f21373q = new ArrayList();
        }
        if (this.f21371o != null) {
            this.f21359c.removeViewAt(this.f21359c.getChildCount() - 1);
            this.f21371o = null;
        }
        AnimUtil.m28156a(0);
        mo5154f();
    }

    protected void mo5154f() {
        int childCount = this.f21359c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ObjectAnimator a = AnimUtil.m28153a(this.f21359c.getChildAt(i), i, childCount, this.f21365i, this.f21367k);
            Object animateListener = new AnimateListener(this, i);
            a.addUpdateListener(animateListener);
            a.addListener(animateListener);
            this.f21373q.add(a);
        }
        m28191b(this.f21373q);
    }

    public void m28191b(List<Animator> list) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(list);
        animatorSet.addListener(new AnimateListener(this, -1));
        animatorSet.setInterpolator(new DecelerateInterpolator(1.5f));
        animatorSet.start();
    }

    public void m28189b(int i, int i2) {
        if (i != -1 && i2 != -1) {
            int childCount = this.f21359c.getChildCount();
            if (i < childCount && i2 < childCount && this.f21358b == null) {
            }
        }
    }

    public void mo5152c(int i, int i2) {
        LogC.m28528b("CardDisplayManager", " onDragPostionChange= " + i + ", newPosition= " + i2, false);
        m28189b(i, i2);
        m28185a(this.f21358b, i, i2);
    }

    protected void m28185a(List<UniCardInfo> list, int i, int i2) {
        for (UniCardInfo i3 : list) {
            LogC.m28528b("CardDisplayManager", " before change card id: " + i3.m28122i(), true);
        }
        UniCardInfo i32 = (UniCardInfo) list.get(i);
        if (i < i2) {
            while (i < i2) {
                Collections.swap(list, i, i + 1);
                i++;
            }
        } else if (i > i2) {
            while (i > i2) {
                Collections.swap(list, i, i - 1);
                i--;
            }
        }
        list.set(i2, i32);
        for (UniCardInfo i322 : list) {
            LogC.m28528b("CardDisplayManager", " after change card id: " + i322.m28122i(), true);
        }
    }

    public void m28197d(int i, int i2) {
        LogC.m28528b("CardDisplayManager", " onDragStop= " + i + ", newPosition= " + i2, false);
        m28193c();
    }

    public int m28202g() {
        return this.f21365i;
    }

    public void m28199e(int i) {
        this.f21365i = i;
    }

    public void m28201f(int i) {
        this.f21366j = i;
    }

    public boolean m28204h() {
        return this.f21363g;
    }

    public void m28174a(float f) {
        this.f21369m = f;
    }

    public boolean m28205i() {
        return this.f21362f;
    }

    public float m28206j() {
        return this.f21369m;
    }

    public void m28203g(int i) {
        this.f21364h = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public float m28207k() {
        return this.f21372p;
    }

    public int m28208l() {
        if (this.f21358b != null) {
            return this.f21358b.size();
        }
        return 0;
    }
}
