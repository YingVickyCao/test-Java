package com.hades.java.example.serializable._externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Error:发现报错了，序列化成功了，但反序列化失败。提示没有有效的构造方法。
 * 3 actionable tasks: 2 executed, 1 up-to-date
 * java.io.InvalidClassException: serializable._4_externalizable.User; no valid constructor
 * 	at java.base/java.io.ObjectStreamClass$ExceptionInfo.newInvalidClassException(ObjectStreamClass.java:159)
 * 	at java.base/java.io.ObjectStreamClass.checkDeserialize(ObjectStreamClass.java:875)
 * 	at java.base/java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2170)
 * 	at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1679)
 * 	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:493)
 * 	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:451)
 * 	at serializable._4_externalizable.ExternalizableExample.deserialize(ExternalizableExample.java:40)
 * 	at serializable._4_externalizable.ExternalizableExample.test(ExternalizableExample.java:17)
 * 	at serializable._4_externalizable.ExternalizableExample.main(ExternalizableExample.java:10)
 * 22:46:03: Execution finished ':ExternalizableExample.main()'
 * <p>
 * Fix : 使用 Externalizable 进行序列化时，必须要有默认的构造方法
 */
public class ExternalizableExample {
    public static void main(String[] args) {
        ExternalizableExample example = new ExternalizableExample();
        example.test();
    }

    String filePath = "user.txt";

    /**
     * Case 1 : writeExternal and readExternal的实现 为空
     * 序列化后：User{id=0, name='null', score='100'}
     * 结论：序列化的细节由开发实现。如果不实现，那么，序列化行为不回保存/读取任何一个字段。
     * <p>
     * Case 2 : writeExternal and readExternal的实现不为空
     * 序列化后：User{id=1, name='name_1', score='100'}
     * 结论：
     * 使用 Externalizable 进行序列化时，必须要有默认的构造方法。
     * transient 失效。*
     * <p>
     * Case 3 : writeExternal and readExternal的实现不为空 + User又实现了Serializable 接口
     * 序列化后：User{id=1, name='name_1', score='100'}
     * 结论：Externalizable 序列化的优先级比Serializable的优先级高。
     */
    private void test() {
        serialize();
        deserialize();
    }

    private void serialize() {
        User user = new User(); // User@453
        user.setId(1);
        user.setName("name_1");
        user.setScore(100);
        user.setHouse(new House());

        ObjectOutputStream outStream;
        ObjectInputStream inStream;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(filePath));
            // 调用 writeObject 时，调用writeExternal
            outStream.writeObject(user);
            outStream.flush();
            outStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        user.setScore(10);
    }

    private void deserialize() {
        try {
            ObjectInputStream inStream;
            inStream = new ObjectInputStream(new FileInputStream(filePath));
            // 调用 readObject 时，调用  readExternal，然后invoke 默认构造函数，最后invoke set/get
            // 序列化前与序列化后的地址也不同。
            // score 10 -> 100,说明static field 参与了反序列化
            // 序列化后：User{id=1, house=House{date=Mon Jan 30 16:16:34 CST 2023}, name='name_1', score='100'}
            User user = (User) inStream.readObject(); // User@760
            // 反序列是深拷贝
            System.out.println("序列化后：" + user.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
