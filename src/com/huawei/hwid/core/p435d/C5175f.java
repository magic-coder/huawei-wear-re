package com.huawei.hwid.core.p435d;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FastXmlSerializer */
public class C5175f implements XmlSerializer {
    private static final String[] f18632a = new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    private static String f18633b = "                                                              ";
    private final char[] f18634c = new char[8192];
    private int f18635d;
    private Writer f18636e;
    private OutputStream f18637f;
    private CharsetEncoder f18638g;
    private ByteBuffer f18639h = ByteBuffer.allocate(8192);
    private boolean f18640i = false;
    private boolean f18641j;
    private int f18642k = 0;
    private boolean f18643l = true;

    private void m25000a(char c) throws IOException {
        int i = this.f18635d;
        if (i >= 8191) {
            flush();
            i = this.f18635d;
        }
        this.f18634c[i] = c;
        this.f18635d = i + 1;
    }

    private void m25003a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m25003a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f18635d;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f18635d;
        }
        str.getChars(i, i + i2, this.f18634c, i5);
        this.f18635d = i5 + i2;
    }

    private void m25004a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m25004a(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f18635d;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f18635d;
        }
        System.arraycopy(cArr, i, this.f18634c, i5, i2);
        this.f18635d = i5 + i2;
    }

    private void m25002a(String str) throws IOException {
        m25003a(str, 0, str.length());
    }

    private void m25001a(int i) throws IOException {
        int i2 = i * 4;
        if (i2 > f18633b.length()) {
            i2 = f18633b.length();
        }
        m25003a(f18633b, 0, i2);
    }

    private void m25005b(String str) throws IOException {
        int i = 0;
        int length = str.length();
        char length2 = (char) f18632a.length;
        String[] strArr = f18632a;
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2) {
                String str2 = strArr[charAt];
                if (str2 != null) {
                    if (i < i2) {
                        m25003a(str, i, i2 - i);
                    }
                    i = i2 + 1;
                    m25002a(str2);
                }
            }
            i2++;
        }
        if (i < i2) {
            m25003a(str, i, i2 - i);
        }
    }

    private void m25006b(char[] cArr, int i, int i2) throws IOException {
        char length = (char) f18632a.length;
        String[] strArr = f18632a;
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length) {
                String str = strArr[c];
                if (str != null) {
                    if (i4 < i) {
                        m25004a(cArr, i4, i - i4);
                    }
                    i4 = i + 1;
                    m25002a(str);
                }
            }
            i++;
        }
        if (i4 < i) {
            m25004a(cArr, i4, i - i4);
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        m25000a(' ');
        if (str != null) {
            m25002a(str);
            m25000a(':');
        }
        m25002a(str2);
        m25002a("=\"");
        m25005b(str3);
        m25000a('\"');
        this.f18643l = false;
        return this;
    }

    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f18642k--;
        if (this.f18641j) {
            m25002a(" />\n");
        } else {
            if (this.f18640i && this.f18643l) {
                m25001a(this.f18642k);
            }
            m25002a("</");
            if (str != null) {
                m25002a(str);
                m25000a(':');
            }
            m25002a(str2);
            m25002a(">\n");
        }
        this.f18643l = true;
        this.f18641j = false;
        return this;
    }

    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    private void m24999a() throws IOException {
        int position = this.f18639h.position();
        if (position > 0) {
            this.f18639h.flip();
            this.f18637f.write(this.f18639h.array(), 0, position);
            this.f18639h.clear();
        }
    }

    public void flush() throws IOException {
        if (this.f18635d > 0) {
            if (this.f18637f != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f18634c, 0, this.f18635d);
                CoderResult encode = this.f18638g.encode(wrap, this.f18639h, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        m24999a();
                        encode = this.f18638g.encode(wrap, this.f18639h, true);
                    } else {
                        m24999a();
                        this.f18637f.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f18636e.write(this.f18634c, 0, this.f18635d);
            this.f18636e.flush();
            this.f18635d = 0;
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            this.f18640i = true;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f18638g = Charset.forName(str).newEncoder();
            this.f18637f = outputStream;
        } catch (Throwable e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (Throwable e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f18636e = writer;
    }

    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        m25002a("<?xml version='1.0' encoding='utf-8' standalone='" + (bool.booleanValue() ? "yes" : "no") + "' ?>\n");
        this.f18643l = true;
    }

    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f18641j) {
            m25002a(">\n");
        }
        if (this.f18640i) {
            m25001a(this.f18642k);
        }
        this.f18642k++;
        m25000a('<');
        if (str != null) {
            m25002a(str);
            m25000a(':');
        }
        m25002a(str2);
        this.f18641j = true;
        this.f18643l = false;
        return this;
    }

    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean z = false;
        if (this.f18641j) {
            m25002a(">");
            this.f18641j = false;
        }
        m25006b(cArr, i, i2);
        if (this.f18640i) {
            if (cArr[(i + i2) - 1] == '\n') {
                z = true;
            }
            this.f18643l = z;
        }
        return this;
    }

    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean z = false;
        if (this.f18641j) {
            m25002a(">");
            this.f18641j = false;
        }
        m25005b(str);
        if (this.f18640i) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == '\n') {
                z = true;
            }
            this.f18643l = z;
        }
        return this;
    }
}
