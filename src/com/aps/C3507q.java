package com.aps;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

final class C3507q extends PhoneStateListener {
    private /* synthetic */ C3505o f13234a;

    private C3507q(C3505o c3505o) {
        this.f13234a = c3505o;
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        try {
            this.f13234a.f13227t = System.currentTimeMillis();
            this.f13234a.f13230x = cellLocation;
            super.onCellLocationChanged(cellLocation);
        } catch (Exception e) {
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        try {
            if (serviceState.getState() == 0) {
                this.f13234a.f13218k = true;
                String[] a = C3505o.m17584b(this.f13234a.f13209b);
                this.f13234a.f13222o = Integer.parseInt(a[0]);
                this.f13234a.f13223p = Integer.parseInt(a[1]);
            } else {
                this.f13234a.f13218k = false;
            }
            super.onServiceStateChanged(serviceState);
        } catch (Exception e) {
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        try {
            if (this.f13234a.f13216i) {
                this.f13234a.f13217j = signalStrength.getCdmaDbm();
            } else {
                this.f13234a.f13217j = signalStrength.getGsmSignalStrength();
                if (this.f13234a.f13217j == 99) {
                    this.f13234a.f13217j = -1;
                } else {
                    this.f13234a.f13217j = (this.f13234a.f13217j * 2) - 113;
                }
            }
            super.onSignalStrengthsChanged(signalStrength);
        } catch (Exception e) {
        }
    }
}
