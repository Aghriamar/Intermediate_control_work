import toyshop.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ToyShop toyShop = new ToyShop();

        toyShop.addToy(1, "Rainbow Unicorn", 75);
        toyShop.addToy(2, "Superstar Action Figure", 43);
        toyShop.addToy(3, "Magic Castle Playset", 87);
        toyShop.addToy(4, "Adventure Jungle Explorer", 22);
        toyShop.addToy(5, "Smart Robot Buddy", 59);
        toyShop.addToy(6, "Princess Tea Party Set", 94);
        toyShop.addToy(7, "Dinosaur Adventure Playmat", 38);
        toyShop.addToy(8, "Superhero Power Pack", 69);
        toyShop.addToy(9, "Pirate Ship Adventure Set", 11);
        toyShop.addToy(10, "Sports Car Race Track Set", 81);

        toyShop.updateWeight(1, random.nextInt(100) + 1);
        toyShop.updateWeight(4, random.nextInt(100) + 1);
        toyShop.updateWeight(7, random.nextInt(100) + 1);
        toyShop.updateWeight(9, random.nextInt(100) + 1);

        toyShop.startRaffle();
    }
}