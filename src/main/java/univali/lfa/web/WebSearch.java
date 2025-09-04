package univali.lfa.web;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Fetches the raw text content of multiple URLs.
 * @author Santiago
 * @author Caio Rosa
 */
public class WebSearch {
    @Getter
    private final List<String> resourceUrls = new ArrayList<>();

    /**
     * Adds a URL to the download queue.
     */
    public void addResourceUrl(String url) {
        resourceUrls.add(url);
    }

    /**
     * Downloads each queued URL and returns their contents.
     *
     * @return list of page contents in the same order as {@link #resourceUrls}
     * @throws IOException if any connection or read fails
     */
    public List<String> fetchResources() throws IOException {
        List<String> result = new ArrayList<>();
        for (String urlString : resourceUrls) {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(10000);

            try (BufferedReader in =
                         new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line).append('\n');
                }
                result.add(sb.toString());
            }
        }
        return result;
    }
}