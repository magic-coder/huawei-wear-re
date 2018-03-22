package com.aps;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

/* compiled from: APS */
class ad extends PhoneStateListener {
    final /* synthetic */ ac f12889a;

    ad(ac acVar) {
        this.f12889a = acVar;
    }

    public void onCellLocationChanged(CellLocation cellLocation) {
        if (cellLocation != null) {
            try {
                if (!this.f12889a.m17246q()) {
                    this.f12889a.f12861J = cellLocation;
                    this.f12889a.f12852A = bu.m17460b();
                    this.f12889a.f12888z = bu.m17460b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void onSignalStrengthChanged(int i) {
        int i2 = -113;
        try {
            switch (this.f12889a.f12872j) {
                case 1:
                    i2 = bu.m17448a(i);
                    break;
                case 2:
                    i2 = bu.m17448a(i);
                    break;
            }
            this.f12889a.m17218b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        int i = -113;
        try {
            switch (this.f12889a.f12872j) {
                case 1:
                    i = bu.m17448a(signalStrength.getGsmSignalStrength());
                    break;
                case 2:
                    i = signalStrength.getCdmaDbm();
                    break;
            }
            this.f12889a.m17218b(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onServiceStateChanged(ServiceState serviceState) {
        try {
            switch (serviceState.getState()) {
                case 1:
                    this.f12889a.f12876n.clear();
                    this.f12889a.f12881s = -113;
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
