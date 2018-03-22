package com.huawei.pay.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.ag.c;
import com.huawei.ag.d;
import com.huawei.ag.e;
import com.huawei.ag.f;
import com.huawei.ag.h;
import java.util.ArrayList;
import java.util.Collections;

public class HwPayKeyBoardView extends LinearLayout implements OnClickListener {
    private LinearLayout digit_collapse;
    private LinearLayout digit_del;
    private TextView[] digit_tvs;
    private Context mContext;
    private boolean mIsNumberKeyShuffle;
    private KeyBoardOnClickListener mKeyBoardOnClickListener;
    private ArrayList<Integer> mNumKeyList;

    public interface KeyBoardOnClickListener {
        void onDelKeyClick();

        void onDelKeyLongClick();

        void onHideKeyClick();

        void onNumKeyClick(int i);
    }

    class C57441 implements OnLongClickListener {
        C57441() {
        }

        public boolean onLongClick(View view) {
            if (HwPayKeyBoardView.this.mKeyBoardOnClickListener != null) {
                HwPayKeyBoardView.this.mKeyBoardOnClickListener.onDelKeyLongClick();
            }
            return false;
        }
    }

    public HwPayKeyBoardView(Context context) {
        super(context);
        this.mIsNumberKeyShuffle = false;
        this.digit_tvs = new TextView[10];
        this.mContext = context;
        init();
    }

