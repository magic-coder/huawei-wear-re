package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Headers.Builder;
import okhttp3.internal.DiskLruCache;
import okhttp3.internal.DiskLruCache.Editor;
import okhttp3.internal.DiskLruCache.Snapshot;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.apache.http.client.methods.HttpGet;

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    class C27051 implements InternalCache {
        C27051() {
        }

        public Response get(Request request) throws IOException {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response) throws IOException {
            return Cache.this.put(response);
        }

        public void remove(Request request) throws IOException {
            Cache.this.remove(request);
        }

        public void update(Response response, Response response2) throws IOException {
            Cache.this.update(response, response2);
        }

        public void trackConditionalCacheHit() {
            Cache.this.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            Cache.this.trackResponse(cacheStrategy);
        }
    }

    class C27062 implements Iterator<String> {
        boolean canRemove;
        final Iterator<Snapshot> delegate = Cache.this.cache.snapshots();
        String nextUrl;

        C27062() throws IOException {
        }

        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                Snapshot snapshot = (Snapshot) this.delegate.next();
                try {
                    this.nextUrl = Okio.buffer(snapshot.getSource(0)).readUtf8LineStrict();
                    snapshot.close();
                    return true;
                } catch (IOException e) {
                    snapshot.close();
                } catch (Throwable th) {
                    snapshot.close();
                }
            }
            return false;
        }

        public String next() {
            if (hasNext()) {
                String str = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return str;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.canRemove) {
                this.delegate.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    final class CacheRequestImpl implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        private boolean done;
        private final Editor editor;

        public CacheRequestImpl(final Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newSink(1);
            this.body = new ForwardingSink(this.cacheOut, Cache.this) {
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (CacheRequestImpl.this.done) {
                            return;
                        }
                        CacheRequestImpl.this.done = true;
                        Cache.this.writeSuccessCount = Cache.this.writeSuccessCount + 1;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        public void abort() {
            synchronized (Cache.this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache.this.writeAbortCount = Cache.this.writeAbortCount + 1;
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException e) {
                }
            }
        }

        public Sink body() {
            return this.body;
        }
    }

    class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final Snapshot snapshot;

        public CacheResponseBody(final Snapshot snapshot, String str, String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer(new ForwardingSource(snapshot.getSource(1)) {
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public MediaType contentType() {
            return this.contentType != null ? MediaType.parse(this.contentType) : null;
        }

        public long contentLength() {
            long j = -1;
            try {
                if (this.contentLength != null) {
                    j = Long.parseLong(this.contentLength);
                }
            } catch (NumberFormatException e) {
            }
            return j;
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }

    final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        public Entry(Source source) throws IOException {
            TlsVersion tlsVersion = null;
            int i = 0;
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.url = buffer.readUtf8LineStrict();
                this.requestMethod = buffer.readUtf8LineStrict();
                Builder builder = new Builder();
                int access$1000 = Cache.readInt(buffer);
                for (int i2 = 0; i2 < access$1000; i2++) {
                    builder.addLenient(buffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Builder builder2 = new Builder();
                int access$10002 = Cache.readInt(buffer);
                while (i < access$10002) {
                    builder2.addLenient(buffer.readUtf8LineStrict());
                    i++;
                }
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    CipherSuite forJavaName = CipherSuite.forJavaName(buffer.readUtf8LineStrict());
                    List readCertificateList = readCertificateList(buffer);
                    List readCertificateList2 = readCertificateList(buffer);
                    if (!buffer.exhausted()) {
                        tlsVersion = TlsVersion.forJavaName(buffer.readUtf8LineStrict());
                    }
                    this.handshake = Handshake.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                } else {
                    this.handshake = null;
                }
                source.close();
            } catch (Throwable th) {
                source.close();
            }
        }

        public Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = OkHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
        }

        public void writeTo(Editor editor) throws IOException {
            int i;
            int i2 = 0;
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.url);
            buffer.writeByte(10);
            buffer.writeUtf8(this.requestMethod);
            buffer.writeByte(10);
            buffer.writeDecimalLong((long) this.varyHeaders.size());
            buffer.writeByte(10);
            int size = this.varyHeaders.size();
            for (i = 0; i < size; i++) {
                buffer.writeUtf8(this.varyHeaders.name(i));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.varyHeaders.value(i));
                buffer.writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString());
            buffer.writeByte(10);
            buffer.writeDecimalLong((long) this.responseHeaders.size());
            buffer.writeByte(10);
            i = this.responseHeaders.size();
            while (i2 < i) {
                buffer.writeUtf8(this.responseHeaders.name(i2));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.responseHeaders.value(i2));
                buffer.writeByte(10);
                i2++;
            }
            if (isHttps()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.handshake.cipherSuite().javaName());
                buffer.writeByte(10);
                writeCertList(buffer, this.handshake.peerCertificates());
                writeCertList(buffer, this.handshake.localCertificates());
                if (this.handshake.tlsVersion() != null) {
                    buffer.writeUtf8(this.handshake.tlsVersion().javaName());
                    buffer.writeByte(10);
                }
            }
            buffer.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int access$1000 = Cache.readInt(bufferedSource);
            if (access$1000 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                List<Certificate> arrayList = new ArrayList(access$1000);
                for (int i = 0; i < access$1000; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong((long) list.size());
                bufferedSink.writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.of(((Certificate) list.get(i)).getEncoded()).base64());
                    bufferedSink.writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            return this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && OkHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public Response response(Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).build();
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new C27051();
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    private static String urlToKey(Request request) {
        return Util.md5Hex(request.url().toString());
    }

    Response get(Request request) {
        try {
            Closeable closeable = this.cache.get(urlToKey(request));
            if (closeable == null) {
                return null;
            }
            try {
                Entry entry = new Entry(closeable.getSource(0));
                Response response = entry.response(closeable);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly(response.body());
                return null;
            } catch (IOException e) {
                Util.closeQuietly(closeable);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    private CacheRequest put(Response response) throws IOException {
        Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
                return null;
            } catch (IOException e) {
                return null;
            }
        } else if (!method.equals(HttpGet.METHOD_NAME) || OkHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                Editor edit = this.cache.edit(urlToKey(response.request()));
                if (edit == null) {
                    return null;
                }
                try {
                    entry.writeTo(edit);
                    return new CacheRequestImpl(edit);
                } catch (IOException e2) {
                    editor = edit;
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException e3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    private void remove(Request request) throws IOException {
        this.cache.remove(urlToKey(request));
    }

    private void update(Response response, Response response2) {
        Entry entry = new Entry(response2);
        try {
            Editor edit = ((CacheResponseBody) response.body()).snapshot.edit();
            if (edit != null) {
                entry.writeTo(edit);
                edit.commit();
            }
        } catch (IOException e) {
            abortQuietly(null);
        }
    }

    private void abortQuietly(Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException e) {
            }
        }
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public Iterator<String> urls() throws IOException {
        return new C27062();
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public long size() throws IOException {
        return this.cache.size();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    private synchronized void trackResponse(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    private synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    private static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }
}
