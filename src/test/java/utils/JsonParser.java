package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser
{
    public static JSONObject getJsonData(String userType)
    {
        JSONParser jsonParser = new JSONParser();
        JSONObject user;
        int userIndex;

        switch (userType.toLowerCase()) {
            case "agronomist": userIndex = 0; break;
            case "sr tara hendricks": userIndex = 1; break;
            case "seller": userIndex = 2; break;
            case "seller 2": userIndex = 3; break;
            case "grower": userIndex = 4; break;
            case "grower 2": userIndex = 5; break;
            case "grower 3": userIndex = 6; break;
            case "grower+104": userIndex = 7; break;
            case "grower 5": userIndex = 8; break;
            case "grower molly": userIndex = 9; break;
            case "fsm": userIndex = 10; break;
            case "dm": userIndex = 11; break;
            case "sales rep kurt": userIndex = 12; break;
            case "invalid user": userIndex = 13; break;
            default: userIndex = -14; break;
        }

        Object obj;
        try {
            obj = jsonParser.parse(new FileReader("src/test/resources/users.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray users = (JSONArray) jsonObject.get("user");
        user = (JSONObject) users.get(userIndex);

        return user;
    }

    public static String getNestedData(String userType, String growerName)
    {
        String user = "";
        int growerIndex = -1;

        switch (userType) {
            case "Sales Rep": user = "sellers"; break;
            case "Seller":
            case "Agronomist":
                user = "growers"; break;
        }

        JSONArray jsonArray = (JSONArray) JsonParser.getJsonData(userType).get(user);
        JSONObject sellerList = (JSONObject) jsonArray.get(0);

        if(userType.equals("Seller"))
        {
            for (int i = 0; i <= jsonArray.size(); i++)
            {
                JSONObject growerNameList = (JSONObject) jsonArray.get(i);

                if(growerNameList.get("name").toString().contains(growerName))
                {
                    growerIndex = i;
                    break;
                }
            }

            sellerList = (JSONObject) jsonArray.get(growerIndex);
        }

        return sellerList.get("name").toString();
    }
}