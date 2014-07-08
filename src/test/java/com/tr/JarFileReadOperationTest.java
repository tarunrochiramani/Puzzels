/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.jar.JarFile;

public class JarFileReadOperationTest {
    private JarFileReadOperation jarFileReadOperation = new JarFileReadOperation();

    @Test
    public void canReadJar() throws IOException {
        URL url = ClassLoader.getSystemResource("Puzzels-1.0.jar");
        jarFileReadOperation.readJarFile(url.getPath());
    }
}
