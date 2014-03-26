package com.tr;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NonSerilizableClass {
    private String name;

    NonSerilizableClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class SerializableSample implements Serializable {
    private String str;
    private transient NonSerilizableClass nonSerilizableClass = new NonSerilizableClass("blah");


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            os.writeBytes(nonSerilizableClass.getName());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();

            byte[] bytes = new byte[] {};
            objectInputStream.read();
            nonSerilizableClass = new NonSerilizableClass(new String(bytes));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
