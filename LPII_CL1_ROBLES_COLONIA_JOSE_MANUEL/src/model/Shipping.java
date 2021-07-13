package model;

public class Shipping {
    private String code;
    private String clientName;
    private String productName;
    private String address;
    private double price;
    private String date;
    private int status;

    public Shipping(String code, String clientName, String productName, String address, double price, String date,
            int status) {
        this.code = code;
        this.clientName = clientName;
        this.productName = productName;
        this.address = address;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
