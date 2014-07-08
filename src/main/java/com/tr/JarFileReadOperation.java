/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarFileReadOperation {

    public void readJarFile(String filePath) throws IOException {
        JarFile jarFile = new JarFile(filePath);

        Manifest manifest = jarFile.getManifest();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            Attributes attributes = jarEntry.getAttributes();
        }
    }
}
