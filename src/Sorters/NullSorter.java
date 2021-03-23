package Sorters;

import Products.Product;

import java.util.List;

public class NullSorter implements Sorter {
    @Override
    public List<Product> sort(List<Product> products) {
        return products;
    }
}
