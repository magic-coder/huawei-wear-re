package android.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IBluetoothInputDevice extends IInterface {

    public abstract class Stub extends Binder implements IBluetoothInputDevice {
        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothInputDevice";
        static final int TRANSACTION_connect = 1;
        static final int TRANSACTION_disconnect = 2;
        static final int TRANSACTION_getConnectedDevices = 3;
        static final int TRANSACTION_getConnectionState = 5;
        static final int TRANSACTION_getDevicesMatchingConnectionStates = 4;
        static final int TRANSACTION_getPriority = 7;
        static final int TRANSACTION_getProtocolMode = 8;
        static final int TRANSACTION_getReport = 11;
        static final int TRANSACTION_sendData = 13;
        static final int TRANSACTION_setPriority = 6;
        static final int TRANSACTION_setProtocolMode = 10;
        static final int TRANSACTION_setReport = 12;
        static final int TRANSACTION_virtualUnplug = 9;

        class Proxy implements IBluetoothInputDevice {
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

            public boolean connect(BluetoothDevice bluetoothDevice) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean disconnect(BluetoothDevice bluetoothDevice) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<BluetoothDevice> getConnectedDevices() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    List<BluetoothDevice> createTypedArrayList = obtain2.createTypedArrayList(BluetoothDevice.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    List<BluetoothDevice> createTypedArrayList = obtain2.createTypedArrayList(BluetoothDevice.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getConnectionState(BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setPriority(BluetoothDevice bluetoothDevice, int i) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getPriority(BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getProtocolMode(BluetoothDevice bluetoothDevice) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean virtualUnplug(BluetoothDevice bluetoothDevice) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setProtocolMode(BluetoothDevice bluetoothDevice, int i) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getReport(BluetoothDevice bluetoothDevice, byte b, byte b2, int i) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByte(b);
                    obtain.writeByte(b2);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setReport(BluetoothDevice bluetoothDevice, byte b, String str) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByte(b);
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean sendData(BluetoothDevice bluetoothDevice, String str) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBluetoothInputDevice asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothInputDevice)) {
                return new Proxy(iBinder);
            }
            return (IBluetoothInputDevice) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = 0;
            BluetoothDevice bluetoothDevice = null;
            boolean connect;
            List connectedDevices;
            int connectionState;
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = connect(bluetoothDevice);
                    parcel2.writeNoException();
                    parcel2.writeInt(connect ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = disconnect(bluetoothDevice);
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    connectedDevices = getConnectedDevices();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(connectedDevices);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    connectedDevices = getDevicesMatchingConnectionStates(parcel.createIntArray());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(connectedDevices);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connectionState = getConnectionState(bluetoothDevice);
                    parcel2.writeNoException();
                    parcel2.writeInt(connectionState);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = setPriority(bluetoothDevice, parcel.readInt());
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connectionState = getPriority(bluetoothDevice);
                    parcel2.writeNoException();
                    parcel2.writeInt(connectionState);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = getProtocolMode(bluetoothDevice);
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = virtualUnplug(bluetoothDevice);
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = setProtocolMode(bluetoothDevice, parcel.readInt());
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = getReport(bluetoothDevice, parcel.readByte(), parcel.readByte(), parcel.readInt());
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = setReport(bluetoothDevice, parcel.readByte(), parcel.readString());
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        bluetoothDevice = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
                    }
                    connect = sendData(bluetoothDevice, parcel.readString());
                    parcel2.writeNoException();
                    if (connect) {
                        i3 = 1;
                    }
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

    boolean connect(BluetoothDevice bluetoothDevice) throws RemoteException;

    boolean disconnect(BluetoothDevice bluetoothDevice) throws RemoteException;

    List<BluetoothDevice> getConnectedDevices() throws RemoteException;

    int getConnectionState(BluetoothDevice bluetoothDevice) throws RemoteException;

    List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) throws RemoteException;

    int getPriority(BluetoothDevice bluetoothDevice) throws RemoteException;

    boolean getProtocolMode(BluetoothDevice bluetoothDevice) throws RemoteException;

    boolean getReport(BluetoothDevice bluetoothDevice, byte b, byte b2, int i) throws RemoteException;

    boolean sendData(BluetoothDevice bluetoothDevice, String str) throws RemoteException;

    boolean setPriority(BluetoothDevice bluetoothDevice, int i) throws RemoteException;

    boolean setProtocolMode(BluetoothDevice bluetoothDevice, int i) throws RemoteException;

    boolean setReport(BluetoothDevice bluetoothDevice, byte b, String str) throws RemoteException;

    boolean virtualUnplug(BluetoothDevice bluetoothDevice) throws RemoteException;
}
