package com.squareup.okhttp;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.BufferedSink;
import okio.ByteString;
import org.apache.http.entity.mime.MIME;

public final class MultipartBuilder {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte[] COLONSPACE = new byte[]{TagName.BUSINESS_ORDER_OP_TYPE, (byte) 32};
    private static final byte[] CRLF = new byte[]{TagName.PAY_CHANNEL, (byte) 10};
    private static final byte[] DASHDASH = new byte[]{TagName.APK_UPDATE_FLAG, TagName.APK_UPDATE_FLAG};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final ByteString boundary;
    private final List<RequestBody> partBodies;
    private final List<Headers> partHeaders;
    private MediaType type;

    final class MultipartRequestBody extends RequestBody {
        private final ByteString boundary;
        private final MediaType contentType;
        private final List<RequestBody> partBodies;
        private final List<Headers> partHeaders;

        public MultipartRequestBody(MediaType mediaType, ByteString byteString, List<Headers> list, List<RequestBody> list2) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            }
            this.boundary = byteString;
            this.contentType = MediaType.parse(mediaType + "; boundary=" + byteString.utf8());
            this.partHeaders = Util.immutableList((List) list);
            this.partBodies = Util.immutableList((List) list2);
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public long contentLength() throws IOException {
            return -1;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            int size = this.partHeaders.size();
            for (int i = 0; i < size; i++) {
                Headers headers = (Headers) this.partHeaders.get(i);
                RequestBody requestBody = (RequestBody) this.partBodies.get(i);
                bufferedSink.write(MultipartBuilder.DASHDASH);
                bufferedSink.write(this.boundary);
                bufferedSink.write(MultipartBuilder.CRLF);
                if (headers != null) {
                    int size2 = headers.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        bufferedSink.writeUtf8(headers.name(i2)).write(MultipartBuilder.COLONSPACE).writeUtf8(headers.value(i2)).write(MultipartBuilder.CRLF);
                    }
                }
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(MultipartBuilder.CRLF);
                }
                long contentLength = requestBody.contentLength();
                if (contentLength != -1) {
                    bufferedSink.writeUtf8("Content-Length: ").writeUtf8(Long.toString(contentLength)).write(MultipartBuilder.CRLF);
                }
                bufferedSink.write(MultipartBuilder.CRLF);
                ((RequestBody) this.partBodies.get(i)).writeTo(bufferedSink);
                bufferedSink.write(MultipartBuilder.CRLF);
            }
            bufferedSink.write(MultipartBuilder.DASHDASH);
            bufferedSink.write(this.boundary);
            bufferedSink.write(MultipartBuilder.DASHDASH);
            bufferedSink.write(MultipartBuilder.CRLF);
        }
    }

    public MultipartBuilder() {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String str) {
        this.type = MIXED;
        this.partHeaders = new ArrayList();
        this.partBodies = new ArrayList();
        this.boundary = ByteString.encodeUtf8(str);
    }

    public MultipartBuilder type(MediaType mediaType) {
        if (mediaType == null) {
            throw new NullPointerException("type == null");
        } else if (mediaType.type().equals("multipart")) {
            this.type = mediaType;
            return this;
        } else {
            throw new IllegalArgumentException("multipart != " + mediaType);
        }
    }

    public MultipartBuilder addPart(RequestBody requestBody) {
        return addPart(null, requestBody);
    }

    public MultipartBuilder addPart(Headers headers, RequestBody requestBody) {
        if (requestBody == null) {
            throw new NullPointerException("body == null");
        } else if (headers != null && headers.get("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        } else if (headers == null || headers.get("Content-Length") == null) {
            this.partHeaders.add(headers);
            this.partBodies.add(requestBody);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    private static StringBuilder appendQuotedString(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\n':
                    stringBuilder.append("%0A");
                    break;
                case '\r':
                    stringBuilder.append("%0D");
                    break;
                case '\"':
                    stringBuilder.append("%22");
                    break;
                default:
                    stringBuilder.append(charAt);
                    break;
            }
        }
        stringBuilder.append('\"');
        return stringBuilder;
    }

    public MultipartBuilder addFormDataPart(String str, String str2) {
        return addFormDataPart(str, null, RequestBody.create(null, str2));
    }

    public MultipartBuilder addFormDataPart(String str, String str2, RequestBody requestBody) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        StringBuilder stringBuilder = new StringBuilder("form-data; name=");
        appendQuotedString(stringBuilder, str);
        if (str2 != null) {
            stringBuilder.append("; filename=");
            appendQuotedString(stringBuilder, str2);
        }
        return addPart(Headers.of(MIME.CONTENT_DISPOSITION, stringBuilder.toString()), requestBody);
    }

    public RequestBody build() {
        if (!this.partHeaders.isEmpty()) {
            return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies);
        }
        throw new IllegalStateException("Multipart body must have at least one part.");
    }
}
