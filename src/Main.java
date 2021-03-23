import java.util.Scanner;

public class Main {
    private enum Operations {
        BROWSE, FILTER, SORT, REFRESH, BASKET, BUY, END;

        public static Operations identify(String input) {
            try {
                int num = Integer.parseInt(input);
                return Operations.values()[num - 1];
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("We can't identify your input so, we should show you your basket");
            return Operations.BASKET;
        }
    }

    private static final String iterMessage = "Choose option:\n" +
            "1. Browse products\n2. Setup filter options\n3. Setup sorting options\n" +
            "4. Refresh filters\n5. Print my basket\n6. Buy\n7. End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, dear customer, please have enjoy to use our digital/virtual shop");
        String userInput = "";
        boolean end = false;
        ShopFacade shop = new ShopFacade();

        while (!end) {
            System.out.println(iterMessage);
            userInput = scanner.nextLine();

            switch (Operations.identify(userInput)) {
                case BROWSE -> shop.browseProducts();
                case FILTER -> shop.filterProducts();
                case SORT -> shop.sortProducts();
                case REFRESH -> shop.refresh();
                case BASKET -> shop.printBasket();
                case BUY -> shop.buy();
                case END -> end = true;
            }
        }

        System.out.println("Thank you for using our service!");
    }
}
