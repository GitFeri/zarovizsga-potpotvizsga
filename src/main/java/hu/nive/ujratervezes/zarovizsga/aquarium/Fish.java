package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {

    private final String name;
    private int weight;
    private final String color;
    private final Boolean memoryLoss;

    protected Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        memoryLoss = false;
    }

    protected Fish(String name, int weight, String color, Boolean memoryLoss) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.memoryLoss = memoryLoss;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    public String status() {
        return name + ", weight: " + weight + ", color: " + color + ", short term memory loss: " + memoryLoss;
    }

    public abstract void feed();

    protected void feed(int addWeigth) {
        weight += addWeigth;
    }
}
