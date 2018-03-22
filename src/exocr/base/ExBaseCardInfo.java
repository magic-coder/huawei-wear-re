package exocr.base;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcelable;

public abstract class ExBaseCardInfo implements Parcelable {
    protected Bitmap bitmap;
    protected int charCount;
    protected char[] numbers;
    protected Rect[] rects;
    protected String strNumbers;
    protected long timeend;
    protected long timestart;

    public char[] getNumbers() {
        return this.numbers;
    }

    public void setNumbers(char[] cArr) {
        if (cArr != null) {
            int length = cArr.length;
            Object obj = new char[length];
            System.arraycopy(cArr, 0, obj, 0, length);
            this.numbers = obj;
        }
    }

    public void setNumbersAtIndex(char c, int i) {
        if (this.numbers != null && i >= 0 && i < this.numbers.length) {
            this.numbers[i] = c;
        }
    }

    public void setRectsAtIndex(Rect rect, int i) {
        if (this.rects != null && i >= 0 && i < this.rects.length) {
            this.rects[i] = rect;
        }
    }

    public int getCharCount() {
        return this.charCount;
    }

    public void setCharCount(int i) {
        this.charCount = i;
    }

    public String getStrNumbers() {
        return this.strNumbers;
    }

    public void setStrNumbers() {
        if (this.numbers != null) {
            this.strNumbers = new String(this.numbers, 0, this.charCount);
        }
    }

    public void setStrNumbers(String str) {
        this.strNumbers = str;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void replaceBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.bitmap != null) {
                this.bitmap.recycle();
            }
            this.bitmap = bitmap;
        }
    }

    public long getTimestart() {
        return this.timestart;
    }

    public void setTimestart(long j) {
        this.timestart = j;
    }

    public long getTimeend() {
        return this.timeend;
    }

    public void setTimeend(long j) {
        this.timeend = j;
    }

    public String getText() {
        return ("CardNumber:" + this.strNumbers) + "\nRecoTime=" + (this.timeend - this.timestart);
    }
}
