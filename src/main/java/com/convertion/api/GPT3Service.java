package com.convertion.api;

import java.io.IOException;
import okhttp3.*;

public class GPT3Service {

    private static final String API_KEY = "";

    public static String getGptResponse(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 100}");
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/gpt-3.5-turbo/completions")
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
