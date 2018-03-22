package com.huawei.crowdtestsdk.httpaccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpCookie;

public class SerializableHttpCookie implements Serializable {
    private static final long serialVersionUID = 6374381323722046732L;
    private transient HttpCookie clientCookie;
    private final transient HttpCookie cookie;

    public SerializableHttpCookie(HttpCookie httpCookie) {
        this.cookie = httpCookie;
    }

    public HttpCookie getCookie() {
        HttpCookie httpCookie = this.cookie;
        if (this.clientCookie != null) {
            return this.clientCookie;
        }
        return httpCookie;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cookie.getName());
        objectOutputStream.writeObject(this.cookie.getValue());
        objectOutputStream.writeObject(this.cookie.getComment());
        objectOutputStream.writeObject(this.cookie.getCommentURL());
        objectOutputStream.writeObject(this.cookie.getDomain());
        objectOutputStream.writeLong(this.cookie.getMaxAge());
        objectOutputStream.writeObject(this.cookie.getPath());
        objectOutputStream.writeObject(this.cookie.getPortlist());
        objectOutputStream.writeInt(this.cookie.getVersion());
        objectOutputStream.writeBoolean(this.cookie.getSecure());
        objectOutputStream.writeBoolean(this.cookie.getDiscard());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.clientCookie = new HttpCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.clientCookie.setComment((String) objectInputStream.readObject());
        this.clientCookie.setCommentURL((String) objectInputStream.readObject());
        this.clientCookie.setDomain((String) objectInputStream.readObject());
        this.clientCookie.setMaxAge(objectInputStream.readLong());
        this.clientCookie.setPath((String) objectInputStream.readObject());
        this.clientCookie.setPortlist((String) objectInputStream.readObject());
        this.clientCookie.setVersion(objectInputStream.readInt());
        this.clientCookie.setSecure(objectInputStream.readBoolean());
        this.clientCookie.setDiscard(objectInputStream.readBoolean());
    }
}
