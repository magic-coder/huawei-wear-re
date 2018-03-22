package com.huawei.wallet.ui.cardholder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.NFCOpenApiImpl;
import com.huawei.nfc.carrera.logic.NFCOpenApi;
import com.huawei.nfc.carrera.logic.cardinfo.model.WalletSupportInfo;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p130e.C5730c;
import com.huawei.pay.ui.util.UiUtil;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.wallet.R;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.ui.carddisplay.AnimUtil;
import com.huawei.wallet.ui.carddisplay.CardAnimImageView;
import com.huawei.wallet.ui.carddisplay.CardDisplayManager.OnAnimateListener;
import com.huawei.wallet.ui.carddisplay.CardHolderDisplayManager;
import com.huawei.wallet.ui.carddisplay.CardHolderLayout;
import com.huawei.wallet.ui.carddisplay.CardLayout.OnDragPosChanageListener;
import com.huawei.wallet.ui.carddisplay.CardLayout.OnItemClickListener;
import com.huawei.wallet.ui.carddisplay.CardListInfoListener;
import com.huawei.wallet.ui.carddisplay.HwScrollView;
import com.huawei.wallet.utils.BaseLibUtil;
import com.huawei.wallet.utils.log.LogC;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"NewApi"})
public class CardHolderFragment extends Fragment implements OnClickListener, CardListInfoListener {
    private static ExecutorService f21466H = Executors.newFixedThreadPool(2);
    private boolean f21467A;
    private int f21468B;
    private Drawable f21469C;
    private NFCOpenApi f21470D;
    private ScrollViewTouchListener f21471E;
    private DisplayRunnbale f21472F;
    private CardHandler f21473G;
    private String f21474I = "";
    private int f21475a;
    private C6002a f21476b;
    private View f21477c;
    private TextView f21478d;
    private TextView f21479e;
    private View f21480f;
    private View f21481g;
    private ViewGroup f21482h;
    private HwScrollView f21483i;
    private CardHolderLayout f21484j;
    private View f21485k;
    private ImageView f21486l;
    private ImageView f21487m;
    private TextView f21488n;
    private Button f21489o;
    private List<UniCardInfo> f21490p;
    private CardHolderDisplayManager f21491q;
    private View f21492r;
    private View f21493s;
    private float f21494t;
    private float f21495u;
    private float f21496v;
    private int f21497w;
    private int f21498x;
    private int f21499y;
    private CardListener f21500z;

    class C61581 implements Runnable {
        final /* synthetic */ CardHolderFragment f21458a;

        C61581(CardHolderFragment cardHolderFragment) {
            this.f21458a = cardHolderFragment;
        }

        public void run() {
            Object obj;
            Context activity = this.f21458a.getActivity();
            String str = "PluginPay CardHolderFragment";
            Object[] objArr = new Object[1];
            StringBuilder append = new StringBuilder().append("initCardsView(),c=");
            if (activity == null) {
                obj = "null";
            } else {
                Context context = activity;
            }
            objArr[0] = append.append(obj).toString();
            C2538c.b(str, objArr);
            if (activity != null) {
                WalletSupportInfo walletAbility = ESEInfoManager.getInstance(activity).getWalletAbility();
                str = "PluginPay CardHolderFragment";
                objArr = new Object[1];
                append = new StringBuilder().append("initCardsView(),walletSupportInfo=");
                if (walletAbility == null) {
                    obj = "null";
                } else {
                    WalletSupportInfo walletSupportInfo = walletAbility;
                }
                objArr[0] = append.append(obj).toString();
                C2538c.b(str, objArr);
                if (walletAbility == null || 1 != walletAbility.getSupportDefautcard()) {
                    this.f21458a.f21484j.setDragEnable(false);
                } else {
                    this.f21458a.f21484j.setDragEnable(true);
                }
            }
        }
    }

    class C61603 implements Runnable {
        final /* synthetic */ CardHolderFragment f21462a;

        C61603(CardHolderFragment cardHolderFragment) {
            this.f21462a = cardHolderFragment;
        }

