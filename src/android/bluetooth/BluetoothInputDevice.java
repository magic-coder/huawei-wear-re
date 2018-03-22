package android.bluetooth;

import android.bluetooth.BluetoothProfile.ServiceListener;
import android.bluetooth.IBluetoothStateChangeCallback.Stub;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class BluetoothInputDevice implements BluetoothProfile {
    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED";
    public static final String ACTION_PROTOCOL_MODE_CHANGED = "android.bluetooth.input.profile.action.PROTOCOL_MODE_CHANGED";
    public static final String ACTION_VIRTUAL_UNPLUG_STATUS = "android.bluetooth.input.profile.action.VIRTUAL_UNPLUG_STATUS";
    private static final boolean DBG = true;
    public static final String EXTRA_PROTOCOL_MODE = "android.bluetooth.BluetoothInputDevice.extra.PROTOCOL_MODE";
    public static final String EXTRA_REPORT = "android.bluetooth.BluetoothInputDevice.extra.REPORT";
    public static final String EXTRA_REPORT_BUFFER_SIZE = "android.bluetooth.BluetoothInputDevice.extra.REPORT_BUFFER_SIZE";
    public static final String EXTRA_REPORT_ID = "android.bluetooth.BluetoothInputDevice.extra.REPORT_ID";
    public static final String EXTRA_REPORT_TYPE = "android.bluetooth.BluetoothInputDevice.extra.REPORT_TYPE";
    public static final String EXTRA_VIRTUAL_UNPLUG_STATUS = "android.bluetooth.BluetoothInputDevice.extra.VIRTUAL_UNPLUG_STATUS";
    public static final int INPUT_CONNECT_FAILED_ALREADY_CONNECTED = 5001;
    public static final int INPUT_CONNECT_FAILED_ATTEMPT_FAILED = 5002;
    public static final int INPUT_DISCONNECT_FAILED_NOT_CONNECTED = 5000;
    public static final int INPUT_OPERATION_GENERIC_FAILURE = 5003;
    public static final int INPUT_OPERATION_SUCCESS = 5004;
    public static final int PROTOCOL_BOOT_MODE = 1;
    public static final int PROTOCOL_REPORT_MODE = 0;
    public static final int PROTOCOL_UNSUPPORTED_MODE = 255;
    public static final byte REPORT_TYPE_FEATURE = (byte) 2;
    public static final byte REPORT_TYPE_INPUT = (byte) 0;
    public static final byte REPORT_TYPE_OUTPUT = (byte) 1;
    private static final String TAG = "BluetoothInputDevice";
    private static final boolean VDBG = false;
    public static final int VIRTUAL_UNPLUG_STATUS_FAIL = 1;
    public static final int VIRTUAL_UNPLUG_STATUS_SUCCESS = 0;
    private BluetoothAdapter mAdapter;
    private final IBluetoothStateChangeCallback mBluetoothStateChangeCallback = new C28541();
    private ServiceConnection mConnection = new C28552();
    private Context mContext;
    private IBluetoothInputDevice mService;
    private ServiceListener mServiceListener;

    class C28541 extends Stub {
        C28541() {
        }

        public void onBluetoothStateChange(boolean z) {
            Log.d(BluetoothInputDevice.TAG, "onBluetoothStateChange: up=" + z);
            if (z) {
                synchronized (BluetoothInputDevice.this.mConnection) {
                    try {
                        if (BluetoothInputDevice.this.mService == null && !BluetoothInputDevice.this.mContext.bindService(new Intent(IBluetoothInputDevice.class.getName()), BluetoothInputDevice.this.mConnection, 0)) {
                            Log.e(BluetoothInputDevice.TAG, "Could not bind to Bluetooth HID Service");
                        }
                    } catch (Throwable e) {
                        Log.e(BluetoothInputDevice.TAG, "", e);
                    }
                }
                return;
            }
            synchronized (BluetoothInputDevice.this.mConnection) {
                try {
                    BluetoothInputDevice.this.mService = null;
                    BluetoothInputDevice.this.mContext.unbindService(BluetoothInputDevice.this.mConnection);
                } catch (Throwable e2) {
                    Log.e(BluetoothInputDevice.TAG, "", e2);
                }
            }
        }
    }

    class C28552 implements ServiceConnection {
        C28552() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(BluetoothInputDevice.TAG, "Proxy object connected");
            BluetoothInputDevice.this.mService = IBluetoothInputDevice.Stub.asInterface(iBinder);
            if (BluetoothInputDevice.this.mServiceListener != null) {
                BluetoothInputDevice.this.mServiceListener.onServiceConnected(4, BluetoothInputDevice.this);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(BluetoothInputDevice.TAG, "Proxy object disconnected");
            BluetoothInputDevice.this.mService = null;
            if (BluetoothInputDevice.this.mServiceListener != null) {
                BluetoothInputDevice.this.mServiceListener.onServiceDisconnected(4);
            }
        }
    }

    BluetoothInputDevice(Context context, ServiceListener serviceListener) {
        this.mContext = context;
        this.mServiceListener = serviceListener;
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        IBluetoothManager bluetoothManager = this.mAdapter.getBluetoothManager();
        if (bluetoothManager != null) {
            try {
                bluetoothManager.registerStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (Throwable e) {
                Log.e(TAG, "", e);
            }
        }
        if (!context.bindService(new Intent(IBluetoothInputDevice.class.getName()), this.mConnection, 0)) {
            Log.e(TAG, "Could not bind to Bluetooth HID Service");
        }
    }

    void close() {
        IBluetoothManager bluetoothManager = this.mAdapter.getBluetoothManager();
        if (bluetoothManager != null) {
            try {
                bluetoothManager.unregisterStateChangeCallback(this.mBluetoothStateChangeCallback);
            } catch (Throwable e) {
                Log.e(TAG, "", e);
            }
        }
        synchronized (this.mConnection) {
            if (this.mService != null) {
                try {
                    this.mService = null;
                    this.mContext.unbindService(this.mConnection);
                } catch (Throwable e2) {
                    Log.e(TAG, "", e2);
                }
            }
        }
        this.mServiceListener = null;
    }

    public boolean connect(BluetoothDevice bluetoothDevice) {
        boolean z = false;
        log("connect(" + bluetoothDevice + ")");
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.connect(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public boolean disconnect(BluetoothDevice bluetoothDevice) {
        boolean z = false;
        log("disconnect(" + bluetoothDevice + ")");
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.disconnect(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public List<BluetoothDevice> getConnectedDevices() {
        if (this.mService == null || !isEnabled()) {
            if (this.mService == null) {
                Log.w(TAG, "Proxy not attached to service");
            }
            return new ArrayList();
        }
        try {
            return this.mService.getConnectedDevices();
        } catch (RemoteException e) {
            Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            return new ArrayList();
        }
    }

    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] iArr) {
        if (this.mService == null || !isEnabled()) {
            if (this.mService == null) {
                Log.w(TAG, "Proxy not attached to service");
            }
            return new ArrayList();
        }
        try {
            return this.mService.getDevicesMatchingConnectionStates(iArr);
        } catch (RemoteException e) {
            Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            return new ArrayList();
        }
    }

    public int getConnectionState(BluetoothDevice bluetoothDevice) {
        int i = 0;
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                i = this.mService.getConnectionState(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return i;
    }

    public boolean setPriority(BluetoothDevice bluetoothDevice, int i) {
        boolean z = false;
        log("setPriority(" + bluetoothDevice + ", " + i + ")");
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            if (i == 0 || i == 100) {
                try {
                    z = this.mService.setPriority(bluetoothDevice, i);
                } catch (RemoteException e) {
                    Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
                }
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public int getPriority(BluetoothDevice bluetoothDevice) {
        int i = 0;
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                i = this.mService.getPriority(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return i;
    }

    private boolean isEnabled() {
        if (this.mAdapter.getState() == 12) {
            return true;
        }
        return false;
    }

    private boolean isValidDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress())) {
            return true;
        }
        return false;
    }

    public boolean virtualUnplug(BluetoothDevice bluetoothDevice) {
        boolean z = false;
        log("virtualUnplug(" + bluetoothDevice + ")");
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.virtualUnplug(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public boolean getProtocolMode(BluetoothDevice bluetoothDevice) {
        boolean z = false;
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.getProtocolMode(bluetoothDevice);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public boolean setProtocolMode(BluetoothDevice bluetoothDevice, int i) {
        boolean z = false;
        log("setProtocolMode(" + bluetoothDevice + ")");
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.setProtocolMode(bluetoothDevice, i);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public boolean getReport(BluetoothDevice bluetoothDevice, byte b, byte b2, int i) {
        boolean z = false;
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.getReport(bluetoothDevice, b, b2, i);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public boolean setReport(BluetoothDevice bluetoothDevice, byte b, String str) {
        boolean z = false;
        log("setReport(" + bluetoothDevice + "), reportType=" + b + " report=" + str);
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.setReport(bluetoothDevice, b, str);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    public boolean sendData(BluetoothDevice bluetoothDevice, String str) {
        boolean z = false;
        log("sendData(" + bluetoothDevice + "), report=" + str);
        if (this.mService != null && isEnabled() && isValidDevice(bluetoothDevice)) {
            try {
                z = this.mService.sendData(bluetoothDevice, str);
            } catch (RemoteException e) {
                Log.e(TAG, "Stack:" + Log.getStackTraceString(new Throwable()));
            }
        } else if (this.mService == null) {
            Log.w(TAG, "Proxy not attached to service");
        }
        return z;
    }

    private static void log(String str) {
        Log.d(TAG, str);
    }
}
