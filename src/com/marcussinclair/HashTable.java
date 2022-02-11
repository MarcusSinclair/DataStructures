package com.marcussinclair;

import java.util.LinkedList;

public class HashTable {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        var index = hash(key);
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }
        for (var entry : entries[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        entries[index].addLast(new Entry(key, value));
    }

    private int hash(int key) {
        return key % entries.length;
    }

    public String get(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }

        return null;
    }

    public void remove(int key) {
        var bucket = getBucket(key);
        if (bucket == null) {
            throw new IllegalStateException();
        }

        bucket.remove(getEntry(key));
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        for (var entry : bucket) {
            if (entry.key == key) {
                return entry;
            }
        }

        return null;
    }

}
