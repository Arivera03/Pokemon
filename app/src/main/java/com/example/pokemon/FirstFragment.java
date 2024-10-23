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

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, pokes);

        binding.pokemonListView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int id = 1;
        llamarPokes(id);
        id++;
    }

    private void llamarPokes(int id) {
        MetodosPokes metodosPokes = new MetodosPokes();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            InterfazApi api = new InterfazApi() {
                @Override
                public Call<Pokemon> getPokemon(int id) {
                    return null;
                }
            };
            String result = api.getPokemon(1);

            handler.post(() -> {
                // Aquest codi s'executa en primer pla.
                adapter.clear();
                for (Movie peli : movies) {
                    adapter.add(peli);
                }
            });
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
