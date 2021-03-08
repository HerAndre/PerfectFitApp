package size;

public class Size {

    private int length;
    private int width;

    public Size(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public Size setLength(int length) {
        this.length = length;
        return this;
    }

    public int getWidth() {
        return width;
    }

    // Returns itself for chaining assignment. Ex: new Size().setWidth(5).setLength(2);
    public Size setWidth(int width) {
        this.width = width;
        return this;
    }
}
