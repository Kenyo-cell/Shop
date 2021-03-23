package Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomProductsGenerator {
    private Random random;
    private final int MAX_COST = 10_000;
    private final int MAX_COUNT = 100;
    private final int MAX_CUSTOMERS = 20;
    private final int MAX_MARK = 5;

    private final String[] descriptionAddedWords = {
        "Sport", "Elite", "Kids"
    };

    public List<Product> generate() {
        random = new Random();
        List<Product> generated = new ArrayList<>();
        int max = random.nextInt(MAX_COUNT);
        for (int i = 0 ; i < max; i++) {
            int typeIndex = random.nextInt(Type.values().length);
            generated.add(generateRating(
                    new Product(
                        Type.values()[typeIndex],
                        random.nextInt(MAX_COST),
                        descriptionAddedWords[random.nextInt(descriptionAddedWords.length)]
                                + " " + Type.values()[typeIndex].toString(),
                        random.nextInt(MAX_COUNT)
                ) {} )
            );
        }

        return generated;
    }

    private Product generateRating(Product product) {
        for (int i = 0; i < random.nextInt(MAX_CUSTOMERS); i++) {
            product.appendMark(random.nextInt(MAX_MARK));
        }
        return product;
    }
}
