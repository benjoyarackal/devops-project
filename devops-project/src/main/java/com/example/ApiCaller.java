package com.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiCaller {

    private final OkHttpClient client = new OkHttpClient();

    public String fetchJoke() throws Exception {
        Request request = new Request.Builder()
                .url("https://api.chucknorris.io/jokes/random")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                return "Request failed: " + response.code();
            }
        }
    }

    public static void main(String[] args) {
        ApiCaller caller = new ApiCaller();
        try {
            System.out.println(caller.fetchJoke());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}