package com.huawei.androidcommon.dependence;

import com.huawei.androidcommon.dependence.MonitorableOutputStream.OutputStreamListener;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;

public class MonitorableMultipartEntity extends MultipartEntity {
    private OutputStreamListener listener;

    public MonitorableMultipartEntity(OutputStreamListener outputStreamListener) {
        this.listener = outputStreamListener;
    }

    public MonitorableMultipartEntity(HttpMultipartMode httpMultipartMode, OutputStreamListener outputStreamListener) {
        super(httpMultipartMode);
        this.listener = outputStreamListener;
    }

    public MonitorableMultipartEntity(HttpMultipartMode httpMultipartMode, String str, Charset charset, OutputStreamListener outputStreamListener) {
        super(httpMultipartMode, str, charset);
        this.listener = outputStreamListener;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(new MonitorableOutputStream(outputStream, this.listener));
    }
}
