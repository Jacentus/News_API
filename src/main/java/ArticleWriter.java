import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArticleWriter {

    public void writeToFile(ArrayList<Article> articles) {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new java.io.FileWriter("articles"));
            for (int i = 0; i < articles.size(); i++) {
                String title = articles.get(i).getTitle();
                if (title == null) {
                    title = "Brak tytułu";
                }
                String description = articles.get(i).getDescription();
                if (description == null) {
                    description = "Brak opisu";
                }
                String author = articles.get(i).getAuthor();
                if (author == null) {
                    author = "Autor nieznany";
                }
                writer.write(title + ":" + description + ":" + author + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
