package com.huawei.androidcommon.dependence;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MonitorableOutputStream extends FilterOutputStream {
    private OutputStreamListener listener;
    private long uploaded;

    public interface OutputStreamListener {
        void outputed(long j);
    }

    public MonitorableOutputStream(OutputStream outputStream, OutputStreamListener outputStreamListener) {
        super(outputStream);
        this.listener = outputStreamListener;
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        count(1);
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        count((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        count((long) i2);
    }

    private void count(long j) {
        this.uploaded += j;
        if (this.listener != null) {
            this.listener.outputed(this.uploaded);
        }
    }
}
