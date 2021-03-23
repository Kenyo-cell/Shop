package Filters;

import Products.Product;

import java.util.List;

@FunctionalInterface
public interface Filter {
    List<Product> filter(List<Product> products);
}
