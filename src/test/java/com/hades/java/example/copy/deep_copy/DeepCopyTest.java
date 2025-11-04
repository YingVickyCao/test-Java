package com.hades.java.example.copy.deep_copy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 深拷贝
 * Deep Copy
 */
class Address implements Cloneable {
    String street;

    public Address(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return street;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Address 只有 String (不可变)，所以直接 clone 也是安全的
        return super.clone();
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
        // 手动深拷贝
        Person cloned = (Person) super.clone(); // 浅拷贝对象本身
        cloned.address = (Address) this.address.clone(); // 复制 Address 对象
        return cloned;
    }
}

public class DeepCopyTest {
    @Test
    public void test_1() throws CloneNotSupportedException {
        String street = "Main";
        String street2 = "456 Oak Ave";
        String name = "Alice";
        Address originalAddress = new Address(street);
        Person originalPerson = new Person(name, originalAddress);

        // 深拷贝
        Person clonedPerson = (Person) originalPerson.clone();

        Assert.assertEquals(originalPerson.name, clonedPerson.name);
        Assert.assertNotEquals(originalPerson.address, clonedPerson.address); // address 是不同对象,但值相同
        Assert.assertEquals(originalPerson.address.street, clonedPerson.address.street);

        clonedPerson.address.street = street2;

        Assert.assertEquals(originalPerson.name, clonedPerson.name);
        Assert.assertNotEquals(originalPerson.address, clonedPerson.address);
        Assert.assertEquals(clonedPerson.address.street, street2);
        Assert.assertEquals(originalPerson.address.street, street);
    }
}
