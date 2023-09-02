package json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PerformerJson {
    @JsonIgnore
    private int performerId;

    @JsonProperty("performerName")
    private String performerName;

    @JsonProperty("performerPhone")
    private String performerPhone;

    @JsonProperty("performerEmail")
    private String performerEmail;

    public PerformerJson(int performerId, String performerName, String performerPhone, String performerEmail) {
        this.performerId = performerId;
        this.performerName = performerName;
        this.performerPhone = performerPhone;
        this.performerEmail = performerEmail;
    }

    public PerformerJson() {}

    public int getPerformerId() {
        return performerId;
    }

    public void setPerformerId(int performerId) {
        this.performerId = performerId;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getPerformerPhone() {
        return performerPhone;
    }

    public void setPerformerPhone(String performerPhone) {
        this.performerPhone = performerPhone;
    }

    public String getPerformerEmail() {
        return performerEmail;
    }

    public void setPerformerEmail(String performerEmail) {
        this.performerEmail = performerEmail;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "performerId=" + performerId +
                ", performerName='" + performerName + '\'' +
                ", performerPhone='" + performerPhone + '\'' +
                ", performerEmail='" + performerEmail + '\'' +
                '}';
    }
}
