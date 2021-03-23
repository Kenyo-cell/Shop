package Filters;

import Products.Product;

import java.util.List;
import java.util.stream.Collectors;

public class RatingFilter implements Filter {
    private int rating = 0;

    public RatingFilter(int rating) {
        this.rating = rating;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream().filter(x -> x.getCommonRating() >= rating).collect(Collectors.toList());
    }
}
