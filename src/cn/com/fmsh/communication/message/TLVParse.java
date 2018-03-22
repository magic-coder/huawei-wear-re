package cn.com.fmsh.communication.message;

import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TLVParse {

    public class TagEntry {
        private /* synthetic */ byte[] f9431a;
        private /* synthetic */ byte[] f9432b;
        private /* synthetic */ byte[] f9433c;
        final /* synthetic */ TLVParse f9434d;

        public TagEntry(TLVParse tLVParse, byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.f9434d = tLVParse;
            this.f9431a = bArr;
            this.f9432b = bArr2;
            this.f9433c = bArr3;
        }

        public byte[] getData() {
            return this.f9433c;
        }

        public byte[] getLengthData() {
            return this.f9432b;
        }

        public byte[] getTag() {
            return this.f9431a;
        }
    }

    public static TLVParse intance() {
        return new TLVParse();
    }

    public static void main(String[] strArr) {
        try {
            intance().parse(FM_Bytes.hexStringToBytes(FM_Int.replace(146, "F;=!#&X./449;?!$&(-qsw\bceh")), 1);
        } catch (FMCommunicationMessageException e) {
            e.printStackTrace();
        }
    }

    public List<TagEntry> parse(byte[] bArr, int i) throws FMCommunicationMessageException {
        List<TagEntry> arrayList = new ArrayList();
        if (i < 1) {
            throw new FMCommunicationMessageException(FM_Utils.regionMatches(4, 31, "\u0000_D攡挾觬枞斻｀伫兯盍\u001c敷捨锺廢与吊沔"));
        } else if (bArr == null || bArr.length < i + 1) {
            throw new FMCommunicationMessageException(BCCUtil.getChars("\u0006\u0007\u0012攭挸覬柘斷６伳兩皁敮捹丝吁泗", 2, 121));
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byte[] bArr2 = new byte[2];
            while (true) {
                byte[] bArr3 = new byte[i];
                try {
                    if (byteArrayInputStream.read(bArr3) == -1) {
                        break;
                    }
                    int read = byteArrayInputStream.read();
                    if (read < 0) {
                        break;
                    } else if (read != 0) {
                        byte[] bArr4;
                        if (read == 255) {
                            bArr4 = new byte[3];
                            int read2 = byteArrayInputStream.read(bArr2);
                            bArr4[0] = (byte) 0;
                            bArr4[1] = bArr2[0];
                            bArr4[2] = bArr2[1];
                            read = FM_Bytes.bytesToInt(bArr4);
                            if (read2 == -1) {
                                break;
                            }
                        }
                        bArr4 = new byte[]{(byte) read};
                        byte[] bArr5 = new byte[read];
                        byteArrayInputStream.read(bArr5);
                        arrayList.add(new TagEntry(this, bArr3, bArr4, bArr5));
                    }
                } catch (IOException e) {
                }
            }
            return arrayList;
        }
    }
}
