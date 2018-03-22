package cmb.pb.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import cmb.pb.cmbsafe.C2861a;
import cmb.pb.p203a.C2858a;
import cmb.pb.p203a.C2860c;
import cmb.pb.ui.cmbwidget.C2870e;
import com.amap.api.maps.model.WeightedLatLng;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.wallet.R;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

public class PBKeyboardActivity extends Activity {
    private static int f9246E = 0;
    private static int f9247F = 1;
    private static int f9248G = 2;
    private static int f9249H = 3;
    private static int f9250I = 4;
    private static int f9251J = 5;
    private static int f9252K = 6;
    private static PBKeyboardActivity f9253L = null;
    private static C2873f f9254S = null;
    public static int f9255c = 9555;
    private static C2870e f9256i = null;
    private static Key f9257t = null;
    private static List f9258u = null;
    private static Handler f9259v = null;
    private String f9260A = null;
    private String f9261B = null;
    private boolean f9262C = false;
    private int f9263D = 0;
    private final String f9264M = "PBKeyboardActivity";
    private OnClickListener f9265N = new C2863a(this);
    private OnClickListener f9266O = new C2864b(this);
    private OnKeyboardActionListener f9267P = new C2865c(this);
    private OnFocusChangeListener f9268Q = new C2871d(this);
    private OnTouchListener f9269R = new C2872e(this);
    public boolean f9270a = false;
    public boolean f9271b = false;
    private float f9272d = 0.0f;
    private float f9273e = 0.0f;
    private Context f9274f;
    private Activity f9275g;
    private KeyboardView f9276h;
    private int f9277j = 0;
    private Keyboard f9278k;
    private Keyboard f9279l;
    private Keyboard f9280m;
    private Keyboard f9281n;
    private Keyboard f9282o;
    private Keyboard f9283p;
    private Keyboard f9284q;
    private EditText f9285r;
    private TextView f9286s = null;
    private int f9287w = 0;
    private boolean f9288x = false;
    private int f9289y = 0;
    private String f9290z = null;

    public static void m12963a(Handler handler) {
        f9259v = handler;
    }

    static /* synthetic */ void m12964a(PBKeyboardActivity pBKeyboardActivity) {
        if (pBKeyboardActivity.f9276h.getVisibility() == 0) {
            pBKeyboardActivity.f9276h.setVisibility(4);
        }
        String str = null;
        Editable text = pBKeyboardActivity.f9285r.getText();
        if (text != null && text.length() > 0) {
            str = text.toString();
        }
        if (!C2858a.m12951b(str)) {
            Intent intent = new Intent();
            intent.putExtra("text4set", str);
            pBKeyboardActivity.setResult(-1, intent);
        }
        pBKeyboardActivity.finish();
    }

    static /* synthetic */ void m12966a(PBKeyboardActivity pBKeyboardActivity, Keyboard keyboard) {
        List<Keyboard.Key> keys = keyboard.getKeys();
        if (pBKeyboardActivity.f9271b) {
            pBKeyboardActivity.f9271b = false;
            for (Keyboard.Key key : keys) {
                if (key.label != null && m12969a(key.label.toString())) {
                    key.label = key.label.toString().toLowerCase();
                    key.codes[0] = key.codes[0] + 32;
                }
                if (key.codes[0] == -1) {
                    try {
                        key.icon = pBKeyboardActivity.getResources().getDrawable(R.drawable.cmbkb_shift_normal);
                    } catch (Exception e) {
                    }
                }
            }
            return;
        }
        pBKeyboardActivity.f9271b = true;
        for (Keyboard.Key key2 : keys) {
            if (key2.label != null && m12969a(key2.label.toString())) {
                key2.label = key2.label.toString().toUpperCase();
                key2.codes[0] = key2.codes[0] - 32;
            }
            if (key2.codes[0] == -1) {
                try {
                    key2.icon = pBKeyboardActivity.getResources().getDrawable(R.drawable.cmbkb_shift_actived);
                } catch (Exception e2) {
                }
            }
        }
    }

    static /* synthetic */ void m12967a(PBKeyboardActivity pBKeyboardActivity, View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) pBKeyboardActivity.getSystemService("input_method");
            IBinder windowToken = view.getWindowToken();
            if (windowToken != null) {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m12968a(C2870e c2870e) {
        f9256i = c2870e;
    }

    private static boolean m12969a(String str) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(str.toLowerCase()) >= 0;
    }

    public static PBKeyboardActivity m12971b() {
        return f9253L;
    }

