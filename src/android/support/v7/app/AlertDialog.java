package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertController.AlertParams;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    private AlertController mAlert;

    public class Builder {
        private final AlertParams f111P;
        private int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(Context context, int i) {
            this.f111P = new AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.f111P.mContext;
        }

        public Builder setTitle(int i) {
            this.f111P.mTitle = this.f111P.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f111P.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f111P.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            this.f111P.mMessage = this.f111P.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f111P.mMessage = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.f111P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f111P.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f111P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f111P.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
            this.f111P.mPositiveButtonText = this.f111P.mContext.getText(i);
            this.f111P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f111P.mPositiveButtonText = charSequence;
            this.f111P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
            this.f111P.mNegativeButtonText = this.f111P.mContext.getText(i);
            this.f111P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f111P.mNegativeButtonText = charSequence;
            this.f111P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, OnClickListener onClickListener) {
            this.f111P.mNeutralButtonText = this.f111P.mContext.getText(i);
            this.f111P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f111P.mNeutralButtonText = charSequence;
            this.f111P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f111P.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f111P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f111P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.f111P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, OnClickListener onClickListener) {
            this.f111P.mItems = this.f111P.mContext.getResources().getTextArray(i);
            this.f111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f111P.mItems = charSequenceArr;
            this.f111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f111P.mAdapter = listAdapter;
            this.f111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, OnClickListener onClickListener, String str) {
            this.f111P.mCursor = cursor;
            this.f111P.mLabelColumn = str;
            this.f111P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f111P.mItems = this.f111P.mContext.getResources().getTextArray(i);
            this.f111P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f111P.mCheckedItems = zArr;
            this.f111P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f111P.mItems = charSequenceArr;
            this.f111P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f111P.mCheckedItems = zArr;
            this.f111P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f111P.mCursor = cursor;
            this.f111P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f111P.mIsCheckedColumn = str;
            this.f111P.mLabelColumn = str2;
            this.f111P.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, OnClickListener onClickListener) {
            this.f111P.mItems = this.f111P.mContext.getResources().getTextArray(i);
            this.f111P.mOnClickListener = onClickListener;
            this.f111P.mCheckedItem = i2;
            this.f111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, OnClickListener onClickListener) {
            this.f111P.mCursor = cursor;
            this.f111P.mOnClickListener = onClickListener;
            this.f111P.mCheckedItem = i;
            this.f111P.mLabelColumn = str;
            this.f111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
            this.f111P.mItems = charSequenceArr;
            this.f111P.mOnClickListener = onClickListener;
            this.f111P.mCheckedItem = i;
            this.f111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, OnClickListener onClickListener) {
            this.f111P.mAdapter = listAdapter;
            this.f111P.mOnClickListener = onClickListener;
            this.f111P.mCheckedItem = i;
            this.f111P.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
            this.f111P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.f111P.mView = null;
            this.f111P.mViewLayoutResId = i;
            this.f111P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f111P.mView = view;
            this.f111P.mViewLayoutResId = 0;
            this.f111P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f111P.mView = view;
            this.f111P.mViewLayoutResId = 0;
            this.f111P.mViewSpacingSpecified = true;
            this.f111P.mViewSpacingLeft = i;
            this.f111P.mViewSpacingTop = i2;
            this.f111P.mViewSpacingRight = i3;
            this.f111P.mViewSpacingBottom = i4;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean z) {
            this.f111P.mForceInverseBackground = z;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f111P.mRecycleOnMeasure = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f111P.mContext, this.mTheme, false);
            this.f111P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.f111P.mCancelable);
            if (this.f111P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f111P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f111P.mOnDismissListener);
            if (this.f111P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f111P.mOnKeyListener);
            }
            return alertDialog;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }

    protected AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
    }

    protected AlertDialog(Context context, int i) {
        this(context, i, true);
    }

    AlertDialog(Context context, int i, boolean z) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, OnCancelListener onCancelListener) {
        super(context, resolveDialogTheme(context, 0));
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.mAlert = new AlertController(context, this, getWindow());
    }

    static int resolveDialogTheme(Context context, int i) {
        if (i >= ViewCompat.MEASURED_STATE_TOO_SMALL) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }

    void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, null, message);
    }

    public void setButton(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mAlert.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
