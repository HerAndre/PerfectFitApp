package shoes;

import utlities.DebugMode;

import java.util.ArrayList;
// adopts singleton pattern
public class ShoeDatabase {

    private static ShoeDatabase instance = new ShoeDatabase();

    private final ArrayList<Shoe> shoeDataList = new ArrayList<>();

    public static ShoeDatabase getInstance(){
        return instance;
    }

    public ArrayList<Shoe> getShoeDataTable() {
        return shoeDataList;
    }

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
