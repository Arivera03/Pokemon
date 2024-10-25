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
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;

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

        adapter = new adaptador(getContext(),R.layout.fragment_listapag1_pokemon,pokes);

        binding.pokemonListView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int id = 1;
        int ultimaid = 151;
        llamarPokes(id, ultimaid);
    }

    private void llamarPokes(int id, int uid) {
        if (id > uid){
            Toast.makeText(getContext(),"Todos los pokemons han sido listaos de puta madre", Toast.LENGTH_SHORT).show();
        } else {
            MetodosPokes metodosPokes = new MetodosPokes();

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                metodosPokes.getPokemon((id), pokemon -> {
                    if (pokemon != null) {
                        getActivity().runOnUiThread(() -> {
                            pokes.add(pokemon);
                            adapter.notifyDataSetChanged();
                            llamarPokes(id + 1, uid);
                        });
                    } else {
                        getActivity().runOnUiThread(() ->
                                Toast.makeText(getContext(), "Error al cargar el Pokémon con ID " + id, Toast.LENGTH_SHORT).show()
                        );
                    }
                });
            });
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}