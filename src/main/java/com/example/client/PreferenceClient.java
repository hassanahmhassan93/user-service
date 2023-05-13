package com.example.client;

import com.example.client.responsemodel.PreferenceResModel;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.Optional;

@Client("http://localhost:8081/api/preferences")
public interface PreferenceClient {

    @Get("/{userId}")
    Optional<PreferenceResModel> getUserPreference(Integer userId);
}
