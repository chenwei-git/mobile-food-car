package com.cw.mfc.business.util;

import java.util.HashMap;

public class MapUtil {

    private MapUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <K, V> GlueMap<K, V> of(K k, V v) {
        return GlueMap.<K, V>get().of(k, v);
    }

    public static class GlueMap<K, V> extends HashMap<K, V> {

        public static <K, V> GlueMap<K, V> get() {
            return new GlueMap<>();
        }

        public GlueMap<K, V> of(K k, V v) {
            this.put(k, v);
            return this;
        }
    }
}