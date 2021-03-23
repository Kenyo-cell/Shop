import Filters.*;
import Products.Type;
import Sorters.*;
import StorageDecorators.FilteredStorage;
import StorageDecorators.SortedStorage;
import StorageDecorators.Storage;

import java.util.Scanner;

public class ShopFacade {
    private Storage originStorage;
    private Storage storage;
    private Basket basket;

    public ShopFacade() {
        originStorage = new Storage();
        storage = originStorage;
        basket = new Basket();
    }


    public void browseProducts() {
        int index = 0;
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("end")) {
            System.out.println("If you want to add product to your basket write its number");
            index = storage.next(index);

            if (storage.storageSize() == index) System.out.println("There's nothing to browse");
            System.out.println("Write end to stop browsing or nothing to continue");

            input = scanner.nextLine();
            try {
                int productNumber = Integer.parseInt(input);
                System.out.println("Enter count of products you want to buy");
                int count = scanner.nextInt();
                basket.add(storage.get(productNumber - 1), count);
            } catch (Exception e) {
            }
        }
    }

    public void filterProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filtering type:\n1. By cost\n2. By rating\n3. By type");
        String input = scanner.nextLine();
        Filter filter = new NullFilter();
        switch (Filters.identify(input)) {
            case COST -> {
                System.out.println("Enter min and max values");
                int min = scanner.nextInt();
                int max = scanner.nextInt();
                filter = new CostFilter(min, max);
            }
            case TYPE -> {
                System.out.println("Choose type\n1. Top\n2. Pants\n" +
                        "3. Tech\n4. Boots\n5. Accessories");
                filter = new TypeFilter(Type.identify(scanner.nextLine()));
            }
            case RATING -> {
                System.out.println("Enter min rating value");
                filter = new RatingFilter(scanner.nextInt());
            }
            case NONE -> filter = new NullFilter();
        }
        storage = new FilteredStorage(storage, filter);
    }

    public void sortProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sorting type:\n1. By cost\n2. By rating\n3. By selled items");
        String input = scanner.nextLine();
        System.out.println("Enter sorting order:\n1. natural\n2. reverse");
        boolean order = scanner.nextInt() == 1 ? true : false;
        Sorter sorter = new NullSorter();
        switch (Sorters.identify(input)) {
            case COST -> sorter = new CostSorter(order);
            case SELL -> sorter = new SellCountSorter(order);
            case RATING -> sorter = new RatingSorter(order);
            case NONE -> sorter = new NullSorter();
        }
        storage = new SortedStorage(storage, sorter);
    }

    public void refresh() {
        storage = new Storage(storage);
    }

    public void printBasket() {
        System.out.println(basket);
    }

    public void buy() {
        for (var el : basket.getProducts().entrySet()) {
            storage.reduceProduct(el.getKey(), el.getValue());
        }
    }
}
