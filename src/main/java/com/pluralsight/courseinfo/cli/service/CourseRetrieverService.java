package com.pluralsight.courseinfo.cli.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CourseRetrieverService {
    private static final String PS_URI = "https://app.pluralsight.com/profile/data/author/%s/all-content";
    private static final HttpClient CLIENT = HttpClient
            .newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    public String getCoursesFor(String authorId) {
//        fall back URL
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(PS_URI.formatted(authorId)))
                .GET()
                .build();
        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return switch(response.statusCode()) {
                case 200 -> response.body();
                case 404 -> "";
                default -> throw new RuntimeException("plural sight api call failed with this status" + response.statusCode());
            };
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Could not call Pluralsight api", e);
        }

    }
}
