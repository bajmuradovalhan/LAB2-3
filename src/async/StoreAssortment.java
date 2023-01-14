package async;

public class StoreAssortment {
    private Furniture[] furnitures;
    private int[] quantity;

    public StoreAssortment(Furniture[] furnitures, int[] quantity) {
        this.furnitures = furnitures;
        this.quantity = quantity;
    }

    public StoreAssortment() {
    }

    public void setQuantityFromIndex(int index, int value) {
        try {
            quantity[index] = value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Furniture[] getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(Furniture[] furnitures) {
        this.furnitures = furnitures;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }
}
