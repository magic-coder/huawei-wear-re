package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.BleKeyExchangeRequestParams;
import com.unionpay.tsmservice.request.CheckBinRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExchangeKeyRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetActiveCodeRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.GetUniteAppListRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenCardApplyActivityRequestParams;
import com.unionpay.tsmservice.request.OpenCardDetailActivityRequestParams;
import com.unionpay.tsmservice.request.OpenUniteCardApplyActivityRequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.UniteAppDeleteRequestParams;
import com.unionpay.tsmservice.request.UniteAppDownloadRequestParams;
import com.unionpay.tsmservice.request.UniteCardActiveRequestParams;

public interface ITsmService extends IInterface {

    public abstract class Stub extends Binder implements ITsmService {
        private static final String DESCRIPTOR = "com.unionpay.tsmservice.ITsmService";
        static final int TRANSACTION_appDataUpdate = 20;
        static final int TRANSACTION_appDelete = 18;
        static final int TRANSACTION_appDownload = 16;
        static final int TRANSACTION_appDownloadApply = 15;
        static final int TRANSACTION_appLock = 21;
        static final int TRANSACTION_appUnlock = 22;
        static final int TRANSACTION_bleKeyExchange = 37;
        static final int TRANSACTION_checkBinCode = 3;
        static final int TRANSACTION_clearEncryptData = 45;
        static final int TRANSACTION_closeChannel = 35;
        static final int TRANSACTION_eCashTopUp = 26;
        static final int TRANSACTION_encryptData = 6;
        static final int TRANSACTION_exchangeKey = 5;
        static final int TRANSACTION_executeCmd = 47;
        static final int TRANSACTION_getAccountBalance = 29;
        static final int TRANSACTION_getAccountInfo = 28;
        static final int TRANSACTION_getActiveCode = 24;
        static final int TRANSACTION_getAppDetail = 13;
        static final int TRANSACTION_getAppList = 10;
        static final int TRANSACTION_getAppStatus = 12;
        static final int TRANSACTION_getAssociatedApp = 8;
        static final int TRANSACTION_getCardInfo = 30;
        static final int TRANSACTION_getDefaultCard = 32;
        static final int TRANSACTION_getEncryptData = 44;
        static final int TRANSACTION_getPubKey = 4;
        static final int TRANSACTION_getSEAppList = 9;
        static final int TRANSACTION_getSEId = 7;
        static final int TRANSACTION_getSMSAuthCode = 23;
        static final int TRANSACTION_getSupportedCardTypeList = 2;
        static final int TRANSACTION_getTransElements = 14;
        static final int TRANSACTION_getTransRecord = 27;
        static final int TRANSACTION_getUniteAppList = 11;
        static final int TRANSACTION_hideAppApply = 36;
        static final int TRANSACTION_hideKeyboard = 46;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_openCardApplyActivity = 38;
        static final int TRANSACTION_openCardDetailActivity = 39;
        static final int TRANSACTION_openChannel = 33;
        static final int TRANSACTION_openUniteCardApplyActivity = 40;
        static final int TRANSACTION_sendApdu = 34;
        static final int TRANSACTION_setDefaultCard = 31;
        static final int TRANSACTION_setSafetyKeyboardBitmap = 43;
        static final int TRANSACTION_showSafetyKeyboard = 42;
        static final int TRANSACTION_unbindBleService = 41;
        static final int TRANSACTION_uniteAppDelete = 19;
        static final int TRANSACTION_uniteAppDownload = 17;
        static final int TRANSACTION_uniteCardActive = 25;

        class Proxy implements ITsmService {
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

