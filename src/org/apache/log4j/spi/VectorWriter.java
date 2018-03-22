package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.util.Vector;

class VectorWriter extends PrintWriter {
    private Vector f9186v = new Vector();

    VectorWriter() {
        super(new NullWriter());
    }

    public void print(Object obj) {
        this.f9186v.addElement(String.valueOf(obj));
    }

    public void print(char[] cArr) {
        this.f9186v.addElement(new String(cArr));
    }

    public void print(String str) {
        this.f9186v.addElement(str);
    }

    public void println(Object obj) {
        this.f9186v.addElement(String.valueOf(obj));
    }

    public void println(char[] cArr) {
        this.f9186v.addElement(new String(cArr));
    }

    public void println(String str) {
        this.f9186v.addElement(str);
    }

    public void write(char[] cArr) {
        this.f9186v.addElement(new String(cArr));
    }

    public void write(char[] cArr, int i, int i2) {
        this.f9186v.addElement(new String(cArr, i, i2));
    }

    public void write(String str, int i, int i2) {
        this.f9186v.addElement(str.substring(i, i + i2));
    }

    public void write(String str) {
        this.f9186v.addElement(str);
    }

    public String[] toStringArray() {
        int size = this.f9186v.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) this.f9186v.elementAt(i);
        }
        return strArr;
    }
}
