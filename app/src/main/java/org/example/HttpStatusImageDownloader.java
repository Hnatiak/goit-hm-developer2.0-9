package org.example;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws Exception {
        Path folder = Path.of("photos");

        if (!Files.exists(folder)) {
            Files.createDirectory(folder);
        }

        Path filePath = folder.resolve(code + ".jpg");

        if (Files.exists(filePath)) {
            System.out.println("You already have this status image");
            return;
        }

        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        try (InputStream in = new URL(imageUrl).openStream()) {
            Files.copy(in, filePath);
        }

        System.out.println("Image downloaded successfully");
    }
}