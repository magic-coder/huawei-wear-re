package com.tencent.open.p541a;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
public class C6368o implements Iterable<String> {
    private ConcurrentLinkedQueue<String> f22152a;
    private AtomicInteger f22153b;

    public C6368o() {
        this.f22152a = null;
        this.f22153b = null;
        this.f22152a = new ConcurrentLinkedQueue();
        this.f22153b = new AtomicInteger(0);
    }

    public int m29116a(String str) {
        int length = str.length();
        this.f22152a.add(str);
        return this.f22153b.addAndGet(length);
    }

    public void m29117a(Writer writer, char[] cArr) throws IOException {
        if (writer != null && cArr != null && cArr.length != 0) {
            int length = cArr.length;
            Iterator it = iterator();
            int i = 0;
            int i2 = length;
            while (it.hasNext()) {
                String str = (String) it.next();
                int length2 = str.length();
                int i3 = 0;
                while (length2 > 0) {
                    int i4 = i2 > length2 ? length2 : i2;
                    str.getChars(i3, i3 + i4, cArr, i);
                    i2 -= i4;
                    i += i4;
                    length2 -= i4;
                    i4 += i3;
                    if (i2 == 0) {
                        writer.write(cArr, 0, length);
                        i = 0;
                        i2 = length;
                        i3 = i4;
                    } else {
                        i3 = i4;
                    }
                }
            }
            if (i > 0) {
                writer.write(cArr, 0, i);
            }
            writer.flush();
        }
    }

    public int m29115a() {
        return this.f22153b.get();
    }

    public void m29118b() {
        this.f22152a.clear();
        this.f22153b.set(0);
    }

    public Iterator<String> iterator() {
        return this.f22152a.iterator();
    }
}
