package json;

import com.fasterxml.jackson.annotation.*;

@JsonRootName("Customer")
@JsonPropertyOrder({"customerPhone", "customerName"})
public class CustomerJson {
    @JsonIgnore
    private int customerId;

    @JsonProperty
    private String customerName;

    @JsonProperty
    private String customerPhone;

    @JsonIgnore
    private String customerStreetAddress;

    @JsonIgnore
    private int cityId;

    public CustomerJson(int customerId, String customerName, String customerPhone, String customerStreetAddress, int cityId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerStreetAddress = customerStreetAddress;
        this.cityId = cityId;
    }

    public CustomerJson() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerStreetAddress() {
        return customerStreetAddress;
    }

    public void setCustomerStreetAddress(String customerStreetAddress) {
        this.customerStreetAddress = customerStreetAddress;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerStreetAddress='" + customerStreetAddress + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
