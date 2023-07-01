package toyshop;
import java.io.*;
import java.util.*;

/**
 * Класс, представляющий магазин игрушек.
 * Реализует функционал добавления новых игрушек, изменения веса (частоты выпадения) игрушек
 * и организацию розыгрыша игрушек.
 */
public class ToyShop {
    private final List<Toy> toys;

    /**
     * Список призовых игрушек, ожидающих выдачи.
     */
    private final List<Toy> prizeToys;
    private int totalToys;

    /**
     * Создает новый экземпляр класса ToyShop.
     */
    public ToyShop() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        totalToys = 0;
    }

    /**
     * Добавляет новую игрушку в магазин.
     *
     * @param id идентификатор игрушки
     * @param name название игрушки
     * @param weight вес (частота выпадения) игрушки в процентах от 100
     */
    public void addToy(int id, String name, int weight) {
        Toy toy = new Toy(id, name, weight);
        toys.add(toy);
        totalToys++;
    }

    /**
     * Обновляет вес (частоту выпадения) игрушки по её идентификатору.
     *
     * @param id идентификатор игрушки
     * @param weight новый вес игрушки в процентах от 100
     */
    public void updateWeight(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    /**
     * Запускает розыгрыш игрушек.
     * Выбирает призовые игрушки, записывает их в файл и уменьшает количество игрушек.
     */
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

    /**
     * Генерирует список призовых игрушек на основе их веса (частоты выпадения).
     */
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

    /**
     * Получает призовую игрушку из списка ожидания.
     * Удаляет её из списка и возвращает.
     *
     * @return призовая игрушка
     */
    private Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            return null;
        }
        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(0);
        totalToys--;
        return prizeToy;
    }

    /**
     * Записывает выигрышную игрушку в файл.
     *
     * @param toy выигрышная игрушка
     */
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