package shoes;

import size.Size;

import java.util.Random;

// Factory pattern
public class ShoeBuilder  {
   int numberOfShoes = 10;
   Random rand = new Random();

    public void createShoes(String type) {
        type = type.toLowerCase();
        Shoe shoe;
        for (int i = 0; numberOfShoes > i; i++) {
            int length = rand.nextInt(10);
            int width = rand.nextInt(10);
            int arch = rand.nextInt(3);
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
    // Initializes the shoe database table or uses the existing one, inserts shoe into said database table
    private void insertShoe(Shoe shoe) {
        ShoeDatabase.getInstance().getShoeDataTable().add(shoe);
    }
}
