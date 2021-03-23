package Sorters;

import Products.Product;

import java.util.List;

@FunctionalInterface
public interface Sorter {
    List<Product> sort(List<Product> products);
}
