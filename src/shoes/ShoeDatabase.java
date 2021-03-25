package shoes;

import com.sun.org.apache.xpath.internal.operations.String;
import size.Size;
import utlities.DebugMode;

import java.util.ArrayList;
import java.util.Random;

public class ShoeDatabase {


    private final ArrayList<Shoe> shoeDataList = new ArrayList<>();

    Random rand = new Random();
    private final int shoeCount = 10;

    public ShoeDatabase() {
        initShoes();

        // Prints out the shoes in the shoeDataList array
        if (DebugMode.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            shoeDataList.forEach((shoe ->
                stringBuilder.append( "["
                        + shoe.getBrand() + ": "
                        + "Length: "  + shoe.getSize().getLength() + ", "
                        + "Width: " + shoe.getSize().getWidth() + ", "
                        + "Arch: " + shoe.getSize().getArch() + "]\n"
                )));
            System.out.println(stringBuilder);
            }


    }

    private void initShoes() {
        initAdidasShoes();
        initNikeShoes();
    }

    private void initNikeShoes() {
        for (int i = 0; shoeCount > i; i++) {
            int length = rand.nextInt(5);
            int width = rand.nextInt(5);
            int arch = rand.nextInt(3);
            shoeDataList.add(new ShoeNike(new Size(length, width, arch)));
        }
    }

    private void initAdidasShoes() {
        for (int i = 0; shoeCount > i; i++) {
            int length = rand.nextInt(5);
            int width = rand.nextInt(5);
            int arch = rand.nextInt(3);
            shoeDataList.add(new ShoeAdidas(new Size(length, width, arch)));
        }
    }

    public ArrayList<Shoe> getShoeDataList() {
        return shoeDataList;
    }

}
