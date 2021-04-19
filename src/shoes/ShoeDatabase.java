package shoes;

import utlities.DebugMode;

import java.util.ArrayList;

/**
 * Singleton derived
 * Returns itself
 */
public class ShoeDatabase {

    /**
     * Field containing the only instance allowed
     */
    private static ShoeDatabase instance = null;

    /**
     * Private the constructor to prevent others from using it.
     * It is still possible to access externally though...
     */
    private ShoeDatabase() {}

    /**
     * Arraylist containing all the shoes on the application
     */
    private final ArrayList<Shoe> shoeDataList = new ArrayList<>();

    /**
     * Creates or returns the shoeDatabase class
     * @return instance of the shoeDatabase and or creates one if there does not exist one
     */
    public static ShoeDatabase getInstance() {
        if (instance == null) {
            instance = new ShoeDatabase();
        }
        return instance;
    }

    /**
     * Getter for the shoeDataTable
     * @return shoeDataTable
     */
    public ArrayList<Shoe> getShoeDataTable() {
        return shoeDataList;
    }

    /**
     * Pretty prints the shoes in the shoeDataTable (Only works in DEBUG mode)
     */
    public void printShoeDataTable() {
        if (DebugMode.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            shoeDataList.forEach(shoe -> {
                stringBuilder.append("[");
                stringBuilder.append(shoe.getBrand());
                stringBuilder.append(": Length: ");
                stringBuilder.append(shoe.getSize().getLength());
                stringBuilder.append(", Width: ");
                stringBuilder.append(shoe.getSize().getWidth());
                stringBuilder.append(", Arch: ");
                stringBuilder.append(shoe.getSize().getArch());
                stringBuilder.append("]\n");
                System.out.println(stringBuilder);
            });
        }
    }
}
