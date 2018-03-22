package com.unionpay.blepayservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;

public class Channel implements Parcelable {
    public static final Creator<Channel> CREATOR = new a();
    private static final String TAG = "UPBLEPayChannel";
    private int channelID;
    private C2678d mIbleTransCMDService;
    private String selectResp;

    public Channel(int i, String str, C2678d c2678d) {
        this.channelID = i;
        this.selectResp = str;
        this.mIbleTransCMDService = c2678d;
        Log.i("union_pay", "channelID=" + i);
        Log.i("union_pay", "selectResp=" + str);
        Log.i("union_pay", "null == mIbleTransCMDService" + (this.mIbleTransCMDService == null));
    }

    public Channel(Parcel parcel) {
        this.channelID = parcel.readInt();
        this.selectResp = parcel.readString();
        this.mIbleTransCMDService = C2679e.m12793a(parcel.readStrongBinder());
        Log.i("union_pay", "null == mIbleTransCMDService" + (this.mIbleTransCMDService == null));
    }

    public void setChannelID(int i) {
        this.channelID = i;
    }

    public int getChannelID() {
        return this.channelID;
    }

    public void setResp(String str) {
        this.selectResp = str;
    }

    public String getResp() {
        return this.selectResp;
    }

    public void close() {
        try {
            if (!this.mIbleTransCMDService.mo2923b()) {
                this.mIbleTransCMDService.mo2921a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] transmit(byte[] bArr) {
        Log.i(TAG, "cmd=" + bArr);
        try {
            if (!this.mIbleTransCMDService.mo2923b()) {
                Log.i(TAG, "trans data");
                return this.mIbleTransCMDService.mo2922a(bArr);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.channelID);
        parcel.writeString(this.selectResp);
        try {
            parcel.writeStrongInterface(this.mIbleTransCMDService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
