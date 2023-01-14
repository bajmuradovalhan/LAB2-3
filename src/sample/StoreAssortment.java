package sample;

public class StoreAssortment {
    private Furniture[] furniture;
    private int[] quantity;

    public StoreAssortment(Furniture[] furniture, int[] quantity) {
        this.furniture = furniture;
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

    public Furniture[] getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture[] furniture) { this.furniture = furniture;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }
}
