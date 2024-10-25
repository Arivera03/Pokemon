package com.example.pokemon;

import android.util.Log;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MetodosPokes{
    public void getPokemon(int id, Consumer<Pokemon> callback) {
        Llamarapi api = new Llamarapi();
        Call<Pokemon> call = api.pokemonAPI.getPokemon(id);

        call.enqueue(new Callback <Pokemon> () {
            @Override
            public void onResponse(Call <Pokemon> call, Response <Pokemon> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Pokemon pokemon = response.body();
                    callback.accept(pokemon);
                } else {
                    Log.e("error", "Esto no va chaval");
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call <Pokemon> call, Throwable t) {
                Log.d("error","no va");
            }
        });
    }
}
