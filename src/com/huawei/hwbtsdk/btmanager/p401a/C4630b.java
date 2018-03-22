package com.huawei.hwbtsdk.btmanager.p401a;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbtsdk.p057b.p400b.C4628e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: BTDeviceV0ProtocolDataWrap */
public class C4630b extends C4629a {
    private int f16911a = -1;

    public C4630b(Context context, int i) {
        this.f16911a = i;
    }

    private byte m22146a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        if (bArr == null) {
            return (byte) 0;
        }
        while (i3 > 0) {
            i3--;
            i4 = (byte) (i4 + bArr[i3 + i2]);
        }
        if (1 == i) {
            return (byte) (i4 & 255);
        }
        if (2 == i) {
            return (byte) ((i4 ^ -1) & 255);
        }
        return (byte) -1;
    }

    private void m22147a(int i, byte[] bArr, ArrayList<byte[]> arrayList) {
        ByteBuffer allocate = ByteBuffer.allocate((i + 1) + 1);
        byte[] bArr2 = new byte[(i + 1)];
        allocate.put((byte) -86);
        bArr2[0] = (byte) -86;
        allocate.put(bArr);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2 + 1] = bArr[i2];
        }
        allocate.put(m22146a(1, bArr2, 0, bArr2.length));
        allocate.flip();
        arrayList.add(allocate.array());
    }

    private void m22148b(int i, byte[] bArr, ArrayList<byte[]> arrayList) {
        int i2 = (((this.f16911a - 1) - 1) - 1) - 1;
        int i3 = i % i2 > 0 ? (i / i2) + 1 : i / i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5;
            if (i4 == i3 - 1) {
                i5 = i - (i4 * i2);
            } else {
                i5 = i2;
            }
            ByteBuffer allocate = ByteBuffer.allocate(this.f16911a);
            allocate.put(TagName.TERMINAL_BACK_CHILDREN_ID);
            allocate.put((byte) i);
            allocate.put((byte) i4);
            allocate.put(Arrays.copyOfRange(bArr, i4 * i2, i5 + (i4 * i2)));
            allocate.put(this.f16911a - 1, m22146a(1, allocate.array(), 0, this.f16911a - 1));
            allocate.flip();
            arrayList.add(allocate.array());
        }
    }

    public ArrayList<byte[]> mo4542a(int i, byte[] bArr) {
        if (i <= 0 || bArr == null) {
            return null;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        if (i <= this.f16911a) {
            m22147a(i, bArr, arrayList);
            return arrayList;
        }
        m22148b(i, bArr, arrayList);
        return arrayList;
    }

    public List<C4628e> mo4543b(int i, byte[] bArr) {
        List<C4628e> arrayList = new ArrayList();
        C4628e c4628e = new C4628e();
        if (TagName.TERMINAL_BACK_CHILDREN_ID != bArr[0]) {
            if (m22146a(2, bArr, 0, i) != (byte) 0) {
                return null;
            }
            c4628e.f16906a = false;
            c4628e.f16908c = Arrays.copyOfRange(bArr, 3, i - 1);
            c4628e.f16909d = true;
            c4628e.f16907b = (((i - 1) - 1) - 1) - 1;
            c4628e.f16910e = true;
        } else if (m22146a(2, bArr, 0, i) != (byte) 0) {
            return null;
        } else {
            c4628e.f16906a = true;
            byte b = bArr[1];
            byte b2 = bArr[2];
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 3, (i - 4) + 3);
            c4628e.f16907b = b;
            c4628e.f16908c = copyOfRange;
            if ((b2 * (this.f16911a - 4)) + copyOfRange.length >= b) {
                c4628e.f16910e = true;
            } else {
                c4628e.f16910e = false;
            }
        }
        arrayList.add(c4628e);
        return arrayList;
    }
}
