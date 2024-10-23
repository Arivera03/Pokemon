package com.example.pokemon;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pokemon.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Pokemon> pokes = new ArrayList<>();
    private ArrayAdapter<Pokemon> adapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        pokes = new ArrayList<>();

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, pokes);

        binding.pokemonListView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int id = 1;
        fetchPokemon(id);
        id++;
    }

    private void fetchPokemon(int id) {
        MetodosPokes metodosPokes = new MetodosPokes();

        metodosPokes.getPokemon(id, pokemon -> {
            if (pokemon != null) {
                getActivity().runOnUiThread(() -> {
                    pokes.add(pokemon);
                    Toast.makeText(getContext(), "furula", Toast.LENGTH_SHORT).show();

                });
            } else {
                getActivity().runOnUiThread(() ->
                        Toast.makeText(getContext(), "No furula", Toast.LENGTH_SHORT).show()
                );
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
