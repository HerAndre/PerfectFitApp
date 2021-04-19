package shoes;

import size.Size;

public class Shoe {

    private String brand;
    private Size size;

    public Shoe(String brand, Size size) {
        this.brand = brand;
        this.size = size;
    }

    public Shoe(Size size) {
        this.size = size;
    }

    public String stringifyShoe() {
        Size shoeSize = getSize();

        return "Brand: " +
                getBrand() +
                "; Size: " +
                shoeSize.stringifySize();
    }

    public String getBrand() {
        return this.brand;
    }

    public Size getSize() {
        return this.size;
    }
}
