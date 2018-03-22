package com.huawei.nfc.carrera.ui.widget;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.wheelview.C5691c;
import com.huawei.ui.commonui.wheelview.C6056a;
import com.huawei.ui.commonui.wheelview.WheelView;
import com.huawei.wallet.R;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ValidDatePickerDialog implements C5691c {
    private static final String TAG = "ValidDatePickerDialog";
    private OnDateSetListener mCallBack;
    private Context mContext;
    private C6056a mDateWheelView;
    private int mMonth = 0;
    private C6002a mSetingDateDialog = null;
    private int mYear = 0;

    class C56891 implements OnClickListener {
        C56891() {
        }

        public void onClick(View view) {
            C2538c.c(ValidDatePickerDialog.TAG, new Object[]{"==valid date set mYear : " + ValidDatePickerDialog.this.mYear + " ; mMonth : " + ValidDatePickerDialog.this.mMonth});
            ValidDatePickerDialog.this.mCallBack.onDateSet(null, ValidDatePickerDialog.this.mYear, ValidDatePickerDialog.this.mMonth, 0);
            ValidDatePickerDialog.this.mSetingDateDialog.dismiss();
            ValidDatePickerDialog.this.mSetingDateDialog = null;
        }
    }

    class C56902 implements OnClickListener {
        C56902() {
        }

        public void onClick(View view) {
            C2538c.c(ValidDatePickerDialog.TAG, new Object[]{"==valid date Negative "});
            ValidDatePickerDialog.this.mSetingDateDialog.dismiss();
            ValidDatePickerDialog.this.mSetingDateDialog = null;
        }
    }

    public ValidDatePickerDialog(Context context, OnDateSetListener onDateSetListener, String str) {
        this.mContext = context;
        this.mCallBack = onDateSetListener;
        C2538c.c(TAG, new Object[]{"==valid date  enter ValidDatePickerDialog"});
        C2538c.c(TAG, new Object[]{"==valid date  dateInfomation : " + str});
        this.mDateWheelView = new C6056a(context, 3);
        this.mDateWheelView.m27720a(-2130706433, -15884293);
        String str2 = "";
        str2 = "";
        str2 = "";
        if (!dateLegal(str)) {
            str = ((Calendar.getInstance().get(1) + 1) + "") + GetTransElementsRequestParams.TRANS_TYPE_DOWNLOAD_APPLY;
        }
        str2 = d.c(this.mContext, str.substring(0, 4)) + "";
        String str3 = d.c(this.mContext, str.substring(4, 6)) + "";
        C2538c.c(TAG, new Object[]{"==valid date refresh dateInfomation : " + str});
        this.mDateWheelView.m27721a(str2, str3, "01");
        this.mDateWheelView.setOnWheelChangedListener(this);
        this.mDateWheelView.m27725c();
        C6002a c6002a = new C6002a(context, R.style.app_update_dialogActivity);
        this.mSetingDateDialog = C6002a.m27471d(context);
        this.mSetingDateDialog.m27475a(this.mDateWheelView.getView());
        this.mYear = d.a(str2);
        this.mMonth = d.a(str3);
        updateTitle(this.mYear, this.mMonth);
        this.mSetingDateDialog.m27477a(context.getString(R.string.IDS_settings_button_ok), new C56891());
        this.mSetingDateDialog.m27480b(context.getString(R.string.IDS_settings_button_cancal), new C56902());
    }

    public void show() {
        if (this.mSetingDateDialog != null && !this.mSetingDateDialog.isShowing()) {
            this.mSetingDateDialog.m27481c();
        }
    }

    public boolean isShow() {
        if (this.mSetingDateDialog != null) {
            return this.mSetingDateDialog.isShowing();
        }
        return false;
    }

    public void onChanged(WheelView wheelView, int i, int i2) {
        this.mYear = d.c(this.mContext, this.mDateWheelView.getFisrtPickerValue());
        this.mMonth = d.c(this.mContext, this.mDateWheelView.getSecondPickerValue());
        C2538c.c(TAG, new Object[]{"==valid date onChanged mYear : " + this.mYear + " ; mMonth : " + this.mMonth});
        updateTitle(this.mYear, this.mMonth);
    }

    private void updateTitle(int i, int i2) {
        if (this.mSetingDateDialog != null) {
            Calendar instance = Calendar.getInstance();
            instance.set(1, i);
            instance.set(2, i2 - 1);
            String formatDateTime = DateUtils.formatDateTime(this.mContext, instance.getTimeInMillis(), 65572);
            C2538c.c(TAG, new Object[]{"==valid date  updateTitle :" + formatDateTime});
            this.mSetingDateDialog.m27483d(formatDateTime);
        }
    }

    private boolean dateLegal(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
