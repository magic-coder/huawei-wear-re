package com.huawei.p086k.p462a;

import com.huawei.p190v.C2538c;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* compiled from: RsaEncrypt */
public class C5411f {
    public static final String f19226a = C5411f.class.getSimpleName();
    private String f19227b = "e8fdb5642f64a4f75c9ef453d1c3beb48a7f3fb59a2f70a08cca447420e1ed1094e05ef54c6ed4ba6d6f00147395214b92abc74fe9b922d4eccf5c9de2b91e843fba6eabfa4f98be4c3e0e6ed6ff4e001085028c6b7dd2aa100eddf1afd1015d9d59d5975680e118f2d85742c6c79f7f62dedd53e5d80da395242099a166a8e70d0dda160051adb0aae094ff2b244827262d8a4bc1224eafa642d555705a404784ced9a160cad614bbf486b38ef2bc0119fff2617daae6a03d9aa86d2086f3f9de2d5adbdf3e82a9df454780f40fc809762a6081f795c4834282cdc1a2461da5edc26459e3f4e946b5cd076e028a255d86d00702afeb08fc6e782bce2a11090d";

    public RSAPublicKey m26002a(String str) {
        String a = new C5410e(str).m26000a();
        if (a != null) {
            this.f19227b = a;
        }
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(this.f19227b, 16), new BigInteger("65537")));
        } catch (Exception e) {
            C2538c.e(f19226a, new Object[]{e.getMessage()});
            return null;
        }
    }
}