            public int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (initRequestParams != null) {
                        obtain.writeInt(1);
                        initRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSupportedCardTypeList(ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int checkBinCode(CheckBinRequestParams checkBinRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (checkBinRequestParams != null) {
                        obtain.writeInt(1);
                        checkBinRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPubKey(ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int exchangeKey(ExchangeKeyRequestParams exchangeKeyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (exchangeKeyRequestParams != null) {
                        obtain.writeInt(1);
                        exchangeKeyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (encryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        encryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSEId(ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAssociatedApp(GetAssociatedAppRequestParams getAssociatedAppRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getAssociatedAppRequestParams != null) {
                        obtain.writeInt(1);
                        getAssociatedAppRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSEAppList(ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAppList(GetAppListRequestParams getAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getAppListRequestParams != null) {
                        obtain.writeInt(1);
                        getAppListRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getUniteAppList(GetUniteAppListRequestParams getUniteAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getUniteAppListRequestParams != null) {
                        obtain.writeInt(1);
                        getUniteAppListRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAppStatus(GetAppStatusRequestParams getAppStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getAppStatusRequestParams != null) {
                        obtain.writeInt(1);
                        getAppStatusRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAppDetail(GetAppDetailRequestParams getAppDetailRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getAppDetailRequestParams != null) {
                        obtain.writeInt(1);
                        getAppDetailRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getTransElements(GetTransElementsRequestParams getTransElementsRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getTransElementsRequestParams != null) {
                        obtain.writeInt(1);
                        getTransElementsRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int appDownloadApply(AppDownloadApplyRequestParams appDownloadApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (appDownloadApplyRequestParams != null) {
                        obtain.writeInt(1);
                        appDownloadApplyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int appDownload(AppDownloadRequestParams appDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (appDownloadRequestParams != null) {
                        obtain.writeInt(1);
                        appDownloadRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int uniteAppDownload(UniteAppDownloadRequestParams uniteAppDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uniteAppDownloadRequestParams != null) {
                        obtain.writeInt(1);
                        uniteAppDownloadRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int appDelete(AppDeleteRequestParams appDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (appDeleteRequestParams != null) {
                        obtain.writeInt(1);
                        appDeleteRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int uniteAppDelete(UniteAppDeleteRequestParams uniteAppDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uniteAppDeleteRequestParams != null) {
                        obtain.writeInt(1);
                        uniteAppDeleteRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int appDataUpdate(AppDataUpdateRequestParams appDataUpdateRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (appDataUpdateRequestParams != null) {
                        obtain.writeInt(1);
                        appDataUpdateRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int appLock(AppLockRequestParams appLockRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (appLockRequestParams != null) {
                        obtain.writeInt(1);
                        appLockRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int appUnlock(AppUnlockRequestParams appUnlockRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (appUnlockRequestParams != null) {
                        obtain.writeInt(1);
                        appUnlockRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSMSAuthCode(GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getSMSAuthCodeRequestParams != null) {
                        obtain.writeInt(1);
                        getSMSAuthCodeRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getActiveCode(GetActiveCodeRequestParams getActiveCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getActiveCodeRequestParams != null) {
                        obtain.writeInt(1);
                        getActiveCodeRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int uniteCardActive(UniteCardActiveRequestParams uniteCardActiveRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uniteCardActiveRequestParams != null) {
                        obtain.writeInt(1);
                        uniteCardActiveRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int eCashTopUp(ECashTopUpRequestParams eCashTopUpRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (eCashTopUpRequestParams != null) {
                        obtain.writeInt(1);
                        eCashTopUpRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getTransRecord(GetTransRecordRequestParams getTransRecordRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getTransRecordRequestParams != null) {
                        obtain.writeInt(1);
                        getTransRecordRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAccountInfo(GetAccountInfoRequestParams getAccountInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getAccountInfoRequestParams != null) {
                        obtain.writeInt(1);
                        getAccountInfoRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getAccountBalance(GetAccountBalanceRequestParams getAccountBalanceRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getAccountBalanceRequestParams != null) {
                        obtain.writeInt(1);
                        getAccountBalanceRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getCardInfo(String[] strArr, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setDefaultCard(String str, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getDefaultCard(ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int openChannel(String str, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int sendApdu(SendApduRequestParams sendApduRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (sendApduRequestParams != null) {
                        obtain.writeInt(1);
                        sendApduRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int closeChannel(String str, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hideAppApply(String str, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int bleKeyExchange(BleKeyExchangeRequestParams bleKeyExchangeRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bleKeyExchangeRequestParams != null) {
                        obtain.writeInt(1);
                        bleKeyExchangeRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int openCardApplyActivity(OpenCardApplyActivityRequestParams openCardApplyActivityRequestParams, ITsmActivityCallback iTsmActivityCallback, ITsmCallback iTsmCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (openCardApplyActivityRequestParams != null) {
                        obtain.writeInt(1);
                        openCardApplyActivityRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmActivityCallback != null ? iTsmActivityCallback.asBinder() : null);
                    if (iTsmCallback != null) {
                        iBinder = iTsmCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int openCardDetailActivity(OpenCardDetailActivityRequestParams openCardDetailActivityRequestParams, ITsmActivityCallback iTsmActivityCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (openCardDetailActivityRequestParams != null) {
                        obtain.writeInt(1);
                        openCardDetailActivityRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmActivityCallback != null ? iTsmActivityCallback.asBinder() : null);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int openUniteCardApplyActivity(OpenUniteCardApplyActivityRequestParams openUniteCardApplyActivityRequestParams, ITsmActivityCallback iTsmActivityCallback, ITsmCallback iTsmCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (openUniteCardApplyActivityRequestParams != null) {
                        obtain.writeInt(1);
                        openUniteCardApplyActivityRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmActivityCallback != null ? iTsmActivityCallback.asBinder() : null);
                    if (iTsmCallback != null) {
                        iBinder = iTsmCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unbindBleService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (safetyKeyboardRequestParams != null) {
                        obtain.writeInt(1);
                        safetyKeyboardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(onSafetyKeyboardCallback != null ? onSafetyKeyboardCallback.asBinder() : null);
                    if (iTsmActivityCallback != null) {
                        iBinder = iTsmActivityCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (safetyKeyboardRequestParams != null) {
                        obtain.writeInt(1);
                        safetyKeyboardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (getEncryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        getEncryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int clearEncryptData(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hideKeyboard() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int executeCmd(ExecuteCmdRequestParams executeCmdRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (executeCmdRequestParams != null) {
                        obtain.writeInt(1);
                        executeCmdRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITsmService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmService)) {
                return new Proxy(iBinder);
            }
            return (ITsmService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            ExecuteCmdRequestParams executeCmdRequestParams = null;
            int init;
            SafetyKeyboardRequestParams safetyKeyboardRequestParams;
            switch (i) {
                case 1:
                    InitRequestParams initRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        initRequestParams = (InitRequestParams) InitRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = init(initRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = getSupportedCardTypeList(com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 3:
                    CheckBinRequestParams checkBinRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        checkBinRequestParams = (CheckBinRequestParams) CheckBinRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = checkBinCode(checkBinRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = getPubKey(com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 5:
                    ExchangeKeyRequestParams exchangeKeyRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        exchangeKeyRequestParams = (ExchangeKeyRequestParams) ExchangeKeyRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = exchangeKey(exchangeKeyRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 6:
                    EncryptDataRequestParams encryptDataRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        encryptDataRequestParams = (EncryptDataRequestParams) EncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = encryptData(encryptDataRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = getSEId(com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 8:
                    GetAssociatedAppRequestParams getAssociatedAppRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getAssociatedAppRequestParams = (GetAssociatedAppRequestParams) GetAssociatedAppRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getAssociatedApp(getAssociatedAppRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = getSEAppList(com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 10:
                    GetAppListRequestParams getAppListRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getAppListRequestParams = (GetAppListRequestParams) GetAppListRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getAppList(getAppListRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 11:
                    GetUniteAppListRequestParams getUniteAppListRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getUniteAppListRequestParams = (GetUniteAppListRequestParams) GetUniteAppListRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getUniteAppList(getUniteAppListRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 12:
                    GetAppStatusRequestParams getAppStatusRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getAppStatusRequestParams = (GetAppStatusRequestParams) GetAppStatusRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getAppStatus(getAppStatusRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 13:
                    GetAppDetailRequestParams getAppDetailRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getAppDetailRequestParams = (GetAppDetailRequestParams) GetAppDetailRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getAppDetail(getAppDetailRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 14:
                    GetTransElementsRequestParams getTransElementsRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getTransElementsRequestParams = (GetTransElementsRequestParams) GetTransElementsRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getTransElements(getTransElementsRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 15:
                    AppDownloadApplyRequestParams appDownloadApplyRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        appDownloadApplyRequestParams = (AppDownloadApplyRequestParams) AppDownloadApplyRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = appDownloadApply(appDownloadApplyRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 16:
                    AppDownloadRequestParams appDownloadRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        appDownloadRequestParams = (AppDownloadRequestParams) AppDownloadRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = appDownload(appDownloadRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 17:
                    UniteAppDownloadRequestParams uniteAppDownloadRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        uniteAppDownloadRequestParams = (UniteAppDownloadRequestParams) UniteAppDownloadRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = uniteAppDownload(uniteAppDownloadRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 18:
                    AppDeleteRequestParams appDeleteRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        appDeleteRequestParams = (AppDeleteRequestParams) AppDeleteRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = appDelete(appDeleteRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 19:
                    UniteAppDeleteRequestParams uniteAppDeleteRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        uniteAppDeleteRequestParams = (UniteAppDeleteRequestParams) UniteAppDeleteRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = uniteAppDelete(uniteAppDeleteRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 20:
                    AppDataUpdateRequestParams appDataUpdateRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        appDataUpdateRequestParams = (AppDataUpdateRequestParams) AppDataUpdateRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = appDataUpdate(appDataUpdateRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 21:
                    AppLockRequestParams appLockRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        appLockRequestParams = (AppLockRequestParams) AppLockRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = appLock(appLockRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 22:
                    AppUnlockRequestParams appUnlockRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        appUnlockRequestParams = (AppUnlockRequestParams) AppUnlockRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = appUnlock(appUnlockRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 23:
                    GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getSMSAuthCodeRequestParams = (GetSMSAuthCodeRequestParams) GetSMSAuthCodeRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getSMSAuthCode(getSMSAuthCodeRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 24:
                    GetActiveCodeRequestParams getActiveCodeRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getActiveCodeRequestParams = (GetActiveCodeRequestParams) GetActiveCodeRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getActiveCode(getActiveCodeRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 25:
                    UniteCardActiveRequestParams uniteCardActiveRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        uniteCardActiveRequestParams = (UniteCardActiveRequestParams) UniteCardActiveRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = uniteCardActive(uniteCardActiveRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 26:
                    ECashTopUpRequestParams eCashTopUpRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        eCashTopUpRequestParams = (ECashTopUpRequestParams) ECashTopUpRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = eCashTopUp(eCashTopUpRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 27:
                    GetTransRecordRequestParams getTransRecordRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getTransRecordRequestParams = (GetTransRecordRequestParams) GetTransRecordRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getTransRecord(getTransRecordRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 28:
                    GetAccountInfoRequestParams getAccountInfoRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getAccountInfoRequestParams = (GetAccountInfoRequestParams) GetAccountInfoRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getAccountInfo(getAccountInfoRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 29:
                    GetAccountBalanceRequestParams getAccountBalanceRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getAccountBalanceRequestParams = (GetAccountBalanceRequestParams) GetAccountBalanceRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getAccountBalance(getAccountBalanceRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = getCardInfo(parcel.createStringArray(), com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = setDefaultCard(parcel.readString(), com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = getDefaultCard(com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = openChannel(parcel.readString(), com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 34:
                    SendApduRequestParams sendApduRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        sendApduRequestParams = (SendApduRequestParams) SendApduRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = sendApdu(sendApduRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = closeChannel(parcel.readString(), com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = hideAppApply(parcel.readString(), com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 37:
                    BleKeyExchangeRequestParams bleKeyExchangeRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bleKeyExchangeRequestParams = (BleKeyExchangeRequestParams) BleKeyExchangeRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = bleKeyExchange(bleKeyExchangeRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 38:
                    OpenCardApplyActivityRequestParams openCardApplyActivityRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        openCardApplyActivityRequestParams = (OpenCardApplyActivityRequestParams) OpenCardApplyActivityRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = openCardApplyActivity(openCardApplyActivityRequestParams, com.unionpay.tsmservice.ITsmActivityCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 39:
                    OpenCardDetailActivityRequestParams openCardDetailActivityRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        openCardDetailActivityRequestParams = (OpenCardDetailActivityRequestParams) OpenCardDetailActivityRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = openCardDetailActivity(openCardDetailActivityRequestParams, com.unionpay.tsmservice.ITsmActivityCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 40:
                    OpenUniteCardApplyActivityRequestParams openUniteCardApplyActivityRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        openUniteCardApplyActivityRequestParams = (OpenUniteCardApplyActivityRequestParams) OpenUniteCardApplyActivityRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = openUniteCardApplyActivity(openUniteCardApplyActivityRequestParams, com.unionpay.tsmservice.ITsmActivityCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    unbindBleService();
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        safetyKeyboardRequestParams = (SafetyKeyboardRequestParams) SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = showSafetyKeyboard(safetyKeyboardRequestParams, parcel.readInt(), com.unionpay.tsmservice.OnSafetyKeyboardCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmActivityCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        safetyKeyboardRequestParams = (SafetyKeyboardRequestParams) SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 44:
                    GetEncryptDataRequestParams getEncryptDataRequestParams;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        getEncryptDataRequestParams = (GetEncryptDataRequestParams) GetEncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = getEncryptData(getEncryptDataRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = clearEncryptData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    init = hideKeyboard();
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        executeCmdRequestParams = (ExecuteCmdRequestParams) ExecuteCmdRequestParams.CREATOR.createFromParcel(parcel);
                    }
                    init = executeCmd(executeCmdRequestParams, com.unionpay.tsmservice.ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), com.unionpay.tsmservice.ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(init);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int appDataUpdate(AppDataUpdateRequestParams appDataUpdateRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int appDelete(AppDeleteRequestParams appDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int appDownload(AppDownloadRequestParams appDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int appDownloadApply(AppDownloadApplyRequestParams appDownloadApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int appLock(AppLockRequestParams appLockRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int appUnlock(AppUnlockRequestParams appUnlockRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int bleKeyExchange(BleKeyExchangeRequestParams bleKeyExchangeRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int checkBinCode(CheckBinRequestParams checkBinRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int clearEncryptData(int i) throws RemoteException;

    int closeChannel(String str, ITsmCallback iTsmCallback) throws RemoteException;

    int eCashTopUp(ECashTopUpRequestParams eCashTopUpRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int exchangeKey(ExchangeKeyRequestParams exchangeKeyRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int executeCmd(ExecuteCmdRequestParams executeCmdRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int getAccountBalance(GetAccountBalanceRequestParams getAccountBalanceRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAccountInfo(GetAccountInfoRequestParams getAccountInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getActiveCode(GetActiveCodeRequestParams getActiveCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAppDetail(GetAppDetailRequestParams getAppDetailRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAppList(GetAppListRequestParams getAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAppStatus(GetAppStatusRequestParams getAppStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAssociatedApp(GetAssociatedAppRequestParams getAssociatedAppRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getCardInfo(String[] strArr, ITsmCallback iTsmCallback) throws RemoteException;

    int getDefaultCard(ITsmCallback iTsmCallback) throws RemoteException;

    int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getPubKey(ITsmCallback iTsmCallback) throws RemoteException;

    int getSEAppList(ITsmCallback iTsmCallback) throws RemoteException;

    int getSEId(ITsmCallback iTsmCallback) throws RemoteException;

    int getSMSAuthCode(GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getSupportedCardTypeList(ITsmCallback iTsmCallback) throws RemoteException;

    int getTransElements(GetTransElementsRequestParams getTransElementsRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getTransRecord(GetTransRecordRequestParams getTransRecordRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getUniteAppList(GetUniteAppListRequestParams getUniteAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int hideAppApply(String str, ITsmCallback iTsmCallback) throws RemoteException;

    int hideKeyboard() throws RemoteException;

    int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int openCardApplyActivity(OpenCardApplyActivityRequestParams openCardApplyActivityRequestParams, ITsmActivityCallback iTsmActivityCallback, ITsmCallback iTsmCallback) throws RemoteException;

    int openCardDetailActivity(OpenCardDetailActivityRequestParams openCardDetailActivityRequestParams, ITsmActivityCallback iTsmActivityCallback) throws RemoteException;

    int openChannel(String str, ITsmCallback iTsmCallback) throws RemoteException;

    int openUniteCardApplyActivity(OpenUniteCardApplyActivityRequestParams openUniteCardApplyActivityRequestParams, ITsmActivityCallback iTsmActivityCallback, ITsmCallback iTsmCallback) throws RemoteException;

    int sendApdu(SendApduRequestParams sendApduRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int setDefaultCard(String str, ITsmCallback iTsmCallback) throws RemoteException;

    int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException;

    int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback) throws RemoteException;

    void unbindBleService() throws RemoteException;

    int uniteAppDelete(UniteAppDeleteRequestParams uniteAppDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int uniteAppDownload(UniteAppDownloadRequestParams uniteAppDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int uniteCardActive(UniteCardActiveRequestParams uniteCardActiveRequestParams, ITsmCallback iTsmCallback) throws RemoteException;
}
