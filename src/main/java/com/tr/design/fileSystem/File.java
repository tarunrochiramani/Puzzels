/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.fileSystem;

public class File extends Entry {
    private String content;

    public File(String name, Directory parent) {
        super(name, parent);
    }

    @Override
    public int getSize() {
        return content.length();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
