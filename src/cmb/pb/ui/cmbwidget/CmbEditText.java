package cmb.pb.ui.cmbwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import cmb.pb.cmbsafe.C2862b;
import cmb.pb.cmbsafe.CmbService;
import cmb.pb.p203a.C2860c;
import cmb.pb.ui.PBKeyboardActivity;
import com.huawei.wallet.R;
import java.lang.reflect.Method;
import net.sqlcipher.database.SQLiteDatabase;

public class CmbEditText extends EditText {
    private static String f9294c = "CmbEditText";
    private static PopupWindow f9295m = null;
    public boolean f9296a = false;
    public boolean f9297b = false;
    private int f9298d = 0;
    private int f9299e = 0;
    private boolean f9300f = false;
    private boolean f9301g = false;
    private C2867b f9302h = null;
    private C2869d f9303i = null;
    private C2870e f9304j = null;
    private Drawable f9305k = null;
    private boolean f9306l = false;
    private Activity f9307n = null;
    private String f9308o = "";

    public CmbEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12990a(context, attributeSet);
        m12997d();
    }

    public CmbEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12990a(context, attributeSet);
        m12997d();
    }

    private void m12990a(Context context, AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CmbEditText);
            this.f9298d = obtainStyledAttributes.getInteger(0, 0);
            this.f9299e = obtainStyledAttributes.getInteger(1, 0);
            this.f9300f = obtainStyledAttributes.getBoolean(2, true);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void m12991a(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            IBinder windowToken = view.getWindowToken();
            if (windowToken != null) {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void m12992a(EditText editText) {
        CharSequence text = editText.getText();
        if (text instanceof Spannable) {
            Selection.setSelection((Spannable) text, text.length());
        }
    }

    private void m12997d() {
        try {
            this.f9302h = new C2867b(this);
            this.f9303i = new C2869d(this);
            if (this != null) {
                if (VERSION.SDK_INT <= 10) {
                    setInputType(0);
                } else {
                    Method method;
                    try {
                        ((Activity) getContext()).getWindow().setSoftInputMode(3);
                    } catch (Exception e) {
                    }
                    try {
                        method = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                        method.setAccessible(true);
                        method.invoke(this, new Object[]{Boolean.valueOf(false)});
                    } catch (Exception e2) {
                    }
                    try {
                        method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                        method.setAccessible(true);
                        method.invoke(this, new Object[]{Boolean.valueOf(false)});
                    } catch (Exception e3) {
                    }
                }
            }
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.f9305k = getCompoundDrawables()[2];
            if (this.f9305k == null) {
                this.f9305k = getResources().getDrawable(R.drawable.cmbkb_emotionstore_progresscancelbtn);
            }
            this.f9305k.setBounds(0, 0, this.f9305k.getIntrinsicWidth(), this.f9305k.getIntrinsicHeight());
            m13002a(false);
            setOnFocusChangeListener(new C2866a());
            setOnTouchListener(new C2868c());
            if (this.f9300f) {
                this.f9304j = new C2870e(this.f9299e, "");
            }
        } catch (Exception e4) {
        }
    }

    public final void m13001a() {
        super.setText("");
        if (this.f9300f && this.f9304j != null) {
            this.f9304j.m13009c();
        }
    }

    protected final void m13002a(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.f9305k : null, getCompoundDrawables()[3]);
    }

    public final void m13003b() {
        C2862b.m12960a((Object) this);
        C2862b.m12959a(this);
        C2862b.m12961a("showCMBKeyboardWindow2");
        this.f9307n.startService(new Intent(this.f9307n, CmbService.class));
    }

    public final void m13004c() {
        this.f9301g = false;
        this.f9307n.stopService(new Intent(this.f9307n, CmbService.class));
    }

    public String getEnctyptText() {
        String b = (!this.f9300f || this.f9304j == null) ? "" : this.f9304j.m13008b();
        return C2860c.m12954a(b, this.f9308o);
    }

    public int getInputLength() {
        return this.f9304j.m13005a();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m13002a(charSequence.length() > 0);
    }

    public void setInputType(int i) {
        super.setInputType(0);
    }

    public void setRecvTouchEventActivity(Activity activity) {
        this.f9307n = activity;
    }

    public void setSessionID(String str) {
        this.f9308o = str;
    }

    public void showCMBKeyboardWindow2() {
        if (!this.f9301g) {
            this.f9301g = true;
            try {
                setCursorVisible(true);
                setFocusable(true);
                requestFocus();
                Thread.sleep(100);
                PBKeyboardActivity.m12963a(this.f9302h);
                if (this.f9300f) {
                    PBKeyboardActivity.m12968a(this.f9304j);
                }
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("IsPassword", this.f9300f);
                intent.putExtra("Hint", getHint());
                intent.putExtra("KeyboardType", this.f9298d);
                intent.putExtra("Length", this.f9299e);
                intent.putExtra("OldText", getText().toString());
                intent.putExtra("UseHandler", true);
                intent.setClass(this.f9307n, PBKeyboardActivity.class);
                this.f9307n.startActivityForResult(intent, PBKeyboardActivity.f9255c);
            } catch (Exception e) {
            }
        }
    }
}
