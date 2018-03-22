package com.unionpay.tsmservice.request;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import com.unionpay.tsmservice.data.NinePatchInfo;
import java.util.ArrayList;

public class SafetyKeyboardRequestParams extends RequestParams {
    public static final Creator<SafetyKeyboardRequestParams> CREATOR = new C66031();
    private int mConfirmBtnHeight = -1;
    private int mConfirmBtnOutPaddingRight = -1;
    private int mConfirmBtnWidth = -1;
    private Bitmap mDelBgBitmap;
    private int mDelBgColor = -1;
    private Bitmap mDelForeBitmap;
    private Bitmap mDoneBgBitmap;
    private int mDoneBgColor = -1;
    private Bitmap mDoneForeBitmap;
    private int mDoneRight = 0;
    private boolean mEnableLightStatusBar = false;
    private int mEnableOKBtn = 1;
    private int mInnerPaddingBottom = -1;
    private int mInnerPaddingLeft = -1;
    private int mInnerPaddingRight = -1;
    private int mInnerPaddingTop = -1;
    private int mIsAudio = 0;
    private int mIsDefaultPosition = 1;
    private int mIsVibrate = 0;
    private Bitmap mKeyboardBgBitmap;
    private int mKeyboardBgColor = -1;
    private int mKeyboardHeight = -1;
    private int mKeyboardWidth = -1;
    private int mMarginCol = -1;
    private int mMarginRow = -1;
    private NinePatchInfo mNinePatchBackground;
    private NinePatchInfo mNinePatchDelKeyBg;
    private NinePatchInfo mNinePatchDoneKeyBg;
    private NinePatchInfo mNinePatchNumKeyBg;
    private NinePatchInfo mNinePatchTitleBg;
    private Bitmap mNumBgBitmap;
    private int mNumBgColor = -1;
    private ArrayList<Bitmap> mNumForeBitmaps;
    private int mNumSize = -1;
    private int mNumberKeyColor = ViewCompat.MEASURED_STATE_MASK;
    private int mOutPaddingBottom = -1;
    private int mOutPaddingLeft = -1;
    private int mOutPaddingRight = -1;
    private int mOutPaddingTop = -1;
    private int mSecureHeight = -1;
    private int mSecureWidth = -1;
    private int mStartX = 0;
    private int mStartY = 0;
    private String mTitle;
    private Bitmap mTitleBgBitmap;
    private int mTitleBgColor = -1;
    private int mTitleColor = -1;
    private int mTitleDrawablePadding = -1;
    private Bitmap mTitleDropBitmap;
    private int mTitleFont;
    private int mTitleHeight = -1;
    private Bitmap mTitleIconBitmap;
    private int mTitleSize = -1;

    final class C66031 implements Creator<SafetyKeyboardRequestParams> {
        C66031() {
        }

        public SafetyKeyboardRequestParams createFromParcel(Parcel parcel) {
            return new SafetyKeyboardRequestParams(parcel);
        }

        public SafetyKeyboardRequestParams[] newArray(int i) {
            return new SafetyKeyboardRequestParams[i];
        }
    }

