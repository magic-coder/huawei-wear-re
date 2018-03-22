package cn.com.fmsh.nfcos.client.service.huawei;

import android.nfc.Tag;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface CardAppManager extends IInterface {

    public abstract class Stub extends Binder implements CardAppManager {
        private static final String DESCRIPTOR = "cn.com.fmsh.nfcos.client.service.huawei.CardAppManager";
        static final int TRANSACTION_apply4Order = 25;
        static final int TRANSACTION_apply4OrderEx = 26;
        static final int TRANSACTION_applyIssue = 28;
        static final int TRANSACTION_applyIssueByProduct = 27;
        static final int TRANSACTION_cancelIssue = 8;
        static final int TRANSACTION_closeApp = 5;
        static final int TRANSACTION_deleteApp = 4;
        static final int TRANSACTION_doIssue = 3;
        static final int TRANSACTION_doRefund = 19;
        static final int TRANSACTION_doUnsolvedOrder = 18;
        static final int TRANSACTION_getAppIssueStatus = 9;
        static final int TRANSACTION_getAppIssueStatusByPlatform = 10;
        static final int TRANSACTION_getInfo = 11;
        static final int TRANSACTION_getInvoiceToken = 20;
        static final int TRANSACTION_getIssueProcess = 29;
        static final int TRANSACTION_login = 22;
        static final int TRANSACTION_logout = 23;
        static final int TRANSACTION_modifyPassword = 24;
        static final int TRANSACTION_moveApp = 7;
        static final int TRANSACTION_openApp = 6;
        static final int TRANSACTION_queryActivities = 30;
        static final int TRANSACTION_queryBusinessOrder = 15;
        static final int TRANSACTION_queryBusinessOrders = 16;
        static final int TRANSACTION_queryMainOrder = 13;
        static final int TRANSACTION_queryMainOrders = 12;
        static final int TRANSACTION_queryPayOrder = 14;
        static final int TRANSACTION_queryPreDeposit = 31;
        static final int TRANSACTION_recharge = 17;
        static final int TRANSACTION_register = 21;
        static final int TRANSACTION_switchMode2NFC = 2;
        static final int TRANSACTION_switchMode2OMA = 1;

        class Proxy implements CardAppManager {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public int switchMode2OMA(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
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

            public int switchMode2NFC(Tag tag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tag != null) {
                        obtain.writeInt(1);
                        tag.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int doIssue(byte[] bArr, byte b, byte[] bArr2, byte[] bArr3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeByte(b);
                    obtain.writeByteArray(bArr2);
                    obtain.writeByteArray(bArr3);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int deleteApp(byte[] bArr, int i, byte[] bArr2, String str, CardAppInfo cardAppInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr2);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        cardAppInfo.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int closeApp(byte[] bArr, int i, byte[] bArr2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr2);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int openApp(byte[] bArr, int i, byte[] bArr2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr2);
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int moveApp(byte[] bArr, int i, byte[] bArr2, String str, VoucherInfo voucherInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr2);
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        voucherInfo.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int cancelIssue(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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

            public int getAppIssueStatus(int i, CardAppStatus cardAppStatus) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        cardAppStatus.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAppIssueStatusByPlatform(int i, byte[] bArr, String str, CardAppStatus cardAppStatus) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        cardAppStatus.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getInfo(int i, int i2, CardAppInfo cardAppInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        cardAppInfo.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int queryMainOrders(int i, int i2, int i3, int[] iArr, List<NfcosMainOrder> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeIntArray(iArr);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readTypedList(list, NfcosMainOrder.CREATOR);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int queryMainOrder(byte[] bArr, NfcosMainOrder nfcosMainOrder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        nfcosMainOrder.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int queryPayOrder(byte[] bArr, NfcosPayOrder nfcosPayOrder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        nfcosPayOrder.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int queryBusinessOrder(byte[] bArr, NfcosBusinessOrder nfcosBusinessOrder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        nfcosBusinessOrder.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int queryBusinessOrders(int i, int i2, int i3, int[] iArr, int i4, byte[] bArr, List<NfcosBusinessOrder> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i4);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readTypedList(list, NfcosBusinessOrder.CREATOR);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int recharge(byte[] bArr, byte[] bArr2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int doUnsolvedOrder(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int doRefund(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getInvoiceToken(byte[] bArr, InvoiceToken invoiceToken) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        invoiceToken.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int register(UserInfo userInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (userInfo != null) {
                        obtain.writeInt(1);
                        userInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int login(String str, String str2, LoginInfo loginInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        loginInfo.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int logout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int modifyPassword(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int apply4Order(int i, int i2, int i3, byte[] bArr, NfcosMainOrder nfcosMainOrder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        nfcosMainOrder.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int apply4OrderEx(int i, int i2, int i3, byte[] bArr, byte[] bArr2, NfcosMainOrder nfcosMainOrder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        nfcosMainOrder.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int applyIssueByProduct(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2, byte[] bArr3, NfcosMainOrder nfcosMainOrder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr3);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        nfcosMainOrder.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int applyIssue(int i, int i2, int i3, byte[] bArr, String str, byte[] bArr2, NfcosMainOrder nfcosMainOrder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr2);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        nfcosMainOrder.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getIssueProcess(IssueProcess issueProcess) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        issueProcess.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int queryActivities(int i, List<NfcosActivity> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readTypedList(list, NfcosActivity.CREATOR);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int queryPreDeposit(int i, PreDepositInfo preDepositInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        preDepositInfo.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static CardAppManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof CardAppManager)) {
                return new Proxy(iBinder);
            }
            return (CardAppManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            UserInfo userInfo = null;
            int switchMode2OMA;
            byte[] createByteArray;
            int readInt;
            byte[] createByteArray2;
            String readString;
            String readString2;
            int readInt2;
            int readInt3;
            int[] createIntArray;
            byte[] createByteArray3;
            byte[] createByteArray4;
            byte[] createByteArray5;
            byte[] createByteArray6;
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = switchMode2OMA(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 2:
                    Tag tag;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        tag = (Tag) Tag.CREATOR.createFromParcel(parcel);
                    }
                    switchMode2OMA = switchMode2NFC(tag);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = doIssue(parcel.createByteArray(), parcel.readByte(), parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    createByteArray = parcel.createByteArray();
                    readInt = parcel.readInt();
                    createByteArray2 = parcel.createByteArray();
                    readString = parcel.readString();
                    CardAppInfo cardAppInfo = new CardAppInfo();
                    switchMode2OMA = deleteApp(createByteArray, readInt, createByteArray2, readString, cardAppInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (cardAppInfo != null) {
                        parcel2.writeInt(1);
                        cardAppInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = closeApp(parcel.createByteArray(), parcel.readInt(), parcel.createByteArray(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = openApp(parcel.createByteArray(), parcel.readInt(), parcel.createByteArray(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    createByteArray = parcel.createByteArray();
                    readInt = parcel.readInt();
                    createByteArray2 = parcel.createByteArray();
                    readString = parcel.readString();
                    VoucherInfo voucherInfo = new VoucherInfo();
                    switchMode2OMA = moveApp(createByteArray, readInt, createByteArray2, readString, voucherInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (voucherInfo != null) {
                        parcel2.writeInt(1);
                        voucherInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = cancelIssue(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = parcel.readInt();
                    CardAppStatus cardAppStatus = new CardAppStatus();
                    switchMode2OMA = getAppIssueStatus(switchMode2OMA, cardAppStatus);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (cardAppStatus != null) {
                        parcel2.writeInt(1);
                        cardAppStatus.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = parcel.readInt();
                    createByteArray = parcel.createByteArray();
                    readString2 = parcel.readString();
                    CardAppStatus cardAppStatus2 = new CardAppStatus();
                    switchMode2OMA = getAppIssueStatusByPlatform(switchMode2OMA, createByteArray, readString2, cardAppStatus2);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (cardAppStatus2 != null) {
                        parcel2.writeInt(1);
                        cardAppStatus2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = parcel.readInt();
                    readInt2 = parcel.readInt();
                    CardAppInfo cardAppInfo2 = new CardAppInfo();
                    switchMode2OMA = getInfo(switchMode2OMA, readInt2, cardAppInfo2);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (cardAppInfo2 != null) {
                        parcel2.writeInt(1);
                        cardAppInfo2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    readInt2 = parcel.readInt();
                    readInt = parcel.readInt();
                    readInt3 = parcel.readInt();
                    createIntArray = parcel.createIntArray();
                    List arrayList = new ArrayList();
                    switchMode2OMA = queryMainOrders(readInt2, readInt, readInt3, createIntArray, arrayList);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    parcel2.writeTypedList(arrayList);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    createByteArray3 = parcel.createByteArray();
                    NfcosMainOrder nfcosMainOrder = new NfcosMainOrder();
                    switchMode2OMA = queryMainOrder(createByteArray3, nfcosMainOrder);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (nfcosMainOrder != null) {
                        parcel2.writeInt(1);
                        nfcosMainOrder.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    createByteArray3 = parcel.createByteArray();
                    NfcosPayOrder nfcosPayOrder = new NfcosPayOrder();
                    switchMode2OMA = queryPayOrder(createByteArray3, nfcosPayOrder);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (nfcosPayOrder != null) {
                        parcel2.writeInt(1);
                        nfcosPayOrder.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    createByteArray3 = parcel.createByteArray();
                    NfcosBusinessOrder nfcosBusinessOrder = new NfcosBusinessOrder();
                    switchMode2OMA = queryBusinessOrder(createByteArray3, nfcosBusinessOrder);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (nfcosBusinessOrder != null) {
                        parcel2.writeInt(1);
                        nfcosBusinessOrder.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    readInt2 = parcel.readInt();
                    readInt = parcel.readInt();
                    readInt3 = parcel.readInt();
                    createIntArray = parcel.createIntArray();
                    int readInt4 = parcel.readInt();
                    createByteArray4 = parcel.createByteArray();
                    List arrayList2 = new ArrayList();
                    switchMode2OMA = queryBusinessOrders(readInt2, readInt, readInt3, createIntArray, readInt4, createByteArray4, arrayList2);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    parcel2.writeTypedList(arrayList2);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = recharge(parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = doUnsolvedOrder(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = doRefund(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    createByteArray3 = parcel.createByteArray();
                    InvoiceToken invoiceToken = new InvoiceToken();
                    switchMode2OMA = getInvoiceToken(createByteArray3, invoiceToken);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (invoiceToken != null) {
                        parcel2.writeInt(1);
                        invoiceToken.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        userInfo = (UserInfo) UserInfo.CREATOR.createFromParcel(parcel);
                    }
                    switchMode2OMA = register(userInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    LoginInfo loginInfo = new LoginInfo();
                    switchMode2OMA = login(readString3, readString4, loginInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (loginInfo != null) {
                        parcel2.writeInt(1);
                        loginInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = logout();
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = modifyPassword(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    readInt2 = parcel.readInt();
                    readInt = parcel.readInt();
                    readInt3 = parcel.readInt();
                    createByteArray5 = parcel.createByteArray();
                    NfcosMainOrder nfcosMainOrder2 = new NfcosMainOrder();
                    switchMode2OMA = apply4Order(readInt2, readInt, readInt3, createByteArray5, nfcosMainOrder2);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (nfcosMainOrder2 != null) {
                        parcel2.writeInt(1);
                        nfcosMainOrder2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    readInt2 = parcel.readInt();
                    readInt = parcel.readInt();
                    readInt3 = parcel.readInt();
                    createByteArray5 = parcel.createByteArray();
                    createByteArray6 = parcel.createByteArray();
                    NfcosMainOrder nfcosMainOrder3 = new NfcosMainOrder();
                    switchMode2OMA = apply4OrderEx(readInt2, readInt, readInt3, createByteArray5, createByteArray6, nfcosMainOrder3);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (nfcosMainOrder3 != null) {
                        parcel2.writeInt(1);
                        nfcosMainOrder3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    readInt2 = parcel.readInt();
                    readString2 = parcel.readString();
                    readInt3 = parcel.readInt();
                    createByteArray5 = parcel.createByteArray();
                    createByteArray6 = parcel.createByteArray();
                    String readString5 = parcel.readString();
                    byte[] createByteArray7 = parcel.createByteArray();
                    NfcosMainOrder nfcosMainOrder4 = new NfcosMainOrder();
                    switchMode2OMA = applyIssueByProduct(readInt2, readString2, readInt3, createByteArray5, createByteArray6, readString5, createByteArray7, nfcosMainOrder4);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (nfcosMainOrder4 != null) {
                        parcel2.writeInt(1);
                        nfcosMainOrder4.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    readInt2 = parcel.readInt();
                    readInt = parcel.readInt();
                    readInt3 = parcel.readInt();
                    createByteArray5 = parcel.createByteArray();
                    String readString6 = parcel.readString();
                    createByteArray4 = parcel.createByteArray();
                    NfcosMainOrder nfcosMainOrder5 = new NfcosMainOrder();
                    switchMode2OMA = applyIssue(readInt2, readInt, readInt3, createByteArray5, readString6, createByteArray4, nfcosMainOrder5);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (nfcosMainOrder5 != null) {
                        parcel2.writeInt(1);
                        nfcosMainOrder5.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    IssueProcess issueProcess = new IssueProcess();
                    readInt2 = getIssueProcess(issueProcess);
                    parcel2.writeNoException();
                    parcel2.writeInt(readInt2);
                    if (issueProcess != null) {
                        parcel2.writeInt(1);
                        issueProcess.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = parcel.readInt();
                    List arrayList3 = new ArrayList();
                    switchMode2OMA = queryActivities(switchMode2OMA, arrayList3);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    parcel2.writeTypedList(arrayList3);
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchMode2OMA = parcel.readInt();
                    PreDepositInfo preDepositInfo = new PreDepositInfo();
                    switchMode2OMA = queryPreDeposit(switchMode2OMA, preDepositInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(switchMode2OMA);
                    if (preDepositInfo != null) {
                        parcel2.writeInt(1);
                        preDepositInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int apply4Order(int i, int i2, int i3, byte[] bArr, NfcosMainOrder nfcosMainOrder) throws RemoteException;

    int apply4OrderEx(int i, int i2, int i3, byte[] bArr, byte[] bArr2, NfcosMainOrder nfcosMainOrder) throws RemoteException;

    int applyIssue(int i, int i2, int i3, byte[] bArr, String str, byte[] bArr2, NfcosMainOrder nfcosMainOrder) throws RemoteException;

    int applyIssueByProduct(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2, byte[] bArr3, NfcosMainOrder nfcosMainOrder) throws RemoteException;

    int cancelIssue(int i) throws RemoteException;

    int closeApp(byte[] bArr, int i, byte[] bArr2, String str) throws RemoteException;

    int deleteApp(byte[] bArr, int i, byte[] bArr2, String str, CardAppInfo cardAppInfo) throws RemoteException;

    int doIssue(byte[] bArr, byte b, byte[] bArr2, byte[] bArr3) throws RemoteException;

    int doRefund(byte[] bArr) throws RemoteException;

    int doUnsolvedOrder(byte[] bArr) throws RemoteException;

    int getAppIssueStatus(int i, CardAppStatus cardAppStatus) throws RemoteException;

    int getAppIssueStatusByPlatform(int i, byte[] bArr, String str, CardAppStatus cardAppStatus) throws RemoteException;

    int getInfo(int i, int i2, CardAppInfo cardAppInfo) throws RemoteException;

    int getInvoiceToken(byte[] bArr, InvoiceToken invoiceToken) throws RemoteException;

    int getIssueProcess(IssueProcess issueProcess) throws RemoteException;

    int login(String str, String str2, LoginInfo loginInfo) throws RemoteException;

    int logout() throws RemoteException;

    int modifyPassword(String str, String str2) throws RemoteException;

    int moveApp(byte[] bArr, int i, byte[] bArr2, String str, VoucherInfo voucherInfo) throws RemoteException;

    int openApp(byte[] bArr, int i, byte[] bArr2, String str) throws RemoteException;

    int queryActivities(int i, List<NfcosActivity> list) throws RemoteException;

    int queryBusinessOrder(byte[] bArr, NfcosBusinessOrder nfcosBusinessOrder) throws RemoteException;

    int queryBusinessOrders(int i, int i2, int i3, int[] iArr, int i4, byte[] bArr, List<NfcosBusinessOrder> list) throws RemoteException;

    int queryMainOrder(byte[] bArr, NfcosMainOrder nfcosMainOrder) throws RemoteException;

    int queryMainOrders(int i, int i2, int i3, int[] iArr, List<NfcosMainOrder> list) throws RemoteException;

    int queryPayOrder(byte[] bArr, NfcosPayOrder nfcosPayOrder) throws RemoteException;

    int queryPreDeposit(int i, PreDepositInfo preDepositInfo) throws RemoteException;

    int recharge(byte[] bArr, byte[] bArr2) throws RemoteException;

    int register(UserInfo userInfo) throws RemoteException;

    int switchMode2NFC(Tag tag) throws RemoteException;

    int switchMode2OMA(int i, int i2) throws RemoteException;
}
