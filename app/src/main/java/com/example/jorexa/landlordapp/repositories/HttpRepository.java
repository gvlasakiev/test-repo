package com.example.jorexa.landlordapp.repositories;

import com.example.jorexa.landlordapp.http.HttpRequester;
import com.example.jorexa.landlordapp.parsers.base.JsonParser;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;

public class HttpRepository<T> implements Repository<T> {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;

    public HttpRepository(
            String serverUrl,
            HttpRequester httpRequester,
            JsonParser<T> jsonParser
    ) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public T login(T item) throws IOException {
        return null;
    }
}
