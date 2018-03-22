package com.squareup.leakcanary;

import android.os.Build;
import android.os.Build.VERSION;
import com.squareup.leakcanary.ExcludedRefs.Builder;
import com.squareup.leakcanary.ExcludedRefs.BuilderWithParams;
import com.squareup.leakcanary.internal.LeakCanaryInternals;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;

public enum AndroidExcludedRefs {
    ;
    
    final boolean applies;

    enum AnonymousClass10 extends AndroidExcludedRefs {
        AnonymousClass10(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            String str = "ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0";
            builder.instanceField("android.support.v7.internal.widget.ActivityChooserModel", "mActivityChoserModelPolicy").reason(str);
            builder.instanceField("android.widget.ActivityChooserModel", "mActivityChoserModelPolicy").reason(str);
        }
    }

    enum AnonymousClass11 extends AndroidExcludedRefs {
        AnonymousClass11(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.speech.SpeechRecognizer$InternalListener", "this$0").reason("Prior to Android 5, SpeechRecognizer.InternalListener was a non static inner class and leaked the SpeechRecognizer which leaked an activity context. Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit /b37866db469e81aca534ff6186bdafd44352329b");
        }
    }

    enum AnonymousClass12 extends AndroidExcludedRefs {
        AnonymousClass12(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.accounts.AccountManager$AmsTask$Response", "this$1").reason("AccountManager$AmsTask$Response is a stub and is held in memory by native code, probably because the reference to the response in the other process hasn't been cleared. AccountManager$AmsTask is holding on to the activity reference to use for launching a new sub- Activity. Tracked here: https://code.google.com/p/android/issues/detail?id=173689 Fix: Pass a null activity reference to the AccountManager methods and then deal with the returned future to to get the result and correctly start an activity when it's available.");
        }
    }

    enum AnonymousClass13 extends AndroidExcludedRefs {
        AnonymousClass13(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.media.MediaScannerConnection", "mContext").reason("The static method MediaScannerConnection.scanFile() takes an activity context but the service might not disconnect after the activity has been destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=173788 Fix: Create an instance of MediaScannerConnection yourself and pass in the application context. Call connect() and disconnect() manually.");
        }
    }

    enum AnonymousClass14 extends AndroidExcludedRefs {
        AnonymousClass14(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.os.UserManager", "mContext").reason("UserManager has a static sInstance field that creates an instance and caches it the first time UserManager.get() is called. This instance is created with the outer context (which is an activity base context). Tracked here: https://code.google.com/p/android/issues/detail?id=173789 Introduced by: https://github.com/android/platform_frameworks_base/commit/27db46850b708070452c0ce49daf5f79503fbde6 Fix: trigger a call to UserManager.get() in Application.onCreate(), so that the UserManager instance gets cached with a reference to the application context.");
        }
    }

    enum AnonymousClass15 extends AndroidExcludedRefs {
        AnonymousClass15(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.appwidget.AppWidgetHost$Callbacks", "this$0").reason("android.appwidget.AppWidgetHost$Callbacks is a stub and is held in memory native code. The reference to the `mContext` was not being cleared, which caused the Callbacks instance to retain this reference Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit/7a96f3c917e0001ee739b65da37b2fadec7d7765");
        }
    }

    enum AnonymousClass16 extends AndroidExcludedRefs {
        AnonymousClass16(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.media.AudioManager$1", "this$0").reason("Prior to Android M, VideoView required audio focus from AudioManager and never abandoned it, which leaks the Activity context through the AudioManager. The root of the problem is that AudioManager uses whichever context it receives, which in the case of the VideoView example is an Activity, even though it only needs the application's context. The issue is fixed in Android M, and the AudioManager now uses the application's context. Tracked here: https://code.google.com/p/android/issues/detail?id=152173 Fix: https://gist.github.com/jankovd/891d96f476f7a9ce24e2");
        }
    }