    public SafetyKeyboardRequestParams(Parcel parcel) {
        boolean z;
        this.mTitle = parcel.readString();
        this.mKeyboardWidth = parcel.readInt();
        this.mKeyboardHeight = parcel.readInt();
        this.mTitleHeight = parcel.readInt();
        this.mMarginRow = parcel.readInt();
        this.mMarginCol = parcel.readInt();
        this.mOutPaddingLeft = parcel.readInt();
        this.mOutPaddingTop = parcel.readInt();
        this.mOutPaddingRight = parcel.readInt();
        this.mOutPaddingBottom = parcel.readInt();
        this.mInnerPaddingLeft = parcel.readInt();
        this.mInnerPaddingTop = parcel.readInt();
        this.mInnerPaddingRight = parcel.readInt();
        this.mInnerPaddingBottom = parcel.readInt();
        this.mConfirmBtnOutPaddingRight = parcel.readInt();
        this.mConfirmBtnWidth = parcel.readInt();
        this.mConfirmBtnHeight = parcel.readInt();
        this.mStartX = parcel.readInt();
        this.mStartY = parcel.readInt();
        this.mIsDefaultPosition = parcel.readInt();
        this.mNumSize = parcel.readInt();
        this.mKeyboardBgBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mTitleBgBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mTitleIconBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mTitleDropBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mDoneForeBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mDoneBgBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mDelForeBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mDelBgBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mNumBgBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.mNumForeBitmaps = parcel.readArrayList(ArrayList.class.getClassLoader());
        this.mKeyboardBgColor = parcel.readInt();
        this.mTitleBgColor = parcel.readInt();
        this.mDoneBgColor = parcel.readInt();
        this.mDelBgColor = parcel.readInt();
        this.mNumBgColor = parcel.readInt();
        this.mIsAudio = parcel.readInt();
        this.mEnableOKBtn = parcel.readInt();
        this.mDoneRight = parcel.readInt();
        this.mIsVibrate = parcel.readInt();
        this.mSecureWidth = parcel.readInt();
        this.mSecureHeight = parcel.readInt();
        this.mTitleDrawablePadding = parcel.readInt();
        this.mTitleColor = parcel.readInt();
        this.mTitleSize = parcel.readInt();
        this.mNumberKeyColor = parcel.readInt();
        this.mNinePatchBackground = (NinePatchInfo) parcel.readParcelable(NinePatchInfo.class.getClassLoader());
        this.mNinePatchDelKeyBg = (NinePatchInfo) parcel.readParcelable(NinePatchInfo.class.getClassLoader());
        this.mNinePatchDoneKeyBg = (NinePatchInfo) parcel.readParcelable(NinePatchInfo.class.getClassLoader());
        this.mNinePatchNumKeyBg = (NinePatchInfo) parcel.readParcelable(NinePatchInfo.class.getClassLoader());
        this.mNinePatchTitleBg = (NinePatchInfo) parcel.readParcelable(NinePatchInfo.class.getClassLoader());
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.mEnableLightStatusBar = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mTitle);
        parcel.writeInt(this.mKeyboardWidth);
        parcel.writeInt(this.mKeyboardHeight);
        parcel.writeInt(this.mTitleHeight);
        parcel.writeInt(this.mMarginRow);
        parcel.writeInt(this.mMarginCol);
        parcel.writeInt(this.mOutPaddingLeft);
        parcel.writeInt(this.mOutPaddingTop);
        parcel.writeInt(this.mOutPaddingRight);
        parcel.writeInt(this.mOutPaddingBottom);
        parcel.writeInt(this.mInnerPaddingLeft);
        parcel.writeInt(this.mInnerPaddingTop);
        parcel.writeInt(this.mInnerPaddingRight);
        parcel.writeInt(this.mInnerPaddingBottom);
        parcel.writeInt(this.mConfirmBtnOutPaddingRight);
        parcel.writeInt(this.mConfirmBtnWidth);
        parcel.writeInt(this.mConfirmBtnHeight);
        parcel.writeInt(this.mStartX);
        parcel.writeInt(this.mStartY);
        parcel.writeInt(this.mIsDefaultPosition);
        parcel.writeInt(this.mNumSize);
        parcel.writeParcelable(this.mKeyboardBgBitmap, 0);
        parcel.writeParcelable(this.mTitleBgBitmap, 0);
        parcel.writeParcelable(this.mTitleIconBitmap, 0);
        parcel.writeParcelable(this.mTitleDropBitmap, 0);
        parcel.writeParcelable(this.mDoneForeBitmap, 0);
        parcel.writeParcelable(this.mDoneBgBitmap, 0);
        parcel.writeParcelable(this.mDelForeBitmap, 0);
        parcel.writeParcelable(this.mDelBgBitmap, 0);
        parcel.writeParcelable(this.mNumBgBitmap, 0);
        parcel.writeList(this.mNumForeBitmaps);
        parcel.writeInt(this.mKeyboardBgColor);
        parcel.writeInt(this.mTitleBgColor);
        parcel.writeInt(this.mDoneBgColor);
        parcel.writeInt(this.mDelBgColor);
        parcel.writeInt(this.mNumBgColor);
        parcel.writeInt(this.mIsAudio);
        parcel.writeInt(this.mEnableOKBtn);
        parcel.writeInt(this.mDoneRight);
        parcel.writeInt(this.mIsVibrate);
        parcel.writeInt(this.mSecureWidth);
        parcel.writeInt(this.mSecureHeight);
        parcel.writeInt(this.mTitleDrawablePadding);
        parcel.writeInt(this.mTitleColor);
        parcel.writeInt(this.mTitleSize);
        parcel.writeInt(this.mNumberKeyColor);
        parcel.writeParcelable(this.mNinePatchBackground, i);
        parcel.writeParcelable(this.mNinePatchDelKeyBg, i);
        parcel.writeParcelable(this.mNinePatchDoneKeyBg, i);
        parcel.writeParcelable(this.mNinePatchNumKeyBg, i);
        parcel.writeParcelable(this.mNinePatchTitleBg, i);
        if (!this.mEnableLightStatusBar) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public int getKeyboardWidth() {
        return this.mKeyboardWidth;
    }

    public void setKeyboardWidth(int i) {
        this.mKeyboardWidth = i;
    }

    public int getKeyboardHeight() {
        return this.mKeyboardHeight;
    }

    public void setKeyboardHeight(int i) {
        this.mKeyboardHeight = i;
    }

