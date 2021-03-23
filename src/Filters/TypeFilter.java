package Filters;

import Products.Product;
import Products.Type;

import java.util.List;
import java.util.stream.Collectors;

public class TypeFilter implements Filter {
    private Type type;

    public TypeFilter(Type type) {
        this.type = type;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream().filter(x -> x.getType() == type).collect(Collectors.toList());
    }
}
