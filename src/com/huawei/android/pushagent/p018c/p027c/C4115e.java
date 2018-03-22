package com.huawei.android.pushagent.p018c.p027c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;

public class C4115e {
    private static boolean f15509a = false;
    private static boolean f15510b = false;

    public static void m20143a(int i, int i2) {
        Parcel obtain;
        RemoteException e;
        Throwable th;
        Parcel parcel = null;
        e.a("PushLogAC2712", "ctrlSocket cmd is " + i + ", param is " + i2);
        try {
            IBinder service = ServiceManager.getService("connectivity");
            if (service == null) {
                e.c("PushLogAC2712", "get connectivity service failed ");
                if (parcel != null) {
                    parcel.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                    return;
                }
                return;
            }
            obtain = Parcel.obtain();
            try {
                obtain.writeInt(Process.myPid());
                obtain.writeInt(i);
                obtain.writeInt(i2);
                parcel = Parcel.obtain();
                service.transact(1003, obtain, parcel, 0);
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } catch (RemoteException e2) {
                e = e2;
                try {
                    e.d("PushLogAC2712", "ctrlSocket error:" + e.getMessage());
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                th = e3;
                e.c("PushLogAC2712", "ctrlSocket error:", th);
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            }
        } catch (RemoteException e4) {
            e = e4;
            obtain = parcel;
            e.d("PushLogAC2712", "ctrlSocket error:" + e.getMessage());
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
        } catch (Exception e5) {
            th = e5;
            obtain = parcel;
            e.c("PushLogAC2712", "ctrlSocket error:", th);
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
        } catch (Throwable th3) {
            th = th3;
            obtain = parcel;
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
    }

    public static void m20144a(String str) {
        Parcel obtain;
        RemoteException e;
        Throwable th;
        Parcel parcel = null;
        e.a("PushLogAC2712", "ctrlScoket registerPackage " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                IBinder service = ServiceManager.getService("connectivity");
                if (service == null) {
                    e.c("PushLogAC2712", "get connectivity service failed ");
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                        return;
                    }
                    return;
                }
                obtain = Parcel.obtain();
                try {
                    obtain.writeString(str);
                    parcel = Parcel.obtain();
                    service.transact(1001, obtain, parcel, 0);
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                } catch (RemoteException e2) {
                    e = e2;
                    try {
                        e.d("PushLogAC2712", "registerPackage error:" + e.getMessage());
                        if (obtain != null) {
                            obtain.recycle();
                        }
                        if (parcel != null) {
                            parcel.recycle();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (obtain != null) {
                            obtain.recycle();
                        }
                        if (parcel != null) {
                            parcel.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    th = e3;
                    e.c("PushLogAC2712", "registerPackage error:", th);
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                }
            } catch (RemoteException e4) {
                e = e4;
                obtain = parcel;
                e.d("PushLogAC2712", "registerPackage error:" + e.getMessage());
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } catch (Exception e5) {
                th = e5;
                obtain = parcel;
                e.c("PushLogAC2712", "registerPackage error:", th);
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } catch (Throwable th3) {
                th = th3;
                obtain = parcel;
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
                throw th;
            }
        }
    }

    public static String[] m20145a() {
        Parcel obtain;
        RemoteException e;
        Throwable th;
        Throwable e2;
        Parcel parcel = null;
        String[] strArr = new String[0];
        try {
            IBinder service = ServiceManager.getService("connectivity");
            if (service == null) {
                e.c("PushLogAC2712", "get connectivity service failed ");
                if (parcel != null) {
                    parcel.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } else {
                obtain = Parcel.obtain();
                try {
                    parcel = Parcel.obtain();
                    service.transact(1004, obtain, parcel, 0);
                    Object readString = parcel.readString();
                    e.a("PushLogAC2712", "ctrlSocket whitepackages is:" + readString);
                    if (!TextUtils.isEmpty(readString)) {
                        strArr = readString.split("\t");
                    }
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                } catch (RemoteException e3) {
                    e = e3;
                    try {
                        e.d("PushLogAC2712", "ctrlSocket error:" + e.getMessage());
                        if (obtain != null) {
                            obtain.recycle();
                        }
                        if (parcel != null) {
                            parcel.recycle();
                        }
                        return strArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (obtain != null) {
                            obtain.recycle();
                        }
                        if (parcel != null) {
                            parcel.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    e.c("PushLogAC2712", "ctrlSocket error:", e2);
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    return strArr;
                }
            }
        } catch (RemoteException e5) {
            e = e5;
            obtain = parcel;
            e.d("PushLogAC2712", "ctrlSocket error:" + e.getMessage());
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            return strArr;
        } catch (Exception e6) {
            e2 = e6;
            obtain = parcel;
            e.c("PushLogAC2712", "ctrlSocket error:", e2);
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            return strArr;
        } catch (Throwable th3) {
            th = th3;
            obtain = parcel;
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
        return strArr;
    }

    public static int m20146b() {
        Parcel obtain;
        RemoteException e;
        Throwable th;
        Throwable e2;
        Parcel parcel = null;
        int i = -1;
        try {
            IBinder service = ServiceManager.getService("connectivity");
            if (service == null) {
                e.c("PushLogAC2712", "get connectivity service failed ");
                if (parcel != null) {
                    parcel.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
                return i;
            }
            obtain = Parcel.obtain();
            try {
                parcel = Parcel.obtain();
                service.transact(1005, obtain, parcel, 0);
                i = parcel.readInt();
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } catch (RemoteException e3) {
                e = e3;
                try {
                    e.d("PushLogAC2712", "getCtrlSocketModel error:" + e.getMessage());
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    e.a("PushLogAC2712", "ctrlSocket level is:" + i);
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                e.c("PushLogAC2712", "getCtrlSocketModel error:", e2);
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
                e.a("PushLogAC2712", "ctrlSocket level is:" + i);
                return i;
            }
            e.a("PushLogAC2712", "ctrlSocket level is:" + i);
            return i;
        } catch (RemoteException e5) {
            e = e5;
            obtain = parcel;
            e.d("PushLogAC2712", "getCtrlSocketModel error:" + e.getMessage());
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            e.a("PushLogAC2712", "ctrlSocket level is:" + i);
            return i;
        } catch (Exception e6) {
            e2 = e6;
            obtain = parcel;
            e.c("PushLogAC2712", "getCtrlSocketModel error:", e2);
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            e.a("PushLogAC2712", "ctrlSocket level is:" + i);
            return i;
        } catch (Throwable th3) {
            th = th3;
            obtain = parcel;
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
    }

    public static void m20147b(String str) {
        Parcel obtain;
        RemoteException e;
        Throwable th;
        Parcel parcel = null;
        e.a("PushLogAC2712", "ctrlScoket deregisterPackage " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                IBinder service = ServiceManager.getService("connectivity");
                if (service == null) {
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                        return;
                    }
                    return;
                }
                obtain = Parcel.obtain();
                try {
                    obtain.writeString(str);
                    parcel = Parcel.obtain();
                    service.transact(1002, obtain, parcel, 0);
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                } catch (RemoteException e2) {
                    e = e2;
                    try {
                        e.d("PushLogAC2712", "deregisterPackage error:" + e.getMessage());
                        if (obtain != null) {
                            obtain.recycle();
                        }
                        if (parcel != null) {
                            parcel.recycle();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (obtain != null) {
                            obtain.recycle();
                        }
                        if (parcel != null) {
                            parcel.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    th = e3;
                    e.c("PushLogAC2712", "deregisterPackage error:", th);
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                }
            } catch (RemoteException e4) {
                e = e4;
                obtain = parcel;
                e.d("PushLogAC2712", "deregisterPackage error:" + e.getMessage());
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } catch (Exception e5) {
                th = e5;
                obtain = parcel;
                e.c("PushLogAC2712", "deregisterPackage error:", th);
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } catch (Throwable th3) {
                th = th3;
                obtain = parcel;
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
                throw th;
            }
        }
    }

    public static synchronized boolean m20148c() {
        boolean z;
        synchronized (C4115e.class) {
            String str = "v2";
            if (!f15509a) {
                f15509a = true;
                f15510b = str.equals(C4115e.m20149d());
            }
            z = f15510b;
        }
        return z;
    }

    private static String m20149d() {
        Parcel obtain;
        RemoteException e;
        Throwable th;
        Throwable e2;
        Parcel parcel = null;
        String str = "";
        try {
            IBinder service = ServiceManager.getService("connectivity");
            if (service == null) {
                e.c("PushLogAC2712", "get connectivity service failed ");
                if (parcel != null) {
                    parcel.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
                return str;
            }
            obtain = Parcel.obtain();
            try {
                parcel = Parcel.obtain();
                service.transact(1006, obtain, parcel, 0);
                str = parcel.readString();
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            } catch (RemoteException e3) {
                e = e3;
                try {
                    e.d("PushLogAC2712", "getCtrlSocketVersion error:" + e.getMessage());
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    e.a("PushLogAC2712", "ctrlSocket version is:" + str);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (obtain != null) {
                        obtain.recycle();
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                e.c("PushLogAC2712", "getCtrlSocketVersion error:", e2);
                if (obtain != null) {
                    obtain.recycle();
                }
                if (parcel != null) {
                    parcel.recycle();
                }
                e.a("PushLogAC2712", "ctrlSocket version is:" + str);
                return str;
            }
            e.a("PushLogAC2712", "ctrlSocket version is:" + str);
            return str;
        } catch (RemoteException e5) {
            e = e5;
            obtain = parcel;
            e.d("PushLogAC2712", "getCtrlSocketVersion error:" + e.getMessage());
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            e.a("PushLogAC2712", "ctrlSocket version is:" + str);
            return str;
        } catch (Exception e6) {
            e2 = e6;
            obtain = parcel;
            e.c("PushLogAC2712", "getCtrlSocketVersion error:", e2);
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            e.a("PushLogAC2712", "ctrlSocket version is:" + str);
            return str;
        } catch (Throwable th3) {
            th = th3;
            obtain = parcel;
            if (obtain != null) {
                obtain.recycle();
            }
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
    }
}
