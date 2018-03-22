package com.huawei.pluginkidwatch.common.lib.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: K1Util */
public class C1492l {
    private static String f3465A = "。";
    private static String f3466B = "、";
    private static String f3467C = "";
    private static final byte[] f3468a = new byte[0];
    private static final char[] f3469b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static int f3470c = 32;
    private static int f3471d = 127;
    private static int f3472e = 44;
    private static int f3473f = 34;
    private static int f3474g = 58;
    private static int f3475h = 59;
    private static int f3476i = 92;
    private static int f3477j = 38;
    private static int f3478k = 37;
    private static int f3479l = 43;
    private static int f3480m = 39;
    private static int f3481n = 60;
    private static int f3482o = 62;
    private static int f3483p = 63;
    private static int f3484q = 42;
    private static int f3485r = 47;
    private static int f3486s = ReportInfoUtils.FEEDBACK_FAILED;
    private static String f3487t = HwAccountConstants.BLANK;
    private static String f3488u = "•";
    private static String f3489v = "·";
    private static String f3490w = "▪";
    private static String f3491x = ",";
    private static String f3492y = ".";
    private static String f3493z = "，";

    public static String m6908a(String str) {
        String str2 = "";
        try {
            str2 = C1492l.m6909a(str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            C2538c.m12680e("K1Util", "Exception e = " + e.getMessage());
        }
        return str2;
    }

    public static String m6909a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = (((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8)) | (bArr[i3 + 2] & 255);
            stringBuffer.append(f3469b[(i4 >> 18) & 63]);
            stringBuffer.append(f3469b[(i4 >> 12) & 63]);
            stringBuffer.append(f3469b[(i4 >> 6) & 63]);
            stringBuffer.append(f3469b[i4 & 63]);
            i4 = i3 + 3;
            i3 = i2 + 1;
            if (i2 >= 14) {
                stringBuffer.append(HwAccountConstants.BLANK);
                i3 = 0;
            }
            i2 = i3;
            i3 = i4;
        }
        if (i3 == (0 + length) - 2) {
            i3 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            stringBuffer.append(f3469b[(i3 >> 18) & 63]);
            stringBuffer.append(f3469b[(i3 >> 12) & 63]);
            stringBuffer.append(f3469b[(i3 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i3 == (0 + length) - 1) {
            i3 = (bArr[i3] & 255) << 16;
            stringBuffer.append(f3469b[(i3 >> 18) & 63]);
            stringBuffer.append(f3469b[(i3 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString().replace(HwAccountConstants.BLANK, "");
    }

    public static String m6915b(byte[] bArr) {
        StringBuffer stringBuffer;
        synchronized (f3468a) {
            stringBuffer = new StringBuffer();
            for (byte b : bArr) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toHexString);
            }
        }
        return stringBuffer.toString();
    }

    public static String m6907a(Context context) {
        if (context == null) {
            return "";
        }
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null) {
            return ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName();
        }
        C2538c.m12680e("K1Util", "mRunningTaskInfoList is null !!!!");
        return "";
    }

    public static int m6901a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static boolean m6917b(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        Pattern compile = Pattern.compile("^[a-zA-Z0-9一-龥豈-鶴]+$");
        for (int i = 0; i < str.length(); i++) {
            CharSequence substring = str.substring(i, i + 1);
            if (!(substring.equals(f3487t) || substring.equals(f3488u) || substring.equals(f3489v) || substring.equals(f3490w) || substring.equals(f3491x) || substring.equals(f3492y) || substring.equals(f3493z) || substring.equals(f3465A) || substring.equals(f3466B))) {
                if (!compile.matcher(substring).matches()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean m6919c(String str) {
        if (str == null || "".equals(str) || !Pattern.compile("[0-9]*").matcher(str).matches() || "".equals(str)) {
            return false;
        }
        return true;
    }

    public static int m6920d(String str) {
        int i = 0;
        try {
            if (str.indexOf(".") > 0) {
                str = str.substring(0, str.indexOf("."));
            }
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C2538c.m12680e("K1Util", "Exception e = " + e.getMessage());
        }
        return i;
    }

    public static double m6921e(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            C2538c.m12680e("K1Util", "Exception e = " + e.getMessage());
            return 0.0d;
        }
    }

    public static long m6922f(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            C2538c.m12680e("K1Util", "Exception e = " + e.getMessage());
            return 0;
        }
    }

    public static boolean m6916b(Context context) {
        if (context != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static int m6902a(String str, int i) {
        if (!(str == null || str.length() == 0)) {
            String trim = str.trim();
            try {
                i = Integer.parseInt(trim);
            } catch (NumberFormatException e) {
                C2538c.m12680e("K1Util", "NumberFormatException E1 = " + e.getMessage());
                try {
                    i = Float.valueOf(trim).intValue();
                } catch (NumberFormatException e2) {
                    C2538c.m12680e("K1Util", "NumberFormatException E2 = " + e2.getMessage());
                }
            }
        }
        return i;
    }

    public static int m6923g(String str) {
        return C1492l.m6902a(str, 0);
    }

    public static int m6900a(int i) {
        return i / 100;
    }

    public static int m6914b(int i) {
        return i % 100;
    }

    public static String m6906a(int i, int i2, int i3, String str) {
        SimpleDateFormat simpleDateFormat;
        if (TextUtils.isEmpty(str)) {
            simpleDateFormat = new SimpleDateFormat("date_format", Locale.ENGLISH);
        } else {
            simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getDefault());
        instance.set(i, i2 - 1, i3);
        return simpleDateFormat.format(instance.getTime());
    }

    public static Bitmap m6903a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        float f;
        float f2;
        float f3;
        int i;
        int i2;
        float f4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f5 = (float) width;
        float f6 = (float) height;
        if (f5 <= f6) {
            f = f5;
            f2 = 0.0f;
            f3 = f5 / 2.0f;
            i = width;
            i2 = width;
            f4 = f5;
            f6 = f5;
        } else {
            f4 = (f5 - f6) / 2.0f;
            f3 = f6 / 2.0f;
            i = height;
            i2 = height;
            f2 = f4;
            f = f5 - f4;
            f4 = f6;
            f5 = f6;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i, Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f2, (int) null, (int) f, (int) f4);
        Rect rect2 = new Rect((int) null, (int) null, (int) f6, (int) f5);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f3, f3, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static Bitmap m6904a(Bitmap bitmap, double d, double d2) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) d) / width, ((float) d2) / height);
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }

    public static Bitmap m6905a(View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static boolean m6912a() {
        String str = "EmotionUI";
        try {
            boolean z;
            Class cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.version.emui"});
            C2538c.m12674b("K1Util", "emui:" + str2);
            if (str2 == null || str2.indexOf(str) == -1) {
                z = false;
            } else {
                z = true;
            }
            return z;
        } catch (ClassNotFoundException e) {
            C2538c.m12674b("K1Util", e.getMessage());
            return false;
        } catch (NoSuchMethodException e2) {
            C2538c.m12674b("K1Util", e2.getMessage());
            return false;
        } catch (InvocationTargetException e3) {
            C2538c.m12674b("K1Util", e3.getMessage());
            return false;
        } catch (IllegalAccessException e4) {
            C2538c.m12674b("K1Util", e4.getMessage());
            return false;
        }
    }

    public static String m6924h(String str) {
        C2538c.m12674b("K1Util", "=====Enter string2Json s:" + str);
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                    stringBuffer.append("\\\"");
                    break;
                case '/':
                    stringBuffer.append("\\/");
                    break;
                case '\\':
                    stringBuffer.append("\\\\");
                    break;
                default:
                    stringBuffer.append(charAt);
                    break;
            }
        }
        C2538c.m12674b("K1Util", "=====Enter string2Json res:" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static String m6918c(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getAbsolutePath() + File.separator;
    }

    public static boolean m6913a(Context context, String[] strArr) {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        C2538c.m12674b("K1Util", "hasPermission =" + b.a(context, strArr));
        return b.a(context, strArr);
    }

    public static void m6910a(Activity activity, String[] strArr) {
        b.a(activity, strArr, new C1493m());
    }

    public static void m6911a(Context context, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("devicename", str2);
        hashMap.put("mac", str3);
        c.a().a(BaseApplication.m2632b(), str, hashMap, 0);
    }
}