        public void run() {
            WalletSupportInfo walletAbility = ESEInfoManager.getInstance(this.f21462a.getActivity()).getWalletAbility();
            if (walletAbility != null) {
                C2538c.c("PluginPay CardHolderFragment", new Object[]{" getWalletSupport  walletabillity :  " + walletAbility.toString()});
            } else {
                walletAbility = new WalletSupportInfo("");
            }
            this.f21462a.f21474I = walletAbility.getSupportBusiness();
            if (this.f21462a.f21467A && this.f21462a.f21473G != null) {
                this.f21462a.f21473G.sendEmptyMessage(10);
            }
        }
    }

    class CardHandler extends Handler {
        private final WeakReference<CardHolderFragment> f21463a;

        public CardHandler(CardHolderFragment cardHolderFragment) {
            this.f21463a = new WeakReference(cardHolderFragment);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.f21463a == null) {
                message.getTarget().removeCallbacksAndMessages(null);
                return;
            }
            CardHolderFragment cardHolderFragment = (CardHolderFragment) this.f21463a.get();
            if (cardHolderFragment == null || !cardHolderFragment.isAdded() || cardHolderFragment.isDetached()) {
                message.getTarget().removeCallbacksAndMessages(null);
            } else if (message.what == 10) {
                cardHolderFragment.m28315p();
            }
        }
    }

    class CardListener implements OnAnimateListener, OnDragPosChanageListener, OnItemClickListener {
        final /* synthetic */ CardHolderFragment f21464a;

        private CardListener(CardHolderFragment cardHolderFragment) {
            this.f21464a = cardHolderFragment;
        }

        public void mo5163b(int i, int i2) {
            LogC.m28530b("CardHolderFragment CardListener onDragStop= " + i + ", newPosition= " + i2, false);
            int l = this.f21464a.f21491q.m28208l();
            LogC.m28530b("CardHolderFragment CardListener topCardSize= " + i + ", newPosition= " + i2, false);
            if (i < l) {
                if (i2 < l) {
                    LogC.m28530b("CardHolderFragment CardListener onDragStop do swap top card data", false);
                    if (this.f21464a.f21470D.isCanDragStop(i, i2, this.f21464a.f21490p, this.f21464a.getActivity())) {
                        LogC.m28530b("CardHolderFragment 123", false);
                        this.f21464a.f21470D.onDragStop(i, i2, this.f21464a.f21490p);
                        this.f21464a.f21491q.mo5152c(i, i2);
                        LogC.m28530b("CardHolderFragment 456", false);
                    }
                }
            } else if (i2 >= l) {
                int i3 = i - l;
                LogC.m28530b("CardHolderFragment CardListener onDragStop do swap bottom card data tmpOldPosition= " + i3 + ", tmpNewPosition=" + (i2 - l), false);
                this.f21464a.f21491q.mo5152c(i, i2);
            }
            this.f21464a.f21491q.m28197d(i, i2);
        }

        public void mo5162a(int i, int i2) {
        }

        public void onAnimateUpdate(int i, float f, boolean z) {
        }

        public void onAllAnimateEnd(boolean z) {
            if (z) {
                this.f21464a.f21471E.m28322a(true);
                this.f21464a.f21493s.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                return;
            }
            this.f21464a.f21471E.m28322a(false);
            this.f21464a.f21493s.setAlpha(0.0f);
        }

        public void onAnimateEnd(int i, boolean z) {
        }

        public void onAnimateStart(int i, boolean z) {
        }

        public void onItemClick(View view, int i) {
            if (!this.f21464a.f21491q.m28204h()) {
                this.f21464a.m28289b(view, i);
            }
        }
    }

    class DisplayRunnbale implements Runnable {
        final /* synthetic */ CardHolderFragment f21465a;

        private DisplayRunnbale(CardHolderFragment cardHolderFragment) {
            this.f21465a = cardHolderFragment;
        }

        public void run() {
            this.f21465a.m28299f();
            boolean z = this.f21465a.f21484j.getChildCount() > 0;
            LogC.m28530b(" card holder fragment add view succss= " + z, false);
            if (!z) {
                this.f21465a.m28299f();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        this.f21473G = new CardHandler(this);
        this.f21500z = new CardListener();
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f21481g = layoutInflater.inflate(R.layout.frag_card_holder, viewGroup, false);
        this.f21482h = (ViewGroup) this.f21481g.findViewById(R.id.root);
        this.f21480f = this.f21481g.findViewById(R.id.loading);
        ProgressBar progressBar = (ProgressBar) this.f21480f.findViewById(R.id.listview_center_progress);
        if (VERSION.SDK_INT > 22) {
            progressBar.setIndeterminateDrawable(getActivity().getResources().getDrawable(R.drawable.app_update_checking));
        }
        return this.f21481g;
    }

    private void m28295d() {
        if (this.f21499y == 0 || -1110 == ((UniCardInfo) this.f21490p.get(0)).m28119g()) {
            this.f21489o.setVisibility(0);
            return;
        }
        this.f21486l.setVisibility(0);
        this.f21487m.setVisibility(0);
        this.f21488n.setVisibility(0);
    }

    private void m28283a(View view) {
        this.f21477c = view.findViewById(R.id.card_holder_error);
        this.f21478d = (TextView) view.findViewById(R.id.error_alert);
        this.f21479e = (TextView) view.findViewById(R.id.setting_net);
        this.f21479e.setOnClickListener(this);
        this.f21478d.setOnClickListener(this);
        this.f21483i = (HwScrollView) view.findViewById(R.id.scroll);
        this.f21483i.setCanRebound(true);
        this.f21471E = new ScrollViewTouchListener(true);
        this.f21483i.setOnTouchListener(this.f21471E);
        this.f21492r = view.findViewById(R.id.control_scroll);
        this.f21484j = (CardHolderLayout) view.findViewById(R.id.card_container);
        this.f21484j.setParentScrollView(this.f21483i);
        this.f21484j.setItemClickListener(this.f21500z);
        this.f21484j.setOnChangeListener(this.f21500z);
        this.f21484j.setDragEnable(false);
        this.f21485k = view.findViewById(R.id.offline_section);
        this.f21486l = (ImageView) this.f21485k.findViewById(R.id.add_card);
        this.f21487m = (ImageView) this.f21485k.findViewById(R.id.add_card1);
        this.f21488n = (TextView) this.f21485k.findViewById(R.id.add_card2);
        this.f21486l.setOnClickListener(this);
        this.f21489o = (Button) this.f21485k.findViewById(R.id.add_card_empty);
        this.f21489o.setOnClickListener(this);
        this.f21493s = this.f21485k;
        f21466H.execute(new C61581(this));
    }

    private void m28287b(int i) {
        if (this.f21490p == null) {
            this.f21490p = new LinkedList();
        }
        if (this.f21490p.isEmpty()) {
            UniCardInfo uniCardInfo = new UniCardInfo();
            uniCardInfo.m28111c(i);
            this.f21490p.add(uniCardInfo);
        }
        this.f21499y = this.f21490p.size();
    }

    private void m28297e() {
        C2538c.b("PluginPay CardHolderFragment", new Object[]{"disPlayCardsView(),topCardSize"});
        if (this.f21499y > 0) {
            this.f21491q.m28184a(this.f21490p);
            m28312m();
        }
        m28286a(true);
        this.f21491q.m28193c();
    }

    private void m28299f() {
        this.f21498x = this.f21493s.getMeasuredHeight();
        this.f21484j.setInitTopCardY(this.f21498x);
        this.f21484j.getLocationOnScreen(new int[2]);
        m28297e();
        this.f21471E.m28322a(true);
        this.f21483i.setVisibility(0);
    }

    private void m28301g() {
        Activity activity = getActivity();
        if (activity != null) {
            m28282a(activity);
            if (this.f21484j != null) {
                if (this.f21472F == null) {
                    this.f21472F = new DisplayRunnbale();
                }
                if (!this.f21484j.post(this.f21472F)) {
                    LogC.m28530b("CardHolderFragment show cards view fail,and post runnbale again", false);
                    this.f21484j.postDelayed(this.f21472F, 250);
                }
            }
        }
    }

    private void m28282a(Activity activity) {
        if (this.f21480f != null) {
            this.f21480f.setVisibility(8);
        }
        if (this.f21477c != null) {
            this.f21477c.setVisibility(8);
        }
        if (this.f21493s != null) {
            this.f21493s.setVisibility(0);
            this.f21486l.setClickable(true);
            this.f21489o.setClickable(true);
            this.f21493s.setAlpha(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        }
        if (this.f21484j == null) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.card_holder_list, null);
            if (this.f21482h != null) {
                this.f21482h.addView(inflate);
                m28283a(inflate);
                m28310l();
                m28295d();
            }
        }
    }

    private void m28303h() {
        Activity activity = getActivity();
        if (activity != null) {
            m28287b(-1110);
            m28301g();
            if (this.f21469C == null) {
                this.f21469C = activity.getResources().getDrawable(R.drawable.ic_hint_red);
            }
            this.f21469C.setBounds(0, 0, this.f21469C.getMinimumWidth(), this.f21469C.getMinimumHeight());
            this.f21478d.setCompoundDrawables(this.f21469C, null, null, null);
            this.f21477c.setVisibility(0);
            this.f21478d.setText(activity.getResources().getString(R.string.huaweipay_net_error_click_refresh));
        }
    }

    private void m28305i() {
        if (getActivity() != null) {
            m28287b(-1110);
            m28301g();
        }
    }

    private void m28306j() {
        Activity activity = getActivity();
        if (activity != null) {
            m28287b(-1110);
            m28301g();
            this.f21477c.setVisibility(0);
            this.f21478d.setText(activity.getResources().getString(R.string.unconnect_server));
            this.f21478d.setCompoundDrawables(null, null, null, null);
            this.f21479e.setVisibility(8);
        }
    }

    private void m28309k() {
        Context activity = getActivity();
        if (activity != null) {
            Resources resources = activity.getResources();
            this.f21494t = resources.getDimension(R.dimen.card_list_magin_bottom);
            this.f21495u = resources.getDimension(R.dimen.card_list_magin_top);
            this.f21496v = resources.getDimension(R.dimen.card_list_magin_left_right);
        }
    }

    private void m28310l() {
        Activity activity = getActivity();
        if (activity != null) {
            int screenWith = UiUtil.getScreenWith(getActivity());
            int screenHeight = UiUtil.getScreenHeight(getActivity());
            if (screenWith >= screenHeight) {
                screenWith = screenHeight;
            }
            int i = (int) (((float) screenWith) - (this.f21496v * 2.0f));
            int i2 = (int) ((608.0f * ((float) i)) / 984.0f);
            if (this.f21484j != null) {
                this.f21491q = new CardHolderDisplayManager(activity, this.f21484j, i, i2, this.f21474I);
                this.f21491q.m28203g(1);
                this.f21491q.m28183a(this.f21500z);
            }
        }
    }

    private void m28312m() {
        this.f21484j.setTopCardsCount(this.f21499y);
    }

    private void m28286a(boolean z) {
        int i;
        if (z) {
            this.f21497w = (int) ((this.f21495u + ((float) this.f21491q.mo5153d())) + this.f21494t);
            i = this.f21497w;
        } else {
            this.f21468B = this.f21483i.getScrollY();
            i = this.f21483i.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f21492r.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = i;
            this.f21492r.setLayoutParams(marginLayoutParams);
            if (!z) {
                this.f21483i.scrollTo(0, 0);
            }
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m28309k();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f21470D != null) {
            this.f21470D.unregisterCardListListener(this);
        }
        if (this.f21484j != null) {
            this.f21484j.removeCallbacks(this.f21472F);
            this.f21472F = null;
        }
        if (this.f21473G != null) {
            this.f21473G.removeCallbacksAndMessages(null);
        }
    }

    public void m28316a() {
        Context activity = getActivity();
        if (activity != null) {
            this.f21470D = NFCOpenApiImpl.getInstance(activity);
            this.f21470D.initNFC(activity);
            this.f21470D.registerCardListInfoListener(this);
            this.f21470D.setRefreshRF(false);
            this.f21470D.refreshCardList();
        }
    }

    private void m28313n() {
        if (this.f21491q.m28205i()) {
            this.f21486l.setClickable(false);
            this.f21489o.setClickable(false);
            AnimUtil.m28149a(this.f21493s, 0.0f, 10).start();
            return;
        }
        this.f21486l.setClickable(true);
        this.f21489o.setClickable(true);
        AnimUtil.m28149a(this.f21493s, (float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 500).start();
    }

    private void m28284a(View view, int i) {
        C2538c.b("PluginPay CardHolderFragment", new Object[]{"procCardItemClick(),topCardSize" + this.f21491q.m28208l() + ",position=" + i});
        View view2 = null;
        if (i < this.f21491q.m28208l()) {
            if (this.f21470D != null) {
                view2 = this.f21470D.getCardDetailView((UniCardInfo) this.f21490p.get(i), getActivity(), this.f21491q.m28192c(1));
            } else {
                C2538c.e("PluginPay CardHolderFragment", new Object[]{"nfcapi is  null"});
            }
        }
        m28313n();
        this.f21491q.m28181a(view, i, view2);
    }

    private void m28293c(int i) {
        if (i < this.f21491q.m28208l()) {
            this.f21470D.jumpToAddCardActivity(getActivity());
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.add_card || id == R.id.add_card_empty) {
            m28288b(view);
        } else if (id == R.id.setting_net) {
            BaseLibUtil.jumpToSettings(getActivity());
        } else if (id == R.id.error_alert) {
            m28319b();
        }
    }

    private void m28289b(final View view, final int i) {
        boolean z = view instanceof CardAnimImageView;
        if (!z || view.getId() == R.id.card_virtual) {
            if (view.getId() == R.id.card_virtual && !z) {
                m28293c(i);
            }
        } else if (this.f21491q.m28205i()) {
            m28286a(false);
            m28284a(view, i);
        } else {
            m28286a(true);
            this.f21492r.post(new Runnable(this) {
                final /* synthetic */ CardHolderFragment f21461c;

                public void run() {
                    this.f21461c.f21483i.scrollTo(0, this.f21461c.f21468B);
                    this.f21461c.m28284a(view, i);
                }
            });
        }
    }

    public void m28319b() {
        if (C5730c.m26408a(getActivity())) {
            Activity activity = getActivity();
            if (activity != null) {
                this.f21497w = 0;
                this.f21475a = 0;
                this.f21467A = false;
                this.f21470D.refreshCardList();
                if (this.f21476b == null) {
                    this.f21476b = C6002a.m27468a(getActivity());
                }
                this.f21476b.m27476a(activity.getString(R.string.huaweipay_isloading));
                this.f21476b.setCancelable(false);
                this.f21476b.show();
            }
        }
    }

    private void m28288b(View view) {
        if (view == this.f21486l || view == this.f21489o) {
            this.f21470D.jumpToAddCardActivity(getActivity());
        }
    }

    public void mo5164a(int i) {
        LogC.m28530b("CardHolderFragment refreshError errorCode= " + i, false);
        this.f21475a = i;
    }

    public void mo5165a(int i, List<UniCardInfo> list) {
        C2538c.c("PluginPay CardHolderFragment", new Object[]{"CardHolderFragment refreshCardListInfo type= " + i + ",list= " + list + ",current thread name=" + Thread.currentThread().getName()});
        if (list != null) {
            C2538c.c("PluginPay CardHolderFragment", new Object[]{"CardHolderFragment refreshCardListInfo list size= " + list.size()});
        }
        if (i == 1) {
            this.f21490p = list;
            this.f21467A = true;
        }
        m28314o();
    }

    private void m28314o() {
        f21466H.execute(new C61603(this));
    }

    private void m28315p() {
        if (this.f21475a == -4) {
            m28303h();
        } else if (this.f21475a == -3) {
            m28306j();
        } else {
            m28305i();
        }
        if (this.f21476b != null) {
            this.f21476b.dismiss();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m28305i();
    }

    public int m28320c() {
        return this.f21475a;
    }

    public void onStop() {
        super.onStop();
        if (this.f21484j != null) {
            this.f21484j.m28256b();
        }
    }
}
