package Products;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Product {
    private Type type;
    private int cost;
    private String description;
    private List<Integer> usersMarks;
    private double commonRating;
    private int availableCount;
    private int sellCount;


    public Product(Type type, int cost, String description, int availableCount) {
        this.type = type;
        this.cost = cost;
        this.description = description;
        this.availableCount = availableCount;
        usersMarks = new ArrayList<>();
        commonRating = 0;
        sellCount = 0;
    }

    public Type getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public List<Integer> getUsersMarks() {
        return usersMarks;
    }

    public void appendMark(int mark) {
        usersMarks.add(mark);
        sellCount++;
        updateRating();
    }

    public void updateRating() {
        commonRating =
                IntStream.of(usersMarks.stream().mapToInt(Integer::intValue).toArray()).sum()
                        / (double) usersMarks.size();
    }

    public double getCommonRating() {
        return commonRating;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public String toString() {
        return String.format("%s    cost: %d\nrating: %f    available: %d",
                description, cost, commonRating, availableCount);
    }

    public int getSellCount() {
        return sellCount;
    }

    public void updateBySell(int value) {
        availableCount -= value;
        sellCount += value;
    }
}
