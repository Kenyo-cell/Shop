package Products;


public enum Type {
    TOP,
    PANTS,
    TECH,
    BOOTS,
    ACCESSORIES;

    public static Type identify(String input) {
        try {
            int num = Integer.parseInt(input);
            return Type.values()[num - 1];
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("We can't identify your input so, we should choose Ttch");
        return Type.TECH;
    }
}
