package com.google.zxing.client.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.C3709a;
import com.google.zxing.C3880e;
import com.google.zxing.C3922o;
import com.google.zxing.C3934m;
import com.google.zxing.C3935n;
import com.google.zxing.client.android.decode.C3798d;
import com.google.zxing.client.android.decode.C3799e;
import com.google.zxing.client.android.decode.CaptureActivityHandler;
import com.google.zxing.client.android.p286a.C3775e;
import com.google.zxing.client.android.p290c.C3784b;
import com.google.zxing.client.android.p291d.C3790a;
import com.google.zxing.client.android.p291d.C3792c;
import com.google.zxing.client.android.p292e.C3802a;
import com.google.zxing.client.android.p292e.C3805c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class CaptureActivity extends Activity implements Callback {
    private static /* synthetic */ int[] f14644I;
    private static final String f14645a = CaptureActivity.class.getSimpleName();
    private boolean f14646A = false;
    private Map<String, Object> f14647B = new HashMap();
    private boolean f14648C = false;
    private C3821s f14649D;
    private boolean f14650E = true;
    private C3802a f14651F;
    private TextView f14652G;
    private Handler f14653H = new C3814k(this);
    private C3775e f14654b;
    private CaptureActivityHandler f14655c;
    private C3805c f14656d;
    private View f14657e;
    private C3934m f14658f;
    private boolean f14659g;
    private boolean f14660h;
    private C3816m f14661i;
    private String f14662j;
    private Collection<C3709a> f14663k;
    private Map<C3880e, ?> f14664l;
    private String f14665m;
    private C3799e f14666n;
    private C3782b f14667o;
    private C3778a f14668p;
    private Button f14669q;
    private ImageView f14670r;
    private ImageView f14671s;
    private TextView f14672t;
    private boolean f14673u = false;
    private PackageManager f14674v;
    private TextView f14675w;
    private C3817n f14676x = null;
    private String f14677y;
    private String f14678z;

    static /* synthetic */ int[] m18942i() {
        int[] iArr = f14644I;
        if (iArr == null) {
            iArr = new int[C3816m.values().length];
            try {
                iArr[C3816m.NATIVE_APP_INTENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C3816m.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C3816m.PRODUCT_SEARCH_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C3816m.ZXING_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            f14644I = iArr;
        }
        return iArr;
    }

    public C3805c m18960a() {
        return this.f14656d;
    }

    public Handler m18963b() {
        return this.f14655c;
    }

    public C3775e m18964c() {
        return this.f14654b;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Window window = getWindow();
        if (VERSION.SDK_INT >= 19) {
            window.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR);
        }
        this.f14676x = new C3817n(this);
        window.addFlags(128);
        setContentView(this.f14676x.m19064f("sns_barcode_capture"));
        this.f14659g = false;
        this.f14661i = C3816m.NONE;
        this.f14666n = new C3799e(this);
        this.f14667o = new C3782b(this);
        this.f14668p = new C3778a(this);
        this.f14674v = getPackageManager();
        this.f14669q = (Button) findViewById(this.f14676x.m19061c("btn_light_control"));
        this.f14670r = (ImageView) findViewById(this.f14676x.m19061c("btn_select_control"));
        this.f14671s = (ImageView) findViewById(this.f14676x.m19061c("btn_select_control_default"));
        this.f14672t = (TextView) findViewById(this.f14676x.m19061c("my_qr_view"));
        this.f14651F = (C3802a) findViewById(this.f14676x.m19061c("scanframe_view"));
        this.f14652G = (TextView) findViewById(this.f14676x.m19061c("scan_title"));
        if (!C3826x.m19090a()) {
            this.f14672t.setTextColor(this.f14676x.m19067i("sns_qr_my_text_color_emui40"));
        }
        if (!this.f14674v.hasSystemFeature("android.hardware.camera.flash")) {
            this.f14669q.setVisibility(8);
        }
        this.f14669q.setOnClickListener(new C3794d(this));
        this.f14670r.setOnClickListener(new C3806e(this));
        this.f14672t.setOnClickListener(new C3807f(this));
        m18947l();
        m18949m();
        m18943j();
    }

    private void m18925a(Rect rect) {
        if (rect != null) {
            int i = rect.top;
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(this.f14651F.getLayoutParams());
            marginLayoutParams.setMargins(0, i, 0, 0);
            this.f14651F.setLayoutParams(new LayoutParams(marginLayoutParams));
            i = C3815l.m19056a((Context) this, this.f14676x.m19063e("sns_qrinfo_vertical_spacing"));
            int i2 = rect.bottom + i;
            MarginLayoutParams marginLayoutParams2 = new MarginLayoutParams(this.f14675w.getLayoutParams());
            marginLayoutParams2.setMargins(0, i2, 0, 0);
            this.f14675w.setLayoutParams(new LayoutParams(marginLayoutParams2));
            i = (int) ((((float) i) + this.f14675w.getTextSize()) + ((float) i2));
            marginLayoutParams = new MarginLayoutParams(this.f14672t.getLayoutParams());
            marginLayoutParams.setMargins(0, i, 0, 0);
            this.f14672t.setLayoutParams(new LayoutParams(marginLayoutParams));
        }
    }

    private void m18943j() {
        new C3784b(this).m19014a(new C3808g(this));
    }

    private void m18945k() {
        try {
            this.f14671s.setBackgroundResource(this.f14676x.m19059b("sns_ic_broken_white"));
        } catch (Exception e) {
            Log.e(f14645a, "hwsns sns_ic_broken_white is not found.");
        }
    }

    protected void m18965d() {
        Intent intent = new Intent("com.huawei.sns.action.SELECT_PICTURE");
        intent.putExtra("isSingle", true);
        intent.setPackage("com.huawei.hwid");
        startActivityForResult(intent, 1);
    }

    protected void m18966e() {
        Intent intent = new Intent("com.huawei.sns.action.SELF_TWO_DIMCODE");
        intent.setPackage("com.huawei.hwid");
        startActivity(intent);
    }

    private void m18947l() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if ("com.huawei.sns.action.SCAN_QRCODE".equals(intent.getAction())) {
                this.f14646A = true;
            }
            if (extras != null) {
                this.f14677y = getPackageName();
                this.f14678z = intent.getStringExtra("package");
                if (extras.containsKey("sns_identity")) {
                    if ("invite".equals(extras.getString("sns_identity"))) {
                        this.f14648C = true;
                    }
                }
                for (String str : extras.keySet()) {
                    this.f14647B.put(str, extras.get(str));
                }
            }
        }
    }

    private void m18949m() {
        CharSequence charSequence = null;
        try {
            charSequence = getResources().getString(this.f14676x.m19057a(m18950n()));
        } catch (Exception e) {
        }
        if (this.f14652G != null && charSequence != null) {
            this.f14652G.setText(charSequence);
        }
    }

    private String m18950n() {
        if (this.f14648C) {
            return "sns_sweep_hwid_qrcode";
        }
        return "sns_sweep";
    }

    protected void onResume() {
        super.onResume();
        this.f14654b = new C3775e(getApplication());
        this.f14656d = (C3805c) findViewById(this.f14676x.m19061c("viewfinder_view"));
        this.f14656d.setCameraManager(this.f14654b);
        this.f14657e = findViewById(this.f14676x.m19061c("result_view"));
        this.f14675w = (TextView) findViewById(this.f14676x.m19061c("status_view"));
        this.f14655c = null;
        this.f14658f = null;
        m18959w();
        SurfaceHolder holder = ((SurfaceView) findViewById(this.f14676x.m19061c("preview_view"))).getHolder();
        if (this.f14659g) {
            m18926a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f14667o.m19008a();
        this.f14668p.m19003a(this.f14654b);
        this.f14666n.m19038c();
        this.f14661i = C3816m.NONE;
    }

    protected void onPause() {
        m18952p();
        super.onPause();
    }

    private void m18951o() {
        View findViewById = findViewById(this.f14676x.m19061c("surface_parent"));
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
    }

    private void m18952p() {
        if (this.f14655c != null) {
            this.f14655c.m19027a();
            this.f14655c = null;
        }
        if (this.f14666n != null) {
            this.f14666n.m19037b();
        }
        if (this.f14668p != null) {
            this.f14668p.m19002a();
        }
        if (this.f14654b != null) {
            this.f14654b.m18994b();
        }
        if (!this.f14659g) {
            ((SurfaceView) findViewById(this.f14676x.m19061c("preview_view"))).getHolder().removeCallback(this);
        }
        this.f14651F.m19042a();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f14666n != null) {
            this.f14666n.m19039d();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 3:
            case 4:
                if (this.f14661i == C3816m.NATIVE_APP_INTENT) {
                    setResult(0);
                    finish();
                    return true;
                } else if ((this.f14661i == C3816m.NONE || this.f14661i == C3816m.ZXING_LINK) && this.f14658f != null) {
                    m18961a(0);
                    return true;
                }
            case 27:
            case 80:
                return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            try {
                m18922a(intent);
            } catch (Exception e) {
                Log.e(f14645a, "onActivityResult exception: " + e.getMessage());
                finish();
            }
        }
        if (i == 43725) {
            m18952p();
            finish();
        }
    }

    private void m18932a(boolean z) {
        this.f14650E = z;
    }

    public boolean m18967f() {
        return this.f14650E;
    }

    private void m18953q() {
        if (this.f14649D != null) {
            this.f14649D.m19075b();
        }
    }

    private void m18954r() {
        if (this.f14649D == null) {
            this.f14649D = new C3821s(this, "", getResources().getString(this.f14676x.m19057a("sns_scanning")), new C3810h(this));
        }
        this.f14649D.m19074a();
    }

    private void m18922a(Intent intent) {
        int intExtra = intent.getIntExtra("selectedId", 0);
        if (intExtra == 0) {
            Log.d(f14645a, "getResultData id is not validate");
            return;
        }
        m18932a(false);
        m18954r();
        new C3818o(this).m19070a(intExtra, new C3812i(this));
    }

    private void m18955s() {
        if (!isFinishing()) {
            OnClickListener c3813j = new C3813j(this);
            CharSequence string = getResources().getString(this.f14676x.m19057a("sns_not_found_qrcode"));
            new Builder(this).setTitle("").setMessage(string).setPositiveButton(getResources().getString(this.f14676x.m19057a("sns_i_know")), c3813j).create().show();
        }
    }

    private void m18956t() {
        if (this.f14667o != null) {
            this.f14667o.m19009b();
        }
    }

    private void m18957u() {
        if (this.f14656d != null) {
            this.f14656d.setHidenFrame(true);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(f14645a, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        Log.d(f14645a, "surfaceCreated()");
        if (!this.f14659g) {
            this.f14659g = true;
            m18926a(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f14659g = false;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void m18962a(C3934m c3934m, Bitmap bitmap, float f) {
        this.f14666n.m19036a();
        this.f14658f = c3934m;
        String str = "";
        if (c3934m != null) {
            str = c3934m.m19572a();
            Log.i(f14645a, "rawResult str:" + str);
            if (!(str == null || "".equals(str))) {
                m18956t();
                m18931a(str);
                return;
            }
        }
        try {
            boolean z;
            C3790a a = C3792c.m19024a(this, c3934m);
            if (bitmap != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.f14667o.m19009b();
                m18923a(bitmap, f, c3934m);
            }
            switch (m18942i()[this.f14661i.ordinal()]) {
                case 1:
                case 2:
                    m18930a(c3934m, a, bitmap);
                    return;
                case 3:
                    return;
                case 4:
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    if (z && defaultSharedPreferences.getBoolean("preferences_bulk_mode", false)) {
                        Toast.makeText(getApplicationContext(), new StringBuilder(String.valueOf(getResources().getString(this.f14676x.m19057a(m18950n())))).append(" (").append(c3934m.m19572a()).append(')').toString(), 0).show();
                        m18961a(1000);
                        return;
                    }
                    CharSequence b = a.m19021b();
                    if (b != null) {
                        m18931a(b.toString());
                        return;
                    } else {
                        finish();
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception e) {
            m18931a(str);
        }
    }

    private void m18931a(String str) {
        if (this.f14646A) {
            Intent intent = new Intent();
            intent.setAction("com.huawei.sns.action.CHECK_QRCODE");
            intent.setPackage("com.huawei.hwid");
            Bundle bundle = new Bundle();
            bundle.putString("sns_qrcode", str.toString());
            for (Entry entry : this.f14647B.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (!(key == null || value == null)) {
                    if (value instanceof String) {
                        bundle.putString(key.toString(), value.toString());
                    } else if (value instanceof Long) {
                        bundle.putLong(key.toString(), ((Long) value).longValue());
                    } else if (value instanceof Integer) {
                        bundle.putInt(key.toString(), ((Integer) value).intValue());
                    }
                }
            }
            intent.putExtras(bundle);
            try {
                startActivityForResult(intent, 43725);
                return;
            } catch (ActivityNotFoundException e) {
                Log.e(f14645a, "isFromHwId action not found");
                return;
            }
        }
        setResult(-1, new Intent().putExtra("data", str.toString()));
        finish();
    }

    private void m18923a(Bitmap bitmap, float f, C3934m c3934m) {
        int i = 0;
        C3922o[] c = c3934m.m19577c();
        if (c != null && c.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(this.f14676x.m19065g("result_points")));
            if (c.length == 2) {
                paint.setStrokeWidth(4.0f);
                m18924a(canvas, paint, c[0], c[1], f);
            } else if (c.length == 4 && (c3934m.m19578d() == C3709a.UPC_A || c3934m.m19578d() == C3709a.EAN_13)) {
                m18924a(canvas, paint, c[0], c[1], f);
                m18924a(canvas, paint, c[2], c[3], f);
            } else {
                paint.setStrokeWidth(10.0f);
                int length = c.length;
                while (i < length) {
                    C3922o c3922o = c[i];
                    canvas.drawPoint(c3922o.m19522a() * f, c3922o.m19523b() * f, paint);
                    i++;
                }
            }
        }
    }

    private static void m18924a(Canvas canvas, Paint paint, C3922o c3922o, C3922o c3922o2, float f) {
        if (c3922o != null && c3922o2 != null) {
            canvas.drawLine(f * c3922o.m19522a(), f * c3922o.m19523b(), f * c3922o2.m19522a(), f * c3922o2.m19523b(), paint);
        }
    }

    private void m18930a(C3934m c3934m, C3790a c3790a, Bitmap bitmap) {
        String valueOf;
        long j = 1500;
        int i = 0;
        if (bitmap != null) {
            this.f14656d.m19048a(bitmap);
        }
        if (getIntent() != null) {
            j = getIntent().getLongExtra("RESULT_DISPLAY_DURATION_MS", 1500);
        }
        if (j > 0) {
            valueOf = String.valueOf(c3934m);
            if (valueOf.length() > 32) {
                valueOf.substring(0, 32) + " ...";
            }
        }
        if (this.f14660h && !c3790a.m19020a()) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
            CharSequence b = c3790a.m19021b();
            if (b != null) {
                try {
                    clipboardManager.setText(b);
                } catch (Throwable e) {
                    Log.w(f14645a, "Clipboard bug", e);
                }
            }
        }
        if (this.f14661i == C3816m.NATIVE_APP_INTENT) {
            Object intent = new Intent(getIntent().getAction());
            intent.addFlags(524288);
            intent.putExtra("SCAN_RESULT", c3934m.toString());
            intent.putExtra("SCAN_RESULT_FORMAT", c3934m.m19578d().toString());
            byte[] b2 = c3934m.m19576b();
            if (b2 != null && b2.length > 0) {
                intent.putExtra("SCAN_RESULT_BYTES", b2);
            }
            Map e2 = c3934m.m19579e();
            if (e2 != null) {
                if (e2.containsKey(C3935n.UPC_EAN_EXTENSION)) {
                    intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", e2.get(C3935n.UPC_EAN_EXTENSION).toString());
                }
                Integer num = (Integer) e2.get(C3935n.ORIENTATION);
                if (num != null) {
                    intent.putExtra("SCAN_RESULT_ORIENTATION", num.intValue());
                }
                valueOf = (String) e2.get(C3935n.ERROR_CORRECTION_LEVEL);
                if (valueOf != null) {
                    intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", valueOf);
                }
                Iterable<byte[]> iterable = (Iterable) e2.get(C3935n.BYTE_SEGMENTS);
                if (iterable != null) {
                    for (byte[] b22 : iterable) {
                        intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i, b22);
                        i++;
                    }
                }
            }
            m18921a(this.f14676x.m19061c("return_scan_result"), intent, j);
        } else if (this.f14661i == C3816m.PRODUCT_SEARCH_LINK) {
            m18921a(this.f14676x.m19061c("launch_product_query"), new StringBuilder(String.valueOf(this.f14662j.substring(0, this.f14662j.lastIndexOf("/scan")))).append("?q=").append(c3790a.m19021b()).append("&source=zxing").toString(), j);
        } else {
            C3816m c3816m = C3816m.ZXING_LINK;
        }
    }

    private void m18921a(int i, Object obj, long j) {
        Message obtain = Message.obtain(this.f14655c, i, obj);
        if (j > 0) {
            this.f14655c.sendMessageDelayed(obtain, j);
        } else {
            this.f14655c.sendMessage(obtain);
        }
    }

    private void m18926a(SurfaceHolder surfaceHolder) {
        Log.d(f14645a, "initCamera()");
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (this.f14654b.m18993a()) {
            Log.w(f14645a, "initCamera() while already open -- late SurfaceView callback?");
        } else {
            try {
                this.f14654b.m18991a(surfaceHolder);
                if (this.f14655c == null) {
                    this.f14655c = new CaptureActivityHandler(this, this.f14663k, this.f14664l, this.f14665m, this.f14654b);
                }
            } catch (Throwable e) {
                Log.w(f14645a, e);
                m18958v();
            } catch (Throwable e2) {
                Log.w(f14645a, "Unexpected error initializing camera", e2);
                m18958v();
            }
        }
    }

    private void m18958v() {
        Builder builder = new Builder(this);
        builder.setTitle(this.f14676x.m19057a(m18950n()));
        builder.setMessage(this.f14676x.m19057a("sns_qr_msg_camera_framework_bug"));
        builder.setPositiveButton(this.f14676x.m19057a("sns_confirm"), new C3798d(this));
        builder.setOnCancelListener(new C3798d(this));
        builder.show();
    }

    public void m18961a(long j) {
        if (this.f14655c != null) {
            this.f14655c.sendEmptyMessageDelayed(this.f14676x.m19061c("restart_preview"), j);
        }
        m18959w();
    }

    private void m18959w() {
        this.f14657e.setVisibility(8);
        this.f14675w.setText(this.f14676x.m19057a("sns_qr_info"));
        this.f14675w.setVisibility(0);
        this.f14656d.setVisibility(0);
        this.f14658f = null;
    }

    public void m18968g() {
        if (this.f14673u) {
            this.f14654b.m18992a(true);
        }
    }

    public void m18969h() {
        this.f14656d.m19047a();
        Rect e = this.f14654b.m18997e();
        if (e != null) {
            m18925a(e);
            this.f14651F.m19043a(e.width(), e.height());
            this.f14651F.m19044b();
        }
        this.f14653H.sendEmptyMessageDelayed(1, 500);
    }
}
