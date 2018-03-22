package com.aps;

import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

public final class ai {
    int f12896a = Integer.MAX_VALUE;
    int f12897b = Integer.MAX_VALUE;
    int f12898c = Integer.MAX_VALUE;
    int f12899d = Integer.MAX_VALUE;
    int f12900e = Integer.MAX_VALUE;

    ai(CellLocation cellLocation) {
        if (cellLocation == null) {
            return;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            this.f12900e = gsmCellLocation.getCid();
            this.f12899d = gsmCellLocation.getLac();
        } else if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            this.f12898c = cdmaCellLocation.getBaseStationId();
            this.f12897b = cdmaCellLocation.getNetworkId();
            this.f12896a = cdmaCellLocation.getSystemId();
        }
    }
}
