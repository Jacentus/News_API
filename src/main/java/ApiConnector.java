import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ApiConnector {

    private final String key = "VALID API KEY";
    private final String address = "https://newsapi.org/v2/top-headlines";
    private final String country = "pl";
    private final String category = "business";

    public ApiConnector() {
    }

    public ArrayList<Article> getArticles() {

        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(this.address + "?" + "country=" + country + "&" + "category=" + category + "&" + "apiKey=" + key)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        JSONObject responseObject = response.getBody().getObject();
        JSONArray jsonArray = responseObject.getJSONArray("articles");
        String stringArray = jsonArray.toString();
        Type userListType = new TypeToken<ArrayList<Article>>(){}.getType();
        ArrayList<Article> articleArray = gson.fromJson(stringArray, userListType);

        return articleArray;
    }

    /////////////////////////////// auto generated getters ////////////////////////////////////////////

    public String getKey() {
        return key;
    }

    public String getAddress() {
        return address;
    }

}
