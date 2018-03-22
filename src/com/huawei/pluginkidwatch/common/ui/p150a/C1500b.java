package com.huawei.pluginkidwatch.common.ui.p150a;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CalendarViewPager;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.Date;

/* compiled from: CalendarDialogUtil */
public class C1500b {
    private static CalendarViewPager f3511a;
    private static Dialog f3512b = null;
    private static OnClickListener f3513c = new C1504e();

    public static void m6965a(Context context, Date date, C1509k c1509k) {
        View inflate = LayoutInflater.from(context).inflate(h.dialog_common_calendar, null);
        TextView textView = (TextView) inflate.findViewById(g.dailog_calender_month_txt);
        f3511a = (CalendarViewPager) inflate.findViewById(g.dailog_calender_viewpager);
        ((ImageView) inflate.findViewById(g.calender_pre)).setOnClickListener(f3513c);
        ImageView imageView = (ImageView) inflate.findViewById(g.calender_next);
        imageView.setOnClickListener(f3513c);
        imageView.setEnabled(false);
        f3511a.m7193a(date, c1509k);
        Object a = C1485e.m6849a(date, "yyyy年MM月");
        textView.setText(a);
        if (C1485e.m6861c().startsWith(a)) {
            imageView.setEnabled(false);
        } else {
            imageView.setEnabled(true);
        }
        f3511a.setmMonthChangedListener(new C1502c(textView, imageView));
        f3512b = new C1595v(context).m7343a(inflate).m7338a();
        f3512b.setOnDismissListener(new C1503d());
        f3512b.show();
    }

    public static void m6964a() {
        if (f3512b != null && f3512b.isShowing()) {
            f3512b.cancel();
            f3512b = null;
        }
    }
}