    enum AnonymousClass17 extends AndroidExcludedRefs {
        AnonymousClass17(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.widget.Editor$Blink", "this$0").reason("The EditText Blink of the Cursor is implemented using a callback and Messages, which trigger the display of the Cursor. If an AlertDialog or DialogFragment that contains a blinking cursor is detached, a message is posted with a delay after the dialog has been closed and as a result leaks the Activity. This can be fixed manually by calling TextView.setCursorVisible(false) in the dismiss() method of the dialog. Tracked here: https://code.google.com/p/android/issues/detail?id=188551 Fixed in AOSP: https://android.googlesource.com/platform/frameworks/base/+/5b734f2430e9f26c769d6af8ea5645e390fcf5af%5E%21/");
        }
    }

    enum AnonymousClass18 extends AndroidExcludedRefs {
        AnonymousClass18(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.net.ConnectivityManager", "sInstance").reason("ConnectivityManager has a sInstance field that is set when the firstConnectivityManager instance is created. ConnectivityManager has a mContext field.When calling activity.getSystemService(Context.CONNECTIVITY_SERVICE) , the firstConnectivityManager instance is created with the activity context and stored insInstance. That activity context then leaks forever.Until this is fixed, app developers can prevent this leak by making sure the ConnectivityManager is first created with an App Context. E.g. in some static init do: context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) Tracked here: https://code.google.com/p/android/issues/detail?id=198852 Introduced here: https://github.com/android/platform_frameworks_base/commit/e0bef71662d81caaaa0d7214fb0bef5d39996a69");
        }
    }

    enum AnonymousClass19 extends AndroidExcludedRefs {
        AnonymousClass19(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.app.Instrumentation", "mRecommendActivity").reason("Instrumentation would leak com.android.internal.app.RecommendActivity (in framework.jar) in Meizu FlymeOS 4.5 and above, which is based on Android 5.0 and above");
        }
    }

    enum C25691 extends AndroidExcludedRefs {
        C25691(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.app.ActivityThread$ActivityClientRecord", "nextIdle").reason("Android AOSP sometimes keeps a reference to a destroyed activity as a nextIdle client record in the android.app.ActivityThread.mActivities map. Not sure what's going on there, input welcome.");
        }
    }

    enum AnonymousClass20 extends AndroidExcludedRefs {
        AnonymousClass20(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            if (LeakCanaryInternals.MOTOROLA.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19) {
                builder.instanceField("android.app.admin.DevicePolicyManager$SettingsObserver", "this$0").reason("DevicePolicyManager keeps a reference to the context it has been created with instead of extracting the application context. In this Motorola build, DevicePolicyManager has an inner SettingsObserver class that is a content observer, which is held into memory by a binder transport object.");
            }
        }
    }

    enum AnonymousClass21 extends AndroidExcludedRefs {
        AnonymousClass21(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("com.samsung.android.smartclip.SpenGestureManager", "mContext").reason("SpenGestureManager has a static mContext field that leaks a reference to the activity. Yes, a STATIC mContext field.");
        }
    }

    enum AnonymousClass22 extends AndroidExcludedRefs {
        AnonymousClass22(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.sec.clipboard.ClipboardUIManager", "mContext").reason("ClipboardUIManager is a static singleton that leaks an activity context. Fix: trigger a call to ClipboardUIManager.getInstance() in Application.onCreate() , so that the ClipboardUIManager instance gets cached with a reference to the application context. Example: https://gist.github.com/cypressious/91c4fb1455470d803a602838dfcd5774");
        }
    }

    enum AnonymousClass23 extends AndroidExcludedRefs {
        AnonymousClass23(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.widget.BubblePopupHelper", "sHelper").reason("A static helper for EditText bubble popups leaks a reference to the latestfocused view.");
        }
    }

    enum AnonymousClass24 extends AndroidExcludedRefs {
        AnonymousClass24(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("com.android.org.chromium.android_webview.AwResource", "sResources");
        }
    }

    enum AnonymousClass25 extends AndroidExcludedRefs {
        AnonymousClass25(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("com.nvidia.ControllerMapper.MapperClient$ServiceClient", "this$0").reason("Not sure exactly what ControllerMapper is about, but there is an anonymous Handler in ControllerMapper.MapperClient.ServiceClient, which leaks ControllerMapper.MapperClient which leaks the activity context.");
        }
    }

    enum AnonymousClass26 extends AndroidExcludedRefs {
        AnonymousClass26(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.widget.TextView", "mLastHoveredView").reason("mLastHoveredView is a static field in TextView that leaks the last hovered view.");
        }
    }

    enum AnonymousClass27 extends AndroidExcludedRefs {
        AnonymousClass27(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.os.PersonaManager", "mContext").reason("android.app.LoadedApk.mResources has a reference to android.content.res.Resources.mPersonaManager which has a reference to android.os.PersonaManager.mContext which is an activity.");
        }
    }

    enum AnonymousClass28 extends AndroidExcludedRefs {
        AnonymousClass28(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.content.res.Resources", "mContext").reason("In AOSP the Resources class does not have a context. Here we have ZygoteInit.mResources (static field) holding on to a Resources instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issue-74450184");
        }
    }

    enum AnonymousClass29 extends AndroidExcludedRefs {
        AnonymousClass29(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.view.ViewConfiguration", "mContext").reason("In AOSP the ViewConfiguration class does not have a context. Here we have ViewConfiguration.sConfigurations (static field) holding on to a ViewConfiguration instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issuecomment-100324683");
        }
    }

    enum C25702 extends AndroidExcludedRefs {
        C25702(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            String str = "Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.";
            builder.instanceField("android.widget.Editor$EasyEditSpanController", "this$0").reason(str);
            builder.instanceField("android.widget.Editor$SpanController", "this$0").reason(str);
        }
    }

    enum AnonymousClass30 extends AndroidExcludedRefs {
        AnonymousClass30(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.hardware.SystemSensorManager", "mAppContextImpl").reason("Lenovo specific leak. SystemSensorManager stores a reference to context in a static field in its constructor. Found on LENOVO 4.4.2. Fix: use application context to get SensorManager");
        }
    }

    enum AnonymousClass31 extends AndroidExcludedRefs {
        AnonymousClass31(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.media.AudioManager", "mContext_static").reason("Samsung added a static mContext_static field to AudioManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/32");
        }
    }

    enum AnonymousClass32 extends AndroidExcludedRefs {
        AnonymousClass32(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.app.ActivityManager", "mContext").reason("Samsung added a static mContext field to ActivityManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/177 Fix in comment: https://github.com/square/leakcanary/issues/177#issuecomment-222724283");
        }
    }

    enum AnonymousClass33 extends AndroidExcludedRefs {
        AnonymousClass33(String str, int i) {
            super(str, i);
        }

        void add(Builder builder) {
            builder.clazz(WeakReference.class.getName()).alwaysExclude();
            builder.clazz(SoftReference.class.getName()).alwaysExclude();
            builder.clazz(PhantomReference.class.getName()).alwaysExclude();
            builder.clazz("java.lang.ref.Finalizer").alwaysExclude();
            builder.clazz("java.lang.ref.FinalizerReference").alwaysExclude();
        }
    }

    enum AnonymousClass34 extends AndroidExcludedRefs {
        AnonymousClass34(String str, int i) {
            super(str, i);
        }

        void add(Builder builder) {
            builder.thread("FinalizerWatchdogDaemon").alwaysExclude();
        }
    }

    enum AnonymousClass35 extends AndroidExcludedRefs {
        AnonymousClass35(String str, int i) {
            super(str, i);
        }

        void add(Builder builder) {
            builder.thread("main").alwaysExclude();
        }
    }

    enum AnonymousClass36 extends AndroidExcludedRefs {
        AnonymousClass36(String str, int i) {
            super(str, i);
        }

        void add(Builder builder) {
            builder.thread("LeakCanary-Heap-Dump").alwaysExclude();
        }
    }

    enum AnonymousClass37 extends AndroidExcludedRefs {
        AnonymousClass37(String str, int i) {
            super(str, i);
        }

        void add(Builder builder) {
            builder.instanceField("android.view.Choreographer$FrameDisplayEventReceiver", "mMessageQueue").alwaysExclude();
        }
    }

    enum C25713 extends AndroidExcludedRefs {
        C25713(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.media.session.MediaSessionLegacyHelper", "sInstance").reason("MediaSessionLegacyHelper is a static singleton that is lazily instantiated and keeps a reference to the context it's given the first time MediaSessionLegacyHelper.getHelper() is called. This leak was introduced in android-5.0.1_r1 and fixed in Android 5.1.0_r1 by calling context.getApplicationContext(). Fix: https://github.com/android/platform_frameworks_base/commit/9b5257c9c99c4cb541d8e8e78fb04f008b1a9091 To fix this, you could call MediaSessionLegacyHelper.getHelper() early in Application.onCreate() and pass it the application context.");
        }
    }

    enum C25724 extends AndroidExcludedRefs {
        C25724(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.staticField("android.text.TextLine", "sCached").reason("TextLine.sCached is a pool of 3 TextLine instances. TextLine.recycle() has had at least two bugs that created memory leaks by not correctly clearing the recycled TextLine instances. The first was fixed in android-5.1.0_r1: https://github.com/android/platform_frameworks_base/commit/893d6fe48d37f71e683f722457bea646994a10 The second was fixed, not released yet: https://github.com/android/platform_frameworks_base/commit/b3a9bc038d3a218b1dbdf7b5668e3d6c12be5e To fix this, you could access TextLine.sCached and clear the pool every now and then (e.g. on activity destroy).");
        }
    }

    enum C25735 extends AndroidExcludedRefs {
        C25735(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            String str = "Prior to ART, a thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after beingused, this won't be a problem, because these references are cleared when beingrecycled. However, dialogs create template Message instances to be copied when amessage needs to be sent. These Message templates holds references to the dialoglisteners, which most likely leads to holding a reference onto the activity in someway. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. To fix this, you could post empty messages to the idle handler threads from time to time. This won't be easy because you cannot access all handler threads, but a librarythat is widely used should consider doing this for its own handler threads.";
            builder.instanceField("android.os.Message", "obj").reason(str);
            builder.instanceField("android.os.Message", "next").reason(str);
            builder.instanceField("android.os.Message", "target").reason(str);
        }
    }

    enum C25746 extends AndroidExcludedRefs {
        C25746(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            String str = "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414";
            builder.instanceField("android.view.inputmethod.InputMethodManager", "mNextServedView").reason(str);
            builder.instanceField("android.view.inputmethod.InputMethodManager", "mServedView").reason(str);
            builder.instanceField("android.view.inputmethod.InputMethodManager", "mServedInputConnection").reason(str);
        }
    }

    enum C25757 extends AndroidExcludedRefs {
        C25757(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.view.inputmethod.InputMethodManager", "mCurRootView").reason("The singleton InputMethodManager is holding a reference to mCurRootView long after the activity has been destroyed. Observed on ICS MR1: https://github.com/square/leakcanary/issues/1#issuecomment-100579429 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414");
        }
    }

    enum C25768 extends AndroidExcludedRefs {
        C25768(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.animation.LayoutTransition$1", "val$parent").reason("LayoutTransition leaks parent ViewGroup through ViewTreeObserver.OnPreDrawListener When triggered, this leaks stays until the window is destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=171830");
        }
    }

    enum C25779 extends AndroidExcludedRefs {
        C25779(String str, int i, boolean z) {
            super(str, i, z);
        }

        void add(Builder builder) {
            builder.instanceField("android.view.textservice.SpellCheckerSession$1", "this$0").reason("SpellCheckerSessionListenerImpl.mHandler is leaking destroyed Activity when the SpellCheckerSession is closed before the service is connected. Tracked here: https://code.google.com/p/android/issues/detail?id=172542");
        }
    }

    abstract void add(Builder builder);

    static {
        boolean z;
        String str = "ACTIVITY_CLIENT_RECORD__NEXT_IDLE";
        if (VERSION.SDK_INT < 19 || VERSION.SDK_INT > 21) {
            z = false;
        } else {
            z = true;
        }
        ACTIVITY_CLIENT_RECORD__NEXT_IDLE = new C25691(str, 0, z);
        str = "SPAN_CONTROLLER";
        if (VERSION.SDK_INT <= 19) {
            z = true;
        } else {
            z = false;
        }
        SPAN_CONTROLLER = new C25702(str, 1, z);
        str = "MEDIA_SESSION_LEGACY_HELPER__SINSTANCE";
        if (VERSION.SDK_INT == 21) {
            z = true;
        } else {
            z = false;
        }
        MEDIA_SESSION_LEGACY_HELPER__SINSTANCE = new C25713(str, 2, z);
        str = "TEXT_LINE__SCACHED";
        if (VERSION.SDK_INT <= 22) {
            z = true;
        } else {
            z = false;
        }
        TEXT_LINE__SCACHED = new C25724(str, 3, z);
        str = "BLOCKING_QUEUE";
        if (VERSION.SDK_INT < 21) {
            z = true;
        } else {
            z = false;
        }
        BLOCKING_QUEUE = new C25735(str, 4, z);
        str = "INPUT_METHOD_MANAGER__SERVED_VIEW";
        if (VERSION.SDK_INT < 15 || VERSION.SDK_INT > 23) {
            z = false;
        } else {
            z = true;
        }
        INPUT_METHOD_MANAGER__SERVED_VIEW = new C25746(str, 5, z);
        str = "INPUT_METHOD_MANAGER__ROOT_VIEW";
        if (VERSION.SDK_INT < 15 || VERSION.SDK_INT > 23) {
            z = false;
        } else {
            z = true;
        }
        INPUT_METHOD_MANAGER__ROOT_VIEW = new C25757(str, 6, z);
        str = "LAYOUT_TRANSITION";
        z = VERSION.SDK_INT >= 14 && VERSION.SDK_INT <= 22;
        LAYOUT_TRANSITION = new C25768(str, 7, z);
        str = "SPELL_CHECKER_SESSION";
        if ((VERSION.SDK_INT < 16 || VERSION.SDK_INT > 22) && VERSION.SDK_INT < 24) {
            z = false;
        } else {
            z = true;
        }
        SPELL_CHECKER_SESSION = new C25779(str, 8, z);
        str = "ACTIVITY_CHOOSE_MODEL";
        if (VERSION.SDK_INT <= 14 || VERSION.SDK_INT > 22) {
            z = false;
        } else {
            z = true;
        }
        ACTIVITY_CHOOSE_MODEL = new AnonymousClass10(str, 9, z);
        SPEECH_RECOGNIZER = new AnonymousClass11("SPEECH_RECOGNIZER", 10, VERSION.SDK_INT < 21);
        str = "ACCOUNT_MANAGER";
        if (VERSION.SDK_INT <= 22) {
            z = true;
        } else {
            z = false;
        }
        ACCOUNT_MANAGER = new AnonymousClass12(str, 11, z);
        str = "MEDIA_SCANNER_CONNECTION";
        if (VERSION.SDK_INT <= 22) {
            z = true;
        } else {
            z = false;
        }
        MEDIA_SCANNER_CONNECTION = new AnonymousClass13(str, 12, z);
        str = "USER_MANAGER__SINSTANCE";
        if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 23) {
            z = false;
        } else {
            z = true;
        }
        USER_MANAGER__SINSTANCE = new AnonymousClass14(str, 13, z);
        str = "APP_WIDGET_HOST_CALLBACKS";
        if (VERSION.SDK_INT < 22) {
            z = true;
        } else {
            z = false;
        }
        APP_WIDGET_HOST_CALLBACKS = new AnonymousClass15(str, 14, z);
        str = "AUDIO_MANAGER";
        if (VERSION.SDK_INT <= 22) {
            z = true;
        } else {
            z = false;
        }
        AUDIO_MANAGER = new AnonymousClass16(str, 15, z);
        str = "EDITTEXT_BLINK_MESSAGEQUEUE";
        if (VERSION.SDK_INT <= 22) {
            z = true;
        } else {
            z = false;
        }
        EDITTEXT_BLINK_MESSAGEQUEUE = new AnonymousClass17(str, 16, z);
        str = "CONNECTIVITY_MANAGER__SINSTANCE";
        if (VERSION.SDK_INT <= 23) {
            z = true;
        } else {
            z = false;
        }
        CONNECTIVITY_MANAGER__SINSTANCE = new AnonymousClass18(str, 17, z);
        str = "INSTRUMENTATION_RECOMMEND_ACTIVITY";
        z = LeakCanaryInternals.MEIZU.equals(Build.MANUFACTURER) && VERSION.SDK_INT >= 21 && VERSION.SDK_INT <= 22;
        INSTRUMENTATION_RECOMMEND_ACTIVITY = new AnonymousClass19(str, 18, z);
        str = "DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER";
        if (!LeakCanaryInternals.MOTOROLA.equals(Build.MANUFACTURER) || VERSION.SDK_INT < 19 || VERSION.SDK_INT > 22) {
            z = false;
        } else {
            z = true;
        }
        DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER = new AnonymousClass20(str, 19, z);
        str = "SPEN_GESTURE_MANAGER";
        z = LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19;
        SPEN_GESTURE_MANAGER = new AnonymousClass21(str, 20, z);
        str = "CLIPBOARD_UI_MANAGER__SINSTANCE";
        if (!LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) || VERSION.SDK_INT < 19 || VERSION.SDK_INT > 21) {
            z = false;
        } else {
            z = true;
        }
        CLIPBOARD_UI_MANAGER__SINSTANCE = new AnonymousClass22(str, 21, z);
        str = "BUBBLE_POPUP_HELPER__SHELPER";
        z = LeakCanaryInternals.LG.equals(Build.MANUFACTURER) && VERSION.SDK_INT >= 19 && VERSION.SDK_INT <= 21;
        BUBBLE_POPUP_HELPER__SHELPER = new AnonymousClass23(str, 22, z);
        str = "AW_RESOURCE__SRESOURCES";
        if (LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19) {
            z = true;
        } else {
            z = false;
        }
        AW_RESOURCE__SRESOURCES = new AnonymousClass24(str, 23, z);
        str = "MAPPER_CLIENT";
        if (LeakCanaryInternals.NVIDIA.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19) {
            z = true;
        } else {
            z = false;
        }
        MAPPER_CLIENT = new AnonymousClass25(str, 24, z);
        str = "TEXT_VIEW__MLAST_HOVERED_VIEW";
        if (!LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) || VERSION.SDK_INT < 19 || VERSION.SDK_INT > 22) {
            z = false;
        } else {
            z = true;
        }
        TEXT_VIEW__MLAST_HOVERED_VIEW = new AnonymousClass26(str, 25, z);
        str = "PERSONA_MANAGER";
        if (LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19) {
            z = true;
        } else {
            z = false;
        }
        PERSONA_MANAGER = new AnonymousClass27(str, 26, z);
        str = "RESOURCES__MCONTEXT";
        if (LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19) {
            z = true;
        } else {
            z = false;
        }
        RESOURCES__MCONTEXT = new AnonymousClass28(str, 27, z);
        str = "VIEW_CONFIGURATION__MCONTEXT";
        if (LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19) {
            z = true;
        } else {
            z = false;
        }
        VIEW_CONFIGURATION__MCONTEXT = new AnonymousClass29(str, 28, z);
        str = "SYSTEM_SENSOR_MANAGER_LENOVO";
        z = LeakCanaryInternals.LENOVO.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19;
        SYSTEM_SENSOR_MANAGER_LENOVO = new AnonymousClass30(str, 29, z);
        str = "AUDIO_MANAGER__MCONTEXT_STATIC";
        if (LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 19) {
            z = true;
        } else {
            z = false;
        }
        AUDIO_MANAGER__MCONTEXT_STATIC = new AnonymousClass31(str, 30, z);
        str = "ACTIVITY_MANAGER_MCONTEXT";
        if (LeakCanaryInternals.SAMSUNG.equals(Build.MANUFACTURER) && VERSION.SDK_INT == 22) {
            z = true;
        } else {
            z = false;
        }
        ACTIVITY_MANAGER_MCONTEXT = new AnonymousClass32(str, 31, z);
        SOFT_REFERENCES = new AnonymousClass33("SOFT_REFERENCES", 32);
        FINALIZER_WATCHDOG_DAEMON = new AnonymousClass34("FINALIZER_WATCHDOG_DAEMON", 33);
        MAIN = new AnonymousClass35("MAIN", 34);
        LEAK_CANARY_THREAD = new AnonymousClass36("LEAK_CANARY_THREAD", 35);
        EVENT_RECEIVER__MMESSAGE_QUEUE = new AnonymousClass37("EVENT_RECEIVER__MMESSAGE_QUEUE", 36);
        $VALUES = new AndroidExcludedRefs[]{ACTIVITY_CLIENT_RECORD__NEXT_IDLE, SPAN_CONTROLLER, MEDIA_SESSION_LEGACY_HELPER__SINSTANCE, TEXT_LINE__SCACHED, BLOCKING_QUEUE, INPUT_METHOD_MANAGER__SERVED_VIEW, INPUT_METHOD_MANAGER__ROOT_VIEW, LAYOUT_TRANSITION, SPELL_CHECKER_SESSION, ACTIVITY_CHOOSE_MODEL, SPEECH_RECOGNIZER, ACCOUNT_MANAGER, MEDIA_SCANNER_CONNECTION, USER_MANAGER__SINSTANCE, APP_WIDGET_HOST_CALLBACKS, AUDIO_MANAGER, EDITTEXT_BLINK_MESSAGEQUEUE, CONNECTIVITY_MANAGER__SINSTANCE, INSTRUMENTATION_RECOMMEND_ACTIVITY, DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER, SPEN_GESTURE_MANAGER, CLIPBOARD_UI_MANAGER__SINSTANCE, BUBBLE_POPUP_HELPER__SHELPER, AW_RESOURCE__SRESOURCES, MAPPER_CLIENT, TEXT_VIEW__MLAST_HOVERED_VIEW, PERSONA_MANAGER, RESOURCES__MCONTEXT, VIEW_CONFIGURATION__MCONTEXT, SYSTEM_SENSOR_MANAGER_LENOVO, AUDIO_MANAGER__MCONTEXT_STATIC, ACTIVITY_MANAGER_MCONTEXT, SOFT_REFERENCES, FINALIZER_WATCHDOG_DAEMON, MAIN, LEAK_CANARY_THREAD, EVENT_RECEIVER__MMESSAGE_QUEUE};
    }

    public static Builder createAndroidDefaults() {
        return createBuilder(EnumSet.of(SOFT_REFERENCES, FINALIZER_WATCHDOG_DAEMON, MAIN, LEAK_CANARY_THREAD, EVENT_RECEIVER__MMESSAGE_QUEUE));
    }

    public static Builder createAppDefaults() {
        return createBuilder(EnumSet.allOf(AndroidExcludedRefs.class));
    }

    public static Builder createBuilder(EnumSet<AndroidExcludedRefs> enumSet) {
        Builder builder = ExcludedRefs.builder();
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            AndroidExcludedRefs androidExcludedRefs = (AndroidExcludedRefs) it.next();
            if (androidExcludedRefs.applies) {
                androidExcludedRefs.add(builder);
                ((BuilderWithParams) builder).named(androidExcludedRefs.name());
            }
        }
        return builder;
    }

    private AndroidExcludedRefs(boolean z) {
        this.applies = z;
    }
}
