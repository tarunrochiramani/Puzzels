/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.jackson;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JsonSerializeOperationTest {

    private JsonSerializeOperation jsonSerializeOperation = new JsonSerializeOperation();

    @Test
    public void canSerializeAndDeserialize() throws IOException {
        Person person = new Person();
        person.setName("personA");
        person.setMyEnum(Person.MyEnum.B);

        String strValue = jsonSerializeOperation.serialize(person);
        assertNotNull(strValue);

        Person personToVerify = jsonSerializeOperation.deserialize(strValue);
        assertNotNull(personToVerify);
        assertEquals(person.getName(), personToVerify.getName());
        assertEquals(person.getMyEnum(), personToVerify.getMyEnum());
    }

    @Test
    public void canSerializeAndDeserializeWithMissingProperty() throws IOException {
        String strValue = "{\"name\":\"personA\"}";

        Person personToVerify = jsonSerializeOperation.deserialize(strValue);
        assertNotNull(personToVerify);
        assertEquals("personA", personToVerify.getName());
        assertEquals(Person.MyEnum.A, personToVerify.getMyEnum());

        String str = jsonSerializeOperation.serialize(personToVerify);
        assertNotNull(str);
    }
}
