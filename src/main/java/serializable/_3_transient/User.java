package serializable._3_transient;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = -4575083234166325540L;

    private int id;
    private transient String name;

    private static int score;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
