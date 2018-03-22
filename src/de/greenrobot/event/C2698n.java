package de.greenrobot.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SubscriberMethodFinder */
class C2698n {
    private static final Map<String, List<C2697m>> f9151a = new HashMap();
    private static final Map<Class<?>, Class<?>> f9152b = new ConcurrentHashMap();

    C2698n() {
    }

    List<C2697m> m12852a(Class<?> cls, String str) {
        String str2 = cls.getName() + '.' + str;
        synchronized (f9151a) {
            List<C2697m> list = (List) f9151a.get(str2);
        }
        if (list != null) {
            return list;
        }
        List<C2697m> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name2 = method.getName();
                if (name2.startsWith(str)) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        C2700p c2700p;
                        name = name2.substring(str.length());
                        if (name.length() == 0) {
                            c2700p = C2700p.PostThread;
                        } else if (name.equals("MainThread")) {
                            c2700p = C2700p.MainThread;
                        } else if (name.equals("BackgroundThread")) {
                            c2700p = C2700p.BackgroundThread;
                        } else if (name.equals("Async")) {
                            c2700p = C2700p.Async;
                        } else if (!f9152b.containsKey(cls2)) {
                            throw new C2692h("Illegal onEvent method, check for typos: " + method);
                        }
                        Class cls3 = parameterTypes[0];
                        stringBuilder.setLength(0);
                        stringBuilder.append(name2);
                        stringBuilder.append('>').append(cls3.getName());
                        if (hashSet.add(stringBuilder.toString())) {
                            arrayList.add(new C2697m(method, c2700p, cls3));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            throw new C2692h("Subscriber " + cls + " has no methods called " + str);
        }
        synchronized (f9151a) {
            f9151a.put(str2, arrayList);
        }
        return arrayList;
    }
}
