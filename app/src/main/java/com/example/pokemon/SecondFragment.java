package com.example.pokemon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.pokemon.databinding.FragmentSecondBinding;

import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null) {
            Pokemon pokemon = (Pokemon) args.getSerializable("item");

            if (pokemon != null) {
                updateUi(pokemon);
            }
        }
    }

    private void updateUi(Pokemon pokemon) {
        Log.d("infopokes", pokemon.toString());

        binding.detNombrePokemon.setText(pokemon.getName().toUpperCase());
        binding.detIdPokemon.setText("#" + pokemon.getId());
        binding.detPesoPokemon.setText("Peso: " + pokemon.getWeight() / 10);
        String spriteUrl = pokemon.getSprite().getFrontDefault();
        Glide.with(getContext()).load(spriteUrl).into(binding.detSpritePokemon);
        List<Type> tipos = pokemon.getTypes();
        String texto = "";
        for (Type tipo : tipos){
            if (tipo.getDetalletipo() != null && tipo.getDetalletipo().getName() != null) {
                String nombre = tipo.getDetalletipo().getName();
                switch (nombre){
                    case "grass":
                        nombre = "Planta";
                        break;
                    case "poison":
                        nombre = "Veneno";
                        break;
                    case "water":
                        nombre = "Agua";
                        break;
                    case "ground":
                        nombre = "Tierra";
                        break;
                    case "fire":
                        nombre = "Fuego";
                        break;
                    case "ice":
                        nombre = "Hielo";
                        break;
                    case "flying":
                        nombre = "Volador";
                        break;
                    case "electric":
                        nombre = "Eléctrico";
                        break;
                    case "dark":
                        nombre = "Siniestro";
                        break;
                    case "fairy":
                        nombre = "Hada";
                        break;
                    case "normal":
                        nombre = "Normal";
                        break;
                    case "fighting":
                        nombre = "Lucha";
                        break;
                    case "dragon":
                        nombre = "Dragón";
                        break;
                    case "bug":
                        nombre = "Bicho";
                        break;
                    case "psychic":
                        nombre = "Psíquico";
                        break;
                    case "steel":
                        nombre = "Acero";
                        break;
                }
                if (!texto.isEmpty()) {
                    texto += ", ";
                }
                texto += nombre;
            }
        }
        binding.detTipoPokemon.setText(texto);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}