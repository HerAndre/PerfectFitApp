package shoes;

import size.Size;

/**
 * Contains a string brand name and a Size object
 */
public class Shoe {

    private String brand;
    private Size size;

    /**
     * Constructor of a shoe
     * @param brand the brand name of the shoe
     * @param size the size object of the shoe
     */
    public Shoe(String brand, Size size) {
        this.brand = brand;
        this.size = size;
    }

    public Shoe(Size size) {
        this.size = size;
    }

    /**
     * Formats a string containing a pretty version of the the shoe
     * @return a formatted string providing readable details about the shoe
     */
    public String stringifyShoe() {
        Size shoeSize = getSize();

        return "Brand: " +
                getBrand() +
                "; Size: " +
                shoeSize.stringifySize();
    }

    /**
     * Getter for brand
     * @return brand of the shoe
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Getter for size
     * @return size object of the shoe
     */
    public Size getSize() {
        return this.size;
    }
}
