/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design;

import java.util.LinkedList;

public class HashTabble<K, V> {
    private LinkedList<HashTableObject<K, V>>[] list;
    private final int size = 10;

    public HashTabble() {
        list = new LinkedList[size];
    }

    public void put(K key, V value) {
        int slot = key.hashCode() % size;
        if (list[slot] == null) {
            list[slot] = new LinkedList<>();
        }
        list[slot].add(new HashTableObject<K, V>(key, value));
    }

    public V get(K key) {
        int slot = key.hashCode() % size;
        for (HashTableObject<K, V> hashTableObject : list[slot]) {
            if (hashTableObject.key.equals(key)) {
                return hashTableObject.value;
            }
        }

        return null;
    }
}

class HashTableObject<K, V> {
    K key;
    V value;

    HashTableObject(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
