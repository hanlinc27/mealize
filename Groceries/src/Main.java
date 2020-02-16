import java.io.FileReader;
import java.rmi.server.ExportException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Main {
    public static void main(String[] args) throws Exception {
        JSONObject testJO = (JSONObject) (new JSONParser().parse(new FileReader("Ingredients/m2m2x7_flyers.json")));
        JSONArray flyerList = (JSONArray) (testJO.get("flyers"));
        for (Object flyer : flyerList) {
            JSONObject jFlyer = (JSONObject) flyer;
            JSONArray categories = (JSONArray) jFlyer.get("categories");
            if (categories.contains("Groceries")) {
                System.out.println((jFlyer).get("merchant"));
            }
        }



//        Map address = ((Map)jo.get("address"));
//
//        // iterating address Map
//        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
//        while (itr1.hasNext()) {
//            Map.Entry pair = itr1.next();
//            System.out.println(pair.getKey() + " : " + pair.getValue());
//        }
//
//        // getting phoneNumbers
//        JSONArray ja = (JSONArray) jo.get("phoneNumbers");
//
//        // iterating phoneNumbers
//        Iterator itr2 = ja.iterator();
//
//        while (itr2.hasNext())
//        {
//            itr1 = ((Map) itr2.next()).entrySet().iterator();
//            while (itr1.hasNext()) {
//                Map.Entry pair = itr1.next();
//                System.out.println(pair.getKey() + " : " + pair.getValue());
//            }
//        }
    }
}
