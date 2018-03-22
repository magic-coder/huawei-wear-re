package com.unionpay.tsmservice.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.OnSafetyKeyboardCallback.Stub;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener;
import com.unionpay.tsmservice.data.NinePatchInfo;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.result.GetEncryptDataResult;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UPNewSaftyKeyboard {
    private static final int KEYBOARD_COLOR_INITVALUE = -1;
    private static final int MSG_ONSHOWLISTENER_ONEDITORCHANGED = 2;
    private static final int MSG_ONSHOWLISTENER_ONHIDE = 1;
    private static final int MSG_ONSHOWLISTENER_ONSHHOW = 0;
    private static final int TYPE_DRAWABLE_BITMAP = 0;
    private static final int TYPE_DRAWABLE_COLOR = 1;
    private static final int TYPE_DRAWABLE_ERROR = -1;
    private static final int TYPE_DRAWABLE_NINE_PATCH = 2;
    private Callback mCallback;
    private int mConfirmBtnHeight;
    private int mConfirmBtnOutRight;
    private int mConfirmBtnWidth;
    private UPTsmConnectionListener mConnectionListener;
    private Context mContext;
    private boolean mEnable;
    private boolean mEnableLightStatusBar;
    private Typeface mFont;
    private final Handler mHandler;
    private int mInnerBottom;
    private int mInnerLeft;
    private int mInnerRight;
    private int mInnerTop;
    private int mIsDefaultPosition;
    private boolean mIsKeyAudio;
    private int mKeyboardHeight;
    private int mKeyboardWidth;
    private int mMarginCol;
    private int mMarginRow;
    private boolean mMode;
    private int mNumSize;
    private int mNumberKeyColor;
    private OnEditorListener mOnEditorListener;
    private OnHideListener mOnHideListener;
    private Stub mOnSafetyKeyboardCallback;
    private OnShowListener mOnShowListener;
    private int mOutBottom;
    private int mOutLeft;
    private int mOutRight;
    private int mOutTop;
    private int mPwdSize;
    private int mSecureHeight;
    private int mSecureWidth;
    private int mStartX;
    private int mStartY;
    private String mTitle;
    private int mTitleColor;
    private int mTitleDrawablePadding;
    private int mTitleHeight;
    private int mTitleSize;
    private int mType;
    private UPTsmAddon mUPTsmAddon;
    private boolean mVibrate;

    public interface OnEditorListener {
        void onEditorChanged(int i);
    }

    class C66371 implements Callback {
        C66371() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (UPNewSaftyKeyboard.this.mOnShowListener == null) {
                        return true;
                    }
                    UPNewSaftyKeyboard.this.mOnShowListener.onShow();
                    return true;
                case 1:
                    if (UPNewSaftyKeyboard.this.mOnHideListener != null) {
                        UPNewSaftyKeyboard.this.mOnHideListener.onHide();
                    }
                    UPNewSaftyKeyboard.this.mOnSafetyKeyboardCallback = null;
                    return true;
                case 2:
                    if (UPNewSaftyKeyboard.this.mOnEditorListener == null) {
                        return true;
                    }
                    UPNewSaftyKeyboard.this.mPwdSize = message.arg1;
                    UPNewSaftyKeyboard.this.mOnEditorListener.onEditorChanged(UPNewSaftyKeyboard.this.mPwdSize);
                    return true;
                default:
                    return false;
            }
        }
    }

    class C66382 implements UPTsmConnectionListener {
        C66382() {
        }

        public void onTsmDisconnected() {
        }

        public void onTsmConnected() {
            UPNewSaftyKeyboard.this.clearPwd(UPNewSaftyKeyboard.this.mType);
        }
    }

    class KeyBoardCallback extends Stub {
        KeyBoardCallback() {
        }

        public void onShow() throws RemoteException {
            UPNewSaftyKeyboard.this.mHandler.sendEmptyMessage(0);
        }

        public void onHide() throws RemoteException {
            UPNewSaftyKeyboard.this.mHandler.sendEmptyMessage(1);
        }

        public void onEditorChanged(int i) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = i;
            UPNewSaftyKeyboard.this.mHandler.sendMessage(obtain);
        }
    }

    class KeyBoardTask extends FutureTask<String> {

        class C66391 implements Callable<String> {
            final /* synthetic */ UPNewSaftyKeyboard val$this$0;

            C66391(UPNewSaftyKeyboard uPNewSaftyKeyboard) {
                this.val$this$0 = uPNewSaftyKeyboard;
            }

            public String call() throws Exception {
                throw new IllegalStateException("this should never be called");
            }
        }

        class EncryptDataCallback extends ITsmCallback.Stub {
            EncryptDataCallback() {
            }

            public void onResult(Bundle bundle) throws RemoteException {
                bundle.setClassLoader(GetEncryptDataResult.class.getClassLoader());
                KeyBoardTask.this.set(((GetEncryptDataResult) bundle.get("result")).getData());
            }

            public void onError(String str, String str2) throws RemoteException {
                KeyBoardTask.this.set("");
            }
        }

        public KeyBoardTask() {
            super(new C66391(UPNewSaftyKeyboard.this));
        }

        private void start(String str) {
            GetEncryptDataRequestParams getEncryptDataRequestParams = new GetEncryptDataRequestParams();
            getEncryptDataRequestParams.setPan(str);
            getEncryptDataRequestParams.setType(UPNewSaftyKeyboard.this.mType);
            try {
                UPNewSaftyKeyboard.this.mUPTsmAddon.getEncryptData(getEncryptDataRequestParams, new EncryptDataCallback());
            } catch (RemoteException e) {
                e.printStackTrace();
                set("");
            }
        }

        private String getData(long j, TimeUnit timeUnit) {
            String str;
            try {
                str = (String) get(j, timeUnit);
                return str;
            } catch (InterruptedException e) {
                str = e;
                str.printStackTrace();
                return "";
            } catch (ExecutionException e2) {
                str = e2;
                str.printStackTrace();
                return "";
            } catch (TimeoutException e3) {
                str = e3;
                str.printStackTrace();
                return "";
            } finally {
                cancel(true);
            }
        }
    }

    public interface OnHideListener {
        void onHide();
    }

    public interface OnShowListener {
        void onShow();
    }

    public UPNewSaftyKeyboard(Context context, int i) throws RemoteException {
        this(context, i, null);
    }

    public UPNewSaftyKeyboard(Context context, int i, Drawable drawable) throws RemoteException {
        this.mContext = null;
        this.mKeyboardWidth = -1;
        this.mKeyboardHeight = -1;
        this.mConfirmBtnWidth = -1;
        this.mConfirmBtnHeight = -1;
        this.mTitleHeight = -1;
        this.mMarginRow = -1;
        this.mMarginCol = -1;
        this.mOutLeft = -1;
        this.mOutTop = -1;
        this.mOutRight = -1;
        this.mOutBottom = -1;
        this.mInnerLeft = -1;
        this.mInnerTop = -1;
        this.mInnerRight = -1;
        this.mInnerBottom = -1;
        this.mNumSize = -1;
        this.mConfirmBtnOutRight = -1;
        this.mStartX = 0;
        this.mStartY = 0;
        this.mIsDefaultPosition = 1;
        this.mIsKeyAudio = false;
        this.mMode = false;
        this.mEnable = true;
        this.mVibrate = false;
        this.mSecureWidth = -1;
        this.mSecureHeight = -1;
        this.mTitleDrawablePadding = -1;
        this.mTitleColor = -1;
        this.mTitleSize = -1;
        this.mNumberKeyColor = ViewCompat.MEASURED_STATE_MASK;
        this.mEnableLightStatusBar = false;
        this.mCallback = new C66371();
        this.mHandler = new Handler(Looper.getMainLooper(), this.mCallback);
        this.mContext = context;
        this.mType = i;
        if (i < 2000 || i > 2001) {
            throw new IllegalArgumentException("Type is error");
        }
        initUPTsmAddon();
        if (drawable != null) {
            try {
                setKeyboardBackground(drawable);
            } catch (KeyboardDrawableErrorException e) {
                e.printStackTrace();
            }
        }
    }

    private void initUPTsmAddon() throws RemoteException {
        this.mUPTsmAddon = UPTsmAddon.getInstance(this.mContext);
        if (this.mUPTsmAddon.isConnected()) {
            clearPwd(this.mType);
            return;
        }
        this.mConnectionListener = new C66382();
        this.mUPTsmAddon.addConnectionListener(this.mConnectionListener);
        this.mUPTsmAddon.bind();
    }

    private void clearPwd(int i) {
        if (this.mUPTsmAddon != null) {
            try {
                this.mUPTsmAddon.clearEncryptData(this.mType);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTitleText(String str) {
        this.mTitle = str;
    }

    public void setKeyBoardSize(int i, int i2) {
        this.mKeyboardWidth = i;
        this.mKeyboardHeight = i2;
    }

    public void setConfirmBtnSize(int i, int i2) {
        this.mConfirmBtnWidth = i;
        this.mConfirmBtnHeight = i2;
    }

    public void setTitleHeight(int i) {
        this.mTitleHeight = i;
    }

    public void setNumKeyMargin(int i, int i2) {
        this.mMarginRow = i;
        this.mMarginCol = i2;
    }

    public void setKeyboardPadding(int i, int i2, int i3, int i4) {
        this.mOutLeft = i;
        this.mOutTop = i2;
        this.mOutRight = i3;
        this.mOutBottom = i4;
    }

    public void setKeyAreaPadding(int i, int i2, int i3, int i4) {
        this.mInnerLeft = i;
        this.mInnerTop = i2;
        this.mInnerRight = i3;
        this.mInnerBottom = i4;
    }

    public void setNumberKeySize(int i) {
        this.mNumSize = i;
    }

    public void setConfirmBtnOutPaddingRight(int i) {
        this.mConfirmBtnOutRight = i;
    }

    public void setKeyboardStartPosition(int i, int i2) {
        this.mStartX = i;
        this.mStartY = i2;
        this.mIsDefaultPosition = 0;
    }

    public void setKeyboardBackground(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setKeyboardBgBitmap(drawableToBitamp(drawable));
                safetyKeyboardRequestParams.setKeyboardBgColor(-1);
            } else if (checkDrawable == 1) {
                safetyKeyboardRequestParams.setKeyboardBgColor(drawableToColor(drawable));
            } else if (checkDrawable == 2) {
                safetyKeyboardRequestParams.setKeyboardBgNinePatch(obtainNinePatchInfo(drawable));
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    public void setTitleBackground(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setTitleBgBitmap(drawableToBitamp(drawable));
                safetyKeyboardRequestParams.setTitleBgColor(-1);
            } else if (checkDrawable == 1) {
                safetyKeyboardRequestParams.setTitleBgColor(drawableToColor(drawable));
            } else if (checkDrawable == 2) {
                safetyKeyboardRequestParams.setTitleBgNinePatch(obtainNinePatchInfo(drawable));
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    public void setTitleDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setTitleIconBitmap(drawableToBitamp(drawable));
            } else if (checkDrawable == 1) {
                throw new KeyboardDrawableErrorException();
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    public void setTitleConfirmDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setTitleDropBitmap(drawableToBitamp(drawable));
            } else if (checkDrawable == 1) {
                throw new KeyboardDrawableErrorException();
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    private void setDoneKeyFore(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setDoneForeBitmap(drawableToBitamp(drawable));
            } else if (checkDrawable == 1) {
                throw new KeyboardDrawableErrorException();
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    private void setDoneKeyBg(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setDoneBgBitmap(drawableToBitamp(drawable));
                safetyKeyboardRequestParams.setDoneBgColor(-1);
            } else if (checkDrawable == 1) {
                safetyKeyboardRequestParams.setDoneBgColor(drawableToColor(drawable));
            } else if (checkDrawable == 2) {
                safetyKeyboardRequestParams.setDoneKeyBgNinePatch(obtainNinePatchInfo(drawable));
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    public void setDoneKeyDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            setDoneKeyFore(drawable);
        }
    }

    public void setDoneKeyDrawable(Drawable drawable, Drawable drawable2) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            setDoneKeyFore(drawable);
        }
        if (drawable2 != null) {
            setDoneKeyBg(drawable2);
        }
    }

    private void setDelKeyFore(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setDelForeBitmap(drawableToBitamp(drawable));
            } else if (checkDrawable == 1) {
                throw new KeyboardDrawableErrorException();
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    private void setDelKeyBg(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setDelBgBitmap(drawableToBitamp(drawable));
                safetyKeyboardRequestParams.setDelBgColor(-1);
            } else if (checkDrawable == 1) {
                safetyKeyboardRequestParams.setDelBgColor(drawableToColor(drawable));
            } else if (checkDrawable == 2) {
                safetyKeyboardRequestParams.setDelKeyBgNinePatch(obtainNinePatchInfo(drawable));
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    public void setDelKeyDrawable(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            setDelKeyFore(drawable);
        }
    }

    public void setDelKeyDrawable(Drawable drawable, Drawable drawable2) throws KeyboardDrawableErrorException, RemoteException {
        if (drawable != null) {
            setDelKeyFore(drawable);
        }
        if (drawable2 != null) {
            setDelKeyBg(drawable2);
        }
    }

    public void setNumberKeyDrawable(Drawable[] drawableArr) throws KeyboardDrawableErrorException, RemoteException {
        if (checkDrawables(drawableArr) == 0) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            safetyKeyboardRequestParams.setNumForeBitmaps(drawablesToBitmaps(drawableArr));
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    public void setNumKeyBackgroud(Drawable drawable) throws KeyboardDrawableErrorException, RemoteException {
        int checkDrawable = checkDrawable(drawable);
        if (checkDrawable != -1) {
            SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
            if (checkDrawable == 0) {
                safetyKeyboardRequestParams.setNumBgBitmap(drawableToBitamp(drawable));
                safetyKeyboardRequestParams.setNumBgColor(-1);
            } else if (checkDrawable == 1) {
                safetyKeyboardRequestParams.setNumBgColor(drawableToColor(drawable));
            } else if (checkDrawable == 2) {
                safetyKeyboardRequestParams.setNumKeyBgNinePatch(obtainNinePatchInfo(drawable));
            }
            setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
            return;
        }
        throw new KeyboardDrawableErrorException();
    }

    private void setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException {
        this.mUPTsmAddon.setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
    }

    public void setKeyboardAudio(boolean z) {
        this.mIsKeyAudio = z;
    }

    public void setDoneKeyRightMode(boolean z) {
        this.mMode = z;
    }

    public void setDoneKeyEnable(boolean z) {
        this.mEnable = z;
    }

    public void setKeyboardVibrate(boolean z) {
        this.mVibrate = z;
    }

    public void setTitleDrawableSize(int i, int i2) {
        this.mSecureWidth = i;
        this.mSecureHeight = i2;
    }

    public void setTitleDrawablePadding(int i) {
        this.mTitleDrawablePadding = i;
    }

    public void setTitleColor(int i) {
        this.mTitleColor = i;
    }

    public void setTitleSize(int i) {
        this.mTitleSize = i;
    }

    public void setNumberKeyColor(int i) {
        this.mNumberKeyColor = i;
    }

    public void setTitleFont(Typeface typeface) {
        this.mFont = typeface;
    }

    public void enableLightStatusBar(boolean z) {
        this.mEnableLightStatusBar = z;
    }

    public synchronized boolean show() {
        boolean z = false;
        synchronized (this) {
            if (this.mOnSafetyKeyboardCallback == null) {
                this.mOnSafetyKeyboardCallback = new KeyBoardCallback();
                try {
                    int i;
                    SafetyKeyboardRequestParams safetyKeyboardRequestParams = new SafetyKeyboardRequestParams();
                    safetyKeyboardRequestParams.setTitle(this.mTitle);
                    safetyKeyboardRequestParams.setKeyboardWidth(this.mKeyboardWidth);
                    safetyKeyboardRequestParams.setKeyboardHeight(this.mKeyboardHeight);
                    safetyKeyboardRequestParams.setConfirmBtnWidth(this.mConfirmBtnWidth);
                    safetyKeyboardRequestParams.setConfirmBtnHeight(this.mConfirmBtnHeight);
                    safetyKeyboardRequestParams.setTitleHeight(this.mTitleHeight);
                    safetyKeyboardRequestParams.setMarginRow(this.mMarginRow);
                    safetyKeyboardRequestParams.setMarginCol(this.mMarginCol);
                    safetyKeyboardRequestParams.setOutPaddingLeft(this.mOutLeft);
                    safetyKeyboardRequestParams.setOutPaddingRight(this.mOutRight);
                    safetyKeyboardRequestParams.setOutPaddingTop(this.mOutTop);
                    safetyKeyboardRequestParams.setOutPaddingBottom(this.mOutBottom);
                    safetyKeyboardRequestParams.setInnerPaddingLeft(this.mInnerLeft);
                    safetyKeyboardRequestParams.setInnerPaddingRight(this.mInnerRight);
                    safetyKeyboardRequestParams.setInnerPaddingTop(this.mInnerTop);
                    safetyKeyboardRequestParams.setInnerPaddingBottom(this.mInnerBottom);
                    safetyKeyboardRequestParams.setNumSize(this.mNumSize);
                    safetyKeyboardRequestParams.setConfirmBtnOutPaddingRight(this.mConfirmBtnOutRight);
                    safetyKeyboardRequestParams.setStartX(this.mStartX);
                    safetyKeyboardRequestParams.setStartY(this.mStartY);
                    safetyKeyboardRequestParams.setDefaultPosition(this.mIsDefaultPosition);
                    safetyKeyboardRequestParams.setIsAudio(this.mIsKeyAudio ? 1 : 0);
                    if (this.mMode) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    safetyKeyboardRequestParams.setDoneRight(i);
                    if (this.mEnable) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    safetyKeyboardRequestParams.setEnableOKBtn(i);
                    if (this.mVibrate) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    safetyKeyboardRequestParams.setIsVibrate(i);
                    safetyKeyboardRequestParams.setSecureWidth(this.mSecureWidth);
                    safetyKeyboardRequestParams.setSecureHeight(this.mSecureHeight);
                    safetyKeyboardRequestParams.setTitleDrawablePadding(this.mTitleDrawablePadding);
                    safetyKeyboardRequestParams.setTitleColor(this.mTitleColor);
                    safetyKeyboardRequestParams.setTitleSize(this.mTitleSize);
                    safetyKeyboardRequestParams.setNumberKeyColor(this.mNumberKeyColor);
                    if (this.mFont != null) {
                        safetyKeyboardRequestParams.setTitleFont(this.mFont.getStyle());
                    }
                    safetyKeyboardRequestParams.setEnableLightStatusBar(this.mEnableLightStatusBar);
                    if (this.mUPTsmAddon.showSafetyKeyboard(safetyKeyboardRequestParams, this.mType, this.mOnSafetyKeyboardCallback, this.mContext) != 0) {
                        this.mOnSafetyKeyboardCallback = null;
                    } else {
                        z = true;
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                    this.mOnSafetyKeyboardCallback = null;
                }
            }
        }
        return z;
    }

    public boolean hide() {
        int hideKeyboard;
        try {
            hideKeyboard = this.mUPTsmAddon.hideKeyboard();
        } catch (RemoteException e) {
            e.printStackTrace();
            hideKeyboard = -5;
        }
        return hideKeyboard == 0;
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    public void setOnHideListener(OnHideListener onHideListener) {
        this.mOnHideListener = onHideListener;
    }

    public void setOnEditorListener(OnEditorListener onEditorListener) {
        this.mOnEditorListener = onEditorListener;
    }

    private int checkDrawables(Drawable[] drawableArr) {
        if (drawableArr == null || drawableArr.length <= 0) {
            return -1;
        }
        for (Drawable drawable : drawableArr) {
            if (!(drawable instanceof BitmapDrawable)) {
                return -1;
            }
        }
        return 0;
    }

    private int checkDrawable(Drawable drawable) {
        if (drawable == null) {
            return -1;
        }
        if (drawable instanceof BitmapDrawable) {
            return 0;
        }
        if (drawable instanceof ColorDrawable) {
            return 1;
        }
        if (drawable instanceof NinePatchDrawable) {
            return 2;
        }
        return -1;
    }

    private ArrayList<Bitmap> drawablesToBitmaps(Drawable[] drawableArr) {
        ArrayList<Bitmap> arrayList = new ArrayList();
        for (Drawable drawable : drawableArr) {
            if (drawableToBitamp(drawable) != null) {
                arrayList.add(drawableToBitamp(drawable));
            }
        }
        return arrayList;
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }

    @SuppressLint({"NewApi"})
    private int drawableToColor(Drawable drawable) {
        return ((ColorDrawable) drawable).getColor();
    }

    public synchronized boolean clearPwd() {
        boolean z = false;
        synchronized (this) {
            int clearEncryptData;
            this.mPwdSize = 0;
            try {
                clearEncryptData = this.mUPTsmAddon.clearEncryptData(this.mType);
            } catch (RemoteException e) {
                e.printStackTrace();
                clearEncryptData = -5;
            }
            if (clearEncryptData == 0) {
                z = true;
            }
        }
        return z;
    }

    public int getCurrentPinLength() {
        return this.mPwdSize;
    }

    public String getInput() {
        return execTask("");
    }

    public String getInput(String str) {
        if (this.mType != 2000) {
            return "";
        }
        return execTask(str);
    }

    private String execTask(String str) {
        KeyBoardTask keyBoardTask = new KeyBoardTask();
        keyBoardTask.start(str);
        return keyBoardTask.getData(2000, TimeUnit.MILLISECONDS);
    }

    private NinePatchInfo obtainNinePatchInfo(Drawable drawable) {
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable;
        NinePatchInfo ninePatchInfo = new NinePatchInfo();
        Rect rect = new Rect();
        ninePatchDrawable.getPadding(rect);
        ninePatchInfo.setPadding(rect);
        ConstantState constantState = ninePatchDrawable.getConstantState();
        try {
            Field declaredField = Class.forName("android.graphics.drawable.NinePatchDrawable$NinePatchState").getDeclaredField("mNinePatch");
            declaredField.setAccessible(true);
            Bitmap bitmap = (Bitmap) Class.forName("android.graphics.NinePatch").getDeclaredMethod("getBitmap", new Class[0]).invoke(declaredField.get(constantState), new Object[0]);
            ninePatchInfo.setBitmap(bitmap);
            ninePatchInfo.setChunk(bitmap.getNinePatchChunk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ninePatchInfo;
    }
}
