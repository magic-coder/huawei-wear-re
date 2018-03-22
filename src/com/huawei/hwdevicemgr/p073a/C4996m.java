package com.huawei.hwdevicemgr.p073a;

import android.os.HandlerThread;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C4995c;
import com.huawei.p190v.C2538c;

/* compiled from: OTATransferFile */
class C4996m implements C4995c {
    final /* synthetic */ C4991j f18114a;

    C4996m(C4991j c4991j) {
        this.f18114a = c4991j;
    }

    public void mo4607a(Object obj) {
        if (this.f18114a.f18109x != null) {
            this.f18114a.f18109x.removeMessages(1);
        }
        if (this.f18114a.f18108w != null) {
            this.f18114a.f18108w.getLooper().quit();
            this.f18114a.f18108w = null;
            this.f18114a.f18109x = null;
            C2538c.c("OTATransferFile", new Object[]{"mHandlerThread close.set mOtaHandler null"});
        }
        C2538c.c("OTATransferFile", new Object[]{"ota crc result is " + ((Byte) obj).byteValue()});
        if (this.f18114a.f18104s != null) {
            this.f18114a.f18104s.b(r6.byteValue());
        }
        this.f18114a.f18095j = 0;
        this.f18114a.f18096k = false;
    }

    public void mo4608a(byte[] bArr) {
        this.f18114a.f18098m = this.f18114a.f18098m + 1;
        if (bArr[1] == (byte) 0) {
            C2538c.c("OTATransferFile", new Object[]{"onReceive,mErrorPackages.size()==0,mChunksDone=" + this.f18114a.f18098m});
            if ((this.f18114a.f18098m * 100) / this.f18114a.f18094i > this.f18114a.f18095j && this.f18114a.f18095j < 100) {
                this.f18114a.f18095j = (this.f18114a.f18098m * 100) / this.f18114a.f18094i;
                if (this.f18114a.f18104s != null) {
                    this.f18114a.f18104s.a(this.f18114a.f18095j);
                }
                C2538c.c("OTATransferFile", new Object[]{"onFileTransferState,mProcessB0=" + this.f18114a.f18095j});
            }
            if (100 == this.f18114a.f18095j) {
                C2538c.c("OTATransferFile", new Object[]{"transfer file over ,set mProcessB0 0. start a Timer"});
                if (this.f18114a.f18109x == null || this.f18114a.f18108w == null) {
                    this.f18114a.f18108w = new HandlerThread("OTATransferFile");
                    this.f18114a.f18108w.start();
                    this.f18114a.f18109x = new C4997n(this.f18114a, this.f18114a.f18108w.getLooper());
                }
                this.f18114a.f18109x.sendEmptyMessageDelayed(1, StatisticConfig.MIN_UPLOAD_INTERVAL);
                this.f18114a.f18095j = 0;
            }
            if (this.f18114a.f18098m < this.f18114a.f18094i) {
                this.f18114a.m23940a(this.f18114a.f18098m + 1, false);
                return;
            }
            return;
        }
        this.f18114a.f18090e = 5;
        this.f18114a.m23988c();
    }

    public void mo4606a(int i, String str) {
        if (104005 == i) {
            this.f18114a.f18090e = 5;
            this.f18114a.f18098m = this.f18114a.f18098m + 1;
            this.f18114a.m23988c();
        } else if (this.f18114a.f18096k && this.f18114a.f18104s != null) {
            this.f18114a.f18104s.a(i, str);
            this.f18114a.f18095j = 0;
            this.f18114a.f18096k = false;
        }
    }

    public void mo4605a() {
        this.f18114a.f18098m = this.f18114a.f18098m + 1;
        if (this.f18114a.f18097l.size() <= 0) {
            C2538c.c("OTATransferFile", new Object[]{"onReceiveNoAck, mChunksDone = " + this.f18114a.f18098m});
            if ((this.f18114a.f18098m * 100) / this.f18114a.f18094i > this.f18114a.f18095j && this.f18114a.f18095j < 100) {
                this.f18114a.f18095j = (this.f18114a.f18098m * 100) / this.f18114a.f18094i;
                if (this.f18114a.f18104s != null) {
                    this.f18114a.f18104s.a(this.f18114a.f18095j);
                }
                C2538c.c("OTATransferFile", new Object[]{"onFileTransferState,mProcessB0=" + this.f18114a.f18095j});
            }
            if (100 == this.f18114a.f18095j) {
                this.f18114a.f18095j = 0;
            }
            this.f18114a.m23940a(this.f18114a.f18098m + 1, false);
        } else if (1 == this.f18114a.f18097l.size()) {
            this.f18114a.m23940a(((Integer) this.f18114a.f18097l.get(0)).intValue(), true);
            this.f18114a.f18097l.remove(0);
        } else {
            C2538c.e("OTATransferFile", new Object[]{"onReceiveNoAck, mErrorPackages.size != 0 , mErrorPackages.size = " + this.f18114a.f18097l.size()});
            int intValue = ((Integer) this.f18114a.f18097l.get(0)).intValue();
            this.f18114a.f18097l.remove(0);
            this.f18114a.m23940a(intValue, false);
        }
    }
}
