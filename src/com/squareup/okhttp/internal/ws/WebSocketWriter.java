package com.squareup.okhttp.internal.ws;

import android.support.v4.media.TransportMediator;
import com.squareup.okhttp.internal.ws.WebSocket.PayloadType;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Timeout;

public final class WebSocketWriter {
    private boolean activeWriter;
    private boolean closed;
    private final FrameSink frameSink = new FrameSink();
    private final boolean isClient;
    private final byte[] maskBuffer = new byte[2048];
    private final byte[] maskKey = new byte[4];
    private final Random random;
    private final BufferedSink sink;

    final class FrameSink implements Sink {
        private boolean isFirstFrame;
        private PayloadType payloadType;

        private FrameSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            WebSocketWriter.this.writeFrame(this.payloadType, buffer, j, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        public void flush() throws IOException {
            synchronized (WebSocketWriter.this.sink) {
                WebSocketWriter.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public void close() throws IOException {
            synchronized (WebSocketWriter.this.sink) {
                WebSocketWriter.this.sink.writeByte(128);
                if (WebSocketWriter.this.isClient) {
                    WebSocketWriter.this.sink.writeByte(128);
                    WebSocketWriter.this.random.nextBytes(WebSocketWriter.this.maskKey);
                    WebSocketWriter.this.sink.write(WebSocketWriter.this.maskKey);
                } else {
                    WebSocketWriter.this.sink.writeByte(0);
                }
                WebSocketWriter.this.sink.flush();
            }
            WebSocketWriter.this.activeWriter = false;
        }
    }

    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink");
        } else if (random == null) {
            throw new NullPointerException("random");
        } else {
            this.isClient = z;
            this.sink = bufferedSink;
            this.random = random;
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void writePing(Buffer buffer) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("Closed");
        }
        synchronized (this.sink) {
            writeControlFrame(9, buffer);
        }
    }

    public void writePong(Buffer buffer) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("Closed");
        }
        synchronized (this.sink) {
            writeControlFrame(10, buffer);
        }
    }

    public void writeClose(int i, String str) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("Closed");
        }
        Buffer buffer = null;
        if (i != 0) {
            if (i < 1000 || i >= 5000) {
                throw new IllegalArgumentException("Code must be in range [1000,5000).");
            }
            buffer = new Buffer();
            buffer.writeShort(i);
            if (str != null) {
                buffer.writeUtf8(str);
            }
        } else if (str != null) {
            throw new IllegalArgumentException("Code required to include reason.");
        }
        writeClose(buffer);
    }

    public void writeClose(Buffer buffer) throws IOException {
        synchronized (this.sink) {
            writeControlFrame(8, buffer);
            this.closed = true;
        }
    }

    private void writeControlFrame(int i, Buffer buffer) throws IOException {
        int i2 = 0;
        if (buffer != null) {
            i2 = (int) buffer.size();
            if (i2 > 125) {
                throw new IllegalArgumentException("Control frame payload must be less than 125B.");
            }
        }
        this.sink.writeByte(i | 128);
        if (this.isClient) {
            this.sink.writeByte(i2 | 128);
            this.random.nextBytes(this.maskKey);
            this.sink.write(this.maskKey);
            if (buffer != null) {
                writeAllMasked(buffer, (long) i2);
            }
        } else {
            this.sink.writeByte(i2);
            if (buffer != null) {
                this.sink.writeAll(buffer);
            }
        }
        this.sink.flush();
    }

    public BufferedSink newMessageSink(PayloadType payloadType) {
        if (payloadType == null) {
            throw new NullPointerException("type == null");
        } else if (this.closed) {
            throw new IllegalStateException("Closed");
        } else if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        } else {
            this.activeWriter = true;
            this.frameSink.payloadType = payloadType;
            this.frameSink.isFirstFrame = true;
            return Okio.buffer(this.frameSink);
        }
    }

    public void sendMessage(PayloadType payloadType, Buffer buffer) throws IOException {
        if (payloadType == null) {
            throw new NullPointerException("type == null");
        } else if (buffer == null) {
            throw new NullPointerException("payload == null");
        } else if (this.closed) {
            throw new IllegalStateException("Closed");
        } else if (this.activeWriter) {
            throw new IllegalStateException("A message writer is active. Did you call close()?");
        } else {
            writeFrame(payloadType, buffer, buffer.size(), true, true);
        }
    }

    private void writeFrame(PayloadType payloadType, Buffer buffer, long j, boolean z, boolean z2) throws IOException {
        int i;
        int i2 = 0;
        if (z) {
            switch (payloadType) {
                case TEXT:
                    i = 1;
                    break;
                case BINARY:
                    i = 2;
                    break;
                default:
                    throw new IllegalStateException("Unknown payload type: " + payloadType);
            }
        }
        i = 0;
        synchronized (this.sink) {
            if (z2) {
                i |= 128;
            }
            this.sink.writeByte(i);
            if (this.isClient) {
                i2 = 128;
                this.random.nextBytes(this.maskKey);
            }
            if (j <= 125) {
                this.sink.writeByte(((int) j) | i2);
            } else if (j <= 32767) {
                this.sink.writeByte(i2 | TransportMediator.KEYCODE_MEDIA_PLAY);
                this.sink.writeShort((int) j);
            } else {
                this.sink.writeByte(i2 | 127);
                this.sink.writeLong(j);
            }
            if (this.isClient) {
                this.sink.write(this.maskKey);
                writeAllMasked(buffer, j);
            } else {
                this.sink.write(buffer, j);
            }
            this.sink.flush();
        }
    }

    private void writeAllMasked(BufferedSource bufferedSource, long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            int read = bufferedSource.read(this.maskBuffer, 0, (int) Math.min(j, (long) this.maskBuffer.length));
            if (read == -1) {
                throw new AssertionError();
            }
            Protocol.toggleMask(this.maskBuffer, (long) read, this.maskKey, j2);
            this.sink.write(this.maskBuffer, 0, read);
            j2 += (long) read;
        }
    }
}
