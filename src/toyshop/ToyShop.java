package toyshop;
import java.io.*;
import java.util.*;

public class ToyShop {
    private final List<Toy> toys;

    private final List<Toy> prizeToys;
    private int totalToys;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        totalToys = 0;
    }

    public void addToy(int id, String name, int weight) {
        Toy toy = new Toy(id, name, weight);
        toys.add(toy);
        totalToys++;
    }

    public void updateWeight(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void startRaffle() {
        if (prizeToys.isEmpty()) {
            generatePrizeToys();
        }
        while (!prizeToys.isEmpty()) {
            Toy prizeToy = getPrizeToy();
            if(prizeToy != null) {
                writeToFile(prizeToy);
                System.out.println("Congratulations! You won a toy: " + prizeToy.getName());
            } else {
                System.out.println("No more prize toys available.");
            }
        }
    }

    private void generatePrizeToys() {
        Random random = new Random();
        for (Toy toy : toys) {
            int weight = toy.getWeight();
            int randomValue = random.nextInt(100) + 1;
            if (randomValue <= weight) {
                prizeToys.add(toy);
            }
        }
    }

    private Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            return null;
        }
        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(0);
        totalToys--;
        return prizeToy;
    }

    private void writeToFile(Toy toy) {
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(toy.getId() + ", " + toy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}