package StorageDecorators;

import Products.Product;
import Products.RandomProductsGenerator;

import java.util.List;

public class Storage {
    protected final int AT_PAGE = 10;

    // DIP - dependency inversion, my code depends of interface not of implementation
    protected List<Product> originProducts;
    protected List<Product> products;

    public Storage() {
        originProducts = new RandomProductsGenerator().generate();
        products = originProducts;
    }

    public Storage(Storage storage) {
        originProducts = storage.originProducts;
        products = originProducts;
    }

    public void reduceProduct(Product product, int value) {
        int index = originProducts.indexOf(product);
        if (originProducts.get(index).getAvailableCount() == value) {
            originProducts.remove(index);
        } else if (originProducts.get(index).getAvailableCount() < value) {
            System.out.println("You cant buy more than we have");
        }
        else {
            originProducts.get(index).updateBySell(value);
        }
    }

    public Product get(int index) {
        return products.get(index);
    }

    public int next(int start) {
        int i;
        for (i = start; i < start + AT_PAGE && i < products.size(); i++) {
            System.out.println(i + 1 + " " + products.get(i));
        }
        return i;
    }

    public int storageSize() {
        return products.size();
    }
}
