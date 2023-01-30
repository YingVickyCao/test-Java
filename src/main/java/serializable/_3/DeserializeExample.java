package serializable._3;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 测试：transient 修饰 字段name，那么，序列化时会忽略name
 */
public class DeserializeExample {
    public static void main(String[] args) {
        DeserializeExample example = new DeserializeExample();
        example.test();
    }

    String filePath = "user.txt";

    private void test() {
        deserialize();
    }

    private void deserialize() {
        try {
            ObjectInputStream inStream;
            inStream = new ObjectInputStream(new FileInputStream(filePath));
            // 调用readObject后，不调用构造函数。
            User user = (User) inStream.readObject();
            // 序列化后：User{id=1, name='null', score='100'}
            System.out.println("序列化后：" + user.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
