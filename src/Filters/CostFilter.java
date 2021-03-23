package Filters;

import Products.Product;

import java.util.List;
import java.util.stream.Collectors;

public class CostFilter implements Filter {
    private int min = 0;
    private int max = 10_000;

    public CostFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream().filter(x -> x.getCost() > min && x.getCost() <= max).collect(Collectors.toList());
    }
}
