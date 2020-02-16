import java.lang.Object;
import java.net.*;
import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class GroceryFetcher {
    private final static String BASE_URL = "https://backflipp.wishabi.com/flipp";
    private final static String FLYER_URL = "/flyers?locale=en-ca&postal_code=";
    private final static int NUM_STORES = 5;
    public static void main(String[] args) throws IOException, ParseException {
        getGroceryInfo("M2J3Z5");
    }
    private static boolean getGroceryInfo(String postalCode) throws IOException, ParseException {
        // validate postal code?
        URL flyerURL = new URL(BASE_URL + FLYER_URL + postalCode);
        HttpURLConnection connection = (HttpURLConnection) flyerURL.openConnection();
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
        for (int i = 0; i < flyerList.size() && storeList.size() < 5; i++) {
            JSONObject jFlyer = (JSONObject) flyerList.get(i);
            JSONArray categories = (JSONArray) jFlyer.get("categories");
            if (categories.contains("Groceries")) {
                System.out.printf("%s%d%s", (String) jFlyer.get("merchant"), (long) jFlyer.get("merchant_id"), (String) jFlyer.get("merchant_logo"));
                storeList.add(new GroceryStore((String) jFlyer.get("merchant"), (long) jFlyer.get("merchant_id"), (String) jFlyer.get("merchant_logo")));
            }
        }


        in.close();
        return true;
    }
}
