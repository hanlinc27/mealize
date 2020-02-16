import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Recipes {

    class GroceryItem {
        String name;
        int price;
        String imageURL;
        GroceryItem(String name, int price, String imageURL) {
            this.name = name;
            this.price = price;
            this.imageURL = imageURL;
        }
    }
    static class RecipeItem {
        ArrayList <String> ingredients;
        ArrayList <GroceryItem> saleItems;
        RecipeItem() {
            ingredients = new ArrayList<>();
            saleItems = new ArrayList<>();
        }

    }

    public static void getRecipes(ArrayList<GroceryItem> items) {
        ArrayList<RecipeItem> recipes = new ArrayList<>();
        ArrayList<String>commonIngredients = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("commonIngredients.txt")));
            String in;
            while((in = br.readLine()) != null) {
                commonIngredients.add(in);
            }
            String raw = new String((Files.readAllBytes(Paths.get("recipes_raw.json"))));
            JSONObject jo = new JSONObject(raw);
            JSONArray id = jo.names();
            for(int i = 0; i < id.length(); ++i) {
                JSONObject cur = (JSONObject) jo.get((String)id.get(i));
                try {
                    JSONArray ingredientsList = (JSONArray) cur.get("ingredients");
                    recipes.add(new RecipeItem());
                    for(int j = 0; j < ingredientsList.length(); ++j) {
                        int cnt = 0;
                        recipes.get(i).ingredients.add((String)ingredientsList.get(j));
                        for(int k = 0; k < commonIngredients.size(); ++k) {
                            if(recipes.get(i).ingredients.get(j).contains(commonIngredients.get(k))) {
                                System.out.println(commonIngredients.get(k) + " " + cnt);
                                ++cnt;
                            }
                        }
                    }
                } catch(Exception e) {
                }
            }
            System.out.println(recipes.size());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        getRecipes(new ArrayList<>());

    }
}
