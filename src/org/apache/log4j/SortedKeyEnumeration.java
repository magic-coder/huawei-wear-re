package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* compiled from: PropertyConfigurator */
class SortedKeyEnumeration implements Enumeration {
    private Enumeration f9183e;

    public SortedKeyEnumeration(Hashtable hashtable) {
        Enumeration keys = hashtable.keys();
        Vector vector = new Vector(hashtable.size());
        int i = 0;
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            int i2 = 0;
            while (i2 < i && str.compareTo((String) vector.get(i2)) > 0) {
                i2++;
            }
            vector.add(i2, str);
            i++;
        }
        this.f9183e = vector.elements();
    }

    public boolean hasMoreElements() {
        return this.f9183e.hasMoreElements();
    }

    public Object nextElement() {
        return this.f9183e.nextElement();
    }
}
