import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ApiConnector connector = new ApiConnector();

        ArrayList<Article> articles = connector.getArticles();

        ArticleWriter articleWriter = new ArticleWriter();

        articleWriter.writeToFile(articles);

    }

}
