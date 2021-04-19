package shoes;

import size.Size;

import java.util.Random;

/**
 * Factory for generating shoes
 */
// Factory pattern
public class ShoeBuilder  {
   int numberOfShoes = 500;
   Random rand = new Random();

    /**
     * Generates a number of shoes based on numberofShoes
     * Inserts generated shoes to the database shoeDataTable
     * @param type the brand name of the shoe to create
     */
    public void createShoes(String type) {
        type = type.toLowerCase();
        Shoe shoe;
        for (int i = 0; numberOfShoes > i; i++) {
            int length = rand.nextInt(11);
            int width = rand.nextInt(11);
            int arch = rand.nextInt(4);
            switch(type) {
                case "nike":
                    shoe = new ShoeNike(new Size(length, width, arch));
                    break;
                case "adidas":
                    shoe = new ShoeAdidas(new Size(length, width, arch));
                    break;
                case "puma":
                    shoe = new ShoePuma(new Size(length, width, arch));
                    break;
                case "reebok":
                    shoe = new ShoeReebok(new Size(length, width, arch));
                    break;
                case "vans":
                    shoe = new ShoeVans(new Size(length, width, arch));
                    break;
                case "converse":
                    shoe = new ShoeConverse(new Size(length, width, arch));
                    break;
                default:
                    System.out.println("BUILDER MISSING TYPE: " + type);
                    return;
            }
            insertShoe(shoe);
        }
    }

    /**
     * Inserts a shoe into the shoeDataTable.
     * @param shoe the shoe to be inserted into the shoeDataTable
     */
    // Initializes the shoe database table or uses the existing one, inserts shoe into said database table
    private void insertShoe(Shoe shoe) {
        ShoeDatabase.getInstance().getShoeDataTable().add(shoe);
    }
}
