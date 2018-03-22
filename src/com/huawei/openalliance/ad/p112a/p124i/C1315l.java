package com.huawei.openalliance.ad.p112a.p124i;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.inter.AdActivity;
import com.huawei.openalliance.ad.inter.data.SplashParam;
import com.huawei.openalliance.ad.inter.listener.SplashListener;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p124i.p126a.C1297d;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

public class C1315l extends C1303b {
    private C1221g f2843b;
    private List<String> f2844c = new ArrayList(4);
    private SplashListener f2845d;
    private C1274a f2846e;
    private Context f2847f;
    private int f2848g;
    private int f2849h;

    public interface C1274a {
        void mo2434a(int i, int i2);

        void mo2438b(int i, int i2);

        void mo2440d();
    }

    public C1315l(Context context, SplashParam splashParam, SplashListener splashListener, C1274a c1274a) {
        super(context);
        this.f2847f = context;
        this.f2845d = splashListener;
        this.f2846e = c1274a;
        if (splashParam != null) {
            this.f2844c.add(splashParam.getAdId());
            this.f2848g = splashParam.getOrientation();
            this.f2849h = splashParam.getDeviceType();
        }
    }

    private void m5824a(int i, int i2) {
        if (this.f2846e != null) {
            this.f2846e.mo2434a(i, i2);
        }
    }

    @SuppressLint({"NewApi"})
    private void m5826a(String str, ImageView imageView, int i, int i2) {
        if (!TextUtils.isEmpty(str) && this.f2847f != null) {
            try {
                Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
                if (parseUri.getData() != null && VERSION.SDK_INT >= 16) {
                    parseUri = parseUri.setDataAndTypeAndNormalize(parseUri.getData(), parseUri.getType());
                }
                PackageManager packageManager = this.f2847f.getPackageManager();
                if (packageManager != null && !packageManager.queryIntentActivities(parseUri, 65536).isEmpty()) {
                    if (imageView instanceof C1297d) {
                        ((C1297d) imageView).m5757b();
                    }
                    this.f2847f.startActivity(parseUri);
                    m5824a(i, i2);
                }
            } catch (URISyntaxException e) {
                C1336d.m5888c("SplashView", "parse uri fail");
            } catch (ActivityNotFoundException e2) {
                C1336d.m5888c("SplashView", "activity not exist");
            } catch (Exception e3) {
                C1336d.m5888c("SplashView", "handle intent url fail");
            }
        }
    }

    private void m5829b(String str, ImageView imageView, int i, int i2) {
        if (this.f2847f != null && URLUtil.isNetworkUrl(str) && this.f2843b != null) {
            try {
                m5824a(i, i2);
                if (imageView instanceof C1297d) {
                    ((C1297d) imageView).m5757b();
                }
                Intent intent = new Intent(this.f2847f, AdActivity.class);
                intent.putExtra(AdActivity.TAG_DETAIL_URL, str);
                intent.putExtra(AdActivity.TAG_SHOW_ID, this.f2843b.getShowid__());
                Bundle bundle = new Bundle();
                bundle.putSerializable(AdActivity.TAG_PARAM_FROM_SERVER, this.f2843b.getParamfromserver__());
                intent.putExtras(bundle);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.f2847f.startActivity(intent);
            } catch (Exception e) {
                C1336d.m5888c("SplashView", "handle url fail");
            }
        }
    }

    public void m5831a(C1221g c1221g, String str, int i) {
        View c1297d;
        this.f2843b = c1221g;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View c1311h = new C1311h(this.f2847f, c1221g.getSkipText__(), this.f2848g, this.f2849h);
        if (4 == c1221g.getCreativetype__()) {
            c1311h.setVisibility(8);
            c1297d = new C1297d(this.f2847f, str, new C1316m(this, c1311h));
        } else {
            c1297d = m5795a(str);
            c1297d.setScaleType(ScaleType.CENTER_CROP);
        }
        addView(c1297d, layoutParams);
        c1297d.setOnTouchListener(new C1317n(this, c1221g, c1297d));
        addView(c1311h, c1311h.m5811a());
        c1311h.setClickable(true);
        c1311h.setOnTouchListener(new C1318o(this, c1297d));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1336d.m5886b("SplashView", "onDetachedFromWindow");
        if (this.f2846e != null) {
            this.f2846e.mo2438b(0, 0);
        }
    }
}