    public final void m12989a() {
        this.f9261B = null;
        this.f9285r.setText("");
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        setContentView(R.layout.cmbkeyboard);
        Intent intent = getIntent();
        this.f9287w = intent.getIntExtra("KeyboardType", 0);
        this.f9288x = intent.getBooleanExtra("IsPassword", false);
        this.f9289y = intent.getIntExtra("Length", 0);
        this.f9290z = intent.getStringExtra("Hint");
        this.f9260A = intent.getStringExtra("Label");
        this.f9261B = intent.getStringExtra("OldText");
        this.f9262C = intent.getBooleanExtra("UseHandler", false);
        f9253L = this;
        this.f9275g = this;
        this.f9274f = this;
        this.f9285r = (EditText) findViewById(R.id.edit_cmbinput);
        Log.v("PBKeyboardActivity", "android.os.Build.VERSION.SDK_INT:" + VERSION.SDK_INT);
        if (VERSION.SDK_INT <= 10) {
            this.f9285r.setInputType(0);
        } else {
            Method method;
            getWindow().setSoftInputMode(3);
            try {
                method = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                method.invoke(this.f9285r, new Object[]{Boolean.valueOf(false)});
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                method.invoke(this.f9285r, new Object[]{Boolean.valueOf(false)});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f9288x) {
            this.f9285r.setInputType(129);
        } else {
            this.f9285r.setInputType(SyslogAppender.LOG_LOCAL2);
            this.f9285r.setHint("");
        }
        CharSequence string = getResources().getString(R.string.cmbkb_please_input);
        if (this.f9289y > 0) {
            this.f9285r.setFilters(new InputFilter[]{new LengthFilter(this.f9289y)});
        }
        if (this.f9290z == null || this.f9290z.length() <= 0) {
            this.f9285r.setHint(string);
        } else {
            this.f9285r.setHint(this.f9290z);
        }
        if (this.f9260A != null && this.f9260A.length() > 0) {
            textView = (TextView) findViewById(R.id.cmbkb_tvLabel);
            if (textView != null) {
                textView.setText(this.f9260A);
            }
        }
        if (this.f9261B != null) {
            this.f9285r.setText(this.f9261B);
            CharSequence text = this.f9285r.getText();
            if (text instanceof Spannable) {
                Selection.setSelection((Spannable) text, text.length());
            }
        }
        this.f9285r.setOnFocusChangeListener(this.f9268Q);
        this.f9285r.setOnTouchListener(this.f9269R);
        if (this.f9262C) {
            textView = (TextView) findViewById(R.id.cmbkb_tvLabel);
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (this.f9285r != null) {
                this.f9285r.setVisibility(8);
            }
            String str = "";
            if (this.f9261B != null) {
                str = this.f9261B;
            }
            Handler handler = f9259v;
            if (handler != null) {
                Message message = new Message();
                message.what = 1;
                Bundle bundle2 = new Bundle();
                bundle2.putString("KeyString", str);
                message.setData(bundle2);
                handler.sendMessage(message);
            }
        }
        View findViewById = findViewById(R.id.cmbkb_safeSign);
        if (findViewById != null) {
            if (this.f9287w == 2 || this.f9287w == 3 || this.f9287w == 4) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        this.f9286s = (TextView) findViewById(R.id.cmbkb_tvComplete);
        if (this.f9286s != null) {
            if (this.f9287w == 2 || this.f9287w == 3 || this.f9287w == 4) {
                this.f9286s.setVisibility(0);
                this.f9286s.setOnClickListener(this.f9265N);
            } else {
                this.f9286s.setOnClickListener(null);
                this.f9286s.setVisibility(8);
            }
        }
        this.f9278k = new Keyboard(this.f9274f, R.xml.cmbkb_number);
        this.f9279l = new Keyboard(this.f9274f, R.xml.cmbkb_number_symbols);
        this.f9280m = new Keyboard(this.f9274f, R.xml.cmbkb_number_with_dot);
        this.f9281n = new Keyboard(this.f9274f, R.xml.cmbkb_number_with_x);
        this.f9282o = new Keyboard(this.f9274f, R.xml.cmbkb_number_with_change);
        this.f9283p = new Keyboard(this.f9274f, R.xml.cmbkb_symbols);
        this.f9284q = new Keyboard(this.f9274f, R.xml.cmbkb_qwerty);
        C2861a.m12957a(this.f9278k);
        C2861a.m12957a(this.f9279l);
        C2861a.m12957a(this.f9280m);
        C2861a.m12957a(this.f9281n);
        C2861a.m12957a(this.f9282o);
        this.f9276h = (KeyboardView) this.f9275g.findViewById(R.id.cmbkeyboard_view);
        this.f9276h.setEnabled(true);
        this.f9276h.setPreviewEnabled(false);
        this.f9276h.setOnKeyboardActionListener(this.f9267P);
        if (this.f9287w == 1) {
            this.f9276h.setKeyboard(this.f9278k);
            this.f9263D = f9246E;
        } else if (this.f9287w == 2) {
            this.f9276h.setKeyboard(this.f9280m);
            this.f9263D = f9250I;
        } else if (this.f9287w == 3) {
            this.f9276h.setKeyboard(this.f9281n);
            this.f9263D = f9251J;
        } else if (this.f9287w == 4) {
            this.f9276h.setKeyboard(this.f9282o);
            this.f9263D = f9252K;
        } else {
            this.f9276h.setKeyboard(this.f9284q);
            this.f9263D = f9247F;
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * WeightedLatLng.DEFAULT_INTENSITY);
        attributes.alpha = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        attributes.dimAmount = 0.0f;
        getWindow().setAttributes(attributes);
        getWindow().setType(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION);
        try {
            C2860c.m12956a(getResources().getString(R.string.cmbkb_publickey));
        } catch (NotFoundException e3) {
            e3.printStackTrace();
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    protected void onDestroy() {
        Log.d("PBKeyboardActivity", "onDestroy()");
        if (f9259v != null) {
            Message message = new Message();
            message.what = 2;
            Bundle bundle = new Bundle();
            bundle.putFloat("rawX", this.f9272d);
            bundle.putFloat("rawY", this.f9273e);
            message.setData(bundle);
            f9259v.sendMessage(message);
            f9259v = null;
        }
        super.onDestroy();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f9272d = motionEvent.getRawX();
        this.f9273e = motionEvent.getRawY();
        finish();
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && f9254S != null) {
            if (this.f9277j == 0) {
                this.f9277j = ((LinearLayout) findViewById(R.id.cmbkb_contentLayout)).getMeasuredHeight();
            }
            C2873f c2873f = f9254S;
            int i = this.f9277j;
        }
    }
}
