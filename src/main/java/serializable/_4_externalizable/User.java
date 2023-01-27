package serializable._4_externalizable;

import java.io.*;

class User implements Externalizable {
    private int id;
    private transient String name;

    private static int score;

    // 使用Externalizable时，必须提供默认构造函数，否则报错：java.io.InvalidClassException: serializable._4_externalizable.User; no valid constructor
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        User.score = score;
    }

    // Case 1
//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//    }


    // Case 2
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeInt(score);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = in.readUTF();
        score = in.readInt();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
