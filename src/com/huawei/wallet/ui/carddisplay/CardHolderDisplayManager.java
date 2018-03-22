package com.huawei.wallet.ui.carddisplay;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.b.e;
import com.huawei.b.f;
import com.huawei.b.g;
import com.huawei.b.h;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.utils.StringUtil;
import com.huawei.wallet.utils.log.LogC;
import com.unionpay.tsmservice.data.ResultCode;
import java.util.ArrayList;
import java.util.List;

public class CardHolderDisplayManager extends CardDisplayManager {
    private List<UniCardInfo> f21375s;
    private float f21376t;
    private boolean f21377u;
    private boolean f21378v;
    private String f21379w = "";

    public CardHolderDisplayManager(Activity activity, CardLayout cardLayout, int i, int i2, String str) {
        super(activity, cardLayout, i, i2);
        this.f21379w = str;
    }

    public int mo5147a(int i, int i2) {
        int i3 = 0;
        if (this.b != null) {
            i3 = this.b.size();
        }
        if (this.f21375s != null) {
            i3 += this.f21375s.size();
        }
        return m28171a(i, i2, i3);
    }

    protected void mo5154f() {
        int size = this.b.size();
        int childCount = this.c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.c.getChildAt(i);
            ObjectAnimator a;
            Object animateListener;
            if (i < size) {
                a = AnimUtil.m28154a(childAt, i, size, this.i, this.k, this.n);
                animateListener = new AnimateListener(this, i);
                a.addUpdateListener(animateListener);
                a.addListener(animateListener);
                this.q.add(a);
            } else {
                a = AnimUtil.m28154a(childAt, i - size, size, this.i, this.k, this.f21376t);
                animateListener = new AnimateListener(this, i);
                a.addUpdateListener(animateListener);
                a.addListener(animateListener);
                this.q.add(a);
            }
        }
        m28191b(this.q);
    }

    protected void mo5151b() {
        mo5156n();
        if (this.b != null) {
            View h;
            int i = 0;
            for (UniCardInfo uniCardInfo : this.b) {
                int g = uniCardInfo.m28119g();
                LogC.m28530b("CardHolderDisplayManager initCardAnimImageViewList TYPE= " + g, false);
                if (g == -1110) {
                    h = m28211h(1);
                    this.f21377u = true;
                    h.setY(162.0f);
                    i++;
                    break;
                } else if (g == -1111) {
                    CardAnimImageView b = m28210b(i, uniCardInfo);
                    this.f21377u = true;
                    b.setY(this.n);
                    i++;
                    break;
                } else {
                    m28172a(i, uniCardInfo).setY(this.n + (((float) i) * this.k));
                    i++;
                }
            }
            int size = this.b.size();
            LogC.m28530b("CardHolderDisplayManager top card size= " + size + ",index= " + i, false);
            if (this.f21375s != null) {
                for (UniCardInfo uniCardInfo2 : this.f21375s) {
                    int g2 = uniCardInfo2.m28119g();
                    LogC.m28530b("CardHolderDisplayManager initCardAnimImageViewList bottomCardInfoList TYPE= " + g2, false);
                    if (g2 == -1110) {
                        h = m28211h(0);
                        this.f21378v = true;
                        h.setY(162.0f);
                        return;
                    } else if (g2 == -1111) {
                        h = m28210b(i, uniCardInfo2);
                        this.f21378v = true;
                        h.setY(this.f21376t);
                        return;
                    } else {
                        m28172a(i, uniCardInfo2).setY(this.f21376t + (((float) (i - size)) * this.k));
                        i++;
                    }
                }
            }
        }
    }

    protected void mo5149a(int i, View view, int i2, float f) {
        if (this.b != null) {
            int height;
            CardAnimImageView a;
            int abs;
            int i3 = 0;
            if (this.l == 0) {
                height = this.c.getHeight();
            } else {
                height = this.l;
            }
            int size = this.b.size();
            if (this.f21375s != null) {
                size += this.f21375s.size();
            }
            for (UniCardInfo a2 : this.b) {
                a = m28172a(i3, a2);
                abs = Math.abs((size - i3) - 1);
                if (i2 == 1) {
                    m28177a(i, i3, height, a, abs);
                } else {
                    m28176a(i, i3, height, size, a);
                }
                i3++;
            }
            if (this.f21375s != null) {
                for (UniCardInfo a22 : this.f21375s) {
                    a = m28172a(i3, a22);
                    abs = Math.abs((size - i3) - 1);
                    if (i2 == 1) {
                        m28177a(i, i3, height, a, abs);
                    } else {
                        m28176a(i, i3, height, size, a);
                    }
                    i3++;
                }
            }
            if (view != null) {
                this.o = view;
                this.c.addView(view, this.c.getChildCount());
                view.setY(((float) this.i) + (((float) m28192c(i2)) * f));
            }
        }
    }

    public void mo5152c(int i, int i2) {
        m28189b(i, i2);
        int size = this.b.size();
        if (i < size) {
            if (i2 < size) {
                m28185a(this.b, i, i2);
            }
        } else if (i2 >= size) {
            m28185a(this.f21375s, i - size, i2 - size);
        }
    }

    public int mo5155m() {
        return super.mo5153d();
    }

    public int mo5153d() {
        if (this.f21375s == null || this.f21375s.isEmpty()) {
            return mo5155m();
        }
        int size = this.f21375s.size();
        float f = (((float) (size - 1)) * this.k) + this.f21376t;
        if (this.i == 0) {
            this.i = (int) (this.d.f21450c * 203.0f);
        }
        return (int) (f + ((float) this.i));
    }

    public ArrayList<Animator> mo5150b(int i, int i2, int i3, float f) {
        ArrayList<Animator> arrayList = new ArrayList();
        if (!this.f21378v) {
            return super.mo5150b(i, i2, i3, f);
        }
        int i4 = i2 - 1;
        for (int i5 = 0; i5 < i4; i5++) {
            View childAt = this.c.getChildAt(i5);
            Object animateListener = new AnimateListener(this, i5);
            ObjectAnimator b = AnimUtil.m28160b(childAt, i5, i, this.d.f21450c, i4, i3, this.m);
            b.addUpdateListener(animateListener);
            b.addListener(animateListener);
            arrayList.add(b);
        }
        arrayList.add(AnimUtil.m28159b(this.c.getChildAt(i4), i4, i3, this.m));
        return arrayList;
    }

    public ArrayList<Animator> mo5148a(int i, int i2, int i3, float f) {
        int i4 = 0;
        ArrayList<Animator> arrayList = new ArrayList();
        View childAt;
        Object animateListener;
        ObjectAnimator a;
        if (this.f21377u) {
            arrayList.add(AnimUtil.m28159b(this.c.getChildAt(0), 0, i3, this.m));
            for (i4 = 1; i4 < i2; i4++) {
                childAt = this.c.getChildAt(i4);
                animateListener = new AnimateListener(this, i4);
                a = AnimUtil.m28152a(childAt, i4, i, this.d.f21450c, i2, i3, this.m);
                a.addUpdateListener(animateListener);
                a.addListener(animateListener);
                arrayList.add(a);
            }
            return arrayList;
        } else if (!this.f21378v) {
            return super.mo5148a(i, i2, i3, f);
        } else {
            int i5 = i2 - 1;
            while (i4 < i5) {
                childAt = this.c.getChildAt(i4);
                animateListener = new AnimateListener(this, i4);
                a = AnimUtil.m28152a(childAt, i4, i, this.d.f21450c, i5, i3, this.m);
                a.addUpdateListener(animateListener);
                a.addListener(animateListener);
                arrayList.add(a);
                i4++;
            }
            arrayList.add(AnimUtil.m28159b(this.c.getChildAt(i5), i5, i3, this.m));
            return arrayList;
        }
    }

    private View m28211h(int i) {
        View inflate = LayoutInflater.from(this.e).inflate(g.card_empty_view, null);
        inflate.setId(f.card_virtual);
        TextView textView = (TextView) inflate.findViewById(f.description);
        ImageView imageView = (ImageView) inflate.findViewById(f.empty_icon);
        if (i == 1) {
            textView.setGravity(GravityCompat.START);
            m28209a(textView);
            imageView.setBackgroundResource(e.img_empty_offline);
        } else {
            textView.setText(this.e.getResources().getString(h.add_online_card_brief));
            imageView.setBackgroundResource(e.img_empty_online);
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.j, this.i);
        layoutParams.addRule(14);
        inflate.setLayoutParams(layoutParams);
        this.c.addView(inflate);
        return inflate;
    }

    private CardAnimImageView m28210b(int i, UniCardInfo uniCardInfo) {
        View cardAnimImageView = new CardAnimImageView(this.e, null, uniCardInfo.m28124k(), uniCardInfo.m28119g(), uniCardInfo.m28117f());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.j, this.i);
        layoutParams.addRule(14);
        cardAnimImageView.setLayoutParams(layoutParams);
        cardAnimImageView.setId(f.card_virtual);
        this.c.addView(cardAnimImageView, i);
        return cardAnimImageView;
    }

    public void mo5156n() {
        this.f21377u = false;
        this.f21378v = false;
    }

    private void m28209a(TextView textView) {
        if (this.f21379w == null || StringUtil.m28479a(this.f21379w, true)) {
            C2538c.c("CardHolderDisplayManager", new Object[]{" SupportType is null"});
            textView.setText(this.e.getResources().getString(h.add_online_card_bus));
            return;
        }
        C2538c.c("CardHolderDisplayManager", new Object[]{" mSupportType " + this.f21379w});
        if (this.f21379w.equals(ResultCode.ERROR_DETAIL_SE_SERVICE_CONNTECT) || this.f21379w.equals(ResultCode.ERROR_DETAIL_TRANSMIT_APDU)) {
            textView.setText(this.e.getResources().getString(h.add_offline_card_brief));
        } else {
            textView.setText(this.e.getResources().getString(h.add_online_card_bus));
        }
    }
}
