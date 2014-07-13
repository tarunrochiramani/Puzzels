/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.fileSystem;

import java.util.Date;

public abstract class Entry {
    protected String name;
    protected long created;
    protected long lastAccessed;
    protected Directory parent;

    public Entry(String name, Directory parent) {
        this.parent = parent;
        this.name = name;
        created = new Date().getTime();
        lastAccessed = created;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public abstract int getSize();
}
