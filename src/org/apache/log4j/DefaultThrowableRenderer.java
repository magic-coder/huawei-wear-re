package org.apache.log4j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import org.apache.log4j.spi.ThrowableRenderer;

public final class DefaultThrowableRenderer implements ThrowableRenderer {
    public String[] doRender(Throwable th) {
        return render(th);
    }

    public static String[] render(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (RuntimeException e) {
        }
        printWriter.flush();
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(stringWriter.toString()));
        ArrayList arrayList = new ArrayList();
        try {
            for (Object readLine = lineNumberReader.readLine(); readLine != null; readLine = lineNumberReader.readLine()) {
                arrayList.add(readLine);
            }
        } catch (IOException e2) {
            if (e2 instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            arrayList.add(e2.toString());
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}
