package Sorters;

import Products.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SellCountSorter implements Sorter{
    private boolean natural = true;

    public SellCountSorter() {}
    public SellCountSorter(boolean isNaturalOrder) {
        natural = isNaturalOrder;
    }

    @Override
    public List<Product> sort(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getSellCount,
                natural ? Comparator.naturalOrder() : Comparator.reverseOrder())).collect(Collectors.toList());
    }
}
