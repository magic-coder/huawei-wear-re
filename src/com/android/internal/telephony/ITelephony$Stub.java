package com.android.internal.telephony;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.NeighboringCellInfo;
import java.util.List;

public abstract class ITelephony$Stub extends Binder implements ITelephony {
    private static final String DESCRIPTOR = "com.android.internal.telephony.ITelephony";
    static final int TRANSACTION_answerRingingCall = 7;
    static final int TRANSACTION_call = 2;
    static final int TRANSACTION_cancelMissedCallsNotification = 14;
    static final int TRANSACTION_dial = 1;
    static final int TRANSACTION_disableApnType = 24;
    static final int TRANSACTION_disableDataConnectivity = 26;
    static final int TRANSACTION_disableLocationUpdates = 22;
    static final int TRANSACTION_enableApnType = 23;
    static final int TRANSACTION_enableDataConnectivity = 25;
    static final int TRANSACTION_enableLocationUpdates = 21;
    static final int TRANSACTION_endCall = 5;
    static final int TRANSACTION_endCallForSubscriber = 6;
    static final int TRANSACTION_getActivePhoneType = 33;
    static final int TRANSACTION_getCallState = 30;
    static final int TRANSACTION_getCdmaEriIconIndex = 34;
    static final int TRANSACTION_getCdmaEriIconMode = 35;
    static final int TRANSACTION_getCdmaEriText = 36;
    static final int TRANSACTION_getCellLocation = 28;
    static final int TRANSACTION_getDataActivity = 31;
    static final int TRANSACTION_getDataState = 32;
    static final int TRANSACTION_getLteOnCdmaMode = 41;
    static final int TRANSACTION_getNeighboringCellInfo = 29;
    static final int TRANSACTION_getNetworkType = 39;
    static final int TRANSACTION_getVoiceMessageCount = 38;
    static final int TRANSACTION_handlePinMmi = 17;
    static final int TRANSACTION_hasIccCard = 40;
    static final int TRANSACTION_isDataConnectivityPossible = 27;
    static final int TRANSACTION_isIdle = 11;
    static final int TRANSACTION_isOffhook = 9;
    static final int TRANSACTION_isRadioOn = 12;
    static final int TRANSACTION_isRinging = 10;
    static final int TRANSACTION_isSimPinEnabled = 13;
    static final int TRANSACTION_needsOtaServiceProvisioning = 37;
    static final int TRANSACTION_setRadio = 19;
    static final int TRANSACTION_showCallScreen = 3;
    static final int TRANSACTION_showCallScreenWithDialpad = 4;
    static final int TRANSACTION_silenceRinger = 8;
    static final int TRANSACTION_supplyPin = 15;
    static final int TRANSACTION_supplyPuk = 16;
    static final int TRANSACTION_toggleRadioOnOff = 18;
    static final int TRANSACTION_updateServiceLocation = 20;

    class Proxy implements ITelephony {
        private IBinder mRemote;

