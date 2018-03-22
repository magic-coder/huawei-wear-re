package com.huawei.hwbtsdk.btmanager.p401a;

import android.content.Context;
import com.huawei.hwbtsdk.p057b.p400b.C4628e;
import com.huawei.hwbtsdk.p399a.C4612o;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: BTDeviceV1ProtocolDataWrap */
public class C4631c extends C4629a {
    private Context f16912a = null;
    private int f16913b = -1;

    public C4631c(Context context, int i) {
        this.f16912a = context;
        this.f16913b = i;
    }

    private byte[] m22154b(int i) {
        String str = "";
        int i2 = i + 3;
        if (16384 <= i2) {
            str = C0973a.a((i2 >> 14) + 128) + C0973a.a((i2 >> 7) + 128) + C0973a.a(i2 & 127);
        } else if (128 <= i2) {
            str = C0973a.a((i2 >> 7) + 128) + C0973a.a(i2 & 127);
        } else {
            str = C0973a.a(i2);
        }
        return C0973a.b(str);
    }

    private void m22152a(int i, byte[] bArr, ArrayList<byte[]> arrayList) {
        int i2 = 0;
        byte[] b = m22154b(i);
        int length = b.length;
        int i3 = ((length + 4) + i) + 2;
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        byte[] bArr2 = new byte[(i3 - 2)];
        allocate.put((byte) -86);
        bArr2[0] = (byte) -86;
        allocate.put(b);
        for (i3 = 0; i3 < b.length; i3++) {
            bArr2[i3 + 1] = b[i3];
        }
        allocate.put((byte) 0);
        bArr2[length + 1] = (byte) 0;
        allocate.put((byte) 1);
        bArr2[(length + 1) + 1] = (byte) 1;
        allocate.put((byte) 1);
        bArr2[((length + 1) + 1) + 1] = (byte) 1;
        allocate.put(bArr);
        i3 = length + 4;
        while (i2 < bArr.length) {
            bArr2[i3] = bArr[i2];
            i3++;
            i2++;
        }
        allocate.put(C4612o.m22004a(this.f16912a).m22013a(bArr2));
        allocate.flip();
        arrayList.add(allocate.array());
    }

