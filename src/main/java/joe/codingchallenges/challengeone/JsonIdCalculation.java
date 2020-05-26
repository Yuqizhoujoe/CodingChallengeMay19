package joe.codingchallenges.challengeone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Set;


public class JsonIdCalculation {

    /*
    * * CHALLENGE DESCRIPTION:
     * You have JSON string which describes a menu. Calculate the SUM of IDs of all “items” in the case a “label”
     * exists for an item.
     *
     * INPUT SAMPLE:
     * Your program should accept as its first argument a path to a filename. Input example is the following
     * {“menu”: {“header”: “menu”, “items”: [{“id”: 27}, {“id”: 0, “label”: “Label 0"}, null, {“id”: 93}, {“id”: 85}, {“id”: 54}, null, {“id”: 46, “label”: “Label 46"}]}}
     * {“menu”: {“header”: “menu”, “items”: [{“id”: 81}]}}
     * {“menu”: {“header”: “menu”, “items”: [{“id”: 70, “label”: “Label 70"}, {“id”: 85, “label”: “Label 85”}, {“id”: 93, “label”: “Label 93"}, {“id”: 2}]}}
     * All IDs are integers between 0 and 100. It can be 10 items maximum for a menu.
     *
     * OUTPUT SAMPLE:
     * Print results in the following way.
     * 46
     * 0
     * 248
     */

    public static void main(String[] args) throws IOException {

        JSONArray jsonArray = readJson();
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(getItemsArray(jsonObject));
        }

    }


    public static JSONArray readJson() throws IOException {
        // JSON Parser Object
        JSONParser jsonParser = new JSONParser();
        // File Reader
        FileReader fileReader = null;
        // JSON Array
        JSONArray jsonArray = null;

        try {
            fileReader = new FileReader("src\\main\\resources\\chanllengeone.json");
            Object obj = jsonParser.parse(fileReader);
            jsonArray = (JSONArray) obj;
            for (Object jsonObject : jsonArray) {

            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (jsonArray != null) {
                fileReader.close();
            }
        }

        return jsonArray;
    }

    public static int getItemsArray(JSONObject jsonObject) throws IOException {
        JSONObject menu = (JSONObject) jsonObject.get("menu");
        JSONArray items = (JSONArray) menu.get("items");
        LinkedList<String> list = new LinkedList<String>();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null) {
                JSONObject obj = (JSONObject) items.get(i);
                if (obj.containsKey("label")) {
                    list.addLast(String.valueOf(obj.get("id")));
                }
            }
        }
        int count = 0;
        for (String item : list) {
            count += Integer.parseInt(item);
        }
        return count;
    }

}
