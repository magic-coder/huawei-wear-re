package com.squareup.haha.trove;

import java.io.IOException;
import java.io.ObjectOutputStream;

final class SerializationProcedure implements TIntObjectProcedure, TLongObjectProcedure, TLongProcedure, TObjectObjectProcedure, TObjectProcedure {
    IOException exception;
    private final ObjectOutputStream stream;

    SerializationProcedure(ObjectOutputStream objectOutputStream) {
        this.stream = objectOutputStream;
    }

    public final boolean execute(long j) {
        try {
            this.stream.writeLong(j);
            return true;
        } catch (IOException e) {
            this.exception = e;
            return false;
        }
    }

    public final boolean execute(Object obj) {
        try {
            this.stream.writeObject(obj);
            return true;
        } catch (IOException e) {
            this.exception = e;
            return false;
        }
    }

    public final boolean execute(Object obj, Object obj2) {
        try {
            this.stream.writeObject(obj);
            this.stream.writeObject(obj2);
            return true;
        } catch (IOException e) {
            this.exception = e;
            return false;
        }
    }

    public final boolean execute(int i, Object obj) {
        try {
            this.stream.writeInt(i);
            this.stream.writeObject(obj);
            return true;
        } catch (IOException e) {
            this.exception = e;
            return false;
        }
    }

    public final boolean execute(long j, Object obj) {
        try {
            this.stream.writeLong(j);
            this.stream.writeObject(obj);
            return true;
        } catch (IOException e) {
            this.exception = e;
            return false;
        }
    }
}
