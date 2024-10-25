package com.example.pokemon;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class adaptador extends ArrayAdapter<Pokemon> {
    public adaptador(Context context, int resource, List<Pokemon> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon pokemon = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_listapag1_pokemon, parent, false);
        }

        TextView nombrepoke = convertView.findViewById(R.id.pokemonNombre);
        ImageView spritepoke = convertView.findViewById(R.id.pokemonSprite);

        nombrepoke.setText(pokemon.getName());
        String spriteUrl = pokemon.getSprite().getFrontDefault();
        Glide.with(getContext()).load(spriteUrl).into(spritepoke);

        return convertView;
    }
}
