package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).build();
    public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_RSA_WITH_RC4_128_SHA, CipherSuite.TLS_RSA_WITH_RC4_128_MD5).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    private final String[] cipherSuites;
    private ConnectionSpec supportedSpec;
    final boolean supportsTlsExtensions;
    final boolean tls;
    private final String[] tlsVersions;

    public final class Builder {
        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;

        private Builder(boolean z) {
            this.tls = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (this.tls) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].javaName;
                }
                return cipherSuites(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        Builder cipherSuites(String[] strArr) {
            this.cipherSuites = strArr;
            return this;
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (this.tls) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return tlsVersions(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        Builder tlsVersions(String... strArr) {
            this.tlsVersions = strArr;
            return this;
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec();
        }
    }

    private ConnectionSpec(Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.tls;
    }

    public List<CipherSuite> cipherSuites() {
        Object[] objArr = new CipherSuite[this.cipherSuites.length];
        for (int i = 0; i < this.cipherSuites.length; i++) {
            objArr[i] = CipherSuite.forJavaName(this.cipherSuites[i]);
        }
        return Util.immutableList(objArr);
    }

    public List<TlsVersion> tlsVersions() {
        Object[] objArr = new TlsVersion[this.tlsVersions.length];
        for (int i = 0; i < this.tlsVersions.length; i++) {
            objArr[i] = TlsVersion.forJavaName(this.tlsVersions[i]);
        }
        return Util.immutableList(objArr);
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    void apply(SSLSocket sSLSocket, Route route) {
        String[] strArr;
        Platform platform;
        ConnectionSpec connectionSpec = this.supportedSpec;
        if (connectionSpec == null) {
            connectionSpec = supportedSpec(sSLSocket);
            this.supportedSpec = connectionSpec;
        }
        sSLSocket.setEnabledProtocols(connectionSpec.tlsVersions);
        Object obj = connectionSpec.cipherSuites;
        if (route.shouldSendTlsFallbackIndicator) {
            String str = "TLS_FALLBACK_SCSV";
            if (Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
                strArr = new String[(obj.length + 1)];
                System.arraycopy(obj, 0, strArr, 0, obj.length);
                strArr[strArr.length - 1] = "TLS_FALLBACK_SCSV";
                sSLSocket.setEnabledCipherSuites(strArr);
                platform = Platform.get();
                if (connectionSpec.supportsTlsExtensions) {
                    platform.configureTlsExtensions(sSLSocket, route.address.uriHost, route.address.protocols);
                }
            }
        }
        Object obj2 = obj;
        sSLSocket.setEnabledCipherSuites(strArr);
        platform = Platform.get();
        if (connectionSpec.supportsTlsExtensions) {
            platform.configureTlsExtensions(sSLSocket, route.address.uriHost, route.address.protocols);
        }
    }

    private ConnectionSpec supportedSpec(SSLSocket sSLSocket) {
        List intersect = Util.intersect(this.cipherSuites, sSLSocket.getSupportedCipherSuites());
        List intersect2 = Util.intersect(this.tlsVersions, sSLSocket.getSupportedProtocols());
        return new Builder(this).cipherSuites((String[]) intersect.toArray(new String[intersect.size()])).tlsVersions((String[]) intersect2.toArray(new String[intersect2.size()])).build();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (this.tls != connectionSpec.tls) {
            return false;
        }
        if (!this.tls || (Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.tls) {
            return 17;
        }
        return (this.supportsTlsExtensions ? 0 : 1) + ((((Arrays.hashCode(this.cipherSuites) + 527) * 31) + Arrays.hashCode(this.tlsVersions)) * 31);
    }

    public String toString() {
        if (this.tls) {
            return "ConnectionSpec(cipherSuites=" + cipherSuites() + ", tlsVersions=" + tlsVersions() + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
        }
        return "ConnectionSpec()";
    }
}
