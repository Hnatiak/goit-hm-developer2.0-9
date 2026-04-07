package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        System.out.println("Enter HTTP status code:");

        String input = scanner.nextLine();

        try {
            int code = Integer.parseInt(input);
            downloader.downloadStatusImage(code);

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");

        } catch (Exception e) {
            System.out.println("There is not image for HTTP status " + input);
        }
    }
}