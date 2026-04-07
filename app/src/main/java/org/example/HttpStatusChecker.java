package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {
            return url;
        } else {
            throw new Exception("No image for status code: " + code);
        }
    }
}
