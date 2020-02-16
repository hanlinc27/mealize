import java.util.ArrayList;

class RecipeItem implements Comparable {
    String name, intructions;
    ArrayList<String> allIngredients;
    ArrayList<String> keyIngredients;
    ArrayList<GroceryItem> saleItems;
    int score;

    RecipeItem(String n, String i) {
        name = n;
        intructions = i;
        score = 0;
        allIngredients = new ArrayList<>();
        keyIngredients = new ArrayList<>();
        saleItems = new ArrayList<>();
    }

    @Override
    public int compareTo(Object o) {
        return ((RecipeItem) o).score - this.score;
    }
}