    public int getConfirmBtnWidth() {
        return this.mConfirmBtnWidth;
    }

    public void setConfirmBtnWidth(int i) {
        this.mConfirmBtnWidth = i;
    }

    public int getConfirmBtnHeight() {
        return this.mConfirmBtnHeight;
    }

    public void setConfirmBtnHeight(int i) {
        this.mConfirmBtnHeight = i;
    }

    public int getTitleHeight() {
        return this.mTitleHeight;
    }

    public void setTitleHeight(int i) {
        this.mTitleHeight = i;
    }

    public int getMarginRow() {
        return this.mMarginRow;
    }

    public void setMarginRow(int i) {
        this.mMarginRow = i;
    }

    public int getMarginCol() {
        return this.mMarginCol;
    }

    public void setMarginCol(int i) {
        this.mMarginCol = i;
    }

    public int getOutPaddingLeft() {
        return this.mOutPaddingLeft;
    }

    public void setOutPaddingLeft(int i) {
        this.mOutPaddingLeft = i;
    }

    public int getOutPaddingTop() {
        return this.mOutPaddingTop;
    }

    public void setOutPaddingTop(int i) {
        this.mOutPaddingTop = i;
    }

    public int getOutPaddingRight() {
        return this.mOutPaddingRight;
    }

    public void setOutPaddingRight(int i) {
        this.mOutPaddingRight = i;
    }

    public int getOutPaddingBottom() {
        return this.mOutPaddingBottom;
    }

    public void setOutPaddingBottom(int i) {
        this.mOutPaddingBottom = i;
    }

    public int getInnerPaddingLeft() {
        return this.mInnerPaddingLeft;
    }

    public void setInnerPaddingLeft(int i) {
        this.mInnerPaddingLeft = i;
    }

    public int getInnerPaddingTop() {
        return this.mInnerPaddingTop;
    }

    public void setInnerPaddingTop(int i) {
        this.mInnerPaddingTop = i;
    }

    public int getInnerPaddingRight() {
        return this.mInnerPaddingRight;
    }

    public void setInnerPaddingRight(int i) {
        this.mInnerPaddingRight = i;
    }

    public int getInnerPaddingBottom() {
        return this.mInnerPaddingBottom;
    }

    public void setInnerPaddingBottom(int i) {
        this.mInnerPaddingBottom = i;
    }

    public int getConfirmBtnOutPaddingRight() {
        return this.mConfirmBtnOutPaddingRight;
    }

    public void setConfirmBtnOutPaddingRight(int i) {
        this.mConfirmBtnOutPaddingRight = i;
    }

    public int getNumSize() {
        return this.mNumSize;
    }

    public void setNumSize(int i) {
        this.mNumSize = i;
    }

    public Bitmap getKeyboardBgBitmap() {
        return this.mKeyboardBgBitmap;
    }

    public void setKeyboardBgBitmap(Bitmap bitmap) {
        this.mKeyboardBgBitmap = bitmap;
    }

    public Bitmap getTitleBgBitmap() {
        return this.mTitleBgBitmap;
    }

    public void setTitleBgBitmap(Bitmap bitmap) {
        this.mTitleBgBitmap = bitmap;
    }

    public Bitmap getTitleIconBitmap() {
        return this.mTitleIconBitmap;
    }

    public void setTitleIconBitmap(Bitmap bitmap) {
        this.mTitleIconBitmap = bitmap;
    }

    public Bitmap getTitleDropBitmap() {
        return this.mTitleDropBitmap;
    }

    public void setTitleDropBitmap(Bitmap bitmap) {
        this.mTitleDropBitmap = bitmap;
    }

    public Bitmap getDoneForeBitmap() {
        return this.mDoneForeBitmap;
    }

    public void setDoneForeBitmap(Bitmap bitmap) {
        this.mDoneForeBitmap = bitmap;
    }

    public Bitmap getDoneBgBitmap() {
        return this.mDoneBgBitmap;
    }

    public void setDoneBgBitmap(Bitmap bitmap) {
        this.mDoneBgBitmap = bitmap;
    }

    public Bitmap getDelForeBitmap() {
        return this.mDelForeBitmap;
    }

    public void setDelForeBitmap(Bitmap bitmap) {
        this.mDelForeBitmap = bitmap;
    }

    public Bitmap getDelBgBitmap() {
        return this.mDelBgBitmap;
    }

    public void setDelBgBitmap(Bitmap bitmap) {
        this.mDelBgBitmap = bitmap;
    }

    public Bitmap getNumBgBitmap() {
        return this.mNumBgBitmap;
    }

    public void setNumBgBitmap(Bitmap bitmap) {
        this.mNumBgBitmap = bitmap;
    }

    public ArrayList<Bitmap> getNumForeBitmaps() {
        return this.mNumForeBitmaps;
    }

