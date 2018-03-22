package com.huawei.crowdtestsdk.feedback.widgets;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.huawei.androidcommon.utils.ToastUtil;
import com.huawei.crowdtestsdk.feedback.widgets.WheelView.OnWheelViewListener;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.Arrays;
import java.util.Calendar;

public class TimeDialog {
    private static final int FOOT_LEN = 10;
    private static final int HEAD_LEN = 9;
    private static String[] HOURS = new String[43];
    private static final int HOURS_LIST_BODY_LEN = 24;
    private static String[] MINS = new String[79];
    private static final int MIN_LIST_BODY_LEN = 60;
    private static final int OFFSET = 2;
    private static String[] days = null;
    private TextView btnCancel;
    private TextView btnOk;
    private Context context;
    private WheelView dayListView;
    private int hourIndex;
    private WheelView hourListView;
    private int minIndex;
    private WheelView minListView;
    private OnDismissListener onDismissListener = null;
    private OnGetTimeListener onGetTimeListener;
    private int retDay = 0;
    private int retHour = 0;
    private int retMin = 0;
    private long selectTime = -1;
    private AlertDialog timeDialog;

    public interface OnGetTimeListener {
        void onGetTime(long j);
    }

    class C07231 implements OnClickListener {
        C07231() {
        }

        public void onClick(View view) {
            TimeDialog.this.dismissDialog();
            if (TimeDialog.this.onGetTimeListener != null) {
                TimeDialog.this.onGetTimeListener.onGetTime(TimeDialog.this.getSelectTime());
            }
        }
    }

    class C07242 implements OnClickListener {
        C07242() {
        }

        public void onClick(View view) {
            TimeDialog.this.dismissDialog();
        }
    }

    class C07253 extends OnWheelViewListener {
        C07253() {
        }

        public void onSelected(int i, String str) {
            TimeDialog.this.retMin = (i - 2) - 9;
            TimeDialog.this.retMin = TimeDialog.this.checkMinWithOfRange(TimeDialog.this.retMin);
            TimeDialog.this.minIndex = TimeDialog.this.getMinIndex(TimeDialog.this.retMin);
            if (i > 2 && i < 11) {
                TimeDialog.this.minListView.setSeletion((i + 60) - 2);
                TimeDialog.this.hourListView.setSeletion(TimeDialog.access$806(TimeDialog.this));
                TimeDialog.this.retHour = TimeDialog.this.checkHourWithOfRange(TimeDialog.access$1006(TimeDialog.this));
            } else if (i >= 71) {
                TimeDialog.this.minListView.setSeletion((i - 60) - 2);
                TimeDialog.this.hourListView.setSeletion(TimeDialog.access$804(TimeDialog.this));
                TimeDialog.this.retHour = TimeDialog.this.checkHourWithOfRange(TimeDialog.access$1004(TimeDialog.this));
            }
            TimeDialog.this.checkSelectTime();
        }
    }

    class C07264 extends OnWheelViewListener {
        C07264() {
        }

        public void onSelected(int i, String str) {
            TimeDialog.this.retHour = (i - 2) - 9;
            TimeDialog.this.retHour = TimeDialog.this.checkHourWithOfRange(TimeDialog.this.retHour);
            TimeDialog.this.hourIndex = TimeDialog.this.getHourIndex(TimeDialog.this.retHour);
            if (i >= 35) {
                TimeDialog.this.hourListView.setSeletion((i - 24) - 2);
            } else if (i > 2 && i < 12) {
                TimeDialog.this.hourListView.setSeletion((i + 24) - 2);
            }
            TimeDialog.this.checkSelectTime();
        }
    }

    class C07275 extends OnWheelViewListener {
        C07275() {
        }

        public void onSelected(int i, String str) {
            C2511g.m12481b("BETACLUB_SDK", "selectedIndex: " + i + ", item: " + str);
            TimeDialog.this.retDay = i - 2;
            TimeDialog.this.checkSelectTime();
        }
    }

    static /* synthetic */ int access$1004(TimeDialog timeDialog) {
        int i = timeDialog.retHour + 1;
        timeDialog.retHour = i;
        return i;
    }

    static /* synthetic */ int access$1006(TimeDialog timeDialog) {
        int i = timeDialog.retHour - 1;
        timeDialog.retHour = i;
        return i;
    }

    static /* synthetic */ int access$804(TimeDialog timeDialog) {
        int i = timeDialog.hourIndex + 1;
        timeDialog.hourIndex = i;
        return i;
    }

    static /* synthetic */ int access$806(TimeDialog timeDialog) {
        int i = timeDialog.hourIndex - 1;
        timeDialog.hourIndex = i;
        return i;
    }

