package House;

public class Resident {
    private double money;
    private String name;

    public Resident(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
}
