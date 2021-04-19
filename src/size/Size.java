package size;

/**
 * The size used in shoes and feet.
 */
public class Size {

    private int length; // lets keep these 0-10
    private int width; // lets keep these 0-10
    private int arch; // Low - 0; Medium - 1; High - 2; Extra-High - 3;


    /**
     * @param length size's length
     * @param width size's width
     * @param arch size's arch
     */
    public Size(int length, int width, int arch) {
        this.length = length;
        this.width = width;
        this.arch = arch;
    }

    /**
     * Checks the properties on the sizes and checks if they are equal
     * @param size other size object to compare
     * @return true if the size properties are equal. False otherwise
     */
    public boolean isEqual(Size size) {
        return this.getWidth() == size.getWidth() && this.getLength() == size.getLength() && this.getArch() == size.getArch();
    }

    /**
     * Set length on the Size object
     * @param length new length to set on the size
     * @return itself -- the size object
     */
    // Returns itself for chaining assignment. Ex: new Size().setWidth(5).setLength(2);
    public Size setLength(int length) {
        this.length = length;
        return this;
    }

    /**
     * Set length on the Size object
     * @param width new width to set on the size
     * @return itself -- the size object
     */
    public Size setWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * Set length on the Size object
     * @param arch new arch to set on the size
     * @return itself -- the size object
     */
    public Size setArch(int arch) {
        this.arch = arch;
        return this;
    }

    /**
     * Getter for size's length
     * @return length of the shoe
     */
    public int getLength() {
        return length;
    }
    /**
     * Getter for size's width
     * @return width of the shoe
     */
    public int getWidth() {
        return width;
    }
    /**
     * Getter for size's arch
     * @return arch of the shoe
     */
    public int getArch() {
        return arch;
    }

    /**
     * Formats a string containing a pretty version of the the size
     * @return a formatted string providing readable details about the size
     */
    public String stringifySize() {
        return "Length: " +
                length +
                "\n Width: " +
                width +
                "\n Arch: " +
                arch;
    }

}