        Proxy(IBinder iBinder) {
            this.mRemote = iBinder;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public String getInterfaceDescriptor() {
            return ITelephony$Stub.DESCRIPTOR;
        }

        public void dial(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(1, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void call(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(2, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean showCallScreen() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(3, obtain, obtain2, 0);
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

        public boolean showCallScreenWithDialpad(boolean z) throws RemoteException {
            boolean z2 = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeInt(z ? 1 : 0);
                this.mRemote.transact(4, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z2;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean endCall() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
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

        public boolean endCallForSubscriber(int i) throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeInt(i);
                this.mRemote.transact(6, obtain, obtain2, 0);
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

        public void answerRingingCall() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(7, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void silenceRinger() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(8, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isOffhook() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(9, obtain, obtain2, 0);
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

        public boolean isRinging() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(10, obtain, obtain2, 0);
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

        public boolean isIdle() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(11, obtain, obtain2, 0);
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

        public boolean isRadioOn() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(12, obtain, obtain2, 0);
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

        public boolean isSimPinEnabled() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(13, obtain, obtain2, 0);
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

        public void cancelMissedCallsNotification() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(14, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean supplyPin(String str) throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(15, obtain, obtain2, 0);
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

        public boolean supplyPuk(String str, String str2) throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeString(str);
                obtain.writeString(str2);
                this.mRemote.transact(16, obtain, obtain2, 0);
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

        public boolean handlePinMmi(String str) throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(17, obtain, obtain2, 0);
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

        public void toggleRadioOnOff() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(18, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean setRadio(boolean z) throws RemoteException {
            boolean z2 = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeInt(z ? 1 : 0);
                this.mRemote.transact(19, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z2;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void updateServiceLocation() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(20, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void enableLocationUpdates() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(21, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public void disableLocationUpdates() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(22, obtain, obtain2, 0);
                obtain2.readException();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int enableApnType(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(23, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int disableApnType(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                obtain.writeString(str);
                this.mRemote.transact(24, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean enableDataConnectivity() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(25, obtain, obtain2, 0);
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

        public boolean disableDataConnectivity() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(26, obtain, obtain2, 0);
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

        public boolean isDataConnectivityPossible() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(27, obtain, obtain2, 0);
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

        public Bundle getCellLocation() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                Bundle bundle;
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(28, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                } else {
                    bundle = null;
                }
                obtain2.recycle();
                obtain.recycle();
                return bundle;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public List<NeighboringCellInfo> getNeighboringCellInfo() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(29, obtain, obtain2, 0);
                obtain2.readException();
                List<NeighboringCellInfo> createTypedArrayList = obtain2.createTypedArrayList(NeighboringCellInfo.CREATOR);
                return createTypedArrayList;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getCallState() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(30, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getDataActivity() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(31, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getDataState() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(32, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getActivePhoneType() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(33, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getCdmaEriIconIndex() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(34, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getCdmaEriIconMode() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(35, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public String getCdmaEriText() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(36, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean needsOtaServiceProvisioning() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(37, obtain, obtain2, 0);
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

        public int getVoiceMessageCount() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(38, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public int getNetworkType() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(39, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean hasIccCard() throws RemoteException {
            boolean z = false;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(40, obtain, obtain2, 0);
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

        public int getLteOnCdmaMode() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ITelephony$Stub.DESCRIPTOR);
                this.mRemote.transact(41, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ITelephony$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static ITelephony asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ITelephony)) {
            return new Proxy(iBinder);
        }
        return (ITelephony) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3 = 0;
        boolean showCallScreen;
        switch (i) {
            case 1:
                parcel.enforceInterface(DESCRIPTOR);
                dial(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                call(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = showCallScreen();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    showCallScreen = true;
                } else {
                    showCallScreen = false;
                }
                showCallScreen = showCallScreenWithDialpad(showCallScreen);
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = endCall();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = endCallForSubscriber(parcel.readInt());
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 7:
                parcel.enforceInterface(DESCRIPTOR);
                answerRingingCall();
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface(DESCRIPTOR);
                silenceRinger();
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = isOffhook();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = isRinging();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 11:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = isIdle();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 12:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = isRadioOn();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 13:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = isSimPinEnabled();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 14:
                parcel.enforceInterface(DESCRIPTOR);
                cancelMissedCallsNotification();
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = supplyPin(parcel.readString());
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 16:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = supplyPuk(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 17:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = handlePinMmi(parcel.readString());
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 18:
                parcel.enforceInterface(DESCRIPTOR);
                toggleRadioOnOff();
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    showCallScreen = true;
                } else {
                    showCallScreen = false;
                }
                showCallScreen = setRadio(showCallScreen);
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 20:
                parcel.enforceInterface(DESCRIPTOR);
                updateServiceLocation();
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface(DESCRIPTOR);
                enableLocationUpdates();
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface(DESCRIPTOR);
                disableLocationUpdates();
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = enableApnType(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 24:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = disableApnType(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 25:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = enableDataConnectivity();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 26:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = disableDataConnectivity();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 27:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = isDataConnectivityPossible();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 28:
                parcel.enforceInterface(DESCRIPTOR);
                Bundle cellLocation = getCellLocation();
                parcel2.writeNoException();
                if (cellLocation != null) {
                    parcel2.writeInt(1);
                    cellLocation.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 29:
                parcel.enforceInterface(DESCRIPTOR);
                List neighboringCellInfo = getNeighboringCellInfo();
                parcel2.writeNoException();
                parcel2.writeTypedList(neighboringCellInfo);
                return true;
            case 30:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getCallState();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 31:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getDataActivity();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 32:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getDataState();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 33:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getActivePhoneType();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 34:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getCdmaEriIconIndex();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 35:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getCdmaEriIconMode();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 36:
                parcel.enforceInterface(DESCRIPTOR);
                String cdmaEriText = getCdmaEriText();
                parcel2.writeNoException();
                parcel2.writeString(cdmaEriText);
                return true;
            case 37:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = needsOtaServiceProvisioning();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 38:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getVoiceMessageCount();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 39:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getNetworkType();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 40:
                parcel.enforceInterface(DESCRIPTOR);
                showCallScreen = hasIccCard();
                parcel2.writeNoException();
                if (showCallScreen) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 41:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getLteOnCdmaMode();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 1598968902:
                parcel2.writeString(DESCRIPTOR);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
