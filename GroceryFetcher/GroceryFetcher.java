import java.lang.Object;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.lang.model.type.ArrayType;

public class GroceryFetcher {
    private final static int NUM_STORES = 15;

    private final static String BASE_URL = "https://backflipp.wishabi.com/flipp";
    private final static String FLYER_URL = "/flyers?locale=en-ca&postal_code=";
    private final static String ITEM_URL = "/items/search?locale=en-ca&postal_code=";
    private final static String QUERY_URL = "&q=";
    private final static String DEFAULT_PC = "M1C3T7";

    public static void main(String[] args) throws IOException, ParseException {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter postal code");
//            String postal_code = sc.nextLine();
//            postal_code = getValidPostalCode(postal_code);
//            getGroceryInfo(postal_code);
//        }
        ArrayList<RecipeItem> test = Recipe.getRecipes(getGroceryInfo("M2J3Z5"), new ArrayList<>());
        for(RecipeItem i : test) {
            System.out.print(i.name + ": [");
            for (String s : i.keyIngredients) {
                System.out.print(s + ", ");
            }
            System.out.print("] [");
            for (GroceryItem g : i.saleItems) {
                System.out.print(g.name + ", ");
            }
            System.out.print("]");
            System.out.println(i.score);
        }
//        ArrayList<GroceryItem> list = getGroceryInfo("M2J3Z5");
//        for (GroceryItem g : list) {
//            System.out.println(g.name);
//        }
    }
    private static String getValidPostalCode(String postalCode) {
        if (!isPostalCodeValid(postalCode)) {
            postalCode = postalCode.replaceAll(" ", "");
            if (!isPostalCodeValid(postalCode)) {
                postalCode = DEFAULT_PC;
            }
        }
        return postalCode;
    }
    private static boolean isPostalCodeValid(String postalCode) {
        boolean result = true;
        if (postalCode.length() != 6) {
            result = false;
        } else {
            for (int i = 0; i <= 4 && result; i += 2) {
                char ch = postalCode.charAt(i);
                if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z'))
                    result = false;
            }
            for (int i = 1; i <= 5; i += 2) {
                char ch = postalCode.charAt(i);
                if (ch < '0' || ch > '9')
                    result = false;
            }
        }
        return result;
    }
    private static ArrayList<GroceryItem> getGroceryInfo(String postalCode) throws IOException, ParseException {
        // validate postal code?
        URL url = new URL(BASE_URL + FLYER_URL + postalCode);
        System.out.println("... fetching data from " + BASE_URL + FLYER_URL + postalCode);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder result = new StringBuilder();
        String toAppend;
        while ((toAppend = in.readLine()) != null) {
            result.append(toAppend).append("\n");
        }
        JSONParser parser = new JSONParser();
        JSONObject flyerJSON = (JSONObject) (parser.parse(String.valueOf(result)));
        JSONArray flyerList = (JSONArray) (flyerJSON.get("flyers"));
        ArrayList<GroceryStore> storeList = new ArrayList<>(NUM_STORES);
        for (int i = 0; i < flyerList.size() && storeList.size() < NUM_STORES; i++) {
            JSONObject jFlyer = (JSONObject) flyerList.get(i);
            JSONArray categories = (JSONArray) jFlyer.get("categories");
            long merchant_id = (long) jFlyer.get("merchant_id");
            boolean alreadyIncluded = false;
            for (int j = 0; j < storeList.size() && !alreadyIncluded; j++) {
                if (storeList.get(j).id == merchant_id)
                    alreadyIncluded = true;
            }
            if (!alreadyIncluded && categories.contains("Groceries")) {
                System.out.printf("%d: %s %s\n", storeList.size(), jFlyer.get("merchant"), jFlyer.get("merchant_logo"));
                storeList.add(new GroceryStore((String) jFlyer.get("merchant"), (long) jFlyer.get("merchant_id"), (String) jFlyer.get("merchant_logo")));
            }
        }
        System.out.println("Enter the index of the flyer you want to return items for.");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        GroceryStore selectedStore = storeList.get(index);
        String selectedName = selectedStore.name;
        selectedName = selectedName.replaceAll(" ", "%20");
        url = new URL(BASE_URL + ITEM_URL + postalCode + QUERY_URL + selectedName);
        System.out.println("... fetching data from " + BASE_URL + ITEM_URL + postalCode + QUERY_URL + selectedName);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        result = new StringBuilder();
        while ((toAppend = in.readLine()) != null) {
            result.append(toAppend).append("\n");
        }
        JSONObject itemsJSON = (JSONObject) (parser.parse(String.valueOf(result)));
        JSONArray itemsList = (JSONArray) (itemsJSON.get("items"));
        for (Object item : itemsList) {
            JSONObject jItem = (JSONObject) item;
            if (jItem.get("current_price") != null) {
                selectedStore.items.add(new GroceryItem((String) jItem.get("name"), (int) ((double) jItem.get("current_price") * 100), (String) jItem.get("clean_image_url")));
                System.out.format("%s %d %s\n", (String) jItem.get("name"), (int) ((double) jItem.get("current_price") * 100), (String) jItem.get("clean_image_url"));
            }
        }
        in.close();

        return selectedStore.items;
    }
}

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