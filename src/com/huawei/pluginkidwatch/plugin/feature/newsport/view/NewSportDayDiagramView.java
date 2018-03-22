package com.huawei.pluginkidwatch.plugin.feature.newsport.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.p138a.C1399o;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.e;
import java.util.ArrayList;

public class NewSportDayDiagramView extends View {
    private int f5012A;
    private ArrayList<RectF> f5013B;
    private ArrayList<Float> f5014C;
    private Rect f5015D;
    private RectF f5016E;
    private int f5017F;
    private int f5018G;
    private int f5019H;
    private int f5020I;
    private int f5021J;
    private int f5022K;
    private int f5023L;
    private int f5024M;
    private int f5025N;
    private int f5026O;
    private int f5027P;
    private int f5028Q;
    private float f5029R;
    private int f5030S;
    private int f5031T;
    private boolean f5032U;
    private int f5033a;
    private int f5034b;
    private int[] f5035c;
    private Paint f5036d;
    private int f5037e;
    private int f5038f;
    private int f5039g;
    private int f5040h;
    private int f5041i;
    private int f5042j;
    private int f5043k;
    private int f5044l;
    private int f5045m;
    private Bitmap f5046n;
    private Bitmap f5047o;
    private Bitmap f5048p;
    private Bitmap f5049q;
    private float f5050r;
    private C1399o f5051s;
    private String f5052t;
    private int f5053u;
    private int f5054v;
    private int f5055w;
    private float f5056x;
    private float f5057y;
    private int f5058z;

    public NewSportDayDiagramView(Context context) {
        this(context, null);
    }

