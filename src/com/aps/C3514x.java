package com.aps;

import android.location.GpsSatellite;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class C3514x implements Listener, NmeaListener {
    private long f13240a = 0;
    private long f13241b = 0;
    private boolean f13242c = false;
    private List f13243d = new ArrayList();
    private String f13244e = null;
    private String f13245f = null;
    private String f13246g = null;
    private /* synthetic */ bz f13247h;

    protected C3514x(bz bzVar) {
        this.f13247h = bzVar;
    }

    public final void m17631a(String str) {
        if (System.currentTimeMillis() - this.f13241b > 400 && this.f13242c && this.f13243d.size() > 0) {
            try {
                bx bxVar = new bx(this.f13243d, this.f13244e, null, this.f13246g);
                if (bxVar.m17468a()) {
                    this.f13247h.f13125O = bz.m17472a(this.f13247h, bxVar, this.f13247h.f13122L);
                    if (this.f13247h.f13125O > 0) {
                        bz.m17490b(this.f13247h, String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", new Object[]{Double.valueOf(bxVar.m17470c()), Double.valueOf(bxVar.m17469b()), Integer.valueOf(this.f13247h.f13125O)}));
                    }
                } else {
                    this.f13247h.f13125O = 0;
                }
            } catch (Exception e) {
                this.f13247h.f13125O = 0;
            }
            this.f13243d.clear();
            this.f13246g = null;
            this.f13245f = null;
            this.f13244e = null;
            this.f13242c = false;
        }
        if (str.startsWith("$GPGGA")) {
            this.f13242c = true;
            this.f13244e = str.trim();
        } else if (str.startsWith("$GPGSV")) {
            this.f13243d.add(str.trim());
        } else if (str.startsWith("$GPGSA")) {
            this.f13246g = str.trim();
        }
        this.f13241b = System.currentTimeMillis();
    }

    public final void onGpsStatusChanged(int i) {
        int i2 = 0;
        try {
            if (this.f13247h.f13134s != null) {
                switch (i) {
                    case 2:
                        this.f13247h.f13124N = 0;
                        return;
                    case 4:
                        if (bz.f13101a || System.currentTimeMillis() - this.f13240a >= 10000) {
                            if (this.f13247h.f13120J == null) {
                                this.f13247h.f13120J = this.f13247h.f13134s.getGpsStatus(null);
                            } else {
                                this.f13247h.f13134s.getGpsStatus(this.f13247h.f13120J);
                            }
                            this.f13247h.f13121K = 0;
                            this.f13247h.f13122L = 0;
                            this.f13247h.f13123M = new HashMap();
                            int i3 = 0;
                            int i4 = 0;
                            for (GpsSatellite gpsSatellite : this.f13247h.f13120J.getSatellites()) {
                                i3++;
                                if (gpsSatellite.usedInFix()) {
                                    i4++;
                                }
                                if (gpsSatellite.getSnr() > 0.0f) {
                                    i2++;
                                }
                                if (gpsSatellite.getSnr() >= ((float) bz.f13098X)) {
                                    this.f13247h.f13122L = this.f13247h.f13122L + 1;
                                }
                            }
                            if (this.f13247h.f13128m == -1 || ((i4 >= 4 && this.f13247h.f13128m < 4) || (i4 < 4 && this.f13247h.f13128m >= 4))) {
                                this.f13247h.f13128m = i4;
                                if (i4 < 4) {
                                    if (this.f13247h.f13135t != null) {
                                        this.f13247h.f13135t.m17627w();
                                    }
                                } else if (this.f13247h.f13135t != null) {
                                    this.f13247h.f13135t.m17626v();
                                }
                            }
                            this.f13247h.f13124N = i2;
                            this.f13247h.m17473a(this.f13247h.f13123M);
                            if (!bz.f13101a) {
                                if ((i4 > 3 || i3 > 15) && this.f13247h.f13134s.getLastKnownLocation("gps") != null) {
                                    this.f13240a = System.currentTimeMillis();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onNmeaReceived(long j, String str) {
        try {
            if (bz.f13101a && str != null && !str.equals("") && str.length() >= 9 && str.length() <= 150) {
                this.f13247h.f13116F.sendMessage(this.f13247h.f13116F.obtainMessage(1, str));
            }
        } catch (Exception e) {
        }
    }
}
