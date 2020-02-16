import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;

class Recipe {
    public static ArrayList<RecipeItem> getRecipes(ArrayList<GroceryItem> items, ArrayList<String> itemsAlreadyHas) {
        ArrayList<RecipeItem> recipes = new ArrayList<>();
        ArrayList<String> commonIngredients = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("commonIngredients.txt")));
            String in;
            while ((in = br.readLine()) != null) {
                commonIngredients.add(in);
            }
            /**replace grocery sale items with common names**/
            for (GroceryItem i : items) {
                for (String s : commonIngredients) {
                    if (i.name.toLowerCase().contains(s)) {
                        i.name = s;
                    }
                }
            }
            /**index the recipes form JSON file**/
            String raw = new String((Files.readAllBytes(Paths.get("recipes_raw.json"))));
            JSONObject jo = new JSONObject(raw);
            JSONArray id = jo.names();
            for (int i = 0; i < id.length(); ++i) {
                JSONObject cur = (JSONObject) jo.get((String) id.get(i));
                try {
                    JSONArray ingredientsList = (JSONArray) cur.get("ingredients");
                    recipes.add(new RecipeItem(cur.getString("title"), cur.getString("instructions")));
                    for (int j = 0; j < ingredientsList.length(); ++j) {
                        recipes.get(i).allIngredients.add((String) ingredientsList.get(j));
                        for (String s : commonIngredients) {
                            if (((String) ingredientsList.get(j)).contains(s)) {
                                recipes.get(i).keyIngredients.add(s);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**score each recipe item**/
        ArrayList<RecipeItem> ret = new ArrayList<>();
        for (int i1 = 0; i1 < recipes.size(); i1++) {
            RecipeItem r = recipes.get(i1);
            for (GroceryItem g : items) {
                for (String s : r.keyIngredients) {
                    if (s.contains(g.name.toLowerCase())) {
                        r.score += 1;
                        r.saleItems.add(g); //store the item thats on sale
                    }
                }
            }
            for (String i : itemsAlreadyHas) {
                for (String s : r.allIngredients) {
                    if (s.contains(i)) {
                        r.score = 9999; //high score for items that user already has
                    }
                }
            }
        }
        Collections.sort(recipes);
        for(int i = 0; i < 25; ++i) {
            ret.add(recipes.get(i));
        }
        Collections.sort(ret);
        return ret;
    }
}