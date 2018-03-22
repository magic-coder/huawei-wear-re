package com.huawei.hwbtsdk.btmanager.p401a;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbtsdk.p057b.p400b.C4628e;
import com.huawei.hwbtsdk.p399a.C4612o;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: BTDeviceV2ProtocolDataWrap */
public class C4632d extends C4629a {
    private Context f16914a = null;
    private int f16915b = -1;
    private int f16916c = 0;
    private int f16917d = 0;
    private String f16918e;

    public C4632d(Context context, int i) {
        this.f16914a = context;
        this.f16915b = i;
    }

    private void m22157a(int i, byte[] bArr, ArrayList<byte[]> arrayList) {
        int i2 = 0;
        byte[] b = C0973a.b(C0973a.b(i + 1));
        int i3 = (i + 4) + 2;
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        byte[] bArr2 = new byte[(i3 - 2)];
        allocate.put(TagName.PREDEPOSIT_TOTAL);
        bArr2[0] = TagName.PREDEPOSIT_TOTAL;
        allocate.put(b);
        for (i3 = 0; i3 < b.length; i3++) {
            bArr2[i3 + 1] = b[i3];
        }
        allocate.put((byte) 0);
        bArr2[3] = (byte) 0;
        allocate.put(bArr);
        i3 = 4;
        while (i2 < bArr.length) {
            bArr2[i3] = bArr[i2];
            i3++;
            i2++;
        }
        allocate.put(C4612o.m22004a(this.f16914a).m22013a(bArr2));
        allocate.flip();
        arrayList.add(allocate.array());
    }

