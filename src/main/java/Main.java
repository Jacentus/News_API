import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ApiConnector connector = new ApiConnector();

        ArrayList<Article> articles = connector.getArticles();

        ArticleWriter articleWriter = new ArticleWriter();

        articleWriter.writeToFile(articles);

    }

}
