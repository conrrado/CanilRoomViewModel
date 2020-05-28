package com.ccamacho.canilroomviewmodel.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ccamacho.canilroomviewmodel.databinding.FragmentCanilDetailBinding;
import com.ccamacho.canilroomviewmodel.model.Dog;
import com.ccamacho.canilroomviewmodel.model.DogDetail;
import com.ccamacho.canilroomviewmodel.retrofit.RetrofitConfig;
import com.ccamacho.canilroomviewmodel.viewmodel.CanilDetailViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanilDetailFragment extends Fragment {

    private FragmentCanilDetailBinding binding;
    private CanilDetailViewModel viewModel;
    private RetrofitConfig config;
    private Call<List<DogDetail>> request;

    public CanilDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCanilDetailBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CanilDetailViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getDogDetail().observe(getViewLifecycleOwner(), detail -> {
            Dog dog = detail.getDogList().get(0);

            binding.textViewBreed.setText(dog.getName());
            binding.textViewId.setText(String.valueOf(dog.getId()));
            binding.textViewWeight.setText(dog.getWeight().getMetric());
            binding.textViewHeight.setText(dog.getHeight().getMetric());
            binding.textViewBredFor.setText(dog.getBreadFor());
            binding.textViewLifeSpan.setText(dog.getLifeSpan());
            binding.textViewTemperament.setText(dog.getTemperament());

            Glide.with(this).load(detail.getUrl()).into(binding.imageView);
        });
        viewModel.isLoading().observe(getViewLifecycleOwner(), loading -> {
            binding.progressBar.setVisibility(View.GONE);
            if (loading) {
                binding.progressBar.setVisibility(View.VISIBLE);
            }
        });

        config = new RetrofitConfig();

        if (getArguments() != null) {
            int id = CanilDetailFragmentArgs.fromBundle(getArguments()).getId();
            getData(id);
        }
    }

    private void getData(int id) {
        request = config.getCanilAPI().getDogByBreedId(id);
        request.enqueue(new Callback<List<DogDetail>>() {
            @Override
            public void onResponse(Call<List<DogDetail>> call, Response<List<DogDetail>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    viewModel.updateDogDetail(response.body().get(0));
                }
                hideLoading();
            }

            @Override
            public void onFailure(Call<List<DogDetail>> call, Throwable t) {
                Toast.makeText(getContext(), "Erro ao obter os dados", Toast.LENGTH_SHORT).show();
                hideLoading();
            }
        });
    }

    private void hideLoading() {
        viewModel.updateLoading(false);
    }
}
