/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.jackson;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;

public class JsonSerializeOperation {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Person deserialize(String strValue) throws IOException {
        return objectMapper.readValue(strValue, Person.class);
    }

    public String serialize(Person person) throws IOException {
        return objectMapper.writeValueAsString(person);
    }
}

class Person {

    enum MyEnum {
        A, B
    }
    private String name;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    private MyEnum myEnum = MyEnum.A;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }

}
