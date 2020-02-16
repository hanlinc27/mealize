import java.util.ArrayList;

class RecipeItem implements Comparable {
    String name;
    ArrayList<String> allIngredients;
    ArrayList<String> keyIngredients;
    ArrayList<GroceryItem> saleItems;
    int score;

    RecipeItem(String s) {
        name = s;
        score = 0;
        allIngredients = new ArrayList<>();
        keyIngredients = new ArrayList<>();
        saleItems = new ArrayList<>();
    }

    @Override
    public int compareTo(Object o) {
        return this.score - ((RecipeItem) o).score;
    }
}