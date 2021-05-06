package ee.bcs.valiit.booksearch.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebReader {
    public static String readWeb(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder contents = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while((line =  reader.readLine()) != null)  {
                contents.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents.toString();
    }

}
