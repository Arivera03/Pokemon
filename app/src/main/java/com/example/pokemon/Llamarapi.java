package com.example.pokemon;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Llamarapi {
    final String URL_BASE = "https://pokeapi.co/api/v2/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    InterfazApi pokemonAPI = retrofit.create(InterfazApi.class);
}
