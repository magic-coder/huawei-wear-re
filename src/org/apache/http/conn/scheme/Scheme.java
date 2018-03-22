package org.apache.http.conn.scheme;

import android.support.v4.internal.view.SupportMenu;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.LangUtils;

@Immutable
public final class Scheme {
    private final int defaultPort;
    private final boolean layered;
    private final String name;
    private final SchemeSocketFactory socketFactory;
    private String stringRep;

    public Scheme(String str, int i, SchemeSocketFactory schemeSocketFactory) {
        if (str == null) {
            throw new IllegalArgumentException("Scheme name may not be null");
        } else if (i <= 0 || i > SupportMenu.USER_MASK) {
            throw new IllegalArgumentException("Port is invalid: " + i);
        } else if (schemeSocketFactory == null) {
            throw new IllegalArgumentException("Socket factory may not be null");
        } else {
            this.name = str.toLowerCase(Locale.ENGLISH);
            this.defaultPort = i;
            if (schemeSocketFactory instanceof SchemeLayeredSocketFactory) {
                this.layered = true;
                this.socketFactory = schemeSocketFactory;
            } else if (schemeSocketFactory instanceof LayeredSchemeSocketFactory) {
                this.layered = true;
                this.socketFactory = new SchemeLayeredSocketFactoryAdaptor2((LayeredSchemeSocketFactory) schemeSocketFactory);
            } else {
                this.layered = false;
                this.socketFactory = schemeSocketFactory;
            }
        }
    }

    @Deprecated
    public Scheme(String str, SocketFactory socketFactory, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Scheme name may not be null");
        } else if (socketFactory == null) {
            throw new IllegalArgumentException("Socket factory may not be null");
        } else if (i <= 0 || i > SupportMenu.USER_MASK) {
            throw new IllegalArgumentException("Port is invalid: " + i);
        } else {
            this.name = str.toLowerCase(Locale.ENGLISH);
            if (socketFactory instanceof LayeredSocketFactory) {
                this.socketFactory = new SchemeLayeredSocketFactoryAdaptor((LayeredSocketFactory) socketFactory);
                this.layered = true;
            } else {
                this.socketFactory = new SchemeSocketFactoryAdaptor(socketFactory);
                this.layered = false;
            }
            this.defaultPort = i;
        }
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    @Deprecated
    public final SocketFactory getSocketFactory() {
        if (this.socketFactory instanceof SchemeSocketFactoryAdaptor) {
            return ((SchemeSocketFactoryAdaptor) this.socketFactory).getFactory();
        }
        if (this.layered) {
            return new LayeredSocketFactoryAdaptor((LayeredSchemeSocketFactory) this.socketFactory);
        }
        return new SocketFactoryAdaptor(this.socketFactory);
    }

    public final SchemeSocketFactory getSchemeSocketFactory() {
        return this.socketFactory;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isLayered() {
        return this.layered;
    }

    public final int resolvePort(int i) {
        return i <= 0 ? this.defaultPort : i;
    }

    public final String toString() {
        if (this.stringRep == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.name);
            stringBuilder.append(':');
            stringBuilder.append(Integer.toString(this.defaultPort));
            this.stringRep = stringBuilder.toString();
        }
        return this.stringRep;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        if (this.name.equals(scheme.name) && this.defaultPort == scheme.defaultPort && this.layered == scheme.layered) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.defaultPort), this.name), this.layered);
    }
}
