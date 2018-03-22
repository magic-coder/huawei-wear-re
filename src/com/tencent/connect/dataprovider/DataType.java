package com.tencent.connect.dataprovider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public final class DataType {

    /* compiled from: ProGuard */
    public class TextAndMediaPath implements Parcelable {
        public static final Creator<TextAndMediaPath> CREATOR = new C6290b();
        private String f21875a;
        private String f21876b;

        public TextAndMediaPath(String str, String str2) {
            this.f21875a = str;
            this.f21876b = str2;
        }

        public String getText() {
            return this.f21875a;
        }

        public String getMediaPath() {
            return this.f21876b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f21875a);
            parcel.writeString(this.f21876b);
        }

        private TextAndMediaPath(Parcel parcel) {
            this.f21875a = parcel.readString();
            this.f21876b = parcel.readString();
        }
    }

    /* compiled from: ProGuard */
    public class TextOnly implements Parcelable {
        public static final Creator<TextOnly> CREATOR = new C6291c();
        private String f21877a;

        public TextOnly(String str) {
            this.f21877a = str;
        }

        public String getText() {
            return this.f21877a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f21877a);
        }

        private TextOnly(Parcel parcel) {
            this.f21877a = parcel.readString();
        }
    }
}
