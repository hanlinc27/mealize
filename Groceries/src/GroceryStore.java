import java.util.ArrayList;

class GroceryStore {
    private static final int INIT_SIZE = 25;
    String name;
    long id;
    String imageURL;
    ArrayList<GroceryItem> items;
    GroceryStore(String name, long id, String imageURL) {
        this.name = name;
        this.id = id;
        this.imageURL = imageURL;
        items = new ArrayList<>(INIT_SIZE);
    }
}