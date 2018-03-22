package com.squareup.okhttp.internal.ws;

import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.squareup.okhttp.internal.ws.WebSocket.PayloadType;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class WebSocketReader {
    private boolean closed;
    private long frameBytesRead;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final Source framedMessageSource = new FramedMessageSource();
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private boolean isMasked;
    private final WebSocketListener listener;
    private final byte[] maskBuffer = new byte[2048];
    private final byte[] maskKey = new byte[4];
    private boolean messageClosed;
    private int opcode;
    private final BufferedSource source;

    public interface FrameCallback {
        void onClose(Buffer buffer) throws IOException;

        void onPing(Buffer buffer);
    }

    final class FramedMessageSource implements Source {
        private FramedMessageSource() {
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (WebSocketReader.this.closed) {
                throw new IOException("Closed");
            } else if (WebSocketReader.this.messageClosed) {
                throw new IllegalStateException("Closed");
            } else {
                long read;
                if (WebSocketReader.this.frameBytesRead == WebSocketReader.this.frameLength) {
                    if (WebSocketReader.this.isFinalFrame) {
                        return -1;
                    }
                    WebSocketReader.this.readUntilNonControlFrame();
                    if (WebSocketReader.this.opcode != 0) {
                        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(WebSocketReader.this.opcode));
                    }
                }
                long min = Math.min(j, WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
                if (WebSocketReader.this.isMasked) {
                    read = (long) WebSocketReader.this.source.read(WebSocketReader.this.maskBuffer, 0, (int) Math.min(min, (long) WebSocketReader.this.maskBuffer.length));
                    if (read == -1) {
                        throw new EOFException();
                    }
                    Protocol.toggleMask(WebSocketReader.this.maskBuffer, read, WebSocketReader.this.maskKey, WebSocketReader.this.frameBytesRead);
                    buffer.write(WebSocketReader.this.maskBuffer, 0, (int) read);
                } else {
                    read = WebSocketReader.this.source.read(buffer, min);
                    if (read == -1) {
                        throw new EOFException();
                    }
                }
                WebSocketReader.this.frameBytesRead = WebSocketReader.this.frameBytesRead + read;
                return read;
            }
        }

        public Timeout timeout() {
            return WebSocketReader.this.source.timeout();
        }

        public void close() throws IOException {
            if (!WebSocketReader.this.messageClosed) {
                WebSocketReader.this.messageClosed = true;
                if (!WebSocketReader.this.closed) {
                    WebSocketReader.this.source.skip(WebSocketReader.this.frameLength - WebSocketReader.this.frameBytesRead);
                    while (!WebSocketReader.this.isFinalFrame) {
                        WebSocketReader.this.readUntilNonControlFrame();
                        WebSocketReader.this.source.skip(WebSocketReader.this.frameLength);
                    }
                }
            }
        }
    }

    public WebSocketReader(boolean z, BufferedSource bufferedSource, WebSocketListener webSocketListener, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source");
        } else if (webSocketListener == null) {
            throw new NullPointerException(JoinConstants.LISTENER);
        } else if (frameCallback == null) {
            throw new NullPointerException("frameCallback");
        } else {
            this.isClient = z;
            this.source = bufferedSource;
            this.listener = webSocketListener;
            this.frameCallback = frameCallback;
        }
    }

    public void readMessage() throws IOException {
        readUntilNonControlFrame();
        if (!this.closed) {
            PayloadType payloadType;
            switch (this.opcode) {
                case 1:
                    payloadType = PayloadType.TEXT;
                    break;
                case 2:
                    payloadType = PayloadType.BINARY;
                    break;
                default:
                    throw new IllegalStateException("Unknown opcode: " + Integer.toHexString(this.opcode));
            }
            this.messageClosed = false;
            this.listener.onMessage(Okio.buffer(this.framedMessageSource), payloadType);
            if (!this.messageClosed) {
                throw new IllegalStateException("Listener failed to call close on message payload.");
            }
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                return;
            }
        }
    }

    private void readHeader() throws IOException {
        boolean z = true;
        if (this.closed) {
            throw new IllegalStateException("Closed");
        }
        boolean z2;
        int readByte = this.source.readByte() & 255;
        this.opcode = readByte & 15;
        this.isFinalFrame = (readByte & 128) != 0;
        if ((readByte & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.isControlFrame = z2;
        if (!this.isControlFrame || this.isFinalFrame) {
            boolean z3 = (readByte & 64) != 0;
            boolean z4;
            if ((readByte & 32) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((readByte & 16) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 || r3 || r0) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int readByte2 = this.source.readByte() & 255;
            if ((readByte2 & 128) == 0) {
                z = false;
            }
            this.isMasked = z;
            if (this.isMasked == this.isClient) {
                throw new ProtocolException("Client-sent frames must be masked. Server sent must not.");
            }
            this.frameLength = (long) (readByte2 & 127);
            if (this.frameLength == 126) {
                this.frameLength = (long) this.source.readShort();
            } else if (this.frameLength == 127) {
                this.frameLength = this.source.readLong();
            }
            this.frameBytesRead = 0;
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            } else if (this.isMasked) {
                this.source.readFully(this.maskKey);
                return;
            } else {
                return;
            }
        }
        throw new ProtocolException("Control frames must be final.");
    }

    private void readControlFrame() throws IOException {
        Buffer buffer;
        Buffer buffer2 = null;
        if (this.frameBytesRead < this.frameLength) {
            Buffer buffer3 = new Buffer();
            if (this.isClient) {
                this.source.readFully(buffer3, this.frameLength);
                buffer = buffer3;
            } else {
                while (this.frameBytesRead < this.frameLength) {
                    int read = this.source.read(this.maskBuffer, 0, (int) Math.min(this.frameLength - this.frameBytesRead, (long) this.maskBuffer.length));
                    if (read == -1) {
                        throw new EOFException();
                    }
                    Protocol.toggleMask(this.maskBuffer, (long) read, this.maskKey, this.frameBytesRead);
                    buffer3.write(this.maskBuffer, 0, read);
                    this.frameBytesRead += (long) read;
                }
                buffer = buffer3;
            }
        } else {
            buffer = null;
        }
        switch (this.opcode) {
            case 8:
                int readShort;
                String readUtf8;
                FrameCallback frameCallback = this.frameCallback;
                if (buffer != null) {
                    buffer2 = buffer.clone();
                }
                frameCallback.onClose(buffer2);
                this.closed = true;
                String str = "";
                if (buffer != null) {
                    readShort = buffer.readShort();
                    readUtf8 = buffer.readUtf8();
                } else {
                    readUtf8 = str;
                    readShort = 0;
                }
                this.listener.onClose(readShort, readUtf8);
                return;
            case 9:
                this.frameCallback.onPing(buffer);
                return;
            case 10:
                return;
            default:
                throw new IllegalStateException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }
}
