package async;

public class UserReserve {
    private Furniture furniture;
    private int quantity;
    private double totalAmount;

    public UserReserve() {
        this.furniture = new Furniture();
        this.quantity = 0;
        this.totalAmount = 0;
    }

    public UserReserve(Furniture furniture, int quantity) {
        this.furniture = furniture;
        this.quantity = quantity;
        this.totalAmount = furniture.getPrice() * quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