    public void setNumForeBitmaps(ArrayList<Bitmap> arrayList) {
        this.mNumForeBitmaps = arrayList;
    }

    public int getKeyboardBgColor() {
        return this.mKeyboardBgColor;
    }

    public void setKeyboardBgColor(int i) {
        this.mKeyboardBgColor = i;
    }

    public int getTitleBgColor() {
        return this.mTitleBgColor;
    }

    public void setTitleBgColor(int i) {
        this.mTitleBgColor = i;
    }

    public int getDoneBgColor() {
        return this.mDoneBgColor;
    }

    public void setDoneBgColor(int i) {
        this.mDoneBgColor = i;
    }

    public int getDelBgColor() {
        return this.mDelBgColor;
    }

    public void setDelBgColor(int i) {
        this.mDelBgColor = i;
    }

    public int getNumBgColor() {
        return this.mNumBgColor;
    }

    public void setNumBgColor(int i) {
        this.mNumBgColor = i;
    }

    public int getIsAudio() {
        return this.mIsAudio;
    }

    public void setIsAudio(int i) {
        this.mIsAudio = i;
    }

    public int getIsVibrate() {
        return this.mIsVibrate;
    }

    public void setIsVibrate(int i) {
        this.mIsVibrate = i;
    }

    public int getEnableOKBtn() {
        return this.mEnableOKBtn;
    }

    public void setEnableOKBtn(int i) {
        this.mEnableOKBtn = i;
    }

    public int getDoneRight() {
        return this.mDoneRight;
    }

    public void setDoneRight(int i) {
        this.mDoneRight = i;
    }

    public int getSecureWidth() {
        return this.mSecureWidth;
    }

    public void setSecureWidth(int i) {
        this.mSecureWidth = i;
    }

    public int getSecureHeight() {
        return this.mSecureHeight;
    }

    public void setSecureHeight(int i) {
        this.mSecureHeight = i;
    }

    public int getTitleDrawablePadding() {
        return this.mTitleDrawablePadding;
    }

    public void setTitleDrawablePadding(int i) {
        this.mTitleDrawablePadding = i;
    }

    public int getTitleColor() {
        return this.mTitleColor;
    }

    public void setTitleColor(int i) {
        this.mTitleColor = i;
    }

    public int getTitleSize() {
        return this.mTitleSize;
    }

    public void setTitleSize(int i) {
        this.mTitleSize = i;
    }

    public int getNumberKeyColor() {
        return this.mNumberKeyColor;
    }

    public void setNumberKeyColor(int i) {
        this.mNumberKeyColor = i;
    }

    public int getTitleFont() {
        return this.mTitleFont;
    }

    public void setTitleFont(int i) {
        this.mTitleFont = i;
    }

    public NinePatchInfo getKeyboardBgNinePatch() {
        return this.mNinePatchBackground;
    }

    public void setKeyboardBgNinePatch(NinePatchInfo ninePatchInfo) {
        this.mNinePatchBackground = ninePatchInfo;
    }

    public int getStartX() {
        return this.mStartX;
    }

    public void setStartX(int i) {
        this.mStartX = i;
    }

    public int getStartY() {
        return this.mStartY;
    }

    public void setStartY(int i) {
        this.mStartY = i;
    }

    public int getDefaultPosition() {
        return this.mIsDefaultPosition;
    }

    public void setDefaultPosition(int i) {
        this.mIsDefaultPosition = i;
    }

    public boolean isEnableLightStatusBar() {
        return this.mEnableLightStatusBar;
    }

    public void setEnableLightStatusBar(boolean z) {
        this.mEnableLightStatusBar = z;
    }

    public NinePatchInfo getDelKeyBgNinePatch() {
        return this.mNinePatchDelKeyBg;
    }

    public void setDelKeyBgNinePatch(NinePatchInfo ninePatchInfo) {
        this.mNinePatchDelKeyBg = ninePatchInfo;
    }

    public NinePatchInfo getDoneKeyBgNinePatch() {
        return this.mNinePatchDoneKeyBg;
    }

    public void setDoneKeyBgNinePatch(NinePatchInfo ninePatchInfo) {
        this.mNinePatchDoneKeyBg = ninePatchInfo;
    }

    public NinePatchInfo getNumKeyBgNinePatch() {
        return this.mNinePatchNumKeyBg;
    }

    public void setNumKeyBgNinePatch(NinePatchInfo ninePatchInfo) {
        this.mNinePatchNumKeyBg = ninePatchInfo;
    }

    public NinePatchInfo getTitleBgNinePatch() {
        return this.mNinePatchTitleBg;
    }

    public void setTitleBgNinePatch(NinePatchInfo ninePatchInfo) {
        this.mNinePatchTitleBg = ninePatchInfo;
    }
}
