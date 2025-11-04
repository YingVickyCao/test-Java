package com.hades.java.example.copy.shadow_copy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 浅拷贝
 * Shadow Copy
 */
class Address {
    String street;

    public Address(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return street;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 默认是浅拷贝
        return super.clone();
    }
}

public class ShallowCopyTest {
    @Test
    public void test_1() throws CloneNotSupportedException {
        String street = "Main";
        String street2 = "456 Oak Ave";
        String name = "Alice";
        Address originalAddress = new Address(street);
        Person originalPerson = new Person(name, originalAddress);

        // 浅拷贝
        Person clonedPerson = (Person) originalPerson.clone();

        Assert.assertEquals(originalPerson.name, clonedPerson.name);
        Assert.assertEquals(originalPerson.address, clonedPerson.address); // address 是同一个对象

        clonedPerson.address.street = street2;

        Assert.assertEquals(originalPerson.name, clonedPerson.name);
        Assert.assertEquals(originalPerson.address, clonedPerson.address);
        Assert.assertEquals(clonedPerson.address.street, street2);
        Assert.assertEquals(originalPerson.address.street, street2);
    }
}
