package com.huawei.lcagent.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ILogCollect$Stub extends Binder implements ILogCollect {
    private static final String DESCRIPTOR = "com.huawei.lcagent.client.ILogCollect";
    static final int TRANSACTION_allowUploadAlways = 10;
    static final int TRANSACTION_allowUploadInMobileNetwork = 9;
    static final int TRANSACTION_captureAllLog = 15;
    static final int TRANSACTION_captureLogMetric = 6;
    static final int TRANSACTION_clearLogMetric = 7;
    static final int TRANSACTION_configure = 14;
    static final int TRANSACTION_configureAPlogs = 22;
    static final int TRANSACTION_configureBluetoothlogcat = 20;
    static final int TRANSACTION_configureCoredump = 23;
    static final int TRANSACTION_configureGPS = 24;
    static final int TRANSACTION_configureLogcat = 21;
    static final int TRANSACTION_configureModemlogcat = 19;
    static final int TRANSACTION_configureUserType = 11;
    static final int TRANSACTION_configureWithPara = 25;
    static final int TRANSACTION_feedbackUploadResult = 8;
    static final int TRANSACTION_forceUpload = 13;
    static final int TRANSACTION_getCompressInfo = 26;
    static final int TRANSACTION_getFirstErrorTime = 16;
    static final int TRANSACTION_getFirstErrorType = 18;
    static final int TRANSACTION_getUserType = 12;
    static final int TRANSACTION_resetFirstErrorTime = 17;
    static final int TRANSACTION_setMetricCommonHeader = 2;
    static final int TRANSACTION_setMetricStoargeHeader = 1;
    static final int TRANSACTION_setMetricStoargeTail = 3;
    static final int TRANSACTION_shouldSubmitMetric = 5;
    static final int TRANSACTION_submitMetric = 4;

    class Proxy implements ILogCollect {
        private IBinder mRemote;

        Proxy(IBinder iBinder) {
            this.mRemote = iBinder;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public String getInterfaceDescriptor() {
            return ILogCollect$Stub.DESCRIPTOR;
        }

        public int setMetricStoargeHeader(int i, byte[] bArr, int i2) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeByteArray(bArr);
                obtain.writeInt(i2);
                this.mRemote.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int setMetricCommonHeader(int i, byte[] bArr, int i2) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeByteArray(bArr);
                obtain.writeInt(i2);
                this.mRemote.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int setMetricStoargeTail(int i, byte[] bArr, int i2) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeByteArray(bArr);
                obtain.writeInt(i2);
                this.mRemote.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int submitMetric(int i, int i2, byte[] bArr, int i3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                obtain.writeByteArray(bArr);
                obtain.writeInt(i3);
                this.mRemote.transact(4, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean shouldSubmitMetric(int i, int i2) {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeInt(i2);
                this.mRemote.transact(5, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public LogMetricInfo captureLogMetric(int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                LogMetricInfo logMetricInfo;
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                this.mRemote.transact(6, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    logMetricInfo = (LogMetricInfo) LogMetricInfo.CREATOR.createFromParcel(obtain2);
                } else {
                    logMetricInfo = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return logMetricInfo;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void clearLogMetric(long j) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeLong(j);
                this.mRemote.transact(7, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int feedbackUploadResult(long j, int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeLong(j);
                obtain.writeInt(i);
                this.mRemote.transact(8, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int allowUploadInMobileNetwork(boolean z) {
            int i = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                if (z) {
                    i = 1;
                }
                obtain.writeInt(i);
                this.mRemote.transact(9, obtain, obtain2, 0);
                obtain2.readException();
                i = obtain2.readInt();
                return i;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int allowUploadAlways(boolean z) {
            int i = 0;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                if (z) {
                    i = 1;
                }
                obtain.writeInt(i);
                this.mRemote.transact(10, obtain, obtain2, 0);
                obtain2.readException();
                i = obtain2.readInt();
                return i;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configureUserType(int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                this.mRemote.transact(11, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getUserType() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                this.mRemote.transact(12, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int forceUpload() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                this.mRemote.transact(13, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configure(String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(14, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public LogMetricInfo captureAllLog() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                LogMetricInfo logMetricInfo;
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                this.mRemote.transact(15, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    logMetricInfo = (LogMetricInfo) LogMetricInfo.CREATOR.createFromParcel(obtain2);
                } else {
                    logMetricInfo = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return logMetricInfo;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public long getFirstErrorTime() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                this.mRemote.transact(16, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int resetFirstErrorTime() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                this.mRemote.transact(17, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public String getFirstErrorType() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                this.mRemote.transact(18, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configureModemlogcat(int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.mRemote.transact(19, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configureBluetoothlogcat(int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.mRemote.transact(20, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configureLogcat(int i, String str) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                obtain.writeString(str);
                this.mRemote.transact(21, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configureAPlogs(int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                this.mRemote.transact(22, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configureCoredump(int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                this.mRemote.transact(23, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int configureGPS(int i) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                this.mRemote.transact(24, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void configureWithPara(String str, String str2) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.mRemote.transact(25, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public CompressInfo getCompressInfo() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                CompressInfo compressInfo;
                obtain.writeInterfaceToken(ILogCollect$Stub.DESCRIPTOR);
                this.mRemote.transact(26, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    compressInfo = (CompressInfo) CompressInfo.CREATOR.createFromParcel(obtain2);
                } else {
                    compressInfo = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return compressInfo;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ILogCollect$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static ILogCollect asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ILogCollect)) {
            return new Proxy(iBinder);
        }
        return (ILogCollect) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        int metricStoargeHeader;
        LogMetricInfo captureLogMetric;
        switch (i) {
            case 1:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = setMetricStoargeHeader(parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = setMetricCommonHeader(parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 3:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = setMetricStoargeTail(parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 4:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = submitMetric(parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 5:
                parcel.enforceInterface(DESCRIPTOR);
                boolean shouldSubmitMetric = shouldSubmitMetric(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (shouldSubmitMetric) {
                    metricStoargeHeader = 1;
                }
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 6:
                parcel.enforceInterface(DESCRIPTOR);
                captureLogMetric = captureLogMetric(parcel.readInt());
                parcel2.writeNoException();
                if (captureLogMetric != null) {
                    parcel2.writeInt(1);
                    captureLogMetric.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 7:
                parcel.enforceInterface(DESCRIPTOR);
                clearLogMetric(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = feedbackUploadResult(parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 9:
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                metricStoargeHeader = allowUploadInMobileNetwork(z);
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 10:
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                metricStoargeHeader = allowUploadAlways(z);
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 11:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configureUserType(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 12:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = getUserType();
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 13:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = forceUpload();
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 14:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configure(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 15:
                parcel.enforceInterface(DESCRIPTOR);
                captureLogMetric = captureAllLog();
                parcel2.writeNoException();
                if (captureLogMetric != null) {
                    parcel2.writeInt(1);
                    captureLogMetric.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 16:
                parcel.enforceInterface(DESCRIPTOR);
                long firstErrorTime = getFirstErrorTime();
                parcel2.writeNoException();
                parcel2.writeLong(firstErrorTime);
                return true;
            case 17:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = resetFirstErrorTime();
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 18:
                parcel.enforceInterface(DESCRIPTOR);
                String firstErrorType = getFirstErrorType();
                parcel2.writeNoException();
                parcel2.writeString(firstErrorType);
                return true;
            case 19:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configureModemlogcat(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 20:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configureBluetoothlogcat(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 21:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configureLogcat(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 22:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configureAPlogs(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 23:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configureCoredump(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 24:
                parcel.enforceInterface(DESCRIPTOR);
                metricStoargeHeader = configureGPS(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(metricStoargeHeader);
                return true;
            case 25:
                parcel.enforceInterface(DESCRIPTOR);
                configureWithPara(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface(DESCRIPTOR);
                CompressInfo compressInfo = getCompressInfo();
                parcel2.writeNoException();
                if (compressInfo != null) {
                    parcel2.writeInt(1);
                    compressInfo.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString(DESCRIPTOR);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
