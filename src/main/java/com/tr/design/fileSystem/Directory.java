/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private List<Entry> children;

    public Directory(String name, Directory parent) {
        super(name, parent);
        children = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (Entry child : children) {
            totalSize += child.getSize();
        }

        return totalSize;
    }
}