    public NewSportDayDiagramView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5033a = 396;
        this.f5034b = 0;
        this.f5035c = new int[0];
        this.f5036d = null;
        this.f5037e = getScreenWidth();
        this.f5038f = 2;
        this.f5039g = 3;
        this.f5040h = 360;
        this.f5041i = 1320;
        this.f5042j = -7829368;
        this.f5043k = -7829368;
        this.f5044l = -7829368;
        this.f5045m = ViewCompat.MEASURED_STATE_MASK;
        this.f5046n = null;
        this.f5047o = null;
        this.f5048p = null;
        this.f5049q = null;
        this.f5050r = 0.0f;
        this.f5051s = null;
        this.f5053u = 0;
        this.f5054v = 36;
        this.f5055w = 90;
        this.f5056x = 0.0f;
        this.f5057y = 0.0f;
        this.f5012A = 36;
        this.f5013B = new ArrayList(96);
        this.f5014C = new ArrayList(96);
        this.f5015D = new Rect();
        this.f5016E = new RectF();
        this.f5017F = 70;
        this.f5018G = 10;
        this.f5019H = 1;
        this.f5020I = 0;
        this.f5021J = 0;
        this.f5022K = 0;
        this.f5023L = 0;
        this.f5024M = 18;
        this.f5025N = 0;
        this.f5026O = 0;
        this.f5027P = 0;
        this.f5028Q = 0;
        this.f5029R = 0.0f;
        this.f5030S = this.f5041i - this.f5040h;
        this.f5031T = 0;
        this.f5032U = false;
        this.f5036d = new Paint();
        this.f5036d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f5036d.setAntiAlias(true);
        this.f5033a = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_height);
        this.f5037e = getScreenWidth();
        this.f5034b = getResources().getDimensionPixelSize(e.kw_feature_sports_viewpager_height);
        this.f5038f = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_timeLineWidth);
        this.f5039g = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_minHeight);
        this.f5052t = String.format(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_nodata_text), new Object[0]);
        this.f5053u = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_maxValueText_size);
        this.f5054v = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_noDataText_size);
        this.f5055w = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_timeText_size);
        this.f5042j = getResources().getColor(d.kw_color_sport_Diagram_timeLine);
        this.f5043k = getResources().getColor(d.kw_color_sport_Diagram_timeText);
        this.f5044l = getResources().getColor(d.kw_color_sport_Diagram_noSportsData);
        this.f5047o = BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_time_vertical_line1);
        this.f5048p = BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_time_vertical_cursor);
        this.f5046n = BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_step_icon_bubble);
        this.f5049q = BitmapFactory.decodeResource(getResources(), C1617f.kw_pic_sport_max_step_point);
        this.f5045m = getResources().getColor(d.kw_color_black_65alpha);
        this.f5012A = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_sportsValue_size);
        this.f5017F = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_sportsValueYPoint);
        this.f5020I = this.f5017F + getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_scaleHeight);
        this.f5021J = this.f5020I + this.f5046n.getHeight();
        this.f5022K = (this.f5020I + (this.f5046n.getHeight() / 2)) + getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_runIcon_marginBottom);
        this.f5018G = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_sportsValueMargin);
        this.f5023L = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_timelinetop);
        this.f5025N = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_timetextlineHeight);
        this.f5024M = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_timetextleftright);
        this.f5019H = getResources().getDimensionPixelSize(e.kw_feature_sportsDiagram_brokenLineWidth);
    }

    private String m8662a(int i) {
        int i2;
        String str = "06:00";
        if (this.f5030S != 0) {
            i2 = (this.f5031T * i) + (this.f5040h / 60);
        } else {
            i2 = (i * 4) + 6;
        }
        if (i2 < 10) {
            return "0" + Integer.toString(i2) + ":" + "00";
        }
        if (i2 < 10 || i2 > 24) {
            return str;
        }
        return Integer.toString(i2) + ":" + "00";
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m8667d(canvas);
        if (!m8665b(canvas)) {
            m8668e(canvas);
            m8669f(canvas);
            m8666c(canvas);
        }
    }

    private void m8663a(Canvas canvas) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.f5044l);
        textPaint.setTextSize((float) this.f5054v);
        float f = ((float) this.f5037e) / 20.0f;
        float f2 = ((float) this.f5033a) / 2.0f;
        StaticLayout staticLayout = new StaticLayout(this.f5052t, textPaint, (this.f5037e * 18) / 20, Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, false);
        canvas.translate(f, f2);
        staticLayout.draw(canvas);
    }

    private boolean m8665b(Canvas canvas) {
        if (this.f5051s != null) {
            C2538c.m12674b("NewSportDayDiagramView", "sportData = " + this.f5051s.toString());
            if (this.f5051s.m6372e() != 0 || 0.0f != this.f5050r) {
                return false;
            }
            m8663a(canvas);
            return true;
        }
        m8663a(canvas);
        return true;
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private void m8666c(Canvas canvas) {
        if (this.f5032U) {
            String a;
            int b;
            C1816a sportsValue = getSportsValue();
            String str = "06:00";
            if (sportsValue != null) {
                a = sportsValue.f5059a;
                b = sportsValue.f5060b;
            } else {
                a = str;
                b = 0;
            }
            this.f5036d.setAntiAlias(true);
            this.f5036d.setTextSize((float) this.f5012A);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(b);
            stringBuffer.append(getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_step));
            str = stringBuffer.toString();
            int measureText = (int) this.f5036d.measureText(str, 0, str.length());
            this.f5015D.left = (int) this.f5056x;
            this.f5015D.top = this.f5021J;
            this.f5015D.right = this.f5015D.left + this.f5019H;
            this.f5015D.bottom = this.f5033a;
            m8664a(canvas, this.f5047o, this.f5015D);
            this.f5015D.left = ((int) this.f5056x) - (this.f5048p.getWidth() / 2);
            this.f5015D.top = this.f5033a;
            this.f5015D.right = this.f5015D.left + this.f5048p.getWidth();
            this.f5015D.bottom = this.f5033a + this.f5048p.getHeight();
            m8664a(canvas, this.f5048p, this.f5015D);
            this.f5015D.left = (((int) this.f5056x) - (measureText / 2)) - this.f5018G;
            this.f5015D.top = this.f5020I;
            this.f5015D.right = (this.f5015D.left + measureText) + (this.f5018G * 2);
            this.f5015D.bottom = this.f5020I + this.f5046n.getHeight();
            this.f5036d.setColor(-1);
            m8664a(canvas, this.f5046n, this.f5015D);
            this.f5036d.setColor(this.f5045m);
            canvas.drawText(str, (float) (((int) this.f5056x) - (measureText / 2)), (float) this.f5022K, this.f5036d);
            canvas.drawText(a, (float) (((int) this.f5056x) - (((int) this.f5036d.measureText(a, 0, a.length())) / 2)), (float) this.f5017F, this.f5036d);
        }
    }

    private void m8664a(Canvas canvas, Bitmap bitmap, Rect rect) {
        if (rect != null && bitmap != null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawBitmap(bitmap, null, rect, this.f5036d);
        }
    }

    private void m8667d(Canvas canvas) {
        int i = 0;
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = this.f5033a;
        rect.right = getScreenWidth();
        rect.bottom = getHeight();
        this.f5036d.setAntiAlias(true);
        this.f5036d.setColor(-1);
        canvas.drawRect(rect, this.f5036d);
        this.f5036d.setColor(this.f5042j);
        this.f5036d.setStrokeWidth((float) this.f5038f);
        canvas.drawLine(0.0f, (float) this.f5033a, (float) getScreenWidth(), (float) this.f5033a, this.f5036d);
        if (this.f5051s == null) {
            this.f5041i = 1320;
        } else if (C1485e.m6850a().toString().equals(this.f5051s.m6363b())) {
            this.f5041i = C1485e.m6856b();
        }
        getSportEndTime();
        String str = "06:00";
        this.f5036d.setTextSize((float) this.f5055w);
        this.f5031T = this.f5030S / 240;
        this.f5026O = (int) this.f5036d.measureText(str, 0, str.length());
        this.f5028Q = (this.f5037e - (this.f5024M * 2)) - this.f5026O;
        this.f5027P = this.f5028Q / 4;
        this.f5029R = ((float) this.f5028Q) / ((float) this.f5030S);
        if (Float.compare(0.0f, this.f5056x) == 0) {
            this.f5056x = (float) (this.f5024M + (this.f5026O / 2));
        }
        while (i < 5) {
            this.f5036d.setColor(this.f5043k);
            canvas.drawText(m8662a(i), (float) (this.f5024M + (this.f5027P * i)), (float) (this.f5033a + this.f5023L), this.f5036d);
            this.f5036d.setColor(this.f5042j);
            canvas.drawLine((float) ((this.f5024M + (this.f5027P * i)) + (this.f5026O / 2)), (float) this.f5033a, (float) ((this.f5024M + (this.f5027P * i)) + (this.f5026O / 2)), (float) (this.f5033a + this.f5025N), this.f5036d);
            i++;
        }
    }

    public void getSportStartTime() {
        if (360 <= this.f5040h && HeartRateDetail.HEART_RATE_TYPE_SPORT > this.f5040h) {
            this.f5040h = 360;
        } else if (HeartRateDetail.HEART_RATE_TYPE_SPORT < this.f5040h && 840 > this.f5040h) {
            this.f5040h = HeartRateDetail.HEART_RATE_TYPE_SPORT;
        } else if (840 < this.f5040h && 1080 > this.f5040h) {
            this.f5040h = 840;
        } else if (1080 < this.f5040h) {
            this.f5040h = 1080;
        }
    }

    public void getSportEndTime() {
        if (360 < this.f5041i && HeartRateDetail.HEART_RATE_TYPE_SPORT > this.f5041i) {
            this.f5041i = HeartRateDetail.HEART_RATE_TYPE_SPORT;
        } else if (HeartRateDetail.HEART_RATE_TYPE_SPORT < this.f5041i && 840 > this.f5041i) {
            this.f5041i = 840;
        } else if (840 < this.f5041i && 1080 > this.f5041i) {
            this.f5041i = 1080;
        } else if (1080 < this.f5041i) {
            this.f5041i = 1320;
        }
    }

    public void m8670a() {
        this.f5051s = null;
        this.f5030S = 960;
        this.f5040h = 360;
        this.f5041i = 1320;
        this.f5050r = 0.0f;
        invalidate();
    }

    public void m8671a(C1399o c1399o, boolean z) {
        String str = "NewSportDayDiagramView";
        Object[] objArr = new Object[1];
        objArr[0] = " sportData = " + (c1399o != null ? c1399o.toString() : "");
        C2538c.m12674b(str, objArr);
        this.f5051s = c1399o;
        this.f5050r = 0.0f;
        if (c1399o != null && c1399o.f3126a.length > 0) {
            int i;
            for (i = 1320; i >= 360; i--) {
                if (c1399o.f3126a[i] != 0) {
                    this.f5041i = i;
                    break;
                }
            }
            for (i = 360; i < 1320; i++) {
                if (c1399o.f3126a[i] != 0) {
                    this.f5040h = i;
                    break;
                }
            }
            getSportStartTime();
            getSportEndTime();
            this.f5030S = this.f5041i - this.f5040h;
            this.f5035c = new int[(this.f5030S / 10)];
            int i2 = 0;
            i = 0;
            for (int i3 = this.f5040h; i3 < this.f5041i; i3++) {
                if (9 != i3 % 10) {
                    i2 += c1399o.f3126a[i3];
                } else {
                    if (i < this.f5035c.length) {
                        i2 += c1399o.f3126a[i3];
                        this.f5035c[i] = i2;
                        if (((float) i2) > this.f5050r) {
                            this.f5050r = (float) i2;
                        }
                        i++;
                    }
                    i2 = 0;
                }
            }
        }
        invalidate();
    }

    private C1816a getSportsValue() {
        int i = 0;
        while (i < this.f5030S / 10) {
            if (i < this.f5013B.size()) {
                int i2;
                int i3;
                int i4;
                StringBuilder append;
                Object obj;
                if (i == this.f5013B.size() - 1) {
                    if (this.f5056x >= ((RectF) this.f5013B.get(i)).left && this.f5056x <= ((float) ((this.f5037e - this.f5024M) - (this.f5026O / 2)))) {
                        i2 = this.f5040h + (i * 10);
                        i3 = i2 / 60;
                        i4 = i2 % 60;
                        append = new StringBuilder().append(i3 < 10 ? "0" + i3 : Integer.valueOf(i3)).append(":");
                        if (i4 == 0) {
                            obj = "00";
                        } else {
                            obj = Integer.valueOf(i4);
                        }
                        return new C1816a(append.append(obj).toString(), this.f5035c[i]);
                    }
                } else if (this.f5056x >= ((RectF) this.f5013B.get(i)).left && this.f5056x <= ((Float) this.f5014C.get(i)).floatValue()) {
                    i2 = this.f5040h + (i * 10);
                    i3 = i2 / 60;
                    i4 = i2 % 60;
                    append = new StringBuilder().append(i3 < 10 ? "0" + i3 : Integer.valueOf(i3)).append(":");
                    if (i4 == 0) {
                        obj = "00";
                    } else {
                        obj = Integer.valueOf(i4);
                    }
                    return new C1816a(append.append(obj).toString(), this.f5035c[i]);
                }
            }
            i++;
        }
        return null;
    }

    private void m8668e(Canvas canvas) {
        this.f5013B.clear();
        Paint paint = new Paint();
        int color = getResources().getColor(d.kw_color_sport_Diagram_sports);
        for (int i = 0; i < this.f5035c.length; i++) {
            RectF a = m8660a(i, (float) this.f5035c[i], this.f5050r);
            this.f5013B.add(i, new RectF(a));
            paint.setColor(color);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.drawRect(a, paint);
        }
    }

    private RectF m8661a(RectF rectF) {
        float f = rectF.bottom - rectF.top;
        if (f > 0.0f && f < ((float) this.f5039g)) {
            rectF.top = rectF.bottom - ((float) this.f5039g);
        }
        return rectF;
    }

    private RectF m8660a(int i, float f, float f2) {
        float f3 = (((float) (i * 10)) * this.f5029R) + ((float) (this.f5024M + (this.f5026O / 2)));
        float f4 = f3 + (10.0f * this.f5029R);
        float f5 = ((float) this.f5033a) - ((((float) (this.f5033a - this.f5021J)) / f2) * f);
        if (f5 > ((float) this.f5033a)) {
            f5 = (float) this.f5033a;
        }
        RectF rectF = new RectF();
        rectF.left = f3;
        rectF.top = f5;
        rectF.right = (this.f5029R * 8.0f) + f3;
        rectF.bottom = (float) this.f5033a;
        RectF a = m8661a(rectF);
        this.f5014C.add(i, Float.valueOf(f4));
        if (f == f2) {
            this.f5016E.set(a.left, a.top, a.right, a.bottom);
        }
        return a;
    }

    private void m8669f(Canvas canvas) {
        this.f5036d.setColor(this.f5045m);
        this.f5036d.setAntiAlias(true);
        this.f5036d.setTextSize((float) this.f5053u);
        String valueOf = String.valueOf((int) this.f5050r);
        valueOf = valueOf + getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_step);
        canvas.drawText(valueOf, (this.f5016E.left + ((this.f5016E.right - this.f5016E.left) / 2.0f)) - (this.f5036d.measureText(valueOf, 0, valueOf.length()) / 2.0f), this.f5016E.top - (((float) this.f5049q.getHeight()) / 2.0f), this.f5036d);
        canvas.drawBitmap(this.f5049q, (this.f5016E.left + ((this.f5016E.right - this.f5016E.left) / 2.0f)) - (((float) this.f5049q.getWidth()) / 2.0f), this.f5016E.top - (((float) this.f5049q.getHeight()) / 2.0f), this.f5036d);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C2538c.m12674b("NewSportDayDiagramView", "DayDiagramViewSport onTouchEvent...");
        this.f5056x = motionEvent.getX();
        this.f5057y = motionEvent.getY();
        this.f5058z = motionEvent.getAction();
        if (this.f5058z != 0 && 2 != this.f5058z) {
            this.f5032U = false;
        } else if (this.f5057y >= ((float) this.f5034b) || ((float) (this.f5024M + (this.f5026O / 2))) >= this.f5056x || ((float) (this.f5037e - (this.f5024M + (this.f5026O / 2)))) <= this.f5056x) {
            this.f5032U = false;
        } else {
            this.f5032U = true;
        }
        invalidate();
        return true;
    }
}
