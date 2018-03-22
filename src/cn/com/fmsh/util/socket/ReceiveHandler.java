package cn.com.fmsh.util.socket;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.log4j.net.SyslogAppender;

public class ReceiveHandler {
    private /* synthetic */ boolean f9864a;
    /* synthetic */ FMLog f9865b = null;

    private /* synthetic */ ReceiveHandler() {
    }

    public static ReceiveHandler instance() {
        return new ReceiveHandler();
    }

    public void cancel() {
        setStop(true);
    }

    public boolean isStop() {
        return this.f9864a;
    }

    public byte[] receive(DataLengthHandle dataLengthHandle, int i, DataInputStream dataInputStream) throws IOException {
        int i2 = 0;
        this.f9864a = false;
        if (this.f9865b == null) {
            this.f9865b = LogFactory.getInstance().getLog();
        }
        if (dataLengthHandle == null) {
            return receive(dataInputStream);
        }
        int dataSize = dataLengthHandle.getDataSize(dataInputStream);
        if (dataSize <= 0) {
            return receive(dataInputStream);
        }
        if (i <= 0) {
            i = 5000;
        }
        byte[] bArr = new byte[dataSize];
        long currentTimeMillis = System.currentTimeMillis();
        while (i2 < dataSize) {
            if (System.currentTimeMillis() - currentTimeMillis >= ((long) i)) {
                if (this.f9865b != null) {
                    this.f9865b.debug(BCCUtil.getChars("\u00063;?5(eJehlfi|", 4, 2), FM_Bytes.concat("措厈敿捱跊早", SyslogAppender.LOG_LOCAL7, 48));
                }
                throw new IOException(new StringBuilder(FM_CN.equals("坼捂富盃旮闽A", 1)).append(i).append(FM_Long.copyValueOf("V再术控敩剬捞富锬延盉攺挩", 3)).toString());
            }
            i2 += dataInputStream.read(bArr, i2, dataSize - i2);
        }
        return bArr;
    }

    public byte[] receive(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = null;
        byte[] bArr2 = new byte[1024];
        int available = dataInputStream.available();
        if (this.f9865b != null) {
            this.f9865b.debug(FM_Int.replace(6, "\t;ban|hXrx}pzp"), new StringBuilder(FM_Exception.insert(154, 7, "ZdxrS/8:\"\u000e0978m'oc}jfpzs#w")).append(available).toString());
        }
        while (true) {
            available = dataInputStream.read(bArr2);
            if (available <= 0) {
                return bArr;
            }
            if (this.f9865b != null) {
                this.f9865b.debug(FM_Int.replace(SyslogAppender.LOG_LOCAL2, "WmhkxbrR|ngjl~"), new StringBuilder(FM_Bytes.concat("51,wmjj1xrtztk<", 5, 3)).append(available).toString());
            }
            if (bArr == null) {
                bArr = Arrays.copyOf(bArr2, available);
            } else {
                FM_Bytes.join(bArr, Arrays.copyOf(bArr2, available));
            }
        }
    }

    public void setStop(boolean z) {
        this.f9864a = z;
    }
}