    private void m22158b(int i, byte[] bArr, ArrayList<byte[]> arrayList) {
        int i2 = ((this.f16915b - 4) - 1) - 2;
        int i3 = i % i2 > 0 ? (i / i2) + 1 : i / i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5;
            if (i4 == i3 - 1) {
                i5 = i - (i4 * i2);
            } else {
                i5 = i2;
            }
            int i6 = i4 * i2;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i6, i6 + i5);
            byte[] b = C0973a.b(C0973a.b((i5 + 1) + 1));
            i5 = (i5 + 5) + 2;
            ByteBuffer allocate = ByteBuffer.allocate(i5);
            byte[] bArr2 = new byte[(i5 - 2)];
            allocate.put(TagName.PREDEPOSIT_TOTAL);
            bArr2[0] = TagName.PREDEPOSIT_TOTAL;
            allocate.put(b);
            for (i5 = 0; i5 < b.length; i5++) {
                bArr2[i5 + 1] = b[i5];
            }
            if (i4 == 0) {
                allocate.put((byte) 1);
                bArr2[3] = (byte) 1;
            } else if (i4 == i3 - 1) {
                allocate.put((byte) 3);
                bArr2[3] = (byte) 3;
            } else {
                allocate.put((byte) 2);
                bArr2[3] = (byte) 2;
            }
            allocate.put((byte) i4);
            bArr2[4] = (byte) i4;
            allocate.put(copyOfRange);
            i6 = 5;
            for (byte b2 : copyOfRange) {
                bArr2[i6] = b2;
                i6++;
            }
            allocate.put(C4612o.m22004a(this.f16914a).m22013a(bArr2));
            allocate.flip();
            arrayList.add(allocate.array());
        }
    }

    public ArrayList<byte[]> mo4542a(int i, byte[] bArr) {
        if (i <= 0 || bArr == null) {
            return null;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        if ((i + 4) + 2 <= this.f16915b) {
            m22157a(i, bArr, arrayList);
            return arrayList;
        }
        m22158b(i, bArr, arrayList);
        return arrayList;
    }

    public List<C4628e> mo4543b(int i, byte[] bArr) {
        C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"Enter parseResponsePacket()."});
        List<C4628e> arrayList = new ArrayList();
        String a = a.a(bArr);
        if (a.length() < 6) {
            C2538c.b("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHex length is invalid with data = " + a});
            return arrayList;
        }
        int parseInt = Integer.parseInt(a.substring(2, 6), 16);
        int parseInt2;
        if ((parseInt + 3) + 2 == i) {
            C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"Single package."});
            C4628e c4628e = new C4628e();
            if (bArr[0] != TagName.PREDEPOSIT_TOTAL) {
                c4628e.f16909d = false;
                return null;
            } else if (a.length() < 8) {
                C2538c.b("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHex length is invalid with data = " + a});
                return arrayList;
            } else {
                parseInt2 = Integer.parseInt(a.substring(6, 8), 16) & 3;
                if (parseInt2 == 0) {
                    c4628e.f16906a = false;
                    c4628e.f16908c = Arrays.copyOfRange(bArr, 4, i - 2);
                    c4628e.f16909d = true;
                    c4628e.f16907b = parseInt - 1;
                    c4628e.f16910e = true;
                } else {
                    c4628e.f16906a = true;
                    c4628e.f16908c = Arrays.copyOfRange(bArr, 5, i - 2);
                    c4628e.f16909d = true;
                    c4628e.f16907b = (parseInt - 1) - 1;
                    if (3 == parseInt2) {
                        c4628e.f16910e = true;
                    } else {
                        c4628e.f16910e = false;
                    }
                }
                arrayList.add(c4628e);
                return arrayList;
            }
        }
        C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"Multi package."});
        List arrayList2 = new ArrayList();
        int length = a.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            parseInt = i3 + 2;
            parseInt2 = i3 + 6;
            if (length < parseInt2) {
                C2538c.b("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHex length is invalid for check MFS length with data = " + a});
                this.f16918e = a.substring(i3, length);
                this.f16916c = this.f16918e.length() / 2;
                C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"The left data len less then header length with left data = " + this.f16918e});
                return arrayList;
            }
            int parseInt3 = Integer.parseInt(a.substring(parseInt, parseInt2), 16);
            parseInt = i3 + 6;
            parseInt2 = i3 + 8;
            if (length < parseInt2) {
                C2538c.b("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHex length is invalid for check MFS length and control with data = " + a});
                this.f16918e = a.substring(i3, length);
                this.f16916c = parseInt3;
                C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"The left data len less then header length with left data = " + this.f16918e});
                return arrayList;
            }
            C4628e c4628e2;
            parseInt = Integer.parseInt(a.substring(parseInt, parseInt2), 16) & 3;
            int i4;
            if (parseInt == 0) {
                C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"controlFSNInfo is single package."});
                c4628e2 = new C4628e();
                c4628e2.f16906a = false;
                parseInt2 = i3 + 8;
                i4 = ((parseInt3 + 3) * 2) + i3;
                if (i4 > length) {
                    this.f16916c = (parseInt3 + 3) + 2;
                    this.f16918e = a.substring(i3, length);
                    this.f16917d = this.f16916c - (this.f16918e.length() / 2);
                } else if (length < i4 || parseInt2 > i4) {
                    C2538c.b("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHex length is invalid for copy common data content with data = " + a});
                    this.f16916c = 0;
                    this.f16917d = 0;
                    this.f16918e = "";
                    return arrayList;
                } else {
                    c4628e2.f16908c = a.b(a.substring(parseInt2, i4));
                    c4628e2.f16909d = true;
                    c4628e2.f16907b = parseInt3 - 1;
                    c4628e2.f16910e = true;
                    arrayList.add(c4628e2);
                }
                parseInt = i2;
            } else {
                C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"controlFSNInfo is multi package."});
                parseInt2 = i3 + 10;
                i4 = ((parseInt3 + 3) * 2) + i3;
                if (i4 + 4 > length) {
                    C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHexLen less than endPosition."});
                    this.f16916c = (parseInt3 + 3) + 2;
                    this.f16918e = a.substring(i3, length);
                    this.f16917d = this.f16916c - (this.f16918e.length() / 2);
                    parseInt2 = i2;
                } else if (length < i4 || parseInt2 > i4) {
                    C2538c.b("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHex length is invalid for copy common data content with data = " + a});
                    this.f16918e = "";
                    this.f16916c = 0;
                    this.f16917d = 0;
                    return arrayList;
                } else {
                    Object b = a.b(a.substring(parseInt2, i4));
                    arrayList2.add(b);
                    parseInt2 = b.length + i2;
                }
                if (3 == parseInt && this.f16916c == 0) {
                    C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"Receive all Tag."});
                    if (parseInt2 > 0) {
                        ByteBuffer allocate = ByteBuffer.allocate(parseInt2);
                        for (i2 = 0; i2 < arrayList2.size(); i2++) {
                            allocate.put((byte[]) arrayList2.get(i2));
                        }
                        c4628e2 = new C4628e();
                        c4628e2.f16908c = allocate.array();
                        c4628e2.f16906a = true;
                        c4628e2.f16907b = parseInt2;
                        if (i4 > length) {
                            c4628e2.f16910e = false;
                        } else {
                            c4628e2.f16910e = true;
                        }
                        arrayList.add(c4628e2);
                        arrayList2.clear();
                        parseInt = 0;
                    }
                }
                parseInt = parseInt2;
            }
            i3 = (((parseInt3 + 3) + 2) * 2) + i3;
            i2 = parseInt;
        }
        if (i2 > 0) {
            C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"Exist sliced package and not receive last package."});
            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
            for (parseInt2 = 0; parseInt2 < arrayList2.size(); parseInt2++) {
                allocate2.put((byte[]) arrayList2.get(parseInt2));
            }
            c4628e2 = new C4628e();
            c4628e2.f16906a = true;
            c4628e2.f16908c = allocate2.array();
            c4628e2.f16907b = i2;
            c4628e2.f16910e = false;
            arrayList.add(c4628e2);
        }
        return arrayList;
    }

    public String mo4546c(int i, byte[] bArr) {
        C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"Enter spliceMTUPackage()."});
        if (bArr[0] == TagName.PREDEPOSIT_TOTAL && this.f16916c == 0) {
            String a = a.a(bArr);
            if (a.length() < 6) {
                C2538c.b("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"strDataContentHex length is invalid with data = " + a});
                return "";
            }
            int parseInt = Integer.parseInt(a.substring(2, 6), 16);
            if ((parseInt + 3) + 2 <= bArr.length) {
                return a.a(bArr);
            }
            C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"data content len less than linkDataLen."});
            this.f16918e = a.a(bArr);
            this.f16916c = ((parseInt + 1) + 2) + 2;
            C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"mV2TotalDataLen = " + this.f16916c});
            this.f16917d = this.f16916c - bArr.length;
            C2538c.a("01", 0, "BTDeviceV2ProtocolDataWrap", new Object[]{"mV2LeftDataLen = " + this.f16917d});
        } else if (this.f16916c < 6) {
            C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"mV2TotalDataLen less than link header length."});
            this.f16918e += C0973a.a(bArr);
            return this.f16918e;
        } else if (i < this.f16917d) {
            this.f16918e += C0973a.a(bArr);
            C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"data content len less than mV2LeftDataLen."});
            this.f16917d -= i;
        } else if (i == this.f16917d) {
            C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"data content len equal mV2LeftDataLen."});
            this.f16916c = 0;
            this.f16917d = 0;
            this.f16918e += C0973a.a(bArr);
            return this.f16918e;
        } else {
            C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"data content len more than mV2LeftDataLen."});
            if (bArr[this.f16917d] == TagName.PREDEPOSIT_TOTAL) {
                this.f16918e += C0973a.a(Arrays.copyOfRange(bArr, 0, this.f16917d));
                C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"data content len more than mV2LeftDataLen. data is valid!"});
            } else {
                this.f16918e = "";
                C2538c.a("01", 1, "BTDeviceV2ProtocolDataWrap", new Object[]{"data content len more than mV2LeftDataLen. data is invalid!!!"});
            }
            this.f16916c = 0;
            this.f16917d = 0;
            return this.f16918e;
        }
        return "";
    }

    public void mo4544a() {
        this.f16918e = "";
        this.f16917d = 0;
        this.f16916c = 0;
    }

    public void mo4545a(int i) {
        this.f16915b = i;
    }
}
