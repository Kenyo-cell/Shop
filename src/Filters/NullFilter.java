package Filters;

import Products.Product;

import java.util.List;

public class NullFilter implements Filter {
    @Override
    public List<Product> filter(List<Product> products) {
        return products;
    }
}