    public TimeDialog(Context context, OnGetTimeListener onGetTimeListener, OnDismissListener onDismissListener) {
        this.context = context;
        this.onGetTimeListener = onGetTimeListener;
        this.onDismissListener = onDismissListener;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.context).inflate(ResUtil.getResId(this.context, "sdk_crowdtest_layout_time_select", ResUtil.TYPE_LAYOUT), null);
        initData();
        initView(inflate);
        showDatePicker();
        showCurrentSelection();
        this.timeDialog = new Builder(this.context).create();
        if (this.onDismissListener != null) {
            this.timeDialog.setOnDismissListener(this.onDismissListener);
        }
        this.timeDialog.show();
        this.timeDialog.getWindow().setContentView(inflate);
        Window window = this.timeDialog.getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    private void initView(View view) {
        this.dayListView = (WheelView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_time_select_day", "id"));
        this.hourListView = (WheelView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_time_select_hour", "id"));
        this.minListView = (WheelView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_time_select_minute", "id"));
        this.btnOk = (TextView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_time_select_ok", "id"));
        this.btnCancel = (TextView) view.findViewById(ResUtil.getResId(this.context, "sdk_crowdtest_time_select_cancel", "id"));
        this.btnOk.setOnClickListener(new C07231());
        this.btnCancel.setOnClickListener(new C07242());
        this.hourListView.setHeadItemCount(9);
        this.hourListView.setFootItemCount(10);
        this.minListView.setHeadItemCount(9);
        this.minListView.setFootItemCount(10);
    }

    private void initData() {
        days = this.context.getResources().getStringArray(ResUtil.getResId(this.context, "sdk_crowdtest_days_array", ResUtil.TYPE_ARRAY));
        initHours();
        initMins();
    }

    private void initMins() {
        for (int i = 0; i < 79; i++) {
            int abs = Math.abs((i + 60) - 9) % 60;
            MINS[i] = String.format("%02d", new Object[]{Integer.valueOf(abs)}) + this.context.getResources().getString(ResUtil.getResId(this.context, "sdk_crowdtest_description_fragment_time_select_minute", ResUtil.TYPE_STRING));
        }
    }

    private void initHours() {
        for (int i = 0; i < 43; i++) {
            int abs = Math.abs((i + 24) - 9) % 24;
            HOURS[i] = String.format("%02d", new Object[]{Integer.valueOf(abs)}) + this.context.getResources().getString(ResUtil.getResId(this.context, "sdk_crowdtest_description_fragment_time_select_hour", ResUtil.TYPE_STRING));
        }
    }

    private void initHoursAndMins() {
        for (int i = 0; i < 60; i++) {
            if (i < 24) {
                HOURS[i] = String.format("%02d", new Object[]{Integer.valueOf(i)}) + this.context.getResources().getString(ResUtil.getResId(this.context, "sdk_crowdtest_description_fragment_time_select_hour", ResUtil.TYPE_STRING));
            }
            MINS[i] = String.format("%02d", new Object[]{Integer.valueOf(i)}) + this.context.getResources().getString(ResUtil.getResId(this.context, "sdk_crowdtest_description_fragment_time_select_minute", ResUtil.TYPE_STRING));
        }
    }

    private void showDatePicker() {
        showDayPicker();
        showHourPicker();
        showMinPicker();
    }

    private void showMinPicker() {
        this.minListView.setOffset(2);
        this.minListView.setItems(Arrays.asList(MINS));
        this.minListView.setOnWheelViewListener(new C07253());
    }

    private int checkMinWithOfRange(int i) {
        if (i < 0) {
            return i + 60;
        }
        if (i > 60) {
            return i - 60;
        }
        return i;
    }

    private void showHourPicker() {
        this.hourListView.setOffset(2);
        this.hourListView.setItems(Arrays.asList(HOURS));
        this.hourListView.setOnWheelViewListener(new C07264());
    }

    private int checkHourWithOfRange(int i) {
        if (i < 0) {
            return i + 24;
        }
        if (i > 23) {
            return i - 24;
        }
        return i;
    }

    private void showDayPicker() {
        this.dayListView.setOffset(2);
        this.dayListView.setItems(Arrays.asList(days));
        this.dayListView.setOnWheelViewListener(new C07275());
    }

    private void showCurrentSelection() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(11);
        int i2 = instance.get(12);
        C2511g.m12481b("BETACLUB_SDK", "[TimeDialog.showCurrentSelection] hour:==" + i + "+==min==" + i2);
        this.retHour = i;
        this.retMin = i2;
        this.hourIndex = getHourIndex(i);
        this.minIndex = getMinIndex(i2);
        C2511g.m12481b("BETACLUB_SDK", i + "/" + i2);
        if (i >= 0 && i <= 23) {
            this.hourListView.setSeletion(i + 9);
        }
        if (i2 >= 0 && i2 <= 59) {
            this.minListView.setSeletion(i2 + 9);
        }
    }

    private int getMinIndex(int i) {
        return i + 9;
    }

    private int getHourIndex(int i) {
        return i + 9;
    }

    private void checkSelectTime() {
        this.selectTime = getSelectTime();
        if (this.selectTime > System.currentTimeMillis()) {
            ToastUtil.showShortToast(this.context, (CharSequence) "选择时间非法");
            showCurrentSelection();
            this.selectTime = -1;
        }
    }

    private long getSelectTime() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(11);
        int i2 = instance.get(12);
        long currentTimeMillis = System.currentTimeMillis() - ((long) ((instance.get(13) + (((i * 60) + i2) * 60)) * 1000));
        int i3 = this.retMin;
        if (this.minIndex >= 69) {
            i3 = this.minIndex - 69;
        }
        if (this.retDay == 1) {
            return ((((((long) i3) + (((long) this.retHour) * 60)) * 60) * 1000) + currentTimeMillis) - 86400000;
        } else if (this.retDay == 2) {
            return ((((((long) i3) + (((long) this.retHour) * 60)) * 60) * 1000) + currentTimeMillis) - 172800000;
        } else {
            return (((((long) i3) + (((long) this.retHour) * 60)) * 60) * 1000) + currentTimeMillis;
        }
    }

    private void dismissDialog() {
        if (this.timeDialog != null && this.timeDialog.isShowing()) {
            this.timeDialog.dismiss();
        }
    }
}
