package serializable._serializable;

import java.io.*;

/**
 *
 * 测试：transient 修饰 字段name，那么，序列化时会忽略name
 */
public class TransientExample {
    public static void main(String[] args) {
        TransientExample example = new TransientExample();
        example.test();
    }

    String filePath = "user.txt";

    private void test() {
        serialize();
        deserialize();
    }

    private void serialize() {
        User user = new User();
        user.setId(1);
        user.setName("name_1");
        user.setScore(100);
        user.setHouse(new House());

        ObjectOutputStream outStream;
        ObjectInputStream inStream;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(filePath));
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
            // 调用readObject后，不调用构造函数。
            User user = (User) inStream.readObject();
            // 序列化后：User{id=1, house=House{date=Mon Jan 30 16:18:55 CST 2023}, name='null', score='10'}
            System.out.println("序列化后：" + user.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
