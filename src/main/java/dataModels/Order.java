package dataModels;

public class Order {

    private String orderNumber;
    private boolean isCompleted;
    private double totalPrice;
    private Bag bag;
    private Address address;
    private RegisteredUser registeredUser;
    private UserBase notRegisterUser;


    public Order(Bag bag, Address address, RegisteredUser registeredUser) {
        this.bag = bag;
        this.address = address;
        this.registeredUser = registeredUser;
    }

    public Order(Bag bag, Address address, UserBase notRegisterUser) {
        this.bag = bag;
        this.address = address;
        this.notRegisterUser = notRegisterUser;
    }

    public UserBase getNotRegisterUser() {
        return notRegisterUser;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Bag getBag() {
        return bag;
    }

    public Address getAddress() {
        return address;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

