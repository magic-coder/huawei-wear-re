package com.huawei.android.pushselfshow.richpush;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.p340b.C4163a;
import com.huawei.android.pushselfshow.richpush.p341c.C4179a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class RichPushActivity extends Activity {
    String f15625a = "";
    public Activity f15626b = this;
    public boolean f15627c = false;
    private Class f15628d;
    private Object f15629e;
    private HashMap f15630f = null;

    private HashMap m20300a() {
        HashMap hashMap = new HashMap();
        hashMap.put("html", C4179a.class);
        hashMap.put("favorite", C4163a.class);
        return hashMap;
    }

    private void m20301a(String str, Class[] clsArr, Object[] objArr) {
        if (this.f15628d != null && this.f15629e != null && !TextUtils.isEmpty(str) && clsArr != null && objArr != null) {
            try {
                this.f15628d.getDeclaredMethod(str, clsArr).invoke(this.f15629e, objArr);
            } catch (NoSuchMethodException e) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has " + str + " method,err info " + e.toString());
            } catch (IllegalAccessException e2) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has " + str + " method,err info " + e2.toString());
            } catch (IllegalArgumentException e3) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has " + str + " method,err info " + e3.toString());
            } catch (InvocationTargetException e4) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has " + str + " method,err info " + e4.toString());
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        e.a("PushSelfShowLog", "enter onActivityResult of RichPush");
        if (!this.f15627c) {
            super.onActivityResult(i, i2, intent);
        }
        m20301a("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
    }

    public void onCreate(Bundle bundle) {
        this.f15626b.requestWindowFeature(1);
        this.f15626b.setRequestedOrientation(5);
        if (!this.f15627c) {
            super.onCreate(bundle);
        }
        e.a(this.f15626b);
        e.a("PushSelfShowLog", "enter onCreate of RichPush ");
        if (this.f15630f == null || this.f15630f.isEmpty()) {
            this.f15630f = m20300a();
        }
        Intent intent = this.f15626b.getIntent();
        e.a("PushSelfShowLog", "enter onCreate of RichPush  intent " + intent);
        if (intent == null) {
            finish();
            return;
        }
        if (bundle != null) {
            intent.putExtra("collect_img_disable", bundle.getBoolean("collect_img_disable"));
        }
        try {
            this.f15625a = intent.getStringExtra("type");
        } catch (Exception e) {
            e.d("PushSelfShowLog", "getStringExtra type error");
        }
        e.a("PushSelfShowLog", "the showType is :" + this.f15625a);
        if (this.f15630f.containsKey(this.f15625a)) {
            this.f15628d = (Class) this.f15630f.get(this.f15625a);
            try {
                this.f15629e = this.f15628d.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method declaredMethod = this.f15628d.getDeclaredMethod("setActivity", new Class[]{Activity.class});
                e.a("PushSelfShowLog", "call setActivity in RichPush!");
                declaredMethod.invoke(this.f15629e, new Object[]{this.f15626b});
                this.f15628d.getDeclaredMethod("onCreate", new Class[]{Intent.class}).invoke(this.f15629e, new Object[]{intent});
                return;
            } catch (NoSuchMethodException e2) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has onCreate method,err info " + e2.toString());
                return;
            } catch (InstantiationException e3) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has onCreate method,err info " + e3.toString());
                return;
            } catch (IllegalAccessException e4) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has onCreate method,err info " + e4.toString());
                return;
            } catch (IllegalArgumentException e5) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has onCreate method,err info " + e5.toString());
                return;
            } catch (InvocationTargetException e6) {
                e.a("PushSelfShowLog", this.f15628d.getName() + " doesn't has onCreate method,err info " + e6.toString());
                return;
            }
        }
        e.a("PushSelfShowLog", "the showType is invalid");
        finish();
    }

    public void onDestroy() {
        e.a("PushSelfShowLog", "enter onDestroy of RichPush");
        if (!this.f15627c) {
            super.onDestroy();
        }
        m20301a("onDestroy", new Class[0], new Object[0]);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        e.a("PushSelfShowLog", "enter onKeyDown of RichPush");
        m20301a("onKeyDown", new Class[]{Integer.TYPE, KeyEvent.class}, new Object[]{Integer.valueOf(i), keyEvent});
        return true;
    }

    public void onPause() {
        e.a("PushSelfShowLog", "enter onPause of RichPush");
        if (!this.f15627c) {
            super.onPause();
        }
        m20301a("onPause", new Class[0], new Object[0]);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.a("PushSelfShowLog", "enter onRequestPermissionsResult of RichPush");
        if (!this.f15627c) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
        m20301a("onRequestPermissionsResult", new Class[]{Integer.TYPE, String[].class, int[].class}, new Object[]{Integer.valueOf(i), strArr, iArr});
    }

    public void onRestart() {
        e.a("PushSelfShowLog", "enter onRestart of RichPush");
        if (!this.f15627c) {
            super.onRestart();
        }
        m20301a("onRestart", new Class[0], new Object[0]);
    }

    protected void onResume() {
        e.a("PushSelfShowLog", "enter onResume of RichPush");
        if (!this.f15627c) {
            super.onResume();
        }
        m20301a("onResume", new Class[0], new Object[0]);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        e.a("PushSelfShowLog", "enter onSaveInstanceState of RichPush");
        if (!this.f15627c) {
            super.onSaveInstanceState(bundle);
        }
        m20301a("onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
    }

    public void onStart() {
        e.a("PushSelfShowLog", "enter onStart of RichPush");
        if (!this.f15627c) {
            super.onStart();
        }
        m20301a("onStart", new Class[0], new Object[0]);
    }

    public void onStop() {
        e.a("PushSelfShowLog", "enter onStop of RichPush， and mkInstance is " + this.f15627c + "and pActivityClass is " + this.f15628d + ",and pActivityInstance is " + this.f15629e);
        if (!this.f15627c) {
            super.onStop();
        }
        m20301a("onStop", new Class[0], new Object[0]);
    }
}