    private void m22153b(int i, byte[] bArr, ArrayList<byte[]> arrayList) {
        int i2;
        if (i <= 127) {
            i2 = 1;
        } else if (i <= 16383) {
            i2 = 2;
        } else if (i <= 2080641) {
            i2 = 3;
        } else {
            return;
        }
        int i3 = (((((this.f16913b - 1) - i2) - 1) - 1) - 1) - 2;
        i2 = i % i3 > 0 ? (i / i3) + 1 : i / i3;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5;
            if (i4 == i2 - 1) {
                i5 = i - (i4 * i3);
            } else {
                i5 = i3;
            }
            int i6 = i4 * i3;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i6, i5 + i6);
            byte[] b = m22154b(copyOfRange.length);
            int length = b.length;
            i5 = (copyOfRange.length + ((((length + 1) + 1) + 1) + 1)) + 2;
            ByteBuffer allocate = ByteBuffer.allocate(i5);
            byte[] bArr2 = new byte[(i5 - 2)];
            allocate.put((byte) -86);
            bArr2[0] = (byte) -86;
            allocate.put(b);
            for (i5 = 0; i5 < b.length; i5++) {
                bArr2[i5 + 1] = b[i5];
            }
            allocate.put((byte) 0);
            bArr2[length + 1] = (byte) 0;
            allocate.put((byte) i2);
            bArr2[(length + 1) + 1] = (byte) i2;
            allocate.put((byte) (i4 + 1));
            bArr2[((length + 1) + 1) + 1] = (byte) (i4 + 1);
            allocate.put(copyOfRange);
            i6 = (((length + 1) + 1) + 1) + 1;
            for (byte b2 : copyOfRange) {
                bArr2[i6] = b2;
                i6++;
            }
            allocate.put(C4612o.m22004a(this.f16912a).m22013a(bArr2));
            allocate.flip();
            arrayList.add(allocate.array());
        }
    }

    public ArrayList<byte[]> mo4542a(int i, byte[] bArr) {
        if (i <= 0 || bArr == null) {
            return null;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        if (((m22154b(i).length + 4) + i) + 2 <= this.f16913b) {
            m22152a(i, bArr, arrayList);
            return arrayList;
        }
        m22153b(i, bArr, arrayList);
        return arrayList;
    }

    private int m22151a(byte[] bArr) {
        String a = a.a(bArr);
        if (a.length() < 4) {
            C2538c.a("01", 1, "BTDeviceV1ProtocolDataWrap", new Object[]{"start responseHex len is incorrect."});
            return 0;
        }
        int i = 0;
        int i2 = 2;
        int i3 = 0;
        int i4 = 0;
        while (Integer.parseInt(a.substring(i2, i2 + 2), 16) > 127) {
            int parseInt = Integer.parseInt(a.substring(i2, i2 + 2), 16);
            switch (i) {
                case 0:
                    i4 = parseInt - 128;
                    break;
                case 1:
                    i3 = parseInt - 128;
                    break;
            }
            i2 += 2;
            i++;
            if (a.length() < i2 + 2) {
                C2538c.a("01", 1, "BTDeviceV1ProtocolDataWrap", new Object[]{"parse responseHex len is incorrect."});
                return 0;
            }
        }
        int parseInt2 = Integer.parseInt(a.substring(i2, i2 + 2), 16);
        i = 2 == i ? ((i4 * 16384) + (i3 * 128)) + parseInt2 : 1 == i ? (i4 * 128) + parseInt2 : parseInt2;
        return i;
    }

    public List<C4628e> mo4543b(int i, byte[] bArr) {
        int i2 = 4;
        int i3 = 3;
        List<C4628e> arrayList = new ArrayList();
        int a = m22151a(bArr);
        if (a == 0) {
            C2538c.a("01", 1, "BTDeviceV1ProtocolDataWrap", new Object[]{"dataTotalLen = 0."});
            return null;
        }
        int i4;
        byte[] copyOfRange;
        if (16384 <= a) {
            i2 = 5;
            i4 = 6;
        } else if (128 <= a) {
            i4 = 5;
            i3 = 2;
        } else {
            i4 = 4;
            i2 = 3;
            i3 = 1;
        }
        if ((byte) -86 == bArr[0]) {
            i3 += 4;
            int i5 = i - 2;
            if (i5 <= i3 || bArr.length <= i5) {
                C2538c.a("01", 1, "BTDeviceV1ProtocolDataWrap", new Object[]{"dataTotalLen = 0."});
                return null;
            }
            copyOfRange = Arrays.copyOfRange(bArr, i3, i5);
        } else {
            copyOfRange = null;
        }
        if (bArr.length <= i2) {
            C2538c.b("01", 1, "BTDeviceV1ProtocolDataWrap", new Object[]{"dataContent.length less than pack_total_position so return null."});
            return null;
        }
        byte b = bArr[i2];
        C4628e c4628e = new C4628e();
        if ((byte) 1 == b) {
            c4628e.f16906a = false;
            c4628e.f16908c = copyOfRange;
        } else {
            c4628e.f16906a = true;
            if (bArr.length <= i4) {
                C2538c.a("01", 1, "BTDeviceV1ProtocolDataWrap", new Object[]{"dataContent length less than pack_index_position."});
                return null;
            }
            byte b2 = bArr[i4];
            c4628e.f16907b = a;
            c4628e.f16908c = copyOfRange;
            if (b == b2) {
                c4628e.f16910e = true;
            } else {
                c4628e.f16910e = false;
            }
        }
        arrayList.add(c4628e);
        return arrayList;
    }
}
