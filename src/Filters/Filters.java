package Filters;

public enum Filters{
    COST, RATING, TYPE, NONE;

    public static Filters identify(String input) {
        try {
            int num = Integer.parseInt(input);
            return Filters.values()[num - 1];
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("We can't identify your input so, we shouldn't filter products");
        return Filters.NONE;
    }
}