    public HwPayKeyBoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsNumberKeyShuffle = false;
        this.digit_tvs = new TextView[10];
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.hwkeybroad_attr);
        this.mIsNumberKeyShuffle = obtainStyledAttributes.getBoolean(h.hwkeybroad_attr_shuffle, false);
        obtainStyledAttributes.recycle();
        this.mContext = context;
        init();
    }

    private void init() {
        this.mNumKeyList = createNumKey();
        if (this.mIsNumberKeyShuffle) {
            Collections.shuffle(this.mNumKeyList);
        }
        initViews();
    }

    public void setKeyBoardListener(KeyBoardOnClickListener keyBoardOnClickListener) {
        if (keyBoardOnClickListener != null) {
            this.mKeyBoardOnClickListener = keyBoardOnClickListener;
        }
    }

    public boolean getNumKeyShuffle() {
        return this.mIsNumberKeyShuffle;
    }

    public void shuffleNumKey() {
        this.mIsNumberKeyShuffle = true;
        Collections.shuffle(this.mNumKeyList);
        initViews();
        requestLayout();
    }

    public void sortNumKey() {
        this.mIsNumberKeyShuffle = false;
        Collections.sort(this.mNumKeyList);
        initViews();
        requestLayout();
    }

    private void initViews() {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(f.hwpay_keyboard, this);
        this.digit_tvs[0] = (TextView) findViewById(e.digit_tv0);
        this.digit_tvs[1] = (TextView) findViewById(e.digit_tv1);
        this.digit_tvs[2] = (TextView) findViewById(e.digit_tv2);
        this.digit_tvs[3] = (TextView) findViewById(e.digit_tv3);
        this.digit_tvs[4] = (TextView) findViewById(e.digit_tv4);
        this.digit_tvs[5] = (TextView) findViewById(e.digit_tv5);
        this.digit_tvs[6] = (TextView) findViewById(e.digit_tv6);
        this.digit_tvs[7] = (TextView) findViewById(e.digit_tv7);
        this.digit_tvs[8] = (TextView) findViewById(e.digit_tv8);
        this.digit_tvs[9] = (TextView) findViewById(e.digit_tv9);
        this.digit_tvs[0].setText(this.mNumKeyList.get(0) + "");
        this.digit_tvs[1].setText(this.mNumKeyList.get(1) + "");
        this.digit_tvs[2].setText(this.mNumKeyList.get(2) + "");
        this.digit_tvs[3].setText(this.mNumKeyList.get(3) + "");
        this.digit_tvs[4].setText(this.mNumKeyList.get(4) + "");
        this.digit_tvs[5].setText(this.mNumKeyList.get(5) + "");
        this.digit_tvs[6].setText(this.mNumKeyList.get(6) + "");
        this.digit_tvs[7].setText(this.mNumKeyList.get(7) + "");
        this.digit_tvs[8].setText(this.mNumKeyList.get(8) + "");
        this.digit_tvs[9].setText(this.mNumKeyList.get(9) + "");
        this.digit_collapse = (LinearLayout) findViewById(e.digit_collapse);
        this.digit_del = (LinearLayout) findViewById(e.digit_del);
        this.digit_tvs[0].setOnClickListener(this);
        this.digit_tvs[1].setOnClickListener(this);
        this.digit_tvs[2].setOnClickListener(this);
        this.digit_tvs[3].setOnClickListener(this);
        this.digit_tvs[4].setOnClickListener(this);
        this.digit_tvs[5].setOnClickListener(this);
        this.digit_tvs[6].setOnClickListener(this);
        this.digit_tvs[7].setOnClickListener(this);
        this.digit_tvs[8].setOnClickListener(this);
        this.digit_tvs[9].setOnClickListener(this);
        this.digit_collapse.setOnClickListener(this);
        this.digit_del.setOnClickListener(this);
        this.digit_del.setOnLongClickListener(new C57441());
    }

    public void showKeyBoard() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    public void setKeyBoardLocked(boolean z) {
        int i = 0;
        if (z) {
            for (int i2 = 0; i2 < this.digit_tvs.length; i2++) {
                this.digit_tvs[i2].setClickable(false);
                this.digit_tvs[i2].setTextColor(getResources().getColor(c.huaweipay_black_a_4C));
                this.digit_tvs[i2].setBackgroundColor(getResources().getColor(c.keyboard_num_locked_color));
            }
            this.digit_collapse.setBackgroundColor(getResources().getColor(c.keyboard_num_locked_color));
            this.digit_del.setBackgroundColor(getResources().getColor(c.keyboard_num_locked_color));
        } else {
            while (i < this.digit_tvs.length) {
                this.digit_tvs[i].setClickable(true);
                this.digit_tvs[i].setTextColor(getResources().getColor(c.primarycolor));
                this.digit_tvs[i].setBackgroundDrawable(getResources().getDrawable(d.huaweipay_select_item_click));
                i++;
            }
            this.digit_collapse.setBackgroundDrawable(getResources().getDrawable(d.huaweipay_select_item_click));
            this.digit_del.setBackgroundDrawable(getResources().getDrawable(d.huaweipay_select_item_click));
        }
        invalidate();
    }

    public void onClick(View view) {
        if (view.getId() == e.digit_tv0) {
            onNumKeyClick(0);
        } else if (view.getId() == e.digit_tv1) {
            onNumKeyClick(1);
        } else if (view.getId() == e.digit_tv2) {
            onNumKeyClick(2);
        } else if (view.getId() == e.digit_tv3) {
            onNumKeyClick(3);
        } else if (view.getId() == e.digit_tv4) {
            onNumKeyClick(4);
        } else if (view.getId() == e.digit_tv5) {
            onNumKeyClick(5);
        } else if (view.getId() == e.digit_tv6) {
            onNumKeyClick(6);
        } else if (view.getId() == e.digit_tv7) {
            onNumKeyClick(7);
        } else if (view.getId() == e.digit_tv8) {
            onNumKeyClick(8);
        } else if (view.getId() == e.digit_tv9) {
            onNumKeyClick(9);
        } else if (view.getId() == e.digit_collapse) {
            setVisibility(8);
            if (this.mKeyBoardOnClickListener != null) {
                this.mKeyBoardOnClickListener.onHideKeyClick();
            }
        } else if (view.getId() == e.digit_del && this.mKeyBoardOnClickListener != null) {
            this.mKeyBoardOnClickListener.onDelKeyClick();
        }
    }

    private void onNumKeyClick(int i) {
        if (this.mKeyBoardOnClickListener != null) {
            this.mKeyBoardOnClickListener.onNumKeyClick(((Integer) this.mNumKeyList.get(i)).intValue());
        }
    }

    private ArrayList<Integer> createNumKey() {
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}
