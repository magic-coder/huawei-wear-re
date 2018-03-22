package com.fenda.hwbracelet.connection;

import android.os.Handler;
import java.util.HashMap;
import java.util.UUID;

/* compiled from: CharacteristicHandlersContainer */
public class C3594k {
    private HashMap<UUID, HashMap<UUID, Handler>> f13764a = new HashMap();

    public void m18049a(UUID uuid, UUID uuid2, Handler handler) {
        HashMap hashMap = (HashMap) this.f13764a.get(uuid);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f13764a.put(uuid, hashMap);
        }
        hashMap.put(uuid2, handler);
    }

    public void m18048a(UUID uuid, UUID uuid2) {
        HashMap hashMap = (HashMap) this.f13764a.get(uuid);
        if (hashMap != null) {
            hashMap.remove(uuid2);
        }
    }

    public Handler m18050b(UUID uuid, UUID uuid2) {
        HashMap hashMap = (HashMap) this.f13764a.get(uuid);
        if (hashMap == null) {
            return null;
        }
        return (Handler) hashMap.get(uuid2);
    }
}
