import Products.Product;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Product, Integer> products;

    public Basket() {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void add(Product product, int value) {
        if (products.get(product) != null) {
            products.put(product, products.get(product) + value);
        } else {
            products.put(product, value);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (var el : products.entrySet()) {
            Product product = el.getKey();
            int finalCost = el.getValue() * product.getCost();
            builder.append(String.format("%s\nx%d item(s) -> final cost %d rub\n", product,
                    el.getValue(), finalCost));
        }
        return builder.toString();
    }
}
