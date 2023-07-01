package toyshop;

/**
 * Класс, представляющий игрушку в магазине.
 */
public class Toy {
    private final int id;
    private final String name;
    private int weight;

    /**
     * Создает новую игрушку с заданными параметрами.
     * @param id уникальный идентификатор игрушки
     * @param name название игрушки
     * @param weight вес игрушки (в % от 100)
     */
    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    /**
     * Возвращает идентификатор игрушки.
     * @return идентификатор игрушки
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название игрушки.
     * @return название игрушки
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает вес игрушки.
     * @return вес игрушки (в % от 100)
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Устанавливает новый вес игрушки.
     * @param weight новый вес игрушки (в % от 100)
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}