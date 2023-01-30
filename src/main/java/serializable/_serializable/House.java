package serializable._serializable;

import java.io.Serializable;
import java.util.Date;

public class House implements Serializable {
    private Date date = new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "House{" +
                "date=" + date +
                '}';
    }
}
