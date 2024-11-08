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

        binding.detNombrePokemon.setText(pokemon.getName());
        binding.detIdPokemon.setText("#" + pokemon.getId());
        binding.detPesoPokemon.setText("Peso: " + pokemon.getWeight() / 10);
        String spriteUrl = pokemon.getSprite().getFrontDefault();
        Glide.with(getContext()).load(spriteUrl).into(binding.detSpritePokemon);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}