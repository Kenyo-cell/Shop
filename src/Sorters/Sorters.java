package Sorters;

import Filters.Filters;

public enum Sorters {
    COST, RATING, SELL, NONE;

    public static Sorters identify(String input) {
        try {
            int num = Integer.parseInt(input);
            return Sorters.values()[num - 1];
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("We can't identify your input so, we shouldn't filter products");
        return Sorters.NONE;
    }
}
