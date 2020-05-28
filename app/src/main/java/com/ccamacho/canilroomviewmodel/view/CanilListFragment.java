package com.ccamacho.canilroomviewmodel.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ccamacho.canilroomviewmodel.R;
import com.ccamacho.canilroomviewmodel.adapters.CanilListAdapter;
import com.ccamacho.canilroomviewmodel.databinding.FragmentCanilListBinding;
import com.ccamacho.canilroomviewmodel.model.Dog;
import com.ccamacho.canilroomviewmodel.retrofit.RetrofitConfig;
import com.ccamacho.canilroomviewmodel.viewmodel.CanilListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanilListFragment extends Fragment {

    private FragmentCanilListBinding binding;
    private CanilListViewModel viewModel;
    private CanilListAdapter adapter;
    private List<Dog> dogList;
    private RetrofitConfig config;
    private Call<List<Dog>> request;

    public CanilListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCanilListBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CanilListViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getDogList().observe(getViewLifecycleOwner(), list -> {
            dogList.addAll(list);
            adapter.notifyDataSetChanged();
        });
        viewModel.isLoading().observe(getViewLifecycleOwner(), loading -> {
            binding.progressBar.setVisibility(View.GONE);
            if (loading) {
                binding.progressBar.setVisibility(View.VISIBLE);
            }
        });

        dogList = new ArrayList<>();
        config = new RetrofitConfig();

        getData();

        adapter = new CanilListAdapter(dogList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    private void getData() {
        request = config.getCanilAPI().getAll();
        request.enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    viewModel.updateDogList(response.body());
                }
                hideLoading();
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getContext(), "Erro ao obter os dados", Toast.LENGTH_SHORT).show();
                hideLoading();
            }
        });
    }

    private void hideLoading() {
        viewModel.updateLoading(false);
    }
}
